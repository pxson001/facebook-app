package com.facebook.redspace.rows.header;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.common.propertybag.PropertyBag;
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
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.redspace.abtest.ExperimentsForRedSpaceExperimentsModule;
import com.facebook.redspace.rows.RedSpaceEnvironment;
import com.facebook.ultralight.Inject;
import com.facebook.widget.text.BetterTextView;

@ContextScoped
/* compiled from: PULSAR */
public class RedSpaceHeaderTitlePartDefinition extends MultiRowSinglePartDefinition<CharSequence, Void, RedSpaceEnvironment, BetterTextView> {
    public static final ViewType<BetterTextView> f12210a = ViewType.a(2130906759);
    private static final PaddingStyle f12211b = Builder.b().a(2).b(1).i();
    private static RedSpaceHeaderTitlePartDefinition f12212f;
    private static final Object f12213g = new Object();
    private final QeAccessor f12214c;
    private final TextPartDefinition f12215d;
    private final BackgroundPartDefinition f12216e;

    private static RedSpaceHeaderTitlePartDefinition m12682b(InjectorLike injectorLike) {
        return new RedSpaceHeaderTitlePartDefinition((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), TextPartDefinition.a(injectorLike), BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m12684a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f12215d, (CharSequence) obj);
        subParts.a(this.f12216e, new StylingData(f12211b));
        return null;
    }

    public final boolean m12685a(Object obj) {
        return !TextUtils.isEmpty((CharSequence) obj) && this.f12214c.a(ExperimentsForRedSpaceExperimentsModule.l, false);
    }

    @Inject
    private RedSpaceHeaderTitlePartDefinition(QeAccessor qeAccessor, TextPartDefinition textPartDefinition, BackgroundPartDefinition backgroundPartDefinition) {
        this.f12214c = qeAccessor;
        this.f12215d = textPartDefinition;
        this.f12216e = backgroundPartDefinition;
    }

    public final ViewType<BetterTextView> m12683a() {
        return f12210a;
    }

    public static RedSpaceHeaderTitlePartDefinition m12681a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RedSpaceHeaderTitlePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12213g) {
                RedSpaceHeaderTitlePartDefinition redSpaceHeaderTitlePartDefinition;
                if (a2 != null) {
                    redSpaceHeaderTitlePartDefinition = (RedSpaceHeaderTitlePartDefinition) a2.a(f12213g);
                } else {
                    redSpaceHeaderTitlePartDefinition = f12212f;
                }
                if (redSpaceHeaderTitlePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12682b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12213g, b3);
                        } else {
                            f12212f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = redSpaceHeaderTitlePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
