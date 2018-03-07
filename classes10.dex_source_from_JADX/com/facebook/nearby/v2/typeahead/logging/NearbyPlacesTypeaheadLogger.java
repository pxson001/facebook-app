package com.facebook.nearby.v2.typeahead.logging;

import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.Assisted;
import com.facebook.nearby.v2.model.NearbyPlacesFragmentModel;
import com.facebook.nearby.v2.network.NearbyPlacesTypeaheadGraphQLModels.FBNearbyPlacesTypeaheadLocationResultsConnectionFragmentModel.EdgesModel.NodeModel;
import com.facebook.nearby.v2.network.NearbyPlacesTypeaheadGraphQLModels.FBNearbyPlacesTypeaheadPlaceFragmentModel;
import com.facebook.nearby.v2.typeahead.NearbyPlacesTypeaheadFragment;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: passenger_details */
public class NearbyPlacesTypeaheadLogger {
    private final AnalyticsLogger f5204a;
    public NearbyPlacesFragmentModel f5205b;
    public NearbyPlacesTypeaheadFragment f5206c;
    public NearbyPlacesTypeaheadFragment f5207d;

    /* compiled from: passenger_details */
    public enum TypeaheadSearchType {
        NONE,
        PLACES_TOPICS,
        LOCATIONS
    }

    @Inject
    public NearbyPlacesTypeaheadLogger(@Assisted NearbyPlacesFragmentModel nearbyPlacesFragmentModel, @Assisted NearbyPlacesTypeaheadFragment nearbyPlacesTypeaheadFragment, @Assisted NearbyPlacesTypeaheadFragment nearbyPlacesTypeaheadFragment2, AnalyticsLogger analyticsLogger) {
        Preconditions.checkNotNull(nearbyPlacesFragmentModel);
        Preconditions.checkNotNull(nearbyPlacesTypeaheadFragment);
        Preconditions.checkNotNull(nearbyPlacesTypeaheadFragment2);
        this.f5205b = nearbyPlacesFragmentModel;
        this.f5206c = nearbyPlacesTypeaheadFragment;
        this.f5207d = nearbyPlacesTypeaheadFragment2;
        this.f5204a = analyticsLogger;
    }

    public final void m4668a(TypeaheadSearchType typeaheadSearchType) {
        String str = "";
        switch (typeaheadSearchType) {
            case PLACES_TOPICS:
                str = "nearby_places_search_typeahead_did_receive_results";
                break;
            case LOCATIONS:
                str = "nearby_places_city_typeahead_did_receive_results";
                break;
        }
        m4665a(str, typeaheadSearchType);
    }

    public final void m4671b(TypeaheadSearchType typeaheadSearchType) {
        HoneyClientEvent a = m4662a(m4664a("nearby_places_search_impression"), typeaheadSearchType);
        a.b("search_string", m4667g(typeaheadSearchType)).a("places_ids", m4666f(typeaheadSearchType));
        this.f5204a.a(a);
    }

    public final void m4669a(String str, int i, int i2) {
        HoneyClientEvent a = m4663a(m4664a("search_result_user_selection"), TypeaheadSearchType.PLACES_TOPICS, null, i, i2);
        a.b("result_name", str).b("selection_name", str);
        this.f5204a.a(a);
    }

    public final void m4672b(String str, int i, int i2) {
        this.f5204a.a(m4663a(m4664a("search_result_user_selection"), TypeaheadSearchType.PLACES_TOPICS, str, i, i2));
    }

    public final void m4670a(@Nullable String str, String str2, int i, int i2, boolean z) {
        HoneyClientEvent a = m4663a(m4664a("search_result_user_selection"), TypeaheadSearchType.LOCATIONS, str, i, i2);
        a.b("result_name", str2).a("is_current_location", z).a("user_has_location_services", this.f5206c.f5196f.f5217a.f());
        this.f5204a.a(a);
    }

    public final void m4673c(TypeaheadSearchType typeaheadSearchType) {
        this.f5204a.a(m4662a(m4664a("search_button_tapped"), typeaheadSearchType));
    }

