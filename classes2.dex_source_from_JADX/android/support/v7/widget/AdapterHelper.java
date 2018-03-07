package android.support.v7.widget;

import android.support.v4.util.Pools$Pool;
import android.support.v4.util.Pools$SimplePool;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.facebook.proxygen.HTTPTransportCallback;
import java.util.ArrayList;
import java.util.List;

/* compiled from: num_queries */
public class AdapterHelper implements Callback {
    public final ArrayList<UpdateOp> f11949a;
    final ArrayList<UpdateOp> f11950b;
    final Callback f11951c;
    Runnable f11952d;
    final boolean f11953e;
    final OpReorderer f11954f;
    private Pools$Pool<UpdateOp> f11955g;

    /* compiled from: num_queries */
    interface Callback {
        ViewHolder mo2262a(int i);

        void mo2263a(int i, int i2);

        void mo2264a(int i, int i2, Object obj);

        void mo2265a(UpdateOp updateOp);

        void mo2266b(int i, int i2);

        void mo2267b(UpdateOp updateOp);

        void mo2268c(int i, int i2);

        void mo2269d(int i, int i2);
    }

    /* compiled from: num_queries */
    public class UpdateOp {
        public int f18985a;
        public int f18986b;
        Object f18987c;
        public int f18988d;

        UpdateOp(int i, int i2, int i3, Object obj) {
            this.f18985a = i;
            this.f18986b = i2;
            this.f18988d = i3;
            this.f18987c = obj;
        }

        public String toString() {
            String str;
            StringBuilder append = new StringBuilder().append(Integer.toHexString(System.identityHashCode(this))).append("[");
            switch (this.f18985a) {
                case 0:
                    str = "add";
                    break;
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    str = "rm";
                    break;
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    str = "up";
                    break;
                case 3:
                    str = "mv";
                    break;
                default:
                    str = "??";
                    break;
            }
            return append.append(str).append(",s:").append(this.f18986b).append("c:").append(this.f18988d).append(",p:").append(this.f18987c).append("]").toString();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            UpdateOp updateOp = (UpdateOp) obj;
            if (this.f18985a != updateOp.f18985a) {
                return false;
            }
            if (this.f18985a == 3 && Math.abs(this.f18988d - this.f18986b) == 1 && this.f18988d == updateOp.f18986b && this.f18986b == updateOp.f18988d) {
                return true;
            }
            if (this.f18988d != updateOp.f18988d) {
                return false;
            }
            if (this.f18986b != updateOp.f18986b) {
                return false;
            }
            if (this.f18987c != null) {
                if (this.f18987c.equals(updateOp.f18987c)) {
                    return true;
                }
                return false;
            } else if (updateOp.f18987c != null) {
                return false;
            } else {
                return true;
            }
        }

        public int hashCode() {
            return (((this.f18985a * 31) + this.f18986b) * 31) + this.f18988d;
        }
    }

    AdapterHelper(Callback callback) {
        this(callback, false);
    }

    private AdapterHelper(Callback callback, boolean z) {
        this.f11955g = new Pools$SimplePool(30);
        this.f11949a = new ArrayList();
        this.f11950b = new ArrayList();
        this.f11951c = callback;
        this.f11953e = z;
        this.f11954f = new OpReorderer(this);
    }

    final void m17574a() {
        m17564a(this.f11949a);
        m17564a(this.f11950b);
    }

    final void m17577b() {
        this.f11954f.m17603a(this.f11949a);
        int size = this.f11949a.size();
        for (int i = 0; i < size; i++) {
            UpdateOp updateOp = (UpdateOp) this.f11949a.get(i);
            switch (updateOp.f18985a) {
                case 0:
                    m17571g(updateOp);
                    break;
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    m17566c(updateOp);
                    break;
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    m17569d(updateOp);
                    break;
                case 3:
                    m17571g(updateOp);
                    break;
            }
            if (this.f11952d != null) {
                this.f11952d.run();
            }
        }
        this.f11949a.clear();
    }

