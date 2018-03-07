package com.facebook.feedplugins.spannable;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.text.TextLayoutView;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
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
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

@ContextScoped
/* compiled from: group/{%s}/permalink/{%s}/comment/{%s} */
public class SpannablePartDefinition<E extends HasPersistentState & HasInvalidate> extends BaseSinglePartDefinition<PersistentSpannableInput, Boolean, E, View> {
    private static SpannablePartDefinition f21768c;
    private static final Object f21769d = new Object();
    private final SpannableInTextLayoutPartDefinition<E> f21770a;
    private final SpannableInTextViewPartDefinition<E> f21771b;

    private static SpannablePartDefinition m29500b(InjectorLike injectorLike) {
        return new SpannablePartDefinition(SpannableInTextLayoutPartDefinition.m28627a(injectorLike), SpannableInTextViewPartDefinition.m29503a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        PersistentSpannableInput persistentSpannableInput = (PersistentSpannableInput) obj;
        boolean z = persistentSpannableInput.mo3196d() != null;
        if (z) {
            subParts.mo2756a(this.f21770a, persistentSpannableInput);
        } else {
            subParts.mo2756a(this.f21771b, persistentSpannableInput);
        }
        return Boolean.valueOf(z);
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -617275465);
        if (((Boolean) obj2).booleanValue()) {
            Preconditions.checkState(view instanceof TextLayoutView);
        } else {
            Preconditions.checkState(view instanceof BetterTextView);
        }
        Logger.a(8, EntryType.MARK_POP, -87739545, a);
    }

    @Inject
    public SpannablePartDefinition(SpannableInTextLayoutPartDefinition spannableInTextLayoutPartDefinition, SpannableInTextViewPartDefinition spannableInTextViewPartDefinition) {
        this.f21770a = spannableInTextLayoutPartDefinition;
        this.f21771b = spannableInTextViewPartDefinition;
    }

    public static SpannablePartDefinition m29499a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SpannablePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f21769d) {
                SpannablePartDefinition spannablePartDefinition;
                if (a2 != null) {
                    spannablePartDefinition = (SpannablePartDefinition) a2.mo818a(f21769d);
                } else {
                    spannablePartDefinition = f21768c;
                }
                if (spannablePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m29500b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f21769d, b3);
                        } else {
                            f21768c = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = spannablePartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
