package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.BackStackRecord.TransitionState;
import android.support.v4.app.Fragment.SavedState;
import android.support.v4.app.FragmentManager.OnBackStackChangedListener;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.LogWriter;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater.Factory;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* compiled from: }') */
public final class FragmentManagerImpl extends FragmentManager implements Factory {
    static final Interpolator f3761A = new DecelerateInterpolator(1.5f);
    static final Interpolator f3762B = new AccelerateInterpolator(2.5f);
    static final Interpolator f3763C = new AccelerateInterpolator(1.5f);
    public static boolean f3764a = false;
    static final boolean f3765b;
    static final Interpolator f3766z = new DecelerateInterpolator(2.5f);
    ArrayList<Runnable> f3767c;
    Runnable[] f3768d;
    boolean f3769e;
    ArrayList<Fragment> f3770f;
    ArrayList<Integer> f3771g;
    ArrayList<BackStackRecord> f3772h;
    ArrayList<Fragment> f3773i;
    ArrayList<BackStackRecord> f3774j;
    ArrayList<Integer> f3775k;
    ArrayList<OnBackStackChangedListener> f3776l;
    int f3777m = 0;
    ArrayList<Fragment> mAdded;
    FragmentHost f3778n;
    FragmentContainer f3779o;
    Fragment f3780p;
    boolean f3781q;
    boolean f3782r;
    boolean f3783s;
    String f3784t;
    boolean f3785u;
    Exception f3786v;
    Bundle f3787w = null;
    SparseArray<Parcelable> f3788x = null;
    Runnable f3789y = new C02191(this);

    /* compiled from: }') */
    class C02191 implements Runnable {
        final /* synthetic */ FragmentManagerImpl f3833a;

        C02191(FragmentManagerImpl fragmentManagerImpl) {
            this.f3833a = fragmentManagerImpl;
        }

        public void run() {
            this.f3833a.m6267i();
        }
    }

    FragmentManagerImpl() {
    }

    static {
        boolean z = false;
        if (VERSION.SDK_INT >= 11) {
            z = true;
        }
        f3765b = z;
    }

    public final int m6246b(int i) {
        if (this.f3770f != null) {
            Iterator it = this.f3770f.iterator();
            while (it.hasNext()) {
                Fragment fragment = (Fragment) it.next();
                if (fragment != null) {
                    if (fragment.f102F != null) {
                        fragment.f129q = fragment.f102F.m6246b(i) + 1;
                    } else {
                        fragment.f129q = i + 1;
                    }
                    i = fragment.f129q;
                }
            }
        }
        return i;
    }

    public final Fragment m6255c(int i) {
        if (this.f3770f == null) {
            return null;
        }
        Iterator it = this.f3770f.iterator();
        while (it.hasNext()) {
            Fragment fragment = (Fragment) it.next();
            if (fragment != null && fragment.f129q >= i) {
                return fragment.m264d(i);
            }
        }
        return null;
    }

    private void m6215a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
        if (this.f3778n != null) {
            try {
                this.f3778n.mo864a("  ", null, printWriter, new String[0]);
            } catch (Throwable e) {
                Log.e("FragmentManager", "Failed dumping state", e);
            }
        } else {
            try {
                mo847a("  ", null, printWriter, new String[0]);
            } catch (Throwable e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        }
        throw runtimeException;
    }

    public final FragmentTransaction mo842a() {
        return new BackStackRecord(this);
    }

    public final boolean mo849b() {
        return m6267i();
    }

    public final void mo852d() {
        m6239a(new 2(this), false);
    }

    public final boolean mo853e() {
        m6208A();
        mo849b();
        return m6245a(null, -1, 0);
    }

    public final void mo846a(String str, int i) {
        m6239a(new 3(this, str, i), false);
    }

    public final boolean mo850b(String str, int i) {
        m6208A();
        mo849b();
        return m6245a(str, -1, i);
    }

