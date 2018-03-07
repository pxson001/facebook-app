package com.facebook.adinterfaces.component;

import android.view.View;
import com.facebook.adinterfaces.external.ComponentType;
import com.facebook.adinterfaces.model.AdInterfacesDataModel;
import com.facebook.adinterfaces.ui.AdInterfacesViewController;

/* compiled from: _typeId_ */
public interface AdInterfacesComponent<T extends View, D extends AdInterfacesDataModel> {
    int mo946a();

    boolean mo947a(D d);

    AdInterfacesViewController<T, D> mo948b();

    ComponentType mo949c();
}
