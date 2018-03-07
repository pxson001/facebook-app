package com.facebook.reaction.feed.unitcomponents.subpart;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeView;
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
import javax.annotation.Nullable;

@ContextScoped
/* compiled from: [[change_contactpoint]] */
public class ReactionDrawableIconPartDefinition extends BaseSinglePartDefinition<Props, Void, AnyEnvironment, FbDraweeView> {
    private static ReactionDrawableIconPartDefinition f20573a;
    private static final Object f20574b = new Object();

    /* compiled from: [[change_contactpoint]] */
    public class Props {
        @Nullable
        public final Drawable f20572a;

        public Props(@Nullable Drawable drawable) {
            this.f20572a = drawable;
        }
    }

    private static ReactionDrawableIconPartDefinition m24305a() {
        return new ReactionDrawableIconPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m24307a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -462406541);
        Props props = (Props) obj;
        FbDraweeView fbDraweeView = (FbDraweeView) view;
        if (props.f20572a == null) {
            fbDraweeView.setVisibility(8);
        } else {
            fbDraweeView.setVisibility(0);
            fbDraweeView.setImageDrawable(props.f20572a);
        }
        Logger.a(8, EntryType.MARK_POP, 1835908394, a);
    }

    public static ReactionDrawableIconPartDefinition m24306a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionDrawableIconPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f20574b) {
                ReactionDrawableIconPartDefinition reactionDrawableIconPartDefinition;
                if (a3 != null) {
                    reactionDrawableIconPartDefinition = (ReactionDrawableIconPartDefinition) a3.a(f20574b);
                } else {
                    reactionDrawableIconPartDefinition = f20573a;
                }
                if (reactionDrawableIconPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m24305a();
                        if (a3 != null) {
                            a3.a(f20574b, a2);
                        } else {
                            f20573a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = reactionDrawableIconPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
