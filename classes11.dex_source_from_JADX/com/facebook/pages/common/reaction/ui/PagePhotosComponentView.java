package com.facebook.pages.common.reaction.ui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Space;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.pages.common.reaction.components.PagePhotosUnitComponentPartDefinition.Photo;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.CustomViewUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: search_button_nux_completed */
public class PagePhotosComponentView extends CustomLinearLayout {
    public static final CallerContext f2221a = CallerContext.a(PagePhotosComponentView.class, "pages_public_view");
    private final LayoutInflater f2222b;
    public final List<FbDraweeView> f2223c = new ArrayList();

    /* compiled from: search_button_nux_completed */
    public enum PhotosLayout {
        UNSUPPORTED,
        ONE_BIG_SIDE_SMALL_GRID,
        HORIZONTAL;

        public static PhotosLayout fromPhotoCount(int i) {
            if (i == 3) {
                return ONE_BIG_SIDE_SMALL_GRID;
            }
            if (i <= 0 || i >= 3) {
                return UNSUPPORTED;
            }
            return HORIZONTAL;
        }
    }

    public PagePhotosComponentView(Context context) {
        super(context);
        CustomViewUtils.b(this, new ColorDrawable(context.getResources().getColor(2131361920)));
        this.f2222b = LayoutInflater.from(context);
        setOrientation(0);
    }

    public final void m3184a(List<Photo> list) {
        int i;
        switch (PhotosLayout.fromPhotoCount(list.size())) {
            case ONE_BIG_SIDE_SMALL_GRID:
                removeAllViews();
                this.f2223c.clear();
                this.f2222b.inflate(2130906076, this, true);
                FbDraweeView fbDraweeView = (FbDraweeView) a(2131565643);
                fbDraweeView.setAspectRatio(1.25f);
                LayoutParams layoutParams = (LayoutParams) fbDraweeView.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.weight = 2.0f;
                fbDraweeView.setLayoutParams(layoutParams);
                fbDraweeView.a(Uri.parse(((Photo) list.get(0)).f2029b), f2221a);
                fbDraweeView.setOnClickListener(((Photo) list.get(0)).f2031d);
                this.f2223c.add(fbDraweeView);
                LinearLayout linearLayout = (LinearLayout) a(2131565644);
                linearLayout.removeAllViews();
                layoutParams = (LayoutParams) linearLayout.getLayoutParams();
                layoutParams.weight = 1.0f;
                linearLayout.setLayoutParams(layoutParams);
                for (int i2 = 1; i2 < list.size(); i2++) {
                    boolean z;
                    FbDraweeView fbDraweeView2 = new FbDraweeView(getContext());
                    ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-1, 0, 1.0f);
                    if (i2 == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        i = 0;
                    } else {
                        i = m3183c(2131429806);
                    }
                    layoutParams2.setMargins(0, i, 0, 0);
                    fbDraweeView2.setLayoutParams(layoutParams2);
                    fbDraweeView2.a(Uri.parse(((Photo) list.get(i2)).f2030c), f2221a);
                    fbDraweeView2.setOnClickListener(((Photo) list.get(i2)).f2031d);
                    this.f2223c.add(fbDraweeView2);
                    linearLayout.addView(fbDraweeView2);
                }
                return;
            case HORIZONTAL:
                int i3;
                removeAllViews();
                this.f2223c.clear();
                for (i = 0; i < list.size(); i++) {
                    boolean z2;
                    FbDraweeView fbDraweeView3 = new FbDraweeView(getContext());
                    fbDraweeView3.setAspectRatio(1.25f);
                    ViewGroup.LayoutParams layoutParams3 = new LayoutParams(0, -2, 1.0f);
                    if (i == 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        i3 = 0;
                    } else {
                        i3 = m3183c(2131429806);
                    }
                    layoutParams3.setMargins(i3, 0, 0, 0);
                    fbDraweeView3.setLayoutParams(layoutParams3);
                    fbDraweeView3.a(Uri.parse(((Photo) list.get(i)).f2030c), f2221a);
                    fbDraweeView3.setOnClickListener(((Photo) list.get(i)).f2031d);
                    this.f2223c.add(fbDraweeView3);
                    addView(fbDraweeView3);
                }
                i = 3 - list.size();
                for (i3 = 0; i3 < i; i3++) {
                    View space = new Space(getContext());
                    ViewGroup.LayoutParams layoutParams4 = new LayoutParams(0, -1, 1.0f);
                    layoutParams4.setMargins(m3183c(2131429806), 0, 0, 0);
                    space.setLayoutParams(layoutParams4);
                    addView(space);
                }
                return;
            default:
                throw new IllegalArgumentException("Unsupported photo count: " + list.size());
        }
    }

    private int m3183c(int i) {
        return getContext().getResources().getDimensionPixelSize(i);
    }
}
