package com.moviematcher;

import android.os.Parcel;
import android.os.Parcelable;

public class RecommendedBy2 implements Parcelable {

    public String name;
    public String imageUrl;
    Boolean isFriend;

    public RecommendedBy2(String name, String imageUrl, Boolean isFriend) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.isFriend = isFriend;
    }


    protected RecommendedBy2(Parcel in) {
        name = in.readString();
        imageUrl = in.readString();
        byte tmpIsFriend = in.readByte();
        isFriend = tmpIsFriend == 0 ? null : tmpIsFriend == 1;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(imageUrl);
        dest.writeByte((byte) (isFriend == null ? 0 : isFriend ? 1 : 2));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<RecommendedBy2> CREATOR = new Creator<RecommendedBy2>() {
        @Override
        public RecommendedBy2 createFromParcel(Parcel in) {
            return new RecommendedBy2(in);
        }

        @Override
        public RecommendedBy2[] newArray(int size) {
            return new RecommendedBy2[size];
        }
    };
}
