package com.facebook.components;

import com.facebook.components.ComponentLifecycle.MountType;

/* compiled from: getGoogleAppId failed with status */
class HostComponent extends ComponentLifecycle {
    public static final HostComponent f22586b = new HostComponent();

    /* compiled from: getGoogleAppId failed with status */
    class State extends Component<HostComponent> implements Cloneable {
        State() {
            super(HostComponent.f22586b);
        }
    }

    HostComponent() {
    }

    protected final Object mo3145e(ComponentContext componentContext, Object obj, Component component) {
        if (obj == null) {
            return new ComponentHost(componentContext);
        }
        return obj;
    }

    public final MountType mo3146f() {
        return MountType.VIEW;
    }

    static Component m30500j() {
        return new State();
    }
}
