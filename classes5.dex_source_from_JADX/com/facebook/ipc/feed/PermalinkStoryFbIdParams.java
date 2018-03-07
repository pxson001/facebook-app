package com.facebook.ipc.feed;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.ipc.intent.FacebookOnlyIntentParams;
import com.google.common.base.Preconditions;
import javax.annotation.Nonnull;

/* compiled from: TIME */
public class PermalinkStoryFbIdParams implements FacebookOnlyIntentParams {
    public static final Creator<PermalinkStoryFbIdParams> CREATOR = new C13431();
    @Nonnull
    public final String f14037a;

    /* compiled from: TIME */
    final class C13431 implements Creator<PermalinkStoryFbIdParams> {
        C13431() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PermalinkStoryFbIdParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new PermalinkStoryFbIdParams[i];
        }
    }

    public PermalinkStoryFbIdParams(@Nonnull String str) {
        Preconditions.checkNotNull(str);
        this.f14037a = str;
    }

    public PermalinkStoryFbIdParams(Parcel parcel) {
        this.f14037a = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f14037a);
    }
}
