package com.facebook.events.eventsdiscovery;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.nearby.v2.model.NearbyPlacesSearchDataModel;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionSuggestedEventsQueryModel;
import com.facebook.reaction.ui.fragment.BaseFullscreenReactionFragment;
import com.facebook.reaction.ui.recyclerview.AbstractReactionRecyclerViewAdapter;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: com.facebook.fragment.BUNDLE_EXTRAS */
public class EventsDiscoveryReactionFragment extends BaseFullscreenReactionFragment {
    private List<String> aA;
    @Inject
    public EventsDiscoveryReactionSessionBuilder am;
    private final SuggestedEventsUnitsCallback an = new SuggestedEventsUnitsCallback(this);
    private final Surface ao = Surface.ANDROID_EVENT_DISCOVER_EVENT_LIST;
    public ReactionSession ap;
    public AbstractReactionRecyclerViewAdapter aq;
    private ObjectNode ar;
    public String as;
    @Nullable
    private String at;
    private String au;
    private String av;
    private String aw;
    private NearbyPlacesSearchDataModel ax;
    private int ay;
    public boolean az;

    /* compiled from: com.facebook.fragment.BUNDLE_EXTRAS */
    public class SuggestedEventsUnitsCallback extends AbstractDisposableFutureCallback<GraphQLResult<ReactionSuggestedEventsQueryModel>> {
        final /* synthetic */ EventsDiscoveryReactionFragment f17324a;

        public SuggestedEventsUnitsCallback(EventsDiscoveryReactionFragment eventsDiscoveryReactionFragment) {
            this.f17324a = eventsDiscoveryReactionFragment;
        }

        protected final void m17607a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            this.f17324a.b(false);
            if (graphQLResult.e == null || ((ReactionSuggestedEventsQueryModel) graphQLResult.e).a() == null || ((ReactionSuggestedEventsQueryModel) graphQLResult.e).a().a() == null || ((ReactionSuggestedEventsQueryModel) graphQLResult.e).a().a().a().isEmpty()) {
                this.f17324a.ap.p = false;
                this.f17324a.aq.j_(this.f17324a.aq.g());
            } else {
                DefaultPageInfoFieldsModel j = ((ReactionSuggestedEventsQueryModel) graphQLResult.e).a().a().j();
                this.f17324a.as = j.a();
                this.f17324a.ap.p = j.b();
                this.f17324a.aq.a(((ReactionSuggestedEventsQueryModel) graphQLResult.e).a().a());
            }
            this.f17324a.ay();
        }

        protected final void m17608a(Throwable th) {
            this.f17324a.aq.j_(this.f17324a.aq.g());
            this.f17324a.kp_();
        }
    }

    public static void m17610a(Object obj, Context context) {
        ((EventsDiscoveryReactionFragment) obj).am = EventsDiscoveryReactionSessionBuilder.m17618b(FbInjector.get(context));
    }

    public final String am_() {
        return "event_discovery";
    }

    public final void m17615c(@Nullable Bundle bundle) {
        Class cls = EventsDiscoveryReactionFragment.class;
        m17610a((Object) this, getContext());
        this.av = this.s.getString("extra_events_discovery_suggestion_token");
        this.aw = this.s.getString("extra_events_discovery_filter_time");
        this.ax = (NearbyPlacesSearchDataModel) this.s.getParcelable("extra_events_discovery_filter_location");
        this.ay = this.s.getInt("extra_events_discovery_filter_location_range");
        if (bundle != null) {
            this.az = bundle.getBoolean("extra_events_discovery_fragment_waiting_for_location_result");
        }
        this.aA = this.s.getStringArrayList("extra_events_discovery_fragment_selected_category");
        this.ar = m17609a(this.av, this.aw, this.ax, this.ay, this.aA);
        this.at = this.s.getString("extra_events_discovery_title");
        this.au = this.s.getString("extra_fragment_tag");
        super.c(bundle);
        this.ap = this.av;
    }

    public final View m17611a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -627219389);
        View a2 = a(viewGroup, this.av);
        this.aq = this.at;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1501961939, a);
        return a2;
    }

    protected final ReactionSession ax() {
        if (this.az) {
            return this.am.m17619a(this.ao);
        }
        EventsDiscoveryReactionSessionBuilder eventsDiscoveryReactionSessionBuilder = this.am;
        Surface surface = this.ao;
        SuggestedEventsUnitsCallback suggestedEventsUnitsCallback = this.an;
        ObjectNode objectNode = this.ar;
        String str = this.au;
        ReactionSession a = eventsDiscoveryReactionSessionBuilder.m17619a(surface);
        eventsDiscoveryReactionSessionBuilder.m17620a(surface, suggestedEventsUnitsCallback, objectNode, str);
        return a;
    }

    protected final void m17614b(String str) {
        if (!StringUtil.a(this.at)) {
            super.b(this.at);
        }
    }

    protected final void aV() {
        this.am.m17621a(this.ao, this.an, this.ar, this.au, this.ap.p, this.as);
    }

    public final void m17616e(Bundle bundle) {
        super.e(bundle);
        bundle.putBoolean("extra_events_discovery_fragment_waiting_for_location_result", this.az);
    }

    private static ObjectNode m17609a(String str, String str2, NearbyPlacesSearchDataModel nearbyPlacesSearchDataModel, int i, List<String> list) {
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        if (!StringUtil.a(str)) {
            objectNode.a("suggestion_token", str);
        }
        if (!StringUtil.a(str2)) {
            objectNode.a("time", str2);
        }
        if (nearbyPlacesSearchDataModel != null) {
            if (nearbyPlacesSearchDataModel.b) {
                Location location = nearbyPlacesSearchDataModel.c;
                if (location != null) {
                    ObjectNode objectNode2 = new ObjectNode(JsonNodeFactory.a);
                    objectNode2.a("latitude", location.getLatitude());
                    objectNode2.a("longitude", location.getLongitude());
                    objectNode.c("lat_lon", objectNode2);
                    objectNode.a("range", i);
                }
            } else {
                objectNode.a("city", nearbyPlacesSearchDataModel.d);
            }
        }
        if (list != null) {
            ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
            for (String h : list) {
                arrayNode.h(h);
            }
            objectNode.c("event_categories", arrayNode);
        }
        return objectNode;
    }

    public final void m17612a(NearbyPlacesSearchDataModel nearbyPlacesSearchDataModel, int i) {
        this.az = false;
        this.ax = nearbyPlacesSearchDataModel;
        this.ay = i;
        aY();
        this.ar = m17609a(this.av, this.aw, nearbyPlacesSearchDataModel, i, null);
        this.am.m17620a(this.ao, this.an, this.ar, this.au);
    }

    private void aY() {
        this.aq.j();
        this.aq.k();
        b(true);
    }

    public final void aX() {
        if (getInteractionTracker() != null) {
            getInteractionTracker().d(aQ());
            getInteractionTracker().c();
        }
    }

    public final void m17613a(NearbyPlacesSearchDataModel nearbyPlacesSearchDataModel, int i, List<String> list) {
        this.ax = nearbyPlacesSearchDataModel;
        this.ay = i;
        this.aA = list;
        aY();
        this.ar = m17609a(this.av, this.aw, nearbyPlacesSearchDataModel, i, list);
        this.am.m17620a(this.ao, this.an, this.ar, this.au);
    }
}
