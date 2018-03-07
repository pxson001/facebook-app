package com.facebook.widget.sectionedadapter;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: trans_suggestion_1 */
public class SectionedAdapterController<SECTION extends Section> {
    private ImmutableList<SECTION> f16148a;
    private SECTION f16149b;
    public Observer f16150c;
    private boolean f16151d;
    private boolean f16152e;
    private int f16153f;
    private List<SectionLookUpResult<SECTION>> f16154g;
    private SparseIntArray f16155h;
    private SparseArray<ViewTypeLookUpResult> f16156i;
    public Map<Section, Integer> f16157j;
    public boolean f16158k;

    /* compiled from: trans_suggestion_1 */
    public interface Section {
        void mo57a(Observer observer);

        int getCount();

        Object getItem(int i);

        int getItemViewType(int i);

        int getViewTypeCount();
    }

    /* compiled from: trans_suggestion_1 */
    public abstract class Observer {
        public void mo1239a() {
        }

        public void mo1240a(int i, int i2) {
        }

        public void mo1242b(int i, int i2) {
        }

        public void mo1243c(int i, int i2) {
        }

        public void mo1241a(int i, int i2, int i3) {
        }
    }

    /* compiled from: trans_suggestion_1 */
    public final class SectionLookUpResult<T extends Section> {
        public int f16139a;
        public T f16140b;
        public int f16141c;
        final /* synthetic */ SectionedAdapterController f16142d;

        public SectionLookUpResult(SectionedAdapterController sectionedAdapterController, int i, T t, int i2) {
            this.f16142d = sectionedAdapterController;
            this.f16139a = i;
            this.f16140b = t;
            this.f16141c = i2;
        }
    }

    /* compiled from: trans_suggestion_1 */
    public class SectionObserver extends Observer {
        final /* synthetic */ SectionedAdapterController f16143a;
        private final Section f16144b;

        public SectionObserver(SectionedAdapterController sectionedAdapterController, Section section) {
            this.f16143a = sectionedAdapterController;
            this.f16144b = section;
        }

        public final void mo1239a() {
            SectionedAdapterController.m20188c(this.f16143a);
            this.f16143a.f16158k = false;
            if (this.f16143a.f16150c != null) {
                this.f16143a.f16150c.mo1239a();
            }
        }

        public final void mo1240a(int i, int i2) {
            this.f16143a.f16158k = true;
            if (this.f16143a.f16150c != null) {
                this.f16143a.f16150c.mo1240a(((Integer) this.f16143a.f16157j.get(this.f16144b)).intValue() + i, i2);
            }
        }

        public final void mo1242b(int i, int i2) {
            SectionedAdapterController.m20188c(this.f16143a);
            this.f16143a.f16158k = false;
            if (this.f16143a.f16150c != null) {
                this.f16143a.f16150c.mo1242b(((Integer) this.f16143a.f16157j.get(this.f16144b)).intValue() + i, i2);
            }
        }

        public final void mo1243c(int i, int i2) {
            SectionedAdapterController.m20188c(this.f16143a);
            this.f16143a.f16158k = false;
            if (this.f16143a.f16150c != null) {
                this.f16143a.f16150c.mo1243c(((Integer) this.f16143a.f16157j.get(this.f16144b)).intValue() + i, i2);
            }
        }

        public final void mo1241a(int i, int i2, int i3) {
            this.f16143a.f16158k = true;
            if (this.f16143a.f16150c != null) {
                int intValue = ((Integer) this.f16143a.f16157j.get(this.f16144b)).intValue();
                this.f16143a.f16150c.mo1241a(intValue + i, intValue + i2, i3);
            }
        }
    }

    /* compiled from: trans_suggestion_1 */
    public final class ViewTypeLookUpResult<T extends Section> {
        public int f16145a;
        public T f16146b;
        final /* synthetic */ SectionedAdapterController f16147c;

        public ViewTypeLookUpResult(SectionedAdapterController sectionedAdapterController, int i, T t) {
            this.f16147c = sectionedAdapterController;
            this.f16145a = i;
            this.f16146b = t;
        }
    }

    public static <T extends Section> SectionedAdapterController<T> m20187a(ImmutableList<T> immutableList, T t) {
        return new SectionedAdapterController(immutableList, t, true);
    }

    public SectionedAdapterController(ImmutableList<SECTION> immutableList, SECTION section) {
        this(immutableList, section, false);
    }

