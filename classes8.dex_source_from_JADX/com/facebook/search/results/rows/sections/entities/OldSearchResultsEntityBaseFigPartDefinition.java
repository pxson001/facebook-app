package com.facebook.search.results.rows.sections.entities;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.fig.listitem.FigListItem;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.enums.GraphQLPageCallToActionType;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.appspecific.AppGlyphResolver;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.search.results.environment.entity.OldCanApplyEntityInlineAction;
import com.facebook.search.results.environment.entity.OldCanLogEntityNavigation;
import com.facebook.search.results.model.SearchResultsModelEntityUtils;
import com.facebook.search.results.rows.sections.binders.GraphQLNodeViewerGuestStateKey;
import com.facebook.search.results.rows.sections.binders.GraphQLNodeViewerJoinStateKey;
import com.facebook.search.results.rows.sections.binders.GraphQLNodeViewerLikeStateKey;
import com.facebook.search.results.rows.sections.collection.OldSearchResultsNodeClickListenerPartDefinition;
import com.facebook.search.results.rows.sections.entities.SearchResultsEntityActionButtonPartDefinition.ActionButtonData;
import javax.inject.Inject;

@ContextScoped
@Deprecated
/* compiled from: REACTION_ATTACHMENTS_CLOSED */
public class OldSearchResultsEntityBaseFigPartDefinition<E extends HasContext & HasPersistentState & OldCanLogEntityNavigation & OldCanApplyEntityInlineAction> extends BaseSinglePartDefinition<GraphQLNode, Void, E, FigListItem> {
    private static OldSearchResultsEntityBaseFigPartDefinition f24122d;
    private static final Object f24123e = new Object();
    private final OldSearchResultsEntityTitleFigPartDefinition f24124a;
    private final SearchResultsEntityActionButtonFigPartDefinition f24125b;
    private final OldSearchResultsNodeClickListenerPartDefinition f24126c;

    /* compiled from: REACTION_ATTACHMENTS_CLOSED */
    final class C25701 implements OnClickListener {
        final /* synthetic */ OldCanApplyEntityInlineAction f24118a;
        final /* synthetic */ GraphQLNode f24119b;

        C25701(OldCanApplyEntityInlineAction oldCanApplyEntityInlineAction, GraphQLNode graphQLNode) {
            this.f24118a = oldCanApplyEntityInlineAction;
            this.f24119b = graphQLNode;
        }

