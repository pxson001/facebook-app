package com.facebook.friends.controllers;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.error.GraphQLError;
import com.facebook.graphql.error.GraphQLException;
import com.facebook.http.protocol.ApiErrorResult;
import com.facebook.inject.InjectorLike;
import com.facebook.resources.ui.FbTextView;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import javax.inject.Inject;

/* compiled from: newsfeed_composer */
public class FriendingExceptionHandler {
    private final Context f12287a;
    private final Toaster f12288b;

    public static FriendingExceptionHandler m18298b(InjectorLike injectorLike) {
        return new FriendingExceptionHandler((Context) injectorLike.getInstance(Context.class), Toaster.m6454b(injectorLike));
    }

    @Inject
    public FriendingExceptionHandler(Context context, Toaster toaster) {
        this.f12287a = context;
        this.f12288b = toaster;
    }

    public final void m18302a(Throwable th) {
        m18303a(th, 2131230758, null);
    }

    public final void m18305a(Throwable th, OnClickListener onClickListener) {
        m18303a(th, 2131230758, onClickListener);
    }

    public final void m18303a(Throwable th, int i, OnClickListener onClickListener) {
        m18304a(th, i, onClickListener, this.f12287a);
    }

    public final void m18304a(Throwable th, int i, OnClickListener onClickListener, Context context) {
        Object obj;
        Activity activity = (Activity) ContextUtils.m2500a(context, Activity.class);
        if (activity == null || activity.isFinishing()) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            CharSequence c = m18299c(th);
            if (StringUtil.m3589a(c)) {
                this.f12288b.m6456b(new ToastBuilder(i));
                return;
            }
            int e = m18301e(th);
            FbAlertDialogBuilder fbAlertDialogBuilder = new FbAlertDialogBuilder(context);
            CharSequence d = m18300d(th);
            if (StringUtil.m3589a(d)) {
                fbAlertDialogBuilder.b(Html.fromHtml(c).toString());
            } else {
                View inflate = LayoutInflater.from(this.f12287a).inflate(2130904504, null);
                FbTextView fbTextView = (FbTextView) inflate.findViewById(2131562307);
                ((FbTextView) inflate.findViewById(2131562306)).setText(d);
                fbTextView.setText(Html.fromHtml(c).toString());
                fbAlertDialogBuilder.b(inflate);
            }
            if (e == 1407026) {
                fbAlertDialogBuilder.a(2131230729, onClickListener).b(2131230727, m18297a());
            } else {
                fbAlertDialogBuilder.a(2131230726, m18297a());
            }
            fbAlertDialogBuilder.b();
        }
    }

    private static String m18299c(Throwable th) {
        if (!(th instanceof GraphQLException)) {
            return null;
        }
        ApiErrorResult apiErrorResult = ((GraphQLException) th).error;
        if (apiErrorResult != null) {
            return apiErrorResult.c();
        }
        return null;
    }

    private static String m18300d(Throwable th) {
        if (!(th instanceof GraphQLException)) {
            return null;
        }
        GraphQLError graphQLError = ((GraphQLException) th).error;
        if (graphQLError != null) {
            return graphQLError.summary;
        }
        return null;
    }

    private static int m18301e(Throwable th) {
        if (!(th instanceof GraphQLException)) {
            return -1;
        }
        ApiErrorResult apiErrorResult = ((GraphQLException) th).error;
        if (apiErrorResult != null) {
            return apiErrorResult.a();
        }
        return -1;
    }

    private static OnClickListener m18297a() {
        return new 1();
    }
}
