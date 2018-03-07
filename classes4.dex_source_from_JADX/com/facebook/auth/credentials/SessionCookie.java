package com.facebook.auth.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.infer.annotation.PrivacySource;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.instagram.common.json.annotation.JsonType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = SessionCookieDeserializer.class)
@JsonType
/* compiled from: first_option */
public class SessionCookie implements Parcelable {
    public static final Creator<SessionCookie> CREATOR = new C05611();
    @PrivacySource
    @JsonProperty("domain")
    public String mDomain;
    @PrivacySource
    @JsonProperty("expires")
    public String mExpires;
    @PrivacySource
    @JsonProperty("name")
    public String mName;
    @PrivacySource
    @JsonProperty("path")
    public String mPath;
    @JsonProperty("secure")
    public boolean mSecure;
    @PrivacySource
    @JsonProperty("value")
    public String mValue;

    /* compiled from: first_option */
    final class C05611 implements Creator<SessionCookie> {
        C05611() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SessionCookie(parcel);
        }

        public final Object[] newArray(int i) {
            return new SessionCookie[i];
        }
    }

    /* compiled from: first_option */
    public class CookieBuilder {
        final /* synthetic */ SessionCookie f11608a;
        public List<String> f11609b = new ArrayList();

        public CookieBuilder(SessionCookie sessionCookie) {
            this.f11608a = sessionCookie;
        }

        public final CookieBuilder m12113a(String str, String str2) {
            this.f11609b.add(str + "=" + str2);
            return this;
        }
    }

    SessionCookie() {
        this.mName = null;
        this.mValue = "";
        this.mExpires = null;
        this.mDomain = "";
        this.mSecure = false;
        this.mPath = "";
    }

    public SessionCookie(Parcel parcel) {
        this.mName = parcel.readString();
        this.mValue = parcel.readString();
        this.mExpires = parcel.readString();
        this.mDomain = parcel.readString();
        this.mSecure = parcel.readByte() != (byte) 0;
        this.mPath = parcel.readString();
    }

    public String toString() {
        if (this.mName == null) {
            return null;
        }
        CookieBuilder a = new CookieBuilder(this).m12113a(this.mName, this.mValue);
        if (this.mExpires != null) {
            a.m12113a("Expires", this.mExpires);
        }
        a.m12113a("Domain", this.mDomain).m12113a("Path", this.mPath);
        if (this.mSecure) {
            a.f11609b.add("secure");
        }
        return Joiner.on("; ").join(a.f11609b);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mName);
        parcel.writeString(this.mValue);
        parcel.writeString(this.mExpires);
        parcel.writeString(this.mDomain);
        parcel.writeByte((byte) (this.mSecure ? 1 : 0));
        parcel.writeString(this.mPath);
    }

    public static ImmutableList<SessionCookie> m12036a(ObjectMapper objectMapper, String str) {
        ImmutableList<SessionCookie> immutableList = null;
        if (str != null) {
            try {
                JsonParser a = objectMapper.b().a(str);
                if (a.c() == JsonToken.START_ARRAY) {
                    Builder builder = ImmutableList.builder();
                    while (a.c() != JsonToken.END_ARRAY) {
                        builder.c(SessionCookie__JsonHelper.m12038a(a));
                    }
                    immutableList = builder.b();
                }
            } catch (IOException e) {
            }
        }
        return immutableList;
    }

    public static String m12037b(ObjectMapper objectMapper, String str) {
        if (!Strings.isNullOrEmpty(str)) {
            ImmutableList a = m12036a(objectMapper, str);
            if (a != null) {
                StringBuilder stringBuilder = new StringBuilder();
                int size = a.size();
                for (int i = 0; i < size; i++) {
                    stringBuilder.append(((SessionCookie) a.get(i)).toString()).append(";");
                }
                return stringBuilder.toString();
            }
        }
        return null;
    }
}
