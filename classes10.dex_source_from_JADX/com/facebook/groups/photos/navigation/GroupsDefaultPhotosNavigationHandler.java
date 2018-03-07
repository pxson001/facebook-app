package com.facebook.groups.photos.navigation;

import android.view.View;
import com.facebook.base.fragment.FbFragment;
import com.facebook.groups.navigation.GroupsNavigationHandler;
import com.facebook.groups.navigation.GroupsNavigationSecondaryActionDelegate;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.HasTitleBar;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import javax.annotation.Nullable;
import javax.inject.Singleton;

@Singleton
/* compiled from: TOXICLE_MESSAGE_INVITER_BAR */
public class GroupsDefaultPhotosNavigationHandler implements GroupsNavigationHandler {
    private static volatile GroupsDefaultPhotosNavigationHandler f23058a;

    public static com.facebook.groups.photos.navigation.GroupsDefaultPhotosNavigationHandler m24266a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f23058a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.groups.photos.navigation.GroupsDefaultPhotosNavigationHandler.class;
        monitor-enter(r1);
        r0 = f23058a;	 Catch:{ all -> 0x0039 }
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
        r0 = m24265a();	 Catch:{ all -> 0x0034 }
        f23058a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f23058a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.photos.navigation.GroupsDefaultPhotosNavigationHandler.a(com.facebook.inject.InjectorLike):com.facebook.groups.photos.navigation.GroupsDefaultPhotosNavigationHandler");
    }

    private static GroupsDefaultPhotosNavigationHandler m24265a() {
        return new GroupsDefaultPhotosNavigationHandler();
    }

    public final void m24268a(FbFragment fbFragment, String str, @Nullable GroupsNavigationSecondaryActionDelegate groupsNavigationSecondaryActionDelegate) {
        HasTitleBar hasTitleBar = (HasTitleBar) fbFragment.a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.a_(str);
            m24267a(fbFragment, groupsNavigationSecondaryActionDelegate);
        }
    }

    public final void m24267a(FbFragment fbFragment, final GroupsNavigationSecondaryActionDelegate groupsNavigationSecondaryActionDelegate) {
        HasTitleBar hasTitleBar = (HasTitleBar) fbFragment.a(HasTitleBar.class);
        if (hasTitleBar != null && groupsNavigationSecondaryActionDelegate != null && groupsNavigationSecondaryActionDelegate.d()) {
            Builder a = TitleBarButtonSpec.a();
            a.b = groupsNavigationSecondaryActionDelegate.a();
            a = a;
            a.j = groupsNavigationSecondaryActionDelegate.b();
            hasTitleBar.a(a.a());
            hasTitleBar.a(new OnToolbarButtonListener(this) {
                final /* synthetic */ GroupsDefaultPhotosNavigationHandler f23057b;

                public final void m24264a(View view, TitleBarButtonSpec titleBarButtonSpec) {
                    groupsNavigationSecondaryActionDelegate.c();
                }
            });
        }
    }
}
