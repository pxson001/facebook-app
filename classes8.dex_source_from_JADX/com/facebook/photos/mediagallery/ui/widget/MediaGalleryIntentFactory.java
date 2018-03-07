package com.facebook.photos.mediagallery.ui.widget;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.editgallery.CropMode;
import com.facebook.ipc.editgallery.EditFeature;
import com.facebook.ipc.editgallery.EditGalleryIntentCreator;
import com.facebook.ipc.editgallery.EditGalleryLaunchConfiguration.Builder;
import com.facebook.ipc.editgallery.EntryPoint;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.stagingground.StagingGroundIntentFactory;
import com.facebook.timeline.stagingground.StagingGroundLaunchConfig;
import com.facebook.timeline.tempprofilepic.model.ExpirationState;
import javax.inject.Inject;

/* compiled from: single_category_transaction */
public class MediaGalleryIntentFactory {
    private final Context f2704a;
    private final AllCapsTransformationMethod f2705b;
    private final QeAccessor f2706c;

    public static MediaGalleryIntentFactory m2791b(InjectorLike injectorLike) {
        return new MediaGalleryIntentFactory((Context) injectorLike.getInstance(Context.class), AllCapsTransformationMethod.b(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public MediaGalleryIntentFactory(Context context, AllCapsTransformationMethod allCapsTransformationMethod, QeAccessor qeAccessor) {
        this.f2704a = context;
        this.f2705b = allCapsTransformationMethod;
        this.f2706c = qeAccessor;
    }

    public final Intent m2792a(MediaMetadata mediaMetadata) {
        Builder a = new Builder().a(Uri.parse(mediaMetadata.g().b()), mediaMetadata.d()).a(EditFeature.CROP).a(CropMode.ZOOM_CROP);
        a.f = true;
        a = a;
        a.h = false;
        a = a;
        a.i = this.f2705b.getTransformation(this.f2704a.getString(2131234496), null).toString();
        a = a;
        a.k = ExpirationState.b;
        return EditGalleryIntentCreator.a(this.f2704a, EntryPoint.PROFILE.name(), a.a());
    }

    public static MediaGalleryIntentFactory m2790a(InjectorLike injectorLike) {
        return m2791b(injectorLike);
    }

    public final Intent m2793b(MediaMetadata mediaMetadata) {
        StagingGroundLaunchConfig.Builder a = new StagingGroundLaunchConfig.Builder().a(Uri.parse(mediaMetadata.g().b()), mediaMetadata.d());
        a.d = EntryPoint.PROFILE.name();
        a = a;
        a.p = false;
        a = a;
        a.r = this.f2706c.a(ExperimentsForTimelineAbTestModule.k, false);
        a = a;
        a.s = this.f2706c.a(ExperimentsForTimelineAbTestModule.l, false);
        a = a;
        a.t = this.f2706c.a(ExperimentsForTimelineAbTestModule.h, false);
        return StagingGroundIntentFactory.a(this.f2704a, a.a(), new Builder().a(EditFeature.CROP).a(CropMode.ZOOM_CROP).a());
    }
}
