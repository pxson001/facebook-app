package com.facebook.messaging.payment.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.annotation.StringRes;
import com.facebook.common.util.ExceptionUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.http.protocol.ApiException;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.connectivity.PaymentConnectivityDialogFactory;
import com.facebook.messaging.payment.model.PaymentCard;
import com.facebook.messaging.payment.utils.PaymentViewUtil;
import com.facebook.offlinemode.common.OfflineModeHelper;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;

/* compiled from: initial_nearby_place */
public class PaymentDialogsBuilder {

    /* compiled from: initial_nearby_place */
    final class C14441 implements OnClickListener {
        final /* synthetic */ ImmutableList f13001a;
        final /* synthetic */ MultiOptionsDialogListener f13002b;
        final /* synthetic */ String f13003c;

        C14441(ImmutableList immutableList, MultiOptionsDialogListener multiOptionsDialogListener, String str) {
            this.f13001a = immutableList;
            this.f13002b = multiOptionsDialogListener;
            this.f13003c = str;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            if (i < this.f13001a.size()) {
                this.f13002b.mo521a(i);
                return;
            }
            Preconditions.checkState(!Strings.isNullOrEmpty(this.f13003c));
            this.f13002b.mo520a();
        }
    }

    /* compiled from: initial_nearby_place */
    final class C14453 implements OnClickListener {
        C14453() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* compiled from: initial_nearby_place */
    public interface MultiOptionsDialogListener {
        void mo520a();

        void mo521a(int i);
    }

    public static PaymentDialogsBuilder m13301a(InjectorLike injectorLike) {
        return new PaymentDialogsBuilder();
    }

    public static AlertDialog m13297a(Context context, ImmutableList<String> immutableList, @Nullable String str, String str2, @Nullable String str3, MultiOptionsDialogListener multiOptionsDialogListener) {
        Builder builder = new Builder();
        builder.b(immutableList);
        if (!Strings.isNullOrEmpty(str)) {
            builder.c(str);
        }
        OnClickListener c14441 = new C14441(immutableList, multiOptionsDialogListener, str);
        ImmutableList b = builder.b();
        String[] strArr = new String[b.size()];
        FbAlertDialogBuilder fbAlertDialogBuilder = new FbAlertDialogBuilder(context);
        PaymentMultiChooserCustomTitleView paymentMultiChooserCustomTitleView = new PaymentMultiChooserCustomTitleView(context);
        paymentMultiChooserCustomTitleView.f13004a.setText(str2);
        if (StringUtil.a(str3)) {
            paymentMultiChooserCustomTitleView.f13005b.setVisibility(8);
        } else {
            paymentMultiChooserCustomTitleView.f13005b.setText(str3);
        }
        return fbAlertDialogBuilder.a(paymentMultiChooserCustomTitleView).a((CharSequence[]) b.toArray(strArr), c14441).b();
    }

    private static AlertDialog m13298a(Context context, String str, String str2) {
        return m13299a(context, str, str2, context.getString(2131230726), new C14453());
    }

    public static AlertDialog m13299a(Context context, String str, String str2, String str3, OnClickListener onClickListener) {
        return new FbAlertDialogBuilder(context).a(str).b(str2).c(str3, onClickListener).a();
    }

    public static AlertDialog m13295a(Context context, @StringRes int i, @StringRes int i2, @StringRes int i3, OnClickListener onClickListener, @StringRes int i4, OnClickListener onClickListener2) {
        return m13300a(context, context.getString(i), context.getString(i2), context.getString(i3), onClickListener, context.getString(i4), onClickListener2);
    }

    public static AlertDialog m13300a(Context context, String str, String str2, String str3, OnClickListener onClickListener, String str4, OnClickListener onClickListener2) {
        return new FbAlertDialogBuilder(context).a(str).b(str2).a(str3, onClickListener).b(str4, onClickListener2).a();
    }

    public static AlertDialog m13296a(Context context, @StringRes int i, @StringRes int i2, OnClickListener onClickListener, @StringRes int i3, OnClickListener onClickListener2) {
        return m13300a(context, null, context.getString(i), context.getString(i2), onClickListener, context.getString(i3), onClickListener2);
    }

    public static void m13303a(Context context, Throwable th, String str, String str2) {
        if (OfflineModeHelper.b(th)) {
            PaymentConnectivityDialogFactory.a(context);
            return;
        }
        ApiException apiException = (ApiException) ExceptionUtil.a(th, ApiException.class);
        if (apiException == null || apiException.c() == null || apiException.d() == null) {
            m13298a(context, str, str2).show();
        } else {
            m13298a(context, apiException.c(), apiException.d()).show();
        }
    }

    public static ImmutableList<String> m13302a(Context context, ImmutableList<PaymentCard> immutableList) {
        Builder builder = new Builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            builder.c(PaymentViewUtil.m15541a(context, (PaymentCard) immutableList.get(i)));
        }
        return builder.b();
    }
}
