package com.facebook.video.newplayer;

import android.net.Uri;
import android.widget.FrameLayout;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.eventbus.TypedEventBus;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.video.api.VideoEvents.BufferingEndEvent;
import com.facebook.video.api.VideoEvents.BufferingEndEvent.Handler;
import com.facebook.video.api.VideoEvents.PausingEvent;
import com.facebook.video.newplayer.VideoPlayer.Plugin;
import com.google.common.base.Objects;

/* compiled from: location_settings_learn_more */
public class CoverImagePlugin extends Plugin {
    private static final CallerContext f9784a = CallerContext.a(CoverImagePlugin.class);
    public FbDraweeView f9785b;
    private Uri f9786c;

    /* compiled from: location_settings_learn_more */
    class EventsHandler implements Handler, PausingEvent.Handler {
        final /* synthetic */ CoverImagePlugin f9782a;

        public EventsHandler(CoverImagePlugin coverImagePlugin) {
            this.f9782a = coverImagePlugin;
        }

        public final void m11478a(BufferingEndEvent bufferingEndEvent) {
            this.f9782a.f9785b.setVisibility(8);
        }

        public final void m11479a(PausingEvent pausingEvent) {
            this.f9782a.f9785b.setVisibility(0);
        }
    }

    public final void m11482a(Uri uri) {
        if (!Objects.equal(this.f9786c, uri)) {
            this.f9786c = uri;
            m11481a();
        }
    }

    private void m11481a() {
        if (this.f9785b != null) {
            this.f9785b.a(this.f9786c, f9784a);
        }
    }

    protected final void mo622a(TypedEventBus typedEventBus, FrameLayout frameLayout) {
        this.f9785b = new FbDraweeView(frameLayout.getContext());
        m11481a();
        frameLayout.addView(this.f9785b);
        EventsHandler eventsHandler = new EventsHandler(this);
        typedEventBus.a(BufferingEndEvent.class, eventsHandler);
        typedEventBus.a(PausingEvent.class, eventsHandler);
    }
}
