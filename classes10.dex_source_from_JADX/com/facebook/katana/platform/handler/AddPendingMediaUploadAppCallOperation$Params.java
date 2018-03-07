package com.facebook.katana.platform.handler;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.platform.common.action.PlatformAppCall;

/* compiled from: ttc */
public class AddPendingMediaUploadAppCallOperation$Params implements Parcelable {
    public static final Creator<AddPendingMediaUploadAppCallOperation$Params> CREATOR = new C01971();
    private final PlatformAppCall f1150a;
    private final String f1151b;

    /* compiled from: ttc */
    final class C01971 implements Creator<AddPendingMediaUploadAppCallOperation$Params> {
        C01971() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AddPendingMediaUploadAppCallOperation$Params(parcel);
        }

        public final Object[] newArray(int i) {
            return new AddPendingMediaUploadAppCallOperation$Params[i];
        }
    }

    public AddPendingMediaUploadAppCallOperation$Params(PlatformAppCall platformAppCall, String str) {
        this.f1150a = platformAppCall;
        this.f1151b = str;
    }

    public AddPendingMediaUploadAppCallOperation$Params(Parcel parcel) {
        this.f1150a = (PlatformAppCall) parcel.readParcelable(PlatformAppCall.class.getClassLoader());
        this.f1151b = parcel.readString();
    }

    public final PlatformAppCall m1181a() {
        return this.f1150a;
    }

    public final String m1182b() {
        return this.f1151b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f1150a, i);
        parcel.writeString(this.f1151b);
    }
}
