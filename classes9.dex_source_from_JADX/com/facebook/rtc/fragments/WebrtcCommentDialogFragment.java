package com.facebook.rtc.fragments;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbEditText;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import javax.inject.Inject;

/* compiled from: application/vnd.wv.csp+wbxml */
public class WebrtcCommentDialogFragment extends WebrtcDialogFragment {
    @Inject
    public Clock am;
    private int aq;
    private String ar;
    public String as;
    public long at;
    private boolean au;

    /* compiled from: application/vnd.wv.csp+wbxml */
    class C23211 implements OnClickListener {
        final /* synthetic */ WebrtcCommentDialogFragment f19714a;

        C23211(WebrtcCommentDialogFragment webrtcCommentDialogFragment) {
            this.f19714a = webrtcCommentDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f19714a.a();
        }
    }

    /* compiled from: application/vnd.wv.csp+wbxml */
    public class C23233 implements TextWatcher {
        final /* synthetic */ WebrtcCommentDialogFragment f19717a;

        public C23233(WebrtcCommentDialogFragment webrtcCommentDialogFragment) {
            this.f19717a = webrtcCommentDialogFragment;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            if (editable.length() > 300) {
                editable.delete(300, editable.length());
            }
            long a = this.f19717a.am.a();
            if (a - this.f19717a.at > 10000) {
                this.f19717a.an.mo808a(180000);
                this.f19717a.at = a;
            }
        }
    }

    public static void m19521a(Object obj, Context context) {
        ((WebrtcCommentDialogFragment) obj).am = (Clock) SystemClockMethodAutoProvider.a(FbInjector.get(context));
    }

    public final void mo817a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 316180866);
        super.mo817a(bundle);
        Class cls = WebrtcCommentDialogFragment.class;
        m19521a(this, getContext());
        this.aq = this.s.getInt("rating");
        this.ar = this.s.getString("reason_key");
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1138144195, a);
    }

    final AlertDialog aq() {
        return null;
    }

    public final Dialog m19523c(Bundle bundle) {
        this.an.mo808a(180000);
        final FbEditText fbEditText = (FbEditText) this.aq.getLayoutInflater().inflate(2130907752, null);
        fbEditText.addTextChangedListener(new C23233(this));
        return new FbAlertDialogBuilder(this.aq).b(fbEditText).a(getContext().getString(2131232064)).a(b(2131232062), new OnClickListener(this) {
            final /* synthetic */ WebrtcCommentDialogFragment f19716b;

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f19716b.as = fbEditText.getText().toString();
                this.f19716b.a();
            }
        }).b(b(2131232063), new C23211(this)).a();
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (this.au) {
            this.au = false;
        } else {
            m19519a(this.aq, this.ar, this.as);
        }
    }

    public final void ar() {
        this.au = true;
        m19519a(this.aq, this.ar, this.as);
    }
}
