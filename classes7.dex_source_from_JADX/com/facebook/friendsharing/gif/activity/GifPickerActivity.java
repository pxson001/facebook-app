package com.facebook.friendsharing.gif.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import javax.annotation.Nullable;

/* compiled from: SELF */
public class GifPickerActivity extends FbFragmentActivity {
    GifPickerFragment f23873p;

    public static Intent m26008a(@Nullable String str, Context context, ComposerConfiguration composerConfiguration) {
        return new Intent(context, GifPickerActivity.class).putExtra("extra_gif_picker_launcher_settings", composerConfiguration).putExtra("extra_gif_picker_launcher_id", str);
    }

    public final void m26009b(Bundle bundle) {
        super.b(bundle);
        setContentView(2130904590);
        this.f23873p = (GifPickerFragment) kO_().a(2131562537);
        if (this.f23873p == null) {
            this.f23873p = new GifPickerFragment();
            this.f23873p.g(getIntent().getExtras());
            kO_().a().a(2131562537, this.f23873p).b();
        }
    }

    public void onBackPressed() {
        GifPickerFragment gifPickerFragment = this.f23873p;
        gifPickerFragment.as.f23911b.c();
        GifPickerAnalyticsLogger gifPickerAnalyticsLogger = gifPickerFragment.f23902d;
        gifPickerAnalyticsLogger.f23884a.a(new HoneyClientEvent("gif_picker_back_pressed").b("session_id", gifPickerFragment.am));
        super.onBackPressed();
    }
}
