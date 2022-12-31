package com.c16.flywithme.presentation.ui.user.booking

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.recyclerview.widget.RecyclerView
import com.c16.flywithme.data.remote.ApiConfig
import com.c16.flywithme.data.request.BookingRequest
import com.c16.flywithme.data.response.AddBookingResponse
import com.c16.flywithme.data.response.FlightsItem
import com.c16.flywithme.databinding.FlightItemBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FlightAdapter(private val context: Context, private val listFlight: ArrayList<FlightsItem>) : RecyclerView.Adapter<FlightAdapter.FlightViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlightViewHolder {
        val binding = FlightItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FlightViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FlightViewHolder, position: Int) {
        holder.binding.tvFrom.text = listFlight[position].from
        holder.binding.tvTo.text = listFlight[position].to
        holder.binding.tvPrice.text = "IDR ${listFlight[position].classPrice}"
        holder.binding.tvDepartureTime.text = listFlight[position].depatureTime
        holder.binding.tvArrivalTime.text = listFlight[position].arrivalTime
        holder.binding.btnCheck.setOnClickListener {
            val client = ApiConfig.getApiService().addBooking(
                listOf(
                BookingRequest(
                "Fathan", 20, 3328080205000004, "087823456784",
                    "b5", listFlight[position].classPrice, listFlight[position].id, 8)))
            client.enqueue(object : Callback<AddBookingResponse> {
                override fun onResponse(
                    call: Call<AddBookingResponse>,
                    response: Response<AddBookingResponse>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        if (responseBody != null) {
                            Toast.makeText(context, responseBody.message,Toast.LENGTH_SHORT).show()
                        }
                    }
                }

                override fun onFailure(call: Call<AddBookingResponse>, t: Throwable) {
                    Toast.makeText(context, t.toString(),Toast.LENGTH_SHORT).show()
                }

            })
            val intent = Intent(context, PaymentActivity::class.java)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int = listFlight.size

    class FlightViewHolder(var binding: FlightItemBinding) : RecyclerView.ViewHolder(binding.root)
}