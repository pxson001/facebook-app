package com.facebook.richdocument.view.transition;

import android.view.View;
import com.facebook.richdocument.view.transition.ViewAttribute.ViewAttributeType;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: originalCoordinates */
public class ViewLayoutImpl implements ViewLayout {
    private final TransitionState f7000a;
    private final Map<View, ViewAttributes> f7001b;

    public ViewLayoutImpl(TransitionState transitionState) {
        this(transitionState, null);
    }

    private ViewLayoutImpl(ViewLayout viewLayout) {
        this(viewLayout.mo427a(), viewLayout);
    }

    private ViewLayoutImpl(TransitionState transitionState, ViewLayout viewLayout) {
        this.f7000a = transitionState;
        this.f7001b = new LinkedHashMap();
        if (viewLayout != null) {
            for (Entry entry : viewLayout.mo432b().entrySet()) {
                this.f7001b.put(entry.getKey(), new ViewAttributes((ViewAttributes) entry.getValue()));
            }
        }
    }

    public final TransitionState mo427a() {
        return this.f7000a;
    }

    public final ViewAttributes mo429a(View view) {
        return (ViewAttributes) this.f7001b.get(view);
    }

    public final <V extends ViewAttribute> V mo428a(View view, ViewAttributeType viewAttributeType, Class<V> cls) {
        ViewAttributes a = mo429a(view);
        if (a != null) {
            return (ViewAttribute) a.f6999a.get(viewAttributeType);
        }
        return null;
    }

    public final Map<View, ViewAttributes> mo432b() {
        return this.f7001b;
    }

    public final void mo431a(View view, ViewAttributes viewAttributes) {
        this.f7001b.put(view, viewAttributes);
    }

    public final boolean mo433b(View view) {
        return this.f7001b.containsKey(view);
    }

    public final ViewLayout mo430a(ViewLayout viewLayout, float f) {
        ViewLayout viewLayoutImpl = new ViewLayoutImpl(this.f7000a.mo422a(viewLayout.mo427a(), f));
        for (Entry entry : this.f7001b.entrySet()) {
            View view = (View) entry.getKey();
            ViewAttributes viewAttributes = (ViewAttributes) entry.getValue();
            if (viewLayout.mo433b(view)) {
                ViewAttributes a = viewLayout.mo429a(view);
                ViewAttributes viewAttributes2 = new ViewAttributes();
                for (ViewAttribute viewAttribute : viewAttributes.f6999a.values()) {
                    if (a.f6999a.containsKey(viewAttribute.mo412a())) {
                        viewAttributes2.m7297a(viewAttribute.mo413a((ViewAttribute) a.f6999a.get(viewAttribute.mo412a()), f));
                    } else {
                        viewAttributes2.m7297a(viewAttribute.mo414c());
                    }
                }
                viewLayoutImpl.mo431a(view, viewAttributes2);
            }
        }
        return viewLayoutImpl;
    }

    public final ViewLayout mo434c() {
        return new ViewLayoutImpl((ViewLayout) this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ViewLayoutImpl viewLayoutImpl = (ViewLayoutImpl) obj;
        if (this.f7000a.equals(viewLayoutImpl.f7000a) && this.f7001b.equals(viewLayoutImpl.f7001b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f7001b.hashCode() * 31) + this.f7000a.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append("{\n  ").append("state: ").append(this.f7000a).append(",\n");
        for (Entry entry : this.f7001b.entrySet()) {
            stringBuilder.append("  ");
            stringBuilder.append(((View) entry.getKey()).toString());
            stringBuilder.append(": ");
            stringBuilder.append(((ViewAttributes) entry.getValue()).toString());
            stringBuilder.append(",\n");
        }
        int lastIndexOf = stringBuilder.lastIndexOf(",\n");
        if (lastIndexOf != -1) {
            stringBuilder.delete(lastIndexOf, lastIndexOf + 1);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
