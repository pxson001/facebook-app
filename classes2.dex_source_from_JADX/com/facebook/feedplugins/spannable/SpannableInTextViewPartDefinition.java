package com.facebook.feedplugins.spannable;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.View;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.spannable.PersistentSpannable;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.interfaces.CacheableEntity;
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
import com.facebook.multirow.api.SubParts;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.widget.text.BetterTextView;
import com.facebook.widget.text.abtest.ExperimentsForWidgetTextAbTestModule;
import javax.inject.Inject;

@ContextScoped
/* compiled from: group/members/search/<q$1> */
public class SpannableInTextViewPartDefinition<E extends HasPersistentState & HasInvalidate> extends BaseSinglePartDefinition<PersistentSpannableInput, PersistentSpannable, E, BetterTextView> {
    private static SpannableInTextViewPartDefinition f21772d;
    private static final Object f21773e = new Object();
    private final PersistentSpannablePreparer f21774a;
    private final AbstractFbErrorReporter f21775b;
    private final QeAccessor f21776c;

    private static SpannableInTextViewPartDefinition m29505b(InjectorLike injectorLike) {
        return new SpannableInTextViewPartDefinition(PersistentSpannablePreparer.m28258a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        PersistentSpannableInput persistentSpannableInput = (PersistentSpannableInput) obj;
        HasPersistentState hasPersistentState = (HasPersistentState) anyEnvironment;
        if (this.f21776c.mo596a(ExperimentsForWidgetTextAbTestModule.f21795c, false)) {
            this.f21774a.m28262c(persistentSpannableInput, hasPersistentState);
        } else {
            this.f21774a.m28261b(persistentSpannableInput, hasPersistentState);
        }
        return (PersistentSpannable) hasPersistentState.mo2425a(persistentSpannableInput.mo3193a(), persistentSpannableInput.mo3195c());
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 410521217);
        m29504a((PersistentSpannableInput) obj, (PersistentSpannable) obj2, (BetterTextView) view);
        Logger.a(8, EntryType.MARK_POP, -1303852620, a);
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((BetterTextView) view).setAttachDetachListener(null);
    }

    @Inject
    public SpannableInTextViewPartDefinition(PersistentSpannablePreparer persistentSpannablePreparer, AbstractFbErrorReporter abstractFbErrorReporter, QeAccessor qeAccessor) {
        this.f21774a = persistentSpannablePreparer;
        this.f21775b = abstractFbErrorReporter;
        this.f21776c = qeAccessor;
    }

    public static SpannableInTextViewPartDefinition m29503a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SpannableInTextViewPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f21773e) {
                SpannableInTextViewPartDefinition spannableInTextViewPartDefinition;
                if (a2 != null) {
                    spannableInTextViewPartDefinition = (SpannableInTextViewPartDefinition) a2.mo818a(f21773e);
                } else {
                    spannableInTextViewPartDefinition = f21772d;
                }
                if (spannableInTextViewPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m29505b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f21773e, b3);
                        } else {
                            f21772d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = spannableInTextViewPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    private void m29504a(PersistentSpannableInput persistentSpannableInput, PersistentSpannable persistentSpannable, BetterTextView betterTextView) {
        try {
            betterTextView.setMovementMethod(LinkMovementMethod.getInstance());
            betterTextView.setText(persistentSpannable.f21833a);
            if (persistentSpannable.f21835c != null) {
                betterTextView.setAttachDetachListener(persistentSpannable.f21835c);
            }
        } catch (Throwable e) {
            String str;
            Throwable th = e;
            CacheableEntity c = persistentSpannableInput.mo3195c();
            String S_ = (c == null || !(c instanceof GraphQLStory)) ? null : ((GraphQLStory) c).S_();
            AbstractFbErrorReporter abstractFbErrorReporter = this.f21775b;
            StringBuilder stringBuilder = new StringBuilder("SpannableInTextViewPartDefinition");
            if (S_ != null) {
                str = "_withZombie";
            } else {
                str = "";
            }
            abstractFbErrorReporter.mo336a(SoftError.a(stringBuilder.append(str).toString(), StringLocaleUtil.m21640a("JellyBean setText bug with text: %s and zombie: %s", persistentSpannable.f21833a, S_)).a(th).g());
            if (persistentSpannable.f21833a != null) {
                betterTextView.setText(persistentSpannable.f21833a.toString());
            }
        }
    }
}
