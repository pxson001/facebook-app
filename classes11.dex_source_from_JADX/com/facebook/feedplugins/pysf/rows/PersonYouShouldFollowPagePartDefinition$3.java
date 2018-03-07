package com.facebook.feedplugins.pysf.rows;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.controller.mutation.util.FeedbackGraphQLGenerator;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.friends.FriendingClient;
import com.facebook.friends.FriendingStartOperationHelper;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLPeopleYouShouldFollowFeedUnit;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.base.Functions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: checkin_story_preview */
public class PersonYouShouldFollowPagePartDefinition$3 implements OnClickListener {
    final /* synthetic */ PersonYouShouldFollowPagePartDefinition$Props f8836a;
    final /* synthetic */ PersonYouShouldFollowPagePartDefinition f8837b;

    public PersonYouShouldFollowPagePartDefinition$3(PersonYouShouldFollowPagePartDefinition personYouShouldFollowPagePartDefinition, PersonYouShouldFollowPagePartDefinition$Props personYouShouldFollowPagePartDefinition$Props) {
        this.f8837b = personYouShouldFollowPagePartDefinition;
        this.f8836a = personYouShouldFollowPagePartDefinition$Props;
    }

    public void onClick(View view) {
        HoneyAnalyticsEvent honeyAnalyticsEvent;
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1335179144);
        NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder = this.f8837b.k;
        ArrayNode a2 = GraphQLHelper.a(this.f8836a.f8839b, this.f8836a.f8838a);
        if (NewsFeedAnalyticsEventBuilder.B(a2)) {
            honeyAnalyticsEvent = null;
        } else {
            HoneyClientEvent a3 = new HoneyClientEvent("pysf_xout").a("tracking", a2);
            a3.c = "native_newsfeed";
            honeyAnalyticsEvent = a3;
        }
        this.f8837b.l.a(honeyAnalyticsEvent);
        FriendingClient friendingClient = this.f8837b.j;
        String P = this.f8836a.f8839b.m().P();
        Bundle bundle = new Bundle();
        bundle.putString("blacklistPeopleYouShouldFollowParamsKey", P);
        ListenableFuture a4 = Futures.a(FriendingStartOperationHelper.a(BlueServiceOperationFactoryDetour.a(friendingClient.f, "friending_blacklist_people_you_should_follow", bundle, ErrorPropagation.BY_EXCEPTION, null, 1973538276)), Functions.constant(null), friendingClient.l);
        GraphQLPeopleYouShouldFollowFeedUnit a5 = this.f8837b.h.a(this.f8836a.f8838a, this.f8836a.f8839b.k());
        if (a5 != null) {
            ((FeedbackGraphQLGenerator) this.f8837b.i.get()).a(a5.g(), a5);
        }
        Logger.a(2, EntryType.UI_INPUT_END, -1861278300, a);
    }
}
