package com.facebook.feedplugins.multishare;

import android.content.Context;
import android.view.View;
import com.facebook.attachments.angora.actionbutton.GenericActionButtonView;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.text.GlyphWithTextView;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.rows.core.props.AttachmentProps;
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
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: network_timeout_ms_for_blocking_requests */
public class BusinessActionButtonPartDefinition<E extends HasInvalidate> extends BaseSinglePartDefinition<Props, Void, E, GenericActionButtonView> {
    private static BusinessActionButtonPartDefinition f7201c;
    private static final Object f7202d = new Object();
    private final BusinessLocationActionLinkClickListenerProvider f7203a;
    private final ClickListenerPartDefinition f7204b;

    private static BusinessActionButtonPartDefinition m7521b(InjectorLike injectorLike) {
        return new BusinessActionButtonPartDefinition((BusinessLocationActionLinkClickListenerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(BusinessLocationActionLinkClickListenerProvider.class), ClickListenerPartDefinition.a(injectorLike));
    }

    public final Object m7522a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        subParts.a(2131562505, this.f7204b, this.f7203a.m7519a(AttachmentProps.e(props.c), props.b.aE(), props.d));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m7523a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1116787270);
        Props props = (Props) obj;
        GenericActionButtonView genericActionButtonView = (GenericActionButtonView) view;
        genericActionButtonView.setVisibility(0);
        genericActionButtonView.setButtonBackgroundResource(2130840230);
        GlyphWithTextView glyphWithTextView = genericActionButtonView.f13757a;
        glyphWithTextView.setCompoundDrawablePadding(0);
        glyphWithTextView.setImageResource(props.a);
        glyphWithTextView.setGlyphColor(-11643291);
        Logger.a(8, EntryType.MARK_POP, -2140820066, a);
    }

    public final void m7524b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((GenericActionButtonView) view).setVisibility(8);
    }

    @Inject
    public BusinessActionButtonPartDefinition(BusinessLocationActionLinkClickListenerProvider businessLocationActionLinkClickListenerProvider, ClickListenerPartDefinition clickListenerPartDefinition) {
        this.f7203a = businessLocationActionLinkClickListenerProvider;
        this.f7204b = clickListenerPartDefinition;
    }

    public static BusinessActionButtonPartDefinition m7520a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BusinessActionButtonPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7202d) {
                BusinessActionButtonPartDefinition businessActionButtonPartDefinition;
                if (a2 != null) {
                    businessActionButtonPartDefinition = (BusinessActionButtonPartDefinition) a2.a(f7202d);
                } else {
                    businessActionButtonPartDefinition = f7201c;
                }
                if (businessActionButtonPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7521b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7202d, b3);
                        } else {
                            f7201c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = businessActionButtonPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
