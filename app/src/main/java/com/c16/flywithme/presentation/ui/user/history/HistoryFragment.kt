package com.c16.flywithme.presentation.ui.user.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.c16.flywithme.data.response.HistoryResponse
import com.c16.flywithme.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment(), AdapterHistories.OnItemClickListener {

    private lateinit var adapterHistories: AdapterHistories
    private lateinit var _binding: FragmentHistoryBinding
    private lateinit var historiesViewModel: HistoriesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewModel()
        initRecyclerViewHistories()
    }

    private fun initRecyclerViewHistories() {
        _binding.recyclerViewFlights.apply {
            layoutManager = LinearLayoutManager(this@HistoryFragment.context)
            val decoration =
                DividerItemDecoration(this@HistoryFragment.context, DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            adapterHistories = AdapterHistories(this@HistoryFragment)
            adapter = adapterHistories
        }
    }

    private fun initViewModel() {
        historiesViewModel = ViewModelProvider(this)[HistoriesViewModel::class.java]
        historiesViewModel.getHistoriesObserver().observe(this@HistoryFragment.viewLifecycleOwner) {
            if (it != null) {
                showLoading(false)
//                adapterHistories.historiesList = it.orderList.toMutableList()
//                adapterHistories.notifyDataSetChanged()

            } else {
                showLoading(false)
                Toast.makeText(
                    this@HistoryFragment.context,
                    "no result found...",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        historiesViewModel.getHistories()
    }

    private fun showLoading(loading: Boolean) {
        when (loading) {
            true -> _binding.progressBar.visibility = View.VISIBLE
            false -> _binding.progressBar.visibility = View.GONE
        }
    }

    override fun onItemDetailCLick(flight: HistoryResponse) {
        TODO("Not yet implemented")
    }

}