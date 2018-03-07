package com.facebook.notifications.preferences;

import android.content.Context;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.FbInjector;
import com.facebook.interstitial.api.FetchInterstitialsParams;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: negative_feedback_node_token */
public class InlineNotificationNuxResetServerPreference extends Preference {
    @Inject
    public DefaultBlueServiceOperationFactory f8431a;
    @Inject
    public FbSharedPreferences f8432b;
    @Inject
    public Toaster f8433c;
    @Inject
    @ForUiThread
    public Executor f8434d;

    /* compiled from: negative_feedback_node_token */
    public class C06811 implements OnPreferenceClickListener {
        final /* synthetic */ InlineNotificationNuxResetServerPreference f8429a;

        public C06811(InlineNotificationNuxResetServerPreference inlineNotificationNuxResetServerPreference) {
            this.f8429a = inlineNotificationNuxResetServerPreference;
        }

        public boolean onPreferenceClick(Preference preference) {
            InlineNotificationNuxResetServerPreference inlineNotificationNuxResetServerPreference = this.f8429a;
            inlineNotificationNuxResetServerPreference.f8432b.edit().a(NotificationsPreferenceConstants.K).a(NotificationsPreferenceConstants.J).commit();
            inlineNotificationNuxResetServerPreference.f8433c.a(new ToastBuilder("Starting status fetch from server."));
            Bundle bundle = new Bundle();
            bundle.putParcelable("fetchAndUpdateInterstitialsParams", new FetchInterstitialsParams(ImmutableList.of("4127")));
            Futures.a(BlueServiceOperationFactoryDetour.a(inlineNotificationNuxResetServerPreference.f8431a, "interstitials_fetch_and_update", bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.a(InlineNotificationNuxResetServerPreference.class), -155839154).a(), new C06822(inlineNotificationNuxResetServerPreference), inlineNotificationNuxResetServerPreference.f8434d);
            return true;
        }
    }

    /* compiled from: negative_feedback_node_token */
    public class C06822 implements FutureCallback<OperationResult> {
        final /* synthetic */ InlineNotificationNuxResetServerPreference f8430a;

        public C06822(InlineNotificationNuxResetServerPreference inlineNotificationNuxResetServerPreference) {
            this.f8430a = inlineNotificationNuxResetServerPreference;
        }

        public void onSuccess(@Nullable Object obj) {
            this.f8430a.f8433c.a(new ToastBuilder("NUX status fetched"));
        }

        public void onFailure(Throwable th) {
            this.f8430a.f8433c.a(new ToastBuilder("NUX status reset complete, but server fetch failed."));
        }
    }

    public static void m10014a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        InlineNotificationNuxResetServerPreference inlineNotificationNuxResetServerPreference = (InlineNotificationNuxResetServerPreference) obj;
        DefaultBlueServiceOperationFactory b = DefaultBlueServiceOperationFactory.b(fbInjector);
        FbSharedPreferences fbSharedPreferences = (FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector);
        Toaster b2 = Toaster.b(fbInjector);
        Executor executor = (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector);
        inlineNotificationNuxResetServerPreference.f8431a = b;
        inlineNotificationNuxResetServerPreference.f8432b = fbSharedPreferences;
        inlineNotificationNuxResetServerPreference.f8433c = b2;
        inlineNotificationNuxResetServerPreference.f8434d = executor;
    }

    public InlineNotificationNuxResetServerPreference(Context context) {
        super(context);
        Class cls = InlineNotificationNuxResetServerPreference.class;
        m10014a(this, getContext());
    }
}
