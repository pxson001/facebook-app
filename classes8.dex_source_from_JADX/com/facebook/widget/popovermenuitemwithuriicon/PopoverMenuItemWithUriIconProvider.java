package com.facebook.widget.popovermenuitemwithuriicon;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: location_opt_in_google_play_location_dialog_triggered */
public class PopoverMenuItemWithUriIconProvider extends AbstractAssistedProvider<PopoverMenuItemWithUriIcon> {
    public final PopoverMenuItemWithUriIcon m11632a(PopoverMenu popoverMenu, CharSequence charSequence) {
        return new PopoverMenuItemWithUriIcon(FbDraweeControllerBuilder.b(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), popoverMenu, charSequence);
    }
}
