package com.facebook.timeline.tempprofilepic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.common.util.FindViewUtil;
import com.facebook.fbui.widget.text.ImageWithTextView;
import com.facebook.inject.Assisted;
import com.facebook.photos.creativeediting.RotatingFrameLayout;
import com.facebook.photos.creativeediting.swipeable.composer.CreativeEditingSwipeableLayout;
import com.facebook.ui.compat.fbrelativelayout.FbRelativeLayout;
import javax.inject.Inject;

/* compiled from: facecast_share_now_start */
public class EditGalleryExpirationController {
    public final Runnable f14904a = new C10951(this);
    public final Runnable f14905b = new C10962(this);
    public final RotatingFrameLayout f14906c;
    public final FrameLayout f14907d;
    public final CreativeEditingSwipeableLayout f14908e;
    private final Context f14909f;
    public final ExpirationDialogController f14910g;
    private final LayoutInflater f14911h;
    private ImageWithTextView f14912i;

    /* compiled from: facecast_share_now_start */
    class C10951 implements Runnable {
        final /* synthetic */ EditGalleryExpirationController f14902a;

        C10951(EditGalleryExpirationController editGalleryExpirationController) {
            this.f14902a = editGalleryExpirationController;
        }

        public void run() {
            EditGalleryExpirationController.m18767a(this.f14902a, this.f14902a.f14907d, this.f14902a.f14908e, 0.0d);
        }
    }

    /* compiled from: facecast_share_now_start */
    class C10962 implements Runnable {
        final /* synthetic */ EditGalleryExpirationController f14903a;

        C10962(EditGalleryExpirationController editGalleryExpirationController) {
            this.f14903a = editGalleryExpirationController;
        }

        public void run() {
            ImageView imageView = (ImageView) this.f14903a.f14906c.findViewById(2131558576);
            if (imageView != null) {
                EditGalleryExpirationController.m18767a(this.f14903a, this.f14903a.f14906c, imageView, 0.05d);
            }
        }
    }

    @Inject
    public EditGalleryExpirationController(@Assisted RotatingFrameLayout rotatingFrameLayout, @Assisted FrameLayout frameLayout, @Assisted CreativeEditingSwipeableLayout creativeEditingSwipeableLayout, @Assisted long j, Context context, ExpirationDialogControllerProvider expirationDialogControllerProvider, LayoutInflater layoutInflater) {
        this.f14906c = rotatingFrameLayout;
        this.f14907d = frameLayout;
        this.f14908e = creativeEditingSwipeableLayout;
        this.f14909f = context;
        this.f14910g = expirationDialogControllerProvider.m18776a(j);
        this.f14911h = layoutInflater;
    }

    public final void m18768a(FbRelativeLayout fbRelativeLayout) {
        this.f14911h.inflate(2130904181, fbRelativeLayout);
        this.f14912i = (ImageWithTextView) FindViewUtil.b(fbRelativeLayout, 2131561588);
        this.f14910g.m18774a(this.f14912i, -1);
        this.f14910g.m18775a(this.f14912i, null);
    }

    public static void m18767a(EditGalleryExpirationController editGalleryExpirationController, View view, View view2, double d) {
        float dimension = editGalleryExpirationController.f14909f.getResources().getDimension(2131431921);
        int width = view2.getWidth();
        int height = view2.getHeight();
        int left = view.getLeft();
        int top = view.getTop() - editGalleryExpirationController.f14912i.getHeight();
        if (view2.getWidth() > view2.getHeight()) {
            left = (int) (((double) left) + (((double) (((float) (view2.getLeft() + ((width - height) / 2))) + dimension)) + (((double) height) * d)));
            width = left;
            left = (int) ((((double) (((float) (view2.getTop() + height)) - dimension)) - (((double) height) * d)) + ((double) top));
        } else {
            left = (int) (((double) left) + (((double) (((float) view2.getLeft()) + dimension)) + (((double) width) * d)));
            int top2 = (int) ((((double) (((float) (((height - width) / 2) + (view2.getTop() + width))) - dimension)) - (((double) width) * d)) + ((double) top));
            width = left;
            left = top2;
        }
        LayoutParams layoutParams = (LayoutParams) editGalleryExpirationController.f14912i.getLayoutParams();
        layoutParams.setMargins(width, left, 0, 0);
        editGalleryExpirationController.f14912i.setLayoutParams(layoutParams);
    }
}
