package com.facebook.presence;

import com.facebook.common.time.Clock;
import com.facebook.inject.Assisted;
import com.facebook.presence.TypingPresenceManager.TypingState;
import com.google.common.base.Strings;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;

/* compiled from: impressions */
public class CommentTypingContext {
    private final TypingPresenceManager f11143a;
    private final ScheduledExecutorService f11144b;
    private final Clock f11145c;
    public final String f11146d;
    private final Runnable f11147e = new C09841(this);
    private final Runnable f11148f = new C09852(this);
    @GuardedBy("this")
    private ScheduledFuture f11149g;
    @GuardedBy("this")
    private ScheduledFuture f11150h;
    @GuardedBy("this")
    private long f11151i;

    /* compiled from: impressions */
    class C09841 implements Runnable {
        final /* synthetic */ CommentTypingContext f11141a;

        C09841(CommentTypingContext commentTypingContext) {
            this.f11141a = commentTypingContext;
        }

        public void run() {
            CommentTypingContext.m13077e(this.f11141a);
        }
    }

    /* compiled from: impressions */
    class C09852 implements Runnable {
        final /* synthetic */ CommentTypingContext f11142a;

        C09852(CommentTypingContext commentTypingContext) {
            this.f11142a = commentTypingContext;
        }

        public void run() {
            CommentTypingContext.m13078f(this.f11142a);
        }
    }

    @Inject
    public CommentTypingContext(TypingPresenceManager typingPresenceManager, ScheduledExecutorService scheduledExecutorService, Clock clock, @Assisted String str) {
        this.f11143a = typingPresenceManager;
        this.f11144b = scheduledExecutorService;
        this.f11145c = clock;
        this.f11146d = str;
    }

    public final synchronized void m13079b() {
        if (m13076d()) {
            if (this.f11149g == null || this.f11149g.isDone()) {
                this.f11149g = this.f11144b.schedule(this.f11147e, Math.max(0, 10000 - (this.f11145c.a() - this.f11151i)), TimeUnit.MILLISECONDS);
            }
            if (this.f11150h != null) {
                this.f11150h.cancel(false);
            }
            this.f11150h = this.f11144b.schedule(this.f11148f, 10000, TimeUnit.MILLISECONDS);
        }
    }

    public final synchronized void m13080c() {
        if (m13076d()) {
            if (this.f11149g != null) {
                this.f11149g.cancel(false);
            }
            if (this.f11150h != null) {
                this.f11150h.cancel(false);
            }
            this.f11150h = this.f11144b.schedule(this.f11148f, 0, TimeUnit.MILLISECONDS);
        }
    }

    private boolean m13076d() {
        return !Strings.isNullOrEmpty(this.f11146d);
    }

    public static void m13077e(CommentTypingContext commentTypingContext) {
        synchronized (commentTypingContext) {
            commentTypingContext.f11151i = commentTypingContext.f11145c.a();
        }
        commentTypingContext.f11143a.mo616a(commentTypingContext.f11146d, TypingState.ACTIVE);
    }

    public static void m13078f(CommentTypingContext commentTypingContext) {
        synchronized (commentTypingContext) {
            commentTypingContext.f11151i = 0;
            if (commentTypingContext.f11149g != null) {
                commentTypingContext.f11149g.cancel(false);
            }
        }
        commentTypingContext.f11143a.mo616a(commentTypingContext.f11146d, TypingState.INACTIVE);
    }
}
