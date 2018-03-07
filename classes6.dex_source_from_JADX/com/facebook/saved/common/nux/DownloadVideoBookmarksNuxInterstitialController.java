package com.facebook.saved.common.nux;

import android.content.Context;
import com.facebook.apptab.interfaces.AppTabHost;
import com.facebook.apptab.state.TabTag;
import com.facebook.common.queryinterface.ProvidesInterface;
import com.facebook.common.util.ContextUtils;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.interstitial.manager.BaseInterstitialController;
import com.facebook.interstitial.manager.InterstitialActionController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.google.common.collect.ImmutableList;
import javax.inject.Singleton;

@Singleton
/* compiled from: setDisablePhotos */
public class DownloadVideoBookmarksNuxInterstitialController extends BaseInterstitialController implements InterstitialActionController {
    private static volatile DownloadVideoBookmarksNuxInterstitialController f4842a;

    public static com.facebook.saved.common.nux.DownloadVideoBookmarksNuxInterstitialController m7648a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4842a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.saved.common.nux.DownloadVideoBookmarksNuxInterstitialController.class;
        monitor-enter(r1);
        r0 = f4842a;	 Catch:{ all -> 0x0039 }
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
        r0 = m7649d();	 Catch:{ all -> 0x0034 }
        f4842a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f4842a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.saved.common.nux.DownloadVideoBookmarksNuxInterstitialController.a(com.facebook.inject.InjectorLike):com.facebook.saved.common.nux.DownloadVideoBookmarksNuxInterstitialController");
    }

    private static DownloadVideoBookmarksNuxInterstitialController m7649d() {
        return new DownloadVideoBookmarksNuxInterstitialController();
    }

    public final void m7651a(Context context, Object obj) {
        ProvidesInterface providesInterface = (ProvidesInterface) ContextUtils.a(context, ProvidesInterface.class);
        if (providesInterface != null) {
            AppTabHost appTabHost = (AppTabHost) providesInterface.a(AppTabHost.class);
            if (appTabHost != null) {
                Tooltip tooltip = new Tooltip(context, 2);
                tooltip.t = -1;
                tooltip.b(context.getText(2131232747));
                appTabHost.a(TabTag.Bookmark, tooltip);
            }
        }
    }

    public final String m7652b() {
        return "4163";
    }

    public final InterstitialControllerState m7650a(InterstitialTrigger interstitialTrigger) {
        return InterstitialControllerState.ELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m7653c() {
        return ImmutableList.of(new InterstitialTrigger(Action.VIDEO_DOWNLOAD));
    }
}
