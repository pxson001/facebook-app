package com.facebook.api.story;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.api.ufiservices.common.CommentOrderType;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.fbservice.service.DataFreshnessParam;
import javax.annotation.Nullable;

/* compiled from: android_place_picker_context_menu_report_duplicates */
public class FetchSingleStoryParams implements Parcelable {
    public static final Creator<FetchSingleStoryParams> CREATOR = new C09841();
    @Nullable
    public final String f10255a;
    @Nullable
    public final String f10256b;
    public final DataFreshnessParam f10257c;
    public final FetchType f10258d;
    public final int f10259e;
    public final CommentOrderType f10260f;
    @Nullable
    public final String f10261g;
    public final boolean f10262h;

    /* compiled from: android_place_picker_context_menu_report_duplicates */
    final class C09841 implements Creator<FetchSingleStoryParams> {
        C09841() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchSingleStoryParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchSingleStoryParams[i];
        }
    }

    /* compiled from: android_place_picker_context_menu_report_duplicates */
    public enum FetchType {
        GRAPHQL_DEFAULT,
        GRAPHQL_PHOTO_CREATION_STORY,
        GRAPHQL_VIDEO_CREATION_STORY,
        GRAPHQL_FEEDBACK_DETAILS,
        NOTIFICATION_FEEDBACK_DETAILS,
        PLATFORM_FEEDBACK_DETAILS,
        PLATFORM_DEFAULT
    }

    public FetchSingleStoryParams(String str, DataFreshnessParam dataFreshnessParam) {
        this(str, dataFreshnessParam, FetchType.GRAPHQL_DEFAULT, 0);
    }

    public FetchSingleStoryParams(String str, DataFreshnessParam dataFreshnessParam, FetchType fetchType, int i) {
        this(str, dataFreshnessParam, fetchType, i, null, CommentOrderType.DEFAULT_ORDER, null, false);
    }

    public FetchSingleStoryParams(@Nullable String str, DataFreshnessParam dataFreshnessParam, FetchType fetchType, int i, @Nullable String str2, CommentOrderType commentOrderType, @Nullable String str3, boolean z) {
        this.f10255a = str;
        this.f10257c = dataFreshnessParam;
        this.f10258d = fetchType;
        this.f10259e = i;
        this.f10256b = str2;
        this.f10260f = commentOrderType;
        this.f10261g = str3;
        this.f10262h = z;
    }

    public FetchSingleStoryParams(Parcel parcel) {
        this.f10255a = parcel.readString();
        this.f10257c = DataFreshnessParam.valueOf(parcel.readString());
        this.f10258d = FetchType.values()[parcel.readInt()];
        this.f10259e = parcel.readInt();
        this.f10256b = parcel.readString();
        this.f10260f = CommentOrderType.getOrder(parcel.readString());
        this.f10261g = parcel.readString();
        this.f10262h = ParcelUtil.m3827a(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f10255a);
        parcel.writeString(this.f10257c.toString());
        parcel.writeInt(this.f10258d.ordinal());
        parcel.writeInt(this.f10259e);
        parcel.writeString(this.f10256b);
        parcel.writeString(this.f10260f.toString());
        parcel.writeString(this.f10261g);
        ParcelUtil.m3826a(parcel, this.f10262h);
    }
}
