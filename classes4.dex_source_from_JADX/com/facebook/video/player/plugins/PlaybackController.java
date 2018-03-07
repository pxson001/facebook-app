package com.facebook.video.player.plugins;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.os.Handler;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.MonotonicClock;
import com.facebook.content.event.FbEvent;
import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import com.facebook.inject.Assisted;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.video.abtest.VideoLivePlaybackConfig;
import com.facebook.video.analytics.ChannelEligibility;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.api.VideoMetadata;
import com.facebook.video.engine.AbstractVideoPlayerListener;
import com.facebook.video.engine.Constants.VideoError;
import com.facebook.video.engine.PlayPosition;
import com.facebook.video.engine.VideoLoggingUtils;
import com.facebook.video.engine.VideoPlayer;
import com.facebook.video.engine.VideoPlayer.PlayerState;
import com.facebook.video.engine.VideoPlayerListener;
import com.facebook.video.engine.VideoPlayerManager;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.engine.VideoResolution;
import com.facebook.video.engine.texview.VideoSurfaceTarget;
import com.facebook.video.player.PlayerActivityManager;
import com.facebook.video.player.RichVideoPlayerScheduledRunnable;
import com.facebook.video.player.VideoSpecText$VideoSpecParam;
import com.facebook.video.player.events.RVPAfterVideoPlayedEvent;
import com.facebook.video.player.events.RVPBeforeVideoPlayEvent;
import com.facebook.video.player.events.RVPBroadcastStatusChangedEvent;
import com.facebook.video.player.events.RVPErrorEvent;
import com.facebook.video.player.events.RVPFirstPlayEvent;
import com.facebook.video.player.events.RVPParamsChangedEvent;
import com.facebook.video.player.events.RVPPauseFrameAvailableEvent;
import com.facebook.video.player.events.RVPPlayerStateChangedEvent;
import com.facebook.video.player.events.RVPRequestPausingEvent;
import com.facebook.video.player.events.RVPRequestPlayingEvent;
import com.facebook.video.player.events.RVPRequestSeekingEvent;
import com.facebook.video.player.events.RVPRequestSetResolutionEvent;
import com.facebook.video.player.events.RVPRequestSubtitlesLanguageChangeEvent;
import com.facebook.video.player.events.RVPRequestSwitchPlayableUriEvent;
import com.facebook.video.player.events.RVPStreamCompleteEvent;
import com.facebook.video.player.events.RVPStreamDriedOutEvent;
import com.facebook.video.player.events.RVPVideoResolutionChangedEvent;
import com.facebook.video.player.events.RVPVideoSizeUpdatedEvent;
import com.facebook.video.player.events.RVPVideoSpecUpdateEvent;
import com.facebook.video.player.events.RichVideoPlayerEvent;
import com.facebook.video.player.events.RichVideoPlayerEventBus;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.subtitles.controller.Subtitles;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: perf_sample_rate */
public class PlaybackController {
    private static final String f5101a = PlaybackController.class.getSimpleName();
    private final AudioFocusHandler f5102A = new AudioFocusHandler(this);
    @Nullable
    public String f5103B;
    public GraphQLVideoBroadcastStatus f5104C = null;
    private final List<RichVideoPlayerEventSubscriber<? extends RichVideoPlayerEvent>> f5105b;
    public final StallTimeCalculator f5106c;
    public final MonotonicClock f5107d;
    public final FirstPlayTracker f5108e;
    private final VideoPlayerManager f5109f;
    private final VideoLoggingUtils f5110g;
    private final VideoPlayerListener f5111h;
    private final AbstractFbErrorReporter f5112i;
    private final PlayerActivityManager f5113j;
    public final VideoLivePlaybackConfig f5114k;
    public State f5115l;
    private int f5116m;
    private boolean f5117n;
    private boolean f5118o = true;
    private boolean f5119p = false;
    public PlayerType f5120q;
    public VideoPlayer f5121r;
    public RichVideoPlayerEventBus f5122s;
    public VideoSurfaceTarget f5123t;
    public Subtitles f5124u;
    private final boolean f5125v;
    private final boolean f5126w;
    public final Handler f5127x;
    public final List<RichVideoPlayerScheduledRunnable> f5128y;
    private final AudioManager f5129z;

