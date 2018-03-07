package com.facebook.heisman;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.util.ContextUtils;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.graphql.enums.GraphQLProfilePictureActionLinkType;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.heisman.abtest.ExperimentsForProfilePictureOverlayAbTestModule;
import com.facebook.heisman.intent.ProfilePictureOverlayCameraIntentData.Builder;
import com.facebook.heisman.swipeable.ImageOverlayValidator;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.data.protocol.PhotosMetadataConversionHelper;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.photos.galleryutil.GalleryDeepLinkBinder;
import com.facebook.photos.galleryutil.GalleryDeepLinkBinder.DeepLinkBinderConfig;
import com.facebook.photos.galleryutil.MediaGalleryDeepLinkViewGroup;
import com.facebook.qe.api.QeAccessor;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: v1 */
public class ProfilePictureOverlayDeepLinkBinder extends GalleryDeepLinkBinder implements OnClickListener {
    private final GlyphColorizer f718a;
    private final Provider<ProfilePictureOverlayActivityLauncher> f719b;
    private final QeAccessor f720c;
    private MediaMetadata f721d;

    @Inject
    public ProfilePictureOverlayDeepLinkBinder(GlyphColorizer glyphColorizer, Provider<ProfilePictureOverlayActivityLauncher> provider, QeAccessor qeAccessor) {
        this.f718a = glyphColorizer;
        this.f719b = provider;
        this.f720c = qeAccessor;
    }

    public final boolean m779a(MediaMetadata mediaMetadata, MediaGalleryDeepLinkViewGroup mediaGalleryDeepLinkViewGroup, FbFragment fbFragment, DeepLinkBinderConfig deepLinkBinderConfig) {
        this.f721d = mediaMetadata;
        GraphQLStory c = m778c();
        if (!this.f720c.a(ExperimentsForProfilePictureOverlayAbTestModule.b, false) || c == null || !m777a(c)) {
            return false;
        }
        mediaGalleryDeepLinkViewGroup.setAppIconDrawable(this.f718a.a(2130839749, -1));
        mediaGalleryDeepLinkViewGroup.setText(2131238441);
        mediaGalleryDeepLinkViewGroup.setOnClickListener(this);
        return true;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 704520610);
        GraphQLStory c = m778c();
        if (c == null || !m777a(c)) {
            Logger.a(2, EntryType.UI_INPUT_END, 1178784217, a);
            return;
        }
        Activity activity = (Activity) ContextUtils.a(view.getContext(), Activity.class);
        if (activity != null) {
            GraphQLStoryAttachment o = StoryAttachmentHelper.o(c);
            ((ProfilePictureOverlayActivityLauncher) this.f719b.get()).m650a(activity, 8371, ((Builder) ((Builder) ((Builder) ((Builder) new Builder(this.f721d.S(), SafeUUIDGenerator.a().toString(), "snowlift").a(this.f721d.d())).b(o.B())).a(0)).a(ActionLinkHelper.a(o).s())).a());
        }
        LogUtils.a(1946003970, a);
    }

    private GraphQLStory m778c() {
        if (this.f721d == null || this.f721d.z() == null) {
            return null;
        }
        return PhotosMetadataConversionHelper.a(this.f721d.z());
    }

    private boolean m777a(GraphQLStory graphQLStory) {
        return (this.f721d == null || !ImageOverlayValidator.b(this.f721d.S()) || graphQLStory == null || StoryAttachmentHelper.o(graphQLStory) == null || ActionLinkHelper.a(StoryAttachmentHelper.o(graphQLStory)) == null || ActionLinkHelper.a(StoryAttachmentHelper.o(graphQLStory)).j() == GraphQLProfilePictureActionLinkType.BIRTHDAY_WISHES) ? false : true;
    }
}
