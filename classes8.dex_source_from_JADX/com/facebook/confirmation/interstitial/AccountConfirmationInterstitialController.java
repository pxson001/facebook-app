package com.facebook.confirmation.interstitial;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.facebook.confirmation.activity.SimpleConfirmAccountActivity;
import com.facebook.confirmation.model.AccountConfirmationInterstitialData;
import com.facebook.confirmation.model.AccountConfirmationInterstitialType;
import com.facebook.confirmation.task.BackgroundConfirmationHelper;
import com.facebook.growth.model.Contactpoint;
import com.facebook.inject.Lazy;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialControllerWithContextClass;
import com.facebook.interstitial.manager.InterstitialIntentController;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: interacted_story_type */
public class AccountConfirmationInterstitialController implements InterstitialControllerWithContextClass, InterstitialIntentController {
    long f10769a = 0;
    public final Lazy<BackgroundConfirmationHelper> f10770b;
    public Contactpoint f10771c;
    private AccountConfirmationInterstitialType f10772d;

    public final Optional<Intent> m12718a(int i, Intent intent) {
        return Absent.INSTANCE;
    }

    @Inject
    public AccountConfirmationInterstitialController(Lazy<BackgroundConfirmationHelper> lazy) {
        this.f10770b = lazy;
        this.f10771c = null;
    }

    public final String m12721b() {
        return "1907";
    }

    public final Class<? extends Parcelable> m12723d() {
        return AccountConfirmationInterstitialData.class;
    }

    public final void m12720a(Parcelable parcelable) {
        AccountConfirmationInterstitialData accountConfirmationInterstitialData = (AccountConfirmationInterstitialData) parcelable;
        this.f10771c = accountConfirmationInterstitialData.m12727a();
        this.f10772d = accountConfirmationInterstitialData.interstitialType;
        this.f10769a = accountConfirmationInterstitialData.minImpressionDelayMs;
        if (this.f10771c != null && this.f10771c.m17345a()) {
            ((BackgroundConfirmationHelper) this.f10770b.get()).a(this.f10771c);
        }
    }

    public final void m12719a(long j) {
    }

    public final InterstitialControllerState m12717a(InterstitialTrigger interstitialTrigger) {
        if (this.f10771c == null || !this.f10771c.m17345a()) {
            return InterstitialControllerState.INELIGIBLE;
        }
        return InterstitialControllerState.ELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m12722c() {
        return ImmutableList.of(new InterstitialTrigger(Action.APP_FOREGROUND), new InterstitialTrigger(Action.SESSION_COLD_START));
    }

    public final Intent m12716a(Context context) {
        Intent intent = new Intent(context, SimpleConfirmAccountActivity.class);
        intent.putExtra("extra_contactpoint", this.f10771c);
        intent.putExtra("extra_is_cliff_interstitial", true);
        if (this.f10772d == AccountConfirmationInterstitialType.SOFT_CLIFF) {
            intent.putExtra("extra_cancel_allowed", true);
        }
        return intent;
    }

    public final long hI_() {
        return this.f10769a;
    }
}
