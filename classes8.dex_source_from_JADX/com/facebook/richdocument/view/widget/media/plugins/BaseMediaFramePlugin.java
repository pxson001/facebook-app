package com.facebook.richdocument.view.widget.media.plugins;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.richdocument.view.transition.MediaTransitionState;
import com.facebook.richdocument.view.transition.ViewAttribute.ViewAttributeType;
import com.facebook.richdocument.view.transition.ViewLayout;
import com.facebook.richdocument.view.transition.ViewRect;
import com.facebook.richdocument.view.transition.state.MediaStateMachine.Event;
import com.facebook.richdocument.view.widget.media.MediaFrame;
import com.facebook.richdocument.view.widget.media.MediaFrameBody;

/* compiled from: num_right_swipes */
public abstract class BaseMediaFramePlugin<T> implements InjectableComponentWithContext, MediaFramePlugin<T> {
    public final MediaFrame f7617a;

    public BaseMediaFramePlugin(MediaFrame mediaFrame) {
        this.f7617a = mediaFrame;
    }

    public boolean mo507b() {
        return true;
    }

    public void mo508c() {
    }

    public void mo509d() {
    }

    public void mo510e() {
    }

    public void mo504a(ViewLayout viewLayout) {
    }

    public void mo502a(Canvas canvas) {
    }

    public void mo503a(MediaTransitionState mediaTransitionState) {
    }

    public void mo506b(ViewLayout viewLayout) {
    }

    public boolean mo447a(Event event) {
        return false;
    }

    public void mo505a(MediaFramePlugin mediaFramePlugin, Object obj) {
    }

    protected final void m7886a(Object obj) {
        this.f7617a.mo493a(this, obj);
    }

    public Context getContext() {
        return this.f7617a.getContext();
    }

    public final ViewGroup m7893g() {
        return this.f7617a.mo480b();
    }

    public final MediaFrameBody m7894h() {
        return this.f7617a.getBody();
    }

    public final View m7895i() {
        return this.f7617a.getMediaView().getView();
    }

    public final MediaTransitionState m7896j() {
        return (MediaTransitionState) this.f7617a.getTransitionStrategy().m7206f();
    }

    public static ViewRect m7881a(ViewLayout viewLayout, View view) {
        return (ViewRect) viewLayout.mo428a(view, ViewAttributeType.RECT, ViewRect.class);
    }
}
