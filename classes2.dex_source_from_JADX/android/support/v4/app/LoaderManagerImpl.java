package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.support.v4.content.Loader.OnLoadCompleteListener;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.SparseArrayCompat;
import android.util.Log;
import com.facebook.proxygen.HTTPTransportCallback;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

/* compiled from: supports_timestamps */
public class LoaderManagerImpl extends LoaderManager {
    public static boolean f3792a = false;
    public final SparseArrayCompat<LoaderInfo> f3793b = new SparseArrayCompat();
    final SparseArrayCompat<LoaderInfo> f3794c = new SparseArrayCompat();
    final String f3795d;
    public FragmentHost f3796e;
    boolean f3797f;
    public boolean f3798g;
    boolean f3799h;

    /* compiled from: supports_timestamps */
    public final class LoaderInfo implements OnLoadCompleteListener<Object> {
        final int f3810a;
        final Bundle f3811b;
        public LoaderCallbacks<Object> f3812c;
        public Loader<Object> f3813d;
        public boolean f3814e;
        boolean f3815f;
        public Object f3816g;
        public boolean f3817h;
        public boolean f3818i;
        public boolean f3819j;
        public boolean f3820k;
        boolean f3821l;
        boolean f3822m;
        LoaderInfo f3823n;
        final /* synthetic */ LoaderManagerImpl f3824o;

        public LoaderInfo(LoaderManagerImpl loaderManagerImpl, int i, Bundle bundle, LoaderCallbacks<Object> loaderCallbacks) {
            this.f3824o = loaderManagerImpl;
            this.f3810a = i;
            this.f3811b = bundle;
            this.f3812c = loaderCallbacks;
        }

        final void m6359a() {
            if (this.f3818i && this.f3819j) {
                this.f3817h = true;
            } else if (!this.f3817h) {
                this.f3817h = true;
                if (LoaderManagerImpl.f3792a) {
                    Log.v("LoaderManager", "  Starting: " + this);
                }
                if (this.f3813d == null && this.f3812c != null) {
                    this.f3813d = this.f3812c.n_(this.f3810a);
                }
                if (this.f3813d == null) {
                    return;
                }
                if (!this.f3813d.getClass().isMemberClass() || Modifier.isStatic(this.f3813d.getClass().getModifiers())) {
                    if (!this.f3822m) {
                        this.f3813d.m6368a(this.f3810a, this);
                        this.f3822m = true;
                    }
                    Loader loader = this.f3813d;
                    loader.f3828p = true;
                    loader.f3830r = false;
                    loader.f3829q = false;
                    loader.m6372g();
                    return;
                }
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.f3813d);
            }
        }

        public final void m6363e() {
            if (LoaderManagerImpl.f3792a) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.f3817h = false;
            if (!this.f3818i && this.f3813d != null && this.f3822m) {
                this.f3822m = false;
                this.f3813d.m6369a(this);
                Loader loader = this.f3813d;
                loader.f3828p = false;
                loader.m6373h();
            }
        }

        final void m6364f() {
            String str;
            LoaderCallbacks loaderCallbacks = null;
            if (LoaderManagerImpl.f3792a) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.f3821l = true;
            boolean z = this.f3815f;
            this.f3815f = false;
            if (this.f3812c != null && this.f3813d != null && this.f3814e && z) {
                if (LoaderManagerImpl.f3792a) {
                    Log.v("LoaderManager", "  Reseting: " + this);
                }
                if (this.f3824o.f3796e != null) {
                    String str2 = this.f3824o.f3796e.mo872o().f3784t;
                    this.f3824o.f3796e.mo872o().f3784t = "onLoaderReset";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    this.f3812c.gA_();
                } finally {
                    loaderCallbacks = this.f3824o.f3796e;
                    if (loaderCallbacks != null) {
                        loaderCallbacks = this.f3824o.f3796e.mo872o();
                        loaderCallbacks.f3784t = str;
                    }
                }
            }
            this.f3812c = loaderCallbacks;
            this.f3816g = loaderCallbacks;
            this.f3814e = false;
            if (this.f3813d != null) {
                if (this.f3822m) {
                    this.f3822m = false;
                    this.f3813d.m6369a(this);
                }
                this.f3813d.m6376s();
            }
            if (this.f3823n != null) {
                this.f3823n.m6364f();
            }
        }

