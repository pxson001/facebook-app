package com.facebook.common.executors;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Handler;
import com.facebook.common.process.DefaultProcessUtil;
import com.facebook.common.time.MonotonicClock;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.DynamicSecureBroadcastReceiver;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.ForwardingFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.ListenableScheduledFuture;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;

@ThreadSafe
/* compiled from: maxSize (%s) must >= 0 */
public class WakingExecutorService extends AbstractExecutorService implements ListeningScheduledExecutorService {
    @VisibleForTesting
    public static final String f8214a = (WakingExecutorService.class.getCanonicalName() + ".ACTION_ALARM.");
    private static final Class<?> f8215b = WakingExecutorService.class;
    private final Context f8216c;
    public final MonotonicClock f8217d;
    private final AlarmManager f8218e;
    private final PendingIntent f8219f;
    public final BackgroundWorkLogger f8220g;
    @Nullable
    private final Handler f8221h;
    @GuardedBy("this")
    public final PriorityQueue<ScheduledTask<?>> f8222i = new PriorityQueue();

    /* compiled from: maxSize (%s) must >= 0 */
    public class AlarmReceiver extends DynamicSecureBroadcastReceiver {

        /* compiled from: maxSize (%s) must >= 0 */
        class AlarmAction implements ActionReceiver {
            private final WakingExecutorService f8223a;

            public AlarmAction(WakingExecutorService wakingExecutorService) {
                this.f8223a = wakingExecutorService;
            }

