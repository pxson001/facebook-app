package com.facebook.feed.rows.sections.header;

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
import com.facebook.feed.rows.sections.header.ui.HeaderViewWithTextLayout;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.model.GraphQLPageOutcomeButton;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.StoryActionLinkHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.ultralight.Inject;

@ContextScoped
/* compiled from: iab_click_source */
public class PageOutcomeButtonHeaderPartDefinition<E extends HasAnchoredTooltipProvider & HasContext & HasFeedListType & HasInvalidate & HasMenuButtonProvider & HasPersistentState & HasPositionInformation & HasPrefetcher & HasRowKey> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, HeaderViewWithTextLayout> {
    public static final ViewType f20635a = new C08281();
    private static PageOutcomeButtonHeaderPartDefinition f20636e;
    private static final Object f20637f = new Object();
    private final DefaultHeaderPartDefinition<E> f20638b;
    private final PageOutcomeButtonPartDefinition f20639c;
    private final GatekeeperStoreImpl f20640d;

    /* compiled from: iab_click_source */
    final class C08281 extends ViewType {
        C08281() {
        }

        public final View mo1995a(Context context) {
            return new HeaderViewWithTextLayout(context, null, 2130906070);
        }
    }

    private static PageOutcomeButtonHeaderPartDefinition m28385b(InjectorLike injectorLike) {
        return new PageOutcomeButtonHeaderPartDefinition(DefaultHeaderPartDefinition.m28390a(injectorLike), PageOutcomeButtonPartDefinition.m28446a(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.mo2756a(this.f20638b, feedProps);
        subParts.mo2755a(2131562873, this.f20639c, feedProps);
        return null;
    }

    public final boolean m28388a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        if (!this.f20640d.m2189a(1042, false)) {
            return false;
        }
        GraphQLStoryActionLink c = StoryActionLinkHelper.m28076c((GraphQLStory) feedProps.f13444a);
        if (c == null || c.m22901a() == null || c.m22901a().m22301g() != 1850349541) {
            return false;
        }
        GraphQLPageOutcomeButton aG = c.aG();
        return (aG == null || aG.m23504l() == null || aG.m23502j() == null || aG.m23502j().a() == null || aG.m23502j().a().mo2924b() == null) ? false : true;
    }

    public static PageOutcomeButtonHeaderPartDefinition m28384a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PageOutcomeButtonHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20637f) {
                PageOutcomeButtonHeaderPartDefinition pageOutcomeButtonHeaderPartDefinition;
                if (a2 != null) {
                    pageOutcomeButtonHeaderPartDefinition = (PageOutcomeButtonHeaderPartDefinition) a2.mo818a(f20637f);
                } else {
                    pageOutcomeButtonHeaderPartDefinition = f20636e;
                }
                if (pageOutcomeButtonHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28385b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20637f, b3);
                        } else {
                            f20636e = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = pageOutcomeButtonHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    private PageOutcomeButtonHeaderPartDefinition(DefaultHeaderPartDefinition defaultHeaderPartDefinition, PageOutcomeButtonPartDefinition pageOutcomeButtonPartDefinition, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f20638b = defaultHeaderPartDefinition;
        this.f20639c = pageOutcomeButtonPartDefinition;
        this.f20640d = gatekeeperStoreImpl;
    }

    public final ViewType<HeaderViewWithTextLayout> mo2547a() {
        return f20635a;
    }
}
