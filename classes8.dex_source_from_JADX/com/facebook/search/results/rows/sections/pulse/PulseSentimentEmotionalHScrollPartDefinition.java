package com.facebook.search.results.rows.sections.pulse;

import android.content.Context;
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
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.model.GraphQLEmotionalAnalysisItem;
import com.facebook.graphql.model.GraphQLEmotionalAnalysisItemsEdge;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.search.results.model.unit.SearchResultsPulseSentimentUnit;
import com.facebook.search.results.rows.sections.pulse.PulseSentimentEmotionalItemPartDefinition.PulseEmotionalIconData;
import com.facebook.widget.hscrollrecyclerview.HScrollRecyclerView;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PRIMARY_ACTION */
public class PulseSentimentEmotionalHScrollPartDefinition<E extends HasPersistentState & HasPositionInformation & HasContext> extends MultiRowSinglePartDefinition<FeedProps<SearchResultsPulseSentimentUnit>, Void, E, HScrollRecyclerView> {
    private static PulseSentimentEmotionalHScrollPartDefinition f24886e;
    private static final Object f24887f = new Object();
    public final PulseSentimentEmotionalItemPartDefinition f24888a;
    private final BackgroundPartDefinition f24889b;
    private final PersistentRecyclerPartDefinition<Object, E> f24890c;
    private final PageStyleFactory f24891d;

    private static PulseSentimentEmotionalHScrollPartDefinition m28255b(InjectorLike injectorLike) {
        return new PulseSentimentEmotionalHScrollPartDefinition(PulseSentimentEmotionalItemPartDefinition.m28259a(injectorLike), BackgroundPartDefinition.a(injectorLike), PersistentRecyclerPartDefinition.a(injectorLike), PageStyleFactory.b(injectorLike));
    }

    public final Object m28257a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SearchResultsPulseSentimentUnit searchResultsPulseSentimentUnit = (SearchResultsPulseSentimentUnit) feedProps.a;
        subParts.a(this.f24889b, new StylingData(feedProps, PaddingStyle.a, Position.MIDDLE));
        subParts.a(this.f24890c, m28252a(searchResultsPulseSentimentUnit));
        return null;
    }

    @Inject
    public PulseSentimentEmotionalHScrollPartDefinition(PulseSentimentEmotionalItemPartDefinition pulseSentimentEmotionalItemPartDefinition, BackgroundPartDefinition backgroundPartDefinition, PersistentRecyclerPartDefinition persistentRecyclerPartDefinition, PageStyleFactory pageStyleFactory) {
        this.f24888a = pulseSentimentEmotionalItemPartDefinition;
        this.f24889b = backgroundPartDefinition;
        this.f24890c = persistentRecyclerPartDefinition;
        this.f24891d = pageStyleFactory;
    }

    public static PulseSentimentEmotionalHScrollPartDefinition m28253a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PulseSentimentEmotionalHScrollPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24887f) {
                PulseSentimentEmotionalHScrollPartDefinition pulseSentimentEmotionalHScrollPartDefinition;
                if (a2 != null) {
                    pulseSentimentEmotionalHScrollPartDefinition = (PulseSentimentEmotionalHScrollPartDefinition) a2.a(f24887f);
                } else {
                    pulseSentimentEmotionalHScrollPartDefinition = f24886e;
                }
                if (pulseSentimentEmotionalHScrollPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28255b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24887f, b3);
                        } else {
                            f24886e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pulseSentimentEmotionalHScrollPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<HScrollRecyclerView> m28256a() {
        return HScrollRecyclerViewRowType.b;
    }

    private Props<Object, E> m28252a(final SearchResultsPulseSentimentUnit searchResultsPulseSentimentUnit) {
        return new Props(this.f24891d.a(158.0f, PageStyle.a, true), 0, new SimpleCallbacks<E>(this) {
            final /* synthetic */ PulseSentimentEmotionalHScrollPartDefinition f24885b;

            public final void m28250a(PageSubParts<E> pageSubParts) {
                pageSubParts.a(this.f24885b.f24888a, new PulseEmotionalIconData(searchResultsPulseSentimentUnit.f23500b));
                ImmutableList a = searchResultsPulseSentimentUnit.f23499a.a().a();
                int size = a.size();
                for (int i = 0; i < size; i++) {
                    GraphQLEmotionalAnalysisItem a2 = ((GraphQLEmotionalAnalysisItemsEdge) a.get(i)).a();
                    pageSubParts.a(this.f24885b.f24888a, new PulseEmotionalIconData(a2.k().aG(), a2.a(), a2.j()));
                }
            }

            public final void m28251c(int i) {
            }

            public final int m28249a() {
                return searchResultsPulseSentimentUnit.f23499a.a().a().size() + 1;
            }
        }, searchResultsPulseSentimentUnit.g(), searchResultsPulseSentimentUnit);
    }

    public static boolean m28254a(FeedProps<SearchResultsPulseSentimentUnit> feedProps) {
        return ((SearchResultsPulseSentimentUnit) feedProps.a).m27186n();
    }
}
