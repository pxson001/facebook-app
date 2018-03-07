package com.facebook.redspace.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.SizeUtil;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
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
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.redspace.abtest.ExperimentsForRedSpaceExperimentsModule;
import com.facebook.redspace.data.RedSpaceNewsFeedTitle;
import com.facebook.ultralight.Inject;
import com.facebook.widget.ViewHelper;
import com.facebook.widget.text.BetterTextView;

@ContextScoped
/* compiled from: PageActionBar.bindModel */
public class RedSpaceNewsFeedTitlePartDefinition extends MultiRowSinglePartDefinition<Object, Void, RedSpaceEnvironment, BetterTextView> {
    public static final ViewType<BetterTextView> f12195a = ViewType.a(2130906759);
    private static RedSpaceNewsFeedTitlePartDefinition f12196d;
    private static final Object f12197e = new Object();
    private final TextPartDefinition f12198b;
    private final QeAccessor f12199c;

    private static RedSpaceNewsFeedTitlePartDefinition m12663b(InjectorLike injectorLike) {
        return new RedSpaceNewsFeedTitlePartDefinition(TextPartDefinition.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final /* bridge */ /* synthetic */ void m12666a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -300936467);
        BetterTextView betterTextView = (BetterTextView) view;
        Context context = betterTextView.getContext();
        ViewHelper.a(betterTextView, 0);
        betterTextView.setPadding(SizeUtil.a(context, 12.0f), SizeUtil.a(context, 16.0f), SizeUtil.a(context, 12.0f), SizeUtil.a(context, 0.0f));
        Logger.a(8, EntryType.MARK_POP, -1749956798, a);
    }

    @Inject
    private RedSpaceNewsFeedTitlePartDefinition(TextPartDefinition textPartDefinition, QeAccessor qeAccessor) {
        this.f12198b = textPartDefinition;
        this.f12199c = qeAccessor;
    }

    public final boolean m12667a(Object obj) {
        return (obj instanceof RedSpaceNewsFeedTitle) && this.f12199c.a(ExperimentsForRedSpaceExperimentsModule.l, false);
    }

    public final ViewType<BetterTextView> m12664a() {
        return f12195a;
    }

    public final Object m12665a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f12198b, ((RedSpaceNewsFeedTitle) obj).f11848a);
        return null;
    }

    public static RedSpaceNewsFeedTitlePartDefinition m12662a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RedSpaceNewsFeedTitlePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12197e) {
                RedSpaceNewsFeedTitlePartDefinition redSpaceNewsFeedTitlePartDefinition;
                if (a2 != null) {
                    redSpaceNewsFeedTitlePartDefinition = (RedSpaceNewsFeedTitlePartDefinition) a2.a(f12197e);
                } else {
                    redSpaceNewsFeedTitlePartDefinition = f12196d;
                }
                if (redSpaceNewsFeedTitlePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12663b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12197e, b3);
                        } else {
                            f12196d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = redSpaceNewsFeedTitlePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
