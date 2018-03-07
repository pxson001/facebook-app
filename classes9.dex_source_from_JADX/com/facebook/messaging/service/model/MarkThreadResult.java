package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.google.common.base.Objects;

/* compiled from: content_search_result_resource_size */
public class MarkThreadResult implements Parcelable {
    public static final Creator<MarkThreadResult> CREATOR = new C20381();
    public final ThreadKey f17211a;

    /* compiled from: content_search_result_resource_size */
    final class C20381 implements Creator<MarkThreadResult> {
        C20381() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MarkThreadResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new MarkThreadResult[i];
        }
    }

    /* compiled from: content_search_result_resource_size */
    public class Builder {
        public ThreadKey f17210a;
    }

    public MarkThreadResult(Builder builder) {
        this.f17211a = builder.f17210a;
    }

    public MarkThreadResult(Parcel parcel) {
        this.f17211a = (ThreadKey) parcel.readParcelable(ThreadKey.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f17211a, i);
    }

    public String toString() {
        return Objects.toStringHelper(getClass()).add("threadKey", this.f17211a).toString();
    }
}
