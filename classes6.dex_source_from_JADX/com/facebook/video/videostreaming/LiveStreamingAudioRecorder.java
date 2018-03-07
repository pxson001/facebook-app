package com.facebook.video.videostreaming;

import android.annotation.TargetApi;
import android.media.AudioRecord;
import com.facebook.debug.log.BLog;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

@TargetApi(18)
/* compiled from: saved_state */
public class LiveStreamingAudioRecorder {
    private static final Class<?> f5341b = LiveStreamingAudioRecorder.class;
    AudioRecord f5342a;
    public AtomicBoolean f5343c;
    private Future<?> f5344d;
    public ArrayList<LiveStreamingEncoder> f5345e = new ArrayList();
    private ExecutorService f5346f;

    /* compiled from: saved_state */
    class C03281 implements Runnable {
        final /* synthetic */ LiveStreamingAudioRecorder f5340a;

        C03281(LiveStreamingAudioRecorder liveStreamingAudioRecorder) {
            this.f5340a = liveStreamingAudioRecorder;
        }

        public void run() {
            while (!this.f5340a.f5343c.get()) {
                byte[] bArr = new byte[4096];
                int read = this.f5340a.f5342a.read(bArr, 0, 4096);
                int size = this.f5340a.f5345e.size();
                for (int i = 0; i < size; i++) {
                    ((LiveStreamingEncoder) this.f5340a.f5345e.get(i)).m8071a(bArr, read, false);
                }
            }
        }
    }

    public LiveStreamingAudioRecorder(ExecutorService executorService) {
        this.f5346f = executorService;
    }

    public final synchronized void m8058a() {
        this.f5342a = MicrophoneSetup.m8086a();
    }

    public final synchronized void m8060b() {
        this.f5343c = new AtomicBoolean(true);
    }

    public final synchronized void m8062c() {
        if (this.f5343c != null) {
            this.f5343c.set(true);
        }
    }

    public final synchronized void m8063d() {
        MicrophoneSetup.m8088a(this.f5342a);
    }

    public final synchronized boolean m8059a(LiveStreamingEncoder liveStreamingEncoder) {
        return this.f5345e.add(liveStreamingEncoder);
    }

    public final synchronized boolean m8061b(LiveStreamingEncoder liveStreamingEncoder) {
        return this.f5345e.remove(liveStreamingEncoder);
    }

    public final synchronized void m8064e() {
        this.f5343c.set(false);
        this.f5342a.startRecording();
        this.f5344d = ExecutorDetour.a(this.f5346f, new C03281(this), -2136646141);
    }

    public final synchronized void m8065f() {
        Throwable e;
        if (this.f5344d != null) {
            try {
                FutureDetour.a(this.f5344d, -818497804);
            } catch (InterruptedException e2) {
                e = e2;
                BLog.b(f5341b, "Ran into an exception while draining audio", e);
                this.f5344d = null;
            } catch (ExecutionException e3) {
                e = e3;
                BLog.b(f5341b, "Ran into an exception while draining audio", e);
                this.f5344d = null;
            }
        }
        this.f5344d = null;
    }
}
