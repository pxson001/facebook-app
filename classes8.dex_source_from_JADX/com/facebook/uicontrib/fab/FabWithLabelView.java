package com.facebook.uicontrib.fab;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.uicontrib.fab.FabDrawable.FabType;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: mCompanyIdentifier */
public class FabWithLabelView extends CustomLinearLayout {
    public FabView f9558a;
    public TextView f9559b;

    public FabWithLabelView(Context context) {
        super(context);
        m11239a(null);
    }

    private void m11239a(AttributeSet attributeSet) {
        setContentView(2130904184);
        this.f9558a = (FabView) a(2131561592);
        this.f9559b = (TextView) a(2131561591);
        setClickable(true);
        this.f9558a.m11238a(attributeSet);
        m11240c(attributeSet);
        m11241a();
    }

    public final void m11241a() {
        int dimensionPixelSize = this.f9558a.getType() == FabType.SMALL ? getResources().getDimensionPixelSize(2131427817) : 0;
        LayoutParams layoutParams = (LayoutParams) this.f9558a.getLayoutParams();
        layoutParams.setMargins(dimensionPixelSize, layoutParams.topMargin, dimensionPixelSize, layoutParams.bottomMargin);
        this.f9558a.setLayoutParams(layoutParams);
    }

    private void m11240c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{16843087});
        try {
            CharSequence text = obtainStyledAttributes.getText(0);
            if (text != null) {
                this.f9559b.setText(text);
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.f9558a.setOnClickListener(onClickListener);
        this.f9559b.setOnClickListener(onClickListener);
    }
}
