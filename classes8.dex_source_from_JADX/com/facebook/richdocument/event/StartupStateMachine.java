package com.facebook.richdocument.event;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.event.FbEvent;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.richdocument.event.RichDocumentEventSubscribers.RichDocumentFirstRenderSubscriber;
import com.facebook.richdocument.event.RichDocumentEventSubscribers.RichDocumentIncomingAnimationCompleteSubscriber;
import com.facebook.richdocument.event.RichDocumentEvents.StartupUiTasksCompleted;
import javax.inject.Inject;

@ContextScoped
/* compiled from: previously_selected_location */
public class StartupStateMachine {
    private static StartupStateMachine f5190f;
    private static final Object f5191g = new Object();
    public final RichDocumentEventBus f5192a;
    public final RichDocumentFirstRenderSubscriber f5193b = new C06851(this);
    public final RichDocumentIncomingAnimationCompleteSubscriber f5194c = new C06862(this);
    private boolean f5195d = false;
    private boolean f5196e = false;

    /* compiled from: previously_selected_location */
    class C06851 extends RichDocumentFirstRenderSubscriber {
        final /* synthetic */ StartupStateMachine f5188a;

        C06851(StartupStateMachine startupStateMachine) {
            this.f5188a = startupStateMachine;
        }

        public final void m5145b(FbEvent fbEvent) {
            StartupStateMachine.m5149c(this.f5188a);
            this.f5188a.f5192a.b(this);
        }
    }

    /* compiled from: previously_selected_location */
    class C06862 extends RichDocumentIncomingAnimationCompleteSubscriber {
        final /* synthetic */ StartupStateMachine f5189a;

        C06862(StartupStateMachine startupStateMachine) {
            this.f5189a = startupStateMachine;
        }

        public final void m5146b(FbEvent fbEvent) {
            StartupStateMachine.m5150d(this.f5189a);
            this.f5189a.f5192a.b(this);
        }
    }

    private static StartupStateMachine m5148b(InjectorLike injectorLike) {
        return new StartupStateMachine(RichDocumentEventBus.m5130a(injectorLike));
    }

    @Inject
    public StartupStateMachine(RichDocumentEventBus richDocumentEventBus) {
        this.f5192a = richDocumentEventBus;
    }

    public static void m5149c(StartupStateMachine startupStateMachine) {
        startupStateMachine.f5195d = true;
        startupStateMachine.m5151e();
    }

    public static void m5150d(StartupStateMachine startupStateMachine) {
        startupStateMachine.f5196e = true;
        startupStateMachine.m5151e();
    }

    private void m5151e() {
        if (this.f5196e && this.f5195d) {
            this.f5192a.a(new StartupUiTasksCompleted());
        }
    }

    public static StartupStateMachine m5147a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StartupStateMachine b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5191g) {
                StartupStateMachine startupStateMachine;
                if (a2 != null) {
                    startupStateMachine = (StartupStateMachine) a2.a(f5191g);
                } else {
                    startupStateMachine = f5190f;
                }
                if (startupStateMachine == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5148b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5191g, b3);
                        } else {
                            f5190f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = startupStateMachine;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m5152b() {
        return this.f5196e && this.f5195d;
    }
}
