package com.gopal.aplikasigithubuser

import android.content.Intent
import android.content.res.TypedArray
import android.os.Bundle
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var adapter: UserAdapter

    private lateinit var dataName: Array<String>
    private lateinit var dataUsername: Array<String>
    private lateinit var dataLocation: Array<String>
    private lateinit var dataRepository: Array<String>
    private lateinit var dataCompany: Array<String>
    private lateinit var dataFollowers: Array<String>
    private lateinit var dataFollowing: Array<String>
    private lateinit var dataAvatar: TypedArray


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = UserAdapter(this)
        lv_github.adapter = adapter

        getData()
        addList()

        lv_github.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            showSelected(position)
        }
    }

    private fun getData() {
        dataName = resources.getStringArray(R.array.name)
        dataUsername = resources.getStringArray(R.array.username)
        dataLocation = resources.getStringArray(R.array.location)
        dataRepository = resources.getStringArray(R.array.repository)
        dataCompany = resources.getStringArray(R.array.company)
        dataFollowers = resources.getStringArray(R.array.followers)
        dataFollowing = resources.getStringArray(R.array.following)
        dataAvatar = resources.obtainTypedArray(R.array.avatar)
    }

    private fun addList() {
        for (position in dataName.indices) {
            val user = User(
                name = dataName[position],
                username = dataUsername[position],
                location = dataLocation[position],
                repository = dataRepository[position],
                company = dataCompany[position],
                followers = dataFollowers[position],
                following = dataFollowing[position],
                avatar = dataAvatar.getResourceId(position, 0)
            )
            adapter.userUserAdapter.add(user)
        }
    }

    private fun showSelected(position : Int) {
        val intent = Intent(this@MainActivity, DetailActivity::class.java)
            intent.putExtra(DetailActivity.USER, adapter.userUserAdapter[position])
            startActivity(intent)
    }

}






