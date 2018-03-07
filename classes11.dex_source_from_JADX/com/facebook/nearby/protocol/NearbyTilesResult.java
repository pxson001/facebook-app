package com.facebook.nearby.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.results.BaseResult;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLGeoRectangle;
import com.facebook.graphql.model.GraphQLMapTile;
import com.facebook.graphql.model.GraphQLMapTileNode;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/* compiled from: total_rss_at_priority_ */
public class NearbyTilesResult extends BaseResult implements Parcelable {
    public static final Creator<NearbyTilesResult> CREATOR = new C00831();
    public final List<GraphQLMapTile> f636a;
    public final String f637b;
    public final ImmutableSet<String> f638c;
    public final ImmutableSet<Long> f639d;
    public final NearbyTilesParams f640e;
    public final GraphQLGeoRectangle f641f;

    /* compiled from: total_rss_at_priority_ */
    final class C00831 implements Creator<NearbyTilesResult> {
        C00831() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new NearbyTilesResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new NearbyTilesResult[i];
        }
    }

    public NearbyTilesResult(DataFreshnessResult dataFreshnessResult, long j, List<GraphQLMapTile> list, String str, Set<String> set, Set<Long> set2, GraphQLGeoRectangle graphQLGeoRectangle, NearbyTilesParams nearbyTilesParams) {
        super(dataFreshnessResult, j);
        Preconditions.checkNotNull(str);
        this.f636a = list;
        this.f637b = str;
        this.f638c = ImmutableSet.copyOf(set);
        this.f639d = ImmutableSet.copyOf(set2);
        this.f641f = graphQLGeoRectangle;
        this.f640e = nearbyTilesParams;
    }

    public NearbyTilesResult(Parcel parcel) {
        super(parcel);
        this.f636a = parcel.readArrayList(GraphQLMapTileNode.class.getClassLoader());
        this.f637b = parcel.readString();
        Collection readArrayList = parcel.readArrayList(String.class.getClassLoader());
        this.f638c = readArrayList == null ? null : ImmutableSet.copyOf(readArrayList);
        this.f639d = ImmutableSet.copyOf(parcel.readArrayList(Long.class.getClassLoader()));
        this.f641f = (GraphQLGeoRectangle) FlatBufferModelHelper.a(parcel);
        this.f640e = (NearbyTilesParams) parcel.readParcelable(NearbyTilesParams.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeList(this.f636a);
        parcel.writeString(this.f637b);
        parcel.writeList(this.f638c.asList());
        parcel.writeList(this.f639d.asList());
        FlatBufferModelHelper.a(parcel, this.f641f);
        parcel.writeParcelable(this.f640e, i);
    }

    public int describeContents() {
        return 0;
    }

    public final String m889d() {
        return this.f637b;
    }

    public final Set<String> m890e() {
        return this.f638c;
    }

    public final Set<Long> m891f() {
        return this.f639d;
    }

    public final GraphQLGeoRectangle m892g() {
        return this.f641f;
    }

    public final NearbyTilesParams m893h() {
        return this.f640e;
    }
}
