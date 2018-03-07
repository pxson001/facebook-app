package com.facebook.backgroundtasks;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.analytics.BaseAnalyticsConfig;
import com.facebook.analytics.logger.AnalyticsConfig;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.collect.TopologicalSort;
import com.facebook.common.collect.TopologicalSort.Node;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.SoftErrorHelper;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.BackgroundWorkLogger;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.NamedRunnable;
import com.facebook.common.time.Clock;
import com.facebook.common.userinteraction.DefaultUserInteractionController;
import com.facebook.common.userinteraction.UserInteractionController;
import com.facebook.common.userinteraction.UserInteractionListener;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Provider;

@ThreadSafe
/* compiled from: is_selected_option_external */
public class BackgroundTaskRunner {
    public Future<?> f9834A;
    public Future<?> f9835B;
    private Future<?> f9836C;
    private boolean f9837D;
    private final SingularlyQueuedRunnable f9838E = new RunnableEnsureBackgroundTasksScheduledInNonUiThread(this);
    private final SingularlyQueuedRunnable f9839F = new RunnableLetAllTasksRunOnceWithNoDelay(this);
    private final FutureCallback<BackgroundResult> f9840G = new TaskFutureCallback(this);
    public final ExecutorService f9841a;
    private final ScheduledExecutorService f9842b;
    private final Clock f9843c;
    private final DefaultUserInteractionController f9844d;
    private final AppStateManager f9845e;
    private final LocalBroadcastManager f9846f;
    public final BackgroundTaskController f9847g;
    public final Provider<BackgroundTaskPrerequisiteChecker> f9848h;
    private final DefaultAndroidThreadUtil f9849i;
    private final BaseAnalyticsConfig f9850j;
    private final QuickPerformanceLogger f9851k;
    private final BackgroundWorkLogger f9852l;
    private final AbstractFbErrorReporter f9853m;
    private final SoftErrorHelper f9854n;
    private final AnalyticsLogger f9855o;
    private final long f9856p;
    private final long f9857q;
    private final long f9858r;
    private final Lazy<Set<BackgroundTask>> f9859s;
    private final AtomicBoolean f9860t;
    private Map<String, TaskInfo> f9861u;
    private List<TaskInfo> f9862v;
    public final Map<Class<? extends Annotation>, Boolean> f9863w;
    private final UserInteractionListener f9864x;
    private int f9865y;
    private TaskInfo f9866z;

    /* compiled from: is_selected_option_external */
    class RunnableEnsureBackgroundTasksScheduledInNonUiThread extends SingularlyQueuedRunnable {
        final /* synthetic */ BackgroundTaskRunner f9868a;

        public RunnableEnsureBackgroundTasksScheduledInNonUiThread(BackgroundTaskRunner backgroundTaskRunner) {
            this.f9868a = backgroundTaskRunner;
        }

        public final void mo787a() {
            BackgroundTaskRunner.m10258h(this.f9868a);
        }
    }

    /* compiled from: is_selected_option_external */
    abstract class SingularlyQueuedRunnable implements Runnable {
        private final AtomicBoolean f9869a = new AtomicBoolean();

        public abstract void mo787a();

        public final void m10275a(ExecutorService executorService) {
            if (this.f9869a.compareAndSet(false, true)) {
                ExecutorDetour.a(executorService, this, -145682740);
            }
        }

        public final void run() {
            Preconditions.checkState(this.f9869a.getAndSet(false));
            mo787a();
        }
    }

    /* compiled from: is_selected_option_external */
    class RunnableLetAllTasksRunOnceWithNoDelay extends SingularlyQueuedRunnable {
        final /* synthetic */ BackgroundTaskRunner f9870a;

        public RunnableLetAllTasksRunOnceWithNoDelay(BackgroundTaskRunner backgroundTaskRunner) {
            this.f9870a = backgroundTaskRunner;
        }

        public final void mo787a() {
            for (TaskInfo taskInfo : BackgroundTaskRunner.m10264n(this.f9870a)) {
                taskInfo.f12538d = false;
            }
            BackgroundTaskRunner.m10258h(this.f9870a);
        }
    }

