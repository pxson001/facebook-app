package com.facebook.search.results.rows.sections.common;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.feed.environment.HasContext;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.search.api.SearchQueryFunctions;
import com.facebook.search.intent.SearchResultsIntentBuilder;
import com.facebook.search.logging.SearchResultsLogger;
import com.facebook.search.logging.api.SearchResultsSource;
import com.facebook.search.results.environment.HasFeedItemPosition;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.environment.HasSearchResultsPerformanceLogger;
import com.facebook.search.results.model.contract.SearchResultsFeedImpressionTrackable;
import com.facebook.search.results.model.contract.SearchResultsSeeMoreFeedUnit;
import com.facebook.search.results.rows.sections.seemore.SearchResultsSeeMoreQueryPartDefinition;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: REACTION_OVERLAY_CLOSED_WITH_PLACE */
public class SearchResultsSeeMoreClickListenerPartDefinition<E extends HasContext & HasFeedItemPosition & HasSearchResultsContext & HasSearchResultsPerformanceLogger> extends BaseSinglePartDefinition<SeeMoreData, OnClickListener, E, View> {
    private static SearchResultsSeeMoreClickListenerPartDefinition f24030d;
    private static final Object f24031e = new Object();
    private final SearchResultsLogger f24032a;
    private final SearchResultsIntentBuilder f24033b;
    private final SecureContextHelper f24034c;

    /* compiled from: REACTION_OVERLAY_CLOSED_WITH_PLACE */
    public class SeeMoreData {
        public final SearchResultsSeeMoreFeedUnit f24026a;
        public final SearchResultsSeeMoreLogger f24027b;
        public final int f24028c;
        public final boolean f24029d;

        public SeeMoreData(SearchResultsSeeMoreFeedUnit searchResultsSeeMoreFeedUnit, SearchResultsSeeMoreLogger searchResultsSeeMoreLogger, int i) {
            this(searchResultsSeeMoreFeedUnit, searchResultsSeeMoreLogger, i, false);
        }

        public SeeMoreData(SearchResultsSeeMoreFeedUnit searchResultsSeeMoreFeedUnit, SearchResultsSeeMoreLogger searchResultsSeeMoreLogger, int i, boolean z) {
            this.f24026a = searchResultsSeeMoreFeedUnit;
            this.f24027b = searchResultsSeeMoreLogger;
            this.f24028c = i;
            this.f24029d = z;
        }
    }