    /* compiled from: perf_sample_rate */
    class AudioFocusHandler implements OnAudioFocusChangeListener {
        final /* synthetic */ PlaybackController f5130a;

        public AudioFocusHandler(PlaybackController playbackController) {
            this.f5130a = playbackController;
        }

        public void onAudioFocusChange(int i) {
            if (i == -1) {
                this.f5130a.m5463a(EventTriggerType.BY_ANDROID);
            }
        }
    }

    /* compiled from: perf_sample_rate */
    class PlayerListener extends AbstractVideoPlayerListener {
        final /* synthetic */ PlaybackController f5131a;

        public PlayerListener(PlaybackController playbackController) {
            this.f5131a = playbackController;
        }

        public final void mo447a(Bitmap bitmap) {
            if (this.f5131a.f5122s != null) {
                this.f5131a.f5122s.m14878a(new RVPPauseFrameAvailableEvent(bitmap));
            }
        }

        public final void mo444a() {
            this.f5131a.f5108e.m5551c();
            if (this.f5131a.f5122s != null && this.f5131a.f5121r.mo496r() != null) {
                this.f5131a.f5122s.m14878a(new RVPVideoSpecUpdateEvent(VideoSpecText$VideoSpecParam.API_CONFIG.value, this.f5131a.f5121r.mo496r()));
            }
        }

        public final void mo446a(int i, int i2) {
            if (this.f5131a.f5122s != null) {
                this.f5131a.f5122s.m14878a(new RVPVideoSizeUpdatedEvent(i, i2));
            }
        }

        public final void mo445a(int i) {
            if (this.f5131a.f5122s != null) {
                PlaybackController.m5455a(this.f5131a, State.PLAYBACK_COMPLETE);
                this.f5131a.f5122s.m14878a(new RVPStreamCompleteEvent(i));
            }
            this.f5131a.f5108e.m5550a();
        }

        public final void mo449a(EventTriggerType eventTriggerType, boolean z) {
            if (this.f5131a.f5122s != null) {
                if (!z) {
                    PlaybackController.m5455a(this.f5131a, State.ERROR);
                }
                this.f5131a.f5122s.m14878a(new RVPBeforeVideoPlayEvent(z));
            }
        }

        public final void mo456c(EventTriggerType eventTriggerType) {
            if (this.f5131a.f5122s != null) {
                PlaybackController.m5455a(this.f5131a, State.PLAYING);
                this.f5131a.f5122s.m14878a(new RVPAfterVideoPlayedEvent());
                VideoMetadata p = this.f5131a.f5121r.mo512p();
                if (p != null) {
                    this.f5131a.f5122s.m14878a(new RVPVideoSpecUpdateEvent(VideoSpecText$VideoSpecParam.VIDEO_MIME.value, p.m5999a()));
                    this.f5131a.f5122s.m14878a(new RVPVideoSpecUpdateEvent(VideoSpecText$VideoSpecParam.STREAMING_FORMAT.value, p.f5585f));
                    this.f5131a.f5122s.m14878a(new RVPVideoSpecUpdateEvent(VideoSpecText$VideoSpecParam.DASH_STREAM.value, p.f5586g));
                }
            }
            this.f5131a.f5108e.m5552d();
            this.f5131a.f5106c.m5553b();
            PlaybackController.m5456b(this.f5131a, -1);
        }

        public final void mo454b(EventTriggerType eventTriggerType) {
            PlaybackController.m5456b(this.f5131a, this.f5131a.f5121r.mo487b());
            if (this.f5131a.f5115l != State.SEEKING) {
                PlaybackController.m5455a(this.f5131a, State.PAUSED);
            }
        }

