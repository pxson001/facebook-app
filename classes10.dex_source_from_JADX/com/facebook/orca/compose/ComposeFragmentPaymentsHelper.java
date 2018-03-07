package com.facebook.orca.compose;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.util.ContextUtils;
import com.facebook.contacts.picker.UserComparatorByName;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.dialog.MenuDialogFragment;
import com.facebook.messaging.dialog.MenuDialogItem;
import com.facebook.messaging.dialog.MenuDialogItemBuilder;
import com.facebook.messaging.dialog.MenuDialogParamsBuilder;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.payment.SentPayment;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKey.Type;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.payment.analytics.P2pPaymentsLogEvent;
import com.facebook.messaging.payment.analytics.P2pPaymentsLogEvent.Builder;
import com.facebook.messaging.payment.analytics.PaymentFlowType;
import com.facebook.messaging.payment.method.verification.PaymentMethodVerificationNuxDialogsHelper;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentPlatformContextModel;
import com.facebook.messaging.payment.value.input.EnterPaymentValueActivity;
import com.facebook.messaging.payment.value.input.MessengerPayType;
import com.facebook.messaging.payment.value.input.OrionMessengerPayParams;
import com.facebook.messaging.payment.value.input.OrionMessengerPayParamsBuilder;
import com.facebook.messaging.send.client.OutgoingMessageFactory;
import com.facebook.payments.dialog.PaymentsConfirmDialogFragment;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.user.cache.UserCache;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: origIndex */
public class ComposeFragmentPaymentsHelper {
    private static final String f5406a = ComposeFragmentPaymentsHelper.class.getName();
    private final Context f5407b;
    private final DataCache f5408c;
    private final OutgoingMessageFactory f5409d;
    private final SecureContextHelper f5410e;
    private final Lazy<NavigationLogger> f5411f;
    private final AbstractFbErrorReporter f5412g;
    private final Provider<User> f5413h;
    public final Lazy<AnalyticsLogger> f5414i;
    private final Lazy<PaymentMethodVerificationNuxDialogsHelper> f5415j;
    private final UserCache f5416k;
    private final com.facebook.messaging.dialog.MenuDialogFragment.Listener f5417l = new C07621(this);
    private final UserComparatorByName f5418m = new UserComparatorByName();
    public Listener f5419n;
    public ThreadKey f5420o;
    public Fragment f5421p;
    public PaymentFlowType f5422q;
    private String f5423r;

    /* compiled from: origIndex */
    interface Listener {
        void mo144a(Message message);

        void mo145a(OrionMessengerPayParams orionMessengerPayParams);
    }

    /* compiled from: origIndex */
    class C07621 implements com.facebook.messaging.dialog.MenuDialogFragment.Listener {
        final /* synthetic */ ComposeFragmentPaymentsHelper f5403a;

        public final boolean m4986a(MenuDialogItem menuDialogItem, Object obj) {
            UserKey userKey = (UserKey) menuDialogItem.e;
            ((AnalyticsLogger) this.f5403a.f5414i.get()).a(P2pPaymentsLogEvent.d("p2p_group_send_recipient_picked", this.f5403a.f5422q.analyticsModule).o(userKey.b()).a(this.f5403a.f5420o).a);
            this.f5403a.m4991a(userKey, menuDialogItem.c.toString(), null, String.valueOf(this.f5403a.f5420o.b));
            return true;
        }

        C07621(ComposeFragmentPaymentsHelper composeFragmentPaymentsHelper) {
            this.f5403a = composeFragmentPaymentsHelper;
        }
    }

    /* compiled from: origIndex */
    class C07632 implements OnClickListener {
        final /* synthetic */ ComposeFragmentPaymentsHelper f5404a;

