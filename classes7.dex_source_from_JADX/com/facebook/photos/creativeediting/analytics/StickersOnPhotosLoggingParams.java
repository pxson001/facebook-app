package com.facebook.photos.creativeediting.analytics;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: mUnreadCount */
public class StickersOnPhotosLoggingParams implements Parcelable {
    public static final Creator<StickersOnPhotosLoggingParams> CREATOR = new C07781();
    public boolean f9567a;
    public final List<String> f9568b = Lists.a();
    public final List<String> f9569c = Lists.a();
    public final List<String> f9570d = Lists.a();
    public int f9571e;
    public int f9572f;

    /* compiled from: mUnreadCount */
    final class C07781 implements Creator<StickersOnPhotosLoggingParams> {
        C07781() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new StickersOnPhotosLoggingParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new StickersOnPhotosLoggingParams[i];
        }
    }

    public StickersOnPhotosLoggingParams(Parcel parcel) {
        boolean z = true;
        this.f9571e = parcel.readInt();
        this.f9572f = parcel.readInt();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.f9567a = z;
        parcel.readStringList(this.f9568b);
        parcel.readStringList(this.f9569c);
        parcel.readStringList(this.f9570d);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f9571e);
        parcel.writeInt(this.f9572f);
        parcel.writeInt(this.f9567a ? 1 : 0);
        parcel.writeStringList(this.f9568b);
        parcel.writeStringList(this.f9569c);
        parcel.writeStringList(this.f9570d);
    }
}
