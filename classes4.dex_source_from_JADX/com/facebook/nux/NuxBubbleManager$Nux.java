package com.facebook.nux;

import android.view.View;
import com.facebook.common.util.StringUtil;
import com.facebook.nux.interstitial.BaseNuxDelegate;
import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;

/* compiled from: profile_picture_expiration_time */
public class NuxBubbleManager$Nux {
    public final int f4103a;
    public final String f4104b;
    public final WeakReference<View> f4105c;
    public final BaseNuxDelegate f4106d;
    public final boolean f4107e;
    public final int f4108f;

    public NuxBubbleManager$Nux(int i, String str, View view, BaseNuxDelegate baseNuxDelegate, boolean z, int i2) {
        Preconditions.checkArgument(!StringUtil.a(str));
        Preconditions.checkNotNull(view);
        Preconditions.checkNotNull(baseNuxDelegate);
        this.f4103a = i;
        this.f4104b = str;
        this.f4105c = new WeakReference(view);
        this.f4106d = baseNuxDelegate;
        this.f4107e = z;
        this.f4108f = i2;
    }
}
