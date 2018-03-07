package com.facebook.facecast.plugin.tipjar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.facecast.plugin.FacecastEndScreenBasePlugin;
import com.facebook.facecastdisplay.FacecastUtil;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.payments.model.PaymentItemType;
import com.facebook.payments.paymentmethods.cardform.CardFormActivity;
import com.facebook.payments.paymentmethods.cardform.CardFormAnalyticsParams;
import com.facebook.payments.paymentmethods.cardform.CardFormAnalyticsParamsBuilder;
import com.facebook.payments.paymentmethods.cardform.CardFormCommonParams;
import com.facebook.payments.paymentmethods.cardform.CardFormCommonParamsBuilder;
import com.facebook.payments.paymentmethods.cardform.CardFormStyle;
import com.facebook.payments.paymentmethods.cardform.CardFormStyleParams;
import com.facebook.payments.paymentmethods.cardform.CardFormStyleParams.Builder;
import com.facebook.resources.ui.FbButton;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.SwitchCompat;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: base_system_version */
public class FacecastTipJarEndScreenPlugin extends FacecastEndScreenBasePlugin {
    @Inject
    public FacecastUtil f18739g;
    @Inject
    public SecureContextHelper f18740h;
    private final SwitchCompat f18741i;
    private final ViewGroup f18742j;
    private final ViewGroup f18743k;
    private final FbTextView f18744l;
    private final FbTextView f18745m;
    private final FbButton f18746n;
    private final FbTextView f18747o;
    private final boolean f18748p;
    private final String f18749q;
    private final String f18750r;
    private final String f18751s;
    private final int f18752t;
    private final String f18753u;

    /* compiled from: base_system_version */
    class C16201 implements OnClickListener {
        final /* synthetic */ FacecastTipJarEndScreenPlugin f18738a;

        C16201(FacecastTipJarEndScreenPlugin facecastTipJarEndScreenPlugin) {
            this.f18738a = facecastTipJarEndScreenPlugin;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1648744439);
            FacecastTipJarEndScreenPlugin facecastTipJarEndScreenPlugin = this.f18738a;
            CardFormCommonParamsBuilder newBuilder = CardFormCommonParams.newBuilder();
            newBuilder.a = CardFormStyle.SIMPLE;
            newBuilder = newBuilder;
            Builder newBuilder2 = CardFormStyleParams.newBuilder();
            newBuilder2.a = facecastTipJarEndScreenPlugin.getResources().getString(2131238288);
            newBuilder.c = newBuilder2.e();
            newBuilder = newBuilder;
            newBuilder.e = PaymentItemType.P2P_TRANSFER;
            newBuilder = newBuilder;
            CardFormAnalyticsParamsBuilder newBuilder3 = CardFormAnalyticsParams.newBuilder();
            newBuilder3.a = "tip_jar";
            newBuilder3 = newBuilder3;
            newBuilder3.b = "TIPJAR";
            newBuilder.b = newBuilder3.c();
            facecastTipJarEndScreenPlugin.f18740h.a(CardFormActivity.a(facecastTipJarEndScreenPlugin.getContext(), newBuilder.f()), facecastTipJarEndScreenPlugin.getContext());
            Logger.a(2, EntryType.UI_INPUT_END, -739453410, a);
        }
    }

    public static void m22291a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        FacecastTipJarEndScreenPlugin facecastTipJarEndScreenPlugin = (FacecastTipJarEndScreenPlugin) obj;
        FacecastUtil b = FacecastUtil.m3107b(fbInjector);
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector);
        facecastTipJarEndScreenPlugin.f18739g = b;
        facecastTipJarEndScreenPlugin.f18740h = secureContextHelper;
    }

    public FacecastTipJarEndScreenPlugin(Context context) {
        this(context, null);
    }

    private FacecastTipJarEndScreenPlugin(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @SuppressLint({"ConstructorMayLeakThis"})
    private FacecastTipJarEndScreenPlugin(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f18748p = false;
        this.f18749q = "Visa Debit 1111";
        this.f18750r = "tip_jar";
        this.f18751s = "TIPJAR";
        this.f18752t = 2;
        this.f18753u = "$2";
        Class cls = FacecastTipJarEndScreenPlugin.class;
        m22291a(this, getContext());
        LayoutInflater from = LayoutInflater.from(context);
        ViewGroup viewGroup = (ViewGroup) findViewById(2131561645);
        View inflate = from.inflate(2130904209, viewGroup, false);
        this.f18747o = (FbTextView) findViewById(2131561648);
        viewGroup.addView(inflate, viewGroup.indexOfChild(this.f18747o) + 1);
        viewGroup = (ViewGroup) findViewById(2131561652);
        from.inflate(2130904210, viewGroup);
        from.inflate(2130904208, viewGroup);
        this.f18742j = (ViewGroup) findViewById(2131561661);
        this.f18743k = (ViewGroup) findViewById(2131561656);
        this.f18744l = (FbTextView) findViewById(2131561657);
        this.f18745m = (FbTextView) findViewById(2131561658);
        this.f18741i = (SwitchCompat) findViewById(2131561663);
        this.f18741i.setChecked(false);
        this.f18746n = (FbButton) findViewById(2131561660);
        this.f18746n.setOnClickListener(new C16201(this));
        if (this.f18739g.m3123x()) {
            this.f18742j.setVisibility(0);
        } else {
            this.f18742j.setVisibility(8);
        }
        this.f18743k.setVisibility(8);
        this.f18746n.setVisibility(0);
    }

    public final void mo1440a(long j, long j2, String str, String str2, ComposerTargetData composerTargetData, int i) {
        super.mo1440a(j, j2, str, str2, composerTargetData, i);
        this.f18747o.setText(getResources().getString(2131238290, new Object[]{Integer.valueOf(2), "$2"}));
    }

    public final void mo1441h() {
        super.mo1441h();
        if (this.f18741i != null && this.f18741i.isChecked()) {
            m22034i();
        }
    }

    protected final void mo1417g() {
        super.mo1417g();
        this.f18742j.setVisibility(8);
        this.f18746n.setVisibility(8);
        this.f18743k.setVisibility(8);
    }
}
