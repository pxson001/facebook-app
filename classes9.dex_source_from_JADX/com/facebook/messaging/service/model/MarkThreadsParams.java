package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Iterator;

/* compiled from: content_search_result */
public class MarkThreadsParams implements Parcelable {
    public static final Creator<MarkThreadsParams> CREATOR = new C20391();
    public final Mark f17215a;
    public final boolean f17216b;
    public final ImmutableList<MarkThreadFields> f17217c;
    public final ImmutableList<ThreadKey> f17218d;

    /* compiled from: content_search_result */
    final class C20391 implements Creator<MarkThreadsParams> {
        C20391() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MarkThreadsParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new MarkThreadsParams[i];
        }
    }

    /* compiled from: content_search_result */
    public class MarkThreadsParamsBuilder {
        public Mark f17212a;
        public boolean f17213b = true;
        public final Builder<MarkThreadFields> f17214c = ImmutableList.builder();

        public final MarkThreadsParamsBuilder m17153a(MarkThreadFields markThreadFields) {
            this.f17214c.c(markThreadFields);
            return this;
        }

        public final MarkThreadsParams m17154a() {
            return new MarkThreadsParams(this);
        }
    }

    public MarkThreadsParams(MarkThreadsParamsBuilder markThreadsParamsBuilder) {
        this.f17215a = markThreadsParamsBuilder.f17212a;
        this.f17216b = markThreadsParamsBuilder.f17213b;
        this.f17217c = markThreadsParamsBuilder.f17214c.b();
        Builder builder = ImmutableList.builder();
        Iterator it = this.f17217c.iterator();
        while (it.hasNext()) {
            builder.c(((MarkThreadFields) it.next()).f17204a);
        }
        this.f17218d = builder.b();
    }

    public MarkThreadsParams(Parcel parcel) {
        this.f17215a = Mark.valueOf(parcel.readString());
        this.f17216b = ParcelUtil.a(parcel);
        this.f17217c = ImmutableList.copyOf(parcel.readArrayList(MarkThreadFields.class.getClassLoader()));
        this.f17218d = ImmutableList.copyOf(parcel.readArrayList(ThreadKey.class.getClassLoader()));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f17215a.name());
        ParcelUtil.a(parcel, this.f17216b);
        parcel.writeTypedList(this.f17217c);
        parcel.writeTypedList(this.f17218d);
    }
}
