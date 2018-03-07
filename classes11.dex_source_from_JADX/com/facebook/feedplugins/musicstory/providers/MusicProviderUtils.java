package com.facebook.feedplugins.musicstory.providers;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feedplugins.musicstory.providers.SpotifyBuilder.Spotify.C10383;
import com.facebook.feedplugins.musicstory.providers.protocol.SpotifySaveSongController;
import com.facebook.feedplugins.musicstory.providers.protocol.SpotifySaveSongController.SpotifySaveSongFailureCallback;
import com.facebook.feedplugins.musicstory.utils.MusicStoryLogger;
import com.facebook.feedplugins.musicstory.utils.MusicStoryLogger.ActionType;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: com.facebook.timeline.header.favphotos.edit.TimelineEditFavPhotosActivity */
public class MusicProviderUtils {
    private final Context f8375a;
    public final AtomicBoolean f8376b = new AtomicBoolean(false);
    @Nullable
    public FragmentManager f8377c;
    private SecureContextHelper f8378d;
    private SpotifySaveSongController f8379e;

    /* compiled from: com.facebook.timeline.header.favphotos.edit.TimelineEditFavPhotosActivity */
    public class C10331 {
        public final /* synthetic */ MusicStoryLogger f8364a;
        public final /* synthetic */ SpotifySaveSongController f8365b;
        public final /* synthetic */ Uri f8366c;
        public final /* synthetic */ C10383 f8367d;
        public final /* synthetic */ MusicProviderUtils f8368e;

        public C10331(MusicProviderUtils musicProviderUtils, MusicStoryLogger musicStoryLogger, SpotifySaveSongController spotifySaveSongController, Uri uri, C10383 c10383) {
            this.f8368e = musicProviderUtils;
            this.f8364a = musicStoryLogger;
            this.f8365b = spotifySaveSongController;
            this.f8366c = uri;
            this.f8367d = c10383;
        }
    }

    /* compiled from: com.facebook.timeline.header.favphotos.edit.TimelineEditFavPhotosActivity */
    public class C10353 implements SpotifySaveSongFailureCallback {
        final /* synthetic */ MusicProviderUtils f8374a;

        public C10353(MusicProviderUtils musicProviderUtils) {
            this.f8374a = musicProviderUtils;
        }

        public final void mo247a() {
        }
    }

    public static MusicProviderUtils m9281b(InjectorLike injectorLike) {
        return new MusicProviderUtils((Context) injectorLike.getInstance(Context.class), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), new SpotifySaveSongController((ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), String_LoggedInUserIdMethodAutoProvider.b(injectorLike), GraphQLQueryExecutor.a(injectorLike)));
    }

    @Inject
    public MusicProviderUtils(Context context, SecureContextHelper secureContextHelper, SpotifySaveSongController spotifySaveSongController) {
        this.f8375a = context;
        this.f8378d = secureContextHelper;
        if (this.f8375a instanceof FragmentActivity) {
            this.f8377c = ((FragmentActivity) this.f8375a).kO_();
        }
        this.f8379e = spotifySaveSongController;
    }

    public final void m9283a(Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.addFlags(335544320);
        this.f8378d.b(intent, this.f8375a);
    }

    public final void m9284a(Uri uri, @Nullable MusicStoryLogger musicStoryLogger, C10383 c10383) {
        String str;
        Preconditions.checkNotNull(uri);
        Preconditions.checkNotNull(c10383);
        List pathSegments = uri.getPathSegments();
        int i = 0;
        while (i < pathSegments.size()) {
            if ("track".equalsIgnoreCase((String) pathSegments.get(i)) && i < pathSegments.size() - 1) {
                str = (String) pathSegments.get(i + 1);
                break;
            }
            i++;
        }
        str = null;
        if (str == null) {
            if (musicStoryLogger != null) {
                musicStoryLogger.m9315a(ActionType.deep_link);
            }
            m9283a(uri);
        }
        this.f8379e.m9292a(null, uri, c10383, m9282c(musicStoryLogger, uri, this.f8379e, c10383));
    }

    private SpotifySaveSongFailureCallback m9282c(@Nullable MusicStoryLogger musicStoryLogger, Uri uri, SpotifySaveSongController spotifySaveSongController, C10383 c10383) {
        Preconditions.checkNotNull(spotifySaveSongController);
        final MusicStoryLogger musicStoryLogger2 = musicStoryLogger;
        final Uri uri2 = uri;
        final SpotifySaveSongController spotifySaveSongController2 = spotifySaveSongController;
        final C10383 c103832 = c10383;
        return new SpotifySaveSongFailureCallback(this) {
            final /* synthetic */ MusicProviderUtils f8373e;

            public final void mo247a() {
                MusicProviderUtils musicProviderUtils = this.f8373e;
                MusicStoryLogger musicStoryLogger = musicStoryLogger2;
                Uri uri = uri2;
                SpotifySaveSongController spotifySaveSongController = spotifySaveSongController2;
                C10383 c10383 = c103832;
                Preconditions.checkNotNull(spotifySaveSongController);
                Preconditions.checkNotNull(c10383);
                if (musicProviderUtils.f8377c != null && !musicProviderUtils.f8376b.getAndSet(true)) {
                    if (musicProviderUtils.f8377c.a(AuthorizationDialog.am) != null) {
                        musicProviderUtils.f8376b.set(false);
                        return;
                    }
                    AuthorizationDialog authorizationDialog = new AuthorizationDialog();
                    Preconditions.checkNotNull(spotifySaveSongController);
                    Preconditions.checkNotNull(c10383);
                    authorizationDialog.ao = new C10331(musicProviderUtils, musicStoryLogger, spotifySaveSongController, uri, c10383);
                    musicProviderUtils.f8377c.a().a(authorizationDialog, AuthorizationDialog.am).c();
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        musicProviderUtils.f8377c.b();
                    }
                    musicProviderUtils.f8376b.set(false);
                }
            }
        };
    }
}
