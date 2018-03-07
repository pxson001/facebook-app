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
import com.facebook.graphql.model.GraphQLQuotesAnalysisItem;
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
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PTR */
public class PulseCommonQuoteContentPartDefinition extends MultiRowSinglePartDefinition<GraphQLQuotesAnalysisItem, Void, HasPositionInformation, BetterTextView> {
    public static final ViewType f24731a = new C26101();
    private static final PaddingStyle f24732b;
    private static PulseCommonQuoteContentPartDefinition f24733d;
    private static final Object f24734e = new Object();
    private final BackgroundPartDefinition f24735c;

    /* compiled from: PTR */
    final class C26101 extends ViewType {
        C26101() {
        }

        public final View m28142a(Context context) {
            return LayoutInflater.from(context).inflate(2130906517, null);
        }
    }

    private static PulseCommonQuoteContentPartDefinition m28144b(InjectorLike injectorLike) {
        return new PulseCommonQuoteContentPartDefinition(BackgroundPartDefinition.a(injectorLike));
    }

    public final /* bridge */ /* synthetic */ void m28147a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1069048360);
        ((BetterTextView) view).setText(((GraphQLQuotesAnalysisItem) obj).j());
        Logger.a(8, EntryType.MARK_POP, -248242978, a);
    }

    public final boolean m28148a(Object obj) {
        return ((GraphQLQuotesAnalysisItem) obj).j() != null;
    }

    static {
        Builder a = Builder.a();
        a.b = 6.0f;
        f24732b = a.i();
    }

    @Inject
    public PulseCommonQuoteContentPartDefinition(BackgroundPartDefinition backgroundPartDefinition) {
        this.f24735c = backgroundPartDefinition;
    }

    public final ViewType m28145a() {
        return f24731a;
    }

    public static PulseCommonQuoteContentPartDefinition m28143a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PulseCommonQuoteContentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24734e) {
                PulseCommonQuoteContentPartDefinition pulseCommonQuoteContentPartDefinition;
                if (a2 != null) {
                    pulseCommonQuoteContentPartDefinition = (PulseCommonQuoteContentPartDefinition) a2.a(f24734e);
                } else {
                    pulseCommonQuoteContentPartDefinition = f24733d;
                }
                if (pulseCommonQuoteContentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28144b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24734e, b3);
                        } else {
                            f24733d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pulseCommonQuoteContentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final Object m28146a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f24735c, new StylingData(f24732b));
        return null;
    }
}
