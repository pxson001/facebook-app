package com.facebook.share.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: media_set_display_activity_titlebard_label */
public class LinksPreviewParams implements Parcelable {
    public static final Creator<LinksPreviewParams> CREATOR = new C09291();
    public final String f8974a;
    public final String f8975b;
    public final String f8976c;
    public final ImmutableList<Size> f8977d;

    /* compiled from: media_set_display_activity_titlebard_label */
    final class C09291 implements Creator<LinksPreviewParams> {
        C09291() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new LinksPreviewParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new LinksPreviewParams[i];
        }
    }

    /* compiled from: media_set_display_activity_titlebard_label */
    public class Builder {
        public String f8970a;
        public String f8971b;
        public String f8972c;
        public final com.google.common.collect.ImmutableList.Builder<Size> f8973d = new com.google.common.collect.ImmutableList.Builder();

        public final LinksPreviewParams m10696a() {
            return new LinksPreviewParams(this);
        }
    }

    @AutoGenJsonSerializer
    @JsonSerialize(using = LinksPreviewParams_SizeSerializer.class)
    /* compiled from: media_set_display_activity_titlebard_label */
    class Size {
        @JsonProperty("height")
        public final int mHeight;
        @JsonProperty("width")
        public final int mWidth;
    }

    public LinksPreviewParams(Builder builder) {
        this.f8974a = builder.f8970a;
        this.f8975b = builder.f8971b;
        this.f8976c = builder.f8972c;
        this.f8977d = builder.f8973d.b();
    }

    public LinksPreviewParams(Parcel parcel) {
        this.f8974a = parcel.readString();
        this.f8975b = parcel.readString();
        this.f8976c = parcel.readString();
        Collection arrayList = new ArrayList();
        parcel.readList(arrayList, List.class.getClassLoader());
        this.f8977d = ImmutableList.copyOf(arrayList);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8974a);
        parcel.writeString(this.f8975b);
        parcel.writeString(this.f8976c);
        parcel.writeList(this.f8977d);
    }
}
