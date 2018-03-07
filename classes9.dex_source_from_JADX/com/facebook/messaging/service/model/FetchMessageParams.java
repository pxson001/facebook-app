package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: createGroupParams */
public class FetchMessageParams implements Parcelable {
    public static final Creator<FetchMessageParams> CREATOR = new C20131();
    public final String f17063a;
    public final ThreadKey f17064b;

    /* compiled from: createGroupParams */
    final class C20131 implements Creator<FetchMessageParams> {
        C20131() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchMessageParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchMessageParams[i];
        }
    }

    public FetchMessageParams(String str, ThreadKey threadKey) {
        this.f17063a = str;
        this.f17064b = threadKey;
    }

    public FetchMessageParams(Parcel parcel) {
        this.f17063a = parcel.readString();
        this.f17064b = (ThreadKey) parcel.readParcelable(ThreadKey.class.getClassLoader());
    }

    public String toString() {
        return Objects.toStringHelper(this).add("mid", this.f17063a).toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f17063a);
        parcel.writeParcelable(this.f17064b, i);
    }
}
