package android.support.v7.media;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.media.AudioManager;
import android.support.v7.media.MediaRouteDescriptor.Builder;
import android.support.v7.media.MediaRouteProvider.ProviderMetadata;
import android.support.v7.media.MediaRouteProvider.RouteController;
import android.support.v7.media.MediaRouter.RouteInfo;
import android.support.v7.media.MediaRouterJellybean.Callback;
import android.support.v7.media.MediaRouterJellybean.CallbackProxy;
import android.support.v7.media.MediaRouterJellybean.GetDefaultRouteWorkaround;
import android.support.v7.media.MediaRouterJellybean.SelectRouteWorkaround;
import android.support.v7.media.MediaRouterJellybean.UserRouteInfo;
import android.support.v7.media.MediaRouterJellybean.VolumeCallback;
import android.support.v7.media.MediaRouterJellybean.VolumeCallbackProxy;
import android.support.v7.media.MediaRouterJellybeanMr1.ActiveScanWorkaround;
import android.support.v7.media.MediaRouterJellybeanMr1.IsConnectingWorkaround;
import android.util.Log;
import android.view.Display;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.work.inlinecomposer.protocol.FetchTopComposerGroupsParsers.FetchTopComposerGroupsParser;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: currencies */
abstract class SystemMediaRouteProvider extends MediaRouteProvider {

    /* compiled from: currencies */
    public interface SyncCallback {
        RouteInfo mo1255a(String str);
    }

    /* compiled from: currencies */
    public class JellybeanImpl extends SystemMediaRouteProvider implements Callback, VolumeCallback {
        private static final ArrayList<IntentFilter> f16385j;
        private static final ArrayList<IntentFilter> f16386k;
        protected final Object f16387a;
        protected final Object f16388b;
        protected final Object f16389c;
        protected final Object f16390d;
        protected int f16391e;
        protected boolean f16392f;
        protected boolean f16393g;
        protected final ArrayList<SystemRouteRecord> f16394h = new ArrayList();
        protected final ArrayList<UserRouteRecord> f16395i = new ArrayList();
        private final SyncCallback f16396l;
        private SelectRouteWorkaround f16397m;
        private GetDefaultRouteWorkaround f16398n;

        /* compiled from: currencies */
        public final class SystemRouteController extends RouteController {
            final /* synthetic */ JellybeanImpl f16378a;
            private final Object f16379b;

            public SystemRouteController(JellybeanImpl jellybeanImpl, Object obj) {
                this.f16378a = jellybeanImpl;
                this.f16379b = obj;
            }

            public final void mo1259a(int i) {
                FetchTopComposerGroupsParser.a(this.f16379b, i);
            }

            public final void mo1261b(int i) {
                FetchTopComposerGroupsParser.b(this.f16379b, i);
            }
        }

        /* compiled from: currencies */
        public final class SystemRouteRecord {
            public final Object f16380a;
            public final String f16381b;
            public MediaRouteDescriptor f16382c;

            public SystemRouteRecord(Object obj, String str) {
                this.f16380a = obj;
                this.f16381b = str;
            }
        }

        /* compiled from: currencies */
        public final class UserRouteRecord {
            public final RouteInfo f16383a;
            public final Object f16384b;

            public UserRouteRecord(RouteInfo routeInfo, Object obj) {
                this.f16383a = routeInfo;
                this.f16384b = obj;
            }
        }

        private String m20465k(Object obj) {
            CharSequence a = FetchTopComposerGroupsParser.a(obj, this.f16255a);
            return a != null ? a.toString() : "";
        }

        protected Object mo1280h() {
            return new CallbackProxy(this);
        }

        static {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addCategory("android.media.intent.category.LIVE_AUDIO");
            ArrayList arrayList = new ArrayList();
            f16385j = arrayList;
            arrayList.add(intentFilter);
            intentFilter = new IntentFilter();
            intentFilter.addCategory("android.media.intent.category.LIVE_VIDEO");
            arrayList = new ArrayList();
            f16386k = arrayList;
            arrayList.add(intentFilter);
        }

