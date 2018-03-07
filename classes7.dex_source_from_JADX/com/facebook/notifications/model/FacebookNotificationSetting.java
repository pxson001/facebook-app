package com.facebook.notifications.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Objects;

@AutoGenJsonDeserializer
@JsonDeserialize(using = FacebookNotificationSettingDeserializer.class)
/* compiled from: neko_log_flag */
public class FacebookNotificationSetting implements Parcelable {
    public static final Creator<FacebookNotificationSetting> CREATOR = new C06711();
    @JsonProperty("setting_id")
    public final String settingId;
    @JsonProperty("setting_value")
    public final String settingValue;

    /* compiled from: neko_log_flag */
    final class C06711 implements Creator<FacebookNotificationSetting> {
        C06711() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FacebookNotificationSetting(parcel);
        }

        public final Object[] newArray(int i) {
            return new FacebookNotificationSetting[i];
        }
    }

    private FacebookNotificationSetting() {
        this.settingId = null;
        this.settingValue = null;
    }

    public FacebookNotificationSetting(Parcel parcel) {
        this.settingId = parcel.readString();
        this.settingValue = parcel.readString();
    }

    public static FacebookNotificationSetting m9976a(JsonParser jsonParser) {
        return (FacebookNotificationSetting) jsonParser.a(FacebookNotificationSetting.class);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.settingId);
        parcel.writeString(this.settingValue);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FacebookNotificationSetting)) {
            return false;
        }
        FacebookNotificationSetting facebookNotificationSetting = (FacebookNotificationSetting) obj;
        if (Objects.equal(facebookNotificationSetting.settingId, this.settingId) && Objects.equal(facebookNotificationSetting.settingValue, this.settingValue)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.settingId, this.settingValue});
    }

    public String toString() {
        return Objects.toStringHelper(this).add("setting ID", this.settingId).add("setting value", this.settingValue).toString();
    }
}
