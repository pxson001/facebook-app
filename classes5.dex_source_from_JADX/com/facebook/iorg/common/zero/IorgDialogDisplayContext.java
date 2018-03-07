package com.facebook.iorg.common.zero;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: TOPIC_AUTOMOTIVE */
public enum IorgDialogDisplayContext implements Parcelable {
    IORG_APP,
    EXTERNAL_REQUEST,
    FROM_BACKGROUND;
    
    public static final Creator<IorgDialogDisplayContext> CREATOR = null;

    /* compiled from: TOPIC_AUTOMOTIVE */
    final class C13231 implements Creator<IorgDialogDisplayContext> {
        C13231() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return IorgDialogDisplayContext.values()[parcel.readInt()];
        }

        public final Object[] newArray(int i) {
            return new IorgDialogDisplayContext[i];
        }
    }

    static {
        CREATOR = new C13231();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(ordinal());
    }
}
