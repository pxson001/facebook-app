package com.facebook.feedplugins.researchpoll;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
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
import com.facebook.graphql.model.GraphQLResearchPollFeedUnit;
import com.facebook.graphql.model.GraphQLResearchPollMultipleChoiceQuestion;
import com.facebook.graphql.model.ItemListFeedUnitImpl;
import com.facebook.graphql.model.VisibleItemHelper;
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
import com.facebook.widget.hscrollrecyclerview.HScrollRecyclerView;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: calendar_displayName */
public class ResearchPollResultsHScrollPartDefinition<E extends HasPositionInformation & HasPersistentState & HasContext> extends MultiRowSinglePartDefinition<FeedProps<GraphQLResearchPollFeedUnit>, Void, E, HScrollRecyclerView> {
    private static ResearchPollResultsHScrollPartDefinition f9082e;
    private static final Object f9083f = new Object();
    private final BackgroundPartDefinition f9084a;
    public final ResultItemPartDefinition f9085b;
    private final PersistentRecyclerPartDefinition<Object, E> f9086c;
    private final PageStyleFactory f9087d;

    private static ResearchPollResultsHScrollPartDefinition m9772b(InjectorLike injectorLike) {
        return new ResearchPollResultsHScrollPartDefinition(BackgroundPartDefinition.a(injectorLike), ResultItemPartDefinition.a(injectorLike), PersistentRecyclerPartDefinition.a(injectorLike), PageStyleFactory.b(injectorLike));
    }

    public final Object m9774a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        final GraphQLResearchPollFeedUnit graphQLResearchPollFeedUnit = (GraphQLResearchPollFeedUnit) feedProps.a;
        subParts.a(this.f9084a, new StylingData(feedProps, PageStyle.a));
        PersistentRecyclerPartDefinition persistentRecyclerPartDefinition = this.f9086c;
        PageStyle a = this.f9087d.a(PageStyle.a);
        int ac_ = graphQLResearchPollFeedUnit.ac_();
        final ImmutableList a2 = ItemListFeedUnitImpl.a(graphQLResearchPollFeedUnit);
        final int a3 = ResearchPollUnitHelper.m9817a(a2);
        subParts.a(persistentRecyclerPartDefinition, new Props(a, ac_, new SimpleCallbacks<E>(this) {
            final /* synthetic */ ResearchPollResultsHScrollPartDefinition f9081d;

            public final void m9769a(PageSubParts<E> pageSubParts) {
                for (int i = 0; i < a2.size(); i++) {
                    pageSubParts.a(this.f9081d.f9085b, new ResultItemPartDefinition$Props((GraphQLResearchPollMultipleChoiceQuestion) a2.get(i), a3));
                }
            }

            public final void m9770c(int i) {
                VisibleItemHelper.a(graphQLResearchPollFeedUnit, a2, i);
            }
        }, graphQLResearchPollFeedUnit.g(), graphQLResearchPollFeedUnit));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m9775a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        Object obj3;
        int a = Logger.a(8, EntryType.MARK_PUSH, 1309221407);
        HScrollRecyclerView hScrollRecyclerView = (HScrollRecyclerView) view;
        GraphQLResearchPollFeedUnit graphQLResearchPollFeedUnit = (GraphQLResearchPollFeedUnit) ((FeedProps) obj).a;
        if (graphQLResearchPollFeedUnit.H().n() != 0 || graphQLResearchPollFeedUnit.U().b) {
            obj3 = 1;
        } else {
            obj3 = null;
        }
        hScrollRecyclerView.setVisibility(obj3 != null ? 0 : 8);
        Logger.a(8, EntryType.MARK_POP, 328346000, a);
    }

    public final boolean m9776a(Object obj) {
        GraphQLResearchPollFeedUnit graphQLResearchPollFeedUnit = (GraphQLResearchPollFeedUnit) ((FeedProps) obj).a;
        return graphQLResearchPollFeedUnit.x().size() > 1 && ResearchPollUnitHelper.m9821a(graphQLResearchPollFeedUnit);
    }

    @Inject
    public ResearchPollResultsHScrollPartDefinition(BackgroundPartDefinition backgroundPartDefinition, ResultItemPartDefinition resultItemPartDefinition, PersistentRecyclerPartDefinition persistentRecyclerPartDefinition, PageStyleFactory pageStyleFactory) {
        this.f9084a = backgroundPartDefinition;
        this.f9085b = resultItemPartDefinition;
        this.f9086c = persistentRecyclerPartDefinition;
        this.f9087d = pageStyleFactory;
    }

    public static ResearchPollResultsHScrollPartDefinition m9771a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ResearchPollResultsHScrollPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9083f) {
                ResearchPollResultsHScrollPartDefinition researchPollResultsHScrollPartDefinition;
                if (a2 != null) {
                    researchPollResultsHScrollPartDefinition = (ResearchPollResultsHScrollPartDefinition) a2.a(f9083f);
                } else {
                    researchPollResultsHScrollPartDefinition = f9082e;
                }
                if (researchPollResultsHScrollPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9772b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9083f, b3);
                        } else {
                            f9082e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = researchPollResultsHScrollPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m9773a() {
        return HScrollRecyclerViewRowType.a;
    }
}
