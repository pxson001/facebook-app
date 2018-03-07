package com.facebook.auth.viewercontext;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.infer.annotation.PrivacySource;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

@Immutable
/* compiled from: wifi */
public class ViewerContext implements Parcelable {
    public static final Creator<ViewerContext> CREATOR = new C00511();
    @PrivacySource
    @JsonProperty("auth_token")
    public final String mAuthToken;
    @JsonProperty("is_page_context")
    public final boolean mIsPageContext;
    @PrivacySource
    @JsonProperty("session_cookies_string")
    public final String mSessionCookiesString;
    @PrivacySource
    @JsonProperty("session_key")
    public final String mSessionKey;
    @PrivacySource
    @JsonProperty("session_secret")
    public final String mSessionSecret;
    @PrivacySource
    @JsonProperty("user_id")
    public final String mUserId;
    @PrivacySource
    @JsonProperty("username")
    public final String mUsername;

    /* compiled from: wifi */
    final class C00511 implements Creator<ViewerContext> {
        C00511() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ViewerContext(parcel);
        }

        public final Object[] newArray(int i) {
            return new ViewerContext[i];
        }
    }

    @NotThreadSafe
    /* compiled from: wifi */
    public class ViewerContextBuilder {
        public String f764a;
        public String f765b;
        public String f766c;
        public boolean f767d;
        public String f768e;
        public String f769f;
        public String f770g;

        ViewerContextBuilder() {
        }

        public final ViewerContext m1532h() {
            return new ViewerContext(this);
        }
    }

    private ViewerContext() {
        this.mUserId = null;
        this.mAuthToken = null;
        this.mSessionCookiesString = null;
        this.mIsPageContext = false;
        this.mSessionSecret = null;
        this.mSessionKey = null;
        this.mUsername = null;
    }

    public ViewerContext(ViewerContextBuilder viewerContextBuilder) {
        this.mUserId = (String) Preconditions.checkNotNull(viewerContextBuilder.f764a);
        this.mAuthToken = (String) Preconditions.checkNotNull(viewerContextBuilder.f765b);
        this.mSessionCookiesString = viewerContextBuilder.f766c;
        this.mIsPageContext = viewerContextBuilder.f767d;
        this.mSessionSecret = viewerContextBuilder.f768e;
        this.mSessionKey = viewerContextBuilder.f769f;
        this.mUsername = viewerContextBuilder.f770g;
    }

    public ViewerContext(Parcel parcel) {
        this.mUserId = parcel.readString();
        this.mAuthToken = parcel.readString();
        this.mSessionCookiesString = parcel.readString();
        this.mIsPageContext = ParcelUtil.a(parcel);
        this.mSessionSecret = parcel.readString();
        this.mSessionKey = parcel.readString();
        this.mUsername = parcel.readString();
    }

    public static ViewerContextBuilder newBuilder() {
        return new ViewerContextBuilder();
    }

    public final String m1525a() {
        return this.mUserId;
    }

    public final String m1526b() {
        return this.mAuthToken;
    }

    public final String m1527c() {
        return this.mSessionCookiesString;
    }

    public final boolean m1528d() {
        return this.mIsPageContext;
    }

    public final String m1529e() {
        return this.mSessionSecret;
    }

    public final String m1530f() {
        return this.mSessionKey;
    }

    public final String m1531g() {
        return this.mUsername;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mUserId);
        parcel.writeString(this.mAuthToken);
        parcel.writeString(this.mSessionCookiesString);
        ParcelUtil.a(parcel, this.mIsPageContext);
        parcel.writeString(this.mSessionSecret);
        parcel.writeString(this.mSessionKey);
        parcel.writeString(this.mUsername);
    }
}
