package com.facebook.photos.taggablegallery;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.util.FindViewUtil;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.base.analytics.TaggablePhotoGalleryFlowLogger;
import com.facebook.photos.base.media.VideoItem;
import com.facebook.photos.taggablegallery.TaggableGalleryConstants.Source;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.titlebar.Fb4aTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: selected_type */
public class ProductionVideoGalleryFragment extends FbFragment {
    public TaggablePhotoGalleryFlowLogger f3413a;
    private Source f3414b;
    private String f3415c;
    public VideoItem f3416d;
    private Uri f3417e;
    private VideoPlayerGalleryDelegate f3418f;

    /* compiled from: selected_type */
    class C04321 implements OnClickListener {
        final /* synthetic */ ProductionVideoGalleryFragment f3410a;

        C04321(ProductionVideoGalleryFragment productionVideoGalleryFragment) {
            this.f3410a = productionVideoGalleryFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -955311468);
            this.f3410a.ao().onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, 1128311732, a);
        }
    }

    /* compiled from: selected_type */
    public class C04332 extends OnToolbarButtonListener {
        final /* synthetic */ ProductionVideoGalleryFragment f3411a;

        public C04332(ProductionVideoGalleryFragment productionVideoGalleryFragment) {
            this.f3411a = productionVideoGalleryFragment;
        }

        public final void m3377a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            Activity ao = this.f3411a.ao();
            ao.setResult(-1, new Intent().putExtra("extra_video_item", this.f3411a.f3416d));
            ao.finish();
        }
    }

    public static void m3378a(Object obj, Context context) {
        ((ProductionVideoGalleryFragment) obj).f3413a = TaggablePhotoGalleryFlowLogger.b(FbInjector.get(context));
    }

    public final void m3384c(Bundle bundle) {
        super.c(bundle);
        Class cls = ProductionVideoGalleryFragment.class;
        m3378a(this, getContext());
    }

    public final void m3383a(Source source, String str, @Nullable VideoItem videoItem, Uri uri, VideoPlayerGalleryDelegate videoPlayerGalleryDelegate) {
        Preconditions.checkNotNull(source);
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(uri);
        this.f3414b = source;
        this.f3415c = str;
        this.f3416d = videoItem;
        this.f3417e = uri;
        this.f3418f = videoPlayerGalleryDelegate;
    }

    public final View m3382a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1597134416);
        this.f3413a.a = this.f3415c;
        this.f3413a.a();
        View a2 = this.f3418f.mo179a(layoutInflater, viewGroup);
        layoutInflater.inflate(2130904261, this.f3418f.mo180a());
        Fb4aTitleBar fb4aTitleBar = (Fb4aTitleBar) FindViewUtil.b(a2, 2131558563);
        fb4aTitleBar.a(new C04321(this));
        Builder a3 = TitleBarButtonSpec.a();
        if (this.f3414b == Source.COMPOSER) {
            i = 2131234399;
        } else {
            i = 2131234407;
        }
        a3.g = b(i);
        fb4aTitleBar.setButtonSpecs(ImmutableList.of(a3.a()));
        fb4aTitleBar.setOnToolbarButtonListener(new C04332(this));
        fb4aTitleBar.setTitle(b(this.f3414b == Source.COMPOSER ? 2131234410 : 2131234408));
        LogUtils.f(-1148408005, a);
        return a2;
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2085478991);
        super.mi_();
        this.f3418f.mo181a(this.f3417e);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -819483353, a);
    }

    public final void m3380H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -93943604);
        super.H();
        this.f3418f.mo183c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 270188497, a);
    }

    public final void m3379G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -699621138);
        super.G();
        this.f3418f.mo182b();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2116049831, a);
    }

    public final void m3381I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -442715369);
        switch (this.f3414b) {
            case SIMPLEPICKER:
                this.f3413a.b();
                break;
            case COMPOSER:
                this.f3413a.c();
                break;
        }
        super.I();
        LogUtils.f(-1870096297, a);
    }
}
