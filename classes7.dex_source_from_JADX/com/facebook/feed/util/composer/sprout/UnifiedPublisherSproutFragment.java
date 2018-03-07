package com.facebook.feed.util.composer.sprout;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.analytics.NavigationLogger;
import com.facebook.feed.util.composer.sprout.SproutAnalyticsLogger.SproutSource;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.springs.SpringUtil;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.facebook.uicontrib.fab.FabDrawable.FabType;
import com.facebook.uicontrib.fab.FabView;
import com.facebook.uicontrib.fab.FabWithLabelView;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Iterator;
import java.util.Map.Entry;
import javax.inject.Inject;

/* compiled from: TRETURN_TYPE; */
public class UnifiedPublisherSproutFragment extends FbDialogFragment {
    @Inject
    public SpringSystem am;
    @Inject
    public SproutAnalyticsLoggerProvider an;
    @Inject
    public Lazy<NavigationLogger> ao;
    public SproutSource ap;
    public String aq;
    public ImmutableList<LauncherSpec> ar;
    public LauncherSpec as;
    public Spring at;
    public SproutAnalyticsLogger au;
    public LinearLayout av;
    public ImmutableMap<LauncherSpec, LauncherInfo> aw;
    private boolean ax = false;
    private final OnGlobalLayoutListener ay = new C19371(this);

    /* compiled from: TRETURN_TYPE; */
    class C19371 implements OnGlobalLayoutListener {
        final /* synthetic */ UnifiedPublisherSproutFragment f22474a;

        C19371(UnifiedPublisherSproutFragment unifiedPublisherSproutFragment) {
            this.f22474a = unifiedPublisherSproutFragment;
        }

        public void onGlobalLayout() {
            if (this.f22474a.T != null) {
                this.f22474a.av.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                int[] iArr = new int[]{0, 0};
                ((LauncherInfo) this.f22474a.aw.get(this.f22474a.as)).f22479a.getLocationOnScreen(iArr);
                int i = iArr[1];
                Iterator it = this.f22474a.aw.values().iterator();
                while (it.hasNext()) {
                    LauncherInfo launcherInfo = (LauncherInfo) it.next();
                    launcherInfo.f22479a.getLocationOnScreen(iArr);
                    launcherInfo.f22480b = Optional.of(Integer.valueOf((this.f22474a.jW_().getDimensionPixelSize(2131427817) + i) - iArr[1]));
                }
                this.f22474a.at.b(1.0d);
            }
        }
    }

    /* compiled from: TRETURN_TYPE; */
    public class C19404 implements OnClickListener {
        final /* synthetic */ UnifiedPublisherSproutFragment f22478a;

