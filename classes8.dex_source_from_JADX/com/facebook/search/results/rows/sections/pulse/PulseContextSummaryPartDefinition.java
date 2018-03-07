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
import com.facebook.search.results.model.unit.SearchResultsPulseContextUnit;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

@ContextScoped
@Deprecated
/* compiled from: PRIORITY_FB_TOKEN_2 */
public class PulseContextSummaryPartDefinition extends MultiRowSinglePartDefinition<SearchResultsPulseContextUnit, CharSequence, HasPositionInformation, BetterTextView> {
    public static final ViewType f24862a = new C26191();
    private static final PaddingStyle f24863b;
    private static PulseContextSummaryPartDefinition f24864d;
    private static final Object f24865e = new Object();
    private final BackgroundPartDefinition f24866c;

    /* compiled from: PRIORITY_FB_TOKEN_2 */
    final class C26191 extends ViewType {
        C26191() {
        }

        public final View m28235a(Context context) {
            return LayoutInflater.from(context).inflate(2130906514, null);
        }
    }

    private static PulseContextSummaryPartDefinition m28237b(InjectorLike injectorLike) {
        return new PulseContextSummaryPartDefinition(BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m28239a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        SearchResultsPulseContextUnit searchResultsPulseContextUnit = (SearchResultsPulseContextUnit) obj;
        subParts.a(this.f24866c, new StylingData(f24863b));
        return searchResultsPulseContextUnit.m27181n().a();
    }

    public final /* bridge */ /* synthetic */ void m28240a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 2026210973);
        ((BetterTextView) view).setText((CharSequence) obj2);
        Logger.a(8, EntryType.MARK_POP, -837894086, a);
    }

    public final boolean m28241a(Object obj) {
        return ((SearchResultsPulseContextUnit) obj).m27181n() != null;
    }

    static {
        Builder a = Builder.a();
        a.c = -6.0f;
        f24863b = a.i();
    }

    @Inject
    public PulseContextSummaryPartDefinition(BackgroundPartDefinition backgroundPartDefinition) {
        this.f24866c = backgroundPartDefinition;
    }

    public final ViewType m28238a() {
        return f24862a;
    }

    public static PulseContextSummaryPartDefinition m28236a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PulseContextSummaryPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24865e) {
                PulseContextSummaryPartDefinition pulseContextSummaryPartDefinition;
                if (a2 != null) {
                    pulseContextSummaryPartDefinition = (PulseContextSummaryPartDefinition) a2.a(f24865e);
                } else {
                    pulseContextSummaryPartDefinition = f24864d;
                }
                if (pulseContextSummaryPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28237b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24865e, b3);
                        } else {
                            f24864d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pulseContextSummaryPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
