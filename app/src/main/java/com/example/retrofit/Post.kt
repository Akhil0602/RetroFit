package com.example.retrofit

import com.google.gson.annotations.SerializedName


class Post(userId: Int, text: String, id: Int, title: String)
{
    var userId: Int= userId

    @SerializedName("body")
    var text: String=text

    private var id: Int=id

    private var title: String=title

    fun getid(): Int
    {
        return id;
    }

    fun getuserid(): Int
    {
        return userId;
    }

    fun gettext(): String
    {
        return text;
    }

    fun gettitle(): String
    {
        return title;
    }
}