package com.facebook.zero.carrier.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.CrossProcessFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.common.util.SizeUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.iorg.common.upsell.model.PromoDataModel;
import com.facebook.iorg.common.upsell.model.PromoLocation;
import com.facebook.iorg.common.upsell.server.UpsellApiRequestManager;
import com.facebook.iorg.common.upsell.server.UpsellPromo;
import com.facebook.iorg.common.upsell.server.ZeroRecommendedPromoParams;
import com.facebook.iorg.common.upsell.server.ZeroRecommendedPromoResult;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.titlebar.HasTitleBar;
import com.facebook.zero.carrier.CarrierManagerUtil;
import com.facebook.zero.carrier.model.CarrierPromoRowModel;
import com.facebook.zero.carrier.model.CarrierPromoSubRowModel;
import com.facebook.zero.carrier.ui.CarrierManagerAlert;
import com.facebook.zero.carrier.ui.CarrierManagerUiHelper;
import com.facebook.zero.carrier.ui.CarrierPromoRow;
import com.facebook.zero.carrier.ui.CarrierSuggestedPromos;
import com.facebook.zero.sdk.common.TokenRequestReason;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.facebook.zero.upsell.activity.ZeroUpsellBuyConfirmInterstitialActivity;
import com.facebook.zero.upsell.service.FbUpsellPromoServiceManager;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: music_preview_action_sheet */
public class CarrierManagerFragment extends FbFragment implements AnalyticsFragment {
    public static final String f5305a = CarrierManagerFragment.class.getSimpleName();
    private static final CallerContext f5306b = CallerContext.a(CarrierManagerFragment.class, "zero_carrier_manager");
    public View aA;
    public ProgressBar aB;
    public int aC;
    public LoadingHandler aD = new C06901(this);
    public LoadingHandler aE = new C06912(this);
    public AnalyticsLogger al;
    private FbUpsellPromoServiceManager am;
    public View an;
    public View ao;
    private View ap;
    private FbDraweeView aq;
    private View ar;
    public ViewGroup as;
    private TextView at;
    private TextView au;
    public TextView av;
    private TextView aw;
    private View ax;
    public LinearLayout ay;
    public View az;
    public SecureContextHelper f5307c;
    public DefaultAndroidThreadUtil f5308d;
    private BaseFbBroadcastManager f5309e;
    private Provider<Boolean> f5310f;
    private TimeFormatUtil f5311g;
    private CarrierManagerUtil f5312h;
    public AbstractFbErrorReporter f5313i;

    /* compiled from: music_preview_action_sheet */
    interface LoadingHandler {
        void mo149a();

        void mo150b();

        void mo151c();
    }

    /* compiled from: music_preview_action_sheet */
    public class C06901 implements LoadingHandler {
        public final /* synthetic */ CarrierManagerFragment f5296a;

        /* compiled from: music_preview_action_sheet */
        public class C06891 implements OnClickListener {
            final /* synthetic */ C06901 f5295a;

            public C06891(C06901 c06901) {
                this.f5295a = c06901;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1087476491);
                this.f5295a.f5296a.az.setVisibility(8);
                CarrierManagerFragment.m6562a(this.f5295a.f5296a, this.f5295a.f5296a.aD, false);
                Logger.a(2, EntryType.UI_INPUT_END, 2094620822, a);
            }
        }

        C06901(CarrierManagerFragment carrierManagerFragment) {
            this.f5296a = carrierManagerFragment;
        }

        public final void mo149a() {
            this.f5296a.an.setVisibility(0);
            if (this.f5296a.az != null) {
                this.f5296a.az.setVisibility(8);
            }
            this.f5296a.ao.setVisibility(0);
        }

        public final void mo150b() {
            this.f5296a.an.setVisibility(8);
            if (this.f5296a.az != null) {
                this.f5296a.az.setVisibility(8);
            }
            this.f5296a.ao.setVisibility(8);
        }

