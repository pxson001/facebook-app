package com.facebook.photos.tagging.ui;

import android.content.Context;
import android.graphics.RectF;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.facebook.inject.FbInjector;
import com.facebook.photos.base.tagging.Tag;
import com.facebook.photos.tagging.shared.layout.TagWithFacebox;
import com.facebook.photos.tagging.shared.layout.TagsViewLayoutHelper;
import com.facebook.photos.tagging.shared.layout.TagsViewLayoutHelperProvider;
import com.facebook.photos.tagging.ui.TagView.TagViewListener;
import com.facebook.photos.tagging.ui.TaggablePhotoView.C09502;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.images.zoomableimageview.ZoomableImageView;
import com.google.common.collect.Maps;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: intern_settings */
public class TagsView extends CustomFrameLayout {
    @Inject
    public TagsViewLayoutHelperProvider f11012a;
    public final float f11013b;
    public ZoomableImageView f11014c;
    public boolean f11015d;
    public Map<TagView, TagWithFacebox> f11016e = Maps.c();
    public TagView f11017f;
    public C09502 f11018g;
    public TagsViewLayoutHelper f11019h;

    /* compiled from: intern_settings */
    public class C09602 implements TagViewListener {
        final /* synthetic */ TagsView f11009a;

        public C09602(TagsView tagsView) {
            this.f11009a = tagsView;
        }

        public final void mo615a(Tag tag) {
            this.f11009a.m13007a(tag);
            this.f11009a.f11018g.m12958b(tag);
        }
    }

    /* compiled from: intern_settings */
    public class C09613 implements Runnable {
        final /* synthetic */ boolean f11010a;
        final /* synthetic */ TagsView f11011b;

        public C09613(TagsView tagsView, boolean z) {
            this.f11011b = tagsView;
            this.f11010a = z;
        }

        public void run() {
            this.f11011b.f11019h.a(this.f11011b.f11014c, this.f11010a);
            for (TagView tagView : this.f11011b.f11016e.keySet()) {
                tagView.setVisibility(0);
                if (tagView.f10934e.e) {
                    tagView.m12954a(false);
                }
            }
        }
    }

    public static void m13005a(Object obj, Context context) {
        ((TagsView) obj).f11012a = (TagsViewLayoutHelperProvider) FbInjector.get(context).getOnDemandAssistedProviderForStaticDi(TagsViewLayoutHelperProvider.class);
    }

    public TagsView(Context context, ZoomableImageView zoomableImageView) {
        super(context, null);
        this.f11014c = zoomableImageView;
        this.f11013b = getResources().getDimension(2131430313) + getResources().getDimension(2131430312);
        Class cls = TagsView.class;
        m13005a((Object) this, getContext());
        this.f11019h = this.f11012a.a(this, getResources().getDimension(2131430317));
    }

    public void setFaceBoxRects(@Nullable List<RectF> list) {
        if (list == null) {
            this.f11019h.a(Collections.EMPTY_LIST);
        } else {
            this.f11019h.a(list);
        }
    }

    public final void m13008a(@Nullable List<Tag> list, boolean z) {
        if (list == null) {
            list = Collections.EMPTY_LIST;
        }
        this.f11015d = z;
        removeAllViews();
        this.f11016e.clear();
        for (final Tag tag : r13) {
            final TagView tagView = new TagView(getContext(), tag, this.f11015d);
            tagView.setOnTouchListener(new ZoomableFriendlyOnTouchListener(getContext(), this.f11014c, new Object(this) {
                public final /* synthetic */ TagsView f11008c;
            }));
            tagView.f10939j = new C09602(this);
            LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 1;
            tagView.setVisibility(4);
            addView(tagView, layoutParams);
            this.f11016e.put(tagView, new TagWithFacebox(tag.a.e(), tag.a.d()));
        }
        this.f11019h.a(this.f11016e);
    }

    public final void m13006a() {
        if (this.f11017f != null) {
            if (!this.f11017f.f10934e.e) {
                this.f11017f.m12956e();
            }
            this.f11017f = null;
        }
    }

    public final void m13009a(boolean z) {
        this.f11019h.a(this.f11014c, z);
    }

    public final void m13007a(Tag tag) {
        if (this.f11017f != null && this.f11017f.f10934e == tag) {
            this.f11017f = null;
        }
        for (TagView tagView : this.f11016e.keySet()) {
            if (tagView.f10934e == tag) {
                removeView(tagView);
                this.f11016e.remove(tag);
                this.f11019h.a(this.f11016e);
                return;
            }
        }
    }
}
