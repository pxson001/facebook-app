package com.facebook.vault.momentsupsell.ui;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.appsinstallhelper.AppsInstallHelper;
import com.facebook.appsinstallhelper.AppsInstallHelperProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.facepile.FacepileView;
import com.facebook.inject.FbInjector;
import com.facebook.inject.ForAppContext;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.moments.install.MomentsInstallInfo;
import com.facebook.resources.ui.FbButton;
import com.facebook.resources.ui.FbTextView;
import com.facebook.vault.momentsupsell.analytics.MomentsUpsellLogger;
import com.facebook.vault.momentsupsell.model.MomentsAppInfo;
import com.facebook.vault.momentsupsell.model.MomentsAppInterstitialInfo;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: thread_level_gating */
public class MomentsAppPromotionView extends FrameLayout {
    private static final CallerContext f1822d = CallerContext.a(MomentsAppPromotionView.class, "unknown");
    @Inject
    @ForAppContext
    Context f1823a;
    @Inject
    AppsInstallHelperProvider f1824b;
    @Inject
    MomentsUpsellLogger f1825c;
    @Nullable
    private MomentsAppInfo f1826e;
    private FbDraweeView f1827f;
    private FbTextView f1828g;
    private FbTextView f1829h;
    private FacepileView f1830i;
    private FbTextView f1831j;
    private FbButton f1832k;
    private FbButton f1833l;

    private static <T extends View> void m1913a(Class<T> cls, T t) {
        m1914a((Object) t, t.getContext());
    }

    private static void m1914a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((MomentsAppPromotionView) obj).m1912a((Context) fbInjector.getInstance(Context.class, ForAppContext.class), (AppsInstallHelperProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(AppsInstallHelperProvider.class), MomentsUpsellLogger.m1745a(fbInjector));
    }

    private void m1912a(Context context, AppsInstallHelperProvider appsInstallHelperProvider, MomentsUpsellLogger momentsUpsellLogger) {
        this.f1823a = context;
        this.f1824b = appsInstallHelperProvider;
        this.f1825c = momentsUpsellLogger;
    }

    public MomentsAppPromotionView(Context context) {
        super(context);
        m1911a();
    }

    public MomentsAppPromotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m1911a();
    }

    public MomentsAppPromotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m1911a();
    }

    private void m1911a() {
        m1913a(MomentsAppPromotionView.class, (View) this);
        View inflate = LayoutInflater.from(getContext()).inflate(2130905296, this, true);
        this.f1827f = (FbDraweeView) inflate.findViewById(2131563906);
        this.f1828g = (FbTextView) inflate.findViewById(2131563907);
        this.f1829h = (FbTextView) inflate.findViewById(2131563908);
        this.f1830i = (FacepileView) inflate.findViewById(2131563909);
        this.f1831j = (FbTextView) inflate.findViewById(2131563910);
        this.f1832k = (FbButton) inflate.findViewById(2131563911);
        this.f1833l = (FbButton) inflate.findViewById(2131563912);
    }

    public final void m1915a(@Nullable MomentsAppInfo momentsAppInfo) {
        if (momentsAppInfo != null && momentsAppInfo.f1774c != null) {
            this.f1826e = momentsAppInfo;
            final MomentsAppInterstitialInfo momentsAppInterstitialInfo = this.f1826e.f1774c;
            this.f1827f.a(Uri.parse(momentsAppInterstitialInfo.f1791c), f1822d);
            this.f1828g.setText(momentsAppInterstitialInfo.f1789a);
            this.f1829h.setText(momentsAppInterstitialInfo.f1790b);
            ImmutableList immutableList = momentsAppInterstitialInfo.f1793e;
            if (immutableList == null || immutableList.isEmpty()) {
                this.f1830i.setVisibility(8);
            } else {
                this.f1830i.setFaceStrings(immutableList);
                this.f1830i.setVisibility(0);
            }
            if (Strings.isNullOrEmpty(momentsAppInterstitialInfo.f1792d) || immutableList == null || immutableList.isEmpty()) {
                this.f1831j.setVisibility(8);
            } else {
                this.f1831j.setText(momentsAppInterstitialInfo.f1792d);
                this.f1831j.setVisibility(0);
            }
            final AppsInstallHelper a = this.f1824b.a(new MomentsInstallInfo());
            this.f1832k.setText(StringLocaleUtil.b(momentsAppInterstitialInfo.f1794f));
            this.f1832k.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ MomentsAppPromotionView f1818c;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 710869187);
                    if (!Strings.isNullOrEmpty(momentsAppInterstitialInfo.f1795g)) {
                        MomentsUpsellLogger momentsUpsellLogger = this.f1818c.f1825c;
                        momentsUpsellLogger.f1713a.a(new HoneyClientEvent("shoebox_moments_interstitial_accept"));
                        a.a(momentsAppInterstitialInfo.f1795g, this.f1818c.f1823a);
                    }
                    Logger.a(2, EntryType.UI_INPUT_END, -812389027, a);
                }
            });
            if (!StringUtil.a(new CharSequence[]{momentsAppInterstitialInfo.f1796h})) {
                if (!StringUtil.a(new CharSequence[]{momentsAppInterstitialInfo.f1797i})) {
                    this.f1833l.setVisibility(0);
                    this.f1833l.setText(this.f1826e.f1774c.f1796h);
                    this.f1833l.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ MomentsAppPromotionView f1821c;

                        public void onClick(View view) {
                            int a = Logger.a(2, EntryType.UI_INPUT_START, 1201686373);
                            MomentsUpsellLogger momentsUpsellLogger = this.f1821c.f1825c;
                            momentsUpsellLogger.f1713a.a(new HoneyClientEvent("shoebox_moments_interstitial_help"));
                            a.b(momentsAppInterstitialInfo.f1797i, this.f1821c.f1823a);
                            Logger.a(2, EntryType.UI_INPUT_END, 320009337, a);
                        }
                    });
                    return;
                }
            }
            this.f1833l.setVisibility(8);
        }
    }
}