        C07632(ComposeFragmentPaymentsHelper composeFragmentPaymentsHelper) {
            this.f5404a = composeFragmentPaymentsHelper;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: origIndex */
    class C07643 implements OnClickListener {
        final /* synthetic */ ComposeFragmentPaymentsHelper f5405a;

        C07643(ComposeFragmentPaymentsHelper composeFragmentPaymentsHelper) {
            this.f5405a = composeFragmentPaymentsHelper;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    private static ComposeFragmentPaymentsHelper m4995b(InjectorLike injectorLike) {
        return new ComposeFragmentPaymentsHelper((Context) injectorLike.getInstance(Context.class), DataCache.a(injectorLike), OutgoingMessageFactory.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 137), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), IdBasedProvider.a(injectorLike, 3596), IdBasedSingletonScopeProvider.b(injectorLike, 175), IdBasedLazy.a(injectorLike, 8062), UserCache.a(injectorLike));
    }

    public static ComposeFragmentPaymentsHelper m4987a(InjectorLike injectorLike) {
        return m4995b(injectorLike);
    }

    @Inject
    public ComposeFragmentPaymentsHelper(Context context, DataCache dataCache, OutgoingMessageFactory outgoingMessageFactory, SecureContextHelper secureContextHelper, Lazy<NavigationLogger> lazy, FbErrorReporter fbErrorReporter, Provider<User> provider, Lazy<AnalyticsLogger> lazy2, Lazy<PaymentMethodVerificationNuxDialogsHelper> lazy3, UserCache userCache) {
        this.f5407b = context;
        this.f5408c = dataCache;
        this.f5409d = outgoingMessageFactory;
        this.f5410e = secureContextHelper;
        this.f5411f = lazy;
        this.f5412g = fbErrorReporter;
        this.f5413h = provider;
        this.f5414i = lazy2;
        this.f5415j = lazy3;
        this.f5416k = userCache;
    }

    public final void m5005a(Listener listener) {
        this.f5419n = listener;
    }

    public final void m5004a(ThreadKey threadKey) {
        this.f5420o = threadKey;
    }

    public final void m5003a(Fragment fragment) {
        this.f5421p = fragment;
    }

    public final void m5002a(Bundle bundle) {
        if (bundle != null) {
            this.f5422q = (PaymentFlowType) bundle.getSerializable("payment_flow_type");
            this.f5423r = bundle.getString("default_payment_amount");
        }
    }

    public final void m5009b(Bundle bundle) {
        bundle.putSerializable("payment_flow_type", this.f5422q);
        bundle.putString("default_payment_amount", this.f5423r);
    }

    public final void m5010b(Fragment fragment) {
        MenuDialogFragment menuDialogFragment = (MenuDialogFragment) fragment.s().a("PAYMENT_RECIPIENT_PICKER");
        if (menuDialogFragment != null) {
            menuDialogFragment.an = this.f5417l;
        }
    }

    public final void m5006a(ComposerInitParams composerInitParams) {
        if (composerInitParams.f5428d != null) {
            this.f5410e.a(EnterPaymentValueActivity.a(this.f5407b, composerInitParams.f5428d), 10000, this.f5421p);
        }
    }

    public final void m5001a(@Nullable Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("recipient_id");
            SentPayment sentPayment = (SentPayment) intent.getParcelableExtra("sent_payment");
            ThreadKey threadKey = (ThreadKey) intent.getParcelableExtra("thread_key");
            if (stringExtra != null && Objects.equal(this.f5420o, threadKey)) {
                boolean z;
                boolean booleanExtra = intent.getBooleanExtra("show_pin_nux", false);
                boolean booleanExtra2 = intent.getBooleanExtra("show_card_added_nux", false);
                if (threadKey == null || threadKey.a != Type.GROUP) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    z = false;
                } else {
                    z = true;
                }
                m4989a(sentPayment, z, stringExtra);
                ((PaymentMethodVerificationNuxDialogsHelper) this.f5415j.get()).b(booleanExtra, booleanExtra2);
            }
        }
    }

