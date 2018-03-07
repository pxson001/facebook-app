package com.facebook.feed.rows.sections.offline;

import android.content.Context;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.animators.OfflinePartAnimator;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.traversal.GroupPartHolder;
import com.facebook.feedplugins.offline.OfflineStoryKey;
import com.facebook.feedplugins.offline.OfflineStoryPersistentState;
import com.facebook.graphql.enums.GraphQLFeedOptimisticPublishState;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.multirow.api.MultiRowSubParts;
import com.facebook.photos.upload.serverprocessing.util.VideoProcessingUtil;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

@ContextScoped
/* compiled from: USER_REQUESTED */
public class OfflineAnimationGroupPartDefinition<E extends HasPersistentState> extends BaseMultiRowGroupPartDefinition<Props<E>, OfflineStoryPersistentState, E> {
    private static OfflineAnimationGroupPartDefinition f21534d;
    private static final Object f21535e = new Object();
    private final OfflinePartAnimator f21536a;
    private final OptimisticStoryStateCache f21537b;
    private final QeAccessor f21538c;

    /* compiled from: USER_REQUESTED */
    public interface Callbacks<E extends HasPersistentState> {
        void mo1502a(MultiRowSubParts<E> multiRowSubParts, FeedProps<GraphQLStory> feedProps, E e);
    }

    /* compiled from: USER_REQUESTED */
    public class Props<E extends HasPersistentState> {
        public final Callbacks<E> f21532a;
        public final FeedProps<GraphQLStory> f21533b;

        public Props(FeedProps<GraphQLStory> feedProps, Callbacks<E> callbacks) {
            this.f21532a = callbacks;
            this.f21533b = feedProps;
        }
    }

    private static OfflineAnimationGroupPartDefinition m24170b(InjectorLike injectorLike) {
        return new OfflineAnimationGroupPartDefinition(OfflinePartAnimator.m23093a(injectorLike), OptimisticStoryStateCache.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m24171a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        HasPersistentState hasPersistentState = (HasPersistentState) anyEnvironment;
        props.f21532a.mo1502a(baseMultiRowSubParts, props.f21533b, hasPersistentState);
        GraphQLStory graphQLStory = (GraphQLStory) props.f21533b.a;
        return (OfflineStoryPersistentState) hasPersistentState.a(new OfflineStoryKey(graphQLStory), graphQLStory);
    }

    public final void m24172a(Object obj, Object obj2, AnyEnvironment anyEnvironment, GroupPartHolder groupPartHolder) {
        Object obj3;
        OfflineStoryPersistentState offlineStoryPersistentState = (OfflineStoryPersistentState) obj2;
        GraphQLStory graphQLStory = (GraphQLStory) ((Props) obj).f21533b.a;
        GraphQLFeedOptimisticPublishState a = this.f21537b.a(graphQLStory);
        Object obj4 = ((StoryAttachmentHelper.k(graphQLStory) || StoryAttachmentHelper.n(graphQLStory)) && a == GraphQLFeedOptimisticPublishState.SUCCESS && VideoProcessingUtil.a(this.f21538c)) ? 1 : null;
        if (obj4 != null || a == GraphQLFeedOptimisticPublishState.POSTING || a == GraphQLFeedOptimisticPublishState.FAILED) {
            obj3 = 1;
        } else {
            obj3 = null;
        }
        groupPartHolder.a().setAlpha(obj3 != null ? 0.3f : 1.0f);
        if (a == GraphQLFeedOptimisticPublishState.SUCCESS && !offlineStoryPersistentState.f23557a && obj4 == null) {
            this.f21536a.m23095a(groupPartHolder.a());
            if (!offlineStoryPersistentState.f23558b) {
                this.f21536a.m23096a(offlineStoryPersistentState);
                offlineStoryPersistentState.m25800d();
            }
        }
    }

    @Inject
    public OfflineAnimationGroupPartDefinition(OfflinePartAnimator offlinePartAnimator, OptimisticStoryStateCache optimisticStoryStateCache, QeAccessor qeAccessor) {
        this.f21536a = offlinePartAnimator;
        this.f21537b = optimisticStoryStateCache;
        this.f21538c = qeAccessor;
    }

    public static OfflineAnimationGroupPartDefinition m24169a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            OfflineAnimationGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f21535e) {
                OfflineAnimationGroupPartDefinition offlineAnimationGroupPartDefinition;
                if (a2 != null) {
                    offlineAnimationGroupPartDefinition = (OfflineAnimationGroupPartDefinition) a2.a(f21535e);
                } else {
                    offlineAnimationGroupPartDefinition = f21534d;
                }
                if (offlineAnimationGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24170b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f21535e, b3);
                        } else {
                            f21534d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = offlineAnimationGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m24173a(Object obj) {
        return true;
    }

    public final void m24174b(Object obj, Object obj2, AnyEnvironment anyEnvironment, GroupPartHolder groupPartHolder) {
        OfflinePartAnimator offlinePartAnimator = this.f21536a;
        offlinePartAnimator.f19837b.remove(groupPartHolder.a());
        groupPartHolder.a().setAlpha(1.0f);
    }
}
