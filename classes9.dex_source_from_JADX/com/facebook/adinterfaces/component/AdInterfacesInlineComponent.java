package com.facebook.adinterfaces.component;

import android.view.View;
import com.facebook.adinterfaces.external.ComponentType;
import com.facebook.adinterfaces.model.AdInterfacesDataModel;
import com.facebook.adinterfaces.objective.AdInterfacesComponentStatus;
import com.facebook.adinterfaces.ui.AdInterfacesViewController;
import com.facebook.adinterfaces.ui.BaseAdInterfacesViewController;

/* compiled from: _onActivityCreate */
public class AdInterfacesInlineComponent<T extends View, D extends AdInterfacesDataModel> implements AdInterfacesComponent<T, D> {
    private int f21617a;
    private BaseAdInterfacesViewController f21618b;
    private AdInterfacesComponentStatus f21619c;
    private ComponentType f21620d;

    public AdInterfacesInlineComponent(int i, AdInterfacesViewController<T, D> adInterfacesViewController, AdInterfacesComponentStatus adInterfacesComponentStatus, ComponentType componentType) {
        this.f21617a = i;
        this.f21618b = adInterfacesViewController;
        this.f21619c = adInterfacesComponentStatus;
        this.f21620d = componentType;
    }

    public final int mo946a() {
        return this.f21617a;
    }

    public final AdInterfacesViewController<T, D> mo948b() {
        return this.f21618b;
    }

    public final boolean mo947a(D d) {
        return this.f21619c.mo967a(d);
    }

    public final ComponentType mo949c() {
        return this.f21620d;
    }
}