    public final void m5008a(String str, boolean z, int i, PaymentFlowType paymentFlowType, @Nullable String str2, @Nullable PaymentPlatformContextModel paymentPlatformContextModel, @Nullable String str3) {
        if (i > 1) {
            m4996b();
            return;
        }
        this.f5422q = paymentFlowType;
        this.f5423r = str;
        if (this.f5420o == null || this.f5420o.a != Type.GROUP) {
            ((NavigationLogger) this.f5411f.get()).a("tap_composer_list_item");
            m4992a(z, str2, paymentPlatformContextModel, str3);
            return;
        }
        m4988a();
    }

    public final void m5007a(String str, @Nullable PaymentPlatformContextModel paymentPlatformContextModel, String str2) {
        UserKey b = UserKey.b(String.valueOf(this.f5420o.d));
        if (((User) this.f5413h.get()).a.equals(b.b())) {
            m4998c();
            return;
        }
        String str3;
        OrionMessengerPayParamsBuilder newBuilder = OrionMessengerPayParams.newBuilder();
        newBuilder.a = b;
        newBuilder = newBuilder;
        newBuilder.b = str2;
        newBuilder = newBuilder;
        newBuilder.c = this.f5420o;
        newBuilder = newBuilder;
        newBuilder.d = str;
        newBuilder = newBuilder;
        newBuilder.f = paymentPlatformContextModel;
        OrionMessengerPayParamsBuilder orionMessengerPayParamsBuilder = newBuilder;
        if (paymentPlatformContextModel == null) {
            str3 = null;
        } else {
            str3 = paymentPlatformContextModel.g().g();
        }
        orionMessengerPayParamsBuilder.e = str3;
        OrionMessengerPayParams h = orionMessengerPayParamsBuilder.h();
        Context context = this.f5407b;
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(h.a);
        Intent intent = new Intent(context, EnterPaymentValueActivity.class);
        intent.putExtra("messenger_pay_type", MessengerPayType.GROUP_COMMERCE_REQUEST);
        intent.putExtra("orion_messenger_pay_params", h);
        this.f5410e.a(intent, this.f5407b);
    }

