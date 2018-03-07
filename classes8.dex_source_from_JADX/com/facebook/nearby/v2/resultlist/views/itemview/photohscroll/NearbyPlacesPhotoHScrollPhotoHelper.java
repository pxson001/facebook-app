package com.facebook.nearby.v2.resultlist.views.itemview.photohscroll;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.BrowseNearbyPlacesFullImageFragmentModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.Photo320FragmentModel;
import com.google.common.base.Preconditions;

/* compiled from: d0b8c78f1a9f5b6e5be2545dd1a11747 */
public abstract class NearbyPlacesPhotoHScrollPhotoHelper {
    private static final Class<?> f16022a = NearbyPlacesPhotoHScrollPhotoHelper.class;

    public static final FbDraweeView m18813a(Photo320FragmentModel photo320FragmentModel, int i, Context context, Resources resources) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(resources);
        if (photo320FragmentModel == null) {
            return null;
        }
        BrowseNearbyPlacesFullImageFragmentModel ke_ = photo320FragmentModel.ke_();
        if (ke_ == null) {
            return null;
        }
        Object d = ke_.m17807d();
        if (StringUtil.a(d)) {
            return null;
        }
        Uri parse = Uri.parse(d);
        if (parse == null) {
            return null;
        }
        FbDraweeView fbDraweeView = new FbDraweeView(context);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
        layoutParams.gravity = 16;
        Preconditions.checkNotNull(resources);
        layoutParams.setMargins(0, 0, (int) resources.getDimension(2131430913), 0);
        fbDraweeView.setLayoutParams(layoutParams);
        fbDraweeView.setMinimumWidth(i);
        fbDraweeView.setMaxWidth(i);
        fbDraweeView.setMinimumHeight(i);
        fbDraweeView.setMaxHeight(i);
        fbDraweeView.setScaleType(ScaleType.CENTER_CROP);
        Preconditions.checkNotNull(resources);
        int ceil = (int) Math.ceil((double) resources.getDimension(2131430912));
        fbDraweeView.setPadding(ceil, ceil, ceil, ceil);
        fbDraweeView.setBackgroundResource(2130841608);
        fbDraweeView.a(parse, CallerContext.a(f16022a));
        fbDraweeView.setClickable(true);
        fbDraweeView.requestLayout();
        return fbDraweeView;
    }
}
