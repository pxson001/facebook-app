package com.facebook.places.checkin.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: chaining_image_size */
public class CheckinSearchBar extends CustomFrameLayout {
    private EditText f18110a;
    private View f18111b;

    public CheckinSearchBar(Context context) {
        super(context);
    }

    public CheckinSearchBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1936073053);
        super.onFinishInflate();
        m22079a();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1256199821, a);
    }

    private void m22079a() {
        this.f18110a = (EditText) c(2131560492);
        this.f18111b = c(2131560324);
    }

    public EditText getSearchEditBox() {
        return this.f18110a;
    }

    public View getClearSearchTextButton() {
        return this.f18111b;
    }
}
