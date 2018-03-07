package com.facebook.nearby.cluster;

import android.graphics.RectF;
import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.GraphQLPlacesTileResultsEdge;
import com.facebook.nearby.model.NearbyPlaceEdgeWrapper;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.collect.Sets;
import java.util.Set;

/* compiled from: user_heading_accuracy */
public class NearbyPlaceCluster implements Parcelable {
    public static final Creator<NearbyPlaceCluster> CREATOR = new C00471();
    public final Set<NearbyPlaceEdgeWrapper> f305a;
    public final RectF f306b;
    public final Location f307c;
    public final NearbyPlaceEdgeWrapper f308d;

    /* compiled from: user_heading_accuracy */
    final class C00471 implements Creator<NearbyPlaceCluster> {
        C00471() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new NearbyPlaceCluster(parcel);
        }

        public final Object[] newArray(int i) {
            return new NearbyPlaceCluster[i];
        }
    }

    public NearbyPlaceCluster(NearbyPlaceEdgeWrapper nearbyPlaceEdgeWrapper, RectF rectF) {
        this.f306b = rectF;
        this.f308d = nearbyPlaceEdgeWrapper;
        this.f307c = this.f308d.m502f();
        this.f305a = Sets.a(new NearbyPlaceEdgeWrapper[]{nearbyPlaceEdgeWrapper});
    }

    public NearbyPlaceCluster(Parcel parcel) {
        int i = 0;
        if ((parcel.readByte() != (byte) 0 ? 1 : 0) != 0) {
            Builder builder = new Builder();
            NearbyPlaceEdgeWrapper[] nearbyPlaceEdgeWrapperArr = (NearbyPlaceEdgeWrapper[]) parcel.readParcelableArray(NearbyPlaceEdgeWrapper.class.getClassLoader());
            int length = nearbyPlaceEdgeWrapperArr.length;
            while (i < length) {
                builder.c(nearbyPlaceEdgeWrapperArr[i]);
                i++;
            }
            this.f305a = builder.b();
        } else {
            this.f305a = null;
        }
        this.f308d = (NearbyPlaceEdgeWrapper) parcel.readParcelable(GraphQLPlacesTileResultsEdge.class.getClassLoader());
        this.f307c = this.f308d.m502f();
        this.f306b = (RectF) parcel.readParcelable(RectF.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.f305a == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeParcelableArray((Parcelable[]) this.f305a.toArray(new NearbyPlaceEdgeWrapper[this.f305a.size()]), i);
        }
        parcel.writeParcelable(this.f308d, i);
        parcel.writeParcelable(this.f306b, i);
    }

    public int describeContents() {
        return 0;
    }

    public final void m396a(NearbyPlaceEdgeWrapper nearbyPlaceEdgeWrapper) {
        this.f305a.add(nearbyPlaceEdgeWrapper);
    }

    public final int m397c() {
        return this.f305a.size();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (NearbyPlaceEdgeWrapper nearbyPlaceEdgeWrapper : this.f305a) {
            stringBuilder.append(nearbyPlaceEdgeWrapper.m500d()).append(":").append(nearbyPlaceEdgeWrapper.m503g()).append(":").append(nearbyPlaceEdgeWrapper.m506k()).append("\n");
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof NearbyPlaceCluster)) {
            return false;
        }
        NearbyPlaceCluster nearbyPlaceCluster = (NearbyPlaceCluster) obj;
        if (Objects.equal(this.f305a, nearbyPlaceCluster.f305a) && Objects.equal(Double.valueOf(this.f307c.getLatitude()), Double.valueOf(nearbyPlaceCluster.f307c.getLatitude())) && Objects.equal(Double.valueOf(this.f307c.getLongitude()), Double.valueOf(nearbyPlaceCluster.f307c.getLongitude())) && Objects.equal(this.f308d, nearbyPlaceCluster.f308d)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f305a, this.f308d, Double.valueOf(this.f307c.getLatitude()), Double.valueOf(this.f307c.getLongitude())});
    }
}
