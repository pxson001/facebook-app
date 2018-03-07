package android.support.v7.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.media.MediaRouteProvider.ProviderMetadata;
import android.support.v7.media.MediaRouteProvider.RouteController;
import android.support.v7.media.MediaRouter.ControlRequestCallback;
import android.util.Log;
import android.util.SparseArray;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.tools.dextr.runtime.detour.ServiceConnectionDetour;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: cta_lead_gen_xout_on_top */
public final class RegisteredMediaRouteProvider extends MediaRouteProvider implements ServiceConnection {
    public static final boolean f16355a = Log.isLoggable("MediaRouteProviderProxy", 3);
    public final ComponentName f16356b;
    public final PrivateHandler f16357c;
    public final ArrayList<Controller> f16358d = new ArrayList();
    private boolean f16359e;
    private boolean f16360f;
    public Connection f16361g;
    public boolean f16362h;

    /* compiled from: cta_lead_gen_xout_on_top */
    public final class Connection implements DeathRecipient {
        public final /* synthetic */ RegisteredMediaRouteProvider f16337a;
        private final Messenger f16338b;
        private final ReceiveHandler f16339c;
        private final Messenger f16340d;
        private int f16341e = 1;
        private int f16342f = 1;
        public int f16343g;
        public int f16344h;
        public final SparseArray<ControlRequestCallback> f16345i = new SparseArray();

        /* compiled from: cta_lead_gen_xout_on_top */
        class C12861 implements Runnable {
            final /* synthetic */ Connection f16335a;

            C12861(Connection connection) {
                this.f16335a = connection;
            }

            public void run() {
                Connection connection = this.f16335a;
                for (int i = 0; i < connection.f16345i.size(); i++) {
                    connection.f16345i.valueAt(i);
                }
                connection.f16345i.clear();
            }
        }

        /* compiled from: cta_lead_gen_xout_on_top */
        class C12872 implements Runnable {
            final /* synthetic */ Connection f16336a;

            C12872(Connection connection) {
                this.f16336a = connection;
            }

            public void run() {
                RegisteredMediaRouteProvider.m20440b(this.f16336a.f16337a, this.f16336a);
            }
        }

        public Connection(RegisteredMediaRouteProvider registeredMediaRouteProvider, Messenger messenger) {
            this.f16337a = registeredMediaRouteProvider;
            this.f16338b = messenger;
            this.f16339c = new ReceiveHandler(this);
            this.f16340d = new Messenger(this.f16339c);
        }

        public final boolean m20422a() {
            int i = this.f16341e;
            this.f16341e = i + 1;
            this.f16344h = i;
            if (!m20418a(1, this.f16344h, 1, null, null)) {
                return false;
            }
            try {
                this.f16338b.getBinder().linkToDeath(this, 0);
                return true;
            } catch (RemoteException e) {
                binderDied();
                return false;
            }
        }

        public final void m20424b() {
            m20418a(2, 0, 0, null, null);
            this.f16339c.f16354a.clear();
            this.f16338b.getBinder().unlinkToDeath(this, 0);
            HandlerDetour.a(this.f16337a.f16357c, new C12861(this), -872432355);
        }

        public final boolean m20423a(int i, int i2, Bundle bundle) {
            if (this.f16343g != 0 || i != this.f16344h || i2 <= 0) {
                return false;
            }
            this.f16344h = 0;
            this.f16343g = i2;
            RegisteredMediaRouteProvider.m20437a(this.f16337a, this, MediaRouteProviderDescriptor.m20333a(bundle));
            MediaRouteProvider mediaRouteProvider = this.f16337a;
            if (mediaRouteProvider.f16361g == this) {
                mediaRouteProvider.f16362h = true;
                int size = mediaRouteProvider.f16358d.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((Controller) mediaRouteProvider.f16358d.get(i3)).m20431a(mediaRouteProvider.f16361g);
                }
                MediaRouteDiscoveryRequest mediaRouteDiscoveryRequest = mediaRouteProvider.f16259e;
                if (mediaRouteDiscoveryRequest != null) {
                    mediaRouteProvider.f16361g.m20421a(mediaRouteDiscoveryRequest);
                }
            }
            return true;
        }

        public final void binderDied() {
            HandlerDetour.a(this.f16337a.f16357c, new C12872(this), -467651054);
        }

