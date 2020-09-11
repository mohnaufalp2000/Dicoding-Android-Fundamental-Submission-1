package com.gopal.aplikasigithubuser

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView


class UserAdapter(private val context: Context) : BaseAdapter(){

    var userUserAdapter : ArrayList<User> = arrayListOf()

    inner class ViewHolder(itemView : View){
        val adapterName : TextView = itemView.findViewById(R.id.tv_name)
        val adapterUsername : TextView = itemView.findViewById(R.id.tv_username)
        val adapterImg : ImageView = itemView.findViewById(R.id.iv_img)
    }

    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        var itemViewView = view

        if (itemViewView==null) {
            itemViewView = LayoutInflater.from(context).inflate(R.layout.item_card_list, parent, false)
        }

        val viewHolder = ViewHolder(itemViewView as View)
        val user = getItem(position) as User
        val bind = user

        viewHolder.adapterName.text = bind.name
        viewHolder.adapterUsername.text = bind.username
        viewHolder.adapterImg.setImageResource(bind.avatar)


        return itemViewView
    }

    override fun getItem(position: Int): Any {
        return userUserAdapter[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return userUserAdapter.size
    }


}