package com.facebook.components.widget;

import android.graphics.Picture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.Layout;
import com.facebook.fbui.widget.text.LayoutMeasureUtil;
import java.lang.ref.WeakReference;

/* compiled from: friends_you_may_invite */
public class GlyphWarmer {
    private static final String f22990a = GlyphWarmer.class.getName();
    private static GlyphWarmer f22991b;
    private WarmerHandler f22992c;

    /* compiled from: friends_you_may_invite */
    final class WarmerHandler extends Handler {
        private final Picture f22993a;

        public WarmerHandler(Looper looper) {
            Picture picture;
            super(looper);
            try {
                picture = new Picture();
            } catch (RuntimeException e) {
                picture = null;
            }
            this.f22993a = picture;
        }

        public final void handleMessage(Message message) {
            if (this.f22993a != null) {
                try {
                    Layout layout = (Layout) ((WeakReference) message.obj).get();
                    if (layout != null) {
                        layout.draw(this.f22993a.beginRecording(layout.getWidth(), LayoutMeasureUtil.m29744b(layout)));
                        this.f22993a.endRecording();
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    public static synchronized GlyphWarmer m31111a() {
        GlyphWarmer glyphWarmer;
        synchronized (GlyphWarmer.class) {
            if (f22991b == null) {
                f22991b = new GlyphWarmer();
            }
            glyphWarmer = f22991b;
        }
        return glyphWarmer;
    }

    private GlyphWarmer() {
        HandlerThread handlerThread = new HandlerThread(f22990a, 14);
        handlerThread.start();
        this.f22992c = new WarmerHandler(handlerThread.getLooper());
    }

    public final void m31112a(Layout layout) {
        this.f22992c.obtainMessage(0, new WeakReference(layout)).sendToTarget();
    }
}
