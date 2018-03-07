package com.facebook.video.api;

import com.facebook.common.eventbus.TypedEventBus;
import com.facebook.common.eventbus.TypedHandler;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.video.api.Video.State;
import com.facebook.video.api.VideoEvents.BufferingEndEvent;
import com.facebook.video.api.VideoEvents.BufferingEndEvent.Handler;
import com.facebook.video.api.VideoEvents.PausingEvent;
import com.facebook.video.api.VideoEvents.StartingEvent;
import com.facebook.video.api.VideoEvents.StateChangeEvent;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import java.util.Set;

/* compiled from: content_attachment */
public class AsyncVideo<SourceType> implements Video<SourceType> {
    private static final Set<State> f18508a = ImmutableSet.of(State.BUFFERING, State.PLAYING);
    private final Video f18509b;
    private final DefaultAndroidThreadUtil f18510c;
    public final PlayRequestedWatcher f18511d;
    private SourceType f18512e;
    private SourceType f18513f = null;
    private Boolean f18514g = null;
    private int f18515h = -1;
    private UserReason f18516i;
    private UserReason f18517j;

    /* compiled from: content_attachment */
    public class C13791 implements TypedHandler {
        public final /* synthetic */ AsyncVideo f18500a;

        C13791(AsyncVideo asyncVideo) {
            this.f18500a = asyncVideo;
        }
    }

    /* compiled from: content_attachment */
    class C13802 implements Runnable {
        final /* synthetic */ AsyncVideo f18501a;

        C13802(AsyncVideo asyncVideo) {
            this.f18501a = asyncVideo;
        }

        public void run() {
            AsyncVideo.m27134b(this.f18501a);
        }
    }

    /* compiled from: content_attachment */
    public class PlayRequestedWatcher implements Handler, PausingEvent.Handler, StartingEvent.Handler {
        public final /* synthetic */ AsyncVideo f18503a;
        public boolean f18504b;
        public int f18505c;
        public UserReason f18506d;
        public boolean f18507e;

        public PlayRequestedWatcher(AsyncVideo asyncVideo) {
            this.f18503a = asyncVideo;
        }

        public final void m27130a(StartingEvent startingEvent) {
            if (this.f18504b) {
                this.f18507e = true;
            }
        }

        public final void mo1401a(BufferingEndEvent bufferingEndEvent) {
            if (this.f18507e) {
                this.f18504b = false;
                this.f18503a.getEventBus().a(new PlayStartedEvent(this.f18505c, bufferingEndEvent.f18537a, this.f18506d));
            }
        }

        public final void mo1402a(PausingEvent pausingEvent) {
            if (this.f18507e && !this.f18504b) {
                this.f18507e = false;
                this.f18503a.getEventBus().a(new PlayPausedEvent(pausingEvent.f18544a, pausingEvent.f18545b));
            }
        }
    }

    public AsyncVideo(Video<SourceType> video, AndroidThreadUtil androidThreadUtil) {
        this.f18509b = video;
        this.f18510c = androidThreadUtil;
        this.f18509b.getEventBus().a(StateChangeEvent.class, new C13791(this));
        this.f18511d = new PlayRequestedWatcher(this);
        PlayRequestedWatcher playRequestedWatcher = this.f18511d;
        TypedEventBus eventBus = this.f18509b.getEventBus();
        eventBus.a(StartingEvent.class, playRequestedWatcher.f18503a.f18511d);
        eventBus.a(BufferingEndEvent.class, playRequestedWatcher.f18503a.f18511d);
        eventBus.a(PausingEvent.class, playRequestedWatcher.f18503a.f18511d);
    }

    public State getCurrentState() {
        return this.f18509b.getCurrentState();
    }

    public TypedEventBus getEventBus() {
        return this.f18509b.getEventBus();
    }

    public void setSource(SourceType sourceType) {
        boolean z = this.f18514g == Boolean.FALSE || !f18508a.contains(this.f18509b.getCurrentState());
        Preconditions.checkArgument(z);
        this.f18513f = sourceType;
        m27133a(this);
    }

    public SourceType getSource() {
        return this.f18513f;
    }

    public void setPosition(int i) {
        boolean z = this.f18514g == Boolean.FALSE || !f18508a.contains(this.f18509b.getCurrentState());
        Preconditions.checkArgument(z, "Cannot call AsyncVideo.setPosition without having called pause before");
        this.f18515h = i;
        m27133a(this);
    }

