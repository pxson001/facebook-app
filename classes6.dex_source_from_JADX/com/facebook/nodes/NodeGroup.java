package com.facebook.nodes;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.facebook.nodes.canvas.DeferredModeCanvasProxy;
import java.util.ArrayList;

/* compiled from: ticket_provider_page */
public class NodeGroup extends Node implements NodeParent {
    protected final ArrayList<Node> f3093e = new ArrayList();

    public NodeGroup(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void mo191a(Node node, LayoutParams layoutParams) {
        node.mo205a(layoutParams);
        this.f3093e.add(node);
        node.f3071b = this;
        node.f3073d.f3117b = m4095e();
    }

    public void m4120b(Node node) {
        node.f3071b = null;
        this.f3093e.remove(node);
        m4107s();
    }

    public LayoutParams mo183a(Context context, AttributeSet attributeSet) {
        return mo182a();
    }

    protected LayoutParams mo182a() {
        return new LayoutParams(-2, -2);
    }

    protected boolean m4122b(LayoutParams layoutParams) {
        return layoutParams != null;
    }

    public final void mo181f(int i) {
        int size = this.f3093e.size();
        for (int i2 = 0; i2 != size; i2++) {
            ((Node) this.f3093e.get(i2)).mo181f(i);
        }
        super.mo181f(i);
    }

    public final void mo176a(BaseThreadingModel baseThreadingModel) {
        int size = this.f3093e.size();
        for (int i = 0; i != size; i++) {
            ((Node) this.f3093e.get(i)).mo176a(baseThreadingModel);
        }
        super.mo176a(baseThreadingModel);
    }

    public final Node mo179b(int i) {
        int size = this.f3093e.size();
        for (int i2 = 0; i2 != size; i2++) {
            Node b = ((Node) this.f3093e.get(i2)).mo179b(i);
            if (b != null) {
                return b;
            }
        }
        return super.mo179b(i);
    }

    final Node mo180c(int i) {
        int size = this.f3093e.size();
        for (int i2 = 0; i2 != size; i2++) {
            Node c = ((Node) this.f3093e.get(i2)).mo180c(i);
            if (c != null) {
                return c;
            }
        }
        return super.mo180c(i);
    }

    public final int m4126y() {
        return this.f3093e.size();
    }

    public final Node m4125g(int i) {
        return (Node) this.f3093e.get(i);
    }

    protected final void mo177a(DeferredModeCanvasProxy deferredModeCanvasProxy) {
        int size = this.f3093e.size();
        for (int i = 0; i != size; i++) {
            Node node = (Node) this.f3093e.get(i);
            if (node.m4108t() == 0) {
                node.m4088b(deferredModeCanvasProxy);
            }
        }
    }

    protected final void mo178a(int[] iArr) {
        super.mo178a(iArr);
        int size = this.f3093e.size();
        for (int i = 0; i != size; i++) {
            ((Node) this.f3093e.get(i)).mo178a(iArr);
        }
    }

    protected final void m4121b(Node node, int i, int i2, int i3, int i4) {
        int i5 = this.f3077h + i;
        int i6 = this.f3078i + i2;
        node.m4086b(i5, i6, i5 + i3, i6 + i4);
    }

    public void mo190a(Node node) {
        LayoutParams layoutParams = node.f3075f;
        if (layoutParams == null) {
            layoutParams = mo182a();
        }
        mo191a(node, layoutParams);
    }

    protected final void m4115a(Node node, int i, int i2, int i3, int i4) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) node.f3075f;
        node.m4089b(ViewGroup.getChildMeasureSpec(i, (((this.f3081l + this.f3082m) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i3, (((this.f3083n + this.f3084o) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height));
    }
}
