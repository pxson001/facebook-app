package com.facebook.reaction.feed.common;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.facepile.Face;
import com.facebook.fbui.facepile.FacepileView;
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
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLInterfaces.ReactionFacepileProfile;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

@ContextScoped
/* compiled from: bellerophon_logger_data */
public class ReactionFacepilePartDefinition extends BaseSinglePartDefinition<ImmutableList<Face>, Void, AnyEnvironment, FacepileView> {
    private static ReactionFacepilePartDefinition f18974a;
    private static final Object f18975b = new Object();

    private static ReactionFacepilePartDefinition m23001a() {
        return new ReactionFacepilePartDefinition();
    }

    public final Object m23004a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return (Void) super.a(subParts, (ImmutableList) obj, anyEnvironment);
    }

    public final /* bridge */ /* synthetic */ void m23005a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1843007305);
        ((FacepileView) view).setFaces((ImmutableList) obj);
        Logger.a(8, EntryType.MARK_POP, -926087989, a);
    }

    public static ImmutableList<Face> m23003a(int i, ImmutableList<? extends ReactionFacepileProfile> immutableList) {
        Builder builder = new Builder();
        int min = Math.min(i, immutableList.size());
        for (int i2 = 0; i2 < min; i2++) {
            builder.c(new Face(Uri.parse(((ReactionFacepileProfile) immutableList.get(i2)).d().b())));
        }
        return builder.b();
    }

    public static ReactionFacepilePartDefinition m23002a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionFacepilePartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f18975b) {
                ReactionFacepilePartDefinition reactionFacepilePartDefinition;
                if (a3 != null) {
                    reactionFacepilePartDefinition = (ReactionFacepilePartDefinition) a3.a(f18975b);
                } else {
                    reactionFacepilePartDefinition = f18974a;
                }
                if (reactionFacepilePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m23001a();
                        if (a3 != null) {
                            a3.a(f18975b, a2);
                        } else {
                            f18974a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = reactionFacepilePartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
