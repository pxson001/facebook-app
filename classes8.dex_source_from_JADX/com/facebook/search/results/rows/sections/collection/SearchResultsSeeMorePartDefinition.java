package com.facebook.search.results.rows.sections.collection;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.intent.SearchResultsIntentBuilder;
import com.facebook.search.logging.SearchResultsLogger;
import com.facebook.search.results.environment.HasFeedItemPosition;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.environment.tabs.SearchResultsTab;
import com.facebook.search.results.model.contract.SearchResultsSeeMoreFeedUnit;
import com.facebook.search.results.model.unit.SearchResultsCollectionUnit;
import com.facebook.search.results.rows.sections.common.SearchResultsSeeMoreClickListenerPartDefinition;
import com.facebook.search.results.rows.sections.common.SearchResultsSeeMoreClickListenerPartDefinition.SeeMoreData;
import com.facebook.search.results.rows.sections.common.SearchResultsSeeMoreLogger;
import com.facebook.search.results.rows.sections.common.SearchResultsTabSwitchPartDefinition;
import com.facebook.search.results.rows.sections.common.SearchResultsTabSwitchPartDefinition.TabSwitchData;
import com.facebook.widget.text.BetterTextView;
import com.google.common.collect.ImmutableMap;
import javax.inject.Inject;

@ContextScoped
/* compiled from: REPEAT_ALL */
public class SearchResultsSeeMorePartDefinition<T, E extends HasContext & HasFeedItemPosition & HasSearchResultsContext & HasPositionInformation> extends MultiRowSinglePartDefinition<FeedProps<SearchResultsCollectionUnit<T>>, Void, E, View> {
    public static final ViewType f23838a = new C25441();
    public static final SearchResultsSeeMoreLogger f23839b = new C25452();
    protected static final ImmutableMap<GraphQLGraphSearchResultRole, SearchResultsTab> f23840c = ImmutableMap.of(GraphQLGraphSearchResultRole.COMMERCE_B2C, SearchResultsTab.MARKETPLACE, GraphQLGraphSearchResultRole.COMMERCE_C2C, SearchResultsTab.MARKETPLACE, GraphQLGraphSearchResultRole.COMMERCE_COMBINED, SearchResultsTab.MARKETPLACE, GraphQLGraphSearchResultRole.LIVE_CONVERSATION_MODULE, SearchResultsTab.LATEST);
    private static final PaddingStyle f23841d;
    private static final PaddingStyle f23842e;
    private static SearchResultsSeeMorePartDefinition f23843k;
    private static final Object f23844l = new Object();
    private final TextPartDefinition f23845f;
    private final SearchResultsSeeMoreClickListenerPartDefinition f23846g;
    private final SearchResultsTabSwitchPartDefinition f23847h;
    private final BackgroundPartDefinition f23848i;
    private final QeAccessor f23849j;

    /* compiled from: REPEAT_ALL */
    final class C25441 extends ViewType {
        C25441() {
        }

        public final View m27452a(Context context) {
            BetterTextView betterTextView = new BetterTextView(context);
            betterTextView.setTextAppearance(betterTextView.getContext(), 2131625898);
            betterTextView.setGravity(17);
            return betterTextView;
        }
    }

    /* compiled from: REPEAT_ALL */
    final class C25452 implements SearchResultsSeeMoreLogger {
        C25452() {
        }

        public final <E extends HasSearchResultsContext & HasFeedItemPosition> void mo1334a(SearchResultsLogger searchResultsLogger, E e, SearchResultsSeeMoreFeedUnit searchResultsSeeMoreFeedUnit) {
            SearchResultsCollectionUnit searchResultsCollectionUnit = (SearchResultsCollectionUnit) searchResultsSeeMoreFeedUnit;
            searchResultsLogger.m25483a(e.mo1248s(), searchResultsCollectionUnit.mo1321k(), (String) searchResultsCollectionUnit.mo1322l().orNull(), (GraphQLGraphSearchResultsDisplayStyle) searchResultsCollectionUnit.f23460a.orNull(), ((HasFeedItemPosition) e).mo1245a(searchResultsCollectionUnit), searchResultsCollectionUnit.f23463d.size(), (GraphQLObjectType) searchResultsCollectionUnit.f23465f.orNull());
        }
    }

