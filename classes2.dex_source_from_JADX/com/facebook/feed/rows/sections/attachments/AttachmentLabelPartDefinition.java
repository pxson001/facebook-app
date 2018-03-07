package com.facebook.feed.rows.sections.attachments;

import android.content.Context;
import android.view.View;
import com.facebook.attachments.angora.AttachmentHasLabel;
import com.facebook.common.propertybag.PropertyBag;
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

@ContextScoped
/* compiled from: fetch_reshare_counts */
public class AttachmentLabelPartDefinition<V extends View & AttachmentHasLabel> extends BaseSinglePartDefinition<Props, Void, AnyEnvironment, V> {
    private static AttachmentLabelPartDefinition f23940a;
    private static final Object f23941b = new Object();

    private static AttachmentLabelPartDefinition m32322a() {
        return new AttachmentLabelPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1998818231);
        m32324a((Props) obj, view);
        Logger.a(8, EntryType.MARK_POP, -920236347, a);
    }

    private static void m32324a(Props props, V v) {
        ((AttachmentHasLabel) v).setTitle(props.a);
        ((AttachmentHasLabel) v).setContextText(props.b);
    }

    public static AttachmentLabelPartDefinition m32323a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AttachmentLabelPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.m1330a(b2);
            synchronized (f23941b) {
                AttachmentLabelPartDefinition attachmentLabelPartDefinition;
                if (a3 != null) {
                    attachmentLabelPartDefinition = (AttachmentLabelPartDefinition) a3.mo818a(f23941b);
                } else {
                    attachmentLabelPartDefinition = f23940a;
                }
                if (attachmentLabelPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.m1474e();
                        a2 = m32322a();
                        if (a3 != null) {
                            a3.mo822a(f23941b, a2);
                        } else {
                            f23940a = a2;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    a2 = attachmentLabelPartDefinition;
                }
            }
            return a2;
        } finally {
            a.m1505c(b);
        }
    }
}
