package com.facebook.feedplugins.musicstory;

import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.base.fragment.ContentFragmentContainer;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.ContextUtils;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.animations.AnimationsPartDefinition;
import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.feedplugins.musicstory.albums.AlbumSharePartDefinition.PersistentAlbumState;
import com.facebook.feedplugins.musicstory.animations.PlaybackAnimationBuilder;
import com.facebook.feedplugins.musicstory.animations.PlaybackAnimationBuilder.AnimationData;
import com.facebook.feedplugins.musicstory.animations.PlaybackAnimationBuilder.PlaybackAnimationListener;
import com.facebook.feedplugins.musicstory.utils.MusicStoryLogger;
import com.facebook.feedplugins.musicstory.utils.SongClipPlayer;
import com.facebook.feedplugins.musicstory.utils.SongClipPlayer.SongClipPlayerListener;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: composer_opened_inline_sprout_data */
public class MusicPlaybackPartDefinition<E extends HasInvalidate & HasPersistentState & HasPositionInformation> extends BaseSinglePartDefinition<Props, State, E, SimpleMusicStoryView> {
    private static MusicPlaybackPartDefinition f8164i;
    private static final Object f8165j = new Object();
    private final Context f8166a;
    public final MusicPlayer f8167b;
    public final HashMap<Uri, SimpleMusicStoryView> f8168c = new HashMap();
    private final ClickListenerPartDefinition f8169d;
    private final AnimationsPartDefinition f8170e;
    private final ExecutorService f8171f;
    public final Clock f8172g;
    private final PlaybackVisibilityRunnable f8173h = new PlaybackVisibilityRunnable(new C10171(this));

    /* compiled from: composer_opened_inline_sprout_data */
    public class C10171 {
        public final /* synthetic */ MusicPlaybackPartDefinition f8139a;

        C10171(MusicPlaybackPartDefinition musicPlaybackPartDefinition) {
            this.f8139a = musicPlaybackPartDefinition;
        }

        public final SimpleMusicStoryView m9146c(Uri uri) {
            return (SimpleMusicStoryView) this.f8139a.f8168c.get(uri);
        }
    }

    /* compiled from: composer_opened_inline_sprout_data */
    public class MusicPlaybackStateKey implements ContextStateKey<String, PersistentState> {
        private static final String f8144a = MusicPlaybackPartDefinition.class.getName();
        private final String f8145b;

        public MusicPlaybackStateKey(String str) {
            Preconditions.checkNotNull(str);
            this.f8145b = f8144a + str;
        }

        public final Object m9147a() {
            return new PersistentState();
        }

        public final Object m9148b() {
            return this.f8145b;
        }
    }

    @Immutable
    /* compiled from: composer_opened_inline_sprout_data */
    public class PersistentState {
        public PlaybackState f8146a;
        public int f8147b;
        public long f8148c;
    }

    /* compiled from: composer_opened_inline_sprout_data */
    public class PlaybackListener<E extends HasInvalidate> {
        private final ExecutorService f8150a;
        public final PersistentState f8151b;
        public final E f8152c;
        private final PlaybackVisibilityRunnable f8153d;
        public final Clock f8154e;
        @Nullable
        private final PersistentAlbumState f8155f;
        private final int f8156g;
        private final Context f8157h;
        public MusicStoryLogger f8158i;

        /* compiled from: composer_opened_inline_sprout_data */
        class C10191 implements Runnable {
            final /* synthetic */ PlaybackListener f8149a;

            C10191(PlaybackListener playbackListener) {
                this.f8149a = playbackListener;
            }

            public void run() {
                this.f8149a.f8152c.hL_();
            }
        }

        public PlaybackListener(Context context, ExecutorService executorService, Clock clock, PlaybackVisibilityRunnable playbackVisibilityRunnable, PersistentState persistentState, E e, int i, PersistentAlbumState persistentAlbumState, MusicStoryLogger musicStoryLogger) {
            this.f8157h = context;
            this.f8150a = executorService;
            this.f8151b = persistentState;
            this.f8154e = clock;
            this.f8153d = playbackVisibilityRunnable;
            this.f8152c = e;
            this.f8155f = persistentAlbumState;
            this.f8156g = i;
            this.f8158i = musicStoryLogger;
        }

        public final void m9152a() {
            if (m9149a(PlaybackState.LOADING)) {
                m9150b();
            }
        }

