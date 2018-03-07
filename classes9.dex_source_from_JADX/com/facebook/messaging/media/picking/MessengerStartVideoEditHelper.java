package com.facebook.messaging.media.picking;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentManager;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.fullscreendialog.FullScreenDialogParams;
import com.facebook.messaging.media.upload.MediaUploadManagerImpl;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.media.attachments.MediaResource;
import javax.inject.Inject;

/* compiled from: log_analytics */
public class MessengerStartVideoEditHelper {
    private MediaUploadManagerImpl f11799a;

    /* compiled from: log_analytics */
    public class C13251 implements OnClickListener {
        final /* synthetic */ MessengerStartVideoEditHelper f11798a;

        public C13251(MessengerStartVideoEditHelper messengerStartVideoEditHelper) {
            this.f11798a = messengerStartVideoEditHelper;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public static MessengerStartVideoEditHelper m12422b(InjectorLike injectorLike) {
        return new MessengerStartVideoEditHelper(MediaUploadManagerImpl.a(injectorLike));
    }

    @Inject
    public MessengerStartVideoEditHelper(MediaUploadManagerImpl mediaUploadManagerImpl) {
        this.f11799a = mediaUploadManagerImpl;
    }

    public final void m12423a(Context context, MediaResource mediaResource, FragmentManager fragmentManager, String str, FullScreenDialogParams fullScreenDialogParams, ThreadKey threadKey, boolean z) {
        if (this.f11799a.a()) {
            new FbAlertDialogBuilder(context).a(context.getResources().getString(2131231733)).b(context.getResources().getString(2131231734)).a(17039370, new C13251(this)).b();
            return;
        }
        MessengerVideoEditDialogFragment a;
        if (fullScreenDialogParams != null) {
            a = MessengerVideoEditDialogFragment.m12426a(mediaResource, fullScreenDialogParams, z);
        } else {
            a = MessengerVideoEditDialogFragment.m12426a(mediaResource, FullScreenDialogParams.a(), z);
        }
        if (threadKey != null) {
            a.at = threadKey;
        }
        a.a(fragmentManager, str);
    }
}
