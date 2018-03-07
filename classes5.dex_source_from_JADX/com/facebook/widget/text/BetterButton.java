package com.facebook.widget.text;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.facebook.R;
import com.facebook.resources.ui.FbButton;
import com.facebook.widget.text.CustomFontHelper.FontFamily;
import com.facebook.widget.text.CustomFontHelper.FontWeight;

/* compiled from: com.facebook.messaging.annotations.ForSecureIntentHandlerActivity */
public class BetterButton extends FbButton {
    public BetterButton(Context context) {
        this(context, null);
    }

    public BetterButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10592a(context, attributeSet);
    }

    public BetterButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10592a(context, attributeSet);
    }

    private void m10592a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BetterButton);
        CustomFontHelper.a(this, FontFamily.fromIndex(obtainStyledAttributes.getInt(0, 0)), FontWeight.fromIndex(obtainStyledAttributes.getInt(1, FontWeight.BUILTIN.ordinal())), getTypeface());
        if (obtainStyledAttributes.getBoolean(2, false)) {
            setTransformationMethod(new AllCapsTransformationMethod(context));
        }
        obtainStyledAttributes.recycle();
    }
}
