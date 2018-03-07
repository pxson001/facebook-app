package com.facebook.iorg.common.upsell.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.iorg.common.upsell.model.PromoDataModel;
import com.facebook.iorg.common.upsell.server.ZeroPromoResult;
import com.facebook.iorg.common.upsell.server.ZeroRecommendedPromoResult;
import com.facebook.iorg.common.upsell.ui.screencontroller.AbstractUpsellDialogScreenController;
import com.facebook.iorg.common.upsell.ui.screencontroller.BorrowLoanConfirmController;
import com.facebook.iorg.common.upsell.ui.screencontroller.BuyConfirmController;
import com.facebook.iorg.common.upsell.ui.screencontroller.BuyFailurePromoController;
import com.facebook.iorg.common.upsell.ui.screencontroller.BuyMaybeController;
import com.facebook.iorg.common.upsell.ui.screencontroller.BuySuccessController;
import com.facebook.iorg.common.upsell.ui.screencontroller.FetchUpsellsSpinnerController;
import com.facebook.iorg.common.upsell.ui.screencontroller.PromoListScreenController;
import com.facebook.iorg.common.upsell.ui.screencontroller.ShowLoanController;
import com.facebook.iorg.common.upsell.ui.screencontroller.UpsellStandardDataChargesController;
import com.facebook.iorg.common.upsell.ui.screencontroller.UseDataOrStayInFreeController;
import com.facebook.iorg.common.zero.constants.ZeroDialogState;
import com.facebook.iorg.common.zero.interfaces.IorgAndroidThreadUtil;
import com.facebook.iorg.common.zero.interfaces.UpsellsAnalyticsEvent;
import com.facebook.iorg.common.zero.ui.ZeroDialogController.DialogData;
import com.facebook.iorg.common.zero.ui.ZeroDialogFragment;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.facebook.zero.upsell.IorgFb4aAndroidThreadUtil;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: lte */
public class UpsellDialogFragment extends ZeroDialogFragment {
    private Map<Screen, ScreenInfo> aA = Maps.c();
    private IorgFb4aAndroidThreadUtil aB = null;
    private Handler aC = null;
    public LinearLayout av;
    @Nullable
    public ZeroRecommendedPromoResult aw;
    @Nullable
    public ZeroPromoResult ax;
    public ImmutableMap<Screen, Lazy<? extends ScreenController>> ay;
    public boolean az = false;

    /* compiled from: lte */
    class C07141 implements OnClickListener {
        final /* synthetic */ UpsellDialogFragment f11367a;

