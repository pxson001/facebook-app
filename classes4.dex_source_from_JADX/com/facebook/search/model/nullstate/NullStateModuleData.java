package com.facebook.search.model.nullstate;

import com.facebook.search.model.NullStateModuleCollectionUnit;
import com.facebook.search.model.NullStateModuleSuggestionUnit;
import com.facebook.search.model.TypeaheadUnit;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: fetchGraphQLNotificationsParams */
public class NullStateModuleData {
    private final List<NullStateModuleCollectionUnit> f11780a = new ArrayList();
    public long f11781b;
    private int f11782c = -1;

    public final void m12363a(NullStateModuleCollectionUnit nullStateModuleCollectionUnit, boolean z) {
        if (this.f11780a.add(nullStateModuleCollectionUnit) && z) {
            this.f11782c = this.f11780a.size() - 1;
        }
    }

    public final boolean m12365a() {
        return this.f11780a != null && this.f11780a.isEmpty();
    }

    public final ImmutableList<? extends TypeaheadUnit> m12366b() {
        return ImmutableList.copyOf(this.f11780a);
    }

    @Nullable
    public final String m12367c() {
        return this.f11782c != -1 ? ((NullStateModuleCollectionUnit) this.f11780a.get(this.f11782c)).b : null;
    }

    public final int m12368e() {
        return this.f11780a.size();
    }

    public final long m12369f() {
        return this.f11781b;
    }

    public final int m12362a(NullStateModuleCollectionUnit nullStateModuleCollectionUnit) {
        int i = 0;
        if (this.f11782c != -1) {
            NullStateModuleCollectionUnit nullStateModuleCollectionUnit2 = (NullStateModuleCollectionUnit) this.f11780a.get(this.f11782c);
            ImmutableList f = nullStateModuleCollectionUnit.f();
            int size = f.size();
            int i2 = 0;
            while (i2 < size) {
                int i3;
                if (nullStateModuleCollectionUnit2.f().contains((NullStateModuleSuggestionUnit) f.get(i2))) {
                    i3 = i;
                } else {
                    i3 = i + 1;
                }
                i2++;
                i = i3;
            }
        }
        return i;
    }

    public final void m12364a(NullStateModuleData nullStateModuleData, int i) {
        if (nullStateModuleData.f11782c != -1) {
            NullStateModuleCollectionUnit a = NullStateModuleCollectionUnit.a((NullStateModuleCollectionUnit) nullStateModuleData.f11780a.get(nullStateModuleData.f11782c), i);
            if (this.f11782c == -1) {
                m12363a(a, true);
            } else {
                this.f11780a.set(this.f11782c, a);
            }
        }
    }

    public final void m12370g() {
        if (this.f11782c != -1) {
            this.f11780a.set(this.f11782c, NullStateModuleCollectionUnit.a((NullStateModuleCollectionUnit) this.f11780a.get(this.f11782c), 0));
        }
    }
}
