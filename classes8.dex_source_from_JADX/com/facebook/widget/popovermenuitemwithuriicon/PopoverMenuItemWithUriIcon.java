package com.facebook.widget.popovermenuitemwithuriicon;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.view.MenuItem;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.fbui.menu.MenuItemImpl;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.inject.Assisted;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: location_opt_in_google_play_location_failed */
public class PopoverMenuItemWithUriIcon extends MenuItemImpl {
    public static final CallerContext f9907a = CallerContext.a(PopoverMenuItemWithUriIcon.class, "widget");
    public static final String f9908b = PopoverMenuItemWithUriIcon.class.getSimpleName();
    public final AbstractFbErrorReporter f9909c;
    private final FbDraweeControllerBuilder f9910d;
    public DraweeHolder<GenericDraweeHierarchy> f9911e;

    /* compiled from: location_opt_in_google_play_location_failed */
    class C10431 extends BaseControllerListener {
        final /* synthetic */ PopoverMenuItemWithUriIcon f9906a;

        C10431(PopoverMenuItemWithUriIcon popoverMenuItemWithUriIcon) {
            this.f9906a = popoverMenuItemWithUriIcon;
        }

        public final void m11629a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            this.f9906a.setIcon(this.f9906a.f9911e.h());
        }

        public final void m11630b(String str, Throwable th) {
            super.b(str, th);
            this.f9906a.f9909c.a(PopoverMenuItemWithUriIcon.f9908b, th);
        }
    }

    @Inject
    public PopoverMenuItemWithUriIcon(FbDraweeControllerBuilder fbDraweeControllerBuilder, AbstractFbErrorReporter abstractFbErrorReporter, @Assisted PopoverMenu popoverMenu, @Assisted CharSequence charSequence) {
        super(popoverMenu, 0, 0, charSequence);
        this.f9910d = fbDraweeControllerBuilder;
        this.f9909c = abstractFbErrorReporter;
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(popoverMenu.c.getResources());
        genericDraweeHierarchyBuilder.d = 0;
        genericDraweeHierarchyBuilder = genericDraweeHierarchyBuilder;
        genericDraweeHierarchyBuilder.f = new ColorDrawable(0);
        this.f9911e = DraweeHolder.a(genericDraweeHierarchyBuilder.u(), popoverMenu.c);
    }

    public final MenuItem m11631a(@Nullable String str) {
        setIcon(this.f9911e.h());
        this.f9911e.a(((FbDraweeControllerBuilder) this.f9910d.a(f9907a).a(str).a(new C10431(this))).s());
        this.f9911e.b();
        return this;
    }
}
