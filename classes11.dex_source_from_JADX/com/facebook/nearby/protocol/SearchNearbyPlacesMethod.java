package com.facebook.nearby.protocol;

import android.content.res.Resources;
import android.location.Location;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.JSONUtil;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.graphql.model.GraphQLNearbySearchSuggestion;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.inject.InjectorLike;
import com.facebook.nearby.common.SearchSuggestion;
import com.facebook.nearby.model.TypeaheadPlace;
import com.facebook.nearby.protocol.SearchNearbyPlacesGraphQL.SearchNearbyPlacesString;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* compiled from: top_up_amount */
public class SearchNearbyPlacesMethod extends AbstractPersistedGraphQlApiMethod<SearchNearbyPlacesParams, SearchNearbyPlacesResult> {
    private final Clock f696c;
    private final Resources f697d;
    private final ObjectMapper f698e;
    private final GraphQLProtocolHelper f699f;

    public static SearchNearbyPlacesMethod m1012b(InjectorLike injectorLike) {
        return new SearchNearbyPlacesMethod((Clock) SystemClockMethodAutoProvider.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), GraphQLProtocolHelper.a(injectorLike));
    }

    public final Object m1014a(Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        List b;
        List a;
        SearchNearbyPlacesParams searchNearbyPlacesParams = (SearchNearbyPlacesParams) obj;
        int i = 0;
        JsonNode jsonNode = (JsonNode) jsonParser.J();
        JsonNode b2 = jsonNode.b("result_sections");
        JsonNode b3 = b2.b("edges");
        b2 = b2.b("nodes");
        String B = jsonNode.b("search_session_id").B();
        for (int i2 = 0; i2 < b3.e(); i2++) {
            JsonNode b4 = b3.a(i2).b("node");
            JsonNode b5 = b4.b("results").b("edges");
            if (JSONUtil.b(b4.b("result_category")).equals("PLACES")) {
                b = m1013b(b5);
                break;
            }
        }
        b = null;
        while (i < b2.e()) {
            jsonNode = b2.a(i);
            if (JSONUtil.b(jsonNode.b("result_category")).equals("TOPICS_AND_REGION")) {
                a = m1011a(jsonNode.b("topic_suggestions").b("nodes"));
                break;
            }
            i++;
        }
        a = null;
        if (a == null) {
            throw new RuntimeException("missing TOPICS_AND_REGION node in response: " + apiResponse.c().toString());
        } else if (b != null) {
            return new SearchNearbyPlacesResult(DataFreshnessResult.FROM_SERVER, this.f696c.a(), B, Strings.nullToEmpty(searchNearbyPlacesParams.f710b), a, b);
        } else {
            throw new RuntimeException("missing PLACES node in response: " + apiResponse.c().toString());
        }
    }

    public final GraphQlQueryString m1016f(Object obj) {
        SearchNearbyPlacesParams searchNearbyPlacesParams = (SearchNearbyPlacesParams) obj;
        int dimensionPixelSize = this.f697d.getDimensionPixelSize(2131430878);
        GraphQlQueryString searchNearbyPlacesString = new SearchNearbyPlacesString();
        searchNearbyPlacesString.a("profile_pic_size", String.valueOf(dimensionPixelSize)).a("search_latitude", String.valueOf(searchNearbyPlacesParams.f709a.f658a.getLatitude())).a("search_longitude", String.valueOf(searchNearbyPlacesParams.f709a.f658a.getLongitude())).a("query", Strings.nullToEmpty(searchNearbyPlacesParams.f710b).replaceAll("\\\\", "\\\\\\\\").replaceAll("\\(", "\\\\(").replaceAll(",", "\\\\,").replaceAll("\\.", "\\\\.").replaceAll("\\)", "\\\\)").replaceAll("\\<", "\\\\<").replaceAll("\\>", "\\\\>")).a("result_categories", Lists.a(new String[]{"TOPICS_AND_REGION", "PLACES"})).a("user_altitude", String.valueOf(searchNearbyPlacesParams.f712d)).a("user_altitude_accuracy", String.valueOf(searchNearbyPlacesParams.f713e)).a("user_heading", String.valueOf(searchNearbyPlacesParams.f714f)).a("user_heading_accuracy", String.valueOf(searchNearbyPlacesParams.f715g)).a("user_speed", String.valueOf(searchNearbyPlacesParams.f716h));
        long j = (long) searchNearbyPlacesParams.f709a.f659b;
        Location location = searchNearbyPlacesParams.f711c;
        if (j != -1) {
            searchNearbyPlacesString.a("search_distance", String.valueOf(j));
        }
        if (location != null) {
            searchNearbyPlacesString.a("user_location_latitude", String.valueOf(location.getLatitude())).a("user_location_longitude", String.valueOf(location.getLongitude())).a("user_location_accuracy", String.valueOf(location.getAccuracy())).a("user_location_stale_time", String.valueOf(searchNearbyPlacesParams.f717i));
        }
        return searchNearbyPlacesString;
    }

    @Inject
    public SearchNearbyPlacesMethod(Clock clock, Resources resources, ObjectMapper objectMapper, GraphQLProtocolHelper graphQLProtocolHelper) {
        super(graphQLProtocolHelper);
        this.f696c = clock;
        this.f697d = resources;
        this.f698e = objectMapper;
        this.f699f = graphQLProtocolHelper;
    }

    private ImmutableList<SearchSuggestion> m1011a(JsonNode jsonNode) {
        Builder builder = ImmutableList.builder();
        Iterator it = jsonNode.iterator();
        while (it.hasNext()) {
            builder.c(new SearchSuggestion((GraphQLNearbySearchSuggestion) this.f698e.a(((JsonNode) it.next()).toString(), GraphQLNearbySearchSuggestion.class)));
        }
        return builder.b();
    }

    private ImmutableList<TypeaheadPlace> m1013b(JsonNode jsonNode) {
        Builder builder = ImmutableList.builder();
        Iterator it = jsonNode.iterator();
        while (it.hasNext()) {
            builder.c(new TypeaheadPlace((GraphQLNode) this.f698e.a(((JsonNode) it.next()).b("node").toString(), GraphQLNode.class)));
        }
        return builder.b();
    }

    public final int m1015b(Object obj, ApiResponse apiResponse) {
        return 1;
    }
}
