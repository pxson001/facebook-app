package com.facebook.contacts.pictures;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.util.SizeUtil;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: education_banner_nux_config */
public class ContactPictureSizes {
    private static volatile ContactPictureSizes f13279b;
    private final ImmutableMap<Size, Integer> f13280a;

    /* compiled from: education_banner_nux_config */
    public enum Size {
        SMALL(50),
        BIG(80),
        HUGE(320);
        
        public final int dp;

        private Size(int i) {
            this.dp = i;
        }
    }

    public static com.facebook.contacts.pictures.ContactPictureSizes m14161a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f13279b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.contacts.pictures.ContactPictureSizes.class;
        monitor-enter(r1);
        r0 = f13279b;	 Catch:{ all -> 0x003a }
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
        r0 = m14162b(r0);	 Catch:{ all -> 0x0035 }
        f13279b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13279b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.contacts.pictures.ContactPictureSizes.a(com.facebook.inject.InjectorLike):com.facebook.contacts.pictures.ContactPictureSizes");
    }

    private static ContactPictureSizes m14162b(InjectorLike injectorLike) {
        return new ContactPictureSizes(ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ContactPictureSizes(Resources resources) {
        this.f13280a = new Builder().b(Size.SMALL, Integer.valueOf(SizeUtil.a(resources, (float) Size.SMALL.dp))).b(Size.BIG, Integer.valueOf(SizeUtil.a(resources, (float) Size.BIG.dp))).b(Size.HUGE, Integer.valueOf(SizeUtil.a(resources, (float) Size.HUGE.dp))).b();
    }

    public final String m14164a() {
        return Joiner.on(",").join(this.f13280a.values());
    }

    public final int m14163a(Size size) {
        return ((Integer) this.f13280a.get(size)).intValue();
    }

    public final String m14165b(Size size) {
        return Integer.toString(m14163a(size));
    }
}
