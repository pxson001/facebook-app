package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.threadkey.ThreadKey;

/* compiled from: content_source */
public class MarkThreadFields implements Parcelable {
    public static final Creator<MarkThreadFields> CREATOR = new C20371();
    public final ThreadKey f17204a;
    public final boolean f17205b;
    public final long f17206c;
    public final long f17207d;
    public final long f17208e;
    public final FolderName f17209f;

    /* compiled from: content_source */
    final class C20371 implements Creator<MarkThreadFields> {
        C20371() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MarkThreadFields(parcel);
        }

        public final Object[] newArray(int i) {
            return new MarkThreadFields[i];
        }
    }

    /* compiled from: content_source */
    public class MarkThreadFieldsBuilder {
        public ThreadKey f17198a;
        public boolean f17199b;
        public long f17200c;
        public long f17201d = -1;
        public long f17202e = -1;
        public FolderName f17203f;

        public final MarkThreadFields m17152a() {
            return new MarkThreadFields(this);
        }
    }

    public MarkThreadFields(MarkThreadFieldsBuilder markThreadFieldsBuilder) {
        this.f17204a = markThreadFieldsBuilder.f17198a;
        this.f17205b = markThreadFieldsBuilder.f17199b;
        this.f17206c = markThreadFieldsBuilder.f17200c;
        this.f17207d = markThreadFieldsBuilder.f17201d;
        this.f17208e = markThreadFieldsBuilder.f17202e;
        this.f17209f = markThreadFieldsBuilder.f17203f;
    }

    public MarkThreadFields(Parcel parcel) {
        this.f17204a = (ThreadKey) parcel.readParcelable(ThreadKey.class.getClassLoader());
        this.f17205b = ParcelUtil.a(parcel);
        this.f17206c = parcel.readLong();
        this.f17207d = parcel.readLong();
        this.f17208e = parcel.readLong();
        this.f17209f = FolderName.fromDbName(parcel.readString());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f17204a, i);
        ParcelUtil.a(parcel, this.f17205b);
        parcel.writeLong(this.f17206c);
        parcel.writeLong(this.f17207d);
        parcel.writeLong(this.f17208e);
        parcel.writeString(this.f17209f.dbName);
    }
}
