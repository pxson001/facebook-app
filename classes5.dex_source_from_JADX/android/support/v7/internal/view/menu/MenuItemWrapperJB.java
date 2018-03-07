package android.support.v7.internal.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.ActionProvider;
import android.support.v7.internal.view.menu.MenuItemWrapperICS.ActionProviderWrapper;
import android.view.ActionProvider.VisibilityListener;
import android.view.MenuItem;
import android.view.View;

@TargetApi(16)
/* compiled from: unowned_place_photo_vote_module */
class MenuItemWrapperJB extends MenuItemWrapperICS {

    /* compiled from: unowned_place_photo_vote_module */
    class ActionProviderWrapperJB extends ActionProviderWrapper implements VisibilityListener {
        ActionProvider.VisibilityListener f907c;
        final /* synthetic */ MenuItemWrapperJB f908d;

        public ActionProviderWrapperJB(MenuItemWrapperJB menuItemWrapperJB, Context context, android.view.ActionProvider actionProvider) {
            this.f908d = menuItemWrapperJB;
            super(menuItemWrapperJB, context, actionProvider);
        }

        public final View mo324a(MenuItem menuItem) {
            return this.f901a.onCreateActionView(menuItem);
        }

        public final boolean mo326b() {
            return this.f901a.overridesItemVisibility();
        }

        public final boolean mo327c() {
            return this.f901a.isVisible();
        }

        public final void mo325a(ActionProvider.VisibilityListener visibilityListener) {
            VisibilityListener visibilityListener2;
            this.f907c = visibilityListener;
            android.view.ActionProvider actionProvider = this.f901a;
            if (visibilityListener == null) {
                visibilityListener2 = null;
            }
            actionProvider.setVisibilityListener(visibilityListener2);
        }

        public void onActionProviderVisibilityChanged(boolean z) {
            if (this.f907c != null) {
                this.f907c.mo315a();
            }
        }
    }

    MenuItemWrapperJB(Context context, SupportMenuItem supportMenuItem) {
        super(context, supportMenuItem);
    }

    final ActionProviderWrapper mo328a(android.view.ActionProvider actionProvider) {
        return new ActionProviderWrapperJB(this, this.f815a, actionProvider);
    }
}
