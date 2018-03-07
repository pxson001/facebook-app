package com.facebook.heisman;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.Toolbar.OnMenuItemClickListener;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.creativecam.activity.CreativeEditingCameraFragment.1;
import com.facebook.qe.api.QeAccessor;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.UltralightRuntime;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: vAlignment */
public class ProfilePictureOverlayCameraToolbarBinder {
    private static volatile ProfilePictureOverlayCameraToolbarBinder f712f;
    @Inject
    public volatile Provider<QeAccessor> f713a = UltralightRuntime.a;
    @Inject
    public GlyphColorizer f714b;
    @Inject
    public AllCapsTransformationMethod f715c;
    @Inject
    public Resources f716d;
    @Inject
    private Context f717e;

    /* compiled from: vAlignment */
    public class C00881 implements OnClickListener {
        final /* synthetic */ 1 f708a;
        final /* synthetic */ ProfilePictureOverlayCameraToolbarBinder f709b;

        public C00881(ProfilePictureOverlayCameraToolbarBinder profilePictureOverlayCameraToolbarBinder, 1 1) {
            this.f709b = profilePictureOverlayCameraToolbarBinder;
            this.f708a = 1;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1450273473);
            this.f708a.a();
            Logger.a(2, EntryType.UI_INPUT_END, -46991789, a);
        }
    }

    /* compiled from: vAlignment */
    public class C00892 implements OnMenuItemClickListener {
        final /* synthetic */ 1 f710a;
        final /* synthetic */ ProfilePictureOverlayCameraToolbarBinder f711b;

        public C00892(ProfilePictureOverlayCameraToolbarBinder profilePictureOverlayCameraToolbarBinder, 1 1) {
            this.f711b = profilePictureOverlayCameraToolbarBinder;
            this.f710a = 1;
        }

        public final boolean m773a(MenuItem menuItem) {
            if (menuItem.getItemId() != 1) {
                return false;
            }
            this.f710a.b();
            return true;
        }
    }

    public static com.facebook.heisman.ProfilePictureOverlayCameraToolbarBinder m774a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f712f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.heisman.ProfilePictureOverlayCameraToolbarBinder.class;
        monitor-enter(r1);
        r0 = f712f;	 Catch:{ all -> 0x003a }
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
        r0 = m776b(r0);	 Catch:{ all -> 0x0035 }
        f712f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f712f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.heisman.ProfilePictureOverlayCameraToolbarBinder.a(com.facebook.inject.InjectorLike):com.facebook.heisman.ProfilePictureOverlayCameraToolbarBinder");
    }

    private static ProfilePictureOverlayCameraToolbarBinder m776b(InjectorLike injectorLike) {
        ProfilePictureOverlayCameraToolbarBinder profilePictureOverlayCameraToolbarBinder = new ProfilePictureOverlayCameraToolbarBinder();
        profilePictureOverlayCameraToolbarBinder.m775a(IdBasedSingletonScopeProvider.a(injectorLike, 3219), GlyphColorizer.a(injectorLike), AllCapsTransformationMethod.b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), (Context) injectorLike.getInstance(Context.class));
        return profilePictureOverlayCameraToolbarBinder;
    }

    private void m775a(Provider<QeAccessor> provider, GlyphColorizer glyphColorizer, AllCapsTransformationMethod allCapsTransformationMethod, Resources resources, Context context) {
        this.f713a = provider;
        this.f714b = glyphColorizer;
        this.f715c = allCapsTransformationMethod;
        this.f716d = resources;
        this.f717e = context;
    }
}
