package com.facebook.growth.friendfinder.invitablecontacts;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.widget.TextView.BufferType;
import com.facebook.resources.ui.FbButton;
import com.facebook.widget.CustomViewGroup;
import com.facebook.widget.text.BetterTextView;

/* compiled from: pageAdminReply */
public class InvitableContactsItemRow extends CustomViewGroup {
    public BetterTextView f7387a = ((BetterTextView) getView(2131563282));
    public BetterTextView f7388b = ((BetterTextView) getView(2131563283));
    public FbButton f7389c = ((FbButton) getView(2131563284));

    public InvitableContactsItemRow(Context context) {
        super(context);
        setContentView(2130904971);
    }

    public final void m7714b(boolean z, CharSequence charSequence) {
        if (z) {
            this.f7388b.setText(charSequence, BufferType.SPANNABLE);
            this.f7388b.setMovementMethod(LinkMovementMethod.getInstance());
            return;
        }
        this.f7388b.setText(charSequence);
        this.f7388b.setMovementMethod(null);
    }
}
