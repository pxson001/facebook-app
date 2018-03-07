package com.facebook.nearby.v2.resultlist;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.base.fragment.FbFragment;
import com.facebook.nearby.v2.NearbyPlacesV2Fragment;
import com.facebook.nearby.v2.model.NearbyPlacesFragmentModel;
import com.facebook.nearby.v2.model.NearbyPlacesSearchDataProvider;
import com.facebook.nearby.v2.resultlist.model.NearbyPlacesResultListModel;
import com.google.common.base.Preconditions;

/* compiled from: default_action */
public abstract class NearbyPlacesV2ResultsFragment extends FbFragment implements AnalyticsFragment {

    /* compiled from: default_action */
    public interface OnResultListModelUpdatedListener {
        void mo963a(NearbyPlacesResultListModel nearbyPlacesResultListModel);
    }

    /* compiled from: default_action */
    public class Options implements Parcelable {
        public static final Creator<Options> CREATOR = new C16941();
        public final boolean f15836a;
        public final boolean f15837b;
        public final boolean f15838c;
        public final boolean f15839d;
        public final boolean f15840e;
        public final boolean f15841f;

        /* compiled from: default_action */
        final class C16941 implements Creator<Options> {
            C16941() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Options(parcel);
            }

            public final Object[] newArray(int i) {
                return new Options[i];
            }
        }

        /* compiled from: default_action */
        public class Builder {
            public boolean f15830a;
            public boolean f15831b;
            public boolean f15832c;
            public boolean f15833d;
            public boolean f15834e;
            public boolean f15835f;

            public final Options m18687a() {
                return new Options(this);
            }
        }

        public Options(Builder builder) {
            this.f15836a = builder.f15830a;
            this.f15837b = builder.f15831b;
            this.f15838c = builder.f15832c;
            this.f15839d = builder.f15833d;
            this.f15840e = builder.f15834e;
            this.f15841f = builder.f15835f;
        }

        public Options(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            this.f15836a = parcel.readByte() != (byte) 0;
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.f15837b = z;
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.f15838c = z;
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.f15839d = z;
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.f15840e = z;
            if (parcel.readByte() == (byte) 0) {
                z2 = false;
            }
            this.f15841f = z2;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2;
            int i3 = 1;
            parcel.writeByte((byte) (this.f15836a ? 1 : 0));
            if (this.f15837b) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            parcel.writeByte((byte) i2);
            if (this.f15838c) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            parcel.writeByte((byte) i2);
            if (this.f15839d) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            parcel.writeByte((byte) i2);
            if (this.f15840e) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            parcel.writeByte((byte) i2);
            if (!this.f15841f) {
                i3 = 0;
            }
            parcel.writeByte((byte) i3);
        }
    }

    public abstract void mo959a(NearbyPlacesV2Fragment nearbyPlacesV2Fragment);

    public abstract void mo960a(NearbyPlacesFragmentModel nearbyPlacesFragmentModel);

    public abstract void mo961a(NearbyPlacesSearchDataProvider nearbyPlacesSearchDataProvider);

    public abstract void mo962a(OnResultListModelUpdatedListener onResultListModelUpdatedListener);

    public abstract void mo964e();

    public static NearbyPlacesV2ResultsFragment m18640b(Options options) {
        Preconditions.checkNotNull(options);
        if (!options.f15837b) {
            return NearbyPlacesV2ResultListFragment.m18669a(options);
        }
        NearbyPlacesV2ResultsFragment nearbyPlacesV2CombinedResultsFragment = new NearbyPlacesV2CombinedResultsFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("options", options);
        nearbyPlacesV2CombinedResultsFragment.g(bundle);
        return nearbyPlacesV2CombinedResultsFragment;
    }

    public final Options ar() {
        return (Options) this.s.getParcelable("options");
    }
}
