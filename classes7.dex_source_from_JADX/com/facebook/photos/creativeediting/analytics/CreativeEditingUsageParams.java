package com.facebook.photos.creativeediting.analytics;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.ipc.editgallery.EntryPoint;

/* compiled from: mVectorCount */
public class CreativeEditingUsageParams implements Parcelable {
    public static final Creator<CreativeEditingUsageParams> CREATOR = new C07761();
    public final boolean f9547a;
    public final boolean f9548b;
    public final boolean f9549c;
    public final int f9550d;
    public final int f9551e;
    public final int f9552f;
    public final int f9553g;
    public final int f9554h;
    public final int f9555i;
    public final int f9556j;
    public final int f9557k;
    public final int f9558l;
    public final int f9559m;
    public final String f9560n;
    public final EntryPoint f9561o;

    /* compiled from: mVectorCount */
    final class C07761 implements Creator<CreativeEditingUsageParams> {
        C07761() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new CreativeEditingUsageParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new CreativeEditingUsageParams[i];
        }
    }

    /* compiled from: mVectorCount */
    public class Builder {
        public boolean f9532a;
        public boolean f9533b;
        public boolean f9534c;
        public int f9535d;
        public int f9536e;
        public int f9537f;
        public int f9538g;
        public int f9539h;
        public int f9540i;
        public int f9541j;
        public int f9542k;
        public int f9543l;
        public int f9544m;
        public String f9545n;
        public EntryPoint f9546o;

        public Builder(CreativeEditingUsageParams creativeEditingUsageParams) {
            this.f9532a = creativeEditingUsageParams.f9547a;
            this.f9533b = creativeEditingUsageParams.f9548b;
            this.f9534c = creativeEditingUsageParams.f9549c;
            this.f9535d = creativeEditingUsageParams.f9550d;
            this.f9536e = creativeEditingUsageParams.f9551e;
            this.f9537f = creativeEditingUsageParams.f9552f;
            this.f9538g = creativeEditingUsageParams.f9553g;
            this.f9539h = creativeEditingUsageParams.f9554h;
            this.f9540i = creativeEditingUsageParams.f9555i;
            this.f9541j = creativeEditingUsageParams.f9556j;
            this.f9542k = creativeEditingUsageParams.f9557k;
            this.f9543l = creativeEditingUsageParams.f9558l;
            this.f9544m = creativeEditingUsageParams.f9559m;
            this.f9545n = creativeEditingUsageParams.f9560n;
            this.f9546o = creativeEditingUsageParams.f9561o;
        }

        public final CreativeEditingUsageParams m11494a() {
            return new CreativeEditingUsageParams(this);
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder m11495a(CreativeEditingUsageParams creativeEditingUsageParams) {
        return new Builder(creativeEditingUsageParams);
    }

    public CreativeEditingUsageParams(Builder builder) {
        this.f9547a = builder.f9532a;
        this.f9548b = builder.f9533b;
        this.f9549c = builder.f9534c;
        this.f9550d = builder.f9535d;
        this.f9551e = builder.f9536e;
        this.f9552f = builder.f9537f;
        this.f9553g = builder.f9538g;
        this.f9554h = builder.f9539h;
        this.f9555i = builder.f9540i;
        this.f9556j = builder.f9541j;
        this.f9557k = builder.f9542k;
        this.f9558l = builder.f9543l;
        this.f9559m = builder.f9544m;
        this.f9560n = builder.f9545n;
        this.f9561o = builder.f9546o;
    }

    public CreativeEditingUsageParams(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.f9550d = parcel.readInt();
        this.f9551e = parcel.readInt();
        this.f9552f = parcel.readInt();
        this.f9553g = parcel.readInt();
        this.f9554h = parcel.readInt();
        this.f9555i = parcel.readInt();
        this.f9556j = parcel.readInt();
        this.f9557k = parcel.readInt();
        this.f9558l = parcel.readInt();
        this.f9547a = parcel.readInt() == 1;
        this.f9560n = parcel.readString();
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f9548b = z;
        if (parcel.readInt() != 1) {
            z2 = false;
        }
        this.f9549c = z2;
        this.f9559m = parcel.readInt();
        this.f9561o = (EntryPoint) ParcelUtil.c(parcel, EntryPoint.class);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append("edit gallery entries:" + this.f9550d + ",");
        stringBuilder.append("crop entries:" + this.f9553g + ",");
        stringBuilder.append("isCropped:" + this.f9547a + ",");
        stringBuilder.append("isRotated:" + this.f9559m + ",");
        stringBuilder.append("text entries:" + this.f9552f + ",");
        stringBuilder.append("#texts:" + this.f9557k + ",");
        stringBuilder.append("#doodles: " + this.f9558l + ",");
        stringBuilder.append("sticker entries:" + this.f9551e + ",");
        stringBuilder.append("#stickers:" + this.f9556j + ",");
        stringBuilder.append("filter entries in gallery:" + this.f9554h + ",");
        stringBuilder.append("filter swipes:" + this.f9555i + ",");
        stringBuilder.append("filter name:" + this.f9560n + ",");
        stringBuilder.append("isDeleted:" + this.f9548b + ",");
        stringBuilder.append("isPublished:" + this.f9549c);
        stringBuilder.append("edit gallery entry point:" + this.f9561o + ",");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeInt(this.f9550d);
        parcel.writeInt(this.f9551e);
        parcel.writeInt(this.f9552f);
        parcel.writeInt(this.f9553g);
        parcel.writeInt(this.f9554h);
        parcel.writeInt(this.f9555i);
        parcel.writeInt(this.f9556j);
        parcel.writeInt(this.f9557k);
        parcel.writeInt(this.f9558l);
        parcel.writeInt(this.f9547a ? 1 : 0);
        parcel.writeString(this.f9560n);
        if (this.f9548b) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.f9549c) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeInt(this.f9559m);
        ParcelUtil.a(parcel, this.f9561o);
    }

    public final boolean m11496a() {
        return this.f9550d > 0 || this.f9553g > 0 || this.f9551e > 0 || this.f9552f > 0 || this.f9554h > 0 || this.f9555i > 0 || this.f9558l > 0;
    }
}
