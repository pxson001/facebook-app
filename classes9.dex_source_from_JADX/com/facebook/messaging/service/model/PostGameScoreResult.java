package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: contentInset */
public class PostGameScoreResult implements Parcelable {
    public static final Creator<PostGameScoreResult> CREATOR = new C20441();
    public final boolean f17265a;

    /* compiled from: contentInset */
    final class C20441 implements Creator<PostGameScoreResult> {
        C20441() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PostGameScoreResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new PostGameScoreResult[i];
        }
    }

    public PostGameScoreResult(boolean z) {
        this.f17265a = z;
    }

    public PostGameScoreResult(Parcel parcel) {
        boolean z = true;
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.f17265a = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f17265a ? 1 : 0);
    }
}
