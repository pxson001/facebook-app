package com.facebook.messaging.media.mediapicker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.messaging.media.picking.MessengerVideoEditDialogFragment;
import com.facebook.messaging.media.picking.MessengerVideoEditDialogFragment.Listener;
import com.facebook.ui.media.attachments.MediaResource;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import javax.annotation.Nullable;

/* compiled from: mCardFirstSix */
public class MediaPickerActivity extends FbFragmentActivity {
    private final MediaPickerListener f11670p = new MediaPickerListener(this);
    private final VideoEditListener f11671q = new VideoEditListener(this);

    /* compiled from: mCardFirstSix */
    public class MediaPickerListener {
        final /* synthetic */ MediaPickerActivity f11668a;

        public MediaPickerListener(MediaPickerActivity mediaPickerActivity) {
            this.f11668a = mediaPickerActivity;
        }

        public final void m12327a(ImmutableList<MediaResource> immutableList) {
            ArrayList arrayList = new ArrayList(immutableList);
            Intent intent = new Intent();
            intent.putParcelableArrayListExtra("extra_media_items", arrayList);
            this.f11668a.setResult(-1, intent);
            this.f11668a.finish();
        }
    }

    /* compiled from: mCardFirstSix */
    class VideoEditListener implements Listener {
        final /* synthetic */ MediaPickerActivity f11669a;

        public VideoEditListener(MediaPickerActivity mediaPickerActivity) {
            this.f11669a = mediaPickerActivity;
        }

        public final void mo453a(MediaResource mediaResource) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(mediaResource);
            Intent intent = new Intent();
            intent.putParcelableArrayListExtra("extra_media_items", arrayList);
            this.f11669a.setResult(-1, intent);
            this.f11669a.finish();
        }

        public final void mo454b(MediaResource mediaResource) {
        }

        public final void mo452a() {
            this.f11669a.setResult(0);
        }
    }

    public static Intent m12334a(Context context, ArrayList<? extends Parcelable> arrayList, @Nullable MediaPickerEnvironment mediaPickerEnvironment) {
        Intent intent = new Intent(context, MediaPickerActivity.class);
        intent.putParcelableArrayListExtra("extra_selection", arrayList);
        if (mediaPickerEnvironment != null) {
            intent.putExtra("extra_environment", mediaPickerEnvironment);
        }
        return intent;
    }

    protected final void m12336b(Bundle bundle) {
        super.b(bundle);
        setContentView(2130905181);
        if (kO_().a("media-picker-fragment") == null) {
            MediaPickerFragment mediaPickerFragment = new MediaPickerFragment();
            mediaPickerFragment.g(getIntent().getExtras());
            kO_().a().a(2131558429, mediaPickerFragment, "media-picker-fragment").b();
        }
    }

    public final void m12335a(Fragment fragment) {
        super.a(fragment);
        if (fragment instanceof MediaPickerFragment) {
            ((MediaPickerFragment) fragment).aK = this.f11670p;
        } else if (fragment instanceof MessengerVideoEditDialogFragment) {
            ((MessengerVideoEditDialogFragment) fragment).av = this.f11671q;
        }
    }
}
