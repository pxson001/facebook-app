package com.facebook.feedplugins.musicstory.providers;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feedplugins.musicstory.SingleSongData;
import com.facebook.feedplugins.musicstory.SingleSongPartDefinition.PersistentState;
import com.facebook.feedplugins.musicstory.utils.MusicStoryLogger;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: com.facebook.storygallerysurvey.activity.StoryGallerySurveyWithStoryActivity */
public class SpotifyBuilder implements MusicProviderBuilder {
    public final Context f8389a;
    public final MusicProviderUtils f8390b;
    public final ExecutorService f8391c;

    /* compiled from: com.facebook.storygallerysurvey.activity.StoryGallerySurveyWithStoryActivity */
    public class Spotify implements MusicProvider {
        public final /* synthetic */ SpotifyBuilder f8383a;
        private final OnClickListener f8384b = new C10361(this);
        public final SingleSongData f8385c;
        public final MusicStoryLogger f8386d;
        public final HasInvalidate f8387e;
        public final PersistentState f8388f;

        /* compiled from: com.facebook.storygallerysurvey.activity.StoryGallerySurveyWithStoryActivity */
        class C10361 implements OnClickListener {
            final /* synthetic */ Spotify f8380a;

            C10361(Spotify spotify) {
                this.f8380a = spotify;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -193137559);
                Uri uri = this.f8380a.f8385c.f8232h;
                if (uri == null) {
                    Logger.a(2, EntryType.UI_INPUT_END, 563385345, a);
                    return;
                }
                this.f8380a.f8383a.f8390b.m9284a(uri, this.f8380a.f8386d, new C10383(this.f8380a));
                LogUtils.a(1711014832, a);
            }
        }

        /* compiled from: com.facebook.storygallerysurvey.activity.StoryGallerySurveyWithStoryActivity */
        public class C10372 implements Runnable {
            final /* synthetic */ Spotify f8381a;

            public C10372(Spotify spotify) {
                this.f8381a = spotify;
            }

            public void run() {
                this.f8381a.f8387e.hL_();
            }
        }

        /* compiled from: com.facebook.storygallerysurvey.activity.StoryGallerySurveyWithStoryActivity */
        public class C10383 {
            public final /* synthetic */ Spotify f8382a;

            public C10383(Spotify spotify) {
                this.f8382a = spotify;
            }
        }

        public Spotify(SpotifyBuilder spotifyBuilder, SingleSongData singleSongData, MusicStoryLogger musicStoryLogger, HasInvalidate hasInvalidate, PersistentState persistentState) {
            this.f8383a = spotifyBuilder;
            this.f8385c = singleSongData;
            this.f8386d = musicStoryLogger;
            this.f8387e = hasInvalidate;
            this.f8388f = persistentState;
        }

        public final String mo240a() {
            if (this.f8388f.f8236a) {
                return this.f8383a.f8389a.getResources().getString(2131242486);
            }
            return this.f8383a.f8389a.getResources().getString(2131242485);
        }

        public final OnClickListener mo241b() {
            return this.f8384b;
        }

        public final int mo242c() {
            return 2130838328;
        }

        public final int mo243d() {
            if (this.f8388f.f8236a) {
                return 2130838325;
            }
            return 2130838324;
        }
    }

    @Inject
    public SpotifyBuilder(Context context, MusicProviderUtils musicProviderUtils, ExecutorService executorService) {
        this.f8389a = context;
        this.f8390b = musicProviderUtils;
        this.f8391c = executorService;
    }

    public final String mo245a() {
        return "6243987495";
    }

    public final String mo246b() {
        return "Spotify";
    }

    public final MusicProvider mo244a(SingleSongData singleSongData, MusicStoryLogger musicStoryLogger, HasInvalidate hasInvalidate, PersistentState persistentState) {
        return new Spotify(this, singleSongData, musicStoryLogger, hasInvalidate, persistentState);
    }
}