    private static SearchResultsSeeMoreClickListenerPartDefinition m27602b(InjectorLike injectorLike) {
        return new SearchResultsSeeMoreClickListenerPartDefinition(SearchResultsLogger.m25460a(injectorLike), SearchResultsIntentBuilder.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    public final Object m27603a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final SeeMoreData seeMoreData = (SeeMoreData) obj;
        final HasContext hasContext = (HasContext) anyEnvironment;
        return new OnClickListener(this) {
            final /* synthetic */ SearchResultsSeeMoreClickListenerPartDefinition f24025c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1596965175);
                this.f24025c.m27604a(hasContext, seeMoreData);
                Logger.a(2, EntryType.UI_INPUT_END, -2008034014, a);
            }
        };
    }

    public final /* bridge */ /* synthetic */ void m27605a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -577655357);
        m27601a((SeeMoreData) obj, (OnClickListener) obj2, view);
        Logger.a(8, EntryType.MARK_POP, 2112906485, a);
    }

    public final void m27606b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        View view2;
        if (((SeeMoreData) obj).f24029d && (view instanceof ContentView)) {
            view2 = ((ContentView) view).a;
        } else {
            view2 = view;
        }
        if (view2 != null) {
            view = view2;
        }
        view.setOnClickListener(null);
    }

    public static SearchResultsSeeMoreClickListenerPartDefinition m27600a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsSeeMoreClickListenerPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24031e) {
                SearchResultsSeeMoreClickListenerPartDefinition searchResultsSeeMoreClickListenerPartDefinition;
                if (a2 != null) {
                    searchResultsSeeMoreClickListenerPartDefinition = (SearchResultsSeeMoreClickListenerPartDefinition) a2.a(f24031e);
                } else {
                    searchResultsSeeMoreClickListenerPartDefinition = f24030d;
                }
                if (searchResultsSeeMoreClickListenerPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27602b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24031e, b3);
                        } else {
                            f24030d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsSeeMoreClickListenerPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SearchResultsSeeMoreClickListenerPartDefinition(SearchResultsLogger searchResultsLogger, SearchResultsIntentBuilder searchResultsIntentBuilder, SecureContextHelper secureContextHelper) {
        this.f24032a = searchResultsLogger;
        this.f24033b = searchResultsIntentBuilder;
        this.f24034c = secureContextHelper;
    }

    private static void m27601a(SeeMoreData seeMoreData, OnClickListener onClickListener, View view) {
        View view2;
        if (seeMoreData.f24029d && (view instanceof ContentView)) {
            view2 = ((ContentView) view).a;
        } else {
            view2 = view;
        }
        if (view2 != null) {
            view = view2;
        }
        view.setOnClickListener(onClickListener);
    }

    public final void m27604a(E e, SeeMoreData seeMoreData) {
        GraphQLGraphSearchResultsDisplayStyle graphQLGraphSearchResultsDisplayStyle;
        String a;
        GraphQLGraphSearchResultRole k;
        Object obj;
        SearchResultsSeeMoreFeedUnit searchResultsSeeMoreFeedUnit = seeMoreData.f24026a;
        if ((searchResultsSeeMoreFeedUnit instanceof SearchResultsFeedImpressionTrackable) && ((SearchResultsFeedImpressionTrackable) searchResultsSeeMoreFeedUnit).mo1321k() == GraphQLGraphSearchResultRole.TOPIC_MEDIA) {
            graphQLGraphSearchResultsDisplayStyle = GraphQLGraphSearchResultsDisplayStyle.PHOTOS;
        } else {
            graphQLGraphSearchResultsDisplayStyle = searchResultsSeeMoreFeedUnit.mo1331n();
        }
        Object obj2 = graphQLGraphSearchResultsDisplayStyle == GraphQLGraphSearchResultsDisplayStyle.ENTITY_HSCROLL ? 1 : null;
        if (obj2 != null) {
            a = ((HasSearchResultsContext) e).mo1248s().mo1211a();
        } else if (!searchResultsSeeMoreFeedUnit.mo1329f().isPresent() || Strings.isNullOrEmpty((String) searchResultsSeeMoreFeedUnit.mo1329f().get())) {
            a = e.getContext().getString(seeMoreData.f24028c);
        } else {
            a = (String) searchResultsSeeMoreFeedUnit.mo1329f().get();
        }
        String p = obj2 != null ? SearchQueryFunctions.p(a) : (String) searchResultsSeeMoreFeedUnit.mo1330m().get();
        SearchResultsIntentBuilder searchResultsIntentBuilder = this.f24033b;
        String str = ((HasSearchResultsContext) e).mo1248s().f23382q;
        SearchResultsSource a2 = SearchResultsSeeMoreQueryPartDefinition.m28330a((HasSearchResultsContext) e);
        if (searchResultsSeeMoreFeedUnit instanceof SearchResultsFeedImpressionTrackable) {
            k = ((SearchResultsFeedImpressionTrackable) searchResultsSeeMoreFeedUnit).mo1321k();
        } else {
            k = null;
        }
        Intent a3 = searchResultsIntentBuilder.a(graphQLGraphSearchResultsDisplayStyle, a, p, str, a2, k, ((HasSearchResultsContext) e).mo1248s().f23369d);
        int intExtra = a3.getIntExtra("target_fragment", -1);
        if (intExtra == ContentFragmentType.SEARCH_FRAGMENT.ordinal() || intExtra == ContentFragmentType.SEARCH_RESULTS_FEED_FRAGMENT.ordinal()) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            ((HasSearchResultsPerformanceLogger) e).mo1249t();
        }
        this.f24034c.a(a3, e.getContext());
        seeMoreData.f24027b.mo1334a(this.f24032a, (HasSearchResultsContext) e, searchResultsSeeMoreFeedUnit);
    }
}
