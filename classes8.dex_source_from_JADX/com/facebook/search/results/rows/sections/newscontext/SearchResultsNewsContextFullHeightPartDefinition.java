package com.facebook.search.results.rows.sections.newscontext;

import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.injectable.DisplayUtil;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLTrendingTopicData;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.FbDraweePartDefinition;
import com.facebook.multirow.parts.FbDraweePartDefinition.Props.Builder;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.multirow.parts.ViewDimensionsPartDefinition;
import com.facebook.multirow.parts.ViewDimensionsPartDefinition.DimensionData;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.model.unit.SearchResultsNewsContextUnit;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PageIdentityNuxCardQuery */
public class SearchResultsNewsContextFullHeightPartDefinition<E extends HasSearchResultsContext & HasPositionInformation & HasContext & HasPrefetcher> extends MultiRowSinglePartDefinition<FeedProps<SearchResultsNewsContextUnit>, Void, E, CustomFrameLayout> {
    public static final ViewType<CustomFrameLayout> f24625a = ViewType.a(2130904542);
    private static final CallerContext f24626b = CallerContext.a(SearchResultsNewsContextFullHeightPartDefinition.class, "keyword_search");
    private static SearchResultsNewsContextFullHeightPartDefinition f24627h;
    private static final Object f24628i = new Object();
    private final ViewDimensionsPartDefinition f24629c;
    private final TextPartDefinition f24630d;
    private final FbDraweePartDefinition f24631e;
    private final DisplayUtil f24632f;
    private final QeAccessor f24633g;

    private static SearchResultsNewsContextFullHeightPartDefinition m28045b(InjectorLike injectorLike) {
        return new SearchResultsNewsContextFullHeightPartDefinition(TextPartDefinition.a(injectorLike), ViewDimensionsPartDefinition.a(injectorLike), FbDraweePartDefinition.a(injectorLike), DisplayUtil.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m28047a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Uri a;
        HasSearchResultsContext hasSearchResultsContext = (HasSearchResultsContext) anyEnvironment;
        GraphQLTrendingTopicData iL = ((SearchResultsNewsContextUnit) ((FeedProps) obj).a).f23490a.iL();
        subParts.a(2131559692, this.f24630d, ((HasContext) hasSearchResultsContext).getContext().getString(2131239054, new Object[]{((SearchResultsNewsContextUnit) r12.a).f23490a.iM(), iL.o()}));
        subParts.a(2131562403, this.f24630d, iL.m());
        Point a2 = this.f24632f.a();
        if (a2.y < a2.x) {
            a = ImageUtil.a(iL.r());
        } else {
            a = ImageUtil.a(iL.s());
        }
        FbDraweePartDefinition fbDraweePartDefinition = this.f24631e;
        Builder a3 = FbDraweePartDefinition.a().a(a);
        a3.c = f24626b;
        subParts.a(2131560273, fbDraweePartDefinition, a3.a());
        subParts.a(2131560273, this.f24629c, new DimensionData(a2.x, a2.y - ((HasContext) hasSearchResultsContext).getContext().getResources().getDimensionPixelSize(this.f24633g.a(ExperimentsForSearchAbTestModule.bS, false) ? 2131432640 : 2131432639)));
        return null;
    }

    public final boolean m28048a(Object obj) {
        GraphQLTrendingTopicData iL = ((SearchResultsNewsContextUnit) ((FeedProps) obj).a).f23490a.iL();
        if (iL == null) {
            return false;
        }
        GraphQLImage s = iL.s();
        GraphQLImage r = iL.r();
        return (s == null || r == null || Strings.isNullOrEmpty(s.b()) || Strings.isNullOrEmpty(r.b()) || !this.f24633g.a(ExperimentsForSearchAbTestModule.bO, false)) ? false : true;
    }

    public static SearchResultsNewsContextFullHeightPartDefinition m28044a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsNewsContextFullHeightPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24628i) {
                SearchResultsNewsContextFullHeightPartDefinition searchResultsNewsContextFullHeightPartDefinition;
                if (a2 != null) {
                    searchResultsNewsContextFullHeightPartDefinition = (SearchResultsNewsContextFullHeightPartDefinition) a2.a(f24628i);
                } else {
                    searchResultsNewsContextFullHeightPartDefinition = f24627h;
                }
                if (searchResultsNewsContextFullHeightPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28045b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24628i, b3);
                        } else {
                            f24627h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsNewsContextFullHeightPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SearchResultsNewsContextFullHeightPartDefinition(TextPartDefinition textPartDefinition, ViewDimensionsPartDefinition viewDimensionsPartDefinition, FbDraweePartDefinition fbDraweePartDefinition, DisplayUtil displayUtil, QeAccessor qeAccessor) {
        this.f24630d = textPartDefinition;
        this.f24629c = viewDimensionsPartDefinition;
        this.f24631e = fbDraweePartDefinition;
        this.f24632f = displayUtil;
        this.f24633g = qeAccessor;
    }

    public final ViewType<CustomFrameLayout> m28046a() {
        return f24625a;
    }
}
