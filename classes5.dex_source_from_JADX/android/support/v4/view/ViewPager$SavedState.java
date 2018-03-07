package android.support.v4.view;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.view.View.BaseSavedState;

/* compiled from: video_bit_rate */
public class ViewPager$SavedState extends BaseSavedState {
    public static final Creator<ViewPager$SavedState> CREATOR = ParcelableCompat.m283a(new C00251());
    int f354a;
    Parcelable f355b;
    ClassLoader f356c;

    /* compiled from: video_bit_rate */
    final class C00251 implements ParcelableCompatCreatorCallbacks<ViewPager$SavedState> {
        C00251() {
        }

        public final Object mo72a(Parcel parcel, ClassLoader classLoader) {
            return new ViewPager$SavedState(parcel, classLoader);
        }

        public final Object[] mo73a(int i) {
            return new ViewPager$SavedState[i];
        }
    }

    public ViewPager$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f354a);
        parcel.writeParcelable(this.f355b, i);
    }

    public String toString() {
        return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f354a + "}";
    }

    ViewPager$SavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel);
        if (classLoader == null) {
            classLoader = getClass().getClassLoader();
        }
        this.f354a = parcel.readInt();
        this.f355b = parcel.readParcelable(classLoader);
        this.f356c = classLoader;
    }
}
