package com.facebook.ipc.feed;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.ipc.intent.FacebookOnlyIntentParams;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: TIMELINE */
public class PermalinkPlatformIdParams implements FacebookOnlyIntentParams {
    public static final Creator<PermalinkPlatformIdParams> CREATOR = new C13421();
    @Nonnull
    public final String f14035a;
    @Nullable
    public final String f14036b;

    /* compiled from: TIMELINE */
    final class C13421 implements Creator<PermalinkPlatformIdParams> {
        C13421() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PermalinkPlatformIdParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new PermalinkPlatformIdParams[i];
        }
    }

    public PermalinkPlatformIdParams(Parcel parcel) {
        this.f14035a = parcel.readString();
        this.f14036b = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f14035a);
        parcel.writeString(this.f14036b);
    }
}
