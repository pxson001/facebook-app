package com.facebook.search.results.rows.sections.spellcorrection;

import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.widget.contentview.ContentViewWithButton;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.calls.ExactMatchInputExactMatch;
import com.facebook.graphql.enums.GraphQLGraphSearchSpellerConfidence;
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
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.ContentViewTitlePartDefinition;
import com.facebook.search.intent.SearchResultsIntentBuilder;
import com.facebook.search.logging.SearchResultsLogger;
import com.facebook.search.logging.api.SearchResultsSource;
import com.facebook.search.results.environment.HasFeedItemPosition;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.model.unit.SearchResultsSpellCorrectionUnit;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PRESENCE_CHANGED */
public class SearchResultsSpellCorrectionEscapePartDefinition<E extends HasPositionInformation & HasFeedItemPosition & HasSearchResultsContext & HasContext> extends MultiRowSinglePartDefinition<FeedProps<SearchResultsSpellCorrectionUnit>, Void, E, ContentViewWithButton> {
    public static final ViewType<ContentViewWithButton> f25011a = ViewType.a(2130904995);
    private static SearchResultsSpellCorrectionEscapePartDefinition f25012h;
    private static final Object f25013i = new Object();
    private final BackgroundPartDefinition f25014b;
    private final ClickListenerPartDefinition f25015c;
    private final ContentViewTitlePartDefinition f25016d;
    private final SecureContextHelper f25017e;
    private final SearchResultsIntentBuilder f25018f;
    private final SearchResultsLogger f25019g;

    private static SearchResultsSpellCorrectionEscapePartDefinition m28346b(InjectorLike injectorLike) {
        return new SearchResultsSpellCorrectionEscapePartDefinition(BackgroundPartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), ContentViewTitlePartDefinition.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), SearchResultsIntentBuilder.a(injectorLike), SearchResultsLogger.m25460a(injectorLike));
    }

    public final Object m28348a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        final HasPositionInformation hasPositionInformation = (HasPositionInformation) anyEnvironment;
        final SearchResultsSpellCorrectionUnit searchResultsSpellCorrectionUnit = (SearchResultsSpellCorrectionUnit) feedProps.a;
        subParts.a(this.f25015c, new OnClickListener(this) {
            final /* synthetic */ SearchResultsSpellCorrectionEscapePartDefinition f25010c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 308539089);
                SearchResultsSpellCorrectionEscapePartDefinition.m28344a(this.f25010c, view.getContext(), hasPositionInformation, searchResultsSpellCorrectionUnit);
                Logger.a(2, EntryType.UI_INPUT_END, 1472069213, a);
            }
        });
        float f = searchResultsSpellCorrectionUnit.f23517a == GraphQLGraphSearchSpellerConfidence.DID_YOU_MEAN ? 6.0f : 2.0f;
        BackgroundPartDefinition backgroundPartDefinition = this.f25014b;
        Builder a = Builder.a();
        a.b = f;
        subParts.a(backgroundPartDefinition, new StylingData(feedProps, a.i()));
        boolean a2 = m28345a(searchResultsSpellCorrectionUnit.f23517a);
        int i = a2 ? 2131239051 : 2131239052;
        String str = a2 ? searchResultsSpellCorrectionUnit.f23518b : searchResultsSpellCorrectionUnit.f23520d;
        subParts.a(this.f25016d, Html.fromHtml(((HasContext) hasPositionInformation).getContext().getString(i, new Object[]{str})));
        return null;
    }

    public static SearchResultsSpellCorrectionEscapePartDefinition m28343a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsSpellCorrectionEscapePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25013i) {
                SearchResultsSpellCorrectionEscapePartDefinition searchResultsSpellCorrectionEscapePartDefinition;
                if (a2 != null) {
                    searchResultsSpellCorrectionEscapePartDefinition = (SearchResultsSpellCorrectionEscapePartDefinition) a2.a(f25013i);
                } else {
                    searchResultsSpellCorrectionEscapePartDefinition = f25012h;
                }
                if (searchResultsSpellCorrectionEscapePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28346b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f25013i, b3);
                        } else {
                            f25012h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsSpellCorrectionEscapePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SearchResultsSpellCorrectionEscapePartDefinition(BackgroundPartDefinition backgroundPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, ContentViewTitlePartDefinition contentViewTitlePartDefinition, SecureContextHelper secureContextHelper, SearchResultsIntentBuilder searchResultsIntentBuilder, SearchResultsLogger searchResultsLogger) {
        this.f25014b = backgroundPartDefinition;
        this.f25015c = clickListenerPartDefinition;
        this.f25016d = contentViewTitlePartDefinition;
        this.f25017e = secureContextHelper;
        this.f25018f = searchResultsIntentBuilder;
        this.f25019g = searchResultsLogger;
    }

    public final ViewType<ContentViewWithButton> m28347a() {
        return f25011a;
    }

    public final boolean m28349a(Object obj) {
        return true;
    }

    public static void m28344a(SearchResultsSpellCorrectionEscapePartDefinition searchResultsSpellCorrectionEscapePartDefinition, Context context, HasPositionInformation hasPositionInformation, SearchResultsSpellCorrectionUnit searchResultsSpellCorrectionUnit) {
        String str;
        String str2;
        Intent a;
        if (m28345a(searchResultsSpellCorrectionUnit.f23517a)) {
            str = searchResultsSpellCorrectionUnit.f23518b;
            str2 = searchResultsSpellCorrectionUnit.f23519c;
        } else {
            str = searchResultsSpellCorrectionUnit.f23520d;
            str2 = searchResultsSpellCorrectionUnit.f23521e;
        }
        if (searchResultsSpellCorrectionUnit.f23522f == null || searchResultsSpellCorrectionUnit.f23522f.jI_() == null) {
            a = searchResultsSpellCorrectionEscapePartDefinition.f25018f.a(str, str2, ((HasSearchResultsContext) hasPositionInformation).mo1248s().f23382q, SearchResultsSource.p, ((HasSearchResultsContext) hasPositionInformation).mo1248s().f23369d, ExactMatchInputExactMatch.TRUE);
        } else {
            a = searchResultsSpellCorrectionEscapePartDefinition.f25018f.a(str, str2, ((HasSearchResultsContext) hasPositionInformation).mo1248s().f23382q, SearchResultsSource.p, ((HasSearchResultsContext) hasPositionInformation).mo1248s().f23369d, ExactMatchInputExactMatch.TRUE, searchResultsSpellCorrectionUnit.f23522f.jI_(), searchResultsSpellCorrectionUnit.f23522f.mo1216h(), searchResultsSpellCorrectionUnit.f23522f.mo1217i());
        }
        searchResultsSpellCorrectionEscapePartDefinition.f25017e.a(a, context);
        searchResultsSpellCorrectionEscapePartDefinition.f25019g.m25487b(((HasSearchResultsContext) hasPositionInformation).mo1248s(), ((HasFeedItemPosition) hasPositionInformation).mo1245a(searchResultsSpellCorrectionUnit), searchResultsSpellCorrectionUnit.f23517a, searchResultsSpellCorrectionUnit.f23520d, searchResultsSpellCorrectionUnit.f23521e);
    }

    private static boolean m28345a(GraphQLGraphSearchSpellerConfidence graphQLGraphSearchSpellerConfidence) {
        return graphQLGraphSearchSpellerConfidence != GraphQLGraphSearchSpellerConfidence.DID_YOU_MEAN;
    }
}