        public final void mo448a(EventTriggerType eventTriggerType) {
            PlaybackController.m5455a(this.f5131a, State.PAUSED);
        }

        public final void mo450a(PlayerState playerState) {
            if (this.f5131a.f5122s != null) {
                this.f5131a.f5122s.m14878a(new RVPVideoSpecUpdateEvent(VideoSpecText$VideoSpecParam.CURRENT_STATE.value, playerState.value));
            }
        }

        public final void mo455b(PlayerState playerState) {
            if (this.f5131a.f5122s != null) {
                this.f5131a.f5122s.m14878a(new RVPVideoSpecUpdateEvent(VideoSpecText$VideoSpecParam.TARGET_STATE.value, playerState.value));
            }
        }

        public final void mo453a(String str, VideoError videoError) {
            PlaybackController.m5455a(this.f5131a, State.ERROR);
            if (this.f5131a.f5121r != null && this.f5131a.f5121r.mo492e() == VideoResolution.HIGH_DEFINITION) {
                this.f5131a.f5121r.mo479a(VideoResolution.STANDARD_DEFINITION, EventTriggerType.BY_USER);
                this.f5131a.f5121r.mo474a(EventTriggerType.BY_USER);
            } else if (this.f5131a.f5122s != null) {
                this.f5131a.f5122s.m14878a(new RVPErrorEvent(str, videoError));
            }
        }

        public final void mo452a(String str) {
            if (this.f5131a.f5122s != null) {
                this.f5131a.f5122s.m14878a(new RVPVideoSpecUpdateEvent(VideoSpecText$VideoSpecParam.DASH_STREAM.value, str));
            }
        }

        public final void mo457e() {
            if (this.f5131a.f5115l == State.PLAYING) {
                PlaybackController.m5455a(this.f5131a, State.ATTEMPT_TO_PLAY);
            }
        }

        public final void mo458f() {
            if (this.f5131a.f5115l == State.ATTEMPT_TO_PLAY) {
                PlaybackController.m5455a(this.f5131a, State.PLAYING);
            }
        }

        public final void mo451a(VideoResolution videoResolution) {
            if (this.f5131a.f5122s != null) {
                this.f5131a.f5122s.m14878a(new RVPVideoResolutionChangedEvent(videoResolution));
            }
        }

        public final void mo459g() {
            if (this.f5131a.f5115l == State.ATTEMPT_TO_PLAY && this.f5131a.f5122s != null) {
                this.f5131a.f5122s.m14878a(new RVPStreamDriedOutEvent());
            }
        }
    }

    /* compiled from: perf_sample_rate */
    public class FirstPlayTracker {
        final /* synthetic */ PlaybackController f5132a;
        private boolean f5133b = false;
        private boolean f5134c = false;
        public boolean f5135d = false;

        public FirstPlayTracker(PlaybackController playbackController) {
            this.f5132a = playbackController;
        }

        public final void m5550a() {
            this.f5133b = false;
            this.f5134c = false;
            this.f5135d = false;
        }

        public final void m5551c() {
            this.f5134c = true;
            m5549e();
        }

        public final void m5552d() {
            this.f5133b = true;
            m5549e();
        }

        private void m5549e() {
            if (!this.f5135d && this.f5133b && this.f5134c) {
                this.f5135d = true;
                if (this.f5132a.f5122s != null) {
                    this.f5132a.f5122s.m14878a(new RVPFirstPlayEvent());
                }
            }
        }
    }

    /* compiled from: perf_sample_rate */
    public class StallTimeCalculator {
        public final /* synthetic */ PlaybackController f5136a;
        public long f5137b;

        public StallTimeCalculator(PlaybackController playbackController) {
            this.f5136a = playbackController;
        }

        public final void m5553b() {
            if (this.f5137b > 0) {
                this.f5136a.f5122s.m14878a(new RVPVideoSpecUpdateEvent(VideoSpecText$VideoSpecParam.NEW_START_TIME.value, StringFormatUtil.formatStrLocaleSafe("%.2f s", Double.valueOf(((double) (this.f5136a.f5107d.now() - this.f5137b)) * 0.001d))));
            }
            this.f5137b = 0;
        }
    }