    public final void mo1403a(UserReason userReason) {
        this.f18514g = Boolean.valueOf(true);
        this.f18516i = userReason;
        m27133a(this);
    }

    public final void mo1404b(UserReason userReason) {
        this.f18514g = Boolean.valueOf(false);
        this.f18517j = userReason;
        m27133a(this);
    }

    public VideoMetadata getMetadata() {
        return this.f18509b.getMetadata();
    }

    public int getPosition() {
        return this.f18511d.f18504b ? this.f18511d.f18505c : this.f18509b.getPosition();
    }

    public static void m27133a(AsyncVideo asyncVideo) {
        asyncVideo.f18510c.b(new C13802(asyncVideo));
    }

    public static void m27134b(AsyncVideo asyncVideo) {
        if (asyncVideo.f18514g == Boolean.TRUE) {
            Object obj = asyncVideo.f18515h != -1 ? 1 : null;
            if (asyncVideo.f18511d.f18504b && obj != null) {
                asyncVideo.m27135c(asyncVideo.f18516i);
            }
            if (!asyncVideo.f18511d.f18504b) {
                int position = asyncVideo.f18515h == -1 ? asyncVideo.getPosition() : asyncVideo.f18515h;
                PlayRequestedWatcher playRequestedWatcher = asyncVideo.f18511d;
                UserReason userReason = asyncVideo.f18516i;
                Preconditions.checkArgument(position >= 0);
                playRequestedWatcher.f18507e = false;
                playRequestedWatcher.f18504b = true;
                playRequestedWatcher.f18505c = position;
                playRequestedWatcher.f18506d = userReason;
                asyncVideo.getEventBus().a(new PlayRequestedEvent(position, asyncVideo.f18516i));
            }
        } else if (asyncVideo.f18514g == Boolean.FALSE && asyncVideo.f18511d.f18504b) {
            asyncVideo.m27135c(asyncVideo.f18517j);
        }
        switch (asyncVideo.f18509b.getCurrentState()) {
            case READY:
                if (asyncVideo.m27136c()) {
                    asyncVideo.f18509b.setSource(null);
                    return;
                } else if (asyncVideo.f18515h != -1) {
                    position = asyncVideo.f18515h;
                    asyncVideo.f18515h = -1;
                    asyncVideo.f18509b.setPosition(position);
                    return;
                } else if (asyncVideo.f18514g == Boolean.TRUE) {
                    asyncVideo.f18514g = null;
                    asyncVideo.f18509b.mo1403a(asyncVideo.f18516i);
                    asyncVideo.f18516i = null;
                    return;
                } else if (asyncVideo.f18514g == Boolean.FALSE) {
                    asyncVideo.f18514g = null;
                    return;
                } else {
                    return;
                }
            case BUFFERING:
            case PLAYING:
                if (asyncVideo.m27136c()) {
                    asyncVideo.f18509b.mo1404b(asyncVideo.f18517j);
                    asyncVideo.f18517j = null;
                    return;
                } else if (asyncVideo.f18515h != -1) {
                    asyncVideo.f18509b.mo1404b(asyncVideo.f18517j);
                    asyncVideo.f18517j = null;
                    return;
                } else if (asyncVideo.f18514g == Boolean.FALSE) {
                    asyncVideo.f18514g = null;
                    asyncVideo.f18509b.mo1404b(asyncVideo.f18517j);
                    asyncVideo.f18517j = null;
                    return;
                } else if (asyncVideo.f18514g == Boolean.TRUE) {
                    asyncVideo.f18514g = null;
                    return;
                } else {
                    return;
                }
            case UNPREPARED:
                if (asyncVideo.f18513f != null) {
                    asyncVideo.f18512e = asyncVideo.f18513f;
                    asyncVideo.f18509b.setSource(asyncVideo.f18513f);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void m27135c(UserReason userReason) {
        UserReason userReason2 = this.f18511d.f18506d;
        this.f18511d.f18504b = false;
        getEventBus().a(new PlayCancelledEvent(userReason2, userReason, getPosition()));
    }

    private boolean m27136c() {
        return !Objects.equal(this.f18512e, this.f18513f);
    }
}
