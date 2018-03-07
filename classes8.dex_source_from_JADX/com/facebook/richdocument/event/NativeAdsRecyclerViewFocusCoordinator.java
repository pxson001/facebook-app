package com.facebook.richdocument.event;

import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.facebook.content.event.FbEvent;
import com.facebook.richdocument.event.RichDocumentEvents.NativeAdsRecyclerViewFocusRequest;
import com.facebook.richdocument.event.RichDocumentEvents.NativeAdsRecyclerViewFocusRequest.RequestType;
import com.facebook.richdocument.view.transition.state.MediaStateMachine;
import com.facebook.richdocument.view.transition.state.MediaStateMachine.Event;

/* compiled from: primary_action_url */
public class NativeAdsRecyclerViewFocusCoordinator extends RichDocumentEventSubscriber<NativeAdsRecyclerViewFocusRequest> {
    private final RecyclerView f5149a;
    private final LinearLayoutManager f5150b = ((LinearLayoutManager) this.f5149a.getLayoutManager());
    private View f5151c;

    public final void m5126b(FbEvent fbEvent) {
        NativeAdsRecyclerViewFocusRequest nativeAdsRecyclerViewFocusRequest = (NativeAdsRecyclerViewFocusRequest) fbEvent;
        View view = nativeAdsRecyclerViewFocusRequest.f5162b;
        RequestType requestType = nativeAdsRecyclerViewFocusRequest.f5161a;
        View view2;
        if (requestType == RequestType.NATIVE_ADS_VIDEO_SET_FOCUSED_VIEW) {
            if (view.getParent() != this.f5149a) {
                view2 = view;
                while (view2.getParent() != null && !(view2.getParent() instanceof RecyclerView)) {
                    view2 = (View) view2.getParent();
                }
                this.f5151c = view2;
            }
        } else if (requestType == RequestType.NATIVE_ADS_VIDEO_UNSET_FOCUSED_VIEW) {
            if (view == this.f5149a) {
                if (this.f5151c instanceof MediaStateMachine) {
                    ((MediaStateMachine) this.f5151c).mo447a(Event.UNFOCUSED);
                }
                this.f5151c = null;
            }
        } else if (requestType == RequestType.NATIVE_ADS_VIDEO_SCROLL_FOCUSED_VIEW_TO_RECT && view.getParent() != this.f5149a) {
            view2 = view;
            while (view2.getParent() != null && !(view2.getParent() instanceof RecyclerView)) {
                view2 = (View) view2.getParent();
            }
            if (view2.getParent() == this.f5149a && view2 == this.f5151c) {
                Rect rect = nativeAdsRecyclerViewFocusRequest.f5163c;
                int left = this.f5151c.getLeft() - rect.left;
                int top = (view.getTop() + this.f5151c.getTop()) - rect.top;
                if (left != 0 && this.f5149a.getLayoutManager().g()) {
                    this.f5149a.scrollBy(left, 0);
                } else if (top != 0 && this.f5149a.getLayoutManager().h()) {
                    if (this.f5150b.l() != 0 || top >= 0) {
                        this.f5149a.scrollBy(0, top);
                        return;
                    }
                    int top2 = this.f5150b.c(0).getTop();
                    if (top2 < 0) {
                        this.f5149a.scrollBy(0, Math.max(top, top2));
                    }
                }
            }
        }
    }

    public NativeAdsRecyclerViewFocusCoordinator(RecyclerView recyclerView) {
        this.f5149a = recyclerView;
    }

    public final Class<NativeAdsRecyclerViewFocusRequest> m5125a() {
        return NativeAdsRecyclerViewFocusRequest.class;
    }
}
