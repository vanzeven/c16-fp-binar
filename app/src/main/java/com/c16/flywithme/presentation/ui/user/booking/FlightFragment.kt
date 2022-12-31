package com.c16.flywithme.presentation.ui.user.booking

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.c16.flywithme.data.remote.ApiConfig
import com.c16.flywithme.data.response.FlightResponse
import com.c16.flywithme.data.response.FlightsItem
import com.c16.flywithme.databinding.FragmentFlightBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FlightFragment : Fragment() {

    private var _binding: FragmentFlightBinding? = null

    private val binding get() = _binding!!

    private var from = ""
    private var to = ""
    private var departureDate = ""
    private var flightType = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFlightBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvFlight.setHasFixedSize(true)
        binding.rvFlight.layoutManager = LinearLayoutManager(requireActivity())
        if (arguments != null) {
            from = arguments?.getString(EXTRA_FROM).toString()
            to = arguments?.getString(EXTRA_TO).toString()
            departureDate = arguments?.getString(EXTRA_DEPARTURE_DATE).toString()
            findAllFlight()
        }
    }

    private fun findAllFlight() {
        val client = ApiConfig.getApiService().getAllFlights()
        client.enqueue(object : Callback<FlightResponse> {
            override fun onResponse(
                call: Call<FlightResponse>,
                response: Response<FlightResponse>
            ) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        val listFlight = arrayListOf<FlightsItem>()
                        for (flight in responseBody.data) {
                            if (flight.from == from && flight.to == to && flight.depatureDate == departureDate) {
                                listFlight.add(flight)
                                val adapter = FlightAdapter(requireActivity(), listFlight)
                                binding.rvFlight.adapter = adapter
                            }
                        }
                    }
                }
            }

            override fun onFailure(call: Call<FlightResponse>, t: Throwable) {
                Toast.makeText(requireActivity(), "Error : ${t}", Toast.LENGTH_SHORT).show()
            }

        })
    }

    companion object {
        const val EXTRA_FROM = "extra_from"
        const val EXTRA_TO = "extra_to"
        const val EXTRA_DEPARTURE_DATE = "extra_departure_date"
        const val EXTRA_FLIGHT_TYPE = "extra_flight_type"
    }
}