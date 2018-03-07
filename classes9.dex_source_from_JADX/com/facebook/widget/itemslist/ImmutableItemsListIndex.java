package com.facebook.widget.itemslist;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;

/* compiled from: shared_device */
public class ImmutableItemsListIndex implements ItemsList, StickyHeaderSectionIndexer {
    public static final ImmutableItemsListIndex f3562a = new ImmutableItemsListIndex(RegularImmutableList.a);
    final ImmutableList<ImmutableItemsList> f3563b;
    final ImmutableList<Integer> f3564c;
    public final int f3565d;

    /* compiled from: shared_device */
    public interface NeverPushesStickyHeader {
    }

    /* compiled from: shared_device */
    public interface SectionHeader {
        String m3352a();
    }

    public ImmutableItemsListIndex(ImmutableList<ImmutableItemsList> immutableList) {
        this.f3563b = immutableList;
        Builder builder = new Builder();
        int size = this.f3563b.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            ImmutableItemsList immutableItemsList = (ImmutableItemsList) this.f3563b.get(i2);
            builder.c(Integer.valueOf(i));
            i += immutableItemsList.m3350a();
        }
        this.f3564c = builder.b();
        this.f3565d = i;
    }

    public final Object m3353a(int i) {
        int sectionForPosition = getSectionForPosition(i);
        return ((ImmutableItemsList) this.f3563b.get(sectionForPosition)).m3351a(i - ((Integer) this.f3564c.get(sectionForPosition)).intValue());
    }

    public Object[] getSections() {
        Object[] objArr = new Object[this.f3563b.size()];
        for (int i = 0; i < this.f3563b.size(); i++) {
            String obj;
            ImmutableItemsList immutableItemsList = (ImmutableItemsList) this.f3563b.get(i);
            Object obj2;
            if (immutableItemsList.f3561d) {
                Object obj3;
                if (!immutableItemsList.f3561d || immutableItemsList.f3560c.isEmpty()) {
                    obj3 = null;
                } else {
                    obj3 = immutableItemsList.f3560c.get(0);
                }
                obj2 = obj3;
                if (obj2 instanceof Character) {
                    obj = obj2.toString();
                } else if (obj2 instanceof CharSequence) {
                    CharSequence charSequence = (CharSequence) obj2;
                } else {
                    obj = obj2 instanceof SectionHeader ? ((SectionHeader) obj2).m3352a() : null;
                }
            } else {
                if (!immutableItemsList.f3560c.isEmpty()) {
                    obj2 = immutableItemsList.m3351a(0);
                    if (obj2 instanceof SectionHeader) {
                        obj = ((SectionHeader) obj2).m3352a();
                    }
                }
                obj = null;
            }
            if (obj == null) {
                obj = "";
            }
            objArr[i] = obj;
        }
        return objArr;
    }

    public int getPositionForSection(int i) {
        if (i >= this.f3563b.size()) {
            return 0;
        }
        return ((Integer) this.f3564c.get(i)).intValue();
    }

    public int getSectionForPosition(int i) {
        for (int size = this.f3564c.size() - 1; size >= 0; size--) {
            if (((Integer) this.f3564c.get(size)).intValue() <= i) {
                return size;
            }
        }
        throw new IndexOutOfBoundsException("Position is not contained within any section");
    }

    public final boolean z_(int i) {
        if (i < 0 || i >= this.f3565d) {
            return false;
        }
        return ((ImmutableItemsList) this.f3563b.get(getSectionForPosition(i))).f3561d;
    }

    public final boolean m3354c(int i) {
        if (i < 0 || i >= this.f3565d || getSectionForPosition(i) >= this.f3563b.size() || (m3353a(i) instanceof NeverPushesStickyHeader) || i != getPositionForSection(getSectionForPosition(i))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("sections", this.f3563b).add("sectionPositions", this.f3564c).toString();
    }
}