        C07141(UpsellDialogFragment upsellDialogFragment) {
            this.f11367a = upsellDialogFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -571442775);
            this.f11367a.ar();
            Logger.a(2, EntryType.UI_INPUT_END, 1280127491, a);
        }
    }

    /* compiled from: lte */
    public enum Screen {
        USE_DATA_OR_STAY_IN_FREE,
        FETCH_UPSELL,
        STANDARD_DATA_CHARGES_APPLY,
        PROMOS_LIST,
        BUY_CONFIRM,
        BUY_SUCCESS,
        BUY_MAYBE,
        BUY_FAILURE,
        SHOW_LOAN,
        BORROW_LOAN_CONFIRM,
        VPN_CALL_TO_HANDLE;

        public static Screen fromInt(int i) {
            Screen[] values = values();
            if (i >= 0 && i < values.length) {
                return values[i];
            }
            throw new IllegalArgumentException("Unrecognized int value for Screen");
        }
    }

    /* compiled from: lte */
    public class ScreenInfo {
        public final /* synthetic */ UpsellDialogFragment f11371a;
        public final Lazy<? extends ScreenController> f11372b;
        @Nullable
        public AbstractUpsellDialogScreenController f11373c = null;
        @Nullable
        public View f11374d = null;

        public ScreenInfo(UpsellDialogFragment upsellDialogFragment, @Nullable Lazy<? extends ScreenController> lazy) {
            this.f11371a = upsellDialogFragment;
            this.f11372b = lazy;
        }

        public final View m18158a() {
            if (this.f11374d == null) {
                if (this.f11373c == null) {
                    this.f11373c = (AbstractUpsellDialogScreenController) this.f11372b.get();
                    this.f11373c.m18189a(this.f11371a, UpsellDialogFragment.aC(this.f11371a));
                }
                AbstractUpsellDialogScreenController abstractUpsellDialogScreenController = this.f11373c;
                Context context = this.f11371a.getContext();
                LinearLayout linearLayout = this.f11371a.av;
                this.f11374d = abstractUpsellDialogScreenController.mo1077a(context);
            }
            return this.f11374d;
        }
    }

    public static void m18162a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((UpsellDialogFragment) obj).m18161a(IorgFb4aAndroidThreadUtil.a(fbInjector), Handler_ForUiThreadMethodAutoProvider.b(fbInjector), IdBasedLazy.a(fbInjector, 7289), IdBasedLazy.a(fbInjector, 7292), IdBasedLazy.a(fbInjector, 7285), IdBasedLazy.a(fbInjector, 7288), IdBasedLazy.a(fbInjector, 7293), IdBasedLazy.a(fbInjector, 7290), IdBasedLazy.a(fbInjector, 7287), IdBasedLazy.a(fbInjector, 7286), IdBasedLazy.a(fbInjector, 7291), IdBasedLazy.a(fbInjector, 7284), IdBasedLazy.a(fbInjector, 11860));
    }

    public static UpsellDialogFragment m18159a(ZeroFeatureKey zeroFeatureKey, Object obj, Screen screen, int i, @Nullable Object obj2, ZeroDialogState zeroDialogState) {
        return m18160a(zeroFeatureKey, obj, screen, i, obj2, zeroDialogState, null);
    }

    private static UpsellDialogFragment m18160a(ZeroFeatureKey zeroFeatureKey, Object obj, Screen screen, int i, @Nullable Object obj2, ZeroDialogState zeroDialogState, @Nullable DialogData dialogData) {
        UpsellDialogFragment upsellDialogFragment = new UpsellDialogFragment();
        Bundle a = ZeroDialogFragment.a(zeroFeatureKey, null, null, obj2, zeroDialogState, dialogData != null ? dialogData.h : null);
        a.putInt("current_screen", screen.ordinal());
        a.putInt("title_extra_image_resource_id", i);
        a.putParcelable("promo_data_model", (Parcelable) obj);
        upsellDialogFragment.g(a);
        return upsellDialogFragment;
    }

    @VisibleForTesting
    private Screen aB() {
        if (aC(this) == null) {
            return Screen.BUY_FAILURE;
        }
        return Screen.fromInt(this.s.getInt("current_screen", Screen.FETCH_UPSELL.ordinal()));
    }

    @Inject
    private void m18161a(IorgAndroidThreadUtil iorgAndroidThreadUtil, Handler handler, Lazy<FetchUpsellsSpinnerController> lazy, Lazy<UpsellStandardDataChargesController> lazy2, Lazy<BuyConfirmController> lazy3, Lazy<BuySuccessController> lazy4, Lazy<UseDataOrStayInFreeController> lazy5, Lazy<PromoListScreenController> lazy6, Lazy<BuyMaybeController> lazy7, Lazy<BuyFailurePromoController> lazy8, Lazy<ShowLoanController> lazy9, Lazy<BorrowLoanConfirmController> lazy10, Lazy<AbstractUpsellDialogScreenController> lazy11) {
        this.aB = iorgAndroidThreadUtil;
        this.aC = handler;
        this.ay = new Builder().b(Screen.STANDARD_DATA_CHARGES_APPLY, lazy2).b(Screen.FETCH_UPSELL, lazy).b(Screen.USE_DATA_OR_STAY_IN_FREE, lazy5).b(Screen.PROMOS_LIST, lazy6).b(Screen.BUY_CONFIRM, lazy3).b(Screen.BUY_SUCCESS, lazy4).b(Screen.BUY_MAYBE, lazy7).b(Screen.BUY_FAILURE, lazy8).b(Screen.SHOW_LOAN, lazy9).b(Screen.BORROW_LOAN_CONFIRM, lazy10).b(Screen.VPN_CALL_TO_HANDLE, lazy11).b();
    }

    public final void m18167a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 921507345);
        super.a(bundle);
        Class cls = UpsellDialogFragment.class;
        m18162a((Object) this, getContext());
        a(1, 2131624754);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1227778503, a);
    }

    public final Dialog m18171c(Bundle bundle) {
        Dialog c = super.c(bundle);
        c.setCanceledOnTouchOutside(true);
        if (bundle != null) {
            m18163b(this, Screen.valueOf(bundle.getString("current_screen")));
            m18169a((PromoDataModel) bundle.getParcelable("promo_data_model"));
        }
        return c;
    }

    public final View m18166a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 131211777);
        this.av = new LinearLayout(getContext());
        this.av.setOnClickListener(new C07141(this));
        View a2 = aD().m18158a();
        if (a2 != null) {
            this.av.addView(a2);
        }
        a2 = this.av;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 240245120, a);
        return a2;
    }

    public final void m18168a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.az = true;
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1451938995);
        this.az = false;
        ScreenInfo aD = aD();
        if (aD.f11373c != null) {
            aD.f11373c.m18188a();
        }
        aD.f11374d = null;
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 421911158, a);
    }

    public final void m18165I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2036511625);
        for (ScreenInfo screenInfo : this.aA.values()) {
            if (screenInfo.f11373c != null) {
                screenInfo.f11373c.f11391a = null;
            }
            screenInfo.f11373c = null;
        }
        super.I();
        LogUtils.f(838789286, a);
    }

    public void onCancel(DialogInterface dialogInterface) {
        ar();
    }

    public final void m18172e(Bundle bundle) {
        super.e(bundle);
        bundle.putString("current_screen", aB().toString());
        bundle.putParcelable("promo_data_model", aC(this));
    }

    protected final UpsellsAnalyticsEvent at() {
        return UpsellsAnalyticsEvent.l;
    }

    protected final String au() {
        return "upsell_dialog_open";
    }

    protected final String av() {
        return "upsell_dialog_confirm";
    }

    protected final String aw() {
        return "upsell_dialog_cancel";
    }

    public static ScreenInfo m18164c(UpsellDialogFragment upsellDialogFragment, Screen screen) {
        ScreenInfo screenInfo = (ScreenInfo) upsellDialogFragment.aA.get(screen);
        if (screenInfo != null) {
            return screenInfo;
        }
        ScreenInfo screenInfo2 = new ScreenInfo(upsellDialogFragment, (Lazy) upsellDialogFragment.ay.get(screen));
        upsellDialogFragment.aA.put(screen, screenInfo2);
        return screenInfo2;
    }

    private ScreenInfo aD() {
        return m18164c(this, aB());
    }

    public final void m18170a(final Screen screen) {
        if (this.aB == null) {
            throw new IllegalStateException("Called go to screen before Fragment.onCreate was called");
        }
        this.aB.a.a();
        if (this.az) {
            final Screen aB = aB();
            if (aB != screen) {
                Preconditions.checkNotNull(this.aC);
                HandlerDetour.a(this.aC, new Runnable(this) {
                    final /* synthetic */ UpsellDialogFragment f11370c;

                    public void run() {
                        UpsellDialogFragment.m18163b(this.f11370c, screen);
                        View a = UpsellDialogFragment.m18164c(this.f11370c, aB).m18158a();
                        View a2 = UpsellDialogFragment.m18164c(this.f11370c, screen).m18158a();
                        if (this.f11370c.ay != null) {
                            Lazy lazy = (Lazy) this.f11370c.ay.get(screen);
                            if (lazy != null) {
                                AbstractUpsellDialogScreenController abstractUpsellDialogScreenController = (AbstractUpsellDialogScreenController) lazy.get();
                                abstractUpsellDialogScreenController.m18189a(this.f11370c, UpsellDialogFragment.aC(this.f11370c));
                                abstractUpsellDialogScreenController.mo1078a((UpsellDialogView) a2);
                            }
                        }
                        this.f11370c.av.removeView(a);
                        this.f11370c.av.addView(a2);
                    }
                }, -1320728019);
            }
        }
    }

    public static PromoDataModel aC(UpsellDialogFragment upsellDialogFragment) {
        return (PromoDataModel) upsellDialogFragment.s.getParcelable("promo_data_model");
    }

    public static void m18163b(UpsellDialogFragment upsellDialogFragment, Screen screen) {
        upsellDialogFragment.s.putInt("current_screen", screen.ordinal());
    }

    public final void m18169a(PromoDataModel promoDataModel) {
        this.s.putParcelable("promo_data_model", promoDataModel);
    }

    public final int ax() {
        return this.s.getInt("title_extra_image_resource_id");
    }
}
