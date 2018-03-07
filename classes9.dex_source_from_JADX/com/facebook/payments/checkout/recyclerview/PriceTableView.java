package com.facebook.payments.checkout.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.facebook.payments.checkout.recyclerview.PriceTableRowView.RowData;
import com.facebook.payments.ui.PaymentsComponentLinearLayout;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: cancel_flow */
public class PriceTableView extends PaymentsComponentLinearLayout {
    public PriceTableView(Context context) {
        super(context);
        m18576a();
    }

    public PriceTableView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m18576a();
    }

    public PriceTableView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18576a();
    }

    private void m18576a() {
        setOrientation(1);
    }

    public void setRowDatas(ImmutableList<RowData> immutableList) {
        removeAllViews();
        LayoutInflater from = LayoutInflater.from(getContext());
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            PriceTableRowView priceTableRowView = (PriceTableRowView) from.inflate(2130907798, this, false);
            priceTableRowView.setRowData((RowData) immutableList.get(i));
            addView(priceTableRowView);
        }
    }
}
