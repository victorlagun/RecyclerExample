package com.example.recyclerexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclerexample.databinding.ActivityMainBinding
import com.example.recyclerexample.model.Contact
import com.example.recyclerexample.model.ContactEmail
import com.example.recyclerexample.model.ContactPhone

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val contactList = mutableListOf<Contact>(
            ContactPhone("", "Victor", "+375333333333"),
            ContactEmail("", "Victor", "test@mail.com"),

            ContactPhone("", "Victor", "+375333333333"),
            ContactEmail("", "Victor", "test@mail.com"),

            ContactPhone("", "Victor", "+375333333333"),
            ContactEmail("", "Victor", "test@mail.com"),
            ContactEmail("", "Victor", "test@mail.com"),

            ContactPhone("", "Victor", "+375333333333"),
            ContactEmail("", "Victor", "test@mail.com"),
            ContactEmail("", "Victor", "test@mail.com"),

            ContactPhone("", "Victor", "+375333333333"),
            ContactEmail("", "Victor", "test@mail.com"),
            ContactEmail("", "Victor", "test@mail.com"),

            ContactPhone("", "Victor", "+375333333333"),
            ContactEmail("", "Victor", "test@mail.com"),
            ContactEmail("", "Victor", "test@mail.com"),

            ContactPhone("", "Victor", "+375333333333"),
            ContactEmail("", "Victor", "test@mail.com"),
            ContactEmail("", "Victor", "test@mail.com"),
        )
        val adapter = ContactListAdapter(contactList, {}, {})
        binding.contactRecyclerView.adapter = adapter
    }
}