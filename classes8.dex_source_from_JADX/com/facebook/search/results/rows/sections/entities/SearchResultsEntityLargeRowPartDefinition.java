package com.facebook.search.results.rows.sections.entities;

import android.content.Context;
import android.net.Uri;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.contentview.ContentViewWithButton;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
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
import com.facebook.multirow.parts.ContentViewMetaTextPartDefinition;
import com.facebook.multirow.parts.ContentViewSubtitlePartDefinition;
import com.facebook.multirow.parts.ContentViewThumbnailUriPartDefinition;
import com.facebook.search.results.environment.entity.CanApplyEntityInlineAction;
import com.facebook.search.results.environment.entity.CanLogEntityNavigation;
import com.facebook.search.results.model.SearchResultsProps;
import com.facebook.search.results.protocol.SearchResultsEdgeInterfaces.SearchResultsEdge.Node;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel;
import com.facebook.search.results.protocol.common.SearchResultsDecorationModels.SearchResultsSnippetModel;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: Quick Promotion Config */
public class SearchResultsEntityLargeRowPartDefinition<E extends HasContext & HasPositionInformation & HasPersistentState & CanLogEntityNavigation & CanApplyEntityInlineAction> extends MultiRowSinglePartDefinition<SearchResultsProps<Node>, Void, E, ContentViewWithButton> {
    public static final ViewType<ContentViewWithButton> f24183a = ViewType.a(2130903977);
    private static SearchResultsEntityLargeRowPartDefinition f24184h;
    private static final Object f24185i = new Object();
    private final BackgroundPartDefinition f24186b;
    private final SearchResultsEntityBasePartDefinition<E> f24187c;
    private final ContentViewSubtitlePartDefinition f24188d;
    private final ContentViewContentDescriptionPartDefinition f24189e;
    private final ContentViewMetaTextPartDefinition f24190f;
    private final ContentViewThumbnailUriPartDefinition f24191g;

    private static SearchResultsEntityLargeRowPartDefinition m27725b(InjectorLike injectorLike) {
        return new SearchResultsEntityLargeRowPartDefinition(BackgroundPartDefinition.a(injectorLike), SearchResultsEntityBasePartDefinition.m27713a(injectorLike), ContentViewSubtitlePartDefinition.a(injectorLike), ContentViewContentDescriptionPartDefinition.a(injectorLike), ContentViewMetaTextPartDefinition.a(injectorLike), ContentViewThumbnailUriPartDefinition.a(injectorLike));
    }

    public final Object m27727a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        CharSequence a;
        SearchResultsProps searchResultsProps = (SearchResultsProps) obj;
        subParts.a(this.f24187c, searchResultsProps);
        subParts.a(this.f24188d, SearchResultsEntityUtils.m27761a(searchResultsProps.f23390c));
        ContentViewContentDescriptionPartDefinition contentViewContentDescriptionPartDefinition = this.f24189e;
        SearchResultsEdgeModel searchResultsEdgeModel = searchResultsProps.f23390c;
        NodeModel a2 = searchResultsEdgeModel.m9770a();
        Object k = a2 != null ? a2.mo563k() : null;
        CharSequence a3 = SearchResultsEntityUtils.m27761a(searchResultsEdgeModel);
        if (k == null) {
            k = a3;
        } else if (a3 != null) {
            k = k + " " + a3;
        }
        subParts.a(contentViewContentDescriptionPartDefinition, k);
        ContentViewMetaTextPartDefinition contentViewMetaTextPartDefinition = this.f24190f;
        ImmutableList e = SearchResultsEntityUtils.m27771e(searchResultsProps.f23390c);
        if (e.size() > 1) {
            a = SearchResultsEntityUtils.m27762a((SearchResultsSnippetModel) e.get(1));
        } else {
            a = null;
        }
        subParts.a(contentViewMetaTextPartDefinition, a);
        ContentViewThumbnailUriPartDefinition contentViewThumbnailUriPartDefinition = this.f24191g;
        Uri uri = null;
        NodeModel a4 = searchResultsProps.f23390c.m9770a();
        if (a4 != null) {
            DefaultImageFields ah = a4.ah();
            if (ah != null) {
                uri = ImageUtil.a(ah);
            }
        }
        subParts.a(contentViewThumbnailUriPartDefinition, uri);
        subParts.a(this.f24186b, SearchResultsEntityConstants.f24177b);
        return null;
    }

    public final boolean m27728a(Object obj) {
        return ((SearchResultsProps) obj).f23388a != null;
    }

    @Inject
    public SearchResultsEntityLargeRowPartDefinition(BackgroundPartDefinition backgroundPartDefinition, SearchResultsEntityBasePartDefinition searchResultsEntityBasePartDefinition, ContentViewSubtitlePartDefinition contentViewSubtitlePartDefinition, ContentViewContentDescriptionPartDefinition contentViewContentDescriptionPartDefinition, ContentViewMetaTextPartDefinition contentViewMetaTextPartDefinition, ContentViewThumbnailUriPartDefinition contentViewThumbnailUriPartDefinition) {
        this.f24186b = backgroundPartDefinition;
        this.f24187c = searchResultsEntityBasePartDefinition;
        this.f24188d = contentViewSubtitlePartDefinition;
        this.f24189e = contentViewContentDescriptionPartDefinition;
        this.f24190f = contentViewMetaTextPartDefinition;
        this.f24191g = contentViewThumbnailUriPartDefinition;
    }

    public static SearchResultsEntityLargeRowPartDefinition m27724a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsEntityLargeRowPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24185i) {
                SearchResultsEntityLargeRowPartDefinition searchResultsEntityLargeRowPartDefinition;
                if (a2 != null) {
                    searchResultsEntityLargeRowPartDefinition = (SearchResultsEntityLargeRowPartDefinition) a2.a(f24185i);
                } else {
                    searchResultsEntityLargeRowPartDefinition = f24184h;
                }
                if (searchResultsEntityLargeRowPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27725b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24185i, b3);
                        } else {
                            f24184h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsEntityLargeRowPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<ContentViewWithButton> m27726a() {
        return f24183a;
    }
}
