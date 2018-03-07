package com.facebook.react.uimanager;

import android.util.SparseArray;
import android.util.SparseBooleanArray;

/* compiled from: free_facebook_message_quota */
class ShadowNodeRegistry {
    private final SparseArray<ReactShadowNode> f11767a = new SparseArray();
    private final SparseBooleanArray f11768b = new SparseBooleanArray();

    public final void m13966a(int i) {
        if (this.f11768b.get(i)) {
            this.f11767a.remove(i);
            this.f11768b.delete(i);
            return;
        }
        throw new IllegalViewOperationException("View with tag " + i + " is not registered as a root view");
    }

    public final void m13969b(ReactShadowNode reactShadowNode) {
        this.f11767a.put(reactShadowNode.f11717g, reactShadowNode);
    }

    public final void m13968b(int i) {
        if (this.f11768b.get(i)) {
            throw new IllegalViewOperationException("Trying to remove root node " + i + " without using removeRootNode!");
        }
        this.f11767a.remove(i);
    }

    public final ReactShadowNode m13970c(int i) {
        return (ReactShadowNode) this.f11767a.get(i);
    }

    public final boolean m13971d(int i) {
        return this.f11768b.get(i);
    }

    public final int m13965a() {
        return this.f11768b.size();
    }

    public final int m13972e(int i) {
        return this.f11768b.keyAt(i);
    }

    public final void m13967a(ReactShadowNode reactShadowNode) {
        int i = reactShadowNode.f11717g;
        this.f11767a.put(i, reactShadowNode);
        this.f11768b.put(i, true);
    }
}