    private void m4988a() {
        ((AnalyticsLogger) this.f5414i.get()).a(P2pPaymentsLogEvent.d("p2p_group_send_initiate", this.f5422q.analyticsModule).o(String.valueOf(this.f5420o.b)).a(this.f5420o).a);
        MenuDialogParamsBuilder menuDialogParamsBuilder = new MenuDialogParamsBuilder();
        menuDialogParamsBuilder.a = 2131240408;
        ThreadSummary a = this.f5408c.a(this.f5420o);
        if (a == null) {
            this.f5412g.b(f5406a, "ThreadSummary found to be null in DataCache during group payment sends");
        } else if (this.f5413h.get() == null) {
            this.f5412g.b(f5406a, "null ViewerContextUser found when opening recipient picker dialog from group thread");
        } else {
            User a2;
            List<User> a3 = Lists.a(a.h.size());
            ImmutableList immutableList = a.h;
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                UserKey b = ((ThreadParticipant) immutableList.get(i)).b();
                if (!((User) this.f5413h.get()).a.equals(b.b())) {
                    a2 = this.f5416k.a(b);
                    if (a2 != null) {
                        a3.add(a2);
                    }
                }
            }
            if (a3.isEmpty()) {
                PaymentsConfirmDialogFragment.a(this.f5407b.getString(2131240409), this.f5407b.getString(2131240410), this.f5407b.getString(2131230726), null, true).a(this.f5421p.s(), "PAYMENT_GROUP_EMPTY_DIALOG");
                return;
            }
            Collections.sort(a3, this.f5418m);
            for (User a22 : a3) {
                MenuDialogItemBuilder menuDialogItemBuilder = new MenuDialogItemBuilder();
                menuDialogItemBuilder.c = a22.k();
                menuDialogItemBuilder = menuDialogItemBuilder;
                menuDialogItemBuilder.e = a22.T;
                menuDialogParamsBuilder.a(menuDialogItemBuilder.f());
            }
            MenuDialogFragment a4 = MenuDialogFragment.a(menuDialogParamsBuilder.e());
            a4.an = this.f5417l;
            a4.a(this.f5421p.s(), "PAYMENT_RECIPIENT_PICKER");
            ((AnalyticsLogger) this.f5414i.get()).a(P2pPaymentsLogEvent.d("p2p_group_send_display_picker_dialog", this.f5422q.analyticsModule).o(String.valueOf(this.f5420o.b)).a(this.f5420o).a);
        }
    }

    private void m4992a(boolean z, @Nullable String str, @Nullable PaymentPlatformContextModel paymentPlatformContextModel, @Nullable String str2) {
        if (!z) {
            str = String.valueOf(this.f5420o.d);
        }
        UserKey b = UserKey.b(str);
        ((AnalyticsLogger) this.f5414i.get()).a(P2pPaymentsLogEvent.d("p2p_initiate_send", this.f5422q.analyticsModule).o(b.b()).a(this.f5420o).a);
        m4991a(b, str2, paymentPlatformContextModel, null);
    }

    private void m4991a(UserKey userKey, @Nullable String str, @Nullable PaymentPlatformContextModel paymentPlatformContextModel, @Nullable String str2) {
        if (this.f5413h.get() == null) {
            this.f5412g.b(f5406a, "null ViewerContextUser found opening send payment screen");
        } else if (((User) this.f5413h.get()).a.equals(userKey.b())) {
            m4998c();
        } else {
            OrionMessengerPayParamsBuilder newBuilder = OrionMessengerPayParams.newBuilder();
            newBuilder.a = userKey;
            newBuilder = newBuilder;
            newBuilder.b = str;
            newBuilder = newBuilder;
            newBuilder.c = this.f5420o;
            newBuilder = newBuilder;
            newBuilder.d = this.f5423r;
            newBuilder = newBuilder;
            newBuilder.f = paymentPlatformContextModel;
            newBuilder = newBuilder;
            newBuilder.g = str2;
            OrionMessengerPayParams h = newBuilder.h();
            if (((Activity) ContextUtils.a(this.f5407b, Activity.class)) != null) {
                this.f5410e.a(EnterPaymentValueActivity.a(this.f5407b, h), 10000, this.f5421p);
                return;
            }
            this.f5419n.mo145a(h);
        }
    }

    private void m4989a(SentPayment sentPayment, boolean z, String str) {
        if (this.f5413h.get() == null) {
            this.f5412g.b(f5406a, "null ViewerContextUser found when sending payment message from group thread");
            return;
        }
        ThreadKey a;
        if (z) {
            a = ThreadKey.a(Long.parseLong(str), Long.parseLong(((User) this.f5413h.get()).a));
        } else {
            a = ThreadKey.a(Long.parseLong(sentPayment.j));
        }
        Message a2 = this.f5409d.a(a, sentPayment);
        AnalyticsLogger analyticsLogger = (AnalyticsLogger) this.f5414i.get();
        Builder a3 = P2pPaymentsLogEvent.d(z ? "p2p_confirm_send" : "p2p_group_send_confirm_send", sentPayment.i.analyticsModule).o(str).a(a2.u.c.a);
        a3.a.b("currency", a2.u.c.b);
        a3 = a3;
        a3.a.a("people_count", 1);
        analyticsLogger.a(a3.c(a2.n).a(a2.u.c.g).a);
        this.f5419n.mo144a(a2);
    }

    private void m4996b() {
        new FbAlertDialogBuilder(this.f5407b).a(2131238318).b(2131240481).c(2131230726, new C07632(this)).b();
    }

    private void m4998c() {
        new FbAlertDialogBuilder(this.f5407b).a(2131238318).b(2131240482).c(2131230726, new C07643(this)).b();
    }

    public static boolean m5000d(ComposeFragmentPaymentsHelper composeFragmentPaymentsHelper) {
        return composeFragmentPaymentsHelper.f5422q == PaymentFlowType.SEND && !composeFragmentPaymentsHelper.f5423r.equals("");
    }
}
