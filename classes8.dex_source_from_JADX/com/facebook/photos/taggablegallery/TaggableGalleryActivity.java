package com.facebook.photos.taggablegallery;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.ipc.media.MediaIdKey;
import com.facebook.photos.base.media.PhotoItem;
import com.facebook.photos.base.tagging.FaceBox;
import com.facebook.photos.creativeediting.model.CreativeEditingData;
import com.facebook.photos.taggablegallery.TaggableGalleryConstants.Source;
import com.facebook.photos.taggablegallery.TaggablePhotoGalleryFragment.NavigationEventListener;
import java.util.ArrayList;

/* compiled from: selected_text */
public class TaggableGalleryActivity extends FbFragmentActivity {
    private TaggablePhotoGalleryFragment f3420p;
    private ArrayList<PhotoItem> f3421q;
    private ArrayList<CreativeEditingData> f3422r;

    /* compiled from: selected_text */
    class C04351 implements NavigationEventListener {
        final /* synthetic */ TaggableGalleryActivity f3419a;

        C04351(TaggableGalleryActivity taggableGalleryActivity) {
            this.f3419a = taggableGalleryActivity;
        }

        public final void mo141a(PhotoItem photoItem, boolean z) {
            this.f3419a.finish();
        }
    }

    public final void m3387b(Bundle bundle) {
        TaggableGalleryPhotoSource taggableGalleryPhotoSourceListImp;
        super.b(bundle);
        setContentView(2130907103);
        Intent intent = getIntent();
        this.f3421q = intent.getParcelableArrayListExtra("extra_taggable_gallery_photo_list");
        if (intent.hasExtra("extras_taggable_gallery_creative_editing_data_list")) {
            this.f3422r = intent.getParcelableArrayListExtra("extras_taggable_gallery_creative_editing_data_list");
            taggableGalleryPhotoSourceListImp = new TaggableGalleryPhotoSourceListImp(this.f3421q, this.f3422r);
        } else {
            taggableGalleryPhotoSourceListImp = new TaggableGalleryPhotoSourceListImp(this.f3421q);
        }
        MediaIdKey mediaIdKey = (MediaIdKey) intent.getParcelableExtra("extra_taggable_gallery_photo_item_id");
        FaceBox faceBox = (FaceBox) intent.getParcelableExtra("extra_taggable_gallery_goto_facebox");
        this.f3420p = m3386i();
        this.f3420p.m3424a(taggableGalleryPhotoSourceListImp, this.f3422r, mediaIdKey, true, new C04351(this), Source.COMPOSER, intent.getStringExtra("extra_session_id"), faceBox, intent.getExtras().getInt("extra_media_container_type", 0), intent.getExtras().getString("extra_media_container_id"));
    }

    public void onBackPressed() {
        if (!this.f3420p.m3425b()) {
            super.onBackPressed();
        }
    }

    public void finish() {
        boolean z;
        if (this.f3420p == null || !this.f3420p.az) {
            z = false;
        } else {
            z = true;
        }
        Intent putExtra = new Intent().putExtra("extra_photo_items_list", this.f3421q).putExtra("extra_are_media_items_modified", z);
        if (!(this.f3422r == null || this.f3422r.isEmpty())) {
            ArrayList arrayList;
            String str = "extras_taggable_gallery_creative_editing_data_list";
            TaggablePhotoGalleryFragment taggablePhotoGalleryFragment = this.f3420p;
            if (taggablePhotoGalleryFragment.aS != null) {
                arrayList = new ArrayList(taggablePhotoGalleryFragment.aS);
            } else {
                arrayList = null;
            }
            putExtra.putParcelableArrayListExtra(str, arrayList);
        }
        setResult(-1, putExtra);
        super.finish();
    }

    private TaggablePhotoGalleryFragment m3386i() {
        TaggablePhotoGalleryFragment taggablePhotoGalleryFragment = (TaggablePhotoGalleryFragment) kO_().a(2131558429);
        if (taggablePhotoGalleryFragment != null) {
            return taggablePhotoGalleryFragment;
        }
        taggablePhotoGalleryFragment = new TaggablePhotoGalleryFragment();
        kO_().a().a(2131558429, taggablePhotoGalleryFragment).b();
        return taggablePhotoGalleryFragment;
    }
}
