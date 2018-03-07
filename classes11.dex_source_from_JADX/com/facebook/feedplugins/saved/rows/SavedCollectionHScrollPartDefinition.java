package com.facebook.feedplugins.saved.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.logging.viewport.FeedLoggingViewportEventListener;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.hscrollrecyclerview.HScrollRecyclerViewRowType;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyle;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyleFactory;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSubParts;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition.Props;
import com.facebook.feed.rows.sections.hscrollrecyclerview.SimpleCallbacks;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.model.GraphQLSavedCollectionFeedUnit;
import com.facebook.graphql.model.GraphQLSavedCollectionFeedUnitItem;
import com.facebook.graphql.model.ScrollableItemListFeedUnitImpl;
import com.facebook.graphql.model.VisibleItemHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.widget.hscrollrecyclerview.HScrollRecyclerView;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: bundle_initial_badge_count */
public class SavedCollectionHScrollPartDefinition<E extends HasPositionInformation & HasPersistentState & HasContext> extends MultiRowSinglePartDefinition<FeedProps<GraphQLSavedCollectionFeedUnit>, Void, E, HScrollRecyclerView> {
    private static final PaddingStyle f9288a = PageStyle.a;
    private static SavedCollectionHScrollPartDefinition f9289g;
    private static final Object f9290h = new Object();
    private final BackgroundPartDefinition f9291b;
    private final PageStyleFactory f9292c;
    private final PersistentRecyclerPartDefinition<Object, E> f9293d;
    public final SavedCollectionPageItemPartDefinition f9294e;
    public final FeedLoggingViewportEventListener f9295f;

    private static SavedCollectionHScrollPartDefinition m9913b(InjectorLike injectorLike) {
        return new SavedCollectionHScrollPartDefinition(BackgroundPartDefinition.a(injectorLike), PageStyleFactory.b(injectorLike), PersistentRecyclerPartDefinition.a(injectorLike), SavedCollectionPageItemPartDefinition.m9925a(injectorLike), FeedLoggingViewportEventListener.a(injectorLike));
    }

    public final Object m9915a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final FeedProps feedProps = (FeedProps) obj;
        GraphQLSavedCollectionFeedUnit graphQLSavedCollectionFeedUnit = (GraphQLSavedCollectionFeedUnit) feedProps.a;
        subParts.a(this.f9291b, new StylingData(feedProps, f9288a));
        PersistentRecyclerPartDefinition persistentRecyclerPartDefinition = this.f9293d;
        PageStyle a = this.f9292c.a(252.0f, f9288a, true);
        int ac_ = graphQLSavedCollectionFeedUnit.ac_();
        final GraphQLSavedCollectionFeedUnit graphQLSavedCollectionFeedUnit2 = (GraphQLSavedCollectionFeedUnit) feedProps.a;
        final ImmutableList a2 = ScrollableItemListFeedUnitImpl.a(graphQLSavedCollectionFeedUnit2);
        subParts.a(persistentRecyclerPartDefinition, new Props(a, ac_, new SimpleCallbacks<E>(this) {
            final /* synthetic */ SavedCollectionHScrollPartDefinition f9287d;

            public final void m9910a(PageSubParts<E> pageSubParts) {
                int size = a2.size();
                for (int i = 0; i < size; i++) {
                    pageSubParts.a(this.f9287d.f9294e, new SavedCollectionPageItemPartDefinition.Props(feedProps, (GraphQLSavedCollectionFeedUnitItem) a2.get(i), false));
                }
            }

            public final void m9911c(int i) {
                this.f9287d.f9295f.a(graphQLSavedCollectionFeedUnit2, i);
                VisibleItemHelper.a(graphQLSavedCollectionFeedUnit2, a2, i);
            }
        }, graphQLSavedCollectionFeedUnit.g(), graphQLSavedCollectionFeedUnit));
        return null;
    }

    @Inject
    public SavedCollectionHScrollPartDefinition(BackgroundPartDefinition backgroundPartDefinition, PageStyleFactory pageStyleFactory, PersistentRecyclerPartDefinition persistentRecyclerPartDefinition, SavedCollectionPageItemPartDefinition savedCollectionPageItemPartDefinition, FeedLoggingViewportEventListener feedLoggingViewportEventListener) {
        this.f9292c = pageStyleFactory;
        this.f9291b = backgroundPartDefinition;
        this.f9293d = persistentRecyclerPartDefinition;
        this.f9294e = savedCollectionPageItemPartDefinition;
        this.f9295f = feedLoggingViewportEventListener;
    }

    public static SavedCollectionHScrollPartDefinition m9912a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SavedCollectionHScrollPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9290h) {
                SavedCollectionHScrollPartDefinition savedCollectionHScrollPartDefinition;
                if (a2 != null) {
                    savedCollectionHScrollPartDefinition = (SavedCollectionHScrollPartDefinition) a2.a(f9290h);
                } else {
                    savedCollectionHScrollPartDefinition = f9289g;
                }
                if (savedCollectionHScrollPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9913b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9290h, b3);
                        } else {
                            f9289g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = savedCollectionHScrollPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m9914a() {
        return HScrollRecyclerViewRowType.a;
    }

    public final boolean m9916a(Object obj) {
        return true;
    }
}
