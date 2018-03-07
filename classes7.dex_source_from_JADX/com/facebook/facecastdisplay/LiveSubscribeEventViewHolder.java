package com.facebook.facecastdisplay;

import android.support.v7.widget.RecyclerView.ViewHolder;
import com.facebook.resources.ui.FbButton;
import com.facebook.resources.ui.FbTextView;

/* compiled from: audio/raw */
public class LiveSubscribeEventViewHolder extends ViewHolder {
    public final FbTextView f18940l;
    public final FbButton f18941m;

    public LiveSubscribeEventViewHolder(LiveSubscribeEventView liveSubscribeEventView) {
        super(liveSubscribeEventView);
        this.f18940l = (FbTextView) liveSubscribeEventView.findViewById(2131563501);
        this.f18941m = (FbButton) liveSubscribeEventView.findViewById(2131563502);
    }

    public final LiveSubscribeEventView m22535w() {
        return (LiveSubscribeEventView) this.a;
    }
}
