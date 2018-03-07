package com.facebook.debug.debugoverlay;

import android.content.Context;
import android.os.Handler;
import android.view.WindowManager;
import com.facebook.common.android.WindowManagerMethodAutoProvider;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: logged_in_user_ids */
public class DebugOverlayController {
    private static final Class<?> f8975a = DebugOverlayController.class;
    private static volatile DebugOverlayController f8976h;
    public final WindowManager f8977b;
    public final Context f8978c;
    private final Handler f8979d;
    private final FbSharedPreferences f8980e;
    private final Runnable f8981f = new C04221(this);
    public DebugOverlayLogView f8982g;

    /* compiled from: logged_in_user_ids */
    class C04221 implements Runnable {
        final /* synthetic */ DebugOverlayController f8983a;

        C04221(DebugOverlayController debugOverlayController) {
            this.f8983a = debugOverlayController;
        }

        public void run() {
            this.f8983a.f8982g.a();
        }
    }

    public static com.facebook.debug.debugoverlay.DebugOverlayController m9307a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f8976h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.debug.debugoverlay.DebugOverlayController.class;
        monitor-enter(r1);
        r0 = f8976h;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m9308b(r0);	 Catch:{ all -> 0x0035 }
        f8976h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8976h;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.debug.debugoverlay.DebugOverlayController.a(com.facebook.inject.InjectorLike):com.facebook.debug.debugoverlay.DebugOverlayController");
    }

    private static DebugOverlayController m9308b(InjectorLike injectorLike) {
        return new DebugOverlayController(WindowManagerMethodAutoProvider.b(injectorLike), (Context) injectorLike.getInstance(Context.class), Handler_ForUiThreadMethodAutoProvider.b(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    DebugOverlayController(WindowManager windowManager, Context context, Handler handler, FbSharedPreferences fbSharedPreferences) {
        this.f8977b = windowManager;
        this.f8978c = context;
        this.f8979d = handler;
        this.f8980e = fbSharedPreferences;
    }

    public final void m9309a(DebugOverlayTag debugOverlayTag, String str) {
        if (this.f8980e.a(DebugOverlayTagPrefKeys.a(debugOverlayTag), false)) {
            HandlerDetour.a(this.f8979d, this.f8981f);
            HandlerDetour.a(this.f8979d, new 2(this, debugOverlayTag, str), -278648786);
            HandlerDetour.b(this.f8979d, this.f8981f, 3000, 2061465431);
        }
    }
}
