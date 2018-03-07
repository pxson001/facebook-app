package com.facebook.orca.threadview;

import android.content.Context;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.notify.FailedToSendMessageNotification.FailureReason;
import com.facebook.messaging.send.ui.SendDialogUtils;
import com.facebook.messaging.send.ui.SendDialogUtils.C05994;
import com.facebook.messaging.send.ui.SendDialogUtils.C06005;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import javax.inject.Inject;

/* compiled from: mediaview */
public class ThreadViewMessagesFragmentSendFailuresHelper {
    private final Lazy<SendDialogUtils> f7903a;

    private static ThreadViewMessagesFragmentSendFailuresHelper m7861b(InjectorLike injectorLike) {
        return new ThreadViewMessagesFragmentSendFailuresHelper(IdBasedLazy.a(injectorLike, 8357));
    }

    @Inject
    public ThreadViewMessagesFragmentSendFailuresHelper(Lazy<SendDialogUtils> lazy) {
        this.f7903a = lazy;
    }

    public final void m7862a(Context context, ThreadViewMessagesInitParams threadViewMessagesInitParams) {
        if (threadViewMessagesInitParams.f7908e != null) {
            SendDialogUtils sendDialogUtils = (SendDialogUtils) this.f7903a.get();
            if (threadViewMessagesInitParams.f7908e == FailureReason.MEDIA_UPLOAD_FILE_NOT_FOUND_LOW_DISK_SPACE) {
                new FbAlertDialogBuilder(context).a(2131231240).b(2131231244).a(2131231245, new C06005(sendDialogUtils, context)).b(2131231246, new C05994(sendDialogUtils)).a().show();
            }
        }
    }

    public static ThreadViewMessagesFragmentSendFailuresHelper m7860a(InjectorLike injectorLike) {
        return m7861b(injectorLike);
    }
}
