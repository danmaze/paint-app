package com.revgalaxy.paint

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var paintView: PaintView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        paintView = findViewById(R.id.paintView)
        val metrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(metrics)
        paintView!!.init(metrics)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.normal -> {
                paintView!!.normal()
                return true
            }
            R.id.blur -> {
                paintView!!.blur()
                return true
            }
            R.id.clear -> {
                paintView!!.clear()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
