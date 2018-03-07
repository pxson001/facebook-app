package com.facebook.friendsharing.meme.prompt;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.feed.inlinecomposer.multirow.common.views.HasPhotoTray;
import com.facebook.feed.photoreminder.common.ScrollingImagePromptView;
import javax.annotation.Nullable;

/* compiled from: Retrieved Box is not a valid FaceBox */
public class MemePromptScrollingView extends ScrollingImagePromptView implements HasPhotoTray {
    private boolean f23977b = false;
    private boolean f23978c;

    public MemePromptScrollingView(Context context) {
        super(context);
        mo1467b();
    }

    public MemePromptScrollingView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        mo1467b();
    }

    public MemePromptScrollingView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        mo1467b();
    }

    protected int getImageTrayHeight() {
        return getResources().getDimensionPixelSize(2131432477);
    }

    protected void setIsAnimationRunning(boolean z) {
        this.f23977b = z;
    }

    protected final boolean mo1472h() {
        return this.f23977b;
    }

    protected void setHasBeenShown(boolean z) {
        this.f23978c = z;
    }

    protected final boolean mo1470g() {
        return this.f23978c;
    }
}
