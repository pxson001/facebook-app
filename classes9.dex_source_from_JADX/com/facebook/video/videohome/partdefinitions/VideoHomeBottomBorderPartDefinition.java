package com.facebook.video.videohome.partdefinitions;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.ViewType;
import com.facebook.reaction.common.ReactionUnitComponentNode;

@ContextScoped
/* compiled from: sms_tid */
public class VideoHomeBottomBorderPartDefinition extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, AnyEnvironment, View> {
    private static VideoHomeBottomBorderPartDefinition f3032a;
    private static final Object f3033b = new Object();

    private static VideoHomeBottomBorderPartDefinition m2907b() {
        return new VideoHomeBottomBorderPartDefinition();
    }

    public final boolean m2909a(Object obj) {
        return ((ReactionUnitComponentNode) obj).b.aD();
    }

    public final ViewType m2908a() {
        return VideoHomeTopBorderPartDefinition.f3184a;
    }

    public static VideoHomeBottomBorderPartDefinition m2906a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoHomeBottomBorderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f3033b) {
                VideoHomeBottomBorderPartDefinition videoHomeBottomBorderPartDefinition;
                if (a2 != null) {
                    videoHomeBottomBorderPartDefinition = (VideoHomeBottomBorderPartDefinition) a2.a(f3033b);
                } else {
                    videoHomeBottomBorderPartDefinition = f3032a;
                }
                if (videoHomeBottomBorderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        b3 = m2907b();
                        if (a2 != null) {
                            a2.a(f3033b, b3);
                        } else {
                            f3032a = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoHomeBottomBorderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
