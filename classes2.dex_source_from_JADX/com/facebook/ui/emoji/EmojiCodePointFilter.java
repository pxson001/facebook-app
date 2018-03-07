package com.facebook.ui.emoji;

import javax.inject.Singleton;

@Singleton
/* compiled from: index */
public class EmojiCodePointFilter {
    private static volatile EmojiCodePointFilter f20231a;

    public static com.facebook.ui.emoji.EmojiCodePointFilter m27891a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f20231a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.ui.emoji.EmojiCodePointFilter.class;
        monitor-enter(r1);
        r0 = f20231a;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x0039 }
        r3 = r2.m1503b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m27890a();	 Catch:{ all -> 0x0034 }
        f20231a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f20231a;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ui.emoji.EmojiCodePointFilter.a(com.facebook.inject.InjectorLike):com.facebook.ui.emoji.EmojiCodePointFilter");
    }

    private static EmojiCodePointFilter m27890a() {
        return new EmojiCodePointFilter();
    }

    public static boolean m27892a(int i, int i2) {
        if (i < 35 || i > 983042) {
            return false;
        }
        if ((i == 35 || (i >= 48 && i <= 57)) && i2 != 8419) {
            return false;
        }
        if (i >= 36 && i <= 47) {
            return false;
        }
        if (i >= 58 && i <= 168) {
            return false;
        }
        if (i < 175 || i > 8481) {
            if ((i >= 128710 && i <= 983039) || i < 35) {
                return false;
            }
            if (i <= 35) {
                return true;
            }
            if (i < 48) {
                return false;
            }
            if (i <= 57) {
                return true;
            }
            if (i < 169) {
                return false;
            }
            if (i <= 174) {
                return true;
            }
            if (i < 8482) {
                return false;
            }
            if (i <= 8618) {
                return true;
            }
            if (i < 8986) {
                return false;
            }
            if (i <= 8987) {
                return true;
            }
            if (i < 9193) {
                return false;
            }
            if (i <= 9196) {
                return true;
            }
            if (i < 9200) {
                return false;
            }
            if (i <= 9203) {
                return true;
            }
            if (i < 9410) {
                return false;
            }
            if (i <= 9410) {
                return true;
            }
            if (i < 9642) {
                return false;
            }
            if (i <= 9726) {
                return true;
            }
            if (i < 9728) {
                return false;
            }
            if (i <= 10084) {
                return true;
            }
            if (i < 10133) {
                return false;
            }
            if (i <= 10135) {
                return true;
            }
            if (i < 10145) {
                return false;
            }
            if (i <= 10175) {
                return true;
            }
            if (i < 10548) {
                return false;
            }
            if (i <= 10549) {
                return true;
            }
            if (i < 11013) {
                return false;
            }
            if (i <= 11015) {
                return true;
            }
            if (i < 11035) {
                return false;
            }
            if (i <= 11036) {
                return true;
            }
            if (i < 11088) {
                return false;
            }
            if (i <= 11088) {
                return true;
            }
            if (i < 11093) {
                return false;
            }
            if (i <= 11093) {
                return true;
            }
            if (i < 12336) {
                return false;
            }
            if (i <= 12336) {
                return true;
            }
            if (i < 12349) {
                return false;
            }
            if (i <= 12349) {
                return true;
            }
            if (i < 12951) {
                return false;
            }
            if (i <= 12953) {
                return true;
            }
            if (i < 57345) {
                return false;
            }
            if (i <= 58678) {
                return true;
            }
            if (i < 126980) {
                return false;
            }
            if (i <= 126980) {
                return true;
            }
            if (i < 127183) {
                return false;
            }
            if (i <= 127183) {
                return true;
            }
            if (i < 127344) {
                return false;
            }
            if (i <= 127386) {
                return true;
            }
            if (i < 127462) {
                return false;
            }
            if (i <= 127487) {
                return true;
            }
            if (i < 127489) {
                return false;
            }
            if (i <= 127569) {
                return true;
            }
            if (i < 127744) {
                return false;
            }
            if (i <= 128709) {
                return true;
            }
            if (i < 983040 || i > 983042) {
                return false;
            }
            return true;
        } else if (i == 8252 || i == 8265) {
            return true;
        } else {
            return false;
        }
    }
}
