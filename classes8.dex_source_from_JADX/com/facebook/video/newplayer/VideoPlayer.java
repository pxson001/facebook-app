package com.facebook.video.newplayer;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.common.eventbus.TypedEventBus;
import com.facebook.video.api.UserReason;
import com.facebook.video.api.Video;
import com.facebook.video.api.Video.State;
import com.facebook.video.api.VideoMetadata;

/* compiled from: location_settings_device_settings_click */
public class VideoPlayer<SourceType> extends FrameLayout implements Video<SourceType> {
    private final View f9787a;
    private final Video<SourceType> f9788b;

    /* compiled from: location_settings_device_settings_click */
    public abstract class Plugin {
        public VideoPlayer<?> f9783a;

        public abstract void mo622a(TypedEventBus typedEventBus, FrameLayout frameLayout);
    }

    public VideoPlayer(Context context, View view, Video<SourceType> video) {
        super(context);
        this.f9787a = view;
        this.f9788b = video;
        this.f9787a.setLayoutParams(new LayoutParams(-1, -1));
        addView(this.f9787a);
    }

    public State getCurrentState() {
        return this.f9788b.getCurrentState();
    }

    public TypedEventBus getEventBus() {
        return this.f9788b.getEventBus();
    }

    public void setSource(SourceType sourceType) {
        this.f9788b.setSource(sourceType);
    }

    public SourceType getSource() {
        return this.f9788b.getSource();
    }

    public void setPosition(int i) {
        this.f9788b.setPosition(i);
    }

    public final void m11484a(UserReason userReason) {
        this.f9788b.a(userReason);
    }

    public final void m11485b(UserReason userReason) {
        this.f9788b.b(userReason);
    }

    public VideoMetadata getMetadata() {
        return this.f9788b.getMetadata();
    }

    public int getPosition() {
        return this.f9788b.getPosition();
    }
}
