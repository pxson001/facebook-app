package com.facebook.aldrin.prefs;

import android.content.Context;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import com.facebook.aldrin.service.FetchAldrinUserStatusClient;
import com.facebook.aldrin.status.AldrinUserStatus;
import com.facebook.aldrin.status.AldrinUserStatusManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.BackgroundExecutorService;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: likes */
public class RefreshAldrinUserStatusPreference extends Preference {
    @Inject
    FbSharedPreferences f10350a;
    @Inject
    public FetchAldrinUserStatusClient f10351b;
    @Inject
    AldrinUserStatusManager f10352c;
    @BackgroundExecutorService
    @Inject
    public ExecutorService f10353d;
    @Inject
    @ForUiThread
    ExecutorService f10354e;

    /* compiled from: likes */
    class C10981 implements OnPreferenceClickListener {
        final /* synthetic */ RefreshAldrinUserStatusPreference f10347a;

        C10981(RefreshAldrinUserStatusPreference refreshAldrinUserStatusPreference) {
            this.f10347a = refreshAldrinUserStatusPreference;
        }

        public boolean onPreferenceClick(Preference preference) {
            RefreshAldrinUserStatusPreference refreshAldrinUserStatusPreference = this.f10347a;
            Futures.a(refreshAldrinUserStatusPreference.f10351b.m12179a(CallerContext.a(refreshAldrinUserStatusPreference.getClass())), new C11002(refreshAldrinUserStatusPreference), refreshAldrinUserStatusPreference.f10353d);
            return true;
        }
    }

    /* compiled from: likes */
    public class C11002 implements FutureCallback<AldrinUserStatus> {
        final /* synthetic */ RefreshAldrinUserStatusPreference f10349a;

        /* compiled from: likes */
        class C10991 implements Runnable {
            final /* synthetic */ C11002 f10348a;

            C10991(C11002 c11002) {
                this.f10348a = c11002;
            }

            public void run() {
                this.f10348a.f10349a.m12160a();
            }
        }

        public C11002(RefreshAldrinUserStatusPreference refreshAldrinUserStatusPreference) {
            this.f10349a = refreshAldrinUserStatusPreference;
        }

        public void onSuccess(@Nullable Object obj) {
            ExecutorDetour.a(this.f10349a.f10354e, new C10991(this), 1636471547);
        }

        public void onFailure(Throwable th) {
        }
    }

    public static void m12162a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((RefreshAldrinUserStatusPreference) obj).m12161a((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), FetchAldrinUserStatusClient.m12176b(injectorLike), AldrinUserStatusManager.a(injectorLike), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    public RefreshAldrinUserStatusPreference(Context context) {
        super(context);
        Class cls = RefreshAldrinUserStatusPreference.class;
        m12162a(this, getContext());
        setTitle("Force Refresh Aldrin User Status");
        m12160a();
        setOnPreferenceClickListener(new C10981(this));
    }

    private void m12160a() {
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        AldrinUserStatus d = this.f10352c.d();
        if (d == null) {
            stringBuilder.append("status: null");
        } else {
            stringBuilder.append("\nshouldBeCu: ");
            stringBuilder.append(d.shouldBeCu);
            stringBuilder.append("\nisCu: ");
            stringBuilder.append(d.isCu);
            stringBuilder.append("\nEffective region: ");
            stringBuilder.append(d.effectiveRegion);
            stringBuilder.append("\nCurrent region: ");
            stringBuilder.append(d.currentRegion);
            stringBuilder.append("\nTOS transition type: ");
            stringBuilder.append(d.tosTransitionType);
        }
        long a = this.f10350a.a(AldrinPrefKeys.f10343a, 0);
        stringBuilder.append("\nLast fetch time: ");
        if (a == 0) {
            str = "";
        } else {
            str = new SimpleDateFormat("MMM d, hh:mm:ss a z", Locale.US).format(new Date(a));
        }
        stringBuilder.append(str);
        setSummary(stringBuilder.toString());
    }

    private void m12161a(FbSharedPreferences fbSharedPreferences, FetchAldrinUserStatusClient fetchAldrinUserStatusClient, AldrinUserStatusManager aldrinUserStatusManager, ExecutorService executorService, ExecutorService executorService2) {
        this.f10350a = fbSharedPreferences;
        this.f10351b = fetchAldrinUserStatusClient;
        this.f10352c = aldrinUserStatusManager;
        this.f10353d = executorService;
        this.f10354e = executorService2;
    }
}