        public JellybeanImpl(Context context, SyncCallback syncCallback) {
            super(context);
            this.f16396l = syncCallback;
            this.f16387a = context.getSystemService("media_router");
            this.f16388b = mo1280h();
            this.f16389c = new VolumeCallbackProxy(this);
            this.f16390d = MediaRouterJellybean.m20405a(this.f16387a, context.getResources().getString(2131238215), false);
            m20464j();
        }

        public final RouteController mo1263a(String str) {
            int b = m20459b(str);
            if (b >= 0) {
                return new SystemRouteController(this, ((SystemRouteRecord) this.f16394h.get(b)).f16380a);
            }
            return null;
        }

        public final void mo1264b(MediaRouteDiscoveryRequest mediaRouteDiscoveryRequest) {
            int i;
            boolean z = false;
            if (mediaRouteDiscoveryRequest != null) {
                List a = mediaRouteDiscoveryRequest.m20317a().m20344a();
                int size = a.size();
                int i2 = 0;
                i = 0;
                while (i2 < size) {
                    int i3;
                    String str = (String) a.get(i2);
                    if (str.equals("android.media.intent.category.LIVE_AUDIO")) {
                        i3 = i | 1;
                    } else if (str.equals("android.media.intent.category.LIVE_VIDEO")) {
                        i3 = i | 2;
                    } else {
                        i3 = 8388608 | i;
                    }
                    i2++;
                    i = i3;
                }
                z = mediaRouteDiscoveryRequest.m20318b();
            } else {
                i = 0;
            }
            if (this.f16391e != i || this.f16392f != z) {
                this.f16391e = i;
                this.f16392f = z;
                mo1279g();
                m20464j();
            }
        }

        public final void mo1269b(Object obj) {
            if (mo1278f(obj)) {
                m20481f();
            }
        }

        private void m20464j() {
            int i = 0;
            for (Object f : MediaRouterJellybean.m20406a(this.f16387a)) {
                i |= mo1278f(f);
            }
            if (i != 0) {
                m20481f();
            }
        }

        private boolean mo1278f(Object obj) {
            if (m20463j(obj) != null || m20482g(obj) >= 0) {
                return false;
            }
            SystemRouteRecord systemRouteRecord = new SystemRouteRecord(obj, m20462i(obj));
            mo1277a(systemRouteRecord);
            this.f16394h.add(systemRouteRecord);
            return true;
        }

        private String m20462i(Object obj) {
            String format = (mo1283i() == obj ? 1 : 0) != 0 ? "DEFAULT_ROUTE" : String.format(Locale.US, "ROUTE_%08x", new Object[]{Integer.valueOf(m20465k(obj).hashCode())});
            if (m20459b(format) < 0) {
                return format;
            }
            int i = 2;
            while (true) {
                String format2 = String.format(Locale.US, "%s_%d", new Object[]{format, Integer.valueOf(i)});
                if (m20459b(format2) < 0) {
                    return format2;
                }
                i++;
            }
        }

        public final void mo1272c(Object obj) {
            if (m20463j(obj) == null) {
                int g = m20482g(obj);
                if (g >= 0) {
                    this.f16394h.remove(g);
                    m20481f();
                }
            }
        }

        public final void mo1274d(Object obj) {
            if (m20463j(obj) == null) {
                int g = m20482g(obj);
                if (g >= 0) {
                    mo1277a((SystemRouteRecord) this.f16394h.get(g));
                    m20481f();
                }
            }
        }

        public final void mo1275e(Object obj) {
            if (m20463j(obj) == null) {
                int g = m20482g(obj);
                if (g >= 0) {
                    SystemRouteRecord systemRouteRecord = (SystemRouteRecord) this.f16394h.get(g);
                    int d = FetchTopComposerGroupsParser.d(obj);
                    if (d != systemRouteRecord.f16382c.m20309i()) {
                        systemRouteRecord.f16382c = new Builder(systemRouteRecord.f16382c).m20296c(d).m20294a();
                        m20481f();
                    }
                }
            }
        }

