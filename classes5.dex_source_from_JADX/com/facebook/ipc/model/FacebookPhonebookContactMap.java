package com.facebook.ipc.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Map;

/* compiled from: TEXT_NO_CUSTOM_MEASURE */
public class FacebookPhonebookContactMap implements Parcelable {
    public static final Creator<FacebookPhonebookContactMap> CREATOR = new C13581();
    public final Map<Long, FacebookPhonebookContact> f14126a;

    /* compiled from: TEXT_NO_CUSTOM_MEASURE */
    final class C13581 implements Creator<FacebookPhonebookContactMap> {
        C13581() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FacebookPhonebookContactMap(parcel);
        }

        public final Object[] newArray(int i) {
            return new FacebookPhonebookContactMap[i];
        }
    }

    public FacebookPhonebookContactMap() {
        this.f14126a = null;
    }

    public FacebookPhonebookContactMap(Map<Long, FacebookPhonebookContact> map) {
        this.f14126a = map;
    }

    public FacebookPhonebookContactMap(Parcel parcel) {
        this.f14126a = parcel.readHashMap(FacebookPhonebookContact.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(this.f14126a);
    }
}
