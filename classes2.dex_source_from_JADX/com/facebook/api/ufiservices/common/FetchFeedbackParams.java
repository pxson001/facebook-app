package com.facebook.api.ufiservices.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.fbservice.service.DataFreshnessParam;

/* compiled from: groups/addtogroups/%s?profile_name=%s */
public class FetchFeedbackParams implements Parcelable {
    public static final Creator<FetchFeedbackParams> CREATOR = new C08601();
    public final String f21632a;
    public final int f21633b;
    private final FetchType f21634c;
    public final DataFreshnessParam f21635d;
    public final CommentOrderType f21636e;
    public final boolean f21637f;
    public final boolean f21638g;
    public final String f21639h;
    public final boolean f21640i;

    /* compiled from: groups/addtogroups/%s?profile_name=%s */
    final class C08601 implements Creator<FetchFeedbackParams> {
        C08601() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchFeedbackParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchFeedbackParams[i];
        }
    }

    /* compiled from: groups/addtogroups/%s?profile_name=%s */
    public enum FetchType {
        COMPLETE,
        BASE
    }

    public FetchFeedbackParams(String str, int i, DataFreshnessParam dataFreshnessParam, CommentOrderType commentOrderType, String str2) {
        this(str, i, FetchType.COMPLETE, dataFreshnessParam, commentOrderType, str2, false, false, false);
    }

    public FetchFeedbackParams(String str, int i, DataFreshnessParam dataFreshnessParam, CommentOrderType commentOrderType, boolean z, String str2, boolean z2) {
        this(str, i, FetchType.COMPLETE, dataFreshnessParam, commentOrderType, str2, false, z2, z);
    }

    public FetchFeedbackParams(String str, int i, FetchType fetchType, DataFreshnessParam dataFreshnessParam, CommentOrderType commentOrderType, String str2, boolean z, boolean z2, boolean z3) {
        this.f21632a = str;
        this.f21633b = i;
        this.f21634c = fetchType;
        this.f21635d = dataFreshnessParam;
        this.f21636e = commentOrderType;
        this.f21639h = str2;
        this.f21638g = z;
        this.f21640i = z2;
        this.f21637f = z3;
    }

    protected FetchFeedbackParams(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.f21632a = parcel.readString();
        this.f21633b = parcel.readInt();
        this.f21634c = FetchType.values()[parcel.readInt()];
        this.f21635d = DataFreshnessParam.valueOf(parcel.readString());
        this.f21636e = CommentOrderType.getOrder(parcel.readString());
        this.f21637f = ParcelUtil.a(parcel);
        this.f21639h = parcel.readString();
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f21638g = z;
        if (parcel.readInt() != 1) {
            z2 = false;
        }
        this.f21640i = z2;
    }

    public final boolean m29344c() {
        return this.f21634c == FetchType.COMPLETE;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.f21632a);
        parcel.writeInt(this.f21633b);
        parcel.writeInt(this.f21634c.ordinal());
        parcel.writeString(this.f21635d.toString());
        parcel.writeString(this.f21636e.toString());
        ParcelUtil.a(parcel, this.f21637f);
        parcel.writeString(this.f21639h);
        if (this.f21638g) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.f21640i) {
            i3 = 0;
        }
        parcel.writeInt(i3);
    }

    public int describeContents() {
        return 0;
    }
}