        public final void mo151c() {
            if (this.f5296a.az == null) {
                View view = this.f5296a.as;
                if (this.f5296a.az == null) {
                    this.f5296a.az = ((ViewStub) view.findViewById(2131560226)).inflate();
                    this.f5296a.az.findViewById(2131561897).setOnClickListener(new C06891(this));
                }
            }
            this.f5296a.ao.setVisibility(8);
            TextView textView = (TextView) this.f5296a.az.findViewById(2131561899);
            textView.setText(2131241749);
            textView.setContentDescription(this.f5296a.b(2131241749));
            this.f5296a.az.setVisibility(0);
        }
    }

    /* compiled from: music_preview_action_sheet */
    class C06912 implements LoadingHandler {
        final /* synthetic */ CarrierManagerFragment f5297a;

        C06912(CarrierManagerFragment carrierManagerFragment) {
            this.f5297a = carrierManagerFragment;
        }

        public final void mo149a() {
            this.f5297a.aA.setVisibility(8);
            this.f5297a.aB.setVisibility(0);
        }

        public final void mo150b() {
            for (int childCount = this.f5297a.ay.getChildCount() - 1; childCount >= this.f5297a.aC; childCount--) {
                this.f5297a.ay.removeViewAt(childCount);
            }
            this.f5297a.av.setTextColor(this.f5297a.jW_().getColor(2131361853));
            this.f5297a.aA.setVisibility(0);
            this.f5297a.aB.setVisibility(8);
        }

        public final void mo151c() {
            this.f5297a.aA.setVisibility(0);
            this.f5297a.aB.setVisibility(8);
            this.f5297a.av.setTextColor(this.f5297a.jW_().getColor(2131363901));
            this.f5297a.av.setText(2131241761);
        }
    }

    /* compiled from: music_preview_action_sheet */
    class C06923 implements OnClickListener {
        final /* synthetic */ CarrierManagerFragment f5298a;

        C06923(CarrierManagerFragment carrierManagerFragment) {
            this.f5298a = carrierManagerFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -165333750);
            AnalyticsLogger analyticsLogger = this.f5298a.al;
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("carrier_manager_refresh");
            honeyClientEvent.c = this.f5298a.am_();
            analyticsLogger.a(honeyClientEvent);
            CarrierManagerFragment.m6562a(this.f5298a, this.f5298a.aE, true);
            Logger.a(2, EntryType.UI_INPUT_END, -1774910154, a);
        }
    }

    /* compiled from: music_preview_action_sheet */
    class C06966 implements OnClickListener {
        final /* synthetic */ CarrierManagerFragment f5304a;

        C06966(CarrierManagerFragment carrierManagerFragment) {
            this.f5304a = carrierManagerFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1145144341);
            UpsellPromo upsellPromo = (UpsellPromo) view.getTag();
            PromoDataModel promoDataModel = new PromoDataModel(upsellPromo.e, this.f5304a.b(2131232863), "", upsellPromo.b, upsellPromo.f, upsellPromo.d, this.f5304a.b(2131232864), upsellPromo.o, PromoLocation.CARRIER_MANAGER);
            Intent intent = new Intent(this.f5304a.getContext(), ZeroUpsellBuyConfirmInterstitialActivity.class);
            intent.putExtra("promo_data_model", promoDataModel);
            this.f5304a.f5307c.a(intent, 0, this.f5304a);
            Logger.a(2, EntryType.UI_INPUT_END, 467402330, a);
        }
    }

    public static void m6563a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((CarrierManagerFragment) obj).m6560a((SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), DefaultAndroidThreadUtil.b(fbInjector), (BaseFbBroadcastManager) CrossProcessFbBroadcastManager.a(fbInjector), IdBasedProvider.a(fbInjector, 4034), (TimeFormatUtil) DefaultTimeFormatUtil.a(fbInjector), CarrierManagerUtil.m6548b(fbInjector), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), AnalyticsLoggerMethodAutoProvider.a(fbInjector), FbUpsellPromoServiceManager.a(fbInjector));
    }

    @Inject
    private void m6560a(SecureContextHelper secureContextHelper, AndroidThreadUtil androidThreadUtil, FbBroadcastManager fbBroadcastManager, Provider<Boolean> provider, TimeFormatUtil timeFormatUtil, CarrierManagerUtil carrierManagerUtil, FbErrorReporter fbErrorReporter, AnalyticsLogger analyticsLogger, UpsellApiRequestManager upsellApiRequestManager) {
        this.f5307c = secureContextHelper;
        this.f5308d = androidThreadUtil;
        this.f5309e = fbBroadcastManager;
        this.f5310f = provider;
        this.f5311g = timeFormatUtil;
        this.f5312h = carrierManagerUtil;
        this.f5313i = fbErrorReporter;
        this.al = analyticsLogger;
        this.am = upsellApiRequestManager;
    }

    public final void m6567c(Bundle bundle) {
        super.c(bundle);
        Class cls = CarrierManagerFragment.class;
        m6563a((Object) this, getContext());
        if (bundle == null) {
            bundle = this.s;
        }
        AnalyticsLogger analyticsLogger = this.al;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("carrier_manager_impression");
        honeyClientEvent.c = am_();
        analyticsLogger.a(honeyClientEvent.b("ref", bundle.getString("ref")));
        if (((Boolean) this.f5310f.get()).booleanValue()) {
            this.f5309e.a("com.facebook.zero.ACTION_FORCE_ZERO_HEADER_REFRESH");
        } else {
            this.f5309e.a(new Intent("com.facebook.zero.ACTION_ZERO_REFRESH_TOKEN").putExtra("zero_token_request_reason", TokenRequestReason.CARRIER_MANAGER));
        }
    }

    public final View m6565a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1839239399);
        this.as = (ViewGroup) layoutInflater.inflate(2130903510, viewGroup, false);
        this.an = this.as.findViewById(2131560225);
        this.ao = this.as.findViewById(2131559418);
        this.ap = this.as.findViewById(2131560229);
        this.aq = (FbDraweeView) this.as.findViewById(2131560230);
        this.at = (TextView) this.as.findViewById(2131560231);
        this.ar = this.as.findViewById(2131560232);
        this.au = (TextView) this.as.findViewById(2131560233);
        this.av = (TextView) this.as.findViewById(2131560236);
        this.aw = (TextView) this.as.findViewById(2131560235);
        this.aA = this.as.findViewById(2131560237);
        this.aB = (ProgressBar) this.as.findViewById(2131560238);
        this.ax = this.as.findViewById(2131560239);
        this.ay = (LinearLayout) this.as.findViewById(2131560228);
        this.aC = this.ay.getChildCount();
        this.aA.setOnClickListener(new C06923(this));
        m6562a(this, this.aD, false);
        View view = this.as;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 336693064, a);
        return view;
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1816820043);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.y_(2131241750);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1341610475, a);
    }

    public static void m6562a(CarrierManagerFragment carrierManagerFragment, final LoadingHandler loadingHandler, boolean z) {
        loadingHandler.mo149a();
        carrierManagerFragment.f5308d.a(carrierManagerFragment.am.a(new ZeroRecommendedPromoParams(25, SizeUtil.a(carrierManagerFragment.jW_()), z, PromoLocation.CARRIER_MANAGER, ZeroFeatureKey.CARRIER_MANAGER)), new FutureCallback<ZeroRecommendedPromoResult>(carrierManagerFragment) {
            final /* synthetic */ CarrierManagerFragment f5300b;

            public void onSuccess(Object obj) {
                ZeroRecommendedPromoResult zeroRecommendedPromoResult = (ZeroRecommendedPromoResult) obj;
                if (!this.f5300b.mx_()) {
                    return;
                }
                if (StringUtil.a(zeroRecommendedPromoResult.i)) {
                    loadingHandler.mo150b();
                    CarrierManagerFragment.m6561a(this.f5300b, zeroRecommendedPromoResult);
                    return;
                }
                loadingHandler.mo151c();
            }

            public void onFailure(Throwable th) {
                if (this.f5300b.mx_()) {
                    loadingHandler.mo151c();
                }
            }
        });
    }

    public static void m6561a(CarrierManagerFragment carrierManagerFragment, final ZeroRecommendedPromoResult zeroRecommendedPromoResult) {
        CarrierPromoRow carrierPromoRow;
        HasTitleBar hasTitleBar = (HasTitleBar) carrierManagerFragment.a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.a_(zeroRecommendedPromoResult.w);
        }
        if (zeroRecommendedPromoResult.y) {
            carrierManagerFragment.f5312h.m6549a(zeroRecommendedPromoResult.A, zeroRecommendedPromoResult.z, new FutureCallback<Boolean>(carrierManagerFragment) {
                final /* synthetic */ CarrierManagerFragment f5303b;

                /* compiled from: music_preview_action_sheet */
                class C06941 implements Runnable {
                    final /* synthetic */ C06955 f5301a;

                    C06941(C06955 c06955) {
                        this.f5301a = c06955;
                    }

                    public void run() {
                        CarrierManagerAlert carrierManagerAlert = new CarrierManagerAlert(this.f5301a.f5303b.getContext());
                        ZeroRecommendedPromoResult zeroRecommendedPromoResult = zeroRecommendedPromoResult;
                        carrierManagerAlert.setVisibility(0);
                        carrierManagerAlert.f5325c.a(Uri.parse(zeroRecommendedPromoResult.B), CarrierManagerAlert.f5323a);
                        carrierManagerAlert.f5326d.setText(zeroRecommendedPromoResult.C);
                        carrierManagerAlert.f5326d.setContentDescription(zeroRecommendedPromoResult.C);
                        this.f5301a.f5303b.as.addView(carrierManagerAlert);
                    }
                }

                public void onSuccess(Object obj) {
                    if (((Boolean) obj).booleanValue()) {
                        AnalyticsLogger analyticsLogger = this.f5303b.al;
                        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("carrier_manager_shortcut_created");
                        honeyClientEvent.c = this.f5303b.am_();
                        analyticsLogger.a(honeyClientEvent);
                        this.f5303b.f5308d.a(new C06941(this));
                    }
                }

                public void onFailure(Throwable th) {
                    this.f5303b.f5313i.a(CarrierManagerFragment.f5305a, "Error creating application shortcut", th);
                }
            });
        }
        carrierManagerFragment.ap.setVisibility(0);
        Drawable gradientDrawable = new GradientDrawable(Orientation.LEFT_RIGHT, new int[]{zeroRecommendedPromoResult.t, zeroRecommendedPromoResult.u});
        gradientDrawable.setCornerRadius(0.0f);
        carrierManagerFragment.ap.setBackgroundDrawable(gradientDrawable);
        if (StringUtil.a(zeroRecommendedPromoResult.s)) {
            carrierManagerFragment.ap.setVisibility(8);
        } else {
            carrierManagerFragment.aq.a(Uri.parse(zeroRecommendedPromoResult.s), f5306b);
            carrierManagerFragment.ap.setVisibility(0);
        }
        if (StringUtil.a(zeroRecommendedPromoResult.m)) {
            carrierManagerFragment.at.setVisibility(8);
        } else {
            carrierManagerFragment.at.setVisibility(0);
            carrierManagerFragment.at.setText(zeroRecommendedPromoResult.m);
            carrierManagerFragment.at.setContentDescription(zeroRecommendedPromoResult.m);
        }
        carrierManagerFragment.ar.setVisibility(0);
        CharSequence a = carrierManagerFragment.a(2131241754, new Object[]{zeroRecommendedPromoResult.n});
        carrierManagerFragment.au.setText(a);
        carrierManagerFragment.au.setContentDescription(a);
        if (zeroRecommendedPromoResult.g() != 0) {
            a = carrierManagerFragment.a(2131241755, new Object[]{carrierManagerFragment.m6559a(zeroRecommendedPromoResult.g())});
            carrierManagerFragment.av.setText(a);
            carrierManagerFragment.av.setContentDescription(a);
            carrierManagerFragment.av.setVisibility(0);
        } else {
            carrierManagerFragment.av.setVisibility(8);
        }
        carrierManagerFragment.aw.setText(zeroRecommendedPromoResult.r);
        carrierManagerFragment.aw.setContentDescription(zeroRecommendedPromoResult.r);
        carrierManagerFragment.ax.setVisibility(0);
        if (!StringUtil.a(zeroRecommendedPromoResult.j)) {
            carrierPromoRow = new CarrierPromoRow(carrierManagerFragment.getContext());
            if (zeroRecommendedPromoResult.j() <= 0) {
                carrierPromoRow.m6574a(new CarrierPromoRowModel(2130838374, zeroRecommendedPromoResult.j, carrierManagerFragment.b(2131241756), false, new CarrierPromoSubRowModel(carrierManagerFragment.b(2131241757), zeroRecommendedPromoResult.p)));
            } else {
                carrierPromoRow.m6574a(new CarrierPromoRowModel(2130838374, zeroRecommendedPromoResult.j, carrierManagerFragment.b(2131241756), false, new CarrierPromoSubRowModel(carrierManagerFragment.b(2131241757), zeroRecommendedPromoResult.p), new CarrierPromoSubRowModel(carrierManagerFragment.b(2131241758), carrierManagerFragment.m6559a(zeroRecommendedPromoResult.j()))));
            }
            carrierManagerFragment.ay.addView(carrierPromoRow);
        }
        ImmutableList immutableList = zeroRecommendedPromoResult.v;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            UpsellPromo upsellPromo = (UpsellPromo) immutableList.get(i);
            CarrierPromoRow carrierPromoRow2 = new CarrierPromoRow(carrierManagerFragment.getContext());
            carrierPromoRow2.m6574a(new CarrierPromoRowModel(CarrierManagerUiHelper.m6572a(upsellPromo, true), upsellPromo.b, carrierManagerFragment.b(2131241759), true, new CarrierPromoSubRowModel[0]));
            carrierManagerFragment.ay.addView(carrierPromoRow2);
        }
        carrierPromoRow = new CarrierPromoRow(carrierManagerFragment.getContext());
        carrierPromoRow.m6574a(new CarrierPromoRowModel(2130839636, carrierManagerFragment.b(2131241760), zeroRecommendedPromoResult.x, false, new CarrierPromoSubRowModel[0]));
        carrierManagerFragment.ay.addView(carrierPromoRow);
        if (m6564a(zeroRecommendedPromoResult.c)) {
            CarrierSuggestedPromos carrierSuggestedPromos = new CarrierSuggestedPromos(carrierManagerFragment.getContext());
            carrierSuggestedPromos.m6576a(zeroRecommendedPromoResult.c, new C06966(carrierManagerFragment));
            carrierManagerFragment.ay.addView(carrierSuggestedPromos);
        }
    }

    private static boolean m6564a(ImmutableList<UpsellPromo> immutableList) {
        if (immutableList == null || immutableList.isEmpty()) {
            return false;
        }
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            if (!((UpsellPromo) immutableList.get(i)).i) {
                return true;
            }
        }
        return false;
    }

    private String m6559a(long j) {
        return this.f5311g.a(TimeFormatStyle.EVENTS_RELATIVE_STYLE, 1000 * j);
    }

    public final String am_() {
        return "zero_carrier_manager";
    }

    public final void m6566a(int i, int i2, Intent intent) {
        if (i2 == -1) {
            this.f5309e.a("com.facebook.zero.ACTION_FORCE_ZERO_HEADER_REFRESH");
            m6562a(this, this.aE, true);
        }
    }
}
