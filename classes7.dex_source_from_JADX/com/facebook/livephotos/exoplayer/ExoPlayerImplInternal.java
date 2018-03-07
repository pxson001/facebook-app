package com.facebook.livephotos.exoplayer;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import com.facebook.livephotos.exoplayer.util.Assertions;
import com.facebook.livephotos.exoplayer.util.PriorityHandlerThread;
import com.facebook.livephotos.exoplayer.util.TraceUtil;
import com.facebook.livephotos.exoplayer.util.Util;
import com.facebook.tools.dextr.runtime.detour.ObjectDetour;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: param_feed_cache_id */
public final class ExoPlayerImplInternal implements Callback {
    public final Handler f6717a;
    private final HandlerThread f6718b;
    private final Handler f6719c;
    private final StandaloneMediaClock f6720d;
    private final AtomicInteger f6721e;
    private final List<TrackRenderer> f6722f;
    private final MediaFormat[][] f6723g;
    private final int[] f6724h;
    private final long f6725i;
    private final long f6726j;
    private TrackRenderer[] f6727k;
    private TrackRenderer f6728l;
    private MediaClock f6729m;
    private boolean f6730n;
    private boolean f6731o;
    private boolean f6732p;
    private int f6733q;
    public int f6734r = 0;
    private int f6735s = 0;
    private long f6736t;
    private volatile long f6737u;
    private volatile long f6738v;
    private volatile long f6739w;

    public ExoPlayerImplInternal(Handler handler, boolean z, int[] iArr, int i, int i2) {
        this.f6719c = handler;
        this.f6731o = z;
        this.f6725i = ((long) i) * 1000;
        this.f6726j = ((long) i2) * 1000;
        this.f6724h = Arrays.copyOf(iArr, iArr.length);
        this.f6733q = 1;
        this.f6737u = -1;
        this.f6739w = -1;
        this.f6720d = new StandaloneMediaClock();
        this.f6721e = new AtomicInteger();
        this.f6722f = new ArrayList(iArr.length);
        this.f6723g = new MediaFormat[iArr.length][];
        this.f6718b = new PriorityHandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.f6718b.start();
        this.f6717a = new Handler(this.f6718b.getLooper(), this);
    }

    private static void m8592d(TrackRenderer trackRenderer) {
        if (trackRenderer.f6748a == 3) {
            Assertions.m9297b(trackRenderer.f6748a == 3);
            trackRenderer.f6748a = 2;
            trackRenderer.mo379d();
        }
    }

