package com.facebook.search.results.rows.sections.entities;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.fig.listitem.FigListItem;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ImageBlockLayoutContentDescriptionPartDefinition;
import com.facebook.multirow.parts.ImageBlockLayoutThumbnailPartDefinition;
import com.facebook.multirow.parts.ImageBlockLayoutThumbnailPartDefinition.Props.Builder;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.results.environment.entity.OldCanApplyEntityInlineAction;
import com.facebook.search.results.environment.entity.OldCanLogEntityNavigation;
import com.facebook.search.results.rows.sections.collection.SearchResultsSeeMoreFigPartDefinition;
import com.facebook.search.results.rows.sections.common.FigListItemBodyPartDefinition;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

@ContextScoped
/* compiled from: QUESTION_SKIP_TAP */
public class SearchResultsEntityRowFigPartDefinition<E extends HasContext & HasPositionInformation & HasPersistentState & OldCanLogEntityNavigation & OldCanApplyEntityInlineAction> extends MultiRowSinglePartDefinition<GraphQLNode, Void, E, FigListItem> {
    public static final ViewType<FigListItem> f24209a = ViewType.a(2130903978);
    private static SearchResultsEntityRowFigPartDefinition f24210i;
    private static final Object f24211j = new Object();
    private final OldSearchResultsEntityBaseFigPartDefinition<E> f24212b;
    private final NavigationalLinkFigPartDefinition f24213c;
    private final FigListItemBodyPartDefinition f24214d;
    private final ImageBlockLayoutContentDescriptionPartDefinition f24215e;
    private final ImageBlockLayoutThumbnailPartDefinition f24216f;
    private final BackgroundPartDefinition f24217g;
    private final QeAccessor f24218h;

    private static SearchResultsEntityRowFigPartDefinition m27741b(InjectorLike injectorLike) {
        return new SearchResultsEntityRowFigPartDefinition(OldSearchResultsEntityBaseFigPartDefinition.m27665a(injectorLike), NavigationalLinkFigPartDefinition.m27652a(injectorLike), FigListItemBodyPartDefinition.m27560a(injectorLike), ImageBlockLayoutContentDescriptionPartDefinition.a(injectorLike), ImageBlockLayoutThumbnailPartDefinition.a(injectorLike), BackgroundPartDefinition.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m27743a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Position position;
        GraphQLNode graphQLNode = (GraphQLNode) obj;
        HasContext hasContext = (HasContext) anyEnvironment;
        MultiRowSinglePartDefinition h = ((HasPositionInformation) hasContext).h();
        if (h == null) {
            position = Position.BOTTOM;
        } else if (h instanceof SearchResultsSeeMoreFigPartDefinition) {
            position = Position.DIVIDER_BOTTOM_NON_TOP;
        } else {
            position = Position.MIDDLE;
        }
        subParts.a(SearchResultsEntityUtils.m27773g(graphQLNode) ? this.f24213c : this.f24212b, graphQLNode);
        subParts.a(this.f24214d, SearchResultsEntityUtils.m27760a(graphQLNode, hasContext.getContext().getString(2131239060)));
        subParts.a(this.f24215e, SearchResultsEntityUtils.m27765b(graphQLNode));
        Builder builder = new Builder();
        Uri c = SearchResultsEntityUtils.m27766c(graphQLNode);
        Preconditions.checkState(builder.a == null, "Thumbnail Uri is already defined.");
        builder.b = c;
        subParts.a(this.f24216f, builder.a());
        subParts.a(this.f24217g, new StylingData(null, SearchResultsEntityConstants.f24176a, position));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m27744a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1457983239);
        FigListItem figListItem = (FigListItem) view;
        figListItem.setTitleMaxLines(1);
        figListItem.setBodyMaxLines(1);
        Logger.a(8, EntryType.MARK_POP, 1806762567, a);
    }

    public final void m27746b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((FigListItem) view).a();
    }

    public static SearchResultsEntityRowFigPartDefinition m27740a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsEntityRowFigPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24211j) {
                SearchResultsEntityRowFigPartDefinition searchResultsEntityRowFigPartDefinition;
                if (a2 != null) {
                    searchResultsEntityRowFigPartDefinition = (SearchResultsEntityRowFigPartDefinition) a2.a(f24211j);
                } else {
                    searchResultsEntityRowFigPartDefinition = f24210i;
                }
                if (searchResultsEntityRowFigPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27741b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24211j, b3);
                        } else {
                            f24210i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsEntityRowFigPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SearchResultsEntityRowFigPartDefinition(OldSearchResultsEntityBaseFigPartDefinition oldSearchResultsEntityBaseFigPartDefinition, NavigationalLinkFigPartDefinition navigationalLinkFigPartDefinition, FigListItemBodyPartDefinition figListItemBodyPartDefinition, ImageBlockLayoutContentDescriptionPartDefinition imageBlockLayoutContentDescriptionPartDefinition, ImageBlockLayoutThumbnailPartDefinition imageBlockLayoutThumbnailPartDefinition, BackgroundPartDefinition backgroundPartDefinition, QeAccessor qeAccessor) {
        this.f24212b = oldSearchResultsEntityBaseFigPartDefinition;
        this.f24213c = navigationalLinkFigPartDefinition;
        this.f24214d = figListItemBodyPartDefinition;
        this.f24215e = imageBlockLayoutContentDescriptionPartDefinition;
        this.f24216f = imageBlockLayoutThumbnailPartDefinition;
        this.f24217g = backgroundPartDefinition;
        this.f24218h = qeAccessor;
    }

    public final ViewType<FigListItem> m27742a() {
        return f24209a;
    }

    public final boolean m27745a(Object obj) {
        return this.f24218h.a(ExperimentsForSearchAbTestModule.p, false);
    }
}