    public final void mo843a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Bad id: " + i);
        }
        m6239a(new 4(this, i, i2), false);
    }

    public final int mo854f() {
        return this.f3772h != null ? this.f3772h.size() : 0;
    }

    public final void mo845a(OnBackStackChangedListener onBackStackChangedListener) {
        if (this.f3776l == null) {
            this.f3776l = new ArrayList();
        }
        this.f3776l.add(onBackStackChangedListener);
    }

    public final void mo848b(OnBackStackChangedListener onBackStackChangedListener) {
        if (this.f3776l != null) {
            this.f3776l.remove(onBackStackChangedListener);
        }
    }

    public final void mo844a(Bundle bundle, String str, Fragment fragment) {
        if (fragment.f128p < 0) {
            m6215a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putInt(str, fragment.f128p);
    }

    public final Fragment mo840a(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        if (i >= this.f3770f.size()) {
            m6215a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        }
        Fragment fragment = (Fragment) this.f3770f.get(i);
        if (fragment != null) {
            return fragment;
        }
        m6215a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        return fragment;
    }

    public final SavedState mo838a(Fragment fragment) {
        if (fragment.f128p < 0) {
            m6215a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        if (fragment.f123k <= 0) {
            return null;
        }
        Bundle h = m6222h(fragment);
        if (h != null) {
            return new SavedState(h);
        }
        return null;
    }

    public final boolean mo855g() {
        return this.f3783s;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(HTTPTransportCallback.BODY_BYTES_RECEIVED);
        stringBuilder.append("FragmentManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        if (this.f3780p != null) {
            DebugUtils.m13772a(this.f3780p, stringBuilder);
        } else {
            DebugUtils.m13772a(this.f3778n, stringBuilder);
        }
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public final void mo847a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int i;
        Fragment fragment;
        int i2 = 0;
        String str2 = str + "    ";
        if (this.f3770f != null) {
            size = this.f3770f.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.print("Active Fragments in ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this)));
                printWriter.println(":");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.f3770f.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment);
                    if (fragment != null) {
                        fragment.mo1891a(str2, fileDescriptor, printWriter, strArr);
                    }
                }
            }
        }
        if (this.mAdded != null) {
            size = this.mAdded.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Added Fragments:");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.mAdded.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment.toString());
                }
            }
        }
        if (this.f3773i != null) {
            size = this.f3773i.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Fragments Created Menus:");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.f3773i.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment.toString());
                }
            }
        }
        if (this.f3772h != null) {
            size = this.f3772h.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack:");
                for (i = 0; i < size; i++) {
                    BackStackRecord backStackRecord = (BackStackRecord) this.f3772h.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(backStackRecord.toString());
                    backStackRecord.m13708a(str2, printWriter);
                }
            }
        }
        synchronized (this) {
            if (this.f3774j != null) {
                int size2 = this.f3774j.size();
                if (size2 > 0) {
                    printWriter.print(str);
                    printWriter.println("Back Stack Indices:");
                    for (i = 0; i < size2; i++) {
                        backStackRecord = (BackStackRecord) this.f3774j.get(i);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i);
                        printWriter.print(": ");
                        printWriter.println(backStackRecord);
                    }
                }
            }
            if (this.f3775k != null && this.f3775k.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.f3775k.toArray()));
            }
        }
        if (this.f3767c != null) {
            i = this.f3767c.size();
            if (i > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                while (i2 < i) {
                    Runnable runnable = (Runnable) this.f3767c.get(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i2);
                    printWriter.print(": ");
                    printWriter.println(runnable);
                    i2++;
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mActivity=");
        printWriter.println(this.f3778n);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f3779o);
        if (this.f3780p != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f3780p);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f3777m);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f3782r);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f3783s);
        if (this.f3781q) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f3781q);
        }
        if (this.f3784t != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.f3784t);
        }
        if (this.f3771g != null && this.f3771g.size() > 0) {
            printWriter.print(str);
            printWriter.print("  mAvailIndices: ");
            printWriter.println(Arrays.toString(this.f3771g.toArray()));
        }
    }

    private static Animation m6211a(float f, float f2, float f3, float f4) {
        Animation animationSet = new AnimationSet(false);
        Animation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(f3766z);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        scaleAnimation = new AlphaAnimation(f3, f4);
        scaleAnimation.setInterpolator(f3761A);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        return animationSet;
    }

    private static Animation m6210a(float f, float f2) {
        Animation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(f3761A);
        alphaAnimation.setDuration(220);
        return alphaAnimation;
    }

    private Animation m6212a(Fragment fragment, int i, boolean z, int i2) {
        Animation a = fragment.m240a(i, z, fragment.f114R);
        if (a != null) {
            return a;
        }
        if (fragment.f114R != 0) {
            a = AnimationUtils.loadAnimation(this.f3778n.mo865h(), fragment.f114R);
            if (a != null) {
                return a;
            }
        }
        if (i == 0) {
            return null;
        }
        int b = m6216b(i, z);
        if (b < 0) {
            return null;
        }
        switch (b) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return m6211a(1.125f, 1.0f, 0.0f, 1.0f);
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return m6211a(1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return m6211a(0.975f, 1.0f, 0.0f, 1.0f);
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return m6211a(1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return m6210a(0.0f, 1.0f);
            case 6:
                return m6210a(1.0f, 0.0f);
            default:
                if (i2 == 0 && this.f3778n.mo867j() != null) {
                    i2 = this.f3778n.mo867j().getAttributes().windowAnimations;
                }
                if (i2 == 0) {
                    return null;
                }
                return null;
        }
    }

    public final void m6248b(Fragment fragment) {
        if (!fragment.f118V) {
            return;
        }
        if (this.f3769e) {
            this.f3785u = true;
            return;
        }
        fragment.f118V = false;
        m6235a(fragment, this.f3777m, 0, 0, false);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final void m6235a(android.support.v4.app.Fragment r10, int r11, int r12, int r13, boolean r14) {
        /*
        r9 = this;
        r8 = 4;
        r6 = 3;
        r5 = 1;
        r3 = 0;
        r7 = 0;
        r0 = r10.f135w;
        if (r0 == 0) goto L_0x000d;
    L_0x0009:
        r0 = r10.f108L;
        if (r0 == 0) goto L_0x0010;
    L_0x000d:
        if (r11 <= r5) goto L_0x0010;
    L_0x000f:
        r11 = r5;
    L_0x0010:
        r0 = r10.f136x;
        if (r0 == 0) goto L_0x001a;
    L_0x0014:
        r0 = r10.f123k;
        if (r11 <= r0) goto L_0x001a;
    L_0x0018:
        r11 = r10.f123k;
    L_0x001a:
        r0 = r10.f118V;
        if (r0 == 0) goto L_0x0025;
    L_0x001e:
        r0 = r10.f123k;
        if (r0 >= r8) goto L_0x0025;
    L_0x0022:
        if (r11 <= r6) goto L_0x0025;
    L_0x0024:
        r11 = r6;
    L_0x0025:
        r0 = r10.f123k;
        if (r0 >= r11) goto L_0x0274;
    L_0x0029:
        r0 = r10.f138z;
        if (r0 == 0) goto L_0x0032;
    L_0x002d:
        r0 = r10.f97A;
        if (r0 != 0) goto L_0x0032;
    L_0x0031:
        return;
    L_0x0032:
        r0 = r10.f124l;
        if (r0 == 0) goto L_0x0040;
    L_0x0036:
        r10.f124l = r7;
        r2 = r10.f125m;
        r0 = r9;
        r1 = r10;
        r4 = r3;
        r0.m6235a(r1, r2, r3, r4, r5);
    L_0x0040:
        r0 = r10.f123k;
        switch(r0) {
            case 0: goto L_0x0048;
            case 1: goto L_0x0169;
            case 2: goto L_0x0224;
            case 3: goto L_0x0224;
            case 4: goto L_0x0241;
            default: goto L_0x0045;
        };
    L_0x0045:
        r10.f123k = r11;
        goto L_0x0031;
    L_0x0048:
        r0 = f3764a;
        if (r0 == 0) goto L_0x0060;
    L_0x004c:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r2 = "moveto CREATED: ";
        r1.<init>(r2);
        r1 = r1.append(r10);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0060:
        r0 = r10.f126n;
        if (r0 == 0) goto L_0x00a8;
    L_0x0064:
        r0 = r10.f126n;
        r1 = r9.f3778n;
        r1 = r1.mo865h();
        r1 = r1.getClassLoader();
        r0.setClassLoader(r1);
        r0 = r10.f126n;
        r1 = "android:view_state";
        r0 = r0.getSparseParcelableArray(r1);
        r10.f127o = r0;
        r0 = r10.f126n;
        r1 = "android:target_state";
        r0 = r9.mo840a(r0, r1);
        r10.f132t = r0;
        r0 = r10.f132t;
        if (r0 == 0) goto L_0x0095;
    L_0x008b:
        r0 = r10.f126n;
        r1 = "android:target_req_state";
        r0 = r0.getInt(r1, r3);
        r10.f134v = r0;
    L_0x0095:
        r0 = r10.f126n;
        r1 = "android:user_visible_hint";
        r0 = r0.getBoolean(r1, r5);
        r10.f119W = r0;
        r0 = r10.f119W;
        if (r0 != 0) goto L_0x00a8;
    L_0x00a3:
        r10.f118V = r5;
        if (r11 <= r6) goto L_0x00a8;
    L_0x00a7:
        r11 = r6;
    L_0x00a8:
        r0 = r9.f3778n;
        r10.f101E = r0;
        r0 = r9.f3780p;
        r10.f103G = r0;
        r0 = r9.f3780p;
        if (r0 == 0) goto L_0x00e4;
    L_0x00b4:
        r0 = r9.f3780p;
        r0 = r0.f102F;
    L_0x00b8:
        r10.f100D = r0;
        r10.f113Q = r3;
        r0 = r9.f3778n;
        r0 = r0.mo865h();
        r10.a_(r0);
        r0 = r10.f113Q;
        if (r0 != 0) goto L_0x00eb;
    L_0x00c9:
        r0 = new android.support.v4.app.SuperNotCalledException;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r10);
        r2 = " did not call through to super.onAttach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x00e4:
        r0 = r9.f3778n;
        r0 = r0.mo872o();
        goto L_0x00b8;
    L_0x00eb:
        r0 = r9.f3778n;
        r0 = r0.mo865h();
        r0 = r0 instanceof android.app.Activity;
        if (r0 == 0) goto L_0x0121;
    L_0x00f5:
        r10.f113Q = r3;
        r0 = r9.f3778n;
        r0 = r0.mo865h();
        r0 = (android.app.Activity) r0;
        r10.m245a(r0);
        r0 = r10.f113Q;
        if (r0 != 0) goto L_0x0121;
    L_0x0106:
        r0 = new android.support.v4.app.SuperNotCalledException;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r10);
        r2 = " did not call through to super.onAttach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0121:
        r0 = r10.f103G;
        if (r0 != 0) goto L_0x0266;
    L_0x0125:
        r0 = r9.f3778n;
        r0.mo859a(r10);
    L_0x012a:
        r0 = r10.f110N;
        if (r0 != 0) goto L_0x0133;
    L_0x012e:
        r0 = r10.f126n;
        r10.m274i(r0);
    L_0x0133:
        r10.f110N = r3;
        r0 = r10.f138z;
        if (r0 == 0) goto L_0x0169;
    L_0x0139:
        r0 = r10.f126n;
        r0 = r10.mo17b(r0);
        r1 = r10.f126n;
        r0 = r10.m258b(r0, r7, r1);
        r10.f116T = r0;
        r0 = r10.f116T;
        if (r0 == 0) goto L_0x026d;
    L_0x014b:
        r0 = r10.f116T;
        r10.f117U = r0;
        r0 = r10.f116T;
        r0 = android.support.v4.app.NoSaveStateFrameLayout.m13818a(r0);
        r10.f116T = r0;
        r0 = r10.f107K;
        if (r0 == 0) goto L_0x0162;
    L_0x015b:
        r0 = r10.f116T;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x0162:
        r0 = r10.f116T;
        r1 = r10.f126n;
        r10.mo1865a(r0, r1);
    L_0x0169:
        if (r11 <= r5) goto L_0x0224;
    L_0x016b:
        r0 = f3764a;
        if (r0 == 0) goto L_0x0183;
    L_0x016f:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r2 = "moveto ACTIVITY_CREATED: ";
        r1.<init>(r2);
        r1 = r1.append(r10);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0183:
        r0 = r10.f138z;
        if (r0 != 0) goto L_0x0214;
    L_0x0187:
        r0 = r10.f105I;
        if (r0 == 0) goto L_0x03b6;
    L_0x018b:
        r0 = r9.f3779o;
        r1 = r10.f105I;
        r0 = r0.mo856a(r1);
        r0 = (android.view.ViewGroup) r0;
        if (r0 != 0) goto L_0x01d0;
    L_0x0197:
        r1 = r10.f98B;
        if (r1 != 0) goto L_0x01d0;
    L_0x019b:
        r1 = new java.lang.IllegalArgumentException;
        r2 = new java.lang.StringBuilder;
        r3 = "No view found for id 0x";
        r2.<init>(r3);
        r3 = r10.f105I;
        r3 = java.lang.Integer.toHexString(r3);
        r2 = r2.append(r3);
        r3 = " (";
        r2 = r2.append(r3);
        r3 = m6217d(r10);
        r2 = r2.append(r3);
        r3 = ") for fragment ";
        r2 = r2.append(r3);
        r2 = r2.append(r10);
        r2 = r2.toString();
        r1.<init>(r2);
        r9.m6215a(r1);
    L_0x01d0:
        r10.f115S = r0;
        r1 = r10.f126n;
        r1 = r10.mo17b(r1);
        r2 = r10.f126n;
        r1 = r10.m258b(r1, r0, r2);
        r10.f116T = r1;
        r1 = r10.f116T;
        if (r1 == 0) goto L_0x0271;
    L_0x01e4:
        r1 = r10.f116T;
        r10.f117U = r1;
        r1 = r10.f116T;
        r1 = android.support.v4.app.NoSaveStateFrameLayout.m13818a(r1);
        r10.f116T = r1;
        if (r0 == 0) goto L_0x0202;
    L_0x01f2:
        r1 = r9.m6212a(r10, r12, r5, r13);
        if (r1 == 0) goto L_0x01fd;
    L_0x01f8:
        r2 = r10.f116T;
        r2.startAnimation(r1);
    L_0x01fd:
        r1 = r10.f116T;
        r0.addView(r1);
    L_0x0202:
        r0 = r10.f107K;
        if (r0 == 0) goto L_0x020d;
    L_0x0206:
        r0 = r10.f116T;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x020d:
        r0 = r10.f116T;
        r1 = r10.f126n;
        r10.mo1865a(r0, r1);
    L_0x0214:
        r0 = r10.f126n;
        r10.m276k(r0);
        r0 = r10.f116T;
        if (r0 == 0) goto L_0x0222;
    L_0x021d:
        r0 = r10.f126n;
        r10.m269f(r0);
    L_0x0222:
        r10.f126n = r7;
    L_0x0224:
        if (r11 <= r6) goto L_0x0241;
    L_0x0226:
        r0 = f3764a;
        if (r0 == 0) goto L_0x023e;
    L_0x022a:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r2 = "moveto STARTED: ";
        r1.<init>(r2);
        r1 = r1.append(r10);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x023e:
        r10.m234T();
    L_0x0241:
        if (r11 <= r8) goto L_0x0045;
    L_0x0243:
        r0 = f3764a;
        if (r0 == 0) goto L_0x025b;
    L_0x0247:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r2 = "moveto RESUMED: ";
        r1.<init>(r2);
        r1 = r1.append(r10);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x025b:
        r10.f137y = r5;
        r10.m236V();
        r10.f126n = r7;
        r10.f127o = r7;
        goto L_0x0045;
    L_0x0266:
        r0 = r9.f3780p;
        r0.m251a(r10);
        goto L_0x012a;
    L_0x026d:
        r10.f117U = r7;
        goto L_0x0169;
    L_0x0271:
        r10.f117U = r7;
        goto L_0x0214;
    L_0x0274:
        r0 = r10.f123k;
        if (r0 <= r11) goto L_0x0045;
    L_0x0278:
        r0 = r10.f123k;
        switch(r0) {
            case 1: goto L_0x027f;
            case 2: goto L_0x02f3;
            case 3: goto L_0x02d6;
            case 4: goto L_0x02b9;
            case 5: goto L_0x0299;
            default: goto L_0x027d;
        };
    L_0x027d:
        goto L_0x0045;
    L_0x027f:
        if (r11 > 0) goto L_0x0045;
    L_0x0281:
        r0 = r9.f3783s;
        if (r0 == 0) goto L_0x0290;
    L_0x0285:
        r0 = r10.f124l;
        if (r0 == 0) goto L_0x0290;
    L_0x0289:
        r0 = r10.f124l;
        r10.f124l = r7;
        r0.clearAnimation();
    L_0x0290:
        r0 = r10.f124l;
        if (r0 == 0) goto L_0x035c;
    L_0x0294:
        r10.f125m = r11;
        r11 = r5;
        goto L_0x0045;
    L_0x0299:
        r0 = 5;
        if (r11 >= r0) goto L_0x02b9;
    L_0x029c:
        r0 = f3764a;
        if (r0 == 0) goto L_0x02b4;
    L_0x02a0:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r2 = "movefrom RESUMED: ";
        r1.<init>(r2);
        r1 = r1.append(r10);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02b4:
        r10.ae();
        r10.f137y = r3;
    L_0x02b9:
        if (r11 >= r8) goto L_0x02d6;
    L_0x02bb:
        r0 = f3764a;
        if (r0 == 0) goto L_0x02d3;
    L_0x02bf:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r2 = "movefrom STARTED: ";
        r1.<init>(r2);
        r1 = r1.append(r10);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02d3:
        r10.ag();
    L_0x02d6:
        if (r11 >= r6) goto L_0x02f3;
    L_0x02d8:
        r0 = f3764a;
        if (r0 == 0) goto L_0x02f0;
    L_0x02dc:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r2 = "movefrom STOPPED: ";
        r1.<init>(r2);
        r1 = r1.append(r10);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02f0:
        r10.ai();
    L_0x02f3:
        r0 = 2;
        if (r11 >= r0) goto L_0x027f;
    L_0x02f6:
        r0 = f3764a;
        if (r0 == 0) goto L_0x030e;
    L_0x02fa:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r2 = "movefrom ACTIVITY_CREATED: ";
        r1.<init>(r2);
        r1 = r1.append(r10);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x030e:
        r0 = r10.f116T;
        if (r0 == 0) goto L_0x0321;
    L_0x0312:
        r0 = r9.f3778n;
        r0 = r0.mo874q();
        if (r0 != 0) goto L_0x0321;
    L_0x031a:
        r0 = r10.f127o;
        if (r0 != 0) goto L_0x0321;
    L_0x031e:
        r9.m6221g(r10);
    L_0x0321:
        r10.aj();
        r0 = r10.f116T;
        if (r0 == 0) goto L_0x0354;
    L_0x0328:
        r0 = r10.f115S;
        if (r0 == 0) goto L_0x0354;
    L_0x032c:
        r0 = r9.f3777m;
        if (r0 <= 0) goto L_0x03b4;
    L_0x0330:
        r0 = r9.f3783s;
        if (r0 != 0) goto L_0x03b4;
    L_0x0334:
        r0 = r9.m6212a(r10, r12, r3, r13);
    L_0x0338:
        if (r0 == 0) goto L_0x034d;
    L_0x033a:
        r1 = r10.f116T;
        r10.f124l = r1;
        r10.f125m = r11;
        r1 = new android.support.v4.app.FragmentManagerImpl$5;
        r1.<init>(r9, r10);
        r0.setAnimationListener(r1);
        r1 = r10.f116T;
        r1.startAnimation(r0);
    L_0x034d:
        r0 = r10.f115S;
        r1 = r10.f116T;
        r0.removeView(r1);
    L_0x0354:
        r10.f115S = r7;
        r10.f116T = r7;
        r10.f117U = r7;
        goto L_0x027f;
    L_0x035c:
        r0 = f3764a;
        if (r0 == 0) goto L_0x0374;
    L_0x0360:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r2 = "movefrom CREATED: ";
        r1.<init>(r2);
        r1 = r1.append(r10);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0374:
        r0 = r10.f110N;
        if (r0 != 0) goto L_0x037b;
    L_0x0378:
        r10.al();
    L_0x037b:
        r10.f113Q = r3;
        r10.dE_();
        r0 = r10.f113Q;
        if (r0 != 0) goto L_0x039f;
    L_0x0384:
        r0 = new android.support.v4.app.SuperNotCalledException;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r10);
        r2 = " did not call through to super.onDetach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x039f:
        if (r14 != 0) goto L_0x0045;
    L_0x03a1:
        r0 = r10.f110N;
        if (r0 != 0) goto L_0x03aa;
    L_0x03a5:
        r9.m6220f(r10);
        goto L_0x0045;
    L_0x03aa:
        r10.f101E = r7;
        r10.f103G = r7;
        r10.f100D = r7;
        r10.f102F = r7;
        goto L_0x0045;
    L_0x03b4:
        r0 = r7;
        goto L_0x0338;
    L_0x03b6:
        r0 = r7;
        goto L_0x01d0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.FragmentManagerImpl.a(android.support.v4.app.Fragment, int, int, int, boolean):void");
    }

    private static String m6217d(Fragment fragment) {
        try {
            return fragment.jW_().getResourceName(fragment.f105I);
        } catch (NotFoundException e) {
            return "not-found";
        }
    }

    final void m6256c(Fragment fragment) {
        m6235a(fragment, this.f3777m, 0, 0, false);
    }

    private void m6214a(int i, boolean z) {
        m6230a(i, 0, 0, z);
    }

    final void m6230a(int i, int i2, int i3, boolean z) {
        if (this.f3778n == null && i != 0) {
            throw new IllegalStateException("No activity");
        } else if (z || this.f3777m != i) {
            this.f3777m = i;
            if (this.f3770f != null) {
                int i4 = 0;
                int i5 = 0;
                while (i4 < this.f3770f.size()) {
                    int a;
                    Fragment fragment = (Fragment) this.f3770f.get(i4);
                    if (fragment != null) {
                        m6235a(fragment, i, i2, i3, false);
                        if (fragment.f120X != null) {
                            a = i5 | fragment.f120X.mo878a();
                            i4++;
                            i5 = a;
                        }
                    }
                    a = i5;
                    i4++;
                    i5 = a;
                }
                if (i5 == 0) {
                    m6266h();
                }
                if (this.f3781q && this.f3778n != null && this.f3777m == 5) {
                    this.f3778n.mo869l();
                    this.f3781q = false;
                }
            }
        }
    }

    final void m6266h() {
        if (this.f3770f != null) {
            for (int i = 0; i < this.f3770f.size(); i++) {
                Fragment fragment = (Fragment) this.f3770f.get(i);
                if (fragment != null) {
                    m6248b(fragment);
                }
            }
        }
    }

    private void m6219e(Fragment fragment) {
        if (fragment.f128p < 0) {
            if (this.f3771g == null || this.f3771g.size() <= 0) {
                if (this.f3770f == null) {
                    this.f3770f = new ArrayList();
                }
                fragment.m244a(this.f3770f.size(), this.f3780p);
                this.f3770f.add(fragment);
            } else {
                fragment.m244a(((Integer) this.f3771g.remove(this.f3771g.size() - 1)).intValue(), this.f3780p);
                this.f3770f.set(fragment.f128p, fragment);
            }
            if (f3764a) {
                Log.v("FragmentManager", "Allocated fragment index " + fragment);
            }
        }
    }

    private void m6220f(Fragment fragment) {
        if (fragment.f128p >= 0) {
            if (f3764a) {
                Log.v("FragmentManager", "Freeing fragment index " + fragment);
            }
            this.f3770f.set(fragment.f128p, null);
            fragment.f129q = -1;
            if (this.f3771g == null) {
                this.f3771g = new ArrayList();
            }
            this.f3771g.add(Integer.valueOf(fragment.f128p));
            this.f3778n.mo863a(fragment.f130r);
            fragment.f128p = -1;
            fragment.f130r = null;
            fragment.f135w = false;
            fragment.f136x = false;
            fragment.f137y = false;
            fragment.f138z = false;
            fragment.f97A = false;
            fragment.f98B = false;
            fragment.f99C = 0;
            fragment.f100D = null;
            fragment.f102F = null;
            fragment.f101E = null;
            fragment.f104H = 0;
            fragment.f105I = 0;
            fragment.f106J = null;
            fragment.f107K = false;
            fragment.f108L = false;
            fragment.f110N = false;
            fragment.f120X = null;
            fragment.f121Y = false;
            fragment.f122Z = false;
        }
    }

    public final void m6236a(Fragment fragment, boolean z) {
        if (this.mAdded == null) {
            this.mAdded = new ArrayList();
        }
        if (f3764a) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        m6219e(fragment);
        if (!fragment.f108L) {
            if (this.mAdded.contains(fragment)) {
                throw new IllegalStateException("Fragment already added: " + fragment);
            }
            this.mAdded.add(fragment);
            fragment.f135w = true;
            fragment.f136x = false;
            if (fragment.f111O && fragment.f112P) {
                this.f3781q = true;
            }
            if (z) {
                m6256c(fragment);
            }
        }
    }

    public final void m6234a(Fragment fragment, int i, int i2) {
        Object obj;
        boolean z;
        if (f3764a) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.f99C);
        }
        if (fragment.f99C > 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            z = true;
        } else {
            z = false;
        }
        if (!fragment.f108L || z) {
            int i3;
            if (this.mAdded != null) {
                this.mAdded.remove(fragment);
            }
            if (fragment.f111O && fragment.f112P) {
                this.f3781q = true;
            }
            fragment.f135w = false;
            fragment.f136x = true;
            if (z) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            m6235a(fragment, i3, i, i2, false);
        }
    }

    public final void m6249b(Fragment fragment, int i, int i2) {
        if (f3764a) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (!fragment.f107K) {
            fragment.f107K = true;
            if (fragment.f116T != null) {
                Animation a = m6212a(fragment, i, false, i2);
                if (a != null) {
                    fragment.f116T.startAnimation(a);
                }
                fragment.f116T.setVisibility(8);
            }
            if (fragment.f135w && fragment.f111O && fragment.f112P) {
                this.f3781q = true;
            }
            fragment.mo1875c(true);
        }
    }

    public final void m6257c(Fragment fragment, int i, int i2) {
        if (f3764a) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.f107K) {
            fragment.f107K = false;
            if (fragment.f116T != null) {
                Animation a = m6212a(fragment, i, false, i2);
                if (a != null) {
                    fragment.f116T.startAnimation(a);
                }
                fragment.f116T.setVisibility(0);
            }
            if (fragment.f135w && fragment.f111O && fragment.f112P) {
                this.f3781q = true;
            }
            fragment.mo1875c(false);
        }
    }

    public final void m6261d(Fragment fragment, int i, int i2) {
        if (f3764a) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (!fragment.f108L) {
            fragment.f108L = true;
            if (fragment.f135w) {
                if (this.mAdded != null) {
                    if (f3764a) {
                        Log.v("FragmentManager", "remove from detach: " + fragment);
                    }
                    this.mAdded.remove(fragment);
                }
                if (fragment.f111O && fragment.f112P) {
                    this.f3781q = true;
                }
                fragment.f135w = false;
                m6235a(fragment, 1, i, i2, false);
            }
        }
    }

    public final void m6262e(Fragment fragment, int i, int i2) {
        if (f3764a) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.f108L) {
            fragment.f108L = false;
            if (!fragment.f135w) {
                if (this.mAdded == null) {
                    this.mAdded = new ArrayList();
                }
                if (this.mAdded.contains(fragment)) {
                    throw new IllegalStateException("Fragment already added: " + fragment);
                }
                if (f3764a) {
                    Log.v("FragmentManager", "add from attach: " + fragment);
                }
                this.mAdded.add(fragment);
                fragment.f135w = true;
                if (fragment.f111O && fragment.f112P) {
                    this.f3781q = true;
                }
                m6235a(fragment, this.f3777m, i, i2, false);
            }
        }
    }

    public final Fragment mo839a(int i) {
        int size;
        Fragment fragment;
        if (this.mAdded != null) {
            for (size = this.mAdded.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.mAdded.get(size);
                if (fragment != null && fragment.f104H == i) {
                    return fragment;
                }
            }
        }
        if (this.f3770f != null) {
            for (size = this.f3770f.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f3770f.get(size);
                if (fragment != null && fragment.f104H == i) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public final Fragment mo841a(String str) {
        int size;
        Fragment fragment;
        if (!(this.mAdded == null || str == null)) {
            for (size = this.mAdded.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.mAdded.get(size);
                if (fragment != null && str.equals(fragment.f106J)) {
                    return fragment;
                }
            }
        }
        if (!(this.f3770f == null || str == null)) {
            for (size = this.f3770f.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f3770f.get(size);
                if (fragment != null && str.equals(fragment.f106J)) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public final boolean mo851c() {
        return !this.f3782r && this.f3784t == null;
    }

    private void m6208A() {
        if (this.f3782r) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.f3784t != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.f3784t);
        }
    }

    public final void m6239a(Runnable runnable, boolean z) {
        if (!z) {
            m6208A();
        }
        synchronized (this) {
            if (this.f3783s || this.f3778n == null) {
                throw new IllegalStateException("FragmentHost has been destroyed");
            }
            if (this.f3767c == null) {
                this.f3767c = new ArrayList();
            }
            this.f3767c.add(runnable);
            if (this.f3767c.size() == 1) {
                HandlerDetour.a(this.f3778n.mo866i(), this.f3789y);
                HandlerDetour.a(this.f3778n.mo866i(), this.f3789y, -1601031747);
            }
        }
    }

    public final int m6223a(BackStackRecord backStackRecord) {
        int size;
        synchronized (this) {
            if (this.f3775k == null || this.f3775k.size() <= 0) {
                if (this.f3774j == null) {
                    this.f3774j = new ArrayList();
                }
                size = this.f3774j.size();
                if (f3764a) {
                    Log.v("FragmentManager", "Setting back stack index " + size + " to " + backStackRecord);
                }
                this.f3774j.add(backStackRecord);
            } else {
                size = ((Integer) this.f3775k.remove(this.f3775k.size() - 1)).intValue();
                if (f3764a) {
                    Log.v("FragmentManager", "Adding back stack index " + size + " with " + backStackRecord);
                }
                this.f3774j.set(size, backStackRecord);
            }
        }
        return size;
    }

    private void m6213a(int i, BackStackRecord backStackRecord) {
        synchronized (this) {
            if (this.f3774j == null) {
                this.f3774j = new ArrayList();
            }
            int size = this.f3774j.size();
            if (i < size) {
                if (f3764a) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + backStackRecord);
                }
                this.f3774j.set(i, backStackRecord);
            } else {
                while (size < i) {
                    this.f3774j.add(null);
                    if (this.f3775k == null) {
                        this.f3775k = new ArrayList();
                    }
                    if (f3764a) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.f3775k.add(Integer.valueOf(size));
                    size++;
                }
                if (f3764a) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + backStackRecord);
                }
                this.f3774j.add(backStackRecord);
            }
        }
    }

    public final void m6260d(int i) {
        synchronized (this) {
            this.f3774j.set(i, null);
            if (this.f3775k == null) {
                this.f3775k = new ArrayList();
            }
            if (f3764a) {
                Log.v("FragmentManager", "Freeing back stack index " + i);
            }
            this.f3775k.add(Integer.valueOf(i));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean m6267i() {
        /*
        r6 = this;
        r5 = 0;
        r0 = 1;
        r2 = 0;
        r1 = r6.f3769e;
        if (r1 == 0) goto L_0x001d;
    L_0x0007:
        r0 = r6.f3786v;
        if (r0 == 0) goto L_0x0015;
    L_0x000b:
        r0 = new java.lang.IllegalStateException;
        r1 = "Exception thrown in last fragment action was caught, causing invalid state.";
        r2 = r6.f3786v;
        r0.<init>(r1, r2);
        throw r0;
    L_0x0015:
        r0 = new java.lang.IllegalStateException;
        r1 = "Recursive entry to executePendingTransactions";
        r0.<init>(r1);
        throw r0;
    L_0x001d:
        r1 = android.os.Looper.myLooper();
        r3 = r6.f3778n;
        r3 = r3.mo866i();
        r3 = r3.getLooper();
        if (r1 == r3) goto L_0x0035;
    L_0x002d:
        r0 = new java.lang.IllegalStateException;
        r1 = "Must be called from main thread of process";
        r0.<init>(r1);
        throw r0;
    L_0x0035:
        r1 = r2;
    L_0x0036:
        monitor-enter(r6);
        r3 = r6.f3767c;	 Catch:{ all -> 0x00ab }
        if (r3 == 0) goto L_0x0043;
    L_0x003b:
        r3 = r6.f3767c;	 Catch:{ all -> 0x00ab }
        r3 = r3.size();	 Catch:{ all -> 0x00ab }
        if (r3 != 0) goto L_0x006d;
    L_0x0043:
        monitor-exit(r6);	 Catch:{ all -> 0x00ab }
        r0 = r6.f3785u;
        if (r0 == 0) goto L_0x00e0;
    L_0x0048:
        r3 = r2;
        r4 = r2;
    L_0x004a:
        r0 = r6.f3770f;
        r0 = r0.size();
        if (r4 >= r0) goto L_0x00d9;
    L_0x0052:
        r0 = r6.f3770f;
        r0 = r0.get(r4);
        r0 = (android.support.v4.app.Fragment) r0;
        if (r0 == 0) goto L_0x00e1;
    L_0x005c:
        r5 = r0.f120X;
        if (r5 == 0) goto L_0x00e1;
    L_0x0060:
        r0 = r0.f120X;
        r0 = r0.mo878a();
        r3 = r3 | r0;
        r0 = r3;
    L_0x0068:
        r3 = r4 + 1;
        r4 = r3;
        r3 = r0;
        goto L_0x004a;
    L_0x006d:
        r1 = r6.f3767c;	 Catch:{  }
        r3 = r1.size();	 Catch:{  }
        r1 = r6.f3768d;	 Catch:{  }
        if (r1 == 0) goto L_0x007c;
    L_0x0077:
        r1 = r6.f3768d;	 Catch:{  }
        r1 = r1.length;	 Catch:{  }
        if (r1 >= r3) goto L_0x0080;
    L_0x007c:
        r1 = new java.lang.Runnable[r3];	 Catch:{  }
        r6.f3768d = r1;	 Catch:{  }
    L_0x0080:
        r1 = r6.f3767c;	 Catch:{  }
        r4 = r6.f3768d;	 Catch:{  }
        r1.toArray(r4);	 Catch:{  }
        r1 = r6.f3767c;	 Catch:{  }
        r1.clear();	 Catch:{  }
        r1 = r6.f3778n;	 Catch:{  }
        r1 = r1.mo866i();	 Catch:{  }
        r4 = r6.f3789y;	 Catch:{  }
        com.facebook.tools.dextr.runtime.detour.HandlerDetour.a(r1, r4);	 Catch:{  }
        monitor-exit(r6);	 Catch:{  }
        r6.f3769e = r0;
        r1 = r2;
    L_0x009b:
        if (r1 >= r3) goto L_0x00d2;
    L_0x009d:
        r4 = r6.f3768d;	 Catch:{ Exception -> 0x00ae }
        r4 = r4[r1];	 Catch:{ Exception -> 0x00ae }
        r4.run();	 Catch:{ Exception -> 0x00ae }
        r4 = r6.f3768d;
        r4[r1] = r5;
        r1 = r1 + 1;
        goto L_0x009b;
    L_0x00ab:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{  }
        throw r0;
    L_0x00ae:
        r0 = move-exception;
        r6.f3786v = r0;
        r1 = new android.os.Handler;
        r2 = android.os.Looper.getMainLooper();
        r1.<init>(r2);
        r2 = new android.support.v4.app.FragmentManagerImpl$6;
        r2.<init>(r6, r0);
        r3 = 1466605835; // 0x576aa10b float:2.57977395E14 double:7.24599559E-315;
        com.facebook.tools.dextr.runtime.detour.HandlerDetour.a(r1, r2, r3);
        r1 = r0 instanceof java.lang.RuntimeException;
        if (r1 == 0) goto L_0x00cc;
    L_0x00c9:
        r0 = (java.lang.RuntimeException) r0;
        throw r0;
    L_0x00cc:
        r1 = new java.lang.RuntimeException;
        r1.<init>(r0);
        throw r1;
    L_0x00d2:
        r6.f3786v = r5;
        r6.f3769e = r2;
        r1 = r0;
        goto L_0x0036;
    L_0x00d9:
        if (r3 != 0) goto L_0x00e0;
    L_0x00db:
        r6.f3785u = r2;
        r6.m6266h();
    L_0x00e0:
        return r1;
    L_0x00e1:
        r0 = r3;
        goto L_0x0068;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.FragmentManagerImpl.i():boolean");
    }

    private void m6209B() {
        if (this.f3776l != null) {
            for (int i = 0; i < this.f3776l.size(); i++) {
                ((OnBackStackChangedListener) this.f3776l.get(i)).le_();
            }
        }
    }

    final void m6247b(BackStackRecord backStackRecord) {
        if (this.f3772h == null) {
            this.f3772h = new ArrayList();
        }
        this.f3772h.add(backStackRecord);
        m6209B();
    }

    final boolean m6245a(String str, int i, int i2) {
        if (this.f3772h == null) {
            return false;
        }
        int size;
        BackStackRecord backStackRecord;
        if (str == null && i < 0 && (i2 & 1) == 0) {
            size = this.f3772h.size() - 1;
            if (size < 0) {
                return false;
            }
            backStackRecord = (BackStackRecord) this.f3772h.remove(size);
            SparseArray sparseArray = new SparseArray();
            SparseArray sparseArray2 = new SparseArray();
            backStackRecord.m13707a(sparseArray, sparseArray2);
            backStackRecord.m13696a(true, null, sparseArray, sparseArray2);
        } else {
            int size2;
            size = -1;
            if (str != null || i >= 0) {
                size2 = this.f3772h.size() - 1;
                while (size2 >= 0) {
                    backStackRecord = (BackStackRecord) this.f3772h.get(size2);
                    if ((str != null && str.equals(backStackRecord.f8853m)) || (i >= 0 && i == backStackRecord.f8855o)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    size2--;
                    while (size2 >= 0) {
                        backStackRecord = (BackStackRecord) this.f3772h.get(size2);
                        if ((str == null || !str.equals(backStackRecord.m13718d())) && (i < 0 || i != backStackRecord.f8855o)) {
                            break;
                        }
                        size2--;
                    }
                }
                size = size2;
            }
            if (size == this.f3772h.size() - 1) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (size2 = this.f3772h.size() - 1; size2 > size; size2--) {
                arrayList.add(this.f3772h.remove(size2));
            }
            int size3 = arrayList.size() - 1;
            SparseArray sparseArray3 = new SparseArray();
            SparseArray sparseArray4 = new SparseArray();
            for (size2 = 0; size2 <= size3; size2++) {
                ((BackStackRecord) arrayList.get(size2)).m13707a(sparseArray3, sparseArray4);
            }
            TransitionState transitionState = null;
            int i3 = 0;
            while (i3 <= size3) {
                boolean z;
                if (f3764a) {
                    Log.v("FragmentManager", "Popping back stack state: " + arrayList.get(i3));
                }
                backStackRecord = (BackStackRecord) arrayList.get(i3);
                if (i3 == size3) {
                    z = true;
                } else {
                    z = false;
                }
                i3++;
                transitionState = backStackRecord.m13696a(z, transitionState, sparseArray3, sparseArray4);
            }
        }
        m6209B();
        return true;
    }

    final ArrayList<Fragment> m6268j() {
        ArrayList<Fragment> arrayList = null;
        if (this.f3770f != null) {
            for (int i = 0; i < this.f3770f.size(); i++) {
                Fragment fragment = (Fragment) this.f3770f.get(i);
                if (fragment != null && fragment.f109M) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(fragment);
                    fragment.f110N = true;
                    fragment.f133u = fragment.f132t != null ? fragment.f132t.f128p : -1;
                    if (f3764a) {
                        Log.v("FragmentManager", "retainNonConfig: keeping retained " + fragment);
                    }
                }
            }
        }
        return arrayList;
    }

    private void m6221g(Fragment fragment) {
        if (fragment.f117U != null) {
            if (this.f3788x == null) {
                this.f3788x = new SparseArray();
            } else {
                this.f3788x.clear();
            }
            fragment.f117U.saveHierarchyState(this.f3788x);
            if (this.f3788x.size() > 0) {
                fragment.f127o = this.f3788x;
                this.f3788x = null;
            }
        }
    }

    private Bundle m6222h(Fragment fragment) {
        if (this.f3787w == null) {
            this.f3787w = new Bundle();
        }
        Bundle bundle = this.f3787w;
        fragment.mo20e(bundle);
        if (fragment.f102F != null) {
            Parcelable k = fragment.f102F.m6269k();
            if (k != null) {
                bundle.putParcelable("android:support:fragments", k);
            }
        }
        if (this.f3787w.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.f3787w;
            this.f3787w = null;
        }
        if (fragment.f116T != null) {
            m6221g(fragment);
        }
        if (fragment.f127o != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.f127o);
        }
        if (!fragment.f119W) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.f119W);
        }
        return bundle;
    }

    public final Parcelable m6269k() {
        BackStackState[] backStackStateArr = null;
        m6267i();
        if (f3765b) {
            this.f3782r = true;
        }
        if (this.f3770f == null || this.f3770f.size() <= 0) {
            return null;
        }
        int size = this.f3770f.size();
        FragmentState[] fragmentStateArr = new FragmentState[size];
        int i = 0;
        boolean z = false;
        while (i < size) {
            boolean z2;
            Fragment fragment = (Fragment) this.f3770f.get(i);
            if (fragment != null) {
                if (fragment.f128p < 0) {
                    m6215a(new IllegalStateException("Failure saving state: active " + fragment + " has cleared index: " + fragment.f128p));
                }
                FragmentState fragmentState = new FragmentState(fragment);
                fragmentStateArr[i] = fragmentState;
                if (fragment.f123k <= 0 || fragmentState.k != null) {
                    fragmentState.k = fragment.f126n;
                } else {
                    fragmentState.k = m6222h(fragment);
                    if (fragment.f132t != null) {
                        if (fragment.f132t.f128p < 0) {
                            m6215a(new IllegalStateException("Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.f132t));
                        }
                        if (fragmentState.k == null) {
                            fragmentState.k = new Bundle();
                        }
                        mo844a(fragmentState.k, "android:target_state", fragment.f132t);
                        if (fragment.f134v != 0) {
                            fragmentState.k.putInt("android:target_req_state", fragment.f134v);
                        }
                    }
                }
                if (f3764a) {
                    Log.v("FragmentManager", "Saved state of " + fragment + ": " + fragmentState.k);
                }
                z2 = true;
            } else {
                z2 = z;
            }
            i++;
            z = z2;
        }
        if (z) {
            int[] iArr;
            int i2;
            FragmentManagerState fragmentManagerState;
            if (this.mAdded != null) {
                i = this.mAdded.size();
                if (i > 0) {
                    iArr = new int[i];
                    for (i2 = 0; i2 < i; i2++) {
                        iArr[i2] = ((Fragment) this.mAdded.get(i2)).f128p;
                        if (iArr[i2] < 0) {
                            m6215a(new IllegalStateException("Failure saving state: active " + this.mAdded.get(i2) + " has cleared index: " + iArr[i2]));
                        }
                        if (f3764a) {
                            Log.v("FragmentManager", "saveAllState: adding fragment #" + i2 + ": " + this.mAdded.get(i2));
                        }
                    }
                    if (this.f3772h != null) {
                        i = this.f3772h.size();
                        if (i > 0) {
                            backStackStateArr = new BackStackState[i];
                            for (i2 = 0; i2 < i; i2++) {
                                backStackStateArr[i2] = new BackStackState((BackStackRecord) this.f3772h.get(i2));
                                if (f3764a) {
                                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f3772h.get(i2));
                                }
                            }
                        }
                    }
                    fragmentManagerState = new FragmentManagerState();
                    fragmentManagerState.a = fragmentStateArr;
                    fragmentManagerState.b = iArr;
                    fragmentManagerState.c = backStackStateArr;
                    return fragmentManagerState;
                }
            }
            iArr = null;
            if (this.f3772h != null) {
                i = this.f3772h.size();
                if (i > 0) {
                    backStackStateArr = new BackStackState[i];
                    for (i2 = 0; i2 < i; i2++) {
                        backStackStateArr[i2] = new BackStackState((BackStackRecord) this.f3772h.get(i2));
                        if (f3764a) {
                            Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f3772h.get(i2));
                        }
                    }
                }
            }
            fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.a = fragmentStateArr;
            fragmentManagerState.b = iArr;
            fragmentManagerState.c = backStackStateArr;
            return fragmentManagerState;
        } else if (!f3764a) {
            return null;
        } else {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return null;
        }
    }

    public final void m6233a(Parcelable parcelable, ArrayList<Fragment> arrayList) {
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.a != null) {
                int i;
                Fragment fragment;
                int i2;
                if (arrayList != null) {
                    for (i = 0; i < arrayList.size(); i++) {
                        fragment = (Fragment) arrayList.get(i);
                        if (f3764a) {
                            Log.v("FragmentManager", "restoreAllState: re-attaching retained " + fragment);
                        }
                        FragmentState fragmentState = fragmentManagerState.a[fragment.f128p];
                        fragmentState.l = fragment;
                        fragment.f127o = null;
                        fragment.f99C = 0;
                        fragment.f97A = false;
                        fragment.f135w = false;
                        fragment.f132t = null;
                        if (fragmentState.k != null) {
                            fragmentState.k.setClassLoader(this.f3778n.mo865h().getClassLoader());
                            fragment.f127o = fragmentState.k.getSparseParcelableArray("android:view_state");
                            fragment.f126n = fragmentState.k;
                        }
                    }
                }
                this.f3770f = new ArrayList(fragmentManagerState.a.length);
                if (this.f3771g != null) {
                    this.f3771g.clear();
                }
                for (i2 = 0; i2 < fragmentManagerState.a.length; i2++) {
                    FragmentState fragmentState2 = fragmentManagerState.a[i2];
                    if (fragmentState2 != null) {
                        Fragment fragment2;
                        FragmentHost fragmentHost = this.f3778n;
                        Fragment fragment3 = this.f3780p;
                        if (fragmentState2.l != null) {
                            fragment2 = fragmentState2.l;
                        } else {
                            if (fragmentState2.j != null) {
                                fragmentState2.j.setClassLoader(fragmentHost.mo865h().getClassLoader());
                            }
                            fragmentState2.l = Fragment.m221a(fragmentHost.mo865h(), fragmentState2.a, fragmentState2.j);
                            if (fragmentState2.k != null) {
                                fragmentState2.k.setClassLoader(fragmentHost.mo865h().getClassLoader());
                                fragmentState2.l.f126n = fragmentState2.k;
                            }
                            fragmentState2.l.m244a(fragmentState2.b, fragment3);
                            fragmentState2.l.f129q = fragmentState2.c;
                            fragmentState2.l.f138z = fragmentState2.d;
                            fragmentState2.l.f98B = true;
                            fragmentState2.l.f104H = fragmentState2.e;
                            fragmentState2.l.f105I = fragmentState2.f;
                            fragmentState2.l.f106J = fragmentState2.g;
                            fragmentState2.l.f109M = fragmentState2.h;
                            fragmentState2.l.f108L = fragmentState2.i;
                            fragmentState2.l.f100D = fragmentHost.mo872o();
                            if (f3764a) {
                                Log.v("FragmentManager", "Instantiated fragment " + fragmentState2.l);
                            }
                            fragment2 = fragmentState2.l;
                        }
                        Fragment fragment4 = fragment2;
                        if (f3764a) {
                            Log.v("FragmentManager", "restoreAllState: active #" + i2 + ": " + fragment4);
                        }
                        this.f3770f.add(fragment4);
                        fragmentState2.l = null;
                    } else {
                        this.f3770f.add(null);
                        if (this.f3771g == null) {
                            this.f3771g = new ArrayList();
                        }
                        if (f3764a) {
                            Log.v("FragmentManager", "restoreAllState: avail #" + i2);
                        }
                        this.f3771g.add(Integer.valueOf(i2));
                    }
                }
                if (arrayList != null) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        fragment = (Fragment) arrayList.get(i3);
                        if (fragment.f133u >= 0) {
                            if (fragment.f133u < this.f3770f.size()) {
                                fragment.f132t = (Fragment) this.f3770f.get(fragment.f133u);
                            } else {
                                Log.w("FragmentManager", "Re-attaching retained fragment " + fragment + " target no longer exists: " + fragment.f133u);
                                fragment.f132t = null;
                            }
                        }
                    }
                }
                if (fragmentManagerState.b != null) {
                    this.mAdded = new ArrayList(fragmentManagerState.b.length);
                    for (i = 0; i < fragmentManagerState.b.length; i++) {
                        fragment = (Fragment) this.f3770f.get(fragmentManagerState.b[i]);
                        if (fragment == null) {
                            m6215a(new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.b[i]));
                        }
                        fragment.f135w = true;
                        if (f3764a) {
                            Log.v("FragmentManager", "restoreAllState: added #" + i + ": " + fragment);
                        }
                        if (this.mAdded.contains(fragment)) {
                            throw new IllegalStateException("Already added!");
                        }
                        this.mAdded.add(fragment);
                    }
                } else {
                    this.mAdded = null;
                }
                if (fragmentManagerState.c != null) {
                    this.f3772h = new ArrayList(fragmentManagerState.c.length);
                    for (i2 = 0; i2 < fragmentManagerState.c.length; i2++) {
                        BackStackRecord a = fragmentManagerState.c[i2].a(this);
                        if (f3764a) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i2 + " (index " + a.f8855o + "): " + a);
                            a.m13709a("  ", new PrintWriter(new LogWriter("FragmentManager")), false);
                        }
                        this.f3772h.add(a);
                        if (a.f8855o >= 0) {
                            m6213a(a.f8855o, a);
                        }
                    }
                    return;
                }
                this.f3772h = null;
            }
        }
    }

    public final void m6237a(FragmentHost fragmentHost, FragmentContainer fragmentContainer, Fragment fragment) {
        if (this.f3778n != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f3778n = fragmentHost;
        this.f3779o = fragmentContainer;
        this.f3780p = fragment;
    }

    public final void m6270l() {
        this.f3782r = false;
    }

    public final void m6271m() {
        this.f3782r = false;
        m6214a(1, false);
    }

    public final void m6272n() {
        this.f3782r = false;
        m6214a(2, false);
    }

    public final void m6273o() {
        this.f3782r = false;
        m6214a(4, false);
    }

    public final void m6274p() {
        this.f3782r = false;
        m6214a(5, false);
    }

    public final void m6275q() {
        m6214a(4, false);
    }

    public final void m6276r() {
        this.f3782r = true;
        m6214a(3, false);
    }

    public final void m6277s() {
        m6214a(2, false);
    }

    public final void m6278t() {
        m6214a(1, false);
    }

    public final void m6279u() {
        this.f3783s = true;
        m6267i();
        m6214a(0, false);
        this.f3778n = null;
        this.f3779o = null;
        this.f3780p = null;
    }

    public final void m6231a(Configuration configuration) {
        if (this.mAdded != null) {
            for (int i = 0; i < this.mAdded.size(); i++) {
                Fragment fragment = (Fragment) this.mAdded.get(i);
                if (fragment != null) {
                    fragment.onConfigurationChanged(configuration);
                    if (fragment.f102F != null) {
                        fragment.f102F.m6231a(configuration);
                    }
                }
            }
        }
    }

    public final void m6280v() {
        if (this.mAdded != null) {
            for (int i = 0; i < this.mAdded.size(); i++) {
                Fragment fragment = (Fragment) this.mAdded.get(i);
                if (fragment != null) {
                    fragment.onLowMemory();
                    if (fragment.f102F != null) {
                        fragment.f102F.m6280v();
                    }
                }
            }
        }
    }

    public final View m6281w() {
        if (this.mAdded != null) {
            for (int i = 0; i < this.mAdded.size(); i++) {
                Fragment fragment = (Fragment) this.mAdded.get(i);
                if (fragment != null) {
                    View view = null;
                    if (!fragment.f107K) {
                        if (fragment.f111O && fragment.f112P) {
                            view = fragment.ab();
                        }
                        if (view == null && fragment.f102F != null) {
                            view = fragment.f102F.m6281w();
                        }
                    }
                    View view2 = view;
                    if (view2 != null) {
                        return view2;
                    }
                }
            }
        }
        return null;
    }

    public final void m6282x() {
        if (this.mAdded != null) {
            for (int i = 0; i < this.mAdded.size(); i++) {
                Fragment fragment = (Fragment) this.mAdded.get(i);
                if (!(fragment == null || fragment.f107K)) {
                    fragment.mo1864Z();
                    if (fragment.f102F != null) {
                        fragment.f102F.m6282x();
                    }
                }
            }
        }
    }

    public final boolean m6243a(Menu menu, MenuInflater menuInflater) {
        boolean z;
        Fragment fragment;
        int i = 0;
        ArrayList arrayList = null;
        if (this.mAdded != null) {
            int i2 = 0;
            z = false;
            while (i2 < this.mAdded.size()) {
                fragment = (Fragment) this.mAdded.get(i2);
                if (fragment != null) {
                    int i3 = 0;
                    if (!fragment.f107K) {
                        if (fragment.f111O && fragment.f112P) {
                            i3 = 1;
                            fragment.mo1874c(menu, menuInflater);
                        }
                        if (fragment.f102F != null) {
                            i3 |= fragment.f102F.m6243a(menu, menuInflater);
                        }
                    }
                    if (i3 != 0) {
                        z = true;
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(fragment);
                    }
                }
                i2++;
                z = z;
            }
        } else {
            z = false;
        }
        if (this.f3773i != null) {
            while (i < this.f3773i.size()) {
                fragment = (Fragment) this.f3773i.get(i);
                if (arrayList == null || !arrayList.contains(fragment)) {
                    fragment.m231K();
                }
                i++;
            }
        }
        this.f3773i = arrayList;
        return z;
    }

    public final MenuInflater m6283y() {
        if (this.mAdded != null) {
            for (int i = 0; i < this.mAdded.size(); i++) {
                Fragment fragment = (Fragment) this.mAdded.get(i);
                if (fragment != null) {
                    MenuInflater ad;
                    if (!fragment.f107K && fragment.f111O && fragment.f112P) {
                        ad = fragment.ad();
                    } else {
                        ad = null;
                    }
                    MenuInflater menuInflater = ad;
                    if (menuInflater != null) {
                        return menuInflater;
                    }
                }
            }
        }
        return null;
    }

    public final boolean m6242a(Menu menu) {
        if (this.mAdded == null) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.mAdded.size(); i++) {
            Fragment fragment = (Fragment) this.mAdded.get(i);
            if (fragment != null) {
                int i2 = 0;
                if (!fragment.f107K) {
                    if (fragment.f111O && fragment.f112P) {
                        i2 = 1;
                        fragment.m253a(menu);
                    }
                    if (fragment.f102F != null) {
                        i2 |= fragment.f102F.m6242a(menu);
                    }
                }
                if (i2 != 0) {
                    z = true;
                }
            }
        }
        return z;
    }

    public final boolean m6244a(MenuItem menuItem) {
        if (this.mAdded == null) {
            return false;
        }
        for (int i = 0; i < this.mAdded.size(); i++) {
            Fragment fragment = (Fragment) this.mAdded.get(i);
            if (fragment != null) {
                Object obj = 1;
                if (fragment.f107K || (!(fragment.f111O && fragment.f112P && fragment.a_(menuItem)) && (fragment.f102F == null || !fragment.f102F.m6244a(menuItem)))) {
                    obj = null;
                }
                if (obj != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean m6253b(MenuItem menuItem) {
        if (this.mAdded == null) {
            return false;
        }
        for (int i = 0; i < this.mAdded.size(); i++) {
            Fragment fragment = (Fragment) this.mAdded.get(i);
            if (fragment != null) {
                Object obj = 1;
                if (fragment.f107K || (!fragment.m260b(menuItem) && (fragment.f102F == null || !fragment.f102F.m6253b(menuItem)))) {
                    obj = null;
                }
                if (obj != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void m6251b(Menu menu) {
        if (this.mAdded != null) {
            for (int i = 0; i < this.mAdded.size(); i++) {
                Fragment fragment = (Fragment) this.mAdded.get(i);
                if (!(fragment == null || fragment.f107K || fragment.f102F == null)) {
                    fragment.f102F.m6251b(menu);
                }
            }
        }
    }

    public static int m6218e(int i) {
        switch (i) {
            case 4097:
                return 8194;
            case 4099:
                return 4099;
            case 8194:
                return 4097;
            default:
                return 0;
        }
    }

    private static int m6216b(int i, boolean z) {
        switch (i) {
            case 4097:
                return z ? 1 : 2;
            case 4099:
                return z ? 5 : 6;
            case 8194:
                return z ? 3 : 4;
            default:
                return -1;
        }
    }

    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (!"fragment".equals(str)) {
            return null;
        }
        String string;
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, FragmentTag.a);
        if (attributeValue == null) {
            string = obtainStyledAttributes.getString(0);
        } else {
            string = attributeValue;
        }
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string2 = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!Fragment.m222b(this.f3778n.mo865h(), string)) {
            return null;
        }
        Fragment a;
        Fragment a2 = resourceId != -1 ? mo839a(resourceId) : null;
        if (a2 == null && string2 != null) {
            a2 = mo841a(string2);
        }
        if (a2 == null) {
            a2 = mo839a(0);
        }
        if (f3764a) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + string + " existing=" + a2);
        }
        if (a2 == null) {
            a = Fragment.m220a(context, string);
            a.f138z = true;
            a.f104H = resourceId != 0 ? resourceId : 0;
            a.f105I = 0;
            a.f106J = string2;
            a.f97A = true;
            a.f100D = this;
            a.m246a(this.f3778n.mo865h(), attributeSet, a.f126n);
            m6236a(a, true);
        } else if (a2.f97A) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string2 + ", or parent id 0x" + Integer.toHexString(0) + " with another fragment for " + string);
        } else {
            a2.f97A = true;
            if (!a2.f110N) {
                a2.m246a(this.f3778n.mo865h(), attributeSet, a2.f126n);
            }
            a = a2;
        }
        if (this.f3777m > 0 || !a.f138z) {
            m6256c(a);
        } else {
            m6235a(a, 1, 0, 0, false);
        }
        if (a.f116T == null) {
            throw new IllegalStateException("Fragment " + string + " did not create a view.");
        }
        if (resourceId != 0) {
            a.f116T.setId(resourceId);
        }
        if (a.f116T.getTag() == null) {
            a.f116T.setTag(string2);
        }
        return a.f116T;
    }

    final Factory m6284z() {
        return this;
    }
}
