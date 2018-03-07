package com.facebook.registration.fragment;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.facebook.analytics.prefs.AnalyticsPrefKeys;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.util.StringUtil;
import com.facebook.confirmation.task.BackgroundConfirmationHelper;
import com.facebook.confirmation.task.BackgroundConfirmationHelper.1;
import com.facebook.confirmation.task.BackgroundConfirmationHelper.ConfirmationMethod;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.gk.sessionless.GatekeeperStoreImpl_SessionlessMethodAutoProvider;
import com.facebook.gk.sessionless.Sessionless;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.growth.model.Contactpoint;
import com.facebook.growth.model.ContactpointType;
import com.facebook.growth.prefs.GrowthPrefKeys;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.intent.ufiservices.DefaultUriIntentGenerator;
import com.facebook.intent.ufiservices.UriIntentGenerator;
import com.facebook.performancelogger.MarkerConfig;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.registration.constants.RegErrorCategory;
import com.facebook.registration.constants.RegFragmentState;
import com.facebook.registration.constants.RegPermissions;
import com.facebook.registration.constants.RegProtocolConstants;
import com.facebook.registration.logging.RegistrationPerfLogger;
import com.facebook.registration.logging.SimpleRegLogger;
import com.facebook.registration.model.RegError;
import com.facebook.registration.model.SimpleRegFormData;
import com.facebook.registration.prefs.RegistrationPrefKeys;
import com.facebook.registration.protocol.RegisterAccountMethod.Result;
import com.facebook.registration.util.RegistrationUtil;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManager;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManagerProvider;
import com.facebook.runtimepermissions.RuntimePermissionsManager.RuntimePermissionsListener;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import javax.inject.Inject;

/* compiled from: last_geofence_flushed_start */
public class RegistrationCreateAccountFragment extends RegistrationNetworkRequestFragment {
    private static final CallerContext at = CallerContext.a(RegistrationCreateAccountFragment.class);
    @Inject
    ActivityRuntimePermissionsManagerProvider al;
    @Inject
    FbSharedPreferences am;
    @Inject
    RegistrationUtil an;
    @Inject
    @Sessionless
    GatekeeperStoreImpl ao;
    public ActivityRuntimePermissionsManager au;
    private Builder av;
    private boolean aw;
    private boolean ax;
    private String ay;
    @Inject
    public Lazy<BackgroundConfirmationHelper> f8814b;
    @Inject
    RegistrationPerfLogger f8815c;
    @Inject
    SecureContextHelper f8816d;
    @Inject
    public SimpleRegFormData f8817e;
    @Inject
    SimpleRegLogger f8818f;
    @Inject
    DefaultUriIntentGenerator f8819g;
    @Inject
    Lazy<Toaster> f8820h;
    @Inject
    AbstractFbErrorReporter f8821i;

    /* compiled from: last_geofence_flushed_start */
    class C13241 extends OperationResultFutureCallback {
        final /* synthetic */ RegistrationCreateAccountFragment f8801a;

        C13241(RegistrationCreateAccountFragment registrationCreateAccountFragment) {
            this.f8801a = registrationCreateAccountFragment;
        }

        protected final void m8797a(Object obj) {
            RegistrationCreateAccountFragment.m8813a(this.f8801a, (OperationResult) obj);
        }

        protected final void m8796a(ServiceException serviceException) {
            RegistrationCreateAccountFragment.m8816b(this.f8801a, serviceException);
        }
    }

    /* compiled from: last_geofence_flushed_start */
    public class C13252 implements RuntimePermissionsListener {
        final /* synthetic */ RegistrationCreateAccountFragment f8802a;

        public C13252(RegistrationCreateAccountFragment registrationCreateAccountFragment) {
            this.f8802a = registrationCreateAccountFragment;
        }

        public final void m8798a() {
            RegistrationCreateAccountFragment.aw(this.f8802a);
        }

        public final void m8799a(String[] strArr, String[] strArr2) {
            RegistrationCreateAccountFragment.aw(this.f8802a);
        }

        public final void m8800b() {
            RegistrationCreateAccountFragment.aw(this.f8802a);
        }
    }

    /* compiled from: last_geofence_flushed_start */
    class C13263 extends TypeReference<Map<Integer, String>> {
        final /* synthetic */ RegistrationCreateAccountFragment f8803b;

        C13263(RegistrationCreateAccountFragment registrationCreateAccountFragment) {
            this.f8803b = registrationCreateAccountFragment;
        }
    }

