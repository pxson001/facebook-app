package com.facebook.feedplugins.musicstory.providers;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feedplugins.musicstory.SingleSongData;
import com.facebook.feedplugins.musicstory.SingleSongPartDefinition.PersistentState;
import com.facebook.feedplugins.musicstory.utils.MusicStoryLogger;
import com.facebook.feedplugins.musicstory.utils.MusicStoryLogger.ActionType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.inject.Inject;

/* compiled from: completed_poll */
public class AppleMusicBuilder implements MusicProviderBuilder {
    public final Context f8343a;
    public final MusicProviderUtils f8344b;

    /* compiled from: completed_poll */
    public class AppleMusic implements MusicProvider {
        final /* synthetic */ AppleMusicBuilder f8339a;
        private final OnClickListener f8340b = new C10291(this);
        public final SingleSongData f8341c;
        public final MusicStoryLogger f8342d;

        /* compiled from: completed_poll */
        class C10291 implements OnClickListener {
            final /* synthetic */ AppleMusic f8338a;

            C10291(AppleMusic appleMusic) {
                this.f8338a = appleMusic;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -684624294);
                Uri uri = this.f8338a.f8341c.f8233i;
                if (uri == null) {
                    Logger.a(2, EntryType.UI_INPUT_END, -577732287, a);
                    return;
                }
                if (this.f8338a.f8342d != null) {
                    this.f8338a.f8342d.m9315a(ActionType.deep_link);
                }
                this.f8338a.f8339a.f8344b.m9283a(uri);
                LogUtils.a(1537403012, a);
            }
        }

        public AppleMusic(AppleMusicBuilder appleMusicBuilder, SingleSongData singleSongData, MusicStoryLogger musicStoryLogger) {
            this.f8339a = appleMusicBuilder;
            this.f8341c = singleSongData;
            this.f8342d = musicStoryLogger;
        }

        public final String mo240a() {
            return this.f8339a.f8343a.getResources().getString(2131242487);
        }

        public final OnClickListener mo241b() {
            return this.f8340b;
        }

        public final int mo242c() {
            return 0;
        }

        public final int mo243d() {
            return 2130838324;
        }
    }

    @Inject
    public AppleMusicBuilder(Context context, MusicProviderUtils musicProviderUtils) {
        this.f8343a = context;
        this.f8344b = musicProviderUtils;
    }

    public final String mo245a() {
        return "615085188507202";
    }

    public final String mo246b() {
        return "Apple Music";
    }

    public final MusicProvider mo244a(SingleSongData singleSongData, MusicStoryLogger musicStoryLogger, HasInvalidate hasInvalidate, PersistentState persistentState) {
        return new AppleMusic(this, singleSongData, musicStoryLogger);
    }
}