    final void m17578c() {
        int size = this.f11950b.size();
        for (int i = 0; i < size; i++) {
            this.f11951c.mo2267b((UpdateOp) this.f11950b.get(i));
        }
        m17564a(this.f11950b);
    }

    private void m17566c(UpdateOp updateOp) {
        int i = updateOp.f18986b;
        int i2 = updateOp.f18986b + updateOp.f18988d;
        int i3 = -1;
        int i4 = updateOp.f18986b;
        int i5 = 0;
        while (i4 < i2) {
            int i6;
            if (this.f11951c.mo2262a(i4) != null || m17567c(i4)) {
                if (i3 == 0) {
                    m17570e(mo2260a(1, i, i5, null));
                    i6 = 1;
                } else {
                    i6 = 0;
                }
                i3 = 1;
            } else {
                if (i3 == 1) {
                    m17571g(mo2260a(1, i, i5, null));
                    i6 = 1;
                } else {
                    i6 = 0;
                }
                i3 = 0;
            }
            if (i6 != 0) {
                i6 = i4 - i5;
                i4 = i2 - i5;
                i2 = 1;
            } else {
                int i7 = i4;
                i4 = i2;
                i2 = i5 + 1;
                i6 = i7;
            }
            i5 = i2;
            i2 = i4;
            i4 = i6 + 1;
        }
        if (i5 != updateOp.f18988d) {
            mo2261a(updateOp);
            updateOp = mo2260a(1, i, i5, null);
        }
        if (i3 == 0) {
            m17570e(updateOp);
        } else {
            m17571g(updateOp);
        }
    }

    private void m17569d(UpdateOp updateOp) {
        int i = updateOp.f18986b;
        int i2 = updateOp.f18986b + updateOp.f18988d;
        int i3 = updateOp.f18986b;
        Object obj = -1;
        int i4 = 0;
        while (i3 < i2) {
            int i5;
            Object obj2;
            if (this.f11951c.mo2262a(i3) != null || m17567c(i3)) {
                if (obj == null) {
                    m17570e(mo2260a(2, i, i4, updateOp.f18987c));
                    i4 = 0;
                    i = i3;
                }
                i5 = i;
                i = i4;
                obj2 = 1;
            } else {
                if (obj == 1) {
                    m17571g(mo2260a(2, i, i4, updateOp.f18987c));
                    i4 = 0;
                    i = i3;
                }
                i5 = i;
                i = i4;
                obj2 = null;
            }
            i3++;
            Object obj3 = obj2;
            i4 = i + 1;
            i = i5;
            obj = obj3;
        }
        if (i4 != updateOp.f18988d) {
            Object obj4 = updateOp.f18987c;
            mo2261a(updateOp);
            updateOp = mo2260a(2, i, i4, obj4);
        }
        if (obj == null) {
            m17570e(updateOp);
        } else {
            m17571g(updateOp);
        }
    }

