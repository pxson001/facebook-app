package com.facebook.feed.rows.sections.text;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.views.SupportsCopyStoryText;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.ui.toaster.Toaster;
import javax.inject.Inject;

@ContextScoped
/* compiled from: horizontal_accuracy */
public class CopyTextPartDefinition<V extends View & SupportsCopyStoryText> extends MultiRowSinglePartDefinition<GraphQLStory, CopyTextEventListenerManager, HasContext, V> {
    public static final ViewType f20894a = new C08341();
    private static CopyTextPartDefinition f20895c;
    private static final Object f20896d = new Object();
    private final Lazy<Toaster> f20897b;

    /* compiled from: horizontal_accuracy */
    final class C08341 extends ViewType {
        C08341() {
        }

        public final View mo1995a(Context context) {
            return BaseTextPartDefinition.a.mo1995a(context);
        }
    }

    private static CopyTextPartDefinition m28619b(InjectorLike injectorLike) {
        return new CopyTextPartDefinition(IdBasedLazy.m1808a(injectorLike, 3588));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return new CopyTextEventListenerManager(((HasContext) anyEnvironment).getContext(), this.f20897b, (GraphQLStory) obj);
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -848784321);
        ((CopyTextEventListenerManager) obj2).m31225a(view);
        Logger.a(8, EntryType.MARK_POP, 377460459, a);
    }

    @Inject
    public CopyTextPartDefinition(Lazy<Toaster> lazy) {
        this.f20897b = lazy;
    }

    public static CopyTextPartDefinition m28618a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CopyTextPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20896d) {
                CopyTextPartDefinition copyTextPartDefinition;
                if (a2 != null) {
                    copyTextPartDefinition = (CopyTextPartDefinition) a2.mo818a(f20896d);
                } else {
                    copyTextPartDefinition = f20895c;
                }
                if (copyTextPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28619b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20896d, b3);
                        } else {
                            f20895c = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = copyTextPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((SupportsCopyStoryText) view).iD_();
    }

    public final boolean m28623a(Object obj) {
        return true;
    }

    public final ViewType<V> mo2547a() {
        return f20894a;
    }
}
