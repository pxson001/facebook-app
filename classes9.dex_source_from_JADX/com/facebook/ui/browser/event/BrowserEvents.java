package com.facebook.ui.browser.event;

import android.webkit.WebView;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import java.util.Set;

/* compiled from: tmp_camera_file */
public class BrowserEvents {

    /* compiled from: tmp_camera_file */
    public class BrowserActivityOnActivityCreateEvent extends BrowserEvent {
    }

    /* compiled from: tmp_camera_file */
    public class BrowserActivityOnPauseEvent extends BrowserEvent {
    }

    /* compiled from: tmp_camera_file */
    public class OnFinishEvent extends BrowserEvent {
    }

    /* compiled from: tmp_camera_file */
    public abstract class OnFinishEventSubscriber extends BrowserEventSubscriber<OnFinishEvent> {
        public final Class<OnFinishEvent> m1601a() {
            return OnFinishEvent.class;
        }
    }

    /* compiled from: tmp_camera_file */
    public class OnHandleBackButtonPressEvent extends BrowserEvent {
    }

    /* compiled from: tmp_camera_file */
    public abstract class OnHandleBackButtonPressEventSubscriber extends BrowserEventSubscriber<OnHandleBackButtonPressEvent> {
        public final Class<OnHandleBackButtonPressEvent> m1602a() {
            return OnHandleBackButtonPressEvent.class;
        }
    }

    /* compiled from: tmp_camera_file */
    public class OnPageFinishedEvent extends BrowserEvent {
        public WebView f1526a;
        public String f1527b;
    }

    /* compiled from: tmp_camera_file */
    public abstract class OnPageFinishedEventSubscriber extends BrowserEventSubscriber<OnPageFinishedEvent> {
        public final Class<OnPageFinishedEvent> m1603a() {
            return OnPageFinishedEvent.class;
        }
    }

    /* compiled from: tmp_camera_file */
    public class OnPageStartedEvent extends BrowserEvent {
        public WebView f1528a;
        public String f1529b;
    }

    /* compiled from: tmp_camera_file */
    public class OnPauseEvent extends BrowserEvent {
    }

    /* compiled from: tmp_camera_file */
    public abstract class OnPauseEventSubscriber extends BrowserEventSubscriber<OnPauseEvent> {
        public final Class<OnPauseEvent> m1604a() {
            return OnPauseEvent.class;
        }
    }

    /* compiled from: tmp_camera_file */
    public class OnResumeEvent extends BrowserEvent {
    }

    /* compiled from: tmp_camera_file */
    public abstract class OnResumeEventSubscriber extends BrowserEventSubscriber<OnResumeEvent> {
        public final Class<OnResumeEvent> m1605a() {
            return OnResumeEvent.class;
        }
    }

    /* compiled from: tmp_camera_file */
    public class OnScrollChangedEvent extends BrowserEvent {
        public String f1530a;
        public boolean f1531b;
        private Map<MAP_KEYS, Object> f1532c;

        /* compiled from: tmp_camera_file */
        public enum MAP_KEYS {
            SCROLL_LOGGING_DATA,
            URLS_EQUAL
        }

        public final ImmutableMap<MAP_KEYS, Object> m1606c() {
            return ImmutableMap.copyOf(this.f1532c);
        }
    }

    /* compiled from: tmp_camera_file */
    public abstract class OnScrollChangedEventSubscriber extends BrowserEventSubscriber<OnScrollChangedEvent> {
        public final Class<OnScrollChangedEvent> m1607a() {
            return OnScrollChangedEvent.class;
        }
    }

    /* compiled from: tmp_camera_file */
    public class ShouldOverrideUrlLoadingEvent extends BrowserEvent {
        public Set<ACTIVE_LOGGERS> f1533a;

        /* compiled from: tmp_camera_file */
        public enum ACTIVE_LOGGERS {
            X_OUT_ANALYTICS_LOGGER,
            LONG_CLICK_BROWSER
        }
    }

    /* compiled from: tmp_camera_file */
    public abstract class ShouldOverrideUrlLoadingEventSubscriber extends BrowserEventSubscriber<ShouldOverrideUrlLoadingEvent> {
        public final Class<ShouldOverrideUrlLoadingEvent> m1608a() {
            return ShouldOverrideUrlLoadingEvent.class;
        }
    }

    /* compiled from: tmp_camera_file */
    public abstract class onPageStartedEventSubscriber extends BrowserEventSubscriber<OnPageStartedEvent> {
        public final Class<OnPageStartedEvent> m1609a() {
            return OnPageStartedEvent.class;
        }
    }
}
