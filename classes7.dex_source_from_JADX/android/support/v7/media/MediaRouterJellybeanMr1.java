package android.support.v7.media;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.media.MediaRouter;
import android.media.MediaRouter.RouteInfo;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.Log;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: cta_message_sent */
final class MediaRouterJellybeanMr1 {

    /* compiled from: cta_message_sent */
    public final class ActiveScanWorkaround implements Runnable {
        private final DisplayManager f16329a;
        public final Handler f16330b;
        public Method f16331c;
        public boolean f16332d;

        public ActiveScanWorkaround(Context context, Handler handler) {
            if (VERSION.SDK_INT != 17) {
                throw new UnsupportedOperationException();
            }
            this.f16329a = (DisplayManager) context.getSystemService("display");
            this.f16330b = handler;
            try {
                this.f16331c = DisplayManager.class.getMethod("scanWifiDisplays", new Class[0]);
            } catch (NoSuchMethodException e) {
            }
        }

        public final void run() {
            if (this.f16332d) {
                try {
                    this.f16331c.invoke(this.f16329a, new Object[0]);
                } catch (Throwable e) {
                    Log.w("MediaRouterJellybeanMr1", "Cannot scan for wifi displays.", e);
                } catch (Throwable e2) {
                    Log.w("MediaRouterJellybeanMr1", "Cannot scan for wifi displays.", e2);
                }
                HandlerDetour.b(this.f16330b, this, 15000, -233295721);
            }
        }
    }

    /* compiled from: cta_message_sent */
    public interface Callback extends android.support.v7.media.MediaRouterJellybean.Callback {
        void mo1278f(Object obj);
    }

    /* compiled from: cta_message_sent */
    public class CallbackProxy<T extends Callback> extends android.support.v7.media.MediaRouterJellybean.CallbackProxy<T> {
        public CallbackProxy(T t) {
            super(t);
        }

        public void onRoutePresentationDisplayChanged(MediaRouter mediaRouter, RouteInfo routeInfo) {
            ((Callback) this.f16325a).mo1278f(routeInfo);
        }
    }

    /* compiled from: cta_message_sent */
    public final class IsConnectingWorkaround {
        private Method f16333a;
        private int f16334b;

        public IsConnectingWorkaround() {
            if (VERSION.SDK_INT != 17) {
                throw new UnsupportedOperationException();
            }
            try {
                this.f16334b = RouteInfo.class.getField("STATUS_CONNECTING").getInt(null);
                this.f16333a = RouteInfo.class.getMethod("getStatusCode", new Class[0]);
            } catch (NoSuchFieldException e) {
            } catch (NoSuchMethodException e2) {
            } catch (IllegalAccessException e3) {
            }
        }

        public final boolean m20414a(Object obj) {
            RouteInfo routeInfo = (RouteInfo) obj;
            if (this.f16333a != null) {
                try {
                    return ((Integer) this.f16333a.invoke(routeInfo, new Object[0])).intValue() == this.f16334b;
                } catch (IllegalAccessException e) {
                } catch (InvocationTargetException e2) {
                }
            }
            return false;
        }
    }

    MediaRouterJellybeanMr1() {
    }
}
