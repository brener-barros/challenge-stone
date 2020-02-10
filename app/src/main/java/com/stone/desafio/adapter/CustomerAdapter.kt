package com.stone.desafio.adapter

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stone.desafio.R
import com.stone.desafio.model.Customer
import kotlinx.android.synthetic.main.customers_list.view.*

class CustomerAdapter (val customers: MutableList<Customer>): RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerViewHolder {
        val itemList = LayoutInflater.from(parent.context).inflate(R.layout.customers_list, parent, false)
        return CustomerViewHolder(itemList)
    }

    override fun getItemCount(): Int {
        return customers.size
    }

    override fun onBindViewHolder(holder: CustomerViewHolder, position: Int) {
        val customer: Customer = customers[position]
        holder.bind(customer)
    }

    inner class CustomerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val name = itemView.textName
        private val id = itemView.textId
        private val status = itemView.textStatus
        private val description = itemView.textDescription
        private val alert = itemView.imageAlert

        fun bind(customer: Customer) {
            name.text = customer.name
            id.text = if(customer.id.isNullOrEmpty()) "Sem id" else customer.id
            description.text = if(customer.description.isNullOrEmpty()) "Sem informações" else customer.description

            if(customer.status.isNullOrEmpty()) {
                status.text = "Não há status"
            }
            else if(customer.status.equals("Reativação")) {
                status.text = customer.status
                alert.visibility = View.VISIBLE
            }
            else {
                status.text = customer.status
                alert.visibility = View.INVISIBLE
            }

        }
    }
}