            public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
                int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 609292524);
                WakingExecutorService.m8510a(this.f8223a);
                Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1954817591, a);
            }
        }

        public AlarmReceiver(WakingExecutorService wakingExecutorService, String str) {
            super(str, new AlarmAction(wakingExecutorService));
        }
    }

    /* compiled from: maxSize (%s) must >= 0 */
    public class WakingListenableScheduledFuture<V> extends ForwardingFuture<V> implements ListenableScheduledFuture<V>, Runnable, ScheduledFuture<V> {
        public final ListenableFutureTask<V> f10326a;
        final /* synthetic */ WakingExecutorService f10327b;

        public WakingListenableScheduledFuture(WakingExecutorService wakingExecutorService, Callable<V> callable) {
            this.f10327b = wakingExecutorService;
            this.f10326a = ListenableFutureTask.a(callable);
        }

        public WakingListenableScheduledFuture(WakingExecutorService wakingExecutorService, Runnable runnable, @Nullable V v) {
            this.f10327b = wakingExecutorService;
            this.f10326a = ListenableFutureTask.a(runnable, v);
        }

        public long getDelay(TimeUnit timeUnit) {
            throw new UnsupportedOperationException();
        }

        public int compareTo(Object obj) {
            throw new UnsupportedOperationException();
        }

        protected final /* synthetic */ Future m10858a() {
            return this.f10326a;
        }

        public final void m10859a(Runnable runnable, Executor executor) {
            this.f10326a.a(runnable, executor);
        }

        protected final /* synthetic */ Object m10860e() {
            return this.f10326a;
        }

        public void run() {
            this.f10326a.run();
        }

        public boolean cancel(boolean z) {
            WakingExecutorService.m8511a(this.f10327b, this);
            return this.f10326a.cancel(z);
        }
    }

    /* compiled from: maxSize (%s) must >= 0 */
    public class ScheduledTask<V> implements Comparable<ScheduledTask<V>> {
        public final WakingListenableScheduledFuture<V> f10328a;
        public final long f10329b;

        public int compareTo(Object obj) {
            return Long.valueOf(this.f10329b).compareTo(Long.valueOf(((ScheduledTask) obj).f10329b));
        }

        public ScheduledTask(WakingListenableScheduledFuture<V> wakingListenableScheduledFuture, long j) {
            this.f10328a = wakingListenableScheduledFuture;
            this.f10329b = j;
        }
    }

    public final /* synthetic */ ListenableFuture m8522a(Runnable runnable) {
        return m8513b(runnable);
    }

    public final /* synthetic */ ListenableFuture m8523a(Runnable runnable, @Nullable Object obj) {
        return m8515b(runnable, obj);
    }

    public final /* synthetic */ ListenableFuture m8524a(Callable callable) {
        return m8516b(callable);
    }

    public final /* synthetic */ ListenableScheduledFuture m8526a(Runnable runnable, long j, TimeUnit timeUnit) {
        return m8514b(runnable, j, timeUnit);
    }

    public final /* synthetic */ ListenableScheduledFuture m8527a(Callable callable, long j, TimeUnit timeUnit) {
        return m8517b(callable, j, timeUnit);
    }

    public /* synthetic */ ScheduledFuture schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        return m8514b(runnable, j, timeUnit);
    }

    public /* synthetic */ ScheduledFuture schedule(Callable callable, long j, TimeUnit timeUnit) {
        return m8517b(callable, j, timeUnit);
    }

    public /* synthetic */ ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return m8525a(runnable, j, j2, timeUnit);
    }

    public /* synthetic */ ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return m8528b(runnable, j, j2, timeUnit);
    }

    public /* synthetic */ Future submit(Runnable runnable) {
        return m8513b(runnable);
    }

    public /* synthetic */ Future submit(Runnable runnable, @Nullable Object obj) {
        return m8515b(runnable, obj);
    }

    public /* synthetic */ Future submit(Callable callable) {
        return m8516b(callable);
    }

    @Inject
    public WakingExecutorService(Context context, MonotonicClock monotonicClock, AlarmManager alarmManager, DefaultProcessUtil defaultProcessUtil, BackgroundWorkLogger backgroundWorkLogger, @Assisted String str, @Nullable @Assisted Handler handler) {
        String str2;
        this.f8216c = context;
        this.f8217d = monotonicClock;
        this.f8218e = alarmManager;
        this.f8220g = backgroundWorkLogger;
        this.f8221h = handler;
        if (str == null) {
            str2 = f8214a + defaultProcessUtil.a();
        } else {
            str2 = f8214a + defaultProcessUtil.a() + "." + str;
        }
        String str3 = str2;
        Intent intent = new Intent(str3);
        intent.setPackage(this.f8216c.getPackageName());
        this.f8219f = PendingIntent.getBroadcast(this.f8216c, 0, intent, 134217728);
        this.f8216c.registerReceiver(new AlarmReceiver(this, str3), new IntentFilter(str3), null, this.f8221h);
    }

    private WakingListenableScheduledFuture<?> m8514b(Runnable runnable, long j, TimeUnit timeUnit) {
        WakingListenableScheduledFuture c = m8519c(m8521c(runnable), null);
        m8509a(c, this.f8217d.now() + timeUnit.toMillis(j));
        return c;
    }

    private <T> WakingListenableScheduledFuture<T> m8516b(Callable<T> callable) {
        return m8517b((Callable) callable, 0, TimeUnit.MILLISECONDS);
    }

    private <T> WakingListenableScheduledFuture<T> m8515b(Runnable runnable, @Nullable T t) {
        WakingListenableScheduledFuture c = m8519c(m8521c(runnable), t);
        m8509a(c, this.f8217d.now());
        return c;
    }

    private WakingListenableScheduledFuture<?> m8513b(Runnable runnable) {
        return m8515b(runnable, null);
    }

    public void execute(Runnable runnable) {
        m8513b(runnable);
    }

    public final ListenableScheduledFuture<?> m8525a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public final ListenableScheduledFuture<?> m8528b(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public void shutdown() {
        throw new UnsupportedOperationException();
    }

    public List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException();
    }

    public boolean isShutdown() {
        return false;
    }

    public boolean isTerminated() {
        return false;
    }

    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @TargetApi(11)
    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new ListenableScheduledRunnableFuture(this, runnable, t);
    }

    @TargetApi(11)
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new ListenableScheduledRunnableFuture(this, callable);
    }

    private <T> WakingListenableScheduledFuture<T> m8519c(Runnable runnable, @Nullable T t) {
        return new WakingListenableScheduledFuture(this, runnable, t);
    }

    private void m8509a(WakingListenableScheduledFuture<?> wakingListenableScheduledFuture, long j) {
        Long.valueOf((j - this.f8217d.now()) / 1000);
        synchronized (this) {
            this.f8222i.add(new ScheduledTask(wakingListenableScheduledFuture, j));
            m8518b();
        }
    }

    public static void m8510a(WakingExecutorService wakingExecutorService) {
        ImmutableList c;
        synchronized (wakingExecutorService) {
            c = wakingExecutorService.m8520c();
            wakingExecutorService.m8518b();
        }
        m8512a(c);
    }

    @GuardedBy("this")
    private void m8518b() {
        if (this.f8222i.isEmpty()) {
            this.f8218e.cancel(this.f8219f);
            return;
        }
        long j = ((ScheduledTask) this.f8222i.peek()).f10329b;
        Long.valueOf((j - this.f8217d.now()) / 1000);
        if (VERSION.SDK_INT < 19) {
            this.f8218e.set(2, j, this.f8219f);
        } else {
            this.f8218e.setExact(2, j, this.f8219f);
        }
    }

    @GuardedBy("this")
    private ImmutableList<WakingListenableScheduledFuture> m8520c() {
        Builder builder = ImmutableList.builder();
        while (true) {
            Object obj;
            if (this.f8222i.isEmpty() || ((ScheduledTask) this.f8222i.peek()).f10329b > this.f8217d.now()) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                return builder.b();
            }
            builder.c(((ScheduledTask) this.f8222i.remove()).f10328a);
        }
    }

    public static void m8511a(WakingExecutorService wakingExecutorService, WakingListenableScheduledFuture wakingListenableScheduledFuture) {
        synchronized (wakingExecutorService) {
            Object obj;
            Iterator it = wakingExecutorService.f8222i.iterator();
            while (it.hasNext()) {
                obj = (ScheduledTask) it.next();
                if (obj.f10328a == wakingListenableScheduledFuture) {
                    break;
                }
            }
            obj = null;
            if (obj != null) {
                wakingExecutorService.f8222i.remove(obj);
                wakingExecutorService.m8518b();
            }
        }
    }

    private static void m8512a(ImmutableList<WakingListenableScheduledFuture> immutableList) {
        Integer.valueOf(immutableList.size());
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ((WakingListenableScheduledFuture) immutableList.get(i)).run();
        }
    }

    private Runnable m8521c(Runnable runnable) {
        return LoggingRunnable.a(runnable, this.f8220g, "WakingExecutorService");
    }

    private <V> WakingListenableScheduledFuture<V> m8517b(Callable<V> callable, long j, TimeUnit timeUnit) {
        WakingListenableScheduledFuture wakingListenableScheduledFuture = new WakingListenableScheduledFuture(this, LoggingCallable.a(callable, this.f8220g, "WakingExecutorService"));
        m8509a(wakingListenableScheduledFuture, this.f8217d.now() + timeUnit.toMillis(j));
        return wakingListenableScheduledFuture;
    }
}
