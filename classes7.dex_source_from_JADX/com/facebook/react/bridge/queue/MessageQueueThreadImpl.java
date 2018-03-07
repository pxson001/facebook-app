package com.facebook.react.bridge.queue;

import android.os.Looper;
import com.facebook.common.logging.FLog;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.futures.SimpleSettableFuture;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.tools.dextr.runtime.detour.ThreadInitDetour;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

@DoNotStrip
/* compiled from: get_notified_click */
public class MessageQueueThreadImpl implements MessageQueueThread {
    public final String f11558a;
    public final Looper f11559b;
    private final MessageQueueThreadHandler f11560c;
    private final String f11561d;
    private volatile boolean f11562e = false;

    /* compiled from: get_notified_click */
    final class C10192 implements Runnable {
        final /* synthetic */ MessageQueueThreadImpl f11554a;

        C10192(MessageQueueThreadImpl messageQueueThreadImpl) {
            this.f11554a = messageQueueThreadImpl;
        }

        public final void run() {
            MessageQueueThreadRegistry.m13570a(this.f11554a);
        }
    }

    /* compiled from: get_notified_click */
    final class C10203 implements Runnable {
        final /* synthetic */ SimpleSettableFuture f11555a;
        final /* synthetic */ SimpleSettableFuture f11556b;

        C10203(SimpleSettableFuture simpleSettableFuture, SimpleSettableFuture simpleSettableFuture2) {
            this.f11555a = simpleSettableFuture;
            this.f11556b = simpleSettableFuture2;
        }

        public final void run() {
            Looper.prepare();
            this.f11555a.m13617a(Looper.myLooper());
            MessageQueueThreadRegistry.m13570a((MessageQueueThread) this.f11556b.m13615a());
            Looper.loop();
        }
    }

    private MessageQueueThreadImpl(String str, Looper looper, QueueThreadExceptionHandler queueThreadExceptionHandler) {
        this.f11558a = str;
        this.f11559b = looper;
        this.f11560c = new MessageQueueThreadHandler(looper, queueThreadExceptionHandler);
        this.f11561d = "Expected to be called from the '" + this.f11558a + "' thread!";
    }

    @DoNotStrip
    public void runOnQueue(Runnable runnable) {
        if (this.f11562e) {
            FLog.a("React", "Tried to enqueue runnable on already finished thread: '" + this.f11558a + "... dropping Runnable.");
        }
        HandlerDetour.a(this.f11560c, runnable, -1093141153);
    }

    @DoNotStrip
    public <T> Future<T> callOnQueue(final Callable<T> callable) {
        final Future simpleSettableFuture = new SimpleSettableFuture();
        runOnQueue(new Runnable(this) {
            final /* synthetic */ MessageQueueThreadImpl f11553c;

            public void run() {
                try {
                    simpleSettableFuture.m13617a(callable.call());
                } catch (Exception e) {
                    simpleSettableFuture.m13616a(e);
                }
            }
        });
        return simpleSettableFuture;
    }

    @DoNotStrip
    public boolean isOnThread() {
        return this.f11559b.getThread() == Thread.currentThread();
    }

    @DoNotStrip
    public void assertIsOnThread() {
        SoftAssertions.m13551a(isOnThread(), this.f11561d);
    }

    @DoNotStrip
    public void quitSynchronous() {
        this.f11562e = true;
        this.f11559b.quit();
        if (this.f11559b.getThread() != Thread.currentThread()) {
            try {
                this.f11559b.getThread().join();
            } catch (InterruptedException e) {
                throw new RuntimeException("Got interrupted waiting to join thread " + this.f11558a);
            }
        }
    }

    public final Looper m13569a() {
        return this.f11559b;
    }

    private String m13568b() {
        return this.f11558a;
    }

    public static MessageQueueThreadImpl m13564a(MessageQueueThreadSpec messageQueueThreadSpec, QueueThreadExceptionHandler queueThreadExceptionHandler) {
        switch (messageQueueThreadSpec.f11565b) {
            case MAIN_UI:
                return m13567b(messageQueueThreadSpec.f11566c, queueThreadExceptionHandler);
            case NEW_BACKGROUND:
                return m13565a(messageQueueThreadSpec.f11566c, messageQueueThreadSpec.f11567d, queueThreadExceptionHandler);
            default:
                throw new RuntimeException("Unknown thread type: " + messageQueueThreadSpec.f11565b);
        }
    }

    private static MessageQueueThreadImpl m13567b(String str, QueueThreadExceptionHandler queueThreadExceptionHandler) {
        MessageQueueThreadImpl messageQueueThreadImpl = new MessageQueueThreadImpl(str, Looper.getMainLooper(), queueThreadExceptionHandler);
        if (UiThreadUtil.m13553a()) {
            MessageQueueThreadRegistry.m13570a(messageQueueThreadImpl);
        } else {
            UiThreadUtil.m13552a(new C10192(messageQueueThreadImpl));
        }
        return messageQueueThreadImpl;
    }

    public static MessageQueueThreadImpl m13566a(String str, QueueThreadExceptionHandler queueThreadExceptionHandler) {
        return m13565a(str, 0, queueThreadExceptionHandler);
    }

    private static MessageQueueThreadImpl m13565a(String str, long j, QueueThreadExceptionHandler queueThreadExceptionHandler) {
        SimpleSettableFuture simpleSettableFuture = new SimpleSettableFuture();
        SimpleSettableFuture simpleSettableFuture2 = new SimpleSettableFuture();
        ThreadInitDetour.a(null, new C10203(simpleSettableFuture, simpleSettableFuture2), "mqt_" + str, j, -23095409).start();
        Object messageQueueThreadImpl = new MessageQueueThreadImpl(str, (Looper) simpleSettableFuture.m13615a(), queueThreadExceptionHandler);
        simpleSettableFuture2.m13617a(messageQueueThreadImpl);
        return messageQueueThreadImpl;
    }
}
