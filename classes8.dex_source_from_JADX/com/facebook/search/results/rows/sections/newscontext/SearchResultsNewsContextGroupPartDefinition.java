package com.facebook.search.results.rows.sections.newscontext;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLTrendingTopicData;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.results.environment.SearchResultsFeedEnvironment;
import com.facebook.search.results.model.unit.SearchResultsNewsContextUnit;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PageIdentityCommerceCardQuery */
public class SearchResultsNewsContextGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<SearchResultsNewsContextUnit>, Void, SearchResultsFeedEnvironment> {
    private static SearchResultsNewsContextGroupPartDefinition f24634g;
    private static final Object f24635h = new Object();
    private final SearchResultsNewsContextTitlePartDefinition f24636a;
    private final SearchResultsNewsContextHeaderPhotoPartDefinition f24637b;
    private final SearchResultsNewsContextHeaderVideoPartDefinition f24638c;
    private final MultiRowPartWithIsNeeded<String, ? super SearchResultsFeedEnvironment> f24639d;
    private final SearchResultsNewsContextAttributionPartDefinition f24640e;
    private final ShareTopicFooterPartDefinition f24641f;

    private static SearchResultsNewsContextGroupPartDefinition m28050b(InjectorLike injectorLike) {
        return new SearchResultsNewsContextGroupPartDefinition((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), SearchResultsNewsContextHeaderPhotoPartDefinition.m28054a(injectorLike), SearchResultsNewsContextHeaderVideoPartDefinition.m28061a(injectorLike), SearchResultsNewsContextTitlePartDefinition.m28084a(injectorLike), SearchResultsNewsContextSummaryPartDefinition.m28079a(injectorLike), SearchResultsNewsContextSummaryComponentPartDefinition.m28071a(injectorLike), SearchResultsNewsContextAttributionPartDefinition.m28039a(injectorLike), ShareTopicFooterPartDefinition.m28096a(injectorLike));
    }

    public final Object m28051a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        String k;
        FeedProps feedProps = (FeedProps) obj;
        SearchResultsNewsContextUnit searchResultsNewsContextUnit = (SearchResultsNewsContextUnit) feedProps.a;
        SubPartsSelector.a(baseMultiRowSubParts, this.f24638c, feedProps).a(this.f24637b, searchResultsNewsContextUnit);
        baseMultiRowSubParts.a(this.f24636a, SearchResultsNewsTitlePartDefinition.m28092b(searchResultsNewsContextUnit.f23490a));
        GraphQLTrendingTopicData iL = searchResultsNewsContextUnit.f23490a.iL();
        Object obj2 = (iL == null || Strings.isNullOrEmpty(iL.k())) ? null : 1;
        if (obj2 != null) {
            k = iL.k();
        } else {
            k = null;
        }
        String str = k;
        iL = searchResultsNewsContextUnit.f23490a.iL();
        obj2 = (iL == null || Strings.isNullOrEmpty(iL.j())) ? null : 1;
        if (obj2 != null) {
            k = iL.j();
        } else {
            k = null;
        }
        String str2 = k;
        if (str != null) {
            baseMultiRowSubParts.a(this.f24639d, str);
        }
        if (str2 != null) {
            baseMultiRowSubParts.a(this.f24640e, str2);
        }
        baseMultiRowSubParts.a(this.f24641f, feedProps.a);
        return null;
    }

    public final boolean m28052a(Object obj) {
        return SearchResultsNewsTitlePartDefinition.m28091a(((SearchResultsNewsContextUnit) ((FeedProps) obj).a).f23490a);
    }

    @Inject
    public SearchResultsNewsContextGroupPartDefinition(QeAccessor qeAccessor, SearchResultsNewsContextHeaderPhotoPartDefinition searchResultsNewsContextHeaderPhotoPartDefinition, SearchResultsNewsContextHeaderVideoPartDefinition searchResultsNewsContextHeaderVideoPartDefinition, SearchResultsNewsContextTitlePartDefinition searchResultsNewsContextTitlePartDefinition, SearchResultsNewsContextSummaryPartDefinition searchResultsNewsContextSummaryPartDefinition, SearchResultsNewsContextSummaryComponentPartDefinition searchResultsNewsContextSummaryComponentPartDefinition, SearchResultsNewsContextAttributionPartDefinition searchResultsNewsContextAttributionPartDefinition, ShareTopicFooterPartDefinition shareTopicFooterPartDefinition) {
        this.f24637b = searchResultsNewsContextHeaderPhotoPartDefinition;
        this.f24638c = searchResultsNewsContextHeaderVideoPartDefinition;
        this.f24636a = searchResultsNewsContextTitlePartDefinition;
        if (!qeAccessor.a(ExperimentsForSearchAbTestModule.ao, false)) {
            searchResultsNewsContextSummaryComponentPartDefinition = searchResultsNewsContextSummaryPartDefinition;
        }
        this.f24639d = searchResultsNewsContextSummaryComponentPartDefinition;
        this.f24640e = searchResultsNewsContextAttributionPartDefinition;
        this.f24641f = shareTopicFooterPartDefinition;
    }

    public static SearchResultsNewsContextGroupPartDefinition m28049a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsNewsContextGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24635h) {
                SearchResultsNewsContextGroupPartDefinition searchResultsNewsContextGroupPartDefinition;
                if (a2 != null) {
                    searchResultsNewsContextGroupPartDefinition = (SearchResultsNewsContextGroupPartDefinition) a2.a(f24635h);
                } else {
                    searchResultsNewsContextGroupPartDefinition = f24634g;
                }
                if (searchResultsNewsContextGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28050b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24635h, b3);
                        } else {
                            f24634g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsNewsContextGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