    private static SearchResultsSeeMorePartDefinition m27459b(InjectorLike injectorLike) {
        return new SearchResultsSeeMorePartDefinition(TextPartDefinition.a(injectorLike), SearchResultsSeeMoreClickListenerPartDefinition.m27600a(injectorLike), SearchResultsTabSwitchPartDefinition.m27607a(injectorLike), BackgroundPartDefinition.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m27461a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SearchResultsCollectionUnit searchResultsCollectionUnit = (SearchResultsCollectionUnit) feedProps.a;
        subParts.a(this.f23845f, ((HasContext) anyEnvironment).getContext().getString(2131239062));
        SearchResultsTab b = m27458b(this.f23849j, searchResultsCollectionUnit);
        if (b != null) {
            subParts.a(this.f23847h, new TabSwitchData(b, searchResultsCollectionUnit));
        } else {
            subParts.a(this.f23846g, new SeeMoreData(searchResultsCollectionUnit, f23839b, 2131239062));
        }
        subParts.a(this.f23848i, new StylingData(feedProps, m27457a(searchResultsCollectionUnit) ? f23842e : f23841d, Position.BOTTOM));
        return null;
    }

    public final boolean m27462a(Object obj) {
        return m27456a(this.f23849j, (SearchResultsCollectionUnit) ((FeedProps) obj).a);
    }

    static {
        Builder a = Builder.a();
        a.b = 6.0f;
        a = a;
        a.c = 6.0f;
        f23841d = a.i();
        a = Builder.a();
        a.b = 4.0f;
        a = a;
        a.c = 6.0f;
        f23842e = a.i();
    }

    public static SearchResultsSeeMorePartDefinition m27455a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsSeeMorePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23844l) {
                SearchResultsSeeMorePartDefinition searchResultsSeeMorePartDefinition;
                if (a2 != null) {
                    searchResultsSeeMorePartDefinition = (SearchResultsSeeMorePartDefinition) a2.a(f23844l);
                } else {
                    searchResultsSeeMorePartDefinition = f23843k;
                }
                if (searchResultsSeeMorePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27459b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23844l, b3);
                        } else {
                            f23843k = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsSeeMorePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SearchResultsSeeMorePartDefinition(TextPartDefinition textPartDefinition, SearchResultsSeeMoreClickListenerPartDefinition searchResultsSeeMoreClickListenerPartDefinition, SearchResultsTabSwitchPartDefinition searchResultsTabSwitchPartDefinition, BackgroundPartDefinition backgroundPartDefinition, QeAccessor qeAccessor) {
        this.f23845f = textPartDefinition;
        this.f23846g = searchResultsSeeMoreClickListenerPartDefinition;
        this.f23847h = searchResultsTabSwitchPartDefinition;
        this.f23848i = backgroundPartDefinition;
        this.f23849j = qeAccessor;
    }

    public final ViewType m27460a() {
        return f23838a;
    }

    public static boolean m27456a(QeAccessor qeAccessor, SearchResultsCollectionUnit<?> searchResultsCollectionUnit) {
        if (m27458b(qeAccessor, searchResultsCollectionUnit) != null) {
            return true;
        }
        if (searchResultsCollectionUnit.mo1321k() == GraphQLGraphSearchResultRole.TOPIC_MEDIA && searchResultsCollectionUnit.mo1330m().isPresent()) {
            return true;
        }
        return searchResultsCollectionUnit.mo1330m().isPresent() && searchResultsCollectionUnit.f23460a.isPresent() && SearchResultsIntentBuilder.a((GraphQLGraphSearchResultsDisplayStyle) searchResultsCollectionUnit.f23460a.get()) && searchResultsCollectionUnit.mo1321k() != GraphQLGraphSearchResultRole.NEWS_MODULE && searchResultsCollectionUnit.f23460a.get() != GraphQLGraphSearchResultsDisplayStyle.WEB;
    }

    public static SearchResultsTab m27458b(QeAccessor qeAccessor, SearchResultsCollectionUnit<?> searchResultsCollectionUnit) {
        if (!qeAccessor.a(ExperimentsForSearchAbTestModule.w, false) && f23840c.containsKey(searchResultsCollectionUnit.mo1321k())) {
            return (SearchResultsTab) f23840c.get(searchResultsCollectionUnit.mo1321k());
        }
        return null;
    }

    protected static boolean m27457a(SearchResultsCollectionUnit<?> searchResultsCollectionUnit) {
        return searchResultsCollectionUnit.mo1321k() == GraphQLGraphSearchResultRole.NEWS_EYEWITNESSES;
    }
}
