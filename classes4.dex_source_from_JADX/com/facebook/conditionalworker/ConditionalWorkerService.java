package com.facebook.conditionalworker;

import android.content.Context;
import android.content.Intent;
import com.facebook.auth.datastore.LoggedInUserAuthDataStore;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.base.service.FbIntentService;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.hardware.SystemBatteryStateManager;
import com.facebook.common.init.AppInitLockHelper;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.time.TimeUtil;
import com.facebook.conditionalworker.ConditionalWorkerInfo.Trigger;
import com.facebook.conditionalworker.CurrentStates.Factory;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.user.model.User;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: maxNumberOfConfigurations must be greater 0 */
public class ConditionalWorkerService extends FbIntentService {
    private static final Class<?> f8225a = ConditionalWorkerService.class;
    private ConditionalWorkerManager f8226b;
    private AppStateManager f8227c;
    private NetworkStateManager f8228d;
    private LoggedInUserSessionManager f8229e;
    private SystemBatteryStateManager f8230f;
    private Set<ConditionalWorkerInfo> f8231g;
    private Clock f8232h;
    private ConditionalWorkerExecutionRecordManager f8233i;
    private ExecutorService f8234j;
    private AbstractFbErrorReporter f8235k;
    private PerformanceLogger f8236l;
    private Factory f8237m;
    private Set<ConditionalWorkerInfo> f8238n;
    private List<ConditionalWorkerInfo> f8239o;
    private List<ConditionalWorkerInfo> f8240p;

    private static <T extends Context> void m8539a(Class<T> cls, T t) {
        m8540a((Object) t, (Context) t);
    }

