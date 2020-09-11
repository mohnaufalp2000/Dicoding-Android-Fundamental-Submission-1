package com.gopal.aplikasigithubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object{
        const val USER = "user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val userDetail = intent.getParcelableExtra<User>(USER)

        tv_detail_name.text = userDetail?.name
        tv_detail_location.text = userDetail?.location
        tv_detail_repo.text = userDetail?.repository
        tv_detail_company.text = userDetail?.company
        tv_detail_followers.text = userDetail?.followers
        tv_detail_following.text =  userDetail?.following

        Glide.with(this)
            .load(userDetail?.avatar)
            .into(iv_detail_avatar)

        val actionBar = supportActionBar
        actionBar!!.title = userDetail?.username
        actionBar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return super.onOptionsItemSelected(item)
    }

}