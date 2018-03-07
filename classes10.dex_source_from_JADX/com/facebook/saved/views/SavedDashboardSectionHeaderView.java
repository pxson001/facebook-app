package com.facebook.saved.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.facebook.saved.data.SavedDashboardListSectionHeader;
import com.facebook.widget.CustomRelativeLayout;
import javax.annotation.Nonnull;

/* compiled from: instant_shopping_element_impression */
public class SavedDashboardSectionHeaderView extends CustomRelativeLayout {
    private TextView f9357a;

    public SavedDashboardSectionHeaderView(Context context) {
        super(context);
        m9512a();
    }

    public SavedDashboardSectionHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m9512a();
    }

    public SavedDashboardSectionHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m9512a();
    }

    private void m9512a() {
        setContentView(2130906956);
        this.f9357a = (TextView) a(2131567235);
    }

    public final void m9513a(@Nonnull SavedDashboardListSectionHeader savedDashboardListSectionHeader) {
        this.f9357a.setText(savedDashboardListSectionHeader.f9120a);
    }
}
