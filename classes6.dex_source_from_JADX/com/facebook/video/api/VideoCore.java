package com.facebook.video.api;

import com.facebook.common.eventbus.TypedEventBus;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.video.api.Video.State;
import com.facebook.video.api.VideoEvents.BufferingEndEvent;
import com.facebook.video.api.VideoEvents.BufferingStartEvent;
import com.facebook.video.api.VideoEvents.CompletedEvent;
import com.facebook.video.api.VideoEvents.ErrorEvent;
import com.facebook.video.api.VideoEvents.PausedEvent;
import com.facebook.video.api.VideoEvents.PausingEvent;
import com.facebook.video.api.VideoEvents.PreparedEvent;
import com.facebook.video.api.VideoEvents.PreparingEvent;
import com.facebook.video.api.VideoEvents.SeekEndEvent;
import com.facebook.video.api.VideoEvents.SeekStartEvent;
import com.facebook.video.api.VideoEvents.StartingEvent;
import com.facebook.video.api.VideoEvents.StateChangeEvent;
import com.facebook.video.api.VideoEvents.UnpreparedEvent;
import com.facebook.video.api.VideoEvents.UnpreparingEvent;
import com.facebook.video.view.TextureViewImplementation;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: contain-fit */
public class VideoCore<SourceType> implements Video<SourceType> {
    private static final Set<State> f18528a = ImmutableSet.of(State.PLAYING, State.BUFFERING);
    public final TextureViewImplementation f18529b;
    public final TypedEventBus f18530c;
    public final Object f18531d = new Object();
    private State f18532e = State.UNPREPARED;
    public SourceType f18533f = null;
    private boolean f18534g = false;
    public int f18535h = 0;
    public VideoMetadata f18536i;

    /* compiled from: contain-fit */
    public abstract class CheckedCallback {
        final /* synthetic */ VideoCore f18518a;
        private boolean f18519b = true;

        public CheckedCallback(VideoCore videoCore) {
            this.f18518a = videoCore;
        }

        protected final void m27139a() {
            Preconditions.checkArgument(this.f18519b, "The callback is already disabled");
        }

        protected final void m27140b() {
            m27139a();
            this.f18519b = false;
        }
    }

    /* compiled from: contain-fit */
    class PauseCallback extends CheckedCallback implements VideoCore$Implementation$FinishedCallback {
        final /* synthetic */ VideoCore f18520b;
        private final UserReason f18521c;

        public PauseCallback(VideoCore videoCore, UserReason userReason) {
            this.f18520b = videoCore;
            super(videoCore);
            this.f18521c = userReason;
        }

        public final void mo1412a(Throwable th) {
            synchronized (this.f18520b.f18531d) {
                m27140b();
                VideoCore.m27154a(this.f18520b, State.UNPREPARED, 0);
                this.f18520b.f18530c.a(new ErrorEvent(th));
            }
        }

        public final void ej_() {
            synchronized (this.f18520b.f18531d) {
                m27140b();
                VideoCore.m27155a(this.f18520b, "PauseCallback.finished", State.PAUSING);
                VideoCore.m27154a(this.f18520b, State.READY, this.f18520b.f18535h);
                this.f18520b.f18530c.a(new PausedEvent(this.f18520b.f18535h, this.f18521c));
            }
        }
    }

    /* compiled from: contain-fit */
    public class PlayingCallback extends CheckedCallback {
        final /* synthetic */ VideoCore f18522b;

        public PlayingCallback(VideoCore videoCore) {
            this.f18522b = videoCore;
            super(videoCore);
        }

        public final void m27146a(Throwable th) {
            synchronized (this.f18522b.f18531d) {
                m27140b();
                VideoCore.m27154a(this.f18522b, State.ERROR, 0);
                this.f18522b.f18530c.a(new ErrorEvent(th));
            }
        }

        public final void ek_() {
            synchronized (this.f18522b.f18531d) {
                m27139a();
                VideoCore.m27155a(this.f18522b, "PlayCallback.onBufferStart", State.PLAYING);
                VideoCore.m27154a(this.f18522b, State.BUFFERING, -1);
                this.f18522b.f18530c.a(new BufferingStartEvent(this.f18522b.f18529b.a()));
            }
        }

