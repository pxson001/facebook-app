package com.facebook.common.util;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import com.facebook.common.stringformat.StringFormatUtil;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: survey_id */
public class FindViewUtil {
    private FindViewUtil() {
    }

    public static <T extends View> Optional<T> m6200a(View view, int i) {
        Preconditions.checkNotNull(view);
        return Optional.fromNullable(view.findViewById(i));
    }

    public static <T extends View> T m6202b(View view, int i) {
        Preconditions.checkNotNull(view);
        return m6199a(view.findViewById(i), view.getResources(), i);
    }

    public static <T extends View> T m6201b(Activity activity, int i) {
        Preconditions.checkNotNull(activity);
        return m6199a(activity.findViewById(i), activity.getResources(), i);
    }

    private static <T extends View> T m6199a(@Nullable View view, Resources resources, int i) {
        Preconditions.checkNotNull(resources);
        if (view != null) {
            return view;
        }
        throw new IllegalStateException(StringFormatUtil.a("Required view with ID %s not found. Either your layout is missing the ID you requested, or you want to use getOptionalView. Only use getOptionalView if you're sure that you need logic that depends on whether a particular child view exists.", new Object[]{resources.getResourceEntryName(i)}));
    }
}
