package bolts;

import bolts.Task.TaskCompletionSource;
import java.util.concurrent.Executor;

/* compiled from: bd_profile_button */
class Task$6 implements Continuation<TResult, Void> {
    final /* synthetic */ TaskCompletionSource f7989a;
    final /* synthetic */ Continuation f7990b;
    final /* synthetic */ Executor f7991c;
    final /* synthetic */ Task f7992d;

    Task$6(Task task, TaskCompletionSource taskCompletionSource, Continuation continuation, Executor executor) {
        this.f7992d = task;
        this.f7989a = taskCompletionSource;
        this.f7990b = continuation;
        this.f7991c = executor;
    }

    public final Object m14122a(Task task) {
        Task.d(this.f7989a, this.f7990b, task, this.f7991c);
        return null;
    }
}
