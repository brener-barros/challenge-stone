package com.stone.desafio.activity

import android.app.PendingIntent.getActivity
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.stone.desafio.R
import com.stone.desafio.adapter.CustomerAdapter
import com.stone.desafio.model.Customer
import kotlinx.android.synthetic.main.customers_list.*


class MainActivity : AppCompatActivity() {
    private lateinit var customerList: MutableList<Customer>
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        customerList = mutableListOf()

        val gson = Gson()
        val mutableListTutorialType = object : TypeToken<MutableList<Customer>>() {}.type
        customerList = gson.fromJson(MockedJson.value, mutableListTutorialType)

        viewManager = LinearLayoutManager(this)
        viewAdapter = CustomerAdapter(customerList)

        recyclerView = findViewById<RecyclerView>(R.id.my_recycler_view).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter
        }
        recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))
    }
}
