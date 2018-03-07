package com.facebook.facecast.plugin.tipjar;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
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
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.facebook.widget.SwitchCompat;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: bar_message */
public class FacecastTipJarSettingDialog extends FbDialogFragment {
    @Inject
    public SecureContextHelper am;
    private final String an = "tip_jar";
    private final String ao = "TIPJAR";
    public Dialog ap;
    private ViewGroup aq;
    private SwitchCompat ar;
    public ViewGroup as;
    public FbTextView at;

    /* compiled from: bar_message */
    class C16211 implements OnCheckedChangeListener {
        final /* synthetic */ FacecastTipJarSettingDialog f18754a;

        C16211(FacecastTipJarSettingDialog facecastTipJarSettingDialog) {
            this.f18754a = facecastTipJarSettingDialog;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                this.f18754a.as.setVisibility(0);
                this.f18754a.at.setText(this.f18754a.jW_().getString(2131238309));
                return;
            }
            this.f18754a.as.setVisibility(8);
            this.f18754a.at.setText(this.f18754a.jW_().getString(2131238306));
        }
    }

    /* compiled from: bar_message */
    class C16222 implements OnClickListener {
        final /* synthetic */ FacecastTipJarSettingDialog f18755a;

        C16222(FacecastTipJarSettingDialog facecastTipJarSettingDialog) {
            this.f18755a = facecastTipJarSettingDialog;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 962351922);
            FacecastTipJarSettingDialog facecastTipJarSettingDialog = this.f18755a;
            CardFormCommonParamsBuilder newBuilder = CardFormCommonParams.newBuilder();
            newBuilder.a = CardFormStyle.SIMPLE;
            newBuilder = newBuilder;
            Builder newBuilder2 = CardFormStyleParams.newBuilder();
            newBuilder2.a = facecastTipJarSettingDialog.jW_().getString(2131238288);
            newBuilder.c = newBuilder2.e();
            newBuilder = newBuilder;
            newBuilder.e = PaymentItemType.P2P_TRANSFER;
            newBuilder = newBuilder;
            CardFormAnalyticsParamsBuilder newBuilder3 = CardFormAnalyticsParams.newBuilder();
            newBuilder3.a = "tip_jar";
            newBuilder3 = newBuilder3;
            newBuilder3.b = "TIPJAR";
            newBuilder.b = newBuilder3.c();
            facecastTipJarSettingDialog.am.a(CardFormActivity.a(facecastTipJarSettingDialog.getContext(), newBuilder.f()), facecastTipJarSettingDialog.getContext());
            Logger.a(2, EntryType.UI_INPUT_END, -1649601080, a);
        }
    }

    /* compiled from: bar_message */
    public class C16233 implements OnClickListener {
        final /* synthetic */ FacecastTipJarSettingDialog f18756a;

        public C16233(FacecastTipJarSettingDialog facecastTipJarSettingDialog) {
            this.f18756a = facecastTipJarSettingDialog;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1709287214);
            this.f18756a.ap.onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, -973770007, a);
        }
    }

    /* compiled from: bar_message */
    public class C16244 extends OnToolbarButtonListener {
        final /* synthetic */ FacecastTipJarSettingDialog f18757a;

        public C16244(FacecastTipJarSettingDialog facecastTipJarSettingDialog) {
            this.f18757a = facecastTipJarSettingDialog;
        }

        public final void m22295a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            this.f18757a.ap.onBackPressed();
        }
    }

    public static void m22296a(Object obj, Context context) {
        ((FacecastTipJarSettingDialog) obj).am = (SecureContextHelper) DefaultSecureContextHelper.a(FbInjector.get(context));
    }

    public final void m22298a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1718493042);
        super.a(bundle);
        Class cls = FacecastTipJarSettingDialog.class;
        m22296a((Object) this, getContext());
        a(2, 2131625233);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1568446319, a);
    }

    public final Dialog m22300c(Bundle bundle) {
        this.ap = new Dialog(an(), d());
        return this.ap;
    }

    public final View m22297a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -170054116);
        View inflate = layoutInflater.inflate(2130904231, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 949361281, a);
        return inflate;
    }

    public final void m22299a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.aq = (ViewGroup) e(2131561711);
        this.aq.setVisibility(0);
        this.ar = (SwitchCompat) e(2131561713);
        this.ar.setChecked(false);
        this.as = (ViewGroup) e(2131561714);
        this.at = (FbTextView) e(2131561717);
        this.ar.setOnCheckedChangeListener(new C16211(this));
        FbTitleBarUtil.a(view);
        FbTitleBar fbTitleBar = (FbTitleBar) e(2131558563);
        fbTitleBar.setTitle(jW_().getString(2131238302));
        fbTitleBar.setHasBackButton(false);
        fbTitleBar.a(new C16233(this));
        TitleBarButtonSpec.Builder a = TitleBarButtonSpec.a();
        a.g = jW_().getString(2131238305);
        fbTitleBar.setButtonSpecs(ImmutableList.of(a.a()));
        fbTitleBar.setOnToolbarButtonListener(new C16244(this));
        this.as.setOnClickListener(new C16222(this));
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1453335922);
        super.mi_();
        if (this.f == null) {
            Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 661003471, a);
        } else {
            LogUtils.f(-1758301524, a);
        }
    }
}
