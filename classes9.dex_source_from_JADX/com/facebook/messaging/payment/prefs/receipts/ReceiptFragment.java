package com.facebook.messaging.payment.prefs.receipts;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.LocalBroadcast;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.payment.cache.PaymentRequestCache;
import com.facebook.messaging.payment.model.PaymentTransaction;
import com.facebook.messaging.payment.model.PaymentTransactionBuilder;
import com.facebook.messaging.payment.model.TransferStatus;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentRequestModel;
import com.facebook.messaging.payment.util.PaymentRequestUtil;
import com.facebook.messaging.payment.util.PaymentTransactionUtil;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: graphql_type_unsupported */
public class ReceiptFragment extends FbFragment {
    @Inject
    @LocalBroadcast
    public LocalFbBroadcastManager f14013a;
    @Inject
    public PaymentRequestUtil f14014b;
    @Inject
    public PaymentTransactionUtil f14015c;
    @Inject
    public PaymentRequestCache f14016d;
    public ReceiptView f14017e;
    public Object f14018f;
    public SelfRegistrableReceiverImpl f14019g;

    /* compiled from: graphql_type_unsupported */
    public class C15931 implements ActionReceiver {
        final /* synthetic */ ReceiptFragment f14011a;

        public C15931(ReceiptFragment receiptFragment) {
            this.f14011a = receiptFragment;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -152627856);
            Object stringExtra = intent.getStringExtra("extra_payment_request_id");
            if ((this.f14011a.f14018f instanceof PaymentRequestModel) && !StringUtil.a(stringExtra) && ((PaymentRequestModel) this.f14011a.f14018f).lw_().equals(stringExtra)) {
                this.f14011a.f14018f = this.f14011a.f14016d.a(stringExtra);
                this.f14011a.f14017e.mo553a(this.f14011a.f14018f, this.f14011a);
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -883280197, a);
        }
    }

    /* compiled from: graphql_type_unsupported */
    public class C15942 implements ActionReceiver {
        final /* synthetic */ ReceiptFragment f14012a;

        public C15942(ReceiptFragment receiptFragment) {
            this.f14012a = receiptFragment;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 172957950);
            String valueOf = String.valueOf(intent.getLongExtra("extra_transfer_id", 0));
            if ((this.f14012a.f14018f instanceof PaymentTransaction) && ((PaymentTransaction) this.f14012a.f14018f).f13229b.equals(valueOf)) {
                TransferStatus transferStatus = (TransferStatus) intent.getSerializableExtra("extra_transfer_status");
                ReceiptFragment receiptFragment = this.f14012a;
                PaymentTransactionBuilder a2 = PaymentTransactionBuilder.m13533a((PaymentTransaction) this.f14012a.f14018f);
                a2.f13248f = transferStatus;
                receiptFragment.f14018f = a2.m13534o();
                this.f14012a.f14017e.mo553a(this.f14012a.f14018f, this.f14012a);
                LogUtils.e(1356259056, a);
                return;
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1057039212, a);
        }
    }

    public static void m14514a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ReceiptFragment receiptFragment = (ReceiptFragment) obj;
        LocalFbBroadcastManager a = LocalFbBroadcastManager.a(injectorLike);
        PaymentRequestUtil a2 = PaymentRequestUtil.a(injectorLike);
        PaymentTransactionUtil a3 = PaymentTransactionUtil.m15519a(injectorLike);
        PaymentRequestCache a4 = PaymentRequestCache.a(injectorLike);
        receiptFragment.f14013a = a;
        receiptFragment.f14014b = a2;
        receiptFragment.f14015c = a3;
        receiptFragment.f14016d = a4;
    }

    public final void m14520c(Bundle bundle) {
        super.c(bundle);
        Class cls = ReceiptFragment.class;
        m14514a((Object) this, getContext());
    }

    public final View m14517a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -264747263);
        if (bundle == null || FlatBufferModelHelper.a(bundle, "messenger_pay_entity") == null) {
            this.f14018f = FlatBufferModelHelper.a(this.s, "messenger_pay_entity");
        } else {
            this.f14018f = FlatBufferModelHelper.a(bundle, "messenger_pay_entity");
        }
        boolean z = (this.f14018f instanceof PaymentTransaction) || (this.f14018f instanceof PaymentRequestModel);
        Preconditions.checkArgument(z);
        View inflate = layoutInflater.inflate(2130906736, viewGroup, false);
        View b = FindViewUtil.b(inflate, 2131566819);
        ViewGroup viewGroup2 = (ViewGroup) b.getParent();
        int indexOfChild = viewGroup2.indexOfChild(b);
        Object obj;
        if (this.f14018f instanceof PaymentRequestModel) {
            PaymentRequestUtil paymentRequestUtil = this.f14014b;
            PaymentRequestModel paymentRequestModel = (PaymentRequestModel) this.f14018f;
            obj = null;
            if (!(paymentRequestUtil.b.get() == null || paymentRequestUtil.d(paymentRequestModel) || paymentRequestUtil.e(paymentRequestModel))) {
                obj = 1;
            }
            i = obj != null ? 2130905938 : 2130905937;
        } else if (((PaymentTransaction) this.f14018f).f13241n != null) {
            i = 2130905302;
        } else {
            PaymentTransactionUtil paymentTransactionUtil = this.f14015c;
            PaymentTransaction paymentTransaction = (PaymentTransaction) this.f14018f;
            obj = (paymentTransactionUtil.m15527c(paymentTransaction) || paymentTransactionUtil.m15528d(paymentTransaction)) ? null : 1;
            i = obj != null ? 2130905940 : 2130905931;
        }
        View inflate2 = layoutInflater.inflate(i, viewGroup2, false);
        inflate2.setLayoutParams(b.getLayoutParams());
        viewGroup2.removeViewInLayout(b);
        viewGroup2.addView(inflate2, indexOfChild);
        this.f14017e = (ReceiptView) inflate2;
        LogUtils.f(940809412, a);
        return inflate;
    }

    public final void m14518a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        this.f14017e.mo552a(i, i2, intent);
    }

    public final void m14515G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1986242408);
        super.G();
        this.f14019g.b();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 489920077, a);
    }

    public final void m14521e(Bundle bundle) {
        FlatBufferModelHelper.a(bundle, "messenger_pay_entity", this.f14018f);
        super.e(bundle);
    }

    public final void m14516I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 413855803);
        super.I();
        this.f14017e.mo551a();
        this.f14019g.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1346201386, a);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        contextMenu.clear();
    }

    public final void m14519a(View view, Bundle bundle) {
        C15931 c15931 = new C15931(this);
        this.f14019g = this.f14013a.a().a("com.facebook.messaging.payment.ACTION_PAYMENT_REQUEST_CACHE_UPDATED", c15931).a("com.facebook.messaging.payment.ACTION_PAYMENT_TRANSACTION_CACHE_UPDATED", new C15942(this)).a();
        this.f14017e.mo554b(this.f14018f, this);
    }
}
