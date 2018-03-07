package com.facebook.timeline.coverphoto.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.Assisted;
import com.facebook.ipc.media.MediaItem;
import com.facebook.productionprompts.logging.PromptAnalytics;
import com.facebook.productionprompts.model.ProductionPromptObject;
import com.facebook.ui.toaster.Toaster;
import java.util.ArrayList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: marketplace_search_uri */
public class CoverPhotoRepositionActivityLauncher {
    private final long f9137a;
    private final Provider<SecureContextHelper> f9138b;

    @Inject
    public CoverPhotoRepositionActivityLauncher(@Assisted Long l, Provider<SecureContextHelper> provider) {
        this.f9137a = l.longValue();
        this.f9138b = provider;
    }

    public final void m10916a(Fragment fragment, Intent intent, boolean z) {
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("extra_media_items");
        if (parcelableArrayListExtra != null && !parcelableArrayListExtra.isEmpty()) {
            m10914a(((MediaItem) parcelableArrayListExtra.get(0)).e(), 0, z, fragment.o(), null, null, null);
        }
    }

    public final void m10915a(Activity activity, Intent intent, boolean z, String str, PromptAnalytics promptAnalytics) {
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("extra_media_items");
        if (parcelableArrayListExtra != null && !parcelableArrayListExtra.isEmpty()) {
            m10914a(((MediaItem) parcelableArrayListExtra.get(0)).e(), 0, z, activity, str, promptAnalytics, ProductionPromptObject.class.getSimpleName());
        }
    }

    private void m10914a(String str, long j, boolean z, Activity activity, @Nullable String str2, @Nullable PromptAnalytics promptAnalytics, @Nullable String str3) {
        if (activity != null) {
            if (str == null) {
                Toaster.a(activity, activity.getString(2131234968));
                return;
            }
            Intent intent = new Intent(activity, CoverPhotoRepositionActivity.class);
            intent.putExtra("cover_photo_uri", str);
            intent.putExtra("cover_photo_fbid", j);
            intent.putExtra("cover_photo_refresh_header", z);
            intent.putExtra("target_fragment", ContentFragmentType.TIMELINE_COVERPHOTO_FRAGMENT.ordinal());
            intent.putExtra("profile_id", this.f9137a);
            intent.putExtra("session_id", str2);
            intent.putExtra("prompt_entry_point_analytics_extra", promptAnalytics);
            intent.putExtra("prompt_object_class_name_extra", str3);
            ((SecureContextHelper) this.f9138b.get()).a(intent, 127, activity);
        }
    }
}
