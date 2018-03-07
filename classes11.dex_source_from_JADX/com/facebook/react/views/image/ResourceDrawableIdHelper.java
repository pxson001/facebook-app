package com.facebook.react.views.image;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.Uri.Builder;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: SCROLL_INVITES */
class ResourceDrawableIdHelper {
    private Map<String, Integer> f11464a = new HashMap();

    private int m11871c(Context context, @Nullable String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        String replace = str.toLowerCase().replace("-", "_");
        if (this.f11464a.containsKey(replace)) {
            return ((Integer) this.f11464a.get(replace)).intValue();
        }
        int identifier = context.getResources().getIdentifier(replace, "drawable", context.getPackageName());
        this.f11464a.put(replace, Integer.valueOf(identifier));
        return identifier;
    }

    @Nullable
    public final Drawable m11872a(Context context, @Nullable String str) {
        int c = m11871c(context, str);
        return c > 0 ? context.getResources().getDrawable(c) : null;
    }

    public final Uri m11873b(Context context, @Nullable String str) {
        int c = m11871c(context, str);
        return c > 0 ? new Builder().scheme("res").path(String.valueOf(c)).build() : Uri.EMPTY;
    }
}
