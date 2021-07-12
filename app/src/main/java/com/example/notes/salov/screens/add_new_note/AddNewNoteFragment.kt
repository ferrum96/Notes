package com.example.notes.salov.screens.add_new_note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.notes.salov.R
import com.example.notes.salov.databinding.FragmentAddNewNoteBinding
import com.example.notes.salov.model.AppNote
import com.example.notes.salov.utilits.APP_ACTIVITY
import com.example.notes.salov.utilits.showToast

class AddNewNoteFragment : Fragment() {

    private var _binding: FragmentAddNewNoteBinding? = null
    val mBinding get() = _binding!!
    private lateinit var mViewModel: AddNewNoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddNewNoteBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initialization() {
        mViewModel = ViewModelProvider(this).get(AddNewNoteViewModel::class.java)
        mBinding.btnAddNote.setOnClickListener {
            val name = mBinding.inputNameNote.text.toString()
            val text = mBinding.inputTextNote.text.toString()
            if (name.isEmpty()) {
                showToast(getString(R.string.toast_enter_name))
            } else {
                mViewModel.insert(AppNote(name = name, text = text)) {
                    APP_ACTIVITY.mNavController.navigate(R.id.action_addNewNoteFragment_to_mainFragment)
                }
            }
        }
    }
}