    /* compiled from: perf_sample_rate */
    class RequestPlayingEventSubscriber extends RichVideoPlayerEventSubscriber<RVPRequestPlayingEvent> {
        final /* synthetic */ PlaybackController f5138a;

        public RequestPlayingEventSubscriber(PlaybackController playbackController) {
            this.f5138a = playbackController;
        }

        public final void m5555b(FbEvent fbEvent) {
            RVPRequestPlayingEvent rVPRequestPlayingEvent = (RVPRequestPlayingEvent) fbEvent;
            StallTimeCalculator stallTimeCalculator = this.f5138a.f5106c;
            stallTimeCalculator.f5137b = stallTimeCalculator.f5136a.f5107d.now();
            this.f5138a.m5464a(rVPRequestPlayingEvent.f5318a, rVPRequestPlayingEvent.f5319b);
        }

        public final Class<RVPRequestPlayingEvent> m5554a() {
            return RVPRequestPlayingEvent.class;
        }
    }

    /* compiled from: perf_sample_rate */
    class RequestPausingEventSubscriber extends RichVideoPlayerEventSubscriber<RVPRequestPausingEvent> {
        final /* synthetic */ PlaybackController f5139a;

        public RequestPausingEventSubscriber(PlaybackController playbackController) {
            this.f5139a = playbackController;
        }

        public final void m5557b(FbEvent fbEvent) {
            this.f5139a.m5463a(((RVPRequestPausingEvent) fbEvent).f14167a);
        }

        public final Class<RVPRequestPausingEvent> m5556a() {
            return RVPRequestPausingEvent.class;
        }
    }

    /* compiled from: perf_sample_rate */
    class RequestSeekingEventSubscriber extends RichVideoPlayerEventSubscriber<RVPRequestSeekingEvent> {
        final /* synthetic */ PlaybackController f5140a;

        public RequestSeekingEventSubscriber(PlaybackController playbackController) {
            this.f5140a = playbackController;
        }

        public final void m5559b(FbEvent fbEvent) {
            RVPRequestSeekingEvent rVPRequestSeekingEvent = (RVPRequestSeekingEvent) fbEvent;
            this.f5140a.m5461a(rVPRequestSeekingEvent.f5321b, rVPRequestSeekingEvent.f5320a);
        }

        public final Class<RVPRequestSeekingEvent> m5558a() {
            return RVPRequestSeekingEvent.class;
        }
    }

    /* compiled from: perf_sample_rate */
    class RequestChangeResolutionEventSubscriber extends RichVideoPlayerEventSubscriber<RVPRequestSetResolutionEvent> {
        final /* synthetic */ PlaybackController f5141a;

        public RequestChangeResolutionEventSubscriber(PlaybackController playbackController) {
            this.f5141a = playbackController;
        }

        public final void m5561b(FbEvent fbEvent) {
            RVPRequestSetResolutionEvent rVPRequestSetResolutionEvent = (RVPRequestSetResolutionEvent) fbEvent;
            this.f5141a.m5468a(rVPRequestSetResolutionEvent.f5323b, rVPRequestSetResolutionEvent.f5322a);
        }

        public final Class<RVPRequestSetResolutionEvent> m5560a() {
            return RVPRequestSetResolutionEvent.class;
        }
    }

    /* compiled from: perf_sample_rate */
    class RequestSwitchPlayableUriEventSubscriber extends RichVideoPlayerEventSubscriber<RVPRequestSwitchPlayableUriEvent> {
        final /* synthetic */ PlaybackController f5142a;

        public RequestSwitchPlayableUriEventSubscriber(PlaybackController playbackController) {
            this.f5142a = playbackController;
        }

