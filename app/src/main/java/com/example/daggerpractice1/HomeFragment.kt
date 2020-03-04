package com.example.daggerpractice1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.daggerpractice1.di.Injectable
import com.example.daggerpractice1.di.ViewModelProviderFactory
import com.example.daggerpractice1.ui.Auth.AuthViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment(), Injectable {

    @Inject
    lateinit var text: String

    @Inject
    lateinit var factory: ViewModelProviderFactory

    lateinit var viewModel: AuthViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this, factory).get(AuthViewModel::class.java)
        viewModel.firstTodo.observe(this, Observer {
            response.text = it.email + it.company + it.email
        })
    }
}
