package com.facebook.messaging.payment.value.input;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.LocalBroadcast;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbservice.ops.ResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.connectivity.ConnectionStatusMonitor;
import com.facebook.messaging.connectivity.ConnectionStatusMonitor.ConnectionType;
import com.facebook.messaging.connectivity.ConnectionStatusMonitorMethodAutoProvider;
import com.facebook.messaging.payment.config.IsP2pPaymentsSyncProtocolEnabled;
import com.facebook.messaging.payment.currency.CurrencyFormatType;
import com.facebook.messaging.payment.currency.PaymentCurrencyUtil;
import com.facebook.messaging.payment.method.input.MessengerPayCardFormParams;
import com.facebook.messaging.payment.method.input.MessengerPayCardFormParamsBuilder;
import com.facebook.messaging.payment.method.verification.PaymentMethodVerificationController;
import com.facebook.messaging.payment.method.verification.PaymentMethodVerificationController.ResultCallback;
import com.facebook.messaging.payment.method.verification.PaymentMethodVerificationParams;
import com.facebook.messaging.payment.model.PaymentCard;
import com.facebook.messaging.payment.model.VerificationFollowUpAction;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLInterfaces.PaymentPlatformContext;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentPlatformContextModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentRequestModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentShippingOptionModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.ThemeModel;
import com.facebook.messaging.payment.pin.PaymentPinConfirmActivity;
import com.facebook.messaging.payment.protocol.PaymentProtocolUtil;
import com.facebook.messaging.payment.util.PaymentAddressUtil;
import com.facebook.messaging.payment.util.PaymentsSoundUtil;
import com.facebook.messaging.payment.value.input.EnterPaymentValueActivity.C17601;
import com.facebook.messaging.payment.value.input.checkout.PaymentShippingOptionUtil;
import com.facebook.messaging.payment.value.util.PaymentsSoftInputUtil;
import com.facebook.payments.confirmation.ConfirmationActivity;
import com.facebook.payments.confirmation.ConfirmationCommonParams;
import com.facebook.payments.confirmation.ConfirmationCommonParamsBuilder;
import com.facebook.payments.confirmation.ConfirmationStyle;
import com.facebook.payments.dialog.PaymentsConfirmDialogFragment;
import com.facebook.payments.dialog.PaymentsConfirmDialogFragment.Listener;
import com.facebook.payments.model.FormFieldProperty;
import com.facebook.payments.model.PaymentItemType;
import com.facebook.payments.paymentmethods.cardform.CardFormActivity;
import com.facebook.payments.paymentmethods.cardform.CardFormAnalyticsParams;
import com.facebook.payments.paymentmethods.cardform.CardFormAnalyticsParamsBuilder;
import com.facebook.payments.paymentmethods.cardform.CardFormCommonParams;
import com.facebook.payments.paymentmethods.cardform.CardFormCommonParamsBuilder;
import com.facebook.payments.paymentmethods.cardform.CardFormStyle;
import com.facebook.payments.paymentmethods.cardform.CardFormStyleParams;
import com.facebook.payments.paymentmethods.model.FbPaymentCard;
import com.facebook.payments.paymentmethods.model.PaymentMethod;
import com.facebook.payments.paymentmethods.model.PaymentMethodType;
import com.facebook.payments.paymentmethods.picker.PickerScreenActivity;
import com.facebook.payments.paymentmethods.picker.PickerScreenParams;
import com.facebook.payments.paymentmethods.picker.PickerScreenStyle;
import com.facebook.payments.shipping.form.ShippingAddressActivity;
import com.facebook.payments.shipping.model.MailingAddress;
import com.facebook.payments.shipping.model.ShippingCommonParams;
import com.facebook.payments.shipping.model.ShippingCommonParamsBuilder;
import com.facebook.payments.shipping.model.ShippingSource;
import com.facebook.payments.shipping.model.ShippingStyle;
import com.facebook.payments.shipping.optionpicker.ShippingOptionPickerScreenParams;
import com.facebook.payments.shipping.optionpicker.ShippingOptionPickerScreenParamsBuilder;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: extra_layout */
public class EnterPaymentValueFragment extends FbFragment {
    @Inject
    GatekeeperStoreImpl f15279a;
    public ListenableFuture<PaymentPlatformContext> aA;
    public ListenableFuture<OperationResult> aB;
    public SelfRegistrableReceiverImpl aC;
    public C17601 aD;
    public final Listener aE = new C17681(this);
    public final Listener aF = new C17692(this);
    public final Listener aG = new C17703(this);
    public final C17714 aH = new C17714(this);
    public final C17725 aI = new C17725(this);
    public final C17736 aJ = new C17736(this);
    @Inject
    PaymentsSoundUtil al;
    @Inject
    public PaymentProtocolUtil am;
    @Inject
    @ForUiThread
    public Executor an;
    @Inject
    public CompositeMessengerPayIneligibleRecipientHandler ao;
    @Inject
    public CompositeMessengerPaySender ap;
    @Inject
    CompositeMessengerPayInitializer aq;
    @Inject
    public CompositeMessengerPayLogger ar;
    @Inject
    CompositeMessengerPayLoader as;
    @Inject
    MessengerPayViewFactory at;
    @Inject
    OrionRequestAckMessengerPayLogger au;
    @Inject
    MessengerPayPickerScreenParamHelper av;
    private MenuItem aw;
    private MessengerPayView ax;
    public MessengerPayData ay;
    public MessengerPayType az;
    @Inject
    PaymentCurrencyUtil f15280b;
    @Inject
    AbstractFbErrorReporter f15281c;
    @Inject
    PaymentsSoftInputUtil f15282d;
    @Inject
    @IsP2pPaymentsSyncProtocolEnabled
    Provider<Boolean> f15283e;
    @Inject
    @LocalBroadcast
    public LocalFbBroadcastManager f15284f;
    @Inject
    public PaymentMethodVerificationController f15285g;
    @Inject
    public SecureContextHelper f15286h;
    @Inject
    ConnectionStatusMonitor f15287i;