    public static void m8540a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((ConditionalWorkerService) obj).m8536a(ConditionalWorkerManager.m8492a(injectorLike), AppStateManager.a(injectorLike), NetworkStateManager.m8499a(injectorLike), LoggedInUserSessionManager.a(injectorLike), SystemBatteryStateManager.a(injectorLike), STATICDI_MULTIBIND_PROVIDER$ConditionalWorkerInfo.m10560a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), ConditionalWorkerExecutionRecordManager.m10561a(injectorLike), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (PerformanceLogger) DelegatingPerformanceLogger.a(injectorLike));
    }

    public ConditionalWorkerService() {
        super(f8225a.getSimpleName());
    }

    public void onCreate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, -338479882);
        super.onCreate();
        Class cls = ConditionalWorkerService.class;
        m8540a((Object) this, (Context) this);
        Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, 1625353915, a);
    }

    @Inject
    private void m8536a(ConditionalWorkerManager conditionalWorkerManager, AppStateManager appStateManager, NetworkStateManager networkStateManager, LoggedInUserAuthDataStore loggedInUserAuthDataStore, SystemBatteryStateManager systemBatteryStateManager, Set<ConditionalWorkerInfo> set, Clock clock, ConditionalWorkerExecutionRecordManager conditionalWorkerExecutionRecordManager, ExecutorService executorService, FbErrorReporter fbErrorReporter, PerformanceLogger performanceLogger) {
        this.f8226b = conditionalWorkerManager;
        this.f8227c = appStateManager;
        this.f8228d = networkStateManager;
        this.f8229e = loggedInUserAuthDataStore;
        this.f8230f = systemBatteryStateManager;
        this.f8231g = set;
        this.f8232h = clock;
        this.f8233i = conditionalWorkerExecutionRecordManager;
        this.f8234j = executorService;
        this.f8235k = fbErrorReporter;
        this.f8236l = performanceLogger;
    }

    protected final void m8545a(Intent intent) {
        if (intent != null) {
            m8541b();
        }
    }

    private static long m8529a(int i) {
        return TimeUtil.m10808a((1 << (Math.min(i, 32) - 1)) * 5);
    }

    private void m8541b() {
        if (this.f8231g != null && !this.f8231g.isEmpty()) {
            AppInitLockHelper.a(this);
            this.f8237m = new Factory(this.f8227c, this.f8228d, this.f8229e, this.f8230f);
            this.f8238n = new HashSet(this.f8231g);
            this.f8239o = new ArrayList(this.f8238n.size());
            this.f8240p = new ArrayList(this.f8238n.size());
            long j = 0;
            int i = 0;
            while (!this.f8238n.isEmpty()) {
                CurrentStates a = this.f8237m.m10569a();
                j = this.f8232h.a();
                m8537a(a, j);
                if (i >= 5 || this.f8239o.isEmpty()) {
                    break;
                }
                m8542c();
                this.f8240p.addAll(this.f8239o);
                this.f8239o.clear();
                i++;
            }
            Integer.valueOf(i);
            if (i >= 5 && !this.f8239o.isEmpty()) {
                this.f8240p.addAll(this.f8239o);
                this.f8235k.a(f8225a.getSimpleName(), "Remaining executable ConditionalWorkerInfo after 5 execution passes: " + m8544e());
            }
            m8534a(j);
        }
    }

    private void m8537a(CurrentStates currentStates, long j) {
        Iterator it = this.f8238n.iterator();
        while (it.hasNext()) {
            ConditionalWorkerInfo conditionalWorkerInfo = (ConditionalWorkerInfo) it.next();
            if (conditionalWorkerInfo.mo788a()) {
                RequiredStates d = conditionalWorkerInfo.mo791d();
                if (conditionalWorkerInfo.mo789b().equals(Trigger.STATE_CHANGE)) {
                    m8538a(currentStates, conditionalWorkerInfo, d);
                }
                Object[] objArr = new Object[]{conditionalWorkerInfo.getClass().getSimpleName(), r3, d, TimeUtil.m10809a(conditionalWorkerInfo.mo792e()), TimeUtil.m10810a(m8530a(conditionalWorkerInfo), j)};
                if (j >= m8530a(conditionalWorkerInfo) && currentStates.m10801a(d) && !this.f8233i.m10566g(conditionalWorkerInfo)) {
                    this.f8239o.add(conditionalWorkerInfo);
                    it.remove();
                }
            } else {
                conditionalWorkerInfo.getClass().getSimpleName();
            }
        }
    }

    private void m8538a(CurrentStates currentStates, ConditionalWorkerInfo conditionalWorkerInfo, RequiredStates requiredStates) {
        if (!currentStates.m10801a(requiredStates)) {
            if (this.f8233i.m10566g(conditionalWorkerInfo)) {
                PrefKey prefKey = (PrefKey) ConditionalWorkerExecutionRecordManager.f10101c.a(conditionalWorkerInfo.getClass().getName());
                this.f8233i.f10103d.edit().putBoolean(prefKey, false).commit();
                return;
            }
            this.f8233i.m10565d(conditionalWorkerInfo);
        }
    }

    private long m8530a(ConditionalWorkerInfo conditionalWorkerInfo) {
        long a;
        PrefKey prefKey = (PrefKey) ConditionalWorkerExecutionRecordManager.f10099a.a(conditionalWorkerInfo.getClass().getName());
        long a2 = this.f8233i.f10103d.a(prefKey, 0);
        int b = this.f8233i.m10563b(conditionalWorkerInfo);
        if (b > 0) {
            conditionalWorkerInfo.getClass().getSimpleName();
            Integer.valueOf(b);
            if (Trigger.STATE_CHANGE.equals(conditionalWorkerInfo.mo789b())) {
                a = m8529a(b);
            } else {
                a = Math.min(m8529a(b), conditionalWorkerInfo.mo792e());
            }
        } else {
            a = conditionalWorkerInfo.mo792e();
        }
        return a + a2;
    }

    private void m8542c() {
        Object a = m8533a(m8543d());
        try {
            int i = 0;
            for (Future future : this.f8234j.invokeAll(a, ConditionalWorkerInfo.f10113a, TimeUnit.MILLISECONDS)) {
                Throwable th;
                ConditionalWorkerResult conditionalWorkerResult;
                if (future.isCancelled()) {
                    th = null;
                    conditionalWorkerResult = null;
                } else {
                    try {
                        conditionalWorkerResult = (ConditionalWorkerResult) FutureDetour.a(future, -1397473044);
                        th = null;
                    } catch (Throwable e) {
                        BLog.b(f8225a, "Future<ConditionalWorkerResult>.get()", e);
                        th = e;
                        conditionalWorkerResult = null;
                    } catch (Throwable e2) {
                        BLog.b(f8225a, "Future<ConditionalWorkerResult>.get()", e2);
                        th = e2;
                        conditionalWorkerResult = null;
                    }
                }
                if (conditionalWorkerResult == null) {
                    m8535a(((ConditionalWorkerRunner) a.get(i)).m1309c(), false, th);
                } else {
                    m8535a(conditionalWorkerResult.f1018a, conditionalWorkerResult.f1019b, null);
                }
                i++;
            }
        } catch (Throwable e22) {
            BLog.b(f8225a, "ExecutorService.invokeAll()", e22);
            this.f8235k.a(f8225a.getSimpleName(), "ExecutorService.invokeAll()", e22);
        }
    }

    private boolean m8543d() {
        User c = this.f8229e.c();
        return c != null && c.o;
    }

    private List<ConditionalWorkerRunner> m8533a(boolean z) {
        List<ConditionalWorkerRunner> arrayList = new ArrayList();
        for (ConditionalWorkerInfo a : this.f8239o) {
            arrayList.add(m8532a(a, z));
        }
        return arrayList;
    }

    private ConditionalWorkerRunner m8532a(ConditionalWorkerInfo conditionalWorkerInfo, boolean z) {
        return new ConditionalWorkerRunner(conditionalWorkerInfo, z, f8225a.getSimpleName(), this.f8236l, this.f8237m);
    }

    private void m8535a(ConditionalWorkerInfo conditionalWorkerInfo, boolean z, @Nullable Throwable th) {
        PrefKey prefKey;
        ConditionalWorkerExecutionRecordManager conditionalWorkerExecutionRecordManager;
        if (z) {
            if (Trigger.STATE_CHANGE.equals(conditionalWorkerInfo.mo789b())) {
                prefKey = (PrefKey) ConditionalWorkerExecutionRecordManager.f10101c.a(conditionalWorkerInfo.getClass().getName());
                this.f8233i.f10103d.edit().putBoolean(prefKey, true).commit();
            }
            this.f8233i.m10565d(conditionalWorkerInfo);
            conditionalWorkerInfo.getClass().getSimpleName();
        } else {
            conditionalWorkerExecutionRecordManager = this.f8233i;
            prefKey = (PrefKey) ConditionalWorkerExecutionRecordManager.f10100b.a(conditionalWorkerInfo.getClass().getName());
            conditionalWorkerExecutionRecordManager.f10103d.edit().a(prefKey, conditionalWorkerExecutionRecordManager.f10103d.a(prefKey, 0) + 1).commit();
            conditionalWorkerInfo.getClass().getSimpleName();
            if (th != null) {
                this.f8235k.a(f8225a.getSimpleName(), "Execution failed: " + conditionalWorkerInfo.getClass().getSimpleName(), th);
            }
        }
        conditionalWorkerExecutionRecordManager = this.f8233i;
        prefKey = (PrefKey) ConditionalWorkerExecutionRecordManager.f10099a.a(conditionalWorkerInfo.getClass().getName());
        conditionalWorkerExecutionRecordManager.f10103d.edit().a(prefKey, this.f8232h.a()).commit();
    }

    private void m8534a(long j) {
        long min = Math.min(m8531a(this.f8238n.iterator(), j), m8531a(this.f8240p.iterator(), j));
        if (min < Long.MAX_VALUE) {
            min = Math.max(min - this.f8232h.a(), ConditionalWorkerInfo.f10113a);
            ConditionalWorkerManager conditionalWorkerManager = this.f8226b;
            if (conditionalWorkerManager.f8206k != null) {
                conditionalWorkerManager.f8206k.cancel(true);
            }
            conditionalWorkerManager.f8206k = conditionalWorkerManager.f8201f.schedule(conditionalWorkerManager.f8205j, min, TimeUnit.MILLISECONDS);
            TimeUtil.m10809a(min);
        }
    }

    private long m8531a(Iterator<ConditionalWorkerInfo> it, long j) {
        long j2 = Long.MAX_VALUE;
        while (it.hasNext()) {
            ConditionalWorkerInfo conditionalWorkerInfo = (ConditionalWorkerInfo) it.next();
            if (conditionalWorkerInfo.mo788a() && (!Trigger.STATE_CHANGE.equals(conditionalWorkerInfo.mo789b()) || (!this.f8233i.m10566g(conditionalWorkerInfo) && this.f8233i.m10563b(conditionalWorkerInfo) > 0))) {
                long a = m8530a(conditionalWorkerInfo);
                if (j < a) {
                    j2 = Math.min(a, j2);
                }
            }
        }
        return j2;
    }

    private String m8544e() {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (ConditionalWorkerInfo conditionalWorkerInfo : this.f8239o) {
            if (stringBuilder.length() > 1) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(conditionalWorkerInfo.getClass().getSimpleName());
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
