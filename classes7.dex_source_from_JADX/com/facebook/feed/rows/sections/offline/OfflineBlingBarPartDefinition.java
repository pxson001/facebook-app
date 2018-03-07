package com.facebook.feed.rows.sections.offline;

import android.content.Context;
import android.view.View;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.offline.ui.OfflineBlingBarView;
import com.facebook.feedplugins.base.blingbar.BlingBarRootPartDefinition;
import com.facebook.feedplugins.base.blingbar.ui.DefaultBlingBarView;
import com.facebook.graphql.enums.GraphQLFeedOptimisticPublishState;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: USED_COLOR_PICKER */
public class OfflineBlingBarPartDefinition<E extends HasPositionInformation & HasPersistentState> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, OfflineBlingBarView> {
    public static final ViewType f21539a = new C18081();
    private static OfflineBlingBarPartDefinition f21540d;
    private static final Object f21541e = new Object();
    private final BlingBarRootPartDefinition<E> f21542b;
    private final OptimisticStoryStateCache f21543c;

    /* compiled from: USED_COLOR_PICKER */
    final class C18081 extends ViewType {
        C18081() {
        }

        public final View m24175a(Context context) {
            View offlineBlingBarView = new OfflineBlingBarView(context);
            View a = DefaultBlingBarView.f22918a.a(context);
            a.setId(2131558599);
            offlineBlingBarView.addView(a);
            return offlineBlingBarView;
        }
    }

    private static OfflineBlingBarPartDefinition m24177b(InjectorLike injectorLike) {
        return new OfflineBlingBarPartDefinition(BlingBarRootPartDefinition.m25429a(injectorLike), OptimisticStoryStateCache.a(injectorLike));
    }

    public final Object m24179a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(2131558599, this.f21542b, (FeedProps) obj);
        return null;
    }

    public final boolean m24180a(Object obj) {
        return (this.f21543c.a((GraphQLStory) ((FeedProps) obj).a) == GraphQLFeedOptimisticPublishState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE || 1 == 0) ? false : true;
    }

    @Inject
    public OfflineBlingBarPartDefinition(BlingBarRootPartDefinition blingBarRootPartDefinition, OptimisticStoryStateCache optimisticStoryStateCache) {
        this.f21542b = blingBarRootPartDefinition;
        this.f21543c = optimisticStoryStateCache;
    }

    public final ViewType m24178a() {
        return f21539a;
    }

    public static OfflineBlingBarPartDefinition m24176a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            OfflineBlingBarPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f21541e) {
                OfflineBlingBarPartDefinition offlineBlingBarPartDefinition;
                if (a2 != null) {
                    offlineBlingBarPartDefinition = (OfflineBlingBarPartDefinition) a2.a(f21541e);
                } else {
                    offlineBlingBarPartDefinition = f21540d;
                }
                if (offlineBlingBarPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24177b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f21541e, b3);
                        } else {
                            f21540d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = offlineBlingBarPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
