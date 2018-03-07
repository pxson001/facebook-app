package com.facebook.feedplugins.pyma.rows.objectives;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.SizeUtil;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.hscrollrecyclerview.HScrollRecyclerViewRowType;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyle;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSubParts;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSwitcherPartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSwitcherPartDefinition.Controller;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition.Props;
import com.facebook.feed.rows.sections.hscrollrecyclerview.SimpleCallbacks;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.util.render.FeedRenderUtils;
import com.facebook.feedplugins.pyma.PYMADataModelHelper;
import com.facebook.feedplugins.pyml.rows.PymlPagePartDefinition;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.GraphQLPagesYouMayAdvertiseFeedUnit;
import com.facebook.graphql.model.SuggestedPageUnitItem;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.hscrollrecyclerview.HScrollRecyclerView;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: collection_list_item_image_size */
public class PYMAPageLikeObjectiveBodyPartDefinition<E extends HasPositionInformation & HasPersistentState> extends MultiRowSinglePartDefinition<FeedProps<GraphQLPagesYouMayAdvertiseFeedUnit>, Void, E, HScrollRecyclerView> {
    private static PYMAPageLikeObjectiveBodyPartDefinition f8661i;
    private static final Object f8662j = new Object();
    private final Context f8663a;
    public final PymlPagePartDefinition f8664b;
    private final BackgroundPartDefinition f8665c;
    private final PersistentRecyclerPartDefinition f8666d;
    private final PageSwitcherPartDefinition f8667e;
    private final FeedRenderUtils f8668f;
    public final TasksManager<GraphQLPage> f8669g;
    public final PYMADataModelHelper f8670h;

    private static PYMAPageLikeObjectiveBodyPartDefinition m9501b(InjectorLike injectorLike) {
        return new PYMAPageLikeObjectiveBodyPartDefinition((Context) injectorLike.getInstance(Context.class), BackgroundPartDefinition.a(injectorLike), PersistentRecyclerPartDefinition.a(injectorLike), PageSwitcherPartDefinition.a(injectorLike), PymlPagePartDefinition.a(injectorLike), FeedRenderUtils.a(injectorLike), IdBasedProvider.a(injectorLike, 3561), PYMADataModelHelper.m9459a(injectorLike));
    }

    public final Object m9503a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f8665c, new StylingData(feedProps, PageStyle.a));
        final Controller controller = new Controller();
        subParts.a(this.f8667e, controller);
        GraphQLPagesYouMayAdvertiseFeedUnit graphQLPagesYouMayAdvertiseFeedUnit = (GraphQLPagesYouMayAdvertiseFeedUnit) feedProps.a;
        PersistentRecyclerPartDefinition persistentRecyclerPartDefinition = this.f8666d;
        PageStyle a = PageStyle.a(m9500b(this), false, true);
        final FeedProps a2 = this.f8670h.m9461a(feedProps);
        subParts.a(persistentRecyclerPartDefinition, new Props(a, 0, new SimpleCallbacks<E>(this) {
            final /* synthetic */ PYMAPageLikeObjectiveBodyPartDefinition f8660d;

            public final void m9497a(PageSubParts<E> pageSubParts) {
                pageSubParts.a(this.f8660d.f8664b, new PymlPagePartDefinition.Props((SuggestedPageUnitItem) a2.a, feedProps, this.f8660d.f8669g, PYMAPageLikeObjectiveBodyPartDefinition.m9500b(this.f8660d), 0, controller, false, false));
            }

            public final void m9498c(int i) {
            }
        }, graphQLPagesYouMayAdvertiseFeedUnit.g(), graphQLPagesYouMayAdvertiseFeedUnit));
        return null;
    }

    public final boolean m9504a(Object obj) {
        return this.f8670h.m9461a((FeedProps) obj) != null;
    }

    @Inject
    public PYMAPageLikeObjectiveBodyPartDefinition(Context context, BackgroundPartDefinition backgroundPartDefinition, PersistentRecyclerPartDefinition persistentRecyclerPartDefinition, PageSwitcherPartDefinition pageSwitcherPartDefinition, PymlPagePartDefinition pymlPagePartDefinition, FeedRenderUtils feedRenderUtils, Provider<TasksManager> provider, PYMADataModelHelper pYMADataModelHelper) {
        this.f8663a = context;
        this.f8665c = backgroundPartDefinition;
        this.f8666d = persistentRecyclerPartDefinition;
        this.f8664b = pymlPagePartDefinition;
        this.f8668f = feedRenderUtils;
        this.f8669g = (TasksManager) provider.get();
        this.f8667e = pageSwitcherPartDefinition;
        this.f8670h = pYMADataModelHelper;
    }

    public static PYMAPageLikeObjectiveBodyPartDefinition m9499a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PYMAPageLikeObjectiveBodyPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8662j) {
                PYMAPageLikeObjectiveBodyPartDefinition pYMAPageLikeObjectiveBodyPartDefinition;
                if (a2 != null) {
                    pYMAPageLikeObjectiveBodyPartDefinition = (PYMAPageLikeObjectiveBodyPartDefinition) a2.a(f8662j);
                } else {
                    pYMAPageLikeObjectiveBodyPartDefinition = f8661i;
                }
                if (pYMAPageLikeObjectiveBodyPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9501b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8662j, b3);
                        } else {
                            f8661i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pYMAPageLikeObjectiveBodyPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public static int m9500b(PYMAPageLikeObjectiveBodyPartDefinition pYMAPageLikeObjectiveBodyPartDefinition) {
        return SizeUtil.c(pYMAPageLikeObjectiveBodyPartDefinition.f8663a, (float) pYMAPageLikeObjectiveBodyPartDefinition.f8668f.a());
    }

    public final ViewType m9502a() {
        return HScrollRecyclerViewRowType.a;
    }
}
