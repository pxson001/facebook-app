package com.facebook.richdocument.view.widget.media;

import android.graphics.Rect;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.inject.InjectableComponentWithoutContext;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.richdocument.view.transition.state.MediaStateMachine.Event;

/* compiled from: nux_empty_state */
public class MediaViewDelegate<V extends MediaView> implements InjectableComponentWithoutContext {
    private final V f7603a;
    public float f7604b;

    /* compiled from: nux_empty_state */
    class C08741 implements OnClickListener {
        final /* synthetic */ MediaViewDelegate f7602a;

        C08741(MediaViewDelegate mediaViewDelegate) {
            this.f7602a = mediaViewDelegate;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -814724696);
            MediaViewDelegate.m7852f(this.f7602a).mo447a(Event.CLICK_MEDIA);
            Logger.a(2, EntryType.UI_INPUT_END, -872866017, a);
        }
    }

    public MediaViewDelegate(V v) {
        this.f7603a = v;
        m7850d();
    }

    public final Rect m7853a() {
        return m7852f(this).mo471a(m7851e());
    }

    private void m7850d() {
        m7851e().setOnClickListener(new C08741(this));
    }

    private View m7851e() {
        return this.f7603a.getView();
    }

    public static MediaFrame m7852f(MediaViewDelegate mediaViewDelegate) {
        return (MediaFrame) mediaViewDelegate.m7851e().getParent().getParent();
    }
}
