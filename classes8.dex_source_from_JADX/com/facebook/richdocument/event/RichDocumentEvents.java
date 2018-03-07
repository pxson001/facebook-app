package com.facebook.richdocument.event;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.richdocument.fetcher.Retryable;
import com.facebook.richdocument.model.block.v2.RichDocumentBlocksImpl;
import com.facebook.richdocument.view.block.impl.VideoBlockViewImpl;
import com.facebook.richdocument.view.transition.MediaTransitionState;
import com.facebook.richdocument.view.widget.media.plugins.MediaRotationPlugin;
import com.facebook.richdocument.view.widget.media.plugins.MediaTiltPlugin;

/* compiled from: price_upper_bound */
public final class RichDocumentEvents {

    /* compiled from: price_upper_bound */
    public class AutoplayCandidateRegisterEvent implements RichDocumentEvent {
        public final VideoBlockViewImpl f5157a;
        public final RequestType f5158b;

        /* compiled from: price_upper_bound */
        public enum RequestType {
            REGISTER,
            UNREGISTER
        }

        public AutoplayCandidateRegisterEvent(VideoBlockViewImpl videoBlockViewImpl, RequestType requestType) {
            this.f5157a = videoBlockViewImpl;
            this.f5158b = requestType;
        }
    }

    /* compiled from: price_upper_bound */
    public class IncomingAnimationCompleteEvent implements RichDocumentEvent {
    }

    /* compiled from: price_upper_bound */
    public class MediaTiltEventListenerRequest implements RichDocumentEvent {
        public final MediaTiltPlugin f5159a;
        public final RequestType f5160b;

        /* compiled from: price_upper_bound */
        public enum RequestType {
            REGISTER,
            UNREGISTER
        }

        public MediaTiltEventListenerRequest(MediaTiltPlugin mediaTiltPlugin, RequestType requestType) {
            this.f5159a = mediaTiltPlugin;
            this.f5160b = requestType;
        }
    }

    /* compiled from: price_upper_bound */
    public class NativeAdsRecyclerViewFocusRequest implements RichDocumentEvent {
        public final RequestType f5161a;
        public final View f5162b;
        public final Rect f5163c;

        /* compiled from: price_upper_bound */
        public enum RequestType {
            NATIVE_ADS_VIDEO_SET_FOCUSED_VIEW,
            NATIVE_ADS_VIDEO_UNSET_FOCUSED_VIEW,
            NATIVE_ADS_VIDEO_SCROLL_FOCUSED_VIEW_TO_RECT
        }

        public NativeAdsRecyclerViewFocusRequest(RequestType requestType, View view, Rect rect) {
            this.f5161a = requestType;
            this.f5162b = view;
            this.f5163c = rect;
        }

        public String toString() {
            return "{event: " + getClass().getSimpleName() + ", type: " + this.f5161a + ", caller: " + this.f5162b + ", rect: " + this.f5163c + "}";
        }
    }

    /* compiled from: price_upper_bound */
    public class OutgoingAnimationCompleteEvent implements RichDocumentEvent {
    }

    /* compiled from: price_upper_bound */
    public class RecyclerViewFocusRequest implements RichDocumentEvent {
        public final RequestType f5164a;
        public final View f5165b;
        public final Rect f5166c;

        /* compiled from: price_upper_bound */
        public enum RequestType {
            SET_FOCUSED_VIEW,
            UNSET_FOCUSED_VIEW,
            SCROLL_FOCUSED_VIEW_TO_RECT
        }

        public RecyclerViewFocusRequest(RequestType requestType, View view, Rect rect) {
            this.f5164a = requestType;
            this.f5165b = view;
            this.f5166c = rect;
        }

        public String toString() {
            return "{event: " + getClass().getSimpleName() + ", type: " + this.f5164a + ", caller: " + this.f5165b + ", rect: " + this.f5166c + "}";
        }
    }

    /* compiled from: price_upper_bound */
    public class RichDocumentBlocksAppendedEvent implements RichDocumentEvent {
        public final RichDocumentBlocksImpl f5167a;
        public final DataFreshnessResult f5168b;
        public final boolean f5169c;

