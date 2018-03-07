package com.facebook.messaging.business.messengerextensions;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.LayoutInflater;
import com.facebook.messaging.business.messengerextensions.MessengerExtensionsContainerView.DismissAnimationEventListener;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.ui.dialogs.FbDialog;
import javax.annotation.Nullable;

/* compiled from: threadViewLoader.serviceException.stackTrace */
public final class MessengerExtensionsPresenter {
    public final Context f1651a;
    public final String f1652b;
    public final ThreadKey f1653c;
    @Nullable
    public ExtensionDialog f1654d = new ExtensionDialog(this, this.f1651a);
    public MessengerExtensionsEventListener f1655e;

    /* compiled from: threadViewLoader.serviceException.stackTrace */
    public class C02661 implements OnDismissListener {
        final /* synthetic */ MessengerExtensionsPresenter f1647a;

        public C02661(MessengerExtensionsPresenter messengerExtensionsPresenter) {
            this.f1647a = messengerExtensionsPresenter;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            this.f1647a.f1654d = null;
            if (this.f1647a.f1655e != null) {
                this.f1647a.f1655e.mo55b();
            }
        }
    }

    /* compiled from: threadViewLoader.serviceException.stackTrace */
    public class C02672 implements DismissAnimationEventListener {
        final /* synthetic */ MessengerExtensionsPresenter f1648a;

        public C02672(MessengerExtensionsPresenter messengerExtensionsPresenter) {
            this.f1648a = messengerExtensionsPresenter;
        }

        public final void mo55b() {
            if (this.f1648a.f1654d != null) {
                this.f1648a.f1654d.dismiss();
            }
        }

        public final void mo54a(boolean z) {
            if (this.f1648a.f1654d != null) {
                if (z) {
                    this.f1648a.f1654d.show();
                } else {
                    this.f1648a.f1654d.hide();
                }
                if (this.f1648a.f1655e != null) {
                    this.f1648a.f1655e.mo54a(z);
                }
            }
        }

        public final void mo53a() {
            if (this.f1648a.f1654d != null) {
                this.f1648a.f1654d.m1600a();
            }
        }
    }

    /* compiled from: threadViewLoader.serviceException.stackTrace */
    public class ExtensionDialog extends FbDialog {
        final /* synthetic */ MessengerExtensionsPresenter f1649a;
        private final MessengerExtensionsContainerView f1650b;

        @SuppressLint({"BadArgument-LayoutInflater#inflate-0"})
        public ExtensionDialog(MessengerExtensionsPresenter messengerExtensionsPresenter, Context context) {
            this.f1649a = messengerExtensionsPresenter;
            super(context, 2131624659);
            getWindow().setFlags(131072, 131072);
            getWindow().setFlags(16777216, 16777216);
            this.f1650b = (MessengerExtensionsContainerView) LayoutInflater.from(context).inflate(2130905247, null);
            this.f1650b.m1591a(messengerExtensionsPresenter.f1652b, messengerExtensionsPresenter.f1653c, new C02672(messengerExtensionsPresenter));
            setContentView(this.f1650b);
        }

        public final void m1600a() {
            super.dismiss();
        }

        public void dismiss() {
            this.f1650b.m1590a();
        }
    }

    MessengerExtensionsPresenter(Context context, String str, ThreadKey threadKey) {
        this.f1651a = context;
        this.f1652b = str;
        this.f1653c = threadKey;
        this.f1654d.show();
        this.f1654d.setOnDismissListener(new C02661(this));
    }
}
