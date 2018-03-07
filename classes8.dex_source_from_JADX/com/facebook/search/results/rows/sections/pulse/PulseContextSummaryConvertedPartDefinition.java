package com.facebook.search.results.rows.sections.pulse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
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
import com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlInterfaces.SearchResultsArticleExternalUrl;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PRIORITY_SENDER */
public class PulseContextSummaryConvertedPartDefinition extends MultiRowSinglePartDefinition<SearchResultsArticleExternalUrl, CharSequence, HasPositionInformation, BetterTextView> {
    public static final ViewType<BetterTextView> f24857a = new C26181();
    private static final PaddingStyle f24858b;
    private static PulseContextSummaryConvertedPartDefinition f24859d;
    private static final Object f24860e = new Object();
    private final BackgroundPartDefinition f24861c;

    /* compiled from: PRIORITY_SENDER */
    final class C26181 extends ViewType<BetterTextView> {
        C26181() {
        }

        public final View m28228a(Context context) {
            return (BetterTextView) LayoutInflater.from(context).inflate(2130906514, null);
        }
    }

    private static PulseContextSummaryConvertedPartDefinition m28230b(InjectorLike injectorLike) {
        return new PulseContextSummaryConvertedPartDefinition(BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m28232a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        SearchResultsArticleExternalUrl searchResultsArticleExternalUrl = (SearchResultsArticleExternalUrl) obj;
        subParts.a(this.f24861c, new StylingData(f24858b));
        return searchResultsArticleExternalUrl.mo579T().m10481a();
    }

    public final /* bridge */ /* synthetic */ void m28233a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 63204119);
        ((BetterTextView) view).setText((CharSequence) obj2);
        Logger.a(8, EntryType.MARK_POP, -1615768889, a);
    }

    public final boolean m28234a(Object obj) {
        return ((SearchResultsArticleExternalUrl) obj).mo579T() != null;
    }

    static {
        Builder a = Builder.a();
        a.c = -6.0f;
        f24858b = a.i();
    }

    @Inject
    public PulseContextSummaryConvertedPartDefinition(BackgroundPartDefinition backgroundPartDefinition) {
        this.f24861c = backgroundPartDefinition;
    }

    public final ViewType<BetterTextView> m28231a() {
        return f24857a;
    }

    public static PulseContextSummaryConvertedPartDefinition m28229a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PulseContextSummaryConvertedPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24860e) {
                PulseContextSummaryConvertedPartDefinition pulseContextSummaryConvertedPartDefinition;
                if (a2 != null) {
                    pulseContextSummaryConvertedPartDefinition = (PulseContextSummaryConvertedPartDefinition) a2.a(f24860e);
                } else {
                    pulseContextSummaryConvertedPartDefinition = f24859d;
                }
                if (pulseContextSummaryConvertedPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28230b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24860e, b3);
                        } else {
                            f24859d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pulseContextSummaryConvertedPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