    public final synchronized void m8600b() {
        if (!this.f6730n) {
            this.f6717a.sendEmptyMessage(5);
            while (!this.f6730n) {
                try {
                    ObjectDetour.a(this, 56042112);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            this.f6718b.quit();
        }
    }

    public final boolean handleMessage(Message message) {
        boolean z = false;
        try {
            switch (message.what) {
                case 1:
                    m8588b((TrackRenderer[]) message.obj);
                    return true;
                case 2:
                    m8589c();
                    return true;
                case 3:
                    if (message.arg1 != 0) {
                        z = true;
                    }
                    m8587b(z);
                    return true;
                case 4:
                    m8597h();
                    return true;
                case 5:
                    m8598i();
                    return true;
                case 6:
                    m8583a(Util.m9367b(message.arg1, message.arg2));
                    return true;
                case 7:
                    m8596g();
                    return true;
                case 8:
                    m8580a(message.arg1, message.arg2);
                    return true;
                case 9:
                    m8582a(message.arg1, message.obj);
                    return true;
                default:
                    return false;
            }
        } catch (Throwable e) {
            Log.e("ExoPlayerImplInternal", "Internal track renderer error.", e);
            this.f6719c.obtainMessage(4, e).sendToTarget();
            m8597h();
            return true;
        } catch (Throwable e2) {
            Log.e("ExoPlayerImplInternal", "Internal runtime error.", e2);
            this.f6719c.obtainMessage(4, new ExoPlaybackException(e2, true)).sendToTarget();
            m8597h();
            return true;
        }
    }

    private void m8579a(int i) {
        if (this.f6733q != i) {
            this.f6733q = i;
            this.f6719c.obtainMessage(2, i, 0).sendToTarget();
        }
    }

    private void m8588b(TrackRenderer[] trackRendererArr) {
        m8599j();
        this.f6727k = trackRendererArr;
        Arrays.fill(this.f6723g, null);
        m8579a(2);
        m8589c();
    }

    private void m8589c() {
        int i;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Object obj = 1;
        for (TrackRenderer trackRenderer : this.f6727k) {
            if (trackRenderer.f6748a == 0 && trackRenderer.m8610d(this.f6738v) == 0) {
                trackRenderer.mo372p();
                obj = null;
            }
        }
        if (obj == null) {
            m8581a(2, elapsedRealtime, 10);
            return;
        }
        ExoPlayerImplInternal exoPlayerImplInternal;
        elapsedRealtime = 0;
        Object obj2 = 1;
        obj = 1;
        for (i = 0; i < this.f6727k.length; i++) {
            int i2;
            TrackRenderer trackRenderer2 = this.f6727k[i];
            int r = trackRenderer2.mo374r();
            MediaFormat[] mediaFormatArr = new MediaFormat[r];
            for (i2 = 0; i2 < r; i2++) {
                mediaFormatArr[i2] = trackRenderer2.mo364a(i2);
            }
            this.f6723g[i] = mediaFormatArr;
            if (r > 0) {
                if (elapsedRealtime != -1) {
                    long o = trackRenderer2.mo371o();
                    if (o == -1) {
                        elapsedRealtime = -1;
                    } else if (o != -2) {
                        elapsedRealtime = Math.max(elapsedRealtime, o);
                    }
                }
                i2 = this.f6724h[i];
                if (i2 >= 0 && i2 < mediaFormatArr.length) {
                    m8584a(trackRenderer2, i2, false);
                    obj2 = (obj2 == null || !trackRenderer2.mo380e()) ? null : 1;
                    if (obj == null || !m8585a(trackRenderer2)) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                }
            }
        }
        this.f6737u = elapsedRealtime;
        if (obj2 != null && (elapsedRealtime == -1 || elapsedRealtime <= this.f6738v)) {
            i = 5;
            exoPlayerImplInternal = this;
        } else if (obj != null) {
            i = 4;
            exoPlayerImplInternal = this;
        } else {
            i = 3;
            exoPlayerImplInternal = this;
        }
        exoPlayerImplInternal.f6733q = i;
        this.f6719c.obtainMessage(1, this.f6733q, 0, this.f6723g).sendToTarget();
        if (this.f6731o && this.f6733q == 4) {
            m8591d();
        }
        this.f6717a.sendEmptyMessage(7);
    }

    private void m8584a(TrackRenderer trackRenderer, int i, boolean z) {
        long j = this.f6738v;
        boolean z2 = true;
        if (trackRenderer.f6748a != 1) {
            z2 = false;
        }
        Assertions.m9297b(z2);
        trackRenderer.f6748a = 2;
        trackRenderer.mo365a(i, j, z);
        this.f6722f.add(trackRenderer);
        MediaClock b = trackRenderer.mo389b();
        if (b != null) {
            Assertions.m9297b(this.f6729m == null);
            this.f6729m = b;
            this.f6728l = trackRenderer;
        }
    }

    private boolean m8585a(TrackRenderer trackRenderer) {
        if (trackRenderer.mo380e()) {
            return true;
        }
        if (!trackRenderer.mo381f()) {
            return false;
        }
        if (this.f6733q == 4) {
            return true;
        }
        long o = trackRenderer.mo371o();
        long n = trackRenderer.mo370n();
        long j = this.f6732p ? this.f6726j : this.f6725i;
        if (j <= 0 || n == -1 || n == -3 || n >= j + this.f6738v) {
            return true;
        }
        if (o == -1 || o == -2 || n < o) {
            return false;
        }
        return true;
    }

    private void m8587b(boolean z) {
        try {
            this.f6732p = false;
            this.f6731o = z;
            if (!z) {
                m8593e();
                m8595f();
            } else if (this.f6733q == 4) {
                m8591d();
                this.f6717a.sendEmptyMessage(7);
            } else if (this.f6733q == 3) {
                this.f6717a.sendEmptyMessage(7);
            }
            this.f6719c.obtainMessage(3).sendToTarget();
        } catch (Throwable th) {
            this.f6719c.obtainMessage(3).sendToTarget();
        }
    }

    private void m8591d() {
        this.f6732p = false;
        StandaloneMediaClock standaloneMediaClock = this.f6720d;
        if (!standaloneMediaClock.f6875a) {
            standaloneMediaClock.f6875a = true;
            standaloneMediaClock.f6877c = StandaloneMediaClock.m8767b(standaloneMediaClock.f6876b);
        }
        for (int i = 0; i < this.f6722f.size(); i++) {
            ((TrackRenderer) this.f6722f.get(i)).m8621t();
        }
    }

    private void m8593e() {
        this.f6720d.m8770c();
        for (int i = 0; i < this.f6722f.size(); i++) {
            m8592d((TrackRenderer) this.f6722f.get(i));
        }
    }

    private void m8595f() {
        if (this.f6729m == null || !this.f6722f.contains(this.f6728l) || this.f6728l.mo380e()) {
            this.f6738v = this.f6720d.mo382a();
        } else {
            this.f6738v = this.f6729m.mo382a();
            this.f6720d.m8769a(this.f6738v);
        }
        this.f6736t = SystemClock.elapsedRealtime() * 1000;
    }

    private void m8596g() {
        TraceUtil.m9359a("doSomeWork");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.f6737u != -1 ? this.f6737u : Long.MAX_VALUE;
        m8595f();
        Object obj = 1;
        Object obj2 = 1;
        long j2 = j;
        for (int i = 0; i < this.f6722f.size(); i++) {
            TrackRenderer trackRenderer = (TrackRenderer) this.f6722f.get(i);
            trackRenderer.mo366a(this.f6738v, this.f6736t);
            obj2 = (obj2 == null || !trackRenderer.mo380e()) ? null : 1;
            boolean a = m8585a(trackRenderer);
            if (!a) {
                trackRenderer.mo372p();
            }
            obj = (obj == null || !a) ? null : 1;
            if (j2 != -1) {
                long o = trackRenderer.mo371o();
                long n = trackRenderer.mo370n();
                if (n == -1) {
                    j2 = -1;
                } else if (n != -3 && (o == -1 || o == -2 || n < o)) {
                    j2 = Math.min(j2, n);
                }
            }
        }
        this.f6739w = j2;
        if (obj2 != null && (this.f6737u == -1 || this.f6737u <= this.f6738v)) {
            m8579a(5);
            m8593e();
        } else if (this.f6733q == 3 && obj != null) {
            m8579a(4);
            if (this.f6731o) {
                m8591d();
            }
        } else if (this.f6733q == 4 && obj == null) {
            this.f6732p = this.f6731o;
            m8579a(3);
            m8593e();
        }
        this.f6717a.removeMessages(7);
        if ((this.f6731o && this.f6733q == 4) || this.f6733q == 3) {
            m8581a(7, elapsedRealtime, 10);
        } else if (!this.f6722f.isEmpty()) {
            m8581a(7, elapsedRealtime, 1000);
        }
        TraceUtil.m9358a();
    }

    private void m8581a(int i, long j, long j2) {
        long elapsedRealtime = (j + j2) - SystemClock.elapsedRealtime();
        if (elapsedRealtime <= 0) {
            this.f6717a.sendEmptyMessage(i);
        } else {
            this.f6717a.sendEmptyMessageDelayed(i, elapsedRealtime);
        }
    }

    private void m8583a(long j) {
        try {
            if (j != this.f6738v / 1000) {
                this.f6732p = false;
                this.f6738v = j * 1000;
                this.f6720d.m8770c();
                this.f6720d.m8769a(this.f6738v);
                if (this.f6733q == 1 || this.f6733q == 2) {
                    this.f6721e.decrementAndGet();
                    return;
                }
                for (int i = 0; i < this.f6722f.size(); i++) {
                    TrackRenderer trackRenderer = (TrackRenderer) this.f6722f.get(i);
                    m8592d(trackRenderer);
                    trackRenderer.mo368c(this.f6738v);
                }
                m8579a(3);
                this.f6717a.sendEmptyMessage(7);
                this.f6721e.decrementAndGet();
            }
        } finally {
            this.f6721e.decrementAndGet();
        }
    }

    private void m8597h() {
        m8599j();
        m8579a(1);
    }

    private void m8598i() {
        m8599j();
        m8579a(1);
        synchronized (this) {
            this.f6730n = true;
            ObjectDetour.c(this, -1563644347);
        }
    }

    private void m8599j() {
        int i = 0;
        this.f6717a.removeMessages(7);
        this.f6717a.removeMessages(2);
        this.f6732p = false;
        this.f6720d.m8770c();
        if (this.f6727k != null) {
            while (i < this.f6727k.length) {
                TrackRenderer trackRenderer = this.f6727k[i];
                m8586b(trackRenderer);
                m8590c(trackRenderer);
                i++;
            }
            this.f6727k = null;
            this.f6729m = null;
            this.f6728l = null;
            this.f6722f.clear();
        }
    }

    private void m8586b(TrackRenderer trackRenderer) {
        try {
            m8594e(trackRenderer);
        } catch (Throwable e) {
            Log.e("ExoPlayerImplInternal", "Stop failed.", e);
        } catch (Throwable e2) {
            Log.e("ExoPlayerImplInternal", "Stop failed.", e2);
        }
    }

    private static void m8590c(TrackRenderer trackRenderer) {
        try {
            trackRenderer.m8622w();
        } catch (Throwable e) {
            Log.e("ExoPlayerImplInternal", "Release failed.", e);
        } catch (Throwable e2) {
            Log.e("ExoPlayerImplInternal", "Release failed.", e2);
        }
    }

    private <T> void m8582a(int i, Object obj) {
        try {
            Pair pair = (Pair) obj;
            ((TrackRenderer) pair.first).mo384a(i, pair.second);
            if (!(this.f6733q == 1 || this.f6733q == 2)) {
                this.f6717a.sendEmptyMessage(7);
            }
            synchronized (this) {
                this.f6735s++;
                ObjectDetour.c(this, 1430894523);
            }
        } catch (Throwable th) {
            synchronized (this) {
                this.f6735s++;
                ObjectDetour.c(this, -2074157213);
            }
        }
    }

    private void m8580a(int i, int i2) {
        boolean z = true;
        if (this.f6724h[i] != i2) {
            this.f6724h[i] = i2;
            if (this.f6733q != 1 && this.f6733q != 2) {
                TrackRenderer trackRenderer = this.f6727k[i];
                int i3 = trackRenderer.f6748a;
                if (i3 != 0 && i3 != -1 && trackRenderer.mo374r() != 0) {
                    boolean z2;
                    boolean z3 = i3 == 2 || i3 == 3;
                    if (i2 < 0 || i2 >= this.f6723g[i].length) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (z3) {
                        if (!z2 && trackRenderer == this.f6728l) {
                            this.f6720d.m8769a(this.f6729m.mo382a());
                        }
                        m8594e(trackRenderer);
                        this.f6722f.remove(trackRenderer);
                    }
                    if (z2) {
                        z2 = this.f6731o && this.f6733q == 4;
                        if (z3 || !z2) {
                            z = false;
                        }
                        m8584a(trackRenderer, i2, z);
                        if (z2) {
                            trackRenderer.m8621t();
                        }
                        this.f6717a.sendEmptyMessage(7);
                    }
                }
            }
        }
    }

    private void m8594e(TrackRenderer trackRenderer) {
        m8592d(trackRenderer);
        if (trackRenderer.f6748a == 2) {
            Assertions.m9297b(trackRenderer.f6748a == 2);
            trackRenderer.f6748a = 1;
            trackRenderer.mo369g();
            if (trackRenderer == this.f6728l) {
                this.f6729m = null;
                this.f6728l = null;
            }
        }
    }
}
