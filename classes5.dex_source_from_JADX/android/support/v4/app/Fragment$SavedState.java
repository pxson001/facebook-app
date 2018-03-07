package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: wilde_groups_tab */
public class Fragment$SavedState implements Parcelable {
    public static final Creator<Fragment$SavedState> CREATOR = new C00031();
    final Bundle f62a;

    /* compiled from: wilde_groups_tab */
    final class C00031 implements Creator<Fragment$SavedState> {
        C00031() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new Fragment$SavedState(parcel, null);
        }

        public final Object[] newArray(int i) {
            return new Fragment$SavedState[i];
        }
    }

    Fragment$SavedState(Bundle bundle) {
        this.f62a = bundle;
    }

    Fragment$SavedState(Parcel parcel, ClassLoader classLoader) {
        this.f62a = parcel.readBundle();
        if (classLoader != null && this.f62a != null) {
            this.f62a.setClassLoader(classLoader);
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.f62a);
    }
}