        public final void m5563b(FbEvent fbEvent) {
            RVPRequestSwitchPlayableUriEvent rVPRequestSwitchPlayableUriEvent = (RVPRequestSwitchPlayableUriEvent) fbEvent;
            if (rVPRequestSwitchPlayableUriEvent.f5324a != null && rVPRequestSwitchPlayableUriEvent.f5324a.equals(this.f5142a.f5103B)) {
                PlaybackController playbackController = this.f5142a;
                playbackController.f5121r.mo477a(rVPRequestSwitchPlayableUriEvent.f5326c, rVPRequestSwitchPlayableUriEvent.f5327d, rVPRequestSwitchPlayableUriEvent.f5325b);
            }
        }

        public final Class<RVPRequestSwitchPlayableUriEvent> m5562a() {
            return RVPRequestSwitchPlayableUriEvent.class;
        }
    }

    /* compiled from: perf_sample_rate */
    class ParamsChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPParamsChangedEvent> {
        final /* synthetic */ PlaybackController f5143a;

        public ParamsChangedEventSubscriber(PlaybackController playbackController) {
            this.f5143a = playbackController;
        }

        public final void m5565b(FbEvent fbEvent) {
            this.f5143a.m5467a(((RVPParamsChangedEvent) fbEvent).f5328a.f4962a);
        }

        public final Class<RVPParamsChangedEvent> m5564a() {
            return RVPParamsChangedEvent.class;
        }
    }

    /* compiled from: perf_sample_rate */
    class SubtitlesLanguageChangeEventSubscriber extends RichVideoPlayerEventSubscriber<RVPRequestSubtitlesLanguageChangeEvent> {
        final /* synthetic */ PlaybackController f5144a;

        public SubtitlesLanguageChangeEventSubscriber(PlaybackController playbackController) {
            this.f5144a = playbackController;
        }

        public final void m5567b(FbEvent fbEvent) {
            RVPRequestSubtitlesLanguageChangeEvent rVPRequestSubtitlesLanguageChangeEvent = (RVPRequestSubtitlesLanguageChangeEvent) fbEvent;
            this.f5144a.f5124u = rVPRequestSubtitlesLanguageChangeEvent.f5097a;
        }

        public final Class<RVPRequestSubtitlesLanguageChangeEvent> m5566a() {
            return RVPRequestSubtitlesLanguageChangeEvent.class;
        }
    }

    /* compiled from: perf_sample_rate */
    class BroadcastStatusChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPBroadcastStatusChangedEvent> {
        final /* synthetic */ PlaybackController f5145a;

        public BroadcastStatusChangedEventSubscriber(PlaybackController playbackController) {
            this.f5145a = playbackController;
        }

        public final void m5569b(FbEvent fbEvent) {
            RVPBroadcastStatusChangedEvent rVPBroadcastStatusChangedEvent = (RVPBroadcastStatusChangedEvent) fbEvent;
            if (rVPBroadcastStatusChangedEvent.f5329a != null && rVPBroadcastStatusChangedEvent.f5329a.equals(this.f5145a.f5103B)) {
                PlaybackController playbackController = this.f5145a;
                GraphQLVideoBroadcastStatus graphQLVideoBroadcastStatus = rVPBroadcastStatusChangedEvent.f5330b;
                GraphQLVideoBroadcastStatus graphQLVideoBroadcastStatus2 = playbackController.f5104C;
                playbackController.f5104C = graphQLVideoBroadcastStatus;
                if (playbackController.f5114k.aa && graphQLVideoBroadcastStatus2 == GraphQLVideoBroadcastStatus.LIVE && playbackController.f5104C != GraphQLVideoBroadcastStatus.LIVE) {
                    playbackController.f5121r.mo503e(EventTriggerType.BY_LIVE_POLLER_TRANSITION);
                }
            }
        }

        public final Class<RVPBroadcastStatusChangedEvent> m5568a() {
            return RVPBroadcastStatusChangedEvent.class;
        }
    }

    /* compiled from: perf_sample_rate */
    public enum State {
        UNPREPARED,
        PREPARED,
        ATTEMPT_TO_PLAY,
        PLAYING,
        SEEKING,
        ATTEMPT_TO_PAUSE,
        PAUSED,
        PLAYBACK_COMPLETE,
        ERROR;

