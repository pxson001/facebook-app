package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.threadkey.ThreadKey;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: createLocalAdminMessageParams */
public class FetchIsThreadQueueEnabledParams implements Parcelable {
    public static final Creator<FetchIsThreadQueueEnabledParams> CREATOR = new C20111();
    public static String f17060a = "fetchIsThreadQueueEnabledParams";
    public final ThreadKey f17061b;

    /* compiled from: createLocalAdminMessageParams */
    final class C20111 implements Creator<FetchIsThreadQueueEnabledParams> {
        C20111() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchIsThreadQueueEnabledParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchIsThreadQueueEnabledParams[i];
        }
    }

    public FetchIsThreadQueueEnabledParams(ThreadKey threadKey) {
        this.f17061b = threadKey;
    }

    public FetchIsThreadQueueEnabledParams(Parcel parcel) {
        this.f17061b = (ThreadKey) parcel.readParcelable(ThreadKey.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f17061b, i);
    }
}
