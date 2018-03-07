package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.BackStackRecord.Op;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

/* compiled from: withPrefix */
final class BackStackState implements Parcelable {
    public static final Creator<BackStackState> CREATOR = new C00021();
    final int[] f47a;
    final int f48b;
    final int f49c;
    final String f50d;
    final int f51e;
    final int f52f;
    final CharSequence f53g;
    final int f54h;
    final CharSequence f55i;
    final ArrayList<String> f56j;
    final ArrayList<String> f57k;

    /* compiled from: withPrefix */
    final class C00021 implements Creator<BackStackState> {
        C00021() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        public final Object[] newArray(int i) {
            return new BackStackState[i];
        }
    }

    public BackStackState(BackStackRecord backStackRecord) {
        int i = 0;
        for (Op op = backStackRecord.b; op != null; op = op.a) {
            if (op.i != null) {
                i += op.i.size();
            }
        }
        this.f47a = new int[(i + (backStackRecord.d * 7))];
        if (backStackRecord.k) {
            i = 0;
            for (Op op2 = backStackRecord.b; op2 != null; op2 = op2.a) {
                int i2 = i + 1;
                this.f47a[i] = op2.c;
                int i3 = i2 + 1;
                this.f47a[i2] = op2.d != null ? op2.d.p : -1;
                int i4 = i3 + 1;
                this.f47a[i3] = op2.e;
                i2 = i4 + 1;
                this.f47a[i4] = op2.f;
                i4 = i2 + 1;
                this.f47a[i2] = op2.g;
                i2 = i4 + 1;
                this.f47a[i4] = op2.h;
                if (op2.i != null) {
                    int size = op2.i.size();
                    i4 = i2 + 1;
                    this.f47a[i2] = size;
                    i2 = 0;
                    while (i2 < size) {
                        i3 = i4 + 1;
                        this.f47a[i4] = ((Fragment) op2.i.get(i2)).p;
                        i2++;
                        i4 = i3;
                    }
                    i = i4;
                } else {
                    i = i2 + 1;
                    this.f47a[i2] = 0;
                }
            }
            this.f48b = backStackRecord.i;
            this.f49c = backStackRecord.j;
            this.f50d = backStackRecord.m;
            this.f51e = backStackRecord.o;
            this.f52f = backStackRecord.p;
            this.f53g = backStackRecord.q;
            this.f54h = backStackRecord.r;
            this.f55i = backStackRecord.s;
            this.f56j = backStackRecord.t;
            this.f57k = backStackRecord.u;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public BackStackState(Parcel parcel) {
        this.f47a = parcel.createIntArray();
        this.f48b = parcel.readInt();
        this.f49c = parcel.readInt();
        this.f50d = parcel.readString();
        this.f51e = parcel.readInt();
        this.f52f = parcel.readInt();
        this.f53g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f54h = parcel.readInt();
        this.f55i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f56j = parcel.createStringArrayList();
        this.f57k = parcel.createStringArrayList();
    }

    public final BackStackRecord m62a(FragmentManagerImpl fragmentManagerImpl) {
        BackStackRecord backStackRecord = new BackStackRecord(fragmentManagerImpl);
        int i = 0;
        int i2 = 0;
        while (i2 < this.f47a.length) {
            Op op = new Op();
            int i3 = i2 + 1;
            op.c = this.f47a[i2];
            if (FragmentManagerImpl.a) {
                Log.v("FragmentManager", "Instantiate " + backStackRecord + " op #" + i + " base fragment #" + this.f47a[i3]);
            }
            int i4 = i3 + 1;
            i2 = this.f47a[i3];
            if (i2 >= 0) {
                op.d = (Fragment) fragmentManagerImpl.f.get(i2);
            } else {
                op.d = null;
            }
            i3 = i4 + 1;
            op.e = this.f47a[i4];
            i4 = i3 + 1;
            op.f = this.f47a[i3];
            i3 = i4 + 1;
            op.g = this.f47a[i4];
            int i5 = i3 + 1;
            op.h = this.f47a[i3];
            i4 = i5 + 1;
            int i6 = this.f47a[i5];
            if (i6 > 0) {
                op.i = new ArrayList(i6);
                i3 = 0;
                while (i3 < i6) {
                    if (FragmentManagerImpl.a) {
                        Log.v("FragmentManager", "Instantiate " + backStackRecord + " set remove fragment #" + this.f47a[i4]);
                    }
                    i5 = i4 + 1;
                    op.i.add((Fragment) fragmentManagerImpl.f.get(this.f47a[i4]));
                    i3++;
                    i4 = i5;
                }
            }
            backStackRecord.a(op);
            i++;
            i2 = i4;
        }
        backStackRecord.i = this.f48b;
        backStackRecord.j = this.f49c;
        backStackRecord.m = this.f50d;
        backStackRecord.o = this.f51e;
        backStackRecord.k = true;
        backStackRecord.p = this.f52f;
        backStackRecord.q = this.f53g;
        backStackRecord.r = this.f54h;
        backStackRecord.s = this.f55i;
        backStackRecord.t = this.f56j;
        backStackRecord.u = this.f57k;
        backStackRecord.b(1);
        return backStackRecord;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f47a);
        parcel.writeInt(this.f48b);
        parcel.writeInt(this.f49c);
        parcel.writeString(this.f50d);
        parcel.writeInt(this.f51e);
        parcel.writeInt(this.f52f);
        TextUtils.writeToParcel(this.f53g, parcel, 0);
        parcel.writeInt(this.f54h);
        TextUtils.writeToParcel(this.f55i, parcel, 0);
        parcel.writeStringList(this.f56j);
        parcel.writeStringList(this.f57k);
    }
}
