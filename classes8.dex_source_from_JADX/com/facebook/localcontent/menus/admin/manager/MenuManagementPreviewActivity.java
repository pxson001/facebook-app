package com.facebook.localcontent.menus.admin.manager;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.composer.ui.titlebar.ComposerBaseTitleBar;
import com.facebook.composer.ui.titlebar.ComposerTitleBar;
import com.facebook.composer.ui.titlebar.ComposerTitleBar.StateBuilder;
import com.facebook.composer.ui.titlebar.HarrisonPlusIconType;
import com.facebook.inject.FbInjector;
import com.facebook.localcontent.menus.PagePhotoMenuFragment;
import com.facebook.localcontent.menus.structured.StructuredMenuTabPagerFragment;
import com.facebook.widget.titlebar.FbTitleBar.OnBackPressedListener;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: ec_card_scrolled */
public class MenuManagementPreviewActivity extends FbFragmentActivity {
    @Inject
    public AbstractFbErrorReporter f15063p;
    private MenuPreviewType f15064q;

    /* compiled from: ec_card_scrolled */
    class C16401 implements OnBackPressedListener {
        final /* synthetic */ MenuManagementPreviewActivity f15060a;

        C16401(MenuManagementPreviewActivity menuManagementPreviewActivity) {
            this.f15060a = menuManagementPreviewActivity;
        }

        public final void m17485a() {
            this.f15060a.onBackPressed();
        }
    }

    /* compiled from: ec_card_scrolled */
    class C16412 extends OnToolbarButtonListener {
        final /* synthetic */ MenuManagementPreviewActivity f15061a;

        C16412(MenuManagementPreviewActivity menuManagementPreviewActivity) {
            this.f15061a = menuManagementPreviewActivity;
        }

        public final void m17486a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            this.f15061a.setResult(-1);
            this.f15061a.finish();
        }
    }

    /* compiled from: ec_card_scrolled */
    public enum MenuPreviewType {
        PHOTO_MENU,
        STRUCTURED_MENU,
        LINK_MENU
    }

    private static <T extends Context> void m17488a(Class<T> cls, T t) {
        m17489a((Object) t, (Context) t);
    }

    public static void m17489a(Object obj, Context context) {
        ((MenuManagementPreviewActivity) obj).f15063p = (AbstractFbErrorReporter) FbErrorReporterImpl.a(FbInjector.get(context));
    }

    protected final void m17493b(@Nullable Bundle bundle) {
        super.b(bundle);
        Class cls = MenuManagementPreviewActivity.class;
        m17489a((Object) this, (Context) this);
        setContentView(2130905220);
        this.f15064q = (MenuPreviewType) Preconditions.checkNotNull(getIntent().getSerializableExtra("extra_menu_type"));
        m17490i();
        m17491j();
    }

    private void m17490i() {
        FragmentManager kO_ = kO_();
        Fragment a = kO_.a(2131558429);
        if (a == null) {
            switch (this.f15064q) {
                case PHOTO_MENU:
                    a = new PagePhotoMenuFragment();
                    break;
                case STRUCTURED_MENU:
                    a = new StructuredMenuTabPagerFragment();
                    break;
                case LINK_MENU:
                    a = new PageLinkMenuFragment();
                    break;
                default:
                    this.f15063p.b(MenuManagementPreviewActivity.class.getSimpleName(), "Trying to preview an unsupported menu type");
                    break;
            }
            a.g(getIntent().getExtras());
        }
        kO_.a().b(2131558429, a).b();
    }

    private void m17491j() {
        ComposerBaseTitleBar composerBaseTitleBar = (ComposerBaseTitleBar) a(2131560528);
        composerBaseTitleBar.setOnBackPressedListener(new C16401(this));
        StateBuilder stateBuilder = new StateBuilder();
        stateBuilder.b = m17487a(this.f15064q);
        stateBuilder = stateBuilder;
        stateBuilder.c = new C16412(this);
        stateBuilder = stateBuilder;
        stateBuilder.a = m17492k();
        stateBuilder = stateBuilder;
        stateBuilder.d = HarrisonPlusIconType.c();
        ComposerTitleBar composerTitleBar = new ComposerTitleBar(composerBaseTitleBar, stateBuilder.a());
    }

    private String m17492k() {
        switch (this.f15064q) {
            case PHOTO_MENU:
                return getString(2131239098);
            case STRUCTURED_MENU:
                return getString(2131239134);
            case LINK_MENU:
                return getString(2131239124);
            default:
                return getString(2131239119);
        }
    }

    @Nullable
    private TitleBarButtonSpec m17487a(MenuPreviewType menuPreviewType) {
        if (menuPreviewType != MenuPreviewType.STRUCTURED_MENU && menuPreviewType != MenuPreviewType.PHOTO_MENU) {
            return null;
        }
        Builder a = TitleBarButtonSpec.a();
        a.g = getString(2131239133);
        a = a;
        a.d = true;
        return a.a();
    }
}
