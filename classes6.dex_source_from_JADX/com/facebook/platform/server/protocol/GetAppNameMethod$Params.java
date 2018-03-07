package com.facebook.platform.server.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.IOException;

/* compiled from: fetch_stories_about_page */
public class GetAppNameMethod$Params implements Parcelable {
    public static final Creator<GetAppNameMethod$Params> CREATOR = new C09851();
    public final String f14935a;

    /* compiled from: fetch_stories_about_page */
    final class C09851 implements Creator<GetAppNameMethod$Params> {
        C09851() {
        }

        public final Object createFromParcel(Parcel parcel) {
            try {
                return new GetAppNameMethod$Params(parcel);
            } catch (IOException e) {
                return null;
            }
        }

        public final Object[] newArray(int i) {
            return new GetAppNameMethod$Params[i];
        }
    }

    public GetAppNameMethod$Params(String str) {
        this.f14935a = str;
    }

    public GetAppNameMethod$Params(Parcel parcel) {
        this.f14935a = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f14935a);
    }
}