        public final void mo1266a(Object obj) {
            if (obj == MediaRouterJellybean.m20404a(this.f16387a, 8388611)) {
                UserRouteRecord j = m20463j(obj);
                if (j != null) {
                    j.f16383a.m20378n();
                    return;
                }
                int g = m20482g(obj);
                if (g >= 0) {
                    RouteInfo a = this.f16396l.mo1255a(((SystemRouteRecord) this.f16394h.get(g)).f16381b);
                    if (a != null) {
                        a.m20378n();
                    }
                }
            }
        }

        public final void mo1267a(Object obj, int i) {
            UserRouteRecord j = m20463j(obj);
            if (j != null) {
                j.f16383a.m20372a(i);
            }
        }

        public final void mo1270b(Object obj, int i) {
            UserRouteRecord j = m20463j(obj);
            if (j != null) {
                j.f16383a.m20375b(i);
            }
        }

        public final void mo1265a(RouteInfo routeInfo) {
            if (routeInfo.m20379p() != this) {
                Object b = MediaRouterJellybean.m20409b(this.f16387a, this.f16390d);
                UserRouteRecord userRouteRecord = new UserRouteRecord(routeInfo, b);
                FetchTopComposerGroupsParser.a(b, userRouteRecord);
                UserRouteInfo.m20400a(b, this.f16389c);
                mo1281a(userRouteRecord);
                this.f16395i.add(userRouteRecord);
                MediaRouterJellybean.m20411c(this.f16387a, b);
                return;
            }
            int g = m20482g(MediaRouterJellybean.m20404a(this.f16387a, 8388611));
            if (g >= 0 && ((SystemRouteRecord) this.f16394h.get(g)).f16381b.equals(routeInfo.f16305b)) {
                routeInfo.m20378n();
            }
        }

        public final void mo1268b(RouteInfo routeInfo) {
            if (routeInfo.m20379p() != this) {
                int e = m20460e(routeInfo);
                if (e >= 0) {
                    UserRouteRecord userRouteRecord = (UserRouteRecord) this.f16395i.remove(e);
                    FetchTopComposerGroupsParser.a(userRouteRecord.f16384b, null);
                    UserRouteInfo.m20400a(userRouteRecord.f16384b, null);
                    MediaRouterJellybean.m20412d(this.f16387a, userRouteRecord.f16384b);
                }
            }
        }

        public final void mo1271c(RouteInfo routeInfo) {
            if (routeInfo.m20379p() != this) {
                int e = m20460e(routeInfo);
                if (e >= 0) {
                    mo1281a((UserRouteRecord) this.f16395i.get(e));
                }
            }
        }

        public final void mo1273d(RouteInfo routeInfo) {
            if (!routeInfo.m20376f()) {
                return;
            }
            int e;
            if (routeInfo.m20379p() != this) {
                e = m20460e(routeInfo);
                if (e >= 0) {
                    mo1282h(((UserRouteRecord) this.f16395i.get(e)).f16384b);
                    return;
                }
                return;
            }
            e = m20459b(routeInfo.f16305b);
            if (e >= 0) {
                mo1282h(((SystemRouteRecord) this.f16394h.get(e)).f16380a);
            }
        }

        protected final void m20481f() {
            MediaRouteProviderDescriptor.Builder builder = new MediaRouteProviderDescriptor.Builder();
            int size = this.f16394h.size();
            for (int i = 0; i < size; i++) {
                builder.m20331a(((SystemRouteRecord) this.f16394h.get(i)).f16382c);
            }
            m20329a(builder.m20332a());
        }

        protected final int m20482g(Object obj) {
            int size = this.f16394h.size();
            for (int i = 0; i < size; i++) {
                if (((SystemRouteRecord) this.f16394h.get(i)).f16380a == obj) {
                    return i;
                }
            }
            return -1;
        }

