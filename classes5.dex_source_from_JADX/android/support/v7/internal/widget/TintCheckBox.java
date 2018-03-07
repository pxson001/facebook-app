package android.support.v7.internal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;

/* compiled from: unchanged */
public class TintCheckBox extends CheckBox {
    private static final int[] f1206a = new int[]{16843015};
    private TintManager f1207b;

    public TintCheckBox(Context context) {
        this(context, null);
    }

    public TintCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842860);
    }

    public TintCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (TintManager.f1213a) {
            TintTypedArray a = TintTypedArray.m1693a(getContext(), attributeSet, f1206a, i, 0);
            setButtonDrawable(a.m1695a(0));
            a.m1698b();
            this.f1207b = a.m1700c();
        }
    }

    public void setButtonDrawable(int i) {
        if (this.f1207b != null) {
            setButtonDrawable(this.f1207b.m1690a(i));
        } else {
            super.setButtonDrawable(i);
        }
    }
}
