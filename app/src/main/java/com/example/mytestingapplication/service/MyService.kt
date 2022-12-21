package com.example.mytestingapplication.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.example.mytestingapplication.R

class MyService: Service() {

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(getString(R.string.app_name), Thread.currentThread().id.toString())
        stopSelf()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}