    /* compiled from: is_selected_option_external */
    class TaskFutureCallback implements FutureCallback<BackgroundResult> {
        final /* synthetic */ BackgroundTaskRunner f9871a;

        public TaskFutureCallback(BackgroundTaskRunner backgroundTaskRunner) {
            this.f9871a = backgroundTaskRunner;
        }

        public void onSuccess(Object obj) {
            BackgroundTaskRunner.m10244a(this.f9871a, (BackgroundResult) obj);
        }

        public void onFailure(Throwable th) {
            this.f9871a.m10267a(th, true);
        }
    }

    /* compiled from: is_selected_option_external */
    class C04451 implements UserInteractionListener {
        final /* synthetic */ BackgroundTaskRunner f9872a;

        C04451(BackgroundTaskRunner backgroundTaskRunner) {
            this.f9872a = backgroundTaskRunner;
        }

        public final void m10277a(boolean z) {
            BackgroundTaskRunner.m10245a(this.f9872a, z);
        }
    }

    /* compiled from: is_selected_option_external */
    class C04462 extends BroadcastReceiver {
        final /* synthetic */ BackgroundTaskRunner f9873a;

        C04462(BackgroundTaskRunner backgroundTaskRunner) {
            this.f9873a = backgroundTaskRunner;
        }

