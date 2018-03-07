package com.facebook.events.create;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.events.create.EventCreationNikumanActivity.AnonymousClass16;
import com.facebook.fbui.dialog.AlertDialog.Builder;

/* compiled from: contact_list_item_add_message_action_text */
public class EventDiscardConfirmationDialog {

    /* compiled from: contact_list_item_add_message_action_text */
    final class C22581 implements OnClickListener {
        C22581() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: contact_list_item_add_message_action_text */
    final class C22592 implements OnClickListener {
        final /* synthetic */ AnonymousClass16 f16189a;
        final /* synthetic */ Activity f16190b;

        C22592(AnonymousClass16 anonymousClass16, Activity activity) {
            this.f16189a = anonymousClass16;
            this.f16190b = activity;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            if (this.f16189a != null) {
                this.f16189a.m16497a();
            }
            this.f16190b.setResult(0);
            this.f16190b.finish();
        }
    }

    public static void m16577a(Activity activity, AnonymousClass16 anonymousClass16) {
        new Builder(activity).a(2131236898).b(2131236899).a(2131236900, new C22592(anonymousClass16, activity)).b(2131236901, new C22581()).a(false).a().show();
    }
}
