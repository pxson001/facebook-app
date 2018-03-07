package com.facebook.composer.minutiae.titlebar;

import android.content.res.Resources;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.composer.minutiae.MinutiaeTagPickerActivity.C01201;
import com.facebook.composer.minutiae.util.MinutiaeConfiguration;
import com.facebook.inject.InjectorLike;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: thread_presence_post */
public class MinutiaeTitleBarHelper {
    private final Resources f1770a;
    public C01201 f1771b = null;

    /* compiled from: thread_presence_post */
    public class C01771 extends OnToolbarButtonListener {
        final /* synthetic */ MinutiaeTitleBarHelper f1768a;

        public C01771(MinutiaeTitleBarHelper minutiaeTitleBarHelper) {
            this.f1768a = minutiaeTitleBarHelper;
        }

        public final void m1736a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            if (this.f1768a.f1771b != null) {
                this.f1768a.f1771b.m1430a();
            }
        }
    }

    public static MinutiaeTitleBarHelper m1738b(InjectorLike injectorLike) {
        return new MinutiaeTitleBarHelper(ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public MinutiaeTitleBarHelper(Resources resources) {
        this.f1770a = resources;
    }

    public final void m1740a(FbTitleBar fbTitleBar, MinutiaeConfiguration minutiaeConfiguration) {
        switch (minutiaeConfiguration.f1836b) {
            case VERB_PICKER:
                m1737a(fbTitleBar);
                return;
            case OBJECT_PICKER:
                m1739b(fbTitleBar, minutiaeConfiguration);
                return;
            case UNKNOWN:
                throw new IllegalArgumentException();
            default:
                return;
        }
    }

    private static void m1737a(FbTitleBar fbTitleBar) {
        fbTitleBar.setTitle(2131234553);
        ((View) fbTitleBar).setVisibility(0);
    }

    private void m1739b(FbTitleBar fbTitleBar, MinutiaeConfiguration minutiaeConfiguration) {
        if (minutiaeConfiguration.f1846l != null) {
            fbTitleBar.setTitle(minutiaeConfiguration.f1846l);
        } else if (minutiaeConfiguration.f1839e != null) {
            fbTitleBar.setTitle(minutiaeConfiguration.f1839e.n());
        } else if (minutiaeConfiguration.m1816f()) {
            Preconditions.checkArgument(!(fbTitleBar instanceof RidgeTitleBar));
            fbTitleBar.setTitle(minutiaeConfiguration.m1817g().g().b());
            String string = this.f1770a.getString(2131235639);
            Builder a = TitleBarButtonSpec.a();
            a.a = 1;
            a = a;
            a.g = string;
            a = a;
            a.h = -2;
            fbTitleBar.setButtonSpecs(ImmutableList.of(a.a()));
            fbTitleBar.setOnToolbarButtonListener(new C01771(this));
        }
        ((View) fbTitleBar).setVisibility(0);
    }
}
