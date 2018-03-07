package com.facebook.messaging.audio.record;

import android.net.Uri;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.DefaultSerialListeningExecutorService;
import com.facebook.orca.compose.VoiceClipKeyboardView.4;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Source;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.facebook.ui.media.attachments.MediaResourceBuilder;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;

@ThreadSafe
/* compiled from: optimisticStory */
public class AudioRecorderAsync {
    private final DefaultSerialListeningExecutorService f8103a;
    private final DefaultAndroidThreadUtil f8104b;
    public final AudioRecorder f8105c;
    private final Object f8106d = new Object();
    @GuardedBy("mQueueLock")
    private final Queue<Action> f8107e = Lists.b();
    private volatile State f8108f = State.OPEN;
    @GuardedBy("ui-thread")
    public 4 f8109g;

    /* compiled from: optimisticStory */
    class C09111 implements Runnable {
        final /* synthetic */ AudioRecorderAsync f8097a;

        C09111(AudioRecorderAsync audioRecorderAsync) {
            this.f8097a = audioRecorderAsync;
        }

        public void run() {
            AudioRecorderAsync.m8354f(this.f8097a);
        }
    }

    /* compiled from: optimisticStory */
    enum Action {
        START_RECORDING,
        STOP_RECORDING,
        FINISH_RECORDING,
        CANCEL_RECORDING
    }

    /* compiled from: optimisticStory */
    enum NotifyEventType {
        STARTED_RECORDING,
        STOPPING_RECORDING,
        STOPPED_RECORDING,
        ERROR,
        RESET
    }

    /* compiled from: optimisticStory */
    enum State {
        RECORDING,
        OPEN,
        MAXED_OUT
    }

    @Inject
    public AudioRecorderAsync(DefaultSerialListeningExecutorService defaultSerialListeningExecutorService, DefaultAndroidThreadUtil defaultAndroidThreadUtil, AudioRecorder audioRecorder) {
        this.f8103a = defaultSerialListeningExecutorService;
        this.f8104b = defaultAndroidThreadUtil;
        this.f8105c = audioRecorder;
    }

    public final void m8359b() {
        m8352b(Action.START_RECORDING);
    }

    public final void m8360c() {
        m8348a(Action.START_RECORDING);
        m8352b(Action.STOP_RECORDING);
    }

    public final void m8361d() {
        m8348a(Action.START_RECORDING);
        m8352b(Action.FINISH_RECORDING);
    }

    public final void m8362e() {
        m8348a(Action.START_RECORDING);
        m8352b(Action.CANCEL_RECORDING);
    }

    private void m8348a(Action action) {
        synchronized (this.f8106d) {
            Iterator it = this.f8107e.iterator();
            while (it.hasNext()) {
                if (((Action) it.next()) == action) {
                    it.remove();
                }
            }
        }
    }

    private void m8352b(Action action) {
        synchronized (this.f8106d) {
            this.f8107e.add(action);
            ExecutorDetour.a(this.f8103a, new C09111(this), 1674613417);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m8354f(com.facebook.messaging.audio.record.AudioRecorderAsync r2) {
        /*
    L_0x0000:
        r1 = r2.f8106d;
        monitor-enter(r1);
        r0 = r2.f8107e;	 Catch:{ all -> 0x0026 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0026 }
        if (r0 == 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r1);	 Catch:{ all -> 0x0026 }
        return;
    L_0x000d:
        r0 = r2.f8107e;	 Catch:{ all -> 0x0026 }
        r0 = r0.poll();	 Catch:{ all -> 0x0026 }
        r0 = (com.facebook.messaging.audio.record.AudioRecorderAsync.Action) r0;	 Catch:{ all -> 0x0026 }
        monitor-exit(r1);	 Catch:{ all -> 0x0026 }
        r1 = com.facebook.messaging.audio.record.AudioRecorderAsync.C09133.f8101a;
        r0 = r0.ordinal();
        r0 = r1[r0];
        switch(r0) {
            case 1: goto L_0x0022;
            case 2: goto L_0x0029;
            case 3: goto L_0x002d;
            case 4: goto L_0x0031;
            default: goto L_0x0021;
        };
    L_0x0021:
        goto L_0x0000;
    L_0x0022:
        r2.m8355g();
        goto L_0x0000;
    L_0x0026:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{  }
        throw r0;
    L_0x0029:
        r2.m8356h();
        goto L_0x0000;
    L_0x002d:
        r2.m8358j();
        goto L_0x0000;
    L_0x0031:
        r2.m8357i();
        goto L_0x0000;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.audio.record.AudioRecorderAsync.f(com.facebook.messaging.audio.record.AudioRecorderAsync):void");
    }

    private void m8355g() {
        if (this.f8108f == State.OPEN) {
            this.f8105c.a();
            this.f8108f = State.RECORDING;
            m8349a(NotifyEventType.STARTED_RECORDING);
            return;
        }
        m8351a(new IllegalStateException("Requested starting recording when camera wasn't open."));
    }

    private void m8356h() {
        if (this.f8108f == State.RECORDING) {
            this.f8105c.b();
            m8349a(NotifyEventType.STOPPING_RECORDING);
        }
    }

    private void m8357i() {
        if (this.f8108f == State.RECORDING) {
            this.f8105c.c();
            this.f8108f = State.OPEN;
            m8349a(NotifyEventType.STOPPED_RECORDING);
        }
    }

    private void m8358j() {
        if (this.f8108f == State.RECORDING) {
            Uri d = this.f8105c.d();
            long j = this.f8105c.j;
            this.f8108f = State.OPEN;
            if (d != null) {
                MediaResourceBuilder a = MediaResource.a();
                a.a = d;
                MediaResourceBuilder mediaResourceBuilder = a;
                mediaResourceBuilder.b = Type.AUDIO;
                mediaResourceBuilder = mediaResourceBuilder;
                mediaResourceBuilder.c = Source.UNSPECIFIED;
                mediaResourceBuilder = mediaResourceBuilder;
                mediaResourceBuilder.g = j;
                mediaResourceBuilder = mediaResourceBuilder;
                mediaResourceBuilder.m = "audio/mpeg";
                m8350a(NotifyEventType.STOPPED_RECORDING, mediaResourceBuilder.C());
            }
        }
    }

    private void m8349a(NotifyEventType notifyEventType) {
        m8350a(notifyEventType, null);
    }

    private void m8351a(Throwable th) {
        m8350a(NotifyEventType.ERROR, th);
    }

    private void m8350a(final NotifyEventType notifyEventType, @Nullable final Object obj) {
        this.f8104b.b(new Runnable(this) {
            final /* synthetic */ AudioRecorderAsync f8100c;

            public void run() {
                AudioRecorderAsync.m8353b(this.f8100c, notifyEventType, obj);
            }
        });
    }

    public static void m8353b(AudioRecorderAsync audioRecorderAsync, NotifyEventType notifyEventType, Object obj) {
        audioRecorderAsync.f8104b.a();
        if (audioRecorderAsync.f8109g != null) {
            switch (notifyEventType) {
                case STARTED_RECORDING:
                    audioRecorderAsync.f8109g.a();
                    return;
                case STOPPING_RECORDING:
                    audioRecorderAsync.f8109g.b();
                    return;
                case STOPPED_RECORDING:
                    audioRecorderAsync.f8109g.a((MediaResource) obj);
                    return;
                default:
                    return;
            }
        }
    }
}
