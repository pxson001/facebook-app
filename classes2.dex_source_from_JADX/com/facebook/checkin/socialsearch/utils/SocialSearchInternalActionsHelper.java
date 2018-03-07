package com.facebook.checkin.socialsearch.utils;

import android.content.Context;
import android.view.Menu;
import com.facebook.checkin.abtest.CheckinAbTestGatekeepers;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: network_info_req_bw_ingress_max */
public class SocialSearchInternalActionsHelper {
    public final FbUriIntentHandler f12514a;
    private final CheckinAbTestGatekeepers f12515b;

    public static SocialSearchInternalActionsHelper m18598a(InjectorLike injectorLike) {
        return new SocialSearchInternalActionsHelper(FbUriIntentHandler.m8626a(injectorLike), CheckinAbTestGatekeepers.m10687b(injectorLike));
    }

    @Inject
    public SocialSearchInternalActionsHelper(FbUriIntentHandler fbUriIntentHandler, CheckinAbTestGatekeepers checkinAbTestGatekeepers) {
        this.f12514a = fbUriIntentHandler;
        this.f12515b = checkinAbTestGatekeepers;
    }

    public final boolean m18600a(FeedUnit feedUnit) {
        if (!this.f12515b.f6337a.m2189a(446, false) || !(feedUnit instanceof GraphQLStory)) {
            return false;
        }
        GraphQLStory graphQLStory = (GraphQLStory) feedUnit;
        if (graphQLStory.m22350c() == null) {
            return false;
        }
        if ((graphQLStory.m22327M() == null || graphQLStory.m22327M().size() == 0) && graphQLStory.m22330P()) {
            return true;
        }
        return false;
    }

    public final void m18599a(Menu menu, GraphQLStory graphQLStory, Context context) {
        menu.add("[FB] Add Social Recs List").setOnMenuItemClickListener(new 1(this, graphQLStory, context));
    }
}
