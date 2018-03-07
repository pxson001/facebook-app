package com.facebook.feed.inlinecomposer.multirow;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.inlinecomposer.multirow.common.HasFeedUnitTopGetter;
import com.facebook.feed.inlinecomposer.multirow.common.InlineComposerEnvironment;
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
import javax.annotation.Nullable;

@ContextScoped
/* compiled from: must call addApi() to add at least one API */
public class InlineComposerExposedTopGetterPartDefinition<E extends HasFeedUnitTopGetter> extends BaseSinglePartDefinition<Void, Void, E, View> {
    private static InlineComposerExposedTopGetterPartDefinition f13173b;
    private static final Object f13174c = new Object();
    public final SettableTopGetter f13175a = new SettableTopGetter();

    /* compiled from: must call addApi() to add at least one API */
    public class SettableTopGetter {
        public final int[] f13176a = new int[2];
        @Nullable
        public View f13177b;
    }

    private static InlineComposerExposedTopGetterPartDefinition m19370a() {
        return new InlineComposerExposedTopGetterPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1673064570);
        InlineComposerEnvironment inlineComposerEnvironment = (InlineComposerEnvironment) anyEnvironment;
        this.f13175a.f13177b = view;
        inlineComposerEnvironment.f12852r = this.f13175a;
        Logger.a(8, EntryType.MARK_POP, -320127670, a);
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((InlineComposerEnvironment) anyEnvironment).f12852r = null;
        this.f13175a.f13177b = null;
    }

    public static InlineComposerExposedTopGetterPartDefinition m19371a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InlineComposerExposedTopGetterPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.m1330a(b2);
            synchronized (f13174c) {
                InlineComposerExposedTopGetterPartDefinition inlineComposerExposedTopGetterPartDefinition;
                if (a3 != null) {
                    inlineComposerExposedTopGetterPartDefinition = (InlineComposerExposedTopGetterPartDefinition) a3.mo818a(f13174c);
                } else {
                    inlineComposerExposedTopGetterPartDefinition = f13173b;
                }
                if (inlineComposerExposedTopGetterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.m1474e();
                        a2 = m19370a();
                        if (a3 != null) {
                            a3.mo822a(f13174c, a2);
                        } else {
                            f13173b = a2;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    a2 = inlineComposerExposedTopGetterPartDefinition;
                }
            }
            return a2;
        } finally {
            a.m1505c(b);
        }
    }
}