        public RichDocumentBlocksAppendedEvent(RichDocumentBlocksImpl richDocumentBlocksImpl, DataFreshnessResult dataFreshnessResult) {
            this(richDocumentBlocksImpl, dataFreshnessResult, false);
        }

        public RichDocumentBlocksAppendedEvent(RichDocumentBlocksImpl richDocumentBlocksImpl, DataFreshnessResult dataFreshnessResult, boolean z) {
            this.f5167a = richDocumentBlocksImpl;
            this.f5168b = dataFreshnessResult;
            this.f5169c = z;
        }
    }

    /* compiled from: price_upper_bound */
    public class RichDocumentBlocksErrorEvent implements RichDocumentEvent {
        public final RichDocumentBlocksImpl f5170a;
        private final Throwable f5171b;
        public final Retryable f5172c;

        public RichDocumentBlocksErrorEvent(RichDocumentBlocksImpl richDocumentBlocksImpl, Throwable th, Retryable retryable) {
            this.f5170a = richDocumentBlocksImpl;
            this.f5171b = th;
            this.f5172c = retryable;
        }
    }

    /* compiled from: price_upper_bound */
    public class RichDocumentBlocksFetchStartedEvent implements RichDocumentEvent {
    }

    /* compiled from: price_upper_bound */
    public class RichDocumentFirstRenderEvent implements RichDocumentEvent {
        public final long f5173a;
        public final long f5174b;

        public RichDocumentFirstRenderEvent(long j, long j2) {
            this.f5173a = j;
            this.f5174b = j2;
        }
    }

    /* compiled from: price_upper_bound */
    public class RichDocumentFragmentLifeCycleEvent implements RichDocumentEvent {
        public final FragmentLifeCycleEvent f5175a;

        /* compiled from: price_upper_bound */
        public enum FragmentLifeCycleEvent {
            ON_CREATE,
            ON_RESUME,
            ON_PAUSE,
            ON_DESTROY,
            ON_SAVE_INSTANCE_STATE,
            ON_LOW_MEMORY
        }

        public RichDocumentFragmentLifeCycleEvent(FragmentLifeCycleEvent fragmentLifeCycleEvent) {
            this.f5175a = fragmentLifeCycleEvent;
        }
    }

    /* compiled from: price_upper_bound */
    public class RichDocumentMediaSnappingEvent implements RichDocumentEvent {
    }

    /* compiled from: price_upper_bound */
    public class RichDocumentMediaTransitionEvent implements RichDocumentEvent {
        public final Object f5176a;
        public final MediaTransitionState f5177b;
        private final float f5178c;
        public final boolean f5179d;

        public RichDocumentMediaTransitionEvent(Object obj, MediaTransitionState mediaTransitionState, float f, boolean z) {
            this.f5176a = obj;
            this.f5177b = new MediaTransitionState(mediaTransitionState.f6981e, mediaTransitionState.f6982f, mediaTransitionState.f6983g);
            this.f5178c = f;
            this.f5179d = z;
        }
    }

    /* compiled from: price_upper_bound */
    public class RichDocumentPrefetchRequest implements RichDocumentEvent {
        public final String f5180a;

        public RichDocumentPrefetchRequest(String str) {
            this.f5180a = str;
        }
    }

    /* compiled from: price_upper_bound */
    public class RotatableCandidateRegisterEvent implements RichDocumentEvent {
        public final MediaRotationPlugin f5181a;
        public final RequestType f5182b;

        /* compiled from: price_upper_bound */
        public enum RequestType {
            REGISTER,
            UNREGISTER
        }

        public RotatableCandidateRegisterEvent(MediaRotationPlugin mediaRotationPlugin, RequestType requestType) {
            this.f5181a = mediaRotationPlugin;
            this.f5182b = requestType;
        }
    }

    /* compiled from: price_upper_bound */
    public class ScrollValueChangedEvent implements RichDocumentEvent {
        private final int f5183a;
        public final int f5184b;
        public final RecyclerView f5185c;

        public ScrollValueChangedEvent(RecyclerView recyclerView, int i, int i2) {
            this.f5185c = recyclerView;
            this.f5183a = i;
            this.f5184b = i2;
        }
    }

    /* compiled from: price_upper_bound */
    public class StartupUiTasksCompleted implements RichDocumentEvent {
    }
}
