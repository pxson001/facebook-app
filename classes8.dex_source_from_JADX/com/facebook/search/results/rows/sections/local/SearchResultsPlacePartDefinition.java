package com.facebook.search.results.rows.sections.local;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.CurationMechanism;
import com.facebook.analytics.CurationSurface;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.fig.button.FigToggleButton;
import com.facebook.fig.listitem.FigListItem;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLSavedState;
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
import com.facebook.multirow.parts.FigListItemBodyPartDefinition;
import com.facebook.multirow.parts.FigListItemContentDescriptionPartDefinition;
import com.facebook.multirow.parts.FigListItemMetaTextPartDefinition;
import com.facebook.multirow.parts.FigListItemThumbnailUriPartDefinition;
import com.facebook.multirow.parts.FigListItemTitlePartDefinition;
import com.facebook.multirow.parts.FigListItemTitlePartDefinition.Props;
import com.facebook.multirow.parts.FigListItemToggleButtonPartDefinition;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.saved.common.protocol.UpdateSavedStateParams.SavedAction;
import com.facebook.saved.common.protocol.UpdateSavedStateUtils;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.abtest.SearchAbTestGatekeepers;
import com.facebook.search.logging.SearchResultsLogger;
import com.facebook.search.logging.SearchResultsLogger.Event;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.environment.entity.OldCanLogEntityNavigation;
import com.facebook.search.results.rows.sections.collection.OldSearchResultsNodeClickListenerPartDefinition;
import com.facebook.search.results.rows.sections.entities.SearchResultsEntityConstants;
import com.facebook.search.results.rows.sections.entities.SearchResultsEntityUtils;
import com.facebook.search.util.LocalSearchUtil;
import com.facebook.search.util.TypeaheadRowTitleFormatter;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PageSurfaceFirstCardSequence */
public class SearchResultsPlacePartDefinition<E extends HasPositionInformation & HasContext & HasPersistentState & HasSearchResultsContext & OldCanLogEntityNavigation> extends MultiRowSinglePartDefinition<GraphQLNode, Void, E, FigListItem> {
    public static ViewType<FigListItem> f24591a = ViewType.a(2130906248);
    private static SearchResultsPlacePartDefinition f24592q;
    private static final Object f24593r = new Object();
    public final Toaster f24594b;
    private final QeAccessor f24595c;
    public final GatekeeperStoreImpl f24596d;
    public final SearchResultsLogger f24597e;
    private final LocalSearchUtil f24598f;
    private final TypeaheadRowTitleFormatter f24599g;
    private final UpdateSavedStateUtils f24600h;
    private final BackgroundPartDefinition f24601i;
    private final FigListItemTitlePartDefinition f24602j;
    private final OldSearchResultsNodeClickListenerPartDefinition f24603k;
    private final FigListItemBodyPartDefinition f24604l;
    private final FigListItemMetaTextPartDefinition f24605m;
    private final FigListItemContentDescriptionPartDefinition f24606n;
    private final FigListItemThumbnailUriPartDefinition f24607o;
    private final FigListItemToggleButtonPartDefinition f24608p;

