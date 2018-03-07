package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;

/* compiled from: open_poll */
public abstract class ShareMedia implements ShareModel {
    public final Bundle f4595a;

    /* compiled from: open_poll */
    public abstract class Builder<M extends ShareMedia, B extends Builder> {
        public Bundle f4594a = new Bundle();

        public B mo117a(M m) {
            if (m == null) {
                return this;
            }
            this.f4594a.putAll(new Bundle(m.f4595a));
            return this;
        }
    }

    protected ShareMedia(Builder builder) {
        this.f4595a = new Bundle(builder.f4594a);
    }

    ShareMedia(Parcel parcel) {
        this.f4595a = parcel.readBundle();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.f4595a);
    }
}
