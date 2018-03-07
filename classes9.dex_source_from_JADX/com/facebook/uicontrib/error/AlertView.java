package com.facebook.uicontrib.error;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import com.facebook.resources.ui.EllipsizingTextView;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.LazyView;
import com.facebook.widget.text.BetterTextView;

/* compiled from: timestamp_in_folder_ms */
public class AlertView extends CustomLinearLayout {
    private LazyView<FbTextView> f1665a;
    private LazyView<BetterTextView> f1666b;
    private FbTextView f1667c;
    private EllipsizingTextView f1668d;
    private BetterTextView f1669e;
    private BetterTextView f1670f;
    private Resources f1671g;

    public AlertView(Context context) {
        super(context);
        m1693a();
    }

    public AlertView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m1693a();
    }

    public AlertView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m1693a();
    }

    private void m1693a() {
        setContentView(2130903241);
        this.f1665a = new LazyView((ViewStub) findViewById(2131559562));
        this.f1666b = new LazyView((ViewStub) findViewById(2131559564));
        this.f1668d = (EllipsizingTextView) a(2131559563);
        this.f1669e = (BetterTextView) a(2131559565);
        this.f1671g = getContext().getResources();
    }

    public void setTitle(int i) {
        setTitle(this.f1671g.getString(i));
    }

    public void setTitle(CharSequence charSequence) {
        this.f1667c = (FbTextView) this.f1665a.a();
        if (this.f1667c != null) {
            this.f1667c.setVisibility(0);
            this.f1667c.setText(charSequence);
        }
    }

    public void setMessage(int i) {
        setMessage(this.f1671g.getString(i));
    }

    public void setMessage(CharSequence charSequence) {
        this.f1668d.setText(charSequence);
    }

    public void setPrimaryButtonText(int i) {
        setPrimaryButtonText(this.f1671g.getString(i));
    }

    public void setPrimaryButtonText(String str) {
        this.f1669e.setText(str);
    }

    public void setPrimaryButtonClickListener(OnClickListener onClickListener) {
        this.f1669e.setOnClickListener(onClickListener);
    }

    public void setSecondaryButtonText(int i) {
        setSecondaryButtonText(this.f1671g.getString(i));
    }

    public void setSecondaryButtonText(String str) {
        this.f1670f = (BetterTextView) this.f1666b.a();
        if (this.f1670f != null) {
            this.f1670f.setVisibility(0);
            this.f1670f.setText(str);
        }
    }

    public void setSecondaryButtonClickListener(OnClickListener onClickListener) {
        this.f1670f = (BetterTextView) this.f1666b.a();
        if (this.f1670f != null) {
            this.f1670f.setOnClickListener(onClickListener);
        }
    }
}
