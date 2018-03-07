package com.facebook.crudolib.params;

import com.facebook.infer.annotation.Assertions;
import java.util.ArrayList;
import javax.annotation.Nullable;

/* compiled from: restricted_profile */
public final class ParamsCollectionArray extends ParamsCollection {
    private final ArrayList<Object> f6854b;

    ParamsCollectionArray(int i) {
        this.f6854b = new ArrayList(i);
    }

    public final int m11506j() {
        return this.f6854b.size();
    }

    @Nullable
    public final Object m11501b(int i) {
        return this.f6854b.get(i);
    }

    public final void m11500a(@Nullable String str) {
        m11495a((Object) str);
    }

    public final void m11499a(@Nullable Number number) {
        m11495a((Object) number);
    }

    public final void m11498a(@Nullable Boolean bool) {
        m11495a((Object) bool);
    }

    public final void m11502c(ParamsCollection paramsCollection) {
        m11496d(paramsCollection);
        paramsCollection.m5436a((ParamsCollection) this);
    }

    private void m11496d(ParamsCollection paramsCollection) {
        Assertions.m5468a((Object) paramsCollection, "subParams cannot be null!");
        m5448g();
        paramsCollection.m5444c();
        m11495a((Object) paramsCollection);
    }

    public final ParamsCollectionMap mo1634k() {
        ParamsCollection b = m5450i().m5398b();
        m11502c(b);
        return b;
    }

    public final ParamsCollectionArray mo1635l() {
        ParamsCollection c = m5450i().m5399c();
        m11502c(c);
        return c;
    }

    private void m11495a(@Nullable Object obj) {
        m5448g();
        this.f6854b.add(obj);
    }

    protected final void mo743d() {
        int j = m11506j();
        for (int i = 0; i < j; i++) {
            Object b = m11501b(i);
            if (b instanceof ParamsCollection) {
                ((ParamsCollection) b).m5443b();
            }
        }
    }

    protected final void mo744e() {
        m5450i().f3236b.mo741a(this);
    }

    protected final void mo745h() {
        this.f6854b.clear();
    }

    protected final void mo742a(int i) {
        int size = this.f6854b.size() - i;
        while (true) {
            int i2 = size - 1;
            if (size > 0) {
                this.f6854b.remove(this.f6854b.size() - 1);
                size = i2;
            } else {
                this.f6854b.trimToSize();
                return;
            }
        }
    }
}
