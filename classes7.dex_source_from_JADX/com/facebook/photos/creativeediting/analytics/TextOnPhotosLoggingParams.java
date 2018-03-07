package com.facebook.photos.creativeediting.analytics;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: mTemplate */
public class TextOnPhotosLoggingParams implements Parcelable {
    public static final Creator<TextOnPhotosLoggingParams> CREATOR = new C07791();
    public boolean f9573a;
    public boolean f9574b;
    public final List<String> f9575c = Lists.a();
    public final List<String> f9576d = Lists.a();
    public final List<String> f9577e = Lists.a();
    public final List<String> f9578f = Lists.a();
    public int f9579g;
    public int f9580h;

    /* compiled from: mTemplate */
    final class C07791 implements Creator<TextOnPhotosLoggingParams> {
        C07791() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new TextOnPhotosLoggingParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new TextOnPhotosLoggingParams[i];
        }
    }

    public TextOnPhotosLoggingParams(Parcel parcel) {
        boolean z = true;
        this.f9579g = parcel.readInt();
        this.f9580h = parcel.readInt();
        this.f9573a = parcel.readInt() == 1;
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.f9574b = z;
        parcel.readStringList(this.f9577e);
        parcel.readStringList(this.f9575c);
        parcel.readStringList(this.f9576d);
        parcel.readStringList(this.f9578f);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeInt(this.f9579g);
        parcel.writeInt(this.f9580h);
        parcel.writeInt(this.f9573a ? 1 : 0);
        if (!this.f9574b) {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeStringList(this.f9577e);
        parcel.writeStringList(this.f9575c);
        parcel.writeStringList(this.f9576d);
        parcel.writeStringList(this.f9578f);
    }

    public final void m11497a() {
        this.f9579g++;
    }
}
