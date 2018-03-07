package com.facebook.reaction.feed.pages;

import android.content.Context;
import android.view.LayoutInflater;
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
/* compiled from: author_style */
public class PagesPinnedPostHeaderPartDefinition<E extends HasFeedListType & HasInvalidate & HasAnchoredTooltipProvider & HasMenuButtonProvider & HasPersistentState & HasPositionInformation & HasPrefetcher & HasRowKey & HasContext> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, View> {
    public static final ViewType f19134a = new C20921();
    private static PagesPinnedPostHeaderPartDefinition f19135c;
    private static final Object f19136d = new Object();
    private final DefaultHeaderPartDefinition<E> f19137b;

    /* compiled from: author_style */
    final class C20921 extends ViewType {
        C20921() {
        }

        public final View m23165a(Context context) {
            return LayoutInflater.from(context).inflate(2130906701, null);
        }
    }

    private static PagesPinnedPostHeaderPartDefinition m23167b(InjectorLike injectorLike) {
        return new PagesPinnedPostHeaderPartDefinition(DefaultHeaderPartDefinition.a(injectorLike));
    }

    public final Object m23169a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(2131566766, this.f19137b, (FeedProps) obj);
        return null;
    }

    public final boolean m23170a(Object obj) {
        return BaseHeaderPartDefinition.b((FeedProps) obj);
    }

    @Inject
    public PagesPinnedPostHeaderPartDefinition(DefaultHeaderPartDefinition defaultHeaderPartDefinition) {
        this.f19137b = defaultHeaderPartDefinition;
    }

    public final ViewType m23168a() {
        return f19134a;
    }

    public static PagesPinnedPostHeaderPartDefinition m23166a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PagesPinnedPostHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19136d) {
                PagesPinnedPostHeaderPartDefinition pagesPinnedPostHeaderPartDefinition;
                if (a2 != null) {
                    pagesPinnedPostHeaderPartDefinition = (PagesPinnedPostHeaderPartDefinition) a2.a(f19136d);
                } else {
                    pagesPinnedPostHeaderPartDefinition = f19135c;
                }
                if (pagesPinnedPostHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23167b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19136d, b3);
                        } else {
                            f19135c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pagesPinnedPostHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
