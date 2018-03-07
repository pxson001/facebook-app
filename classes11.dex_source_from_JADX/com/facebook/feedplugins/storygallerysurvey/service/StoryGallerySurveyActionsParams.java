package com.facebook.feedplugins.storygallerysurvey.service;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: birthday_cam_start_recording */
public class StoryGallerySurveyActionsParams implements Parcelable {
    public String f9531a;

    public StoryGallerySurveyActionsParams(String str) {
        this.f9531a = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f9531a);
    }

    public int describeContents() {
        return 0;
    }
}
