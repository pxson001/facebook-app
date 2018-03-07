package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: wilde_group_profile_upsell */
final class FragmentManagerState implements Parcelable {
    public static final Creator<FragmentManagerState> CREATOR = new C00041();
    FragmentState[] f75a;
    int[] f76b;
    BackStackState[] f77c;

    /* compiled from: wilde_group_profile_upsell */
    final class C00041 implements Creator<FragmentManagerState> {
        C00041() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }

        public final Object[] newArray(int i) {
            return new FragmentManagerState[i];
        }
    }

    public FragmentManagerState(Parcel parcel) {
        this.f75a = (FragmentState[]) parcel.createTypedArray(FragmentState.CREATOR);
        this.f76b = parcel.createIntArray();
        this.f77c = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.f75a, i);
        parcel.writeIntArray(this.f76b);
        parcel.writeTypedArray(this.f77c, i);
    }
}