        public C19404(UnifiedPublisherSproutFragment unifiedPublisherSproutFragment) {
            this.f22478a = unifiedPublisherSproutFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 593826008);
            ((NavigationLogger) this.f22478a.ao.get()).a("tap_outside");
            UnifiedPublisherSproutFragment.at(this.f22478a);
            Logger.a(2, EntryType.UI_INPUT_END, 2137118887, a);
        }
    }

    /* compiled from: TRETURN_TYPE; */
    public class LauncherInfo {
        public final FabWithLabelView f22479a;
        Optional<Integer> f22480b = Absent.INSTANCE;

        public LauncherInfo(View view) {
            this.f22479a = (FabWithLabelView) view;
        }
    }

    /* compiled from: TRETURN_TYPE; */
    public class LauncherSpec {
        @ColorRes
        public final int f22481a;
        @DrawableRes
        public final int f22482b;
        public final String f22483c;
        public final String f22484d;
        public final Runnable f22485e;

        public LauncherSpec(@ColorRes int i, @DrawableRes int i2, String str, String str2, Runnable runnable) {
            this.f22481a = i;
            this.f22482b = i2;
            this.f22483c = str;
            this.f22484d = str2;
            this.f22485e = runnable;
        }
    }

    /* compiled from: TRETURN_TYPE; */
    class SpringListener extends SimpleSpringListener {
        final /* synthetic */ UnifiedPublisherSproutFragment f22486a;

        public SpringListener(UnifiedPublisherSproutFragment unifiedPublisherSproutFragment) {
            this.f22486a = unifiedPublisherSproutFragment;
        }

        public final void m25062a(Spring spring) {
            float d = (float) spring.d();
            this.f22486a.av.setAlpha(d);
            LauncherInfo launcherInfo = (LauncherInfo) this.f22486a.aw.get(this.f22486a.as);
            launcherInfo.f22479a.a.setAlpha(d);
            launcherInfo.f22479a.a.setRotation((float) SpringUtil.a((double) d, 0.0d, 1.0d, 0.0d, 360.0d));
            Iterator it = this.f22486a.aw.entrySet().iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                if (entry.getKey() != this.f22486a.as) {
                    launcherInfo = (LauncherInfo) entry.getValue();
                    if (launcherInfo.f22480b.isPresent()) {
                        launcherInfo.f22479a.setTranslationY(((float) ((Integer) launcherInfo.f22480b.get()).intValue()) - (((float) ((Integer) launcherInfo.f22480b.get()).intValue()) * d));
                    }
                }
            }
        }

        public final void m25063b(Spring spring) {
            if (spring.g(0.0d)) {
                this.f22486a.a();
            }
        }
    }

    public static void m25065a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        UnifiedPublisherSproutFragment unifiedPublisherSproutFragment = (UnifiedPublisherSproutFragment) obj;
        SpringSystem b = SpringSystem.b(fbInjector);
        SproutAnalyticsLoggerProvider sproutAnalyticsLoggerProvider = (SproutAnalyticsLoggerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(SproutAnalyticsLoggerProvider.class);
        Lazy b2 = IdBasedSingletonScopeProvider.b(fbInjector, 137);
        unifiedPublisherSproutFragment.am = b;
        unifiedPublisherSproutFragment.an = sproutAnalyticsLoggerProvider;
        unifiedPublisherSproutFragment.ao = b2;
    }

    public final void m25069a(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2121220278);
        super.a(bundle);
        Class cls = UnifiedPublisherSproutFragment.class;
        m25065a((Object) this, getContext());
        this.au = this.an.m25030a(this.ap, this.aq);
        a(2, 2131625410);
        this.ax = bundle != null;
        LogUtils.f(-688353496, a);
    }

    public final Dialog m25071c(Bundle bundle) {
        Dialog c19382 = new Dialog(this, an(), d()) {
            final /* synthetic */ UnifiedPublisherSproutFragment f22475a;

            public void onBackPressed() {
                ((NavigationLogger) this.f22475a.ao.get()).a("tap_back_button");
                UnifiedPublisherSproutFragment.at(this.f22475a);
            }
        };
        c19382.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        return c19382;
    }

    public final View m25068a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1673100649);
        if (this.ax) {
            Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1169683211, a);
            return null;
        }
        Preconditions.checkNotNull(this.aq);
        Preconditions.checkNotNull(this.ar);
        Preconditions.checkNotNull(this.as);
        this.au.m25029c();
        View inflate = layoutInflater.inflate(2130904463, viewGroup, false);
        this.av = (LinearLayout) inflate.findViewById(2131561590);
        Builder builder = ImmutableMap.builder();
        int size = this.ar.size();
        for (int i = 0; i < size; i++) {
            m25064a(this.av, builder, (LauncherSpec) this.ar.get(i), false);
        }
        m25064a(this.av, builder, this.as, true);
        this.aw = builder.b();
        LogUtils.f(-632252394, a);
        return inflate;
    }

    private void m25064a(LinearLayout linearLayout, Builder<LauncherSpec, LauncherInfo> builder, LauncherSpec launcherSpec, boolean z) {
        FabType fabType;
        FabWithLabelView fabWithLabelView = new FabWithLabelView(getContext());
        FabView fabView = fabWithLabelView.a;
        if (z) {
            fabType = FabType.BIG;
        } else {
            fabType = FabType.SMALL;
        }
        fabView.setType(fabType);
        fabWithLabelView.a.setFillColor(launcherSpec.f22481a);
        fabWithLabelView.a.setGlyphID(launcherSpec.f22482b);
        fabWithLabelView.a.setContentDescription(launcherSpec.f22483c);
        fabWithLabelView.b.setText(launcherSpec.f22483c);
        fabWithLabelView.a();
        linearLayout.addView(fabWithLabelView);
        LayoutParams layoutParams = (LayoutParams) fabWithLabelView.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        if (z) {
            layoutParams.topMargin = jW_().getDimensionPixelSize(2131429783);
        }
        builder.b(launcherSpec, new LauncherInfo(fabWithLabelView));
    }

    public final void m25070a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.av.getViewTreeObserver().addOnGlobalLayoutListener(this.ay);
        Iterator it = this.aw.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            final LauncherSpec launcherSpec = (LauncherSpec) entry.getKey();
            ((LauncherInfo) entry.getValue()).f22479a.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ UnifiedPublisherSproutFragment f22477b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1955045665);
                    Iterator it = this.f22477b.aw.values().iterator();
                    while (it.hasNext()) {
                        LauncherInfo launcherInfo = (LauncherInfo) it.next();
                        launcherInfo.f22479a.a.setEnabled(false);
                        launcherInfo.f22479a.b.setEnabled(false);
                    }
                    this.f22477b.au.m25026a(launcherSpec.f22484d);
                    launcherSpec.f22485e.run();
                    Logger.a(2, EntryType.UI_INPUT_END, 905740401, a);
                }
            });
        }
        this.av.setOnClickListener(new C19404(this));
        as();
    }

    private void as() {
        this.at = this.am.a().a(SpringConfig.a(40.0d, 7.0d)).a(0.0d).b(0.0d).l();
        this.at.a(new SpringListener(this));
    }

    public final void m25066G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -562373968);
        super.G();
        if (this.ax) {
            a();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 824122738, a);
    }

    public final void m25067H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -663145079);
        this.ax = true;
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1069103620, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -99006681);
        if (this.at != null) {
            this.at.m();
        }
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1673642933, a);
    }

    public static void at(UnifiedPublisherSproutFragment unifiedPublisherSproutFragment) {
        unifiedPublisherSproutFragment.au.m25028b(null);
        Spring spring = unifiedPublisherSproutFragment.at;
        spring.c = true;
        spring.b(0.0d);
    }
}
