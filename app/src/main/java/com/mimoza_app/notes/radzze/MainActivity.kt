package com.mimoza_app.notes.radzze

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.mimoza_app.notes.radzze.databinding.ActivityMainBinding
import com.mimoza_app.notes.radzze.utilits.APP_ACTIVITY

class MainActivity : AppCompatActivity() {

    lateinit var mToolBar: Toolbar
    lateinit var mNavController: NavController
    private var _binding: ActivityMainBinding? = null
    val mBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        APP_ACTIVITY = this
        mToolBar = mBinding.toolbar
        mNavController = Navigation.findNavController(this, R.id.nav_host)
        setSupportActionBar(mToolBar)
        title = getString(R.string.title_app)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}