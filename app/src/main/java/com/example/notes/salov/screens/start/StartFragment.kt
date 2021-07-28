package com.example.notes.salov.screens.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.notes.salov.R
import com.example.notes.salov.databinding.FragmentStartBinding
import com.example.notes.salov.utilits.*

class StartFragment : Fragment() {

    private var _binding: FragmentStartBinding? = null
    val mBinding get() = _binding!!
    private lateinit var mViewModel: StartFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStartBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        mViewModel = ViewModelProvider(this).get(StartFragmentViewModel::class.java)
        if (AppPreference.getInitUser()) {
            mViewModel.initDataBase(AppPreference.getTypeDB()) {
                APP_ACTIVITY.navController.navigate(R.id.action_startFragment_to_mainFragment)
            }
        } else {
            initialization()
        }
    }

    private fun initialization() {
        mBinding.btnRoom.setOnClickListener {
            mViewModel.initDataBase(TYPE_ROOM) {
                AppPreference.setInitUser(true)
                AppPreference.setTypeDB(TYPE_ROOM)
                APP_ACTIVITY.navController.navigate(R.id.action_startFragment_to_mainFragment)
            }
        }

        mBinding.btnFirebase.setOnClickListener {
            val emailEditText = mBinding.inputEmail
            val passwordEditText = mBinding.inputPassword
            val loginBtn = mBinding.btnLogin
            emailEditText.visibility = View.VISIBLE
            passwordEditText.visibility = View.VISIBLE
            loginBtn.visibility = View.VISIBLE
            loginBtn.setOnClickListener {
                val inputEmail = emailEditText.text.toString()
                val inputPssword = passwordEditText.text.toString()
                if (inputEmail.isNotEmpty() && inputPssword.isNotEmpty()) {
                    EMAIL = inputEmail
                    PASSWORD = inputPssword
                    mViewModel.initDataBase(TYPE_FIREBASE) {
                        AppPreference.setInitUser(true)
                        AppPreference.setTypeDB(TYPE_FIREBASE)
                        APP_ACTIVITY.navController.navigate(R.id.action_startFragment_to_mainFragment)
                    }
                } else {
                    showToast(getString(R.string.toast_wrong_enter))
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}