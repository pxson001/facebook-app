package com.facebook.fbreact.search;

import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriber;

/* compiled from: sprout_cancel_reason */
public class ReactSearchEvents {

    /* compiled from: sprout_cancel_reason */
    public abstract class ReactSearchEvent implements FbEvent {
    }

    /* compiled from: sprout_cancel_reason */
    public class LaunchReachSearchResultEvent extends ReactSearchEvent {
        public final int f3522a;
        public final String f3523b;
        public final String f3524c;

        public LaunchReachSearchResultEvent(int i, String str, String str2) {
            this.f3522a = i;
            this.f3523b = str;
            this.f3524c = str2;
        }
    }

    /* compiled from: sprout_cancel_reason */
    public abstract class ReactSearchEventSubscriber<T extends ReactSearchEvent> extends FbEventSubscriber<T> {
    }

    /* compiled from: sprout_cancel_reason */
    public abstract class LaunchReachSearchResultEventSubscriber extends ReactSearchEventSubscriber<LaunchReachSearchResultEvent> {
        public final Class<LaunchReachSearchResultEvent> m4214a() {
            return LaunchReachSearchResultEvent.class;
        }
    }

    /* compiled from: sprout_cancel_reason */
    public class LaunchReachSearchResultEventSubscriberImpl extends LaunchReachSearchResultEventSubscriber {
        private final ReactNativeInfoHandler f3525a;

        public final void m4215b(FbEvent fbEvent) {
            LaunchReachSearchResultEvent launchReachSearchResultEvent = (LaunchReachSearchResultEvent) fbEvent;
            if (launchReachSearchResultEvent.f3522a == this.f3525a.m4216a()) {
                this.f3525a.m4218a(launchReachSearchResultEvent.f3523b, launchReachSearchResultEvent.f3524c);
            }
        }

        public LaunchReachSearchResultEventSubscriberImpl(ReactNativeInfoHandler reactNativeInfoHandler) {
            this.f3525a = reactNativeInfoHandler;
        }
    }

    /* compiled from: sprout_cancel_reason */
    public interface ReactNativeInfoHandler {
        int m4216a();

        void m4217a(String str);

        void m4218a(String str, String str2);
    }

    /* compiled from: sprout_cancel_reason */
    public class ResignKeyboardEvent extends ReactSearchEvent {
        public final int f3526a;

        public ResignKeyboardEvent(int i) {
            this.f3526a = i;
        }
    }

    /* compiled from: sprout_cancel_reason */
    public abstract class ResignKeyboardEventSubscriber extends ReactSearchEventSubscriber<ResignKeyboardEvent> {
        public final Class<ResignKeyboardEvent> m4219a() {
            return ResignKeyboardEvent.class;
        }
    }

    /* compiled from: sprout_cancel_reason */
    public class UpdateSearcyQueryEvent extends ReactSearchEvent {
        public final int f3527a;
        public final String f3528b;

        public UpdateSearcyQueryEvent(int i, String str) {
            this.f3527a = i;
            this.f3528b = str;
        }
    }

    /* compiled from: sprout_cancel_reason */
    public abstract class UpdateSearcyQueryEventSubscriber extends ReactSearchEventSubscriber<UpdateSearcyQueryEvent> {
        public final Class<UpdateSearcyQueryEvent> m4220a() {
            return UpdateSearcyQueryEvent.class;
        }
    }

    /* compiled from: sprout_cancel_reason */
    public class UpdateSearcyQueryEventSubscriberImpl extends UpdateSearcyQueryEventSubscriber {
        private final ReactNativeInfoHandler f3529a;

        public final void m4221b(FbEvent fbEvent) {
            UpdateSearcyQueryEvent updateSearcyQueryEvent = (UpdateSearcyQueryEvent) fbEvent;
            if (updateSearcyQueryEvent.f3527a == this.f3529a.m4216a()) {
                this.f3529a.m4217a(updateSearcyQueryEvent.f3528b);
            }
        }

        public UpdateSearcyQueryEventSubscriberImpl(ReactNativeInfoHandler reactNativeInfoHandler) {
            this.f3529a = reactNativeInfoHandler;
        }
    }
}
