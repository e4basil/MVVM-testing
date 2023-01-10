package com.example.mytestingapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.mytestingapplication.databinding.ActivityMainBinding
import com.example.mytestingapplication.network.ResultData
import com.example.mytestingapplication.presentation.activity.MainActivityViewModel
import com.example.mytestingapplication.presentation.activity.adapter.RepositoriesAdapter
import com.example.mytestingapplication.service.MyService
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var isStoped: Boolean = false
    private var count = 0
    val TAG = "MainActivity";
    private lateinit var intentService: Intent
    private lateinit var mBinding:ActivityMainBinding
    private val mainViewModel: MainActivityViewModel by viewModels()
    private lateinit var repositoriesAdapter: RepositoriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        intentService = Intent(applicationContext, MyService::class.java)

        repositoriesAdapter = RepositoriesAdapter().also {
            mBinding.rv.adapter = it
        }

        setObservers()
        getDataAndSubscribeEvents()
    }

    private fun setObservers() {
        mainViewModel.repositoryListLiveData.observe(this){
            when(it){
                is ResultData.Loading->{
                    mBinding.pb.visibility=View.VISIBLE
                    Log.d(getString(R.string.app_name), "setObservers: Loading")
                }
                is ResultData.Failed->{
                    mBinding.pb.visibility=View.GONE
                    Log.d(getString(R.string.app_name), "setObservers: Failed")
                }
                is ResultData.Success->{
                    mBinding.pb.visibility=View.GONE
                    Log.d(getString(R.string.app_name), "setObservers: Success")
//                    Log.d(getString(R.string.app_name), "setObservers: ${it.data}")

                    val repositoriesModel = it.data
                    repositoriesAdapter.submitList(repositoriesModel)
                }
            }
        }
    }

    private fun getDataAndSubscribeEvents() {
        mainViewModel.getRepositoriesList(since = "20")
    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "onDestroy: ")
    }

    override fun onClick(v: View?) {
        when (v?.id) {
//            R.id.btn -> {
//                Log.d(TAG, "onClick: ${Thread.currentThread().name}")
//                isStoped = true
////                Thread {
////                    while (isStoped) {
////                        count++;
////                        findViewById<TextView>(R.id.tv).text = count.toString()
//////                        Log.d(TAG, "onClick: ${Thread.currentThread().id}")
////                    }
////                }.start()
//
//                Log.d(getString(R.string.app_name), "onClick: ${Thread.currentThread().id}")
//                //startService(intentService);
//                startActivity(Intent(this, MainActivity2::class.java))
//            }
//            R.id.btn2 -> {
////                isStoped = false
//            }
        }
    }

}
