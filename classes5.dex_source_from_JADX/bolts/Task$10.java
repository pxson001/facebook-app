package bolts;

import bolts.Task.TaskCompletionSource;

/* compiled from: bd_profile_button */
final class Task$10 implements Runnable {
    final /* synthetic */ Continuation f7986a;
    final /* synthetic */ Task f7987b;
    final /* synthetic */ TaskCompletionSource f7988c;

    /* compiled from: bd_profile_button */
    class C09011 implements Continuation<TContinuationResult, Void> {
        final /* synthetic */ Task$10 f7985a;

        C09011(Task$10 task$10) {
            this.f7985a = task$10;
        }

        public final Object m14121a(Task task) {
            if (task.a()) {
                this.f7985a.f7988c.b();
            } else if (task.b()) {
                this.f7985a.f7988c.a(task.d());
            } else {
                this.f7985a.f7988c.a(task.c());
            }
            return null;
        }
    }

    Task$10(Continuation continuation, Task task, TaskCompletionSource taskCompletionSource) {
        this.f7986a = continuation;
        this.f7987b = task;
        this.f7988c = taskCompletionSource;
    }

    public final void run() {
        try {
            Task task = (Task) this.f7986a.a(this.f7987b);
            if (task == null) {
                this.f7988c.a(null);
            } else {
                task.a(new C09011(this));
            }
        } catch (Exception e) {
            this.f7988c.a(e);
        }
    }
}
