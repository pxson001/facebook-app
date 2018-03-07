package com.facebook.productionprompts.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = ProfilePictureOverlayDeserializer.class)
@Immutable
@JsonSerialize(using = ProfilePictureOverlaySerializer.class)
/* compiled from: startBannerColor */
public class ProfilePictureOverlay implements Parcelable {
    public static final Creator<ProfilePictureOverlay> CREATOR = new C02631();
    @JsonProperty("image_overlay_id")
    public final String mImageOverlayId;
    @JsonProperty("image_overlay_url")
    public final String mImageOverlayUrl;

    /* compiled from: startBannerColor */
    final class C02631 implements Creator<ProfilePictureOverlay> {
        C02631() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ProfilePictureOverlay(parcel);
        }

        public final Object[] newArray(int i) {
            return new ProfilePictureOverlay[i];
        }
    }

    public static ProfilePictureOverlay m6332a(String str, String str2) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str2);
        return new ProfilePictureOverlay(str, str2);
    }

    private ProfilePictureOverlay() {
        this.mImageOverlayId = null;
        this.mImageOverlayUrl = null;
    }

    private ProfilePictureOverlay(String str, String str2) {
        this.mImageOverlayId = str;
        this.mImageOverlayUrl = str2;
    }

    public ProfilePictureOverlay(Parcel parcel) {
        this.mImageOverlayId = parcel.readString();
        this.mImageOverlayUrl = parcel.readString();
    }

    public final String m6333a() {
        return this.mImageOverlayId;
    }

    public final String m6334b() {
        return this.mImageOverlayUrl;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mImageOverlayId);
        parcel.writeString(this.mImageOverlayUrl);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfilePictureOverlay)) {
            return false;
        }
        ProfilePictureOverlay profilePictureOverlay = (ProfilePictureOverlay) obj;
        if (Objects.equal(this.mImageOverlayId, profilePictureOverlay.mImageOverlayId) && Objects.equal(this.mImageOverlayUrl, profilePictureOverlay.mImageOverlayUrl)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.mImageOverlayId, this.mImageOverlayUrl});
    }
}
