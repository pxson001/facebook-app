package com.facebook.commerce.publishing.adapter;

import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: d4ccb2eae9933b0ea9547c624cd75814 */
public class SectionedAdapterHelper {
    private final AdminShopAdapter f15507a;
    @Nullable
    private Map<Integer, int[]> f15508b;

    /* compiled from: d4ccb2eae9933b0ea9547c624cd75814 */
    public class C21401 extends AdapterDataObserver {
        final /* synthetic */ SectionedAdapterHelper f15506a;

        public C21401(SectionedAdapterHelper sectionedAdapterHelper) {
            this.f15506a = sectionedAdapterHelper;
        }

        public final void bb_() {
            this.f15506a.m16026b();
        }

        public final void m16017a(int i, int i2) {
            this.f15506a.m16026b();
        }

        public final void m16019b(int i, int i2) {
            this.f15506a.m16026b();
        }

        public final void m16020c(int i, int i2) {
            this.f15506a.m16026b();
        }

        public final void m16018a(int i, int i2, int i3) {
            this.f15506a.m16026b();
        }
    }

    public SectionedAdapterHelper(AdminShopAdapter adminShopAdapter) {
        this.f15507a = adminShopAdapter;
    }

    public final int m16023a() {
        m16022d();
        return this.f15508b.size();
    }

    public final int m16024a(int i) {
        return m16021c(i)[0];
    }

    public final int m16025b(int i) {
        return m16021c(i)[1];
    }

    public final void m16026b() {
        this.f15508b = null;
    }

    private int[] m16021c(int i) {
        m16022d();
        return (int[]) this.f15508b.get(Integer.valueOf(i));
    }

    private void m16022d() {
        if (this.f15508b == null) {
            this.f15508b = new HashMap();
            AdminShopAdapter adminShopAdapter = this.f15507a;
            int i = 7;
            for (int i2 = 0; i2 < i; i2++) {
                int e = this.f15507a.m15991e(i2);
                for (int i3 = 0; i3 < e; i3++) {
                    this.f15508b.put(Integer.valueOf(this.f15508b.size()), new int[]{i2, i3});
                }
            }
        }
    }
}
