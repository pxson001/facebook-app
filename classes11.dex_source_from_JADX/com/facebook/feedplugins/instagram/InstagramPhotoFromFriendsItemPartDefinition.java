package com.facebook.feedplugins.instagram;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.NavigationLogger;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.common.ui.animation.LikeIconPopAnimationHelper;
import com.facebook.controller.mutation.RawLikeHelper;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbPipelineDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.DraweeView;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSwitcherPartDefinition.Controller;
import com.facebook.feed.thirdparty.instagram.InstagramEntryPoint;
import com.facebook.feed.thirdparty.instagram.InstagramUtils;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.graphql.model.InstagramPhotosFromFriendsPhoto;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinitionWithViewType;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.galleryutil.GalleryDeepLinkBinder.DeepLinkBinderConfig;
import com.facebook.photos.mediagallery.MediaGalleryLauncherParamsFactory;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncher;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncherParams.Builder;
import com.facebook.photos.mediagallery.ui.DefaultMediaGalleryLauncher;
import com.facebook.photos.photogallery.photoviewcontrollers.NestedViewPhotoViewController;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ufiservices.futures.UFIFuturesGenerator;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: currentAcitvity is null */
public class InstagramPhotoFromFriendsItemPartDefinition extends BaseSinglePartDefinitionWithViewType<Props, State, AnyEnvironment, InstagramPhotosFromFriendsItemView> {
    public static final CallerContext f7868a = CallerContext.a(InstagramPhotoFromFriendsItemPartDefinition.class, "photo_gallery");
    private static InstagramPhotoFromFriendsItemPartDefinition f7869l;
    private static final Object f7870m = new Object();
    public final Context f7871b;
    private final UFIFuturesGenerator f7872c;
    private final DefaultAndroidThreadUtil f7873d;
    public final InstagramUtils f7874e;
    public final NavigationLogger f7875f;
    private final TimeFormatUtil f7876g;
    private final MediaGalleryLauncherParamsFactory f7877h;
    private final MediaGalleryLauncher f7878i;
    private final Provider<FbDraweeControllerBuilder> f7879j;
    public final RawLikeHelper f7880k;

    /* compiled from: currentAcitvity is null */
    public class C09921 implements OnClickListener {
        final /* synthetic */ InstagramPhotoFromFriendsItemPartDefinition f7853a;

