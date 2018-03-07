package com.facebook.friendsharing.souvenirs.ui;

import android.content.Context;
import android.net.Uri;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;

/* compiled from: RECONNECT */
public class SouvenirsImageView extends FbDraweeView {
    public Uri f24209c;

    public SouvenirsImageView(Context context) {
        super(context);
    }

    @Deprecated
    public void setImageURI(Uri uri) {
        this.f24209c = uri;
        super.setImageURI(uri);
    }

    public final void m26451a(Uri uri, CallerContext callerContext) {
        this.f24209c = uri;
        super.a(uri, callerContext);
    }
}
