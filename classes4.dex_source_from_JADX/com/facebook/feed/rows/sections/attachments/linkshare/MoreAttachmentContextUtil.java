package com.facebook.feed.rows.sections.attachments.linkshare;

import android.view.ViewGroup.MarginLayoutParams;
import com.facebook.resources.ui.EllipsizingTextView;
import javax.inject.Singleton;

@Singleton
/* compiled from: not a valid representation */
public class MoreAttachmentContextUtil {
    private static volatile MoreAttachmentContextUtil f7004a;

    public static com.facebook.feed.rows.sections.attachments.linkshare.MoreAttachmentContextUtil m7292a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7004a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.feed.rows.sections.attachments.linkshare.MoreAttachmentContextUtil.class;
        monitor-enter(r1);
        r0 = f7004a;	 Catch:{ all -> 0x0039 }
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
        r0 = m7291a();	 Catch:{ all -> 0x0034 }
        f7004a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f7004a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.rows.sections.attachments.linkshare.MoreAttachmentContextUtil.a(com.facebook.inject.InjectorLike):com.facebook.feed.rows.sections.attachments.linkshare.MoreAttachmentContextUtil");
    }

    private static MoreAttachmentContextUtil m7291a() {
        return new MoreAttachmentContextUtil();
    }

    public final void m7293a(int i, EllipsizingTextView ellipsizingTextView, EllipsizingTextView ellipsizingTextView2) {
        int lineHeight = ellipsizingTextView.getLineHeight();
        int lineHeight2 = ellipsizingTextView2.getLineHeight();
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) ellipsizingTextView.getLayoutParams();
        MarginLayoutParams marginLayoutParams2 = (MarginLayoutParams) ellipsizingTextView2.getLayoutParams();
        int i2 = marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
        i2 = i - i2;
        ellipsizingTextView.setMaxLines(((i2 - (marginLayoutParams2.bottomMargin + marginLayoutParams2.topMargin)) - lineHeight2) / lineHeight);
        ellipsizingTextView2.setMaxLines(1);
    }
}
