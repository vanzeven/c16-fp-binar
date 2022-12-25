package com.c16.flywithme.presentation.ui.user.profile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.c16.flywithme.data.remote.ApiConfig
import com.c16.flywithme.data.response.UserDetailResponse
import com.c16.flywithme.databinding.FragmentProfileBinding
import com.c16.flywithme.presentation.ui.login.LoginActivity
import com.c16.flywithme.viewmodel.ViewModelFactory
import com.c16.flywithme.data.result.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class ProfileFragment : Fragment() {

    private lateinit var _binding: FragmentProfileBinding
    private lateinit var viewModel: ProfileViewModel
    private var id = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
        getDetail()

        _binding.btnLogout.setOnClickListener {
            toLogin()
        }
    }

    private fun getDetail() {
        val id = "4"
        val retroInstance = ApiConfig.getApiService()
        val call = retroInstance.detailUser(id)
        _binding.tvFirstname.text = "Sua Yoo"

        call.enqueue(object : Callback<UserDetailResponse> {
            override fun onResponse(
                call: Call<UserDetailResponse>,
                response: Response<UserDetailResponse>
            ) {
                val body = response.body()
            }

            override fun onFailure(call: Call<UserDetailResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    private fun setViewModel() {
        val factory = ViewModelFactory.getInstance(requireContext(), requireContext().dataStore)
        viewModel = ViewModelProvider(viewModelStore, factory)[ProfileViewModel::class.java]

        viewModel.getUserData().observe(viewLifecycleOwner) {
            id = it.localid
           // if(it.isLogin) getUserDetail()
        }
    }

//    private fun getUserDetail() {
//        viewModel.getDetailUser(id).observe(viewLifecycleOwner) { result ->
//            when (result) {
//                is Result.Loading -> showLoading(true)
//                is Result.Success -> {
//                    userDetail = result.data
//                    isiData()
//                    showLoading(false)
//                }
//                is Result.Error -> {
//                    Toast.makeText(requireContext(), result.error, Toast.LENGTH_SHORT).show()
//                    showLoading(false)
//                }
//            }
//        }
//    }

    private fun toLogin() {
        viewModel.signOut()
        val intent = Intent(context, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }

}