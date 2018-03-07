package com.facebook.pages.identity.timeline;

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
/* compiled from: page_insights_summary */
public class PageIdentityPinnedPostHeaderPartDefinition<E extends HasFeedListType & HasInvalidate & HasAnchoredTooltipProvider & HasMenuButtonProvider & HasPersistentState & HasPositionInformation & HasPrefetcher & HasRowKey & HasContext> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, PageIdentityPinnedPostHeaderView> {
    public static final ViewType<PageIdentityPinnedPostHeaderView> f4182a = new C05731();
    private static PageIdentityPinnedPostHeaderPartDefinition f4183c;
    private static final Object f4184d = new Object();
    private final DefaultHeaderPartDefinition<E> f4185b;

    /* compiled from: page_insights_summary */
    final class C05731 extends ViewType<PageIdentityPinnedPostHeaderView> {
        C05731() {
        }

        public final View m5154a(Context context) {
            return new PageIdentityPinnedPostHeaderView(context);
        }
    }

    private static PageIdentityPinnedPostHeaderPartDefinition m5156b(InjectorLike injectorLike) {
        return new PageIdentityPinnedPostHeaderPartDefinition(DefaultHeaderPartDefinition.a(injectorLike));
    }

    public final Object m5158a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(2131565520, this.f4185b, (FeedProps) obj);
        return null;
    }

    public final boolean m5159a(Object obj) {
        return BaseHeaderPartDefinition.b((FeedProps) obj);
    }

    @Inject
    public PageIdentityPinnedPostHeaderPartDefinition(DefaultHeaderPartDefinition defaultHeaderPartDefinition) {
        this.f4185b = defaultHeaderPartDefinition;
    }

    public static PageIdentityPinnedPostHeaderPartDefinition m5155a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PageIdentityPinnedPostHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f4184d) {
                PageIdentityPinnedPostHeaderPartDefinition pageIdentityPinnedPostHeaderPartDefinition;
                if (a2 != null) {
                    pageIdentityPinnedPostHeaderPartDefinition = (PageIdentityPinnedPostHeaderPartDefinition) a2.a(f4184d);
                } else {
                    pageIdentityPinnedPostHeaderPartDefinition = f4183c;
                }
                if (pageIdentityPinnedPostHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5156b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f4184d, b3);
                        } else {
                            f4183c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pageIdentityPinnedPostHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<PageIdentityPinnedPostHeaderView> m5157a() {
        return f4182a;
    }
}
