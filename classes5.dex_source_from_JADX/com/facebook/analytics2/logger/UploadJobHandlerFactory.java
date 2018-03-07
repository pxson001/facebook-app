package com.facebook.analytics2.logger;

import android.content.Context;
import android.os.Looper;
import com.facebook.analytics2.logger.UploadJobHandler.InvocationParams;
import com.facebook.analytics2.logger.UploadJobHandler.UploadJobHandlerCallback;

/* compiled from: tertiary_text_color */
class UploadJobHandlerFactory {
    UploadJobHandlerFactory() {
    }

    public static UploadJobHandler m2761a(Context context, Looper looper, InvocationParams invocationParams, UploadJobHandlerCallback uploadJobHandlerCallback) {
        return new UploadJobHandler(context, looper, invocationParams, uploadJobHandlerCallback);
    }
}
