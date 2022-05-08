package com.mimoza_app.notes.radzze.screens.start

import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.mimoza_app.notes.radzze.R
import com.mimoza_app.notes.radzze.databinding.FragmentStartBinding
import com.mimoza_app.notes.radzze.utilits.*

class StartFragment : Fragment() {

    private var _binding:FragmentStartBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel:StartFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStartBinding.inflate(layoutInflater)
        return mBinding.root

    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        mViewModel = ViewModelProvider(this)[StartFragmentViewModel::class.java]
        mViewModel.initDatabase(TYPE_ROOM){
            APP_ACTIVITY.navController.navigate(R.id.action_startFragment_to_mainFragment)

        }
        mBinding.btnFirebase.setOnClickListener{
            mBinding.inputEmail.visibility = View.VISIBLE
            mBinding.inputPassword.visibility = View.VISIBLE
            mBinding.btnLogin.visibility = View.VISIBLE
            mBinding.btnLogin.setOnClickListener{
                val inputEmail = mBinding.inputEmail.text.toString()
                val inputPassword = mBinding.inputPassword.text.toString()
                if(inputEmail.isNotEmpty() && inputPassword.isNotEmpty()){
                    EMAIL = inputEmail
                    PASSWORD = inputPassword
                    mViewModel.initDatabase(TYPE_FIREBASE){
                        APP_ACTIVITY.navController.navigate(R.id.action_startFragment_to_mainFragment)
                    }
                }else{
                    showToast("Enter a email and password!!")
                }
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}