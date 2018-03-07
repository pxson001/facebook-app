package com.facebook.video.api;

import com.facebook.common.eventbus.TypedEvent;
import com.facebook.common.eventbus.TypedHandler;
import com.facebook.video.api.AsyncVideo.C13791;
import com.facebook.video.api.Video.State;
import com.facebook.video.player.FullScreenVideoPlayer.NewApiEventHandler;
import com.google.common.base.Preconditions;

/* compiled from: container_type */
public class VideoEvents {

    /* compiled from: container_type */
    public class BufferingEndEvent extends TypedEvent<Handler> {
        public final int f18537a;

        /* compiled from: container_type */
        public interface Handler extends TypedHandler {
            void mo1401a(BufferingEndEvent bufferingEndEvent);
        }

        public final void m27158a(TypedHandler typedHandler) {
            ((Handler) typedHandler).mo1401a(this);
        }

        public BufferingEndEvent(int i) {
            this.f18537a = i;
        }
    }

    /* compiled from: container_type */
    public class BufferingStartEvent extends TypedEvent<Handler> {
        public final int f18538a;

        public final void m27159a(TypedHandler typedHandler) {
            ((NewApiEventHandler) typedHandler).m27740b();
        }

        public BufferingStartEvent(int i) {
            this.f18538a = i;
        }
    }

    /* compiled from: container_type */
    public class BufferingUpdatedEvent extends TypedEvent<Object> {
        public final int f18539a;

        public final /* bridge */ /* synthetic */ void m27160a(TypedHandler typedHandler) {
        }

        public BufferingUpdatedEvent(int i) {
            this.f18539a = i;
        }
    }

    /* compiled from: container_type */
    public class CompletedEvent extends TypedEvent<Handler> {
        public final int f18540a;

        public final /* bridge */ /* synthetic */ void m27161a(TypedHandler typedHandler) {
        }

        public CompletedEvent(int i) {
            this.f18540a = i;
        }
    }

    /* compiled from: container_type */
    public class ErrorEvent extends TypedEvent<Object> {
        public final Throwable f18541a;

        public final /* bridge */ /* synthetic */ void m27162a(TypedHandler typedHandler) {
        }

        public ErrorEvent(Throwable th) {
            this.f18541a = th;
        }
    }

    /* compiled from: container_type */
    public class PausedEvent extends TypedEvent<Object> {
        public final int f18542a;
        public final Reason f18543b;

        public final /* bridge */ /* synthetic */ void m27163a(TypedHandler typedHandler) {
        }

        public PausedEvent(int i, Reason reason) {
            this.f18542a = i;
            this.f18543b = reason;
        }
    }

    /* compiled from: container_type */
    public class PausingEvent extends TypedEvent<Handler> {
        public final int f18544a;
        public final Reason f18545b;

        /* compiled from: container_type */
        public interface Handler extends TypedHandler {
            void mo1402a(PausingEvent pausingEvent);
        }

        public final void m27164a(TypedHandler typedHandler) {
            ((Handler) typedHandler).mo1402a(this);
        }

        public PausingEvent(int i, Reason reason) {
            this.f18544a = i;
            this.f18545b = reason;
        }
    }

    /* compiled from: container_type */
    public class PreparedEvent extends TypedEvent<Object> {
        public final Object f18546a;
        public final VideoMetadata f18547b;

        public final /* bridge */ /* synthetic */ void m27165a(TypedHandler typedHandler) {
        }

        public PreparedEvent(Object obj, VideoMetadata videoMetadata) {
            this.f18546a = Preconditions.checkNotNull(obj);
            this.f18547b = videoMetadata;
        }
    }

    /* compiled from: container_type */
    public class PreparingEvent extends TypedEvent<Object> {
        public final Object f18548a;

        public final /* bridge */ /* synthetic */ void m27166a(TypedHandler typedHandler) {
        }

        public PreparingEvent(Object obj) {
            this.f18548a = obj;
        }
    }

    /* compiled from: container_type */
    public class SeekEndEvent extends TypedEvent<Object> {
        public final int f18549a;
        public final int f18550b;

        public final /* bridge */ /* synthetic */ void m27167a(TypedHandler typedHandler) {
        }

        public SeekEndEvent(int i, int i2) {
            this.f18549a = i;
            this.f18550b = i2;
        }
    }

    /* compiled from: container_type */
    public class SeekStartEvent extends TypedEvent<Object> {
        public final int f18551a;
        public final int f18552b;

        public final /* bridge */ /* synthetic */ void m27168a(TypedHandler typedHandler) {
        }

        public SeekStartEvent(int i, int i2) {
            this.f18551a = i;
            this.f18552b = i2;
        }
    }

    /* compiled from: container_type */
    public class StateChangeEvent extends TypedEvent<Handler> {
        public final State f18553a;
        public final State f18554b;

        public final void m27169a(TypedHandler typedHandler) {
            AsyncVideo.m27133a(((C13791) typedHandler).f18500a);
        }

        public StateChangeEvent(State state, State state2) {
            this.f18553a = state;
            this.f18554b = state2;
        }
    }

    /* compiled from: container_type */
    public class UnpreparedEvent extends TypedEvent<Object> {
        public final /* bridge */ /* synthetic */ void m27170a(TypedHandler typedHandler) {
        }
    }

    /* compiled from: container_type */
    public class UnpreparingEvent extends TypedEvent<Object> {
        public final /* bridge */ /* synthetic */ void m27171a(TypedHandler typedHandler) {
        }
    }
}
