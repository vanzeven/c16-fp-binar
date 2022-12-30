package com.c16.flywithme.presentation.ui.user.booking

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.view.get
import com.c16.flywithme.R
import com.c16.flywithme.data.remote.ApiConfig
import com.c16.flywithme.data.response.AirportResponse
import com.c16.flywithme.databinding.FragmentBookingBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BookingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BookingFragment : Fragment() {

    private var _binding: FragmentBookingBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBookingBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        findAllAirport()
        binding.btnDecreaseAdult.setOnClickListener {
            if (binding.etAdult.text.toString().toInt() > 1) {
                var passenger = binding.etAdult.text.toString().toInt()
                passenger--
                binding.etAdult.setText(passenger.toString())
            }
        }
        binding.btnIncreaseAdult.setOnClickListener {
            var passenger = binding.etAdult.text.toString().toInt()
            passenger++
            binding.etAdult.setText(passenger.toString())
        }
        binding.btnSearch.setOnClickListener {
            val from = binding.spFrom.selectedItem.toString()
            val to = binding.spTo.selectedItem.toString()
            val departureDate = binding.etDepart.text.toString()
            val flighType = if(binding.rbRoundTrip.isSelected) binding.rbRoundTrip.text else binding.rbOneWay.text
            val passenger = binding.etAdult.text.toString().toInt()

        }

    }

    fun findAllAirport() {
        val client = ApiConfig.getApiService().getAllAirports()
        client.enqueue(object : Callback<AirportResponse> {
            override fun onResponse(
                call: Call<AirportResponse>,
                response: Response<AirportResponse>
            ) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        val listAirport = arrayListOf<String>()
                        for (airport in responseBody.data) {
                            listAirport.add(airport.name)
                        }
                        ArrayAdapter(requireActivity(),
                            android.R.layout.simple_spinner_item, listAirport)
                            .also { adapter ->
                                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                                binding.spFrom.adapter = adapter
                                binding.spTo.adapter = adapter
                            }
                    }
                }
            }

            override fun onFailure(call: Call<AirportResponse>, t: Throwable) {

            }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}