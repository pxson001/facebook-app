package com.facebook.graphql.model.extras;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.Iterator;
import javax.annotation.Nullable;

/* compiled from: home_stories_media */
public abstract class BaseExtra implements Parcelable, Flattenable {
    private boolean f20933a = false;

    protected BaseExtra() {
    }

    protected BaseExtra(byte b) {
    }

    public final boolean m28655a() {
        return this.f20933a;
    }

    public final void m28656b() {
        this.f20933a = false;
    }

    public int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        return 0;
    }

    public void mo1412a(MutableFlatBuffer mutableFlatBuffer, int i) {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
    }

    protected static <T> ImmutableList<T> m28652a(@Nullable Iterator<T> it) {
        return it != null ? ImmutableList.copyOf((Iterator) it) : RegularImmutableList.f535a;
    }

    public final void m28657c() {
        this.f20933a = true;
    }
}
