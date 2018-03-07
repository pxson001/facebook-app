package com.facebook.messaging.mutators;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import com.facebook.fbservice.ops.BlueServiceFragment;
import com.facebook.fbservice.ops.BlueServiceOperation.OnCompletedListener;
import com.facebook.fbservice.ops.BlueServiceOperation.State;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.annotations.IsGlobalMessageDeleteEnabled;
import com.facebook.messaging.dialog.ConfirmActionDialogFragment;
import com.facebook.messaging.dialog.ConfirmActionParams.Builder;
import com.facebook.messaging.dialog.ConfirmActionParams.ButtonStyle;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.service.model.DeleteMessagesParams;
import com.facebook.messaging.service.model.DeleteMessagesParams.ServerParam;
import com.facebook.ui.errordialog.ErrorDialogParams;
import com.facebook.ui.errordialog.ErrorDialogParamsBuilder;
import com.facebook.ui.errordialog.ErrorDialogs;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: s_i */
public class DeleteMessagesDialogFragment extends ConfirmActionDialogFragment {
    @Inject
    public ErrorDialogs am;
    @Inject
    @IsGlobalMessageDeleteEnabled
    public Provider<Boolean> an;
    @Inject
    public MessageUtil ao;
    public BlueServiceFragment ap;
    public AlertDialog aq;
    public ImmutableSet<String> ar;
    public ThreadKey as;

    /* compiled from: s_i */
    public class C05341 extends OnCompletedListener {
        final /* synthetic */ DeleteMessagesDialogFragment f3317a;

        public C05341(DeleteMessagesDialogFragment deleteMessagesDialogFragment) {
            this.f3317a = deleteMessagesDialogFragment;
        }

        public final void m3227a(OperationResult operationResult) {
            this.f3317a.a();
        }

        public final void m3228a(ServiceException serviceException) {
            DeleteMessagesDialogFragment deleteMessagesDialogFragment = this.f3317a;
            if (deleteMessagesDialogFragment.getContext() != null && deleteMessagesDialogFragment.z() && deleteMessagesDialogFragment.y) {
                ErrorDialogs errorDialogs = deleteMessagesDialogFragment.am;
                ErrorDialogParamsBuilder a = ErrorDialogParams.a(deleteMessagesDialogFragment.jW_()).a(2131230721);
                a.f = serviceException;
                a = a;
                a.j = deleteMessagesDialogFragment;
                deleteMessagesDialogFragment.aq = errorDialogs.a(a.l());
            }
        }
    }

    public static void m3229a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        DeleteMessagesDialogFragment deleteMessagesDialogFragment = (DeleteMessagesDialogFragment) obj;
        ErrorDialogs a = ErrorDialogs.a(fbInjector);
        Provider a2 = IdBasedProvider.a(fbInjector, 4063);
        MessageUtil a3 = MessageUtil.a(fbInjector);
        deleteMessagesDialogFragment.am = a;
        deleteMessagesDialogFragment.an = a2;
        deleteMessagesDialogFragment.ao = a3;
    }

    public final void m3231a(Bundle bundle) {
        Builder builder;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -645428916);
        super.a(bundle);
        Class cls = DeleteMessagesDialogFragment.class;
        m3229a(this, getContext());
        Message message = (Message) this.s.getParcelable("message");
        this.ar = new ImmutableSet.Builder().c(message.a).b();
        this.as = message.b;
        int size = this.ar.size();
        boolean P = this.ao.P(message);
        Resources jW_ = jW_();
        if (!((Boolean) this.an.get()).booleanValue()) {
            builder = new Builder(jW_.getQuantityString(2131689482, size), jW_.getQuantityString(2131689485, size));
            builder.d = jW_.getQuantityString(2131689483, size);
            builder = builder;
        } else if (P) {
            builder = new Builder(jW_.getQuantityString(2131689482, size), jW_.getQuantityString(2131689485, size));
            builder.d = jW_.getQuantityString(2131689484, size);
            builder = builder;
        } else {
            builder = new Builder(jW_.getQuantityString(2131689487, size), jW_.getQuantityString(2131689489, size));
            builder.d = jW_.getQuantityString(2131689488, size);
            builder = builder;
        }
        builder.g = ButtonStyle.DELETE;
        this.am = builder.a();
        if (this.ap == null && this.D.c()) {
            String quantityString;
            this.ap = BlueServiceFragment.a(this.D, "deleteMessagesOperation");
            this.ap.b = new C05341(this);
            if (P || !((Boolean) this.an.get()).booleanValue()) {
                quantityString = jW_().getQuantityString(2131689486, 1);
            } else {
                quantityString = jW_().getQuantityString(2131689490, 1);
            }
            this.ap.a(new DialogBasedProgressIndicator(getContext(), quantityString));
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1800827303, a);
    }

    public final void m3232a(Message message) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("message", message);
        g(bundle);
    }

    public final void m3230a() {
        if (this.ap != null) {
            this.ap.a(null);
        }
        if (this.aq != null) {
            this.aq.dismiss();
            this.aq = null;
        }
        super.b();
    }

    protected final void aq() {
        if (this.ap.b() == State.INIT) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("deleteMessagesParams", new DeleteMessagesParams(this.ar, ServerParam.MUST_UPDATE_SERVER, this.as));
            this.ap.a("delete_messages", bundle);
        }
    }
}
