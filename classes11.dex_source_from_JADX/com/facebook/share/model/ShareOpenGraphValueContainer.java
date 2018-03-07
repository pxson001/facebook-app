package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;

/* compiled from: open_grid_view */
public abstract class ShareOpenGraphValueContainer<P extends ShareOpenGraphValueContainer, E extends Builder> implements ShareModel {
    public final Bundle f4597a;

    /* compiled from: open_grid_view */
    public abstract class Builder<P extends ShareOpenGraphValueContainer, E extends Builder> {
        public Bundle f4596a = new Bundle();

        public E mo116a(P p) {
            if (p != null) {
                this.f4596a.putAll((Bundle) p.f4597a.clone());
            }
            return this;
        }
    }

    protected ShareOpenGraphValueContainer(Builder<P, E> builder) {
        this.f4597a = (Bundle) builder.f4596a.clone();
    }

    ShareOpenGraphValueContainer(Parcel parcel) {
        this.f4597a = parcel.readBundle(Builder.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.f4597a);
    }
}
