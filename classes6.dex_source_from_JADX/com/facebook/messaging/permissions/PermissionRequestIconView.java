package com.facebook.messaging.permissions;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import com.facebook.R;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.resources.utils.ResourceUtils;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;

/* compiled from: is_expanded */
public class PermissionRequestIconView extends CustomFrameLayout {
    private GlyphView f12093a;
    private BetterTextView f12094b;
    private BetterTextView f12095c;

    public PermissionRequestIconView(Context context) {
        super(context);
        m19032a(context, null);
    }

    public PermissionRequestIconView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m19032a(context, attributeSet);
    }

    public PermissionRequestIconView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m19032a(context, attributeSet);
    }

    public void setButtonListener(OnClickListener onClickListener) {
        this.f12095c.setOnClickListener(onClickListener);
    }

    public void setIcon(int i) {
        if (i == -1) {
            this.f12093a.setVisibility(8);
            return;
        }
        this.f12093a.setImageDrawable(getResources().getDrawable(i));
        this.f12093a.setVisibility(0);
    }

    public void setText(String str) {
        this.f12094b.setText(str);
    }

    private void m19032a(Context context, @Nullable AttributeSet attributeSet) {
        setContentView(2130906176);
        this.f12093a = (GlyphView) c(2131563548);
        this.f12094b = (BetterTextView) c(2131563549);
        this.f12095c = (BetterTextView) c(2131563550);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PermissionRequestView);
        setIcon(obtainStyledAttributes.getResourceId(0, -1));
        setText(ResourceUtils.a(getContext(), obtainStyledAttributes, 1));
        obtainStyledAttributes.recycle();
    }
}
