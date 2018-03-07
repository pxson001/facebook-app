package com.facebook.platform.composer.draftpost;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.dialogs.FbDialogFragment;

/* compiled from: rich_document_fetch */
public class DraftPostComposerCancelDialogFragment extends FbDialogFragment {
    public OnClickListener am;
    public OnClickListener an;
    public OnDismissListener ao;
    public OnCancelListener ap;

    /* compiled from: rich_document_fetch */
    class C05391 implements OnClickListener {
        final /* synthetic */ DraftPostComposerCancelDialogFragment f4142a;

        C05391(DraftPostComposerCancelDialogFragment draftPostComposerCancelDialogFragment) {
            this.f4142a = draftPostComposerCancelDialogFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1692300430);
            this.f4142a.f.cancel();
            Logger.a(2, EntryType.UI_INPUT_END, 1003503841, a);
        }
    }

    public final View m4105a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1406996378);
        super.a(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(2130906299, viewGroup);
        View findViewById = inflate.findViewById(2131566094);
        View findViewById2 = inflate.findViewById(2131566095);
        View findViewById3 = inflate.findViewById(2131566096);
        if (this.am != null) {
            findViewById.setOnClickListener(this.am);
        } else {
            findViewById.setVisibility(8);
        }
        findViewById2.setOnClickListener(new C05391(this));
        if (this.an != null) {
            findViewById3.setOnClickListener(this.an);
        } else {
            findViewById3.setVisibility(8);
        }
        LogUtils.f(-1686664395, a);
        return inflate;
    }

    public final Dialog m4106c(Bundle bundle) {
        Dialog c = super.c(bundle);
        c.getWindow().requestFeature(1);
        return c;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.ao != null) {
            this.ao.onDismiss(dialogInterface);
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        if (this.ap != null) {
            this.ap.onCancel(dialogInterface);
        }
    }
}
