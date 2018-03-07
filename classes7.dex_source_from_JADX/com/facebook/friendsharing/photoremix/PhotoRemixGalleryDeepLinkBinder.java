package com.facebook.friendsharing.photoremix;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import com.facebook.base.fragment.FbFragment;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.feedback.ui.EditingGalleryFeedbackLauncher;
import com.facebook.friendsharing.photoremix.abtest.ExperimentsForPhotoRemixExperimentsModule;
import com.facebook.friendsharing.photoremix.utils.PhotoRemixCommentSource;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.inject.Lazy;
import com.facebook.ipc.editgallery.EntryPoint;
import com.facebook.photos.data.protocol.PhotosMetadataConversionHelper;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.SimpleMediaFeedbackModel;
import com.facebook.photos.galleryutil.GalleryDeepLinkBinder;
import com.facebook.photos.galleryutil.GalleryDeepLinkBinder.DeepLinkBinderConfig;
import com.facebook.photos.galleryutil.MediaGalleryDeepLinkViewGroup;
import com.facebook.qe.api.QeAccessor;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: Requires app restart to take effect */
public class PhotoRemixGalleryDeepLinkBinder extends GalleryDeepLinkBinder {
    private String f23986a;
    private GraphQLFeedback f23987b;
    private final Resources f23988c;
    private final Context f23989d;
    private final GlyphColorizer f23990e;
    private final Lazy<EditingGalleryFeedbackLauncher> f23991f;
    private final QeAccessor f23992g;

    @Inject
    public PhotoRemixGalleryDeepLinkBinder(QeAccessor qeAccessor, Resources resources, Context context, GlyphColorizer glyphColorizer, Lazy<EditingGalleryFeedbackLauncher> lazy) {
        this.f23992g = qeAccessor;
        this.f23988c = resources;
        this.f23989d = context;
        this.f23990e = glyphColorizer;
        this.f23991f = lazy;
    }

    public final boolean m26107a(MediaMetadata mediaMetadata, MediaGalleryDeepLinkViewGroup mediaGalleryDeepLinkViewGroup, FbFragment fbFragment, DeepLinkBinderConfig deepLinkBinderConfig) {
        if (!this.f23992g.a(ExperimentsForPhotoRemixExperimentsModule.f5368b, false)) {
            return false;
        }
        SimpleMediaFeedbackModel C = mediaMetadata.C();
        if (C == null) {
            return false;
        }
        GraphQLFeedback a = PhotosMetadataConversionHelper.a(C);
        String G = a.G();
        if (Strings.isNullOrEmpty(G)) {
            return false;
        }
        this.f23986a = G;
        this.f23987b = a;
        mediaGalleryDeepLinkViewGroup.setAppIconDrawable(this.f23990e.a(2130842629, -1));
        mediaGalleryDeepLinkViewGroup.setText(this.f23992g.a(ExperimentsForPhotoRemixExperimentsModule.f5369c, this.f23988c.getString(2131230853)));
        mediaGalleryDeepLinkViewGroup.setOnClickListener(((EditingGalleryFeedbackLauncher) this.f23991f.get()).m5033a(Uri.parse(G), a, EntryPoint.PHOTO_REMIX_MEDIA_GALLERY, PhotoRemixCommentSource.MEDIA_GALLERY));
        return true;
    }
}
