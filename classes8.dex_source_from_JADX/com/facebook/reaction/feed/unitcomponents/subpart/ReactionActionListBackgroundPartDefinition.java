package com.facebook.reaction.feed.unitcomponents.subpart;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.enums.GraphQLReactionUnitComponentStyle;
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
/* compiled from: [trending] */
public class ReactionActionListBackgroundPartDefinition extends BaseSinglePartDefinition<GraphQLReactionUnitComponentStyle, Void, AnyEnvironment, View> {
    private static ReactionActionListBackgroundPartDefinition f20506a;
    private static final Object f20507b = new Object();

    /* compiled from: [trending] */
    public /* synthetic */ class C21741 {
        public static final /* synthetic */ int[] f20505a = new int[GraphQLReactionUnitComponentStyle.values().length];

        static {
            try {
                f20505a[GraphQLReactionUnitComponentStyle.HORIZONTAL_ACTION_LIST.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f20505a[GraphQLReactionUnitComponentStyle.HORIZONTAL_ACTION_LIST_FOOTER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    private static ReactionActionListBackgroundPartDefinition m24266a() {
        return new ReactionActionListBackgroundPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m24268a(@Nullable Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 990247446);
        GraphQLReactionUnitComponentStyle graphQLReactionUnitComponentStyle = (GraphQLReactionUnitComponentStyle) obj;
        if (graphQLReactionUnitComponentStyle != null) {
            int i;
            switch (C21741.f20505a[graphQLReactionUnitComponentStyle.ordinal()]) {
                case 1:
                    i = 2130842884;
                    break;
                default:
                    i = 2130842902;
                    break;
            }
            view.setBackgroundResource(i);
        }
        Logger.a(8, EntryType.MARK_POP, 623299021, a);
    }

    public static ReactionActionListBackgroundPartDefinition m24267a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionActionListBackgroundPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f20507b) {
                ReactionActionListBackgroundPartDefinition reactionActionListBackgroundPartDefinition;
                if (a3 != null) {
                    reactionActionListBackgroundPartDefinition = (ReactionActionListBackgroundPartDefinition) a3.a(f20507b);
                } else {
                    reactionActionListBackgroundPartDefinition = f20506a;
                }
                if (reactionActionListBackgroundPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m24266a();
                        if (a3 != null) {
                            a3.a(f20507b, a2);
                        } else {
                            f20506a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = reactionActionListBackgroundPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
