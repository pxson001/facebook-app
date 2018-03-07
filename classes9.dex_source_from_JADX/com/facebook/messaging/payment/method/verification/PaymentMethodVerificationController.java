package com.facebook.messaging.payment.method.verification;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.Intent;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.android.ActivityMethodAutoProvider;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbservice.ops.ResultFutureCallback;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.http.protocol.ApiErrorResult;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.analytics.P2pPaymentsLogEvent;
import com.facebook.messaging.payment.analytics.PaymentFlowType;
import com.facebook.messaging.payment.dialog.PaymentDialogsBuilder;
import com.facebook.messaging.payment.dialog.PaymentDialogsBuilder.MultiOptionsDialogListener;
import com.facebook.messaging.payment.method.input.MessengerPayCardFormParams;
import com.facebook.messaging.payment.method.input.MessengerPayCardFormParamsBuilder;
import com.facebook.messaging.payment.method.verification.PaymentMethodVerificationParams.LaunchMode;
import com.facebook.messaging.payment.model.PartialPaymentCard;
import com.facebook.messaging.payment.model.PaymentCard;
import com.facebook.messaging.payment.model.VerificationFollowUpAction;
import com.facebook.messaging.payment.pin.model.PaymentPin;
import com.facebook.messaging.payment.pin.protocol.PaymentPinProtocolUtil;
import com.facebook.messaging.payment.protocol.PaymentProtocolUtil;
import com.facebook.messaging.payment.util.PaymentFlowTypeUtil;
import com.facebook.messaging.payment.value.util.PaymentsSoftInputUtil;
import com.facebook.payments.model.FormFieldProperty;
import com.facebook.payments.paymentmethods.cardform.CardFormActivity;
import com.facebook.payments.paymentmethods.cardform.CardFormAnalyticsParams;
import com.facebook.payments.paymentmethods.cardform.CardFormAnalyticsParamsBuilder;
import com.facebook.payments.paymentmethods.cardform.CardFormCommonParams;
import com.facebook.payments.paymentmethods.cardform.CardFormCommonParamsBuilder;
import com.facebook.payments.paymentmethods.cardform.CardFormStyle;
import com.facebook.payments.paymentmethods.cardform.CardFormStyleParams;
import com.facebook.payments.paymentmethods.model.FbPaymentCardType;
import com.facebook.resources.ui.FbEditText;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: image_send_source */
public class PaymentMethodVerificationController {
    public final AbstractFbErrorReporter f13142a;
    private final PaymentPinProtocolUtil f13143b;
    public final PaymentProtocolUtil f13144c;
    public final Context f13145d;
    private final PaymentDialogsBuilder f13146e;
    private final LayoutInflater f13147f;
    public final AnalyticsLogger f13148g;
    public final PaymentsSoftInputUtil f13149h;
    public final Activity f13150i;
    public final Executor f13151j;
    private final SecureContextHelper f13152k;
    public PaymentMethodVerificationParams f13153l;
    public ResultCallback f13154m;
    public ListenableFuture<List<Object>> f13155n;
    public ListenableFuture<ImmutableList<PaymentCard>> f13156o;
    public ListenableFuture<String> f13157p;

    /* compiled from: image_send_source */
    public class AnonymousClass11 implements OnClickListener {
        final /* synthetic */ PaymentCard f13118a;
        final /* synthetic */ PaymentMethodVerificationController f13119b;

        public AnonymousClass11(PaymentMethodVerificationController paymentMethodVerificationController, PaymentCard paymentCard) {
            this.f13119b = paymentMethodVerificationController;
            this.f13118a = paymentCard;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            PaymentMethodVerificationController.m13452c(this.f13119b, this.f13118a);
        }
    }

    /* compiled from: image_send_source */
    public class C14642 implements OnCancelListener {
        final /* synthetic */ PaymentMethodVerificationController f13126a;

        public C14642(PaymentMethodVerificationController paymentMethodVerificationController) {
            this.f13126a = paymentMethodVerificationController;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f13126a.f13148g.a(P2pPaymentsLogEvent.c(this.f13126a.f13153l.f13186e.analyticsModule, "p2p_cancel_select_card"));
            this.f13126a.f13154m.mo547c();
        }
    }

