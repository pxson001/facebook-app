package com.facebook.greetingcards.render;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.facebook.fbui.draggable.AdvancedDragDetector;
import com.facebook.fbui.draggable.AdvancedDragDetector.DragListener;
import com.facebook.fbui.draggable.Direction;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.inject.Inject;

/* compiled from: zxcAAAsdfghthhhbmwfcz */
public class DraggableView extends FrameLayout {
    public AdvancedDragDetector f167a;

    private static <T extends View> void m187a(Class<T> cls, T t) {
        m188a((Object) t, t.getContext());
    }

    private static void m188a(Object obj, Context context) {
        ((DraggableView) obj).f167a = AdvancedDragDetector.b(FbInjector.get(context));
    }

    public DraggableView(Context context) {
        this(context, null);
    }

    public DraggableView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DraggableView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m189b();
    }

    @Inject
    private void m186a(AdvancedDragDetector advancedDragDetector) {
        this.f167a = advancedDragDetector;
    }

    private void m189b() {
        m187a(DraggableView.class, (View) this);
        this.f167a.p = Direction.DOWN.flag() | Direction.UP.flag();
    }

    public void setDragListener(DragListener dragListener) {
        this.f167a.r = dragListener;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f167a.a(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 202565955);
        boolean b = this.f167a.b(motionEvent);
        Logger.a(2, EntryType.UI_INPUT_END, -713993900, a);
        return b;
    }

    public final void m190a() {
        this.f167a.c();
    }
}
