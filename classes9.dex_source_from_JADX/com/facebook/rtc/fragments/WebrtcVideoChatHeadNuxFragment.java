package com.facebook.rtc.fragments;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.facebook.user.model.UserKey;
import com.facebook.user.tiles.UserTileView;
import com.facebook.user.tiles.UserTileViewParams;

/* compiled from: application/vnd.wap.wtls-ca-certificate */
public class WebrtcVideoChatHeadNuxFragment extends FbDialogFragment {
    public OnActionClickListener am = null;
    private UserTileView an;
    private UserTileView ao;
    public long ap;
    public long aq;
    private Activity ar;
    private AlertDialog as;

    /* compiled from: application/vnd.wap.wtls-ca-certificate */
    class C23301 implements OnClickListener {
        final /* synthetic */ WebrtcVideoChatHeadNuxFragment f19727a;

        C23301(WebrtcVideoChatHeadNuxFragment webrtcVideoChatHeadNuxFragment) {
            this.f19727a = webrtcVideoChatHeadNuxFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (this.f19727a.am != null) {
                OnActionClickListener onActionClickListener = this.f19727a.am;
            }
            this.f19727a.a();
        }
    }

    /* compiled from: application/vnd.wap.wtls-ca-certificate */
    class C23312 implements OnClickListener {
        final /* synthetic */ WebrtcVideoChatHeadNuxFragment f19728a;

        C23312(WebrtcVideoChatHeadNuxFragment webrtcVideoChatHeadNuxFragment) {
            this.f19728a = webrtcVideoChatHeadNuxFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (this.f19728a.am != null) {
                this.f19728a.am.mo836a();
            }
            this.f19728a.a();
        }
    }

    /* compiled from: application/vnd.wap.wtls-ca-certificate */
    public interface OnActionClickListener {
        void mo836a();
    }

    public final void a_(Context context) {
        super.a_(context);
        if (context instanceof Activity) {
            this.ar = (Activity) context;
        }
    }

    public final Dialog m19531c(Bundle bundle) {
        View inflate = this.ar.getLayoutInflater().inflate(2130906927, null);
        this.ao = (UserTileView) inflate.findViewById(2131567189);
        this.an = (UserTileView) inflate.findViewById(2131567190);
        if (this.ap > 0 && this.ao != null) {
            this.ao.setParams(UserTileViewParams.a(UserKey.b(Long.toString(this.ap))));
        }
        if (this.aq > 0 && this.an != null) {
            this.an.setParams(UserTileViewParams.a(UserKey.b(Long.toString(this.aq))));
        }
        this.as = new FbAlertDialogBuilder(this.ar).b(inflate).a(b(2131232099), new C23312(this)).b(b(2131232100), new C23301(this)).a();
        return this.as;
    }
}
