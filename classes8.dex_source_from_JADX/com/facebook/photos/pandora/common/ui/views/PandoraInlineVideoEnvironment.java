package com.facebook.photos.pandora.common.ui.views;

import android.view.View;
import com.facebook.feed.environment.CanShowVideoInFullScreen;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.impl.CanShowVideoInFullScreenImpl;
import com.facebook.feed.environment.impl.HasInvalidateImpl;
import com.facebook.feed.environment.impl.HasInvalidateImplProvider;
import com.facebook.feed.environment.impl.HasPersistentStateImpl;
import com.facebook.feed.rows.core.FeedListName;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.Assisted;
import com.facebook.multirow.api.DirtyListener;
import com.facebook.multirow.api.DirtyUnitObserver;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: com.facebook.widget.ratingbar.FractionalRatingBar */
public class PandoraInlineVideoEnvironment implements CanShowVideoInFullScreen, HasFeedListType, HasInvalidate, HasPersistentState, DirtyUnitObserver {
    private static final FeedListType f17543a = new C18621();
    private final HasPersistentStateImpl f17544b;
    private final CanShowVideoInFullScreenImpl f17545c;
    private final HasInvalidateImpl f17546d;

    /* compiled from: com.facebook.widget.ratingbar.FractionalRatingBar */
    final class C18621 implements FeedListType {
        C18621() {
        }

        public final FeedListName m21514a() {
            return FeedListName.PANDORA;
        }
    }

    @Inject
    public PandoraInlineVideoEnvironment(@Assisted Runnable runnable, HasPersistentStateImpl hasPersistentStateImpl, HasInvalidateImplProvider hasInvalidateImplProvider, CanShowVideoInFullScreenImpl canShowVideoInFullScreenImpl) {
        this.f17544b = hasPersistentStateImpl;
        this.f17546d = HasInvalidateImplProvider.a(runnable);
        this.f17545c = canShowVideoInFullScreenImpl;
    }

    public final FeedListType m21524c() {
        return f17543a;
    }

    public final <K, T> T m21515a(ContextStateKey<K, T> contextStateKey) {
        return this.f17544b.a(contextStateKey);
    }

    public final <K, T> T m21516a(ContextStateKey<K, T> contextStateKey, CacheableEntity cacheableEntity) {
        return this.f17544b.a(contextStateKey, cacheableEntity);
    }

    public final <K, T> boolean m21522a(ContextStateKey<K, T> contextStateKey, T t) {
        return this.f17544b.a(contextStateKey, t);
    }

    public final void hL_() {
        this.f17546d.hL_();
    }

    public final void m21521a(Object... objArr) {
        this.f17546d.a(objArr);
    }

    public final void m21520a(FeedProps... feedPropsArr) {
        this.f17546d.a(feedPropsArr);
    }

    public final void a_(boolean z) {
        this.f17546d.a_(z);
    }

    public final void m21518a(GraphQLStoryAttachment graphQLStoryAttachment, View view) {
        this.f17545c.a(graphQLStoryAttachment, view);
    }

    public final void m21517a(GraphQLStoryAttachment graphQLStoryAttachment) {
        this.f17545c.a(graphQLStoryAttachment);
    }

    public final void m21523b(GraphQLStoryAttachment graphQLStoryAttachment) {
        this.f17545c.b(graphQLStoryAttachment);
    }

    public final boolean m21525c(GraphQLStoryAttachment graphQLStoryAttachment) {
        return this.f17545c.c(graphQLStoryAttachment);
    }

    public final void m21519a(@Nullable DirtyListener dirtyListener) {
        this.f17546d.a(dirtyListener);
    }
}