    private void m4665a(String str, TypeaheadSearchType typeaheadSearchType) {
        HoneyClientEvent a = m4662a(m4664a(str), typeaheadSearchType);
        a.b("search_string", m4667g(typeaheadSearchType)).a("results_from_cache", false);
        List f = m4666f(typeaheadSearchType);
        if (f != null) {
            a.a("places_ids", f);
        }
        this.f5204a.a(a);
    }

    private HoneyClientEvent m4664a(String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.f = this.f5205b.a.c;
        honeyClientEvent = honeyClientEvent;
        honeyClientEvent.c = "nearby_places_module";
        return honeyClientEvent;
    }

    private HoneyClientEvent m4662a(HoneyClientEvent honeyClientEvent, TypeaheadSearchType typeaheadSearchType) {
        String str;
        HoneyClientEvent b = honeyClientEvent.b("session_id", this.f5205b.a.c);
        String str2 = "result_list_id";
        switch (typeaheadSearchType) {
            case PLACES_TOPICS:
                if (this.f5206c.f5196f.f5218b != null) {
                    str = this.f5206c.f5196f.f5218b.f5216d;
                    break;
                }
                str = "";
                break;
            case LOCATIONS:
                if (this.f5206c.f5196f.f5219c != null) {
                    str = this.f5206c.f5196f.f5219c.f5212c;
                    break;
                }
                str = "";
                break;
            default:
                str = "";
                break;
        }
        b = b.b(str2, str);
        str2 = "typeahead_session_id";
        switch (typeaheadSearchType) {
            case PLACES_TOPICS:
                str = this.f5207d.f5197g.f5208a;
                break;
            case LOCATIONS:
                str = this.f5207d.f5197g.f5209b;
                break;
            default:
                str = "";
                break;
        }
        b = b.b(str2, str);
        str2 = "typeahead_search_type";
        switch (typeaheadSearchType) {
            case PLACES_TOPICS:
                str = "places";
                break;
            case LOCATIONS:
                str = "location";
                break;
            default:
                str = "";
                break;
        }
        b.b(str2, str).b("ref", this.f5205b.a.a.getValue());
        return honeyClientEvent;
    }

    private HoneyClientEvent m4663a(HoneyClientEvent honeyClientEvent, TypeaheadSearchType typeaheadSearchType, @Nullable String str, int i, int i2) {
        HoneyClientEvent a = m4662a(honeyClientEvent, typeaheadSearchType);
        HoneyClientEvent b = a.b("selection_type", "typeahead_suggestion");
        String str2 = "selection_ids";
        if (str == null) {
            str = "";
        }
        b.b(str2, str).b("overall_rank", String.valueOf(i)).b("selection_rank", String.valueOf(i2));
        return a;
    }

    @Nullable
    private List<String> m4666f(TypeaheadSearchType typeaheadSearchType) {
        ImmutableList immutableList;
        List<String> arrayList;
        int i;
        switch (typeaheadSearchType) {
            case PLACES_TOPICS:
                if (this.f5206c.f5196f.f5218b == null) {
                    return null;
                }
                immutableList = this.f5206c.f5196f.f5218b.f5214b;
                arrayList = new ArrayList();
                for (i = 0; i < immutableList.size(); i++) {
                    arrayList.add(((FBNearbyPlacesTypeaheadPlaceFragmentModel) immutableList.get(i)).k());
                }
                return arrayList;
            case LOCATIONS:
                if (this.f5206c.f5196f.f5219c == null) {
                    return null;
                }
                immutableList = this.f5206c.f5196f.f5219c.f5211b;
                arrayList = new ArrayList();
                for (i = 0; i < immutableList.size(); i++) {
                    arrayList.add(((NodeModel) immutableList.get(i)).j());
                }
                return arrayList;
            default:
                return null;
        }
    }

    private String m4667g(TypeaheadSearchType typeaheadSearchType) {
        switch (typeaheadSearchType) {
            case PLACES_TOPICS:
                if (this.f5206c.f5196f.f5218b == null) {
                    return "";
                }
                return this.f5206c.f5196f.f5218b.f5213a;
            case LOCATIONS:
                if (this.f5206c.f5196f.f5219c == null) {
                    return "";
                }
                return this.f5206c.f5196f.f5219c.f5210a;
            default:
                return "";
        }
    }
}
