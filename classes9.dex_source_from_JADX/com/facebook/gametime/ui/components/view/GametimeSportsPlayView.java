package com.facebook.gametime.ui.components.view;

import android.content.Context;
import android.widget.LinearLayout;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.feedback.reactions.ui.PillsBlingBarView;
import com.facebook.feedback.ui.rows.views.CommentHeaderView;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: StickerInfo */
public class GametimeSportsPlayView extends CustomFrameLayout {
    public final LinearLayout f25293a = ((LinearLayout) c(2131562499));
    public final PillsBlingBarView f25294b = ((PillsBlingBarView) c(2131562501));
    private final ContentView f25295c = ((ContentView) c(2131562500));
    public final CommentHeaderView f25296d = ((CommentHeaderView) c(2131562503));

    public GametimeSportsPlayView(Context context) {
        super(context);
        setContentView(2130904577);
    }

    public ContentView getContentView() {
        return this.f25295c;
    }
}
