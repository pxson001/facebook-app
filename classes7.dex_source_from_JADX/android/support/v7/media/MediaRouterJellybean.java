package android.support.v7.media;

import android.media.MediaRouter;
import android.media.MediaRouter.RouteCategory;
import android.media.MediaRouter.RouteGroup;
import android.media.MediaRouter.RouteInfo;
import android.os.Build.VERSION;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ctts */
final class MediaRouterJellybean {

    /* compiled from: ctts */
    public interface Callback {
        void mo1266a(Object obj);

        void mo1269b(Object obj);

        void mo1272c(Object obj);

        void mo1274d(Object obj);

        void mo1275e(Object obj);
    }

    /* compiled from: ctts */
    public class CallbackProxy<T extends Callback> extends android.media.MediaRouter.Callback {
        protected final T f16325a;

        public CallbackProxy(T t) {
            this.f16325a = t;
        }

        public void onRouteSelected(MediaRouter mediaRouter, int i, RouteInfo routeInfo) {
            this.f16325a.mo1266a(routeInfo);
        }

        public void onRouteUnselected(MediaRouter mediaRouter, int i, RouteInfo routeInfo) {
        }

        public void onRouteAdded(MediaRouter mediaRouter, RouteInfo routeInfo) {
            this.f16325a.mo1269b(routeInfo);
        }

        public void onRouteRemoved(MediaRouter mediaRouter, RouteInfo routeInfo) {
            this.f16325a.mo1272c(routeInfo);
        }

        public void onRouteChanged(MediaRouter mediaRouter, RouteInfo routeInfo) {
            this.f16325a.mo1274d(routeInfo);
        }

        public void onRouteGrouped(MediaRouter mediaRouter, RouteInfo routeInfo, RouteGroup routeGroup, int i) {
        }

        public void onRouteUngrouped(MediaRouter mediaRouter, RouteInfo routeInfo, RouteGroup routeGroup) {
        }

        public void onRouteVolumeChanged(MediaRouter mediaRouter, RouteInfo routeInfo) {
            this.f16325a.mo1275e(routeInfo);
        }
    }

    /* compiled from: ctts */
    public final class GetDefaultRouteWorkaround {
        private Method f16326a;

        public GetDefaultRouteWorkaround() {
            if (VERSION.SDK_INT < 16 || VERSION.SDK_INT > 17) {
                throw new UnsupportedOperationException();
            }
            try {
                this.f16326a = MediaRouter.class.getMethod("getSystemAudioRoute", new Class[0]);
            } catch (NoSuchMethodException e) {
            }
        }

        public final Object m20397a(Object obj) {
            MediaRouter mediaRouter = (MediaRouter) obj;
            if (this.f16326a != null) {
                try {
                    return this.f16326a.invoke(mediaRouter, new Object[0]);
                } catch (IllegalAccessException e) {
                } catch (InvocationTargetException e2) {
                }
            }
            return mediaRouter.getRouteAt(0);
        }
    }

    /* compiled from: ctts */
    public final class SelectRouteWorkaround {
        private Method f16327a;

        public SelectRouteWorkaround() {
            if (VERSION.SDK_INT < 16 || VERSION.SDK_INT > 17) {
                throw new UnsupportedOperationException();
            }
            try {
                this.f16327a = MediaRouter.class.getMethod("selectRouteInt", new Class[]{Integer.TYPE, RouteInfo.class});
            } catch (NoSuchMethodException e) {
            }
        }

        public final void m20398a(Object obj, int i, Object obj2) {
            MediaRouter mediaRouter = (MediaRouter) obj;
            RouteInfo routeInfo = (RouteInfo) obj2;
            if ((routeInfo.getSupportedTypes() & 8388608) == 0) {
                if (this.f16327a != null) {
                    try {
                        this.f16327a.invoke(mediaRouter, new Object[]{Integer.valueOf(i), routeInfo});
                        return;
                    } catch (Throwable e) {
                        Log.w("MediaRouterJellybean", "Cannot programmatically select non-user route.  Media routing may not work.", e);
                    } catch (Throwable e2) {
                        Log.w("MediaRouterJellybean", "Cannot programmatically select non-user route.  Media routing may not work.", e2);
                    }
                } else {
                    Log.w("MediaRouterJellybean", "Cannot programmatically select non-user route because the platform is missing the selectRouteInt() method.  Media routing may not work.");
                }
            }
            mediaRouter.selectRoute(i, routeInfo);
        }
    }

    /* compiled from: ctts */
    public final class UserRouteInfo {
        public static void m20399a(Object obj, int i) {
            ((android.media.MediaRouter.UserRouteInfo) obj).setPlaybackType(i);
        }

        public static void m20401b(Object obj, int i) {
            ((android.media.MediaRouter.UserRouteInfo) obj).setPlaybackStream(i);
        }

        public static void m20400a(Object obj, Object obj2) {
            ((android.media.MediaRouter.UserRouteInfo) obj).setVolumeCallback((android.media.MediaRouter.VolumeCallback) obj2);
        }
    }

    /* compiled from: ctts */
    public interface VolumeCallback {
        void mo1267a(Object obj, int i);

        void mo1270b(Object obj, int i);
    }

    /* compiled from: ctts */
    public class VolumeCallbackProxy<T extends VolumeCallback> extends android.media.MediaRouter.VolumeCallback {
        protected final T f16328a;

        public VolumeCallbackProxy(T t) {
            this.f16328a = t;
        }

        public void onVolumeSetRequest(RouteInfo routeInfo, int i) {
            this.f16328a.mo1267a(routeInfo, i);
        }

        public void onVolumeUpdateRequest(RouteInfo routeInfo, int i) {
            this.f16328a.mo1270b(routeInfo, i);
        }
    }

    MediaRouterJellybean() {
    }

    public static List m20406a(Object obj) {
        MediaRouter mediaRouter = (MediaRouter) obj;
        int routeCount = mediaRouter.getRouteCount();
        List arrayList = new ArrayList(routeCount);
        for (int i = 0; i < routeCount; i++) {
            arrayList.add(mediaRouter.getRouteAt(i));
        }
        return arrayList;
    }

    public static Object m20404a(Object obj, int i) {
        return ((MediaRouter) obj).getSelectedRoute(i);
    }

    public static void m20407a(Object obj, int i, Object obj2) {
        ((MediaRouter) obj).selectRoute(i, (RouteInfo) obj2);
    }

    public static void m20410b(Object obj, int i, Object obj2) {
        ((MediaRouter) obj).addCallback(i, (android.media.MediaRouter.Callback) obj2);
    }

    public static void m20408a(Object obj, Object obj2) {
        ((MediaRouter) obj).removeCallback((android.media.MediaRouter.Callback) obj2);
    }

    public static Object m20405a(Object obj, String str, boolean z) {
        return ((MediaRouter) obj).createRouteCategory(str, z);
    }

    public static Object m20409b(Object obj, Object obj2) {
        return ((MediaRouter) obj).createUserRoute((RouteCategory) obj2);
    }

    public static void m20411c(Object obj, Object obj2) {
        ((MediaRouter) obj).addUserRoute((android.media.MediaRouter.UserRouteInfo) obj2);
    }

    public static void m20412d(Object obj, Object obj2) {
        ((MediaRouter) obj).removeUserRoute((android.media.MediaRouter.UserRouteInfo) obj2);
    }
}
