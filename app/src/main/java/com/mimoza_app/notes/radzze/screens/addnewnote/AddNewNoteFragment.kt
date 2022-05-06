package com.mimoza_app.notes.radzze.screens.addnewnote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.mimoza_app.notes.radzze.R
import com.mimoza_app.notes.radzze.databinding.FragmentAddNewNoteBinding
import com.mimoza_app.notes.radzze.models.AppNote
import com.mimoza_app.notes.radzze.utilits.APP_ACTIVITY
import com.mimoza_app.notes.radzze.utilits.showToast

class AddNewNoteFragment : Fragment() {

    private var _binding:FragmentAddNewNoteBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel:AddNewNoteFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddNewNoteBinding.inflate(layoutInflater,container,false)
        return mBinding.root
    }


    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        mViewModel = ViewModelProvider(this)[AddNewNoteFragmentViewModel::class.java]
        mBinding.addNewNote.setOnClickListener{
            val name = mBinding.editTextNoteName.text.toString()
            val text = mBinding.editTextNoteText.text.toString()
            if(name.isEmpty()){
                showToast(getString(R.string.toast_enter_name))
            }else{
                mViewModel.insert(AppNote(name = name,text = text)){
                    APP_ACTIVITY.mNavController.navigate(R.id.action_addNewNoteFragment_to_mainFragment)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}