        public C09921(InstagramPhotoFromFriendsItemPartDefinition instagramPhotoFromFriendsItemPartDefinition) {
            this.f7853a = instagramPhotoFromFriendsItemPartDefinition;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1162027733);
            this.f7853a.f7874e.a(this.f7853a.f7871b, InstagramEntryPoint.Ego, null);
            Logger.a(2, EntryType.UI_INPUT_END, 1966266216, a);
        }
    }

    /* compiled from: currentAcitvity is null */
    public class Props {
        public final InstagramPhotosFromFriendsPhoto f7859a;
        public final Controller f7860b;

        public Props(InstagramPhotosFromFriendsPhoto instagramPhotosFromFriendsPhoto, Controller controller) {
            this.f7859a = instagramPhotosFromFriendsPhoto;
            this.f7860b = controller;
        }
    }

    /* compiled from: currentAcitvity is null */
    public class State {
        public final DraweeController f7861a;
        public final OnClickListener f7862b;
        public final String f7863c;
        public String f7864d;
        public boolean f7865e;
        public OnClickListener f7866f;
        public OnClickListener f7867g;

        public State(DraweeController draweeController, OnClickListener onClickListener, String str, String str2, boolean z) {
            this.f7861a = draweeController;
            this.f7862b = onClickListener;
            this.f7863c = str;
            this.f7864d = str2;
            this.f7865e = z;
        }

        public State(DraweeController draweeController, OnClickListener onClickListener, String str) {
            this.f7861a = draweeController;
            this.f7862b = onClickListener;
            this.f7863c = str;
        }
    }

    private static InstagramPhotoFromFriendsItemPartDefinition m8979b(InjectorLike injectorLike) {
        return new InstagramPhotoFromFriendsItemPartDefinition((Context) injectorLike.getInstance(Context.class), UFIFuturesGenerator.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), InstagramUtils.a(injectorLike), NavigationLogger.a(injectorLike), (TimeFormatUtil) DefaultTimeFormatUtil.a(injectorLike), MediaGalleryLauncherParamsFactory.a(injectorLike), (MediaGalleryLauncher) DefaultMediaGalleryLauncher.a(injectorLike), IdBasedProvider.a(injectorLike, 1117), RawLikeHelper.b(injectorLike));
    }

    public final Object m8981a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Uri a;
        final Props props = (Props) obj;
        if (props.f7859a.a.L() != null) {
            a = ImageUtil.a(props.f7859a.a.L());
        } else {
            a = null;
        }
        FbPipelineDraweeController s = ((FbDraweeControllerBuilder) this.f7879j.get()).a(f7868a).b(a).s();
        C09943 c09943 = new OnClickListener(this) {
            final /* synthetic */ InstagramPhotoFromFriendsItemPartDefinition f7858b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1708595505);
                InstagramPhotoFromFriendsItemPartDefinition.m8978a(this.f7858b, (DraweeView) view, props.f7859a);
                Logger.a(2, EntryType.UI_INPUT_END, -149114106, a);
            }
        };
        String aa = props.f7859a.a.aB().aa();
        if (this.f7874e.i()) {
            State state = new State(s, c09943, aa);
            state.f7867g = new C09921(this);
            return state;
        }
        String a2 = this.f7876g.a(TimeFormatStyle.STREAM_RELATIVE_STYLE, props.f7859a.a.B() * 1000);
        boolean z = props.f7859a.a.F() != null && props.f7859a.a.F().y_();
        final Object state2 = new State(s, c09943, aa, a2, z);
        state2.f7866f = new OnClickListener(this) {
            final /* synthetic */ InstagramPhotoFromFriendsItemPartDefinition f7856c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1664456475);
                InstagramPhotosFromFriendsItemView instagramPhotosFromFriendsItemView = (InstagramPhotosFromFriendsItemView) view.getParent().getParent().getParent();
                state2.f7865e = !state2.f7865e;
                InstagramPhotoFromFriendsItemPartDefinition instagramPhotoFromFriendsItemPartDefinition = this.f7856c;
                Props props = props;
                instagramPhotoFromFriendsItemPartDefinition.f7880k.a(String.valueOf(props.f7859a.a.K()), state2.f7865e, null, new FeedbackLoggingParams(props.f7859a.a(), null, InstagramPhotoFromFriendsItemPartDefinition.f7868a.c()), null);
                instagramPhotoFromFriendsItemPartDefinition = this.f7856c;
                State state = state2;
                instagramPhotosFromFriendsItemView.setLikeSelected(state.f7865e);
                if (state.f7865e && 1 != null) {
                    LikeIconPopAnimationHelper.a(instagramPhotosFromFriendsItemView.e);
                }
                if (state2.f7865e) {
                    props.f7860b.a();
                }
                LogUtils.a(642450407, a);
            }
        };
        return state2;
    }

    public final /* bridge */ /* synthetic */ void m8982a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1528796259);
        State state = (State) obj2;
        InstagramPhotosFromFriendsItemView instagramPhotosFromFriendsItemView = (InstagramPhotosFromFriendsItemView) view;
        instagramPhotosFromFriendsItemView.d.setController(state.f7861a);
        instagramPhotosFromFriendsItemView.b.setText(state.f7863c);
        instagramPhotosFromFriendsItemView.setPhotoClickListener(state.f7862b);
        if (this.f7874e.i()) {
            instagramPhotosFromFriendsItemView.c.setVisibility(8);
            instagramPhotosFromFriendsItemView.setInstallClickListener(state.f7867g);
            instagramPhotosFromFriendsItemView.e.setImageResource(2130840252);
            instagramPhotosFromFriendsItemView.e.setSelected(true);
        } else {
            instagramPhotosFromFriendsItemView.c.setText(state.f7864d);
            instagramPhotosFromFriendsItemView.setLikeSelected(state.f7865e);
            instagramPhotosFromFriendsItemView.setLikeClickListener(state.f7866f);
        }
        Logger.a(8, EntryType.MARK_POP, 1792577701, a);
    }

    public final void m8983b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        InstagramPhotosFromFriendsItemView instagramPhotosFromFriendsItemView = (InstagramPhotosFromFriendsItemView) view;
        instagramPhotosFromFriendsItemView.setLikeClickListener(null);
        instagramPhotosFromFriendsItemView.setPhotoClickListener(null);
        instagramPhotosFromFriendsItemView.setInstallClickListener(null);
    }

    public static InstagramPhotoFromFriendsItemPartDefinition m8977a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InstagramPhotoFromFriendsItemPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7870m) {
                InstagramPhotoFromFriendsItemPartDefinition instagramPhotoFromFriendsItemPartDefinition;
                if (a2 != null) {
                    instagramPhotoFromFriendsItemPartDefinition = (InstagramPhotoFromFriendsItemPartDefinition) a2.a(f7870m);
                } else {
                    instagramPhotoFromFriendsItemPartDefinition = f7869l;
                }
                if (instagramPhotoFromFriendsItemPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m8979b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7870m, b3);
                        } else {
                            f7869l = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = instagramPhotoFromFriendsItemPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public InstagramPhotoFromFriendsItemPartDefinition(Context context, UFIFuturesGenerator uFIFuturesGenerator, AndroidThreadUtil androidThreadUtil, InstagramUtils instagramUtils, NavigationLogger navigationLogger, TimeFormatUtil timeFormatUtil, MediaGalleryLauncherParamsFactory mediaGalleryLauncherParamsFactory, MediaGalleryLauncher mediaGalleryLauncher, Provider<FbDraweeControllerBuilder> provider, RawLikeHelper rawLikeHelper) {
        this.f7871b = context;
        this.f7872c = uFIFuturesGenerator;
        this.f7873d = androidThreadUtil;
        this.f7874e = instagramUtils;
        this.f7875f = navigationLogger;
        this.f7876g = timeFormatUtil;
        this.f7877h = mediaGalleryLauncherParamsFactory;
        this.f7878i = mediaGalleryLauncher;
        this.f7879j = provider;
        this.f7880k = rawLikeHelper;
    }

    public final ViewType<InstagramPhotosFromFriendsItemView> m8980a() {
        return InstagramPhotosFromFriendsItemView.a;
    }

    public static void m8978a(InstagramPhotoFromFriendsItemPartDefinition instagramPhotoFromFriendsItemPartDefinition, DraweeView draweeView, InstagramPhotosFromFriendsPhoto instagramPhotosFromFriendsPhoto) {
        DeepLinkBinderConfig a;
        long parseLong = Long.parseLong(instagramPhotosFromFriendsPhoto.a.K());
        String K = instagramPhotosFromFriendsPhoto.a.K();
        instagramPhotoFromFriendsItemPartDefinition.f7875f.a("tap_photo").a(f7868a.c(), true);
        NestedViewPhotoViewController nestedViewPhotoViewController = new NestedViewPhotoViewController(((Activity) instagramPhotoFromFriendsItemPartDefinition.f7871b).getWindow(), draweeView, draweeView, parseLong);
        String arrayNode = instagramPhotosFromFriendsPhoto.a() != null ? instagramPhotosFromFriendsPhoto.a().toString() : null;
        if (instagramPhotoFromFriendsItemPartDefinition.f7874e.a(InstagramEntryPoint.Photo)) {
            a = instagramPhotoFromFriendsItemPartDefinition.f7874e.a(true, arrayNode);
        } else {
            a = null;
        }
        Builder a2 = MediaGalleryLauncherParamsFactory.f(ImmutableList.of(K)).a(K);
        a2.j = arrayNode;
        Builder a3 = a2.a(FullscreenGallerySource.NEWSFEED).a(nestedViewPhotoViewController);
        a3.r = a;
        instagramPhotoFromFriendsItemPartDefinition.f7878i.a(instagramPhotoFromFriendsItemPartDefinition.f7871b, a3.b(), null);
    }
}
