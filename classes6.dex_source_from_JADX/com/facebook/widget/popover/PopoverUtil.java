package com.facebook.widget.popover;

import android.app.Dialog;
import android.content.res.Resources;
import android.view.View;
import com.facebook.common.ui.util.ViewDimensionUtil;
import com.facebook.common.util.SizeUtil;
import com.facebook.fbui.draggable.Direction;

/* compiled from: com.google.android.gms.maps.internal.IOnIndoorStateChangeListener */
public class PopoverUtil {
    public static boolean m28515a(int i, float f, Direction direction) {
        return direction.isYAxis() ? m28517b(i, f, direction) : m28518c(i, f, direction);
    }

    public static boolean m28517b(int i, float f, Direction direction) {
        return direction == Direction.UP ? f < ((float) (-i)) : f > ((float) i);
    }

    public static boolean m28518c(int i, float f, Direction direction) {
        return direction == Direction.LEFT ? f < ((float) (-i)) : f > ((float) i);
    }

    public static boolean m28516a(View view, float f, float f2) {
        return f >= view.getX() && f <= view.getX() + ((float) view.getWidth()) && f2 >= view.getY() && f2 <= view.getY() + ((float) SizeUtil.a(view.getContext(), 48.0f));
    }

    public static void m28514a(Dialog dialog) {
        Resources resources = dialog.getContext().getResources();
        dialog.getWindow().setLayout(ViewDimensionUtil.a(dialog.getContext(), 16842996, resources.getDisplayMetrics().widthPixels, -1), ViewDimensionUtil.a(dialog.getContext(), 16842997, resources.getDisplayMetrics().heightPixels, -1));
    }
}
