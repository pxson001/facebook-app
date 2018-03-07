package com.facebook.common.viewport;

import android.support.v4.util.SimpleArrayMap;
import com.facebook.controllercallbacks.api.ControllerCallback;
import com.facebook.widget.listview.ScrollingViewProxy;

@ControllerCallback
/* compiled from: photo_reminder_tap */
public interface ViewportEventListener {
    void mo1966a(SimpleArrayMap<Object, Object> simpleArrayMap);

    void mo1967a(ScrollingViewProxy scrollingViewProxy);

    void mo1968a(ScrollingViewProxy scrollingViewProxy, Object obj, int i);

    void mo1969a(ScrollingViewProxy scrollingViewProxy, Object obj, int i, int i2);

    void mo1970a(Object obj);

    void mo1971b(ScrollingViewProxy scrollingViewProxy);

    void mo1972b(ScrollingViewProxy scrollingViewProxy, Object obj, int i);

    void mo1973b(Object obj);
}
