package com.facebook.platform.server.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: fetch_page_feed */
public class ResolveTaggableProfileIdsMethod$Params implements Parcelable {
    public static final Creator<ResolveTaggableProfileIdsMethod$Params> CREATOR = new C09901();
    public final List<String> f14940a;

    /* compiled from: fetch_page_feed */
    final class C09901 implements Creator<ResolveTaggableProfileIdsMethod$Params> {
        C09901() {
        }

        public final Object createFromParcel(Parcel parcel) {
            try {
                return new ResolveTaggableProfileIdsMethod$Params(parcel);
            } catch (IOException e) {
                return null;
            }
        }

        public final Object[] newArray(int i) {
            return new ResolveTaggableProfileIdsMethod$Params[i];
        }
    }

    public ResolveTaggableProfileIdsMethod$Params(ArrayList<String> arrayList) {
        this.f14940a = arrayList;
    }

    public ResolveTaggableProfileIdsMethod$Params(Parcel parcel) {
        this.f14940a = parcel.createStringArrayList();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(this.f14940a);
    }
}
