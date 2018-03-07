package com.facebook.audiofingerprinting;

import android.media.AudioRecord;
import android.os.Handler;
import android.os.Process;
import com.facebook.audiofingerprinting.AudioFingerprintingSession.C01021.C01011;
import com.facebook.audiofingerprinting.AudioFingerprintingSession.C01032;
import com.facebook.audiofingerprinting.AudioFingerprintingSession.C01043;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Strings;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;

/* compiled from: uploadContactBatchForFriendFinder (%d changes) */
public class AudioFingerprintCapturer implements Runnable {
    private final byte[] f1030a = new byte[500];
    public final DefaultAndroidThreadUtil f1031b;
    public final AudioReceiver f1032c;
    public final Runnable f1033d;
    public final Runnable f1034e;
    public final Handler f1035f;
    public AtomicBoolean f1036g = new AtomicBoolean(false);
    public AudioRecord f1037h;
    public C01011 f1038i;

    /* compiled from: uploadContactBatchForFriendFinder (%d changes) */
    class C00991 implements Runnable {
        final /* synthetic */ AudioFingerprintCapturer f1028a;

        C00991(AudioFingerprintCapturer audioFingerprintCapturer) {
            this.f1028a = audioFingerprintCapturer;
        }

        public void run() {
            if (this.f1028a.f1038i != null) {
                this.f1028a.f1038i.f1039a.f1042c.f1063l.mo85a();
            }
        }
    }

    /* compiled from: uploadContactBatchForFriendFinder (%d changes) */
    class C01002 implements Runnable {
        final /* synthetic */ AudioFingerprintCapturer f1029a;

        C01002(AudioFingerprintCapturer audioFingerprintCapturer) {
            this.f1029a = audioFingerprintCapturer;
        }

        public void run() {
            if (this.f1029a.f1038i != null) {
                C01011 c01011 = this.f1029a.f1038i;
                c01011.f1039a.f1042c.f1063l.mo89a((String) c01011.f1039a.f1042c.f1066o.get());
                AudioFingerprintingSession audioFingerprintingSession = c01011.f1039a.f1042c;
                Runnable runnable = c01011.f1039a.f1042c.f1052a;
                Optional optional = c01011.f1039a.f1040a;
                Optional optional2 = c01011.f1039a.f1041b;
                ExecutorDetour.a(audioFingerprintingSession.f1056e, runnable, -635229344);
                if (optional2.isPresent()) {
                    Runnable c01032 = new C01032(audioFingerprintingSession);
                    Long l = (Long) optional2.get();
                    for (long longValue = l.longValue(); longValue <= 15000 + l.longValue(); longValue += l.longValue()) {
                        HandlerDetour.b(audioFingerprintingSession.f1059h, c01032, longValue, 1437332631);
                    }
                }
                if (optional.isPresent()) {
                    Object obj;
                    MusicMetadata musicMetadata = (MusicMetadata) optional.get();
                    if (Strings.isNullOrEmpty(musicMetadata.f1072a) && Strings.isNullOrEmpty(musicMetadata.f1073b) && Strings.isNullOrEmpty(musicMetadata.f1074c)) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    if (obj != null) {
                        musicMetadata = (MusicMetadata) optional.get();
                        Optional optional3 = audioFingerprintingSession.f1067p;
                        if (optional3.isPresent() && ((MusicMetadata) optional3.get()).f1074c.equals(musicMetadata.f1074c) && ((MusicMetadata) optional3.get()).f1073b.equals(musicMetadata.f1073b) && ((MusicMetadata) optional3.get()).f1072a.equals(musicMetadata.f1072a) && ((MusicMetadata) optional3.get()).f1075d.equals(musicMetadata.f1075d)) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj == null) {
                            AudioFingerprintingSession.m1014a(audioFingerprintingSession, "local", Absent.INSTANCE, optional);
                        }
                    }
                }
                for (long j = 3000; j <= 16000; j += 1000) {
                    String valueOf = String.valueOf(j);
                    HandlerDetour.b(audioFingerprintingSession.f1059h, new C01043(audioFingerprintingSession, valueOf), j, -43545363);
                    audioFingerprintingSession.f1060i.add(valueOf);
                }
                Optional optional4 = audioFingerprintingSession.f1066o;
            }
        }
    }

    @Inject
    public AudioFingerprintCapturer(Handler handler, AudioReceiver audioReceiver, DefaultAndroidThreadUtil defaultAndroidThreadUtil) {
        this.f1032c = audioReceiver;
        this.f1031b = defaultAndroidThreadUtil;
        this.f1035f = handler;
        this.f1034e = new C00991(this);
        this.f1033d = new C01002(this);
    }

    public void run() {
        this.f1031b.b();
        Process.setThreadPriority(-19);
        while (true) {
            try {
                synchronized (this.f1036g) {
                    if (!this.f1036g.get() || this.f1037h.getRecordingState() != 3) {
                        break;
                    }
                    this.f1032c.m1027a(this.f1030a, this.f1037h.read(this.f1030a, 0, 500));
                }
            } catch (IllegalStateException e) {
                m999g();
                return;
            }
        }
    }

    public final byte[] m1000b() {
        return this.f1032c.m1032g();
    }

    public final int m1001d() {
        return this.f1032c.m1034i();
    }

    public final double m1002e() {
        return this.f1032c.m1035j();
    }

    public final void m1003f() {
        m999g();
    }

    protected void finalize() {
        super.finalize();
        m999g();
    }

    private void m999g() {
        this.f1036g.set(false);
        synchronized (this.f1036g) {
            if (this.f1037h != null && this.f1037h.getState() == 1) {
                this.f1037h.stop();
                this.f1037h.release();
            }
            this.f1032c.m1031f();
        }
    }
}
