package com.facebook.base.service;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.widget.LinearLayoutCompat;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.ObjectDetour;
import com.google.common.base.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

/* compiled from: subscribe_story */
public abstract class FbBackgroundService extends FbService {
    public final Object f2450a = new Object();
    private volatile boolean f2451b;
    @Nullable
    public AtomicReference<FbBackgroundServiceHandler> f2452c;

    /* compiled from: subscribe_story */
    public class FbBackgroundServiceHandler extends Handler {
        private final FbBackgroundService f2448a;
        private volatile boolean f2449b;

        public FbBackgroundServiceHandler(FbBackgroundService fbBackgroundService, Looper looper) {
            super(looper);
            this.f2448a = (FbBackgroundService) Preconditions.checkNotNull(fbBackgroundService);
        }

        public void handleMessage(Message message) {
            if (message == null) {
                throw new IllegalStateException("Message is null");
            }
            Object obj;
            switch (message.what) {
                case 1:
                    this.f2448a.m3558b();
                    return;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    FbBackgroundService fbBackgroundService = this.f2448a;
                    Intent intent = (Intent) message.obj;
                    int i = message.arg1;
                    i = message.arg2;
                    fbBackgroundService.m3557a(intent);
                    return;
                case 3:
                    obj = message.obj;
                    return;
                case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                    return;
                case 5:
                    int i2 = message.arg1;
                    return;
                case 6:
                    obj = message.obj;
                    return;
                case 7:
                    this.f2448a.m3562i();
                    m3550e();
                    return;
                default:
                    throw new IllegalStateException(StringFormatUtil.formatStrLocaleSafe("Message what %d is not supported", Integer.valueOf(message.what)));
            }
        }

        public final boolean m3552a(Intent intent, int i, int i2) {
            return sendMessage(obtainMessage(2, i, i2, intent));
        }

        private boolean m3547a(long j) {
            if (sendMessage(obtainMessage(7))) {
                return m3548b(j);
            }
            return false;
        }

        public final boolean m3553c() {
            return m3547a(0);
        }

        private synchronized void m3550e() {
            this.f2449b = true;
            ObjectDetour.c(this, 1615739019);
        }

        private synchronized boolean m3548b(long j) {
            boolean c;
            if (j > 0) {
                c = m3549c(j);
            } else {
                c = m3551f();
            }
            return c;
        }

        private synchronized boolean m3549c(long j) {
            boolean z;
            long uptimeMillis = SystemClock.uptimeMillis() + j;
            while (!this.f2449b) {
                long uptimeMillis2 = uptimeMillis - SystemClock.uptimeMillis();
                if (uptimeMillis2 <= 0) {
                    z = false;
                    break;
                }
                try {
                    ObjectDetour.a(this, uptimeMillis2, -456792648);
                } catch (InterruptedException e) {
                }
            }
            z = true;
            return z;
        }

        private synchronized boolean m3551f() {
            while (!this.f2449b) {
                try {
                    ObjectDetour.a(this, -1069952381);
                } catch (InterruptedException e) {
                }
            }
            return true;
        }
    }

    protected abstract void m3557a(Intent intent);

    public abstract Looper m3559c();

    protected abstract void m3560d();

    public final void m3556a() {
        FbBackgroundServiceHandler fbBackgroundServiceHandler;
        super.a();
        Looper c = m3559c();
        if (c == null || c == Looper.getMainLooper()) {
            fbBackgroundServiceHandler = null;
        } else {
            fbBackgroundServiceHandler = new FbBackgroundServiceHandler(this, c);
        }
        this.f2452c = new AtomicReference(fbBackgroundServiceHandler);
        FbBackgroundServiceHandler fbBackgroundServiceHandler2 = fbBackgroundServiceHandler;
        if (fbBackgroundServiceHandler2 != null) {
            boolean sendMessage = fbBackgroundServiceHandler2.sendMessage(fbBackgroundServiceHandler2.obtainMessage(1));
        } else {
            m3558b();
        }
    }

    protected final void m3558b() {
        synchronized (this.f2450a) {
            if (!this.f2451b) {
                m3560d();
                this.f2451b = true;
            }
        }
    }

    @Nullable
    protected Integer m3561e() {
        return null;
    }

    protected void m3562i() {
    }

    private void m3554a(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(fileDescriptor, printWriter, strArr);
    }

    @Deprecated
    public final void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        FbBackgroundServiceHandler fbBackgroundServiceHandler = (FbBackgroundServiceHandler) this.f2452c.get();
        if (fbBackgroundServiceHandler != null) {
            boolean a = fbBackgroundServiceHandler.m3552a(intent, -1, i);
        } else {
            m3557a(intent);
        }
    }

    public final int m3555a(Intent intent, int i, int i2) {
        int a = super.a(intent, i, i2);
        Integer e = m3561e();
        FbBackgroundServiceHandler fbBackgroundServiceHandler = (FbBackgroundServiceHandler) this.f2452c.get();
        if (fbBackgroundServiceHandler != null) {
            fbBackgroundServiceHandler.m3552a(intent, i, i2);
        } else {
            m3557a(intent);
        }
        if (e != null) {
            return e.intValue();
        }
        return a;
    }

    public final void m3563k() {
        super.k();
        FbBackgroundServiceHandler fbBackgroundServiceHandler = (FbBackgroundServiceHandler) this.f2452c.get();
        if (fbBackgroundServiceHandler != null) {
            fbBackgroundServiceHandler.m3553c();
        } else {
            m3562i();
        }
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        FbBackgroundServiceHandler fbBackgroundServiceHandler = (FbBackgroundServiceHandler) this.f2452c.get();
        if (fbBackgroundServiceHandler != null) {
            boolean sendMessage = fbBackgroundServiceHandler.sendMessage(fbBackgroundServiceHandler.obtainMessage(3, configuration));
        }
    }

    public final void onLowMemory() {
        super.onLowMemory();
        FbBackgroundServiceHandler fbBackgroundServiceHandler = (FbBackgroundServiceHandler) this.f2452c.get();
        if (fbBackgroundServiceHandler != null) {
            boolean sendMessage = fbBackgroundServiceHandler.sendMessage(fbBackgroundServiceHandler.obtainMessage(4));
        }
    }

    public final void onTrimMemory(int i) {
        super.onTrimMemory(i);
        FbBackgroundServiceHandler fbBackgroundServiceHandler = (FbBackgroundServiceHandler) this.f2452c.get();
        if (fbBackgroundServiceHandler != null) {
            Message obtainMessage = fbBackgroundServiceHandler.obtainMessage(5);
            obtainMessage.arg1 = i;
            boolean sendMessage = fbBackgroundServiceHandler.sendMessage(obtainMessage);
        }
    }

    public final void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        FbBackgroundServiceHandler fbBackgroundServiceHandler = (FbBackgroundServiceHandler) this.f2452c.get();
        if (fbBackgroundServiceHandler != null) {
            boolean sendMessage = fbBackgroundServiceHandler.sendMessage(fbBackgroundServiceHandler.obtainMessage(6, intent));
        }
    }

    protected final void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        m3558b();
        m3554a(fileDescriptor, printWriter, strArr);
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    public void onRebind(Intent intent) {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, -206096662);
        super.onRebind(intent);
        Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, -1676000521, a);
    }
}
