package com.facebook.messaging.send.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.util.StringUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.attachments.AttachmentDataFactory;
import com.facebook.messaging.messageclassifier.MessageClassifier;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.service.model.DeleteMessagesParams;
import com.facebook.messaging.service.model.DeleteMessagesParams.ServerParam;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.errordialog.ErrorDialogs;
import com.google.common.collect.ImmutableSet;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: rapid_feedback_survey */
public class SendDialogUtils {
    private static final Class<?> f3982a = SendDialogUtils.class;
    public final Resources f3983b;
    public final DefaultBlueServiceOperationFactory f3984c;
    public final SendErrorHelper f3985d;
    public final ErrorDialogs f3986e;
    public final SecureContextHelper f3987f;

    /* compiled from: rapid_feedback_survey */
    class C05972 implements OnClickListener {
        final /* synthetic */ SendDialogUtils f3975a;

        C05972(SendDialogUtils sendDialogUtils) {
            this.f3975a = sendDialogUtils;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: rapid_feedback_survey */
    public class C05994 implements OnClickListener {
        final /* synthetic */ SendDialogUtils f3979a;

        public C05994(SendDialogUtils sendDialogUtils) {
            this.f3979a = sendDialogUtils;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: rapid_feedback_survey */
    public class C06005 implements OnClickListener {
        final /* synthetic */ Context f3980a;
        final /* synthetic */ SendDialogUtils f3981b;

        public C06005(SendDialogUtils sendDialogUtils, Context context) {
            this.f3981b = sendDialogUtils;
            this.f3980a = context;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f3981b.f3987f.b(new Intent("android.settings.INTERNAL_STORAGE_SETTINGS"), this.f3980a);
        }
    }

    public static SendDialogUtils m3710b(InjectorLike injectorLike) {
        Resources a = ResourcesMethodAutoProvider.a(injectorLike);
        DefaultBlueServiceOperationFactory b = DefaultBlueServiceOperationFactory.b(injectorLike);
        SendErrorHelper sendErrorHelper = new SendErrorHelper(MessageClassifier.a(injectorLike), AttachmentDataFactory.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
        sendErrorHelper.f3994f = IdBasedLazy.a(injectorLike, 2644);
        return new SendDialogUtils(a, b, sendErrorHelper, ErrorDialogs.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    public static SendDialogUtils m3709a(InjectorLike injectorLike) {
        return m3710b(injectorLike);
    }

    @Inject
    public SendDialogUtils(Resources resources, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, SendErrorHelper sendErrorHelper, ErrorDialogs errorDialogs, SecureContextHelper secureContextHelper) {
        this.f3983b = resources;
        this.f3984c = defaultBlueServiceOperationFactory;
        this.f3985d = sendErrorHelper;
        this.f3986e = errorDialogs;
        this.f3987f = secureContextHelper;
    }

    public final void m3711a(final Context context, final String str, int i, @Nullable String str2, final ThreadKey threadKey) {
        String string;
        if (BLog.b(3)) {
            new StringBuilder("showMessageFailNoRetryErrorDialog, message id is ").append(str);
        }
        FbAlertDialogBuilder fbAlertDialogBuilder = new FbAlertDialogBuilder(context);
        if (ThreadKey.d(threadKey)) {
            string = this.f3983b.getString(2131231243);
        } else {
            string = this.f3985d.m3718a(i, this.f3983b.getString(2131231241));
        }
        Builder b = fbAlertDialogBuilder.a(string).b(str2).a(2131230726, new C05972(this)).b(this.f3983b.getQuantityString(2131689485, 1), new OnClickListener(this) {
            final /* synthetic */ SendDialogUtils f3974c;

            public void onClick(DialogInterface dialogInterface, int i) {
                SendDialogUtils sendDialogUtils = this.f3974c;
                String str = str;
                ThreadKey threadKey = threadKey;
                Bundle bundle = new Bundle();
                bundle.putParcelable("deleteMessagesParams", new DeleteMessagesParams(ImmutableSet.of(str), ServerParam.MUST_UPDATE_SERVER, threadKey));
                BlueServiceOperationFactoryDetour.a(sendDialogUtils.f3984c, "delete_messages", bundle, 637679718).a(true).a();
                dialogInterface.dismiss();
            }
        });
        if (StringUtil.a(str2)) {
            b.b(2131231186);
        } else {
            b.b(str2);
        }
        final Object a = this.f3985d.m3717a(i);
        if (!StringUtil.a(a)) {
            b.c(2131231247, new OnClickListener(this) {
                final /* synthetic */ SendDialogUtils f3978c;

                public void onClick(DialogInterface dialogInterface, int i) {
                    Uri parse = Uri.parse(a);
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(parse);
                    this.f3978c.f3987f.b(intent, context);
                    dialogInterface.dismiss();
                }
            });
        }
        b.b();
    }
}
