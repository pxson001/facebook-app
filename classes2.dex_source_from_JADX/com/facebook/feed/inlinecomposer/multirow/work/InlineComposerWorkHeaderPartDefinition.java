package com.facebook.feed.inlinecomposer.multirow.work;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.inlinecomposer.model.InlineComposerModel;
import com.facebook.feed.inlinecomposer.work.WorkHeaderGroupsActionHandler;
import com.facebook.feed.inlinecomposer.work.WorkHeaderView;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.DefaultPaddingStyleResolver;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: native_document/?id={%s -1} */
public class InlineComposerWorkHeaderPartDefinition extends MultiRowSinglePartDefinition<InlineComposerModel, OnClickListener, HasPositionInformation, WorkHeaderView> {
    public static final ViewType<WorkHeaderView> f13001a = new C05291();
    private static InlineComposerWorkHeaderPartDefinition f13002e;
    private static final Object f13003f = new Object();
    private final BackgroundPartDefinition f13004b;
    private final PaddingStyle f13005c;
    public final WorkHeaderGroupsActionHandler f13006d;

    /* compiled from: native_document/?id={%s -1} */
    final class C05291 extends ViewType<WorkHeaderView> {
        C05291() {
        }

        public final View mo1995a(Context context) {
            return new WorkHeaderView(context);
        }
    }

    private static InlineComposerWorkHeaderPartDefinition m19127b(InjectorLike injectorLike) {
        return new InlineComposerWorkHeaderPartDefinition(BackgroundPartDefinition.m19135a(injectorLike), DefaultPaddingStyleResolver.m19157a(injectorLike), WorkHeaderGroupsActionHandler.m19209b(injectorLike));
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1038798198);
        ((WorkHeaderView) view).setActionButtonClickListener((OnClickListener) obj2);
        Logger.a(8, EntryType.MARK_POP, -710842940, a);
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((WorkHeaderView) view).setActionButtonClickListener(null);
    }

    @Inject
    public InlineComposerWorkHeaderPartDefinition(BackgroundPartDefinition backgroundPartDefinition, DefaultPaddingStyleResolver defaultPaddingStyleResolver, WorkHeaderGroupsActionHandler workHeaderGroupsActionHandler) {
        this.f13004b = backgroundPartDefinition;
        Builder a = Builder.m19301a();
        a.f13067c = defaultPaddingStyleResolver.m19169c();
        this.f13005c = a.m19313i();
        this.f13006d = workHeaderGroupsActionHandler;
    }

    public final boolean m19131a(Object obj) {
        return true;
    }

    public final ViewType<WorkHeaderView> mo2547a() {
        return f13001a;
    }

    public static InlineComposerWorkHeaderPartDefinition m19126a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InlineComposerWorkHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f13003f) {
                InlineComposerWorkHeaderPartDefinition inlineComposerWorkHeaderPartDefinition;
                if (a2 != null) {
                    inlineComposerWorkHeaderPartDefinition = (InlineComposerWorkHeaderPartDefinition) a2.mo818a(f13003f);
                } else {
                    inlineComposerWorkHeaderPartDefinition = f13002e;
                }
                if (inlineComposerWorkHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m19127b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f13003f, b3);
                        } else {
                            f13002e = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = inlineComposerWorkHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.mo2756a(this.f13004b, new StylingData(this.f13005c));
        return new 2(this);
    }
}
