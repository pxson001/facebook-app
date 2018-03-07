package com.facebook.richdocument.view.transition;

import android.view.View;
import com.facebook.richdocument.view.transition.ViewAttribute.ViewAttributeType;
import java.util.Map;

/* compiled from: originalEmail */
public interface ViewLayout {
    TransitionState mo427a();

    <V extends ViewAttribute> V mo428a(View view, ViewAttributeType viewAttributeType, Class<V> cls);

    ViewAttributes mo429a(View view);

    ViewLayout mo430a(ViewLayout viewLayout, float f);

    void mo431a(View view, ViewAttributes viewAttributes);

    Map<View, ViewAttributes> mo432b();

    boolean mo433b(View view);

    ViewLayout mo434c();
}
