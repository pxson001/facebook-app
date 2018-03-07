package com.facebook.pages.identity.cards.photos;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.feed.hscroll.FeedRecyclablePagerAdapter;
import com.facebook.graphql.model.GraphQLPhoto;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.mediagallery.MediaGalleryLauncherParamsFactory;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncher;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncherParams.Builder;
import com.facebook.photos.mediagallery.launcher.animation.AnimationParamProvider;
import com.facebook.photos.mediagallery.launcher.animation.AnimationParams;
import com.facebook.ui.recyclablepager.PagerViewType;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: privacy_checkup_app_delete_dialog_delete_app_only */
public class PageIdentityPhotoGalleryAdapter extends FeedRecyclablePagerAdapter<GraphQLPhoto> {
    private static final CallerContext f3561a = CallerContext.a(PageIdentityPhotoGalleryAdapter.class, "page_photos_by_friends");
    private static final CallerContext f3562b = CallerContext.b(PageIdentityPhotoGalleryAdapter.class, "privacy");
    private static final PagerViewType f3563c = new C04841();
    public final Context f3564d;
    private final Provider<TimeFormatUtil> f3565e;
    public final MediaGalleryLauncher f3566f;
    public final MediaGalleryLauncherParamsFactory f3567g;

    /* compiled from: privacy_checkup_app_delete_dialog_delete_app_only */
    final class C04841 implements PagerViewType {
        C04841() {
        }

        public final Class m4619a() {
            return PageIdentityPhotoGalleryItemView.class;
        }

        public final View m4618a(Context context) {
            return new PageIdentityPhotoGalleryItemView(context);
        }
    }

    protected final void m4622a(View view, Object obj, int i) {
        final GraphQLPhoto graphQLPhoto = (GraphQLPhoto) obj;
        final PageIdentityPhotoGalleryItemView pageIdentityPhotoGalleryItemView = (PageIdentityPhotoGalleryItemView) view;
        String str = null;
        if (graphQLPhoto != null) {
            if (graphQLPhoto.L() != null) {
                str = graphQLPhoto.L().b();
            } else if (graphQLPhoto.U() != null) {
                str = graphQLPhoto.U().b();
            } else if (graphQLPhoto.af() != null) {
                str = graphQLPhoto.af().b();
            } else if (graphQLPhoto.M() != null) {
                str = graphQLPhoto.M().b();
            } else if (graphQLPhoto.X() != null) {
                str = graphQLPhoto.X().b();
            } else if (graphQLPhoto.N() != null) {
                str = graphQLPhoto.N().b();
            }
        }
        String str2 = str;
        if (str2 == null) {
            pageIdentityPhotoGalleryItemView.setVisibility(8);
            return;
        }
        final ImageRequest a = ImageRequest.a(str2);
        pageIdentityPhotoGalleryItemView.a.a(Uri.parse(str2), f3561a);
        if (m4621a(graphQLPhoto)) {
            pageIdentityPhotoGalleryItemView.b.setVisibility(0);
            pageIdentityPhotoGalleryItemView.e.setVisibility(0);
            pageIdentityPhotoGalleryItemView.c.setText(graphQLPhoto.aB().aa());
            pageIdentityPhotoGalleryItemView.d.setText(((TimeFormatUtil) this.f3565e.get()).a(TimeFormatStyle.STREAM_RELATIVE_STYLE, graphQLPhoto.B() * 1000).toUpperCase(Locale.getDefault()));
            pageIdentityPhotoGalleryItemView.e.a(ImageUtil.a(graphQLPhoto.aN().m()), f3562b);
        }
        pageIdentityPhotoGalleryItemView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PageIdentityPhotoGalleryAdapter f3560d;

            /* compiled from: privacy_checkup_app_delete_dialog_delete_app_only */
            class C04851 implements AnimationParamProvider {
                final /* synthetic */ C04862 f3556a;

                C04851(C04862 c04862) {
                    this.f3556a = c04862;
                }

                public final AnimationParams m4620a(String str) {
                    return Objects.equal(str, graphQLPhoto.K()) ? AnimationParams.a(pageIdentityPhotoGalleryItemView.a, a) : null;
                }
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1973486925);
                MediaGalleryLauncherParamsFactory mediaGalleryLauncherParamsFactory = this.f3560d.f3567g;
                Builder a2 = MediaGalleryLauncherParamsFactory.b(ImmutableList.copyOf(this.f3560d.a)).a(FullscreenGallerySource.TIMELINE_PHOTO_ALBUMS).a(graphQLPhoto.K()).a(a);
                a2.m = true;
                this.f3560d.f3566f.a(this.f3560d.f3564d, a2.b(), new C04851(this));
                Logger.a(2, EntryType.UI_INPUT_END, -155930224, a);
            }
        });
    }

    @Inject
    public PageIdentityPhotoGalleryAdapter(Context context, Provider<TimeFormatUtil> provider, RecyclableViewPoolManager recyclableViewPoolManager, MediaGalleryLauncher mediaGalleryLauncher, MediaGalleryLauncherParamsFactory mediaGalleryLauncherParamsFactory) {
        super(recyclableViewPoolManager);
        this.f3564d = context;
        this.f3565e = provider;
        this.f3566f = mediaGalleryLauncher;
        this.f3567g = mediaGalleryLauncherParamsFactory;
    }

    protected final PagerViewType m4623d() {
        return f3563c;
    }

    private static boolean m4621a(GraphQLPhoto graphQLPhoto) {
        return (graphQLPhoto.aB() == null || graphQLPhoto.B() == 0 || graphQLPhoto.aN() == null) ? false : true;
    }
}
