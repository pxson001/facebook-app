package android.support.v7.internal.widget;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.widget.ImageView;

/* compiled from: unauthClient */
public class TintImageView extends ImageView {
    private static final int[] f1209a = new int[]{16842964, 16843033};
    private final TintManager f1210b;

    public TintImageView(Context context) {
        this(context, null);
    }

    public TintImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TintImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TintTypedArray a = TintTypedArray.m1693a(getContext(), attributeSet, f1209a, i, 0);
        if (a.f1229b.length() > 0) {
            if (a.m1702d(0)) {
                setBackgroundDrawable(a.m1695a(0));
            }
            if (a.m1702d(1)) {
                setImageDrawable(a.m1695a(1));
            }
        }
        a.m1698b();
        this.f1210b = a.m1700c();
    }

    public void setImageResource(@DrawableRes int i) {
        setImageDrawable(this.f1210b.m1690a(i));
    }
}
