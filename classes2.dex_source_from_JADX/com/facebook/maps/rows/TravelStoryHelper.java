package com.facebook.maps.rows;

import android.graphics.Color;
import com.facebook.android.maps.StaticMapView.Marker;
import com.facebook.android.maps.StaticMapView.StaticMapOptions;
import com.facebook.android.maps.model.LatLng;
import com.facebook.checkin.abtest.CheckinAbTestGatekeepers;
import com.facebook.checkin.abtest.ExperimentsForCheckinAbTestModule;
import com.facebook.graphql.model.GraphQLLocation;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLPlace;
import com.facebook.graphql.model.GraphQLPlace.Builder;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentStyleInfo;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: salegroups */
public class TravelStoryHelper {
    private final QeAccessor f6335a;
    private final CheckinAbTestGatekeepers f6336b;

    public static TravelStoryHelper m10683b(InjectorLike injectorLike) {
        return new TravelStoryHelper(QeInternalImplMethodAutoProvider.m3744a(injectorLike), CheckinAbTestGatekeepers.m10687b(injectorLike));
    }

    @Inject
    public TravelStoryHelper(QeAccessor qeAccessor, CheckinAbTestGatekeepers checkinAbTestGatekeepers) {
        this.f6335a = qeAccessor;
        this.f6336b = checkinAbTestGatekeepers;
    }

    public static StaticMapOptions m10680a(GraphQLStory graphQLStory, String str) {
        ImmutableList m = m10685c(graphQLStory).m27611m();
        List arrayList = new ArrayList(m.size());
        int size = m.size();
        for (int i = 0; i < size; i++) {
            GraphQLLocation graphQLLocation = (GraphQLLocation) m.get(i);
            arrayList.add(new LatLng(graphQLLocation.mo2957a(), graphQLLocation.mo2958b()));
        }
        return m10681a(arrayList, str);
    }

    private static StaticMapOptions m10681a(List<LatLng> list, String str) {
        StaticMapOptions staticMapOptions = new StaticMapOptions(str);
        staticMapOptions.a(list, Color.argb(255, 245, 21, 111), 3, "bezier", "3,5");
        List arrayList = new ArrayList(list.size() + 1);
        LatLng latLng = (LatLng) list.get(0);
        LatLng latLng2 = (LatLng) list.get(1);
        arrayList.add(new Marker(latLng, "images/places/map/map_pin.png", 0.5f, 0.5f));
        arrayList.add(new Marker(latLng, "images/places/map/bright-pink-pin-2x.png", 0.5f, 1.0f));
        arrayList.add(new Marker(latLng2, "images/places/map/pink-place-dot.png", 0.5f, 0.5f));
        staticMapOptions.a(arrayList);
        return staticMapOptions;
    }

    public final boolean m10686a(GraphQLStory graphQLStory) {
        if (m10684b(graphQLStory) && !this.f6336b.f6337a.m2189a(1141, false) && this.f6335a.mo596a(ExperimentsForCheckinAbTestModule.b, true)) {
            return true;
        }
        return false;
    }

    public static boolean m10684b(GraphQLStory graphQLStory) {
        GraphQLStoryAttachmentStyleInfo c = m10685c(graphQLStory);
        return (c == null || c.m27611m() == null || c.m27611m().size() != 2) ? false : true;
    }

    public static GraphQLPlace m10682a(GraphQLNode graphQLNode) {
        Builder builder = new Builder();
        builder.q = graphQLNode.dp();
        Builder builder2 = builder;
        builder2.X = graphQLNode.m23390j();
        builder2 = builder2.c(graphQLNode.eP());
        builder2.r = graphQLNode.dQ();
        builder2 = builder2;
        builder2.R = graphQLNode.hZ();
        builder2 = builder2;
        builder2.s = graphQLNode.er();
        builder2 = builder2;
        builder2.S = graphQLNode.iR();
        builder2 = builder2;
        builder2.J = graphQLNode.gj();
        builder2 = builder2;
        builder2.P = graphQLNode.hp();
        builder2 = builder2;
        builder2.v = graphQLNode.eZ();
        builder2 = builder2;
        builder2.j = graphQLNode.bd();
        builder2 = builder2;
        builder2.N = graphQLNode.gK();
        builder2 = builder2.a(graphQLNode.jn());
        builder2.I = graphQLNode.gi();
        builder2 = builder2;
        builder2.h = graphQLNode.aZ();
        builder2.d = graphQLNode.m23399s();
        if (graphQLNode.fc() != null) {
            builder.t = graphQLNode.fc().aA();
            builder2 = builder;
            builder2.x = graphQLNode.fc().aS();
            builder2.V = graphQLNode.fc().cH();
        }
        return builder.a();
    }

    private static GraphQLStoryAttachmentStyleInfo m10685c(GraphQLStory graphQLStory) {
        GraphQLStoryAttachment o = StoryAttachmentHelper.m28042o(graphQLStory);
        if (o.m23983v() == null || o.m23983v().isEmpty()) {
            return null;
        }
        return (GraphQLStoryAttachmentStyleInfo) o.m23983v().get(0);
    }
}
