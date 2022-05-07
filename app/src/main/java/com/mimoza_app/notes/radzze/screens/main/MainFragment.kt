package com.mimoza_app.notes.radzze.screens.main

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.mimoza_app.notes.radzze.R
import com.mimoza_app.notes.radzze.databinding.FragmentMainBinding
import com.mimoza_app.notes.radzze.models.AppNote
import com.mimoza_app.notes.radzze.utilits.APP_ACTIVITY
import com.mimoza_app.notes.radzze.utilits.KEY_CLICK_NOTE

class MainFragment : Fragment() {

    private var _binding:FragmentMainBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var  mainAdapter:MainAdapter
    private lateinit var mObserver:Observer<List<AppNote>>
    private lateinit var mViewModel:MainFragmentViewModel
    private lateinit var rvMain:RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(layoutInflater,container,false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization(){
        setHasOptionsMenu(true)
        setupRecyclerView()
        mObserver = Observer{
            mainAdapter.submitList(it.asReversed())
        }
        mViewModel = ViewModelProvider(this)[MainFragmentViewModel::class.java]
        mViewModel.allNotes.observe(this,mObserver)
        mBinding.btnAddNote.setOnClickListener {
            APP_ACTIVITY.navController.navigate(R.id.action_mainFragment_to_addNewNoteFragment)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu,menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.exit_btn ->{
                mViewModel.signOut()
                APP_ACTIVITY.navController.navigate(R.id.action_mainFragment_to_startFragment)

            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupRecyclerView(){
        rvMain = mBinding.rvMain
        with(rvMain){
            mainAdapter = MainAdapter()
            adapter = mainAdapter
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
        mViewModel.allNotes.removeObserver(mObserver)
        rvMain.adapter = null
    }

    companion object{
        fun onClickNote(note:AppNote){
            val bundle = Bundle()
            bundle.putSerializable(KEY_CLICK_NOTE,note)
            APP_ACTIVITY.navController.navigate(R.id.action_mainFragment_to_noteFragment,bundle)
        }
    }

}

