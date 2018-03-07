package com.facebook.richdocument.view.performance;

import android.content.Context;
import com.facebook.common.executors.IncrementalRunnable;
import com.facebook.common.idleexecutor.DefaultProcessIdleExecutor;
import com.facebook.common.idleexecutor.IdleExecutor_ForUiThreadMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.event.FbEvent;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.richdocument.event.RichDocumentEventBus;
import com.facebook.richdocument.event.RichDocumentEventSubscribers.RichDocumentStartupUiTasksCompletedSubscriber;
import com.facebook.richdocument.event.StartupStateMachine;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

@ContextScoped
/* compiled from: page_call_to_action_isadmin_extra */
public class IncrementalUiIdleJobManager {
    private static IncrementalUiIdleJobManager f6906i;
    private static final Object f6907j = new Object();
    public final Queue<IncrementalUiIdleJob> f6908a = new LinkedList();
    private final StartupStateMachine f6909b;
    public final RichDocumentEventBus f6910c;
    private final ExecutorService f6911d;
    private final RichDocumentStartupUiTasksCompletedSubscriber f6912e = new C07871(this);
    public IncrementalUiIdleJob f6913f;
    public UiIdleIncrementalRunnable f6914g;
    public boolean f6915h = false;

    /* compiled from: page_call_to_action_isadmin_extra */
    class C07871 extends RichDocumentStartupUiTasksCompletedSubscriber {
        final /* synthetic */ IncrementalUiIdleJobManager f6904a;

        C07871(IncrementalUiIdleJobManager incrementalUiIdleJobManager) {
            this.f6904a = incrementalUiIdleJobManager;
        }

        public final void m7148b(FbEvent fbEvent) {
            this.f6904a.f6910c.b(this);
            this.f6904a.f6915h = true;
            IncrementalUiIdleJobManager.m7153b(this.f6904a);
        }
    }

    /* compiled from: page_call_to_action_isadmin_extra */
    class UiIdleIncrementalRunnable extends IncrementalRunnable {
        private final IncrementalUiIdleJobManager f6905a;

        public UiIdleIncrementalRunnable(IncrementalUiIdleJobManager incrementalUiIdleJobManager, ExecutorService executorService) {
            super(executorService);
            this.f6905a = incrementalUiIdleJobManager;
        }

        public final void m7149b() {
            IncrementalUiIdleJobManager.m7153b(this.f6905a);
        }

        public final boolean m7150c() {
            IncrementalUiIdleJobManager incrementalUiIdleJobManager = this.f6905a;
            boolean z = (incrementalUiIdleJobManager.f6913f != null && incrementalUiIdleJobManager.f6913f.mo409i()) || !incrementalUiIdleJobManager.f6908a.isEmpty();
            if (!z) {
                incrementalUiIdleJobManager.f6913f = null;
                incrementalUiIdleJobManager.f6914g = null;
            }
            return z;
        }
    }

    private static IncrementalUiIdleJobManager m7152b(InjectorLike injectorLike) {
        return new IncrementalUiIdleJobManager(StartupStateMachine.m5147a(injectorLike), RichDocumentEventBus.m5130a(injectorLike), IdleExecutor_ForUiThreadMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public IncrementalUiIdleJobManager(StartupStateMachine startupStateMachine, RichDocumentEventBus richDocumentEventBus, DefaultProcessIdleExecutor defaultProcessIdleExecutor) {
        this.f6909b = startupStateMachine;
        this.f6910c = richDocumentEventBus;
        this.f6911d = defaultProcessIdleExecutor;
        if (this.f6909b.m5152b()) {
            this.f6915h = true;
        } else {
            this.f6910c.a(this.f6912e);
        }
    }

    public final synchronized void m7155a(IncrementalUiIdleJob incrementalUiIdleJob) {
        if (incrementalUiIdleJob != null) {
            this.f6908a.add(incrementalUiIdleJob);
            if (this.f6913f == null && this.f6915h) {
                m7153b(this);
            }
        }
    }

    public static IncrementalUiIdleJobManager m7151a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            IncrementalUiIdleJobManager b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6907j) {
                IncrementalUiIdleJobManager incrementalUiIdleJobManager;
                if (a2 != null) {
                    incrementalUiIdleJobManager = (IncrementalUiIdleJobManager) a2.a(f6907j);
                } else {
                    incrementalUiIdleJobManager = f6906i;
                }
                if (incrementalUiIdleJobManager == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7152b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6907j, b3);
                        } else {
                            f6906i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = incrementalUiIdleJobManager;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public static synchronized void m7153b(IncrementalUiIdleJobManager incrementalUiIdleJobManager) {
        synchronized (incrementalUiIdleJobManager) {
            incrementalUiIdleJobManager.f6913f = incrementalUiIdleJobManager.m7154c();
            if (incrementalUiIdleJobManager.f6913f != null) {
                if (incrementalUiIdleJobManager.f6914g != null) {
                    incrementalUiIdleJobManager.f6913f.mo410j();
                } else {
                    incrementalUiIdleJobManager.f6914g = new UiIdleIncrementalRunnable(incrementalUiIdleJobManager, incrementalUiIdleJobManager.f6911d);
                    ExecutorDetour.a(incrementalUiIdleJobManager.f6911d, incrementalUiIdleJobManager.f6914g, 1151398296);
                }
            }
        }
    }

    private IncrementalUiIdleJob m7154c() {
        if (this.f6913f != null && this.f6913f.mo409i()) {
            return this.f6913f;
        }
        IncrementalUiIdleJob incrementalUiIdleJob;
        do {
            incrementalUiIdleJob = (IncrementalUiIdleJob) this.f6908a.poll();
            if (incrementalUiIdleJob == null) {
                return incrementalUiIdleJob;
            }
        } while (!incrementalUiIdleJob.mo409i());
        return incrementalUiIdleJob;
    }
}
