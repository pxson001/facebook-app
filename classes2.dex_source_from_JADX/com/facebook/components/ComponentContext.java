package com.facebook.components;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.annotation.StyleRes;
import com.facebook.R;

/* compiled from: getLine1Number */
public class ComponentContext extends ContextWrapper {
    public Component<?> f22549a;
    public ResourceCache f22550b;
    @StyleRes
    public int f22551c = 0;

    public ComponentContext(Context context) {
        super(context);
        this.f22550b = ResourceCache.m30449a(context.getResources().getConfiguration());
    }

    public final TypedArray m30446a(int[] iArr, int i) {
        return obtainStyledAttributes(null, iArr, i, this.f22551c);
    }

    final ComponentLayout$ContainerBuilder m30448b(@StyleRes int i) {
        Resources resources = getResources();
        InternalNode internalNode = (InternalNode) ComponentsPools.f22593c.mo740a();
        if (internalNode == null) {
            internalNode = new InternalNode();
        }
        internalNode.f22768o = this;
        internalNode.f22769p = resources;
        internalNode.f22767n.m30669a(internalNode.f22768o, this.f22550b);
        InternalNode internalNode2 = internalNode;
        m30445a(internalNode2, i);
        return internalNode2;
    }

    private void m30445a(InternalNode internalNode, @StyleRes int i) {
        if (i != 0) {
            this.f22551c = i;
            TypedArray a = m30446a(R.styleable.ComponentLayout, 0);
            internalNode.m30782a(a);
            a.recycle();
            this.f22551c = 0;
        }
    }

    public final ComponentLayout$Builder m30447a(Component<?> component, @StyleRes int i) {
        ComponentLifecycle componentLifecycle = component.f22589c;
        Component component2 = this.f22549a;
        this.f22549a = component;
        ComponentsSystrace.m30654a("onCreateLayout");
        InternalNode b = componentLifecycle.mo3135b(this, (Component) component);
        ComponentsSystrace.m30653a();
        this.f22549a = component2;
        if (b.f22770q == null) {
            b.f22770q = component;
            if (componentLifecycle.mo3144c()) {
                b.m30849a(ComponentLifecycle.f20395c);
            }
        }
        componentLifecycle.mo3149c(this, component);
        InternalNode internalNode = b;
        m30445a(internalNode, i);
        return internalNode;
    }
}
