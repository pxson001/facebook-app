package com.facebook.api.ufiservices.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.service.DataFreshnessParam;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: android_page_action_menu_suggest_edits */
public final class FetchSingleMediaParams implements Parcelable {
    public static final Creator<FetchSingleMediaParams> CREATOR = new C09931();
    public final String f10308a;
    public final int f10309b;
    public final FetchType f10310c;
    public final DataFreshnessParam f10311d;
    public final CommentOrderType f10312e;

    /* compiled from: android_page_action_menu_suggest_edits */
    final class C09931 implements Creator<FetchSingleMediaParams> {
        C09931() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchSingleMediaParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchSingleMediaParams[i];
        }
    }

    /* compiled from: android_page_action_menu_suggest_edits */
    public enum FetchType {
        COMPLETE,
        SIMPLE,
        SIMPLE_WITH_ATTRIBUTION
    }

    public FetchSingleMediaParams(String str, int i, FetchType fetchType, DataFreshnessParam dataFreshnessParam, CommentOrderType commentOrderType) {
        this.f10308a = str;
        this.f10309b = i;
        this.f10310c = fetchType;
        this.f10311d = dataFreshnessParam;
        this.f10312e = commentOrderType;
    }

    public FetchSingleMediaParams(Parcel parcel) {
        this.f10308a = parcel.readString();
        this.f10309b = parcel.readInt();
        this.f10310c = FetchType.values()[parcel.readInt()];
        this.f10311d = DataFreshnessParam.valueOf(parcel.readString());
        this.f10312e = CommentOrderType.getOrder(parcel.readString());
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f10308a);
        parcel.writeInt(this.f10309b);
        parcel.writeInt(this.f10310c.ordinal());
        parcel.writeString(this.f10311d.toString());
        parcel.writeString(this.f10312e.toString());
    }
}
