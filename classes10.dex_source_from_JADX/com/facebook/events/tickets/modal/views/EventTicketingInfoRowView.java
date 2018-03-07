package com.facebook.events.tickets.modal.views;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.resources.ui.FbTextView;
import com.google.common.base.Strings;
import javax.annotation.Nullable;

/* compiled from: application_requests */
public class EventTicketingInfoRowView extends EventTicketingLinearLayout {
    public FbTextView f19365a;
    public FbTextView f19366c;
    public FbTextView f19367d;

    public EventTicketingInfoRowView(Context context) {
        super(context);
        m19516a();
    }

    public EventTicketingInfoRowView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m19516a();
    }

    public EventTicketingInfoRowView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m19516a();
    }

    private void m19516a() {
        setContentView(2130903997);
        this.f19365a = (FbTextView) a(2131561212);
        this.f19366c = (FbTextView) a(2131561213);
        this.f19367d = (FbTextView) a(2131561214);
    }

    public static void m19517a(FbTextView fbTextView, @Nullable String str) {
        if (Strings.isNullOrEmpty(str)) {
            fbTextView.setVisibility(8);
            return;
        }
        fbTextView.setText(str);
        fbTextView.setVisibility(0);
    }
}
