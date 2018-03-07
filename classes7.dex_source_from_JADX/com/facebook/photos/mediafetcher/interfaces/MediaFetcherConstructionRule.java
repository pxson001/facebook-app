package com.facebook.photos.mediafetcher.interfaces;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.inject.AssistedProvider;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

/* compiled from: lastSequeuenceId included in the connect message %d is greater than the current one %d */
public class MediaFetcherConstructionRule implements Parcelable {
    public static final Creator<MediaFetcherConstructionRule> CREATOR = new C08991();
    public final Class<? extends AssistedProvider<? extends MediaQuery>> f10555a;
    public final QueryParam f10556b;

    /* compiled from: lastSequeuenceId included in the connect message %d is greater than the current one %d */
    final class C08991 implements Creator<MediaFetcherConstructionRule> {
        C08991() {
        }

        public final Object createFromParcel(Parcel parcel) {
            try {
                return new MediaFetcherConstructionRule(parcel);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public final Object[] newArray(int i) {
            return new MediaFetcherConstructionRule[i];
        }
    }

    public static <QUERY extends MediaQuery<QUERY_PARAM>, QUERY_PARAM extends QueryParam> MediaFetcherConstructionRule m12416a(Class<? extends AssistedProvider<QUERY>> cls, QUERY_PARAM query_param) {
        return new MediaFetcherConstructionRule(cls, query_param);
    }

    private MediaFetcherConstructionRule(Class<? extends AssistedProvider<? extends MediaQuery>> cls, QueryParam queryParam) {
        this.f10555a = (Class) Preconditions.checkNotNull(cls);
        this.f10556b = (QueryParam) Preconditions.checkNotNull(queryParam);
    }

    public MediaFetcherConstructionRule(Parcel parcel) {
        this.f10555a = Class.forName(parcel.readString());
        this.f10556b = (QueryParam) parcel.readParcelable(MediaFetcherConstructionRule.class.getClassLoader());
    }

    public String toString() {
        return Objects.toStringHelper(this).add("mediaQueryProviderClass", this.f10555a).add("queryParam", this.f10556b).toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f10555a.getCanonicalName());
        parcel.writeParcelable(this.f10556b, i);
    }
}
