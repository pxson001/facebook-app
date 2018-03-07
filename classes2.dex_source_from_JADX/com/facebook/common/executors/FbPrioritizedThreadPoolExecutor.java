package com.facebook.common.executors;

import com.facebook.common.executors.PrioritizedExecutorService.TaskPriority;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ExecutionList;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: page */
public class FbPrioritizedThreadPoolExecutor extends AbstractExecutorService implements PrioritizedExecutorService {
    private final Executor f10610a = new C04481(this);
    private final Executor f10611b = new C04492(this);
    private final Executor f10612c = new C04503(this);
    private final Executor f10613d;

    /* compiled from: page */
    class C04481 implements Executor {
        final /* synthetic */ FbPrioritizedThreadPoolExecutor f10614a;

        C04481(FbPrioritizedThreadPoolExecutor fbPrioritizedThreadPoolExecutor) {
            this.f10614a = fbPrioritizedThreadPoolExecutor;
        }

        public void execute(Runnable runnable) {
            this.f10614a.m15804a(TaskPriority.LOW, runnable);
        }
    }

    /* compiled from: page */
    class C04492 implements Executor {
        final /* synthetic */ FbPrioritizedThreadPoolExecutor f10615a;

        C04492(FbPrioritizedThreadPoolExecutor fbPrioritizedThreadPoolExecutor) {
            this.f10615a = fbPrioritizedThreadPoolExecutor;
        }

        public void execute(Runnable runnable) {
            this.f10615a.m15804a(TaskPriority.NORMAL, runnable);
        }
    }

    /* compiled from: page */
    class C04503 implements Executor {
        final /* synthetic */ FbPrioritizedThreadPoolExecutor f10616a;

        C04503(FbPrioritizedThreadPoolExecutor fbPrioritizedThreadPoolExecutor) {
            this.f10616a = fbPrioritizedThreadPoolExecutor;
        }

        public void execute(Runnable runnable) {
            this.f10616a.m15804a(TaskPriority.HIGH, runnable);
        }
    }

    /* compiled from: page */
    class PriorityComparator implements Comparator<Runnable> {
        public int compare(Object obj, Object obj2) {
            Runnable runnable = (Runnable) obj2;
            return m15807a(runnable).ordinal() - m15807a((Runnable) obj).ordinal();
        }

        private static TaskPriority m15807a(Runnable runnable) {
            if (runnable instanceof ListenablePrioritizedRunnableFuture) {
                return ((ListenablePrioritizedRunnableFuture) runnable).f14677a;
            }
            return TaskPriority.NORMAL;
        }
    }

    /* compiled from: page */
    /* synthetic */ class C04554 {
        static final /* synthetic */ int[] f10622a = new int[TaskPriority.values().length];

        static {
            try {
                f10622a[TaskPriority.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f10622a[TaskPriority.HIGH.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f10622a[TaskPriority.NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* compiled from: page */
    public class ListenablePrioritizedRunnableFuture<T> extends FutureTask<T> implements ListenableFuture<T> {
        public final TaskPriority f14677a;
        private final ExecutionList f14678b = new ExecutionList();

        public ListenablePrioritizedRunnableFuture(Runnable runnable, TaskPriority taskPriority) {
            super(runnable, null);
            this.f14677a = taskPriority;
        }

        public final void mo223a(Runnable runnable, Executor executor) {
            this.f14678b.m1746a(runnable, executor);
        }

        protected void done() {
            super.done();
            this.f14678b.m1745a();
        }
    }

    private static BlockingQueue<Runnable> m15803a() {
        return new PriorityBlockingQueue(11, new PriorityComparator());
    }

    public FbPrioritizedThreadPoolExecutor(String str, int i, Executor executor, BackgroundWorkLogger backgroundWorkLogger, ConstrainedExecutorsStatusController constrainedExecutorsStatusController) {
        this.f10613d = new DefaultConstrainedListeningExecutorService(str, i, executor, m15803a(), backgroundWorkLogger, constrainedExecutorsStatusController);
    }

    public final ListenableFuture<?> m15804a(TaskPriority taskPriority, Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        ListenablePrioritizedRunnableFuture listenablePrioritizedRunnableFuture = new ListenablePrioritizedRunnableFuture(runnable, taskPriority);
        ExecutorDetour.a(this, listenablePrioritizedRunnableFuture, -609831878);
        return listenablePrioritizedRunnableFuture;
    }

    public void execute(Runnable runnable) {
        ExecutorDetour.a(this.f10613d, runnable, -356163457);
    }

    public final Executor mo2027a(TaskPriority taskPriority) {
        switch (C04554.f10622a[taskPriority.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return this.f10610a;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return this.f10612c;
            default:
                return this.f10611b;
        }
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
}
