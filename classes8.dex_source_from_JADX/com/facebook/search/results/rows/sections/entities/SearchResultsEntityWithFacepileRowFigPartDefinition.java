package com.facebook.search.results.rows.sections.entities;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.widget.contentview.ContentViewWithButton;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ContentViewContentDescriptionPartDefinition;
import com.facebook.multirow.parts.ContentViewSubtitlePartDefinition;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.results.environment.entity.OldCanApplyEntityInlineAction;
import com.facebook.search.results.environment.entity.OldCanLogEntityNavigation;
import com.facebook.search.results.rows.sections.collection.SearchResultsSeeMoreFigPartDefinition;
import com.facebook.search.results.rows.sections.entities.SearchResultsEntityGroupFacepilePartDefinition.FacepileData;
import javax.inject.Inject;

@ContextScoped
/* compiled from: QUERY_AWESOMIZER_UNFOLLOWING_TASK_ID */
public class SearchResultsEntityWithFacepileRowFigPartDefinition<E extends HasContext & HasPositionInformation & HasPersistentState & OldCanLogEntityNavigation & OldCanApplyEntityInlineAction> extends MultiRowSinglePartDefinition<GraphQLNode, Void, E, ContentViewWithButton> {
    public static final ViewType<ContentViewWithButton> f24240a = ViewType.a(2130903980);
    private static final PaddingStyle f24241b;
    private static SearchResultsEntityWithFacepileRowFigPartDefinition f24242i;
    private static final Object f24243j = new Object();
    private final BackgroundPartDefinition f24244c;
    private final OldSearchResultsEntityBasePartDefinition<E> f24245d;
    private final SearchResultsEntityGroupFacepilePartDefinition f24246e;
    private final ContentViewSubtitlePartDefinition f24247f;
    private final ContentViewContentDescriptionPartDefinition f24248g;
    private final QeAccessor f24249h;

    private static SearchResultsEntityWithFacepileRowFigPartDefinition m27780b(InjectorLike injectorLike) {
        return new SearchResultsEntityWithFacepileRowFigPartDefinition(BackgroundPartDefinition.a(injectorLike), OldSearchResultsEntityBasePartDefinition.m27674a(injectorLike), SearchResultsEntityGroupFacepilePartDefinition.m27721a(injectorLike), ContentViewSubtitlePartDefinition.a(injectorLike), ContentViewContentDescriptionPartDefinition.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m27782a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        String a;
        GraphQLNode graphQLNode = (GraphQLNode) obj;
        HasContext hasContext = (HasContext) anyEnvironment;
        subParts.a(this.f24245d, graphQLNode);
        subParts.a(this.f24244c, new StylingData(null, f24241b, ((HasPositionInformation) hasContext).h() instanceof SearchResultsSeeMoreFigPartDefinition ? Position.DIVIDER_BOTTOM_NON_TOP : Position.MIDDLE));
        subParts.a(2131561192, this.f24246e, new FacepileData(4, SearchResultsEntityUtils.m27770e(graphQLNode)));
        ContentViewSubtitlePartDefinition contentViewSubtitlePartDefinition = this.f24247f;
        GraphQLTextWithEntities hu = graphQLNode.hu();
        if (hu != null) {
            a = hu.a();
        } else {
            a = null;
        }
        CharSequence charSequence = a;
        if (StringUtil.a(charSequence)) {
            hu = graphQLNode.jr();
            Object a2 = hu != null ? hu.a() : null;
        }
        subParts.a(contentViewSubtitlePartDefinition, charSequence);
        subParts.a(this.f24248g, SearchResultsEntityUtils.m27765b(graphQLNode));
        return null;
    }

    public final boolean m27783a(Object obj) {
        return SearchResultsEntityUtils.m27768d((GraphQLNode) obj) == 69076575 && this.f24249h.a(ExperimentsForSearchAbTestModule.p, false);
    }

    static {
        Builder a = Builder.a();
        a.b = 6.0f;
        a = a;
        a.c = 6.0f;
        f24241b = a.i();
    }

    public static SearchResultsEntityWithFacepileRowFigPartDefinition m27779a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsEntityWithFacepileRowFigPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24243j) {
                SearchResultsEntityWithFacepileRowFigPartDefinition searchResultsEntityWithFacepileRowFigPartDefinition;
                if (a2 != null) {
                    searchResultsEntityWithFacepileRowFigPartDefinition = (SearchResultsEntityWithFacepileRowFigPartDefinition) a2.a(f24243j);
                } else {
                    searchResultsEntityWithFacepileRowFigPartDefinition = f24242i;
                }
                if (searchResultsEntityWithFacepileRowFigPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27780b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24243j, b3);
                        } else {
                            f24242i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsEntityWithFacepileRowFigPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SearchResultsEntityWithFacepileRowFigPartDefinition(BackgroundPartDefinition backgroundPartDefinition, OldSearchResultsEntityBasePartDefinition oldSearchResultsEntityBasePartDefinition, SearchResultsEntityGroupFacepilePartDefinition searchResultsEntityGroupFacepilePartDefinition, ContentViewSubtitlePartDefinition contentViewSubtitlePartDefinition, ContentViewContentDescriptionPartDefinition contentViewContentDescriptionPartDefinition, QeAccessor qeAccessor) {
        this.f24244c = backgroundPartDefinition;
        this.f24245d = oldSearchResultsEntityBasePartDefinition;
        this.f24246e = searchResultsEntityGroupFacepilePartDefinition;
        this.f24247f = contentViewSubtitlePartDefinition;
        this.f24248g = contentViewContentDescriptionPartDefinition;
        this.f24249h = qeAccessor;
    }

    public final ViewType<ContentViewWithButton> m27781a() {
        return f24240a;
    }
}