        public final int m20419a(String str) {
            int i = this.f16342f;
            this.f16342f = i + 1;
            Bundle bundle = new Bundle();
            bundle.putString("routeId", str);
            int i2 = this.f16341e;
            this.f16341e = i2 + 1;
            m20418a(3, i2, i, null, bundle);
            return i;
        }

        public final void m20425b(int i) {
            int i2 = this.f16341e;
            this.f16341e = i2 + 1;
            m20418a(4, i2, i, null, null);
        }

        public final void m20427c(int i) {
            int i2 = this.f16341e;
            this.f16341e = i2 + 1;
            m20418a(5, i2, i, null, null);
        }

        public final void m20428d(int i) {
            int i2 = this.f16341e;
            this.f16341e = i2 + 1;
            m20418a(6, i2, i, null, null);
        }

        public final void m20420a(int i, int i2) {
            Bundle bundle = new Bundle();
            bundle.putInt("volume", i2);
            int i3 = this.f16341e;
            this.f16341e = i3 + 1;
            m20418a(7, i3, i, null, bundle);
        }

        public final void m20426b(int i, int i2) {
            Bundle bundle = new Bundle();
            bundle.putInt("volume", i2);
            int i3 = this.f16341e;
            this.f16341e = i3 + 1;
            m20418a(8, i3, i, null, bundle);
        }

        public final void m20421a(MediaRouteDiscoveryRequest mediaRouteDiscoveryRequest) {
            Object obj;
            int i = this.f16341e;
            this.f16341e = i + 1;
            if (mediaRouteDiscoveryRequest != null) {
                obj = mediaRouteDiscoveryRequest.f16251a;
            } else {
                obj = null;
            }
            m20418a(10, i, 0, obj, null);
        }

