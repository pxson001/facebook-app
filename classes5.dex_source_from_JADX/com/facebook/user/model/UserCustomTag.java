package com.facebook.user.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: comment_composer_session_ended */
public class UserCustomTag implements Parcelable {
    public static final Creator<UserCustomTag> CREATOR = new C05121();
    public final String f5518a;
    public final String f5519b;
    public final int f5520c;
    public final int f5521d;
    public final int f5522e;

    /* compiled from: comment_composer_session_ended */
    final class C05121 implements Creator<UserCustomTag> {
        C05121() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new UserCustomTag(parcel);
        }

        public final Object[] newArray(int i) {
            return new UserCustomTag[i];
        }
    }

    public UserCustomTag(String str, String str2, int i, int i2, int i3) {
        this.f5518a = str;
        this.f5519b = str2;
        this.f5520c = i;
        this.f5521d = i2;
        this.f5522e = i3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5518a);
        parcel.writeString(this.f5519b);
        parcel.writeInt(this.f5520c);
        parcel.writeInt(this.f5521d);
        parcel.writeInt(this.f5522e);
    }

    protected UserCustomTag(Parcel parcel) {
        this.f5518a = parcel.readString();
        this.f5519b = parcel.readString();
        this.f5520c = parcel.readInt();
        this.f5521d = parcel.readInt();
        this.f5522e = parcel.readInt();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UserCustomTag userCustomTag = (UserCustomTag) obj;
        if (Objects.equal(Integer.valueOf(this.f5520c), Integer.valueOf(userCustomTag.f5520c)) && Objects.equal(Integer.valueOf(this.f5521d), Integer.valueOf(userCustomTag.f5521d)) && Objects.equal(Integer.valueOf(this.f5522e), Integer.valueOf(userCustomTag.f5522e)) && Objects.equal(this.f5518a, userCustomTag.f5518a) && Objects.equal(this.f5519b, userCustomTag.f5519b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f5518a, this.f5519b, Integer.valueOf(this.f5520c), Integer.valueOf(this.f5521d), Integer.valueOf(this.f5522e)});
    }
}
