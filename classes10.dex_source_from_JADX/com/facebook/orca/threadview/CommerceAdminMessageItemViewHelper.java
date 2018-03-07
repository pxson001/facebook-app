package com.facebook.orca.threadview;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.dialog.ProgressDialog;
import com.facebook.http.protocol.ApiException;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.blocking.ManageBlockingParam;
import com.facebook.messaging.business.commerceui.analytics.MessengerCommerceAnalyticsLogger;
import com.facebook.messaging.business.commerceui.analytics.MessengerCommerceAnalyticsLogger.CommerceNetworkRequestTypes;
import com.facebook.messaging.business.commerceui.protocol.CommerceUnlinkHandler;
import com.facebook.messaging.business.commerceui.protocol.CommerceUnlinkHandler.1;
import com.facebook.messaging.business.commerceui.protocol.CommerceUnlinkMethod;
import com.facebook.messaging.business.promotion.gating.BusinessPromotionGatekeepers;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageType;
import com.facebook.orca.threadview.AdminMessageItemView.C10192;
import com.facebook.ui.dialogs.DialogWindowUtils;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: move */
public class CommerceAdminMessageItemViewHelper {
    public final CommerceUnlinkHandler f6879a;
    public final ExecutorService f6880b;
    public final Context f6881c;
    public final MessengerCommerceAnalyticsLogger f6882d;
    public final MonotonicClock f6883e;
    public C10192 f6884f;
    public BusinessPromotionGatekeepers f6885g;
    public ProgressDialog f6886h;
    public ListenableFuture<Void> f6887i;
    public AlertDialog f6888j;

    /* compiled from: move */
    public class C10292 implements OnClickListener {
        final /* synthetic */ CommerceAdminMessageItemViewHelper f6872a;

        public C10292(CommerceAdminMessageItemViewHelper commerceAdminMessageItemViewHelper) {
            this.f6872a = commerceAdminMessageItemViewHelper;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            this.f6872a.f6888j = null;
        }
    }

    /* compiled from: move */
    public class C10303 implements OnClickListener {
        final /* synthetic */ Message f6873a;
        final /* synthetic */ CommerceAdminMessageItemViewHelper f6874b;

        public C10303(CommerceAdminMessageItemViewHelper commerceAdminMessageItemViewHelper, Message message) {
            this.f6874b = commerceAdminMessageItemViewHelper;
            this.f6873a = message;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            CommerceAdminMessageItemViewHelper commerceAdminMessageItemViewHelper = this.f6874b;
            String b = this.f6873a.e.b.b();
            commerceAdminMessageItemViewHelper.f6882d.c(b);
            if (commerceAdminMessageItemViewHelper.f6887i == null) {
                long now = commerceAdminMessageItemViewHelper.f6883e.now();
                CommerceUnlinkHandler commerceUnlinkHandler = commerceAdminMessageItemViewHelper.f6879a;
                commerceAdminMessageItemViewHelper.f6887i = commerceUnlinkHandler.c.a(new 1(commerceUnlinkHandler, b));
                Futures.a(commerceAdminMessageItemViewHelper.f6887i, new C10314(commerceAdminMessageItemViewHelper, now), commerceAdminMessageItemViewHelper.f6880b);
                if (commerceAdminMessageItemViewHelper.f6886h == null || !commerceAdminMessageItemViewHelper.f6886h.isShowing()) {
                    commerceAdminMessageItemViewHelper.f6886h = new ProgressDialog(commerceAdminMessageItemViewHelper.f6881c);
                    commerceAdminMessageItemViewHelper.f6886h.a(true);
                    commerceAdminMessageItemViewHelper.f6886h.setCancelable(true);
                    DialogWindowUtils.a(commerceAdminMessageItemViewHelper.f6886h);
                    commerceAdminMessageItemViewHelper.f6886h.show();
                    commerceAdminMessageItemViewHelper.f6886h.setContentView(2130906491);
                }
            }
            dialogInterface.dismiss();
            this.f6874b.f6888j = null;
        }
    }

    /* compiled from: move */
    public class C10314 implements FutureCallback<Void> {
        final /* synthetic */ long f6875a;
        final /* synthetic */ CommerceAdminMessageItemViewHelper f6876b;

        public C10314(CommerceAdminMessageItemViewHelper commerceAdminMessageItemViewHelper, long j) {
            this.f6876b = commerceAdminMessageItemViewHelper;
            this.f6875a = j;
        }

        public void onSuccess(Object obj) {
            this.f6876b.f6887i = null;
            CommerceAdminMessageItemViewHelper.m6517d(this.f6876b);
            this.f6876b.f6882d.a(CommerceNetworkRequestTypes.UNLINK_BUSINESS, true, this.f6876b.f6883e.now() - this.f6875a, null);
        }

