package com.facebook.payments.paymentmethods.picker;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.facebook.payments.picker.RowItemViewFactory;
import com.facebook.payments.picker.model.RowItem;
import com.facebook.payments.picker.model.RowType;
import com.facebook.payments.ui.SimplePaymentsComponentCallback;
import javax.inject.Inject;

/* compiled from: bookmark_pic */
public class PickerScreenAdapter extends ArrayAdapter<RowItem> {
    public final SimplePickerScreenManager f18772a;
    public SimplePaymentsComponentCallback f18773b;
    public RowItemViewFactory f18774c;

    @Inject
    public PickerScreenAdapter(Context context, SimplePickerScreenManager simplePickerScreenManager) {
        super(context, 0);
        this.f18772a = simplePickerScreenManager;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return this.f18774c.mo651a(this.f18773b, (RowItem) getItem(i), view, viewGroup);
    }

    public boolean isEnabled(int i) {
        return ((RowItem) getItem(i)).mo657a().isSelectable();
    }

    public int getViewTypeCount() {
        return RowType.values().length;
    }

    public boolean areAllItemsEnabled() {
        return false;
    }

    public int getItemViewType(int i) {
        return ((RowItem) getItem(i)).mo657a().ordinal();
    }
}
