package com.facebook.nearby.v2.resultlist.views.itemview.photohscroll;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.nearby.v2.model.NearbyPlacesPlaceModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.Photo320FragmentModel;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.HorizontalImageGallery;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/* compiled from: daily_dialogue_lightweight_unit_type */
public class NearbyPlacesPhotoHScrollView extends CustomFrameLayout {
    private HorizontalImageGallery f16025a;
    public OnPhotoClickedListener f16026b;

    /* compiled from: daily_dialogue_lightweight_unit_type */
    public interface OnPhotoClickedListener {
        void mo968a(int i);
    }

    public NearbyPlacesPhotoHScrollView(Context context) {
        this(context, null);
    }

    public NearbyPlacesPhotoHScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NearbyPlacesPhotoHScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130905402);
        this.f16025a = (HorizontalImageGallery) c(2131564147);
        LinearLayout linearLayout = this.f16025a.b;
        if (linearLayout != null) {
            linearLayout.getLayoutParams().height = getImageSize();
            linearLayout.requestLayout();
        }
    }

    public final void m18816a() {
        Preconditions.checkNotNull(this.f16025a);
        this.f16025a.a();
    }

    public final void m18817a(NearbyPlacesPlaceModel nearbyPlacesPlaceModel) {
        Preconditions.checkNotNull(nearbyPlacesPlaceModel);
        ImmutableList l = nearbyPlacesPlaceModel.m17748l();
        boolean z = (l == null || l.isEmpty()) ? false : true;
        Preconditions.checkArgument(z);
        this.f16025a.a();
        int imageSize = getImageSize();
        for (int i = 0; i < l.size(); i++) {
            FbDraweeView a = NearbyPlacesPhotoHScrollPhotoHelper.m18813a((Photo320FragmentModel) l.get(i), imageSize, getContext(), getResources());
            if (a != null) {
                a.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ NearbyPlacesPhotoHScrollView f16024b;

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, -2110464752);
                        this.f16024b.m18814a(i);
                        Logger.a(2, EntryType.UI_INPUT_END, 452183374, a);
                    }
                });
                this.f16025a.a(a, -1, a.getLayoutParams());
            }
        }
        this.f16025a.scrollTo(0, 0);
    }

    public void setOnPhotoClickedListener(OnPhotoClickedListener onPhotoClickedListener) {
        this.f16026b = onPhotoClickedListener;
    }

    private void m18814a(int i) {
        if (this.f16026b != null) {
            this.f16026b.mo968a(i);
        }
    }

    private int getImageSize() {
        return (int) getResources().getDimension(2131430910);
    }
}
