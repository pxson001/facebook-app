package com.facebook.groups.memberpicker;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.widget.friendselector.GenericFriendsSelectorFragment;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: extra_album_id */
public class DefaultMemberPickerNavigationHandler {
    private static volatile DefaultMemberPickerNavigationHandler f14558b;
    public final Resources f14559a;

    /* compiled from: extra_album_id */
    public class C15801 extends OnToolbarButtonListener {
        final /* synthetic */ OnClickListener f14556a;
        final /* synthetic */ DefaultMemberPickerNavigationHandler f14557b;

        public C15801(DefaultMemberPickerNavigationHandler defaultMemberPickerNavigationHandler, OnClickListener onClickListener) {
            this.f14557b = defaultMemberPickerNavigationHandler;
            this.f14556a = onClickListener;
        }

        public final void m16401a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            this.f14556a.onClick(view);
        }
    }

    public static com.facebook.groups.memberpicker.DefaultMemberPickerNavigationHandler m16402a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f14558b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.groups.memberpicker.DefaultMemberPickerNavigationHandler.class;
        monitor-enter(r1);
        r0 = f14558b;	 Catch:{ all -> 0x003a }
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
        r0 = m16403b(r0);	 Catch:{ all -> 0x0035 }
        f14558b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f14558b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.memberpicker.DefaultMemberPickerNavigationHandler.a(com.facebook.inject.InjectorLike):com.facebook.groups.memberpicker.DefaultMemberPickerNavigationHandler");
    }

    private static DefaultMemberPickerNavigationHandler m16403b(InjectorLike injectorLike) {
        return new DefaultMemberPickerNavigationHandler(ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public DefaultMemberPickerNavigationHandler(Resources resources) {
        this.f14559a = resources;
    }

    public final void m16404a(FbFragment fbFragment) {
        if (fbFragment instanceof GenericFriendsSelectorFragment) {
            ((GenericFriendsSelectorFragment) fbFragment).aI();
        } else {
            fbFragment.o().onBackPressed();
        }
    }
}
