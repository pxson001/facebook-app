package com.facebook.dialtone;

import android.content.Context;
import com.facebook.common.executors.C0055x2995691a;
import com.facebook.inject.InjectorLike;
import com.facebook.nodex.startup.signal.DialtoneSignalFile;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: trimEndTimeMs */
public class DialtoneAsyncSignalFile extends DialtoneSignalFile {
    private final ExecutorService f2239c;
    private final Runnable f2240d = new C01471(this);
    private final Runnable f2241e = new C01482(this);

    /* compiled from: trimEndTimeMs */
    class C01471 implements Runnable {
        final /* synthetic */ DialtoneAsyncSignalFile f2245a;

        C01471(DialtoneAsyncSignalFile dialtoneAsyncSignalFile) {
            this.f2245a = dialtoneAsyncSignalFile;
        }

        public void run() {
            super.mo638b();
        }
    }

    /* compiled from: trimEndTimeMs */
    class C01482 implements Runnable {
        final /* synthetic */ DialtoneAsyncSignalFile f2246a;

        C01482(DialtoneAsyncSignalFile dialtoneAsyncSignalFile) {
            this.f2246a = dialtoneAsyncSignalFile;
        }

        public void run() {
            super.mo637a();
        }
    }

    public static DialtoneAsyncSignalFile m4396b(InjectorLike injectorLike) {
        return new DialtoneAsyncSignalFile((Context) injectorLike.getInstance(Context.class), C0055x2995691a.m1881a(injectorLike));
    }

    @Inject
    public DialtoneAsyncSignalFile(Context context, ExecutorService executorService) {
        super(context);
        this.f2239c = executorService;
    }

    public static DialtoneAsyncSignalFile m4394a(InjectorLike injectorLike) {
        return m4396b(injectorLike);
    }

    public final boolean mo638b() {
        this.b = Boolean.valueOf(false);
        ExecutorDetour.a(this.f2239c, this.f2240d, 486965471);
        return true;
    }

    public final boolean mo637a() {
        this.b = Boolean.valueOf(true);
        ExecutorDetour.a(this.f2239c, this.f2241e, -831022195);
        return true;
    }
}
