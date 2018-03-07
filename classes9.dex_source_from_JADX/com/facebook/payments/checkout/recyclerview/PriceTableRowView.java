package com.facebook.payments.checkout.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/* compiled from: cancel_inline_reply_dialog_event */
public class PriceTableRowView extends CustomLinearLayout {
    private BetterTextView f18549a;
    private BetterTextView f18550b;

    @Immutable
    /* compiled from: cancel_inline_reply_dialog_event */
    public class RowData {
        public final String f18546a;
        public final String f18547b;
        public final boolean f18548c;

        public RowData(String str, String str2) {
            this(str, str2, false);
        }

        public RowData(String str, String str2, boolean z) {
            this.f18546a = str;
            this.f18547b = str2;
            this.f18548c = z;
        }
    }

    public PriceTableRowView(Context context) {
        super(context);
        m18575a();
    }

    public PriceTableRowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18575a();
    }

    public PriceTableRowView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18575a();
    }

    private void m18575a() {
        setContentView(2130906374);
        this.f18549a = (BetterTextView) a(2131566219);
        this.f18550b = (BetterTextView) a(2131566220);
    }

    public void setRowData(RowData rowData) {
        this.f18549a.setText(rowData.f18546a);
        this.f18550b.setText(rowData.f18547b);
        if (rowData.f18548c) {
            this.f18549a.setTextAppearance(getContext(), 2131626345);
            this.f18550b.setTextAppearance(getContext(), 2131626345);
        }
    }
}