        public final void m9154a(Uri uri, int i, int i2) {
            long j = (long) i;
            if (this.f8151b.f8146a == PlaybackState.PLAY_REQUESTED || this.f8151b.f8146a == PlaybackState.LOADING || this.f8151b.f8146a == PlaybackState.PAUSED) {
                long a = this.f8154e.a();
                long j2 = a - this.f8151b.f8148c;
                this.f8151b.f8148c = a;
                MusicStoryLogger musicStoryLogger = this.f8158i;
                if (this.f8151b.f8146a == PlaybackState.PAUSED) {
                    j2 = -1;
                }
                musicStoryLogger.m9314a(j, j2);
            }
            if (m9149a(PlaybackState.PLAYING)) {
                FbFragment fbFragment;
                PlaybackVisibilityRunnable playbackVisibilityRunnable = this.f8153d;
                PersistentAlbumState persistentAlbumState = this.f8155f;
                ContentFragmentContainer contentFragmentContainer = (ContentFragmentContainer) ContextUtils.a(this.f8157h, ContentFragmentContainer.class);
                if (contentFragmentContainer == null) {
                    fbFragment = null;
                } else {
                    fbFragment = contentFragmentContainer.a();
                }
                playbackVisibilityRunnable.m9184a(uri, persistentAlbumState, fbFragment, this.f8156g);
                this.f8151b.f8147b = i2;
                m9150b();
            }
        }

        public final void m9153a(int i, int i2) {
            m9151c(i, i2);
            if (m9149a(PlaybackState.STOPPED)) {
                m9150b();
            }
        }

        public final void m9156b(int i, int i2) {
            m9151c(i, i2);
            if (m9149a(PlaybackState.PAUSED)) {
                m9150b();
            }
        }

        public final void m9155a(String str) {
            this.f8158i.m9316a(str);
            if (m9149a(PlaybackState.STOPPED)) {
                m9150b();
            }
        }

        private void m9151c(int i, int i2) {
            if (this.f8151b.f8146a == PlaybackState.PLAY_REQUESTED || this.f8151b.f8146a == PlaybackState.PLAYING || this.f8151b.f8146a == PlaybackState.LOADING) {
                long a = this.f8154e.a() - this.f8151b.f8148c;
                if (i2 == 0) {
                    this.f8158i.m9317b(i, (int) a);
                } else {
                    this.f8158i.m9313a(i, (int) a);
                }
            }
        }

        private boolean m9149a(PlaybackState playbackState) {
            if (this.f8151b.f8146a == playbackState) {
                return false;
            }
            this.f8151b.f8146a = playbackState;
            return true;
        }

        private void m9150b() {
            ExecutorDetour.a(this.f8150a, new C10191(this), -1147470751);
        }
    }

    /* compiled from: composer_opened_inline_sprout_data */
    public enum PlaybackState {
        STOPPED,
        PLAY_REQUESTED,
        LOADING,
        PLAYING,
        PAUSED
    }

    @Immutable
    /* compiled from: composer_opened_inline_sprout_data */
    public class Props {
        public final SingleSongData f8159a;
        public final MusicStoryLogger f8160b;
        @Nullable
        public final PersistentAlbumState f8161c;
        public final int f8162d;

        public Props(SingleSongData singleSongData, MusicStoryLogger musicStoryLogger, PersistentAlbumState persistentAlbumState, int i) {
            this.f8159a = singleSongData;
            this.f8160b = musicStoryLogger;
            this.f8161c = persistentAlbumState;
            this.f8162d = i;
        }
    }

    @Immutable
    /* compiled from: composer_opened_inline_sprout_data */
    public class State {
        public final PlaybackListener f8163a;

        public State(PlaybackListener playbackListener) {
            this.f8163a = playbackListener;
        }
    }

