package com.example.notes.salov.screens.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.notes.salov.R
import com.example.notes.salov.databinding.FragmentStartBinding
import com.example.notes.salov.utilits.APP_ACTIVITY
import com.example.notes.salov.utilits.TYPE_ROOM

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
        initialization()
    }

    private fun initialization() {
        mViewModel = ViewModelProvider(this).get(StartFragmentViewModel::class.java)
        mBinding.btnRoom.setOnClickListener {
            mViewModel.initDataBase(TYPE_ROOM) {
                APP_ACTIVITY.mNavController.navigate(R.id.action_startFragment_to_mainFragment)
            }
        }
    }

}