package com.facebook.platform.composer.composer;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import com.facebook.common.util.TriState;
import com.facebook.composer.activity.ComposerFragment.62;
import com.facebook.composer.ui.underwood.UnderwoodController;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.photos.base.media.PhotoItem;
import com.facebook.platform.composer.composer.PlatformComposerFragment.C05328;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.ScrollingAwareScrollView;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: rich_document_fragment_starts */
public class PlatformComposerPhotoReelController {
    public final Lazy<UnderwoodController> f4124a;
    public final View f4125b;

    @Inject
    public PlatformComposerPhotoReelController(@Assisted ViewStub viewStub, Lazy<UnderwoodController> lazy) {
        this.f4124a = lazy;
        viewStub.setLayoutResource(2130906309);
        this.f4125b = viewStub.inflate();
    }

    public final void m4091a(ScrollingAwareScrollView scrollingAwareScrollView, ViewGroup viewGroup, boolean z, boolean z2, 62 62, C05328 c05328) {
        ((UnderwoodController) this.f4124a.get()).a(viewGroup, scrollingAwareScrollView, (LinearLayout) scrollingAwareScrollView.findViewById(2131560638), z, z2, c05328);
        scrollingAwareScrollView.setDescendantFocusability(262144);
        ((UnderwoodController) this.f4124a.get()).L = 62;
        CustomViewUtils.b(this.f4125b, null);
    }

    public final void m4092a(ImmutableList<PhotoItem> immutableList) {
        m4090a(immutableList, TriState.UNSET);
    }

    public final void m4094b(ImmutableList<PhotoItem> immutableList) {
        m4090a(immutableList, TriState.NO);
    }

    private void m4090a(ImmutableList<PhotoItem> immutableList, TriState triState) {
        ((UnderwoodController) this.f4124a.get()).a(immutableList, triState);
    }

    public final void m4093b() {
        UnderwoodController underwoodController = (UnderwoodController) this.f4124a.get();
        underwoodController.b(false);
        underwoodController.i();
    }
}
