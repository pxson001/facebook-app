package com.facebook.crudolib.params;

import android.text.TextUtils;
import com.facebook.infer.annotation.Assertions;
import java.util.ArrayList;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: tap_360_photo_heading_indicator */
public final class ParamsCollectionMap extends ParamsCollection {
    public final ArrayList<Object> f3272b;
    public int f3273c;

    ParamsCollectionMap(int i) {
        this.f3272b = new ArrayList(i * 2);
    }

    public final int m5430j() {
        return this.f3273c;
    }

    public final String m5423b(int i) {
        m5415d(i);
        return (String) this.f3272b.get(i * 2);
    }

    @Nullable
    public final Object m5426c(int i) {
        m5415d(i);
        return this.f3272b.get((i * 2) + 1);
    }

    private void m5415d(int i) {
        if (i < 0 || i >= this.f3273c) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
    }

    public final void m5421a(String str, @Nullable String str2) {
        m5413a(str, (Object) str2);
    }

    public final void m5420a(String str, @Nullable Number number) {
        m5413a(str, (Object) number);
    }

    public final void m5419a(String str, @Nullable Boolean bool) {
        m5413a(str, (Object) bool);
    }

    public final void m5418a(String str, ParamsCollection paramsCollection) {
        m5414c(str, paramsCollection);
        paramsCollection.m5436a((ParamsCollection) this);
    }

    public final void m5424b(String str, ParamsCollection paramsCollection) {
        m5414c(str, paramsCollection);
        paramsCollection.m5444c();
        paramsCollection.f3281h = this;
        paramsCollection.f3277d.incrementAndGet();
    }

    private void m5414c(String str, ParamsCollection paramsCollection) {
        Assertions.m5468a((Object) paramsCollection, "subParams cannot be null!");
        m5416d(str);
        paramsCollection.m5444c();
        m5413a(str, (Object) paramsCollection);
    }

    public final ParamsCollectionMap m5422b(String str) {
        ParamsCollection b = m5450i().m5398b();
        m5418a(str, b);
        return b;
    }

    public final ParamsCollectionArray m5425c(String str) {
        ParamsCollection c = m5450i().m5399c();
        m5418a(str, c);
        return c;
    }

    private void m5416d(String str) {
        m5448g();
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("key=" + str);
        }
    }

    private void m5413a(String str, @Nullable Object obj) {
        m5416d(str);
        this.f3272b.add(str);
        this.f3272b.add(obj);
        this.f3273c++;
    }

    protected final void mo743d() {
        for (int i = 0; i < this.f3273c; i++) {
            Object c = m5426c(i);
            if (c instanceof ParamsCollection) {
                ((ParamsCollection) c).m5443b();
            }
        }
    }

    protected final void mo744e() {
        m5450i().f3235a.mo741a(this);
    }

    protected final void mo745h() {
        this.f3272b.clear();
        this.f3273c = 0;
    }

    protected final void mo742a(int i) {
        int i2 = this.f3273c - i;
        while (true) {
            int i3 = i2 - 1;
            if (i2 > 0) {
                this.f3272b.remove(this.f3272b.size() - 1);
                this.f3272b.remove(this.f3272b.size() - 1);
                i2 = i3;
            } else {
                this.f3272b.trimToSize();
                return;
            }
        }
    }
}
