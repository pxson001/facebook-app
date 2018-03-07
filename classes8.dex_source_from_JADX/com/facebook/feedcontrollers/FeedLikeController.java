package com.facebook.feedcontrollers;

import com.facebook.api.feed.data.LegacyFeedUnitUpdater;
import com.facebook.content.event.FbEvent;
import com.facebook.controller.mutation.MutationCallback;
import com.facebook.controller.mutation.StoryMutationHelper;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.feed.loader.FeedOnDataChangeListener;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStorySet;
import com.facebook.graphql.model.StorySetHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.ufiservices.event.UfiEvents.LikeClickedEvent;
import com.facebook.ufiservices.event.UfiEvents.LikeClickedEventSubscriber;
import com.facebook.ufiservices.event.UfiEvents.PageLikeClickedEvent;
import com.facebook.ufiservices.event.UfiEvents.PageLikeClickedEventSubscriber;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: group_block */
public class FeedLikeController {
    private final FeedEventBus f11952a;
    public final StoryMutationHelper f11953b;
    private PageLikeClickSubscriber f11954c;
    private LikeClickSubscriber f11955d;
    public LegacyFeedUnitUpdater f11956e;
    public FeedOnDataChangeListener f11957f;
    public final MutationCallback<FeedUnit> f11958g = new C12831(this);

    /* compiled from: group_block */
    class C12831 implements MutationCallback<FeedUnit> {
        final /* synthetic */ FeedLikeController f11949a;

        C12831(FeedLikeController feedLikeController) {
            this.f11949a = feedLikeController;
        }

        public final void m14033a(Object obj) {
            this.f11949a.f11956e.a((FeedUnit) obj);
            if (this.f11949a.f11957f != null) {
                this.f11949a.f11957f.c();
            }
        }

        public final void m14034a(Object obj, ServiceException serviceException) {
            this.f11949a.f11956e.a((FeedUnit) obj);
            if (this.f11949a.f11957f != null) {
                this.f11949a.f11957f.c();
            }
        }

        public final /* bridge */ /* synthetic */ void m14035b(Object obj) {
        }

        public final /* bridge */ /* synthetic */ void m14036c(Object obj) {
        }
    }

    /* compiled from: group_block */
    class LikeClickSubscriber extends LikeClickedEventSubscriber {
        final /* synthetic */ FeedLikeController f11950a;

        public LikeClickSubscriber(FeedLikeController feedLikeController) {
            this.f11950a = feedLikeController;
        }

        public final void m14037b(FbEvent fbEvent) {
            LikeClickedEvent likeClickedEvent = (LikeClickedEvent) fbEvent;
            if (likeClickedEvent.a == null) {
                this.f11950a.f11953b.a(FeedProps.c(this.f11950a.f11956e.b(likeClickedEvent.b)), likeClickedEvent.d, likeClickedEvent.f, likeClickedEvent.g, null, this.f11950a.f11958g);
                return;
            }
            for (GraphQLFeedUnitEdge graphQLFeedUnitEdge : this.f11950a.f11956e.d(likeClickedEvent.c == null ? likeClickedEvent.a : likeClickedEvent.c)) {
                if (graphQLFeedUnitEdge.c() instanceof GraphQLStory) {
                    FeedProps a = StoryProps.a(FeedProps.c((GraphQLStory) graphQLFeedUnitEdge.c()), likeClickedEvent.a);
                    if (a != null) {
                        this.f11950a.f11953b.a(a, likeClickedEvent.d, likeClickedEvent.f, likeClickedEvent.g, null, this.f11950a.f11958g);
                    }
                }
            }
        }
    }

    /* compiled from: group_block */
    class PageLikeClickSubscriber extends PageLikeClickedEventSubscriber {
        final /* synthetic */ FeedLikeController f11951a;

        public PageLikeClickSubscriber(FeedLikeController feedLikeController) {
            this.f11951a = feedLikeController;
        }

        public final void m14038b(FbEvent fbEvent) {
            PageLikeClickedEvent pageLikeClickedEvent = (PageLikeClickedEvent) fbEvent;
            FeedProps feedProps = pageLikeClickedEvent.a;
            if (feedProps.a instanceof GraphQLStorySet) {
                feedProps = feedProps.a(StorySetHelper.a((GraphQLStorySet) feedProps.a));
            }
            if (feedProps.a instanceof GraphQLStory) {
                this.f11951a.f11953b.a(pageLikeClickedEvent.b, feedProps, null, pageLikeClickedEvent.e, null, null, true, this.f11951a.f11958g);
            }
        }
    }

    public static FeedLikeController m14040b(InjectorLike injectorLike) {
        return new FeedLikeController(FeedEventBus.a(injectorLike), StoryMutationHelper.b(injectorLike));
    }

    @Inject
    public FeedLikeController(FeedEventBus feedEventBus, StoryMutationHelper storyMutationHelper) {
        this.f11952a = feedEventBus;
        this.f11953b = storyMutationHelper;
    }

    public final void m14042a(LegacyFeedUnitUpdater legacyFeedUnitUpdater, @Nullable FeedOnDataChangeListener feedOnDataChangeListener) {
        this.f11955d = new LikeClickSubscriber(this);
        this.f11954c = new PageLikeClickSubscriber(this);
        this.f11952a.a(this.f11955d);
        this.f11952a.a(this.f11954c);
        this.f11956e = legacyFeedUnitUpdater;
        this.f11957f = feedOnDataChangeListener;
    }

    public static FeedLikeController m14039a(InjectorLike injectorLike) {
        return m14040b(injectorLike);
    }

    public final void m14041a() {
        if (this.f11955d != null) {
            this.f11952a.b(this.f11955d);
        }
        if (this.f11954c != null) {
            this.f11952a.b(this.f11954c);
        }
    }
}
