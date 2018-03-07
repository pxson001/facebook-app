package com.facebook.photos.creativecam.ui;

import android.hardware.Camera;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.facebook.common.util.FindViewUtil;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.creativecam.CreativeCamSource;
import com.facebook.ipc.creativecam.controller.CreativeCamTopBarController;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.creativecam.activity.CreativeEditingCameraFragment.1;
import com.facebook.photos.creativeediting.analytics.CreativeEditingLogger;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: start_id */
public class CreativeCamTopBarControllerImpl implements CreativeCamTopBarController {
    public static final OnTouchListener f2243a = new C02671();
    private static volatile CreativeCamTopBarControllerImpl f2244e;
    public final CreativeEditingLogger f2245b;
    public CreativeCamSource f2246c;
    private View f2247d;

    /* compiled from: start_id */
    final class C02671 implements OnTouchListener {
        C02671() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            GlyphView glyphView = (GlyphView) view;
            switch (motionEvent.getAction()) {
                case 0:
                    glyphView.setGlyphColor(-6842473);
                    break;
                case 1:
                    glyphView.setGlyphColor(-1);
                    glyphView.performClick();
                    break;
                case 3:
                    glyphView.setGlyphColor(-1);
                    break;
            }
            return true;
        }
    }

    public static com.facebook.photos.creativecam.ui.CreativeCamTopBarControllerImpl m2394a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2244e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.photos.creativecam.ui.CreativeCamTopBarControllerImpl.class;
        monitor-enter(r1);
        r0 = f2244e;	 Catch:{ all -> 0x003a }
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
        r0 = m2395b(r0);	 Catch:{ all -> 0x0035 }
        f2244e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2244e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.creativecam.ui.CreativeCamTopBarControllerImpl.a(com.facebook.inject.InjectorLike):com.facebook.photos.creativecam.ui.CreativeCamTopBarControllerImpl");
    }

    private static CreativeCamTopBarControllerImpl m2395b(InjectorLike injectorLike) {
        return new CreativeCamTopBarControllerImpl(CreativeEditingLogger.b(injectorLike));
    }

    @Inject
    public CreativeCamTopBarControllerImpl(CreativeEditingLogger creativeEditingLogger) {
        this.f2245b = creativeEditingLogger;
    }

    @Nullable
    public final View m2396a() {
        return this.f2247d;
    }

    public final ViewGroup m2397a(ViewStub viewStub, final 1 1) {
        viewStub.setLayoutResource(2130903497);
        ViewGroup viewGroup = (ViewGroup) viewStub.inflate();
        GlyphView glyphView = (GlyphView) FindViewUtil.b(viewGroup, 2131559737);
        glyphView.setOnTouchListener(f2243a);
        glyphView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ CreativeCamTopBarControllerImpl f2240b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1242017638);
                1.a();
                this.f2240b.f2245b.c(this.f2240b.f2246c);
                Logger.a(2, EntryType.UI_INPUT_END, -618885626, a);
            }
        });
        glyphView = (GlyphView) FindViewUtil.b(viewGroup, 2131560191);
        if (Camera.getNumberOfCameras() < 2) {
            glyphView.setVisibility(8);
        }
        glyphView.setOnTouchListener(f2243a);
        glyphView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ CreativeCamTopBarControllerImpl f2242b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 553787984);
                1.b();
                Logger.a(2, EntryType.UI_INPUT_END, 1291637489, a);
            }
        });
        this.f2247d = FindViewUtil.b(viewGroup, 2131559849);
        return viewGroup;
    }

    public final void m2398a(ViewGroup viewGroup, ImmutableList<?> immutableList) {
        View b = FindViewUtil.b(viewGroup, 2131560190);
        if (immutableList == null || immutableList.isEmpty()) {
            b.setVisibility(8);
        } else {
            b.setVisibility(0);
        }
    }
}
