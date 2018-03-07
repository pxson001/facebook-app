package com.facebook.api.ufiservices.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: android_nearby_friends_self_view_unknown_region */
public class SetNotifyMeParams implements Parcelable {
    public static final Creator<SetNotifyMeParams> CREATOR = new C09941();
    public final String f10319a;
    public final String f10320b;
    public final String f10321c;
    public final String f10322d;
    public final boolean f10323e;
    public final String f10324f;

    /* compiled from: android_nearby_friends_self_view_unknown_region */
    final class C09941 implements Creator<SetNotifyMeParams> {
        C09941() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SetNotifyMeParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new SetNotifyMeParams[i];
        }
    }

    /* compiled from: android_nearby_friends_self_view_unknown_region */
    public class Builder {
        public String f10313a;
        public String f10314b;
        public String f10315c;
        public boolean f10316d;
        public String f10317e;
        public String f10318f;

        public Builder(SetNotifyMeParams setNotifyMeParams) {
            this.f10313a = setNotifyMeParams.f10320b;
            this.f10314b = setNotifyMeParams.f10319a;
            this.f10315c = setNotifyMeParams.f10321c;
            this.f10316d = setNotifyMeParams.f10323e;
            this.f10317e = setNotifyMeParams.f10322d;
            this.f10318f = setNotifyMeParams.f10324f;
        }

        public final Builder m18411a(boolean z) {
            this.f10316d = z;
            return this;
        }

        public final Builder m18412b(String str) {
            this.f10313a = str;
            return this;
        }

        public final Builder m18413c(String str) {
            this.f10314b = str;
            return this;
        }

        public final Builder m18414d(String str) {
            this.f10315c = str;
            return this;
        }

        public final Builder m18415e(String str) {
            this.f10318f = str;
            return this;
        }

        public final SetNotifyMeParams m18416g() {
            return new SetNotifyMeParams(this);
        }
    }

    public SetNotifyMeParams(Builder builder) {
        this.f10319a = builder.f10314b;
        this.f10320b = builder.f10313a;
        this.f10321c = builder.f10315c;
        this.f10323e = builder.f10316d;
        this.f10322d = builder.f10317e;
        this.f10324f = builder.f10318f;
    }

    public SetNotifyMeParams(Parcel parcel) {
        this.f10319a = parcel.readString();
        this.f10320b = parcel.readString();
        this.f10321c = parcel.readString();
        this.f10322d = parcel.readString();
        this.f10323e = ParcelUtil.m3827a(parcel);
        this.f10324f = parcel.readString();
    }

    public static Builder m18417f() {
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f10319a);
        parcel.writeString(this.f10320b);
        parcel.writeString(this.f10321c);
        parcel.writeString(this.f10322d);
        ParcelUtil.m3826a(parcel, this.f10323e);
        parcel.writeString(this.f10324f);
    }
}