        private int m20459b(String str) {
            int size = this.f16394h.size();
            for (int i = 0; i < size; i++) {
                if (((SystemRouteRecord) this.f16394h.get(i)).f16381b.equals(str)) {
                    return i;
                }
            }
            return -1;
        }

        private int m20460e(RouteInfo routeInfo) {
            int size = this.f16395i.size();
            for (int i = 0; i < size; i++) {
                if (((UserRouteRecord) this.f16395i.get(i)).f16383a == routeInfo) {
                    return i;
                }
            }
            return -1;
        }

        private static UserRouteRecord m20463j(Object obj) {
            Object g = FetchTopComposerGroupsParser.g(obj);
            return g instanceof UserRouteRecord ? (UserRouteRecord) g : null;
        }

        private void mo1277a(SystemRouteRecord systemRouteRecord) {
            Builder builder = new Builder(systemRouteRecord.f16381b, m20465k(systemRouteRecord.f16380a));
            mo1276a(systemRouteRecord, builder);
            systemRouteRecord.f16382c = builder.m20294a();
        }

        protected void mo1276a(SystemRouteRecord systemRouteRecord, Builder builder) {
            int a = FetchTopComposerGroupsParser.a(systemRouteRecord.f16380a);
            if ((a & 1) != 0) {
                builder.m20293a(f16385j);
            }
            if ((a & 2) != 0) {
                builder.m20293a(f16386k);
            }
            builder.m20292a(FetchTopComposerGroupsParser.b(systemRouteRecord.f16380a));
            builder.m20295b(FetchTopComposerGroupsParser.c(systemRouteRecord.f16380a));
            builder.m20296c(FetchTopComposerGroupsParser.d(systemRouteRecord.f16380a));
            builder.m20297d(FetchTopComposerGroupsParser.e(systemRouteRecord.f16380a));
            builder.m20298e(FetchTopComposerGroupsParser.f(systemRouteRecord.f16380a));
        }

        protected void mo1281a(UserRouteRecord userRouteRecord) {
            FetchTopComposerGroupsParser.a(userRouteRecord.f16384b, userRouteRecord.f16383a.f16307d);
            UserRouteInfo.m20399a(userRouteRecord.f16384b, userRouteRecord.f16383a.f16312i);
            UserRouteInfo.m20401b(userRouteRecord.f16384b, userRouteRecord.f16383a.f16313j);
            FetchTopComposerGroupsParser.c(userRouteRecord.f16384b, userRouteRecord.f16383a.f16315l);
            FetchTopComposerGroupsParser.d(userRouteRecord.f16384b, userRouteRecord.f16383a.f16316m);
            FetchTopComposerGroupsParser.e(userRouteRecord.f16384b, userRouteRecord.f16383a.f16314k);
        }

        protected void mo1279g() {
            if (this.f16393g) {
                this.f16393g = false;
                MediaRouterJellybean.m20408a(this.f16387a, this.f16388b);
            }
            if (this.f16391e != 0) {
                this.f16393g = true;
                MediaRouterJellybean.m20410b(this.f16387a, this.f16391e, this.f16388b);
            }
        }

        protected void mo1282h(Object obj) {
            if (this.f16397m == null) {
                this.f16397m = new SelectRouteWorkaround();
            }
            this.f16397m.m20398a(this.f16387a, 8388611, obj);
        }

        protected Object mo1283i() {
            if (this.f16398n == null) {
                this.f16398n = new GetDefaultRouteWorkaround();
            }
            return this.f16398n.m20397a(this.f16387a);
        }
    }

    /* compiled from: currencies */
    public class JellybeanMr1Impl extends JellybeanImpl implements MediaRouterJellybeanMr1.Callback {
        private ActiveScanWorkaround f16399j;
        private IsConnectingWorkaround f16400k;

        protected final Object mo1280h() {
            return new MediaRouterJellybeanMr1.CallbackProxy(this);
        }

