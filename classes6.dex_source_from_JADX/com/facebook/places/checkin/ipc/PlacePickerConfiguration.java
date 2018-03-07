package com.facebook.places.checkin.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.model.ComposerLocation;
import com.facebook.ipc.composer.model.ComposerTaggedUser;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;

/* compiled from: free_internal_storage_bytes */
public class PlacePickerConfiguration implements Parcelable {
    public static final Creator<PlacePickerConfiguration> CREATOR = new C09361();
    @Nullable
    public final CheckinPlaceModel f14640a;
    @Nullable
    public final String f14641b;
    @Nullable
    public final ComposerConfiguration f14642c;
    @Nullable
    public final ComposerLocation f14643d;
    @Nullable
    public final String f14644e;
    public final boolean f14645f;
    public final boolean f14646g;
    public final boolean f14647h;
    public final boolean f14648i;
    @Nullable
    public final String f14649j;
    @Nullable
    public final String f14650k;
    @Nullable
    public final String f14651l;
    @Nullable
    public final MinutiaeObject f14652m;
    @Nullable
    public final ImmutableList<String> f14653n;
    @Nullable
    public final ComposerLocation f14654o;
    @Nullable
    public final SearchType f14655p;
    public final ImmutableList<ComposerTaggedUser> f14656q;
    public final ImmutableList<Long> f14657r;
    public final boolean f14658s;
    public final boolean f14659t;
    @Nullable
    public final String f14660u;
    public final boolean f14661v;
    public final boolean f14662w;
    public final boolean f14663x;
    @Nullable
    public final String f14664y;

    /* compiled from: free_internal_storage_bytes */
    final class C09361 implements Creator<PlacePickerConfiguration> {
        C09361() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PlacePickerConfiguration(parcel);
        }

