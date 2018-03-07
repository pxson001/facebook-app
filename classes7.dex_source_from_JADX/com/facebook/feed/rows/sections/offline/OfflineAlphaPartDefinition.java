package com.facebook.feed.rows.sections.offline;

import android.content.Context;
import android.view.View;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.common.propertybag.PropertyBag;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: USER_TIMELINE */
public class OfflineAlphaPartDefinition extends BaseSinglePartDefinition<GraphQLStory, Void, AnyEnvironment, View> {
    private static OfflineAlphaPartDefinition f21529b;
    private static final Object f21530c = new Object();
    public final OptimisticStoryStateCache f21531a;

    private static OfflineAlphaPartDefinition m24166b(InjectorLike injectorLike) {
        return new OfflineAlphaPartDefinition(OptimisticStoryStateCache.a(injectorLike));
    }

    public final /* bridge */ /* synthetic */ void m24167a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1423669107);
        GraphQLFeedOptimisticPublishState a2 = this.f21531a.a((GraphQLStory) obj);
        Object obj3 = (a2 == GraphQLFeedOptimisticPublishState.POSTING || a2 == GraphQLFeedOptimisticPublishState.FAILED) ? 1 : null;
        view.setAlpha(obj3 != null ? 0.3f : 1.0f);
        Logger.a(8, EntryType.MARK_POP, 1950835973, a);
    }

    @Inject
    public OfflineAlphaPartDefinition(OptimisticStoryStateCache optimisticStoryStateCache) {
        this.f21531a = optimisticStoryStateCache;
    }

    public static OfflineAlphaPartDefinition m24165a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            OfflineAlphaPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f21530c) {
                OfflineAlphaPartDefinition offlineAlphaPartDefinition;
                if (a2 != null) {
                    offlineAlphaPartDefinition = (OfflineAlphaPartDefinition) a2.a(f21530c);
                } else {
                    offlineAlphaPartDefinition = f21529b;
                }
                if (offlineAlphaPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24166b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f21530c, b3);
                        } else {
                            f21529b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = offlineAlphaPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
