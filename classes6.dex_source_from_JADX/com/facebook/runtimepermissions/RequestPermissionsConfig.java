package com.facebook.runtimepermissions;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: setInitialRating */
public class RequestPermissionsConfig implements Parcelable {
    public static final Creator<RequestPermissionsConfig> CREATOR = new C02871();
    @Nullable
    public final String f4782a;
    @Nullable
    public final String f4783b;
    public final RationaleBehavior f4784c;
    public final boolean f4785d;

    /* compiled from: setInitialRating */
    final class C02871 implements Creator<RequestPermissionsConfig> {
        C02871() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new RequestPermissionsConfig(parcel);
        }

        public final Object[] newArray(int i) {
            return new RequestPermissionsConfig[i];
        }
    }

    /* compiled from: setInitialRating */
    public enum RationaleBehavior {
        NEVER_SHOW(false, false),
        ONLY_SHOW_FOR_SETTINGS(false, true),
        ALWAYS_SHOW(true, true);
        
        public final boolean shouldShowForDialogStep;
        public final boolean shouldShowForSettingsStep;

        private RationaleBehavior(boolean z, boolean z2) {
            this.shouldShowForDialogStep = z;
            this.shouldShowForSettingsStep = z2;
        }
    }

    public RequestPermissionsConfig(Parcel parcel) {
        this.f4782a = parcel.readString();
        this.f4783b = parcel.readString();
        this.f4784c = (RationaleBehavior) ParcelUtil.c(parcel, RationaleBehavior.class);
        this.f4785d = ParcelUtil.a(parcel);
    }

    RequestPermissionsConfig(RequestPermissionsConfigBuilder requestPermissionsConfigBuilder) {
        this.f4782a = requestPermissionsConfigBuilder.f4786a;
        this.f4783b = requestPermissionsConfigBuilder.f4787b;
        this.f4784c = requestPermissionsConfigBuilder.f4788c;
        this.f4785d = requestPermissionsConfigBuilder.f4789d;
        Preconditions.checkNotNull(this.f4784c);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4782a);
        parcel.writeString(this.f4783b);
        ParcelUtil.a(parcel, this.f4784c);
        ParcelUtil.a(parcel, this.f4785d);
    }
}
