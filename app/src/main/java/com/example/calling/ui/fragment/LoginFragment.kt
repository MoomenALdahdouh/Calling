package com.example.calling.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.calling.databinding.FragmentLoginBinding
import com.example.calling.ui.activity.MainActivity
import com.example.calling.utils.PreferenceUtils

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonLoginId.setOnClickListener {
            PreferenceUtils.saveID("Hi", context)
            Toast.makeText(context, "Login", Toast.LENGTH_SHORT).show()
            startActivity(Intent(context, MainActivity::class.java))
            activity?.finish()
            /*val transaction:FragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container_view,CallFragment())*/
        }
    }
}