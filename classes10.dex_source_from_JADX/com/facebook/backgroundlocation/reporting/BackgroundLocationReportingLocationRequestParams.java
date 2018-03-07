package com.facebook.backgroundlocation.reporting;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.location.FbLocationOperationParams;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: dismissModalDialog */
public class BackgroundLocationReportingLocationRequestParams implements Parcelable {
    public static final Creator<BackgroundLocationReportingLocationRequestParams> CREATOR = new C20781();
    public final float f14888a;
    @Nullable
    public final String f14889b;
    public final FbLocationOperationParams f14890c;

    /* compiled from: dismissModalDialog */
    final class C20781 implements Creator<BackgroundLocationReportingLocationRequestParams> {
        C20781() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new BackgroundLocationReportingLocationRequestParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new BackgroundLocationReportingLocationRequestParams[i];
        }
    }

    public BackgroundLocationReportingLocationRequestParams(float f, @Nullable String str, FbLocationOperationParams fbLocationOperationParams) {
        this.f14888a = f;
        this.f14889b = str;
        this.f14890c = fbLocationOperationParams;
    }

    public BackgroundLocationReportingLocationRequestParams(Parcel parcel) {
        this.f14888a = parcel.readFloat();
        this.f14889b = parcel.readString();
        this.f14890c = (FbLocationOperationParams) parcel.readParcelable(FbLocationOperationParams.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.f14888a);
        parcel.writeString(this.f14889b);
        parcel.writeParcelable(this.f14890c, i);
    }

    public int describeContents() {
        return 0;
    }
}
