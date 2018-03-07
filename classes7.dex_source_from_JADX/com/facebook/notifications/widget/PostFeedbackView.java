package com.facebook.notifications.widget;

import android.content.Context;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;
import com.facebook.widget.text.ExpandedTouchLinkMovementMethod;

/* compiled from: method/app_rater.create */
public class PostFeedbackView extends CustomLinearLayout {
    private BetterTextView f9052a;
    public ImageButton f9053b;

    public PostFeedbackView(Context context) {
        this(context, null);
    }

    public PostFeedbackView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10878b();
    }

    private void m10878b() {
        setContentView(2130906350);
        this.f9052a = (BetterTextView) findViewById(2131566188);
        this.f9053b = (ImageButton) findViewById(2131566189);
    }

    public ImageButton getChevronButton() {
        return this.f9053b;
    }

    public void setChevronClickListener(OnClickListener onClickListener) {
        this.f9053b.setOnClickListener(onClickListener);
    }

    public void setChevronVisibility(boolean z) {
        this.f9053b.setVisibility(z ? 0 : 4);
    }

    public final boolean m10879a() {
        return this.f9053b.getVisibility() == 0;
    }

    public void setText(String str) {
        this.f9052a.setText(str);
    }

    public void setText(SpannableString spannableString) {
        this.f9052a.setText(spannableString);
        this.f9052a.setMovementMethod(ExpandedTouchLinkMovementMethod.b);
    }
}
