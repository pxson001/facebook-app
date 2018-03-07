package com.facebook.widget.refreshableview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: reactions_dock_select_6 */
public class ConnectionRetrySnackbarView extends CustomLinearLayout {
    public ConnectionRetrySnackbarView(Context context) {
        this(context, null);
    }

    private ConnectionRetrySnackbarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setContentView(2130903754);
        setBackgroundResource(2131361953);
        setOrientation(0);
    }

    public void setRetryClickListener(OnClickListener onClickListener) {
        a(2131560689).setOnClickListener(onClickListener);
    }
}
