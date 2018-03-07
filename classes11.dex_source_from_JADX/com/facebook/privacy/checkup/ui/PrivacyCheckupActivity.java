package com.facebook.privacy.checkup.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.privacy.checkup.abtest.ExperimentsForPrivacyCheckupAbTestModule;
import com.facebook.privacy.checkup.analytics.PrivacyCheckupPerformanceLogger;
import com.facebook.privacy.checkup.manager.PrivacyCheckupManager;
import com.facebook.privacy.checkup.manager.PrivacyCheckupStepData.PrivacyCheckupStepType;
import com.facebook.privacy.checkup.service.PrivacyCheckupAnalyticsLogger.Event;
import com.facebook.privacy.protocol.ReportPrivacyCheckupActionsParams.PrivacyCheckupEvent;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.widget.CustomViewPager;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Shapes should have a valid path (d) prop */
public final class PrivacyCheckupActivity extends FbFragmentActivity {
    private static final PrivacyCheckupStepType[] f11088p = new PrivacyCheckupStepType[]{PrivacyCheckupStepType.COMPOSER_STEP, PrivacyCheckupStepType.PROFILE_STEP, PrivacyCheckupStepType.APPS_STEP};
    private boolean f11089A;
    private final OnToolbarButtonListener f11090B = new C13181(this);
    private final OnClickListener f11091C = new C13192(this);
    private final OnClickListener f11092D = new C13203(this);
    private final OnClickListener f11093E = new C13214(this);
    private final OnPageChangeListener f11094F = new C13225(this);
    public PrivacyCheckupManager f11095q;
    private AllCapsTransformationMethod f11096r;
    private PrivacyCheckupPerformanceLogger f11097s;
    private QeAccessor f11098t;
    private CustomViewPager f11099u;
    public PrivacyCheckupPagerAdapter f11100v;
    private FbTitleBar f11101w;
    private ScrollView f11102x;
    public PrivacyCheckupState f11103y;
    private String f11104z;

    /* compiled from: Shapes should have a valid path (d) prop */
    class C13181 extends OnToolbarButtonListener {
        final /* synthetic */ PrivacyCheckupActivity f11082a;

        C13181(PrivacyCheckupActivity privacyCheckupActivity) {
            this.f11082a = privacyCheckupActivity;
        }

        public final void m11469a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            switch (titleBarButtonSpec.c) {
                case 0:
                    if (this.f11082a.f11103y == PrivacyCheckupState.INTRODUCTION) {
                        this.f11082a.f11095q.m11340a(Event.PRIVACY_CHECKUP_INTRO_STEP_NEXT);
                    }
                    PrivacyCheckupActivity.m11488o(this.f11082a);
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: Shapes should have a valid path (d) prop */
    class C13192 implements OnClickListener {
        final /* synthetic */ PrivacyCheckupActivity f11083a;

        C13192(PrivacyCheckupActivity privacyCheckupActivity) {
            this.f11083a = privacyCheckupActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1820318688);
            if (this.f11083a.f11103y == PrivacyCheckupState.INTRODUCTION) {
                this.f11083a.f11095q.m11340a(Event.PRIVACY_CHECKUP_INTRO_STEP_CONTINUE);
            }
            PrivacyCheckupActivity.m11488o(this.f11083a);
            Logger.a(2, EntryType.UI_INPUT_END, -207193697, a);
        }
    }

    /* compiled from: Shapes should have a valid path (d) prop */
    class C13203 implements OnClickListener {
        final /* synthetic */ PrivacyCheckupActivity f11084a;

        C13203(PrivacyCheckupActivity privacyCheckupActivity) {
            this.f11084a = privacyCheckupActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1869050867);
            PrivacyCheckupActivity.m11489p(this.f11084a);
            Logger.a(2, EntryType.UI_INPUT_END, -670399212, a);
        }
    }

    /* compiled from: Shapes should have a valid path (d) prop */
    class C13214 implements OnClickListener {
        final /* synthetic */ PrivacyCheckupActivity f11085a;

