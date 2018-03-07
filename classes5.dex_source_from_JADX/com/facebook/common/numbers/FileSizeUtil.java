package com.facebook.common.numbers;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: alarm_manager_fix_enabled */
public class FileSizeUtil {
    public final Resources f11100a;

    public static FileSizeUtil m19098b(InjectorLike injectorLike) {
        return new FileSizeUtil(ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FileSizeUtil(Resources resources) {
        this.f11100a = resources;
    }

    public static FileSizeUtil m19097a(InjectorLike injectorLike) {
        return m19098b(injectorLike);
    }
}