        public final void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2143533348);
            this.f24118a.mo1250a(this.f24119b);
            Logger.a(2, EntryType.UI_INPUT_END, 2056354131, a);
        }
    }

    /* compiled from: REACTION_ATTACHMENTS_CLOSED */
    final class C25712 implements CacheableEntity {
        final /* synthetic */ GraphQLNode f24120a;

        C25712(GraphQLNode graphQLNode) {
            this.f24120a = graphQLNode;
        }

        public final String m27662g() {
            return this.f24120a.dp();
        }
    }

    /* compiled from: REACTION_ATTACHMENTS_CLOSED */
    /* synthetic */ class C25723 {
        static final /* synthetic */ int[] f24121a = new int[GraphQLPageCallToActionType.values().length];

        static {
            try {
                f24121a[GraphQLPageCallToActionType.CALL_NOW.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f24121a[GraphQLPageCallToActionType.MESSAGE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f24121a[GraphQLPageCallToActionType.EMAIL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private static OldSearchResultsEntityBaseFigPartDefinition m27668b(InjectorLike injectorLike) {
        return new OldSearchResultsEntityBaseFigPartDefinition(OldSearchResultsEntityTitleFigPartDefinition.m27682a(injectorLike), SearchResultsEntityActionButtonFigPartDefinition.m27695a(injectorLike), OldSearchResultsNodeClickListenerPartDefinition.m27364a(injectorLike));
    }

    public final Object m27673a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLNode graphQLNode = (GraphQLNode) obj;
        HasContext hasContext = (HasContext) anyEnvironment;
        subParts.a(this.f24124a, graphQLNode);
        subParts.a(this.f24125b, m27667a(graphQLNode, hasContext));
        subParts.a(this.f24126c, graphQLNode);
        return null;
    }

    @Inject
    public OldSearchResultsEntityBaseFigPartDefinition(OldSearchResultsEntityTitleFigPartDefinition oldSearchResultsEntityTitleFigPartDefinition, SearchResultsEntityActionButtonFigPartDefinition searchResultsEntityActionButtonFigPartDefinition, OldSearchResultsNodeClickListenerPartDefinition oldSearchResultsNodeClickListenerPartDefinition) {
        this.f24124a = oldSearchResultsEntityTitleFigPartDefinition;
        this.f24125b = searchResultsEntityActionButtonFigPartDefinition;
        this.f24126c = oldSearchResultsNodeClickListenerPartDefinition;
    }

    public static OldSearchResultsEntityBaseFigPartDefinition m27665a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            OldSearchResultsEntityBaseFigPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24123e) {
                OldSearchResultsEntityBaseFigPartDefinition oldSearchResultsEntityBaseFigPartDefinition;
                if (a2 != null) {
                    oldSearchResultsEntityBaseFigPartDefinition = (OldSearchResultsEntityBaseFigPartDefinition) a2.a(f24123e);
                } else {
                    oldSearchResultsEntityBaseFigPartDefinition = f24122d;
                }
                if (oldSearchResultsEntityBaseFigPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27668b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24123e, b3);
                        } else {
                            f24122d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = oldSearchResultsEntityBaseFigPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    protected static <F extends HasContext & HasPersistentState & OldCanLogEntityNavigation & OldCanApplyEntityInlineAction> ActionButtonData m27667a(GraphQLNode graphQLNode, F f) {
        switch (SearchResultsEntityUtils.m27768d(graphQLNode)) {
            case 2479791:
                return m27670c(graphQLNode, f);
            case 2645995:
                return m27669b(graphQLNode, f);
            case 67338874:
                return m27671d(graphQLNode, f);
            case 69076575:
                return m27672e(graphQLNode, f);
            default:
                return SearchResultsEntityBasePartDefinition.f24167a;
        }
    }

    private static <F extends HasContext & HasPersistentState & OldCanLogEntityNavigation & OldCanApplyEntityInlineAction> ActionButtonData m27669b(GraphQLNode graphQLNode, F f) {
        return SearchResultsEntityBasePartDefinition.m27708a(graphQLNode.cU(), m27663a(graphQLNode, (OldCanApplyEntityInlineAction) f));
    }

    private static <F extends HasContext & HasPersistentState & OldCanLogEntityNavigation & OldCanApplyEntityInlineAction> ActionButtonData m27666a(GraphQLPageCallToActionType graphQLPageCallToActionType, GraphQLNode graphQLNode, F f) {
        int i;
        switch (C25723.f24121a[graphQLPageCallToActionType.ordinal()]) {
            case 1:
                i = 2130837920;
                break;
            case 2:
                i = AppGlyphResolver.a();
                break;
            case 3:
                i = 2130839476;
                break;
            default:
                throw new IllegalArgumentException(StringFormatUtil.formatStrLocaleSafe("Unimplemented page call to action of type %s", graphQLPageCallToActionType.toString()));
        }
        return new ActionButtonData(i, 0, m27663a(graphQLNode, (OldCanApplyEntityInlineAction) f));
    }

    private static <F extends HasContext & HasPersistentState & OldCanLogEntityNavigation & OldCanApplyEntityInlineAction> ActionButtonData m27670c(GraphQLNode graphQLNode, F f) {
        GraphQLNodeViewerLikeStateKey graphQLNodeViewerLikeStateKey = new GraphQLNodeViewerLikeStateKey(graphQLNode);
        GraphQLPageCallToActionType a = SearchResultsModelEntityUtils.m27079a(graphQLNode);
        if (a != null) {
            return m27666a(a, graphQLNode, (HasContext) f);
        }
        boolean bP = graphQLNode.bP();
        int i = (bP && ((Boolean) ((HasPersistentState) f).a(graphQLNodeViewerLikeStateKey, m27664a(graphQLNode))).booleanValue()) ? 0 : bP ? 2130839774 : 2130839953;
        return new ActionButtonData(i, bP ? 2131239011 : 2131239010, bP ? null : m27663a(graphQLNode, (OldCanApplyEntityInlineAction) f));
    }

    private static <F extends HasContext & HasPersistentState & OldCanLogEntityNavigation & OldCanApplyEntityInlineAction> ActionButtonData m27671d(GraphQLNode graphQLNode, F f) {
        return SearchResultsEntityBasePartDefinition.m27711a(graphQLNode.aP(), (GraphQLEventGuestStatus) ((HasPersistentState) f).a(new GraphQLNodeViewerGuestStateKey(graphQLNode), m27664a(graphQLNode)), graphQLNode.je(), m27663a(graphQLNode, (OldCanApplyEntityInlineAction) f));
    }

    private static <F extends HasContext & HasPersistentState & OldCanLogEntityNavigation & OldCanApplyEntityInlineAction> ActionButtonData m27672e(GraphQLNode graphQLNode, F f) {
        return SearchResultsEntityBasePartDefinition.m27709a(graphQLNode.ji(), (GraphQLGroupJoinState) ((HasPersistentState) f).a(new GraphQLNodeViewerJoinStateKey(graphQLNode), m27664a(graphQLNode)), m27663a(graphQLNode, (OldCanApplyEntityInlineAction) f));
    }

    private static OnClickListener m27663a(GraphQLNode graphQLNode, OldCanApplyEntityInlineAction oldCanApplyEntityInlineAction) {
        return new C25701(oldCanApplyEntityInlineAction, graphQLNode);
    }

    private static CacheableEntity m27664a(GraphQLNode graphQLNode) {
        return new C25712(graphQLNode);
    }
}
