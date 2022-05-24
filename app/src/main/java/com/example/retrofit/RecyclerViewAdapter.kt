package com.example.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.Post
import com.example.retrofit.R

interface OnClickListener
{
    fun onRemove(context:Context)
    {
        /*arr.removeAt(id)
        cn.removeAt(id)*/
        Toast.makeText(context,"Clicked Name",Toast.LENGTH_SHORT).show()
    }
    fun onEdit()
}

class RecyclerViewAdapter(contex: Context,post: List<Post>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(),OnClickListener {


    var context: Context = contex
    var post: List<Post> =post

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.format, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var p= post?.elementAt(position)

        holder.Tci.text=p?.getid().toString()
        holder.Tui.text=p?.getuserid().toString()
        holder.Tname.text=p?.gettitle()
        holder.Ttext.text=p?.gettext()

    }


    override fun getItemCount(): Int {
        if(post.isEmpty() == true)
            return 0
        return post.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),View.OnClickListener {
        var Tci = itemView.findViewById<TextView>(R.id.cid)
        var Tname = itemView.findViewById<TextView>(R.id.title)
        var Tui = itemView.findViewById<TextView>(R.id.uid)
        var Ttext = itemView.findViewById<TextView>(R.id.text)


        override fun onClick(p0: View?) {

        }
    }

    override fun onEdit() {

    }


}

