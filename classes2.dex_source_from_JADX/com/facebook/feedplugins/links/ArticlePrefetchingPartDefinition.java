package com.facebook.feedplugins.links;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.graphql.model.GraphQLInstantArticle;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.instantarticles.fetcher.InstantArticlesFetcher;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: fetch_transaction_list */
public class ArticlePrefetchingPartDefinition extends BaseSinglePartDefinition<GraphQLStoryAttachment, State, AnyEnvironment, View> {
    private static ArticlePrefetchingPartDefinition f23854c;
    private static final Object f23855d = new Object();
    public final Provider<TriState> f23856a;
    public final InstantArticlesFetcher f23857b;

    private static ArticlePrefetchingPartDefinition m32247b(InjectorLike injectorLike) {
        return new ArticlePrefetchingPartDefinition(IdBasedProvider.m1811a(injectorLike, 760), InstantArticlesFetcher.m32251a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        String m;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) obj;
        if (((TriState) this.f23856a.get()).asBoolean(false)) {
            if (graphQLStoryAttachment.m23987z() != null) {
                GraphQLInstantArticle dB = graphQLStoryAttachment.m23987z().dB();
                if (dB != null) {
                    m = dB.m23349m();
                }
            }
            m = null;
        } else {
            m = null;
        }
        return new State(m);
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1175973681);
        State state = (State) obj2;
        if (view != null) {
            Context context = view.getContext();
            if (((TriState) this.f23856a.get()).asBoolean(false) && !StringUtil.m3589a(state.b)) {
                state.a = this.f23857b.m32258a(context, state.b);
            }
        }
        Logger.a(8, EntryType.MARK_POP, 1656628969, a);
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        State state = (State) obj2;
        if (state.a != null) {
            state.a.a();
            state.a = null;
        }
    }

    @Inject
    public ArticlePrefetchingPartDefinition(Provider<TriState> provider, InstantArticlesFetcher instantArticlesFetcher) {
        this.f23856a = provider;
        this.f23857b = instantArticlesFetcher;
    }

    public static ArticlePrefetchingPartDefinition m32246a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ArticlePrefetchingPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f23855d) {
                ArticlePrefetchingPartDefinition articlePrefetchingPartDefinition;
                if (a2 != null) {
                    articlePrefetchingPartDefinition = (ArticlePrefetchingPartDefinition) a2.mo818a(f23855d);
                } else {
                    articlePrefetchingPartDefinition = f23854c;
                }
                if (articlePrefetchingPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32247b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f23855d, b3);
                        } else {
                            f23854c = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = articlePrefetchingPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
