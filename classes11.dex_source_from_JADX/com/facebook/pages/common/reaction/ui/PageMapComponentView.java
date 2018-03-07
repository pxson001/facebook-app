package com.facebook.pages.common.reaction.ui;

import android.content.Context;
import android.graphics.RectF;
import android.support.v4.app.FragmentActivity;
import com.facebook.android.maps.StaticMapView.StaticMapOptions;
import com.facebook.android.maps.model.LatLng;
import com.facebook.common.util.ContextUtils;
import com.facebook.graphql.enums.GraphQLPlaceType;
import com.facebook.maps.FbStaticMapView;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLInterfaces.ReactionGeoRectangleFields;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.google.common.base.Preconditions;
import java.util.ArrayList;

/* compiled from: search_longitude */
public class PageMapComponentView extends CustomFrameLayout {
    private final StaticMapOptions f2176a = new StaticMapOptions("pages_multi_locations_map");
    private final FbStaticMapView f2177b;

    public PageMapComponentView(Context context) {
        super(context);
        setContentView(2130906065);
        this.f2177b = (FbStaticMapView) c(2131565617);
        this.f2177b.a(ZeroFeatureKey.VIEW_MAP_INTERSTITIAL, ((FragmentActivity) ContextUtils.a(getContext(), FragmentActivity.class)).kO_(), null);
    }

    public final void m3170a(boolean z, ArrayList<LatLng> arrayList, ReactionGeoRectangleFields reactionGeoRectangleFields, int i, GraphQLPlaceType graphQLPlaceType) {
        Preconditions.checkArgument(!arrayList.isEmpty());
        StaticMapOptions a = this.f2176a.a();
        if (z) {
            this.f2177b.a(graphQLPlaceType == GraphQLPlaceType.PLACE ? this.f2177b.getResources().getDrawable(2130841143) : null, 0.5f, 0.93f);
            a.a(i).a(((LatLng) arrayList.get(0)).a, ((LatLng) arrayList.get(0)).b);
            if (reactionGeoRectangleFields != null) {
                a.a(new RectF((float) reactionGeoRectangleFields.d(), (float) reactionGeoRectangleFields.b(), (float) reactionGeoRectangleFields.a(), (float) reactionGeoRectangleFields.c()));
            }
        } else {
            a.a(arrayList, "red");
        }
        this.f2177b.setMapOptions(a);
    }
}