        public void onReceive(Context context, Intent intent) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1431713895);
            this.f9873a.m10270c();
            LogUtils.a(intent, 2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -970355230, a);
        }
    }

    private static int m10256g(TaskInfo taskInfo) {
        return taskInfo.f12535a.mo597a().hashCode();
    }

    @Inject
    public BackgroundTaskRunner(ExecutorService executorService, ScheduledExecutorService scheduledExecutorService, UserInteractionController userInteractionController, AppStateManager appStateManager, LocalBroadcastManager localBroadcastManager, Lazy<Set<BackgroundTask>> lazy, BackgroundTaskController backgroundTaskController, Provider<BackgroundTaskPrerequisiteChecker> provider, AndroidThreadUtil androidThreadUtil, Clock clock, AnalyticsConfig analyticsConfig, QuickPerformanceLogger quickPerformanceLogger, BackgroundWorkLogger backgroundWorkLogger, FbErrorReporter fbErrorReporter, SoftErrorHelper softErrorHelper, AnalyticsLogger analyticsLogger, @Assisted Long l, @Assisted Long l2, @Assisted Long l3) {
        Preconditions.checkArgument(l.longValue() > 0);
        Preconditions.checkArgument(l.longValue() <= l2.longValue());
        this.f9841a = executorService;
        this.f9842b = scheduledExecutorService;
        this.f9844d = userInteractionController;
        this.f9845e = appStateManager;
        this.f9846f = localBroadcastManager;
        this.f9847g = backgroundTaskController;
        this.f9848h = provider;
        this.f9849i = androidThreadUtil;
        this.f9843c = clock;
        this.f9850j = analyticsConfig;
        this.f9851k = quickPerformanceLogger;
        this.f9852l = backgroundWorkLogger;
        this.f9853m = fbErrorReporter;
        this.f9854n = softErrorHelper;
        this.f9855o = analyticsLogger;
        this.f9856p = l.longValue();
        this.f9857q = l2.longValue();
        this.f9858r = l3.longValue();
        this.f9863w = Maps.e();
        this.f9859s = lazy;
        this.f9860t = new AtomicBoolean(false);
        this.f9865y = 0;
        this.f9864x = new C04451(this);
        this.f9844d.a(this.f9864x);
        this.f9846f.a(new C04462(this), new IntentFilter(AppStateManager.a));
        this.f9837D = this.f9845e.j();
        this.f9851k.b(2555905, 10);
    }

    private List<TaskInfo> m10242a(Iterable<BackgroundTask> iterable) {
        ImmutableList<Node> a = TopologicalSort.m13280a(m10249b((Iterable) iterable));
        Builder builder = ImmutableList.builder();
        for (Node node : a) {
            builder.c(new TaskInfo((BackgroundTask) node.f11990a));
        }
        return builder.b();
    }

    private Collection<Node<BackgroundTask>> m10249b(Iterable<BackgroundTask> iterable) {
        Map hashMap = new HashMap();
        SortedMap treeMap = new TreeMap();
        for (BackgroundTask backgroundTask : iterable) {
            Node node = new Node(backgroundTask);
            hashMap.put(backgroundTask.mo597a(), node);
            int e = backgroundTask.mo601e();
            List list = (List) treeMap.get(Integer.valueOf(e));
            if (list == null) {
                list = new ArrayList();
                treeMap.put(Integer.valueOf(e), list);
            }
            list.add(node);
        }
        Set<Integer> keySet = treeMap.keySet();
        for (Node node2 : hashMap.values()) {
            Iterator it = ((BackgroundTask) node2.f11990a).mo600c().iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                node = (Node) hashMap.get(str);
                if (node == null) {
                    throw new IllegalArgumentException("Missing node for dependency: " + str);
                } else if (((BackgroundTask) node.f11990a).mo601e() < ((BackgroundTask) node2.f11990a).mo601e()) {
                    this.f9853m.b("BackgroundTaskRunner", String.format("%s has priority %d but depends on %s with lesser priority %d", new Object[]{((BackgroundTask) node2.f11990a).mo597a(), Integer.valueOf(((BackgroundTask) node2.f11990a).mo601e()), ((BackgroundTask) node.f11990a).mo597a(), Integer.valueOf(((BackgroundTask) node.f11990a).mo601e())}));
                } else {
                    node.m12651a(node2);
                }
            }
            for (Integer num : keySet) {
                if (num.intValue() > ((BackgroundTask) node2.f11990a).mo601e()) {
                    for (Node a : (List) treeMap.get(num)) {
                        a.m12651a(node2);
                    }
                }
            }
        }
        return hashMap.values();
    }

    private static Map<String, TaskInfo> m10252c(Iterable<TaskInfo> iterable) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        for (TaskInfo taskInfo : iterable) {
            builder.b(taskInfo.toString(), taskInfo);
        }
        return builder.b();
    }

    public final void m10266a() {
        m10254e();
    }

    public final void m10268b() {
        m10254e();
    }

    public final void m10269b(Class<? extends Annotation> cls) {
        this.f9863w.remove(cls);
        m10254e();
    }

    public static void m10245a(BackgroundTaskRunner backgroundTaskRunner, boolean z) {
        if (!z) {
            backgroundTaskRunner.m10255f();
        }
    }

    @VisibleForTesting
    final void m10270c() {
        boolean j = this.f9845e.j();
        if (this.f9837D != j) {
            this.f9837D = j;
            if (!this.f9837D) {
                m10255f();
            }
        }
    }

    private void m10254e() {
        this.f9839F.m10275a(this.f9841a);
    }

    private void m10255f() {
        this.f9838E.m10275a(this.f9841a);
    }

    @VisibleForTesting
    private void m10243a(long j) {
        this.f9834A = this.f9842b.schedule(new NamedRunnable(this, "BackgroundTaskRunner", "runAnyBackgroundTasksDelayed") {
            final /* synthetic */ BackgroundTaskRunner f12540c;

            public void run() {
                this.f12540c.f9834A = null;
                this.f12540c.f9835B = ExecutorDetour.a(this.f12540c.f9841a, new NamedRunnable(this, "BackgroundTaskRunner", "runAnyBackgroundTasks") {
                    final /* synthetic */ C05913 f12541c;

                    public void run() {
                        this.f12541c.f12540c.f9835B = null;
                        this.f12541c.f12540c.m10271d();
                    }
                }, -974803635);
            }
        }, j, TimeUnit.MILLISECONDS);
    }

    @VisibleForTesting
    private void m10257g() {
        this.f9849i.b();
    }

    public static void m10258h(BackgroundTaskRunner backgroundTaskRunner) {
        backgroundTaskRunner.m10257g();
        if (backgroundTaskRunner.f9834A != null) {
            backgroundTaskRunner.f9834A.cancel(false);
            backgroundTaskRunner.f9834A = null;
        }
        if (backgroundTaskRunner.f9835B != null) {
            backgroundTaskRunner.f9835B.cancel(false);
            backgroundTaskRunner.f9835B = null;
        }
        backgroundTaskRunner.m10243a(backgroundTaskRunner.m10259i());
    }

    @VisibleForTesting
    private long m10259i() {
        long a = this.f9843c.a();
        long j = a + this.f9858r;
        List<TaskInfo> n = m10264n(this);
        for (TaskInfo taskInfo : n) {
            if (!taskInfo.f12538d) {
                return 0;
            }
        }
        for (TaskInfo taskInfo2 : n) {
            if (m10251b(taskInfo2)) {
                long j2;
                if (taskInfo2.m13284a(this.f9843c)) {
                    j2 = taskInfo2.f12537c;
                } else {
                    j2 = taskInfo2.f12535a.mo593f();
                }
                long j3 = j2;
                if (j3 != -1) {
                    j3 = Math.min(j, j3);
                } else {
                    j3 = j;
                }
                j = j3;
            }
        }
        return Math.max(0, j - a);
    }

    @VisibleForTesting
    final synchronized void m10271d() {
        m10257g();
        if (this.f9866z == null && !this.f9844d.b()) {
            final ListenableFuture k = m10261k();
            if (k != null) {
                Futures.a(k, this.f9840G, this.f9841a);
                this.f9836C = this.f9842b.schedule(new NamedRunnable(this, "BackgroundTaskRunner", "checkTaskCompletion") {
                    final /* synthetic */ BackgroundTaskRunner f12811d;

                    public void run() {
                        if (!k.isDone()) {
                            this.f12811d.m10267a(new TimeoutException(), true);
                        }
                    }
                }, 180, TimeUnit.SECONDS);
            } else {
                m10255f();
            }
        }
    }

    private TaskInfo m10260j() {
        Preconditions.checkNotNull(this.f9866z);
        TaskInfo taskInfo = this.f9866z;
        this.f9866z = null;
        if (this.f9836C != null) {
            this.f9836C.cancel(false);
            this.f9836C = null;
        }
        return taskInfo;
    }

    public static void m10244a(BackgroundTaskRunner backgroundTaskRunner, BackgroundResult backgroundResult) {
        backgroundTaskRunner.m10257g();
        TaskInfo j = backgroundTaskRunner.m10260j();
        String simpleName = j.f12535a.getClass().getSimpleName();
        if (backgroundTaskRunner.f9850j.b()) {
            int g = m10256g(j);
            backgroundTaskRunner.f9851k.b(2555905, g, simpleName);
            backgroundTaskRunner.f9851k.b(2555905, g, (short) 2);
        }
        j.m13285b(true);
        if (backgroundResult.f12850a) {
            j.f12536b = 0;
        } else {
            j.m13283a(backgroundTaskRunner.f9843c, backgroundTaskRunner.f9856p, backgroundTaskRunner.f9857q);
        }
        m10258h(backgroundTaskRunner);
    }

    private void m10250b(Throwable th, boolean z) {
        m10257g();
        TaskInfo j = m10260j();
        if (this.f9850j.b()) {
            int g = m10256g(j);
            QuickPerformanceLogger quickPerformanceLogger = this.f9851k;
            String str = "exception";
            String message = (th == null || th.getMessage() == null) ? "null" : th.getMessage();
            quickPerformanceLogger.b(2555905, g, str, message);
            this.f9851k.b(2555905, g, (short) 3);
        }
        j.m13285b(false);
        m10247a("start", j, th);
        j.m13283a(this.f9843c, this.f9856p, this.f9857q);
        if (z) {
            m10258h(this);
        }
    }

    @VisibleForTesting
    final void m10267a(Throwable th, boolean z) {
        m10250b(th, z);
    }

    @Nullable
    private ListenableFuture<BackgroundResult> m10261k() {
        int size = m10264n(this).size();
        for (int i = 0; i < size; i++) {
            TaskInfo l = m10262l();
            if (l == null) {
                return null;
            }
            this.f9866z = l;
            boolean b = this.f9850j.b();
            if (b) {
                try {
                    this.f9851k.e(2555905, m10256g(l));
                } catch (Throwable th) {
                    m10267a(th, false);
                    return null;
                }
            }
            ListenableFuture<BackgroundResult> a = this.f9866z.m13282a(this.f9852l);
            if (a != null) {
                return a;
            }
            if (b) {
                this.f9851k.markerCancel(2555905, m10256g(l));
            }
            l.m13285b(true);
            m10260j();
        }
        return null;
    }

    @Nullable
    private TaskInfo m10262l() {
        List n = m10264n(this);
        int size = n.size();
        int i = 0;
        while (i < size) {
            int i2 = (this.f9865y + i) % size;
            TaskInfo taskInfo = (TaskInfo) n.get(i2);
            taskInfo.f12538d = true;
            if (taskInfo.m13284a(this.f9843c) || !m10248a(taskInfo)) {
                i++;
            } else {
                this.f9865y = (i2 + 1) % size;
                return taskInfo;
            }
        }
        return null;
    }

    @VisibleForTesting
    private void m10246a(TaskInfo taskInfo, Throwable th) {
        m10247a("wantsToBeRunNow", taskInfo, th);
    }

    private boolean m10248a(TaskInfo taskInfo) {
        boolean z = false;
        if (m10251b(taskInfo)) {
            try {
                z = taskInfo.m13281a().mo595i();
            } catch (Throwable th) {
                m10246a(taskInfo, th);
            }
        }
        return z;
    }

    private boolean m10251b(TaskInfo taskInfo) {
        if (!m10253c(taskInfo)) {
            Object obj;
            BackgroundTaskController backgroundTaskController = this.f9847g;
            Iterator it = taskInfo.f12535a.mo599b().iterator();
            while (it.hasNext()) {
                if (backgroundTaskController.b.containsKey((Class) it.next())) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj == null) {
                Object obj2;
                for (Class containsKey : taskInfo.f12535a.mo592d()) {
                    if (this.f9863w.containsKey(containsKey)) {
                        obj2 = null;
                        break;
                    }
                }
                obj2 = 1;
                if (obj2 != null && ((BackgroundTaskPrerequisiteChecker) this.f9848h.get()).m13650a(taskInfo.f12535a)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean m10253c(TaskInfo taskInfo) {
        Map m = m10263m();
        Iterator it = taskInfo.f12535a.mo600c().iterator();
        while (it.hasNext()) {
            if (((TaskInfo) m.get((String) it.next())).m13286b()) {
                return true;
            }
        }
        return false;
    }

    private Map<String, TaskInfo> m10263m() {
        m10265o();
        return this.f9861u;
    }

    public static List m10264n(BackgroundTaskRunner backgroundTaskRunner) {
        backgroundTaskRunner.m10265o();
        return backgroundTaskRunner.f9862v;
    }

    private synchronized void m10265o() {
        if (!this.f9860t.getAndSet(true)) {
            TracerDetour.a("backgroundTaskInitialization", 825507917);
            try {
                int hasNext;
                this.f9862v = m10242a((Iterable) this.f9859s.get());
                this.f9861u = m10252c(this.f9862v);
                Iterator it = this.f9862v.iterator();
                while (true) {
                    hasNext = it.hasNext();
                    if (hasNext == 0) {
                        break;
                    }
                    ((TaskInfo) it.next()).m13281a().mo598a(this);
                }
                TracerDetour.a(hasNext);
            } finally {
                TracerDetour.a(-725306191);
            }
        }
    }

    private void m10247a(String str, TaskInfo taskInfo, Throwable th) {
        if (SoftErrorHelper.a(th)) {
            this.f9855o.a(new HoneyClientEvent("background_task_exception").b("type", th.getClass().getSimpleName()).b("msg", th.getMessage()));
            return;
        }
        this.f9853m.a("BackgroundTaskRunner_" + taskInfo + "_" + str, "Task threw exception", th);
    }
}