    private static SearchResultsPlacePartDefinition m28028b(InjectorLike injectorLike) {
        return new SearchResultsPlacePartDefinition(Toaster.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), SearchResultsLogger.m25460a(injectorLike), LocalSearchUtil.m10650a(injectorLike), TypeaheadRowTitleFormatter.m10667a(injectorLike), UpdateSavedStateUtils.a(injectorLike), BackgroundPartDefinition.a(injectorLike), FigListItemTitlePartDefinition.a(injectorLike), OldSearchResultsNodeClickListenerPartDefinition.m27364a(injectorLike), FigListItemBodyPartDefinition.a(injectorLike), FigListItemMetaTextPartDefinition.a(injectorLike), FigListItemContentDescriptionPartDefinition.a(injectorLike), FigListItemThumbnailUriPartDefinition.a(injectorLike), FigListItemToggleButtonPartDefinition.a(injectorLike));
    }

    public final Object m28031a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Object obj2;
        final GraphQLNode graphQLNode = (GraphQLNode) obj;
        final HasPositionInformation hasPositionInformation = (HasPositionInformation) anyEnvironment;
        StylingData stylingData = new StylingData(null, SearchResultsEntityConstants.f24176a, hasPositionInformation.h() == null ? Position.BOTTOM : Position.MIDDLE);
        subParts.a(this.f24602j, new Props(graphQLNode.dZ() ? this.f24599g.m10671a(new SpannableStringBuilder(graphQLNode.eP())) : graphQLNode.eP(), Integer.valueOf(2)));
        boolean z = false;
        boolean a = this.f24596d.a(SearchAbTestGatekeepers.e, false);
        GraphQLSavedState jn = graphQLNode.jn();
        if (jn.equals(GraphQLSavedState.SAVED) || jn.equals(GraphQLSavedState.NOT_SAVED)) {
            z = true;
        }
        if (a && r8) {
            FigListItemToggleButtonPartDefinition.Props props = new FigListItemToggleButtonPartDefinition.Props(((HasContext) hasPositionInformation).getContext().getResources().getDrawable(2130839719), jn.equals(GraphQLSavedState.SAVED), new OnClickListener(this) {
                final /* synthetic */ SearchResultsPlacePartDefinition f24585c;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1727654355);
                    GraphQLSavedState jn = graphQLNode.jn();
                    if (jn.equals(GraphQLSavedState.SAVED)) {
                        SearchResultsPlacePartDefinition.m28027a(this.f24585c, graphQLNode, hasPositionInformation, false, (FigToggleButton) view);
                    } else if (jn.equals(GraphQLSavedState.NOT_SAVED)) {
                        SearchResultsPlacePartDefinition.m28027a(this.f24585c, graphQLNode, hasPositionInformation, true, (FigToggleButton) view);
                    }
                    LogUtils.a(1898675848, a);
                }
            });
        } else {
            obj2 = null;
        }
        Object obj3 = obj2;
        if (obj3 != null && this.f24595c.a(ExperimentsForSearchAbTestModule.ab, false)) {
            subParts.a(this.f24608p, obj3);
        }
        subParts.a(this.f24603k, graphQLNode);
        subParts.a(this.f24607o, SearchResultsEntityUtils.m27766c(graphQLNode));
        subParts.a(this.f24604l, new FigListItemBodyPartDefinition.Props(this.f24598f.m10654a(((HasContext) hasPositionInformation).getContext(), graphQLNode), Integer.valueOf(1)));
        subParts.a(this.f24605m, new FigListItemMetaTextPartDefinition.Props(this.f24598f.m10655a(graphQLNode), Integer.valueOf(1)));
        subParts.a(this.f24606n, SearchResultsEntityUtils.m27765b(graphQLNode));
        subParts.a(this.f24601i, stylingData);
        return null;
    }

    public static SearchResultsPlacePartDefinition m28026a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsPlacePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24593r) {
                SearchResultsPlacePartDefinition searchResultsPlacePartDefinition;
                if (a2 != null) {
                    searchResultsPlacePartDefinition = (SearchResultsPlacePartDefinition) a2.a(f24593r);
                } else {
                    searchResultsPlacePartDefinition = f24592q;
                }
                if (searchResultsPlacePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28028b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24593r, b3);
                        } else {
                            f24592q = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsPlacePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SearchResultsPlacePartDefinition(Toaster toaster, QeAccessor qeAccessor, GatekeeperStoreImpl gatekeeperStoreImpl, SearchResultsLogger searchResultsLogger, LocalSearchUtil localSearchUtil, TypeaheadRowTitleFormatter typeaheadRowTitleFormatter, UpdateSavedStateUtils updateSavedStateUtils, BackgroundPartDefinition backgroundPartDefinition, FigListItemTitlePartDefinition figListItemTitlePartDefinition, OldSearchResultsNodeClickListenerPartDefinition oldSearchResultsNodeClickListenerPartDefinition, FigListItemBodyPartDefinition figListItemBodyPartDefinition, FigListItemMetaTextPartDefinition figListItemMetaTextPartDefinition, FigListItemContentDescriptionPartDefinition figListItemContentDescriptionPartDefinition, FigListItemThumbnailUriPartDefinition figListItemThumbnailUriPartDefinition, FigListItemToggleButtonPartDefinition figListItemToggleButtonPartDefinition) {
        this.f24594b = toaster;
        this.f24595c = qeAccessor;
        this.f24596d = gatekeeperStoreImpl;
        this.f24597e = searchResultsLogger;
        this.f24598f = localSearchUtil;
        this.f24599g = typeaheadRowTitleFormatter;
        this.f24600h = updateSavedStateUtils;
        this.f24601i = backgroundPartDefinition;
        this.f24602j = figListItemTitlePartDefinition;
        this.f24603k = oldSearchResultsNodeClickListenerPartDefinition;
        this.f24604l = figListItemBodyPartDefinition;
        this.f24605m = figListItemMetaTextPartDefinition;
        this.f24606n = figListItemContentDescriptionPartDefinition;
        this.f24607o = figListItemThumbnailUriPartDefinition;
        this.f24608p = figListItemToggleButtonPartDefinition;
    }

    public final ViewType<FigListItem> m28030a() {
        return f24591a;
    }

    public static boolean m28029b() {
        return true;
    }

    public final /* synthetic */ boolean m28032a(Object obj) {
        return true;
    }

    public static void m28027a(SearchResultsPlacePartDefinition searchResultsPlacePartDefinition, GraphQLNode graphQLNode, HasPositionInformation hasPositionInformation, boolean z, FigToggleButton figToggleButton) {
        SavedAction savedAction;
        UpdateSavedStateUtils updateSavedStateUtils = searchResultsPlacePartDefinition.f24600h;
        if (z) {
            savedAction = SavedAction.SAVE;
        } else {
            savedAction = SavedAction.UNSAVE;
        }
        final boolean z2 = z;
        final GraphQLNode graphQLNode2 = graphQLNode;
        final HasPositionInformation hasPositionInformation2 = hasPositionInformation;
        final FigToggleButton figToggleButton2 = figToggleButton;
        updateSavedStateUtils.a(savedAction, graphQLNode.dp(), CurationSurface.NATIVE_SEARCH, CurationMechanism.TOGGLE_BUTTON, new OperationResultFutureCallback(searchResultsPlacePartDefinition) {
            final /* synthetic */ SearchResultsPlacePartDefinition f24590e;

            protected final void m28025a(Object obj) {
                if (z2) {
                    SearchResultsLogger searchResultsLogger = this.f24590e.f24597e;
                    HoneyClientEvent b = SearchResultsLogger.m25459a(Event.PLACE_SAVE_INTERACTION, ((HasSearchResultsContext) hasPositionInformation2).mo1248s()).b("tapped_result_entity_id", graphQLNode2.dp()).b("results_module_role", "GRAMMAR").b("results_module_result_type", "places");
                    searchResultsLogger.f21958c.a(b);
                    if (BLog.b(3)) {
                        String str = b.d;
                        b.u();
                    }
                }
            }

            protected final void m28024a(ServiceException serviceException) {
                figToggleButton2.setChecked(!z2);
                this.f24590e.f24594b.b(new ToastBuilder(2131230758));
            }
        });
    }
}
