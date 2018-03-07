package com.facebook.remoteasset;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: pulsar_ad_indicator */
public class RemoteAssetUriGenerator {
    private final Resources f4885a;

    public static RemoteAssetUriGenerator m4793b(InjectorLike injectorLike) {
        return new RemoteAssetUriGenerator(ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public RemoteAssetUriGenerator(Resources resources) {
        this.f4885a = resources;
    }

    public final String m4794a(RemoteAsset remoteAsset) {
        int i = this.f4885a.getDisplayMetrics().densityDpi;
        StringBuilder stringBuilder = new StringBuilder("https://lookaside.facebook.com/assets/");
        if (Strings.isNullOrEmpty(remoteAsset.m4792a(Integer.valueOf(i)))) {
            String str;
            stringBuilder.append(remoteAsset.f4882b);
            stringBuilder.append("/");
            stringBuilder.append(remoteAsset.f4881a);
            stringBuilder.append("@");
            if (i <= 120) {
                str = "0.75x";
            } else if (i <= 160) {
                str = "1x";
            } else if (i <= 240) {
                str = "1.5x";
            } else if (i <= 320) {
                str = "2x";
            } else if (i <= 480) {
                str = "3x";
            } else if (i <= 640) {
                str = "4x";
            } else {
                str = "4x";
            }
            stringBuilder.append(str);
            stringBuilder.append(".");
            stringBuilder.append(remoteAsset.f4883c);
        } else {
            stringBuilder.append(remoteAsset.m4792a(Integer.valueOf(i)));
        }
        return stringBuilder.toString();
    }
}
