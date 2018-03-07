package com.facebook.feed.rows.permalink;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.widget.CustomFrameLayout;
import javax.annotation.Nullable;

/* compiled from: addContributors */
public class PermalinkProfilePhotoPromptView extends CustomFrameLayout {
    private View f19928a;

    public PermalinkProfilePhotoPromptView(Context context) {
        this(context, null);
    }

    private PermalinkProfilePhotoPromptView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private PermalinkProfilePhotoPromptView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130906175);
        this.f19928a = findViewById(2131565841);
    }

    public final void m23135a(@Nullable OnClickListener onClickListener) {
        this.f19928a.setOnClickListener(onClickListener);
    }
}
