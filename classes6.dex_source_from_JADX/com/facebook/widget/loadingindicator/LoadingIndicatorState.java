package com.facebook.widget.loadingindicator;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.widget.loadingindicator.LoadingIndicator.State;
import com.google.common.base.Preconditions;

/* compiled from: recipientFbId */
public class LoadingIndicatorState implements Parcelable {
    public static final Creator<LoadingIndicatorState> CREATOR = new C03671();
    public State f6109a;
    public String f6110b;
    public String f6111c;
    public int f6112d;

    /* compiled from: recipientFbId */
    final class C03671 implements Creator<LoadingIndicatorState> {
        C03671() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new LoadingIndicatorState(parcel);
        }

        public final Object[] newArray(int i) {
            return new LoadingIndicatorState[i];
        }
    }

    /* compiled from: recipientFbId */
    public class Builder {
        public State f6105a = State.LOAD_FINISHED;
        public String f6106b = null;
        public String f6107c = null;
        public int f6108d = 0;

        public final LoadingIndicatorState m8680a() {
            if (this.f6105a == State.ERROR) {
                Preconditions.checkNotNull(this.f6106b, "Error message cannot be null.");
            }
            return new LoadingIndicatorState(this);
        }
    }

    public LoadingIndicatorState(Parcel parcel) {
        this.f6109a = State.values()[parcel.readInt()];
        this.f6110b = parcel.readString();
        this.f6111c = parcel.readString();
        this.f6112d = parcel.readInt();
    }

    public LoadingIndicatorState(Builder builder) {
        this.f6109a = builder.f6105a;
        this.f6110b = builder.f6106b;
        this.f6111c = builder.f6107c;
        this.f6112d = builder.f6108d;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f6109a.ordinal());
        parcel.writeString(this.f6110b);
        parcel.writeString(this.f6111c);
        parcel.writeInt(this.f6112d);
    }

    public int describeContents() {
        return 0;
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}
