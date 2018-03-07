package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: wilde_groups_tab */
public final class FragmentState implements Parcelable {
    public static final Creator<FragmentState> CREATOR = new C00051();
    public final String f82a;
    public final int f83b;
    public final int f84c;
    public final boolean f85d;
    public final int f86e;
    public final int f87f;
    public final String f88g;
    public final boolean f89h;
    public final boolean f90i;
    public final Bundle f91j;
    public Bundle f92k;
    public Fragment f93l;

    /* compiled from: wilde_groups_tab */
    final class C00051 implements Creator<FragmentState> {
        C00051() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        public final Object[] newArray(int i) {
            return new FragmentState[i];
        }
    }

    public FragmentState(Fragment fragment) {
        this.f82a = fragment.getClass().getName();
        this.f83b = fragment.p;
        this.f84c = fragment.q;
        this.f85d = fragment.z;
        this.f86e = fragment.H;
        this.f87f = fragment.I;
        this.f88g = fragment.J;
        this.f89h = fragment.M;
        this.f90i = fragment.L;
        this.f91j = fragment.s;
    }

    public FragmentState(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.f82a = parcel.readString();
        this.f83b = parcel.readInt();
        this.f84c = parcel.readInt();
        this.f85d = parcel.readInt() != 0;
        this.f86e = parcel.readInt();
        this.f87f = parcel.readInt();
        this.f88g = parcel.readString();
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f89h = z;
        if (parcel.readInt() == 0) {
            z2 = false;
        }
        this.f90i = z2;
        this.f91j = parcel.readBundle();
        this.f92k = parcel.readBundle();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.f82a);
        parcel.writeInt(this.f83b);
        parcel.writeInt(this.f84c);
        parcel.writeInt(this.f85d ? 1 : 0);
        parcel.writeInt(this.f86e);
        parcel.writeInt(this.f87f);
        parcel.writeString(this.f88g);
        if (this.f89h) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.f90i) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeBundle(this.f91j);
        parcel.writeBundle(this.f92k);
    }
}
