package com.facebook.photos.upload.dialog;

import android.content.Context;
import com.facebook.photos.upload.abtest.ExperimentsForPhotosUploadModule;
import com.facebook.photos.upload.operation.UploadOperation;
import com.facebook.qe.api.QeAccessor;
import javax.inject.Inject;

/* compiled from: graph_search_v2_single_state_suggestion */
public class DefaultUploadDialogConfiguration {
    public final QeAccessor f13568a;

    @Inject
    public DefaultUploadDialogConfiguration(QeAccessor qeAccessor) {
        this.f13568a = qeAccessor;
    }

    public static String m21273u(Context context) {
        return context.getString(2131236040);
    }

    public final String m21274a(Context context) {
        return this.f13568a.a(ExperimentsForPhotosUploadModule.f13520y, context.getString(2131236064, new Object[]{m21273u(context)}));
    }

    public final String m21275b(Context context) {
        return this.f13568a.a(ExperimentsForPhotosUploadModule.f13515t, context.getString(2131236065));
    }

    public final String m21276c(Context context) {
        return this.f13568a.a(ExperimentsForPhotosUploadModule.f13516u, context.getString(2131236066));
    }

    public final String m21278h(Context context) {
        return context.getString(2131236075, new Object[]{m21273u(context)});
    }

    public final String m21279i(Context context) {
        return context.getString(2131236076, new Object[]{m21273u(context)});
    }

    public final String m21277c(Context context, UploadOperation uploadOperation) {
        if (uploadOperation.m21520Y()) {
            return context.getString(2131236099, new Object[]{"\n\n"});
        } else if (uploadOperation.m21532c() == 1) {
            return context.getString(2131236097, new Object[]{"\n\n"});
        } else {
            return context.getString(2131236098, new Object[]{"\n\n"});
        }
    }

    public final String m21280l(Context context) {
        return context.getString(2131236087);
    }

    public final String m21281m(Context context) {
        return context.getString(2131236086);
    }

    public final String m21282q(Context context) {
        return context.getString(2131236091, new Object[]{"\n\n"});
    }
}
