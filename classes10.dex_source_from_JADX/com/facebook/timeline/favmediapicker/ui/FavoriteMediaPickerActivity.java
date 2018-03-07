package com.facebook.timeline.favmediapicker.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.ipc.creativecam.CreativeCamResult;
import com.facebook.ipc.media.data.LocalMediaData.Builder;
import com.facebook.ipc.media.data.MediaData;
import com.facebook.ipc.media.data.MediaData.Type;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.base.media.MediaItemFactory.PhotoItemBuilder;
import com.facebook.photos.base.media.PhotoItem;
import com.facebook.photos.pandora.ui.PandoraMediaSetActivity;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import java.util.ArrayList;
import javax.annotation.Nullable;

/* compiled from: friends_nearby_search_section */
public class FavoriteMediaPickerActivity extends FbFragmentActivity {

    /* compiled from: friends_nearby_search_section */
    class C16081 implements OnClickListener {
        final /* synthetic */ FavoriteMediaPickerActivity f11116a;

        C16081(FavoriteMediaPickerActivity favoriteMediaPickerActivity) {
            this.f11116a = favoriteMediaPickerActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 134799284);
            this.f11116a.setResult(0);
            this.f11116a.finish();
            Logger.a(2, EntryType.UI_INPUT_END, 1625894442, a);
        }
    }

    protected final void m11276b(@Nullable Bundle bundle) {
        super.b(bundle);
        setContentView(2130904244);
        m11275i();
        if (bundle == null) {
            kO_().a().a(2131561740, new FavoriteMediaPickerFragment()).b();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 1:
                    setResult(-1, intent);
                    finish();
                    return;
                case 2:
                    setResult(-1, m11273a(((CreativeCamResult) intent.getParcelableExtra("creative_cam_result_extra")).b));
                    finish();
                    return;
                case 3:
                    setResult(-1, m11274b(intent.getExtras().getString(PandoraMediaSetActivity.p)));
                    finish();
                    return;
                default:
                    return;
            }
        }
    }

    private void m11275i() {
        FbTitleBarUtil.b(this);
        ((FbTitleBar) a(2131558563)).a(new C16081(this));
    }

    private static Intent m11273a(Uri uri) {
        Intent intent = new Intent();
        PhotoItemBuilder photoItemBuilder = new PhotoItemBuilder();
        photoItemBuilder.f = new Builder().a(new MediaData.Builder().a(uri.toString()).a(Type.Photo).a(uri).a()).a();
        PhotoItem a = photoItemBuilder.a();
        ArrayList arrayList = new ArrayList();
        arrayList.add(a);
        intent.putParcelableArrayListExtra("extra_media_items", arrayList);
        return intent;
    }

    private static Intent m11274b(String str) {
        Intent intent = new Intent();
        intent.putExtra("suggested_media_fb_id", str);
        return intent;
    }
}
