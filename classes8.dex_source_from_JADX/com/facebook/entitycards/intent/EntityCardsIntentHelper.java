package com.facebook.entitycards.intent;

import com.facebook.entitycards.collect.ImmutableOffsetArray;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Singleton;

@Singleton
/* compiled from: image_large_thumbnail_width */
public class EntityCardsIntentHelper {
    private static volatile EntityCardsIntentHelper f10989a;

    /* compiled from: image_large_thumbnail_width */
    public final class EntityRange {
        public final ImmutableList<String> f10984a;
        public final String f10985b;
        public final ImmutableOffsetArray<String> f10986c;
        public final int f10987d;
        public final int f10988e;

        public EntityRange(ImmutableList<String> immutableList, String str, ImmutableOffsetArray<String> immutableOffsetArray, int i, int i2) {
            this.f10984a = immutableList;
            this.f10985b = str;
            this.f10986c = immutableOffsetArray;
            this.f10987d = i;
            this.f10988e = i2;
        }
    }

    public static com.facebook.entitycards.intent.EntityCardsIntentHelper m12923a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10989a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.entitycards.intent.EntityCardsIntentHelper.class;
        monitor-enter(r1);
        r0 = f10989a;	 Catch:{ all -> 0x0039 }
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
        r0 = m12922a();	 Catch:{ all -> 0x0034 }
        f10989a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f10989a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.entitycards.intent.EntityCardsIntentHelper.a(com.facebook.inject.InjectorLike):com.facebook.entitycards.intent.EntityCardsIntentHelper");
    }

    private static EntityCardsIntentHelper m12922a() {
        return new EntityCardsIntentHelper();
    }

    public static EntityRange m12921a(ImmutableList<String> immutableList, String str) {
        int indexOf = immutableList.indexOf(str);
        Preconditions.checkArgument(indexOf >= 0, "Selected ID is not in list!");
        int max = Math.max(0, indexOf - 2);
        int min = Math.min(indexOf + 2, immutableList.size() - 1);
        ImmutableOffsetArray a = ImmutableOffsetArray.m12843a(max, immutableList.subList(max, min + 1));
        a.m12844a();
        return new EntityRange(immutableList, str, a, max, min);
    }
}
