package com.facebook.messaging.payment.prefs.receipts;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.enums.GraphQLMessengerPayThemeAssetTypeEnum;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.material.MessengerMaterialThemeUtil;
import com.facebook.messaging.payment.currency.CurrencyFormatType;
import com.facebook.messaging.payment.currency.PaymentCurrencyUtil;
import com.facebook.messaging.payment.model.Amount;
import com.facebook.messaging.payment.model.MessengerPayEntityType;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.ThemeAssetModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.ThemeModel;
import com.facebook.messaging.payment.prefs.receipts.PaymentReceiptActivity.AnalyticsSource;
import com.facebook.messaging.payment.ui.DollarIconEditText;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: gql_threads_null */
public class ThemeFullScreenCardActivity extends FbFragmentActivity {
    public static final CallerContext f14022r = CallerContext.a(ThemeFullScreenCardActivity.class);
    @Inject
    public PaymentCurrencyUtil f14023p;
    @Inject
    public SecureContextHelper f14024q;
    public FbDraweeView f14025s;
    public DollarIconEditText f14026t;
    public FbDraweeView f14027u;
    private FbTextView f14028v;
    public ThemeModel f14029w;
    public MessengerPayEntityType f14030x;

    /* compiled from: gql_threads_null */
    class C15951 implements OnClickListener {
        final /* synthetic */ ThemeFullScreenCardActivity f14020a;

        C15951(ThemeFullScreenCardActivity themeFullScreenCardActivity) {
            this.f14020a = themeFullScreenCardActivity;
        }

        public void onClick(View view) {
            Intent a;
            int a2 = Logger.a(2, EntryType.UI_INPUT_START, -920643460);
            switch (this.f14020a.f14030x) {
                case PAYMENT_TRANSACTION:
                    a = PaymentReceiptActivity.m14499a(this.f14020a, String.valueOf(this.f14020a.getIntent().getLongExtra("messenger_pay_entity_id", 0)), AnalyticsSource.THREAD);
                    break;
                case PAYMENT_REQUEST:
                    a = PaymentReceiptActivity.m14503b(this.f14020a, String.valueOf(this.f14020a.getIntent().getLongExtra("messenger_pay_entity_id", 0)), AnalyticsSource.THREAD);
                    break;
                default:
                    RuntimeException runtimeException = new RuntimeException("Unsupported MessengerPayEntityType: " + this.f14020a.f14030x);
                    LogUtils.a(481237291, a2);
                    throw runtimeException;
            }
            this.f14020a.f14024q.a(a, this.f14020a);
            LogUtils.a(1252675429, a2);
        }
    }

    public static void m14523a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ThemeFullScreenCardActivity themeFullScreenCardActivity = (ThemeFullScreenCardActivity) obj;
        PaymentCurrencyUtil a = PaymentCurrencyUtil.m13192a(injectorLike);
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike);
        themeFullScreenCardActivity.f14023p = a;
        themeFullScreenCardActivity.f14024q = secureContextHelper;
    }

    public static Intent m14522a(Context context, long j, MessengerPayEntityType messengerPayEntityType, ThemeModel themeModel, Amount amount) {
        Intent intent = new Intent(context, ThemeFullScreenCardActivity.class);
        intent.putExtra("messenger_pay_entity_id", j);
        intent.putExtra("messenger_pay_entity_type", messengerPayEntityType);
        FlatBufferModelHelper.a(intent, "messenger_pay_theme", themeModel);
        intent.putExtra("messenger_pay_amount", amount);
        return intent;
    }

    protected final void m14524a(Bundle bundle) {
        MessengerMaterialThemeUtil.a(this, 2131625175);
        Class cls = ThemeFullScreenCardActivity.class;
        m14523a(this, this);
    }

    protected final void m14525b(Bundle bundle) {
        ImmutableList a;
        int size;
        int i;
        ThemeAssetModel themeAssetModel;
        super.b(bundle);
        this.f14029w = (ThemeModel) FlatBufferModelHelper.a(getIntent(), "messenger_pay_theme");
        this.f14030x = (MessengerPayEntityType) getIntent().getSerializableExtra("messenger_pay_entity_type");
        setContentView(2130907383);
        this.f14025s = (FbDraweeView) a(2131567839);
        if (this.f14029w != null) {
            a = this.f14029w.m13940b().m13932a();
            size = a.size();
            for (i = 0; i < size; i++) {
                themeAssetModel = (ThemeAssetModel) a.get(i);
                if (GraphQLMessengerPayThemeAssetTypeEnum.FULLSCREEN_TOP.equals(themeAssetModel.m13923a())) {
                    this.f14025s.a(Uri.parse(themeAssetModel.m13926c().m13918a()), f14022r);
                    break;
                }
            }
        }
        this.f14026t = (DollarIconEditText) a(2131567841);
        Amount amount = (Amount) getIntent().getParcelableExtra("messenger_pay_amount");
        String a2 = this.f14023p.m13199a(CurrencyFormatType.NO_CURRENCY_SYMBOL_OR_EMPTY_DECIMALS, amount.m13469d(), amount.m13467b());
        this.f14026t.m15481a();
        this.f14026t.m15482a(amount.m13467b(), a2);
        this.f14027u = (FbDraweeView) a(2131567840);
        if (this.f14029w != null) {
            a = this.f14029w.m13940b().m13932a();
            size = a.size();
            for (i = 0; i < size; i++) {
                themeAssetModel = (ThemeAssetModel) a.get(i);
                if (GraphQLMessengerPayThemeAssetTypeEnum.FULLSCREEN_BOTTOM.equals(themeAssetModel.m13923a())) {
                    this.f14027u.a(Uri.parse(themeAssetModel.m13926c().m13918a()), f14022r);
                    break;
                }
            }
        }
        this.f14028v = (FbTextView) a(2131567842);
        this.f14028v.setOnClickListener(new C15951(this));
    }
}
