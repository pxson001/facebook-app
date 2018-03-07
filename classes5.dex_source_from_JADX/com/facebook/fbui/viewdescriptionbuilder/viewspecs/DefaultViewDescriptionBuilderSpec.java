package com.facebook.fbui.viewdescriptionbuilder.viewspecs;

import android.annotation.TargetApi;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.fbui.viewdescriptionbuilder.LayoutParamsFormatter;
import com.facebook.fbui.viewdescriptionbuilder.ViewDescriptionBuilderSpec;
import com.facebook.fbui.viewdescriptionbuilder.ViewIdExtractor;
import javax.inject.Inject;

/* compiled from: XSMALL */
public class DefaultViewDescriptionBuilderSpec implements ViewDescriptionBuilderSpec<View> {
    private final LayoutParamsFormatter f12221a;
    private final ViewIdExtractor f12222b;

    public final void mo1226a(Object obj, Bundle bundle) {
        String str;
        View view = (View) obj;
        bundle.putString("class_name", view.getClass().getName());
        bundle.putString("id", ViewIdExtractor.m20239a(view.getContext(), view.getId()));
        String str2 = "visibility";
        switch (view.getVisibility()) {
            case 0:
                str = "VISIBLE";
                break;
            case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                str = "INVISIBLE";
                break;
            case 8:
                str = "GONE";
                break;
            default:
                str = "Unknown";
                break;
        }
        bundle.putString(str2, str);
        int i = r5 - r3;
        int bottom = view.getBottom() - r4;
        bundle.putString("local_bounds", StringFormatUtil.a("[l:%d t:%d, r:%d b:%d] [w:%d, h:%d]", new Object[]{Integer.valueOf(view.getLeft()), Integer.valueOf(view.getTop()), Integer.valueOf(view.getRight()), Integer.valueOf(view.getBottom()), Integer.valueOf(i), Integer.valueOf(bottom)}));
        bundle.putString("padding", m20240c(view));
        bundle.putString("background", m20241d(view));
        bundle.putBundle("layout_params", this.f12221a.m20233a(view));
    }

    @Inject
    public DefaultViewDescriptionBuilderSpec(LayoutParamsFormatter layoutParamsFormatter, ViewIdExtractor viewIdExtractor) {
        this.f12221a = layoutParamsFormatter;
        this.f12222b = viewIdExtractor;
    }

    public final Class<View> mo1225a() {
        return View.class;
    }

    private static String m20240c(View view) {
        return StringFormatUtil.formatStrLocaleSafe("[l:%d t:%d, r:%d b:%d]", Integer.valueOf(view.getPaddingLeft()), Integer.valueOf(view.getPaddingTop()), Integer.valueOf(view.getPaddingRight()), Integer.valueOf(view.getPaddingBottom()));
    }

    @TargetApi(11)
    private static String m20241d(View view) {
        Drawable background = view.getBackground();
        if (background == null) {
            return "null";
        }
        if (VERSION.SDK_INT < 11 || !(background instanceof ColorDrawable)) {
            return background.toString();
        }
        return background.toString() + ":0x" + Integer.toHexString(((ColorDrawable) background).getColor());
    }
}