        public final void mo881a(Loader<Object> loader, Object obj) {
            if (LoaderManagerImpl.f3792a) {
                Log.v("LoaderManager", "onLoadComplete: " + this);
            }
            if (this.f3821l) {
                if (LoaderManagerImpl.f3792a) {
                    Log.v("LoaderManager", "  Ignoring load complete -- destroyed");
                }
            } else if (this.f3824o.f3793b.m6350a(this.f3810a) == this) {
                LoaderInfo loaderInfo = this.f3823n;
                if (loaderInfo != null) {
                    if (LoaderManagerImpl.f3792a) {
                        Log.v("LoaderManager", "  Switching to pending loader: " + loaderInfo);
                    }
                    this.f3823n = null;
                    this.f3824o.f3793b.m6351a(this.f3810a, null);
                    m6364f();
                    this.f3824o.m6331a(loaderInfo);
                    return;
                }
                if (!(this.f3816g == obj && this.f3814e)) {
                    this.f3816g = obj;
                    this.f3814e = true;
                    if (this.f3817h) {
                        m6362b(loader, obj);
                    }
                }
                loaderInfo = (LoaderInfo) this.f3824o.f3794c.m6350a(this.f3810a);
                if (!(loaderInfo == null || loaderInfo == this)) {
                    loaderInfo.f3815f = false;
                    loaderInfo.m6364f();
                    this.f3824o.f3794c.m6353b(this.f3810a);
                }
                if (this.f3824o.f3796e != null && !this.f3824o.mo878a()) {
                    this.f3824o.f3796e.mo872o().m6266h();
                }
            } else if (LoaderManagerImpl.f3792a) {
                Log.v("LoaderManager", "  Ignoring load complete -- not active");
            }
        }