        public final boolean isPlayingState() {
            return this == ATTEMPT_TO_PLAY || this == PLAYING;
        }
    }

    @Inject
    public PlaybackController(@Assisted Boolean bool, @Assisted Boolean bool2, @Assisted Boolean bool3, @Assisted PlayerOrigin playerOrigin, @Assisted Boolean bool4, MonotonicClock monotonicClock, Context context, VideoPlayerManager videoPlayerManager, VideoLoggingUtils videoLoggingUtils, Handler handler, AbstractFbErrorReporter abstractFbErrorReporter, PlayerActivityManager playerActivityManager, AudioManager audioManager, VideoLivePlaybackConfig videoLivePlaybackConfig) {
        TracerDetour.a("PlaybackController.simpleInits", -866365410);
        try {
            this.f5125v = bool.booleanValue();
            this.f5126w = bool4.booleanValue();
            this.f5109f = videoPlayerManager;
            this.f5110g = videoLoggingUtils;
            this.f5112i = abstractFbErrorReporter;
            this.f5111h = new PlayerListener(this);
            this.f5108e = new FirstPlayTracker(this);
            this.f5107d = monotonicClock;
            this.f5113j = playerActivityManager;
            this.f5106c = new StallTimeCalculator(this);
            this.f5129z = audioManager;
            this.f5105b = new ArrayList();
            this.f5105b.add(new RequestPlayingEventSubscriber(this));
            this.f5105b.add(new RequestPausingEventSubscriber(this));
            this.f5105b.add(new RequestSeekingEventSubscriber(this));
            this.f5105b.add(new RequestChangeResolutionEventSubscriber(this));
            this.f5105b.add(new RequestSwitchPlayableUriEventSubscriber(this));
            this.f5105b.add(new ParamsChangedEventSubscriber(this));
            this.f5105b.add(new SubtitlesLanguageChangeEventSubscriber(this));
            this.f5105b.add(new BroadcastStatusChangedEventSubscriber(this));
            this.f5127x = handler;
            this.f5128y = new ArrayList();
            this.f5114k = videoLivePlaybackConfig;
            m5456b(this, -1);
            TracerDetour.a("VideoPlayerManager.createVideoPlayer", 432095295);
            try {
                VideoPlayerManager videoPlayerManager2 = this.f5109f;
                VideoPlayerListener videoPlayerListener = this.f5111h;
                VideoLoggingUtils videoLoggingUtils2 = this.f5110g;
                bool2.booleanValue();
                this.f5121r = videoPlayerManager2.a(context, null, 0, videoPlayerListener, null, videoLoggingUtils2, true, false, bool3.booleanValue(), playerOrigin);
                m5465a(playerOrigin);
                this.f5115l = State.UNPREPARED;
                this.f5104C = bool2.booleanValue() ? GraphQLVideoBroadcastStatus.LIVE : null;
            } finally {
                TracerDetour.a(44700669);
            }
        } finally {
            TracerDetour.a(1182094718);
        }
    }

    public final boolean m5472a() {
        return this.f5126w;
    }

    public final State m5473b() {
        return this.f5115l;
    }

    public final void m5470a(RichVideoPlayerEventBus richVideoPlayerEventBus) {
        RichVideoPlayerPluginUtils.m14937a(richVideoPlayerEventBus, this.f5122s, this.f5105b);
        this.f5122s = richVideoPlayerEventBus;
    }

    public final void m5468a(VideoResolution videoResolution, EventTriggerType eventTriggerType) {
        if (videoResolution != m5476e()) {
            int b = this.f5121r.mo487b();
            this.f5121r.mo479a(videoResolution, eventTriggerType);
            this.f5121r.mo473a(b, EventTriggerType.BY_PLAYER);
        }
    }

