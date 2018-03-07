package com.facebook.facecast.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.model.ComposerSourceSurface;
import com.facebook.privacy.model.SelectablePrivacyData;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: broadcast_transition_reason */
public class FacecastCompositionData implements Parcelable {
    public static final Creator<FacecastCompositionData> CREATOR = new C15301();
    @Nullable
    public final String f18152a;
    @Nullable
    public final SelectablePrivacyData f18153b;
    @Nullable
    public final ComposerTargetData f18154c;
    @Nullable
    public final String f18155d;
    @Nullable
    public final String f18156e;
    @Nullable
    public final String f18157f;
    @Nullable
    public final String f18158g;
    @Nullable
    public final String f18159h;
    @Nullable
    public final ImmutableList<Long> f18160i;
    @Nullable
    public final ImmutableList<String> f18161j;
    @Nullable
    public final ComposerSourceSurface f18162k;
    public final boolean f18163l;
    public final boolean f18164m;

    /* compiled from: broadcast_transition_reason */
    final class C15301 implements Creator<FacecastCompositionData> {
        C15301() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FacecastCompositionData(parcel);
        }

        public final Object[] newArray(int i) {
            return new FacecastCompositionData[i];
        }
    }

    /* compiled from: broadcast_transition_reason */
    public class Builder {
        @Nullable
        public String f18139a;
        @Nullable
        public SelectablePrivacyData f18140b;
        @Nullable
        public ComposerTargetData f18141c;
        @Nullable
        public String f18142d;
        @Nullable
        public String f18143e;
        @Nullable
        public String f18144f;
        @Nullable
        public String f18145g;
        @Nullable
        public String f18146h;
        @Nullable
        public ImmutableList<Long> f18147i = RegularImmutableList.a;
        @Nullable
        public ImmutableList<String> f18148j = RegularImmutableList.a;
        @Nullable
        public ComposerSourceSurface f18149k;
        public boolean f18150l;
        public boolean f18151m;

        public Builder(FacecastCompositionData facecastCompositionData) {
            this.f18139a = facecastCompositionData.f18152a;
            this.f18140b = facecastCompositionData.f18153b;
            this.f18141c = facecastCompositionData.f18154c;
            this.f18142d = facecastCompositionData.f18155d;
            this.f18143e = facecastCompositionData.f18156e;
            this.f18144f = facecastCompositionData.f18157f;
            this.f18147i = facecastCompositionData.f18160i;
            this.f18148j = facecastCompositionData.f18161j;
            this.f18149k = facecastCompositionData.f18162k;
            this.f18150l = facecastCompositionData.f18163l;
            this.f18151m = facecastCompositionData.f18164m;
        }

        public final FacecastCompositionData m21945a() {
            return new FacecastCompositionData(this);
        }
    }

    private FacecastCompositionData() {
        this(new Builder());
    }

    public FacecastCompositionData(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.f18152a = parcel.readString();
        this.f18153b = (SelectablePrivacyData) parcel.readParcelable(SelectablePrivacyData.class.getClassLoader());
        this.f18154c = (ComposerTargetData) parcel.readParcelable(ComposerTargetData.class.getClassLoader());
        this.f18155d = parcel.readString();
        this.f18156e = parcel.readString();
        this.f18157f = parcel.readString();
        this.f18158g = parcel.readString();
        this.f18159h = parcel.readString();
        Iterable arrayList = new ArrayList();
        parcel.readList(arrayList, List.class.getClassLoader());
        this.f18160i = new com.google.common.collect.ImmutableList.Builder().b(arrayList).b();
        arrayList = new ArrayList();
        parcel.readList(arrayList, List.class.getClassLoader());
        this.f18161j = new com.google.common.collect.ImmutableList.Builder().b(arrayList).b();
        String readString = parcel.readString();
        this.f18162k = "".equals(readString) ? null : ComposerSourceSurface.valueOf(readString);
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f18163l = z;
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.f18164m = z2;
    }

    public FacecastCompositionData(Builder builder) {
        this.f18152a = builder.f18139a;
        this.f18153b = builder.f18140b;
        this.f18154c = builder.f18141c;
        this.f18155d = builder.f18142d;
        this.f18156e = builder.f18143e;
        this.f18157f = builder.f18144f;
        this.f18158g = builder.f18145g;
        this.f18159h = builder.f18146h;
        this.f18160i = builder.f18147i;
        this.f18161j = builder.f18148j;
        this.f18162k = builder.f18149k;
        this.f18163l = builder.f18150l;
        this.f18164m = builder.f18151m;
    }

    @Nullable
    public final ComposerTargetData m21946c() {
        return this.f18154c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.f18152a);
        parcel.writeParcelable(this.f18153b, 0);
        parcel.writeParcelable(this.f18154c, 0);
        parcel.writeString(this.f18155d);
        parcel.writeString(this.f18156e);
        parcel.writeString(this.f18157f);
        parcel.writeString(this.f18158g);
        parcel.writeString(this.f18159h);
        parcel.writeList(this.f18160i);
        parcel.writeList(this.f18161j);
        parcel.writeString(this.f18162k == null ? "" : this.f18162k.name());
        if (this.f18163l) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!this.f18164m) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
    }
}
