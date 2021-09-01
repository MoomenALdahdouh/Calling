package com.example.calling.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.calling.adapter.ContactsAdapter
import com.example.calling.databinding.FragmentCallBinding
import com.example.calling.model.Contact
import java.util.*

class CallFragment : Fragment() {

    private lateinit var binding: FragmentCallBinding
    private lateinit var contactsAdapter: ContactsAdapter
    private lateinit var contactArrayList: ArrayList<Contact>
    private lateinit var recyclerView: RecyclerView
    private val REQUEST_CALL = 1
    private var mobile: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCallBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        contactArrayList = ArrayList()
        contactArrayList.add(Contact("Moomen", "0597750487"))
        contactArrayList.add(Contact("Sara", "0597750487"))
        contactArrayList.add(Contact("John", "0597750487"))
        contactArrayList.add(Contact("John", "0597750487"))
        contactArrayList.add(Contact("John", "0597750487"))
        contactArrayList.add(Contact("John", "0597750487"))
        contactArrayList.add(Contact("John", "0597750487"))
        contactArrayList.add(Contact("John", "0597750487"))
        contactsAdapter = ContactsAdapter(contactArrayList)
        contactsAdapter.onItemSetOnClickListener(object : ContactsAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                mobile = contactArrayList[position].mobile
                makePhoneCall()
            }
        })
        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = contactsAdapter
        recyclerView.setHasFixedSize(true)
    }

    private fun makePhoneCall() {
        /*if (ContextCompat.checkSelfPermission(
                context, Manifest.permission.CALL_PHONE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                context,
                arrayOf(Manifest.permission.CALL_PHONE),
                REQUEST_CALL
            )
        } else {
            val dial = "tel:$mobile"
            startActivity(Intent(Intent.ACTION_CALL, Uri.parse(dial)))
        }*/
        Toast.makeText(context, "Call", Toast.LENGTH_SHORT).show()
    }


}