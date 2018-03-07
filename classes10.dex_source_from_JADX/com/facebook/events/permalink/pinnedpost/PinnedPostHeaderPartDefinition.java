package com.facebook.events.permalink.pinnedpost;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasAnchoredTooltipProvider;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.BaseHeaderPartDefinition;
import com.facebook.feed.rows.sections.header.DefaultHeaderPartDefinition;
import com.facebook.feed.rows.sections.header.ui.HeaderViewWithTextLayout;
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
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: background_location_update */
public class PinnedPostHeaderPartDefinition<E extends HasFeedListType & HasInvalidate & HasAnchoredTooltipProvider & HasMenuButtonProvider & HasPersistentState & HasPositionInformation & HasPrefetcher & HasRowKey & HasContext> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, HeaderViewWithTextLayout> {
    private static PinnedPostHeaderPartDefinition f18790c;
    private static final Object f18791d = new Object();
    private final DefaultHeaderPartDefinition<E> f18792a;
    private final BaseSinglePartDefinition<Void, Void, AnyEnvironment, HeaderViewWithTextLayout> f18793b = new DisableMenuPartDefinition();

    /* compiled from: background_location_update */
    class DisableMenuPartDefinition extends BaseSinglePartDefinition<Void, Void, AnyEnvironment, HeaderViewWithTextLayout> {
        public final /* bridge */ /* synthetic */ void m19095a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
            int a = Logger.a(8, EntryType.MARK_PUSH, -1655170968);
            ((HeaderViewWithTextLayout) view).setMenuButtonActive(false);
            Logger.a(8, EntryType.MARK_POP, -1483427750, a);
        }
    }

    private static PinnedPostHeaderPartDefinition m19097b(InjectorLike injectorLike) {
        return new PinnedPostHeaderPartDefinition(DefaultHeaderPartDefinition.a(injectorLike));
    }

    public final Object m19099a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f18792a, (FeedProps) obj);
        subParts.a(this.f18793b, null);
        return null;
    }

    public final boolean m19100a(Object obj) {
        return BaseHeaderPartDefinition.b((FeedProps) obj);
    }

    @Inject
    public PinnedPostHeaderPartDefinition(DefaultHeaderPartDefinition defaultHeaderPartDefinition) {
        this.f18792a = defaultHeaderPartDefinition;
    }

    public final ViewType m19098a() {
        return HeaderViewWithTextLayout.k;
    }

    public static PinnedPostHeaderPartDefinition m19096a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PinnedPostHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f18791d) {
                PinnedPostHeaderPartDefinition pinnedPostHeaderPartDefinition;
                if (a2 != null) {
                    pinnedPostHeaderPartDefinition = (PinnedPostHeaderPartDefinition) a2.a(f18791d);
                } else {
                    pinnedPostHeaderPartDefinition = f18790c;
                }
                if (pinnedPostHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m19097b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f18791d, b3);
                        } else {
                            f18790c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pinnedPostHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