    /* compiled from: extra_layout */
    class C17681 implements Listener {
        final /* synthetic */ EnterPaymentValueFragment f15270a;

        C17681(EnterPaymentValueFragment enterPaymentValueFragment) {
            this.f15270a = enterPaymentValueFragment;
        }

        public final void m15617a() {
            EnterPaymentValueFragment.aT(this.f15270a);
        }

        public final void m15618b() {
        }

        public final void m15619c() {
            EnterPaymentValueFragment.aS(this.f15270a);
        }
    }

    /* compiled from: extra_layout */
    class C17692 implements Listener {
        final /* synthetic */ EnterPaymentValueFragment f15271a;

        C17692(EnterPaymentValueFragment enterPaymentValueFragment) {
            this.f15271a = enterPaymentValueFragment;
        }

        public final void m15620a() {
            EnterPaymentValueFragment.aD(this.f15271a);
        }

        public final void m15621b() {
            this.f15271a.f15286h.b(new Intent("android.intent.action.VIEW").setData(Uri.parse("https://m.facebook.com/help/messenger-app/android/574381195996811")), this.f15271a.getContext());
            EnterPaymentValueFragment.aD(this.f15271a);
        }

        public final void m15622c() {
            EnterPaymentValueFragment.aD(this.f15271a);
        }
    }

    /* compiled from: extra_layout */
    class C17703 implements Listener {
        final /* synthetic */ EnterPaymentValueFragment f15272a;

        C17703(EnterPaymentValueFragment enterPaymentValueFragment) {
            this.f15272a = enterPaymentValueFragment;
        }

        public final void m15623a() {
            EnterPaymentValueFragment enterPaymentValueFragment = this.f15272a;
            if (!EnterPaymentValueFragment.m15645a(enterPaymentValueFragment.aB)) {
                enterPaymentValueFragment.aB.cancel(true);
            }
            enterPaymentValueFragment.aB = enterPaymentValueFragment.am.m14946a(enterPaymentValueFragment.getContext(), ((PaymentRequestModel) FlatBufferModelHelper.a(enterPaymentValueFragment.s, "payment_request")).lw_(), enterPaymentValueFragment.jW_().getString(2131240563));
            Futures.a(enterPaymentValueFragment.aB, new ResultFutureCallback<OperationResult>(enterPaymentValueFragment) {
                final /* synthetic */ EnterPaymentValueFragment f15264a;

                {
                    this.f15264a = r1;
                }

                public final void m15609a(ServiceException serviceException) {
                    EnterPaymentValueFragment.m15646b(this.f15264a, "p2p_decline_fail");
                    this.f15264a.f15281c.a("EnterPaymentValueFragment", "Failed to decline a request.");
                    this.f15264a.aD.m15574a();
                }

                public final void m15610a(Object obj) {
                    EnterPaymentValueFragment.m15646b(this.f15264a, "p2p_decline_success");
                    EnterPaymentValueFragment.aD(this.f15264a);
                }
            }, enterPaymentValueFragment.an);
            EnterPaymentValueFragment.m15646b(enterPaymentValueFragment, "p2p_confirm_decline");
        }

        public final void m15624b() {
        }

        public final void m15625c() {
        }
    }

    /* compiled from: extra_layout */
    public class C17714 {
        final /* synthetic */ EnterPaymentValueFragment f15273a;

        C17714(EnterPaymentValueFragment enterPaymentValueFragment) {
            this.f15273a = enterPaymentValueFragment;
        }

        public final void m15626a() {
            EnterPaymentValueFragment.aP(this.f15273a);
        }

        public final void m15627a(PaymentCard paymentCard) {
            this.f15273a.ay.m15756b(Optional.of(paymentCard));
        }
    }

    /* compiled from: extra_layout */
    public class C17725 {
        public final /* synthetic */ EnterPaymentValueFragment f15274a;

        C17725(EnterPaymentValueFragment enterPaymentValueFragment) {
            this.f15274a = enterPaymentValueFragment;
        }
    }

    /* compiled from: extra_layout */
    public class C17736 {
        public final /* synthetic */ EnterPaymentValueFragment f15275a;

        C17736(EnterPaymentValueFragment enterPaymentValueFragment) {
            this.f15275a = enterPaymentValueFragment;
        }
    }

    /* compiled from: extra_layout */
    public class C17747 {
        public final /* synthetic */ EnterPaymentValueFragment f15276a;

        C17747(EnterPaymentValueFragment enterPaymentValueFragment) {
            this.f15276a = enterPaymentValueFragment;
        }

        public final void m15629a(String str) {
            this.f15276a.ay.m15753a(str);
        }

        public final void m15631b(String str) {
            this.f15276a.ay.m15746a(new MessengerPayAmount(str));
        }

        public final void m15630b() {
            if (EnterPaymentValueFragment.aW(this.f15276a)) {
                EnterPaymentValueFragment.aL(this.f15276a);
            } else {
                EnterPaymentValueFragment.aM(this.f15276a);
            }
        }

        public final void m15632c() {
            if (EnterPaymentValueFragment.aW(this.f15276a)) {
                EnterPaymentValueFragment.aL(this.f15276a);
            } else {
                EnterPaymentValueFragment.aP(this.f15276a);
            }
        }

        public final void m15633f() {
            EnterPaymentValueFragment.aO(this.f15276a);
        }

