package com.facebook.richdocument.view.widget.media;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.richdocument.view.transition.MediaTransitionState;
import com.facebook.richdocument.view.transition.MediaTransitionStrategy;
import com.facebook.richdocument.view.transition.TransitionListener;
import com.facebook.richdocument.view.transition.ViewLayout;
import com.facebook.richdocument.view.transition.state.MediaStateMachine;
import com.facebook.richdocument.view.util.CompositeRecyclableViewFactory.RecyclableView;
import com.facebook.richdocument.view.widget.AnnotatableView;
import com.facebook.widget.recyclerview.BetterRecyclerView.OnInterceptTouchEventListener;

/* compiled from: offer_claim */
public interface MediaFrame<V extends MediaView> extends TransitionListener, MediaStateMachine, RecyclableView, AnnotatableView, WithMediaFramePlugins, OnInterceptTouchEventListener {
    Rect mo471a(View view);

    void mo437a();

    void m7801a(View view, int i, int i2);

    void m7802a(View view, Rect rect);

    void mo478a(MediaTransitionState mediaTransitionState);

    ViewGroup mo480b();

    boolean mo481b(MediaTransitionState mediaTransitionState);

    void mo482c();

    void mo483d();

    void mo484e();

    MediaFrameBody<V> getBody();

    Context getContext();

    ViewLayout getCurrentLayout();

    V getMediaView();

    View getOverlayView();

    MediaTransitionStrategy getTransitionStrategy();

    void setBody(MediaFrameBody<V> mediaFrameBody);

    void setOverlayBackgroundColor(int i);

    void setTransitionStrategy(MediaTransitionStrategy mediaTransitionStrategy);
}
