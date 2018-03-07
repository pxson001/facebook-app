package com.facebook.orca.threadlist;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel.MessengerInboxUnitTitleModel;
import com.facebook.orca.threadlist.ThreadListFragment.AnonymousClass17;

/* compiled from: ndt_push_received */
public class InboxUnitConfirmHideSectionDialogFragment extends DialogFragment {
    public AnonymousClass17 al;

    public final Dialog m6171c(Bundle bundle) {
        CharSequence string;
        final NodesModel nodesModel = (NodesModel) FlatBufferModelHelper.a(this.s, "node");
        MessengerInboxUnitTitleModel q = nodesModel.q();
        if (q == null || q.a() == null) {
            string = jW_().getString(2131231820);
        } else {
            string = jW_().getString(2131231819, new Object[]{q.a()});
        }
        return new Builder(getContext()).a(2131231818).b(string).a(2131231821, new OnClickListener(this) {
            final /* synthetic */ InboxUnitConfirmHideSectionDialogFragment f6485b;

            public void onClick(DialogInterface dialogInterface, int i) {
                if (this.f6485b.al != null) {
                    AnonymousClass17 anonymousClass17 = this.f6485b.al;
                    anonymousClass17.f6605a.bA.f2765b.mo79a(nodesModel);
                }
            }
        }).b(2131230727, null).a();
    }
}
