package android.support.v4.hardware.display;

import android.content.Context;
import android.view.WindowManager;
import java.util.WeakHashMap;

/* compiled from: viewer_leave_scenario */
public abstract class DisplayManagerCompat {
    private static final WeakHashMap<Context, DisplayManagerCompat> f229a = new WeakHashMap();

    /* compiled from: viewer_leave_scenario */
    class LegacyImpl extends DisplayManagerCompat {
        private final WindowManager f230a;

        public LegacyImpl(Context context) {
            this.f230a = (WindowManager) context.getSystemService("window");
        }
    }

    DisplayManagerCompat() {
    }

    public static DisplayManagerCompat m258a(Context context) {
        DisplayManagerCompat displayManagerCompat;
        synchronized (f229a) {
            displayManagerCompat = (DisplayManagerCompat) f229a.get(context);
            if (displayManagerCompat == null) {
                displayManagerCompat = new LegacyImpl(context);
                f229a.put(context, displayManagerCompat);
            }
        }
        return displayManagerCompat;
    }
}
