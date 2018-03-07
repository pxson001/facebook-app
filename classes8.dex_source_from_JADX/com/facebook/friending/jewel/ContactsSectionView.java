package com.facebook.friending.jewel;

import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import com.facebook.R;
import com.facebook.fbui.facepile.FacepileView;
import com.facebook.resources.ui.FbButton;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: following */
public class ContactsSectionView extends CustomLinearLayout {
    private FacepileView f13120a;
    private FbTextView f13121b;
    private FbButton f13122c;
    private boolean f13123d;

    public ContactsSectionView(Context context) {
        super(context);
        m14782a(context, null, 2130772407);
    }

    public ContactsSectionView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m14782a(context, attributeSet, 2130772407);
    }

    protected ContactsSectionView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14782a(context, attributeSet, i);
    }

    private void m14782a(Context context, @Nullable AttributeSet attributeSet, int i) {
        setContentView(2130903777);
        this.f13120a = (FacepileView) a(2131560732);
        this.f13121b = (FbTextView) a(2131560733);
        this.f13122c = (FbButton) a(2131560734);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ContactsSectionView, i, 0);
        this.f13123d = obtainStyledAttributes.getBoolean(5, false);
        if (obtainStyledAttributes.hasValue(4)) {
            setActionButtonText(obtainStyledAttributes.getResourceId(4, 0));
        }
        setPadding(obtainStyledAttributes.getDimensionPixelSize(0, 0), obtainStyledAttributes.getDimensionPixelSize(1, 0), obtainStyledAttributes.getDimensionPixelSize(2, 0), obtainStyledAttributes.getDimensionPixelSize(3, 0));
        obtainStyledAttributes.recycle();
    }

    public void setFaceUrls(List<Uri> list) {
        this.f13120a.setFaceUrls(list);
    }

    public void setText(CharSequence charSequence) {
        this.f13121b.setText(charSequence);
    }

    public void setActionButtonOnClickListener(OnClickListener onClickListener) {
        this.f13122c.setOnClickListener(onClickListener);
    }

    public void setActionButtonText(int i) {
        setActionButtonText(getResources().getString(i));
    }

    public void setActionButtonText(CharSequence charSequence) {
        if (this.f13123d) {
            charSequence = charSequence.toString().toUpperCase(getResources().getConfiguration().locale);
        }
        this.f13122c.setText(charSequence);
    }
}
