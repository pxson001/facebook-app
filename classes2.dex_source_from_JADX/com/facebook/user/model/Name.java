package com.facebook.user.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.util.StringUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = NameDeserializer.class)
@Immutable
@JsonSerialize(using = NameSerializer.class)
/* compiled from: t_ec */
public class Name implements Parcelable {
    public static final Creator<Name> CREATOR = new C02061();
    @JsonIgnore
    private String f3570a;
    @JsonProperty("displayName")
    final String displayName;
    @JsonProperty("firstName")
    final String firstName;
    @JsonProperty("lastName")
    final String lastName;

    /* compiled from: t_ec */
    final class C02061 implements Creator<Name> {
        C02061() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new Name(parcel);
        }

        public final Object[] newArray(int i) {
            return new Name[i];
        }
    }

    private Name() {
        this.firstName = null;
        this.lastName = null;
        this.displayName = null;
    }

    public Name(@Nullable String str, @Nullable String str2) {
        this(str, str2, null);
    }

    public Name(String str) {
        this(null, null, str);
    }

    public Name(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.firstName = Strings.emptyToNull(str);
        this.lastName = Strings.emptyToNull(str2);
        this.displayName = Strings.emptyToNull(str3);
    }

    public Name(Parcel parcel) {
        this.firstName = parcel.readString();
        this.lastName = parcel.readString();
        this.displayName = parcel.readString();
    }

    public final String m5808a() {
        return this.firstName;
    }

    public final boolean m5809b() {
        return this.firstName != null;
    }

    public final String m5810c() {
        return this.lastName;
    }

    public final boolean m5811d() {
        return this.lastName != null;
    }

    public final boolean m5812e() {
        return (this.firstName == null || this.lastName == null) ? false : true;
    }

    @JsonIgnore
    public final String m5813f() {
        if (this.f3570a == null) {
            if (this.firstName != null && this.firstName.length() > 0 && this.lastName != null && this.lastName.length() > 0) {
                this.f3570a = this.firstName + " " + this.lastName;
            } else if (this.firstName != null && this.firstName.length() > 0) {
                this.f3570a = this.firstName;
            } else if (this.lastName == null || this.lastName.length() <= 0) {
                this.f3570a = "";
            } else {
                this.f3570a = this.lastName;
            }
        }
        return this.f3570a;
    }

    public final String m5814g() {
        return this.displayName;
    }

    public final boolean m5815h() {
        return this.displayName != null;
    }

    @JsonIgnore
    public final String m5816i() {
        return this.displayName != null ? this.displayName : m5813f();
    }

    @JsonIgnore
    public final String m5817j() {
        CharSequence a = m5808a();
        if (StringUtil.m3589a(a)) {
            return m5816i();
        }
        return a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Name name = (Name) obj;
        if (Objects.equal(this.displayName, name.displayName) && Objects.equal(this.firstName, name.firstName) && Objects.equal(this.lastName, name.lastName)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i = 0;
        if (this.firstName != null) {
            hashCode = this.firstName.hashCode();
        } else {
            hashCode = 0;
        }
        int i2 = hashCode * 31;
        if (this.lastName != null) {
            hashCode = this.lastName.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode = (hashCode + i2) * 31;
        if (this.displayName != null) {
            i = this.displayName.hashCode();
        }
        return hashCode + i;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.firstName);
        parcel.writeString(this.lastName);
        parcel.writeString(this.displayName);
    }

    public String toString() {
        return m5813f();
    }

    public static Name m5807k() {
        return new Name();
    }
}
