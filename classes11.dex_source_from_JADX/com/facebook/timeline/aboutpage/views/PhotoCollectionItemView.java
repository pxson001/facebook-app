package com.facebook.timeline.aboutpage.views;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.graphql.enums.GraphQLTimelineAppSectionType;
import com.facebook.graphql.linkutil.GraphQLLinkExtractor;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.mediagallery.MediaGalleryLauncherParamsFactory;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncher;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncherParams.Builder;
import com.facebook.profile.api.ProfileViewerContext;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.AppCollectionItemModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.CollectionsAppSectionRequestableFieldModel;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: Ljava/lang/ref/WeakReference */
public class PhotoCollectionItemView extends CustomFrameLayout implements ICollectionItemView {
    private static final CallerContext f13888d = CallerContext.a(PhotoCollectionItemView.class, "collections_collection");
    @Inject
    GraphQLLinkExtractor f13889a;
    @Inject
    Provider<FbDraweeControllerBuilder> f13890b;
    @Inject
    Provider<MediaGalleryLauncher> f13891c;
    private FbDraweeView f13892e;
    private final OnClickListener f13893f = new C16161(this);

    /* compiled from: Ljava/lang/ref/WeakReference */
    class C16161 implements OnClickListener {
        final /* synthetic */ PhotoCollectionItemView f13887a;

        C16161(PhotoCollectionItemView photoCollectionItemView) {
            this.f13887a = photoCollectionItemView;
        }

        public void onClick(View view) {
            String obj;
            Builder a;
            int a2 = Logger.a(2, EntryType.UI_INPUT_START, -1447481416);
            AppCollectionItemModel appCollectionItemModel = (AppCollectionItemModel) view.getTag();
            Uri parse = Uri.parse(CollectionsViewFactory.m14941a(appCollectionItemModel, this.f13887a.f13889a));
            String g = appCollectionItemModel.nH_().m14374g();
            ViewParent parent = this.f13887a.getParent();
            if (parent != null) {
                TableCollectionView tableCollectionView = (TableCollectionView) parent.getParent();
                if (tableCollectionView != null) {
                    Object tag = tableCollectionView.getTag(2131558841);
                    if (tag != null) {
                        obj = tag.toString();
                        if (obj == null) {
                            a = MediaGalleryLauncherParamsFactory.a(obj);
                        } else {
                            a = MediaGalleryLauncherParamsFactory.f(ImmutableList.of(g));
                        }
                        ((MediaGalleryLauncher) this.f13887a.f13891c.get()).a(this.f13887a.getContext(), a.a(FullscreenGallerySource.TIMELINE_PHOTOS_ABOUT_TAB).a(g).a(ImageRequest.a(parse)).b(), null);
                        LogUtils.a(-1316888203, a2);
                    }
                }
            }
            obj = null;
            if (obj == null) {
                a = MediaGalleryLauncherParamsFactory.f(ImmutableList.of(g));
            } else {
                a = MediaGalleryLauncherParamsFactory.a(obj);
            }
            ((MediaGalleryLauncher) this.f13887a.f13891c.get()).a(this.f13887a.getContext(), a.a(FullscreenGallerySource.TIMELINE_PHOTOS_ABOUT_TAB).a(g).a(ImageRequest.a(parse)).b(), null);
            LogUtils.a(-1316888203, a2);
        }
    }

    private static <T extends View> void m15024a(Class<T> cls, T t) {
        m15025a((Object) t, t.getContext());
    }

    private static void m15025a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PhotoCollectionItemView) obj).m15023a(GraphQLLinkExtractor.a(fbInjector), IdBasedProvider.a(fbInjector, 1117), IdBasedProvider.a(fbInjector, 9351));
    }

    protected void onFinishInflate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1540321622);
        super.onFinishInflate();
        this.f13892e = (FbDraweeView) c(2131560383);
        FbDraweeView fbDraweeView = this.f13892e;
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(getResources());
        genericDraweeHierarchyBuilder.f = new ColorDrawable(getResources().getColor(2131362148));
        fbDraweeView.setHierarchy(genericDraweeHierarchyBuilder.u());
        this.f13892e.setAspectRatio(1.0f);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 35582642, a);
    }

    public PhotoCollectionItemView(Context context) {
        super(context);
        m15022a();
    }

    public PhotoCollectionItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m15022a();
    }

    private void m15022a() {
        m15024a(PhotoCollectionItemView.class, (View) this);
    }

    public final void mo424a(AppCollectionItemModel appCollectionItemModel) {
        Uri uri;
        if (appCollectionItemModel.m14298k() == null || appCollectionItemModel.m14298k().b() == null) {
            setVisibility(8);
            uri = null;
        } else {
            Uri parse = Uri.parse(appCollectionItemModel.m14298k().b());
            setVisibility(0);
            setTag(appCollectionItemModel);
            setOnClickListener(this.f13893f);
            uri = parse;
        }
        this.f13892e.setController(((FbDraweeControllerBuilder) this.f13890b.get()).a(f13888d).b(uri).s());
    }

    public final void mo425a(CollectionsAppSectionRequestableFieldModel collectionsAppSectionRequestableFieldModel, ProfileViewerContext profileViewerContext, GraphQLTimelineAppSectionType graphQLTimelineAppSectionType) {
    }

    private void m15023a(GraphQLLinkExtractor graphQLLinkExtractor, Provider<FbDraweeControllerBuilder> provider, Provider<MediaGalleryLauncher> provider2) {
        this.f13889a = graphQLLinkExtractor;
        this.f13890b = provider;
        this.f13891c = provider2;
    }
}