    private void m17570e(UpdateOp updateOp) {
        if (updateOp.f18985a == 0 || updateOp.f18985a == 3) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int i;
        int c = m17565c(updateOp.f18986b, updateOp.f18985a);
        int i2 = updateOp.f18986b;
        switch (updateOp.f18985a) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                i = 0;
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                i = 1;
                break;
            default:
                throw new IllegalArgumentException("op should be remove or update." + updateOp);
        }
        int i3 = 1;
        int i4 = c;
        c = i2;
        for (i2 = 1; i2 < updateOp.f18988d; i2++) {
            Object obj;
            int c2 = m17565c(updateOp.f18986b + (i * i2), updateOp.f18985a);
            int i5;
            switch (updateOp.f18985a) {
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    if (c2 != i4) {
                        obj = null;
                        break;
                    } else {
                        i5 = 1;
                        break;
                    }
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    if (c2 != i4 + 1) {
                        obj = null;
                        break;
                    } else {
                        i5 = 1;
                        break;
                    }
                default:
                    obj = null;
                    break;
            }
            if (obj != null) {
                i3++;
            } else {
                UpdateOp a = mo2260a(updateOp.f18985a, i4, i3, updateOp.f18987c);
                m17563a(a, c);
                mo2261a(a);
                if (updateOp.f18985a == 2) {
                    c += i3;
                }
                i3 = 1;
                i4 = c2;
            }
        }
        Object obj2 = updateOp.f18987c;
        mo2261a(updateOp);
        if (i3 > 0) {
            UpdateOp a2 = mo2260a(updateOp.f18985a, i4, i3, obj2);
            m17563a(a2, c);
            mo2261a(a2);
        }
    }

    private void m17563a(UpdateOp updateOp, int i) {
        this.f11951c.mo2265a(updateOp);
        switch (updateOp.f18985a) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                this.f11951c.mo2263a(i, updateOp.f18988d);
                return;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                this.f11951c.mo2264a(i, updateOp.f18988d, updateOp.f18987c);
                return;
            default:
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    private int m17565c(int i, int i2) {
        int i3;
        int size = this.f11950b.size() - 1;
        int i4 = i;
        while (size >= 0) {
            int i5;
            UpdateOp updateOp = (UpdateOp) this.f11950b.get(size);
            if (updateOp.f18985a == 3) {
                int i6;
                if (updateOp.f18986b < updateOp.f18988d) {
                    i6 = updateOp.f18986b;
                    i3 = updateOp.f18988d;
                } else {
                    i6 = updateOp.f18988d;
                    i3 = updateOp.f18986b;
                }
                if (i4 < i6 || i4 > r2) {
                    if (i4 < updateOp.f18986b) {
                        if (i2 == 0) {
                            updateOp.f18986b++;
                            updateOp.f18988d++;
                            i5 = i4;
                        } else if (i2 == 1) {
                            updateOp.f18986b--;
                            updateOp.f18988d--;
                        }
                    }
                    i5 = i4;
                } else if (i6 == updateOp.f18986b) {
                    if (i2 == 0) {
                        updateOp.f18988d++;
                    } else if (i2 == 1) {
                        updateOp.f18988d--;
                    }
                    i5 = i4 + 1;
                } else {
                    if (i2 == 0) {
                        updateOp.f18986b++;
                    } else if (i2 == 1) {
                        updateOp.f18986b--;
                    }
                    i5 = i4 - 1;
                }
            } else {
                if (updateOp.f18986b <= i4) {
                    if (updateOp.f18985a == 0) {
                        i5 = i4 - updateOp.f18988d;
                    } else if (updateOp.f18985a == 1) {
                        i5 = updateOp.f18988d + i4;
                    }
                } else if (i2 == 0) {
                    updateOp.f18986b++;
                    i5 = i4;
                } else if (i2 == 1) {
                    updateOp.f18986b--;
                }
                i5 = i4;
            }
            size--;
            i4 = i5;
        }
        for (i3 = this.f11950b.size() - 1; i3 >= 0; i3--) {
            updateOp = (UpdateOp) this.f11950b.get(i3);
            if (updateOp.f18985a == 3) {
                if (updateOp.f18988d == updateOp.f18986b || updateOp.f18988d < 0) {
                    this.f11950b.remove(i3);
                    mo2261a(updateOp);
                }
            } else if (updateOp.f18988d <= 0) {
                this.f11950b.remove(i3);
                mo2261a(updateOp);
            }
        }
        return i4;
    }

    private boolean m17567c(int i) {
        int size = this.f11950b.size();
        for (int i2 = 0; i2 < size; i2++) {
            UpdateOp updateOp = (UpdateOp) this.f11950b.get(i2);
            if (updateOp.f18985a == 3) {
                if (m17568d(updateOp.f18988d, i2 + 1) == i) {
                    return true;
                }
            } else if (updateOp.f18985a == 0) {
                int i3 = updateOp.f18986b + updateOp.f18988d;
                for (int i4 = updateOp.f18986b; i4 < i3; i4++) {
                    if (m17568d(i4, i2 + 1) == i) {
                        return true;
                    }
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    private void m17571g(UpdateOp updateOp) {
        this.f11950b.add(updateOp);
        switch (updateOp.f18985a) {
            case 0:
                this.f11951c.mo2268c(updateOp.f18986b, updateOp.f18988d);
                return;
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                this.f11951c.mo2266b(updateOp.f18986b, updateOp.f18988d);
                return;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                this.f11951c.mo2264a(updateOp.f18986b, updateOp.f18988d, updateOp.f18987c);
                return;
            case 3:
                this.f11951c.mo2269d(updateOp.f18986b, updateOp.f18988d);
                return;
            default:
                throw new IllegalArgumentException("Unknown update op type for " + updateOp);
        }
    }

    final boolean m17579d() {
        return this.f11949a.size() > 0;
    }

    final int m17572a(int i) {
        return m17568d(i, 0);
    }

    private int m17568d(int i, int i2) {
        int size = this.f11950b.size();
        int i3 = i;
        while (i2 < size) {
            UpdateOp updateOp = (UpdateOp) this.f11950b.get(i2);
            if (updateOp.f18985a == 3) {
                if (updateOp.f18986b == i3) {
                    i3 = updateOp.f18988d;
                } else {
                    if (updateOp.f18986b < i3) {
                        i3--;
                    }
                    if (updateOp.f18988d <= i3) {
                        i3++;
                    }
                }
            } else if (updateOp.f18986b > i3) {
                continue;
            } else if (updateOp.f18985a == 1) {
                if (i3 < updateOp.f18986b + updateOp.f18988d) {
                    return -1;
                }
                i3 -= updateOp.f18988d;
            } else if (updateOp.f18985a == 0) {
                i3 += updateOp.f18988d;
            }
            i2++;
        }
        return i3;
    }

    final boolean m17576a(int i, int i2, int i3) {
        if (i == i2) {
            return false;
        }
        if (i3 != 1) {
            throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
        }
        this.f11949a.add(mo2260a(3, i, i2, null));
        if (this.f11949a.size() == 1) {
            return true;
        }
        return false;
    }

    final void m17580e() {
        m17578c();
        int size = this.f11949a.size();
        for (int i = 0; i < size; i++) {
            UpdateOp updateOp = (UpdateOp) this.f11949a.get(i);
            switch (updateOp.f18985a) {
                case 0:
                    this.f11951c.mo2267b(updateOp);
                    this.f11951c.mo2268c(updateOp.f18986b, updateOp.f18988d);
                    break;
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    this.f11951c.mo2267b(updateOp);
                    this.f11951c.mo2263a(updateOp.f18986b, updateOp.f18988d);
                    break;
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    this.f11951c.mo2267b(updateOp);
                    this.f11951c.mo2264a(updateOp.f18986b, updateOp.f18988d, updateOp.f18987c);
                    break;
                case 3:
                    this.f11951c.mo2267b(updateOp);
                    this.f11951c.mo2269d(updateOp.f18986b, updateOp.f18988d);
                    break;
            }
            if (this.f11952d != null) {
                this.f11952d.run();
            }
        }
        m17564a(this.f11949a);
    }

    public final UpdateOp mo2260a(int i, int i2, int i3, Object obj) {
        UpdateOp updateOp = (UpdateOp) this.f11955g.mo740a();
        if (updateOp == null) {
            return new UpdateOp(i, i2, i3, obj);
        }
        updateOp.f18985a = i;
        updateOp.f18986b = i2;
        updateOp.f18988d = i3;
        updateOp.f18987c = obj;
        return updateOp;
    }

    public final void mo2261a(UpdateOp updateOp) {
        if (!this.f11953e) {
            updateOp.f18987c = null;
            this.f11955g.mo741a(updateOp);
        }
    }

    private void m17564a(List<UpdateOp> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            mo2261a((UpdateOp) list.get(i));
        }
        list.clear();
    }
}
