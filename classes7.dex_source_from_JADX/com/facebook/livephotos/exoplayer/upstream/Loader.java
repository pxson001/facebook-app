package com.facebook.livephotos.exoplayer.upstream;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.facebook.livephotos.exoplayer.extractor.ExtractorSampleSource;
import com.facebook.livephotos.exoplayer.extractor.ExtractorSampleSource.ExtractingLoadable;
import com.facebook.livephotos.exoplayer.util.Assertions;
import com.facebook.livephotos.exoplayer.util.TraceUtil;
import com.facebook.livephotos.exoplayer.util.Util.C06271;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: original_page_id */
public final class Loader {
    public final ExecutorService f7678a;
    public LoadTask f7679b;
    public boolean f7680c;

    @SuppressLint({"HandlerLeak"})
    /* compiled from: original_page_id */
    public final class LoadTask extends Handler implements Runnable {
        public final /* synthetic */ Loader f7674a;
        public final ExtractingLoadable f7675b;
        private final ExtractorSampleSource f7676c;
        public volatile Thread f7677d;

        public LoadTask(Loader loader, Looper looper, ExtractingLoadable extractingLoadable, ExtractorSampleSource extractorSampleSource) {
            this.f7674a = loader;
            super(looper);
            this.f7675b = extractingLoadable;
            this.f7676c = extractorSampleSource;
        }

        public final void run() {
            try {
                this.f7677d = Thread.currentThread();
                if (!this.f7675b.m8868b()) {
                    TraceUtil.m9359a(this.f7675b.getClass().getSimpleName() + ".load()");
                    this.f7675b.m8869c();
                    TraceUtil.m9358a();
                }
                sendEmptyMessage(0);
            } catch (IOException e) {
                obtainMessage(1, e).sendToTarget();
            } catch (InterruptedException e2) {
                Assertions.m9297b(this.f7675b.m8868b());
                sendEmptyMessage(0);
            } catch (Throwable e3) {
                Log.e("LoadTask", "Unexpected exception loading stream", e3);
                obtainMessage(1, new UnexpectedLoaderException(e3)).sendToTarget();
            } catch (Throwable e32) {
                Log.e("LoadTask", "Unexpected error loading stream", e32);
                obtainMessage(2, e32).sendToTarget();
                throw e32;
            }
        }

        public final void handleMessage(Message message) {
            if (message.what == 2) {
                throw ((Error) message.obj);
            }
            this.f7674a.f7680c = false;
            this.f7674a.f7679b = null;
            if (this.f7675b.f6983g) {
                this.f7676c.m8896i();
                return;
            }
            switch (message.what) {
                case 0:
                    this.f7676c.f6997H = true;
                    return;
                case 1:
                    this.f7676c.m8885a((IOException) message.obj);
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: original_page_id */
    public final class UnexpectedLoaderException extends IOException {
        public UnexpectedLoaderException(Exception exception) {
            super("Unexpected " + exception.getClass().getSimpleName() + ": " + exception.getMessage(), exception);
        }
    }

    public Loader(String str) {
        this.f7678a = Executors.newSingleThreadExecutor(new C06271(str));
    }

    public final void m9285a(ExtractingLoadable extractingLoadable, ExtractorSampleSource extractorSampleSource) {
        Looper myLooper = Looper.myLooper();
        Assertions.m9297b(myLooper != null);
        Assertions.m9297b(!this.f7680c);
        this.f7680c = true;
        this.f7679b = new LoadTask(this, myLooper, extractingLoadable, extractorSampleSource);
        ExecutorDetour.a(this.f7678a, this.f7679b, -1615926253);
    }

    public final void m9286b() {
        Assertions.m9297b(this.f7680c);
        LoadTask loadTask = this.f7679b;
        loadTask.f7675b.f6983g = true;
        if (loadTask.f7677d != null) {
            loadTask.f7677d.interrupt();
        }
    }
}