        public void onFailure(Throwable th) {
            String str = null;
            this.f6876b.f6887i = null;
            CommerceAdminMessageItemViewHelper.m6517d(this.f6876b);
            if ((th instanceof ApiException) && ((ApiException) th).b().a() == 10) {
                CommerceAdminMessageItemViewHelper commerceAdminMessageItemViewHelper = this.f6876b;
                commerceAdminMessageItemViewHelper.f6888j = new FbAlertDialogBuilder(commerceAdminMessageItemViewHelper.f6881c).a(2131231790).b(commerceAdminMessageItemViewHelper.f6881c.getResources().getString(2131231791)).a(2131230726, new C10325(commerceAdminMessageItemViewHelper)).b();
            } else {
                CommerceAdminMessageItemViewHelper.m6516c(this.f6876b);
            }
            MessengerCommerceAnalyticsLogger messengerCommerceAnalyticsLogger = this.f6876b.f6882d;
            CommerceNetworkRequestTypes commerceNetworkRequestTypes = CommerceNetworkRequestTypes.UNLINK_BUSINESS;
            long now = this.f6876b.f6883e.now() - this.f6875a;
            if (th != null) {
                str = th.getMessage();
            }
            messengerCommerceAnalyticsLogger.a(commerceNetworkRequestTypes, false, now, str);
        }
    }

    /* compiled from: move */
    public class C10325 implements OnClickListener {
        final /* synthetic */ CommerceAdminMessageItemViewHelper f6877a;

        public C10325(CommerceAdminMessageItemViewHelper commerceAdminMessageItemViewHelper) {
            this.f6877a = commerceAdminMessageItemViewHelper;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            this.f6877a.f6888j = null;
        }
    }

    /* compiled from: move */
    class C10336 implements OnClickListener {
        final /* synthetic */ CommerceAdminMessageItemViewHelper f6878a;

        C10336(CommerceAdminMessageItemViewHelper commerceAdminMessageItemViewHelper) {
            this.f6878a = commerceAdminMessageItemViewHelper;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            this.f6878a.f6888j = null;
        }
    }

    public static CommerceAdminMessageItemViewHelper m6515a(InjectorLike injectorLike) {
        return new CommerceAdminMessageItemViewHelper((Context) injectorLike.getInstance(Context.class), new CommerceUnlinkHandler(ApiMethodRunnerImpl.a(injectorLike), CommerceUnlinkMethod.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike)), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), MessengerCommerceAnalyticsLogger.b(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), BusinessPromotionGatekeepers.b(injectorLike));
    }

    @Inject
    public CommerceAdminMessageItemViewHelper(Context context, CommerceUnlinkHandler commerceUnlinkHandler, ExecutorService executorService, MessengerCommerceAnalyticsLogger messengerCommerceAnalyticsLogger, MonotonicClock monotonicClock, BusinessPromotionGatekeepers businessPromotionGatekeepers) {
        this.f6881c = context;
        this.f6879a = commerceUnlinkHandler;
        this.f6880b = executorService;
        this.f6882d = messengerCommerceAnalyticsLogger;
        this.f6883e = monotonicClock;
        this.f6885g = businessPromotionGatekeepers;
    }

    public final void m6518a(final Message message, TextView textView) {
        if (message.l != MessageType.COMMERCE_UNLINK || this.f6885g.a()) {
            SpannableString spannableString = new SpannableString(message.f + " ");
            Spannable spannableString2 = new SpannableString(this.f6885g.a() ? this.f6881c.getResources().getString(2131231789) : this.f6881c.getResources().getString(2131231788));
            spannableString2.setSpan(new ClickableSpan(this) {
                final /* synthetic */ CommerceAdminMessageItemViewHelper f6871b;

                public void onClick(View view) {
                    if (this.f6871b.f6884f == null) {
                        return;
                    }
                    if (this.f6871b.f6885g.a()) {
                        C10192 c10192 = this.f6871b.f6884f;
                        if (c10192.f6794a.f6808H != null) {
                            c10192.f6794a.f6808H.m6764a(ManageBlockingParam.c);
                            return;
                        }
                        return;
                    }
                    CommerceAdminMessageItemViewHelper commerceAdminMessageItemViewHelper = this.f6871b;
                    Message message = message;
                    String str = message.e == null ? null : message.e.c;
                    commerceAdminMessageItemViewHelper.f6888j = new FbAlertDialogBuilder(commerceAdminMessageItemViewHelper.f6881c).a(2131231786).b(commerceAdminMessageItemViewHelper.f6881c.getResources().getString(2131231787, new Object[]{str})).a(2131231788, new C10303(commerceAdminMessageItemViewHelper, message)).b(2131230727, new C10292(commerceAdminMessageItemViewHelper)).b();
                }
            }, 0, spannableString2.length(), 33);
            spannableString2.setSpan(new ForegroundColorSpan(textView.getCurrentTextColor()), 0, spannableString2.length(), 18);
            textView.setText(TextUtils.concat(new CharSequence[]{spannableString, spannableString2}));
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            return;
        }
        textView.setText(message.f);
    }

    public static void m6516c(CommerceAdminMessageItemViewHelper commerceAdminMessageItemViewHelper) {
        commerceAdminMessageItemViewHelper.f6888j = new FbAlertDialogBuilder(commerceAdminMessageItemViewHelper.f6881c).a(2131231792).b(commerceAdminMessageItemViewHelper.f6881c.getResources().getString(2131240701)).a(2131230726, new C10336(commerceAdminMessageItemViewHelper)).b();
    }

    public static void m6517d(CommerceAdminMessageItemViewHelper commerceAdminMessageItemViewHelper) {
        if (commerceAdminMessageItemViewHelper.f6886h != null) {
            commerceAdminMessageItemViewHelper.f6886h.cancel();
            commerceAdminMessageItemViewHelper.f6886h = null;
        }
    }
}
