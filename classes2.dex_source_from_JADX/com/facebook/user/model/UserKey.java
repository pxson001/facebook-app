package com.facebook.user.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.user.model.User.Type;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.collect.Collections2;
import java.util.Collection;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@JsonDeserialize(using = UserKeyDeserializer.class)
@Immutable
/* compiled from: t_dr_batch */
public class UserKey implements Parcelable {
    public static final Creator<UserKey> CREATOR = new C02094();
    @JsonIgnore
    private String f3624a;
    @JsonProperty("id")
    @Nullable
    private final String id;
    @JsonProperty("type")
    private final Type type;

    /* compiled from: t_dr_batch */
    final class C02094 implements Creator<UserKey> {
        C02094() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new UserKey(parcel);
        }

        public final Object[] newArray(int i) {
            return new UserKey[i];
        }
    }

    private UserKey() {
        this.type = Type.FACEBOOK;
        this.id = null;
    }

    public UserKey(Type type, @Nullable String str) {
        this.type = type;
        this.id = str;
    }

    public UserKey(Parcel parcel) {
        this((Type) parcel.readSerializable(), parcel.readString());
    }

    public static UserKey m5860a(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split(":", 2);
        if (split.length == 2) {
            return new UserKey(Type.valueOf(split[0]), split[1]);
        }
        throw new IllegalArgumentException("Cannot parse user key: " + str);
    }

    public static UserKey m5859a(UserFbidIdentifier userFbidIdentifier) {
        return new UserKey(Type.FACEBOOK, userFbidIdentifier.mo765a());
    }

    public static Collection<UserKey> m5861a(Collection<String> collection) {
        return Collections2.m847a((Collection) collection, new 1());
    }

    public static UserKey m5862b(String str) {
        return new UserKey(Type.FACEBOOK, str);
    }

    public final Type m5866a() {
        return this.type;
    }

    @Nullable
    public final String m5867b() {
        return this.id;
    }

    private void m5865h() {
        if (this.f3624a == null && this.id != null) {
            this.f3624a = this.type + ":" + this.id;
        }
    }

    public final String m5868c() {
        m5865h();
        return this.f3624a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UserKey userKey = (UserKey) obj;
        if (!Objects.equal(this.id, userKey.id)) {
            return false;
        }
        if (this.type != userKey.type) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.id == null ? 0 : this.id.hashCode()) * 31) + this.type.hashCode();
    }

    public String toString() {
        return m5868c();
    }

    public final boolean m5869d() {
        return (this.type == null || this.id == null) ? false : true;
    }

    public final boolean m5870e() {
        return m5866a().isPhoneContact() || this.type == Type.EMAIL;
    }

    public static Collection<String> m5863b(Collection<UserKey> collection) {
        return Collections2.m847a((Collection) collection, new 2());
    }

    public static Collection<String> m5864c(Collection<UserKey> collection) {
        return Collections2.m847a((Collection) collection, new 3());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(this.type);
        parcel.writeString(this.id);
    }

    @Nullable
    public final String m5871f() {
        if (this.type == Type.ADDRESS_BOOK) {
            return this.id;
        }
        if (this.type != Type.PHONE_NUMBER) {
            return null;
        }
        String str = this.id;
        String str2 = null;
        if (!Strings.isNullOrEmpty(str)) {
            int indexOf = str.indexOf(58);
            if (indexOf > 0) {
                str2 = str.substring(0, indexOf);
            }
        }
        return str2;
    }

    @Nullable
    public final String m5872g() {
        if (this.type != Type.PHONE_NUMBER) {
            return null;
        }
        String str = this.id;
        String str2 = null;
        if (!Strings.isNullOrEmpty(str)) {
            int indexOf = str.indexOf(58);
            if (indexOf >= 0 && indexOf + 1 < str.length()) {
                str2 = str.substring(indexOf + 1);
            }
        }
        return str2;
    }
}
