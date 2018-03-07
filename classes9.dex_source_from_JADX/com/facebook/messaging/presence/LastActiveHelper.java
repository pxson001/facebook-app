package com.facebook.messaging.presence;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.presence.Availability;
import com.facebook.presence.PresenceState;
import com.facebook.user.model.LastActive;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: destination_longitude */
public class LastActiveHelper {
    private static volatile LastActiveHelper f16381b;
    private final Resources f16382a;

    /* compiled from: destination_longitude */
    public enum TextFormat {
        UPPER_CASE,
        NORMAL
    }

    /* compiled from: destination_longitude */
    public enum Verbosity {
        VERBOSE,
        ABBREVIATED,
        SHORT
    }

    public static com.facebook.messaging.presence.LastActiveHelper m16446a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f16381b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.presence.LastActiveHelper.class;
        monitor-enter(r1);
        r0 = f16381b;	 Catch:{ all -> 0x003a }
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
        r0 = m16449b(r0);	 Catch:{ all -> 0x0035 }
        f16381b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f16381b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.presence.LastActiveHelper.a(com.facebook.inject.InjectorLike):com.facebook.messaging.presence.LastActiveHelper");
    }

    private static LastActiveHelper m16449b(InjectorLike injectorLike) {
        return new LastActiveHelper(ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public LastActiveHelper(Resources resources) {
        this.f16382a = resources;
    }

    public static long m16445a(long j, Availability availability) {
        if (j <= 0) {
            return 0;
        }
        long currentTimeMillis = System.currentTimeMillis() - j;
        if (availability == Availability.AVAILABLE) {
            j = System.currentTimeMillis();
        } else if (currentTimeMillis > 345600000) {
            j = 0;
        }
        return j;
    }

    public final String m16453a(@Nullable LastActive lastActive, PresenceState presenceState, Verbosity verbosity, TextFormat textFormat) {
        if (lastActive != null) {
            long j;
            if (lastActive != null) {
                j = lastActive.a;
            } else {
                j = 0;
            }
            j = m16445a(j, presenceState.b);
            if (Verbosity.SHORT == verbosity) {
                return m16454b(j, textFormat);
            }
            if (Verbosity.ABBREVIATED == verbosity) {
                return m16450a(j, textFormat);
            }
            return m16451a(j, textFormat, false);
        } else if (presenceState.b == Availability.AVAILABLE && verbosity == Verbosity.VERBOSE) {
            return this.f16382a.getString(2131231559);
        } else {
            return null;
        }
    }

    public final String m16451a(long j, TextFormat textFormat, boolean z) {
        if (j <= 0) {
            return null;
        }
        int currentTimeMillis = (int) ((System.currentTimeMillis() - j) / 1000);
        int i = currentTimeMillis / 60;
        int i2 = i / 60;
        int i3 = i2 / 24;
        if (currentTimeMillis < 60) {
            return m16448a(2131231559, textFormat);
        }
        return i == 1 ? z ? m16448a(2131231567, textFormat) : m16448a(2131231561, textFormat) : i < 60 ? z ? m16447a(2131231568, i, textFormat) : m16447a(2131231562, i, textFormat) : i2 == 1 ? z ? m16448a(2131231569, textFormat) : m16448a(2131231563, textFormat) : i2 < 24 ? z ? m16447a(2131231570, i2, textFormat) : m16447a(2131231564, i2, textFormat) : i3 == 1 ? z ? m16448a(2131231571, textFormat) : m16448a(2131231565, textFormat) : z ? m16447a(2131231572, i3, textFormat) : m16447a(2131231566, i3, textFormat);
    }

    public final String m16450a(long j, TextFormat textFormat) {
        if (j <= 0) {
            return null;
        }
        int currentTimeMillis = (int) ((System.currentTimeMillis() - j) / 1000);
        int i = currentTimeMillis / 60;
        int i2 = i / 60;
        int i3 = i2 / 24;
        if (currentTimeMillis < 60) {
            return m16447a(2131231584, 1, textFormat);
        }
        if (i < 60) {
            return m16447a(2131231584, i, textFormat);
        }
        if (i2 < 24) {
            return m16447a(2131231585, i2, textFormat);
        }
        return m16447a(2131231586, i3, textFormat);
    }

    public final String m16454b(long j, TextFormat textFormat) {
        if (j <= 0) {
            return null;
        }
        int currentTimeMillis = (int) ((System.currentTimeMillis() - j) / 1000);
        int i = currentTimeMillis / 60;
        int i2 = i / 60;
        int i3 = i2 / 24;
        if (currentTimeMillis < 60) {
            return m16447a(2131231581, 1, textFormat);
        }
        if (i < 60) {
            return m16447a(2131231581, i, textFormat);
        }
        if (i2 < 24) {
            return m16447a(2131231582, i2, textFormat);
        }
        return m16447a(2131231583, i3, textFormat);
    }

    public final String m16452a(Verbosity verbosity, TextFormat textFormat) {
        if (verbosity == Verbosity.SHORT || verbosity == Verbosity.ABBREVIATED) {
            return m16448a(2131231560, textFormat);
        }
        return m16448a(2131231559, textFormat);
    }

    private String m16448a(int i, TextFormat textFormat) {
        if (TextFormat.UPPER_CASE == textFormat) {
            i = m16444a(i);
        }
        return this.f16382a.getString(i);
    }

    private String m16447a(int i, int i2, TextFormat textFormat) {
        if (TextFormat.UPPER_CASE == textFormat) {
            i = m16444a(i);
        }
        return this.f16382a.getString(i, new Object[]{Integer.valueOf(i2)});
    }

    private static int m16444a(int i) {
        if (i == 2131231559) {
            return 2131231587;
        }
        if (i == 2131231560) {
            return 2131231588;
        }
        if (i == 2131231561) {
            return 2131231589;
        }
        if (i == 2131231562) {
            return 2131231590;
        }
        if (i == 2131231563) {
            return 2131231591;
        }
        if (i == 2131231564) {
            return 2131231592;
        }
        if (i == 2131231565) {
            return 2131231593;
        }
        if (i == 2131231566) {
            return 2131231594;
        }
        if (i == 2131231581) {
            return 2131231595;
        }
        if (i == 2131231582) {
            return 2131231596;
        }
        if (i == 2131231583) {
            return 2131231597;
        }
        if (i == 2131231584) {
            return 2131231598;
        }
        if (i == 2131231585) {
            return 2131231599;
        }
        if (i == 2131231586) {
            return 2131231600;
        }
        return i;
    }
}
