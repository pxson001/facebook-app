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

/* compiled from: com.google.android.webview */
public class BasicMusicProviderBuilder implements MusicProviderBuilder {
    public final Context f8352a;
    public final MusicProviderUtils f8353b;

    /* compiled from: com.google.android.webview */
    public class BasicMuiscProvider implements MusicProvider {
        final /* synthetic */ BasicMusicProviderBuilder f8348a;
        private final OnClickListener f8349b = new C10311(this);
        public final SingleSongData f8350c;
        public final MusicStoryLogger f8351d;

        /* compiled from: com.google.android.webview */
        class C10311 implements OnClickListener {
            final /* synthetic */ BasicMuiscProvider f8347a;

            C10311(BasicMuiscProvider basicMuiscProvider) {
                this.f8347a = basicMuiscProvider;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1527684273);
                Uri uri = this.f8347a.f8350c.f8232h;
                if (uri == null) {
                    Logger.a(2, EntryType.UI_INPUT_END, -595674452, a);
                    return;
                }
                if (this.f8347a.f8351d != null) {
                    this.f8347a.f8351d.m9315a(ActionType.deep_link);
                }
                this.f8347a.f8348a.f8353b.m9283a(uri);
                LogUtils.a(-2123404657, a);
            }
        }

        public BasicMuiscProvider(BasicMusicProviderBuilder basicMusicProviderBuilder, SingleSongData singleSongData, MusicStoryLogger musicStoryLogger) {
            this.f8348a = basicMusicProviderBuilder;
            this.f8350c = singleSongData;
            this.f8351d = musicStoryLogger;
        }

        public final String mo240a() {
            return this.f8348a.f8352a.getResources().getString(2131242491, new Object[]{this.f8350c.f8228d});
        }

        public final OnClickListener mo241b() {
            return this.f8349b;
        }

        public final int mo242c() {
            return 0;
        }

        public final int mo243d() {
            return 2130838324;
        }
    }

    @Inject
    public BasicMusicProviderBuilder(Context context, MusicProviderUtils musicProviderUtils) {
        this.f8352a = context;
        this.f8353b = musicProviderUtils;
    }

    public final String mo245a() {
        return "";
    }

    public final String mo246b() {
        return "";
    }

    public final MusicProvider mo244a(SingleSongData singleSongData, MusicStoryLogger musicStoryLogger, HasInvalidate hasInvalidate, PersistentState persistentState) {
        return new BasicMuiscProvider(this, singleSongData, musicStoryLogger);
    }
}
