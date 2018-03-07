package com.facebook.feedback.ui;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import com.facebook.widget.CustomFrameLayout;
import javax.annotation.Nullable;

/* compiled from: routeId */
public class NewCommentsLoadingView extends CustomFrameLayout {
    public final ProgressBar f4634a;
    public final NewCommentsPillView f4635b;

    public NewCommentsLoadingView(Context context) {
        this(context, null);
    }

    public NewCommentsLoadingView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NewCommentsLoadingView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130905432);
        this.f4634a = (ProgressBar) c(2131564208);
        this.f4635b = (NewCommentsPillView) c(2131564209);
        Drawable mutate = this.f4634a.getIndeterminateDrawable().mutate();
        mutate.setColorFilter(new PorterDuffColorFilter(-1, Mode.SRC_IN));
        this.f4634a.setIndeterminateDrawable(mutate);
    }

    public View getLoadingView() {
        return this.f4634a;
    }

    public View getPillView() {
        return this.f4635b;
    }

    public void setOnPillClickListener(OnClickListener onClickListener) {
        this.f4635b.setOnClickListener(onClickListener);
    }
}