    /* compiled from: image_send_source */
    class C14653 implements OnClickListener {
        final /* synthetic */ PaymentMethodVerificationController f13127a;

        C14653(PaymentMethodVerificationController paymentMethodVerificationController) {
            this.f13127a = paymentMethodVerificationController;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f13127a.f13148g.a(P2pPaymentsLogEvent.c(this.f13127a.f13153l.f13186e.analyticsModule, "p2p_cancel_csc"));
            dialogInterface.dismiss();
            this.f13127a.f13154m.mo547c();
        }
    }

    /* compiled from: image_send_source */
    class C14686 implements OnCancelListener {
        final /* synthetic */ PaymentMethodVerificationController f13133a;

        C14686(PaymentMethodVerificationController paymentMethodVerificationController) {
            this.f13133a = paymentMethodVerificationController;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f13133a.f13154m.mo547c();
        }
    }

    /* compiled from: image_send_source */
    class C14707 implements OnDismissListener {
        final /* synthetic */ PaymentMethodVerificationController f13135a;

        /* compiled from: image_send_source */
        class C14691 implements Runnable {
            final /* synthetic */ C14707 f13134a;

            C14691(C14707 c14707) {
                this.f13134a = c14707;
            }

            public void run() {
                if (this.f13134a.f13135a.f13150i != null) {
                    this.f13134a.f13135a.f13149h.m16055a(this.f13134a.f13135a.f13150i);
                }
            }
        }

        C14707(PaymentMethodVerificationController paymentMethodVerificationController) {
            this.f13135a = paymentMethodVerificationController;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            HandlerDetour.b(new Handler(), new C14691(this), 100, -38402284);
        }
    }

    /* compiled from: image_send_source */
    public interface ResultCallback {
        void mo544a();

        void mo545a(PaymentCard paymentCard, @Nullable VerificationFollowUpAction verificationFollowUpAction, boolean z, boolean z2);

        void mo546b();

        void mo547c();
    }

