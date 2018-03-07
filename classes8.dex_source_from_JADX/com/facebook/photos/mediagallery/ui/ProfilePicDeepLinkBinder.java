package com.facebook.photos.mediagallery.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.base.fragment.FbFragment;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.photos.galleryutil.GalleryDeepLinkBinder;
import com.facebook.photos.galleryutil.GalleryDeepLinkBinder.DeepLinkBinderConfig;
import com.facebook.photos.galleryutil.MediaGalleryDeepLinkViewGroup;
import com.facebook.photos.mediagallery.MediaMetadataHelper;
import com.facebook.photos.mediagallery.ui.widget.MediaGalleryIntentFactory;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.inject.Inject;

/* compiled from: sms_auto_confirm_success */
public class ProfilePicDeepLinkBinder extends GalleryDeepLinkBinder implements OnClickListener {
    private final MediaGalleryIntentFactory f2433a;
    private final SecureContextHelper f2434b;
    private final GlyphColorizer f2435c;
    private final MediaMetadataHelper f2436d;
    private final QeAccessor f2437e;
    private MediaMetadata f2438f;
    private FbFragment f2439g;

    public static ProfilePicDeepLinkBinder m2562b(InjectorLike injectorLike) {
        return new ProfilePicDeepLinkBinder(MediaGalleryIntentFactory.m2791b(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), GlyphColorizer.a(injectorLike), MediaMetadataHelper.b(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ProfilePicDeepLinkBinder(MediaGalleryIntentFactory mediaGalleryIntentFactory, SecureContextHelper secureContextHelper, GlyphColorizer glyphColorizer, MediaMetadataHelper mediaMetadataHelper, QeAccessor qeAccessor) {
        this.f2433a = mediaGalleryIntentFactory;
        this.f2434b = secureContextHelper;
        this.f2435c = glyphColorizer;
        this.f2436d = mediaMetadataHelper;
        this.f2437e = qeAccessor;
    }

    public final boolean m2563a(MediaMetadata mediaMetadata, MediaGalleryDeepLinkViewGroup mediaGalleryDeepLinkViewGroup, FbFragment fbFragment, DeepLinkBinderConfig deepLinkBinderConfig) {
        this.f2438f = mediaMetadata;
        this.f2439g = fbFragment;
        if (!this.f2438f.s() || !MediaMetadataHelper.a(this.f2438f)) {
            return false;
        }
        mediaGalleryDeepLinkViewGroup.setAppIconDrawable(this.f2435c.a(2130839888, -1));
        mediaGalleryDeepLinkViewGroup.setText(2131235654);
        mediaGalleryDeepLinkViewGroup.setOnClickListener(this);
        return true;
    }

    public final void m2564b() {
        this.f2438f = null;
        this.f2439g = null;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1921600736);
        if (this.f2438f.s() && MediaMetadataHelper.a(this.f2438f)) {
            Intent b;
            if (this.f2437e.a(ExperimentsForTimelineAbTestModule.o, false)) {
                b = this.f2433a.m2793b(this.f2438f);
            } else {
                b = this.f2433a.m2792a(this.f2438f);
            }
            this.f2434b.a(b, 5001, this.f2439g);
            LogUtils.a(1820952483, a);
            return;
        }
        Logger.a(2, EntryType.UI_INPUT_END, 101225449, a);
    }
}
