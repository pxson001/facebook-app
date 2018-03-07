package com.facebook.photos.albums.ui;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;

/* compiled from: confirmationConfirmContactpointParams */
public class PhotoGridImageView extends FbDraweeView {
    public PhotoGridImageView(Context context) {
        Resources resources = context.getResources();
        super(context, new GenericDraweeHierarchyBuilder(resources).g(resources.getDrawable(2131362895)).e(ScaleType.g).u());
        setAspectRatio(1.0f);
    }
}
