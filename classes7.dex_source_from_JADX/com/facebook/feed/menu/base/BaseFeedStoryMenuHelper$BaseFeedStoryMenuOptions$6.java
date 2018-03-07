package com.facebook.feed.menu.base;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper.BaseFeedStoryMenuOptions;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.ufiservices.event.UfiEvents.SetNotifyMeEvent;

/* compiled from: analytics_extra_data */
class BaseFeedStoryMenuHelper$BaseFeedStoryMenuOptions$6 implements OnMenuItemClickListener {
    final /* synthetic */ FeedProps f19421a;
    final /* synthetic */ String f19422b;
    final /* synthetic */ GraphQLStory f19423c;
    final /* synthetic */ boolean f19424d;
    final /* synthetic */ String f19425e;
    final /* synthetic */ String f19426f;
    final /* synthetic */ String f19427g;
    final /* synthetic */ String f19428h;
    final /* synthetic */ String f19429i;
    final /* synthetic */ String f19430j;
    final /* synthetic */ BaseFeedStoryMenuOptions f19431k;

    BaseFeedStoryMenuHelper$BaseFeedStoryMenuOptions$6(BaseFeedStoryMenuOptions baseFeedStoryMenuOptions, FeedProps feedProps, String str, GraphQLStory graphQLStory, boolean z, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.f19431k = baseFeedStoryMenuOptions;
        this.f19421a = feedProps;
        this.f19422b = str;
        this.f19423c = graphQLStory;
        this.f19424d = z;
        this.f19425e = str2;
        this.f19426f = str3;
        this.f19427g = str4;
        this.f19428h = str5;
        this.f19429i = str6;
        this.f19430j = str7;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        boolean z = false;
        this.f19431k.a.a(this.f19421a, menuItem.getItemId(), this.f19422b, true);
        if (this.f19431k.a.G.a()) {
            boolean z2;
            GraphQLQueryExecutor graphQLQueryExecutor = this.f19431k.a.H;
            SetNotifyMeLegacyMutationProvider setNotifyMeLegacyMutationProvider = this.f19431k.a.I;
            GraphQLStory graphQLStory = this.f19423c;
            if (this.f19424d) {
                z2 = false;
            } else {
                z2 = true;
            }
            graphQLQueryExecutor.a(setNotifyMeLegacyMutationProvider.a(graphQLStory, z2));
        } else {
            FeedEventBus feedEventBus = this.f19431k.a.c;
            FeedProps feedProps = this.f19421a;
            String str = this.f19425e;
            String str2 = this.f19426f;
            String str3 = this.f19427g;
            String str4 = this.f19428h;
            String str5 = this.f19429i;
            String str6 = this.f19430j;
            if (!this.f19424d) {
                z = true;
            }
            feedEventBus.a(new SetNotifyMeEvent(feedProps, str, str2, str3, str4, str5, str6, z));
        }
        return true;
    }
}
