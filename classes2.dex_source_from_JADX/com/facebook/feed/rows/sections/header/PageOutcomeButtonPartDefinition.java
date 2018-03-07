package com.facebook.feed.rows.sections.header;

import android.content.Context;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.SecureContextHelper;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLPageOutcomeButton;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryActionLinkHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.FbDraweePartDefinition;
import com.facebook.multirow.parts.FbDraweePartDefinition.Props.Builder;
import com.facebook.ultralight.Inject;

@ContextScoped
/* compiled from: http_liger */
public class PageOutcomeButtonPartDefinition<E extends HasPrefetcher & HasRowKey & HasPersistentState> extends BaseSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, FbDraweeView> {
    private static final CallerContext f20717a = CallerContext.m9060a(PageOutcomeButtonPartDefinition.class);
    private static PageOutcomeButtonPartDefinition f20718h;
    private static final Object f20719i = new Object();
    private final ClickListenerPartDefinition f20720b;
    private final FbDraweePartDefinition<E> f20721c;
    public final Lazy<SecureContextHelper> f20722d;
    public final Lazy<AnalyticsLogger> f20723e;
    public final Lazy<UriIntentMapper> f20724f;
    public final Lazy<FbErrorReporter> f20725g;

    private static PageOutcomeButtonPartDefinition m28447b(InjectorLike injectorLike) {
        return new PageOutcomeButtonPartDefinition(ClickListenerPartDefinition.m19353a(injectorLike), FbDraweePartDefinition.m27839a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 968), IdBasedSingletonScopeProvider.m1810b(injectorLike, 175), IdBasedSingletonScopeProvider.m1810b(injectorLike, 2436), IdBasedSingletonScopeProvider.m1810b(injectorLike, 494));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLPageOutcomeButton aG = StoryActionLinkHelper.m28076c((GraphQLStory) feedProps.f13444a).aG();
        subParts.mo2756a(this.f20720b, new PageOutcomeButtonClickListener(this, feedProps, this.f20722d, this.f20724f, this.f20725g, this.f20723e));
        SinglePartDefinition singlePartDefinition = this.f20721c;
        Builder a = new Builder().m29720a(aG.m23502j().a().mo2924b());
        a.f21889c = f20717a;
        a = a;
        a.f21892f = true;
        subParts.mo2756a(singlePartDefinition, a.m29721a());
        return null;
    }

    public static PageOutcomeButtonPartDefinition m28446a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PageOutcomeButtonPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20719i) {
                PageOutcomeButtonPartDefinition pageOutcomeButtonPartDefinition;
                if (a2 != null) {
                    pageOutcomeButtonPartDefinition = (PageOutcomeButtonPartDefinition) a2.mo818a(f20719i);
                } else {
                    pageOutcomeButtonPartDefinition = f20718h;
                }
                if (pageOutcomeButtonPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28447b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20719i, b3);
                        } else {
                            f20718h = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = pageOutcomeButtonPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    private PageOutcomeButtonPartDefinition(ClickListenerPartDefinition clickListenerPartDefinition, FbDraweePartDefinition fbDraweePartDefinition, Lazy<SecureContextHelper> lazy, Lazy<AnalyticsLogger> lazy2, Lazy<UriIntentMapper> lazy3, Lazy<FbErrorReporter> lazy4) {
        this.f20720b = clickListenerPartDefinition;
        this.f20721c = fbDraweePartDefinition;
        this.f20722d = lazy;
        this.f20723e = lazy2;
        this.f20724f = lazy3;
        this.f20725g = lazy4;
    }
}
