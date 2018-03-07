package com.facebook.reaction.feed;

import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder.Builder;
import com.facebook.feed.rows.adapter.api.MultiRowRecyclerViewAdapter;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.reaction.feed.environment.DefaultReactionFeedEnvironment;
import com.facebook.widget.listview.ScrollingViewProxy;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: big_bottom */
public class ReactionFeedAdapterFactory {
    private final MultiRowAdapterBuilder f18941a;
    private final Lazy<ReactionRootPartDefinition<DefaultReactionFeedEnvironment>> f18942b;

    public static ReactionFeedAdapterFactory m22963a(InjectorLike injectorLike) {
        return new ReactionFeedAdapterFactory(MultiRowAdapterBuilder.b(injectorLike), IdBasedLazy.a(injectorLike, 9857));
    }

    @Inject
    public ReactionFeedAdapterFactory(MultiRowAdapterBuilder multiRowAdapterBuilder, Lazy<ReactionRootPartDefinition> lazy) {
        this.f18941a = multiRowAdapterBuilder;
        this.f18942b = lazy;
    }

    public final MultiRowRecyclerViewAdapter m22964a(DefaultReactionFeedEnvironment defaultReactionFeedEnvironment, ReactionItemCollection reactionItemCollection, @Nullable ScrollingViewProxy scrollingViewProxy) {
        Builder a = this.f18941a.a(this.f18942b, reactionItemCollection);
        a.f = defaultReactionFeedEnvironment;
        a = a;
        if (scrollingViewProxy != null) {
            a.a(scrollingViewProxy);
        }
        return a.d();
    }
}
