package com.facebook.heisman.intent;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: possible_subscription_levels */
public class ProfilePictureOverlayPivotIntentData implements Parcelable {
    public static final Creator<ProfilePictureOverlayPivotIntentData> CREATOR = new C05521();
    public final ProfilePictureOverlayCommonParams f6117a;
    @Nullable
    public final String f6118b;
    @Nullable
    public final String f6119c;

    /* compiled from: possible_subscription_levels */
    final class C05521 implements Creator<ProfilePictureOverlayPivotIntentData> {
        C05521() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ProfilePictureOverlayPivotIntentData(parcel);
        }

        public final Object[] newArray(int i) {
            return new ProfilePictureOverlayPivotIntentData[i];
        }
    }

    /* compiled from: possible_subscription_levels */
    public class Builder extends com.facebook.heisman.intent.ProfilePictureOverlayCommonParams.Builder<Builder> {
        @Nullable
        private String f6115a;
        @Nullable
        private String f6116b;

        public Builder(String str, String str2) {
            super(str, str2);
        }

        protected final /* synthetic */ com.facebook.heisman.intent.ProfilePictureOverlayCommonParams.Builder mo339b() {
            return this;
        }

        public final Builder m7910c(String str) {
            this.f6115a = str;
            return this;
        }

        public final Builder m7911d(@Nullable String str) {
            this.f6116b = str;
            return this;
        }

        public final ProfilePictureOverlayPivotIntentData m7908a() {
            ProfilePictureOverlayCommonParams c = m7898c();
            boolean z = (this.f6115a == null && this.f6116b == null) ? false : true;
            Preconditions.checkArgument(z, "Must have either an image overlay ID or a category ID");
            return new ProfilePictureOverlayPivotIntentData(c, this.f6115a, this.f6116b);
        }
    }

    public ProfilePictureOverlayPivotIntentData(ProfilePictureOverlayCommonParams profilePictureOverlayCommonParams, @Nullable String str, @Nullable String str2) {
        this.f6117a = profilePictureOverlayCommonParams;
        this.f6118b = str;
        this.f6119c = str2;
    }

    public ProfilePictureOverlayPivotIntentData(Parcel parcel) {
        this.f6117a = (ProfilePictureOverlayCommonParams) parcel.readParcelable(ProfilePictureOverlayCommonParams.class.getClassLoader());
        this.f6118b = parcel.readString();
        this.f6119c = parcel.readString();
    }

    public final String m7912a() {
        return this.f6117a.f6108a;
    }

    public final String m7913f() {
        return this.f6117a.f6109b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f6117a, i);
        parcel.writeString(this.f6118b);
        parcel.writeString(this.f6119c);
    }
}
