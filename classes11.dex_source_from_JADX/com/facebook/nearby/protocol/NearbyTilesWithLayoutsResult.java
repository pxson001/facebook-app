package com.facebook.nearby.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.results.BaseResult;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLGeoRectangle;
import com.facebook.graphql.model.GraphQLMapTile;
import com.facebook.graphql.model.GraphQLMapTileNode;
import com.facebook.graphql.model.GraphQLPlacesTileResultsConnection;
import com.facebook.graphql.model.GraphQLPlacesTileResultsEdge;
import com.facebook.nearby.model.MapTile;
import com.facebook.nearby.model.NearbyPlaceEdgeWithLayout;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: topic_suggestions */
public class NearbyTilesWithLayoutsResult extends BaseResult implements Parcelable {
    public static final Creator<NearbyTilesWithLayoutsResult> CREATOR = new C00851();
    private static final Class<?> f644a = NearbyTilesWithLayoutsResult.class;
    public final List<MapTile> f645b;
    public final String f646c;
    public final ImmutableSet<String> f647d;
    public final ImmutableSet<Long> f648e;
    private final NearbyTilesParams f649f;
    public final GraphQLGeoRectangle f650g;

    /* compiled from: topic_suggestions */
    final class C00851 implements Creator<NearbyTilesWithLayoutsResult> {
        C00851() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new NearbyTilesWithLayoutsResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new NearbyTilesWithLayoutsResult[i];
        }
    }

    public NearbyTilesWithLayoutsResult(NearbyTilesResult nearbyTilesResult, FetchNearbyPlacesLayoutResult fetchNearbyPlacesLayoutResult) {
        Map c;
        super(nearbyTilesResult.freshness, nearbyTilesResult.clientTimeMs);
        Preconditions.checkNotNull(nearbyTilesResult.f637b);
        List list = nearbyTilesResult.f636a;
        if (fetchNearbyPlacesLayoutResult == null) {
            c = Maps.c();
        } else {
            c = fetchNearbyPlacesLayoutResult.f522a;
        }
        this.f645b = m895a(list, c);
        this.f646c = nearbyTilesResult.f637b;
        this.f647d = ImmutableSet.copyOf(nearbyTilesResult.f638c);
        this.f648e = ImmutableSet.copyOf(nearbyTilesResult.f639d);
        this.f650g = nearbyTilesResult.f641f;
        this.f649f = nearbyTilesResult.f640e;
    }

    public NearbyTilesWithLayoutsResult(DataFreshnessResult dataFreshnessResult, long j, List<MapTile> list, String str, Set<String> set, Set<Long> set2, GraphQLGeoRectangle graphQLGeoRectangle, NearbyTilesParams nearbyTilesParams) {
        super(dataFreshnessResult, j);
        Preconditions.checkNotNull(str);
        this.f645b = list;
        this.f646c = str;
        this.f647d = ImmutableSet.copyOf(set);
        this.f648e = ImmutableSet.copyOf(set2);
        this.f650g = graphQLGeoRectangle;
        this.f649f = nearbyTilesParams;
    }

    public NearbyTilesWithLayoutsResult(Parcel parcel) {
        super(parcel);
        this.f645b = parcel.readArrayList(GraphQLMapTileNode.class.getClassLoader());
        this.f646c = parcel.readString();
        Collection readArrayList = parcel.readArrayList(String.class.getClassLoader());
        this.f647d = readArrayList == null ? null : ImmutableSet.copyOf(readArrayList);
        this.f648e = ImmutableSet.copyOf(parcel.readArrayList(Long.class.getClassLoader()));
        this.f650g = (GraphQLGeoRectangle) FlatBufferModelHelper.a(parcel);
        this.f649f = (NearbyTilesParams) parcel.readParcelable(NearbyTilesParams.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeList(this.f645b);
        parcel.writeString(this.f646c);
        parcel.writeList(this.f647d.asList());
        parcel.writeList(this.f648e.asList());
        FlatBufferModelHelper.a(parcel, this.f650g);
        parcel.writeParcelable(this.f649f, i);
    }

    public int describeContents() {
        return 0;
    }

    public final List<MapTile> m896c() {
        return this.f645b;
    }

    private List<MapTile> m895a(List<GraphQLMapTile> list, Map<String, String> map) {
        Builder builder = ImmutableList.builder();
        for (GraphQLMapTile graphQLMapTile : list) {
            builder.c(new MapTile(graphQLMapTile.a(), graphQLMapTile.b(), graphQLMapTile.c(), graphQLMapTile.e(), graphQLMapTile.f(), graphQLMapTile.d(), m894a((Map) map, graphQLMapTile.g()), m894a((Map) map, graphQLMapTile.h())));
        }
        return builder.b();
    }

    private static ImmutableList<NearbyPlaceEdgeWithLayout> m894a(Map<String, String> map, GraphQLPlacesTileResultsConnection graphQLPlacesTileResultsConnection) {
        int i;
        Builder builder = ImmutableList.builder();
        if (map.size() > 0) {
            i = 1;
        } else {
            i = 0;
        }
        if (!(graphQLPlacesTileResultsConnection == null || graphQLPlacesTileResultsConnection.a() == null)) {
            ImmutableList a = graphQLPlacesTileResultsConnection.a();
            int size = a.size();
            for (int i2 = 0; i2 < size; i2++) {
                GraphQLPlacesTileResultsEdge graphQLPlacesTileResultsEdge = (GraphQLPlacesTileResultsEdge) a.get(i2);
                String str = (String) map.get(graphQLPlacesTileResultsEdge.a().ae());
                if (i != 0 && str == null) {
                    BLog.a(f644a, "missing layout for place id = %s", new Object[]{graphQLPlacesTileResultsEdge.a().ae()});
                }
                builder.c(new NearbyPlaceEdgeWithLayout(graphQLPlacesTileResultsEdge, str));
            }
        }
        return builder.b();
    }
}
