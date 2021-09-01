package com.example.calling.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.android.volley.AuthFailureError
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.calling.databinding.FragmentLoginBinding
import com.example.calling.ui.activity.SplashActivity
import com.example.calling.utils.Constants
import com.example.calling.utils.PreferenceUtils
import org.json.JSONException
import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.set


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
            val userID = binding.editTextUserID.text.toString().trim()
            val password = binding.editTextUserPassword.text.toString().trim()
            if (userID.isEmpty()) {
                binding.buttonLoginId.error = "User ID is required"
                binding.buttonLoginId.requestFocus()
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                binding.editTextUserPassword.error = "password is required"
                binding.editTextUserPassword.requestFocus()
                return@setOnClickListener
            }

            val request: StringRequest =
                object : StringRequest(Method.POST, Constants.LOGIN_URL, object :
                    Response.Listener<String?> {
                    override fun onResponse(response: String?) {
                        try {
                            val text = response.toString()
                            Toast.makeText(context, "Login", Toast.LENGTH_SHORT)
                                .show()
                            PreferenceUtils.saveID(userID, context)
                            startActivity(Intent(context, SplashActivity::class.java))
                            activity?.finish()
                            //val array = JSONArray(data)
                            /*val person = JSONObject(response)
                            val error = person.getString("error")
                            val message = person.getString("message")
                            Toast.makeText(context, "$error,,$message", Toast.LENGTH_SHORT).show()*/
                            // print the output
                        } catch (e: JSONException) {
                            e.printStackTrace()
                        }
                    }
                }, object : Response.ErrorListener {
                    override fun onErrorResponse(volleyError: VolleyError) {
                        Toast.makeText(context, "error!" + volleyError.message, Toast.LENGTH_SHORT)
                            .show()
                    }
                }) {
                    @Throws(AuthFailureError::class)
                    override fun getParams(): Map<String, String> {
                        val params = HashMap<String, String>()
                        params["userID"] = userID
                        params["password"] = password
                        return params
                    }
                }

            val requestQueue = Volley.newRequestQueue(context)
            requestQueue.add(request)

            //creating volley string request
            /*val stringRequest = @SuppressLint("ApplySharedPref")
            object : StringRequest(Method.POST, Constants.LOGIN_URL,
                Response.Listener { _ ->
                    try {
                        val jsonObject = JSONObject()
                        val error = jsonObject.optString("error")
                        if (error.equals("false")) {
                            Toast.makeText(
                                context,
                                jsonObject.getString("message"),
                                Toast.LENGTH_SHORT
                            ).show()
                            startActivity(Intent(context, MainActivity::class.java))
                            activity?.finish()
                        } else {
                            Toast.makeText(
                                context,
                                jsonObject.getString("message"),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    *//*try {
                        Toast.makeText(context, "You are logged in", Toast.LENGTH_LONG).show()
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }*//*
                },
                object : Response.ErrorListener {
                    override fun onErrorResponse(volleyError: VolleyError) {
                        Toast.makeText(context, volleyError.message, Toast.LENGTH_SHORT).show()
                    }
                }) {
                @Throws(AuthFailureError::class)
                override fun getParams(): Map<String, String> {
                    val params = HashMap<String, String>()
                    params["userID"] = userID
                    params["password"] = password
                    return params
                }
            }
            //adding request to queue
            VolleySingleton.instance?.addToRequestQueue(stringRequest)*/
        }
    }
}