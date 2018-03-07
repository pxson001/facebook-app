package com.facebook.platform.server.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: fetch_reaction_attachments */
public class GetCanonicalProfileIdsMethod$Params implements Parcelable {
    public static final Creator<GetCanonicalProfileIdsMethod$Params> CREATOR = new C09881();
    public final ArrayList<String> f14939a;

    /* compiled from: fetch_reaction_attachments */
    final class C09881 implements Creator<GetCanonicalProfileIdsMethod$Params> {
        C09881() {
        }

        public final Object createFromParcel(Parcel parcel) {
            try {
                return new GetCanonicalProfileIdsMethod$Params(parcel);
            } catch (IOException e) {
                return null;
            }
        }

        public final Object[] newArray(int i) {
            return new GetCanonicalProfileIdsMethod$Params[i];
        }
    }

    public GetCanonicalProfileIdsMethod$Params(ArrayList<String> arrayList) {
        this.f14939a = arrayList;
    }

    public GetCanonicalProfileIdsMethod$Params(Parcel parcel) {
        this.f14939a = parcel.createStringArrayList();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(this.f14939a);
    }
}
