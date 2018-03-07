package com.facebook.common.futures;

import com.facebook.common.util.Tuple;
import java.util.Queue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: split_flow_use_post */
public abstract class DelayedAbstractDisposableFutureCallback<T> implements DisposableFutureCallback<T> {
    private volatile boolean f2596a;
    private boolean f2597b = false;
    private Queue<CallbackTuple> f2598c;

    /* compiled from: split_flow_use_post */
    abstract class CallbackTuple<T0, T1> extends Tuple<T0, T1> {
        final /* synthetic */ DelayedAbstractDisposableFutureCallback f2593c;

        public CallbackTuple(DelayedAbstractDisposableFutureCallback delayedAbstractDisposableFutureCallback, T0 t0, T1 t1) {
            this.f2593c = delayedAbstractDisposableFutureCallback;
            super(t0, t1);
        }
    }

    /* compiled from: split_flow_use_post */
    enum CallbackType {
        SUCCESS,
        FAILURE
    }

    /* compiled from: split_flow_use_post */
    class FailedCallbackTupleWrapper extends CallbackTuple<CallbackType, Throwable> {
        final /* synthetic */ DelayedAbstractDisposableFutureCallback f2594d;

        public FailedCallbackTupleWrapper(DelayedAbstractDisposableFutureCallback delayedAbstractDisposableFutureCallback, Throwable th) {
            this.f2594d = delayedAbstractDisposableFutureCallback;
            super(delayedAbstractDisposableFutureCallback, CallbackType.FAILURE, th);
        }
    }

    /* compiled from: split_flow_use_post */
    class SuccessfulCallbackTupleWrapper extends CallbackTuple<CallbackType, T> {
        final /* synthetic */ DelayedAbstractDisposableFutureCallback f2595d;

        public SuccessfulCallbackTupleWrapper(DelayedAbstractDisposableFutureCallback delayedAbstractDisposableFutureCallback, T t) {
            this.f2595d = delayedAbstractDisposableFutureCallback;
            super(delayedAbstractDisposableFutureCallback, CallbackType.SUCCESS, t);
        }
    }

    protected abstract void m3698a(T t);

    protected abstract void m3699a(Throwable th);

    private void m3697a(CallbackTuple callbackTuple) {
        if (this.f2598c == null) {
            this.f2598c = new LinkedBlockingQueue();
        }
        this.f2598c.add(callbackTuple);
    }

    public final void jc_() {
        this.f2596a = true;
        if (this.f2598c != null) {
            this.f2598c.clear();
        }
    }

    public final boolean ba_() {
        return this.f2596a;
    }

    public final void onSuccess(T t) {
        if (!this.f2596a) {
            if (this.f2597b) {
                m3698a((Object) t);
            } else {
                m3697a(new SuccessfulCallbackTupleWrapper(this, t));
            }
        }
    }

    public final void onFailure(Throwable th) {
        if (!this.f2596a) {
            if (!this.f2597b) {
                m3697a(new FailedCallbackTupleWrapper(this, th));
            } else if (!(th instanceof CancellationException)) {
                m3699a(th);
            }
        }
    }

    public final void m3700b() {
        this.f2597b = true;
        if (this.f2598c != null) {
            synchronized (this.f2598c) {
                for (CallbackTuple callbackTuple : this.f2598c) {
                    if (callbackTuple.f2591a == CallbackType.SUCCESS) {
                        onSuccess(callbackTuple.f2592b);
                    } else if (callbackTuple.f2591a == CallbackType.FAILURE) {
                        onFailure((Throwable) callbackTuple.f2592b);
                    }
                }
            }
        }
    }
}
