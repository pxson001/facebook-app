package com.facebook.identitygrowth.profilequestion.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.fbui.widget.contentview.CheckedContentView;
import javax.annotation.Nullable;

/* compiled from: mIsMobilePushable */
public abstract class ProfileQuestionOptionItem extends CheckedContentView {
    public String f11050h;

    @Nullable
    public abstract String getOptionType();

    public ProfileQuestionOptionItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
