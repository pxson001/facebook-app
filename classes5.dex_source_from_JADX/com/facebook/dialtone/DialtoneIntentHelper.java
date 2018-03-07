package com.facebook.dialtone;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.dialtone.activity.DialtoneIntentInterstitialActivity;
import com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.List;

/* compiled from: \{([^{}]*)\} */
public class DialtoneIntentHelper {
    public static final List<String> f11802a = Arrays.asList(new String[]{"com.facebook.katana.activity.media.ViewVideoActivity", "com.facebook.photos.albums.video.VideoAlbumLaunchPlayerActivity"});

    static boolean m19824a(Intent intent, DialtoneController dialtoneController) {
        boolean z;
        int intExtra = intent.getIntExtra("target_fragment", -1);
        if (intent == null || intent.getComponent() == null) {
            z = false;
        } else {
            z = f11802a.contains(intent.getComponent().getClassName());
        }
        return z || (intExtra == ContentFragmentType.FACEWEB_FRAGMENT.ordinal() && !dialtoneController.c(intent.getStringExtra("mobile_page")));
    }

    static Intent m19823a(Context context, Intent intent, int i, boolean z) {
        Intent intent2 = new Intent();
        intent2.setClass(context, DialtoneIntentInterstitialActivity.class);
        intent2.putExtra("destination_intent", intent);
        intent2.putExtra("request_code", i);
        intent2.putExtra("start_for_result", z);
        intent2.addFlags(65536);
        if ((intent.getFlags() & 268435456) != 0) {
            intent2.addFlags(268435456);
        }
        Preconditions.checkNotNull(intent.getComponent());
        Preconditions.checkNotNull(intent.getComponent().getClassName());
        return intent2;
    }
}
