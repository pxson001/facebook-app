package com.facebook.backgroundlocation.settings.write;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: crowdsourced_field */
public class BackgroundLocationUpdateSettingsParams implements Parcelable {
    public static final Creator<BackgroundLocationUpdateSettingsParams> CREATOR = new C13111();
    public final Optional<Boolean> f16526a;
    public final Optional<String> f16527b;

    /* compiled from: crowdsourced_field */
    final class C13111 implements Creator<BackgroundLocationUpdateSettingsParams> {
        C13111() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new BackgroundLocationUpdateSettingsParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new BackgroundLocationUpdateSettingsParams[i];
        }
    }

    public static BackgroundLocationUpdateSettingsParams m20594a(String str) {
        return new BackgroundLocationUpdateSettingsParams(Absent.INSTANCE, Optional.of(str));
    }

    public static BackgroundLocationUpdateSettingsParams m20595a(boolean z, String str) {
        return new BackgroundLocationUpdateSettingsParams(Optional.of(Boolean.valueOf(z)), Optional.of(str));
    }

    public BackgroundLocationUpdateSettingsParams(Optional<Boolean> optional, Optional<String> optional2) {
        this.f16526a = optional;
        this.f16527b = optional2;
    }

    public BackgroundLocationUpdateSettingsParams(Parcel parcel) {
        String readString = parcel.readString();
        if (readString == null) {
            this.f16526a = Absent.INSTANCE;
        } else {
            this.f16526a = Optional.of(Boolean.valueOf(Boolean.parseBoolean(readString)));
        }
        this.f16527b = Optional.fromNullable(parcel.readString());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f16526a.isPresent() ? ((Boolean) this.f16526a.get()).toString() : null);
        parcel.writeString((String) this.f16527b.orNull());
    }

    public int describeContents() {
        return 0;
    }
}
