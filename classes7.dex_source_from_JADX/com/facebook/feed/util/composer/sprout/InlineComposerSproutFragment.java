package com.facebook.feed.util.composer.sprout;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.facebook.analytics.NavigationLogger;
import com.facebook.common.util.FindViewUtil;
import com.facebook.feed.util.composer.sprout.SproutAnalyticsLogger.SproutSource;
import com.facebook.feed.util.composer.sprout.header.SproutHeaderController;
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
import com.facebook.widget.listview.BetterListView;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: TWO_FRIENDS_ONLY */
public class InlineComposerSproutFragment extends FbDialogFragment implements OnItemClickListener {
    private boolean aA = false;
    public boolean aB = false;
    public int aC;
    public int aD;
    public View aE;
    public View aF;
    public View aG;
    public View aH;
    public View aI;
    private BetterListView aJ;
    public SproutHeaderController<View> aK;
    @Inject
    public SpringSystem am;
    @Inject
    public SproutAnalyticsLoggerProvider an;
    @Inject
    public Lazy<NavigationLogger> ao;
    @Inject
    public SproutAdapterProvider ap;
    private SproutSource aq;
    private String ar;
    @Nullable
    public Runnable as;
    public int at;
    private ImmutableList<SproutSpec> au;
    private Spring av;
    public SproutAnalyticsLogger aw;
    private SproutAdapter ax;
    private boolean ay = false;
    private boolean az = false;

    /* compiled from: TWO_FRIENDS_ONLY */
    class C19312 implements OnLayoutChangeListener {
        final /* synthetic */ InlineComposerSproutFragment f22400a;

