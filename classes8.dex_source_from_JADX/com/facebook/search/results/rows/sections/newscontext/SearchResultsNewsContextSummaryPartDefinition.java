package com.facebook.search.results.rows.sections.newscontext;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
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
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PageCallToActionButton.bindModel */
public class SearchResultsNewsContextSummaryPartDefinition extends MultiRowSinglePartDefinition<String, Void, HasPositionInformation, BetterTextView> {
    public static final ViewType f24662a = ViewType.a(2130905448);
    private static final PaddingStyle f24663b;
    private static SearchResultsNewsContextSummaryPartDefinition f24664e;
    private static final Object f24665f = new Object();
    private final TextPartDefinition f24666c;
    private final BackgroundPartDefinition f24667d;

    private static SearchResultsNewsContextSummaryPartDefinition m28080b(InjectorLike injectorLike) {
        return new SearchResultsNewsContextSummaryPartDefinition(TextPartDefinition.a(injectorLike), BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m28082a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        HasPositionInformation hasPositionInformation = (HasPositionInformation) anyEnvironment;
        subParts.a(this.f24666c, (String) obj);
        Object obj2 = ((hasPositionInformation.h() instanceof SearchResultsNewsContextAttributionPartDefinition) || (hasPositionInformation.h() instanceof ShareTopicFooterPartDefinition)) ? 1 : null;
        subParts.a(this.f24667d, new StylingData(null, f24663b, obj2 != null ? Position.MIDDLE : Position.BOTTOM));
        return null;
    }

    static {
        Builder a = Builder.a();
        a.b = -4.0f;
        a = a;
        a.c = 0.0f;
        f24663b = a.i();
    }

    @Inject
    public SearchResultsNewsContextSummaryPartDefinition(TextPartDefinition textPartDefinition, BackgroundPartDefinition backgroundPartDefinition) {
        this.f24666c = textPartDefinition;
        this.f24667d = backgroundPartDefinition;
    }

    public final ViewType m28081a() {
        return f24662a;
    }

    public final boolean m28083a(Object obj) {
        return true;
    }

    public static SearchResultsNewsContextSummaryPartDefinition m28079a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsNewsContextSummaryPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24665f) {
                SearchResultsNewsContextSummaryPartDefinition searchResultsNewsContextSummaryPartDefinition;
                if (a2 != null) {
                    searchResultsNewsContextSummaryPartDefinition = (SearchResultsNewsContextSummaryPartDefinition) a2.a(f24665f);
                } else {
                    searchResultsNewsContextSummaryPartDefinition = f24664e;
                }
                if (searchResultsNewsContextSummaryPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28080b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24665f, b3);
                        } else {
                            f24664e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsNewsContextSummaryPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
