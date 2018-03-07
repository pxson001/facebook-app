package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: contentSize */
public class PostGameScoreParams implements Parcelable {
    public static final Creator<PostGameScoreParams> CREATOR = new C20431();
    public static String f17256a = "postGameScoreParams";
    public final ThreadKey f17257b;
    public final String f17258c;
    public final String f17259d;
    public final int f17260e;

    /* compiled from: contentSize */
    final class C20431 implements Creator<PostGameScoreParams> {
        C20431() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PostGameScoreParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new PostGameScoreParams[i];
        }
    }

    public PostGameScoreParams(PostGameScoreParamsBuilder postGameScoreParamsBuilder) {
        boolean z;
        if (postGameScoreParamsBuilder.f17261a == null && postGameScoreParamsBuilder.f17262b == null) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkState(z, "thread id/key/idRefQuery must be specified");
        this.f17257b = postGameScoreParamsBuilder.f17261a;
        this.f17258c = postGameScoreParamsBuilder.f17262b;
        this.f17259d = postGameScoreParamsBuilder.f17263c;
        this.f17260e = postGameScoreParamsBuilder.f17264d;
    }

    public PostGameScoreParams(Parcel parcel) {
        this.f17257b = (ThreadKey) parcel.readParcelable(ThreadKey.class.getClassLoader());
        this.f17258c = parcel.readString();
        this.f17259d = parcel.readString();
        this.f17260e = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f17257b, i);
        parcel.writeString(this.f17258c);
        parcel.writeString(this.f17259d);
        parcel.writeInt(this.f17260e);
    }
}
