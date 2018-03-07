package com.facebook.feed.menu.newsfeed;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feedplugins.graphqlstory.followup.FollowUpPersistentState;
import com.facebook.feedplugins.graphqlstory.followup.FollowUpPersistentStateKey;
import com.facebook.graphql.enums.ChainingSectionViewState;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import org.json.JSONObject;

/* compiled from: all_cards_enabled_message */
public class C1686x9af7fa9c {
    final /* synthetic */ NewsFeedStoryMenuHelper f19501a;

    /* compiled from: all_cards_enabled_message */
    public class C16841 implements OnMenuItemClickListener {
        final /* synthetic */ GraphQLStory f19493a;
        final /* synthetic */ GraphQLStoryAttachment f19494b;
        final /* synthetic */ FeedProps f19495c;
        final /* synthetic */ C1686x9af7fa9c f19496d;

        public C16841(C1686x9af7fa9c c1686x9af7fa9c, GraphQLStory graphQLStory, GraphQLStoryAttachment graphQLStoryAttachment, FeedProps feedProps) {
            this.f19496d = c1686x9af7fa9c;
            this.f19493a = graphQLStory;
            this.f19494b = graphQLStoryAttachment;
            this.f19495c = feedProps;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            C1686x9af7fa9c.m22841a(this.f19496d, this.f19493a);
            String a = C1686x9af7fa9c.m22839a(this.f19496d, this.f19494b);
            if (a != null) {
                this.f19496d.f19501a.I.a(a);
                C1686x9af7fa9c.m22840a(this.f19496d, this.f19495c, "irrelevant");
            }
            return true;
        }
    }

    /* compiled from: all_cards_enabled_message */
    public class C16852 implements OnMenuItemClickListener {
        final /* synthetic */ GraphQLStory f19497a;
        final /* synthetic */ GraphQLStoryAttachment f19498b;
        final /* synthetic */ FeedProps f19499c;
        final /* synthetic */ C1686x9af7fa9c f19500d;

        public C16852(C1686x9af7fa9c c1686x9af7fa9c, GraphQLStory graphQLStory, GraphQLStoryAttachment graphQLStoryAttachment, FeedProps feedProps) {
            this.f19500d = c1686x9af7fa9c;
            this.f19497a = graphQLStory;
            this.f19498b = graphQLStoryAttachment;
            this.f19499c = feedProps;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            C1686x9af7fa9c.m22841a(this.f19500d, this.f19497a);
            String a = C1686x9af7fa9c.m22839a(this.f19500d, this.f19498b);
            if (a != null) {
                this.f19500d.f19501a.I.b(a);
                C1686x9af7fa9c.m22840a(this.f19500d, this.f19499c, "inappropriate");
            }
            return true;
        }
    }

    public C1686x9af7fa9c(NewsFeedStoryMenuHelper newsFeedStoryMenuHelper) {
        this.f19501a = newsFeedStoryMenuHelper;
    }

    public static void m22841a(C1686x9af7fa9c c1686x9af7fa9c, GraphQLStory graphQLStory) {
        ((FollowUpPersistentState) c1686x9af7fa9c.f19501a.f().a(new FollowUpPersistentStateKey(graphQLStory), graphQLStory)).b = ChainingSectionViewState.START_HIDING;
        c1686x9af7fa9c.f19501a.f().a(new Object[]{graphQLStory});
    }

    public static String m22839a(C1686x9af7fa9c c1686x9af7fa9c, GraphQLStoryAttachment graphQLStoryAttachment) {
        try {
            return new JSONObject(graphQLStoryAttachment.B()).getString("chained_article_id");
        } catch (Throwable e) {
            c1686x9af7fa9c.f19501a.y.a(NewsFeedStoryMenuHelper.o, "unable to extract chained_article_id from:" + graphQLStoryAttachment.B(), e);
            return null;
        }
    }

    public static void m22840a(C1686x9af7fa9c c1686x9af7fa9c, FeedProps feedProps, String str) {
        AnalyticsLogger analyticsLogger = c1686x9af7fa9c.f19501a.i;
        NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder = c1686x9af7fa9c.f19501a.j;
        analyticsLogger.a(NewsFeedAnalyticsEventBuilder.i(TrackableFeedProps.a(feedProps), str));
    }
}
