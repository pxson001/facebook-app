package android.support.v4.os;

import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: view_boarding_pass_cta_label */
public class ParcelableCompat {

    /* compiled from: view_boarding_pass_cta_label */
    class CompatCreator<T> implements Creator<T> {
        final ParcelableCompatCreatorCallbacks<T> f266a;

        public CompatCreator(ParcelableCompatCreatorCallbacks<T> parcelableCompatCreatorCallbacks) {
            this.f266a = parcelableCompatCreatorCallbacks;
        }

        public T createFromParcel(Parcel parcel) {
            return this.f266a.mo72a(parcel, null);
        }

        public T[] newArray(int i) {
            return this.f266a.mo73a(i);
        }
    }

    public static <T> Creator<T> m283a(ParcelableCompatCreatorCallbacks<T> parcelableCompatCreatorCallbacks) {
        if (VERSION.SDK_INT >= 13) {
            ParcelableCompatCreatorHoneycombMR2 parcelableCompatCreatorHoneycombMR2 = new ParcelableCompatCreatorHoneycombMR2(parcelableCompatCreatorCallbacks);
        }
        return new CompatCreator(parcelableCompatCreatorCallbacks);
    }
}
