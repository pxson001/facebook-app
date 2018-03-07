package com.facebook.search.results.rows.sections.pulse;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
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
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.search.results.model.unit.SearchResultsPulseContextUnit;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

@ContextScoped
@Deprecated
/* compiled from: PRIVATE_GOING */
public class PulseContextHeaderTextPartDefinition extends MultiRowSinglePartDefinition<SearchResultsPulseContextUnit, Void, HasPositionInformation, BetterTextView> {
    public static final ViewType f24851a = ViewType.a(2130906513);
    private static final PaddingStyle f24852b;
    private static PulseContextHeaderTextPartDefinition f24853e;
    private static final Object f24854f = new Object();
    private final BackgroundPartDefinition f24855c;
    private final TextPartDefinition f24856d;

    private static PulseContextHeaderTextPartDefinition m28224b(InjectorLike injectorLike) {
        return new PulseContextHeaderTextPartDefinition(BackgroundPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike));
    }

    public final Object m28226a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        SearchResultsPulseContextUnit searchResultsPulseContextUnit = (SearchResultsPulseContextUnit) obj;
        subParts.a(this.f24855c, new StylingData(f24852b));
        subParts.a(this.f24856d, searchResultsPulseContextUnit.m27182o().a());
        return null;
    }

    public final boolean m28227a(Object obj) {
        SearchResultsPulseContextUnit searchResultsPulseContextUnit = (SearchResultsPulseContextUnit) obj;
        return (searchResultsPulseContextUnit.m27182o() == null || StringUtil.a(searchResultsPulseContextUnit.m27182o().a())) ? false : true;
    }

    static {
        Builder a = Builder.a();
        a.b = -6.0f;
        a = a;
        a.c = -6.0f;
        f24852b = a.i();
    }

    @Inject
    public PulseContextHeaderTextPartDefinition(BackgroundPartDefinition backgroundPartDefinition, TextPartDefinition textPartDefinition) {
        this.f24855c = backgroundPartDefinition;
        this.f24856d = textPartDefinition;
    }

    public final ViewType<BetterTextView> m28225a() {
        return f24851a;
    }

    public static PulseContextHeaderTextPartDefinition m28223a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PulseContextHeaderTextPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24854f) {
                PulseContextHeaderTextPartDefinition pulseContextHeaderTextPartDefinition;
                if (a2 != null) {
                    pulseContextHeaderTextPartDefinition = (PulseContextHeaderTextPartDefinition) a2.a(f24854f);
                } else {
                    pulseContextHeaderTextPartDefinition = f24853e;
                }
                if (pulseContextHeaderTextPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28224b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24854f, b3);
                        } else {
                            f24853e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pulseContextHeaderTextPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
