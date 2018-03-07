package com.facebook.video.formatting;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: composer_publish_start */
public class VideoStringsFormatter {
    private static volatile VideoStringsFormatter f18953b;
    private final Resources f18954a;

    public static com.facebook.video.formatting.VideoStringsFormatter m27625a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f18953b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.formatting.VideoStringsFormatter.class;
        monitor-enter(r1);
        r0 = f18953b;	 Catch:{ all -> 0x003a }
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
        r0 = m27626b(r0);	 Catch:{ all -> 0x0035 }
        f18953b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f18953b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.formatting.VideoStringsFormatter.a(com.facebook.inject.InjectorLike):com.facebook.video.formatting.VideoStringsFormatter");
    }

    private static VideoStringsFormatter m27626b(InjectorLike injectorLike) {
        return new VideoStringsFormatter(ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public VideoStringsFormatter(Resources resources) {
        this.f18954a = resources;
    }

    public final String m27628a(long j) {
        int i = (int) ((j % 3600000) / 60000);
        int i2 = (int) (((j % 3600000) % 60000) / 1000);
        if (((int) (j / 3600000)) > 0) {
            Resources resources = this.f18954a;
            r5 = new Object[3];
            r5[0] = StringFormatUtil.a("%d", new Object[]{Integer.valueOf(r0)});
            r5[1] = StringFormatUtil.a("%02d", new Object[]{Integer.valueOf(i)});
            r5[2] = StringFormatUtil.a("%02d", new Object[]{Integer.valueOf(i2)});
            return resources.getString(2131236131, r5);
        }
        Resources resources2 = this.f18954a;
        r4 = new Object[2];
        r4[0] = StringFormatUtil.a("%d", new Object[]{Integer.valueOf(i)});
        r4[1] = StringFormatUtil.a("%02d", new Object[]{Integer.valueOf(i2)});
        return resources2.getString(2131236132, r4);
    }

    public final String m27627a(int i) {
        if (((double) i) <= 10485.76d) {
            return null;
        }
        String a = StringFormatUtil.a("%01.2f", new Object[]{Float.valueOf(((float) i) / 1048576.0f)});
        return this.f18954a.getString(2131236133, new Object[]{a});
    }
}