    private SectionedAdapterController(ImmutableList<SECTION> immutableList, SECTION section, boolean z) {
        boolean z2;
        boolean z3 = true;
        int i = 0;
        this.f16158k = false;
        this.f16152e = z;
        this.f16148a = immutableList;
        this.f16149b = section;
        if (this.f16149b != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f16151d = z2;
        if (this.f16151d) {
            if (this.f16149b.getCount() != this.f16148a.size()) {
                z3 = false;
            }
            Preconditions.checkArgument(z3);
        }
        int size = immutableList.size();
        while (i < size) {
            Section section2 = (Section) immutableList.get(i);
            section2.mo57a(new SectionObserver(this, section2));
            i++;
        }
        m20188c(this);
    }

    public static void m20188c(SectionedAdapterController sectionedAdapterController) {
        int i;
        sectionedAdapterController.f16154g = Lists.a();
        sectionedAdapterController.f16156i = new SparseArray();
        sectionedAdapterController.f16155h = new SparseIntArray();
        sectionedAdapterController.f16157j = new HashMap();
        sectionedAdapterController.f16153f = 0;
        int size = sectionedAdapterController.f16148a.size();
        for (i = 0; i < size; i++) {
            Section section = (Section) sectionedAdapterController.f16148a.get(i);
            if (!sectionedAdapterController.f16152e) {
                sectionedAdapterController.f16153f = section.getViewTypeCount() + sectionedAdapterController.f16153f;
            } else if (section.getViewTypeCount() > sectionedAdapterController.f16153f) {
                sectionedAdapterController.f16153f = section.getViewTypeCount();
            }
        }
        sectionedAdapterController.f16156i.put(sectionedAdapterController.f16153f, new ViewTypeLookUpResult(sectionedAdapterController, 0, sectionedAdapterController.f16149b));
        size = 0;
        int i2 = 0;
        while (size < sectionedAdapterController.f16148a.size()) {
            int itemViewType;
            Section section2 = (Section) sectionedAdapterController.f16148a.get(size);
            if (sectionedAdapterController.f16151d && section2.getCount() > 0 && !"".equals(sectionedAdapterController.f16149b.getItem(size))) {
                sectionedAdapterController.f16154g.add(new SectionLookUpResult(sectionedAdapterController, size, sectionedAdapterController.f16149b, size));
                sectionedAdapterController.f16155h.put(sectionedAdapterController.f16154g.size() - 1, sectionedAdapterController.f16153f);
            }
            sectionedAdapterController.f16157j.put(section2, Integer.valueOf(sectionedAdapterController.f16154g.size()));
            for (int i3 = 0; i3 < section2.getCount(); i3++) {
                itemViewType = section2.getItemViewType(i3);
                i = i2 + itemViewType;
                int i4 = 0;
                sectionedAdapterController.f16154g.add(new SectionLookUpResult(sectionedAdapterController, i3, section2, size));
                sectionedAdapterController.f16155h.put(sectionedAdapterController.f16154g.size() - 1, i);
                if (sectionedAdapterController.f16156i.indexOfKey(i) < 0) {
                    sectionedAdapterController.f16156i.put(i, new ViewTypeLookUpResult(sectionedAdapterController, itemViewType, section2));
                }
            }
            if (sectionedAdapterController.f16152e) {
                itemViewType = 0;
            } else {
                itemViewType = section2.getViewTypeCount();
            }
            size++;
            i2 = itemViewType + i2;
        }
    }

    private void m20189d() {
        if (this.f16158k) {
            m20188c(this);
            this.f16158k = false;
        }
    }

    public final ViewTypeLookUpResult<SECTION> m20191a(int i) {
        m20189d();
        return (ViewTypeLookUpResult) this.f16156i.get(i);
    }

    public final SectionLookUpResult<SECTION> m20193b(int i) {
        m20189d();
        return (SectionLookUpResult) this.f16154g.get(i);
    }

    public final int m20190a() {
        m20189d();
        return this.f16155h.size();
    }

    public final int m20194c(int i) {
        m20189d();
        return this.f16155h.get(i);
    }

    public final int m20192b() {
        m20189d();
        return this.f16153f + 1;
    }

    public final Object m20195d(int i) {
        m20189d();
        SectionLookUpResult b = m20193b(i);
        return b.f16140b.getItem(b.f16139a);
    }
}
