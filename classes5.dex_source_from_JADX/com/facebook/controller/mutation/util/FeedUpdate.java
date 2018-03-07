package com.facebook.controller.mutation.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.FeedUnit;
import com.google.common.collect.Lists;
import com.google.common.primitives.Longs;
import java.util.ArrayList;
import java.util.Comparator;

/* compiled from: accountName */
public class FeedUpdate implements Parcelable {
    public static final Creator<FeedUpdate> CREATOR = new C10981();
    public static final ArrayList<FeedUpdate> f11700a = Lists.a();
    public static final Comparator<FeedUpdate> f11701b = new StoryUpdateComparator();
    public final String f11702c;
    public final FeedUnit f11703d;

    /* compiled from: accountName */
    final class C10981 implements Creator<FeedUpdate> {
        C10981() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FeedUpdate(parcel);
        }

        public final Object[] newArray(int i) {
            return new FeedUpdate[i];
        }
    }

    /* compiled from: accountName */
    class StoryUpdateComparator implements Comparator<FeedUpdate> {
        public int compare(Object obj, Object obj2) {
            return Longs.a(((FeedUpdate) obj2).f11703d.T_(), ((FeedUpdate) obj).f11703d.T_());
        }
    }

    public FeedUpdate(String str, FeedUnit feedUnit) {
        this.f11702c = str;
        this.f11703d = feedUnit;
    }

    public FeedUpdate(Parcel parcel) {
        this.f11702c = parcel.readString();
        this.f11703d = (FeedUnit) FlatBufferModelHelper.m4278a(parcel);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (this.f11702c.equals(((FeedUpdate) obj).f11702c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f11702c.hashCode();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f11702c);
        FlatBufferModelHelper.m4288a(parcel, this.f11703d);
    }
}