        public final void m6362b(Loader<Object> loader, Object obj) {
            String str;
            if (this.f3812c != null) {
                if (this.f3824o.f3796e != null) {
                    String str2 = this.f3824o.f3796e.mo872o().f3784t;
                    this.f3824o.f3796e.mo872o().f3784t = "onLoadFinished";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    if (LoaderManagerImpl.f3792a) {
                        Log.v("LoaderManager", "  onLoadFinished in " + loader + ": " + Loader.m6366c(obj));
                    }
                    this.f3812c.a(loader, obj);
                    this.f3815f = true;
                } finally {
                    if (this.f3824o.f3796e != null) {
                        this.f3824o.f3796e.mo872o().f3784t = str;
                    }
                }
            }
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder(64);
            stringBuilder.append("LoaderInfo{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" #");
            stringBuilder.append(this.f3810a);
            stringBuilder.append(" : ");
            DebugUtils.m13772a(this.f3813d, stringBuilder);
            stringBuilder.append("}}");
            return stringBuilder.toString();
        }

        public final void m6361a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f3810a);
            printWriter.print(" mArgs=");
            printWriter.println(this.f3811b);
            printWriter.print(str);
            printWriter.print("mCallbacks=");
            printWriter.println(this.f3812c);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f3813d);
            if (this.f3813d != null) {
                this.f3813d.m6370a(str + "  ", fileDescriptor, printWriter, strArr);
            }
            if (this.f3814e || this.f3815f) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.f3814e);
                printWriter.print("  mDeliveredData=");
                printWriter.println(this.f3815f);
                printWriter.print(str);
                printWriter.print("mData=");
                printWriter.println(this.f3816g);
            }
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f3817h);
            printWriter.print(" mReportNextStart=");
            printWriter.print(this.f3820k);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.f3821l);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.f3818i);
            printWriter.print(" mRetainingStarted=");
            printWriter.print(this.f3819j);
            printWriter.print(" mListenerRegistered=");
            printWriter.println(this.f3822m);
            if (this.f3823n != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.f3823n);
                printWriter.println(":");
                this.f3823n.m6361a(str + "  ", fileDescriptor, printWriter, strArr);
            }
        }
    }

    LoaderManagerImpl(String str, FragmentHost fragmentHost, boolean z) {
        this.f3795d = str;
        this.f3796e = fragmentHost;
        this.f3797f = z;
    }

    private LoaderInfo m6327c(int i, Bundle bundle, LoaderCallbacks<Object> loaderCallbacks) {
        LoaderInfo loaderInfo = new LoaderInfo(this, i, bundle, loaderCallbacks);
        loaderInfo.f3813d = loaderCallbacks.n_(i);
        return loaderInfo;
    }

    private LoaderInfo m6328d(int i, Bundle bundle, LoaderCallbacks<Object> loaderCallbacks) {
        try {
            this.f3799h = true;
            LoaderInfo c = m6327c(i, bundle, loaderCallbacks);
            m6331a(c);
            return c;
        } finally {
            this.f3799h = false;
        }
    }

    final void m6331a(LoaderInfo loaderInfo) {
        this.f3793b.m6351a(loaderInfo.f3810a, loaderInfo);
        if (this.f3797f) {
            loaderInfo.m6359a();
        }
    }

    public final <D> Loader<D> mo876a(int i, Bundle bundle, LoaderCallbacks<D> loaderCallbacks) {
        if (this.f3799h) {
            throw new IllegalStateException("Called while creating a loader");
        }
        LoaderInfo loaderInfo = (LoaderInfo) this.f3793b.m6350a(i);
        if (f3792a) {
            Log.v("LoaderManager", "initLoader in " + this + ": args=" + bundle);
        }
        if (loaderInfo == null) {
            loaderInfo = m6328d(i, bundle, loaderCallbacks);
            if (f3792a) {
                Log.v("LoaderManager", "  Created new loader " + loaderInfo);
            }
        } else {
            if (f3792a) {
                Log.v("LoaderManager", "  Re-using existing loader " + loaderInfo);
            }
            loaderInfo.f3812c = loaderCallbacks;
        }
        if (loaderInfo.f3814e && this.f3797f) {
            loaderInfo.m6362b(loaderInfo.f3813d, loaderInfo.f3816g);
        }
        return loaderInfo.f3813d;
    }

    public final <D> Loader<D> mo880b(int i, Bundle bundle, LoaderCallbacks<D> loaderCallbacks) {
        if (this.f3799h) {
            throw new IllegalStateException("Called while creating a loader");
        }
        LoaderInfo loaderInfo = (LoaderInfo) this.f3793b.m6350a(i);
        if (f3792a) {
            Log.v("LoaderManager", "restartLoader in " + this + ": args=" + bundle);
        }
        if (loaderInfo != null) {
            LoaderInfo loaderInfo2 = (LoaderInfo) this.f3794c.m6350a(i);
            if (loaderInfo2 != null) {
                if (loaderInfo.f3814e) {
                    if (f3792a) {
                        Log.v("LoaderManager", "  Removing last inactive loader: " + loaderInfo);
                    }
                    loaderInfo2.f3815f = false;
                    loaderInfo2.m6364f();
                } else if (loaderInfo.f3817h) {
                    if (loaderInfo.f3823n != null) {
                        if (f3792a) {
                            Log.v("LoaderManager", "  Removing pending loader: " + loaderInfo.f3823n);
                        }
                        loaderInfo.f3823n.m6364f();
                        loaderInfo.f3823n = null;
                    }
                    if (f3792a) {
                        Log.v("LoaderManager", "  Enqueuing as new pending loader");
                    }
                    loaderInfo.f3823n = m6327c(i, bundle, loaderCallbacks);
                    return loaderInfo.f3823n.f3813d;
                } else {
                    if (f3792a) {
                        Log.v("LoaderManager", "  Current loader is stopped; replacing");
                    }
                    this.f3793b.m6351a(i, null);
                    loaderInfo.m6364f();
                }
            } else if (f3792a) {
                Log.v("LoaderManager", "  Making last loader inactive: " + loaderInfo);
            }
            loaderInfo.f3813d.m6375r();
            this.f3794c.m6351a(i, loaderInfo);
        }
        return m6328d(i, bundle, loaderCallbacks).f3813d;
    }

    public final void mo877a(int i) {
        if (this.f3799h) {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (f3792a) {
            Log.v("LoaderManager", "destroyLoader in " + this + " of " + i);
        }
        int g = this.f3793b.m6358g(i);
        if (g >= 0) {
            LoaderInfo loaderInfo = (LoaderInfo) this.f3793b.m6357f(g);
            this.f3793b.m6355d(g);
            loaderInfo.m6364f();
        }
        g = this.f3794c.m6358g(i);
        if (g >= 0) {
            loaderInfo = (LoaderInfo) this.f3794c.m6357f(g);
            this.f3794c.m6355d(g);
            loaderInfo.m6364f();
        }
        if (this.f3796e != null && !mo878a()) {
            this.f3796e.mo872o().m6266h();
        }
    }

    public final <D> Loader<D> mo879b(int i) {
        if (this.f3799h) {
            throw new IllegalStateException("Called while creating a loader");
        }
        LoaderInfo loaderInfo = (LoaderInfo) this.f3793b.m6350a(i);
        if (loaderInfo == null) {
            return null;
        }
        if (loaderInfo.f3823n != null) {
            return loaderInfo.f3823n.f3813d;
        }
        return loaderInfo.f3813d;
    }

    final void m6336b() {
        if (f3792a) {
            Log.v("LoaderManager", "Starting in " + this);
        }
        if (this.f3797f) {
            Throwable runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStart when already started: " + this, runtimeException);
            return;
        }
        this.f3797f = true;
        for (int a = this.f3793b.m6348a() - 1; a >= 0; a--) {
            ((LoaderInfo) this.f3793b.m6357f(a)).m6359a();
        }
    }

    public final void m6337c() {
        if (f3792a) {
            Log.v("LoaderManager", "Stopping in " + this);
        }
        if (this.f3797f) {
            for (int a = this.f3793b.m6348a() - 1; a >= 0; a--) {
                ((LoaderInfo) this.f3793b.m6357f(a)).m6363e();
            }
            this.f3797f = false;
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doStop when not started: " + this, runtimeException);
    }

    public final void m6338d() {
        if (f3792a) {
            Log.v("LoaderManager", "Retaining in " + this);
        }
        if (this.f3797f) {
            this.f3798g = true;
            this.f3797f = false;
            for (int a = this.f3793b.m6348a() - 1; a >= 0; a--) {
                LoaderInfo loaderInfo = (LoaderInfo) this.f3793b.m6357f(a);
                if (f3792a) {
                    Log.v("LoaderManager", "  Retaining: " + loaderInfo);
                }
                loaderInfo.f3818i = true;
                loaderInfo.f3819j = loaderInfo.f3817h;
                loaderInfo.f3817h = false;
                loaderInfo.f3812c = null;
            }
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doRetain when not started: " + this, runtimeException);
    }

    final void m6339g() {
        for (int a = this.f3793b.m6348a() - 1; a >= 0; a--) {
            LoaderInfo loaderInfo = (LoaderInfo) this.f3793b.m6357f(a);
            if (loaderInfo.f3817h && loaderInfo.f3820k) {
                loaderInfo.f3820k = false;
                if (loaderInfo.f3814e) {
                    loaderInfo.m6362b(loaderInfo.f3813d, loaderInfo.f3816g);
                }
            }
        }
    }

    public final void m6340h() {
        int a;
        if (!this.f3798g) {
            if (f3792a) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (a = this.f3793b.m6348a() - 1; a >= 0; a--) {
                ((LoaderInfo) this.f3793b.m6357f(a)).m6364f();
            }
            this.f3793b.m6352b();
        }
        if (f3792a) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (a = this.f3794c.m6348a() - 1; a >= 0; a--) {
            ((LoaderInfo) this.f3794c.m6357f(a)).m6364f();
        }
        this.f3794c.m6352b();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(HTTPTransportCallback.BODY_BYTES_RECEIVED);
        stringBuilder.append("LoaderManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        DebugUtils.m13772a(this.f3796e, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public final void m6332a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i = 0;
        if (this.f3793b.m6348a() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i2 = 0; i2 < this.f3793b.m6348a(); i2++) {
                LoaderInfo loaderInfo = (LoaderInfo) this.f3793b.m6357f(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f3793b.m6356e(i2));
                printWriter.print(": ");
                printWriter.println(loaderInfo.toString());
                loaderInfo.m6361a(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.f3794c.m6348a() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            while (i < this.f3794c.m6348a()) {
                loaderInfo = (LoaderInfo) this.f3794c.m6357f(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f3794c.m6356e(i));
                printWriter.print(": ");
                printWriter.println(loaderInfo.toString());
                loaderInfo.m6361a(str3, fileDescriptor, printWriter, strArr);
                i++;
            }
        }
    }

    public final boolean mo878a() {
        int a = this.f3793b.m6348a();
        boolean z = false;
        for (int i = 0; i < a; i++) {
            int i2;
            LoaderInfo loaderInfo = (LoaderInfo) this.f3793b.m6357f(i);
            if (!loaderInfo.f3817h || loaderInfo.f3815f) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            z |= i2;
        }
        return z;
    }
}