        public JellybeanMr1Impl(Context context, SyncCallback syncCallback) {
            super(context, syncCallback);
        }

        public final void mo1278f(Object obj) {
            int g = m20482g(obj);
            if (g >= 0) {
                SystemRouteRecord systemRouteRecord = (SystemRouteRecord) this.f16394h.get(g);
                Display b = FetchTopComposerGroupsParser.b(obj);
                int displayId = b != null ? b.getDisplayId() : -1;
                if (displayId != systemRouteRecord.f16382c.m20312l()) {
                    systemRouteRecord.f16382c = new Builder(systemRouteRecord.f16382c).m20299f(displayId).m20294a();
                    m20481f();
                }
            }
        }

        protected void mo1276a(SystemRouteRecord systemRouteRecord, Builder builder) {
            super.mo1276a(systemRouteRecord, builder);
            if (!FetchTopComposerGroupsParser.a(systemRouteRecord.f16380a)) {
                builder.f16247a.putBoolean("enabled", false);
            }
            if (mo1277a(systemRouteRecord)) {
                builder.f16247a.putBoolean("connecting", true);
            }
            Display b = FetchTopComposerGroupsParser.b(systemRouteRecord.f16380a);
            if (b != null) {
                builder.m20299f(b.getDisplayId());
            }
        }

        protected void mo1279g() {
            int i;
            super.mo1279g();
            if (this.f16399j == null) {
                this.f16399j = new ActiveScanWorkaround(this.f16255a, this.f16257c);
            }
            Runnable runnable = this.f16399j;
            if (this.f16392f) {
                i = this.f16391e;
            } else {
                i = 0;
            }
            if ((i & 2) != 0) {
                if (!runnable.f16332d) {
                    if (runnable.f16331c != null) {
                        runnable.f16332d = true;
                        HandlerDetour.a(runnable.f16330b, runnable, 1191630972);
                        return;
                    }
                    Log.w("MediaRouterJellybeanMr1", "Cannot scan for wifi displays because the DisplayManager.scanWifiDisplays() method is not available on this device.");
                }
            } else if (runnable.f16332d) {
                runnable.f16332d = false;
                HandlerDetour.a(runnable.f16330b, runnable);
            }
        }

        protected boolean mo1277a(SystemRouteRecord systemRouteRecord) {
            if (this.f16400k == null) {
                this.f16400k = new IsConnectingWorkaround();
            }
            return this.f16400k.m20414a(systemRouteRecord.f16380a);
        }
    }

    /* compiled from: currencies */
    public class JellybeanMr2Impl extends JellybeanMr1Impl {
        public JellybeanMr2Impl(Context context, SyncCallback syncCallback) {
            super(context, syncCallback);
        }

        protected final void mo1276a(SystemRouteRecord systemRouteRecord, Builder builder) {
            super.mo1276a(systemRouteRecord, builder);
            CharSequence a = FetchTopComposerGroupsParser.a(systemRouteRecord.f16380a);
            if (a != null) {
                builder.f16247a.putString("status", a.toString());
            }
        }

        protected final void mo1282h(Object obj) {
            MediaRouterJellybean.m20407a(this.f16387a, 8388611, obj);
        }

        protected final Object mo1283i() {
            return MediaRouterJellybeanMr2.m20416a(this.f16387a);
        }

        protected final void mo1281a(UserRouteRecord userRouteRecord) {
            super.mo1281a(userRouteRecord);
            MediaRouterJellybeanMr2.UserRouteInfo.m20415a(userRouteRecord.f16384b, userRouteRecord.f16383a.f16308e);
        }

        protected final void mo1279g() {
            int i = 1;
            if (this.f16393g) {
                MediaRouterJellybean.m20408a(this.f16387a, this.f16388b);
            }
            this.g = true;
            Object obj = this.f16387a;
            int i2 = this.f16391e;
            Object obj2 = this.f16388b;
            if (!this.f16392f) {
                i = 0;
            }
            MediaRouterJellybeanMr2.m20417a(obj, i2, obj2, i | 2);
        }

