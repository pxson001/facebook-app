package com.facebook.katana.platform.handler;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.Lists;
import java.util.ArrayList;

/* compiled from: triggered_from */
public class CopyPlatformAppContentToTempFileOperation$Params implements Parcelable {
    public static final Creator<CopyPlatformAppContentToTempFileOperation$Params> CREATOR = new C01981();
    public final String f1152a;
    public final ArrayList<String> f1153b;
    public final String f1154c;

    /* compiled from: triggered_from */
    final class C01981 implements Creator<CopyPlatformAppContentToTempFileOperation$Params> {
        C01981() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new CopyPlatformAppContentToTempFileOperation$Params(parcel);
        }

        public final Object[] newArray(int i) {
            return new CopyPlatformAppContentToTempFileOperation$Params[i];
        }
    }

    public CopyPlatformAppContentToTempFileOperation$Params(String str, ArrayList<String> arrayList, String str2) {
        this.f1152a = str;
        this.f1153b = arrayList;
        this.f1154c = str2;
    }

    public CopyPlatformAppContentToTempFileOperation$Params(Parcel parcel) {
        this.f1152a = parcel.readString();
        this.f1153b = Lists.a();
        parcel.readStringList(this.f1153b);
        this.f1154c = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1152a);
        parcel.writeStringList(this.f1153b);
        parcel.writeString(this.f1154c);
    }
}
