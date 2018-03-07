package android.support.v4.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.HashMap;

/* compiled from: work */
public abstract class AbstractFragmentHost extends FragmentHost implements Factory {
    private final Context f19a;
    public final FragmentManagerImpl f20b = new FragmentManagerImpl();
    private final MenuInflater f21c;
    private final LayoutInflater f22d;
    private final Handler f23e;
    private FragmentManager f24f;
    private HashMap<String, LoaderManagerImpl> f25g;

    /* compiled from: work */
    class FragmentTag {
        public static final int[] f18a = new int[]{16842755, 16842960, 16842961};
    }

    public AbstractFragmentHost(Context context) {
        this.f19a = context;
        this.f20b.a(this, this, null);
        this.f21c = new MenuInflater(h());
        this.f22d = LayoutInflater.from(h()).cloneInContext(h());
        if (this.f22d.getFactory() == null) {
            this.f22d.setFactory(this);
        }
        this.f23e = new Handler(h().getMainLooper());
    }

    public final void m40c() {
        this.f20b.p();
    }

    public final void m41f() {
        this.f20b.u();
    }

    public final Context m42h() {
        return this.f19a;
    }

    public final Handler m43i() {
        return this.f23e;
    }

    public Window mo10j() {
        return null;
    }

    public Resources mo11k() {
        return h().getResources();
    }

    public final void m46l() {
        this.f20b.x();
    }

    public final LayoutInflater m47m() {
        return this.f22d;
    }

    public final void m35a(Fragment fragment, Intent intent, int i) {
        h().startActivity(intent);
    }

    public final LoaderManagerImpl m33a(String str, boolean z, boolean z2) {
        if (this.f25g == null) {
            this.f25g = new HashMap();
        }
        LoaderManagerImpl loaderManagerImpl = (LoaderManagerImpl) this.f25g.get(str);
        if (loaderManagerImpl != null) {
            loaderManagerImpl.e = this;
            return loaderManagerImpl;
        } else if (!z2) {
            return loaderManagerImpl;
        } else {
            loaderManagerImpl = new LoaderManagerImpl(str, this, z);
            this.f25g.put(str, loaderManagerImpl);
            return loaderManagerImpl;
        }
    }

    public final void m37a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
    }

    public boolean mo12n() {
        return false;
    }

    public final FragmentManagerImpl m49o() {
        return this.f20b;
    }

    public final FragmentManager m50p() {
        return this.f20b;
    }

    public final void m34a(Fragment fragment) {
    }

    public boolean mo13q() {
        return false;
    }

    public final void m38a(String str) {
    }

    public final FragmentManager m52r() {
        return this.f24f;
    }

    public final void m36a(FragmentManager fragmentManager) {
        this.f24f = fragmentManager;
    }

    final void m39a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (!"fragment".equals(str)) {
            return null;
        }
        String string;
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, FragmentTag.f18a);
        if (attributeValue == null) {
            string = obtainStyledAttributes.getString(0);
        } else {
            string = attributeValue;
        }
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string2 = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (resourceId == -1 && string2 == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + string);
        }
        Fragment a;
        FragmentManagerImpl fragmentManagerImpl = this.f24f != null ? (FragmentManagerImpl) this.f24f : this.f20b;
        if (resourceId != -1) {
            a = fragmentManagerImpl.a(resourceId);
        } else {
            a = null;
        }
        if (a == null && string2 != null) {
            a = fragmentManagerImpl.a(string2);
        }
        if (FragmentManagerImpl.a) {
            Log.v("ViewGroupFragmentHost", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + string + " existing=" + a);
        }
        if (a == null) {
            Fragment a2 = Fragment.a(h(), string);
            a2.z = true;
            a2.H = resourceId != 0 ? resourceId : -1;
            a2.I = -1;
            a2.J = string2;
            a2.A = true;
            a2.D = fragmentManagerImpl;
            if ("com.google.android.gms.maps.SupportMapFragment".equals(a2.getClass().getName())) {
                a2.ak = new FakeActivityForMapFragment(a2, h());
            }
            a2.a(a2.ak, attributeSet, a2.n);
            fragmentManagerImpl.a(a2, true);
            a = a2;
        } else if (a.A) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string2 + ", or parent id 0x" + Integer.toHexString(-1) + " with another fragment for " + string);
        } else {
            a.A = true;
            if (!a.N) {
                a.a(null, attributeSet, a.n);
            }
            fragmentManagerImpl.c(a);
        }
        if (a.T == null) {
            throw new IllegalStateException("Fragment " + string + " did not create a view.");
        }
        if (resourceId != 0) {
            a.T.setId(resourceId);
        }
        if (a.T.getTag() == null) {
            a.T.setTag(string2);
        }
        return a.T;
    }
}
