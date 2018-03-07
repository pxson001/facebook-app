package com.facebook.feedplugins.instagram;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.NavigationLogger;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbPipelineDraweeController;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
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
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: count/recovery */
public class InstagramPromoteUnitItemPartDefinition extends BaseSinglePartDefinitionWithViewType<Props, State, AnyEnvironment, InstagramPromoteUnitItemView> {
    public static final CallerContext f7954a = CallerContext.a(InstagramPromoteUnitItemPartDefinition.class, "photo_gallery");
    private static InstagramPromoteUnitItemPartDefinition f7955h;
    private static final Object f7956i = new Object();
    public final Context f7957b;
    public final InstagramUtils f7958c;
    public final NavigationLogger f7959d;
    private final MediaGalleryLauncherParamsFactory f7960e;
    private final MediaGalleryLauncher f7961f;
    private final Provider<FbDraweeControllerBuilder> f7962g;

    /* compiled from: count/recovery */
    public class C10042 implements OnClickListener {
        final /* synthetic */ InstagramPromoteUnitItemPartDefinition f7943a;

        public C10042(InstagramPromoteUnitItemPartDefinition instagramPromoteUnitItemPartDefinition) {
            this.f7943a = instagramPromoteUnitItemPartDefinition;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1289647612);
            this.f7943a.f7958c.a(this.f7943a.f7957b, InstagramEntryPoint.Ego, null);
            Logger.a(2, EntryType.UI_INPUT_END, 2095631391, a);
        }
    }

    /* compiled from: count/recovery */
    public class Props {
        public final InstagramPhotosFromFriendsPhoto f7946a;
        public final Controller f7947b;

        public Props(InstagramPhotosFromFriendsPhoto instagramPhotosFromFriendsPhoto, Controller controller) {
            this.f7946a = instagramPhotosFromFriendsPhoto;
            this.f7947b = controller;
        }
    }

    /* compiled from: count/recovery */
    public class State {
        public final DraweeController f7948a;
        public final OnClickListener f7949b;
        public final String f7950c;
        public final String f7951d;
        public final Boolean f7952e;
        public OnClickListener f7953f;

        public State(DraweeController draweeController, OnClickListener onClickListener, String str, String str2, Boolean bool) {
            this.f7948a = draweeController;
            this.f7949b = onClickListener;
            this.f7950c = str;
            this.f7951d = str2;
            this.f7952e = bool;
        }
    }

    private static InstagramPromoteUnitItemPartDefinition m9034b(InjectorLike injectorLike) {
        return new InstagramPromoteUnitItemPartDefinition((Context) injectorLike.getInstance(Context.class), InstagramUtils.a(injectorLike), NavigationLogger.a(injectorLike), MediaGalleryLauncherParamsFactory.a(injectorLike), (MediaGalleryLauncher) DefaultMediaGalleryLauncher.a(injectorLike), IdBasedProvider.a(injectorLike, 1117));
    }

    public final Object m9036a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Uri a;
        String string;
        OnClickListener onClickListener;
        final Props props = (Props) obj;
        if (props.f7946a.a.L() != null) {
            a = ImageUtil.a(props.f7946a.a.L());
        } else {
            a = null;
        }
        FbPipelineDraweeController s = ((FbDraweeControllerBuilder) this.f7962g.get()).a(f7954a).b(a).s();
        C10031 c10031 = new OnClickListener(this) {
            final /* synthetic */ InstagramPromoteUnitItemPartDefinition f7942b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 979986435);
                InstagramPromoteUnitItemPartDefinition.m9033a(this.f7942b, (DraweeView) view, props.f7946a);
                Logger.a(2, EntryType.UI_INPUT_END, 1071680657, a);
            }
        };
        String aa = props.f7946a.a.aB().aa();
        String string2 = this.f7957b.getResources().getString(2131233574, new Object[]{aa});
        Boolean valueOf = Boolean.valueOf(this.f7958c.k());
        if (this.f7958c.a() && this.f7958c.l()) {
            aa = props.f7946a.a.be() != null ? (String) props.f7946a.a.be().j().get(0) : "";
            C10053 c10053 = new OnClickListener(this) {
                final /* synthetic */ InstagramPromoteUnitItemPartDefinition f7945b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -1754146015);
                    this.f7945b.f7958c.a(this.f7945b.f7957b, aa, InstagramEntryPoint.Ego);
                    Logger.a(2, EntryType.UI_INPUT_END, 1004700287, a);
                }
            };
            string = this.f7957b.getResources().getString(2131233570);
            onClickListener = c10053;
        } else {
            string = this.f7957b.getResources().getString(2131230746);
            Object c10042 = new C10042(this);
        }
        State state = new State(s, c10031, string2, string, valueOf);
        state.f7953f = onClickListener;
        return state;
    }

    public final /* bridge */ /* synthetic */ void m9037a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 434021089);
        State state = (State) obj2;
        InstagramPromoteUnitItemView instagramPromoteUnitItemView = (InstagramPromoteUnitItemView) view;
        instagramPromoteUnitItemView.c.setController(state.f7948a);
        instagramPromoteUnitItemView.setPhotoClickListener(state.f7953f);
        instagramPromoteUnitItemView.b.setText(state.f7950c);
        instagramPromoteUnitItemView.setInstallClickListener(state.f7953f);
        instagramPromoteUnitItemView.e.setText(state.f7951d);
        if (state.f7952e.booleanValue()) {
            instagramPromoteUnitItemView.c.setHierarchy(new GenericDraweeHierarchyBuilder(instagramPromoteUnitItemView.getContext().getResources()).e(ScaleType.c).u());
            instagramPromoteUnitItemView.c.setAspectRatio(1.0f);
        }
        Logger.a(8, EntryType.MARK_POP, 1601947645, a);
    }

    public final void m9038b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        InstagramPromoteUnitItemView instagramPromoteUnitItemView = (InstagramPromoteUnitItemView) view;
        instagramPromoteUnitItemView.setPhotoClickListener(null);
        instagramPromoteUnitItemView.setInstallClickListener(null);
    }

    public static InstagramPromoteUnitItemPartDefinition m9032a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InstagramPromoteUnitItemPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7956i) {
                InstagramPromoteUnitItemPartDefinition instagramPromoteUnitItemPartDefinition;
                if (a2 != null) {
                    instagramPromoteUnitItemPartDefinition = (InstagramPromoteUnitItemPartDefinition) a2.a(f7956i);
                } else {
                    instagramPromoteUnitItemPartDefinition = f7955h;
                }
                if (instagramPromoteUnitItemPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9034b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7956i, b3);
                        } else {
                            f7955h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = instagramPromoteUnitItemPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public InstagramPromoteUnitItemPartDefinition(Context context, InstagramUtils instagramUtils, NavigationLogger navigationLogger, MediaGalleryLauncherParamsFactory mediaGalleryLauncherParamsFactory, MediaGalleryLauncher mediaGalleryLauncher, Provider<FbDraweeControllerBuilder> provider) {
        this.f7957b = context;
        this.f7958c = instagramUtils;
        this.f7959d = navigationLogger;
        this.f7960e = mediaGalleryLauncherParamsFactory;
        this.f7961f = mediaGalleryLauncher;
        this.f7962g = provider;
    }

    public final ViewType<InstagramPromoteUnitItemView> m9035a() {
        return InstagramPromoteUnitItemView.a;
    }

    public static void m9033a(InstagramPromoteUnitItemPartDefinition instagramPromoteUnitItemPartDefinition, DraweeView draweeView, InstagramPhotosFromFriendsPhoto instagramPhotosFromFriendsPhoto) {
        DeepLinkBinderConfig a;
        long parseLong = Long.parseLong(instagramPhotosFromFriendsPhoto.a.K());
        String K = instagramPhotosFromFriendsPhoto.a.K();
        instagramPromoteUnitItemPartDefinition.f7959d.a("tap_photo").a(f7954a.c(), true);
        NestedViewPhotoViewController nestedViewPhotoViewController = new NestedViewPhotoViewController(((Activity) instagramPromoteUnitItemPartDefinition.f7957b).getWindow(), draweeView, draweeView, parseLong);
        String arrayNode = instagramPhotosFromFriendsPhoto.a() != null ? instagramPhotosFromFriendsPhoto.a().toString() : null;
        if (instagramPromoteUnitItemPartDefinition.f7958c.a(InstagramEntryPoint.Photo)) {
            a = instagramPromoteUnitItemPartDefinition.f7958c.a(true, arrayNode);
        } else {
            a = null;
        }
        Builder a2 = MediaGalleryLauncherParamsFactory.f(ImmutableList.of(K)).a(K);
        a2.j = arrayNode;
        Builder a3 = a2.a(FullscreenGallerySource.NEWSFEED).a(nestedViewPhotoViewController);
        a3.r = a;
        instagramPromoteUnitItemPartDefinition.f7961f.a(instagramPromoteUnitItemPartDefinition.f7957b, a3.b(), null);
    }
}
