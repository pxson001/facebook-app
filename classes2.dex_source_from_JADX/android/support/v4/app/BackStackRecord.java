package android.support.v4.app;

import android.os.Build.VERSION;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.LogWriter;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.proxygen.HTTPTransportCallback;
import java.io.PrintWriter;
import java.util.ArrayList;

/* compiled from: profile_image_small_size */
public final class BackStackRecord extends FragmentTransaction implements Runnable {
    final FragmentManagerImpl f8841a;
    Op f8842b;
    Op f8843c;
    int f8844d;
    int f8845e;
    int f8846f;
    int f8847g;
    int f8848h;
    int f8849i;
    int f8850j;
    boolean f8851k;
    boolean f8852l = true;
    public String f8853m;
    boolean f8854n;
    int f8855o = -1;
    int f8856p;
    CharSequence f8857q;
    int f8858r;
    CharSequence f8859s;
    public ArrayList<String> f8860t;
    public ArrayList<String> f8861u;

    /* compiled from: profile_image_small_size */
    final class Op {
        Op f8873a;
        Op f8874b;
        int f8875c;
        Fragment f8876d;
        int f8877e;
        int f8878f;
        int f8879g;
        int f8880h;
        ArrayList<Fragment> f8881i;

        Op() {
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(HTTPTransportCallback.BODY_BYTES_RECEIVED);
        stringBuilder.append("BackStackEntry{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f8855o >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.f8855o);
        }
        if (this.f8853m != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.f8853m);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void m13708a(String str, PrintWriter printWriter) {
        m13709a(str, printWriter, true);
    }

    public final void m13709a(String str, PrintWriter printWriter, boolean z) {
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f8853m);
            printWriter.print(" mIndex=");
            printWriter.print(this.f8855o);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f8854n);
            if (this.f8849i != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f8849i));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.f8850j));
            }
            if (!(this.f8845e == 0 && this.f8846f == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f8845e));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f8846f));
            }
            if (!(this.f8847g == 0 && this.f8848h == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f8847g));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f8848h));
            }
            if (!(this.f8856p == 0 && this.f8857q == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f8856p));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f8857q);
            }
            if (!(this.f8858r == 0 && this.f8859s == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f8858r));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f8859s);
            }
        }
        if (this.f8842b != null) {
            printWriter.print(str);
            printWriter.println("Operations:");
            String str2 = str + "    ";
            int i = 0;
            Op op = this.f8842b;
            while (op != null) {
                String str3;
                switch (op.f8875c) {
                    case 0:
                        str3 = "NULL";
                        break;
                    case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                        str3 = "ADD";
                        break;
                    case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                        str3 = "REPLACE";
                        break;
                    case 3:
                        str3 = "REMOVE";
                        break;
                    case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                        str3 = "HIDE";
                        break;
                    case 5:
                        str3 = "SHOW";
                        break;
                    case 6:
                        str3 = "DETACH";
                        break;
                    case 7:
                        str3 = "ATTACH";
                        break;
                    default:
                        str3 = "cmd=" + op.f8875c;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str3);
                printWriter.print(" ");
                printWriter.println(op.f8876d);
                if (z) {
                    if (!(op.f8877e == 0 && op.f8878f == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(op.f8877e));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(op.f8878f));
                    }
                    if (!(op.f8879g == 0 && op.f8880h == 0)) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(op.f8879g));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(op.f8880h));
                    }
                }
                if (op.f8881i != null && op.f8881i.size() > 0) {
                    for (int i2 = 0; i2 < op.f8881i.size(); i2++) {
                        printWriter.print(str2);
                        if (op.f8881i.size() == 1) {
                            printWriter.print("Removed: ");
                        } else {
                            if (i2 == 0) {
                                printWriter.println("Removed:");
                            }
                            printWriter.print(str2);
                            printWriter.print("  #");
                            printWriter.print(i2);
                            printWriter.print(": ");
                        }
                        printWriter.println(op.f8881i.get(i2));
                    }
                }
                op = op.f8873a;
                i++;
            }
        }
    }

    public BackStackRecord(FragmentManagerImpl fragmentManagerImpl) {
        this.f8841a = fragmentManagerImpl;
    }

    final void m13706a(Op op) {
        if (this.f8842b == null) {
            this.f8843c = op;
            this.f8842b = op;
        } else {
            op.f8874b = this.f8843c;
            this.f8843c.f8873a = op;
            this.f8843c = op;
        }
        op.f8877e = this.f8845e;
        op.f8878f = this.f8846f;
        op.f8879g = this.f8847g;
        op.f8880h = this.f8848h;
        this.f8844d++;
    }

    public final FragmentTransaction mo1845a(Fragment fragment, String str) {
        m13682a(0, fragment, str, 1);
        return this;
    }

    public final FragmentTransaction mo1842a(int i, Fragment fragment) {
        m13682a(i, fragment, null, 1);
        return this;
    }

    public final FragmentTransaction mo1843a(int i, Fragment fragment, String str) {
        m13682a(i, fragment, str, 1);
        return this;
    }

    private void m13682a(int i, Fragment fragment, String str, int i2) {
        fragment.f100D = this.f8841a;
        if (str != null) {
            if (fragment.f106J == null || str.equals(fragment.f106J)) {
                fragment.f106J = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.f106J + " now " + str);
            }
        }
        if (i != 0) {
            if (fragment.f104H == 0 || fragment.f104H == i) {
                fragment.f104H = i;
                fragment.f105I = i;
            } else {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.f104H + " now " + i);
            }
        }
        Op op = new Op();
        op.f8875c = i2;
        op.f8876d = fragment;
        m13706a(op);
    }

    public final FragmentTransaction mo1848b(int i, Fragment fragment) {
        return mo1849b(i, fragment, null);
    }

    public final FragmentTransaction mo1849b(int i, Fragment fragment, String str) {
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        m13682a(i, fragment, str, 2);
        return this;
    }

    public final FragmentTransaction mo1844a(Fragment fragment) {
        Op op = new Op();
        op.f8875c = 3;
        op.f8876d = fragment;
        m13706a(op);
        return this;
    }

    public final FragmentTransaction mo1850b(Fragment fragment) {
        Op op = new Op();
        op.f8875c = 4;
        op.f8876d = fragment;
        m13706a(op);
        return this;
    }

    public final FragmentTransaction mo1852c(Fragment fragment) {
        Op op = new Op();
        op.f8875c = 5;
        op.f8876d = fragment;
        m13706a(op);
        return this;
    }

    public final FragmentTransaction mo1853d(Fragment fragment) {
        Op op = new Op();
        op.f8875c = 6;
        op.f8876d = fragment;
        m13706a(op);
        return this;
    }

    public final FragmentTransaction mo1854e(Fragment fragment) {
        Op op = new Op();
        op.f8875c = 7;
        op.f8876d = fragment;
        m13706a(op);
        return this;
    }

    public final FragmentTransaction mo1840a(int i, int i2) {
        return mo1841a(i, i2, 0, 0);
    }

    public final FragmentTransaction mo1841a(int i, int i2, int i3, int i4) {
        this.f8845e = i;
        this.f8846f = i2;
        this.f8847g = i3;
        this.f8848h = i4;
        return this;
    }

    public final FragmentTransaction mo1839a(int i) {
        this.f8849i = i;
        return this;
    }

    public final FragmentTransaction mo1846a(String str) {
        if (this.f8852l) {
            this.f8851k = true;
            this.f8853m = str;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    public final FragmentTransaction mo1838a() {
        if (this.f8851k) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.f8852l = false;
        return this;
    }

    final void m13714b(int i) {
        if (this.f8851k) {
            if (FragmentManagerImpl.f3764a) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            for (Op op = this.f8842b; op != null; op = op.f8873a) {
                Fragment fragment;
                if (op.f8876d != null) {
                    fragment = op.f8876d;
                    fragment.f99C += i;
                    if (FragmentManagerImpl.f3764a) {
                        Log.v("FragmentManager", "Bump nesting of " + op.f8876d + " to " + op.f8876d.f99C);
                    }
                }
                if (op.f8881i != null) {
                    for (int size = op.f8881i.size() - 1; size >= 0; size--) {
                        fragment = (Fragment) op.f8881i.get(size);
                        fragment.f99C += i;
                        if (FragmentManagerImpl.f3764a) {
                            Log.v("FragmentManager", "Bump nesting of " + fragment + " to " + fragment.f99C);
                        }
                    }
                }
            }
        }
    }

    public final int mo1847b() {
        return m13674a(false);
    }

    public final int mo1851c() {
        return m13674a(true);
    }

    private int m13674a(boolean z) {
        if (this.f8854n) {
            throw new IllegalStateException("commit already called");
        }
        if (FragmentManagerImpl.f3764a) {
            Log.v("FragmentManager", "Commit: " + this);
            m13708a("  ", new PrintWriter(new LogWriter("FragmentManager")));
        }
        this.f8854n = true;
        if (this.f8851k) {
            this.f8855o = this.f8841a.m6223a(this);
        } else {
            this.f8855o = -1;
        }
        this.f8841a.m6239a((Runnable) this, z);
        return this.f8855o;
    }

    public final void run() {
        if (FragmentManagerImpl.f3764a) {
            Log.v("FragmentManager", "Run: " + this);
        }
        if (!this.f8851k || this.f8855o >= 0) {
            TransitionState a;
            m13714b(1);
            if (VERSION.SDK_INT >= 21) {
                SparseArray sparseArray = new SparseArray();
                SparseArray sparseArray2 = new SparseArray();
                m13695b(sparseArray, sparseArray2);
                a = m13675a(sparseArray, sparseArray2, false);
            } else {
                a = null;
            }
            int i = a != null ? 0 : this.f8850j;
            int i2 = a != null ? 0 : this.f8849i;
            Op op = this.f8842b;
            while (op != null) {
                int i3 = a != null ? 0 : op.f8877e;
                int i4 = a != null ? 0 : op.f8878f;
                Fragment fragment;
                switch (op.f8875c) {
                    case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                        fragment = op.f8876d;
                        fragment.f114R = i3;
                        this.f8841a.m6236a(fragment, false);
                        break;
                    case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                        Fragment fragment2;
                        fragment = op.f8876d;
                        if (this.f8841a.mAdded != null) {
                            fragment2 = fragment;
                            for (int i5 = 0; i5 < this.f8841a.mAdded.size(); i5++) {
                                fragment = (Fragment) this.f8841a.mAdded.get(i5);
                                if (FragmentManagerImpl.f3764a) {
                                    Log.v("FragmentManager", "OP_REPLACE: adding=" + fragment2 + " old=" + fragment);
                                }
                                if (fragment2 == null || fragment.f105I == fragment2.f105I) {
                                    if (fragment == fragment2) {
                                        op.f8876d = null;
                                        fragment2 = null;
                                    } else {
                                        if (op.f8881i == null) {
                                            op.f8881i = new ArrayList();
                                        }
                                        op.f8881i.add(fragment);
                                        fragment.f114R = i4;
                                        if (this.f8851k) {
                                            fragment.f99C++;
                                            if (FragmentManagerImpl.f3764a) {
                                                Log.v("FragmentManager", "Bump nesting of " + fragment + " to " + fragment.f99C);
                                            }
                                        }
                                        this.f8841a.m6234a(fragment, i2, i);
                                    }
                                }
                            }
                        } else {
                            fragment2 = fragment;
                        }
                        if (fragment2 == null) {
                            break;
                        }
                        fragment2.f114R = i3;
                        this.f8841a.m6236a(fragment2, false);
                        break;
                    case 3:
                        fragment = op.f8876d;
                        fragment.f114R = i4;
                        this.f8841a.m6234a(fragment, i2, i);
                        break;
                    case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                        fragment = op.f8876d;
                        fragment.f114R = i4;
                        this.f8841a.m6249b(fragment, i2, i);
                        break;
                    case 5:
                        fragment = op.f8876d;
                        fragment.f114R = i3;
                        this.f8841a.m6257c(fragment, i2, i);
                        break;
                    case 6:
                        fragment = op.f8876d;
                        fragment.f114R = i4;
                        this.f8841a.m6261d(fragment, i2, i);
                        break;
                    case 7:
                        fragment = op.f8876d;
                        fragment.f114R = i3;
                        this.f8841a.m6262e(fragment, i2, i);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + op.f8875c);
                }
                op = op.f8873a;
            }
            this.f8841a.m6230a(this.f8841a.f3777m, i2, i, true);
            if (this.f8851k) {
                this.f8841a.m6247b(this);
                return;
            }
            return;
        }
        throw new IllegalStateException("addToBackStack() called after commit()");
    }

    private static void m13689a(SparseArray<Fragment> sparseArray, Fragment fragment) {
        if (fragment != null) {
            int i = fragment.f105I;
            if (i != 0 && !fragment.f107K && fragment.mx_() && fragment.f116T != null && sparseArray.get(i) == null) {
                sparseArray.put(i, fragment);
            }
        }
    }

    private static void m13694b(SparseArray<Fragment> sparseArray, Fragment fragment) {
        if (fragment != null) {
            int i = fragment.f105I;
            if (i != 0) {
                sparseArray.put(i, fragment);
            }
        }
    }

    private void m13695b(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (this.f8841a.f3779o.mo857s()) {
            for (Op op = this.f8842b; op != null; op = op.f8873a) {
                switch (op.f8875c) {
                    case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                        m13694b((SparseArray) sparseArray2, op.f8876d);
                        break;
                    case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                        Fragment fragment;
                        Fragment fragment2 = op.f8876d;
                        if (this.f8841a.mAdded != null) {
                            fragment = fragment2;
                            for (int i = 0; i < this.f8841a.mAdded.size(); i++) {
                                Fragment fragment3 = (Fragment) this.f8841a.mAdded.get(i);
                                if (fragment == null || fragment3.f105I == fragment.f105I) {
                                    if (fragment3 == fragment) {
                                        fragment = null;
                                    } else {
                                        m13689a((SparseArray) sparseArray, fragment3);
                                    }
                                }
                            }
                        } else {
                            fragment = fragment2;
                        }
                        m13694b((SparseArray) sparseArray2, fragment);
                        break;
                    case 3:
                        m13689a((SparseArray) sparseArray, op.f8876d);
                        break;
                    case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                        m13689a((SparseArray) sparseArray, op.f8876d);
                        break;
                    case 5:
                        m13694b((SparseArray) sparseArray2, op.f8876d);
                        break;
                    case 6:
                        m13689a((SparseArray) sparseArray, op.f8876d);
                        break;
                    case 7:
                        m13694b((SparseArray) sparseArray2, op.f8876d);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public final void m13707a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (this.f8841a.f3779o.mo857s()) {
            for (Op op = this.f8842b; op != null; op = op.f8873a) {
                switch (op.f8875c) {
                    case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                        m13689a((SparseArray) sparseArray, op.f8876d);
                        break;
                    case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                        if (op.f8881i != null) {
                            for (int size = op.f8881i.size() - 1; size >= 0; size--) {
                                m13694b((SparseArray) sparseArray2, (Fragment) op.f8881i.get(size));
                            }
                        }
                        m13689a((SparseArray) sparseArray, op.f8876d);
                        break;
                    case 3:
                        m13694b((SparseArray) sparseArray2, op.f8876d);
                        break;
                    case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                        m13694b((SparseArray) sparseArray2, op.f8876d);
                        break;
                    case 5:
                        m13689a((SparseArray) sparseArray, op.f8876d);
                        break;
                    case 6:
                        m13694b((SparseArray) sparseArray2, op.f8876d);
                        break;
                    case 7:
                        m13689a((SparseArray) sparseArray, op.f8876d);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public final TransitionState m13696a(boolean z, TransitionState transitionState, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (FragmentManagerImpl.f3764a) {
            Log.v("FragmentManager", "popFromBackStack: " + this);
            m13708a("  ", new PrintWriter(new LogWriter("FragmentManager")));
        }
        if (transitionState == null) {
            if (!(sparseArray.size() == 0 && sparseArray2.size() == 0)) {
                transitionState = m13675a((SparseArray) sparseArray, (SparseArray) sparseArray2, true);
            }
        } else if (!z) {
            m13685a(transitionState, this.f8861u, this.f8860t);
        }
        m13714b(-1);
        int i = transitionState != null ? 0 : this.f8850j;
        int i2 = transitionState != null ? 0 : this.f8849i;
        Op op = this.f8843c;
        while (op != null) {
            int i3 = transitionState != null ? 0 : op.f8879g;
            int i4 = transitionState != null ? 0 : op.f8880h;
            Fragment fragment;
            Fragment fragment2;
            switch (op.f8875c) {
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    fragment = op.f8876d;
                    fragment.f114R = i4;
                    this.f8841a.m6234a(fragment, FragmentManagerImpl.m6218e(i2), i);
                    break;
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    fragment = op.f8876d;
                    if (fragment != null) {
                        fragment.f114R = i4;
                        this.f8841a.m6234a(fragment, FragmentManagerImpl.m6218e(i2), i);
                    }
                    if (op.f8881i == null) {
                        break;
                    }
                    for (int i5 = 0; i5 < op.f8881i.size(); i5++) {
                        fragment2 = (Fragment) op.f8881i.get(i5);
                        fragment2.f114R = i3;
                        this.f8841a.m6236a(fragment2, false);
                    }
                    break;
                case 3:
                    fragment2 = op.f8876d;
                    fragment2.f114R = i3;
                    this.f8841a.m6236a(fragment2, false);
                    break;
                case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                    fragment2 = op.f8876d;
                    fragment2.f114R = i3;
                    this.f8841a.m6257c(fragment2, FragmentManagerImpl.m6218e(i2), i);
                    break;
                case 5:
                    fragment = op.f8876d;
                    fragment.f114R = i4;
                    this.f8841a.m6249b(fragment, FragmentManagerImpl.m6218e(i2), i);
                    break;
                case 6:
                    fragment2 = op.f8876d;
                    fragment2.f114R = i3;
                    this.f8841a.m6262e(fragment2, FragmentManagerImpl.m6218e(i2), i);
                    break;
                case 7:
                    fragment2 = op.f8876d;
                    fragment2.f114R = i3;
                    this.f8841a.m6261d(fragment2, FragmentManagerImpl.m6218e(i2), i);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + op.f8875c);
            }
            op = op.f8874b;
        }
        if (z) {
            this.f8841a.m6230a(this.f8841a.f3777m, FragmentManagerImpl.m6218e(i2), i, true);
            transitionState = null;
        }
        if (this.f8855o >= 0) {
            this.f8841a.m6260d(this.f8855o);
            this.f8855o = -1;
        }
        return transitionState;
    }

    public final String m13718d() {
        return this.f8853m;
    }

    public final boolean mo1855e() {
        return this.f8844d == 0;
    }

    private TransitionState m13675a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, boolean z) {
        int i = 0;
        TransitionState transitionState = new TransitionState(this);
        transitionState.d = new View(this.f8841a.f3778n.mo865h());
        int i2 = 0;
        int i3 = 0;
        while (i2 < sparseArray.size()) {
            int i4;
            if (m13691a(sparseArray.keyAt(i2), transitionState, z, (SparseArray) sparseArray, (SparseArray) sparseArray2)) {
                i4 = 1;
            } else {
                i4 = i3;
            }
            i2++;
            i3 = i4;
        }
        while (i < sparseArray2.size()) {
            i4 = sparseArray2.keyAt(i);
            if (sparseArray.get(i4) == null && m13691a(i4, transitionState, z, (SparseArray) sparseArray, (SparseArray) sparseArray2)) {
                i3 = 1;
            }
            i++;
        }
        if (i3 == 0) {
            return null;
        }
        return transitionState;
    }

    private static Object m13680a(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        Object obj;
        if (z) {
            Object obj2;
            if (fragment.ad == Fragment.f96j) {
                obj2 = fragment.ac;
            } else {
                obj2 = fragment.ad;
            }
            obj = obj2;
        } else {
            obj = fragment.aa;
        }
        return FragmentTransitionCompat21.a(obj);
    }

    private static Object m13692b(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        Object obj;
        if (z) {
            Object obj2;
            if (fragment.ab == Fragment.f96j) {
                obj2 = fragment.aa;
            } else {
                obj2 = fragment.ab;
            }
            obj = obj2;
        } else {
            obj = fragment.ac;
        }
        return FragmentTransitionCompat21.a(obj);
    }

    private static Object m13679a(Fragment fragment, Fragment fragment2, boolean z) {
        if (fragment == null || fragment2 == null) {
            return null;
        }
        Object obj;
        if (z) {
            obj = fragment2.af == Fragment.f96j ? fragment2.ae : fragment2.af;
        } else {
            obj = fragment.ae;
        }
        return FragmentTransitionCompat21.a(obj);
    }

    private static Object m13681a(Object obj, Fragment fragment, ArrayList<View> arrayList, ArrayMap<String, View> arrayMap, View view) {
        return obj != null ? FragmentTransitionCompat21.a(obj, fragment.f116T, arrayList, arrayMap, view) : obj;
    }

    private ArrayMap<String, View> m13676a(TransitionState transitionState, Fragment fragment, boolean z) {
        ArrayMap arrayMap = new ArrayMap();
        if (this.f8860t != null) {
            FragmentTransitionCompat21.a(arrayMap, fragment.f116T);
            if (z) {
                arrayMap.a(this.f8861u);
            } else {
                arrayMap = m13678a(this.f8860t, this.f8861u, arrayMap);
            }
        }
        SharedElementCallback sharedElementCallback;
        if (z) {
            if (fragment.ai != null) {
                sharedElementCallback = fragment.ai;
            }
            m13683a(transitionState, arrayMap, false);
        } else {
            if (fragment.aj != null) {
                sharedElementCallback = fragment.aj;
            }
            m13693b(transitionState, arrayMap, false);
        }
        return arrayMap;
    }

    private boolean m13691a(int i, TransitionState transitionState, boolean z, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        View view = (ViewGroup) this.f8841a.f3779o.mo856a(i);
        if (view == null) {
            return false;
        }
        Fragment fragment = (Fragment) sparseArray2.get(i);
        Fragment fragment2 = (Fragment) sparseArray.get(i);
        Object a = m13680a(fragment, z);
        Object a2 = m13679a(fragment, fragment2, z);
        Object b = m13692b(fragment2, z);
        if (a == null && a2 == null && b == null) {
            return false;
        }
        ArrayMap arrayMap = null;
        ArrayList arrayList = new ArrayList();
        if (a2 != null) {
            arrayMap = m13676a(transitionState, fragment2, z);
            arrayList.add(transitionState.d);
            arrayList.addAll(arrayMap.values());
            if ((z ? fragment2.ai : fragment.ai) != null) {
                ArrayList arrayList2 = new ArrayList(arrayMap.keySet());
                arrayList2 = new ArrayList(arrayMap.values());
            }
        }
        ArrayList arrayList3 = new ArrayList();
        Object a3 = m13681a(b, fragment2, arrayList3, arrayMap, transitionState.d);
        if (!(this.f8861u == null || arrayMap == null)) {
            View view2 = (View) arrayMap.get(this.f8861u.get(0));
            if (view2 != null) {
                if (a3 != null) {
                    FragmentTransitionCompat21.a(a3, view2);
                }
                if (a2 != null) {
                    FragmentTransitionCompat21.a(a2, view2);
                }
            }
        }
        1 1 = new 1(this, fragment);
        if (a2 != null) {
            m13684a(transitionState, view, a2, fragment, fragment2, z, arrayList);
        }
        ArrayList arrayList4 = new ArrayList();
        ArrayMap arrayMap2 = new ArrayMap();
        Object a4 = FragmentTransitionCompat21.a(a, a3, a2, z ? fragment.m233S() : fragment.m232R());
        if (a4 != null) {
            FragmentTransitionCompat21.a(a, a2, view, 1, transitionState.d, transitionState.c, transitionState.a, arrayList4, arrayMap2, arrayList);
            m13690a(view, transitionState, i, a4);
            FragmentTransitionCompat21.a(a4, transitionState.d, true);
            m13686a(this, transitionState, i, a4);
            FragmentTransitionCompat21.a(view, a4);
            FragmentTransitionCompat21.a(view, transitionState.d, a, arrayList4, a3, arrayList3, a2, arrayList, a4, transitionState.b, arrayMap2);
        }
        if (a4 != null) {
            return true;
        }
        return false;
    }

    private void m13684a(TransitionState transitionState, View view, Object obj, Fragment fragment, Fragment fragment2, boolean z, ArrayList<View> arrayList) {
        view.getViewTreeObserver().addOnPreDrawListener(new 2(this, view, obj, arrayList, transitionState, z, fragment, fragment2));
    }

    static /* synthetic */ void m13687a(BackStackRecord backStackRecord, TransitionState transitionState, Fragment fragment, Fragment fragment2, boolean z, ArrayMap arrayMap) {
        if ((z ? fragment2.ai : fragment.ai) != null) {
            ArrayList arrayList = new ArrayList(arrayMap.keySet());
            arrayList = new ArrayList(arrayMap.values());
        }
    }

    public static ArrayMap m13677a(BackStackRecord backStackRecord, TransitionState transitionState, boolean z, Fragment fragment) {
        ArrayMap arrayMap = new ArrayMap();
        View view = fragment.f116T;
        if (!(view == null || backStackRecord.f8860t == null)) {
            FragmentTransitionCompat21.a(arrayMap, view);
            if (z) {
                arrayMap = m13678a(backStackRecord.f8860t, backStackRecord.f8861u, arrayMap);
            } else {
                arrayMap.a(backStackRecord.f8861u);
            }
        }
        ArrayMap arrayMap2 = arrayMap;
        SharedElementCallback sharedElementCallback;
        if (z) {
            if (fragment.aj != null) {
                sharedElementCallback = fragment.aj;
            }
            backStackRecord.m13683a(transitionState, arrayMap2, true);
        } else {
            if (fragment.ai != null) {
                sharedElementCallback = fragment.ai;
            }
            m13693b(transitionState, arrayMap2, true);
        }
        return arrayMap2;
    }

    public static ArrayMap<String, View> m13678a(ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayMap<String, View> arrayMap) {
        if (arrayMap.isEmpty()) {
            return arrayMap;
        }
        ArrayMap<String, View> arrayMap2 = new ArrayMap();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = (View) arrayMap.get(arrayList.get(i));
            if (view != null) {
                arrayMap2.put(arrayList2.get(i), view);
            }
        }
        return arrayMap2;
    }

    private void m13690a(View view, TransitionState transitionState, int i, Object obj) {
        view.getViewTreeObserver().addOnPreDrawListener(new 3(this, view, transitionState, i, obj));
    }

    public static void m13686a(BackStackRecord backStackRecord, TransitionState transitionState, int i, Object obj) {
        if (backStackRecord.f8841a.mAdded != null) {
            for (int i2 = 0; i2 < backStackRecord.f8841a.mAdded.size(); i2++) {
                Fragment fragment = (Fragment) backStackRecord.f8841a.mAdded.get(i2);
                if (!(fragment.f116T == null || fragment.f115S == null || fragment.f105I != i)) {
                    if (!fragment.f107K) {
                        FragmentTransitionCompat21.a(obj, fragment.f116T, false);
                        transitionState.b.remove(fragment.f116T);
                    } else if (!transitionState.b.contains(fragment.f116T)) {
                        FragmentTransitionCompat21.a(obj, fragment.f116T, true);
                        transitionState.b.add(fragment.f116T);
                    }
                }
            }
        }
    }

    private static void m13688a(ArrayMap<String, String> arrayMap, String str, String str2) {
        if (str != null && str2 != null && !str.equals(str2)) {
            for (int i = 0; i < arrayMap.size(); i++) {
                if (str.equals(arrayMap.c(i))) {
                    arrayMap.a(i, str2);
                    return;
                }
            }
            arrayMap.put(str, str2);
        }
    }

    private static void m13685a(TransitionState transitionState, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                m13688a(transitionState.a, (String) arrayList.get(i), (String) arrayList2.get(i));
            }
        }
    }

    private void m13683a(TransitionState transitionState, ArrayMap<String, View> arrayMap, boolean z) {
        int size = this.f8861u == null ? 0 : this.f8861u.size();
        for (int i = 0; i < size; i++) {
            String str = (String) this.f8860t.get(i);
            View view = (View) arrayMap.get((String) this.f8861u.get(i));
            if (view != null) {
                String a = FragmentTransitionCompat21.a(view);
                if (z) {
                    m13688a(transitionState.a, str, a);
                } else {
                    m13688a(transitionState.a, a, str);
                }
            }
        }
    }

    private static void m13693b(TransitionState transitionState, ArrayMap<String, View> arrayMap, boolean z) {
        int size = arrayMap.size();
        for (int i = 0; i < size; i++) {
            String str = (String) arrayMap.b(i);
            String a = FragmentTransitionCompat21.a((View) arrayMap.c(i));
            if (z) {
                m13688a(transitionState.a, str, a);
            } else {
                m13688a(transitionState.a, a, str);
            }
        }
    }
}
