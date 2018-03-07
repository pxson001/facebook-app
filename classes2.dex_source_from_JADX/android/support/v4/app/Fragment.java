package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.LoaderManagerImpl.LoaderInfo;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.SimpleArrayMap;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.proxygen.HTTPTransportCallback;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: {single=( */
public class Fragment implements ComponentCallbacks, OnCreateContextMenuListener {
    private static final SimpleArrayMap<String, Class<?>> f95a = new SimpleArrayMap();
    public static final Object f96j = new Object();
    public boolean f97A;
    public boolean f98B;
    public int f99C;
    public FragmentManagerImpl f100D;
    public FragmentHost f101E;
    public FragmentManagerImpl f102F;
    public Fragment f103G;
    public int f104H;
    public int f105I;
    public String f106J;
    public boolean f107K;
    public boolean f108L;
    public boolean f109M;
    public boolean f110N;
    public boolean f111O;
    public boolean f112P = true;
    boolean f113Q;
    int f114R;
    ViewGroup f115S;
    public View f116T;
    View f117U;
    boolean f118V;
    boolean f119W = true;
    public LoaderManagerImpl f120X;
    public boolean f121Y;
    public boolean f122Z;
    public Object aa = null;
    public Object ab = f96j;
    public Object ac = null;
    public Object ad = f96j;
    public Object ae = null;
    public Object af = f96j;
    Boolean ag;
    Boolean ah;
    public SharedElementCallback ai = null;
    SharedElementCallback aj = null;
    FakeActivityForMapFragment ak;
    int f123k = 0;
    View f124l;
    int f125m;
    public Bundle f126n;
    SparseArray<Parcelable> f127o;
    public int f128p = -1;
    public int f129q;
    public String f130r;
    public Bundle f131s;
    public Fragment f132t;
    int f133u = -1;
    int f134v;
    public boolean f135w;
    public boolean f136x;
    public boolean f137y;
    public boolean f138z;

    /* compiled from: {single=( */
    class C03981 implements FragmentContainer {
        final /* synthetic */ Fragment f8955a;

        C03981(Fragment fragment) {
            this.f8955a = fragment;
        }

        public final View mo856a(int i) {
            if (this.f8955a.f116T != null) {
                return this.f8955a.f116T.findViewById(i);
            }
            throw new IllegalStateException("Fragment does not have a view");
        }

        public final boolean mo857s() {
            return this.f8955a.f116T != null;
        }
    }

    public static Fragment m220a(Context context, String str) {
        return m221a(context, str, null);
    }

    public static Fragment m221a(Context context, String str, Bundle bundle) {
        try {
            Class cls = (Class) f95a.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                f95a.put(str, cls);
            }
            Fragment fragment = (Fragment) cls.newInstance();
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.f131s = bundle;
            }
            return fragment;
        } catch (Exception e) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e);
        } catch (Exception e2) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (Exception e22) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e22);
        }
    }

    static boolean m222b(Context context, String str) {
        try {
            Class cls = (Class) f95a.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                f95a.put(str, cls);
            }
            return Fragment.class.isAssignableFrom(cls);
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    final void m269f(Bundle bundle) {
        if (this.f127o != null) {
            this.f117U.restoreHierarchyState(this.f127o);
            this.f127o = null;
        }
        this.f113Q = false;
        m273h(bundle);
        if (!this.f113Q) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    public final void m244a(int i, Fragment fragment) {
        this.f128p = i;
        if (fragment != null) {
            this.f130r = fragment.f130r + ":" + this.f128p;
        } else {
            this.f130r = "android:fragment:" + this.f128p;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(HTTPTransportCallback.BODY_BYTES_RECEIVED);
        DebugUtils.m13772a(this, stringBuilder);
        if (this.f128p >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.f128p);
        }
        if (this.f104H != 0) {
            stringBuilder.append(" id=0x");
            stringBuilder.append(Integer.toHexString(this.f104H));
        }
        if (this.f106J != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.f106J);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void m271g(Bundle bundle) {
        if (this.f128p >= 0) {
            throw new IllegalStateException("Fragment already active");
        }
        this.f131s = bundle;
    }

    public final Bundle mt_() {
        return this.f131s;
    }

    public final void m250a(SavedState savedState) {
        if (this.f128p >= 0) {
            throw new IllegalStateException("Fragment already active");
        }
        Bundle bundle = (savedState == null || savedState.a == null) ? null : savedState.a;
        this.f126n = bundle;
    }

    public void m252a(Fragment fragment, int i) {
        this.f132t = fragment;
        this.f134v = i;
    }

    public final FragmentActivity m278o() {
        Context context = getContext();
        if (context == null || (context instanceof FragmentActivity)) {
            return (FragmentActivity) context;
        }
        if (this.ak != null) {
            return this.ak;
        }
        throw new IllegalStateException("Fragment is not hosted in an activity");
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        this.f101E.mo862a(contextMenu, view, contextMenuInfo);
    }

    public Context getContext() {
        return this.f101E == null ? null : this.f101E.mo865h();
    }

    public final Resources jW_() {
        if (this.f101E != null) {
            return this.f101E.mo868k();
        }
        throw new IllegalStateException("Fragment " + this + " not attached to FragmentHost");
    }

    public final CharSequence m241a(@StringRes int i) {
        return jW_().getText(i);
    }

    public final String m259b(@StringRes int i) {
        return jW_().getString(i);
    }

    public final String m242a(@StringRes int i, Object... objArr) {
        return jW_().getString(i, objArr);
    }

    public final FragmentManager mv_() {
        return this.f100D;
    }

    public final FragmentManager m279s() {
        if (this.f102F == null) {
            ax();
            if (this.f123k >= 5) {
                this.f102F.m6274p();
            } else if (this.f123k >= 4) {
                this.f102F.m6273o();
            } else if (this.f123k >= 2) {
                this.f102F.m6272n();
            } else if (this.f123k > 0) {
                this.f102F.m6271m();
            }
        }
        return this.f102F;
    }

    public final Fragment mw_() {
        return this.f103G;
    }

    public final Fragment m264d(int i) {
        if (this.f129q == i) {
            return this;
        }
        if (this.f102F != null) {
            return this.f102F.m6255c(i);
        }
        return null;
    }

    public final boolean mx_() {
        return this.f101E != null && this.f135w;
    }

    public final boolean m280w() {
        return this.f136x;
    }

    public final boolean m281y() {
        return this.f137y;
    }

    public final boolean m282z() {
        return (!mx_() || this.f107K || this.f116T == null || this.f116T.getWindowToken() == null || this.f116T.getVisibility() != 0) ? false : true;
    }

    public final boolean m223A() {
        return this.f107K;
    }

    public void mo1875c(boolean z) {
    }

    public final void m266d(boolean z) {
        if (!z || this.f103G == null) {
            this.f109M = z;
            return;
        }
        throw new IllegalStateException("Can't retain fragements that are nested in other fragments");
    }

    public final void m224C() {
        if (this.f101E != null && this.f111O && mx_() && !this.f107K && this.f112P) {
            this.f101E.mo869l();
        }
    }

    public void m268e(boolean z) {
        if (this.f111O != z) {
            this.f111O = z;
            if (mx_() && !this.f107K && this.f112P) {
                this.f101E.mo869l();
            }
        }
    }

    public void m270f(boolean z) {
        if (this.f112P != z) {
            this.f112P = z;
            if (this.f111O && mx_() && !this.f107K) {
                this.f101E.mo869l();
            }
        }
    }

    public void mo1860g(boolean z) {
        if (!this.f119W && z && this.f123k < 4) {
            this.f100D.m6248b(this);
        }
        this.f119W = z;
        this.f118V = !z;
    }

    public boolean m225D() {
        return this.f119W;
    }

    public final LoaderManager m226E() {
        if (this.f120X != null) {
            return this.f120X;
        }
        if (this.f101E == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to FragmentHost");
        }
        this.f122Z = true;
        this.f120X = this.f101E.mo858a(this.f130r, this.f121Y, true);
        return this.f120X;
    }

    public final void m247a(Intent intent) {
        if (this.f101E == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to FragmentHost");
        }
        this.f101E.mo860a(this, intent, -1);
    }

    public final void m248a(Intent intent, int i) {
        if (this.f101E == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to FragmentHost");
        }
        this.f101E.mo860a(this, intent, i);
    }

    public void mo1858a(int i, int i2, Intent intent) {
    }

    public LayoutInflater mo17b(Bundle bundle) {
        LayoutInflater cloneInContext = this.f101E.mo870m().cloneInContext(this.f101E.mo865h());
        m279s();
        cloneInContext.setFactory(this.f102F);
        return cloneInContext;
    }

    public void m246a(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.f113Q = true;
    }

    public void a_(Context context) {
        this.f113Q = true;
    }

    @Deprecated
    public void m245a(Activity activity) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2130497100);
        this.f113Q = true;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 5009832, a);
    }

    public void m251a(Fragment fragment) {
    }

    public Animation m240a(int i, boolean z, int i2) {
        return null;
    }

    public void mo15a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1363317491);
        this.f113Q = true;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1142559604, a);
    }

    public View mo1857a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -930881840, Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -683614892));
        return null;
    }

    public void mo1865a(View view, @Nullable Bundle bundle) {
    }

    @Nullable
    public final View m227F() {
        return this.f116T;
    }

    public void mo18d(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2116898651);
        this.f113Q = true;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2026142690, a);
    }

    public void m273h(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1107675319);
        this.f113Q = true;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -657716619, a);
    }

    public void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1404858125);
        this.f113Q = true;
        if (!this.f121Y) {
            this.f121Y = true;
            if (!this.f122Z) {
                this.f122Z = true;
                this.f120X = this.f101E.mo858a(this.f130r, this.f121Y, false);
            }
            if (this.f120X != null) {
                this.f120X.m6336b();
            }
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -844673562, a);
    }

    public void mo1884G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1428850017);
        this.f113Q = true;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 502121966, a);
    }

    public void mo20e(Bundle bundle) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.f113Q = true;
    }

    public void mo1885H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -805281132);
        this.f113Q = true;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -170025058, a);
    }

    public void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1511811473);
        this.f113Q = true;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -54749819, a);
    }

    public void onLowMemory() {
        this.f113Q = true;
    }

    public void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1359697154);
        this.f113Q = true;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 778030228, a);
    }

    public void mo1856I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -374694174);
        this.f113Q = true;
        if (!this.f122Z) {
            this.f122Z = true;
            this.f120X = this.f101E.mo858a(this.f130r, this.f121Y, false);
        }
        if (this.f120X != null) {
            this.f120X.m6340h();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1309629998, a);
    }

    public void dE_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -345755806);
        this.f113Q = true;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -930358346, a);
    }

    public View ab() {
        return null;
    }

    public void m254a(Menu menu, MenuInflater menuInflater) {
    }

    public void m253a(Menu menu) {
    }

    public void m231K() {
    }

    public boolean a_(MenuItem menuItem) {
        return false;
    }

    public boolean m260b(MenuItem menuItem) {
        return false;
    }

    public final boolean m232R() {
        return this.ah == null ? true : this.ah.booleanValue();
    }

    public final boolean m233S() {
        return this.ag == null ? true : this.ag.booleanValue();
    }

    public void mo1891a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.f104H));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.f105I));
        printWriter.print(" mTag=");
        printWriter.println(this.f106J);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f123k);
        printWriter.print(" mIndex=");
        printWriter.print(this.f128p);
        printWriter.print(" mWho=");
        printWriter.print(this.f130r);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.f99C);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.f135w);
        printWriter.print(" mRemoving=");
        printWriter.print(this.f136x);
        printWriter.print(" mResumed=");
        printWriter.print(this.f137y);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.f138z);
        printWriter.print(" mInLayout=");
        printWriter.println(this.f97A);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.f107K);
        printWriter.print(" mDetached=");
        printWriter.print(this.f108L);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.f112P);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.f111O);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.f109M);
        printWriter.print(" mRetaining=");
        printWriter.print(this.f110N);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.f119W);
        if (this.f100D != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.f100D);
        }
        if (this.f101E != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.f101E);
        }
        if (this.f103G != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.f103G);
        }
        if (this.f131s != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.f131s);
        }
        if (this.f126n != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.f126n);
        }
        if (this.f127o != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.f127o);
        }
        if (this.f132t != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(this.f132t);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.f134v);
        }
        if (this.f114R != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(this.f114R);
        }
        if (this.f115S != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.f115S);
        }
        if (this.f116T != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.f116T);
        }
        if (this.f117U != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.f116T);
        }
        if (this.f124l != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(this.f124l);
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(this.f125m);
        }
        if (this.f120X != null) {
            printWriter.print(str);
            printWriter.println("Loader Manager:");
            this.f120X.m6332a(str + "  ", fileDescriptor, printWriter, strArr);
        }
        if (this.f102F != null) {
            printWriter.print(str);
            printWriter.println("Child " + this.f102F + ":");
            this.f102F.mo847a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    private void ax() {
        if (this.f101E == null) {
            throw new IllegalStateException("Attempting to create a child FragmentManager, but this fragment is not associated with an activity.");
        }
        this.f102F = new FragmentManagerImpl();
        this.f102F.m6237a(this.f101E, new C03981(this), this);
    }

    final void m274i(Bundle bundle) {
        if (this.f102F != null) {
            this.f102F.m6270l();
        }
        this.f113Q = false;
        mo1876j(bundle);
        if (this.f113Q) {
            if (this.f102F == null) {
                ax();
            }
            if (bundle != null) {
                Parcelable parcelable = bundle.getParcelable("android:support:fragments");
                if (parcelable != null) {
                    this.f102F.m6233a(parcelable, null);
                }
            }
            this.f102F.m6271m();
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onCreate()");
    }

    protected void mo1876j(Bundle bundle) {
        mo15a(bundle);
    }

    final View m258b(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f102F != null) {
            this.f102F.m6270l();
        }
        return mo1873c(layoutInflater, viewGroup, bundle);
    }

    protected View mo1873c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return mo1857a(layoutInflater, viewGroup, bundle);
    }

    final void m276k(Bundle bundle) {
        if (this.f102F != null) {
            this.f102F.m6270l();
        }
        this.f113Q = false;
        mo1878l(bundle);
        if (!this.f113Q) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onActivityCreated()");
        } else if (this.f102F != null) {
            this.f102F.m6272n();
        }
    }

    protected void mo1878l(Bundle bundle) {
        mo18d(bundle);
    }

    final void m234T() {
        if (this.f102F != null) {
            this.f102F.m6270l();
            this.f102F.m6267i();
        }
        this.f113Q = false;
        mo1862U();
        if (this.f113Q) {
            if (this.f102F != null) {
                this.f102F.m6273o();
            }
            if (this.f120X != null) {
                this.f120X.m6339g();
                return;
            }
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStart()");
    }

    protected void mo1862U() {
        mi_();
    }

    final void m236V() {
        if (this.f102F != null) {
            this.f102F.m6270l();
            this.f102F.m6267i();
        }
        this.f113Q = false;
        mo1863W();
        if (!this.f113Q) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onResume()");
        } else if (this.f102F != null) {
            this.f102F.m6274p();
            this.f102F.m6267i();
        }
    }

    protected void mo1863W() {
        mo1884G();
    }

    public void mo1864Z() {
    }

    public void mo1874c(Menu menu, MenuInflater menuInflater) {
        m254a(menu, menuInflater);
    }

    public MenuInflater ad() {
        return null;
    }

    final void ae() {
        if (this.f102F != null) {
            this.f102F.m6275q();
        }
        this.f113Q = false;
        af();
        if (!this.f113Q) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    protected void af() {
        mo1885H();
    }

    final void ag() {
        if (this.f102F != null) {
            this.f102F.m6276r();
        }
        this.f113Q = false;
        ah();
        if (!this.f113Q) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    protected void ah() {
        mj_();
    }

    final void ai() {
        if (this.f102F != null) {
            this.f102F.m6277s();
        }
        if (this.f121Y) {
            this.f121Y = false;
            if (!this.f122Z) {
                this.f122Z = true;
                this.f120X = this.f101E.mo858a(this.f130r, this.f121Y, false);
            }
            if (this.f120X == null) {
                return;
            }
            if (this.f101E.mo871n()) {
                this.f120X.m6338d();
            } else {
                this.f120X.m6337c();
            }
        }
    }

    final void aj() {
        if (this.f102F != null) {
            this.f102F.m6278t();
        }
        this.f113Q = false;
        ak();
        if (!this.f113Q) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroyView()");
        } else if (this.f120X != null) {
            LoaderManagerImpl loaderManagerImpl = this.f120X;
            for (int a = loaderManagerImpl.f3793b.m6348a() - 1; a >= 0; a--) {
                ((LoaderInfo) loaderManagerImpl.f3793b.m6357f(a)).f3820k = true;
            }
        }
    }

    protected void ak() {
        mY_();
    }

    final void al() {
        if (this.f102F != null) {
            this.f102F.m6279u();
            this.f102F = null;
        }
        this.f113Q = false;
        am();
        if (!this.f113Q) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroy()");
        }
    }

    protected void am() {
        mo1856I();
    }
}
