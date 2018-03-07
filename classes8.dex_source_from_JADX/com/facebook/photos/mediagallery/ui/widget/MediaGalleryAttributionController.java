package com.facebook.photos.mediagallery.ui.widget;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.graphql.model.GraphQLActorUtil;
import com.facebook.inject.Assisted;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.data.protocol.PhotosMetadataConversionHelper;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataOwnerModel;
import com.facebook.photos.mediagallery.util.MediaGalleryPrivacyUtil;
import com.facebook.resources.ui.FbTextView;
import com.facebook.timeline.intent.ModelBundle;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: single_tap_on_photo */
public class MediaGalleryAttributionController {
    @VisibleForTesting
    static final CallerContext f2628a = CallerContext.a(MediaGalleryAttributionController.class, "photo_gallery");
    private final FbTextView f2629b;
    private final FbTextView f2630c;
    private final FbDraweeView f2631d;
    private final TimeFormatUtil f2632e;
    private final MediaGalleryPrivacyUtil f2633f;
    public final Provider<IFeedIntentBuilder> f2634g;

    @Inject
    public MediaGalleryAttributionController(@Assisted FbTextView fbTextView, @Assisted FbTextView fbTextView2, @Assisted FbDraweeView fbDraweeView, TimeFormatUtil timeFormatUtil, MediaGalleryPrivacyUtil mediaGalleryPrivacyUtil, Provider<IFeedIntentBuilder> provider) {
        this.f2629b = fbTextView;
        this.f2630c = fbTextView2;
        this.f2631d = fbDraweeView;
        this.f2632e = timeFormatUtil;
        this.f2633f = mediaGalleryPrivacyUtil;
        this.f2634g = provider;
    }

    public final void m2719a(@Nullable MediaMetadata mediaMetadata, final MediaMetadata mediaMetadata2) {
        int i = mediaMetadata == null ? 1 : 0;
        String a = m2718a(mediaMetadata);
        CharSequence a2 = m2718a(mediaMetadata2);
        if (!(i == 0 && Objects.equal(a, a2))) {
            C03321 c03321;
            this.f2629b.setText(a2);
            FbTextView fbTextView = this.f2629b;
            if (mediaMetadata2 == null || mediaMetadata2.N() == null) {
                c03321 = null;
            } else {
                c03321 = new OnClickListener(this) {
                    final /* synthetic */ MediaGalleryAttributionController f2627b;

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, -1047879201);
                        MediaMetadataOwnerModel N = mediaMetadata2.N();
                        Bundle bundle;
                        if (N.b().g() == 2479791) {
                            bundle = new Bundle();
                            ModelBundle.b(bundle, String.valueOf(N.c()), N.d(), null);
                            ((IFeedIntentBuilder) this.f2627b.f2634g.get()).a(view.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.af, N.c()), bundle, null);
                        } else if (N.b().g() == 2645995) {
                            bundle = new Bundle();
                            ModelBundle.a(bundle, N.c(), null, N.d());
                            ((IFeedIntentBuilder) this.f2627b.f2634g.get()).a(view.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.aX, N.c()), bundle, null);
                        }
                        LogUtils.a(-1336915256, a);
                    }
                };
            }
            fbTextView.setOnClickListener(c03321);
        }
        if (!(i == 0 && mediaMetadata.y() == mediaMetadata2.y())) {
            this.f2630c.setText(mediaMetadata2.y() > 0 ? this.f2632e.a(TimeFormatStyle.STREAM_RELATIVE_STYLE, mediaMetadata2.y() * 1000).toUpperCase(Locale.getDefault()) : "");
        }
        a = MediaGalleryPrivacyUtil.b(mediaMetadata);
        String b = MediaGalleryPrivacyUtil.b(mediaMetadata2);
        if (i != 0 || !Objects.equal(a, b)) {
            if (b == null) {
                this.f2631d.a(null, f2628a);
                return;
            }
            this.f2631d.a(Uri.parse(b), f2628a);
            this.f2631d.setVisibility(0);
        }
    }

    @Nullable
    private static String m2718a(@Nullable MediaMetadata mediaMetadata) {
        if (mediaMetadata == null) {
            return null;
        }
        MediaMetadataOwnerModel N = mediaMetadata.N();
        if (N != null) {
            return GraphQLActorUtil.a(PhotosMetadataConversionHelper.a(N));
        }
        return null;
    }
}
