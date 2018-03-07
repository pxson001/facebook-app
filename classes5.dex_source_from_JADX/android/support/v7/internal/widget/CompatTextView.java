package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.internal.text.AllCapsTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import com.facebook.R;

/* compiled from: upsellDeclineButtonLabel */
public class CompatTextView extends TextView {
    public CompatTextView(Context context) {
        this(context, null);
    }

    public CompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CompatTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CompatTextView, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        if (resourceId != -1) {
            obtainStyledAttributes = context.obtainStyledAttributes(resourceId, R.styleable.TextAppearance);
            if (obtainStyledAttributes.hasValue(10)) {
                setAllCaps(obtainStyledAttributes.getBoolean(10, false));
            }
            obtainStyledAttributes.recycle();
        }
        obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CompatTextView, i, 0);
        if (obtainStyledAttributes.hasValue(1)) {
            setAllCaps(obtainStyledAttributes.getBoolean(1, false));
        }
        obtainStyledAttributes.recycle();
    }

    public void setAllCaps(boolean z) {
        setTransformationMethod(z ? new AllCapsTransformationMethod(getContext()) : null);
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, R.styleable.TextAppearance);
        if (obtainStyledAttributes.hasValue(10)) {
            setAllCaps(obtainStyledAttributes.getBoolean(10, false));
        }
        obtainStyledAttributes.recycle();
    }
}
