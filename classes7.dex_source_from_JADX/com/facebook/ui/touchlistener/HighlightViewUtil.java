package com.facebook.ui.touchlistener;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.fbui.widget.layout.ImageBlockLayout;

/* compiled from: enable_album_feedback */
public class HighlightViewUtil {
    public static void m19321a(View view, int i) {
        m19322a(view, i, 0.5f, 1.0f);
    }

    private static void m19322a(View view, int i, float f, float f2) {
        if (i == 0) {
            view.setAlpha(f);
        } else if (i == 1 || i == 3) {
            view.setAlpha(f2);
        }
    }

    public static void m19323a(ViewGroup viewGroup, int i) {
        m19324a(viewGroup, i, 0.5f, 1.0f);
    }

    private static void m19324a(ViewGroup viewGroup, int i, float f, float f2) {
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if ((childAt instanceof ContentView) || !(childAt instanceof ViewGroup)) {
                m19322a(childAt, i, f, f2);
            } else {
                m19324a((ViewGroup) childAt, i, f, f2);
            }
        }
    }

    public static void m19325a(ImageBlockLayout imageBlockLayout, int i) {
        DraweeController controller = imageBlockLayout.getController();
        if (controller != null && controller.d() != null && controller.d().a() != null) {
            if (i == 0) {
                controller.d().a().setAlpha(127);
            } else if (i == 1 || i == 3) {
                controller.d().a().setAlpha(255);
            }
        }
    }
}
