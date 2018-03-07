package com.facebook.messaging.media.upload;

import android.content.Intent;
import android.graphics.drawable.TransitionDrawable;
import android.view.View;
import android.widget.ProgressBar;
import com.facebook.messaging.media.upload.MessageMediaUploadState.UploadState;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: listed_amount */
public class MediaUploadStatusUtil {
    private static volatile MediaUploadStatusUtil f11971b;
    private boolean f11972a;

    public static com.facebook.messaging.media.upload.MediaUploadStatusUtil m12522a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11971b;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.messaging.media.upload.MediaUploadStatusUtil.class;
        monitor-enter(r1);
        r0 = f11971b;	 Catch:{ all -> 0x0039 }
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
        r0 = m12521a();	 Catch:{ all -> 0x0034 }
        f11971b = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f11971b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.media.upload.MediaUploadStatusUtil.a(com.facebook.inject.InjectorLike):com.facebook.messaging.media.upload.MediaUploadStatusUtil");
    }

    private static MediaUploadStatusUtil m12521a() {
        return new MediaUploadStatusUtil();
    }

    @Inject
    public MediaUploadStatusUtil() {
        UploadState uploadState = UploadState.FAILED;
    }

    public final void m12524a(Intent intent, ProgressBar progressBar, View view) {
        if (progressBar != null && view != null) {
            if (intent == null) {
                progressBar.setVisibility(8);
                m12523a(false, view);
            } else if ("com.facebook.orca.media.upload.PROCESS_MEDIA_COMPLETE".equals(intent.getAction())) {
                progressBar.setVisibility(8);
                m12523a(false, view);
            } else if ("com.facebook.orca.media.upload.PROCESS_MEDIA_TOTAL_PROGRESS".equals(intent.getAction())) {
                double doubleExtra = intent.getDoubleExtra("p", -1.0d);
                if (doubleExtra == -1.0d) {
                    progressBar.setVisibility(8);
                    m12523a(true, view);
                    return;
                }
                m12523a(true, view);
                progressBar.setVisibility(0);
                progressBar.setProgress((int) (doubleExtra * 100.0d));
                progressBar.setMax(100);
            }
        }
    }

    private void m12523a(boolean z, View view) {
        if (z && !this.f11972a) {
            view.setVisibility(0);
            this.f11972a = true;
            ((TransitionDrawable) view.getBackground()).startTransition(0);
        }
        if (!z && this.f11972a) {
            ((TransitionDrawable) view.getBackground()).reverseTransition(300);
            this.f11972a = false;
            view.setVisibility(8);
        }
    }
}
