package com.facebook.reaction.feed.rows;

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
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.ViewType;
import com.facebook.reaction.common.ReactionCardNode;
import com.facebook.reaction.feed.environment.HasReactionCardContainer;
import com.facebook.reaction.ui.card.ReactionUnitStackView;

@ContextScoped
/* compiled from: are_media_items_modified */
public class ReactionUnitStackPartDefinition extends MultiRowSinglePartDefinition<ReactionCardNode, Void, HasReactionCardContainer, ReactionUnitStackView> {
    public static final ViewType f19317a = new C21041();
    private static ReactionUnitStackPartDefinition f19318b;
    private static final Object f19319c = new Object();

    /* compiled from: are_media_items_modified */
    final class C21041 extends ViewType {
        C21041() {
        }

        public final View m23317a(Context context) {
            return new ReactionUnitStackView(context);
        }
    }

    private static ReactionUnitStackPartDefinition m23319c() {
        return new ReactionUnitStackPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m23321a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -309997618);
        ReactionCardNode reactionCardNode = (ReactionCardNode) obj;
        ReactionUnitStackView reactionUnitStackView = (ReactionUnitStackView) view;
        reactionUnitStackView.f21077b = ((HasReactionCardContainer) anyEnvironment).mo705q();
        reactionUnitStackView.f21078c = reactionCardNode.mo1117k();
        reactionUnitStackView.f21080f = reactionCardNode.f18839b;
        reactionUnitStackView.f21079e = reactionUnitStackView.f21078c.r().a();
        reactionUnitStackView.a();
        Logger.a(8, EntryType.MARK_POP, 852268575, a);
    }

    public final ViewType<ReactionUnitStackView> m23320a() {
        return f19317a;
    }

    public final boolean m23322a(Object obj) {
        return true;
    }

    public static ReactionUnitStackPartDefinition m23318a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionUnitStackPartDefinition c;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19319c) {
                ReactionUnitStackPartDefinition reactionUnitStackPartDefinition;
                if (a2 != null) {
                    reactionUnitStackPartDefinition = (ReactionUnitStackPartDefinition) a2.a(f19319c);
                } else {
                    reactionUnitStackPartDefinition = f19318b;
                }
                if (reactionUnitStackPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        c = m23319c();
                        if (a2 != null) {
                            a2.a(f19319c, c);
                        } else {
                            f19318b = c;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    c = reactionUnitStackPartDefinition;
                }
            }
            return c;
        } finally {
            a.c(b);
        }
    }
}
