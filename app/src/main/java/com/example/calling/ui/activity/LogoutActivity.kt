package com.example.calling.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.AuthFailureError
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.calling.databinding.ActivityLogoutBinding
import com.example.calling.utils.Constants
import org.json.JSONException
import org.json.JSONObject

class LogoutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLogoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        exitTheApp()
    }

    private fun exitTheApp() {
        binding.textView3.visibility = View.GONE

        binding.button2.setOnClickListener {
            val password = binding.editTextTextPassword.text.toString().trim()
            checkAdminPassword(password)
        }
        binding.button3.setOnClickListener { finish() }
    }

    private fun checkAdminPassword(
        password: String,
    ) {
        val request: StringRequest =
            object : StringRequest(Method.POST, Constants.CHECK_ADMIN_PASSWORD, object :
                Response.Listener<String?> {
                override fun onResponse(response: String?) {
                    try {
                        val json = response.toString()
                        val dataJson = JSONObject(json)
                        val error = dataJson.getString("error")
                        val message = dataJson.getString("message")
                        if (error.equals("false")) {
                            val admin = dataJson.getJSONObject("admin")
                            val adminPassword = admin.getString("password")
                            packageManager.clearPackagePreferredActivities(packageName)
                            val intent = Intent(Intent.ACTION_MAIN)
                            intent.addCategory(Intent.CATEGORY_HOME)
                            startActivity(intent)
                        } else {
                            binding.textView3.text = message
                            binding.textView3.visibility = View.VISIBLE
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }
            }, object : Response.ErrorListener {
                override fun onErrorResponse(volleyError: VolleyError) {
                    Toast.makeText(
                        applicationContext,
                        "error!" + volleyError.message,
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }) {
                @Throws(AuthFailureError::class)
                override fun getParams(): Map<String, String> {
                    val params = HashMap<String, String>()
                    params["password"] = password
                    return params
                }
            }
        val requestQueue = Volley.newRequestQueue(applicationContext)
        requestQueue.add(request)
    }
}