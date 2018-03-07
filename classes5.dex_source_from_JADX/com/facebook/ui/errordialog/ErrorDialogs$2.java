package com.facebook.ui.errordialog;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.ApiErrorResult;

/* compiled from: commerce */
class ErrorDialogs$2 implements OnClickListener {
    final /* synthetic */ ErrorDialogParams f5469a;
    final /* synthetic */ ErrorDialogs f5470b;

    ErrorDialogs$2(ErrorDialogs errorDialogs, ErrorDialogParams errorDialogParams) {
        this.f5470b = errorDialogs;
        this.f5469a = errorDialogParams;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        if (this.f5469a.f5451h != null) {
            this.f5469a.f5451h.finish();
        }
        ErrorReportSender errorReportSender = new ErrorReportSender(this.f5470b.a);
        OperationResult operationResult = this.f5469a.f5448e.result;
        StringBuilder stringBuilder = new StringBuilder();
        ErrorCode errorCode = operationResult.e;
        stringBuilder.append("Error Code: ").append(errorCode.toString()).append("\n");
        stringBuilder.append("Error Description: ").append(operationResult.f).append("\n");
        stringBuilder.append("\n");
        if (errorCode == ErrorCode.API_ERROR) {
            stringBuilder.append("API Error:\n");
            stringBuilder.append(((ApiErrorResult) operationResult.k()).c());
            stringBuilder.append("\n\n");
        }
        Bundle bundle = operationResult.d;
        if (bundle.containsKey("originalExceptionMessage")) {
            stringBuilder.append("Original Exception:");
            stringBuilder.append(bundle.getString("originalExceptionMessage"));
            stringBuilder.append("\n");
            if (bundle.containsKey("originalExceptionStack")) {
                stringBuilder.append(bundle.getString("originalExceptionStack"));
                stringBuilder.append("\n\n");
            }
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/html");
        intent.putExtra("android.intent.extra.EMAIL", new String[]{"orca-crashes@lists.facebook.com"});
        intent.putExtra("android.intent.extra.SUBJECT", "Android Error Report");
        intent.putExtra("android.intent.extra.TEXT", stringBuilder.toString());
        errorReportSender.f5475a.startActivity(Intent.createChooser(intent, "Email Report"));
    }
}
