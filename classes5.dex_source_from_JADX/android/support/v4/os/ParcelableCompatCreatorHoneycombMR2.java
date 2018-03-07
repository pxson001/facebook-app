package android.support.v4.os;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

/* compiled from: videos */
public class ParcelableCompatCreatorHoneycombMR2<T> implements ClassLoaderCreator<T> {
    private final ParcelableCompatCreatorCallbacks<T> f267a;

    public ParcelableCompatCreatorHoneycombMR2(ParcelableCompatCreatorCallbacks<T> parcelableCompatCreatorCallbacks) {
        this.f267a = parcelableCompatCreatorCallbacks;
    }

    public T createFromParcel(Parcel parcel) {
        return this.f267a.mo72a(parcel, null);
    }

    public T createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return this.f267a.mo72a(parcel, classLoader);
    }

    public T[] newArray(int i) {
        return this.f267a.mo73a(i);
    }
}
