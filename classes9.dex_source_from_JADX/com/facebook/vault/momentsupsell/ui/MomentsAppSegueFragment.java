package com.facebook.vault.momentsupsell.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.appsinstallhelper.AppsInstallHelperProvider;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.FbInjector;
import com.facebook.inject.ForAppContext;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.moments.install.MomentsInstallInfo;
import com.facebook.resources.ui.FbButton;
import com.facebook.vault.momentsupsell.analytics.MomentsUpsellLogger;
import com.facebook.vault.momentsupsell.model.MomentsAppInfo;
import javax.inject.Inject;

/* compiled from: thread_initial_fetch_complete/ */
public class MomentsAppSegueFragment extends FbFragment {
    private static final CallerContext f1835d = CallerContext.a(MomentsAppSegueFragment.class, "unknown");
    @Inject
    @ForAppContext
    public Context f1836a;
    @Inject
    public AppsInstallHelperProvider f1837b;
    @Inject
    public MomentsUpsellLogger f1838c;
    @Nullable
    private MomentsAppInfo f1839e;
    private View f1840f;
    private FbDraweeView f1841g;
    private FbButton f1842h;

    /* compiled from: thread_initial_fetch_complete/ */
    class C01781 implements OnClickListener {
        final /* synthetic */ MomentsAppSegueFragment f1834a;

        C01781(MomentsAppSegueFragment momentsAppSegueFragment) {
            this.f1834a = momentsAppSegueFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -801603505);
            MomentsUpsellLogger momentsUpsellLogger = this.f1834a.f1838c;
            momentsUpsellLogger.f1713a.a(new HoneyClientEvent("shoebox_moments_app_open"));
            this.f1834a.f1837b.a(new MomentsInstallInfo()).b("moments://", this.f1834a.f1836a);
            Logger.a(2, EntryType.UI_INPUT_END, 1413041428, a);
        }
    }

    public static void m1916a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        MomentsAppSegueFragment momentsAppSegueFragment = (MomentsAppSegueFragment) obj;
        Context context2 = (Context) fbInjector.getInstance(Context.class, ForAppContext.class);
        AppsInstallHelperProvider appsInstallHelperProvider = (AppsInstallHelperProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(AppsInstallHelperProvider.class);
        MomentsUpsellLogger a = MomentsUpsellLogger.m1745a(fbInjector);
        momentsAppSegueFragment.f1836a = context2;
        momentsAppSegueFragment.f1837b = appsInstallHelperProvider;
        momentsAppSegueFragment.f1838c = a;
    }

    public final View m1917a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1803825611);
        View inflate = layoutInflater.inflate(2130905297, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -348023957, a);
        return inflate;
    }

    public final void m1919c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = MomentsAppSegueFragment.class;
        m1916a((Object) this, getContext());
    }

    public final void m1918a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        if (this.s != null) {
            this.f1839e = (MomentsAppInfo) this.s.getParcelable("arg_moments_app_info");
        }
        this.f1840f = e(2131563913);
        this.f1841g = (FbDraweeView) e(2131563914);
        if (!(this.f1839e == null || this.f1839e.f1778g == null || this.f1839e.f1778g.f1804b == null || this.f1839e.f1778g.f1804b.isEmpty())) {
            this.f1841g.a(Uri.parse((String) this.f1839e.f1778g.f1804b.get(0)), f1835d);
        }
        this.f1840f.setPivotX(0.0f);
        this.f1840f.setPivotY(jW_().getDimension(2131432940));
        this.f1840f.setRotation(-3.6f);
        this.f1842h = (FbButton) e(2131563915);
        this.f1842h.setText(StringLocaleUtil.b(jW_().getString(2131239340)));
        this.f1842h.setOnClickListener(new C01781(this));
    }
}
