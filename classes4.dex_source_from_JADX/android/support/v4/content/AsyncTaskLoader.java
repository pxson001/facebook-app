package android.support.v4.content;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.content.ModernAsyncTaskDetour.ModernAsyncTaskWrapper;
import android.support.v4.util.TimeUtils;
import com.facebook.loom.core.TraceEvents;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/* compiled from: exclude_email_addresses */
public abstract class AsyncTaskLoader<D> extends Loader<D> {
    volatile LoadTask f12702a;
    volatile LoadTask f12703b;
    long f12704c;
    long f12705d = -10000;
    Handler f12706e;

    /* compiled from: exclude_email_addresses */
    final class LoadTask extends ModernAsyncTask<Void, Void, D> implements Runnable {
        D f12761a;
        boolean f12762b;
        final /* synthetic */ AsyncTaskLoader f12763c;
        private CountDownLatch f12764e = new CountDownLatch(1);

        LoadTask(AsyncTaskLoader asyncTaskLoader) {
            this.f12763c = asyncTaskLoader;
        }

        protected final Object mo927a(Object[] objArr) {
            this.f12761a = this.f12763c.mo915d();
            return this.f12761a;
        }

        protected final void mo929a(D d) {
            try {
                this.f12763c.m13513b(this, d);
            } finally {
                this.f12764e.countDown();
            }
        }

        protected final void mo928a() {
            try {
                this.f12763c.m13510a(this, this.f12761a);
            } finally {
                this.f12764e.countDown();
            }
        }

        public final void run() {
            this.f12762b = false;
            this.f12763c.m13515c();
        }
    }

    public abstract D mo915d();

    public AsyncTaskLoader(Context context) {
        super(context);
    }

    protected final void m13509a() {
        super.a();
        m13514b();
        this.f12702a = new LoadTask(this);
        m13515c();
    }

    public final boolean m13514b() {
        boolean z = false;
        if (this.f12702a != null) {
            if (this.f12703b != null) {
                if (this.f12702a.f12762b) {
                    this.f12702a.f12762b = false;
                    HandlerDetour.a(this.f12706e, this.f12702a);
                }
                this.f12702a = null;
            } else if (this.f12702a.f12762b) {
                this.f12702a.f12762b = false;
                HandlerDetour.a(this.f12706e, this.f12702a);
                this.f12702a = null;
            } else {
                z = this.f12702a.f12771g.cancel(false);
                if (z) {
                    this.f12703b = this.f12702a;
                }
                this.f12702a = null;
            }
        }
        return z;
    }

    public void m13511a(D d) {
    }

    final void m13515c() {
        if (this.f12703b == null && this.f12702a != null) {
            if (this.f12702a.f12762b) {
                this.f12702a.f12762b = false;
                HandlerDetour.a(this.f12706e, this.f12702a);
            }
            if (this.f12704c <= 0 || SystemClock.uptimeMillis() >= this.f12705d + this.f12704c) {
                ModernAsyncTask modernAsyncTask = this.f12702a;
                Executor executor = ModernAsyncTask.f12768d;
                ModernAsyncTask a;
                if (TraceEvents.a(1)) {
                    a = new ModernAsyncTaskWrapper(modernAsyncTask, 2006500392, Logger.a(1, EntryType.ASYNC_CALL, 2006500392)).m13641a(executor, null);
                } else {
                    a = modernAsyncTask.m13641a(executor, null);
                }
                return;
            }
            this.f12702a.f12762b = true;
            long j = this.f12705d + this.f12704c;
            boolean postAtTime = this.f12706e.postAtTime(HandlerDetour.a(this.f12702a, -946884025), j);
        }
    }

    final void m13510a(LoadTask loadTask, D d) {
        m13511a(d);
        if (this.f12703b == loadTask) {
            if (this.t) {
                this.s = true;
            }
            this.f12705d = SystemClock.uptimeMillis();
            this.f12703b = null;
            m13515c();
        }
    }

    final void m13513b(LoadTask loadTask, D d) {
        if (this.f12702a != loadTask) {
            m13510a(loadTask, d);
        } else if (this.q) {
            m13511a(d);
        } else {
            u();
            this.f12705d = SystemClock.uptimeMillis();
            this.f12702a = null;
            b(d);
        }
    }

    public void m13512a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.a(str, fileDescriptor, printWriter, strArr);
        if (this.f12702a != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.f12702a);
            printWriter.print(" waiting=");
            printWriter.println(this.f12702a.f12762b);
        }
        if (this.f12703b != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.f12703b);
            printWriter.print(" waiting=");
            printWriter.println(this.f12703b.f12762b);
        }
        if (this.f12704c != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            TimeUtils.a(this.f12704c, printWriter, 0);
            printWriter.print(" mLastLoadCompleteTime=");
            long j = this.f12705d;
            long uptimeMillis = SystemClock.uptimeMillis();
            if (j == 0) {
                printWriter.print("--");
            } else {
                TimeUtils.a(j - uptimeMillis, printWriter, 0);
            }
            printWriter.println();
        }
    }
}
