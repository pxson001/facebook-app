package com.facebook.feedplugins.musicstory.providers;

import android.content.Context;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feedplugins.musicstory.SimpleMusicPopupManager;
import com.facebook.feedplugins.musicstory.SingleSongData;
import com.facebook.feedplugins.musicstory.SingleSongPartDefinition.PersistentState;
import com.facebook.feedplugins.musicstory.utils.MusicStoryLogger;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: com.facebook.work.invitecoworker.InviteCoworkerActivity */
public class MusicProviderFactory {
    private final List<MusicProviderBuilder> f8362a = new ArrayList();
    private final MusicProviderBuilder f8363b;

    public static MusicProviderFactory m9276b(InjectorLike injectorLike) {
        return new MusicProviderFactory(new SpotifyBuilder((Context) injectorLike.getInstance(Context.class), MusicProviderUtils.m9281b(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike)), new AppleMusicBuilder((Context) injectorLike.getInstance(Context.class), MusicProviderUtils.m9281b(injectorLike)), new DocomoMusicBuilder((Context) injectorLike.getInstance(Context.class), MusicProviderUtils.m9281b(injectorLike), new SimpleMusicPopupManager((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike))), new BasicMusicProviderBuilder((Context) injectorLike.getInstance(Context.class), MusicProviderUtils.m9281b(injectorLike)));
    }

    @Inject
    public MusicProviderFactory(SpotifyBuilder spotifyBuilder, AppleMusicBuilder appleMusicBuilder, DocomoMusicBuilder docomoMusicBuilder, BasicMusicProviderBuilder basicMusicProviderBuilder) {
        this.f8362a.add(spotifyBuilder);
        this.f8362a.add(appleMusicBuilder);
        this.f8362a.add(docomoMusicBuilder);
        this.f8363b = basicMusicProviderBuilder;
    }

    public final MusicProvider m9277a(SingleSongData singleSongData, MusicStoryLogger musicStoryLogger, HasInvalidate hasInvalidate, PersistentState persistentState) {
        Preconditions.checkNotNull(singleSongData);
        for (MusicProviderBuilder musicProviderBuilder : this.f8362a) {
            if (!musicProviderBuilder.mo245a().equalsIgnoreCase(singleSongData.f8234j)) {
                if (musicProviderBuilder.mo246b().equalsIgnoreCase(singleSongData.f8228d)) {
                }
            }
            return musicProviderBuilder.mo244a(singleSongData, musicStoryLogger, hasInvalidate, persistentState);
        }
        return this.f8363b.mo244a(singleSongData, musicStoryLogger, hasInvalidate, persistentState);
    }
}
