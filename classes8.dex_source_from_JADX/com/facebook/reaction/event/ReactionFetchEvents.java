package com.facebook.reaction.event;

import com.facebook.content.event.FbEventSubscriber;
import com.facebook.reaction.ReactionQueryParams;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionStories;
import javax.annotation.Nullable;

/* compiled from: bylineArea */
public class ReactionFetchEvents {

    /* compiled from: bylineArea */
    public abstract class RequestNonCancellationFailureSubscriber extends FbEventSubscriber<RequestNonCancellationFailureEvent> {
        public final Class<RequestNonCancellationFailureEvent> m22531a() {
            return RequestNonCancellationFailureEvent.class;
        }
    }

    /* compiled from: bylineArea */
    public abstract class InvalidResponseSubscriber extends FbEventSubscriber<InvalidResponseEvent> {
        public final Class<InvalidResponseEvent> m22533a() {
            return InvalidResponseEvent.class;
        }
    }

    /* compiled from: bylineArea */
    public abstract class InvalidCacheResponseSubscriber extends FbEventSubscriber<InvalidCacheResponseEvent> {
        public final Class<InvalidCacheResponseEvent> m22535a() {
            return InvalidCacheResponseEvent.class;
        }
    }

    /* compiled from: bylineArea */
    public abstract class ReactionEmptyRequestSubscriber extends FbEventSubscriber<ReactionEmptyRequestEvent> {
        public final Class<ReactionEmptyRequestEvent> m22537a() {
            return ReactionEmptyRequestEvent.class;
        }
    }

    /* compiled from: bylineArea */
    public abstract class ReactionResultSubscriber extends FbEventSubscriber<ReactionResultEvent> {
        public final Class<ReactionResultEvent> m22539a() {
            return ReactionResultEvent.class;
        }
    }

    /* compiled from: bylineArea */
    public abstract class ReactionCacheResultSubscriber extends FbEventSubscriber<ReactionCacheResultEvent> {
        public final Class<ReactionCacheResultEvent> m22541a() {
            return ReactionCacheResultEvent.class;
        }
    }

    /* compiled from: bylineArea */
    public abstract class ReactionSentSubscriber extends FbEventSubscriber<ReactionRequestEvent> {
        public final Class<ReactionRequestEvent> m22543a() {
            return ReactionRequestEvent.class;
        }
    }

    /* compiled from: bylineArea */
    public class InvalidCacheResponseEvent implements ReactionEvent {
        public final String f18883a;
        private final String f18884b;

        public InvalidCacheResponseEvent(String str, String str2) {
            this.f18883a = str;
            this.f18884b = str2;
        }

        public final String mo1120a() {
            return this.f18884b;
        }
    }

    /* compiled from: bylineArea */
    public class InvalidResponseEvent implements ReactionEvent {
        public final String f18885a;
        private final String f18886b;

        public InvalidResponseEvent(String str, String str2) {
            this.f18885a = str;
            this.f18886b = str2;
        }

        public final String mo1120a() {
            return this.f18886b;
        }
    }

    /* compiled from: bylineArea */
    public class ReactionCacheResultEvent implements ReactionEvent {
        public final long f18887a;
        public final long f18888b;
        public final ReactionStories f18889c;
        private final String f18890d;

        public ReactionCacheResultEvent(ReactionStories reactionStories, String str, long j, long j2) {
            this.f18887a = j;
            this.f18888b = j2;
            this.f18889c = reactionStories;
            this.f18890d = str;
        }

        public final String mo1120a() {
            return this.f18890d;
        }
    }

    /* compiled from: bylineArea */
    public class ReactionEmptyRequestEvent implements ReactionEvent {
        private String f18891a;

        public ReactionEmptyRequestEvent(String str) {
            this.f18891a = str;
        }

        public final String mo1120a() {
            return this.f18891a;
        }
    }

    /* compiled from: bylineArea */
    public class ReactionRequestEvent implements ReactionEvent {
        public ReactionQueryParams f18892a;
        private String f18893b;

        public ReactionRequestEvent(String str, @Nullable ReactionQueryParams reactionQueryParams) {
            this.f18893b = str;
            this.f18892a = reactionQueryParams;
        }

        public final String mo1120a() {
            return this.f18893b;
        }
    }

    /* compiled from: bylineArea */
    public class ReactionResultEvent implements ReactionEvent {
        public final long f18894a;
        public final long f18895b;
        public final ReactionStories f18896c;
        private final String f18897d;

        public ReactionResultEvent(ReactionStories reactionStories, String str, long j, long j2) {
            this.f18894a = j;
            this.f18895b = j2;
            this.f18896c = reactionStories;
            this.f18897d = str;
        }

        public final String mo1120a() {
            return this.f18897d;
        }
    }

    /* compiled from: bylineArea */
    public class RequestNonCancellationFailureEvent implements ReactionEvent {
        public final Throwable f18898a;
        private final String f18899b;

        public RequestNonCancellationFailureEvent(Throwable th, String str) {
            this.f18898a = th;
            this.f18899b = str;
        }

        public final String mo1120a() {
            return this.f18899b;
        }
    }
}
