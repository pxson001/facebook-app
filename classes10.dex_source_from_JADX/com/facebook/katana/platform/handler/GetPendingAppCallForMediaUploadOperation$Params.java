package com.facebook.katana.platform.handler;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;

/* compiled from: trigger_data */
public class GetPendingAppCallForMediaUploadOperation$Params implements Parcelable {
    public static final Creator<GetPendingAppCallForMediaUploadOperation$Params> CREATOR = new C01991();
    private final String f1155a;
    private final boolean f1156b;

    /* compiled from: trigger_data */
    final class C01991 implements Creator<GetPendingAppCallForMediaUploadOperation$Params> {
        C01991() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GetPendingAppCallForMediaUploadOperation$Params(parcel);
        }

        public final Object[] newArray(int i) {
            return new GetPendingAppCallForMediaUploadOperation$Params[i];
        }
    }

    public GetPendingAppCallForMediaUploadOperation$Params(String str, boolean z) {
        this.f1155a = str;
        this.f1156b = z;
    }

    public GetPendingAppCallForMediaUploadOperation$Params(Parcel parcel) {
        this.f1155a = parcel.readString();
        this.f1156b = ParcelUtil.a(parcel);
    }

    public final String m1183a() {
        return this.f1155a;
    }

    public final boolean m1184b() {
        return this.f1156b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1155a);
        ParcelUtil.a(parcel, this.f1156b);
    }
}
