package android.support.design.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* compiled from: publishShare */
public class SnackbarManager {
    private static SnackbarManager f7084a;
    private final Object f7085b = new Object();
    private final Handler f7086c = new Handler(Looper.getMainLooper(), new C04111(this));
    private SnackbarRecord f7087d;
    private SnackbarRecord f7088e;

    /* compiled from: publishShare */
    interface Callback {
        void mo874a();

        void mo875a(int i);
    }

    /* compiled from: publishShare */
    class C04111 implements android.os.Handler.Callback {
        final /* synthetic */ SnackbarManager f7081a;

        C04111(SnackbarManager snackbarManager) {
            this.f7081a = snackbarManager;
        }

        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    SnackbarManager.m10187b(this.f7081a, (SnackbarRecord) message.obj);
                    return true;
                default:
                    return false;
            }
        }
    }

    /* compiled from: publishShare */
    class SnackbarRecord {
        public final WeakReference<Callback> f7082a;
        public int f7083b;

        SnackbarRecord(int i, Callback callback) {
            this.f7082a = new WeakReference(callback);
            this.f7083b = i;
        }

        final boolean m10182a(Callback callback) {
            return callback != null && this.f7082a.get() == callback;
        }
    }

    public static SnackbarManager m10183a() {
        if (f7084a == null) {
            f7084a = new SnackbarManager();
        }
        return f7084a;
    }

    private SnackbarManager() {
    }

    public final void m10190a(int i, Callback callback) {
        synchronized (this.f7085b) {
            if (m10188f(callback)) {
                this.f7087d.f7083b = i;
                this.f7086c.removeCallbacksAndMessages(this.f7087d);
                m10184a(this.f7087d);
                return;
            }
            if (m10189g(callback)) {
                this.f7088e.f7083b = i;
            } else {
                this.f7088e = new SnackbarRecord(i, callback);
            }
            if (this.f7087d == null || !m10185a(this.f7087d, 4)) {
                this.f7087d = null;
                m10186b();
                return;
            }
        }
    }

    public final void m10192a(Callback callback, int i) {
        synchronized (this.f7085b) {
            if (m10188f(callback)) {
                m10185a(this.f7087d, i);
            } else if (m10189g(callback)) {
                m10185a(this.f7088e, i);
            }
        }
    }

    public final void m10191a(Callback callback) {
        synchronized (this.f7085b) {
            if (m10188f(callback)) {
                this.f7087d = null;
                if (this.f7088e != null) {
                    m10186b();
                }
            }
        }
    }

    public final void m10193b(Callback callback) {
        synchronized (this.f7085b) {
            if (m10188f(callback)) {
                m10184a(this.f7087d);
            }
        }
    }

    public final void m10194c(Callback callback) {
        synchronized (this.f7085b) {
            if (m10188f(callback)) {
                this.f7086c.removeCallbacksAndMessages(this.f7087d);
            }
        }
    }

    public final void m10195d(Callback callback) {
        synchronized (this.f7085b) {
            if (m10188f(callback)) {
                m10184a(this.f7087d);
            }
        }
    }

    public final boolean m10196e(Callback callback) {
        boolean z;
        synchronized (this.f7085b) {
            z = m10188f(callback) || m10189g(callback);
        }
        return z;
    }

    private void m10186b() {
        if (this.f7088e != null) {
            this.f7087d = this.f7088e;
            this.f7088e = null;
            Callback callback = (Callback) this.f7087d.f7082a.get();
            if (callback != null) {
                callback.mo874a();
            } else {
                this.f7087d = null;
            }
        }
    }

    private static boolean m10185a(SnackbarRecord snackbarRecord, int i) {
        Callback callback = (Callback) snackbarRecord.f7082a.get();
        if (callback == null) {
            return false;
        }
        callback.mo875a(i);
        return true;
    }

    private boolean m10188f(Callback callback) {
        return this.f7087d != null && this.f7087d.m10182a(callback);
    }

    private boolean m10189g(Callback callback) {
        return this.f7088e != null && this.f7088e.m10182a(callback);
    }

    private void m10184a(SnackbarRecord snackbarRecord) {
        if (snackbarRecord.f7083b != -2) {
            int i = 2750;
            if (snackbarRecord.f7083b > 0) {
                i = snackbarRecord.f7083b;
            } else if (snackbarRecord.f7083b == -1) {
                i = 1500;
            }
            this.f7086c.removeCallbacksAndMessages(snackbarRecord);
            this.f7086c.sendMessageDelayed(Message.obtain(this.f7086c, 0, snackbarRecord), (long) i);
        }
    }

    public static void m10187b(SnackbarManager snackbarManager, SnackbarRecord snackbarRecord) {
        synchronized (snackbarManager.f7085b) {
            if (snackbarManager.f7087d == snackbarRecord || snackbarManager.f7088e == snackbarRecord) {
                m10185a(snackbarRecord, 2);
            }
        }
    }
}
