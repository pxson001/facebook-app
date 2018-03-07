package com.facebook.richdocument.event;

import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.facebook.content.event.FbEvent;
import com.facebook.richdocument.event.RichDocumentEvents.RecyclerViewFocusRequest;
import com.facebook.richdocument.event.RichDocumentEvents.RecyclerViewFocusRequest.RequestType;
import com.facebook.richdocument.view.transition.state.MediaStateMachine;
import com.facebook.richdocument.view.transition.state.MediaStateMachine.Event;

/* compiled from: primary_action_label */
public class RecyclerViewFocusCoordinator extends RichDocumentEventSubscriber<RecyclerViewFocusRequest> {
    private final RecyclerView f5152a;
    private final LinearLayoutManager f5153b = ((LinearLayoutManager) this.f5152a.getLayoutManager());
    private View f5154c;

    public final void m5128b(FbEvent fbEvent) {
        RecyclerViewFocusRequest recyclerViewFocusRequest = (RecyclerViewFocusRequest) fbEvent;
        View view = recyclerViewFocusRequest.f5165b;
        RequestType requestType = recyclerViewFocusRequest.f5164a;
        if (requestType == RequestType.SET_FOCUSED_VIEW) {
            if (view.getParent() == this.f5152a) {
                this.f5154c = view;
            }
        } else if (requestType == RequestType.UNSET_FOCUSED_VIEW) {
            if (view == this.f5152a) {
                if (this.f5154c instanceof MediaStateMachine) {
                    ((MediaStateMachine) this.f5154c).mo447a(Event.UNFOCUSED);
                }
                this.f5154c = null;
            }
        } else if (requestType == RequestType.SCROLL_FOCUSED_VIEW_TO_RECT && view.getParent() == this.f5152a && view == this.f5154c) {
            Rect rect = recyclerViewFocusRequest.f5166c;
            int left = this.f5154c.getLeft() - rect.left;
            int top = this.f5154c.getTop() - rect.top;
            if (left != 0 && this.f5152a.getLayoutManager().g()) {
                this.f5152a.scrollBy(left, 0);
            } else if (top != 0 && this.f5152a.getLayoutManager().h()) {
                if (this.f5153b.l() != 0 || top >= 0) {
                    this.f5152a.scrollBy(0, top);
                    return;
                }
                left = this.f5153b.c(0).getTop();
                if (left < 0) {
                    this.f5152a.scrollBy(0, Math.max(top, left));
                }
            }
        }
    }

    public RecyclerViewFocusCoordinator(RecyclerView recyclerView) {
        this.f5152a = recyclerView;
    }

    public final Class<RecyclerViewFocusRequest> m5127a() {
        return RecyclerViewFocusRequest.class;
    }
}
