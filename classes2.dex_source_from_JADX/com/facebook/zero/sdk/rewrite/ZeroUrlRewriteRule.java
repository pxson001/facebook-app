package com.facebook.zero.sdk.rewrite;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.json.Postprocessable;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Objects;
import java.util.regex.Pattern;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = ZeroUrlRewriteRuleDeserializer.class)
@Immutable
/* compiled from: foo */
public class ZeroUrlRewriteRule implements Parcelable, Postprocessable<ZeroUrlRewriteRule> {
    public static final Creator<ZeroUrlRewriteRule> CREATOR = new C09561();
    private Pattern f23501a;
    @JsonProperty("matcher")
    final String mMatcher;
    @JsonProperty("replacer")
    final String mReplacer;

    /* compiled from: foo */
    final class C09561 implements Creator<ZeroUrlRewriteRule> {
        C09561() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ZeroUrlRewriteRule(parcel);
        }

        public final Object[] newArray(int i) {
            return new ZeroUrlRewriteRule[i];
        }
    }

    public final /* synthetic */ Object mo78a() {
        return m31806d();
    }

    private ZeroUrlRewriteRule() {
        this.mMatcher = null;
        this.mReplacer = null;
    }

    public ZeroUrlRewriteRule(String str, String str2) {
        this.mMatcher = str;
        this.mReplacer = str2;
        m31806d();
    }

    public ZeroUrlRewriteRule(Parcel parcel) {
        this.mMatcher = parcel.readString();
        this.mReplacer = parcel.readString();
        this.f23501a = Pattern.compile(this.mMatcher);
    }

    private ZeroUrlRewriteRule m31806d() {
        if (this.mMatcher != null) {
            this.f23501a = Pattern.compile(this.mMatcher);
        }
        return this;
    }

    public final String m31809b() {
        return this.mMatcher;
    }

    public final String m31811c() {
        return this.mReplacer;
    }

    public final boolean m31808a(String str) {
        return this.f23501a.matcher(str).matches();
    }

    public final String m31810b(String str) {
        return this.f23501a.matcher(str).replaceFirst(this.mReplacer);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mMatcher);
        parcel.writeString(this.mReplacer);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ZeroUrlRewriteRule)) {
            return false;
        }
        return Objects.equal(this.mMatcher, ((ZeroUrlRewriteRule) obj).mMatcher) && Objects.equal(this.mReplacer, ((ZeroUrlRewriteRule) obj).mReplacer);
    }

    public int hashCode() {
        return Objects.hashCode(this.mMatcher, this.mReplacer);
    }

    public String toString() {
        return Objects.toStringHelper((Object) this).add("matcher", this.mMatcher).add("replacer", this.mReplacer).toString();
    }
}
