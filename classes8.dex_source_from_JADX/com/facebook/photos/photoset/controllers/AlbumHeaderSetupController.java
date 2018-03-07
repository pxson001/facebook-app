package com.facebook.photos.photoset.controllers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.ContextUtils;
import com.facebook.composer.abtest.ExperimentsForComposerAbTestModule;
import com.facebook.config.application.Product;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.enums.GraphQLPhotosAlbumAPIType;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.intent.ComposerPageData;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.model.ComposerSourceSurface;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.ipc.profile.TimelinePhotoTabModeParams;
import com.facebook.ipc.simplepicker.SimplePickerIntent;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Action;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Builder;
import com.facebook.ipc.simplepicker.SimplePickerSource;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.qe.api.QeAccessor;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.titlebar.FbTitleBar;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: color_types */
public class AlbumHeaderSetupController {
    private final String f17760a = AlbumHeaderSetupController.class.getName();
    public final SecureContextHelper f17761b;
    private final Lazy<FbErrorReporter> f17762c;
    private final Provider<Product> f17763d;
    private final Lazy<QeAccessor> f17764e;
    private final Lazy<PagesAnalytics> f17765f;
    public GraphQLAlbum f17766g;
    private TimelinePhotoTabModeParams f17767h;
    private String f17768i;
    private Resources f17769j;
    private long f17770k = -1;
    private boolean f17771l = false;
    private ComposerTargetData f17772m;
    private Lazy<ViewerContext> f17773n;

    /* compiled from: color_types */
    class C18991 implements OnClickListener {
        final /* synthetic */ AlbumHeaderSetupController f17754a;

