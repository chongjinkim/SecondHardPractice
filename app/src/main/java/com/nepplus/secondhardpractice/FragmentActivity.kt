package com.nepplus.secondhardpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nepplus.secondhardpractice.MainActivity.Companion.FRAGMENT_TYPE
import com.nepplus.secondhardpractice.fragment.GithubFragment
import java.lang.IllegalArgumentException

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        val fragmentType = intent.getIntExtra(FRAGMENT_TYPE, 0)
        initFragment(fragmentType)
    }

    private fun initFragment(fragmentType : Int){
        val fragment = when(fragmentType){
            0 -> GithubFragment()
            else -> throw IllegalArgumentException("not defined fragment")
        }
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainerView, fragment)
            .commit()
    }
}