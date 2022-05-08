package com.mimoza_app.notes.radzze.screens.note

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.text.Editable
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.mimoza_app.notes.radzze.R
import com.mimoza_app.notes.radzze.databinding.FragmentNoteBinding
import com.mimoza_app.notes.radzze.models.AppNote
import com.mimoza_app.notes.radzze.utilits.APP_ACTIVITY
import com.mimoza_app.notes.radzze.utilits.KEY_CLICK_NOTE
import com.mimoza_app.notes.radzze.utilits.showToast


class NoteFragment : Fragment() {
    private var _binding: FragmentNoteBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: NoteFragmentViewModel
    private lateinit var mCurrentNote:AppNote

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mCurrentNote = arguments?.getSerializable(KEY_CLICK_NOTE) as AppNote
        _binding = FragmentNoteBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        setHasOptionsMenu(true)
        mViewModel = ViewModelProvider(this)[NoteFragmentViewModel::class.java]
        mBinding.noteName.setText(mCurrentNote.name)
        mBinding.noteText.setText(mCurrentNote.text)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.note_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.delete_btn ->{
                showAlertDialog()
            }
            R.id.save_btn ->{
                mCurrentNote.name = mBinding.noteName.text.toString()
                mCurrentNote.text = mBinding.noteText.text.toString()
                mViewModel.updateItem(mCurrentNote){
                    APP_ACTIVITY.navController.navigate(R.id.action_noteFragment_to_mainFragment)
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }


    private fun showAlertDialog(){
        val listener = DialogInterface.OnClickListener{_,which ->
            run {
                when (which) {
                    DialogInterface.BUTTON_POSITIVE -> {
                        mViewModel.deleteItem(mCurrentNote) {
                            APP_ACTIVITY.navController.navigate(R.id.action_noteFragment_to_mainFragment)
                        }
                    }
                    DialogInterface.BUTTON_NEGATIVE -> {}
                }
            }
        }

        val dialog = AlertDialog.Builder(this.context)
            .setCancelable(false)
            .setTitle("Удалить заметку ?")
            .setMessage("Вы уверенны что хотите удалить заметку?")
            .setPositiveButton("Yes",listener)
            .setNegativeButton("No",listener)
            .create()

        dialog.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}