package android.support.v4.content;

import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.tools.dextr.runtime.detour.ThreadInitDetour;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: estimated_delivery_display_time */
public abstract class ModernAsyncTask<Params, Progress, Result> {
    private static final ThreadFactory f12765a = new C06051();
    private static final BlockingQueue<Runnable> f12766b = new LinkedBlockingQueue(10);
    private static final InternalHandler f12767c = new InternalHandler();
    public static final Executor f12768d = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, f12766b, f12765a);
    private static volatile Executor f12769e = f12768d;
    private final WorkerRunnable<Params, Result> f12770f = new C06062(this);
    public final FutureTask<Result> f12771g = new FutureTask<Result>(this, this.f12770f) {
        final /* synthetic */ ModernAsyncTask f12777a;

        protected void done() {
            try {
                ModernAsyncTask.m13639b(this.f12777a, FutureDetour.a(this, 1283665672));
            } catch (Throwable e) {
                Log.w("AsyncTask", e);
            } catch (ExecutionException e2) {
                throw new RuntimeException("An error occured while executing doInBackground()", e2.getCause());
            } catch (CancellationException e3) {
                ModernAsyncTask.m13639b(this.f12777a, null);
            } catch (Throwable e4) {
                RuntimeException runtimeException = new RuntimeException("An error occured while executing doInBackground()", e4);
            }
        }
    };
    public volatile Status f12772h = Status.PENDING;
    public final AtomicBoolean f12773i = new AtomicBoolean();

    /* compiled from: estimated_delivery_display_time */
    final class C06051 implements ThreadFactory {
        private final AtomicInteger f12774a = new AtomicInteger(1);

        C06051() {
        }

        public final Thread newThread(Runnable runnable) {
            return ThreadInitDetour.a(runnable, "ModernAsyncTask #" + this.f12774a.getAndIncrement(), 1231789939);
        }
    }

    /* compiled from: estimated_delivery_display_time */
    class InternalHandler extends Handler {
        public void handleMessage(Message message) {
            AsyncTaskResult asyncTaskResult = (AsyncTaskResult) message.obj;
            switch (message.what) {
                case 1:
                    ModernAsyncTask modernAsyncTask = asyncTaskResult.f12788a;
                    Object obj = asyncTaskResult.f12789b[0];
                    if (modernAsyncTask.f12771g.isCancelled()) {
                        modernAsyncTask.mo928a();
                    } else {
                        modernAsyncTask.mo929a(obj);
                    }
                    modernAsyncTask.f12772h = Status.FINISHED;
                    return;
                case 2:
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: estimated_delivery_display_time */
    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* compiled from: estimated_delivery_display_time */
    class C06062 extends WorkerRunnable<Params, Result> {
        final /* synthetic */ ModernAsyncTask f12775a;

        C06062(ModernAsyncTask modernAsyncTask) {
            this.f12775a = modernAsyncTask;
        }

        public Result call() {
            this.f12775a.f12773i.set(true);
            Process.setThreadPriority(10);
            return ModernAsyncTask.m13640c(this.f12775a, this.f12775a.mo927a(this.f12776b));
        }
    }

    /* compiled from: estimated_delivery_display_time */
    public abstract class WorkerRunnable<Params, Result> implements Callable<Result> {
        Params[] f12776b;
    }

    /* compiled from: estimated_delivery_display_time */
    class AsyncTaskResult<Data> {
        final ModernAsyncTask f12788a;
        final Data[] f12789b;

        AsyncTaskResult(ModernAsyncTask modernAsyncTask, Data... dataArr) {
            this.f12788a = modernAsyncTask;
            this.f12789b = dataArr;
        }
    }

    protected abstract Result mo927a(Params... paramsArr);

    public static void m13639b(ModernAsyncTask modernAsyncTask, Object obj) {
        if (!modernAsyncTask.f12773i.get()) {
            m13640c(modernAsyncTask, obj);
        }
    }

    public static Object m13640c(ModernAsyncTask modernAsyncTask, Object obj) {
        f12767c.obtainMessage(1, new AsyncTaskResult(modernAsyncTask, obj)).sendToTarget();
        return obj;
    }

    protected void m13645b() {
    }

    public void mo929a(Result result) {
    }

    public void mo928a() {
    }

    public final ModernAsyncTask<Params, Progress, Result> m13641a(Executor executor, Params... paramsArr) {
        if (this.f12772h != Status.PENDING) {
            switch (4.a[this.f12772h.ordinal()]) {
                case 1:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case 2:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.f12772h = Status.RUNNING;
        m13645b();
        this.f12770f.f12776b = paramsArr;
        ExecutorDetour.a(executor, this.f12771g, 1760635575);
        return this;
    }
}
