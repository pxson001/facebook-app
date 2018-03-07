package com.facebook.messaging.keyboard;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import com.facebook.R;
import com.facebook.messaging.permissions.PermissionRequestIconView;
import com.facebook.resources.utils.ResourceUtils;
import com.facebook.widget.CustomFrameLayout;
import javax.annotation.Nullable;

/* compiled from: is_live */
public class PermissionRequestKeyboardView extends CustomFrameLayout {
    private PermissionRequestIconView f12057a;

    public PermissionRequestKeyboardView(Context context) {
        super(context);
        m18974a(context, null);
    }

    public PermissionRequestKeyboardView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m18974a(context, attributeSet);
    }

    public PermissionRequestKeyboardView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18974a(context, attributeSet);
    }

    public void setButtonListener(OnClickListener onClickListener) {
        this.f12057a.setButtonListener(onClickListener);
    }

    private void m18974a(Context context, @Nullable AttributeSet attributeSet) {
        setContentView(2130903713);
        this.f12057a = (PermissionRequestIconView) c(2131560594);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PermissionRequestView);
        this.f12057a.setIcon(obtainStyledAttributes.getResourceId(0, -1));
        this.f12057a.setText(ResourceUtils.a(getContext(), obtainStyledAttributes, 1));
        obtainStyledAttributes.recycle();
    }
}