    public final void m5464a(EventTriggerType eventTriggerType, int i) {
        int i2 = -1;
        if (this.f5115l != State.PLAYING && this.f5115l != State.ATTEMPT_TO_PLAY && this.f5115l != State.SEEKING) {
            m5455a(this, State.ATTEMPT_TO_PLAY);
            if (this.f5116m != -1) {
                i2 = this.f5116m;
            }
            PlayPosition playPosition = new PlayPosition(i2, i);
            if (this.f5113j.a(this, eventTriggerType != EventTriggerType.BY_AUTOPLAY)) {
                if (!this.f5118o) {
                    m5459v();
                }
                this.f5121r.mo476a(eventTriggerType, playPosition);
                return;
            }
            m5455a(this, State.ERROR);
        }
    }

    public final void m5463a(EventTriggerType eventTriggerType) {
        if (this.f5115l != State.PAUSED && this.f5115l != State.ATTEMPT_TO_PAUSE && this.f5115l != State.PLAYBACK_COMPLETE) {
            m5455a(this, State.ATTEMPT_TO_PAUSE);
            this.f5121r.mo490c(eventTriggerType);
        }
    }

    public final void m5461a(int i, EventTriggerType eventTriggerType) {
        if (this.f5115l != State.PAUSED || i <= 0 || this.f5121r.mo487b() <= 0 || Math.abs(i - this.f5121r.mo487b()) >= 200) {
            if (this.f5115l != State.SEEKING) {
                boolean z = this.f5115l == State.ATTEMPT_TO_PLAY || this.f5115l == State.PLAYING;
                this.f5117n = z;
            }
            m5455a(this, State.SEEKING);
            if (this.f5117n) {
                this.f5121r.mo490c(EventTriggerType.BY_SEEKBAR_CONTROLLER);
            }
            int a = m5454a(i);
            this.f5121r.mo473a(a, eventTriggerType);
            m5456b(this, a);
            if (this.f5117n) {
                m5455a(this, State.ATTEMPT_TO_PLAY);
                this.f5121r.mo474a(EventTriggerType.BY_SEEKBAR_CONTROLLER);
                return;
            }
            m5455a(this, State.PAUSED);
        }
    }

    private int m5454a(int i) {
        if (m5479h() - i < 500) {
            return Math.max(0, i - 1000);
        }
        return i;
    }

    public final void m5466a(PlayerType playerType) {
        this.f5120q = playerType;
        this.f5121r.mo501a(playerType);
    }

    public final void m5465a(PlayerOrigin playerOrigin) {
        this.f5121r.mo500a(playerOrigin);
    }

    public final void m5462a(ChannelEligibility channelEligibility) {
        this.f5121r.mo499a(channelEligibility);
    }

    public final void m5475c() {
        if (this.f5122s != null) {
            this.f5122s.m14878a(new RVPPlayerStateChangedEvent(this.f5103B, State.PLAYBACK_COMPLETE));
        }
    }

    public static void m5455a(PlaybackController playbackController, State state) {
        State state2 = playbackController.f5115l;
        if (playbackController.f5115l != state) {
            playbackController.f5115l = state;
            if (playbackController.f5122s != null) {
                playbackController.f5122s.m14878a(new RVPPlayerStateChangedEvent(playbackController.f5103B, state));
            }
            if (!(playbackController.f5115l.isPlayingState() || playbackController.m5482l())) {
                playbackController.m5460w();
            }
            if (state == State.PLAYING) {
                playbackController.m5457t();
            } else if (state2 == State.PLAYING) {
                playbackController.m5458u();
            }
        }
    }

    public final void m5467a(VideoPlayerParams videoPlayerParams) {
        try {
            this.f5108e.m5550a();
            this.f5121r.mo478a(videoPlayerParams);
            this.f5103B = videoPlayerParams.f4833b;
            m5456b(this, -1);
            m5455a(this, State.PREPARED);
        } catch (Exception e) {
            m5455a(this, State.ERROR);
            this.f5110g.a("Error setting video path. " + e, PlayerType.FULL_SCREEN_PLAYER.value, videoPlayerParams.f4833b, videoPlayerParams.f4832a, null, this.f5121r.mo504g(), this.f5121r.mo496r(), e);
        }
    }