        public final Object[] newArray(int i) {
            return new PlacePickerConfiguration[i];
        }
    }

    /* compiled from: free_internal_storage_bytes */
    public class Builder {
        @Nullable
        public CheckinPlaceModel f14615a;
        @Nullable
        public String f14616b;
        @Nullable
        public ComposerConfiguration f14617c;
        @Nullable
        public ComposerLocation f14618d;
        @Nullable
        public String f14619e;
        public boolean f14620f;
        public boolean f14621g;
        public boolean f14622h;
        public boolean f14623i;
        @Nullable
        public String f14624j;
        @Nullable
        public String f14625k;
        @Nullable
        public String f14626l;
        @Nullable
        public MinutiaeObject f14627m;
        @Nullable
        public ImmutableList<String> f14628n;
        @Nullable
        public ComposerLocation f14629o;
        @Nullable
        public SearchType f14630p;
        public ImmutableList<ComposerTaggedUser> f14631q = RegularImmutableList.a;
        public ImmutableList<Long> f14632r = RegularImmutableList.a;
        public boolean f14633s;
        public boolean f14634t;
        @Nullable
        public String f14635u;
        public boolean f14636v;
        public boolean f14637w;
        public boolean f14638x;
        @Nullable
        public String f14639y;

        public Builder(PlacePickerConfiguration placePickerConfiguration) {
            Preconditions.checkNotNull(placePickerConfiguration);
            if (placePickerConfiguration instanceof PlacePickerConfiguration) {
                placePickerConfiguration = placePickerConfiguration;
                this.f14615a = placePickerConfiguration.f14640a;
                this.f14616b = placePickerConfiguration.f14641b;
                this.f14617c = placePickerConfiguration.f14642c;
                this.f14618d = placePickerConfiguration.f14643d;
                this.f14619e = placePickerConfiguration.f14644e;
                this.f14620f = placePickerConfiguration.f14645f;
                this.f14621g = placePickerConfiguration.f14646g;
                this.f14622h = placePickerConfiguration.f14647h;
                this.f14623i = placePickerConfiguration.f14648i;
                this.f14624j = placePickerConfiguration.f14649j;
                this.f14625k = placePickerConfiguration.f14650k;
                this.f14626l = placePickerConfiguration.f14651l;
                this.f14627m = placePickerConfiguration.f14652m;
                this.f14628n = placePickerConfiguration.f14653n;
                this.f14629o = placePickerConfiguration.f14654o;
                this.f14630p = placePickerConfiguration.f14655p;
                this.f14631q = placePickerConfiguration.f14656q;
                this.f14632r = placePickerConfiguration.f14657r;
                this.f14633s = placePickerConfiguration.f14658s;
                this.f14634t = placePickerConfiguration.f14659t;
                this.f14635u = placePickerConfiguration.f14660u;
                this.f14636v = placePickerConfiguration.f14661v;
                this.f14637w = placePickerConfiguration.f14662w;
                this.f14638x = placePickerConfiguration.f14663x;
                this.f14639y = placePickerConfiguration.f14664y;
                return;
            }
            this.f14615a = placePickerConfiguration.f14640a;
            this.f14616b = placePickerConfiguration.f14641b;
            this.f14617c = placePickerConfiguration.f14642c;
            this.f14618d = placePickerConfiguration.f14643d;
            this.f14619e = placePickerConfiguration.f14644e;
            this.f14620f = placePickerConfiguration.f14645f;
            this.f14621g = placePickerConfiguration.f14646g;
            this.f14622h = placePickerConfiguration.f14647h;
            this.f14623i = placePickerConfiguration.f14648i;
            this.f14624j = placePickerConfiguration.f14649j;
            this.f14625k = placePickerConfiguration.f14650k;
            this.f14626l = placePickerConfiguration.f14651l;
            this.f14627m = placePickerConfiguration.f14652m;
            this.f14628n = placePickerConfiguration.f14653n;
            this.f14629o = placePickerConfiguration.f14654o;
            this.f14630p = placePickerConfiguration.f14655p;
            this.f14631q = placePickerConfiguration.f14656q;
            this.f14632r = placePickerConfiguration.f14657r;
            this.f14633s = placePickerConfiguration.f14658s;
            this.f14634t = placePickerConfiguration.f14659t;
            this.f14635u = placePickerConfiguration.f14660u;
            this.f14636v = placePickerConfiguration.f14661v;
            this.f14637w = placePickerConfiguration.f14662w;
            this.f14638x = placePickerConfiguration.f14663x;
            this.f14639y = placePickerConfiguration.f14664y;
        }

        public final PlacePickerConfiguration m22222a() {
            return new PlacePickerConfiguration(this);
        }
    }

    public PlacePickerConfiguration(Builder builder) {
        this.f14640a = builder.f14615a;
        this.f14641b = builder.f14616b;
        this.f14642c = builder.f14617c;
        this.f14643d = builder.f14618d;
        this.f14644e = builder.f14619e;
        this.f14645f = ((Boolean) Preconditions.checkNotNull(Boolean.valueOf(builder.f14620f))).booleanValue();
        this.f14646g = ((Boolean) Preconditions.checkNotNull(Boolean.valueOf(builder.f14621g))).booleanValue();
        this.f14647h = ((Boolean) Preconditions.checkNotNull(Boolean.valueOf(builder.f14622h))).booleanValue();
        this.f14648i = ((Boolean) Preconditions.checkNotNull(Boolean.valueOf(builder.f14623i))).booleanValue();
        this.f14649j = builder.f14624j;
        this.f14650k = builder.f14625k;
        this.f14651l = builder.f14626l;
        this.f14652m = builder.f14627m;
        this.f14653n = builder.f14628n;
        this.f14654o = builder.f14629o;
        this.f14655p = builder.f14630p;
        this.f14656q = (ImmutableList) Preconditions.checkNotNull(builder.f14631q);
        this.f14657r = (ImmutableList) Preconditions.checkNotNull(builder.f14632r);
        this.f14658s = ((Boolean) Preconditions.checkNotNull(Boolean.valueOf(builder.f14633s))).booleanValue();
        this.f14659t = ((Boolean) Preconditions.checkNotNull(Boolean.valueOf(builder.f14634t))).booleanValue();
        this.f14660u = builder.f14635u;
        this.f14661v = ((Boolean) Preconditions.checkNotNull(Boolean.valueOf(builder.f14636v))).booleanValue();
        this.f14662w = ((Boolean) Preconditions.checkNotNull(Boolean.valueOf(builder.f14637w))).booleanValue();
        this.f14663x = ((Boolean) Preconditions.checkNotNull(Boolean.valueOf(builder.f14638x))).booleanValue();
        this.f14664y = builder.f14639y;
    }

    public PlacePickerConfiguration(Parcel parcel) {
        boolean z;
        int i;
        boolean z2 = true;
        if (parcel.readInt() == 0) {
            this.f14640a = null;
        } else {
            this.f14640a = (CheckinPlaceModel) FlatBufferModelHelper.a(parcel);
        }
        if (parcel.readInt() == 0) {
            this.f14641b = null;
        } else {
            this.f14641b = parcel.readString();
        }
        if (parcel.readInt() == 0) {
            this.f14642c = null;
        } else {
            this.f14642c = (ComposerConfiguration) parcel.readParcelable(ComposerConfiguration.class.getClassLoader());
        }
        if (parcel.readInt() == 0) {
            this.f14643d = null;
        } else {
            this.f14643d = (ComposerLocation) parcel.readParcelable(ComposerLocation.class.getClassLoader());
        }
        if (parcel.readInt() == 0) {
            this.f14644e = null;
        } else {
            this.f14644e = parcel.readString();
        }
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f14645f = z;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f14646g = z;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f14647h = z;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f14648i = z;
        if (parcel.readInt() == 0) {
            this.f14649j = null;
        } else {
            this.f14649j = parcel.readString();
        }
        if (parcel.readInt() == 0) {
            this.f14650k = null;
        } else {
            this.f14650k = parcel.readString();
        }
        if (parcel.readInt() == 0) {
            this.f14651l = null;
        } else {
            this.f14651l = parcel.readString();
        }
        if (parcel.readInt() == 0) {
            this.f14652m = null;
        } else {
            this.f14652m = (MinutiaeObject) parcel.readParcelable(MinutiaeObject.class.getClassLoader());
        }
        if (parcel.readInt() == 0) {
            this.f14653n = null;
        } else {
            String[] strArr = new String[parcel.readInt()];
            for (i = 0; i < strArr.length; i++) {
                strArr[i] = parcel.readString();
            }
            this.f14653n = ImmutableList.copyOf(strArr);
        }
        if (parcel.readInt() == 0) {
            this.f14654o = null;
        } else {
            this.f14654o = (ComposerLocation) parcel.readParcelable(ComposerLocation.class.getClassLoader());
        }
        if (parcel.readInt() == 0) {
            this.f14655p = null;
        } else {
            this.f14655p = SearchType.valueOf(parcel.readString());
        }
        ComposerTaggedUser[] composerTaggedUserArr = new ComposerTaggedUser[parcel.readInt()];
        for (int i2 = 0; i2 < composerTaggedUserArr.length; i2++) {
            composerTaggedUserArr[i2] = (ComposerTaggedUser) parcel.readParcelable(ComposerTaggedUser.class.getClassLoader());
        }
        this.f14656q = ImmutableList.copyOf(composerTaggedUserArr);
        Long[] lArr = new Long[parcel.readInt()];
        for (i = 0; i < lArr.length; i++) {
            lArr[i] = Long.valueOf(parcel.readLong());
        }
        this.f14657r = ImmutableList.copyOf(lArr);
        this.f14658s = parcel.readInt() == 1;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f14659t = z;
        if (parcel.readInt() == 0) {
            this.f14660u = null;
        } else {
            this.f14660u = parcel.readString();
        }
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f14661v = z;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f14662w = z;
        if (parcel.readInt() != 1) {
            z2 = false;
        }
        this.f14663x = z2;
        if (parcel.readInt() == 0) {
            this.f14664y = null;
        } else {
            this.f14664y = parcel.readString();
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int size;
        int i3;
        if (this.f14640a == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            FlatBufferModelHelper.a(parcel, this.f14640a);
        }
        if (this.f14641b == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(this.f14641b);
        }
        if (this.f14642c == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeParcelable(this.f14642c, i);
        }
        if (this.f14643d == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeParcelable(this.f14643d, i);
        }
        if (this.f14644e == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(this.f14644e);
        }
        if (this.f14645f) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f14646g) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f14647h) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f14648i) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f14649j == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(this.f14649j);
        }
        if (this.f14650k == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(this.f14650k);
        }
        if (this.f14651l == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(this.f14651l);
        }
        if (this.f14652m == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeParcelable(this.f14652m, i);
        }
        if (this.f14653n == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(this.f14653n.size());
            size = this.f14653n.size();
            for (i3 = 0; i3 < size; i3++) {
                parcel.writeString((String) this.f14653n.get(i3));
            }
        }
        if (this.f14654o == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeParcelable(this.f14654o, i);
        }
        if (this.f14655p == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(this.f14655p.name());
        }
        parcel.writeInt(this.f14656q.size());
        size = this.f14656q.size();
        for (i3 = 0; i3 < size; i3++) {
            parcel.writeParcelable((ComposerTaggedUser) this.f14656q.get(i3), i);
        }
        parcel.writeInt(this.f14657r.size());
        size = this.f14657r.size();
        for (i3 = 0; i3 < size; i3++) {
            parcel.writeLong(((Long) this.f14657r.get(i3)).longValue());
        }
        parcel.writeInt(this.f14658s ? 1 : 0);
        if (this.f14659t) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f14660u == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(this.f14660u);
        }
        if (this.f14661v) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f14662w) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f14663x) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f14664y == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeString(this.f14664y);
    }

    public int describeContents() {
        return 0;
    }
}
