package com.facebook.messaging.contacts.picker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomViewGroup;

/* compiled from: tcp */
public class ContactPickerInviteFriendsView extends CustomViewGroup {
    private final Button f1804a;
    public OnClickListener f1805b;

    /* compiled from: tcp */
    class C02921 implements OnClickListener {
        final /* synthetic */ ContactPickerInviteFriendsView f1803a;

        C02921(ContactPickerInviteFriendsView contactPickerInviteFriendsView) {
            this.f1803a = contactPickerInviteFriendsView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1209854962);
            if (this.f1803a.f1805b != null) {
                this.f1803a.f1805b.onClick(view);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -2050222327, a);
        }
    }

    public ContactPickerInviteFriendsView(Context context) {
        this(context, null, 0);
    }

    private ContactPickerInviteFriendsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130905654);
        this.f1804a = (Button) getView(2131564738);
        this.f1804a.setOnClickListener(new C02921(this));
    }
}
