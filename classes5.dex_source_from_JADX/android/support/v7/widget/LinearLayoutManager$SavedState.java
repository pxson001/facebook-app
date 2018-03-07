package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: trending_topic_name */
public class LinearLayoutManager$SavedState implements Parcelable {
    public static final Creator<LinearLayoutManager$SavedState> CREATOR = new C00671();
    int f1388a;
    public int f1389b;
    public boolean f1390c;

    /* compiled from: trending_topic_name */
    final class C00671 implements Creator<LinearLayoutManager$SavedState> {
        C00671() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new LinearLayoutManager$SavedState(parcel);
        }

        public final Object[] newArray(int i) {
            return new LinearLayoutManager$SavedState[i];
        }
    }

    LinearLayoutManager$SavedState(Parcel parcel) {
        boolean z = true;
        this.f1388a = parcel.readInt();
        this.f1389b = parcel.readInt();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.f1390c = z;
    }

    public LinearLayoutManager$SavedState(LinearLayoutManager$SavedState linearLayoutManager$SavedState) {
        this.f1388a = linearLayoutManager$SavedState.f1388a;
        this.f1389b = linearLayoutManager$SavedState.f1389b;
        this.f1390c = linearLayoutManager$SavedState.f1390c;
    }

    public final boolean m1931a() {
        return this.f1388a >= 0;
    }

    final void m1932b() {
        this.f1388a = -1;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f1388a);
        parcel.writeInt(this.f1389b);
        parcel.writeInt(this.f1390c ? 1 : 0);
    }
}
