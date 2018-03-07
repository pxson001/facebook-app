package com.facebook.feedplugins.graphqlstory.inlinecomments;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.RecyclableView;
import com.facebook.widget.text.BetterTextView;
import com.facebook.widget.text.FakeCursorHook;
import javax.annotation.Nullable;

/* compiled from: Service connection  */
public class InlineCommentComposerView extends CustomFrameLayout implements RecyclableView {
    public FbDraweeView f23343a;
    private boolean f23344b;
    public BetterTextView f23345c;
    @Nullable
    public FakeCursorHook f23346d;

    public InlineCommentComposerView(Context context) {
        this(context, null);
    }

    private InlineCommentComposerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setContentView(2130904898);
        this.f23343a = (FbDraweeView) c(2131563133);
        this.f23345c = (BetterTextView) c(2131563134);
    }

    public void setHasBeenAttached(boolean z) {
        this.f23344b = z;
    }

    public final boolean m25689a() {
        return this.f23344b;
    }
}
