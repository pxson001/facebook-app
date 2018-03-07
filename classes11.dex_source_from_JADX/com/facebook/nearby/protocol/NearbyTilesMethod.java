package com.facebook.nearby.protocol;

import android.content.res.Resources;
import android.location.Location;
import android.util.Pair;
import com.facebook.common.time.Clock;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.graphql.model.GraphQLGeoRectangle;
import com.facebook.graphql.model.GraphQLMapTileNode;
import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.nearby.model.NearbyTiles;
import com.facebook.nearby.model.NearbyTilesMethodResult;
import com.facebook.nearby.protocol.NearbyTilesGraphQL.NearbyTilesString;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.base.Functions.ToStringFunction;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import org.json.JSONArray;

/* compiled from: touchExplorationDidChange */
public class NearbyTilesMethod extends AbstractPersistedGraphQlApiMethod<NearbyTilesParams, NearbyTilesResult> {
    private final Clock f611c;
    private final Resources f612d;

    public final Object m882a(Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        NearbyTilesParams nearbyTilesParams = (NearbyTilesParams) obj;
        NearbyTilesMethodResult nearbyTilesMethodResult = (NearbyTilesMethodResult) jsonParser.a(NearbyTilesMethodResult.class);
        if (nearbyTilesMethodResult == null) {
            throw new Exception("Invalid JSON result");
        }
        List a = Lists.a();
        NearbyTiles nearbyTiles = nearbyTilesMethodResult.nearbyTiles;
        for (GraphQLMapTileNode a2 : nearbyTiles.tiles) {
            a.add(a2.a());
        }
        Pair a3 = m881a(nearbyTiles.canonicalization);
        return new NearbyTilesResult(DataFreshnessResult.FROM_SERVER, this.f611c.a(), a, nearbyTiles.version, (Set) a3.first, (Set) a3.second, nearbyTiles.displayRegionHint, nearbyTilesParams);
    }

    public final GraphQlQueryString m884f(Object obj) {
        NearbyTilesParams nearbyTilesParams = (NearbyTilesParams) obj;
        int dimensionPixelSize = this.f612d.getDimensionPixelSize(2131430879);
        GraphQlQueryString nearbyTilesString = new NearbyTilesString();
        nearbyTilesString.a("places_render_priority_1", "1").a("places_render_priority_2", "2");
        Location location = nearbyTilesParams.f629f;
        if (location != null) {
            nearbyTilesString.a("location_latitude", String.valueOf(location.getLatitude())).a("location_longitude", String.valueOf(location.getLongitude())).a("location_accuracy", String.valueOf(nearbyTilesParams.f630g)).a("location_stale_time", String.valueOf(nearbyTilesParams.f631h)).a("facepile_pic_size", String.valueOf(dimensionPixelSize));
        }
        GraphQLGeoRectangle graphQLGeoRectangle = nearbyTilesParams.f627d;
        if (graphQLGeoRectangle == null) {
            nearbyTilesString.a("altitude", "0").a("accuracy", "0").a("speed", "0");
        } else {
            nearbyTilesString.a("altitude", String.valueOf(nearbyTilesParams.f632i)).a("accuracy", String.valueOf(nearbyTilesParams.f633j)).a("user_heading", String.valueOf(nearbyTilesParams.f634k)).a("user_heading_accuracy", String.valueOf(nearbyTilesParams.f635l)).a("speed", String.valueOf(nearbyTilesParams.f626c)).a("region_north_latitude", String.valueOf(graphQLGeoRectangle.j())).a("region_west_longitude", String.valueOf(graphQLGeoRectangle.l())).a("region_south_latitude", String.valueOf(graphQLGeoRectangle.k())).a("region_east_longitude", String.valueOf(graphQLGeoRectangle.a())).a("region_zoom", String.valueOf(nearbyTilesParams.f628e));
            List list = nearbyTilesParams.f624a;
            if (list != null) {
                nearbyTilesString.a("topics_list", Lists.a(list, ToStringFunction.INSTANCE));
            }
            list = nearbyTilesParams.f625b;
            if (!list.isEmpty()) {
                nearbyTilesString.a("query_function", list);
            }
        }
        return nearbyTilesString;
    }

    @Inject
    public NearbyTilesMethod(Clock clock, Resources resources, GraphQLProtocolHelper graphQLProtocolHelper) {
        super(graphQLProtocolHelper);
        this.f611c = clock;
        this.f612d = resources;
    }

    public final int m883b(Object obj, ApiResponse apiResponse) {
        return 1;
    }

    private static Pair<Set<String>, Set<Long>> m881a(String str) {
        Set a = Sets.a();
        Set a2 = Sets.a();
        JSONArray jSONArray = new JSONArray(str);
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                a2.add(Long.valueOf(Long.parseLong(jSONArray.get(i).toString())));
            } catch (NumberFormatException e) {
                a.add(jSONArray.get(i).toString());
            }
        }
        return new Pair(a, a2);
    }
}
