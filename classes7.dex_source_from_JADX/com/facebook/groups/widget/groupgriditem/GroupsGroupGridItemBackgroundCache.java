package com.facebook.groups.widget.groupgriditem;

import javax.inject.Singleton;

@Singleton
/* compiled from: profile_image */
public class GroupsGroupGridItemBackgroundCache {
    private static DrawableDefinition[] f5918a = new DrawableDefinition[]{m7545a(-41414, -54680), m7545a(-27392, -41414), m7545a(-9396, -13054), m7545a(-7865232, -16002280), m7545a(-11342393, -10827525), m7545a(-15018243, -14851344), m7545a(-3783428, -10987818), m7545a(-1094218, -3783684), m7545a(-11908534, -13948117), m7545a(-2368034, -7762800), m7544a(-50384), m7544a(-27392), m7544a(-13312), m7544a(-11740828), m7544a(-13325604), m7544a(-16745729), m7544a(-10987818), m7544a(-53931), m7544a(-7434605), m7544a(-3684404), m7545a(-10824665, -5970042), m7545a(-3641633, -1787920), m7544a(-3019012), m7544a(-2033448), m7545a(-316567, -42185), m7545a(-526345, -2631721), m7545a(-14845969, -8260611), m7545a(-2699581, -1778230), m7545a(-11145269, -10761473), m7544a(-46719), m7544a(-11296), m7544a(-526345), m7544a(-60672), m7544a(-14737631), m7544a(-4342078), m7544a(-50643)};
    private static volatile GroupsGroupGridItemBackgroundCache f5919b;

    /* compiled from: profile_image */
    abstract class DrawableDefinition {
    }

    /* compiled from: profile_image */
    class ColorDefinition extends DrawableDefinition {
        private final int f5916a;

        public ColorDefinition(int i) {
            this.f5916a = i;
        }
    }

    /* compiled from: profile_image */
    class GradientDefinition extends DrawableDefinition {
        private final int[] f5917a;

        protected GradientDefinition(int i, int i2) {
            this.f5917a = new int[]{i, i2};
        }
    }

    public static com.facebook.groups.widget.groupgriditem.GroupsGroupGridItemBackgroundCache m7547a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f5919b;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.groups.widget.groupgriditem.GroupsGroupGridItemBackgroundCache.class;
        monitor-enter(r1);
        r0 = f5919b;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m7546a();	 Catch:{ all -> 0x0034 }
        f5919b = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f5919b;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.widget.groupgriditem.GroupsGroupGridItemBackgroundCache.a(com.facebook.inject.InjectorLike):com.facebook.groups.widget.groupgriditem.GroupsGroupGridItemBackgroundCache");
    }

    private static GroupsGroupGridItemBackgroundCache m7546a() {
        return new GroupsGroupGridItemBackgroundCache();
    }

    private static DrawableDefinition m7544a(int i) {
        return new ColorDefinition(i);
    }

    private static DrawableDefinition m7545a(int i, int i2) {
        return new GradientDefinition(i, i2);
    }
}