    public static PaymentMethodVerificationController m13449b(InjectorLike injectorLike) {
        return new PaymentMethodVerificationController((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), PaymentPinProtocolUtil.m14279a(injectorLike), PaymentProtocolUtil.m14937a(injectorLike), (Context) injectorLike.getInstance(Context.class), PaymentDialogsBuilder.m13301a(injectorLike), LayoutInflaterMethodAutoProvider.b(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), PaymentsSoftInputUtil.m16054b(injectorLike), ActivityMethodAutoProvider.b(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    public static PaymentMethodVerificationController m13443a(InjectorLike injectorLike) {
        return m13449b(injectorLike);
    }

    @Inject
    public PaymentMethodVerificationController(AbstractFbErrorReporter abstractFbErrorReporter, PaymentPinProtocolUtil paymentPinProtocolUtil, PaymentProtocolUtil paymentProtocolUtil, Context context, PaymentDialogsBuilder paymentDialogsBuilder, LayoutInflater layoutInflater, AnalyticsLogger analyticsLogger, PaymentsSoftInputUtil paymentsSoftInputUtil, Activity activity, Executor executor, SecureContextHelper secureContextHelper) {
        this.f13142a = abstractFbErrorReporter;
        this.f13143b = paymentPinProtocolUtil;
        this.f13144c = paymentProtocolUtil;
        this.f13145d = context;
        this.f13146e = paymentDialogsBuilder;
        this.f13147f = layoutInflater;
        this.f13148g = analyticsLogger;
        this.f13149h = paymentsSoftInputUtil;
        this.f13150i = activity;
        this.f13151j = executor;
        this.f13152k = secureContextHelper;
    }

    public final void m13454a(int i, int i2, @Nullable Intent intent) {
        if (this.f13154m != null) {
            switch (i) {
                case 1000:
                    m13444a(i2, intent, "partial_payment_card");
                    return;
                case 1001:
                    m13444a(i2, intent, "partial_payment_card");
                    return;
                default:
                    return;
            }
        }
    }

    private void m13444a(int i, @Nullable Intent intent, String str) {
        if (i == -1 && intent != null) {
            m13447a(this, (PartialPaymentCard) intent.getParcelableExtra(str), (VerificationFollowUpAction) intent.getParcelableExtra("verification_follow_up_action"));
        } else if (i == 0) {
            this.f13154m.mo547c();
        }
    }

    public final void m13455a(PaymentMethodVerificationParams paymentMethodVerificationParams, ResultCallback resultCallback) {
        boolean z;
        this.f13153l = paymentMethodVerificationParams;
        this.f13154m = resultCallback;
        ImmutableList immutableList = this.f13153l.f13183b;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            if (((PaymentCard) immutableList.get(i)).f13208g) {
                z = false;
                break;
            }
        }
        z = true;
        Builder builder = new Builder();
        builder.c(this.f13143b.m14283a());
        builder.c(Futures.a(Boolean.valueOf(z)));
        this.f13155n = Futures.a(builder.b());
        if (this.f13153l.f13189h == LaunchMode.NEW) {
            m13451c(this);
        } else {
            m13448a(this.f13153l.f13182a);
        }
    }

    private void m13448a(@Nullable PaymentCard paymentCard) {
        if (paymentCard == null) {
            ImmutableList immutableList = this.f13153l.f13183b;
            Builder builder = new Builder();
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                PaymentCard paymentCard2 = (PaymentCard) immutableList.get(i);
                if (!paymentCard2.m13513t()) {
                    builder.c(paymentCard2);
                }
            }
            immutableList = builder.b();
            immutableList = this.f13153l.f13192k ? PaymentCardsFetcher.m13432c(immutableList) : PaymentCardsFetcher.m13433d(immutableList);
            if (immutableList.isEmpty()) {
                m13451c(this);
                return;
            }
            AlertDialog a;
            this.f13148g.a(P2pPaymentsLogEvent.c(this.f13153l.f13186e.analyticsModule, "p2p_initiate_select_card"));
            MultiOptionsDialogListener c14631 = new MultiOptionsDialogListener(this) {
                final /* synthetic */ PaymentMethodVerificationController f13125b;

                public final void mo520a() {
                    PaymentMethodVerificationController.m13451c(this.f13125b);
                }

                public final void mo521a(int i) {
                    PaymentMethodVerificationController.m13450b(this.f13125b, (PaymentCard) immutableList.get(i));
                }
            };
            if (this.f13153l.f13192k) {
                a = PaymentDialogsBuilder.m13297a(this.f13145d, PaymentDialogsBuilder.m13302a(this.f13145d, immutableList), this.f13145d.getString(2131240393), this.f13145d.getString(2131240397), this.f13145d.getString(2131240415), c14631);
            } else {
                a = PaymentDialogsBuilder.m13297a(this.f13145d, PaymentDialogsBuilder.m13302a(this.f13145d, immutableList), this.f13145d.getString(2131240392), this.f13145d.getString(2131240413), this.f13145d.getString(2131240414), c14631);
            }
            a.setOnCancelListener(new C14642(this));
            return;
        }
        Preconditions.checkArgument(paymentCard.m13513t());
        m13450b(this, paymentCard);
    }

    public static void m13450b(PaymentMethodVerificationController paymentMethodVerificationController, PaymentCard paymentCard) {
        if (paymentCard.m13508j() || !paymentCard.f13210i) {
            paymentMethodVerificationController.m13453d(paymentCard);
        } else if (paymentCard.f13208g) {
            paymentMethodVerificationController.f13154m.mo544a();
        } else {
            m13452c(paymentMethodVerificationController, paymentCard);
        }
    }

    public static void m13452c(PaymentMethodVerificationController paymentMethodVerificationController, final PaymentCard paymentCard) {
        int i;
        paymentMethodVerificationController.f13148g.a(P2pPaymentsLogEvent.c(paymentMethodVerificationController.f13153l.f13186e.analyticsModule, "p2p_initiate_csc"));
        Context context = paymentMethodVerificationController.f13145d;
        if (FbPaymentCardType.AMEX == FbPaymentCardType.forValue(paymentCard.f13207f)) {
            i = 2131240420;
        } else {
            i = 2131240419;
        }
        CharSequence string = context.getString(i, new Object[]{paymentCard.f13207f, paymentCard.m13503e()});
        View inflate = paymentMethodVerificationController.f13147f.inflate(2130903829, null);
        ((FbTextView) inflate.findViewById(2131560862)).setText(string);
        final FbEditText fbEditText = (FbEditText) inflate.findViewById(2131560863);
        final AlertDialog a = new FbAlertDialogBuilder(paymentMethodVerificationController.f13145d).a(2131240418).b(inflate).a(2131230726, new OnClickListener(paymentMethodVerificationController) {
            final /* synthetic */ PaymentMethodVerificationController f13130c;

            public void onClick(DialogInterface dialogInterface, int i) {
                PaymentMethodVerificationController.m13446a(this.f13130c, paymentCard, dialogInterface, fbEditText);
            }
        }).b(2131230727, new C14653(paymentMethodVerificationController)).a();
        a.setOnShowListener(new OnShowListener(paymentMethodVerificationController) {
            final /* synthetic */ PaymentMethodVerificationController f13132b;

            public void onShow(DialogInterface dialogInterface) {
                if (this.f13132b.f13150i != null) {
                    this.f13132b.f13149h.m16056a(this.f13132b.f13150i, fbEditText);
                }
            }
        });
        a.setOnCancelListener(new C14686(paymentMethodVerificationController));
        a.setOnDismissListener(new C14707(paymentMethodVerificationController));
        a.setCanceledOnTouchOutside(false);
        a.show();
        fbEditText.setOnEditorActionListener(new OnEditorActionListener(paymentMethodVerificationController) {
            final /* synthetic */ PaymentMethodVerificationController f13139d;

            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6) {
                    PaymentMethodVerificationController.m13446a(this.f13139d, paymentCard, a, fbEditText);
                }
                return false;
            }
        });
    }

    public static void m13446a(PaymentMethodVerificationController paymentMethodVerificationController, final PaymentCard paymentCard, DialogInterface dialogInterface, FbEditText fbEditText) {
        String obj = fbEditText.getText().toString();
        dialogInterface.dismiss();
        if (paymentMethodVerificationController.f13157p == null || paymentMethodVerificationController.f13157p.isDone()) {
            paymentMethodVerificationController.f13148g.a(P2pPaymentsLogEvent.c(paymentMethodVerificationController.f13153l.f13186e.analyticsModule, "p2p_confirm_csc"));
            paymentMethodVerificationController.f13157p = paymentMethodVerificationController.f13144c.m14945a(paymentMethodVerificationController.f13145d, String.valueOf(paymentCard.f13202a), paymentCard.f13204c, paymentCard.f13205d, obj, paymentMethodVerificationController.f13145d.getString(2131240421));
            Futures.a(paymentMethodVerificationController.f13157p, new ResultFutureCallback<String>(paymentMethodVerificationController) {
                final /* synthetic */ PaymentMethodVerificationController f13141b;

                protected final void m13438a(Object obj) {
                    this.f13141b.f13148g.a(P2pPaymentsLogEvent.c(this.f13141b.f13153l.f13186e.analyticsModule, "p2p_csc_success"));
                    PaymentMethodVerificationController.m13447a(this.f13141b, new PartialPaymentCard(paymentCard.f13202a, paymentCard.m13503e(), paymentCard.f13204c, paymentCard.f13205d, paymentCard.f13206e, paymentCard.f13207f, true, paymentCard.f13210i), null);
                }

                protected final void m13437a(ServiceException serviceException) {
                    this.f13141b.f13148g.a(P2pPaymentsLogEvent.c(this.f13141b.f13153l.f13186e.analyticsModule, "p2p_csc_fail"));
                    PaymentMethodVerificationController paymentMethodVerificationController = this.f13141b;
                    PaymentCard paymentCard = paymentCard;
                    if (serviceException.errorCode == ErrorCode.API_ERROR) {
                        ApiErrorResult apiErrorResult = (ApiErrorResult) serviceException.result.h();
                        switch (apiErrorResult.a()) {
                            case 10054:
                                AlertDialog a = PaymentDialogsBuilder.m13300a(paymentMethodVerificationController.f13145d, paymentMethodVerificationController.f13145d.getString(2131240287), ApiErrorResult.a(apiErrorResult.c()), paymentMethodVerificationController.f13145d.getString(2131230767), new AnonymousClass11(paymentMethodVerificationController, paymentCard), paymentMethodVerificationController.f13145d.getString(2131230727), new OnClickListener(paymentMethodVerificationController) {
                                    final /* synthetic */ PaymentMethodVerificationController f13120a;

                                    {
                                        this.f13120a = r1;
                                    }

                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.dismiss();
                                        this.f13120a.f13154m.mo547c();
                                    }
                                });
                                a.setOnCancelListener(new OnCancelListener(paymentMethodVerificationController) {
                                    final /* synthetic */ PaymentMethodVerificationController f13121a;

                                    {
                                        this.f13121a = r1;
                                    }

                                    public void onCancel(DialogInterface dialogInterface) {
                                        this.f13121a.f13154m.mo547c();
                                    }
                                });
                                a.show();
                                return;
                            case 10059:
                                paymentMethodVerificationController.f13154m.mo546b();
                                PaymentDialogsBuilder.m13299a(paymentMethodVerificationController.f13145d, paymentMethodVerificationController.f13145d.getString(2131240296), ApiErrorResult.a(apiErrorResult.c()), paymentMethodVerificationController.f13145d.getString(2131230726), new OnClickListener(paymentMethodVerificationController) {
                                    final /* synthetic */ PaymentMethodVerificationController f13122a;

                                    {
                                        this.f13122a = r1;
                                    }

                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.dismiss();
                                    }
                                }).show();
                                return;
                            default:
                                paymentMethodVerificationController.f13154m.mo546b();
                                PaymentDialogsBuilder.m13299a(paymentMethodVerificationController.f13145d, paymentMethodVerificationController.f13145d.getString(2131240287), ApiErrorResult.a(apiErrorResult.c()), paymentMethodVerificationController.f13145d.getString(2131230726), new OnClickListener(paymentMethodVerificationController) {
                                    final /* synthetic */ PaymentMethodVerificationController f13123a;

                                    {
                                        this.f13123a = r1;
                                    }

                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.dismiss();
                                    }
                                }).show();
                                return;
                        }
                    }
                }
            }, paymentMethodVerificationController.f13151j);
        }
    }

    public static void m13447a(PaymentMethodVerificationController paymentMethodVerificationController, @Nullable final PaymentCard paymentCard, final VerificationFollowUpAction verificationFollowUpAction) {
        Futures.a(paymentMethodVerificationController.f13155n, new FutureCallback<List<Object>>(paymentMethodVerificationController) {
            final /* synthetic */ PaymentMethodVerificationController f13117c;

            public void onSuccess(Object obj) {
                List list = (List) obj;
                boolean z = false;
                Preconditions.checkArgument(list.size() == 2);
                if (!((PaymentPin) list.get(0)).m14261a().isPresent()) {
                    z = true;
                }
                this.f13117c.f13154m.mo545a(paymentCard, verificationFollowUpAction, z, ((Boolean) list.get(1)).booleanValue());
            }

            public void onFailure(Throwable th) {
                this.f13117c.f13142a.a(this.f13117c.getClass().getName(), "Failed to fetch email and PaymentPin for the user.");
            }
        }, paymentMethodVerificationController.f13151j);
    }

    public static void m13451c(PaymentMethodVerificationController paymentMethodVerificationController) {
        String string = paymentMethodVerificationController.f13145d.getString(paymentMethodVerificationController.f13153l.f13192k ? 2131238330 : 2131240258);
        CardFormAnalyticsParamsBuilder newBuilder = CardFormAnalyticsParams.newBuilder();
        newBuilder.a = "p2p";
        newBuilder = newBuilder;
        newBuilder.b = paymentMethodVerificationController.f13153l.f13186e.analyticsModule;
        CardFormAnalyticsParams c = newBuilder.c();
        CardFormStyleParams.Builder newBuilder2 = CardFormStyleParams.newBuilder();
        newBuilder2.a = string;
        CardFormStyleParams.Builder builder = newBuilder2;
        builder.d = FormFieldProperty.REQUIRED;
        builder = builder;
        if (paymentMethodVerificationController.f13153l.f13185d) {
            builder.b = paymentMethodVerificationController.f13145d.getString(2131240274);
        }
        CardFormCommonParamsBuilder newBuilder3 = CardFormCommonParams.newBuilder();
        newBuilder3.a = CardFormStyle.MESSENGER_PAY_ADD;
        newBuilder3 = newBuilder3;
        newBuilder3.b = c;
        CardFormCommonParamsBuilder cardFormCommonParamsBuilder = newBuilder3;
        cardFormCommonParamsBuilder.e = PaymentFlowTypeUtil.m15515a(paymentMethodVerificationController.f13153l.f13192k);
        cardFormCommonParamsBuilder = cardFormCommonParamsBuilder;
        cardFormCommonParamsBuilder.c = builder.e();
        CardFormCommonParamsBuilder cardFormCommonParamsBuilder2 = cardFormCommonParamsBuilder;
        MessengerPayCardFormParamsBuilder newBuilder4 = MessengerPayCardFormParams.newBuilder();
        newBuilder4.f13042f = cardFormCommonParamsBuilder2.f();
        MessengerPayCardFormParamsBuilder messengerPayCardFormParamsBuilder = newBuilder4;
        messengerPayCardFormParamsBuilder.f13037a = paymentMethodVerificationController.f13153l.f13187f;
        messengerPayCardFormParamsBuilder = messengerPayCardFormParamsBuilder;
        messengerPayCardFormParamsBuilder.f13039c = paymentMethodVerificationController.f13153l.f13190i;
        messengerPayCardFormParamsBuilder = messengerPayCardFormParamsBuilder;
        messengerPayCardFormParamsBuilder.f13040d = paymentMethodVerificationController.f13153l.f13191j;
        messengerPayCardFormParamsBuilder = messengerPayCardFormParamsBuilder;
        messengerPayCardFormParamsBuilder.f13041e = paymentMethodVerificationController.f13153l.f13192k;
        messengerPayCardFormParamsBuilder = messengerPayCardFormParamsBuilder;
        messengerPayCardFormParamsBuilder.f13038b = paymentMethodVerificationController.f13153l.f13188g;
        Intent a = CardFormActivity.a(paymentMethodVerificationController.f13145d, messengerPayCardFormParamsBuilder.m13336j());
        paymentMethodVerificationController.f13148g.a(P2pPaymentsLogEvent.c(paymentMethodVerificationController.f13153l.f13186e.analyticsModule, "p2p_initiate_add_card"));
        paymentMethodVerificationController.m13445a(a, 1000);
    }

    private void m13453d(PaymentCard paymentCard) {
        boolean z;
        this.f13148g.a(P2pPaymentsLogEvent.c(this.f13153l.f13186e.analyticsModule, "p2p_initiate_edit_card"));
        CardFormAnalyticsParamsBuilder newBuilder = CardFormAnalyticsParams.newBuilder();
        newBuilder.a = "p2p";
        newBuilder = newBuilder;
        newBuilder.b = this.f13153l.f13186e.analyticsModule;
        CardFormAnalyticsParams c = newBuilder.c();
        CardFormCommonParamsBuilder newBuilder2 = CardFormCommonParams.newBuilder();
        newBuilder2.a = CardFormStyle.MESSENGER_PAY_EDIT;
        newBuilder2 = newBuilder2;
        newBuilder2.d = paymentCard;
        newBuilder2 = newBuilder2;
        newBuilder2.e = PaymentFlowTypeUtil.m15515a(this.f13153l.f13192k);
        newBuilder2 = newBuilder2;
        newBuilder2.b = c;
        CardFormCommonParamsBuilder cardFormCommonParamsBuilder = newBuilder2;
        MessengerPayCardFormParamsBuilder newBuilder3 = MessengerPayCardFormParams.newBuilder();
        newBuilder3.f13042f = cardFormCommonParamsBuilder.f();
        newBuilder3 = newBuilder3;
        if (PaymentFlowType.SETTINGS.equals(this.f13153l.f13186e)) {
            z = false;
        } else {
            z = true;
        }
        newBuilder3.f13044h = z;
        m13445a(CardFormActivity.a(this.f13145d, newBuilder3.m13336j()), 1001);
    }

    private void m13445a(Intent intent, int i) {
        if (this.f13153l.f13184c == null) {
            this.f13152k.a(intent, i, this.f13150i);
        } else {
            this.f13152k.a(intent, i, this.f13153l.f13184c);
        }
    }
}
