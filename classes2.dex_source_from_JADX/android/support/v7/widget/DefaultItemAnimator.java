package android.support.v7.widget;

import android.support.v4.animation.AnimatorCompatHelper;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: num_retries */
public class DefaultItemAnimator extends ItemAnimator {
    private ArrayList<ViewHolder> f11907a = new ArrayList();
    private ArrayList<ViewHolder> f11908b = new ArrayList();
    private ArrayList<MoveInfo> f11909c = new ArrayList();
    private ArrayList<ChangeInfo> f11910d = new ArrayList();
    public ArrayList<ArrayList<ViewHolder>> f11911e = new ArrayList();
    public ArrayList<ArrayList<MoveInfo>> f11912f = new ArrayList();
    public ArrayList<ArrayList<ChangeInfo>> f11913g = new ArrayList();
    public ArrayList<ViewHolder> f11914h = new ArrayList();
    public ArrayList<ViewHolder> f11915i = new ArrayList();
    public ArrayList<ViewHolder> f11916j = new ArrayList();
    public ArrayList<ViewHolder> f11917k = new ArrayList();

    public final void mo2235a() {
        int i;
        int i2;
        int i3;
        int i4 = !this.f11907a.isEmpty() ? 1 : 0;
        if (this.f11909c.isEmpty()) {
            i = 0;
        } else {
            i = 1;
        }
        if (this.f11910d.isEmpty()) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (this.f11908b.isEmpty()) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        if (i4 != 0 || i != 0 || i3 != 0 || i2 != 0) {
            ArrayList arrayList;
            Runnable 1;
            Iterator it = this.f11907a.iterator();
            while (it.hasNext()) {
                m17450g((ViewHolder) it.next());
            }
            this.f11907a.clear();
            if (i != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.f11909c);
                this.f11912f.add(arrayList);
                this.f11909c.clear();
                1 = new 1(this, arrayList);
                if (i4 != 0) {
                    ViewCompat.m10944a(((MoveInfo) arrayList.get(0)).a.f14095a, 1, this.f11921d);
                } else {
                    1.run();
                }
            }
            if (i2 != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.f11910d);
                this.f11913g.add(arrayList);
                this.f11910d.clear();
                1 = new 2(this, arrayList);
                if (i4 != 0) {
                    ViewCompat.m10944a(((ChangeInfo) arrayList.get(0)).a.f14095a, 1, m17477f());
                } else {
                    1.run();
                }
            }
            if (i3 != 0) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.f11908b);
                this.f11911e.add(arrayList2);
                this.f11908b.clear();
                Runnable 3 = new 3(this, arrayList2);
                if (i4 == 0 && i == 0 && i2 == 0) {
                    3.run();
                    return;
                }
                long d;
                long g;
                long f = i4 != 0 ? m17477f() : 0;
                if (i != 0) {
                    d = m17473d();
                } else {
                    d = 0;
                }
                if (i2 != 0) {
                    g = m17479g();
                } else {
                    g = 0;
                }
                ViewCompat.m10944a(((ViewHolder) arrayList2.get(0)).f14095a, 3, f + Math.max(d, g));
            }
        }
    }

    public final boolean mo2236a(ViewHolder viewHolder) {
        m17451i(viewHolder);
        this.f11907a.add(viewHolder);
        return true;
    }

    private void m17450g(ViewHolder viewHolder) {
        ViewPropertyAnimatorCompat t = ViewCompat.m10976t(viewHolder.f14095a);
        this.f11916j.add(viewHolder);
        t.a(this.f11921d).a(0.0f).a(new 4(this, viewHolder, t)).b();
    }

    public final boolean mo2240b(ViewHolder viewHolder) {
        m17451i(viewHolder);
        ViewCompat.m10954c(viewHolder.f14095a, 0.0f);
        this.f11908b.add(viewHolder);
        return true;
    }

    public final boolean mo2237a(ViewHolder viewHolder, int i, int i2, int i3, int i4) {
        View view = viewHolder.f14095a;
        int p = (int) (((float) i) + ViewCompat.m10972p(viewHolder.f14095a));
        int q = (int) (((float) i2) + ViewCompat.m10973q(viewHolder.f14095a));
        m17451i(viewHolder);
        int i5 = i3 - p;
        int i6 = i4 - q;
        if (i5 == 0 && i6 == 0) {
            m17476e(viewHolder);
            return false;
        }
        if (i5 != 0) {
            ViewCompat.m10935a(view, (float) (-i5));
        }
        if (i6 != 0) {
            ViewCompat.m10949b(view, (float) (-i6));
        }
        this.f11909c.add(new MoveInfo(viewHolder, p, q, i3, i4, (byte) 0));
        return true;
    }

    private void m17449b(ViewHolder viewHolder, int i, int i2, int i3, int i4) {
        View view = viewHolder.f14095a;
        int i5 = i3 - i;
        int i6 = i4 - i2;
        if (i5 != 0) {
            ViewCompat.m10976t(view).b(0.0f);
        }
        if (i6 != 0) {
            ViewCompat.m10976t(view).c(0.0f);
        }
        ViewPropertyAnimatorCompat t = ViewCompat.m10976t(view);
        this.f11915i.add(viewHolder);
        t.a(this.f11922e).a(new 6(this, viewHolder, i5, i6, t)).b();
    }

    public final boolean mo2238a(ViewHolder viewHolder, ViewHolder viewHolder2, int i, int i2, int i3, int i4) {
        float p = ViewCompat.m10972p(viewHolder.f14095a);
        float q = ViewCompat.m10973q(viewHolder.f14095a);
        float f = ViewCompat.m10961f(viewHolder.f14095a);
        m17451i(viewHolder);
        int i5 = (int) (((float) (i3 - i)) - p);
        int i6 = (int) (((float) (i4 - i2)) - q);
        ViewCompat.m10935a(viewHolder.f14095a, p);
        ViewCompat.m10949b(viewHolder.f14095a, q);
        ViewCompat.m10954c(viewHolder.f14095a, f);
        if (!(viewHolder2 == null || viewHolder2.f14095a == null)) {
            m17451i(viewHolder2);
            ViewCompat.m10935a(viewHolder2.f14095a, (float) (-i5));
            ViewCompat.m10949b(viewHolder2.f14095a, (float) (-i6));
            ViewCompat.m10954c(viewHolder2.f14095a, 0.0f);
        }
        this.f11910d.add(new ChangeInfo(viewHolder, viewHolder2, i, i2, i3, i4, (byte) 0));
        return true;
    }

    private void m17446a(List<ChangeInfo> list, ViewHolder viewHolder) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ChangeInfo changeInfo = (ChangeInfo) list.get(size);
            if (m17447a(changeInfo, viewHolder) && changeInfo.a == null && changeInfo.b == null) {
                list.remove(changeInfo);
            }
        }
    }

    private void m17448b(ChangeInfo changeInfo) {
        if (changeInfo.a != null) {
            m17447a(changeInfo, changeInfo.a);
        }
        if (changeInfo.b != null) {
            m17447a(changeInfo, changeInfo.b);
        }
    }

    private boolean m17447a(ChangeInfo changeInfo, ViewHolder viewHolder) {
        boolean z = false;
        if (changeInfo.b == viewHolder) {
            changeInfo.b = null;
        } else if (changeInfo.a != viewHolder) {
            return false;
        } else {
            changeInfo.a = null;
            z = true;
        }
        ViewCompat.m10954c(viewHolder.f14095a, 1.0f);
        ViewCompat.m10935a(viewHolder.f14095a, 0.0f);
        ViewCompat.m10949b(viewHolder.f14095a, 0.0f);
        m17463a(viewHolder, z);
        return true;
    }

    public final void mo2242c(ViewHolder viewHolder) {
        int size;
        View view = viewHolder.f14095a;
        ViewCompat.m10976t(view).a();
        for (size = this.f11909c.size() - 1; size >= 0; size--) {
            if (((MoveInfo) this.f11909c.get(size)).a == viewHolder) {
                ViewCompat.m10949b(view, 0.0f);
                ViewCompat.m10935a(view, 0.0f);
                m17476e(viewHolder);
                this.f11909c.remove(size);
            }
        }
        m17446a(this.f11910d, viewHolder);
        if (this.f11907a.remove(viewHolder)) {
            ViewCompat.m10954c(view, 1.0f);
            m17474d(viewHolder);
        }
        if (this.f11908b.remove(viewHolder)) {
            ViewCompat.m10954c(view, 1.0f);
            m17478f(viewHolder);
        }
        for (size = this.f11913g.size() - 1; size >= 0; size--) {
            List list = (ArrayList) this.f11913g.get(size);
            m17446a(list, viewHolder);
            if (list.isEmpty()) {
                this.f11913g.remove(size);
            }
        }
        for (int size2 = this.f11912f.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = (ArrayList) this.f11912f.get(size2);
            int size3 = arrayList.size() - 1;
            while (size3 >= 0) {
                if (((MoveInfo) arrayList.get(size3)).a == viewHolder) {
                    ViewCompat.m10949b(view, 0.0f);
                    ViewCompat.m10935a(view, 0.0f);
                    m17476e(viewHolder);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.f11912f.remove(size2);
                    }
                } else {
                    size3--;
                }
            }
        }
        for (size = this.f11911e.size() - 1; size >= 0; size--) {
            arrayList = (ArrayList) this.f11911e.get(size);
            if (arrayList.remove(viewHolder)) {
                ViewCompat.m10954c(view, 1.0f);
                m17478f(viewHolder);
                if (arrayList.isEmpty()) {
                    this.f11911e.remove(size);
                }
            }
        }
        this.f11916j.remove(viewHolder);
        this.f11914h.remove(viewHolder);
        this.f11917k.remove(viewHolder);
        this.f11915i.remove(viewHolder);
        m17452j(this);
    }

    private void m17451i(ViewHolder viewHolder) {
        AnimatorCompatHelper.a.a(viewHolder.f14095a);
        mo2242c(viewHolder);
    }

    public final boolean mo2239b() {
        return (this.f11908b.isEmpty() && this.f11910d.isEmpty() && this.f11909c.isEmpty() && this.f11907a.isEmpty() && this.f11915i.isEmpty() && this.f11916j.isEmpty() && this.f11914h.isEmpty() && this.f11917k.isEmpty() && this.f11912f.isEmpty() && this.f11911e.isEmpty() && this.f11913g.isEmpty()) ? false : true;
    }

    public static void m17452j(DefaultItemAnimator defaultItemAnimator) {
        if (!defaultItemAnimator.mo2239b()) {
            defaultItemAnimator.m17481i();
        }
    }

    public final void mo2241c() {
        int size;
        for (size = this.f11909c.size() - 1; size >= 0; size--) {
            MoveInfo moveInfo = (MoveInfo) this.f11909c.get(size);
            View view = moveInfo.a.f14095a;
            ViewCompat.m10949b(view, 0.0f);
            ViewCompat.m10935a(view, 0.0f);
            m17476e(moveInfo.a);
            this.f11909c.remove(size);
        }
        for (size = this.f11907a.size() - 1; size >= 0; size--) {
            m17474d((ViewHolder) this.f11907a.get(size));
            this.f11907a.remove(size);
        }
        for (size = this.f11908b.size() - 1; size >= 0; size--) {
            ViewHolder viewHolder = (ViewHolder) this.f11908b.get(size);
            ViewCompat.m10954c(viewHolder.f14095a, 1.0f);
            m17478f(viewHolder);
            this.f11908b.remove(size);
        }
        for (size = this.f11910d.size() - 1; size >= 0; size--) {
            m17448b((ChangeInfo) this.f11910d.get(size));
        }
        this.f11910d.clear();
        if (mo2239b()) {
            int size2;
            ArrayList arrayList;
            int size3;
            for (size2 = this.f11912f.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.f11912f.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    MoveInfo moveInfo2 = (MoveInfo) arrayList.get(size3);
                    View view2 = moveInfo2.a.f14095a;
                    ViewCompat.m10949b(view2, 0.0f);
                    ViewCompat.m10935a(view2, 0.0f);
                    m17476e(moveInfo2.a);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.f11912f.remove(arrayList);
                    }
                }
            }
            for (size2 = this.f11911e.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.f11911e.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    ViewHolder viewHolder2 = (ViewHolder) arrayList.get(size3);
                    ViewCompat.m10954c(viewHolder2.f14095a, 1.0f);
                    m17478f(viewHolder2);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.f11911e.remove(arrayList);
                    }
                }
            }
            for (size2 = this.f11913g.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.f11913g.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    m17448b((ChangeInfo) arrayList.get(size3));
                    if (arrayList.isEmpty()) {
                        this.f11913g.remove(arrayList);
                    }
                }
            }
            m17445a(this.f11916j);
            m17445a(this.f11915i);
            m17445a(this.f11914h);
            m17445a(this.f11917k);
            m17481i();
        }
    }

    private static void m17445a(List<ViewHolder> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ViewCompat.m10976t(((ViewHolder) list.get(size)).f14095a).a();
        }
    }
}