        C18991(AlbumHeaderSetupController albumHeaderSetupController) {
            this.f17754a = albumHeaderSetupController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1511988577);
            this.f17754a.m21749a(this.f17754a.f17766g, ((Activity) ContextUtils.a(view.getContext(), Activity.class)));
            Logger.a(2, EntryType.UI_INPUT_END, -231311061, a);
        }
    }

    /* compiled from: color_types */
    class C19002 implements OnClickListener {
        final /* synthetic */ AlbumHeaderSetupController f17755a;

        C19002(AlbumHeaderSetupController albumHeaderSetupController) {
            this.f17755a = albumHeaderSetupController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1135462859);
            Context a2 = ((Activity) ContextUtils.a(view.getContext(), Activity.class));
            if (this.f17755a.m21753b()) {
                AlbumHeaderSetupController.m21740b(this.f17755a, a2);
            } else if (this.f17755a.m21752a()) {
                AlbumHeaderSetupController.m21741c(this.f17755a, a2);
            } else {
                this.f17755a.f17761b.a(AlbumHeaderSetupController.m21743d(this.f17755a, a2), a2);
            }
            LogUtils.a(328529245, a);
        }
    }

    /* compiled from: color_types */
    class C19013 implements OnClickListener {
        final /* synthetic */ AlbumHeaderSetupController f17756a;

        C19013(AlbumHeaderSetupController albumHeaderSetupController) {
            this.f17756a = albumHeaderSetupController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 227088952);
            AlbumHeaderSetupController.m21740b(this.f17756a, ((Activity) ContextUtils.a(view.getContext(), Activity.class)));
            Logger.a(2, EntryType.UI_INPUT_END, 1939515964, a);
        }
    }

    /* compiled from: color_types */
    class C19024 implements OnClickListener {
        final /* synthetic */ AlbumHeaderSetupController f17757a;

        C19024(AlbumHeaderSetupController albumHeaderSetupController) {
            this.f17757a = albumHeaderSetupController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1856195111);
            AlbumHeaderSetupController.m21741c(this.f17757a, ((Activity) ContextUtils.a(view.getContext(), Activity.class)));
            Logger.a(2, EntryType.UI_INPUT_END, 1959330617, a);
        }
    }

    /* compiled from: color_types */
    class C19035 implements OnClickListener {
        final /* synthetic */ AlbumHeaderSetupController f17758a;

        C19035(AlbumHeaderSetupController albumHeaderSetupController) {
            this.f17758a = albumHeaderSetupController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1316833155);
            AlbumHeaderSetupController albumHeaderSetupController = this.f17758a;
            Activity a2 = ((Activity) ContextUtils.a(view.getContext(), Activity.class));
            albumHeaderSetupController.f17761b.a(AlbumHeaderSetupController.m21743d(albumHeaderSetupController, a2), 1756, a2);
            Logger.a(2, EntryType.UI_INPUT_END, 1226908942, a);
        }
    }

    /* compiled from: color_types */
    /* synthetic */ class C19046 {
        static final /* synthetic */ int[] f17759a = new int[SimplePickerSource.values().length];

        static {
            try {
                f17759a[SimplePickerSource.PAGE_COVER_PHOTO.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f17759a[SimplePickerSource.PAGE_PROFILE_PIC.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public static AlbumHeaderSetupController m21739b(InjectorLike injectorLike) {
        return new AlbumHeaderSetupController((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 494), IdBasedLazy.a(injectorLike, 372), IdBasedProvider.a(injectorLike, 873), IdBasedSingletonScopeProvider.b(injectorLike, 3219), IdBasedSingletonScopeProvider.b(injectorLike, 8930));
    }

    @Inject
    AlbumHeaderSetupController(SecureContextHelper secureContextHelper, Resources resources, Lazy<FbErrorReporter> lazy, Lazy<ViewerContext> lazy2, Provider<Product> provider, Lazy<QeAccessor> lazy3, Lazy<PagesAnalytics> lazy4) {
        this.f17761b = secureContextHelper;
        this.f17769j = resources;
        this.f17762c = lazy;
        this.f17773n = lazy2;
        this.f17763d = provider;
        this.f17764e = lazy3;
        this.f17765f = lazy4;
    }

    public final void m21751a(GraphQLAlbum graphQLAlbum, FbTextView fbTextView, @Nullable ComposerTargetData composerTargetData, String str, long j, boolean z) {
        this.f17766g = graphQLAlbum;
        this.f17768i = str;
        this.f17772m = composerTargetData;
        this.f17770k = j;
        this.f17771l = z;
        if (m21744d()) {
            fbTextView.setText(2131234353);
        } else if (m21742c()) {
            fbTextView.setText(2131234352);
        } else if (m21748i()) {
            fbTextView.setText(2131234351);
        }
        fbTextView.setOnClickListener(new C18991(this));
    }

    public final void m21749a(GraphQLAlbum graphQLAlbum, Activity activity) {
        this.f17766g = graphQLAlbum;
        if (m21742c()) {
            m21740b(this, activity);
        } else if (m21744d()) {
            m21741c(this, activity);
        } else {
            this.f17761b.a(m21743d(this, activity), activity);
        }
        if (this.f17771l) {
            ((PagesAnalytics) this.f17765f.get()).a(this.f17770k, "album_detail_view", graphQLAlbum.u(), graphQLAlbum.E() != null ? graphQLAlbum.E().a() : null);
        }
    }

    private boolean m21742c() {
        return this.f17766g.k() == GraphQLPhotosAlbumAPIType.PROFILE;
    }

    private boolean m21744d() {
        return this.f17766g.k() == GraphQLPhotosAlbumAPIType.COVER;
    }

    public final void m21750a(GraphQLAlbum graphQLAlbum, TimelinePhotoTabModeParams timelinePhotoTabModeParams, View view, FbTitleBar fbTitleBar, String str, String str2) {
        this.f17766g = graphQLAlbum;
        this.f17767h = timelinePhotoTabModeParams;
        this.f17768i = str2;
        view.setVisibility(8);
        if (!(graphQLAlbum == null || graphQLAlbum.B() == null || Objects.equal(graphQLAlbum.B().H(), this.f17768i))) {
            Object obj;
            if (graphQLAlbum == null || graphQLAlbum.q() == null || graphQLAlbum.q().isEmpty()) {
                obj = null;
            } else {
                ImmutableList q = graphQLAlbum.q();
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    if (Objects.equal(((GraphQLActor) q.get(i)).H(), str2)) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
            }
            if (obj == null) {
                return;
            }
        }
        if (graphQLAlbum != null || Strings.isNullOrEmpty(str) || str.contains(this.f17768i)) {
            view.setOnClickListener(new C19002(this));
            view.setVisibility(0);
            TextView textView = (TextView) view.findViewById(2131559545);
            if (m21753b()) {
                textView.setText(2131234352);
                textView.setContentDescription(this.f17769j.getString(2131234352));
                if (fbTitleBar != null) {
                    fbTitleBar.setTitle(2131234393);
                }
            } else if (m21752a()) {
                textView.setText(2131234353);
                textView.setContentDescription(this.f17769j.getString(2131234353));
                if (fbTitleBar != null) {
                    fbTitleBar.setTitle(2131234391);
                }
            } else {
                m21736a(view, textView);
                if (!m21753b() && !m21752a()) {
                    view.setVisibility(8);
                }
            }
        }
    }

    public final boolean m21752a() {
        return this.f17767h != null && this.f17767h.d();
    }

    public final boolean m21753b() {
        return this.f17767h != null && this.f17767h.c();
    }

    private void m21736a(View view, TextView textView) {
        boolean z;
        if (this.f17766g != null && Objects.equal(GraphQLPhotosAlbumAPIType.PROFILE, this.f17766g.k())) {
            view.setVisibility(0);
            textView.setText(2131234352);
            view.setOnClickListener(new C19013(this));
        } else if (this.f17766g == null || !Objects.equal(GraphQLPhotosAlbumAPIType.COVER, this.f17766g.k())) {
            view.setVisibility(0);
            textView.setText(2131234350);
            view.setOnClickListener(new C19035(this));
        } else {
            view.setVisibility(0);
            textView.setText(2131234353);
            view.setOnClickListener(new C19024(this));
        }
        if (this.f17766g == null) {
            z = false;
        } else {
            z = this.f17766g.o();
        }
        if (!z && this.f17766g != null && Objects.equal(GraphQLPhotosAlbumAPIType.COVER, this.f17766g.k()) && Objects.equal(GraphQLPhotosAlbumAPIType.PROFILE, this.f17766g.k()) && Objects.equal(GraphQLPhotosAlbumAPIType.MOBILE, this.f17766g.k())) {
            view.setVisibility(8);
        }
    }

    public static void m21740b(AlbumHeaderSetupController albumHeaderSetupController, Activity activity) {
        if (albumHeaderSetupController.m21745f()) {
            albumHeaderSetupController.m21738a(SimplePickerSource.PAGE_PROFILE_PIC, activity);
        } else {
            albumHeaderSetupController.m21735a(activity, SimplePickerSource.PROFILEPIC, Action.LAUNCH_PROFILE_PIC_EDIT_GALLERY, 1001);
        }
    }

    public static void m21741c(AlbumHeaderSetupController albumHeaderSetupController, Activity activity) {
        if (albumHeaderSetupController.m21745f()) {
            albumHeaderSetupController.m21738a(SimplePickerSource.PAGE_COVER_PHOTO, activity);
        } else {
            albumHeaderSetupController.m21735a(activity, SimplePickerSource.COVERPHOTO, Action.NONE, 1002);
        }
    }

    private void m21737a(Builder builder) {
        if (builder != null && m21745f() && this.f17763d.get() == Product.PAA) {
            builder.k();
        }
    }

    private void m21735a(Activity activity, SimplePickerSource simplePickerSource, Action action, int i) {
        Builder a = new Builder(simplePickerSource).i().h().a(action);
        m21737a(a);
        this.f17761b.a(SimplePickerIntent.a(activity, a), i, activity);
    }

    private void m21738a(SimplePickerSource simplePickerSource, Activity activity) {
        Action action;
        int i;
        switch (C19046.f17759a[simplePickerSource.ordinal()]) {
            case 1:
                action = Action.NONE;
                i = 2001;
                break;
            case 2:
                action = Action.LAUNCH_PROFILE_PIC_CROPPER;
                i = 2000;
                break;
            default:
                return;
        }
        this.f17761b.a(SimplePickerIntent.a(activity, new Builder(simplePickerSource).h().i().k().a(action)), i, activity);
    }

    public static Intent m21743d(AlbumHeaderSetupController albumHeaderSetupController, Activity activity) {
        boolean a = ((QeAccessor) albumHeaderSetupController.f17764e.get()).a(ExperimentsForComposerAbTestModule.Q, false);
        ComposerConfiguration.Builder isFireAndForget = ComposerConfigurationFactory.a(ComposerSourceSurface.ALBUM, albumHeaderSetupController.m21747h() ? "eventAlbum" : "album").setIsFireAndForget(true);
        if (albumHeaderSetupController.m21746g() || albumHeaderSetupController.m21747h() || albumHeaderSetupController.m21745f()) {
            isFireAndForget.setInitialTargetData(albumHeaderSetupController.f17772m);
        }
        if (!(albumHeaderSetupController.f17766g == null || albumHeaderSetupController.m21747h() || (albumHeaderSetupController.f17766g.k() != GraphQLPhotosAlbumAPIType.NORMAL && albumHeaderSetupController.f17766g.k() != GraphQLPhotosAlbumAPIType.SHARED))) {
            if (albumHeaderSetupController.f17766g.D() == null) {
                ((AbstractFbErrorReporter) albumHeaderSetupController.f17762c.get()).a(albumHeaderSetupController.f17760a, StringFormatUtil.formatStrLocaleSafe("Album privacyScope is null, album type %s", albumHeaderSetupController.f17766g.k().toString()));
            } else if (albumHeaderSetupController.f17766g.D().m() == null) {
                ((AbstractFbErrorReporter) albumHeaderSetupController.f17762c.get()).a(albumHeaderSetupController.f17760a, StringFormatUtil.formatStrLocaleSafe("Album privacyScope.iconImage is null, album type %s", albumHeaderSetupController.f17766g.k().toString()));
            } else {
                isFireAndForget.setInitialTargetAlbum(albumHeaderSetupController.f17766g);
            }
        }
        if (albumHeaderSetupController.m21745f()) {
            isFireAndForget.setInitialPageData(ComposerPageData.newBuilder().setPostAsPageViewerContext((ViewerContext) albumHeaderSetupController.f17773n.get()).a());
        }
        Builder builder = new Builder(SimplePickerSource.ALBUM);
        builder.a = isFireAndForget.a();
        builder = builder;
        if (!albumHeaderSetupController.m21748i()) {
            builder.i();
        } else if (a) {
            builder.b();
        }
        albumHeaderSetupController.m21737a(builder);
        return SimplePickerIntent.a(activity, builder);
    }

    private boolean m21745f() {
        return this.f17772m != null && this.f17772m.targetType == TargetType.PAGE;
    }

    private boolean m21746g() {
        return this.f17772m != null && this.f17772m.targetType == TargetType.GROUP;
    }

    private boolean m21747h() {
        return this.f17772m != null && this.f17772m.targetType == TargetType.EVENT;
    }

    private boolean m21748i() {
        return (m21747h() || m21746g() || m21745f() || this.f17766g.k() == GraphQLPhotosAlbumAPIType.SHARED || !((QeAccessor) this.f17764e.get()).a(ExperimentsForComposerAbTestModule.N, false)) ? false : true;
    }
}
