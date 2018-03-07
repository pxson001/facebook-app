package com.facebook.feedplugins.attachments.collage;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.collage.PhotoGridProperties;
import com.facebook.feed.collage.ui.CollageAttachmentView;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasImageLoadListener;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.localstats.LocalStatsLogger;
import com.facebook.localstats.LocalStatsLoggerImpl;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.photos.warning.DisturbingMediaTracker;
import com.facebook.photos.warning.DisturbingMediaView;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: groups_ufi */
public class CollageAttachmentWithWarningsPartDefinition<E extends HasFeedListType & HasInvalidate & HasImageLoadListener & HasPositionInformation & HasPrefetcher> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, State, E, CollageAttachmentView> {
    private static CollageAttachmentWithWarningsPartDefinition f21516e;
    private static final Object f21517f = new Object();
    private final PhotoGridProperties f21518a;
    public final Lazy<DisturbingMediaTracker> f21519b;
    public final Lazy<LocalStatsLogger> f21520c;
    private final CollageAttachmentPartDefinition<E> f21521d;

    private static CollageAttachmentWithWarningsPartDefinition m29226b(InjectorLike injectorLike) {
        return new CollageAttachmentWithWarningsPartDefinition(CollageAttachmentPartDefinition.m29238a(injectorLike), PhotoGridProperties.m28823b(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 9505), IdBasedSingletonScopeProvider.m1810b(injectorLike, 2477));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        Flattenable flattenable = feedProps.f13444a;
        subParts.mo2756a(this.f21521d, feedProps);
        State state = new State(this.f21518a.m28829a(feedProps));
        if (m29225a(state.a)) {
            state.c = new 1(this, state);
        }
        return state;
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1618870682);
        m29224a((State) obj2, (CollageAttachmentView) view);
        Logger.a(8, EntryType.MARK_POP, -571085273, a);
    }

    public final boolean m29231a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        return this.f21521d.m29253a(feedProps) && m29227b(feedProps);
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        State state = (State) obj2;
        boolean z = false;
        if (state.b != null) {
            state.b.b(false);
            state.b.setSeePhotoOnClickListener(null);
            state.b = null;
            return;
        }
        if (!m29225a(state.a)) {
            z = true;
        }
        Preconditions.checkState(z);
    }

    public static CollageAttachmentWithWarningsPartDefinition m29223a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CollageAttachmentWithWarningsPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f21517f) {
                CollageAttachmentWithWarningsPartDefinition collageAttachmentWithWarningsPartDefinition;
                if (a2 != null) {
                    collageAttachmentWithWarningsPartDefinition = (CollageAttachmentWithWarningsPartDefinition) a2.mo818a(f21517f);
                } else {
                    collageAttachmentWithWarningsPartDefinition = f21516e;
                }
                if (collageAttachmentWithWarningsPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m29226b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f21517f, b3);
                        } else {
                            f21516e = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = collageAttachmentWithWarningsPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public CollageAttachmentWithWarningsPartDefinition(CollageAttachmentPartDefinition collageAttachmentPartDefinition, PhotoGridProperties photoGridProperties, Lazy<DisturbingMediaTracker> lazy, Lazy<LocalStatsLogger> lazy2) {
        this.f21521d = collageAttachmentPartDefinition;
        this.f21518a = photoGridProperties;
        this.f21519b = lazy;
        this.f21520c = lazy2;
    }

    public final ViewType mo2547a() {
        return this.f21521d.mo2547a();
    }

    private void m29224a(State state, CollageAttachmentView collageAttachmentView) {
        if (m29225a(state.a)) {
            state.b = DisturbingMediaView.a(collageAttachmentView);
            state.b.setSeePhotoOnClickListener(state.c);
            state.b.a(false);
        }
    }

    private boolean m29227b(@Nullable FeedProps<GraphQLStoryAttachment> feedProps) {
        if (!m29225a(this.f21518a.m28829a((FeedProps) feedProps))) {
            return false;
        }
        ((LocalStatsLoggerImpl) this.f21520c.get()).m13616a(6946818);
        return true;
    }

    private boolean m29225a(ImmutableList<FeedProps<GraphQLStoryAttachment>> immutableList) {
        for (int i = 0; i < immutableList.size(); i++) {
            GraphQLMedia r = ((GraphQLStoryAttachment) ((FeedProps) immutableList.get(i)).f13444a).m23979r();
            Preconditions.checkNotNull(r);
            if (r.ak() && !((DisturbingMediaTracker) this.f21519b.get()).a(r)) {
                return true;
            }
        }
        return false;
    }
}