        public final void el_() {
            synchronized (this.f18522b.f18531d) {
                m27139a();
                VideoCore.m27155a(this.f18522b, "PlayCallback.onBufferEnd", State.BUFFERING);
                VideoCore.m27154a(this.f18522b, State.PLAYING, -1);
                this.f18522b.f18530c.a(new BufferingEndEvent(this.f18522b.f18529b.a()));
            }
        }

        public final void m27145a(int i) {
            synchronized (this.f18522b.f18531d) {
                m27139a();
                VideoCore.m27155a(this.f18522b, "PlayCallback.onCompleting", State.PLAYING, State.BUFFERING);
                int max = Math.max(0, i);
                VideoCore.m27154a(this.f18522b, State.PAUSING, max);
                this.f18522b.f18530c.a(new CompletedEvent(max));
                this.f18522b.f18530c.a(new PausingEvent(max, VideoReason.a));
            }
        }

        public final void m27147c() {
            synchronized (this.f18522b.f18531d) {
                m27140b();
                VideoCore.m27155a(this.f18522b, "PlayCallback.onComplete", State.PAUSING);
                VideoCore.m27154a(this.f18522b, State.READY, this.f18522b.f18535h);
                this.f18522b.f18530c.a(new PausedEvent(this.f18522b.f18535h, VideoReason.a));
            }
        }
    }

    /* compiled from: contain-fit */
    class SetPositionCallback extends CheckedCallback implements VideoCore$Implementation$FinishedCallback {
        final /* synthetic */ VideoCore f18523b;
        private final int f18524c;
        private final int f18525d;

        public SetPositionCallback(VideoCore videoCore, int i, int i2) {
            this.f18523b = videoCore;
            super(videoCore);
            this.f18524c = i;
            this.f18525d = i2;
        }

        public final void mo1412a(Throwable th) {
            synchronized (this.f18523b.f18531d) {
                VideoCore.m27154a(this.f18523b, State.ERROR, 0);
                this.f18523b.f18530c.a(new ErrorEvent(th));
            }
        }

        public final void ej_() {
            synchronized (this.f18523b.f18531d) {
                m27140b();
                VideoCore.m27155a(this.f18523b, "SetPositionCallback.finished", State.SEEKING);
                VideoCore.m27154a(this.f18523b, State.READY, this.f18525d);
                this.f18523b.f18530c.a(new SeekEndEvent(this.f18524c, this.f18525d));
            }
        }
    }

    /* compiled from: contain-fit */
    class SetSourceCallback extends CheckedCallback implements VideoCore$Implementation$PrepareCallback {
        final /* synthetic */ VideoCore f18526b;

        public SetSourceCallback(VideoCore videoCore) {
            this.f18526b = videoCore;
            super(videoCore);
        }

        public final void mo1414a(VideoMetadata videoMetadata) {
            synchronized (this.f18526b.f18531d) {
                m27140b();
                VideoCore.m27155a(this.f18526b, "SetSource.finished", State.PREPARING);
                m27149b(videoMetadata);
                this.f18526b.f18536i = videoMetadata;
                VideoCore.m27154a(this.f18526b, State.READY, 0);
                this.f18526b.f18530c.a(new PreparedEvent(this.f18526b.f18533f, this.f18526b.f18536i));
            }
        }

        private static void m27149b(VideoMetadata videoMetadata) {
            Preconditions.checkNotNull(videoMetadata, "Metadata provided by implementation cannot be null");
        }

        public final void mo1415a(Throwable th) {
            synchronized (this.f18526b.f18531d) {
                m27140b();
                VideoCore.m27154a(this.f18526b, State.UNPREPARED, 0);
                this.f18526b.f18530c.a(new ErrorEvent(th));
            }
        }
    }

    /* compiled from: contain-fit */
    class UnSetSourceCallback extends CheckedCallback implements VideoCore$Implementation$FinishedCallback {
        final /* synthetic */ VideoCore f18527b;

        public UnSetSourceCallback(VideoCore videoCore) {
            this.f18527b = videoCore;
            super(videoCore);
        }

        public final void ej_() {
            synchronized (this.f18527b.f18531d) {
                m27140b();
                VideoCore.m27155a(this.f18527b, "UnSetSource.finished", State.UNPREPARING);
                this.f18527b.f18536i = null;
                VideoCore.m27154a(this.f18527b, State.UNPREPARED, 0);
                this.f18527b.f18530c.a(new UnpreparedEvent());
            }
        }

