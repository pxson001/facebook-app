package com.facebook.feed.menu.base;

import android.app.Activity;
import android.content.Context;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.facebook.analytics.CurationMechanism;
import com.facebook.common.util.ContextUtils;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper.BaseFeedStoryMenuOptions;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.reviews.util.intent.StoryReviewComposerLauncherAndHandler;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;

/* compiled from: analytics_extra_data */
class BaseFeedStoryMenuHelper$BaseFeedStoryMenuOptions$5 implements OnMenuItemClickListener {
    final /* synthetic */ FeedProps f19415a;
    final /* synthetic */ int f19416b;
    final /* synthetic */ String f19417c;
    final /* synthetic */ GraphQLStory f19418d;
    final /* synthetic */ Context f19419e;
    final /* synthetic */ BaseFeedStoryMenuOptions f19420f;

    BaseFeedStoryMenuHelper$BaseFeedStoryMenuOptions$5(BaseFeedStoryMenuOptions baseFeedStoryMenuOptions, FeedProps feedProps, int i, String str, GraphQLStory graphQLStory, Context context) {
        this.f19420f = baseFeedStoryMenuOptions;
        this.f19415a = feedProps;
        this.f19416b = i;
        this.f19417c = str;
        this.f19418d = graphQLStory;
        this.f19419e = context;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        this.f19420f.a.a(this.f19415a, this.f19416b, this.f19417c, true);
        BaseFeedStoryMenuOptions baseFeedStoryMenuOptions = this.f19420f;
        GraphQLStory graphQLStory = this.f19418d;
        if (!((StoryReviewComposerLauncherAndHandler) baseFeedStoryMenuOptions.a.A.get()).a(graphQLStory, 1759, (Activity) ContextUtils.a(this.f19419e, Activity.class), baseFeedStoryMenuOptions.a(), baseFeedStoryMenuOptions.a.b(), CurationMechanism.EDIT_MENU)) {
            ((Toaster) baseFeedStoryMenuOptions.a.d.get()).b(new ToastBuilder(2131235331));
        }
        return true;
    }
}
