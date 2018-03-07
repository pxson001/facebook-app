package com.facebook.feedplugins.spannable;

import android.content.Context;
import android.text.Layout;
import android.view.View;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.lifecycle.AttachDetachListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.fbui.widget.text.TextLayoutView;
import com.facebook.fbui.widget.text.TextLayoutView.LayoutCreator;
import com.facebook.fbui.widget.text.TextLayoutView.WidthErrorReporter;
import com.facebook.fbui.widget.text.layoutbuilder.TextLayoutBuilder;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.spannable.PersistentSpannable;
import com.facebook.feed.util.render.FeedRenderUtils;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.widget.text.abtest.ExperimentsForWidgetTextAbTestModule;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;

@ContextScoped
/* compiled from: homepage_stream */
public class SpannableInTextLayoutPartDefinition<E extends HasPersistentState & HasInvalidate> extends BaseSinglePartDefinition<PersistentSpannableInput, State, E, TextLayoutView> {
    private static SpannableInTextLayoutPartDefinition f20898f;
    private static final Object f20899g = new Object();
    public final FeedRenderUtils f20900a;
    private final PersistentSpannablePreparer f20901b;
    public final AbstractFbErrorReporter f20902c;
    public final Set<String> f20903d = new HashSet();
    private final QeAccessor f20904e;

    /* compiled from: homepage_stream */
    public class State {
        public final int f21852a;
        public final Layout f21853b;
        public final WidthErrorReporter f21854c;
        public final LayoutCreator f21855d;
        public final AttachDetachListener f21856e;

        public State(Layout layout, int i, WidthErrorReporter widthErrorReporter, LayoutCreator layoutCreator, AttachDetachListener attachDetachListener) {
            this.f21853b = layout;
            this.f21852a = i;
            this.f21854c = widthErrorReporter;
            this.f21855d = layoutCreator;
            this.f21856e = attachDetachListener;
        }
    }

    private static SpannableInTextLayoutPartDefinition m28628b(InjectorLike injectorLike) {
        return new SpannableInTextLayoutPartDefinition(FeedRenderUtils.m14652a(injectorLike), PersistentSpannablePreparer.m28258a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final PersistentSpannableInput persistentSpannableInput = (PersistentSpannableInput) obj;
        final HasPersistentState hasPersistentState = (HasPersistentState) anyEnvironment;
        if (this.f20904e.mo596a(ExperimentsForWidgetTextAbTestModule.f21794b, false)) {
            this.f20901b.m28262c(persistentSpannableInput, hasPersistentState);
        } else {
            this.f20901b.m28261b(persistentSpannableInput, hasPersistentState);
        }
        int e = persistentSpannableInput.mo3197e();
        return new State(m28626a(this, persistentSpannableInput, hasPersistentState, e), e, new WidthErrorReporter(this) {
            final /* synthetic */ SpannableInTextLayoutPartDefinition f21878b;

            public final void mo3208a(CharSequence charSequence, int i, int i2) {
                if (this.f21878b.f20903d.add(persistentSpannableInput.mo3195c().mo2507g()) && Math.abs(i - i2) != this.f21878b.f20900a.m14658b() && Math.random() < 0.001d) {
                    this.f21878b.f20902c.m2340a("WrongWidthForTextLayout", StringFormatUtil.a("Regenerating layout for text = %s\nexpected width = %s\nactual width = %s\nwidth-height difference = %s\npersistent spannble input = %s\nstory = %s", new Object[]{charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(r2), persistentSpannableInput, r0}));
                }
            }
        }, new LayoutCreator(this) {
            final /* synthetic */ SpannableInTextLayoutPartDefinition f21881c;

            public final Layout mo3209a(int i) {
                return SpannableInTextLayoutPartDefinition.m28626a(this.f21881c, persistentSpannableInput, hasPersistentState, i);
            }
        }, ((PersistentSpannable) hasPersistentState.mo2425a(persistentSpannableInput.mo3193a(), persistentSpannableInput.mo3195c())).f21835c);
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((TextLayoutView) view).setAttachDetachListener(null);
    }

    public static SpannableInTextLayoutPartDefinition m28627a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SpannableInTextLayoutPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20899g) {
                SpannableInTextLayoutPartDefinition spannableInTextLayoutPartDefinition;
                if (a2 != null) {
                    spannableInTextLayoutPartDefinition = (SpannableInTextLayoutPartDefinition) a2.mo818a(f20899g);
                } else {
                    spannableInTextLayoutPartDefinition = f20898f;
                }
                if (spannableInTextLayoutPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28628b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20899g, b3);
                        } else {
                            f20898f = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = spannableInTextLayoutPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public SpannableInTextLayoutPartDefinition(FeedRenderUtils feedRenderUtils, PersistentSpannablePreparer persistentSpannablePreparer, AbstractFbErrorReporter abstractFbErrorReporter, QeAccessor qeAccessor) {
        this.f20900a = feedRenderUtils;
        this.f20901b = persistentSpannablePreparer;
        this.f20902c = abstractFbErrorReporter;
        this.f20904e = qeAccessor;
    }

    public static Layout m28626a(SpannableInTextLayoutPartDefinition spannableInTextLayoutPartDefinition, PersistentSpannableInput persistentSpannableInput, HasPersistentState hasPersistentState, int i) {
        TextLayoutBuilder d = persistentSpannableInput.mo3196d();
        d.m28592a(i);
        d.m28599a((CharSequence) ((PersistentSpannable) hasPersistentState.mo2425a(persistentSpannableInput.mo3193a(), persistentSpannableInput.mo3195c())).f21833a);
        return d.m28608d();
    }
}
