package com.facebook.debug.components;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.base.fragment.FbFragment;
import com.facebook.components.feed.ComponentPartDefinition;
import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.controllercallbacks.api.Holder;
import com.facebook.controllercallbacks.fragment.ResumePauseCallbacks;
import com.facebook.debug.pref.DebugLoggingPrefKeys;
import com.facebook.feed.rows.core.BoundedAdapter;
import com.facebook.feed.rows.core.binding.Binder;
import com.facebook.feed.rows.core.traversal.SinglePartHolder;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.widget.listview.BasicAdapter;
import com.facebook.widget.listview.controllercallbacks.AdapterDataChangedCallback;
import javax.inject.Inject;

/* compiled from: pid */
public class ComponentsConversionController extends BaseController implements ResumePauseCallbacks, AdapterDataChangedCallback {
    public TextView f9843a;
    private final FbSharedPreferences f9844b;
    public Holder<FbFragment> f9845c;

    public static ComponentsConversionController m14871a(InjectorLike injectorLike) {
        return new ComponentsConversionController(FbSharedPreferencesImpl.m1826a(injectorLike));
    }

    @Inject
    public ComponentsConversionController(FbSharedPreferences fbSharedPreferences) {
        this.f9844b = fbSharedPreferences;
    }

    public final boolean kJ_() {
        return this.f9844b.mo286a(DebugLoggingPrefKeys.f2812j, false);
    }

    public final void mo1264c() {
        Context ao = ((FbFragment) this.f9845c.f10429a).ao();
        if (this.f9843a == null) {
            this.f9843a = new TextView(ao);
            LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 3);
            this.f9843a.setBackground(new ColorDrawable(((FbFragment) this.f9845c.f10429a).jW_().getColor(17170443)));
            ao.getWindow().addContentView(this.f9843a, layoutParams);
        }
    }

    public final void mo1265d() {
    }

    public final void mo1951a(BasicAdapter basicAdapter) {
        int aZ_ = basicAdapter.aZ_();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < aZ_) {
            int i4;
            Object item = basicAdapter.getItem(i);
            if (item instanceof BoundedAdapter) {
                BoundedAdapter boundedAdapter = (BoundedAdapter) item;
                i2++;
                Binder c = boundedAdapter.f13446a.m19049c(boundedAdapter.f13447b);
                if ((c instanceof SinglePartHolder) && (((SinglePartHolder) c).f13428a instanceof ComponentPartDefinition)) {
                    int i5 = i2;
                    i2 = i3 + 1;
                    i4 = i5;
                    i++;
                    i3 = i2;
                    i2 = i4;
                }
            }
            i4 = i2;
            i2 = i3;
            i++;
            i3 = i2;
            i2 = i4;
        }
        if (this.f9843a != null) {
            this.f9843a.setText(String.format("%d / %d = %s", new Object[]{Integer.valueOf(i3), Integer.valueOf(i2), ((((float) i3) / ((float) i2)) * 100.0f) + "%"}));
        }
    }
}
