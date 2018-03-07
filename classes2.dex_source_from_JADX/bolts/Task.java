package bolts;

import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.ObjectDetour;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* compiled from: measurement.upload.window_interval */
public class Task<TResult> {
    public static final ExecutorService f14656a = BoltsExecutors.m21089a();
    public static final Executor f14657b = AndroidExecutors.f14670c.f14672d;
    private static final Executor f14658c = BoltsExecutors.f14665a.f14667c;
    public final Object f14659d = new Object();
    public boolean f14660e;
    private boolean f14661f;
    private TResult f14662g;
    private Exception f14663h;
    private List<Continuation<TResult, Void>> f14664i = new ArrayList();

    /* compiled from: measurement.upload.window_interval */
    public class TaskCompletionSource {
        public final /* synthetic */ Task f14674a;

        public TaskCompletionSource(Task task) {
            this.f14674a = task;
        }

        public final Task<TResult> m21095a() {
            return this.f14674a;
        }

        private boolean m21094c() {
            boolean z = true;
            synchronized (this.f14674a.f14659d) {
                if (this.f14674a.f14660e) {
                    z = false;
                } else {
                    this.f14674a.f14660e = true;
                    this.f14674a.f14661f = true;
                    ObjectDetour.c(this.f14674a.f14659d, -1115782428);
                    Task.m21082g(this.f14674a);
                }
            }
            return z;
        }

        private boolean m21093b(TResult tResult) {
            boolean z = true;
            synchronized (this.f14674a.f14659d) {
                if (this.f14674a.f14660e) {
                    z = false;
                } else {
                    this.f14674a.f14660e = true;
                    this.f14674a.f14662g = tResult;
                    ObjectDetour.c(this.f14674a.f14659d, 1779456021);
                    Task.m21082g(this.f14674a);
                }
            }
            return z;
        }

        private boolean m21092b(Exception exception) {
            boolean z = true;
            synchronized (this.f14674a.f14659d) {
                if (this.f14674a.f14660e) {
                    z = false;
                } else {
                    this.f14674a.f14660e = true;
                    this.f14674a.f14663h = exception;
                    ObjectDetour.c(this.f14674a.f14659d, -1618586337);
                    Task.m21082g(this.f14674a);
                }
            }
            return z;
        }

        public final void m21098b() {
            if (!m21094c()) {
                throw new IllegalStateException("Cannot cancel a completed task.");
            }
        }

        public final void m21097a(TResult tResult) {
            if (!m21093b((Object) tResult)) {
                throw new IllegalStateException("Cannot set the result of a completed task.");
            }
        }

        public final void m21096a(Exception exception) {
            if (!m21092b(exception)) {
                throw new IllegalStateException("Cannot set the error on a completed task.");
            }
        }
    }

    /* compiled from: measurement.upload.window_interval */
    final class C06212 implements Runnable {
        final /* synthetic */ TaskCompletionSource f14675a;
        final /* synthetic */ Callable f14676b;

        C06212(TaskCompletionSource taskCompletionSource, Callable callable) {
            this.f14675a = taskCompletionSource;
            this.f14676b = callable;
        }

        public final void run() {
            try {
                this.f14675a.m21097a(this.f14676b.call());
            } catch (Exception e) {
                this.f14675a.m21096a(e);
            }
        }
    }

    /* compiled from: measurement.upload.window_interval */
    final class C06269 implements Runnable {
        final /* synthetic */ Continuation f14701a;
        final /* synthetic */ Task f14702b;
        final /* synthetic */ TaskCompletionSource f14703c;

        C06269(Continuation continuation, Task task, TaskCompletionSource taskCompletionSource) {
            this.f14701a = continuation;
            this.f14702b = task;
            this.f14703c = taskCompletionSource;
        }

        public final void run() {
            try {
                this.f14703c.m21097a(this.f14701a.mo2823a(this.f14702b));
            } catch (Exception e) {
                this.f14703c.m21096a(e);
            }
        }
    }

    private Task() {
    }

