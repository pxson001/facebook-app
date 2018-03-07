package com.facebook.auth.component.persistent;

import com.facebook.auth.component.persistent.PersistentComponent.ComponentType;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethodRunnerParams;
import com.facebook.http.protocol.ApiMethodRunnerParams.HttpConfig;
import com.facebook.http.protocol.BatchComponent;
import com.facebook.http.protocol.BatchComponentRunner;
import com.facebook.inject.Lazy;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

/* compiled from: taggable_ids */
public class PersistentComponentManager {
    private final Lazy<Set<PersistentComponent>> f1328a;
    private final Lazy<BatchComponentRunner> f1329b;
    private final Lazy<ExecutorService> f1330c;
    private final QuickPerformanceLogger f1331d;
    private final Lazy<FbErrorReporter> f1332e;

    @Inject
    public PersistentComponentManager(Lazy<Set<PersistentComponent>> lazy, Lazy<BatchComponentRunner> lazy2, Lazy<ExecutorService> lazy3, QuickPerformanceLogger quickPerformanceLogger, Lazy<FbErrorReporter> lazy4) {
        this.f1328a = lazy;
        this.f1329b = lazy2;
        this.f1330c = lazy3;
        this.f1331d = quickPerformanceLogger;
        this.f1332e = lazy4;
    }

    public final void m1564a(CallerContext callerContext) {
        Set<PersistentComponent> set = (Set) this.f1328a.get();
        if (!set.isEmpty()) {
            this.f1331d.b(2293776);
            ArrayList arrayList = null;
            ArrayList arrayList2 = null;
            for (PersistentComponent persistentComponent : set) {
                persistentComponent.mo94a();
                if (!persistentComponent.cn_()) {
                    this.f1331d.a(2293776, persistentComponent.getClass().getSimpleName());
                    BatchComponent c = persistentComponent.mo95c();
                    if (c != null) {
                        ArrayList arrayList3;
                        if (persistentComponent.mo98e() == ComponentType.QE) {
                            if (arrayList == null) {
                                arrayList3 = new ArrayList(1);
                            } else {
                                arrayList3 = arrayList;
                            }
                            arrayList3.add(c);
                            arrayList = arrayList3;
                        } else {
                            if (arrayList2 == null) {
                                arrayList3 = new ArrayList(set.size());
                            } else {
                                arrayList3 = arrayList2;
                            }
                            arrayList3.add(c);
                            arrayList2 = arrayList3;
                        }
                    }
                }
            }
            this.f1331d.b(2293776, (short) 2);
            if (arrayList2 != null && arrayList != null) {
                m1563a(callerContext, arrayList2, arrayList);
            } else if (arrayList2 != null) {
                m1562a(this, callerContext, arrayList2, ComponentType.OTHER.name());
            } else if (arrayList != null) {
                m1562a(this, callerContext, arrayList, ComponentType.QE.name());
            }
        }
    }

    private void m1563a(final CallerContext callerContext, final ArrayList<BatchComponent> arrayList, final ArrayList<BatchComponent> arrayList2) {
        Collection arrayList3 = new ArrayList(2);
        arrayList3.add(new Callable<Void>(this) {
            final /* synthetic */ PersistentComponentManager f1639c;

            public Object call() {
                PersistentComponentManager.m1562a(this.f1639c, callerContext, arrayList2, ComponentType.QE.name());
                return null;
            }
        });
        arrayList3.add(new Callable<Void>(this) {
            final /* synthetic */ PersistentComponentManager f1642c;

            public Object call() {
                PersistentComponentManager.m1562a(this.f1642c, callerContext, arrayList, ComponentType.OTHER.name());
                return null;
            }
        });
        try {
            for (Future future : ((ExecutorService) this.f1330c.get()).invokeAll(arrayList3, 35000, TimeUnit.MILLISECONDS)) {
                if (!future.isCancelled()) {
                    FutureDetour.a(future, 142910225);
                }
            }
        } catch (Throwable e) {
            ((AbstractFbErrorReporter) this.f1332e.get()).a("PersistentComponentManager", "PersistentComponents execution interruption", e);
        } catch (Throwable e2) {
            ((AbstractFbErrorReporter) this.f1332e.get()).a("PersistentComponentManager", "PersistentComponents execution failure", e2);
        }
    }

    public static void m1562a(PersistentComponentManager persistentComponentManager, CallerContext callerContext, ArrayList arrayList, String str) {
        persistentComponentManager.f1331d.b(2293777);
        persistentComponentManager.f1331d.a(2293777, str);
        ApiMethodRunnerParams apiMethodRunnerParams = new ApiMethodRunnerParams();
        apiMethodRunnerParams.a(HttpConfig.BOOTSTRAP);
        apiMethodRunnerParams.a(RequestPriority.INTERACTIVE);
        try {
            ((BatchComponentRunner) persistentComponentManager.f1329b.get()).m1567a("fetchPersistentComponents", callerContext, arrayList, apiMethodRunnerParams);
            persistentComponentManager.f1331d.b(2293777, (short) 2);
        } catch (Throwable e) {
            ((AbstractFbErrorReporter) persistentComponentManager.f1332e.get()).b("PersistentComponentManager", "BatchComponentRunner fetchPersistentComponents failure", e);
            persistentComponentManager.f1331d.b(2293777, (short) 87);
        }
    }
}
