package android.support.v7.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;

/* compiled from: customDirectEventTypes */
public final class MediaRouterThemeHelper {
    private MediaRouterThemeHelper() {
    }

    public static Context m20289a(Context context, boolean z) {
        boolean z2 = true;
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(2130771969, typedValue, true) || typedValue.data == 0) {
            z2 = false;
        }
        boolean z3 = z2;
        if (z3 && z) {
            z3 = false;
            context = new ContextThemeWrapper(context, 2131624137);
        }
        return new ContextThemeWrapper(context, z3 ? 2131626104 : 2131626103);
    }

    public static int m20288a(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(i, typedValue, true) ? typedValue.resourceId : 0;
    }

    public static Drawable m20290b(Context context, int i) {
        int a = m20288a(context, i);
        return a != 0 ? context.getResources().getDrawable(a) : null;
    }
}
