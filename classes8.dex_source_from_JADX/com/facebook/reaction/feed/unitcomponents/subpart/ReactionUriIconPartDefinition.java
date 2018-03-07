package com.facebook.reaction.feed.unitcomponents.subpart;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
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
/* compiled from: ZZI */
public class ReactionUriIconPartDefinition extends BaseSinglePartDefinition<String, Void, AnyEnvironment, FbDraweeView> {
    public static final CallerContext f20692a = CallerContext.a(ReactionUriIconPartDefinition.class, "reaction_dialog");
    private static ReactionUriIconPartDefinition f20693b;
    private static final Object f20694c = new Object();

    private static ReactionUriIconPartDefinition m24359a() {
        return new ReactionUriIconPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m24361a(@Nullable Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -423491973);
        String str = (String) obj;
        FbDraweeView fbDraweeView = (FbDraweeView) view;
        if (str != null) {
            fbDraweeView.setVisibility(0);
            fbDraweeView.a(Uri.parse(str), f20692a);
        } else {
            fbDraweeView.setVisibility(8);
        }
        Logger.a(8, EntryType.MARK_POP, 927503548, a);
    }

    public static ReactionUriIconPartDefinition m24360a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionUriIconPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f20694c) {
                ReactionUriIconPartDefinition reactionUriIconPartDefinition;
                if (a3 != null) {
                    reactionUriIconPartDefinition = (ReactionUriIconPartDefinition) a3.a(f20694c);
                } else {
                    reactionUriIconPartDefinition = f20693b;
                }
                if (reactionUriIconPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m24359a();
                        if (a3 != null) {
                            a3.a(f20694c, a2);
                        } else {
                            f20693b = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = reactionUriIconPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
