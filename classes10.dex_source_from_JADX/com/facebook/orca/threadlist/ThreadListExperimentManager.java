package com.facebook.orca.threadlist;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: native_imp */
public class ThreadListExperimentManager {
    private static ThreadListExperimentManager f6594c;
    private static final Object f6595d = new Object();
    public GatekeeperStoreImpl f6596a;
    public boolean f6597b;

    private static ThreadListExperimentManager m6284b(InjectorLike injectorLike) {
        return new ThreadListExperimentManager(GatekeeperStoreImplMethodAutoProvider.a(injectorLike), Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(242, false)));
    }

    @Inject
    ThreadListExperimentManager(GatekeeperStoreImpl gatekeeperStoreImpl, Boolean bool) {
        this.f6596a = gatekeeperStoreImpl;
        this.f6597b = bool.booleanValue();
    }

    public final boolean m6285a() {
        return this.f6597b;
    }

    public static ThreadListExperimentManager m6283a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThreadListExperimentManager b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6595d) {
                ThreadListExperimentManager threadListExperimentManager;
                if (a2 != null) {
                    threadListExperimentManager = (ThreadListExperimentManager) a2.a(f6595d);
                } else {
                    threadListExperimentManager = f6594c;
                }
                if (threadListExperimentManager == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m6284b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6595d, b3);
                        } else {
                            f6594c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = threadListExperimentManager;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
