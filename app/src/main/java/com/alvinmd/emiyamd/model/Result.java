package com.alvinmd.emiyamd.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result implements Parcelable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("anime_title")
    @Expose
    private String animeTitle;
    @SerializedName("anime_images")
    @Expose
    private String animeImages;
    @SerializedName("anime_description")
    @Expose
    private String animeDescription;

    public Result(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        animeTitle = in.readString();
        animeImages = in.readString();
        animeDescription = in.readString();
    }

    public static final Creator<Result> CREATOR = new Creator<Result>() {
        @Override
        public Result createFromParcel(Parcel in) {
            return new Result(in);
        }

        @Override
        public Result[] newArray(int size) {
            return new Result[size];
        }
    };

    public Result() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnimeTitle() {
        return animeTitle;
    }

    public void setAnimeTitle(String animeTitle) {
        this.animeTitle = animeTitle;
    }

    public String getAnimeImages() {
        return animeImages;
    }

    public void setAnimeImages(String animeImages) {
        this.animeImages = animeImages;
    }

    public String getAnimeDescription() {
        return animeDescription;
    }

    public void setAnimeDescription(String animeDescription) {
        this.animeDescription = animeDescription;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeString(animeTitle);
        dest.writeString(animeImages);
        dest.writeString(animeDescription);
    }
}
