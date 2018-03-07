package com.facebook.nodes;

import java.util.ArrayList;

/* compiled from: ticket_sale_time */
public abstract class BaseThreadingModel implements NodeParent {
    public final NodeView f3065a;
    public boolean f3066b;
    public final ArrayList<AttachDetachListener> f3067c = new ArrayList();
    public final ArrayList<TouchHandler> f3068d = new ArrayList();
    public TouchHandler f3069e;

    public abstract void mo192a(int i);

    public abstract void mo193a(int i, int i2);

    public abstract void mo194a(Node node);

    public abstract void mo195a(int[] iArr);

    public abstract Node mo196e();

    public abstract int mo197f();

    public abstract int mo198g();

    public abstract void mo199h();

    protected BaseThreadingModel(NodeView nodeView) {
        this.f3065a = nodeView;
    }

    public final void m4064b() {
        this.f3066b = true;
        int size = this.f3067c.size();
        for (int i = 0; i < size; i++) {
            ((AttachDetachListener) this.f3067c.get(i)).mo189a(this.f3065a);
        }
    }

    public final void m4067c() {
        this.f3066b = false;
        int size = this.f3067c.size();
        for (int i = 0; i < size; i++) {
            ((AttachDetachListener) this.f3067c.get(i)).mo187a();
        }
    }

    public final void m4060a(AttachDetachListener attachDetachListener) {
        if (this.f3066b) {
            attachDetachListener.mo189a(this.f3065a);
        }
        this.f3067c.add(attachDetachListener);
    }

    public final void m4065b(AttachDetachListener attachDetachListener) {
        this.f3067c.remove(attachDetachListener);
    }

    public final void m4062a(TouchHandler touchHandler) {
        this.f3068d.add(touchHandler);
    }

    public final void m4066b(TouchHandler touchHandler) {
        this.f3068d.remove(touchHandler);
    }

    public final int[] m4068d() {
        return this.f3065a.getDrawableState();
    }
}