        private boolean m20418a(int i, int i2, int i3, Object obj, Bundle bundle) {
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.arg1 = i2;
            obtain.arg2 = i3;
            obtain.obj = obj;
            obtain.setData(bundle);
            obtain.replyTo = this.f16340d;
            try {
                this.f16338b.send(obtain);
                return true;
            } catch (DeadObjectException e) {
                return false;
            } catch (Throwable e2) {
                if (i != 2) {
                    Log.e("MediaRouteProviderProxy", "Could not send message to service.", e2);
                }
                return false;
            }
        }
    }

    /* compiled from: cta_lead_gen_xout_on_top */
    public final class Controller extends RouteController {
        final /* synthetic */ RegisteredMediaRouteProvider f16346a;
        private final String f16347b;
        private boolean f16348c;
        private int f16349d = -1;
        private int f16350e;
        private Connection f16351f;
        private int f16352g;

        public Controller(RegisteredMediaRouteProvider registeredMediaRouteProvider, String str) {
            this.f16346a = registeredMediaRouteProvider;
            this.f16347b = str;
        }

        public final void m20431a(Connection connection) {
            this.f16351f = connection;
            this.f16352g = connection.m20419a(this.f16347b);
            if (this.f16348c) {
                connection.m20427c(this.f16352g);
                if (this.f16349d >= 0) {
                    connection.m20420a(this.f16352g, this.f16349d);
                    this.f16349d = -1;
                }
                if (this.f16350e != 0) {
                    connection.m20426b(this.f16352g, this.f16350e);
                    this.f16350e = 0;
                }
            }
        }

        public final void m20435d() {
            if (this.f16351f != null) {
                this.f16351f.m20425b(this.f16352g);
                this.f16351f = null;
                this.f16352g = 0;
            }
        }

        public final void mo1258a() {
            RegisteredMediaRouteProvider.m20439a(this.f16346a, this);
        }

        public final void mo1260b() {
            this.f16348c = true;
            if (this.f16351f != null) {
                this.f16351f.m20427c(this.f16352g);
            }
        }

        public final void mo1262c() {
            this.f16348c = false;
            if (this.f16351f != null) {
                this.f16351f.m20428d(this.f16352g);
            }
        }

        public final void mo1259a(int i) {
            if (this.f16351f != null) {
                this.f16351f.m20420a(this.f16352g, i);
                return;
            }
            this.f16349d = i;
            this.f16350e = 0;
        }

        public final void mo1261b(int i) {
            if (this.f16351f != null) {
                this.f16351f.m20426b(this.f16352g, i);
            } else {
                this.f16350e += i;
            }
        }
    }

    /* compiled from: cta_lead_gen_xout_on_top */
    final class PrivateHandler extends Handler {
        final /* synthetic */ RegisteredMediaRouteProvider f16353a;

        public PrivateHandler(RegisteredMediaRouteProvider registeredMediaRouteProvider) {
            this.f16353a = registeredMediaRouteProvider;
        }
    }

    /* compiled from: cta_lead_gen_xout_on_top */
    public final class ReceiveHandler extends Handler {
        public final WeakReference<Connection> f16354a;

        public ReceiveHandler(Connection connection) {
            this.f16354a = new WeakReference(connection);
        }

        public final void handleMessage(Message message) {
            Connection connection = (Connection) this.f16354a.get();
            if (connection != null && !m20436a(connection, message.what, message.arg1, message.arg2, message.obj, message.peekData()) && RegisteredMediaRouteProvider.f16355a) {
                Log.d("MediaRouteProviderProxy", "Unhandled message from server: " + message);
            }
        }

        private static boolean m20436a(Connection connection, int i, int i2, int i3, Object obj, Bundle bundle) {
            Bundle bundle2;
            boolean z;
            switch (i) {
                case 0:
                    if (i2 == connection.f16344h) {
                        connection.f16344h = 0;
                        RegisteredMediaRouteProvider.m20438a(connection.f16337a, connection, "Registation failed");
                    }
                    if (((ControlRequestCallback) connection.f16345i.get(i2)) != null) {
                        connection.f16345i.remove(i2);
                    }
                    return true;
                case 1:
                    return true;
                case 2:
                    if (obj == null || (obj instanceof Bundle)) {
                        return connection.m20423a(i2, i3, (Bundle) obj);
                    }
                case 3:
                    if (obj == null || (obj instanceof Bundle)) {
                        bundle2 = (Bundle) obj;
                        if (((ControlRequestCallback) connection.f16345i.get(i2)) != null) {
                            connection.f16345i.remove(i2);
                            z = true;
                        } else {
                            z = false;
                        }
                        return z;
                    }
                case 4:
                    if (obj == null || (obj instanceof Bundle)) {
                        if (bundle != null) {
                            String string = bundle.getString("error");
                        }
                        bundle2 = (Bundle) obj;
                        if (((ControlRequestCallback) connection.f16345i.get(i2)) != null) {
                            connection.f16345i.remove(i2);
                            z = true;
                        } else {
                            z = false;
                        }
                        return z;
                    }
                case 5:
                    if (obj == null || (obj instanceof Bundle)) {
                        bundle2 = (Bundle) obj;
                        if (connection.f16343g != 0) {
                            RegisteredMediaRouteProvider.m20437a(connection.f16337a, connection, MediaRouteProviderDescriptor.m20333a(bundle2));
                            z = true;
                        } else {
                            z = false;
                        }
                        return z;
                    }
            }
            return false;
        }
    }

    public RegisteredMediaRouteProvider(Context context, ComponentName componentName) {
        super(context, new ProviderMetadata(componentName));
        this.f16356b = componentName;
        this.f16357c = new PrivateHandler(this);
    }

    public final void mo1264b(MediaRouteDiscoveryRequest mediaRouteDiscoveryRequest) {
        if (this.f16362h) {
            this.f16361g.m20421a(mediaRouteDiscoveryRequest);
        }
        m20441j();
    }

    public final void m20448f() {
        if (!this.f16359e) {
            if (f16355a) {
                Log.d("MediaRouteProviderProxy", this + ": Starting");
            }
            this.f16359e = true;
            m20441j();
        }
    }

    public final void m20449g() {
        if (this.f16359e) {
            if (f16355a) {
                Log.d("MediaRouteProviderProxy", this + ": Stopping");
            }
            this.f16359e = false;
            m20441j();
        }
    }

    public final void m20450h() {
        if (this.f16361g == null && m20442k()) {
            m20444m();
            m20443l();
        }
    }

    private void m20441j() {
        if (m20442k()) {
            m20443l();
        } else {
            m20444m();
        }
    }

    private boolean m20442k() {
        if (!this.f16359e || (this.f16259e == null && this.f16358d.isEmpty())) {
            return false;
        }
        return true;
    }

    private void m20443l() {
        if (!this.f16360f) {
            if (f16355a) {
                Log.d("MediaRouteProviderProxy", this + ": Binding");
            }
            Intent intent = new Intent("android.media.MediaRouteProviderService");
            intent.setComponent(this.f16356b);
            try {
                this.f16360f = ServiceConnectionDetour.a(m20325a(), intent, this, 1, 254923821);
                if (!this.f16360f && f16355a) {
                    Log.d("MediaRouteProviderProxy", this + ": Bind failed");
                }
            } catch (Throwable e) {
                if (f16355a) {
                    Log.d("MediaRouteProviderProxy", this + ": Bind failed", e);
                }
            }
        }
    }

    private void m20444m() {
        if (this.f16360f) {
            if (f16355a) {
                Log.d("MediaRouteProviderProxy", this + ": Unbinding");
            }
            this.f16360f = false;
            m20445n();
            ServiceConnectionDetour.a(this.f16255a, this, 698655826);
        }
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (f16355a) {
            Log.d("MediaRouteProviderProxy", this + ": Connected");
        }
        if (this.f16360f) {
            m20445n();
            Messenger messenger = iBinder != null ? new Messenger(iBinder) : null;
            if (MediaRouteProviderProtocol.m20337a(messenger)) {
                Connection connection = new Connection(this, messenger);
                if (connection.m20422a()) {
                    this.f16361g = connection;
                    return;
                } else if (f16355a) {
                    Log.d("MediaRouteProviderProxy", this + ": Registration failed");
                    return;
                } else {
                    return;
                }
            }
            Log.e("MediaRouteProviderProxy", this + ": Service returned invalid messenger binder");
        }
    }

    public final RouteController mo1263a(String str) {
        MediaRouteProviderDescriptor mediaRouteProviderDescriptor = this.f16261g;
        if (mediaRouteProviderDescriptor != null) {
            List a = mediaRouteProviderDescriptor.m20335a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                if (((MediaRouteDescriptor) a.get(i)).m20301a().equals(str)) {
                    RouteController controller = new Controller(this, str);
                    this.f16358d.add(controller);
                    if (this.f16362h) {
                        controller.m20431a(this.f16361g);
                    }
                    m20441j();
                    return controller;
                }
            }
        }
        return null;
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        if (f16355a) {
            Log.d("MediaRouteProviderProxy", this + ": Service disconnected");
        }
        m20445n();
    }

    public static void m20440b(RegisteredMediaRouteProvider registeredMediaRouteProvider, Connection connection) {
        if (registeredMediaRouteProvider.f16361g == connection) {
            if (f16355a) {
                Log.d("MediaRouteProviderProxy", registeredMediaRouteProvider + ": Service connection died");
            }
            registeredMediaRouteProvider.m20445n();
        }
    }

    public static void m20438a(RegisteredMediaRouteProvider registeredMediaRouteProvider, Connection connection, String str) {
        if (registeredMediaRouteProvider.f16361g == connection) {
            if (f16355a) {
                Log.d("MediaRouteProviderProxy", registeredMediaRouteProvider + ": Service connection error - " + str);
            }
            registeredMediaRouteProvider.m20444m();
        }
    }

    public static void m20437a(RegisteredMediaRouteProvider registeredMediaRouteProvider, Connection connection, MediaRouteProviderDescriptor mediaRouteProviderDescriptor) {
        if (registeredMediaRouteProvider.f16361g == connection) {
            if (f16355a) {
                Log.d("MediaRouteProviderProxy", registeredMediaRouteProvider + ": Descriptor changed, descriptor=" + mediaRouteProviderDescriptor);
            }
            registeredMediaRouteProvider.m20329a(mediaRouteProviderDescriptor);
        }
    }

    private void m20445n() {
        if (this.f16361g != null) {
            m20329a(null);
            this.f16362h = false;
            int size = this.f16358d.size();
            for (int i = 0; i < size; i++) {
                ((Controller) this.f16358d.get(i)).m20435d();
            }
            this.f16361g.m20424b();
            this.f16361g = null;
        }
    }

    public static void m20439a(RegisteredMediaRouteProvider registeredMediaRouteProvider, Controller controller) {
        registeredMediaRouteProvider.f16358d.remove(controller);
        controller.m20435d();
        registeredMediaRouteProvider.m20441j();
    }

    public final String toString() {
        return "Service connection " + this.f16356b.flattenToShortString();
    }
}
