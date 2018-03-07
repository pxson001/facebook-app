package com.facebook.presence;

import com.facebook.common.time.Clock;
import com.facebook.inject.Assisted;
import com.facebook.presence.TypingPresenceManager.TypingState;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserKey;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;

/* compiled from: immersive_react_fragment_start_react_application */
public class ConversationTypingContext {
    private final TypingPresenceManager f11157a;
    private final ScheduledExecutorService f11158b;
    private final Clock f11159c;
    private final UserKey f11160d;
    private final Runnable f11161e = new C09871(this);
    private final Runnable f11162f = new C09882(this);
    @GuardedBy("this")
    private ScheduledFuture f11163g;
    @GuardedBy("this")
    private ScheduledFuture f11164h;
    @GuardedBy("this")
    private long f11165i;

    /* compiled from: immersive_react_fragment_start_react_application */
    class C09871 implements Runnable {
        final /* synthetic */ ConversationTypingContext f11155a;

        C09871(ConversationTypingContext conversationTypingContext) {
            this.f11155a = conversationTypingContext;
        }

        public void run() {
            ConversationTypingContext.m13087d(this.f11155a);
        }
    }

    /* compiled from: immersive_react_fragment_start_react_application */
    class C09882 implements Runnable {
        final /* synthetic */ ConversationTypingContext f11156a;

        C09882(ConversationTypingContext conversationTypingContext) {
            this.f11156a = conversationTypingContext;
        }

        public void run() {
            ConversationTypingContext.m13088e(this.f11156a);
        }
    }

    @Inject
    public ConversationTypingContext(TypingPresenceManager typingPresenceManager, ScheduledExecutorService scheduledExecutorService, Clock clock, @Assisted UserKey userKey) {
        this.f11157a = typingPresenceManager;
        this.f11158b = scheduledExecutorService;
        this.f11159c = clock;
        this.f11160d = userKey;
    }

    public final synchronized void m13089a() {
        if (m13086c()) {
            if (this.f11163g == null || this.f11163g.isDone()) {
                this.f11163g = this.f11158b.schedule(this.f11161e, Math.max(0, 10000 - (this.f11159c.a() - this.f11165i)), TimeUnit.MILLISECONDS);
            }
            if (this.f11164h != null) {
                this.f11164h.cancel(false);
            }
            this.f11164h = this.f11158b.schedule(this.f11162f, 10000, TimeUnit.MILLISECONDS);
        }
    }

    public final synchronized void m13090b() {
        if (m13086c()) {
            if (this.f11163g != null) {
                this.f11163g.cancel(false);
            }
            if (this.f11164h != null) {
                this.f11164h.cancel(false);
            }
            this.f11164h = this.f11158b.schedule(this.f11162f, 0, TimeUnit.MILLISECONDS);
        }
    }

    private boolean m13086c() {
        return this.f11160d != null && this.f11160d.a() == Type.FACEBOOK;
    }

    public static void m13087d(ConversationTypingContext conversationTypingContext) {
        synchronized (conversationTypingContext) {
            conversationTypingContext.f11165i = conversationTypingContext.f11159c.a();
        }
        conversationTypingContext.f11157a.mo616a(conversationTypingContext.f11160d.b(), TypingState.ACTIVE);
    }

    public static void m13088e(ConversationTypingContext conversationTypingContext) {
        synchronized (conversationTypingContext) {
            conversationTypingContext.f11165i = 0;
            if (conversationTypingContext.f11163g != null) {
                conversationTypingContext.f11163g.cancel(false);
            }
        }
        conversationTypingContext.f11157a.mo616a(conversationTypingContext.f11160d.b(), TypingState.INACTIVE);
    }
}
