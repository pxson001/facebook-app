package com.facebook.groups.navigation;

import android.view.View;
import com.facebook.base.fragment.FbFragment;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.HasTitleBar;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import javax.annotation.Nullable;
import javax.inject.Singleton;

@Singleton
/* compiled from: entity_cards_config_extras */
public class DefaultGroupsNavigationHandler implements GroupsNavigationHandler {
    private static volatile DefaultGroupsNavigationHandler f14798a;

    public static com.facebook.groups.navigation.DefaultGroupsNavigationHandler m17162a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f14798a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.groups.navigation.DefaultGroupsNavigationHandler.class;
        monitor-enter(r1);
        r0 = f14798a;	 Catch:{ all -> 0x0039 }
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
        r0 = m17161a();	 Catch:{ all -> 0x0034 }
        f14798a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f14798a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.navigation.DefaultGroupsNavigationHandler.a(com.facebook.inject.InjectorLike):com.facebook.groups.navigation.DefaultGroupsNavigationHandler");
    }

    private static DefaultGroupsNavigationHandler m17161a() {
        return new DefaultGroupsNavigationHandler();
    }

    public final void mo896a(FbFragment fbFragment, String str, @Nullable GroupsNavigationSecondaryActionDelegate groupsNavigationSecondaryActionDelegate) {
        HasTitleBar hasTitleBar = (HasTitleBar) fbFragment.a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.a_(str);
            mo895a(fbFragment, groupsNavigationSecondaryActionDelegate);
        }
    }

    public final void mo895a(FbFragment fbFragment, final GroupsNavigationSecondaryActionDelegate groupsNavigationSecondaryActionDelegate) {
        HasTitleBar hasTitleBar = (HasTitleBar) fbFragment.a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.c(true);
            if (groupsNavigationSecondaryActionDelegate != null && groupsNavigationSecondaryActionDelegate.mo882d()) {
                Builder a = TitleBarButtonSpec.a();
                a.b = groupsNavigationSecondaryActionDelegate.mo879a();
                a = a;
                a.j = groupsNavigationSecondaryActionDelegate.mo880b();
                hasTitleBar.a(a.a());
                hasTitleBar.a(new OnToolbarButtonListener(this) {
                    final /* synthetic */ DefaultGroupsNavigationHandler f14797b;

                    public final void m17158a(View view, TitleBarButtonSpec titleBarButtonSpec) {
                        groupsNavigationSecondaryActionDelegate.mo881c();
                    }
                });
            }
        }
    }
}
