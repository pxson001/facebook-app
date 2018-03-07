package com.facebook.instantshopping.view.block.impl;

import android.content.Context;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.device.ScreenUtil;
import com.facebook.inject.FbInjector;
import com.facebook.instantshopping.logging.LoggingParams;
import com.facebook.instantshopping.utils.InstantShoppingTextUtils;
import com.facebook.richdocument.view.block.impl.ImageBlockViewImpl;
import com.facebook.richdocument.view.widget.media.MediaFrame;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

/* compiled from: STALE_DATA_NEEDS_FULL_SERVER_FETCH */
public class LinkableImageWithAnnotationBlockViewImpl extends LinkableImageBlockViewImpl {
    @Inject
    public InstantShoppingTextUtils f23818p;
    @Inject
    public ScreenUtil f23819q;
    public final BetterTextView f23820r;
    private final View f23821s;

    public static void m25107a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        LinkableImageWithAnnotationBlockViewImpl linkableImageWithAnnotationBlockViewImpl = (LinkableImageWithAnnotationBlockViewImpl) obj;
        InstantShoppingTextUtils b = InstantShoppingTextUtils.b(fbInjector);
        ScreenUtil a = ScreenUtil.a(fbInjector);
        linkableImageWithAnnotationBlockViewImpl.f23818p = b;
        linkableImageWithAnnotationBlockViewImpl.f23819q = a;
    }

    private LinkableImageWithAnnotationBlockViewImpl(View view, MediaFrame mediaFrame) {
        super(mediaFrame, view);
        Class cls = LinkableImageWithAnnotationBlockViewImpl.class;
        m25107a(this, getContext());
        this.f23821s = view;
        LayoutParams layoutParams = (LayoutParams) this.f23821s.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(-1, -2);
        }
        layoutParams.width = this.f23819q.c();
        this.f23821s.setLayoutParams(layoutParams);
        this.f23820r = (BetterTextView) view.findViewById(2131560867);
        this.f23820r.setVisibility(0);
    }

    public final View m25110g() {
        return this.f23821s;
    }

    public static ImageBlockViewImpl m25108c(View view) {
        return new LinkableImageWithAnnotationBlockViewImpl(view, (MediaFrame) ((ViewGroup) view).getChildAt(0));
    }

    public final void mo1032a(LoggingParams loggingParams) {
    }
}
