package com.example.calling.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.calling.R
import com.example.calling.databinding.ActivityMainBinding
import com.example.calling.ui.fragment.CallFragment
import com.example.calling.ui.fragment.LoginFragment
import com.example.calling.utils.PreferenceUtils

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var fragment: Fragment
    private val fragmentManager = supportFragmentManager
    private val fragmentTransaction = fragmentManager.beginTransaction()
    private var idMenu = R.menu.call_menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (!PreferenceUtils.getID(this).equals("")) {
            fragment = CallFragment()
            idMenu = R.menu.call_menu
        } else {
            fragment = LoginFragment()
            idMenu = R.menu.login_menu
        }
        replaceFragment(fragment)
    }

    private fun replaceFragment(fragment: Fragment) {
        fragmentTransaction.replace(R.id.fragment_container_view, fragment)
        fragmentTransaction.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(idMenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.logout_menu_id) {
            PreferenceUtils.saveID("", this)
            Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        } else if (id == R.id.exit_menu_id) {
            Toast.makeText(this, "Exit", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}