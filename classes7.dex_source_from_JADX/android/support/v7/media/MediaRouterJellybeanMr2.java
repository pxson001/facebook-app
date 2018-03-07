package android.support.v7.media;

import android.media.MediaRouter;
import android.media.MediaRouter.Callback;

/* compiled from: cta_message_send */
final class MediaRouterJellybeanMr2 {

    /* compiled from: cta_message_send */
    public final class UserRouteInfo {
        public static void m20415a(Object obj, CharSequence charSequence) {
            ((android.media.MediaRouter.UserRouteInfo) obj).setDescription(charSequence);
        }
    }

    MediaRouterJellybeanMr2() {
    }

    public static Object m20416a(Object obj) {
        return ((MediaRouter) obj).getDefaultRoute();
    }

    public static void m20417a(Object obj, int i, Object obj2, int i2) {
        ((MediaRouter) obj).addCallback(i, (Callback) obj2, i2);
    }
}
