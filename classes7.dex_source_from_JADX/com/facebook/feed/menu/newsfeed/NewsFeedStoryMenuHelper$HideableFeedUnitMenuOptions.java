package com.facebook.feed.menu.newsfeed;

import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper.BaseFeedStoryMenuOptions;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStorySet;
import com.facebook.graphql.model.HideableUnit;
import com.facebook.graphql.model.NegativeFeedbackActionsUnit;
import com.facebook.graphql.model.StorySetHelper;

/* compiled from: all_cards_enabled_message */
public abstract class NewsFeedStoryMenuHelper$HideableFeedUnitMenuOptions<T extends HideableUnit> extends BaseFeedStoryMenuOptions<T> {
    public final /* synthetic */ NewsFeedStoryMenuHelper f19487c;

    public abstract HoneyClientEvent mo1461a(T t, View view);

    public NewsFeedStoryMenuHelper$HideableFeedUnitMenuOptions(NewsFeedStoryMenuHelper newsFeedStoryMenuHelper) {
        this.f19487c = newsFeedStoryMenuHelper;
        super(newsFeedStoryMenuHelper);
    }

    public final boolean m22835a(FeedProps<T> feedProps) {
        if (super.a(feedProps)) {
            return true;
        }
        FeedUnit feedUnit = (FeedUnit) feedProps.a;
        if (feedUnit instanceof NegativeFeedbackActionsUnit) {
            return c(feedProps) || NewsFeedStoryMenuHelper.d(this.f19487c, feedUnit);
        } else {
            return true;
        }
    }

    public final void m22834a(Menu menu, final FeedProps<T> feedProps, final View view) {
        super.a(menu, feedProps, view);
        final FeedUnit feedUnit = (FeedUnit) feedProps.a;
        if (feedUnit instanceof NegativeFeedbackActionsUnit) {
            this.f19487c.a(menu, feedProps, view);
            if (feedUnit instanceof GraphQLStorySet) {
                GraphQLStory a = StorySetHelper.a((GraphQLStorySet) feedProps.a);
                if (c(a)) {
                    a(menu, feedProps.a(a));
                }
            }
        } else {
            menu.add(2131233432).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                final /* synthetic */ NewsFeedStoryMenuHelper$HideableFeedUnitMenuOptions f19505d;

                public boolean onMenuItemClick(MenuItem menuItem) {
                    this.f19505d.f19487c.a(feedUnit, view);
                    NewsFeedStoryMenuHelper$HideableFeedUnitMenuOptions newsFeedStoryMenuHelper$HideableFeedUnitMenuOptions = this.f19505d;
                    FeedProps feedProps = feedProps;
                    View view = view;
                    NewsFeedStoryMenuHelper.a(newsFeedStoryMenuHelper$HideableFeedUnitMenuOptions.f19487c, feedProps, view, newsFeedStoryMenuHelper$HideableFeedUnitMenuOptions.mo1461a((HideableUnit) feedProps.a, view));
                    return true;
                }
            });
        }
        if (NewsFeedStoryMenuHelper.d(this.f19487c, feedUnit)) {
            NewsFeedStoryMenuHelper.d(this.f19487c, menu, feedProps, view);
        }
    }
}
