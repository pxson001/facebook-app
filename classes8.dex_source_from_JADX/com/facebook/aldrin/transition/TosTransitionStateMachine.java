package com.facebook.aldrin.transition;

import android.content.Context;
import com.facebook.aldrin.status.AldrinUserStatusManager;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.enums.GraphQLTosTransitionTypeEnum;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.statemachine.StateMachine;
import com.facebook.statemachine.StateMachine.1;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.util.Map;

@ContextScoped
/* compiled from: last_article_info */
public class TosTransitionStateMachine {
    private static TosTransitionStateMachine f10398c;
    private static final Object f10399d = new Object();
    @VisibleForTesting
    public final StateMachine<TosTransitionState, TosTransitionStateEvent> f10400a;
    public final AldrinUserStatusManager f10401b;

    /* compiled from: last_article_info */
    public /* synthetic */ class C11131 {
        public static final /* synthetic */ int[] f10397a = new int[GraphQLTosTransitionTypeEnum.values().length];

        static {
            try {
                f10397a[GraphQLTosTransitionTypeEnum.EXPLICIT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f10397a[GraphQLTosTransitionTypeEnum.EXPLICIT_FROM_BLOCKING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    private static TosTransitionStateMachine m12201b(InjectorLike injectorLike) {
        return new TosTransitionStateMachine(AldrinUserStatusManager.a(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @javax.inject.Inject
    public TosTransitionStateMachine(com.facebook.aldrin.status.AldrinUserStatusManager r8) {
        /*
        r7 = this;
        r7.<init>();
        r7.f10401b = r8;
        r0 = new com.facebook.statemachine.StateMachine;
        r4 = r7.f10401b;
        r4 = r4.d();
        com.google.common.base.Preconditions.checkNotNull(r4);
        r5 = com.facebook.aldrin.transition.TosTransitionStateMachine.C11131.f10397a;
        r6 = r4.tosTransitionType;
        r6 = r6.ordinal();
        r5 = r5[r6];
        switch(r5) {
            case 1: goto L_0x0052;
            case 2: goto L_0x0070;
            default: goto L_0x001d;
        };
    L_0x001d:
        r4 = com.facebook.aldrin.transition.TosTransitionState.VIEW_ALDRIN_TOS;
    L_0x001f:
        r1 = r4;
        r0.<init>(r1);
        r7.f10400a = r0;
        r0 = r7.f10400a;
        r1 = com.facebook.aldrin.transition.TosTransitionStateEvent.AGREED_TO_ALDRIN_TOS;
        r2 = com.facebook.aldrin.transition.TosTransitionState.VIEW_ALDRIN_TOS;
        r3 = com.facebook.aldrin.transition.TosTransitionState.AGREED_TO_ALDRIN_TOS;
        r0.a(r1, r2, r3);
        r0 = r7.f10400a;
        r1 = com.facebook.aldrin.transition.TosTransitionStateEvent.DENIED_ALDRIN_TOS;
        r2 = com.facebook.aldrin.transition.TosTransitionState.VIEW_ALDRIN_TOS;
        r3 = com.facebook.aldrin.transition.TosTransitionState.VIEW_BLOCK_INTERSTITIAL;
        r0.a(r1, r2, r3);
        r0 = r7.f10400a;
        r1 = com.facebook.aldrin.transition.TosTransitionStateEvent.GO_BACK;
        r2 = com.facebook.aldrin.transition.TosTransitionState.VIEW_BLOCK_INTERSTITIAL;
        r3 = com.facebook.aldrin.transition.TosTransitionState.VIEW_ALDRIN_TOS;
        r0.a(r1, r2, r3);
        r0 = r7.f10400a;
        r1 = com.facebook.aldrin.transition.TosTransitionStateEvent.AGREED_TO_GENERAL_TOS;
        r2 = com.facebook.aldrin.transition.TosTransitionState.VIEW_GENERAL_TOS;
        r3 = com.facebook.aldrin.transition.TosTransitionState.AGREED_TO_GENERAL_TOS;
        r0.a(r1, r2, r3);
        return;
    L_0x0052:
        r5 = r4.effectiveRegion;
        r6 = com.facebook.graphql.enums.GraphQLTosRegionCodeEnum.GENERAL;
        if (r5 != r6) goto L_0x0061;
    L_0x0058:
        r5 = r4.currentRegion;
        r6 = com.facebook.graphql.enums.GraphQLTosRegionCodeEnum.ALDRIN;
        if (r5 != r6) goto L_0x0061;
    L_0x005e:
        r4 = com.facebook.aldrin.transition.TosTransitionState.VIEW_ALDRIN_TOS;
        goto L_0x001f;
    L_0x0061:
        r5 = r4.effectiveRegion;
        r6 = com.facebook.graphql.enums.GraphQLTosRegionCodeEnum.ALDRIN;
        if (r5 != r6) goto L_0x001d;
    L_0x0067:
        r4 = r4.currentRegion;
        r5 = com.facebook.graphql.enums.GraphQLTosRegionCodeEnum.GENERAL;
        if (r4 != r5) goto L_0x001d;
    L_0x006d:
        r4 = com.facebook.aldrin.transition.TosTransitionState.VIEW_GENERAL_TOS;
        goto L_0x001f;
    L_0x0070:
        r4 = com.facebook.aldrin.transition.TosTransitionState.VIEW_BLOCK_INTERSTITIAL;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.aldrin.transition.TosTransitionStateMachine.<init>(com.facebook.aldrin.status.AldrinUserStatusManager):void");
    }

    public static TosTransitionStateMachine m12200a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TosTransitionStateMachine b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10399d) {
                TosTransitionStateMachine tosTransitionStateMachine;
                if (a2 != null) {
                    tosTransitionStateMachine = (TosTransitionStateMachine) a2.a(f10399d);
                } else {
                    tosTransitionStateMachine = f10398c;
                }
                if (tosTransitionStateMachine == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12201b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f10399d, b3);
                        } else {
                            f10398c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = tosTransitionStateMachine;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m12202a(TosTransitionStateEvent tosTransitionStateEvent) {
        StateMachine stateMachine = this.f10400a;
        Preconditions.checkNotNull(tosTransitionStateEvent);
        Map map = (Map) stateMachine.a.get(stateMachine.c);
        if (map != null && map.containsKey(tosTransitionStateEvent)) {
            Object obj = ((1) map.get(tosTransitionStateEvent)).a;
            stateMachine.d = stateMachine.c;
            stateMachine.c = obj;
            if (stateMachine.e != null) {
                stateMachine.e.mo680a(tosTransitionStateEvent, stateMachine.d, stateMachine.c);
            }
        }
    }
}