        C13214(PrivacyCheckupActivity privacyCheckupActivity) {
            this.f11085a = privacyCheckupActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1723731669);
            if (this.f11085a.f11103y == PrivacyCheckupState.INTRODUCTION) {
                this.f11085a.f11095q.m11340a(Event.PRIVACY_CHECKUP_INTRO_STEP_CLOSE);
            }
            PrivacyCheckupActivity.m11492s(this.f11085a);
            Logger.a(2, EntryType.UI_INPUT_END, -251441787, a);
        }
    }

    /* compiled from: Shapes should have a valid path (d) prop */
    class C13225 implements OnPageChangeListener {
        final /* synthetic */ PrivacyCheckupActivity f11086a;

        C13225(PrivacyCheckupActivity privacyCheckupActivity) {
            this.f11086a = privacyCheckupActivity;
        }

        public final void m11470a(int i, float f, int i2) {
        }

        public final void m11471b(int i) {
        }

        public final void e_(int i) {
            PrivacyCheckupActivity.m11483j(this.f11086a);
            this.f11086a.f11095q.m11345b();
            this.f11086a.f11095q.m11338a(this.f11086a.f11100v.m11523e(i));
        }
    }

    /* compiled from: Shapes should have a valid path (d) prop */
    public enum PrivacyCheckupState {
        INTRODUCTION,
        CHECKUP_STEPS,
        CONCLUSION
    }

    private static <T extends Context> void m11474a(Class<T> cls, T t) {
        m11475a((Object) t, (Context) t);
    }

    public static void m11475a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((PrivacyCheckupActivity) obj).m11473a(PrivacyCheckupManager.m11335a(injectorLike), AllCapsTransformationMethod.b(injectorLike), PrivacyCheckupPerformanceLogger.m5405a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    private void m11473a(PrivacyCheckupManager privacyCheckupManager, AllCapsTransformationMethod allCapsTransformationMethod, PrivacyCheckupPerformanceLogger privacyCheckupPerformanceLogger, QeAccessor qeAccessor) {
        this.f11095q = privacyCheckupManager;
        this.f11096r = allCapsTransformationMethod;
        this.f11097s = privacyCheckupPerformanceLogger;
        this.f11098t = qeAccessor;
    }

    protected final void m11495b(@Nullable Bundle bundle) {
        super.b(bundle);
        Class cls = PrivacyCheckupActivity.class;
        m11475a((Object) this, (Context) this);
        this.f11089A = false;
        this.f11104z = getIntent().getStringExtra("source");
        if (TextUtils.isEmpty(this.f11104z)) {
            this.f11104z = "unknown";
        }
        if (bundle != null) {
            this.f11103y = (PrivacyCheckupState) bundle.getSerializable("privacy_checkup_state");
        } else {
            this.f11103y = m11494u();
        }
        if (this.f11103y == PrivacyCheckupState.INTRODUCTION) {
            this.f11097s.f4419e.b(1441797);
        }
        setContentView(2130906376);
        this.f11099u = (CustomViewPager) findViewById(2131566237);
        this.f11100v = new PrivacyCheckupPagerAdapter(getResources(), kO_(), f11088p);
        this.f11099u.setAdapter(this.f11100v);
        this.f11099u.setOnPageChangeListener(this.f11094F);
        this.f11102x = (ScrollView) findViewById(2131566231);
        m11482i();
        m11483j(this);
        m11487n();
        if (this.f11103y == m11494u()) {
            if (bundle == null) {
                if (m11494u() == PrivacyCheckupState.INTRODUCTION) {
                    this.f11095q.m11343a(this.f11104z);
                } else {
                    this.f11095q.m11339a(this.f11100v.m11523e(0), this.f11104z);
                }
            }
            if (this.f11103y == PrivacyCheckupState.INTRODUCTION) {
                this.f11097s.f4419e.b(1441797, (short) 2);
            }
        }
    }

    protected final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("privacy_checkup_state", this.f11103y);
    }

    protected final void onStop() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 925881471);
        super.onStop();
        if (!this.f11089A) {
            this.f11095q.f10898e.m11357a();
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -196118164, a);
    }

    public final void onBackPressed() {
        m11489p(this);
    }

    private void m11482i() {
        FbTitleBarUtil.b(this);
        this.f11101w = (FbTitleBar) a(2131558563);
        this.f11101w.setOnToolbarButtonListener(this.f11090B);
    }

    public static void m11483j(PrivacyCheckupActivity privacyCheckupActivity) {
        if (privacyCheckupActivity.f11101w != null) {
            if (privacyCheckupActivity.f11103y == PrivacyCheckupState.CHECKUP_STEPS) {
                privacyCheckupActivity.f11101w.setTitle(privacyCheckupActivity.f11100v.m11524f(privacyCheckupActivity.f11099u.k));
            } else {
                privacyCheckupActivity.f11101w.setTitle(2131242282);
            }
            Builder a = TitleBarButtonSpec.a();
            a.g = privacyCheckupActivity.m11484k();
            a = a;
            a.j = privacyCheckupActivity.m11484k();
            a = a;
            a.a = 0;
            privacyCheckupActivity.f11101w.setButtonSpecs(ImmutableList.of(a.a()));
            privacyCheckupActivity.f11101w.a(privacyCheckupActivity.f11092D);
        }
    }

    private String m11484k() {
        if (this.f11103y == PrivacyCheckupState.CONCLUSION) {
            return getString(2131230728);
        }
        return getString(2131230744);
    }

    private boolean m11485l() {
        return this.f11099u.k == 0;
    }

    private boolean m11486m() {
        return this.f11099u.k == this.f11100v.b() + -1;
    }

    private void m11487n() {
        switch (this.f11103y) {
            case INTRODUCTION:
                this.f11099u.setVisibility(8);
                this.f11102x.setVisibility(0);
                m11490q();
                return;
            case CONCLUSION:
                this.f11099u.setVisibility(8);
                this.f11102x.setVisibility(0);
                m11491r();
                return;
            case CHECKUP_STEPS:
                this.f11099u.setVisibility(0);
                this.f11102x.setVisibility(8);
                return;
            default:
                return;
        }
    }

    public static void m11488o(PrivacyCheckupActivity privacyCheckupActivity) {
        switch (privacyCheckupActivity.f11103y) {
            case INTRODUCTION:
                privacyCheckupActivity.f11103y = PrivacyCheckupState.CHECKUP_STEPS;
                privacyCheckupActivity.m11487n();
                privacyCheckupActivity.f11095q.m11338a(privacyCheckupActivity.f11100v.m11523e(0));
                break;
            case CONCLUSION:
                privacyCheckupActivity.f11095q.m11340a(Event.PRIVACY_CHECKUP_REVIEW_STEP_CLOSE);
                m11492s(privacyCheckupActivity);
                break;
            case CHECKUP_STEPS:
                privacyCheckupActivity.f11095q.m11345b();
                PrivacyCheckupManager privacyCheckupManager = privacyCheckupActivity.f11095q;
                switch (privacyCheckupActivity.f11100v.m11523e(privacyCheckupActivity.f11099u.k)) {
                    case COMPOSER_STEP:
                        privacyCheckupManager.m11340a(Event.PRIVACY_CHECKUP_COMPOSER_STEP_NEXT);
                        break;
                    case PROFILE_STEP:
                        privacyCheckupManager.m11340a(Event.PRIVACY_CHECKUP_PROFILE_STEP_NEXT);
                        break;
                    case APPS_STEP:
                        privacyCheckupManager.m11340a(Event.PRIVACY_CHECKUP_APP_STEP_NEXT);
                        break;
                }
                if (!privacyCheckupActivity.m11486m()) {
                    privacyCheckupActivity.f11099u.setCurrentItem(privacyCheckupActivity.f11099u.k + 1);
                    break;
                }
                privacyCheckupActivity.f11103y = PrivacyCheckupState.CONCLUSION;
                privacyCheckupActivity.m11487n();
                privacyCheckupActivity.f11095q.f10898e.m11359a(PrivacyCheckupEvent.REVIEW_STEP_EXPOSED, "navigation");
                break;
        }
        m11483j(privacyCheckupActivity);
    }

    public static void m11489p(PrivacyCheckupActivity privacyCheckupActivity) {
        switch (privacyCheckupActivity.f11103y) {
            case INTRODUCTION:
                m11492s(privacyCheckupActivity);
                break;
            case CONCLUSION:
                privacyCheckupActivity.f11095q.m11340a(Event.PRIVACY_CHECKUP_REVIEW_STEP_PREVIOUS);
                privacyCheckupActivity.f11103y = PrivacyCheckupState.CHECKUP_STEPS;
                privacyCheckupActivity.f11095q.m11338a(privacyCheckupActivity.f11100v.m11523e(privacyCheckupActivity.f11100v.b() - 1));
                privacyCheckupActivity.m11487n();
                break;
            case CHECKUP_STEPS:
                privacyCheckupActivity.f11095q.m11345b();
                PrivacyCheckupManager privacyCheckupManager = privacyCheckupActivity.f11095q;
                switch (privacyCheckupActivity.f11100v.m11523e(privacyCheckupActivity.f11099u.k)) {
                    case COMPOSER_STEP:
                        privacyCheckupManager.m11340a(Event.PRIVACY_CHECKUP_COMPOSER_STEP_PREVIOUS);
                        break;
                    case PROFILE_STEP:
                        privacyCheckupManager.m11340a(Event.PRIVACY_CHECKUP_PROFILE_STEP_PREVIOUS);
                        break;
                    case APPS_STEP:
                        privacyCheckupManager.m11340a(Event.PRIVACY_CHECKUP_APP_STEP_PREVIOUS);
                        break;
                }
                if (privacyCheckupActivity.m11485l()) {
                    if (privacyCheckupActivity.m11494u() != PrivacyCheckupState.INTRODUCTION) {
                        m11492s(privacyCheckupActivity);
                        break;
                    }
                    privacyCheckupActivity.f11103y = PrivacyCheckupState.INTRODUCTION;
                    privacyCheckupActivity.m11487n();
                    privacyCheckupActivity.f11095q.m11343a("navigation");
                    break;
                }
                privacyCheckupActivity.f11099u.setCurrentItem(privacyCheckupActivity.f11099u.k - 1);
                break;
        }
        m11483j(privacyCheckupActivity);
    }

    private void m11490q() {
        ((TextView) this.f11102x.findViewById(2131566233)).setText(getString(2131242301));
        ((TextView) this.f11102x.findViewById(2131566234)).setText(getString(2131242302));
        this.f11102x.findViewById(2131566235).setVisibility(8);
        this.f11102x.findViewById(2131566236).setVisibility(8);
        TextView textView = (TextView) this.f11102x.findViewById(2131559565);
        textView.setTransformationMethod(this.f11096r);
        textView.setText(2131230730);
        textView.setOnClickListener(this.f11091C);
        textView = (TextView) this.f11102x.findViewById(2131559566);
        textView.setText(2131230728);
        textView.setOnClickListener(this.f11093E);
        textView.setVisibility(0);
        ((ImageView) this.f11102x.findViewById(2131566232)).setImageResource(2130842737);
        this.f11102x.fullScroll(33);
    }

    private void m11491r() {
        ((TextView) this.f11102x.findViewById(2131566233)).setText(getString(2131242303));
        ((TextView) this.f11102x.findViewById(2131566234)).setText(getString(2131242304));
        TextView textView = (TextView) this.f11102x.findViewById(2131566235);
        textView.setVisibility(0);
        textView.setText(2131242306);
        this.f11102x.findViewById(2131566236).setVisibility(8);
        textView = (TextView) this.f11102x.findViewById(2131559565);
        textView.setTransformationMethod(this.f11096r);
        textView.setText(2131230728);
        textView.setOnClickListener(this.f11091C);
        textView = (TextView) this.f11102x.findViewById(2131559566);
        textView.setVisibility(8);
        textView.setOnClickListener(null);
        ((ImageView) this.f11102x.findViewById(2131566232)).setImageResource(2130842736);
        this.f11102x.fullScroll(33);
    }

    public static void m11492s(PrivacyCheckupActivity privacyCheckupActivity) {
        privacyCheckupActivity.f11089A = true;
        privacyCheckupActivity.f11095q.m11341a(privacyCheckupActivity.f11103y);
        privacyCheckupActivity.finish();
    }

    private boolean m11493t() {
        boolean z = false;
        if (!(this.f11098t.a(Liveness.Live, ExperimentsForPrivacyCheckupAbTestModule.f4413b, false) && Objects.equal("modal", this.f11104z))) {
            z = true;
        }
        this.f11095q.f10898e.f10927s = this.f11098t.a(Liveness.Live, ExperimentsForPrivacyCheckupAbTestModule.f4412a, "");
        return z;
    }

    private PrivacyCheckupState m11494u() {
        if (m11493t()) {
            return PrivacyCheckupState.INTRODUCTION;
        }
        return PrivacyCheckupState.CHECKUP_STEPS;
    }
}