        public final void m15634g() {
            this.f15276a.f15286h.b(new Intent("android.intent.action.VIEW").setData(Uri.parse("https://m.facebook.com/help/messenger-app/750020781733477")), this.f15276a.getContext());
        }

        public final void m15635h() {
            EnterPaymentValueFragment.av(this.f15276a);
        }

        public final void m15628a(@Nullable ThemeModel themeModel) {
            this.f15276a.ay.m15744a(themeModel);
        }
    }

    /* compiled from: extra_layout */
    public class C17758 {
        final /* synthetic */ EnterPaymentValueFragment f15277a;

        C17758(EnterPaymentValueFragment enterPaymentValueFragment) {
            this.f15277a = enterPaymentValueFragment;
        }

        public final void m15636a() {
            EnterPaymentValueFragment.aS(this.f15277a);
        }

        public final void m15637a(@Nullable Intent intent) {
            if (intent != null) {
                this.f15277a.ao().setResult(-1, intent);
            } else {
                this.f15277a.ao().setResult(-1);
            }
            this.f15277a.f15282d.m16055a(this.f15277a.ao());
            this.f15277a.ao().finish();
        }

        public final void m15638a(Intent intent, int i, boolean z) {
            if (z) {
                this.f15277a.ao().setResult(-1);
                EnterPaymentValueFragment.aD(this.f15277a);
            }
            this.f15277a.f15286h.a(intent, i, this.f15277a);
        }
    }

    /* compiled from: extra_layout */
    public class C17769 {
        final /* synthetic */ EnterPaymentValueFragment f15278a;

        C17769(EnterPaymentValueFragment enterPaymentValueFragment) {
            this.f15278a = enterPaymentValueFragment;
        }

        public final void m15639a() {
            this.f15278a.f15281c.a("EnterPaymentValueFragment", "Failed to fetch sender's info needed for sending money.");
            if (this.f15278a.y) {
                EnterPaymentValueFragment.at(this.f15278a);
            }
            if (this.f15278a.f15287i.a(ConnectionType.HTTP)) {
                this.f15278a.aD.m15574a();
            }
        }
    }

