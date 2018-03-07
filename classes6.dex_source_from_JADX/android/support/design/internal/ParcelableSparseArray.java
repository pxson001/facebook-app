package android.support.design.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.util.SparseArray;

/* compiled from: qe_next_page_index */
public class ParcelableSparseArray extends SparseArray<Parcelable> implements Parcelable {
    public static final Creator<ParcelableSparseArray> CREATOR = ParcelableCompat.a(new C03891());

    /* compiled from: qe_next_page_index */
    final class C03891 implements ParcelableCompatCreatorCallbacks<ParcelableSparseArray> {
        C03891() {
        }

        public final Object m9976a(Parcel parcel, ClassLoader classLoader) {
            return new ParcelableSparseArray(parcel, classLoader);
        }

        public final Object[] m9977a(int i) {
            return new ParcelableSparseArray[i];
        }
    }

    public ParcelableSparseArray(Parcel parcel, ClassLoader classLoader) {
        int readInt = parcel.readInt();
        int[] iArr = new int[readInt];
        parcel.readIntArray(iArr);
        Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
        for (int i = 0; i < readInt; i++) {
            put(iArr[i], readParcelableArray[i]);
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int size = size();
        int[] iArr = new int[size];
        Parcelable[] parcelableArr = new Parcelable[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = keyAt(i2);
            parcelableArr[i2] = (Parcelable) valueAt(i2);
        }
        parcel.writeInt(size);
        parcel.writeIntArray(iArr);
        parcel.writeParcelableArray(parcelableArr, i);
    }
}
