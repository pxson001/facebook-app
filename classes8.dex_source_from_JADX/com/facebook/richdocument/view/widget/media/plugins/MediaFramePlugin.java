package com.facebook.richdocument.view.widget.media.plugins;

import android.graphics.Canvas;
import com.facebook.richdocument.view.transition.MediaTransitionState;
import com.facebook.richdocument.view.transition.ViewLayout;
import com.facebook.richdocument.view.transition.state.MediaStateMachine;

/* compiled from: num_swipe_direction_changes */
public interface MediaFramePlugin<T> extends MediaStateMachine {
    void mo502a(Canvas canvas);

    void mo503a(MediaTransitionState mediaTransitionState);

    void mo504a(ViewLayout viewLayout);

    void mo505a(MediaFramePlugin mediaFramePlugin, Object obj);

    void mo506b(ViewLayout viewLayout);

    boolean mo507b();

    void mo508c();

    void mo509d();

    void mo510e();
}
