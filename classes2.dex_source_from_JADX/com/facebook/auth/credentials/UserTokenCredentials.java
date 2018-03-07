package com.facebook.auth.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.infer.annotation.PrivacySource;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: flex_fb4a_optout_tooltip */
public class UserTokenCredentials implements Parcelable {
    public static final Creator<UserTokenCredentials> CREATOR = new C09671();
    @PrivacySource
    public final String f23603a;
    @PrivacySource
    public final String f23604b;

    /* compiled from: flex_fb4a_optout_tooltip */
    final class C09671 implements Creator<UserTokenCredentials> {
        C09671() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new UserTokenCredentials(parcel.readString(), parcel.readString());
        }

        public final Object[] newArray(int i) {
            return new UserTokenCredentials[i];
        }
    }

    public UserTokenCredentials(String str, String str2) {
        this.f23603a = str;
        this.f23604b = str2;
    }

    public String toString() {
        return "UserTokenCredentials{userId='" + this.f23603a + "'}";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserTokenCredentials)) {
            return false;
        }
        UserTokenCredentials userTokenCredentials = (UserTokenCredentials) obj;
        if (!Objects.equal(this.f23603a, userTokenCredentials.f23603a)) {
            return false;
        }
        if (Objects.equal(this.f23604b, userTokenCredentials.f23604b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(this.f23603a, this.f23604b);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f23603a);
        parcel.writeString(this.f23604b);
    }
}
