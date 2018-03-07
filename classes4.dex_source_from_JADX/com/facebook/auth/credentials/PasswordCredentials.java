package com.facebook.auth.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.infer.annotation.PrivacySource;
import javax.annotation.Nullable;

/* compiled from: translation_metadata */
public class PasswordCredentials implements LoginCredentials {
    public static final Creator<PasswordCredentials> CREATOR = new C00761();
    @PrivacySource
    public final String f775a;
    @PrivacySource
    public final String f776b;
    public final Type f777c;

    /* compiled from: translation_metadata */
    public enum Type {
        APP_REGISTRATION_LOGIN_NONCE("app_registration_login_nonce"),
        PASSWORD("password"),
        TRANSIENT_TOKEN("transient_token"),
        WORK_ACCOUNT_PASSWORD("work_account_password"),
        WORK_SSO_NONCE("work_sso_nonce"),
        WORK_USERNAME_WITH_PERSONAL_PASSWORD("personal_account_password_with_work_username"),
        WORK_REGISTRATION_AUTOLOGIN_NONCE("work_registration_autologin_nonce"),
        UNSET(null);
        
        @PrivacySource
        private final String mServerValue;

        private Type(String str) {
            this.mServerValue = str;
        }

        @Nullable
        public final String getServerValue() {
            return this.mServerValue;
        }
    }

    /* compiled from: translation_metadata */
    final class C00761 implements Creator<PasswordCredentials> {
        C00761() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PasswordCredentials(parcel);
        }

        public final Object[] newArray(int i) {
            return new PasswordCredentials[i];
        }
    }

    public PasswordCredentials(String str, String str2, Type type) {
        this.f775a = str;
        this.f776b = str2;
        this.f777c = type;
    }

    protected PasswordCredentials(Parcel parcel) {
        this.f775a = parcel.readString();
        this.f776b = parcel.readString();
        this.f777c = (Type) parcel.readSerializable();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f775a);
        parcel.writeString(this.f776b);
        parcel.writeSerializable(this.f777c);
    }
}
