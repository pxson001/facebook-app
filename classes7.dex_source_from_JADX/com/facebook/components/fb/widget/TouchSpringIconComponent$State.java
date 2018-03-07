package com.facebook.components.fb.widget;

import android.graphics.drawable.Drawable;
import com.facebook.components.Component;
import com.facebook.components.reference.Reference;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.springs.Spring;

/* compiled from: creative_cam_front */
public class TouchSpringIconComponent$State extends Component<TouchSpringIconComponent> implements Cloneable {
    E f16656a;
    String f16657b;
    CacheableEntity f16658c;
    Spring f16659d;
    Reference<Drawable> f16660e;
    final /* synthetic */ TouchSpringIconComponent f16661f;

    public TouchSpringIconComponent$State(TouchSpringIconComponent touchSpringIconComponent) {
        this.f16661f = touchSpringIconComponent;
        super(touchSpringIconComponent);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TouchSpringIconComponent$State touchSpringIconComponent$State = (TouchSpringIconComponent$State) obj;
        if (this.b == touchSpringIconComponent$State.b) {
            return true;
        }
        if (this.f16656a == null ? touchSpringIconComponent$State.f16656a != null : !this.f16656a.equals(touchSpringIconComponent$State.f16656a)) {
            return false;
        }
        if (this.f16657b == null ? touchSpringIconComponent$State.f16657b != null : !this.f16657b.equals(touchSpringIconComponent$State.f16657b)) {
            return false;
        }
        if (this.f16658c == null ? touchSpringIconComponent$State.f16658c != null : !this.f16658c.equals(touchSpringIconComponent$State.f16658c)) {
            return false;
        }
        if (this.f16660e != null) {
            if (this.f16660e.equals(touchSpringIconComponent$State.f16660e)) {
                return true;
            }
        } else if (touchSpringIconComponent$State.f16660e == null) {
            return true;
        }
        return false;
    }

    protected final void m20699a(Component<TouchSpringIconComponent> component) {
        this.f16659d = ((TouchSpringIconComponent$State) component).f16659d;
    }
}
