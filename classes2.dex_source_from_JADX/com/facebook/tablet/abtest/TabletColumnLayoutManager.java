package com.facebook.tablet.abtest;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.TypedValue;
import com.facebook.common.fragmentconstants.FragmentConstants$ContentFragmentType;
import com.facebook.device.ScreenUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.today.abtest.ExperimentsForTodayAbTestModule;
import com.facebook.today.abtest.TodayExperimentController;
import com.facebook.widget.CustomViewUtils;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: show_navigation_events */
public class TabletColumnLayoutManager {
    private static final FragmentConstants$ContentFragmentType[] f4865d = new FragmentConstants$ContentFragmentType[]{FragmentConstants$ContentFragmentType.FRIEND_REQUESTS_FRAGMENT, FragmentConstants$ContentFragmentType.NOTIFICATIONS_FRAGMENT, FragmentConstants$ContentFragmentType.NOTIFICATIONS_FRIENDING_FRAGMENT, FragmentConstants$ContentFragmentType.BOOKMARKS_FRAGMENT, FragmentConstants$ContentFragmentType.THREAD_LIST_FRAGMENT, FragmentConstants$ContentFragmentType.BOOKMARKS_SECTION_FRAGMENT};
    private static final Set<FragmentConstants$ContentFragmentType> f4866e = new HashSet(Arrays.asList(f4865d));
    private static volatile TabletColumnLayoutManager f4867f;
    private TabletExperimentConfiguration f4868a;
    private TodayExperimentController f4869b;
    private ScreenUtil f4870c;

    /* compiled from: show_navigation_events */
    public class ColumnWidthConfig {
        public int f7372a;
        public int f7373b;
        public int f7374c;
        public int f7375d;
        public int f7376e;

        public final boolean m12008a() {
            return this.f7373b > 0;
        }

        public final int m12010h() {
            return this.f7374c;
        }

        public final int m12009g() {
            return this.f7373b + this.f7376e;
        }

        public final int m12011i() {
            if (m12008a()) {
                return this.f7376e;
            }
            return this.f7375d;
        }
    }

    public static com.facebook.tablet.abtest.TabletColumnLayoutManager m8710a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4867f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.tablet.abtest.TabletColumnLayoutManager.class;
        monitor-enter(r1);
        r0 = f4867f;	 Catch:{ all -> 0x003a }
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
        r0 = m8712b(r0);	 Catch:{ all -> 0x0035 }
        f4867f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4867f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.tablet.abtest.TabletColumnLayoutManager.a(com.facebook.inject.InjectorLike):com.facebook.tablet.abtest.TabletColumnLayoutManager");
    }

    private static TabletColumnLayoutManager m8712b(InjectorLike injectorLike) {
        return new TabletColumnLayoutManager(TabletExperimentConfiguration.m7856a(injectorLike), TodayExperimentController.m8720a(injectorLike), ScreenUtil.m8695a(injectorLike));
    }

    @Inject
    public TabletColumnLayoutManager(TabletExperimentConfiguration tabletExperimentConfiguration, TodayExperimentController todayExperimentController, ScreenUtil screenUtil) {
        this.f4868a = tabletExperimentConfiguration;
        this.f4869b = todayExperimentController;
        this.f4870c = screenUtil;
    }

    public final void m8715a(FragmentConstants$ContentFragmentType fragmentConstants$ContentFragmentType, Context context, SwipeRefreshLayout swipeRefreshLayout, int i) {
        Resources resources = context.getResources();
        CustomViewUtils.m30286b(swipeRefreshLayout, new ColorDrawable(resources.getColor(2131362032)));
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        int color = resources.getColor(typedValue.resourceId);
        ColumnWidthConfig b = m8718b(fragmentConstants$ContentFragmentType);
        Drawable layerDrawable = new LayerDrawable(new Drawable[]{new ColorDrawable(color)});
        layerDrawable.setLayerInset(0, b.f7374c, 0, b.f7375d, 0);
        CustomViewUtils.m30286b(swipeRefreshLayout, layerDrawable);
        swipeRefreshLayout.setPadding(b.f7374c, swipeRefreshLayout.getPaddingTop(), b.f7375d, swipeRefreshLayout.getPaddingBottom());
    }

    private boolean m8713d() {
        return this.f4870c.m8703d() > this.f4870c.m8702c();
    }

    private ColumnWidthConfig m8709a(int i) {
        ColumnWidthConfig columnWidthConfig = new ColumnWidthConfig();
        float b = this.f4870c.m8701b();
        int round = Math.round(32.0f * b);
        int i2 = i - (round * 2);
        columnWidthConfig.f7372a = Math.min(i2, Math.round(b * 712.0f));
        int i3 = i2 - columnWidthConfig.f7372a;
        columnWidthConfig.f7374c = (i3 / 2) + round;
        columnWidthConfig.f7375d = (i3 / 2) + round;
        return columnWidthConfig;
    }

    private ColumnWidthConfig m8711b(int i) {
        ColumnWidthConfig columnWidthConfig = new ColumnWidthConfig();
        float b = this.f4870c.m8701b();
        int round = Math.round(32.0f * b);
        int round2 = Math.round(8.0f * b);
        int round3 = Math.round(296.0f * b);
        int round4 = Math.round(b * 712.0f);
        columnWidthConfig.f7373b = round3;
        columnWidthConfig.f7375d = round2;
        round2 = ((i - (round * 2)) - round2) - round3;
        columnWidthConfig.f7372a = Math.min(round2, round4);
        round4 = round2 - columnWidthConfig.f7372a;
        columnWidthConfig.f7374c = (round4 / 2) + round;
        columnWidthConfig.f7376e = (round4 / 2) + round;
        return columnWidthConfig;
    }

    public final int m8714a() {
        return Math.max(m8709a(this.f4870c.m8702c()).f7372a, m8711b(this.f4870c.m8703d()).f7372a);
    }

    public final boolean m8716a(FragmentConstants$ContentFragmentType fragmentConstants$ContentFragmentType) {
        if (!this.f4868a.m7859b()) {
            return false;
        }
        if (FragmentConstants$ContentFragmentType.TODAY_FRAGMENT.equals(fragmentConstants$ContentFragmentType)) {
            return this.f4869b.f4873b.mo596a(ExperimentsForTodayAbTestModule.f8104U, true);
        }
        if (f4866e.contains(fragmentConstants$ContentFragmentType)) {
            return false;
        }
        return true;
    }

    public final ColumnWidthConfig m8718b(@Nullable FragmentConstants$ContentFragmentType fragmentConstants$ContentFragmentType) {
        int c = this.f4870c.m8702c();
        Object obj = (!m8716a(fragmentConstants$ContentFragmentType) || m8713d()) ? null : 1;
        if (obj != null) {
            return m8711b(c);
        }
        return m8709a(c);
    }

    public final ColumnWidthConfig m8717b() {
        int c = this.f4870c.m8702c();
        if (m8713d()) {
            return m8709a(c);
        }
        return m8711b(c);
    }

    public final int m8719c() {
        return m8718b(FragmentConstants$ContentFragmentType.NATIVE_NEWS_FEED_FRAGMENT).f7372a;
    }
}