        C19312(InlineComposerSproutFragment inlineComposerSproutFragment) {
            this.f22400a = inlineComposerSproutFragment;
        }

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.f22400a.aE.removeOnLayoutChangeListener(this);
            if (this.f22400a.T != null) {
                int[] iArr = new int[2];
                this.f22400a.aI.getLocationOnScreen(iArr);
                int i9 = this.f22400a.at - iArr[1];
                this.f22400a.aC = this.f22400a.aH.getMeasuredHeight() - this.f22400a.aI.getMeasuredHeight();
                this.f22400a.aD = i9 - this.f22400a.aC;
                InlineComposerSproutFragment.aq(this.f22400a);
            }
        }
    }

    /* compiled from: TWO_FRIENDS_ONLY */
    class C19323 implements OnClickListener {
        final /* synthetic */ InlineComposerSproutFragment f22401a;

        C19323(InlineComposerSproutFragment inlineComposerSproutFragment) {
            this.f22401a = inlineComposerSproutFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1301291174);
            if (this.f22401a.as != null) {
                this.f22401a.aw.m25026a("header");
                this.f22401a.as.run();
            } else {
                InlineComposerSproutFragment.m24980a(this.f22401a, CancelReason.TAP_HEADER);
            }
            LogUtils.a(1616070053, a);
        }
    }

    /* compiled from: TWO_FRIENDS_ONLY */
    class C19334 implements OnClickListener {
        final /* synthetic */ InlineComposerSproutFragment f22402a;

        C19334(InlineComposerSproutFragment inlineComposerSproutFragment) {
            this.f22402a = inlineComposerSproutFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 546050571);
            InlineComposerSproutFragment.m24980a(this.f22402a, CancelReason.TAP_X);
            Logger.a(2, EntryType.UI_INPUT_END, 1425330823, a);
        }
    }

    /* compiled from: TWO_FRIENDS_ONLY */
    class C19345 implements OnTouchListener {
        final /* synthetic */ InlineComposerSproutFragment f22403a;

        C19345(InlineComposerSproutFragment inlineComposerSproutFragment) {
            this.f22403a = inlineComposerSproutFragment;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                view.performClick();
                InlineComposerSproutFragment.m24980a(this.f22403a, CancelReason.TAP_OUTSIDE);
            }
            return false;
        }
    }

    /* compiled from: TWO_FRIENDS_ONLY */
    enum CancelReason {
        BACK_BUTTON("back_button", "tap_back_button"),
        TAP_OUTSIDE("tap_outside", "tap_outside"),
        TAP_HEADER("tap_header", "tap_outside"),
        TAP_X("tap_x", "tap_outside");
        
        final String analyticsNavigationTapPoint;
        final String name;

        private CancelReason(String str, String str2) {
            this.name = str;
            this.analyticsNavigationTapPoint = str2;
        }
    }

    /* compiled from: TWO_FRIENDS_ONLY */
    class SpringListener extends SimpleSpringListener {
        final /* synthetic */ InlineComposerSproutFragment f22404a;

        public SpringListener(InlineComposerSproutFragment inlineComposerSproutFragment) {
            this.f22404a = inlineComposerSproutFragment;
        }

        public final void m24977a(Spring spring) {
            float d = (float) spring.d();
            this.f22404a.aF.setAlpha(d);
            this.f22404a.aH.setTranslationY(((float) this.f22404a.aC) - ((float) SpringUtil.a((double) d, 0.0d, 1.0d, 0.0d, (double) this.f22404a.aC)));
            this.f22404a.aG.setTranslationY((float) SpringUtil.a((double) d, 0.0d, 1.0d, (double) this.f22404a.aD, 0.0d));
            this.f22404a.aK.mo1558a(this.f22404a.aI, d);
            if (((double) d) > 0.5d) {
                InlineComposerSproutFragment.ar(this.f22404a);
            }
        }

        public final void m24978b(Spring spring) {
            if (spring.g(0.0d)) {
                this.f22404a.b();
                return;
            }
            this.f22404a.aF.setAlpha(1.0f);
            this.f22404a.aH.setTranslationY(0.0f);
            this.f22404a.aG.setTranslationY(0.0f);
            if (!this.f22404a.aB) {
                this.f22404a.aK.mo1557a(this.f22404a.aI);
            }
        }
    }

    public static void m24981a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        InlineComposerSproutFragment inlineComposerSproutFragment = (InlineComposerSproutFragment) obj;
        SpringSystem b = SpringSystem.b(fbInjector);
        SproutAnalyticsLoggerProvider sproutAnalyticsLoggerProvider = (SproutAnalyticsLoggerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(SproutAnalyticsLoggerProvider.class);
        Lazy b2 = IdBasedSingletonScopeProvider.b(fbInjector, 137);
        SproutAdapterProvider sproutAdapterProvider = (SproutAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(SproutAdapterProvider.class);
        inlineComposerSproutFragment.am = b;
        inlineComposerSproutFragment.an = sproutAnalyticsLoggerProvider;
        inlineComposerSproutFragment.ao = b2;
        inlineComposerSproutFragment.ap = sproutAdapterProvider;
    }

    public static InlineComposerSproutFragment m24979a(SproutSource sproutSource, String str, @Nullable Runnable runnable, int i, ImmutableList<SproutSpec> immutableList, SproutHeaderController sproutHeaderController) {
        InlineComposerSproutFragment inlineComposerSproutFragment = new InlineComposerSproutFragment();
        inlineComposerSproutFragment.aq = sproutSource;
        inlineComposerSproutFragment.ar = str;
        inlineComposerSproutFragment.as = runnable;
        inlineComposerSproutFragment.at = i;
        inlineComposerSproutFragment.au = immutableList;
        inlineComposerSproutFragment.aK = sproutHeaderController;
        return inlineComposerSproutFragment;
    }

    public final void m24985a(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1017437712);
        super.a(bundle);
        Class cls = InlineComposerSproutFragment.class;
        m24981a((Object) this, getContext());
        this.aw = this.an.m25030a(this.aq, this.ar);
        this.ax = this.ap.m25023a(getContext());
        this.ax.m25022a(this.au);
        a(2, 2131625410);
        this.ay = bundle != null;
        LogUtils.f(543347293, a);
    }

    public final Dialog m24987c(Bundle bundle) {
        Dialog c19301 = new Dialog(this, an(), d()) {
            final /* synthetic */ InlineComposerSproutFragment f22399a;

            public void onBackPressed() {
                InlineComposerSproutFragment.m24980a(this.f22399a, CancelReason.BACK_BUTTON);
            }
        };
        c19301.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        return c19301;
    }

    public final View m24984a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1643086857);
        if (this.ay) {
            Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1731528692, a);
            return null;
        }
        Preconditions.checkNotNull(this.ar);
        Preconditions.checkNotNull(this.au);
        Preconditions.checkNotNull(this.aK);
        this.aw.m25029c();
        this.aE = layoutInflater.inflate(2130904903, viewGroup, false);
        this.aF = FindViewUtil.b(this.aE, 2131563145);
        this.aG = FindViewUtil.b(this.aE, 2131563146);
        this.aH = FindViewUtil.b(this.aE, 2131563147);
        this.aJ = (BetterListView) FindViewUtil.b(this.aE, 2131563149);
        ViewStub viewStub = (ViewStub) FindViewUtil.b(this.aE, 2131563148);
        viewStub.setLayoutResource(this.aK.mo1556a());
        this.aI = viewStub.inflate();
        View view = this.aE;
        LogUtils.f(1939359256, a);
        return view;
    }

    public final void m24986a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.aE.addOnLayoutChangeListener(new C19312(this));
        this.aK.mo1559a(this.aI, new C19323(this), new C19334(this));
        this.aJ.setAdapter(this.ax);
        this.aJ.setOnItemClickListener(this);
        this.aE.setOnTouchListener(new C19345(this));
        this.av = this.am.a().a(SpringConfig.b(15.0d, 4.0d)).a(new SpringListener(this)).a(0.0d).b(0.0d).l();
    }

    public static void aq(InlineComposerSproutFragment inlineComposerSproutFragment) {
        if (!inlineComposerSproutFragment.az) {
            inlineComposerSproutFragment.az = true;
            inlineComposerSproutFragment.aK.mo1561c(inlineComposerSproutFragment.aI);
            inlineComposerSproutFragment.aF.setAlpha(0.0f);
            inlineComposerSproutFragment.aH.setTranslationY((float) inlineComposerSproutFragment.aC);
            inlineComposerSproutFragment.aG.setTranslationY((float) inlineComposerSproutFragment.aD);
            for (int i = 0; i < inlineComposerSproutFragment.aJ.getChildCount(); i++) {
                ((SproutListItem) inlineComposerSproutFragment.aJ.getChildAt(i)).m25051a();
            }
            inlineComposerSproutFragment.av.b(1.0d);
        }
    }

    public static void m24980a(InlineComposerSproutFragment inlineComposerSproutFragment, CancelReason cancelReason) {
        inlineComposerSproutFragment.aB = true;
        ((NavigationLogger) inlineComposerSproutFragment.ao.get()).a(cancelReason.analyticsNavigationTapPoint);
        inlineComposerSproutFragment.aw.m25028b(cancelReason.name);
        inlineComposerSproutFragment.aK.mo1560b(inlineComposerSproutFragment.aI);
        Spring spring = inlineComposerSproutFragment.av;
        spring.c = true;
        spring.b(0.0d);
        if (inlineComposerSproutFragment.av.k()) {
            inlineComposerSproutFragment.b();
        }
    }

    public final void m24982G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1081970853);
        super.G();
        if (this.ay) {
            a();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -888276837, a);
    }

    public final void m24983H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1306180174);
        this.ay = true;
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 800594398, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1358556774);
        if (this.av != null) {
            this.av.m();
        }
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -138256235, a);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.aJ.setOnItemClickListener(null);
        SproutSpec sproutSpec = (SproutSpec) this.au.get(i);
        this.aw.m25026a(sproutSpec.f22467e);
        sproutSpec.f22468f.run();
        if (sproutSpec.f22471i) {
            a();
        }
    }

    public static void ar(InlineComposerSproutFragment inlineComposerSproutFragment) {
        if (!inlineComposerSproutFragment.aA) {
            inlineComposerSproutFragment.aA = true;
            int childCount = inlineComposerSproutFragment.aJ.getChildCount();
            int i = 250 / childCount;
            for (int i2 = 0; i2 < childCount; i2++) {
                ((SproutListItem) inlineComposerSproutFragment.aJ.getChildAt(i2)).m25052a((long) (i * i2));
            }
        }
    }
}
