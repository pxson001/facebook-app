package com.facebook.nux;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.debug.log.BLog;
import com.facebook.nux.interstitial.BaseNuxScreenController;
import com.facebook.widget.CustomViewPager;
import com.facebook.widget.viewpageindicator.CirclePageIndicator;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

/* compiled from: isSegmentedTranscode */
public abstract class BaseNuxFlowActivity extends FbFragmentActivity implements OnPageChangeListener {
    public static final Class<?> f12198p = BaseNuxFlowActivity.class;
    private int f12199q;
    public NuxFlowAnalyticsLogger f12200r;
    public NuxFlow f12201s;
    public NuxFragmentPagerAdapter f12202t;
    public CustomViewPager f12203u;
    private CirclePageIndicator f12204v;
    public NuxFlowController f12205w;
    private final C07921 f12206x = new C07921(this);

    /* compiled from: isSegmentedTranscode */
    public class C07921 {
        public final /* synthetic */ BaseNuxFlowActivity f12196a;

        C07921(BaseNuxFlowActivity baseNuxFlowActivity) {
            this.f12196a = baseNuxFlowActivity;
        }

        public final void m19115a() {
            BaseNuxFlowActivity baseNuxFlowActivity = this.f12196a;
            NuxFlowAnalyticsLogger nuxFlowAnalyticsLogger = baseNuxFlowActivity.f12200r;
            NuxFlow nuxFlow = baseNuxFlowActivity.f12201s;
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("nux_flow_finish");
            honeyClientEvent.c = nuxFlow.f12208b;
            nuxFlowAnalyticsLogger.f12211a.a(honeyClientEvent.b("flow_name", nuxFlow.f12207a));
            baseNuxFlowActivity.m19125k();
            baseNuxFlowActivity.finish();
        }

        public final void m19116b() {
            BaseNuxFlowActivity baseNuxFlowActivity = this.f12196a;
            NuxFlowAnalyticsLogger nuxFlowAnalyticsLogger = baseNuxFlowActivity.f12200r;
            NuxFlow nuxFlow = baseNuxFlowActivity.f12201s;
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("nux_flow_close");
            honeyClientEvent.c = nuxFlow.f12208b;
            nuxFlowAnalyticsLogger.f12211a.a(honeyClientEvent.b("flow_name", nuxFlow.f12207a));
            baseNuxFlowActivity.m19126l();
            baseNuxFlowActivity.finish();
        }
    }

    /* compiled from: isSegmentedTranscode */
    public class NuxFragmentPagerAdapter extends FragmentPagerAdapter {
        final /* synthetic */ BaseNuxFlowActivity f12197a;

        public NuxFragmentPagerAdapter(BaseNuxFlowActivity baseNuxFlowActivity, FragmentManager fragmentManager) {
            this.f12197a = baseNuxFlowActivity;
            super(fragmentManager);
        }

        public final Fragment m19117a(int i) {
            NuxScreenFragment nuxScreenFragment;
            BaseNuxFlowActivity baseNuxFlowActivity = this.f12197a;
            NuxScreen nuxScreen = (NuxScreen) this.f12197a.f12201s.f12209c.get(i);
            Preconditions.checkNotNull(nuxScreen);
            FragmentManager kO_ = baseNuxFlowActivity.kO_();
            if (kO_ == null) {
                BLog.a(BaseNuxFlowActivity.f12198p, "No fragment manager to ensure fragment exists");
                nuxScreenFragment = null;
            } else {
                Fragment a = kO_.a(StringFormatUtil.formatStrLocaleSafe("nux_flow_fragment_tag_%s_%s", baseNuxFlowActivity.f12201s.f12207a, nuxScreen.f12236h));
                if (a != null) {
                    nuxScreenFragment = (NuxScreenFragment) a;
                } else {
                    nuxScreenFragment = new NuxScreenFragment();
                }
                NuxFlowController nuxFlowController = baseNuxFlowActivity.f12205w;
                Intent intent = baseNuxFlowActivity.getIntent();
                nuxScreenFragment.f12241a = (NuxScreen) Preconditions.checkNotNull(nuxScreen);
                nuxScreenFragment.f12242b = (NuxFlowController) Preconditions.checkNotNull(nuxFlowController);
                nuxScreenFragment.f12243c = intent;
            }
            Fragment fragment = nuxScreenFragment;
            if (fragment == null) {
                this.f12197a.finish();
            }
            return fragment;
        }

        public final int m19118b() {
            return this.f12197a.f12201s.f12209c.size();
        }
    }

    protected abstract NuxFlow m19123i();

    protected void m19124j() {
    }