    private static MusicPlaybackPartDefinition m9161b(InjectorLike injectorLike) {
        return new MusicPlaybackPartDefinition((Context) injectorLike.getInstance(Context.class), AnimationsPartDefinition.a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), MusicPlayer.m9165a(injectorLike));
    }

    public final /* bridge */ /* synthetic */ void m9163a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -771652682);
        Props props = (Props) obj;
        State state = (State) obj2;
        this.f8168c.put(props.f8159a.f8231g, (SimpleMusicStoryView) view);
        MusicPlayer musicPlayer = this.f8167b;
        Uri uri = props.f8159a.f8231g;
        PlaybackListener playbackListener = state.f8163a;
        if (!(playbackListener == null || uri == null || musicPlayer.f8177a.containsKey(uri))) {
            musicPlayer.f8177a.put(uri, playbackListener);
            if (musicPlayer.f8179c != null && musicPlayer.f8177a.size() == 1) {
                SongClipPlayer songClipPlayer = musicPlayer.f8179c;
                if (!songClipPlayer.f8414d.contains(musicPlayer)) {
                    songClipPlayer.f8414d.add(musicPlayer);
                }
            }
        }
        Logger.a(8, EntryType.MARK_POP, 830891307, a);
    }

    public final void m9164b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        Props props = (Props) obj;
        HasInvalidate hasInvalidate = (HasInvalidate) anyEnvironment;
        SimpleMusicStoryView simpleMusicStoryView = (SimpleMusicStoryView) view;
        SingleSongData singleSongData = props.f8159a;
        boolean c = this.f8167b.m9173c(singleSongData.f8231g);
        Object obj3 = (props.f8161c == null || props.f8162d == props.f8161c.f8262a) ? null : 1;
        if (!m9160a(simpleMusicStoryView) || obj3 != null) {
            PersistentState persistentState = (PersistentState) ((HasPersistentState) hasInvalidate).a(new MusicPlaybackStateKey(singleSongData.m9196g()), singleSongData);
            PlaybackState playbackState = persistentState.f8146a;
            persistentState.f8146a = PlaybackState.STOPPED;
            simpleMusicStoryView.m9194b();
            simpleMusicStoryView.f8209e.m9228b();
            if (playbackState == null || playbackState == PlaybackState.PAUSED || playbackState == PlaybackState.STOPPED) {
                this.f8167b.m9174d(singleSongData.f8231g);
                this.f8168c.remove(props.f8159a.f8231g);
                return;
            }
            int b;
            MusicStoryLogger musicStoryLogger = props.f8160b;
            MusicPlayer musicPlayer = this.f8167b;
            if (musicPlayer.m9173c(singleSongData.f8231g)) {
                b = musicPlayer.f8179c.m9334b();
            } else {
                b = 0;
            }
            musicStoryLogger.m9313a(b, (int) (this.f8172g.a() - persistentState.f8148c));
            this.f8167b.m9175e(singleSongData.f8231g);
        } else if (!c) {
            this.f8167b.m9174d(singleSongData.f8231g);
            this.f8168c.remove(props.f8159a.f8231g);
        }
    }

    public static MusicPlaybackPartDefinition m9159a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MusicPlaybackPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8165j) {
                MusicPlaybackPartDefinition musicPlaybackPartDefinition;
                if (a2 != null) {
                    musicPlaybackPartDefinition = (MusicPlaybackPartDefinition) a2.a(f8165j);
                } else {
                    musicPlaybackPartDefinition = f8164i;
                }
                if (musicPlaybackPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9161b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8165j, b3);
                        } else {
                            f8164i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = musicPlaybackPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public MusicPlaybackPartDefinition(Context context, AnimationsPartDefinition animationsPartDefinition, ExecutorService executorService, Clock clock, ClickListenerPartDefinition clickListenerPartDefinition, MusicPlayer musicPlayer) {
        this.f8166a = context;
        this.f8170e = animationsPartDefinition;
        this.f8171f = executorService;
        this.f8169d = clickListenerPartDefinition;
        this.f8167b = musicPlayer;
        this.f8172g = clock;
    }

    private State m9158a(SubParts<E> subParts, Props props, E e) {
        SingleSongData singleSongData = props.f8159a;
        PersistentState persistentState = (PersistentState) ((HasPersistentState) e).a(new MusicPlaybackStateKey(singleSongData.m9196g()), singleSongData);
        persistentState.f8147b = this.f8167b.m9168a(singleSongData.m9197k());
        PlaybackAnimationListener playbackAnimationListener = new PlaybackAnimationListener();
        State state = new State(new PlaybackListener(this.f8166a, this.f8171f, this.f8172g, this.f8173h, persistentState, e, props.f8162d, props.f8161c, props.f8160b));
        OnClickListener a = m9157a(singleSongData.m9197k(), props.f8160b, persistentState);
        subParts.a(2131566148, this.f8169d, a);
        subParts.a(2131567456, this.f8169d, a);
        subParts.a(2131566147, this.f8169d, a);
        subParts.a(this.f8170e, new com.facebook.feed.rows.animations.AnimationsPartDefinition.Props(new AnimationData(persistentState), PlaybackAnimationBuilder.class.getSimpleName() + singleSongData.m9196g(), singleSongData, new PlaybackAnimationBuilder(playbackAnimationListener), null));
        return state;
    }

    private OnClickListener m9157a(final Uri uri, final MusicStoryLogger musicStoryLogger, final PersistentState persistentState) {
        return new OnClickListener(this) {
            final /* synthetic */ MusicPlaybackPartDefinition f8143d;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1173201985);
                if (persistentState.f8146a == null || persistentState.f8146a == PlaybackState.PAUSED || persistentState.f8146a == PlaybackState.STOPPED) {
                    persistentState.f8148c = this.f8143d.f8172g.a();
                    persistentState.f8146a = PlaybackState.PLAY_REQUESTED;
                    musicStoryLogger.m9312a();
                }
                SongClipPlayerListener songClipPlayerListener = this.f8143d.f8167b;
                Uri uri = uri;
                if (uri != null) {
                    if (songClipPlayerListener.f8179c == null) {
                        songClipPlayerListener.f8179c = (SongClipPlayer) songClipPlayerListener.f8178b.get();
                    }
                    songClipPlayerListener.f8179c.m9335b(uri, songClipPlayerListener);
                }
                Logger.a(2, EntryType.UI_INPUT_END, 209508722, a);
            }
        };
    }

    private static boolean m9160a(SimpleMusicStoryView simpleMusicStoryView) {
        boolean z;
        Preconditions.checkNotNull(simpleMusicStoryView);
        Rect rect = new Rect();
        simpleMusicStoryView.getWindowVisibleDisplayFrame(rect);
        int top = simpleMusicStoryView.getTop();
        if (top < -150) {
            z = true;
        } else {
            z = false;
        }
        boolean z2;
        if (Math.abs(top - rect.bottom) < 150) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z || r3) {
            return false;
        }
        return true;
    }
}
