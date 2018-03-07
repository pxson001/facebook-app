package com.facebook.feed.menu.newsfeed;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.util.event.HideEvents.ChangeRendererEvent;
import com.facebook.feed.util.event.HideEvents.StoryVisibilityEvent;
import com.facebook.feedplugins.graphqlstory.usertopictombstone.UserTopicTombstonePersistentState;
import com.facebook.feedplugins.graphqlstory.usertopictombstone.UserTopicTombstoneStoryKey;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLExploreFeed;
import com.facebook.graphql.model.GraphQLStory;

/* compiled from: all_cards_enabled_message */
class NewsFeedStoryMenuHelper$8 implements OnMenuItemClickListener {
    final /* synthetic */ FeedProps f19479a;
    final /* synthetic */ String f19480b;
    final /* synthetic */ GraphQLExploreFeed f19481c;
    final /* synthetic */ GraphQLActor f19482d;
    final /* synthetic */ GraphQLStory f19483e;
    final /* synthetic */ NewsFeedStoryMenuHelper f19484f;

    /* compiled from: all_cards_enabled_message */
    class C16811 extends AbstractDisposableFutureCallback {
        final /* synthetic */ NewsFeedStoryMenuHelper$8 f19478a;

        C16811(NewsFeedStoryMenuHelper$8 newsFeedStoryMenuHelper$8) {
            this.f19478a = newsFeedStoryMenuHelper$8;
        }

        protected final void m22831a(Object obj) {
            UserTopicTombstonePersistentState userTopicTombstonePersistentState = (UserTopicTombstonePersistentState) this.f19478a.f19484f.f().a(new UserTopicTombstoneStoryKey(this.f19478a.f19483e), this.f19478a.f19483e);
            GraphQLActor graphQLActor = this.f19478a.f19482d;
            GraphQLExploreFeed graphQLExploreFeed = this.f19478a.f19481c;
            if (!(graphQLActor == null || graphQLExploreFeed == null)) {
                userTopicTombstonePersistentState.f23485a = graphQLActor.H();
                userTopicTombstonePersistentState.f23486b = graphQLActor.aa();
                userTopicTombstonePersistentState.f23487c = graphQLExploreFeed.n();
                userTopicTombstonePersistentState.f23488d = graphQLExploreFeed.q();
            }
            this.f19478a.f19484f.K.a(this.f19478a.f19483e, this.f19478a.f19482d != null);
            this.f19478a.f19484f.f().a(new Object[]{this.f19478a.f19483e});
            this.f19478a.f19484f.c.a(new StoryVisibilityEvent(this.f19478a.f19483e.g(), null, null, StoryVisibility.HIDDEN, this.f19478a.f19483e.p()));
            this.f19478a.f19484f.c.a(new ChangeRendererEvent());
        }

        protected final void m22832a(Throwable th) {
            this.f19478a.f19484f.y.a(NewsFeedStoryMenuHelper.o, "hide topic from user failed", th);
        }
    }

    NewsFeedStoryMenuHelper$8(NewsFeedStoryMenuHelper newsFeedStoryMenuHelper, FeedProps feedProps, String str, GraphQLExploreFeed graphQLExploreFeed, GraphQLActor graphQLActor, GraphQLStory graphQLStory) {
        this.f19484f = newsFeedStoryMenuHelper;
        this.f19479a = feedProps;
        this.f19480b = str;
        this.f19481c = graphQLExploreFeed;
        this.f19482d = graphQLActor;
        this.f19483e = graphQLStory;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        this.f19484f.a(this.f19479a, menuItem.getItemId(), this.f19480b, true);
        this.f19484f.J.a(this.f19481c.n(), this.f19482d.H(), new C16811(this));
        return true;
    }
}
