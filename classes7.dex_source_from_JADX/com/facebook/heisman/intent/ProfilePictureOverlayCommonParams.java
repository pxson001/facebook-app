package com.facebook.heisman.intent;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.productionprompts.logging.PromptAnalytics;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: postToNewsFeed */
public class ProfilePictureOverlayCommonParams implements Parcelable {
    public static final Creator<ProfilePictureOverlayCommonParams> CREATOR = new C05511();
    public final String f6108a;
    public final String f6109b;
    public final long f6110c;
    @Nullable
    public final String f6111d;
    @Nullable
    public final String f6112e;
    @Nullable
    public final PromptAnalytics f6113f;
    public final int f6114g;

    /* compiled from: postToNewsFeed */
    public abstract class Builder<T extends Builder> {
        private final String f6096a;
        private final String f6097b;
        private long f6098c = 0;
        @Nullable
        private String f6099d;
        @Nullable
        private String f6100e;
        @Nullable
        private PromptAnalytics f6101f;
        private int f6102g = 0;

        protected abstract T mo339b();

        public Builder(String str, String str2) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(str2);
            this.f6096a = str;
            this.f6097b = str2;
        }

        public final T m7893a(long j) {
            this.f6098c = j;
            return mo339b();
        }

        public final T m7895a(String str) {
            this.f6099d = str;
            return mo339b();
        }

        public final T m7897b(String str) {
            this.f6100e = str;
            return mo339b();
        }

        public final T m7894a(PromptAnalytics promptAnalytics) {
            this.f6101f = promptAnalytics;
            return mo339b();
        }

        public final T m7892a(int i) {
            this.f6102g = i;
            return mo339b();
        }

        protected final ProfilePictureOverlayCommonParams m7898c() {
            return new ProfilePictureOverlayCommonParams(this.f6096a, this.f6097b, this.f6098c, this.f6099d, this.f6100e, this.f6101f, this.f6102g);
        }
    }

    /* compiled from: postToNewsFeed */
    final class C05511 implements Creator<ProfilePictureOverlayCommonParams> {
        C05511() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ProfilePictureOverlayCommonParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new ProfilePictureOverlayCommonParams[i];
        }
    }

    public ProfilePictureOverlayCommonParams(String str, String str2, long j, @Nullable String str3, @Nullable String str4, @Nullable PromptAnalytics promptAnalytics, int i) {
        this.f6108a = str;
        this.f6109b = str2;
        this.f6110c = j;
        this.f6111d = str3;
        this.f6112e = str4;
        this.f6113f = promptAnalytics;
        this.f6114g = i;
    }

    public ProfilePictureOverlayCommonParams(Parcel parcel) {
        this.f6108a = parcel.readString();
        this.f6109b = parcel.readString();
        this.f6110c = parcel.readLong();
        this.f6111d = parcel.readString();
        this.f6112e = parcel.readString();
        this.f6113f = (PromptAnalytics) parcel.readParcelable(PromptAnalytics.class.getClassLoader());
        this.f6114g = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6108a);
        parcel.writeString(this.f6109b);
        parcel.writeLong(this.f6110c);
        parcel.writeString(this.f6111d);
        parcel.writeString(this.f6112e);
        parcel.writeParcelable(this.f6113f, i);
        parcel.writeInt(this.f6114g);
    }
}
