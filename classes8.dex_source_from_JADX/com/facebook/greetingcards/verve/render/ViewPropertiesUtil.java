package com.facebook.greetingcards.verve.render;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.facebook.greetingcards.verve.model.VMView;
import com.facebook.greetingcards.verve.model.VMViewType;

/* compiled from: view_page_service_tap */
public class ViewPropertiesUtil {
    private static void m416c(View view, VMView vMView) {
        if (vMView.m308o() != VMViewType.BUTTON || VERSION.SDK_INT >= 11) {
            view.setX(vMView.m303j());
            view.setY(vMView.m304k());
            return;
        }
        LayoutParams layoutParams = new FrameLayout.LayoutParams(m411a(view));
        layoutParams.gravity = 51;
        layoutParams.leftMargin = (int) (vMView.m303j() + 0.5f);
        layoutParams.topMargin = (int) (vMView.m304k() + 0.5f);
        view.setLayoutParams(layoutParams);
    }

    public static void m413a(View view, VMView vMView) {
        m416c(view, vMView);
        view.setRotation(vMView.m294a());
        view.setPivotX(vMView.m305l());
        view.setPivotY(vMView.m306m());
        view.setAlpha(vMView.m295b());
        m412a(view, vMView.m301h());
        m414b(view, vMView.m302i());
    }

    public static void m415b(View view, VMView vMView) {
        if (vMView.position != null) {
            m416c(view, vMView);
        }
        if (vMView.rotation != null) {
            view.setRotation(vMView.m294a());
        }
        if (vMView.anchor != null) {
            view.setPivotX(vMView.m305l());
            view.setPivotY(vMView.m306m());
        }
        if (vMView.opacity != null) {
            view.setAlpha(vMView.m295b());
        }
        if (vMView.size != null) {
            m412a(view, vMView.m301h());
            m414b(view, vMView.m302i());
        }
    }

    public static void m412a(View view, float f) {
        LayoutParams a = m411a(view);
        a.width = (int) (0.5f + f);
        view.setLayoutParams(a);
    }

    public static void m414b(View view, float f) {
        LayoutParams a = m411a(view);
        a.height = (int) (0.5f + f);
        view.setLayoutParams(a);
    }

    private static LayoutParams m411a(View view) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            return new LayoutParams(0, 0);
        }
        return layoutParams;
    }
}