    public static void m8814a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((RegistrationCreateAccountFragment) obj).m8812a(IdBasedLazy.a(injectorLike, 882), RegistrationPerfLogger.m8873a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), SimpleRegFormData.a(injectorLike), SimpleRegLogger.b(injectorLike), DefaultUriIntentGenerator.a(injectorLike), IdBasedLazy.a(injectorLike, 3588), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (ActivityRuntimePermissionsManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ActivityRuntimePermissionsManagerProvider.class), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), RegistrationUtil.b(injectorLike), GatekeeperStoreImpl_SessionlessMethodAutoProvider.a(injectorLike));
    }

    public final void mo403c(Bundle bundle) {
        super.mo403c(bundle);
        Class cls = RegistrationCreateAccountFragment.class;
        m8814a((Object) this, getContext());
        this.av = new Builder(getContext()).a(false).a(2131239849).b(2131239850);
        if (bundle != null) {
            this.ay = bundle.getString("completion_url");
            if (this.ay != null && bundle.getBoolean("completion_dialog_shown")) {
                m8815a(this.ay);
            }
        }
        this.au = this.al.a(o());
    }

    public final void m8820e(Bundle bundle) {
        super.e(bundle);
        bundle.putString("completion_url", this.ay);
        bundle.putBoolean("completion_dialog_shown", this.ax);
    }

    protected final int mo384e() {
        return 2131239839;
    }

    protected final int as() {
        return 2131239841;
    }

    protected final void at() {
        this.f8817e.x();
        mo385a(RegFragmentState.ERROR_CONTINUE);
    }

    protected final void au() {
        if (!this.ax) {
            ListenableFuture listenableFuture;
            if (this.f8817e.e == ContactpointType.PHONE) {
                BackgroundConfirmationHelper backgroundConfirmationHelper = (BackgroundConfirmationHelper) this.f8814b.get();
                HandlerDetour.a(backgroundConfirmationHelper.e, new 1(backgroundConfirmationHelper), -229673806);
                backgroundConfirmationHelper.a(0);
                backgroundConfirmationHelper.a(new HashSet());
                backgroundConfirmationHelper.b(new HashSet());
            }
            if (this.f8817e.e != null) {
                this.aw = true;
                listenableFuture = this.f8817e.e;
                this.f8817e.e = null;
            } else {
                this.aw = false;
                listenableFuture = this.an.a(at);
            }
            PerformanceLogger performanceLogger = this.f8815c.f8899a;
            MarkerConfig b = new MarkerConfig(4194305, "AccountCreationTime").b();
            b.n = true;
            performanceLogger.a(b, true);
            this.ap.a(null, listenableFuture, new C13241(this));
            this.f8818f.a();
        }
    }

    public static void m8813a(RegistrationCreateAccountFragment registrationCreateAccountFragment, OperationResult operationResult) {
        if (operationResult == null) {
            registrationCreateAccountFragment.m8817b("Malformed success response");
            return;
        }
        Result result = (Result) operationResult.h();
        registrationCreateAccountFragment.f8817e.f = result;
        if (result == null) {
            registrationCreateAccountFragment.m8817b("Malformed success result");
        } else if (StringUtil.c(result.completionUrl)) {
            CharSequence charSequence;
            if (!StringUtil.c(result.userId)) {
                charSequence = result.userId;
            } else if (registrationCreateAccountFragment.f8817e.e == ContactpointType.PHONE) {
                r1 = registrationCreateAccountFragment.f8817e.h;
            } else {
                r1 = registrationCreateAccountFragment.f8817e.j;
            }
            if (StringUtil.c(charSequence)) {
                registrationCreateAccountFragment.m8817b("Create without uid/contactpoint");
                return;
            }
            String str = result.accountType;
            String str2 = result.userId;
            if ("full_bypass".equals(str) || "bypass_without_login".equals(str)) {
                if (registrationCreateAccountFragment.f8817e.e == ContactpointType.PHONE) {
                    ((BackgroundConfirmationHelper) registrationCreateAccountFragment.f8814b.get()).a(ConfirmationMethod.EXPERIMENTAL_SMS_CONFIRMATION, Contactpoint.a(registrationCreateAccountFragment.f8817e.h, registrationCreateAccountFragment.f8817e.g), str2);
                    if (!StringUtil.a(registrationCreateAccountFragment.f8817e.q)) {
                        ((BackgroundConfirmationHelper) registrationCreateAccountFragment.f8814b.get()).a(ConfirmationMethod.OPENID_CONNECT_EMAIL_CONFIRMATION, Contactpoint.a(registrationCreateAccountFragment.f8817e.q), str2);
                    }
                } else if (registrationCreateAccountFragment.f8817e.e == ContactpointType.EMAIL) {
                    ((BackgroundConfirmationHelper) registrationCreateAccountFragment.f8814b.get()).a(ConfirmationMethod.OPENID_CONNECT_EMAIL_CONFIRMATION, Contactpoint.a(registrationCreateAccountFragment.f8817e.j), str2);
                }
            }
            registrationCreateAccountFragment.az();
            registrationCreateAccountFragment.f8815c.m8877b();
            registrationCreateAccountFragment.f8818f.a(result.accountType, result.userId);
            registrationCreateAccountFragment.f8817e.p = true;
            if (registrationCreateAccountFragment.f8817e.e == ContactpointType.PHONE) {
                registrationCreateAccountFragment.au.a(RegPermissions.f8716b, new C13252(registrationCreateAccountFragment));
            } else {
                aw(registrationCreateAccountFragment);
            }
        } else {
            registrationCreateAccountFragment.f8815c.f8899a.a(4194305, "AccountCreationTime", null, "result", "completion_url");
            registrationCreateAccountFragment.f8818f.b();
            registrationCreateAccountFragment.f8817e.p = true;
            registrationCreateAccountFragment.m8815a(result.completionUrl);
        }
    }

    public static void aw(RegistrationCreateAccountFragment registrationCreateAccountFragment) {
        registrationCreateAccountFragment.mo385a(RegFragmentState.CREATE_SUCCESS);
    }

    public static void m8816b(RegistrationCreateAccountFragment registrationCreateAccountFragment, ServiceException serviceException) {
        registrationCreateAccountFragment.f8817e.x();
        registrationCreateAccountFragment.f8817e.p = false;
        Map map = (Map) registrationCreateAccountFragment.m8809a(new C13263(registrationCreateAccountFragment), serviceException);
        if (map == null || map.isEmpty()) {
            map = new HashMap();
            RegError a = registrationCreateAccountFragment.m8808a(serviceException);
            if (!(a == null || StringUtil.c(a.message))) {
                map.put(Integer.valueOf(a.code), a.message);
            }
        }
        if (map == null || map.isEmpty()) {
            String str;
            OperationResult operationResult = serviceException.result;
            if (operationResult == null || operationResult.e == null) {
                str = "No response or malformed failed response";
            } else {
                str = operationResult.e.name() + ": " + operationResult.f;
            }
            registrationCreateAccountFragment.m8817b(str);
            return;
        }
        for (Entry entry : map.entrySet()) {
            RegErrorCategory regErrorCategory;
            RegErrorCategory regErrorCategory2 = (RegErrorCategory) RegProtocolConstants.f8717a.get(entry.getKey());
            if (regErrorCategory2 == null) {
                regErrorCategory = RegErrorCategory.UNKNOWN;
            } else {
                regErrorCategory = regErrorCategory2;
            }
            registrationCreateAccountFragment.f8817e.a(regErrorCategory, ((Integer) entry.getKey()).intValue(), (String) entry.getValue());
            registrationCreateAccountFragment.f8815c.f8899a.a(4194305, "AccountCreationTime", null, "result", "server_validation");
            registrationCreateAccountFragment.f8818f.b(String.valueOf(entry.getKey()), (String) entry.getValue());
        }
        registrationCreateAccountFragment.mo385a(RegFragmentState.CREATE_ERROR);
    }

    private void m8815a(final String str) {
        this.ay = str;
        this.ax = true;
        this.av.a(2131230730, new OnClickListener(this) {
            final /* synthetic */ RegistrationCreateAccountFragment f8805b;

            public void onClick(DialogInterface dialogInterface, int i) {
                Context context = this.f8805b.getContext();
                try {
                    this.f8805b.f8816d.b(this.f8805b.f8819g.a(str), context);
                } catch (ActivityNotFoundException e) {
                    ((Toaster) this.f8805b.f8820h.get()).a(new ToastBuilder(2131239851));
                    this.f8805b.f8821i.a("RegistrationCompletionUrlBrowserMissing", "ActivityNotFoundException when attempting to open web view to " + str);
                }
                this.f8805b.o().finish();
            }
        }).b();
    }

    private void m8817b(String str) {
        av();
        this.f8818f.b("unknown", str);
        this.f8815c.f8899a.f(4194305, "AccountCreationTime");
    }

    private void az() {
        boolean z = false;
        Object obj = this.f8817e.f.userId;
        if (this.ao.a(28, false) || this.an.a()) {
            z = true;
        }
        if (z && !StringUtil.c(obj)) {
            this.am.edit().putBoolean(GrowthPrefKeys.b(obj), this.f8817e.b).commit();
        }
        if (this.aw && !StringUtil.c(obj)) {
            this.am.edit().a(RegistrationPrefKeys.a(obj), this.f8817e.o.name()).commit();
            this.f8818f.d(obj);
        }
        if (!StringUtil.c(obj)) {
            this.am.edit().putBoolean(AnalyticsPrefKeys.a(obj), true).commit();
        }
    }

    private void m8812a(Lazy<BackgroundConfirmationHelper> lazy, RegistrationPerfLogger registrationPerfLogger, SecureContextHelper secureContextHelper, SimpleRegFormData simpleRegFormData, SimpleRegLogger simpleRegLogger, UriIntentGenerator uriIntentGenerator, Lazy<Toaster> lazy2, FbErrorReporter fbErrorReporter, ActivityRuntimePermissionsManagerProvider activityRuntimePermissionsManagerProvider, FbSharedPreferences fbSharedPreferences, RegistrationUtil registrationUtil, GatekeeperStore gatekeeperStore) {
        this.f8814b = lazy;
        this.f8815c = registrationPerfLogger;
        this.f8816d = secureContextHelper;
        this.f8817e = simpleRegFormData;
        this.f8818f = simpleRegLogger;
        this.f8819g = uriIntentGenerator;
        this.f8820h = lazy2;
        this.f8821i = fbErrorReporter;
        this.al = activityRuntimePermissionsManagerProvider;
        this.am = fbSharedPreferences;
        this.an = registrationUtil;
        this.ao = gatekeeperStore;
    }
}
