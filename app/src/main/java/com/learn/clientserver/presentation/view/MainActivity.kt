package com.learn.clientserver.presentation.view

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.learn.clientserver.R
import com.learn.clientserver.domain.Success
import com.learn.clientserver.presentation.Constants
import com.learn.clientserver.presentation.adapters.EmpAdapter
import com.learn.clientserver.presentation.viewmodel.EmpViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),EmpAdapter.ItemSelectListener {

    lateinit var viewModel: EmpViewModel
    lateinit var empAdapter: EmpAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[EmpViewModel::class.java]

        empRecyclerView.layoutManager = LinearLayoutManager(this)
        empAdapter = EmpAdapter(this)
        empRecyclerView.adapter = empAdapter

        viewModel.empLiveData.observe(this, Observer { empAdapter.update(it) })
        viewModel.fetchDataFromServer()
    }

    override fun onItemClick(position: Int) {
        val emp = empAdapter.getEmpAt(position)
        Log.e("MainActivity","employee saved = "+emp.name)
        sendEditIntent(emp)
    }


    fun sendEditIntent(emp : Success) {
        var intent = Intent(this,EmpDetailActivity::class.java)
        intent.action = Constants.EDIT_ACTION
        intent.putExtra(Constants.INTENT_DATA_KEY,emp)
        startActivityForResult(intent, Constants.REQUESTCODE_EDIT)
    }

    //getting result back from emp activity
    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)

        if(requestCode == Constants.REQUESTCODE_EDIT && resultCode == Activity.RESULT_OK){
            val emp = intent?.getParcelableExtra<Success>(Constants.INTENT_DATA_KEY)
            Log.e("MainActivity","employee updated = "+emp?.name)
            if (emp != null) {
                viewModel.update(emp)
            }
        }
    }
}
