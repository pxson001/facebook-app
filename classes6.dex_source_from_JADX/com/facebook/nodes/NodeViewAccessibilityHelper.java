package com.facebook.nodes;

import android.graphics.Rect;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.facebook.accessibility.AccessibilityHelper;

/* compiled from: thread_queue_metadata */
public class NodeViewAccessibilityHelper extends AccessibilityHelper<NodeView> {
    public static final int[] f3136b = new int[2];
    public static final Rect f3137c = new Rect();

    public NodeViewAccessibilityHelper(NodeView nodeView) {
        super(nodeView);
    }

    protected final void m4177a(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        Node c = ((NodeView) this.a).getNode().mo180c(i);
        if (c != null) {
            m4175a(c, accessibilityNodeInfoCompat);
            NodeParent nodeParent = c.f3071b;
            if (nodeParent instanceof Node) {
                accessibilityNodeInfoCompat.d(this.a, ((Node) nodeParent).m4095e());
            } else {
                accessibilityNodeInfoCompat.d(this.a);
            }
            ((NodeView) this.a).getLocationOnScreen(f3136b);
            int i2 = f3136b[0];
            int i3 = f3136b[1];
            f3137c.set(c.f3077h + i2, c.f3078i + i3, i2 + c.f3079j, i3 + c.f3080k);
            accessibilityNodeInfoCompat.d(f3137c);
            c.f3073d.mo201a(accessibilityNodeInfoCompat);
        }
    }

    protected final void m4178a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        accessibilityNodeInfoCompat.c(this.a, ((NodeView) this.a).getNode().m4095e());
    }

    protected final int m4176a(float f, float f2) {
        return m4174a(((NodeView) this.a).getNode(), f, f2);
    }

    private void m4175a(Node node, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (node instanceof NodeGroup) {
            NodeGroup nodeGroup = (NodeGroup) node;
            for (int i = 0; i < nodeGroup.m4126y(); i++) {
                accessibilityNodeInfoCompat.c(this.a, nodeGroup.m4125g(i).m4095e());
            }
        }
    }

    private int m4174a(Node node, float f, float f2) {
        if (node instanceof NodeGroup) {
            NodeGroup nodeGroup = (NodeGroup) node;
            for (int i = 0; i < nodeGroup.m4126y(); i++) {
                int a = m4174a(nodeGroup.m4125g(i), f, f2);
                if (a != Integer.MIN_VALUE) {
                    return a;
                }
            }
        }
        return (((float) node.f3077h) > f || f >= ((float) node.f3079j) || ((float) node.f3078i) > f2 || f2 >= ((float) node.f3080k)) ? Integer.MIN_VALUE : node.m4095e();
    }
}
