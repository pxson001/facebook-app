package com.facebook.timeline.header;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.util.ContextUtils;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.timeline.context.TimelineUserContext;
import com.facebook.timeline.delegate.ProfileControllerDelegate;
import com.facebook.timeline.header.TimelineIntroCardAdapter.C16522;
import com.facebook.timeline.header.TimelineIntroCardAdapter.CollapseState;
import com.facebook.timeline.header.bio.IntroCardSuggestedBioExperimentController;
import com.facebook.timeline.header.bio.edit.TimelineBioEditActivity;
import com.facebook.timeline.header.controllers.IntroCardCollapseController;
import com.facebook.timeline.header.controllers.TimelineHeaderViewController;
import com.facebook.timeline.header.controllers.TimelineHeaderViewController.IntroViewType;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.logging.TimelineAnalyticsLogger;
import com.facebook.timeline.logging.TimelinePerformanceLogger;
import com.facebook.timeline.viewfeaturedcontainers.data.FeaturedContainersHeaderData;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: friends_nearby_dashboard_ping */
public class IntroCardBioBinder {
    private final Context f11270a;
    private final TimelineHeaderViewController f11271b;
    private final TimelineUserContext f11272c;
    private final TimelineHeaderUserData f11273d;
    private final TimelinePerformanceLogger f11274e;
    private final TimelineHeaderDataLogger f11275f;
    private final Provider<TimelineAnalyticsLogger> f11276g;
    private final Provider<SecureContextHelper> f11277h;
    public final IntroCardSuggestedBioExperimentController f11278i;
    private final C16522 f11279j;
    private final IntroCardCollapseController f11280k;
    private final FeaturedContainersHeaderData f11281l;
    public boolean f11282m;
    @Nullable
    private OnClickListener f11283n;
    @Nullable
    public OnClickListener f11284o;

    /* compiled from: friends_nearby_dashboard_ping */
    class C16342 implements OnClickListener {
        final /* synthetic */ IntroCardBioBinder f11267a;

