package com.facebook.registration.controller;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.base.fragment.AbstractNavigableFragmentController;
import com.facebook.base.fragment.NavigableFragment;
import com.facebook.base.fragment.NavigableFragmentController.Listener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.TriState;
import com.facebook.device_id.DeviceIdPrefKeys;
import com.facebook.device_id.UniqueDeviceIdBroadcastSender;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.gk.sessionless.GatekeeperStoreImpl_SessionlessMethodAutoProvider;
import com.facebook.gk.sessionless.Sessionless;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.growth.model.DeviceOwnerData;
import com.facebook.growth.util.DeviceOwnerDataFetcher;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.registration.constants.RegFragmentState;
import com.facebook.registration.logging.SimpleRegLogger;
import com.facebook.registration.model.ContactPointSuggestions;
import com.facebook.registration.model.SimpleRegFormData;
import com.facebook.registration.notification.RegistrationNotificationHelper;
import com.facebook.registration.util.RegistrationUtil;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.dialogs.ProgressDialogFragment;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: launch_host */
public class RegistrationFragmentController extends AbstractNavigableFragmentController {
    private static final CallerContext an = CallerContext.a(RegistrationFragmentController.class);
    @Inject
    DeviceOwnerDataFetcher f8741a;
    @Inject
    @Sessionless
    GatekeeperStoreImpl al;
    @Inject
    DefaultBlueServiceOperationFactory am;
    private boolean ao = false;
    @Inject
    MainRegStateMachine f8742b;
    @Inject
    SimpleRegFormData f8743c;
    @Inject
    SimpleRegLogger f8744d;
    @Inject
    RegistrationNotificationHelper f8745e;
    @Inject
    FunnelLoggerImpl f8746f;
    @Inject
    @ForUiThread
    Executor f8747g;
    @Inject
    RegistrationUtil f8748h;
    @Inject
    UniqueDeviceIdBroadcastSender f8749i;

    /* compiled from: launch_host */
    class C13061 implements Listener {
        final /* synthetic */ RegistrationFragmentController f8737a;

        C13061(RegistrationFragmentController registrationFragmentController) {
            this.f8737a = registrationFragmentController;
        }

        public final void m8745a(NavigableFragment navigableFragment, Intent intent) {
            RegFragmentState valueOfKey = RegFragmentState.valueOfKey(intent.getAction());
            this.f8737a.b(this.f8737a.f8742b.m8743a(valueOfKey));
            this.f8737a.f8744d.a(valueOfKey);
        }
    }

    /* compiled from: launch_host */
    class C13083 extends AbstractDisposableFutureCallback<OperationResult> {
        final /* synthetic */ RegistrationFragmentController f8740a;

        C13083(RegistrationFragmentController registrationFragmentController) {
            this.f8740a = registrationFragmentController;
        }

        protected final void m8748a(Object obj) {
            ContactPointSuggestions contactPointSuggestions = (ContactPointSuggestions) ((OperationResult) obj).h();
            this.f8740a.f8743c.a(contactPointSuggestions);
            this.f8740a.f8744d.a(contactPointSuggestions.prefillContactPoints.size(), contactPointSuggestions.autocompleteContactPoints.size());
        }

        protected final void m8749a(Throwable th) {
            this.f8740a.f8744d.g(th.getMessage());
        }
    }

    private static <T extends InjectableComponentWithContext> void m8751a(Class<T> cls, T t) {
        m8752a((Object) t, t.getContext());
    }

