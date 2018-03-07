package com.facebook.photos.upload.manager;

import android.content.Context;
import com.facebook.photos.upload.operation.UploadOperation;

/* compiled from: graph_search_results_page_blended_entities */
public class UnifiedUploadNotificationConfiguration extends DefaultUploadNotificationConfiguration {
    private boolean f13634a = true;

    public final int mo1129a(UploadOperation uploadOperation) {
        if (this.f13634a) {
            return 1;
        }
        return super.mo1129a(uploadOperation);
    }

    public final String mo1131a(Context context, UploadOperation uploadOperation) {
        if (this.f13634a) {
            return m21374h(context);
        }
        return super.mo1131a(context, uploadOperation);
    }

    public final String mo1132a(Context context, UploadOperation uploadOperation, Boolean bool) {
        if (this.f13634a) {
            return m21374h(context);
        }
        return super.mo1132a(context, uploadOperation, bool);
    }

    public final String mo1138e(Context context) {
        if (this.f13634a) {
            return m21374h(context);
        }
        return super.mo1138e(context);
    }

    public final String mo1139f(Context context) {
        if (this.f13634a) {
            return m21374h(context);
        }
        return super.mo1138e(context);
    }

    public final String mo1134b(Context context) {
        return m21375i(context);
    }

    public final String mo1136c(Context context) {
        return m21375i(context);
    }

    public final String mo1137d(Context context) {
        return m21375i(context);
    }

    public final String mo1135b(Context context, UploadOperation uploadOperation) {
        return m21375i(context);
    }

    public final String mo1140g(Context context) {
        return m21375i(context);
    }

    public final String mo1130a(Context context, int i, int i2) {
        return m21375i(context);
    }

    private String m21374h(Context context) {
        return context.getString(2131236052, new Object[]{DefaultUploadNotificationConfiguration.m21346a(context)});
    }

    private static String m21375i(Context context) {
        return context.getString(2131236060);
    }

    public final void mo1133a(boolean z) {
        this.f13634a = z;
    }
}
