package com.facebook.pages.launchpoint.adapters;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: page_fragment_uuid */
public enum PagesLaunchpointFragmentType implements Parcelable {
    PAGES_LAUNCHPOINT_HOME_FRAGMENT,
    PAGES_LAUNCHPOINT_DISCOVER_FRAGMENT,
    PAGES_LAUNCHPOINT_FEED_FRAGMENT;
    
    public static final Creator<PagesLaunchpointFragmentType> CREATOR = null;

    /* compiled from: page_fragment_uuid */
    final class C06031 implements Creator<PagesLaunchpointFragmentType> {
        C06031() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return PagesLaunchpointFragmentType.valueOf(parcel.toString());
        }

        public final Object[] newArray(int i) {
            return new PagesLaunchpointFragmentType[i];
        }
    }

    static {
        CREATOR = new C06031();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name());
    }
}
