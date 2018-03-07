package com.facebook.richdocument.view.widget.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.richdocument.model.block.VideoControlAnnotation;
import com.facebook.richdocument.view.widget.AnnotationView;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.base.MoreObjects;
import java.util.EnumMap;
import java.util.Map.Entry;

/* compiled from: nullstate_header */
public class VideoControlsView extends CustomFrameLayout implements AnnotationView<VideoControlAnnotation> {
    public VideoControlAnnotation f7737a;
    private final EnumMap<State, View> f7738b;
    private State f7739c;

    /* compiled from: nullstate_header */
    public enum State {
        PLAY_ICON,
        PAUSE_ICON,
        NONE
    }

    public VideoControlsView(Context context) {
        this(context, null);
    }

    public VideoControlsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoControlsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7738b = new EnumMap(State.class);
        this.f7739c = State.NONE;
        this.f7737a = new VideoControlAnnotation();
        setContentView(2130906887);
        this.f7738b.put(State.PLAY_ICON, c(2131567050));
        this.f7738b.put(State.PAUSE_ICON, c(2131567051));
        for (View visibility : this.f7738b.values()) {
            visibility.setVisibility(8);
        }
        m8012a(State.NONE, false);
    }

    public VideoControlAnnotation getAnnotation() {
        return this.f7737a;
    }

    public final View mo438b() {
        return this;
    }

    public void setIsOverlay(boolean z) {
    }

    public final boolean mo439c() {
        return false;
    }

    public State getCurrentState() {
        return this.f7739c;
    }

    public final void m8012a(State state, boolean z) {
        this.f7739c = (State) MoreObjects.firstNonNull(state, State.NONE);
        for (Entry entry : this.f7738b.entrySet()) {
            View view = (View) entry.getValue();
            if (entry.getKey() == this.f7739c) {
                view.setVisibility(0);
                ((VideoControlIcon) view).setLoading(z);
            } else {
                view.setVisibility(8);
            }
        }
        invalidate();
    }

    public final void m8011a() {
        if (this.f7739c != State.NONE) {
            ((VideoControlIcon) this.f7738b.get(this.f7739c)).m7429d();
        }
    }

    public final void m8015e() {
        for (View view : this.f7738b.values()) {
            ((VideoControlIcon) view).setLoading(false);
        }
    }

    public static VideoControlsView m8010a(Context context, ViewGroup viewGroup) {
        return (VideoControlsView) LayoutInflater.from(context).inflate(2130906886, viewGroup, false);
    }
}