        public final void mo1412a(Throwable th) {
            synchronized (this.f18527b.f18531d) {
                m27140b();
                VideoCore.m27154a(this.f18527b, State.UNPREPARED, 0);
                this.f18527b.f18530c.a(new ErrorEvent(th));
            }
        }
    }

    public VideoCore(TextureViewImplementation textureViewImplementation, TypedEventBus typedEventBus) {
        this.f18529b = textureViewImplementation;
        this.f18530c = typedEventBus;
    }

    public State getCurrentState() {
        State state;
        synchronized (this.f18531d) {
            state = this.f18532e;
        }
        return state;
    }

    public TypedEventBus getEventBus() {
        return this.f18530c;
    }

    public void setSource(@Nullable SourceType sourceType) {
        synchronized (this.f18531d) {
            this.f18533f = sourceType;
            if (sourceType == null) {
                m27155a(this, "unprepare", State.READY);
                m27154a(this, State.UNPREPARING, 0);
                this.f18530c.a(new UnpreparingEvent());
                this.f18529b.a(new UnSetSourceCallback(this));
            } else {
                m27155a(this, "prepare", State.UNPREPARED);
                m27154a(this, State.PREPARING, 0);
                this.f18530c.a(new PreparingEvent(sourceType));
                this.f18529b.a(sourceType, new SetSourceCallback(this));
            }
        }
    }

    public SourceType getSource() {
        SourceType sourceType;
        synchronized (this.f18531d) {
            sourceType = this.f18533f;
        }
        return sourceType;
    }

    public void setPosition(int i) {
        boolean z = true;
        if (i < 0) {
            z = false;
        }
        Preconditions.checkArgument(z);
        synchronized (this.f18531d) {
            m27155a(this, "setPosition", State.READY);
            m27154a(this, State.SEEKING, this.f18535h);
            this.f18530c.a(new SeekStartEvent(this.f18535h, i));
            this.f18529b.a(i, new SetPositionCallback(this, this.f18535h, i));
        }
    }

    public final void mo1403a(UserReason userReason) {
        synchronized (this.f18531d) {
            m27155a(this, "play", State.READY);
            m27154a(this, State.BUFFERING, this.f18535h);
            this.f18530c.a(new StartingEvent(this.f18535h, userReason));
            this.f18529b.a(new PlayingCallback(this));
        }
    }

    public final void mo1404b(UserReason userReason) {
        synchronized (this.f18531d) {
            m27155a(this, "pause", State.READY, State.BUFFERING, State.PLAYING);
            if (this.f18532e == State.READY) {
                return;
            }
            int a = this.f18535h == -1 ? this.f18529b.a() : this.f18535h;
            m27154a(this, State.PAUSING, a);
            this.f18530c.a(new PausingEvent(a, userReason));
            this.f18529b.b(new PauseCallback(this, userReason));
        }
    }

    public VideoMetadata getMetadata() {
        return this.f18536i;
    }

    public int getPosition() {
        if (this.f18535h != -1) {
            return this.f18535h;
        }
        int a = this.f18529b.a();
        Preconditions.checkArgument(a >= 0, "Cannot return a negative position");
        return a;
    }

    @GuardedBy("mPrivateLock")
    public static void m27154a(VideoCore videoCore, State state, int i) {
        boolean z = (i == -1 && f18528a.contains(state)) || i >= 0;
        Preconditions.checkArgument(z);
        State state2 = videoCore.f18532e;
        videoCore.f18532e = state;
        videoCore.f18535h = i;
        videoCore.f18530c.a(new StateChangeEvent(state2, state));
    }

    @GuardedBy("mPrivateLock")
    public static void m27155a(VideoCore videoCore, String str, State... stateArr) {
        int i = 0;
        int length = stateArr.length;
        while (i < length) {
            if (stateArr[i] != videoCore.f18532e) {
                i++;
            } else {
                return;
            }
        }
        throw new IllegalStateException(StringFormatUtil.formatStrLocaleSafe("Cannot %s in state %s", str, videoCore.f18532e));
    }
}