        protected final boolean mo1277a(SystemRouteRecord systemRouteRecord) {
            return FetchTopComposerGroupsParser.b(systemRouteRecord.f16380a);
        }
    }

    /* compiled from: currencies */
    public class LegacyImpl extends SystemMediaRouteProvider {
        private static final ArrayList<IntentFilter> f16403a;
        public final AudioManager f16404b;
        private final VolumeChangeReceiver f16405c;
        public int f16406d = -1;

        /* compiled from: currencies */
        final class DefaultRouteController extends RouteController {
            final /* synthetic */ LegacyImpl f16401a;

            DefaultRouteController(LegacyImpl legacyImpl) {
                this.f16401a = legacyImpl;
            }

            public final void mo1259a(int i) {
                this.f16401a.f16404b.setStreamVolume(3, i, 0);
                LegacyImpl.m20500f(this.f16401a);
            }

            public final void mo1261b(int i) {
                int streamVolume = this.f16401a.f16404b.getStreamVolume(3);
                if (Math.min(this.f16401a.f16404b.getStreamMaxVolume(3), Math.max(0, streamVolume + i)) != streamVolume) {
                    this.f16401a.f16404b.setStreamVolume(3, streamVolume, 0);
                }
                LegacyImpl.m20500f(this.f16401a);
            }
        }

        /* compiled from: currencies */
        final class VolumeChangeReceiver extends BroadcastReceiver {
            final /* synthetic */ LegacyImpl f16402a;

            VolumeChangeReceiver(LegacyImpl legacyImpl) {
                this.f16402a = legacyImpl;
            }

            public final void onReceive(Context context, Intent intent) {
                int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1374631745);
                if (intent.getAction().equals("android.media.VOLUME_CHANGED_ACTION") && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                    int intExtra = intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_VALUE", -1);
                    if (intExtra >= 0 && intExtra != this.f16402a.f16406d) {
                        LegacyImpl.m20500f(this.f16402a);
                    }
                }
                LogUtils.a(intent, 2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -547432329, a);
            }
        }

        static {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addCategory("android.media.intent.category.LIVE_AUDIO");
            intentFilter.addCategory("android.media.intent.category.LIVE_VIDEO");
            ArrayList arrayList = new ArrayList();
            f16403a = arrayList;
            arrayList.add(intentFilter);
        }

        public LegacyImpl(Context context) {
            super(context);
            this.f16404b = (AudioManager) context.getSystemService("audio");
            this.f16405c = new VolumeChangeReceiver(this);
            context.registerReceiver(this.f16405c, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
            m20500f(this);
        }

        public static void m20500f(LegacyImpl legacyImpl) {
            Resources resources = legacyImpl.f16255a.getResources();
            int streamMaxVolume = legacyImpl.f16404b.getStreamMaxVolume(3);
            legacyImpl.f16406d = legacyImpl.f16404b.getStreamVolume(3);
            legacyImpl.m20329a(new MediaRouteProviderDescriptor.Builder().m20331a(new Builder("DEFAULT_ROUTE", resources.getString(2131238214)).m20293a(f16403a).m20295b(3).m20292a(0).m20298e(1).m20297d(streamMaxVolume).m20296c(legacyImpl.f16406d).m20294a()).m20332a());
        }

        public final RouteController mo1263a(String str) {
            if (str.equals("DEFAULT_ROUTE")) {
                return new DefaultRouteController(this);
            }
            return null;
        }
    }

    protected SystemMediaRouteProvider(Context context) {
        super(context, new ProviderMetadata(new ComponentName("android", SystemMediaRouteProvider.class.getName())));
    }

    public void mo1265a(RouteInfo routeInfo) {
    }

    public void mo1268b(RouteInfo routeInfo) {
    }

    public void mo1271c(RouteInfo routeInfo) {
    }

    public void mo1273d(RouteInfo routeInfo) {
    }
}
