package com.facebook.events.create.ui;

import android.app.Activity;
import android.content.Intent;
import com.facebook.common.android.ActivityMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.events.create.EventCompositionModel;
import com.facebook.events.ui.themeselector.ThemeSelectorActivity;
import com.facebook.inject.InjectorLike;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Action;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Builder;
import com.facebook.ipc.simplepicker.SimplePickerSource;
import com.facebook.photos.simplepicker.launcher.SimplePickerLauncherActivity;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: confirmed */
public class CoverPhotoActivitiesLauncher {
    public Activity f16290a;
    public IFeedIntentBuilder f16291b;
    public SecureContextHelper f16292c;
    public EventCompositionModel f16293d;

    public static CoverPhotoActivitiesLauncher m16772b(InjectorLike injectorLike) {
        return new CoverPhotoActivitiesLauncher(ActivityMethodAutoProvider.b(injectorLike), (IFeedIntentBuilder) DefaultFeedIntentBuilder.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    @Inject
    public CoverPhotoActivitiesLauncher(Activity activity, IFeedIntentBuilder iFeedIntentBuilder, SecureContextHelper secureContextHelper) {
        this.f16290a = activity;
        this.f16291b = iFeedIntentBuilder;
        this.f16292c = secureContextHelper;
    }

    public static CoverPhotoActivitiesLauncher m16771a(InjectorLike injectorLike) {
        return m16772b(injectorLike);
    }

    public final void m16773b() {
        Builder a = new Builder(SimplePickerSource.EVENT).h().i().k().a(Action.NONE);
        Intent intent = new Intent(this.f16290a.getBaseContext(), SimplePickerLauncherActivity.class);
        intent.putExtra("extra_simple_picker_launcher_settings", a.r());
        this.f16292c.a(intent, 103, this.f16290a);
    }

    public final void m16774c() {
        Intent intent = new Intent(this.f16290a.getBaseContext(), ThemeSelectorActivity.class);
        intent.putExtra("extra_show_full_width_themes", 2);
        if (!Strings.isNullOrEmpty(this.f16293d.f16045c)) {
            intent.putExtra("extra_theme_selector_event_name", this.f16293d.f16045c);
        }
        if (this.f16293d.m16448c()) {
            intent.putExtra("extra_theme_selector_event_description", this.f16293d.f16046d);
        }
        this.f16292c.a(intent, 104, this.f16290a);
    }
}
