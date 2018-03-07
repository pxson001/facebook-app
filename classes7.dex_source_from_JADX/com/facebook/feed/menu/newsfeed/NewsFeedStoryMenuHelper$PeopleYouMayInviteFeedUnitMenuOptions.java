package com.facebook.feed.menu.newsfeed;

import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.fbui.menu.MenuItemImpl;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper.BaseFeedStoryMenuOptions;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.FeedTrackableUtil;
import com.facebook.graphql.model.GraphQLPeopleYouMayInviteFeedUnit;
import com.fasterxml.jackson.databind.node.ArrayNode;

/* compiled from: all_cards_enabled_message */
public class NewsFeedStoryMenuHelper$PeopleYouMayInviteFeedUnitMenuOptions extends BaseFeedStoryMenuOptions<GraphQLPeopleYouMayInviteFeedUnit> {
    public final /* synthetic */ NewsFeedStoryMenuHelper f19534b;

    public final void m22846a(Menu menu, FeedProps<GraphQLPeopleYouMayInviteFeedUnit> feedProps, final View view) {
        HoneyAnalyticsEvent honeyAnalyticsEvent;
        final GraphQLPeopleYouMayInviteFeedUnit graphQLPeopleYouMayInviteFeedUnit = (GraphQLPeopleYouMayInviteFeedUnit) feedProps.a;
        MenuItem add = menu.add(2131230747);
        if (add instanceof MenuItemImpl) {
            ((MenuItemImpl) add).a(2131239084);
        }
        add.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
            final /* synthetic */ NewsFeedStoryMenuHelper$PeopleYouMayInviteFeedUnitMenuOptions f19533c;

            public boolean onMenuItemClick(MenuItem menuItem) {
                HoneyAnalyticsEvent honeyAnalyticsEvent;
                NewsFeedStoryMenuHelper$PeopleYouMayInviteFeedUnitMenuOptions newsFeedStoryMenuHelper$PeopleYouMayInviteFeedUnitMenuOptions = this.f19533c;
                View view = view;
                GraphQLPeopleYouMayInviteFeedUnit graphQLPeopleYouMayInviteFeedUnit = graphQLPeopleYouMayInviteFeedUnit;
                Uri build = new Builder().scheme(FBLinks.a).authority("faceweb").path("f").appendQueryParameter("href", "/pymi/legal/learn_more").build();
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(build);
                newsFeedStoryMenuHelper$PeopleYouMayInviteFeedUnitMenuOptions.f19534b.d().a(intent, view.getContext());
                NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder = newsFeedStoryMenuHelper$PeopleYouMayInviteFeedUnitMenuOptions.f19534b.j;
                ArrayNode a = FeedTrackableUtil.a(graphQLPeopleYouMayInviteFeedUnit);
                if (NewsFeedAnalyticsEventBuilder.B(a)) {
                    honeyAnalyticsEvent = null;
                } else {
                    HoneyClientEvent a2 = new HoneyClientEvent("pymi_about_invites").a("tracking", a);
                    a2.c = "native_newsfeed";
                    honeyAnalyticsEvent = a2;
                }
                newsFeedStoryMenuHelper$PeopleYouMayInviteFeedUnitMenuOptions.f19534b.i.a(honeyAnalyticsEvent);
                return true;
            }
        });
        add.setIcon(2130839943);
        NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder = this.f19534b.j;
        ArrayNode a = FeedTrackableUtil.a(graphQLPeopleYouMayInviteFeedUnit);
        if (NewsFeedAnalyticsEventBuilder.B(a)) {
            honeyAnalyticsEvent = null;
        } else {
            HoneyClientEvent a2 = new HoneyClientEvent("pymi_learn_more").a("tracking", a);
            a2.c = "native_newsfeed";
            honeyAnalyticsEvent = a2;
        }
        this.f19534b.i.a(honeyAnalyticsEvent);
    }

    public NewsFeedStoryMenuHelper$PeopleYouMayInviteFeedUnitMenuOptions(NewsFeedStoryMenuHelper newsFeedStoryMenuHelper) {
        this.f19534b = newsFeedStoryMenuHelper;
        super(newsFeedStoryMenuHelper);
    }
}
