package com.facebook.pages.common.reaction.ui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.FindViewUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.pages.common.reaction.components.PagePhotoAlbumsUnitComponentPartDefinition.Album;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.CustomViewUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: search_cancel */
public class PagePhotoAlbumsComponentView extends CustomLinearLayout {
    public static final CallerContext f2218a = CallerContext.a(PagePhotoAlbumsComponentView.class, "pages_public_view");
    public final List<PagePhotoAlbumComponentView> f2219b = new ArrayList();

    public PagePhotoAlbumsComponentView(Context context) {
        super(context);
        CustomViewUtils.b(this, new ColorDrawable(context.getResources().getColor(2131361920)));
        setOrientation(0);
        m3180c(3);
        setPadding(0, 0, 0, m3181d(2131429805));
    }

    public final void m3182a(List<Album> list) {
        if (list.size() != this.f2219b.size()) {
            throw new IllegalArgumentException("Albums count inconsistent between data and view");
        }
        for (int i = 0; i < list.size(); i++) {
            Album album = (Album) list.get(i);
            PagePhotoAlbumComponentView pagePhotoAlbumComponentView = (PagePhotoAlbumComponentView) this.f2219b.get(i);
            String str = album.f2010b;
            CharSequence charSequence = album.f2011c;
            CharSequence charSequence2 = album.f2012d;
            pagePhotoAlbumComponentView.f2215b.a(Uri.parse(str), PagePhotoAlbumComponentView.f2214a);
            pagePhotoAlbumComponentView.f2216c.setText(charSequence);
            pagePhotoAlbumComponentView.f2217d.setText(charSequence2);
            ((PagePhotoAlbumComponentView) this.f2219b.get(i)).setOnClickListener(album.f2013e);
        }
    }

    private void m3180c(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            int i3;
            PagePhotoAlbumComponentView pagePhotoAlbumComponentView = new PagePhotoAlbumComponentView(getContext());
            FbDraweeView fbDraweeView = (FbDraweeView) FindViewUtil.b(pagePhotoAlbumComponentView, 2131565634);
            fbDraweeView.setAspectRatio(1.25f);
            ((LayoutParams) fbDraweeView.getLayoutParams()).height = -2;
            if (i2 == 0) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (i3 != 0) {
                i3 = m3181d(2131429805);
            } else {
                i3 = 0;
            }
            int d = m3181d(2131429805);
            ViewGroup.LayoutParams layoutParams = new LayoutParams(0, -2, 1.0f);
            layoutParams.setMargins(i3, 0, d, 0);
            pagePhotoAlbumComponentView.setLayoutParams(layoutParams);
            this.f2219b.add(pagePhotoAlbumComponentView);
            addView(pagePhotoAlbumComponentView);
        }
    }

    private int m3181d(int i) {
        return getContext().getResources().getDimensionPixelSize(i);
    }
}
