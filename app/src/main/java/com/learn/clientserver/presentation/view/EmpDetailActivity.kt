package com.learn.clientserver.presentation.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.learn.clientserver.R
import com.learn.clientserver.databinding.ContentEmpBinding
import com.learn.clientserver.domain.Success
import com.learn.clientserver.presentation.Constants
import com.learn.clientserver.presentation.viewmodel.EmpViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.content_emp.*

class EmpDetailActivity : AppCompatActivity() {

    var action: String? = null
    lateinit var emp : Success
    lateinit var viewModel : EmpViewModel
    lateinit var binding : ContentEmpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.content_emp)
        viewModel = ViewModelProvider(this)[EmpViewModel::class.java]

        action = intent.action
        Log.e("EmpDetailActivity","action is "+action)
        if(action == Constants.EDIT_ACTION) {
            emp = intent.getParcelableExtra(Constants.INTENT_DATA_KEY)
            binding.emp = emp
            Log.e("EmpDetailActivity","employee get = "+emp.name)
            initView()
        }
    }

    fun initView() {
        Picasso.get()
            .load(emp.image)
            .into(image)
    }

    fun sendIntent(emp : Success) {
        val intent = Intent()
        intent.putExtra(Constants.INTENT_DATA_KEY,emp)
        setResult(Activity.RESULT_OK, intent)
    }

    fun updateEmp() {
        var emp = binding.emp!!
        Log.e("EmpDetailActivity","employee save = "+emp.name)
        sendIntent(emp)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_save -> {
                updateEmp()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}