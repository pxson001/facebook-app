package com.facebook.saved.binders;

import com.facebook.inject.InjectorLike;
import com.facebook.saved.common.data.SavedDashboardSection;
import com.facebook.saved.common.data.SavedSectionResources;
import com.facebook.saved.common.data.SavedSectionResources.SavedSectionResource;
import com.facebook.saved.views.SavedDashboardEmptyView;
import com.google.common.base.Optional;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: item_explanation */
public class SavedItemsEmptyListViewBinder {
    private static volatile SavedItemsEmptyListViewBinder f8953b;
    public final SavedSectionResources f8954a;

    public static com.facebook.saved.binders.SavedItemsEmptyListViewBinder m8941a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8953b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.saved.binders.SavedItemsEmptyListViewBinder.class;
        monitor-enter(r1);
        r0 = f8953b;	 Catch:{ all -> 0x003a }
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
        r0 = m8942b(r0);	 Catch:{ all -> 0x0035 }
        f8953b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8953b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.saved.binders.SavedItemsEmptyListViewBinder.a(com.facebook.inject.InjectorLike):com.facebook.saved.binders.SavedItemsEmptyListViewBinder");
    }

    private static SavedItemsEmptyListViewBinder m8942b(InjectorLike injectorLike) {
        return new SavedItemsEmptyListViewBinder(SavedSectionResources.a(injectorLike));
    }

    @Inject
    public SavedItemsEmptyListViewBinder(SavedSectionResources savedSectionResources) {
        this.f8954a = savedSectionResources;
    }

    public final void m8943a(SavedDashboardEmptyView savedDashboardEmptyView, Optional<SavedDashboardSection> optional) {
        int i;
        savedDashboardEmptyView.setIcon(2130843241);
        if (!optional.isPresent() || ((SavedDashboardSection) optional.get()).a == null) {
            i = SavedSectionResources.a.b;
        } else {
            i = ((SavedSectionResource) this.f8954a.a(((SavedDashboardSection) optional.get()).a).or(SavedSectionResources.a)).b;
        }
        savedDashboardEmptyView.setTitle(i);
    }
}
