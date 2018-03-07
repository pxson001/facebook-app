package com.facebook.feed.rows.core;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.util.SimpleArrayMap;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProviderLazy;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.api.ViewType.LayoutBasedViewType;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: omni */
public class ListItemRowController {
    private static volatile ListItemRowController f11248g;
    public final List<ViewType> f11249a = new ArrayList();
    private final SimpleArrayMap<ViewType, Integer> f11250b = new SimpleArrayMap();
    private final Context f11251c;
    public final DefaultAndroidThreadUtil f11252d;
    public final AbstractFbErrorReporter f11253e;
    @Nullable
    public Lazy<Set<FeedRowSupportDeclaration>> f11254f;

    public static com.facebook.feed.rows.core.ListItemRowController m16554a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11248g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.rows.core.ListItemRowController.class;
        monitor-enter(r1);
        r0 = f11248g;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m16555b(r0);	 Catch:{ all -> 0x0035 }
        f11248g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11248g;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.rows.core.ListItemRowController.a(com.facebook.inject.InjectorLike):com.facebook.feed.rows.core.ListItemRowController");
    }

    private static ListItemRowController m16555b(InjectorLike injectorLike) {
        return new ListItemRowController(ProviderLazy.m1699a(new STATICDI_MULTIBIND_PROVIDER$FeedRowSupportDeclaration(injectorLike.getScopeAwareInjector()), injectorLike.getScopeAwareInjector()), (Context) injectorLike.getInstance(Context.class), DefaultAndroidThreadUtil.m1646b(injectorLike), FbErrorReporterImpl.m2317a(injectorLike));
    }

    @Inject
    public ListItemRowController(Lazy<Set<FeedRowSupportDeclaration>> lazy, Context context, AndroidThreadUtil androidThreadUtil, FbErrorReporter fbErrorReporter) {
        this.f11254f = lazy;
        this.f11251c = context;
        this.f11252d = androidThreadUtil;
        this.f11253e = fbErrorReporter;
    }

    public final void m16558a(ViewType viewType) {
        if (!this.f11250b.containsKey(viewType)) {
            m16556c(viewType);
        }
    }

    private int m16556c(ViewType viewType) {
        Preconditions.checkNotNull(viewType);
        int size = this.f11249a.size();
        this.f11249a.add(viewType);
        this.f11250b.put(viewType, Integer.valueOf(size));
        return size;
    }

    public final ViewType m16557a(int i) {
        return (ViewType) this.f11249a.get(i);
    }

    public final int m16559b(ViewType viewType) {
        Preconditions.checkNotNull(viewType);
        Integer num = (Integer) this.f11250b.get(viewType);
        if (num != null) {
            return num.intValue();
        }
        if (this.f11254f != null) {
            return m16556c(viewType);
        }
        String str;
        if (viewType instanceof LayoutBasedViewType) {
            LayoutBasedViewType layoutBasedViewType = (LayoutBasedViewType) viewType;
            str = "LayoutBasedViewType of " + this.f11251c.getResources().getResourceName(layoutBasedViewType.f23287a);
        } else {
            str = viewType.toString();
        }
        throw new IllegalArgumentException(str + " is not registered");
    }
}
