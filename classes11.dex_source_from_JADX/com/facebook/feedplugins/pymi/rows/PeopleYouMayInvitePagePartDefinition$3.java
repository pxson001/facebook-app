package com.facebook.feedplugins.pymi.rows;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feedplugins.pymi.logging.PeopleYouMayInviteLogger.Events;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLPeopleYouMayInviteFeedUnit;
import com.facebook.graphql.model.GraphQLPeopleYouMayInviteFeedUnitContactsEdge;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.fasterxml.jackson.databind.node.ArrayNode;

/* compiled from: cleanup */
public class PeopleYouMayInvitePagePartDefinition$3 implements OnClickListener {
    final /* synthetic */ PeopleYouMayInvitePagePartDefinition$Props f8779a;
    final /* synthetic */ PeopleYouMayInvitePagePartDefinition f8780b;

    public PeopleYouMayInvitePagePartDefinition$3(PeopleYouMayInvitePagePartDefinition peopleYouMayInvitePagePartDefinition, PeopleYouMayInvitePagePartDefinition$Props peopleYouMayInvitePagePartDefinition$Props) {
        this.f8780b = peopleYouMayInvitePagePartDefinition;
        this.f8779a = peopleYouMayInvitePagePartDefinition$Props;
    }

    public void onClick(View view) {
        HoneyAnalyticsEvent honeyAnalyticsEvent;
        int a = Logger.a(2, EntryType.UI_INPUT_START, 867864687);
        GraphQLPeopleYouMayInviteFeedUnitContactsEdge graphQLPeopleYouMayInviteFeedUnitContactsEdge = this.f8779a.f8793a;
        GraphQLPeopleYouMayInviteFeedUnit graphQLPeopleYouMayInviteFeedUnit = this.f8779a.f8794b;
        String k = graphQLPeopleYouMayInviteFeedUnitContactsEdge.k();
        NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder = this.f8780b.b;
        ArrayNode a2 = GraphQLHelper.a(graphQLPeopleYouMayInviteFeedUnitContactsEdge, graphQLPeopleYouMayInviteFeedUnit);
        if (NewsFeedAnalyticsEventBuilder.B(a2)) {
            honeyAnalyticsEvent = null;
        } else {
            HoneyClientEvent a3 = new HoneyClientEvent("pymi_xout").a("tracking", a2);
            a3.c = "native_newsfeed";
            honeyAnalyticsEvent = a3;
        }
        this.f8780b.c.c(honeyAnalyticsEvent);
        this.f8780b.g.m9514a();
        this.f8780b.g.m9515a(Events.XOUT);
        this.f8780b.h.a(PeopleYouMayInvitePagePartDefinition.a(this.f8780b, k));
        GraphQLPeopleYouMayInviteFeedUnit a4 = this.f8780b.e.a(graphQLPeopleYouMayInviteFeedUnit, k);
        if (a4 != null) {
            this.f8780b.f.m9511a(a4);
        }
        Logger.a(2, EntryType.UI_INPUT_END, -71797454, a);
    }
}
