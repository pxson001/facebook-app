package com.facebook.facecastdisplay;

import android.view.ViewStub;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.springbutton.SpringScaleButton;

/* compiled from: styleList == null */
public class LiveCommentEventViewHolder extends LiveEventAvatarViewHolder {
    public final FbTextView f2867l;
    public final SpringScaleButton f2868m;
    public final ViewStub f2869n;

    public LiveCommentEventViewHolder(LiveCommentEventView liveCommentEventView) {
        super(liveCommentEventView);
        this.f2867l = (FbTextView) liveCommentEventView.findViewById(2131563462);
        this.f2868m = (SpringScaleButton) liveCommentEventView.findViewById(2131563461);
        this.f2869n = (ViewStub) liveCommentEventView.findViewById(2131563460);
    }

    public final LiveCommentEventView m3155w() {
        return (LiveCommentEventView) this.a;
    }
}
