package com.facebook.photos.creativeediting.utilities;

import android.content.Context;
import android.graphics.Rect;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: in_contact_list */
public class PhotoOverlayDrawUtilities {
    private final Context f12844a;
    private final int f12845b = this.f12844a.getResources().getDimensionPixelSize(2131429544);

    public static PhotoOverlayDrawUtilities m20231b(InjectorLike injectorLike) {
        return new PhotoOverlayDrawUtilities((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public PhotoOverlayDrawUtilities(Context context) {
        this.f12844a = context;
    }

    public final Rect m20233a(Rect rect) {
        boolean z = true;
        Preconditions.checkNotNull(rect);
        Preconditions.checkArgument(rect.width() != 0);
        if (rect.height() == 0) {
            z = false;
        }
        Preconditions.checkArgument(z);
        int width = ((int) ((((float) rect.width()) / 2.0f) - (((float) this.f12845b) / 2.0f))) + rect.left;
        int height = ((int) ((((float) rect.height()) / 2.0f) - (((float) this.f12845b) / 2.0f))) + rect.top;
        return new Rect(width, height, this.f12845b + width, this.f12845b + height);
    }

    public static Rect m20229a(Rect rect, int i, int i2) {
        boolean z = true;
        Preconditions.checkNotNull(rect);
        Preconditions.checkArgument(rect.width() != 0);
        if (rect.height() == 0) {
            z = false;
        }
        Preconditions.checkArgument(z);
        int width = ((int) ((((float) rect.width()) / 2.0f) - (((float) i) / 2.0f))) + rect.left;
        int height = ((int) ((((float) rect.height()) / 2.0f) - (((float) i2) / 2.0f))) + rect.top;
        return new Rect(width, height, width + i, height + i2);
    }

    public static Rect m20230b(Rect rect) {
        double max = ((double) (Math.max(rect.width(), rect.height()) / 2)) * 1.41421d;
        return new Rect(rect.centerX() - ((int) max), rect.centerY() - ((int) max), rect.centerX() + ((int) max), ((int) max) + rect.centerY());
    }

    public static Rect m20232c(Rect rect) {
        return new Rect(rect.left - 5, rect.top, rect.right + 5, rect.bottom);
    }
}
