package com.faisal.rxretrofitsearch.ui

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import butterknife.ButterKnife
import android.os.Build
import android.view.View
import android.content.Intent
import butterknife.OnClick
import com.faisal.rxretrofitsearch.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // white background notification bar
        //whiteNotificationBar(toolbar)
    }


    @OnClick(R.id.btn_local_search)
    fun openLocalSearch() {
        // launching local search activity
        startActivity(Intent(this@MainActivity, LocalSearchActivity::class.java))
    }

    @OnClick(R.id.btn_remote_search)
    fun openRemoteSearch() {
        // launch remote search activity
        startActivity(Intent(this@MainActivity, RemoteSearchActivity::class.java))
    }

    private fun whiteNotificationBar(view: View) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            var flags = view.getSystemUiVisibility()
            flags = flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            view.setSystemUiVisibility(flags)
            window.statusBarColor = Color.WHITE
        }
    }
}
