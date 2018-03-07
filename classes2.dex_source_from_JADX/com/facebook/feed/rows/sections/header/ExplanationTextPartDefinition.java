package com.facebook.feed.rows.sections.header;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.views.ContentTextView;
import com.facebook.feedplugins.graphqlstory.explanation.ExplanationSpannableBuilder;
import com.facebook.feedplugins.spannable.SpannableInTextViewPartDefinition;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: friend_reject */
public class ExplanationTextPartDefinition<E extends HasPersistentState & HasInvalidate> extends BaseSinglePartDefinition<Props, Boolean, E, ContentTextView> {
    private static ExplanationTextPartDefinition f23173d;
    private static final Object f23174e = new Object();
    private final ExplanationSpannableBuilder f23175a;
    private final SpannableInTextViewPartDefinition<E> f23176b;
    private final HeaderTextStylePartDefinition f23177c;

    private static ExplanationTextPartDefinition m31285b(InjectorLike injectorLike) {
        return new ExplanationTextPartDefinition(ExplanationSpannableBuilder.m31267a(injectorLike), SpannableInTextViewPartDefinition.m29503a(injectorLike), HeaderTextStylePartDefinition.m31288a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        subParts.mo2756a(this.f23176b, new ExplanationTextSpannableInput(props.a, this.f23175a));
        subParts.mo2756a(this.f23177c, props.b);
        return Boolean.valueOf(StoryProps.m27466p(props.a));
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 2115739769);
        ((ContentTextView) view).setTag(2131558541, (Boolean) obj2);
        Logger.a(8, EntryType.MARK_POP, -1680036074, a);
    }

    @Inject
    public ExplanationTextPartDefinition(ExplanationSpannableBuilder explanationSpannableBuilder, SpannableInTextViewPartDefinition spannableInTextViewPartDefinition, HeaderTextStylePartDefinition headerTextStylePartDefinition) {
        this.f23175a = explanationSpannableBuilder;
        this.f23176b = spannableInTextViewPartDefinition;
        this.f23177c = headerTextStylePartDefinition;
    }

    public static ExplanationTextPartDefinition m31284a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ExplanationTextPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f23174e) {
                ExplanationTextPartDefinition explanationTextPartDefinition;
                if (a2 != null) {
                    explanationTextPartDefinition = (ExplanationTextPartDefinition) a2.mo818a(f23174e);
                } else {
                    explanationTextPartDefinition = f23173d;
                }
                if (explanationTextPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m31285b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f23174e, b3);
                        } else {
                            f23173d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = explanationTextPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
