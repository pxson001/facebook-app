package com.facebook.nearby.v2.resultlist.views.itemview.actionbar.buttons;

import android.content.Context;
import android.location.Location;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.inject.FbInjector;
import com.facebook.maps.MapsLocationUtils;
import javax.inject.Inject;

/* compiled from: d969bfe6f6b3c1cbeea9e045d598d249 */
public class NearbyPlacesActionBarDistanceButtonView extends NearbyPlacesActionBarButtonView {
    private static final Class<?> f16011g = NearbyPlacesActionBarDistanceButtonView.class;
    @Inject
    public MapsLocationUtils f16012f;

    private static <T extends View> void m18806a(Class<T> cls, T t) {
        m18807a((Object) t, t.getContext());
    }

    private static void m18807a(Object obj, Context context) {
        ((NearbyPlacesActionBarDistanceButtonView) obj).f16012f = MapsLocationUtils.b(FbInjector.get(context));
    }

    public NearbyPlacesActionBarDistanceButtonView(Context context) {
        this(context, null);
    }

    public NearbyPlacesActionBarDistanceButtonView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NearbyPlacesActionBarDistanceButtonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18806a(NearbyPlacesActionBarDistanceButtonView.class, (View) this);
        this.e = CallerContext.a(f16011g);
        this.f16007b.setVisibility(8);
    }

    public final void m18808a(Location location, Location location2) {
        if (location == null || location2 == null) {
            this.f16008c.setText("");
        } else {
            this.f16008c.setText(this.f16012f.a(location, location2));
        }
    }

    private void m18805a(MapsLocationUtils mapsLocationUtils) {
        this.f16012f = mapsLocationUtils;
    }
}
