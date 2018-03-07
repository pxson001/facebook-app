package com.facebook.zero.sdk.request;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Objects;

@AutoGenJsonDeserializer
@JsonDeserialize(using = ZeroIndicatorDataDeserializer.class)
/* compiled from: com.facebook.analytics2.logger.USER_LOGOUT */
public class ZeroIndicatorData implements Parcelable {
    public static final Creator<ZeroIndicatorData> CREATOR = new C05421();
    @JsonProperty("action_title")
    private final String mActionTitle;
    @JsonProperty("action_url")
    private final String mActionUrl;
    @JsonProperty("content")
    private final String mContent;
    @JsonProperty("id")
    private final String mId;
    @JsonProperty("title")
    private final String mTitle;

    /* compiled from: com.facebook.analytics2.logger.USER_LOGOUT */
    final class C05421 implements Creator<ZeroIndicatorData> {
        C05421() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ZeroIndicatorData(parcel);
        }

        public final Object[] newArray(int i) {
            return new ZeroIndicatorData[i];
        }
    }

    public ZeroIndicatorData(Parcel parcel) {
        this.mId = parcel.readString();
        this.mTitle = parcel.readString();
        this.mContent = parcel.readString();
        this.mActionTitle = parcel.readString();
        this.mActionUrl = parcel.readString();
    }

    public ZeroIndicatorData(String str, String str2, String str3, String str4, String str5) {
        this.mId = str;
        this.mTitle = str2;
        this.mContent = str3;
        this.mActionTitle = str4;
        this.mActionUrl = str5;
    }

    public ZeroIndicatorData() {
        this(null, null, null, null, null);
    }

    public final String m10680a() {
        return this.mTitle;
    }

    public final String m10681b() {
        return this.mContent;
    }

    public final String m10682c() {
        return this.mActionTitle;
    }

    public final String m10683d() {
        return this.mActionUrl;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mId);
        parcel.writeString(this.mTitle);
        parcel.writeString(this.mContent);
        parcel.writeString(this.mActionTitle);
        parcel.writeString(this.mActionUrl);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ZeroIndicatorData)) {
            return false;
        }
        ZeroIndicatorData zeroIndicatorData = (ZeroIndicatorData) obj;
        if (this.mId.equals(zeroIndicatorData.mId) && this.mTitle.equals(zeroIndicatorData.mTitle) && this.mContent.equals(zeroIndicatorData.mContent) && this.mActionTitle.equals(zeroIndicatorData.mActionTitle) && this.mActionUrl.equals(zeroIndicatorData.mActionUrl)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.mTitle, this.mContent, this.mActionTitle, this.mActionUrl});
    }

    public String toString() {
        return Objects.toStringHelper(this).add("title", this.mTitle).add("content", this.mContent).add("actionTitle", this.mActionTitle).add("actionUrl", this.mActionUrl).toString();
    }
}