    private static <TResult> TaskCompletionSource m21080e() {
        Task task = new Task();
        task.getClass();
        return new TaskCompletionSource(task);
    }

    private boolean m21081f() {
        boolean z;
        synchronized (this.f14659d) {
            z = this.f14660e;
        }
        return z;
    }

    public final boolean m21084a() {
        boolean z;
        synchronized (this.f14659d) {
            z = this.f14661f;
        }
        return z;
    }

    public final boolean m21086b() {
        boolean z;
        synchronized (this.f14659d) {
            z = this.f14663h != null;
        }
        return z;
    }

    public final TResult m21087c() {
        TResult tResult;
        synchronized (this.f14659d) {
            tResult = this.f14662g;
        }
        return tResult;
    }

    public final Exception m21088d() {
        Exception exception;
        synchronized (this.f14659d) {
            exception = this.f14663h;
        }
        return exception;
    }

    public static <TResult> Task<TResult> m21071a(TResult tResult) {
        TaskCompletionSource e = m21080e();
        e.m21097a((Object) tResult);
        return e.f14674a;
    }

    public static <TResult> Task<TResult> m21070a(Exception exception) {
        TaskCompletionSource e = m21080e();
        e.m21096a(exception);
        return e.f14674a;
    }

    public static <TResult> Task<TResult> m21072a(Callable<TResult> callable, Executor executor) {
        TaskCompletionSource e = m21080e();
        ExecutorDetour.a(executor, new C06212(e, callable), -1509831827);
        return e.f14674a;
    }

    private <TContinuationResult> Task<TContinuationResult> m21069a(final Continuation<TResult, TContinuationResult> continuation, final Executor executor) {
        final TaskCompletionSource e = m21080e();
        synchronized (this.f14659d) {
            boolean f = m21081f();
            if (!f) {
                this.f14664i.add(new Continuation<TResult, Void>(this) {
                    final /* synthetic */ Task f14689d;

                    public final Object mo2823a(Task task) {
                        Task.m21078c(e, continuation, task, executor);
                        return null;
                    }
                });
            }
        }
        if (f) {
            m21078c(e, continuation, this, executor);
        }
        return e.m21095a();
    }

    public final <TContinuationResult> Task<TContinuationResult> m21083a(Continuation<TResult, TContinuationResult> continuation) {
        return m21069a((Continuation) continuation, f14658c);
    }

    private <TContinuationResult> Task<TContinuationResult> m21076b(Continuation<TResult, Task<TContinuationResult>> continuation, Executor executor) {
        TaskCompletionSource e = m21080e();
        synchronized (this.f14659d) {
            boolean f = m21081f();
            if (!f) {
                this.f14664i.add(new 6(this, e, continuation, executor));
            }
        }
        if (f) {
            m21079d(e, continuation, this, executor);
        }
        return e.m21095a();
    }

    public final <TContinuationResult> Task<TContinuationResult> m21085b(Continuation<TResult, Task<TContinuationResult>> continuation) {
        return m21076b((Continuation) continuation, f14658c);
    }

    public static <TContinuationResult, TResult> void m21078c(TaskCompletionSource taskCompletionSource, Continuation<TResult, TContinuationResult> continuation, Task<TResult> task, Executor executor) {
        ExecutorDetour.a(executor, new C06269(continuation, task, taskCompletionSource), 1389851533);
    }

    public static <TContinuationResult, TResult> void m21079d(TaskCompletionSource taskCompletionSource, Continuation<TResult, Task<TContinuationResult>> continuation, Task<TResult> task, Executor executor) {
        ExecutorDetour.a(executor, new 10(continuation, task, taskCompletionSource), 78405221);
    }

    public static void m21082g(Task task) {
        synchronized (task.f14659d) {
            for (Continuation a : task.f14664i) {
                try {
                    a.mo2823a(task);
                } catch (RuntimeException e) {
                    throw e;
                } catch (Throwable e2) {
                    throw new RuntimeException(e2);
                }
            }
            task.f14664i = null;
        }
    }
}
