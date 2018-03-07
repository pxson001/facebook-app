package com.facebook.photos.photoset.ui.photoset;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: click_report_url */
public class PandoraCustomizedBackgroundConfig implements Parcelable {
    public static final Creator<PandoraCustomizedBackgroundConfig> CREATOR = new C19331();
    public final int f17925a;
    public final int f17926b;

    /* compiled from: click_report_url */
    final class C19331 implements Creator<PandoraCustomizedBackgroundConfig> {
        C19331() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PandoraCustomizedBackgroundConfig(parcel);
        }

        public final Object[] newArray(int i) {
            return new PandoraCustomizedBackgroundConfig[i];
        }
    }

    public PandoraCustomizedBackgroundConfig(int i, int i2) {
        this.f17925a = i;
        this.f17926b = i2;
    }

    public PandoraCustomizedBackgroundConfig(Parcel parcel) {
        this.f17925a = parcel.readInt();
        this.f17926b = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f17925a);
        parcel.writeInt(this.f17926b);
    }
}
