package com.facebook.iorg.common.upsell.ui.screencontroller;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.iorg.common.upsell.model.PromoDataModel;
import com.facebook.iorg.common.upsell.model.PromoLocation;
import com.facebook.iorg.common.upsell.model.ZeroPromoParams;
import com.facebook.iorg.common.upsell.server.ZeroPromoResult;
import com.facebook.iorg.common.upsell.server.ZeroPromoResult.Code;
import com.facebook.iorg.common.upsell.ui.UpsellDialogFragment;
import com.facebook.iorg.common.upsell.ui.UpsellDialogFragment.Screen;
import com.facebook.iorg.common.zero.interfaces.UpsellsAnalyticsEvent;
import com.facebook.iorg.fb4acommon.IorgFb4aAnalyticsLogger;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.zero.upsell.IorgFb4aAndroidThreadUtil;
import com.facebook.zero.upsell.service.FbUpsellPromoServiceManager;
import com.facebook.zero.upsell.service.FbUpsellPromoServiceManager.3;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* compiled from: logging_session */
public abstract class PromoPurchaseOnClickListener implements OnClickListener {
    public final UpsellDialogFragment f11393a;
    private final IorgFb4aAndroidThreadUtil f11394b;
    private final IorgFb4aAnalyticsLogger f11395c;
    private final FbUpsellPromoServiceManager f11396d;

    /* compiled from: logging_session */
    class C07241 implements FutureCallback<ZeroPromoResult> {
        final /* synthetic */ PromoPurchaseOnClickListener f11431a;

        C07241(PromoPurchaseOnClickListener promoPurchaseOnClickListener) {
            this.f11431a = promoPurchaseOnClickListener;
        }

        public void onSuccess(@Nullable Object obj) {
            ZeroPromoResult zeroPromoResult = (ZeroPromoResult) obj;
            if (zeroPromoResult == null || zeroPromoResult.f11312e == null) {
                PromoPurchaseOnClickListener.m18195c(this.f11431a);
                return;
            }
            this.f11431a.f11393a.ax = zeroPromoResult;
            this.f11431a.f11393a.m18169a(new PromoDataModel(zeroPromoResult));
            switch (Code.fromStatus(zeroPromoResult.f11308a)) {
                case SUCCESS:
                    this.f11431a.f11393a.m18170a(Screen.BUY_SUCCESS);
                    return;
                case MAYBE_SUCCESS:
                    this.f11431a.f11393a.m18170a(Screen.BUY_MAYBE);
                    return;
                default:
                    if (this.f11431a.f11393a.ax.f11310c == null) {
                        this.f11431a.f11393a.m18170a(Screen.BUY_FAILURE);
                        return;
                    } else {
                        this.f11431a.f11393a.m18170a(Screen.SHOW_LOAN);
                        return;
                    }
            }
        }

        public void onFailure(Throwable th) {
            PromoPurchaseOnClickListener.m18195c(this.f11431a);
        }
    }

    protected abstract String mo1074a();

    protected abstract PromoLocation mo1075b();

    protected PromoPurchaseOnClickListener(UpsellDialogFragment upsellDialogFragment, IorgFb4aAndroidThreadUtil iorgFb4aAndroidThreadUtil, IorgFb4aAnalyticsLogger iorgFb4aAnalyticsLogger, FbUpsellPromoServiceManager fbUpsellPromoServiceManager) {
        this.f11393a = upsellDialogFragment;
        this.f11394b = iorgFb4aAndroidThreadUtil;
        this.f11395c = iorgFb4aAnalyticsLogger;
        this.f11396d = fbUpsellPromoServiceManager;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 986669531);
        this.f11395c.a(UpsellsAnalyticsEvent.c, AbstractUpsellDialogScreenController.m18185a(mo1074a(), mo1074a()));
        FbUpsellPromoServiceManager fbUpsellPromoServiceManager = this.f11396d;
        this.f11394b.a(Futures.b(fbUpsellPromoServiceManager.b.a(true), new 3(fbUpsellPromoServiceManager, new ZeroPromoParams(null, mo1074a(), mo1075b())), (Executor) fbUpsellPromoServiceManager.c.get()), new C07241(this));
        Logger.a(2, EntryType.UI_INPUT_END, 1066684414, a);
    }

    public static void m18195c(PromoPurchaseOnClickListener promoPurchaseOnClickListener) {
        promoPurchaseOnClickListener.f11393a.m18169a(new PromoDataModel());
        promoPurchaseOnClickListener.f11393a.m18170a(Screen.BUY_FAILURE);
    }
}
