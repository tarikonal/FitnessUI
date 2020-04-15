package com.tarikonal.fitnessui;

import android.os.Parcel;
import android.os.Parcelable;

public class FitnessMove implements Parcelable {
    private String fitnessName;
    private String fitnessPicture;
    private String fitnessDescription;
    private int fitnessCalorie;

    public FitnessMove(String fitnessName, String fitnessPicture, String fitnessDescription, int fitnessCalorie) {
        this.fitnessName = fitnessName;
        this.fitnessPicture = fitnessPicture;
        this.fitnessDescription = fitnessDescription;
        this.fitnessCalorie = fitnessCalorie;
    }

    public String getFitnessName() {
        return fitnessName;
    }

    public String getFitnessPicture() {
        return fitnessPicture;
    }

    public String getFitnessDescription() {
        return fitnessDescription;
    }

    public int getFitnessCalorie() {
        return fitnessCalorie;
    }

    protected FitnessMove(Parcel in) {
        fitnessName = in.readString();
        fitnessDescription=in.readString();
        fitnessPicture=in.readString();
        fitnessCalorie = in.readInt();
    }

    public static final Creator<FitnessMove> CREATOR = new Creator<FitnessMove>() {
        @Override
        public FitnessMove createFromParcel(Parcel in) {
            return new FitnessMove(in);
        }

        @Override
        public FitnessMove[] newArray(int size) {
            return new FitnessMove[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(fitnessName );
        dest.writeString(fitnessDescription);
        dest.writeString(fitnessPicture);
        dest.writeInt(fitnessCalorie);
    }
}
