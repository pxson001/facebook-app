package com.facebook.strictmode;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.facebook.strictmode.setter.StrictModeSetter;
import com.facebook.strictmode.setter.predefined.SnapshotAll;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: No session id supplied to composer. ComposerConfiguration =  */
public class StrictModeHelper {
    private static Runnable f12987a = null;
    private static Handler f12988b = null;

    /* compiled from: No session id supplied to composer. ComposerConfiguration =  */
    final class C15371 implements Runnable {
        final /* synthetic */ SnapshotAll f12986a;

        C15371(SnapshotAll snapshotAll) {
            this.f12986a = snapshotAll;
        }

        public final void run() {
            this.f12986a.set();
        }
    }

    public static void m13705a(StrictModeSetter... strictModeSetterArr) {
        m13704a(Lists.a(strictModeSetterArr));
    }

    private static void m13704a(List<StrictModeSetter> list) {
        for (StrictModeSetter strictModeSetter : list) {
            strictModeSetter.set();
        }
        SnapshotAll snapshotAll = new SnapshotAll();
        if (VERSION.SDK_INT >= 16) {
            synchronized (StrictModeHelper.class) {
                if (f12988b == null) {
                    f12988b = new Handler(Looper.getMainLooper());
                }
                if (f12987a != null) {
                    HandlerDetour.a(f12988b, f12987a);
                }
                f12987a = new C15371(snapshotAll);
                HandlerDetour.b(f12988b, f12987a, -225081929);
            }
        }
    }
}
