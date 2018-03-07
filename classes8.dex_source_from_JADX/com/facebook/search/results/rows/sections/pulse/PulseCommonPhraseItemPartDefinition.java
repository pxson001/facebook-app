package com.facebook.search.results.rows.sections.pulse;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.graphql.model.GraphQLGraphSearchQuery;
import com.facebook.graphql.model.GraphQLPhrasesAnalysisItem;
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
import com.facebook.search.intent.SearchResultsIntentBuilder;
import com.facebook.search.logging.api.SearchResultsSource;
import com.facebook.search.results.environment.HasSearchResultsContext;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PUBLIC_INVITED */
public class PulseCommonPhraseItemPartDefinition<E extends HasContext & HasPositionInformation & HasSearchResultsContext> extends MultiRowSinglePartDefinition<GraphQLPhrasesAnalysisItem, Spannable, E, ContentView> {
    public static final ViewType f24720a = new C26081();
    private static final PaddingStyle f24721b;
    private static PulseCommonPhraseItemPartDefinition f24722g;
    private static final Object f24723h = new Object();
    private final BackgroundPartDefinition f24724c;
    private final ClickListenerPartDefinition f24725d;
    public final SearchResultsIntentBuilder f24726e;
    public final SecureContextHelper f24727f;

    /* compiled from: PUBLIC_INVITED */
    final class C26081 extends ViewType {
        C26081() {
        }

        public final View m28130a(Context context) {
            return LayoutInflater.from(context).inflate(2130906516, null);
        }
    }

    private static PulseCommonPhraseItemPartDefinition m28132b(InjectorLike injectorLike) {
        return new PulseCommonPhraseItemPartDefinition(BackgroundPartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), SearchResultsIntentBuilder.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    public final Object m28134a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final GraphQLPhrasesAnalysisItem graphQLPhrasesAnalysisItem = (GraphQLPhrasesAnalysisItem) obj;
        final HasContext hasContext = (HasContext) anyEnvironment;
        subParts.a(this.f24724c, new StylingData(f24721b));
        subParts.a(this.f24725d, new OnClickListener(this) {
            final /* synthetic */ PulseCommonPhraseItemPartDefinition f24719c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -695665612);
                GraphQLGraphSearchQuery l = graphQLPhrasesAnalysisItem.l();
                if (!(l == null || l.t() == null || l.r() == null)) {
                    this.f24719c.f24727f.a(this.f24719c.f24726e.a((GraphQLGraphSearchResultsDisplayStyle) l.t().get(0), l.r().a(), l.q(), ((HasSearchResultsContext) hasContext).mo1248s().f23382q, SearchResultsSource.s, ((HasSearchResultsContext) hasContext).mo1248s().f23369d), hasContext.getContext());
                }
                Logger.a(2, EntryType.UI_INPUT_END, 996073274, a);
            }
        });
        int o = graphQLPhrasesAnalysisItem.o();
        int n = graphQLPhrasesAnalysisItem.n();
        Spannable spannableString = new SpannableString(graphQLPhrasesAnalysisItem.r());
        spannableString.setSpan(new StyleSpan(1), o, n + o, 17);
        return spannableString;
    }

    public final /* bridge */ /* synthetic */ void m28135a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1431769118);
        GraphQLPhrasesAnalysisItem graphQLPhrasesAnalysisItem = (GraphQLPhrasesAnalysisItem) obj;
        Spannable spannable = (Spannable) obj2;
        HasContext hasContext = (HasContext) anyEnvironment;
        ContentView contentView = (ContentView) view;
        if (!(graphQLPhrasesAnalysisItem.p() == null || graphQLPhrasesAnalysisItem.p().ai() == null)) {
            contentView.setThumbnailUri(graphQLPhrasesAnalysisItem.p().ai().b());
        }
        contentView.setTitleText(spannable);
        contentView.setSubtitleText(hasContext.getContext().getResources().getQuantityString(2131689711, graphQLPhrasesAnalysisItem.j(), new Object[]{Integer.valueOf(graphQLPhrasesAnalysisItem.j())}));
        Logger.a(8, EntryType.MARK_POP, -1063088096, a);
    }

    public final boolean m28136a(Object obj) {
        GraphQLPhrasesAnalysisItem graphQLPhrasesAnalysisItem = (GraphQLPhrasesAnalysisItem) obj;
        return (graphQLPhrasesAnalysisItem.r() == null || graphQLPhrasesAnalysisItem.l() == null) ? false : true;
    }

    static {
        Builder a = Builder.a();
        a.b = -2.0f;
        a = a;
        a.c = 6.0f;
        f24721b = a.i();
    }

    public static PulseCommonPhraseItemPartDefinition m28131a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PulseCommonPhraseItemPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24723h) {
                PulseCommonPhraseItemPartDefinition pulseCommonPhraseItemPartDefinition;
                if (a2 != null) {
                    pulseCommonPhraseItemPartDefinition = (PulseCommonPhraseItemPartDefinition) a2.a(f24723h);
                } else {
                    pulseCommonPhraseItemPartDefinition = f24722g;
                }
                if (pulseCommonPhraseItemPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28132b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24723h, b3);
                        } else {
                            f24722g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pulseCommonPhraseItemPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PulseCommonPhraseItemPartDefinition(BackgroundPartDefinition backgroundPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, SearchResultsIntentBuilder searchResultsIntentBuilder, SecureContextHelper secureContextHelper) {
        this.f24724c = backgroundPartDefinition;
        this.f24725d = clickListenerPartDefinition;
        this.f24726e = searchResultsIntentBuilder;
        this.f24727f = secureContextHelper;
    }

    public final ViewType m28133a() {
        return f24720a;
    }
}