        C16342(IntroCardBioBinder introCardBioBinder) {
            this.f11267a = introCardBioBinder;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -959503114);
            IntroCardBioBinder.m11389c(this.f11267a);
            Logger.a(2, EntryType.UI_INPUT_END, 641817775, a);
        }
    }

    /* compiled from: friends_nearby_dashboard_ping */
    public class C16353 implements OnClickListener {
        final /* synthetic */ IntroCardBioBinder f11268a;

        public C16353(IntroCardBioBinder introCardBioBinder) {
            this.f11268a = introCardBioBinder;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1586455651);
            IntroCardBioBinder.m11391d(this.f11268a);
            Logger.a(2, EntryType.UI_INPUT_END, -718200803, a);
        }
    }

    @Inject
    public IntroCardBioBinder(Context context, ProfileControllerDelegate profileControllerDelegate, Provider<TimelineAnalyticsLogger> provider, Provider<SecureContextHelper> provider2, TimelineHeaderViewController timelineHeaderViewController, TimelinePerformanceLogger timelinePerformanceLogger, IntroCardSuggestedBioExperimentController introCardSuggestedBioExperimentController, IntroCardCollapseController introCardCollapseController, FeaturedContainersHeaderData featuredContainersHeaderData, @Assisted OnEditBioClickListener onEditBioClickListener, @Assisted TimelineHeaderUserData timelineHeaderUserData, @Assisted TimelineUserContext timelineUserContext) {
        this.f11270a = context;
        this.f11271b = timelineHeaderViewController;
        this.f11272c = timelineUserContext;
        this.f11273d = timelineHeaderUserData;
        this.f11274e = timelinePerformanceLogger;
        this.f11275f = profileControllerDelegate.mo471f();
        this.f11276g = provider;
        this.f11277h = provider2;
        this.f11278i = introCardSuggestedBioExperimentController;
        this.f11280k = introCardCollapseController;
        this.f11279j = onEditBioClickListener;
        this.f11281l = featuredContainersHeaderData;
    }

    public final boolean m11392a(TimelineIntroCardBioView timelineIntroCardBioView, boolean z) {
        int dimensionPixelSize;
        this.f11282m = z;
        boolean a = this.f11271b.m11692a(this.f11272c);
        IntroViewType a2 = this.f11271b.m11691a(this.f11273d, this.f11272c, a);
        boolean z2 = true;
        switch (a2) {
            case NONE:
                timelineIntroCardBioView.m11516a();
                timelineIntroCardBioView.m11520b();
                timelineIntroCardBioView.m11523g();
                z2 = false;
                break;
            case EMPTY:
                z2 = m11388b(timelineIntroCardBioView, a);
                break;
            case CONTENT:
                z2 = m11390c(timelineIntroCardBioView, a);
                break;
            case SUGGESTED_CONTENT:
                z2 = m11387b(timelineIntroCardBioView);
                break;
        }
        this.f11274e.F = a2.name();
        int dimensionPixelSize2 = this.f11270a.getResources().getDimensionPixelSize(2131429937);
        int dimensionPixelSize3 = this.f11270a.getResources().getDimensionPixelSize(2131429938);
        if (z2) {
            dimensionPixelSize = this.f11270a.getResources().getDimensionPixelSize(2131429935) + 0;
            timelineIntroCardBioView.setBackgroundResource(2131361920);
        } else {
            dimensionPixelSize = 0;
        }
        timelineIntroCardBioView.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize3, 0);
        if (this.f11282m) {
            timelineIntroCardBioView.m11521e();
        } else {
            timelineIntroCardBioView.m11522f();
        }
        return z2;
    }

    private boolean m11388b(TimelineIntroCardBioView timelineIntroCardBioView, boolean z) {
        Preconditions.checkArgument(z);
        timelineIntroCardBioView.m11516a();
        timelineIntroCardBioView.m11520b();
        timelineIntroCardBioView.m11517a(m11385a());
        if (this.f11275f != null) {
            TimelineHeaderDataLogger timelineHeaderDataLogger = this.f11275f;
            if (!timelineHeaderDataLogger.f11378m) {
                timelineHeaderDataLogger.f11370e.f(timelineHeaderDataLogger.f11368c, timelineHeaderDataLogger.f11367b);
                timelineHeaderDataLogger.f11378m = true;
            }
        }
        return true;
    }

    private boolean m11390c(TimelineIntroCardBioView timelineIntroCardBioView, boolean z) {
        boolean z2;
        timelineIntroCardBioView.m11523g();
        TimelineHeaderViewController timelineHeaderViewController = this.f11271b;
        TimelineHeaderUserData timelineHeaderUserData = this.f11273d;
        Object obj = null;
        if (!(!TimelineHeaderViewController.m11689b(timelineHeaderUserData) || timelineHeaderUserData.b == null || timelineHeaderUserData.b.g() == null || timelineHeaderUserData.b.g().a().isEmpty())) {
            obj = 1;
        }
        if (obj == null || this.f11280k.m11668a(this.f11272c, this.f11273d, this.f11281l) == CollapseState.EXPANDED) {
            z2 = false;
        } else {
            z2 = true;
        }
        timelineIntroCardBioView.m11519a(this.f11273d.b.b().a(), z, m11385a(), z2);
        timelineIntroCardBioView.m11520b();
        if (this.f11275f != null) {
            TimelineHeaderDataLogger timelineHeaderDataLogger = this.f11275f;
            timelineHeaderUserData = this.f11273d;
            if (!(timelineHeaderDataLogger.f11377l || timelineHeaderUserData == null || !timelineHeaderUserData.W() || timelineIntroCardBioView == null)) {
                timelineHeaderDataLogger.f11377l = true;
                timelineHeaderDataLogger.f11370e.d(timelineHeaderDataLogger.f11368c, timelineHeaderDataLogger.f11367b, timelineHeaderDataLogger.f11375j);
            }
        }
        return true;
    }

    private boolean m11387b(final TimelineIntroCardBioView timelineIntroCardBioView) {
        timelineIntroCardBioView.m11523g();
        timelineIntroCardBioView.m11516a();
        CharSequence a = this.f11273d.b.l().a();
        if (this.f11284o == null) {
            this.f11284o = new C16353(this);
        }
        timelineIntroCardBioView.m11518a(a, this.f11284o, (OnClickListener) new OnClickListener(this) {
            final /* synthetic */ IntroCardBioBinder f11266b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -727380255);
                this.f11266b.f11278i.m11367g();
                this.f11266b.m11392a(timelineIntroCardBioView, this.f11266b.f11282m);
                Logger.a(2, EntryType.UI_INPUT_END, -812323902, a);
            }
        });
        if (this.f11275f != null) {
            TimelineHeaderDataLogger timelineHeaderDataLogger = this.f11275f;
            if (!timelineHeaderDataLogger.f11379n) {
                timelineHeaderDataLogger.f11370e.g(timelineHeaderDataLogger.f11368c, timelineHeaderDataLogger.f11367b);
                timelineHeaderDataLogger.f11379n = true;
            }
        }
        return true;
    }

    private OnClickListener m11385a() {
        if (this.f11283n == null) {
            this.f11283n = new C16342(this);
        }
        return this.f11283n;
    }

    public static void m11389c(IntroCardBioBinder introCardBioBinder) {
        String str;
        if (introCardBioBinder.f11273d.W()) {
            String a = introCardBioBinder.f11273d.b.b().a();
            ((TimelineAnalyticsLogger) introCardBioBinder.f11276g.get()).c(introCardBioBinder.f11272c.b);
            str = a;
        } else {
            ((TimelineAnalyticsLogger) introCardBioBinder.f11276g.get()).a(introCardBioBinder.f11272c.b);
            str = null;
        }
        introCardBioBinder.m11386a(str, false);
    }

    public static void m11391d(IntroCardBioBinder introCardBioBinder) {
        String a = introCardBioBinder.f11273d.b.l().a();
        ((TimelineAnalyticsLogger) introCardBioBinder.f11276g.get()).b(introCardBioBinder.f11272c.b);
        introCardBioBinder.m11386a(a, true);
    }

    private void m11386a(@Nullable String str, boolean z) {
        Intent intent = new Intent(this.f11270a, TimelineBioEditActivity.class);
        if (str != null) {
            intent.putExtra("initial_bio_text", str);
            if (z) {
                intent.putExtra("came_from_suggested_bio", true);
            }
        }
        intent.putExtra("show_feed_sharing_switch_extra", this.f11273d.b.d());
        intent.putExtra("initial_is_feed_sharing_switch_checked", this.f11273d.b.j());
        ((SecureContextHelper) this.f11277h.get()).a(intent, 1821, (Activity) ContextUtils.a(this.f11270a, Activity.class));
        if (this.f11279j != null) {
            C16522 c16522 = this.f11279j;
            if (c16522.f11442a.f11461i.m11674a(c16522.f11442a.f11329c, c16522.f11442a.f11330d)) {
                TimelineIntroCardAdapter.m11502k(c16522.f11442a);
            }
        }
    }
}
