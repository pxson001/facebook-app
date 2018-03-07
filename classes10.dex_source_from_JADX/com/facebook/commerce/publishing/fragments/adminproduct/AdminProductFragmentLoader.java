package com.facebook.commerce.publishing.fragments.adminproduct;

import java.util.Queue;

/* compiled from: customization */
public class AdminProductFragmentLoader {
    public Queue<ProductInitializationLoadable> f15619a;
    public boolean f15620b = false;

    public final boolean m16098a() {
        if (this.f15619a.isEmpty()) {
            this.f15620b = false;
            return false;
        }
        ((ProductInitializationLoadable) this.f15619a.remove()).mo762a();
        return true;
    }
}