    private static void m8752a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((RegistrationFragmentController) obj).m8750a(DeviceOwnerDataFetcher.a(fbInjector), MainRegStateMachine.m8735b(fbInjector), SimpleRegFormData.a(fbInjector), SimpleRegLogger.b(fbInjector), RegistrationNotificationHelper.m8889a(fbInjector), FunnelLoggerImpl.a(fbInjector), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector), RegistrationUtil.b(fbInjector), UniqueDeviceIdBroadcastSender.b(fbInjector), GatekeeperStoreImpl_SessionlessMethodAutoProvider.a(fbInjector), DefaultBlueServiceOperationFactory.b(fbInjector));
    }

    public final void m8753c(Bundle bundle) {
        super.c(bundle);
        m8751a(RegistrationFragmentController.class, (InjectableComponentWithContext) this);
        this.d = new C13061(this);
        if (bundle != null) {
            this.ao = bundle.getBoolean("controller_started", false);
            SimpleRegFormData simpleRegFormData = (SimpleRegFormData) bundle.getParcelable("form_data");
            if (simpleRegFormData != null) {
                SimpleRegFormData simpleRegFormData2 = this.f8743c;
                simpleRegFormData2.a = simpleRegFormData.a;
                simpleRegFormData2.b = simpleRegFormData.b;
                simpleRegFormData2.c = simpleRegFormData.c;
                simpleRegFormData2.d = simpleRegFormData.d;
                simpleRegFormData2.e = simpleRegFormData.e;
                simpleRegFormData2.f = simpleRegFormData.f;
                simpleRegFormData2.g = simpleRegFormData.g;
                simpleRegFormData2.h = simpleRegFormData.h;
                simpleRegFormData2.i = simpleRegFormData.i;
                simpleRegFormData2.j = simpleRegFormData.j;
                simpleRegFormData2.k = simpleRegFormData.k;
                simpleRegFormData2.l = simpleRegFormData.l;
                simpleRegFormData2.m = simpleRegFormData.m;
                simpleRegFormData2.n = simpleRegFormData.n;
                simpleRegFormData2.o = simpleRegFormData.o;
                simpleRegFormData2.p = simpleRegFormData.p;
                simpleRegFormData2.q = simpleRegFormData.q;
                simpleRegFormData2.a = simpleRegFormData.a;
                simpleRegFormData2.b = simpleRegFormData.b;
                simpleRegFormData2.c = simpleRegFormData.c;
                simpleRegFormData2.d = simpleRegFormData.d;
                simpleRegFormData2.e = simpleRegFormData.e;
                simpleRegFormData2.f = simpleRegFormData.f;
            }
        }
        if (!this.ao) {
            as();
            this.f8749i.i();
            ListenableFuture a = this.f8741a.a();
            this.f8743c.a(this.f8741a.g);
            if (!this.f8748h.a() || this.f8748h.e()) {
                aq();
                return;
            }
            final ProgressDialogFragment progressDialogFragment = (ProgressDialogFragment) ProgressDialogFragment.a(jW_().getString(2131230739), true, false);
            progressDialogFragment.a(s(), "DEVICE_OWNER_DATA_DIALOG");
            Futures.a(a, new AbstractDisposableFutureCallback<DeviceOwnerData>(this) {
                final /* synthetic */ RegistrationFragmentController f8739b;

                protected final void m8746a(Object obj) {
                    progressDialogFragment.a();
                    this.f8739b.aq();
                }

                protected final void m8747a(Throwable th) {
                    progressDialogFragment.a();
                    this.f8739b.aq();
                }
            }, this.f8747g);
        }
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1699712692);
        if (ar() && !this.f8743c.p) {
            this.f8745e.m8892a();
        }
        super.mj_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1011846507, a);
    }

    public final void m8754e(Bundle bundle) {
        super.e(bundle);
        bundle.putBoolean("controller_started", this.ao);
        bundle.putParcelable("form_data", this.f8743c);
    }

    public final void aq() {
        this.ao = true;
        Intent a = this.f8742b.m8729c().mo380a();
        a.putExtra("com.facebook.fragment.ENTER_ANIM", 0);
        b(a);
        this.f8746f.a(FunnelRegistry.d);
        this.f8745e.m8893b();
    }

    public final boolean ar() {
        return this.f8743c.a;
    }

    private void as() {
        if (!at()) {
            return;
        }
        if (this.f8749i.k.a(DeviceIdPrefKeys.c)) {
            this.f8744d.b(true);
            Futures.a(BlueServiceOperationFactoryDetour.a(this.am, "registration_contact_point_suggestions", new Bundle(), ErrorPropagation.BY_ERROR_CODE, an, -779549758).a(), new C13083(this), this.f8747g);
            return;
        }
        this.f8744d.b(false);
    }

    private boolean at() {
        TriState a = this.al.a(17);
        this.f8744d.a("reg_fetch_server_contacts", a);
        return a.asBoolean(false);
    }

    private void m8750a(DeviceOwnerDataFetcher deviceOwnerDataFetcher, MainRegStateMachine mainRegStateMachine, SimpleRegFormData simpleRegFormData, SimpleRegLogger simpleRegLogger, RegistrationNotificationHelper registrationNotificationHelper, FunnelLoggerImpl funnelLoggerImpl, Executor executor, RegistrationUtil registrationUtil, UniqueDeviceIdBroadcastSender uniqueDeviceIdBroadcastSender, GatekeeperStoreImpl gatekeeperStoreImpl, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory) {
        this.f8741a = deviceOwnerDataFetcher;
        this.f8742b = mainRegStateMachine;
        this.f8743c = simpleRegFormData;
        this.f8744d = simpleRegLogger;
        this.f8745e = registrationNotificationHelper;
        this.f8746f = funnelLoggerImpl;
        this.f8747g = executor;
        this.f8748h = registrationUtil;
        this.f8749i = uniqueDeviceIdBroadcastSender;
        this.al = gatekeeperStoreImpl;
        this.am = defaultBlueServiceOperationFactory;
    }
}
