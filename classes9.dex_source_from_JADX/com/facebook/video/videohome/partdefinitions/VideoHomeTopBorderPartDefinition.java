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
/* compiled from: since_last_import_query */
public class VideoHomeTopBorderPartDefinition extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, AnyEnvironment, View> {
    public static final ViewType<View> f3184a = ViewType.a(2130907709);
    private static VideoHomeTopBorderPartDefinition f3185b;
    private static final Object f3186c = new Object();

    private static VideoHomeTopBorderPartDefinition m3036b() {
        return new VideoHomeTopBorderPartDefinition();
    }

    public final boolean m3038a(Object obj) {
        return ((ReactionUnitComponentNode) obj).b.aG();
    }

    public final ViewType m3037a() {
        return f3184a;
    }

    public static VideoHomeTopBorderPartDefinition m3035a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoHomeTopBorderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f3186c) {
                VideoHomeTopBorderPartDefinition videoHomeTopBorderPartDefinition;
                if (a2 != null) {
                    videoHomeTopBorderPartDefinition = (VideoHomeTopBorderPartDefinition) a2.a(f3186c);
                } else {
                    videoHomeTopBorderPartDefinition = f3185b;
                }
                if (videoHomeTopBorderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        b3 = m3036b();
                        if (a2 != null) {
                            a2.a(f3186c, b3);
                        } else {
                            f3185b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoHomeTopBorderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
