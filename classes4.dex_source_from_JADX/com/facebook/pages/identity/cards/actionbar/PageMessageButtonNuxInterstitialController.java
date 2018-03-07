package com.facebook.pages.identity.cards.actionbar;

import android.os.Parcelable;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.NotifyPageNuxShownInputData;
import com.facebook.graphql.calls.NotifyPageNuxShownInputData.NuxKey;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.pages.data.graphql.pageheader.PageNuxStateMutation.NotifyPageNuxShownMutationString;
import com.facebook.pages.fb4a.prefkeys.PagesPrefKeys;
import com.facebook.pages.identity.cards.actionbar.PageMessageButtonNuxStateMutator.1;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors;
import javax.inject.Inject;

/* compiled from: remixable_photo_uri */
public class PageMessageButtonNuxInterstitialController implements InterstitialController {
    public static final InterstitialTrigger f3487a = new InterstitialTrigger(Action.PAGE_ACTIONBAR);
    public static final PrefKey f3488b = ((PrefKey) PagesPrefKeys.f3492b.a("message_button_nux_seen"));
    public final FbSharedPreferences f3489c;
    private final PageMessageButtonNuxStateMutator f3490d;

    public static PageMessageButtonNuxInterstitialController m3769b(InjectorLike injectorLike) {
        return new PageMessageButtonNuxInterstitialController((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), new PageMessageButtonNuxStateMutator(String_LoggedInUserIdMethodAutoProvider.b(injectorLike), GraphQLQueryExecutor.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike)));
    }

    @Inject
    public PageMessageButtonNuxInterstitialController(FbSharedPreferences fbSharedPreferences, PageMessageButtonNuxStateMutator pageMessageButtonNuxStateMutator) {
        this.f3489c = fbSharedPreferences;
        this.f3490d = pageMessageButtonNuxStateMutator;
    }

    public final void m3775d() {
        this.f3489c.edit().putBoolean(f3488b, true).commit();
        PageMessageButtonNuxStateMutator pageMessageButtonNuxStateMutator = this.f3490d;
        NotifyPageNuxShownInputData notifyPageNuxShownInputData = new NotifyPageNuxShownInputData();
        notifyPageNuxShownInputData.a("user_id", pageMessageButtonNuxStateMutator.f3495b);
        GraphQlCallInput graphQlCallInput = notifyPageNuxShownInputData;
        graphQlCallInput.a("nux_key", NuxKey.MESSAGE_BUTTON_NUX);
        Futures.a(GraphQLQueryExecutor.a(pageMessageButtonNuxStateMutator.f3496c.a(GraphQLRequest.a((NotifyPageNuxShownMutationString) new NotifyPageNuxShownMutationString().a("input", graphQlCallInput)))), new 1(pageMessageButtonNuxStateMutator), MoreExecutors.a());
    }

    public final String m3773b() {
        return "3641";
    }

    public final void m3772a(Parcelable parcelable) {
    }

    public final void m3771a(long j) {
    }

    public final InterstitialControllerState m3770a(InterstitialTrigger interstitialTrigger) {
        Preconditions.checkState(interstitialTrigger.action == f3487a.action);
        if (this.f3489c.a(f3488b, false)) {
            return InterstitialControllerState.INELIGIBLE;
        }
        return InterstitialControllerState.ELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m3774c() {
        return ImmutableList.of(f3487a);
    }

    public final long hI_() {
        return 0;
    }
}
