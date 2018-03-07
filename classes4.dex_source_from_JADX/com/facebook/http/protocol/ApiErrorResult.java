package com.facebook.http.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;
import javax.annotation.Nullable;

/* compiled from: inline_privacy_survey_serialization */
public class ApiErrorResult implements Parcelable, Serializable {
    public static final Creator<ApiErrorResult> CREATOR = new C04661();
    private final int mErrorCode;
    private final String mErrorData;
    private final ErrorDomain mErrorDomain;
    private final String mErrorMessage;
    public final int mErrorSubCode;
    @Nullable
    public final String mErrorUserMessage;
    @Nullable
    public final String mErrorUserTitle;
    public final boolean mIsTransient;
    public final String mJsonResponse;

    /* compiled from: inline_privacy_survey_serialization */
    final class C04661 implements Creator<ApiErrorResult> {
        C04661() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ApiErrorResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new ApiErrorResult[i];
        }
    }

    /* compiled from: inline_privacy_survey_serialization */
    public class Builder {
        public int f10316a;
        private int f10317b;
        public String f10318c;
        public String f10319d;
        @Nullable
        private String f10320e;
        @Nullable
        private String f10321f;
        @Nullable
        public String f10322g;
        private ErrorDomain f10323h = ErrorDomain.API_EC_DOMAIN;
        public boolean f10324i;

        public final Builder m10841b(int i) {
            this.f10317b = i;
            return this;
        }

        public final Builder m10842b(String str) {
            this.f10319d = str;
            return this;
        }

        public final Builder m10843c(@Nullable String str) {
            this.f10320e = str;
            return this;
        }

        public final Builder m10844d(@Nullable String str) {
            this.f10321f = str;
            return this;
        }

        public final Builder m10845e(String str) {
            this.f10322g = str;
            return this;
        }

        public final Builder m10838a(ErrorDomain errorDomain) {
            if (errorDomain == null) {
                throw new NullPointerException("errorDomain cannot be null");
            }
            this.f10323h = errorDomain;
            return this;
        }

        public final Builder m10839a(boolean z) {
            this.f10324i = z;
            return this;
        }

        public final ApiErrorResult m10840a() {
            return new ApiErrorResult(this.f10316a, this.f10317b, this.f10318c, this.f10319d, this.f10320e, this.f10321f, this.f10323h, this.f10322g, this.f10324i);
        }
    }

    /* compiled from: inline_privacy_survey_serialization */
    public enum ErrorDomain {
        API_EC_DOMAIN,
        GRAPHQL_KERROR_DOMAIN
    }

    protected ApiErrorResult(int i, int i2, String str, String str2, @Nullable String str3, @Nullable String str4, ErrorDomain errorDomain, @Nullable String str5, boolean z) {
        this.mErrorCode = i;
        this.mErrorSubCode = i2;
        this.mErrorMessage = str;
        this.mErrorData = str2;
        this.mErrorUserTitle = str3;
        this.mErrorUserMessage = str4;
        this.mErrorDomain = errorDomain;
        this.mJsonResponse = str5;
        this.mIsTransient = z;
    }

    protected ApiErrorResult(Parcel parcel) {
        this.mErrorCode = parcel.readInt();
        this.mErrorSubCode = parcel.readInt();
        this.mErrorMessage = parcel.readString();
        this.mErrorData = parcel.readString();
        this.mErrorUserTitle = parcel.readString();
        this.mErrorUserMessage = parcel.readString();
        this.mJsonResponse = parcel.readString();
        this.mErrorDomain = (ErrorDomain) Enum.valueOf(ErrorDomain.class, parcel.readString());
        boolean z = parcel.dataAvail() > 0 && parcel.readInt() == 1;
        this.mIsTransient = z;
    }

    public int m10832a() {
        return this.mErrorCode;
    }

    public final int m10833b() {
        return this.mErrorSubCode;
    }

    public String m10834c() {
        return this.mErrorMessage;
    }

    public String m10835d() {
        return this.mErrorData;
    }

    public final String m10836g() {
        return this.mJsonResponse;
    }

    public ErrorDomain m10837h() {
        return this.mErrorDomain;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mErrorCode);
        parcel.writeInt(this.mErrorSubCode);
        parcel.writeString(this.mErrorMessage);
        parcel.writeString(this.mErrorData);
        parcel.writeString(this.mErrorUserTitle);
        parcel.writeString(this.mErrorUserMessage);
        parcel.writeString(this.mJsonResponse);
        parcel.writeString(this.mErrorDomain.toString());
        parcel.writeInt(this.mIsTransient ? 1 : 0);
    }

    public static String m10831a(String str) {
        return str.replaceFirst("^\\(\\#\\d+\\)\\s", "");
    }

    public static Builder m10830a(int i, String str) {
        Builder builder = new Builder();
        builder.f10316a = i;
        builder = builder;
        builder.f10318c = str;
        return builder;
    }
}