    public static void m15644a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((EnterPaymentValueFragment) obj).m15641a(GatekeeperStoreImplMethodAutoProvider.a(injectorLike), PaymentCurrencyUtil.m13192a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), PaymentsSoftInputUtil.m16053a(injectorLike), IdBasedProvider.a(injectorLike, 4184), LocalFbBroadcastManager.a(injectorLike), PaymentMethodVerificationController.m13443a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), ConnectionStatusMonitorMethodAutoProvider.a(injectorLike), PaymentsSoundUtil.m15529a(injectorLike), PaymentProtocolUtil.m14937a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), CompositeMessengerPayIneligibleRecipientHandler.m15551a(injectorLike), CompositeMessengerPaySender.m15570a(injectorLike), CompositeMessengerPayInitializer.m15554a(injectorLike), CompositeMessengerPayLogger.m15563a(injectorLike), CompositeMessengerPayLoader.m15559a(injectorLike), MessengerPayViewFactory.m15773a(injectorLike), OrionRequestAckMessengerPayLogger.m15810a(injectorLike), MessengerPayPickerScreenParamHelper.m15768a(injectorLike));
    }

    private void m15641a(GatekeeperStore gatekeeperStore, PaymentCurrencyUtil paymentCurrencyUtil, FbErrorReporter fbErrorReporter, PaymentsSoftInputUtil paymentsSoftInputUtil, Provider<Boolean> provider, LocalFbBroadcastManager localFbBroadcastManager, PaymentMethodVerificationController paymentMethodVerificationController, SecureContextHelper secureContextHelper, ConnectionStatusMonitor connectionStatusMonitor, PaymentsSoundUtil paymentsSoundUtil, PaymentProtocolUtil paymentProtocolUtil, Executor executor, CompositeMessengerPayIneligibleRecipientHandler compositeMessengerPayIneligibleRecipientHandler, CompositeMessengerPaySender compositeMessengerPaySender, CompositeMessengerPayInitializer compositeMessengerPayInitializer, CompositeMessengerPayLogger compositeMessengerPayLogger, CompositeMessengerPayLoader compositeMessengerPayLoader, MessengerPayViewFactory messengerPayViewFactory, OrionRequestAckMessengerPayLogger orionRequestAckMessengerPayLogger, MessengerPayPickerScreenParamHelper messengerPayPickerScreenParamHelper) {
        this.f15279a = gatekeeperStore;
        this.f15280b = paymentCurrencyUtil;
        this.f15281c = fbErrorReporter;
        this.f15282d = paymentsSoftInputUtil;
        this.f15283e = provider;
        this.f15284f = localFbBroadcastManager;
        this.f15285g = paymentMethodVerificationController;
        this.f15286h = secureContextHelper;
        this.f15287i = connectionStatusMonitor;
        this.al = paymentsSoundUtil;
        this.am = paymentProtocolUtil;
        this.an = executor;
        this.ao = compositeMessengerPayIneligibleRecipientHandler;
        this.ap = compositeMessengerPaySender;
        this.aq = compositeMessengerPayInitializer;
        this.ar = compositeMessengerPayLogger;
        this.as = compositeMessengerPayLoader;
        this.at = messengerPayViewFactory;
        this.au = orionRequestAckMessengerPayLogger;
        this.av = messengerPayPickerScreenParamHelper;
    }

    public static EnterPaymentValueFragment m15640a(OrionMessengerPayParams orionMessengerPayParams) {
        EnterPaymentValueFragment enterPaymentValueFragment = new EnterPaymentValueFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("messenger_pay_type", MessengerPayType.ORION);
        bundle.putParcelable("orion_messenger_pay_params", orionMessengerPayParams);
        enterPaymentValueFragment.g(bundle);
        return enterPaymentValueFragment;
    }

    public final void m15653c(Bundle bundle) {
        super.c(bundle);
        Class cls = EnterPaymentValueFragment.class;
        m15644a((Object) this, getContext());
        d(true);
        this.az = (MessengerPayType) this.s.getSerializable("messenger_pay_type");
        e(!aW(this));
        AnonymousClass12 anonymousClass12 = new ActionReceiver(this) {
            final /* synthetic */ EnterPaymentValueFragment f15262a;

            {
                this.f15262a = r1;
            }

            public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
                int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 295398773);
                this.f15262a.as.mo612a(this.f15262a.s, this.f15262a.ay);
                Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -796887595, a);
            }
        };
        this.aC = this.f15284f.a().a("com.facebook.messaging.payment.ACTION_PAYMENT_CARD_UPDATED", anonymousClass12).a("com.facebook.messaging.payment.ACTION_PIN_UPDATED", anonymousClass12).a("com.facebook.orca.CONNECTIVITY_CHANGED", new ActionReceiver(this) {
            final /* synthetic */ EnterPaymentValueFragment f15263a;

            {
                this.f15263a = r1;
            }

            public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
                int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 345432207);
                if (this.f15263a.f15287i.b(ConnectionType.HTTP) != this.f15263a.f15287i.a(ConnectionType.HTTP)) {
                    this.f15263a.as.mo612a(this.f15263a.s, this.f15263a.ay);
                }
                Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1766937767, a);
            }
        }).a();
    }

    public final View m15649a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1953139529);
        this.ax = this.at.m15775a(this.az);
        View view = (View) this.ax;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1778754782, a);
        return view;
    }

    public final void m15651a(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(2131820578, menu);
        this.aw = menu.findItem(2131568672);
        this.ax.mo621a(this.aw);
    }

    public final boolean a_(MenuItem menuItem) {
        if (menuItem.getItemId() != 2131568672) {
            return super.a_(menuItem);
        }
        av(this);
        return true;
    }

    public final void m15652a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.ax.setListener(new C17747(this));
        if (bundle != null) {
            m15643a((MessengerPayData) bundle.getParcelable("messenger_pay_data"));
            at(this);
        } else {
            m15643a(new MessengerPayData());
            this.aq.mo610a(this.s, this.ay);
        }
        this.ap.mo616a(new C17758(this));
        this.as.mo613a(new C17769(this));
        this.as.mo612a(this.s, this.ay);
        as();
        PaymentsConfirmDialogFragment paymentsConfirmDialogFragment = (PaymentsConfirmDialogFragment) kO_().a("send_confirm_dialog");
        if (paymentsConfirmDialogFragment != null) {
            paymentsConfirmDialogFragment.am = this.aE;
        }
        paymentsConfirmDialogFragment = (PaymentsConfirmDialogFragment) kO_().a("decline_request_dialog");
        if (paymentsConfirmDialogFragment != null) {
            paymentsConfirmDialogFragment.am = this.aG;
        }
        paymentsConfirmDialogFragment = (PaymentsConfirmDialogFragment) kO_().a("ineligible_recipient_dialog");
        if (paymentsConfirmDialogFragment != null) {
            paymentsConfirmDialogFragment.am = this.aF;
        }
        PaymentSelectCardDialogFragment paymentSelectCardDialogFragment = (PaymentSelectCardDialogFragment) kO_().a("select_card_dialog");
        if (paymentSelectCardDialogFragment != null) {
            paymentSelectCardDialogFragment.ao = this.aH;
        }
        PaymentSelectAddressDialogFragment paymentSelectAddressDialogFragment = (PaymentSelectAddressDialogFragment) kO_().a("select_address_dialog");
        if (paymentSelectAddressDialogFragment != null) {
            paymentSelectAddressDialogFragment.an = this.aI;
        }
        PaymentSelectShippingOptionDialogFragment paymentSelectShippingOptionDialogFragment = (PaymentSelectShippingOptionDialogFragment) kO_().a("select_shipping_option_dialog");
        if (paymentSelectShippingOptionDialogFragment != null) {
            paymentSelectShippingOptionDialogFragment.an = this.aJ;
        }
    }

    public static void m15646b(EnterPaymentValueFragment enterPaymentValueFragment, String str) {
        enterPaymentValueFragment.au.m15813a(str, (PaymentRequestModel) FlatBufferModelHelper.a(enterPaymentValueFragment.s, "payment_request"));
    }

    private void m15643a(MessengerPayData messengerPayData) {
        this.ay = messengerPayData;
        this.ay.f15444a = new Object(this) {
            public final /* synthetic */ EnterPaymentValueFragment f15260a;

            {
                this.f15260a = r1;
            }
        };
    }

    public final void m15647G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -944934460);
        super.G();
        this.aC.b();
        aS(this);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 797805609, a);
    }

    public final void m15650a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        switch (i) {
            case 1:
                if (i2 != -1) {
                    aS(this);
                    this.as.mo612a(this.s, this.ay);
                    break;
                }
                this.ay.f15465v = intent.getStringExtra("user_entered_pin");
                aT(this);
                break;
            case 2:
            case 3:
                if (i2 == -1) {
                    MailingAddress mailingAddress = (MailingAddress) intent.getParcelableExtra("shipping_address");
                    m15642a(this, mailingAddress);
                    Builder builder = new Builder();
                    builder.c(mailingAddress);
                    builder.b(this.ay.f15453j);
                    this.ay.m15752a(builder.b());
                    this.as.mo612a(this.s, this.ay);
                    break;
                }
                break;
            case 4:
                if (i2 == -1 && intent != null) {
                    PaymentMethod paymentMethod = (PaymentMethod) intent.getParcelableExtra("selected_payment_method");
                    if (paymentMethod != null) {
                        this.ay.m15751a(Optional.of(paymentMethod));
                        break;
                    }
                }
                break;
            case 5:
                if (i2 == -1) {
                    String stringExtra = intent.getStringExtra("extra_shipping_option_id");
                    ImmutableList s = this.ay.m15767s();
                    int size = s.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        PaymentShippingOptionModel paymentShippingOptionModel = (PaymentShippingOptionModel) s.get(i3);
                        if (paymentShippingOptionModel.m13825b().equals(stringExtra)) {
                            this.ay.m15760c(Optional.of(paymentShippingOptionModel));
                            break;
                        }
                    }
                    break;
                }
                break;
            case 6:
                if (i2 == -1 && intent != null) {
                    this.ay.m15757b(intent.getStringExtra("cvv_code"));
                    aT(this);
                    break;
                }
                aS(this);
                break;
            case 21:
                if (i2 == -1) {
                    ConfirmationCommonParamsBuilder newBuilder = ConfirmationCommonParams.newBuilder();
                    newBuilder.f18596a = ConfirmationStyle.PAGES_COMMERCE;
                    newBuilder = newBuilder;
                    newBuilder.f18598c = this.s.getString("invoice_id");
                    newBuilder = newBuilder;
                    newBuilder.f18597b = false;
                    this.f15286h.a(ConfirmationActivity.m18613a(getContext(), newBuilder.m18623d()), getContext());
                    ao().setResult(-1);
                    aD(this);
                    break;
                }
                break;
            case 1000:
                this.f15285g.m13454a(i, i2, intent);
                break;
            case 1001:
                this.f15285g.m13454a(i, i2, intent);
                break;
        }
        this.ax.mo620a();
    }

    public final void m15648I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2120413101);
        super.I();
        this.ap.mo614a();
        if (this.aA != null) {
            this.aA.cancel(true);
            this.aA = null;
        }
        this.as.mo611a();
        this.aC.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -679585253, a);
    }

    public final void m15654e(Bundle bundle) {
        bundle.putParcelable("messenger_pay_data", this.ay);
        super.e(bundle);
    }

    public static void at(EnterPaymentValueFragment enterPaymentValueFragment) {
        enterPaymentValueFragment.ax.setMessengerPayViewParams(MessengerPayViewFactory.m15774a(enterPaymentValueFragment.az, enterPaymentValueFragment.ay));
        enterPaymentValueFragment.ax.mo621a(enterPaymentValueFragment.aw);
        enterPaymentValueFragment.au();
        PaymentSelectCardDialogFragment paymentSelectCardDialogFragment = (PaymentSelectCardDialogFragment) enterPaymentValueFragment.kO_().a("select_card_dialog");
        if (paymentSelectCardDialogFragment != null && paymentSelectCardDialogFragment.z()) {
            paymentSelectCardDialogFragment.a();
            aM(enterPaymentValueFragment);
        }
        PaymentSelectAddressDialogFragment paymentSelectAddressDialogFragment = (PaymentSelectAddressDialogFragment) enterPaymentValueFragment.kO_().a("select_address_dialog");
        if (paymentSelectAddressDialogFragment != null && paymentSelectAddressDialogFragment.z()) {
            paymentSelectAddressDialogFragment.a();
            aN(enterPaymentValueFragment);
        }
        PaymentSelectShippingOptionDialogFragment paymentSelectShippingOptionDialogFragment = (PaymentSelectShippingOptionDialogFragment) enterPaymentValueFragment.kO_().a("select_shipping_option_dialog");
        if (paymentSelectShippingOptionDialogFragment != null && paymentSelectShippingOptionDialogFragment.z()) {
            paymentSelectShippingOptionDialogFragment.a();
            aO(enterPaymentValueFragment);
        }
    }

    private void au() {
        switch (this.ay.f15445b) {
            case PREPARE_PAYMENT:
                if (this.ay.f15446c) {
                    aT(this);
                    return;
                }
                return;
            case CHECK_RECIPIENT_ELIGIBILITY:
                if (!this.ay.f15461r.isSet()) {
                    return;
                }
                if (this.ay.f15461r.asBoolean()) {
                    aU();
                    return;
                }
                PaymentsConfirmDialogFragment a = PaymentsConfirmDialogFragment.a(getContext().getString(2131240483), this.ao.mo609a(this.s, this.ay), getContext().getString(2131230726), getContext().getString(2131230747), true);
                a.am = this.aF;
                a.a(kO_(), "ineligible_recipient_dialog");
                aT(this);
                return;
            case PROCESSING_CHECK_RECIPIENT_ELIGIBILITY:
            case PROCESSING_CARD_VERIFY:
            case PROCESSING_CHECK_AMOUNT:
            case PROCESSING_CHECK_PIN:
            case PROCESSING_SEND_PAYMENT:
                return;
            case CARD_VERIFY:
                if (aW(this)) {
                    ax();
                    return;
                }
                if (!(this.ay.f15449f == null || this.ay.f15447d == null)) {
                    ResultCallback anonymousClass11 = new ResultCallback(this) {
                        final /* synthetic */ EnterPaymentValueFragment f15261a;

                        {
                            this.f15261a = r1;
                        }

                        public final void mo544a() {
                            this.f15261a.al.m15532a();
                            EnterPaymentValueFragment.aT(this.f15261a);
                        }

                        public final void mo545a(PaymentCard paymentCard, @Nullable VerificationFollowUpAction verificationFollowUpAction, boolean z, boolean z2) {
                            this.f15261a.ay.f15466w = z;
                            this.f15261a.ay.f15467x = z2;
                            this.f15261a.ay.m15756b(Optional.of(paymentCard));
                            EnterPaymentValueFragment.aT(this.f15261a);
                        }

                        public final void mo546b() {
                            EnterPaymentValueFragment.aS(this.f15261a);
                            if (!((Boolean) this.f15261a.f15283e.get()).booleanValue()) {
                                this.f15261a.as.mo612a(this.f15261a.s, this.f15261a.ay);
                            }
                        }

                        public final void mo547c() {
                            EnterPaymentValueFragment.aS(this.f15261a);
                        }
                    };
                    aT(this);
                    PaymentMethodVerificationParams.Builder newBuilder = PaymentMethodVerificationParams.newBuilder();
                    newBuilder.f13171a = (PaymentCard) this.ay.f15449f.orNull();
                    PaymentMethodVerificationParams.Builder builder = newBuilder;
                    builder.f13172b = this.ay.f15448e;
                    builder = builder;
                    builder.f13175e = this.ar.m15565a(this.az);
                    builder = builder;
                    builder.f13181k = aW(this);
                    builder = builder;
                    builder.f13173c = this;
                    builder = builder;
                    builder.f13174d = true;
                    this.f15285g.m13455a(builder.m13461a(), anonymousClass11);
                }
                return;
            case CHECK_AMOUNT:
                ay();
                return;
            case CHECK_PIN:
                az();
                return;
            case SEND_PAYMENT:
                aT(this);
                this.ap.mo615a(this.s, this.ay);
                return;
            default:
                throw new IllegalStateException("Invalid state found + " + this.ay.f15445b);
        }
    }

    public static void av(EnterPaymentValueFragment enterPaymentValueFragment) {
        enterPaymentValueFragment.ay.m15759b(true);
    }

    private void ax() {
        if (this.ay.f15450g != null) {
            if (this.az == MessengerPayType.PAGES_COMMERCE && this.ay.f15450g.isPresent() && PaymentMethodType.CREDIT_CARD.equals(((PaymentMethod) this.ay.f15450g.get()).b())) {
                CardFormAnalyticsParamsBuilder newBuilder = CardFormAnalyticsParams.newBuilder();
                newBuilder.b = this.ar.m15565a(this.az).analyticsModule;
                CardFormAnalyticsParams c = newBuilder.c();
                CardFormStyleParams.Builder newBuilder2 = CardFormStyleParams.newBuilder();
                newBuilder2.a = b(2131240609);
                newBuilder2 = newBuilder2;
                newBuilder2.b = b(2131240610);
                newBuilder2 = newBuilder2;
                newBuilder2.d = FormFieldProperty.HIDDEN;
                CardFormStyleParams e = newBuilder2.e();
                CardFormCommonParamsBuilder newBuilder3 = CardFormCommonParams.newBuilder();
                newBuilder3.a = CardFormStyle.MESSENGER_PAY_REQUIRE_CVV;
                newBuilder3 = newBuilder3;
                newBuilder3.b = c;
                newBuilder3 = newBuilder3;
                newBuilder3.d = (FbPaymentCard) this.ay.f15450g.get();
                CardFormCommonParamsBuilder cardFormCommonParamsBuilder = newBuilder3;
                cardFormCommonParamsBuilder.c = e;
                cardFormCommonParamsBuilder = cardFormCommonParamsBuilder;
                cardFormCommonParamsBuilder.e = PaymentItemType.PAGES_COMMERCE;
                cardFormCommonParamsBuilder = cardFormCommonParamsBuilder;
                MessengerPayCardFormParamsBuilder newBuilder4 = MessengerPayCardFormParams.newBuilder();
                newBuilder4.f13042f = cardFormCommonParamsBuilder.f();
                MessengerPayCardFormParamsBuilder messengerPayCardFormParamsBuilder = newBuilder4;
                messengerPayCardFormParamsBuilder.f13041e = true;
                Intent a = CardFormActivity.a(getContext(), messengerPayCardFormParamsBuilder.m13336j());
                aT(this);
                this.f15286h.a(a, 6, this);
                return;
            }
            aU();
        }
    }

    private void ay() {
        if (this.f15280b.m13204b(this.ay.f15462s.f15442a, this.ay.f15462s.f15443b) < 10000) {
            aU();
            return;
        }
        String a;
        if (this.ay.f15459p.b()) {
            a = this.ay.f15459p.a();
        } else {
            a = this.ay.f15459p.g();
        }
        PaymentsConfirmDialogFragment a2 = PaymentsConfirmDialogFragment.a(jW_().getString(2131240425), jW_().getString(2131240426, new Object[]{this.f15280b.m13199a(CurrencyFormatType.NO_EMPTY_DECIMALS, r1, this.ay.f15462s.f15443b), a}), jW_().getString(2131240427), null, false);
        a2.am = this.aE;
        a2.a(kO_(), "send_confirm_dialog");
        aT(this);
    }

    private void az() {
        if (this.ay.f15447d.m14261a().isPresent()) {
            aT(this);
            this.f15286h.a(PaymentPinConfirmActivity.m14132a(getContext()), 1, this);
            return;
        }
        aU();
    }

    public final void as() {
        if (D()) {
            View immediateFocusView = this.ax.getImmediateFocusView();
            Activity ao = ao();
            if (immediateFocusView == null) {
                ao.getWindow().setSoftInputMode(3);
            } else {
                this.f15282d.m16056a(ao, immediateFocusView);
            }
        }
    }

    public static void aD(EnterPaymentValueFragment enterPaymentValueFragment) {
        enterPaymentValueFragment.f15282d.m16055a(enterPaymentValueFragment.ao());
        enterPaymentValueFragment.ao().finish();
    }

    public static void aL(EnterPaymentValueFragment enterPaymentValueFragment) {
        enterPaymentValueFragment.f15286h.a(PickerScreenActivity.m18779a(enterPaymentValueFragment.getContext(), enterPaymentValueFragment.av.m15771a(enterPaymentValueFragment.az, enterPaymentValueFragment.s.getString("invoice_id"), enterPaymentValueFragment.ay.f15450g, enterPaymentValueFragment.ar.m15565a(enterPaymentValueFragment.az).analyticsModule)), 4, enterPaymentValueFragment);
    }

    public static void aM(EnterPaymentValueFragment enterPaymentValueFragment) {
        Collection collection = enterPaymentValueFragment.ay.f15448e;
        boolean aW = aW(enterPaymentValueFragment);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("payment_cards", new ArrayList(collection));
        bundle.putBoolean("credit_card_enabled", aW);
        PaymentSelectCardDialogFragment paymentSelectCardDialogFragment = new PaymentSelectCardDialogFragment();
        paymentSelectCardDialogFragment.g(bundle);
        PaymentSelectCardDialogFragment paymentSelectCardDialogFragment2 = paymentSelectCardDialogFragment;
        paymentSelectCardDialogFragment2.ao = enterPaymentValueFragment.aH;
        paymentSelectCardDialogFragment2.a(enterPaymentValueFragment.kO_(), "select_card_dialog");
    }

    public static void aN(EnterPaymentValueFragment enterPaymentValueFragment) {
        if (enterPaymentValueFragment.f15279a.a(1018, false)) {
            enterPaymentValueFragment.f15286h.a(PickerScreenActivity.m18779a(enterPaymentValueFragment.getContext(), enterPaymentValueFragment.av.m15772a(enterPaymentValueFragment.ay.f15453j, ((MailingAddress) enterPaymentValueFragment.ay.f15454k.get()).mo760a(), enterPaymentValueFragment.ar.m15565a(enterPaymentValueFragment.az).analyticsModule, aW(enterPaymentValueFragment), enterPaymentValueFragment.ay.f15468y)), 3, enterPaymentValueFragment);
            return;
        }
        Iterable iterable = enterPaymentValueFragment.ay.f15453j;
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("shipping_addresses", Lists.a(iterable));
        PaymentSelectAddressDialogFragment paymentSelectAddressDialogFragment = new PaymentSelectAddressDialogFragment();
        paymentSelectAddressDialogFragment.g(bundle);
        PaymentSelectAddressDialogFragment paymentSelectAddressDialogFragment2 = paymentSelectAddressDialogFragment;
        paymentSelectAddressDialogFragment2.an = enterPaymentValueFragment.aI;
        paymentSelectAddressDialogFragment2.a(enterPaymentValueFragment.kO_(), "select_address_dialog");
    }

    public static void aO(EnterPaymentValueFragment enterPaymentValueFragment) {
        if (enterPaymentValueFragment.f15279a.a(1019, false)) {
            String b;
            Context context = enterPaymentValueFragment.getContext();
            MessengerPayPickerScreenParamHelper messengerPayPickerScreenParamHelper = enterPaymentValueFragment.av;
            List s = enterPaymentValueFragment.ay.m15767s();
            if (enterPaymentValueFragment.ay.f15452i.isPresent()) {
                b = ((PaymentShippingOptionModel) enterPaymentValueFragment.ay.f15452i.get()).m13825b();
            } else {
                b = null;
            }
            String str = enterPaymentValueFragment.ar.m15565a(enterPaymentValueFragment.az).analyticsModule;
            boolean aW = aW(enterPaymentValueFragment);
            ImmutableList a = PaymentShippingOptionUtil.m15977a(s);
            ShippingOptionPickerScreenParamsBuilder newBuilder = ShippingOptionPickerScreenParams.newBuilder();
            newBuilder.f19030a = MessengerPayPickerScreenParamHelper.m15770a(PickerScreenStyle.MESSENGER_COMMERCE_SHIPPING_OPTION_PICKER, messengerPayPickerScreenParamHelper.f15469a.getString(2131240119), str, aW);
            newBuilder = newBuilder;
            newBuilder.f19032c = b;
            newBuilder = newBuilder;
            newBuilder.f19031b = a;
            enterPaymentValueFragment.f15286h.a(PickerScreenActivity.m18779a(context, (PickerScreenParams) newBuilder.m18994d()), 5, enterPaymentValueFragment);
            return;
        }
        ImmutableList s2 = enterPaymentValueFragment.ay.m15767s();
        Bundle bundle = new Bundle();
        FlatBufferModelHelper.a(bundle, "shipping_options", new ArrayList(s2));
        PaymentSelectShippingOptionDialogFragment paymentSelectShippingOptionDialogFragment = new PaymentSelectShippingOptionDialogFragment();
        paymentSelectShippingOptionDialogFragment.g(bundle);
        PaymentSelectShippingOptionDialogFragment paymentSelectShippingOptionDialogFragment2 = paymentSelectShippingOptionDialogFragment;
        paymentSelectShippingOptionDialogFragment2.an = enterPaymentValueFragment.aJ;
        paymentSelectShippingOptionDialogFragment2.a(enterPaymentValueFragment.kO_(), "select_shipping_option_dialog");
    }

    public static void aP(EnterPaymentValueFragment enterPaymentValueFragment) {
        ResultCallback anonymousClass15 = new ResultCallback(enterPaymentValueFragment) {
            final /* synthetic */ EnterPaymentValueFragment f15265a;

            {
                this.f15265a = r1;
            }

            public final void mo544a() {
                this.f15265a.f15281c.b("EnterPaymentValueFragment", "A card already verified event received when adding a new card");
            }

            public final void mo545a(PaymentCard paymentCard, @Nullable VerificationFollowUpAction verificationFollowUpAction, boolean z, boolean z2) {
                this.f15265a.ay.f15466w = z;
                this.f15265a.ay.f15467x = z2;
                this.f15265a.ay.m15756b(Optional.of(paymentCard));
                if (!((Boolean) this.f15265a.f15283e.get()).booleanValue()) {
                    this.f15265a.as.mo612a(this.f15265a.s, this.f15265a.ay);
                }
            }

            public final void mo546b() {
                if (!((Boolean) this.f15265a.f15283e.get()).booleanValue()) {
                    this.f15265a.as.mo612a(this.f15265a.s, this.f15265a.ay);
                }
            }

            public final void mo547c() {
                EnterPaymentValueFragment.aS(this.f15265a);
            }
        };
        PaymentMethodVerificationParams.Builder newBuilder = PaymentMethodVerificationParams.newBuilder();
        newBuilder.f13172b = enterPaymentValueFragment.ay.f15448e;
        newBuilder = newBuilder;
        newBuilder.f13175e = enterPaymentValueFragment.ar.m15565a(enterPaymentValueFragment.az);
        newBuilder = newBuilder;
        newBuilder.f13181k = aW(enterPaymentValueFragment);
        newBuilder = newBuilder;
        newBuilder.f13173c = enterPaymentValueFragment;
        enterPaymentValueFragment.f15285g.m13455a(newBuilder.m13461a(), anonymousClass15);
    }

    public static void aR(EnterPaymentValueFragment enterPaymentValueFragment) {
        ShippingCommonParamsBuilder newBuilder = ShippingCommonParams.newBuilder();
        newBuilder.f18994a = ShippingStyle.MESSENGER_COMMERCE;
        newBuilder = newBuilder;
        newBuilder.f18998e = ShippingSource.CHECKOUT;
        enterPaymentValueFragment.f15286h.a(ShippingAddressActivity.m18920a(enterPaymentValueFragment.getContext(), newBuilder.m18972h()), 2, enterPaymentValueFragment);
    }

    public static void m15642a(EnterPaymentValueFragment enterPaymentValueFragment, MailingAddress mailingAddress) {
        enterPaymentValueFragment.ay.m15762d(Optional.of(mailingAddress));
        enterPaymentValueFragment.ay.m15761c(null);
        enterPaymentValueFragment.ay.m15760c(null);
        String a = mailingAddress.mo760a();
        if (!m15645a(enterPaymentValueFragment.aA)) {
            enterPaymentValueFragment.aA.cancel(true);
        }
        final PaymentPlatformContextModel paymentPlatformContextModel = (PaymentPlatformContextModel) FlatBufferModelHelper.a(enterPaymentValueFragment.s, "payment_platform_context");
        enterPaymentValueFragment.aA = enterPaymentValueFragment.am.m14959a(paymentPlatformContextModel.m13756d(), a);
        Futures.a(enterPaymentValueFragment.aA, new ResultFutureCallback<PaymentPlatformContext>(enterPaymentValueFragment) {
            final /* synthetic */ EnterPaymentValueFragment f15267b;

            public final void m15616a(Object obj) {
                PaymentPlatformContextModel paymentPlatformContextModel = (PaymentPlatformContextModel) obj;
                this.f15267b.ay.m15761c(paymentPlatformContextModel.m13760l());
                this.f15267b.ay.m15760c(Optional.fromNullable(paymentPlatformContextModel.m13758j()));
                if (!paymentPlatformContextModel.lr_().m13674d().equals(((MailingAddress) this.f15267b.ay.f15454k.get()).mo760a())) {
                    this.f15267b.ay.m15762d(Optional.of(PaymentAddressUtil.m15513a(paymentPlatformContextModel.lr_())));
                    this.f15267b.f15281c.a("EnterPaymentValueFragment", "Server side selected address is inconsistent with client side selected address");
                }
                if (!paymentPlatformContextModel.m13756d().equals(paymentPlatformContextModel.m13756d())) {
                    this.f15267b.f15281c.b("EnterPaymentValueFragment", "Server side platContextformId is inconsistent");
                }
            }

            public final void m15615a(ServiceException serviceException) {
                this.f15267b.f15281c.a("EnterPaymentValueFragment", "Failed to set shipping address.");
                this.f15267b.aD.m15574a();
            }
        }, enterPaymentValueFragment.an);
    }

    public static void aS(EnterPaymentValueFragment enterPaymentValueFragment) {
        enterPaymentValueFragment.ay.m15759b(false);
        enterPaymentValueFragment.ay.m15747a(MessengerPayState.PREPARE_PAYMENT);
    }

    public static void aT(EnterPaymentValueFragment enterPaymentValueFragment) {
        enterPaymentValueFragment.ay.m15747a(enterPaymentValueFragment.ay.f15445b.next(enterPaymentValueFragment.az));
    }

    private void aU() {
        this.ay.m15747a(this.ay.f15445b.next(this.az).next(this.az));
    }

    public static boolean m15645a(ListenableFuture listenableFuture) {
        return listenableFuture == null || listenableFuture.isDone();
    }

    public static boolean aW(EnterPaymentValueFragment enterPaymentValueFragment) {
        switch (enterPaymentValueFragment.az) {
            case MP:
            case MC:
            case PAGES_COMMERCE:
                return true;
            default:
                return false;
        }
    }
}
