package com.facebook.megaphone.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.results.BaseResult;
import com.facebook.fbservice.results.DataFreshnessResult;
import javax.annotation.Nullable;

/* compiled from: fbid */
public class FetchMegaphoneLayoutResult extends BaseResult implements Parcelable {
    public static final Creator<FetchMegaphoneLayoutResult> CREATOR = new C05821();
    @Nullable
    public final String f11973a;
    @Nullable
    public final String f11974b;

    /* compiled from: fbid */
    final class C05821 implements Creator<FetchMegaphoneLayoutResult> {
        C05821() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchMegaphoneLayoutResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchMegaphoneLayoutResult[i];
        }
    }

    public FetchMegaphoneLayoutResult(DataFreshnessResult dataFreshnessResult, long j, @Nullable String str, @Nullable String str2) {
        super(dataFreshnessResult, j);
        this.f11973a = str;
        this.f11974b = str2;
    }

    public FetchMegaphoneLayoutResult(Parcel parcel) {
        super(parcel);
        this.f11973a = parcel.readString();
        this.f11974b = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f11973a);
        parcel.writeString(this.f11974b);
    }

    public int describeContents() {
        return 0;
    }
}