    public void onBackPressed() {
        this.f12205w.f12214c = this.f12203u.k;
        NuxScreenFragment t = m19119t();
        if (t == null) {
            BLog.a(f12198p, "Cannot handle back press because there is no current fragment");
            this.f12205w.m19134e();
            return;
        }
        if (t.f12241a.f12237i.isPresent()) {
            ((BaseNuxScreenController) t.f12241a.f12237i.get()).m19149c();
        } else {
            t.f12242b.m19134e();
        }
    }

    protected void m19122b(Bundle bundle) {
        int i;
        super.b(bundle);
        setTheme(2131625266);
        setContentView(2130905515);
        this.f12200r = NuxFlowAnalyticsLogger.m19127a(hz_());
        m19124j();
        this.f12201s = (NuxFlow) Preconditions.checkNotNull(m19123i());
        this.f12202t = new NuxFragmentPagerAdapter(this, kO_());
        this.f12203u = (CustomViewPager) a(2131564294);
        this.f12203u.setAdapter(this.f12202t);
        this.f12203u.a = false;
        this.f12204v = (CirclePageIndicator) a(2131564295);
        this.f12204v.setViewPager(this.f12203u);
        this.f12204v.f20165f = this;
        CirclePageIndicator circlePageIndicator = this.f12204v;
        if (null != null) {
            i = 0;
        } else {
            i = 8;
        }
        circlePageIndicator.setVisibility(i);
        this.f12205w = new NuxFlowController(this.f12201s, this.f12206x);
        if (this.f12202t.m19118b() <= 0 || this.f12203u.k != 0) {
            BLog.b(f12198p, "Could not show fragment for first screen");
            finish();
            return;
        }
        this.f12199q = 0;
        String stringExtra = getIntent().getStringExtra("source");
        NuxFlowAnalyticsLogger nuxFlowAnalyticsLogger = this.f12200r;
        NuxFlow nuxFlow = this.f12201s;
        Optional fromNullable = Optional.fromNullable(stringExtra);
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("nux_flow_start");
        honeyClientEvent.c = nuxFlow.f12208b;
        HoneyClientEvent b = honeyClientEvent.b("flow_name", nuxFlow.f12207a);
        if (fromNullable.isPresent()) {
            b.b("source", (String) fromNullable.get());
        }
        nuxFlowAnalyticsLogger.f12211a.a(b);
    }

    public void m19125k() {
    }

    public void m19126l() {
    }

    private NuxScreenFragment m19119t() {
        Fragment a = this.f12202t.m19117a(this.f12203u.k);
        if (a != null && (a instanceof NuxScreenFragment)) {
            return (NuxScreenFragment) a;
        }
        BLog.a(f12198p, "No fragment manager to get current fragment");
        throw new NullPointerException();
    }

    public final void m19120a(int i, float f, int i2) {
    }

    public final void e_(int i) {
        NuxFlowAnalyticsLogger nuxFlowAnalyticsLogger;
        NuxFlow nuxFlow;
        NuxScreen nuxScreen;
        NuxScreen nuxScreen2;
        HoneyClientEvent honeyClientEvent;
        if (i < this.f12199q) {
            nuxFlowAnalyticsLogger = this.f12200r;
            nuxFlow = this.f12201s;
            nuxScreen = (NuxScreen) this.f12201s.f12209c.get(this.f12199q);
            nuxScreen2 = (NuxScreen) this.f12201s.f12209c.get(i);
            honeyClientEvent = new HoneyClientEvent("nux_flow_previous");
            honeyClientEvent.c = nuxFlow.f12208b;
            nuxFlowAnalyticsLogger.f12211a.a(honeyClientEvent.b("flow_name", nuxFlow.f12207a).b("old_screen", nuxScreen.f12236h).b("new_screen", nuxScreen2.f12236h).a("used_back_button", false));
        } else if (i > this.f12199q) {
            nuxFlowAnalyticsLogger = this.f12200r;
            nuxFlow = this.f12201s;
            nuxScreen = (NuxScreen) this.f12201s.f12209c.get(this.f12199q);
            nuxScreen2 = (NuxScreen) this.f12201s.f12209c.get(i);
            honeyClientEvent = new HoneyClientEvent("nux_flow_next");
            honeyClientEvent.c = nuxFlow.f12208b;
            nuxFlowAnalyticsLogger.f12211a.a(honeyClientEvent.b("flow_name", nuxFlow.f12207a).b("old_screen", nuxScreen.f12236h).b("new_screen", nuxScreen2.f12236h));
        }
        this.f12199q = i;
        this.f12205w.f12214c = i;
    }

    public final void m19121b(int i) {
    }
}
