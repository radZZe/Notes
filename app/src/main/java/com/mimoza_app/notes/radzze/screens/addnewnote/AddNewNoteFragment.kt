package com.mimoza_app.notes.radzze.screens.addnewnote

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
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
        setHasOptionsMenu(true)
        mViewModel = ViewModelProvider(this)[AddNewNoteFragmentViewModel::class.java]

    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.save_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.save_btn ->{
                var name = mBinding.editTextNoteName.text.toString()
                var text = mBinding.editTextNoteText.text.toString()
                if(name.isEmpty()){
                    showToast(getString(R.string.toast_enter_name))
                }else{
                    mViewModel.insert(AppNote(name = name,text = text)){
                        APP_ACTIVITY.navController.navigate(R.id.action_addNewNoteFragment_to_mainFragment)
                    }
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("MyLog","onSaveInstanceState")
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}