package com.facebook.feedplugins.base.footer;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.enums.GraphQLStorySeenState;
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
/* compiled from: is_photo_taken_in_last_n_min */
public class OneButtonFooterStylerPartDefinition extends BaseSinglePartDefinition<Void, State, AnyEnvironment, View> {
    private static OneButtonFooterStylerPartDefinition f18956c;
    private static final Object f18957d = new Object();
    private final Resources f18958a;
    private final DefaultFooterBackgroundStyleResolver f18959b;

    private static OneButtonFooterStylerPartDefinition m26640b(InjectorLike injectorLike) {
        return new OneButtonFooterStylerPartDefinition(ResourcesMethodAutoProvider.m6510a(injectorLike), DefaultFooterBackgroundStyleResolver.m26661a(injectorLike));
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1161317404);
        State state = (State) obj2;
        if (state.b != null) {
            view.setBackgroundDrawable(state.b);
        }
        if (state.a != null) {
            state.a.m26678a(view);
        }
        Logger.a(8, EntryType.MARK_POP, 1978141985, a);
    }

    @Inject
    public OneButtonFooterStylerPartDefinition(Resources resources, DefaultFooterBackgroundStyleResolver defaultFooterBackgroundStyleResolver) {
        this.f18958a = resources;
        this.f18959b = defaultFooterBackgroundStyleResolver;
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FooterBackgroundStyleDefinition a = this.f18959b.m26663a(FooterLevel.TOP);
        return new State(a.f18971c, a.m26679a(this.f18958a, GraphQLStorySeenState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE));
    }

    public static OneButtonFooterStylerPartDefinition m26639a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            OneButtonFooterStylerPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f18957d) {
                OneButtonFooterStylerPartDefinition oneButtonFooterStylerPartDefinition;
                if (a2 != null) {
                    oneButtonFooterStylerPartDefinition = (OneButtonFooterStylerPartDefinition) a2.mo818a(f18957d);
                } else {
                    oneButtonFooterStylerPartDefinition = f18956c;
                }
                if (oneButtonFooterStylerPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m26640b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f18957d, b3);
                        } else {
                            f18956c = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = oneButtonFooterStylerPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
