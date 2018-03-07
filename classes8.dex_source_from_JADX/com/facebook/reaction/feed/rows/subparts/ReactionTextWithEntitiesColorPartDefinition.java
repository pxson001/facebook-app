package com.facebook.reaction.feed.rows.subparts;

import android.content.Context;
import android.view.View;
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
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView;
import javax.annotation.Nullable;

@ContextScoped
/* compiled from: angle */
public class ReactionTextWithEntitiesColorPartDefinition extends BaseSinglePartDefinition<Integer, Void, CanLaunchReactionIntent, TextWithEntitiesView> {
    private static ReactionTextWithEntitiesColorPartDefinition f19434a;
    private static final Object f19435b = new Object();

    private static ReactionTextWithEntitiesColorPartDefinition m23419a() {
        return new ReactionTextWithEntitiesColorPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m23421a(@Nullable Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -648938544);
        Integer num = (Integer) obj;
        TextWithEntitiesView textWithEntitiesView = (TextWithEntitiesView) view;
        if (num != null) {
            textWithEntitiesView.setTextColor(num.intValue());
        }
        Logger.a(8, EntryType.MARK_POP, 1080703538, a);
    }

    public static ReactionTextWithEntitiesColorPartDefinition m23420a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionTextWithEntitiesColorPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f19435b) {
                ReactionTextWithEntitiesColorPartDefinition reactionTextWithEntitiesColorPartDefinition;
                if (a3 != null) {
                    reactionTextWithEntitiesColorPartDefinition = (ReactionTextWithEntitiesColorPartDefinition) a3.a(f19435b);
                } else {
                    reactionTextWithEntitiesColorPartDefinition = f19434a;
                }
                if (reactionTextWithEntitiesColorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m23419a();
                        if (a3 != null) {
                            a3.a(f19435b, a2);
                        } else {
                            f19434a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = reactionTextWithEntitiesColorPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
