package com.facebook.feed.rows.sections.offline;

import android.content.Context;
import android.view.View;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.animators.OfflinePartAnimator;
import com.facebook.feedplugins.offline.OfflineStoryKey;
import com.facebook.feedplugins.offline.OfflineStoryPersistentState;
import com.facebook.graphql.enums.GraphQLFeedOptimisticPublishState;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: UPDATE_SNAPSHOT_DB_WITH_SERVER_ENTRIES */
public class OfflinePartAnimationPartDefinition extends BaseSinglePartDefinition<GraphQLStory, OfflineStoryPersistentState, HasPersistentState, View> {
    private static OfflinePartAnimationPartDefinition f21557c;
    private static final Object f21558d = new Object();
    public final OfflinePartAnimator f21559a;
    public final OptimisticStoryStateCache f21560b;

    private static OfflinePartAnimationPartDefinition m24193b(InjectorLike injectorLike) {
        return new OfflinePartAnimationPartDefinition(OfflinePartAnimator.m23093a(injectorLike), OptimisticStoryStateCache.a(injectorLike));
    }

    public final Object m24194a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLStory graphQLStory = (GraphQLStory) obj;
        return (OfflineStoryPersistentState) ((HasPersistentState) anyEnvironment).a(new OfflineStoryKey(graphQLStory), graphQLStory);
    }

    public final /* bridge */ /* synthetic */ void m24195a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -456642123);
        OfflineStoryPersistentState offlineStoryPersistentState = (OfflineStoryPersistentState) obj2;
        if (this.f21560b.a((GraphQLStory) obj) == GraphQLFeedOptimisticPublishState.SUCCESS && !offlineStoryPersistentState.f23557a) {
            this.f21559a.m23095a(view);
            if (!offlineStoryPersistentState.f23558b) {
                this.f21559a.m23096a(offlineStoryPersistentState);
                offlineStoryPersistentState.m25800d();
            }
        }
        Logger.a(8, EntryType.MARK_POP, -1186938087, a);
    }

    @Inject
    public OfflinePartAnimationPartDefinition(OfflinePartAnimator offlinePartAnimator, OptimisticStoryStateCache optimisticStoryStateCache) {
        this.f21559a = offlinePartAnimator;
        this.f21560b = optimisticStoryStateCache;
    }

    public static OfflinePartAnimationPartDefinition m24192a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            OfflinePartAnimationPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f21558d) {
                OfflinePartAnimationPartDefinition offlinePartAnimationPartDefinition;
                if (a2 != null) {
                    offlinePartAnimationPartDefinition = (OfflinePartAnimationPartDefinition) a2.a(f21558d);
                } else {
                    offlinePartAnimationPartDefinition = f21557c;
                }
                if (offlinePartAnimationPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24193b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f21558d, b3);
                        } else {
                            f21557c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = offlinePartAnimationPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
