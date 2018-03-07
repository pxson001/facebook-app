package com.facebook.pages.common.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewStub;
import com.facebook.resources.ui.FbButton;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;

/* compiled from: redesign_albums_list */
public class PagesEmptyView extends CustomLinearLayout {
    private FbTextView f2704a;
    private FbButton f2705b;
    private ViewStub f2706c;

    public PagesEmptyView(Context context) {
        super(context);
        m3648a();
    }

    public PagesEmptyView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m3648a();
    }

    protected PagesEmptyView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3648a();
    }

    private void m3648a() {
        setContentView(2130906111);
        setGravity(1);
        setOrientation(1);
        setBackgroundResource(2131361970);
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131429991);
        setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        this.f2704a = (FbTextView) a(2131565707);
        this.f2705b = (FbButton) a(2131565708);
        this.f2706c = (ViewStub) a(2131564856);
    }

    public void setImageResource(int i) {
        this.f2704a.setCompoundDrawablesWithIntrinsicBounds(0, i, 0, 0);
        this.f2704a.setVisibility(0);
    }

    public void setMessage(int i) {
        this.f2704a.setVisibility(0);
        this.f2704a.setText(i);
    }

    public void setMessage(String str) {
        this.f2704a.setVisibility(0);
        this.f2704a.setText(str);
    }

    public void setShowProgress(boolean z) {
        int i;
        int i2 = 8;
        ViewStub viewStub = this.f2706c;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        viewStub.setVisibility(i);
        FbTextView fbTextView = this.f2704a;
        if (!z) {
            i2 = 0;
        }
        fbTextView.setVisibility(i2);
    }
}
