package com.facebook.payments.paymentmethods.picker;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.payments.paymentmethods.picker.model.AddCardRowItem;
import com.facebook.payments.picker.RowItemView;
import com.facebook.payments.ui.PaymentsComponentViewGroup;

/* compiled from: boosted_page_like_promotions */
public class AddCardRowItemView extends PaymentsComponentViewGroup implements RowItemView<AddCardRowItem> {
    public TextView f18716a = ((TextView) getView(2131559357));

    /* compiled from: boosted_page_like_promotions */
    public class C21831 implements OnClickListener {
        final /* synthetic */ AddCardRowItem f18714a;
        final /* synthetic */ AddCardRowItemView f18715b;

        public C21831(AddCardRowItemView addCardRowItemView, AddCardRowItem addCardRowItem) {
            this.f18715b = addCardRowItemView;
            this.f18714a = addCardRowItem;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1388357561);
            this.f18715b.a(this.f18714a.f18828a, this.f18714a.f18829b);
            Logger.a(2, EntryType.UI_INPUT_END, -1634500511, a);
        }
    }

    public AddCardRowItemView(Context context) {
        super(context);
        setContentView(2130903157);
    }

    public final void mo658a() {
    }
}
