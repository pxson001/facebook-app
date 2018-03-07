package com.facebook.katana.activity.media.photoset;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.ipc.profile.TimelinePhotoTabModeParams;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.photoset.controllers.PhotoSetOnActivityResultController;
import com.facebook.photos.photoset.ui.photoset.PhotoSetGridFragment;
import com.facebook.widget.titlebar.FbTitleBar;

/* compiled from: {page_set_id NOT_SET} */
public class PhotoSetActivity extends FbFragmentActivity implements AnalyticsActivity {
    private static final CallerContext f11p = CallerContext.a(PhotoSetActivity.class, "photos_album");
    private PhotoSetOnActivityResultController f12q;
    private String f13r;
    private GraphQLAlbum f14s;
    private TimelinePhotoTabModeParams f15t;
    private FullscreenGallerySource f16u;

    /* compiled from: {page_set_id NOT_SET} */
    class C00001 implements OnClickListener {
        final /* synthetic */ PhotoSetActivity f10a;

        C00001(PhotoSetActivity photoSetActivity) {
            this.f10a = photoSetActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1325454534);
            this.f10a.onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, -314200635, a);
        }
    }

    protected final void m29b(Bundle bundle) {
        super.b(bundle);
        setContentView(2130906226);
        this.f12q = PhotoSetOnActivityResultController.b(hz_());
        Intent intent = getIntent();
        this.f13r = intent.getStringExtra("set_token");
        this.f16u = intent.hasExtra("fullscreen_gallery_source") ? FullscreenGallerySource.valueOf(intent.getStringExtra("fullscreen_gallery_source")) : FullscreenGallerySource.UNKNOWN;
        this.f15t = (TimelinePhotoTabModeParams) intent.getParcelableExtra("extra_photo_tab_mode_params");
        this.f14s = (GraphQLAlbum) FlatBufferModelHelper.a(intent, "extra_album_selected");
        m28i();
        FbTitleBar fbTitleBar = (FbTitleBar) a(2131558563);
        fbTitleBar.setTitle(getString(2131236735));
        fbTitleBar.setHasBackButton(false);
        fbTitleBar.a(new C00001(this));
    }

    private void m28i() {
        Bundle bundle = new Bundle();
        bundle.putString("set_token", this.f13r);
        bundle.putString("fullscreen_gallery_source", this.f16u.name());
        bundle.putParcelable("extra_photo_tab_mode_params", this.f15t);
        bundle.putString("photo_set_grid_source", "source_photo_album");
        if (this.f14s != null) {
            FlatBufferModelHelper.a(bundle, "extra_album_selected", this.f14s);
        }
        bundle.putParcelable("extra_caller_context", f11p);
        PhotoSetGridFragment photoSetGridFragment = new PhotoSetGridFragment();
        photoSetGridFragment.g(bundle);
        FragmentManager kO_ = kO_();
        FragmentTransaction a = kO_.a();
        a.a(2131558429, photoSetGridFragment);
        a.b();
        kO_.b();
    }

    public final String am_() {
        return f11p.c();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.f12q.a(this, i, i2, intent);
    }
}
