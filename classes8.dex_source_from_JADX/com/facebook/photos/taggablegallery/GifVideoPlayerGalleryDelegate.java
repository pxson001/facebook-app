package com.facebook.photos.taggablegallery;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import javax.inject.Inject;

/* compiled from: send_user_request_key */
public class GifVideoPlayerGalleryDelegate implements VideoPlayerGalleryDelegate {
    private FbDraweeControllerBuilder f3391a;
    private FbDraweeView f3392b;
    private ViewGroup f3393c;

    @Inject
    public GifVideoPlayerGalleryDelegate(FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        this.f3391a = fbDraweeControllerBuilder;
    }

    public final View mo179a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(2130904594, viewGroup, false);
        this.f3392b = (FbDraweeView) inflate.findViewById(2131562545);
        this.f3393c = (ViewGroup) inflate;
        return inflate;
    }

    public final ViewGroup mo180a() {
        return this.f3393c;
    }

    public final void mo182b() {
    }

    public final void mo183c() {
    }

    public final void mo181a(Uri uri) {
        this.f3392b.setController(((FbDraweeControllerBuilder) this.f3391a.b(uri).a(CallerContext.a(getClass())).c(true)).s());
    }
}
