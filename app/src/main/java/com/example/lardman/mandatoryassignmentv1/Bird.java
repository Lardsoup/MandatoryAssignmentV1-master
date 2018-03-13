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
}
/*public Book() {
    }

    public Book(int id, String author, String title, String publisher, double price) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    @Override
    public String toString() {
        return title;
    }*/