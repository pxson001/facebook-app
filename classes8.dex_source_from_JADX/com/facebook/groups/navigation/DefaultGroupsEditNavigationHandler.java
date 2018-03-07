package com.facebook.groups.navigation;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.base.fragment.FbFragment;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.titlebar.Fb4aTitleBarSupplier;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.FbTitleBarSupplier;
import com.facebook.widget.titlebar.HasTitleBar;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: entity_cards_config_extras_uuid */
public class DefaultGroupsEditNavigationHandler {
    private FbTitleBarSupplier f14795a;

    public static DefaultGroupsEditNavigationHandler m17156b(InjectorLike injectorLike) {
        return new DefaultGroupsEditNavigationHandler((FbTitleBarSupplier) Fb4aTitleBarSupplier.a(injectorLike));
    }

    @Inject
    public DefaultGroupsEditNavigationHandler(FbTitleBarSupplier fbTitleBarSupplier) {
        this.f14795a = fbTitleBarSupplier;
    }

    public final void m17157a(FbFragment fbFragment, String str, String str2, @Nullable OnClickListener onClickListener, @Nullable final OnClickListener onClickListener2) {
        HasTitleBar hasTitleBar = (HasTitleBar) fbFragment.a(HasTitleBar.class);
        if (!(hasTitleBar == null || onClickListener2 == null)) {
            hasTitleBar.a_(str);
            hasTitleBar.c(true);
            Builder a = TitleBarButtonSpec.a();
            a.g = str2;
            hasTitleBar.a(a.a());
            hasTitleBar.a(new OnToolbarButtonListener(this) {
                final /* synthetic */ DefaultGroupsEditNavigationHandler f14794b;

                public final void m17155a(View view, TitleBarButtonSpec titleBarButtonSpec) {
                    onClickListener2.onClick(view);
                }
            });
        }
        FbTitleBar fbTitleBar = (FbTitleBar) this.f14795a.get();
        if (fbTitleBar != null && onClickListener != null) {
            fbTitleBar.a(onClickListener);
        }
    }
}
