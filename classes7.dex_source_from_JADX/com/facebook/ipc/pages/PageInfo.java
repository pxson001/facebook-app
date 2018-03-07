package com.facebook.ipc.pages;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@AutoGenJsonDeserializer
/* compiled from: place_survey_thank_you_subtitle */
public class PageInfo implements Parcelable {
    public static final Creator<PageInfo> CREATOR = new C05561();
    public ProfilePermissions f6184a;
    @JsonProperty("access_token")
    public final String accessToken;
    @JsonProperty("page_id")
    public final long pageId;
    @JsonProperty("name")
    public final String pageName;
    @JsonProperty("page_url")
    public final String pageUrl;
    @JsonProperty("perms")
    public final List<String> permission;
    @JsonProperty("square_pic_url")
    public final String squareProfilePicUrl;

    /* compiled from: place_survey_thank_you_subtitle */
    final class C05561 implements Creator<PageInfo> {
        C05561() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PageInfo(parcel);
        }

        public final Object[] newArray(int i) {
            return new PageInfo[i];
        }
    }

    private PageInfo() {
        this.pageId = 0;
        this.pageName = null;
        this.accessToken = null;
        this.squareProfilePicUrl = null;
        this.permission = null;
        this.pageUrl = null;
    }

    public PageInfo(Parcel parcel) {
        this.pageId = parcel.readLong();
        this.pageName = parcel.readString();
        this.accessToken = parcel.readString();
        this.squareProfilePicUrl = parcel.readString();
        this.permission = parcel.readArrayList(String.class.getClassLoader());
        this.pageUrl = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.pageId);
        parcel.writeString(this.pageName);
        parcel.writeString(this.accessToken);
        parcel.writeString(this.squareProfilePicUrl);
        parcel.writeList(this.permission);
        parcel.writeString(this.pageUrl);
    }
}
