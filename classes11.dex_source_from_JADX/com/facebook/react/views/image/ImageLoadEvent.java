package com.facebook.react.views.image;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.Nullable;

/* compiled from: SECONDARY_ACTION_BUTTON_GLYPH */
public class ImageLoadEvent extends Event<ImageLoadEvent> {
    private final int f11436a;
    @Nullable
    private final String f11437b;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: SECONDARY_ACTION_BUTTON_GLYPH */
    @interface ImageEventType {
    }

    public ImageLoadEvent(int i, long j, int i2) {
        this(i, j, i2, null);
    }

    private ImageLoadEvent(int i, long j, int i2, @Nullable String str) {
        super(i, j);
        this.f11436a = i2;
        this.f11437b = str;
    }

    public static String m11840a(int i) {
        switch (i) {
            case 1:
                return "topError";
            case 2:
                return "topLoad";
            case 3:
                return "topLoadEnd";
            case 4:
                return "topLoadStart";
            case 5:
                return "topProgress";
            default:
                throw new IllegalStateException("Invalid image event: " + Integer.toString(i));
        }
    }

    public final String m11842b() {
        return m11840a(this.f11436a);
    }

    public final short m11843f() {
        return (short) this.f11436a;
    }

    public final void m11841a(RCTEventEmitter rCTEventEmitter) {
        WritableMap writableMap = null;
        if (this.f11437b != null) {
            writableMap = Arguments.b();
            writableMap.putString("uri", this.f11437b);
        }
        rCTEventEmitter.receiveEvent(this.c, b(), writableMap);
    }
}
