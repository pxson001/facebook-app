package com.facebook.negativefeedback.video.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.negativefeedback.video.RapidReportingController;
import com.facebook.negativefeedback.video.RapidReportingController$4;
import com.facebook.negativefeedback.video.protocol.RapidReportingTagsQuery.RapidReportingTagsQueryString;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.dialogs.FbDialogFragment;
import javax.annotation.Nullable;

/* compiled from: terms_and_conditions */
public class ReportLiveVideoDialogFragment extends FbDialogFragment {
    public RapidReportingController am;
    public OnClickListener an;

    /* compiled from: terms_and_conditions */
    public enum DialogType {
        FEEDBACK,
        CANCEL_CONFIRM,
        THANK_YOU
    }

    public static ReportLiveVideoDialogFragment m1887a(DialogType dialogType, String str) {
        ReportLiveVideoDialogFragment reportLiveVideoDialogFragment = new ReportLiveVideoDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("dialog_type", dialogType.ordinal());
        bundle.putString("node_token", str);
        reportLiveVideoDialogFragment.g(bundle);
        return reportLiveVideoDialogFragment;
    }

    public final void m1888a(RapidReportingController rapidReportingController, OnClickListener onClickListener) {
        this.am = rapidReportingController;
        this.an = onClickListener;
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2017585096);
        super.mi_();
        Dialog dialog = this.f;
        if (dialog != null) {
            dialog.setCancelable(false);
            LayoutParams layoutParams = new LayoutParams();
            Window window = dialog.getWindow();
            layoutParams.copyFrom(window.getAttributes());
            layoutParams.width = -1;
            window.setAttributes(layoutParams);
            window.setSoftInputMode(16);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1837624, a);
    }

    public final Dialog m1889c(Bundle bundle) {
        DialogType dialogType = DialogType.values()[this.s.getInt("dialog_type")];
        String string = this.s.getString("node_token");
        Builder a;
        switch (dialogType) {
            case FEEDBACK:
                this.am.g.a(string);
                View reportLiveVideoFeedbackView = new ReportLiveVideoFeedbackView(getContext());
                reportLiveVideoFeedbackView.f1653d = this.am;
                RapidReportingController rapidReportingController = this.am;
                GraphQlQueryString rapidReportingTagsQueryString = new RapidReportingTagsQueryString();
                rapidReportingTagsQueryString.a("node_token", rapidReportingController.n);
                GraphQLRequest a2 = GraphQLRequest.a(rapidReportingTagsQueryString).a(GraphQLCachePolicy.a).a(120);
                a2.s = rapidReportingController.e.a();
                rapidReportingController.b.a(RapidReportingController.a, rapidReportingController.f.a(a2), AbstractDisposableFutureCallback.a(new RapidReportingController$4(rapidReportingController, reportLiveVideoFeedbackView)));
                a = m1886a(getContext(), reportLiveVideoFeedbackView);
                a.a(2131238422, this.an);
                a.b(2131230727, this.an);
                return a.a();
            case CANCEL_CONFIRM:
                a = m1886a(getContext(), null);
                a.a(2131238423);
                a.b(2131238424);
                a.a(2131238425, this.an);
                a.b(2131230742, this.an);
                return a.a();
            case THANK_YOU:
                a = m1886a(getContext(), new ReportLiveVideoThankYouView(getContext()));
                a.a(2131230726, this.an);
                return a.a();
            default:
                throw new IllegalStateException();
        }
    }

    public static Builder m1886a(Context context, @Nullable View view) {
        FbAlertDialogBuilder fbAlertDialogBuilder = new FbAlertDialogBuilder(context, 2131626049);
        fbAlertDialogBuilder.c(false);
        fbAlertDialogBuilder.a(null);
        fbAlertDialogBuilder.a(false);
        fbAlertDialogBuilder.a(view, 0, 0, 0, 0);
        return fbAlertDialogBuilder;
    }
}