    public final VideoResolution m5476e() {
        return this.f5121r.mo492e();
    }

    public final int m5477f() {
        if (this.f5115l == State.PLAYING || this.f5115l == State.ATTEMPT_TO_PAUSE || this.f5115l == State.PLAYBACK_COMPLETE) {
            return this.f5121r.mo487b();
        }
        return this.f5116m == -1 ? 0 : this.f5116m;
    }

    public final int m5478g() {
        return this.f5121r.mo514s();
    }

    public final int m5479h() {
        return this.f5121r.mo508l();
    }

    public final boolean m5480i() {
        return this.f5121r.mo486a();
    }

    public final boolean m5481k() {
        return this.f5121r.mo505h();
    }

    public final boolean m5482l() {
        return this.f5121r.mo506i();
    }

    public final boolean m5483m() {
        return this.f5115l == State.PLAYBACK_COMPLETE;
    }

    public final boolean m5484n() {
        return this.f5108e.f5135d;
    }

    public final PlayerOrigin m5485o() {
        return this.f5121r.mo504g();
    }

    public final int m5486p() {
        return this.f5121r.mo509m();
    }

    public final void m5474b(EventTriggerType eventTriggerType) {
        this.f5121r.mo502d(eventTriggerType);
    }

    public final void m5471a(boolean z, EventTriggerType eventTriggerType) {
        this.f5118o = z;
        if (this.f5118o) {
            m5460w();
        } else if (this.f5115l.isPlayingState() || m5482l()) {
            m5459v();
        }
        this.f5121r.mo485a(z, eventTriggerType);
    }

    @Nullable
    public final String m5487r() {
        return this.f5121r.mo512p() != null ? this.f5121r.mo512p().f5585f : null;
    }

    public final void m5469a(RichVideoPlayerScheduledRunnable richVideoPlayerScheduledRunnable) {
        this.f5128y.add(richVideoPlayerScheduledRunnable);
        if (this.f5115l == State.PLAYING) {
            m5457t();
        }
    }

    public static void m5456b(PlaybackController playbackController, int i) {
        if (i >= 0 || i == -1) {
            playbackController.f5116m = i;
            return;
        }
        playbackController.f5112i.a(f5101a + ".setLastPlayPositionSafely", StringFormatUtil.formatStrLocaleSafe("Invalid lastPlayPosition: %d", Integer.valueOf(i)));
        playbackController.f5116m = -1;
    }

    public final long m5488s() {
        return this.f5121r.mo515t();
    }

    private void m5457t() {
        m5458u();
        int f = m5477f();
        float h = ((float) f) / ((float) m5479h());
        for (RichVideoPlayerScheduledRunnable richVideoPlayerScheduledRunnable : this.f5128y) {
            if (h < richVideoPlayerScheduledRunnable.a) {
                HandlerDetour.b(this.f5127x, richVideoPlayerScheduledRunnable, (long) (((int) (((float) m5479h()) * richVideoPlayerScheduledRunnable.a)) - f), 124523774);
            } else if (h < richVideoPlayerScheduledRunnable.b) {
                HandlerDetour.a(this.f5127x, richVideoPlayerScheduledRunnable, 1352796833);
            }
        }
    }

    private void m5458u() {
        for (RichVideoPlayerScheduledRunnable a : this.f5128y) {
            HandlerDetour.a(this.f5127x, a);
        }
    }

    private void m5459v() {
        synchronized (this.f5129z) {
            if (!this.f5119p) {
                this.f5129z.requestAudioFocus(this.f5102A, 3, 1);
            }
            this.f5119p = true;
        }
    }

    private void m5460w() {
        synchronized (this.f5129z) {
            if (this.f5119p) {
                this.f5129z.abandonAudioFocus(this.f5102A);
            }
            this.f5119p = false;
        }
    }
}
