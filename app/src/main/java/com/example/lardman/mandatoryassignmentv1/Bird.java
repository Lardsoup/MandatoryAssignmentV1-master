package com.example.lardman.mandatoryassignmentv1;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Lardman on 13-03-2018.
 */
//TODO: Lav bird class
public class Bird implements Serializable
{
    @SerializedName("Created")
    private String Created;
    @SerializedName("Id")
    private int Id;
    @SerializedName("NameDanish")
    private String NameDanish;
    @SerializedName("NameEnglish")
    private String NameEnglish;
    @SerializedName("PhotoUrl")
    private String PhotoUrl;
    @SerializedName("UserId")
    private String UserId;

    public Bird(int id, String created, String nameDanish, String nameEnglish, String photoUrl, String userId)
    {
        this.Id = id;
        this.Created = created;
        this.NameDanish = nameDanish;
        this.NameEnglish = nameEnglish;
        this.PhotoUrl = photoUrl;
        this.UserId = userId;
    }

    public void setId(int id)
    {
        this.Id = id;
    }

    public void setCreated(String created)
    {
        this.Created = created;
    }

    public void setNameDanish(String nameDanish)
    {
        this.NameDanish = nameDanish;
    }

    public void setNameEnglish(String nameEnglish)
    {
        this.NameEnglish = nameEnglish;
    }

    public void setPhotoUrl(String photoUrl)
    {
        this.PhotoUrl = photoUrl;
    }

    public void setUserId(String userId)
    {
        this.UserId = userId;
    }


    public int getId()
    {
        return Id;
    }

    public String getCreated()
    {
        return Created;
    }

    public String getNameDanish()
    {
        return NameDanish;
    }

    public String getNameEnglish()
    {
        return NameEnglish;
    }

    public String getPhotoUrl()
    {
        return PhotoUrl;
    }

    public String getUserId()
    {
        return UserId;
    }

    @Override
    public String toString()
    {
        return NameEnglish;
    }
}