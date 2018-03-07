package com.facebook.messaging.events.banner;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.facebook.ui.dialogs.FbAlertDialog;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.google.common.base.Preconditions;

/* compiled from: snapshots */
public class EventReminderPromptCreationDialogFragment extends FbDialogFragment {

    /* compiled from: snapshots */
    class C03952 implements OnClickListener {
        final /* synthetic */ EventReminderPromptCreationDialogFragment f2344a;

        C03952(EventReminderPromptCreationDialogFragment eventReminderPromptCreationDialogFragment) {
            this.f2344a = eventReminderPromptCreationDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public final Dialog m2198c(Bundle bundle) {
        Bundle bundle2 = this.s;
        final String string = bundle2.getString("thread_id");
        final String string2 = bundle2.getString("source_surface");
        final String string3 = bundle2.getString("source_module");
        FbAlertDialog fbAlertDialog = new FbAlertDialog(getContext());
        fbAlertDialog.setTitle(2131241213);
        fbAlertDialog.a(jW_().getString(2131241214));
        fbAlertDialog.a(-1, jW_().getString(2131241215), new OnClickListener(this) {
            final /* synthetic */ EventReminderPromptCreationDialogFragment f2343d;

            public void onClick(DialogInterface dialogInterface, int i) {
                String str = string;
                String str2 = string2;
                String str3 = string3;
                Preconditions.checkNotNull(str);
                Preconditions.checkNotNull(str2);
                Preconditions.checkNotNull(str3);
                Bundle bundle = new Bundle();
                bundle.putString("thread_id", str);
                bundle.putString("source_surface", str2);
                bundle.putString("source_module", str3);
                EventReminderEditTimeDialogFragment eventReminderEditTimeDialogFragment = new EventReminderEditTimeDialogFragment();
                eventReminderEditTimeDialogFragment.g(bundle);
                eventReminderEditTimeDialogFragment.a(this.f2343d.D, "edit_event_reminder_time");
            }
        });
        fbAlertDialog.a(-2, jW_().getString(2131241216), new C03952(this));
        return fbAlertDialog;
    }
}
