package com.example.trainlib

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.trainlib.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),MainView {
    private var vb: ActivityMainBinding? = null
    val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)

        val listener = View.OnClickListener {
            presenter.counterClick(it.id)
        }

        vb?.btnCounter1?.setOnClickListener(listener)
        vb?.btnCounter2?.setOnClickListener(listener)
        vb?.btnCounter3?.setOnClickListener(listener)
    }

    override fun setFirstCount(num: Int) {
        vb?.btnCounter1?.text = num.toString()
    }

    override fun setSecondCount(num: Int) {
        vb?.btnCounter2?.text = num.toString()
    }

    override fun setThirdCount(num: Int) {
        vb?.btnCounter3?.text = num.toString()
    }
}