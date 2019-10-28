package com.example.daggerpractice1.ui.Auth

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.daggerpractice1.di.ViewModelProviderFactory
import com.example.daggerpractice1.R
import com.example.daggerpractice1.model.UserResponse
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class AuthActivity : DaggerAppCompatActivity() {



    @Inject
    lateinit var text :String

    @Inject
    lateinit var factory: ViewModelProviderFactory

    lateinit var viewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel  = ViewModelProviders.of(this,factory).get(AuthViewModel::class.java)

        viewModel.firstTodo.observe(this, Observer {
            Log.e("MainText", "some thisfnsd")
        })
    }


}
