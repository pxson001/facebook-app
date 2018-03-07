package com.facebook.heisman;

import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.heisman.CategoryBrowserActivity.FragmentDelegate;
import com.facebook.inject.Assisted;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.UltralightRuntime;
import javax.inject.Provider;

/* compiled from: video_count_48_h */
public class CategoryBrowserFragmentController {
    @Inject
    public volatile Provider<FbErrorReporter> f594a = UltralightRuntime.a;
    public final FragmentDelegate f595b;

    @Inject
    public CategoryBrowserFragmentController(@Assisted FragmentDelegate fragmentDelegate) {
        this.f595b = fragmentDelegate;
    }
}
