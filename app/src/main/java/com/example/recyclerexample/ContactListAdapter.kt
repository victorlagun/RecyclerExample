package com.example.recyclerexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.recyclerexample.databinding.ItemContactEmailBinding
import com.example.recyclerexample.databinding.ItemContactPhoneBinding
import com.example.recyclerexample.model.Contact
import com.example.recyclerexample.model.ContactEmail
import com.example.recyclerexample.model.ContactPhone

class ContactListAdapter(
    private val list: List<Contact>,
    private val clickListenerPhone: (View) -> Unit,
    private val clickListenerEmail: (View) -> Unit
) : ListAdapter<Contact, ViewHolder>(MyDiffUtilCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        if (viewType == 0) {
            val binding = ItemContactPhoneBinding.inflate(LayoutInflater.from(parent.context), parent,false)
            ContactPhoneViewHolder(binding, clickListenerPhone)
        } else {
            val binding = ItemContactEmailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            ContactEmailViewHolder(binding, clickListenerEmail)

        }

    override fun getItemViewType(position: Int): Int {
        return if (list[position] is ContactPhone) 0 else 1
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (holder is ContactPhoneViewHolder) holder.bind(list[position] as ContactPhone)
        else (holder as ContactEmailViewHolder).bind(list[position] as ContactEmail)
    }

    override fun getItemCount() = list.size
}

class ContactPhoneViewHolder(
    private val binding: ItemContactPhoneBinding,
    private val clickListener: (View) -> Unit
) : ViewHolder(binding.root) {
    fun bind(contact: ContactPhone) {
        with(binding) {
            textName.text = contact.name
            textPhone.text = contact.phone
        }
        itemView.setOnClickListener(clickListener)
    }
}

class ContactEmailViewHolder(
    private val binding: ItemContactEmailBinding,
    private val clickListener: (View) -> Unit
) : ViewHolder(binding.root) {

    fun bind(contact: ContactEmail) {
        with(binding) {
            textName.text = contact.name
            textEmail.text = contact.email
        }
        itemView.setOnClickListener(clickListener)
    }
}

class MyDiffUtilCallback : DiffUtil.ItemCallback<Contact>() {
    override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
        return false
    }

    override fun getChangePayload(oldItem: Contact, newItem: Contact): Any? {
        return super.getChangePayload(oldItem, newItem)
    }
}

