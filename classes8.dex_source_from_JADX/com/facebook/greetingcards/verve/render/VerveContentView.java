package com.facebook.greetingcards.verve.render;

import android.content.Context;
import android.support.v4.util.SparseArrayCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.facebook.fbui.draggable.AdvancedDragDetector;
import com.facebook.fbui.draggable.Direction;
import com.facebook.greetingcards.verve.VerveActionListener;
import com.facebook.greetingcards.verve.VerveMediaInfoSupplier;
import com.facebook.greetingcards.verve.VerveViewSupplier;
import com.facebook.greetingcards.verve.model.VMColor;
import com.facebook.greetingcards.verve.model.VMDeck;
import com.facebook.greetingcards.verve.model.VMSlide;
import com.facebook.greetingcards.verve.model.VMView;
import com.facebook.greetingcards.verve.model.VMViewType;
import com.facebook.greetingcards.verve.mutablemodel.DeckInfo;
import com.facebook.greetingcards.verve.mutablemodel.Transition;
import com.facebook.greetingcards.verve.mutablemodel.Transition.ViewAnim;
import com.facebook.greetingcards.verve.mutablemodel.TransitionLogic;
import com.facebook.greetingcards.verve.render.DragAndSpringScroller.State;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import java.util.Set;

/* compiled from: view_pyml_tap */
public class VerveContentView extends FrameLayout {
    private static final Class<?> f409a = VerveContentView.class;
    private DragAndSpringScroller f410b;
    public DeckInfo f411c;
    public int f412d = -1;
    public int f413e = -1;
    private SparseArrayCompat<View> f414f;
    private Set<Integer> f415g;
    public TransitionValueSetter f416h;

    /* compiled from: view_pyml_tap */
    public class C00461 {
        final /* synthetic */ VerveContentView f407a;

        C00461(VerveContentView verveContentView) {
            this.f407a = verveContentView;
        }

        public final int m381a(Direction direction) {
            this.f407a.f413e = TransitionUtil.m362a(this.f407a.f411c.f346a, this.f407a.f412d, direction);
            this.f407a.f413e = this.f407a.f413e;
            return TransitionUtil.m361a(this.f407a.f411c.f346a, this.f407a.f413e);
        }

        public final void m382a(double d) {
            Double.valueOf(d);
            this.f407a.f416h.m374a(d);
        }

        public final void m383a(boolean z) {
            if (z) {
                Integer.valueOf(this.f407a.f413e);
                VerveContentView.m396e(this.f407a, this.f407a.f413e);
                return;
            }
            Integer.valueOf(this.f407a.f412d);
            VerveContentView.m396e(this.f407a, this.f407a.f412d);
        }
    }

    public VerveContentView(Context context) {
        super(context);
        m386a();
    }

    public VerveContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m386a();
    }

    public VerveContentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m386a();
    }

    private void m386a() {
        this.f416h = new TransitionValueSetter();
        this.f415g = Sets.b();
        this.f410b = new DragAndSpringScroller(new AdvancedDragDetector(getContext()), this);
        this.f410b.f374f = new C00461(this);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f410b.f371c.a(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1369897095);
        boolean b = this.f410b.f371c.b(motionEvent);
        Logger.a(2, EntryType.UI_INPUT_END, 145964547, a);
        return b;
    }

    public final void m397a(VMDeck vMDeck, VerveViewSupplier verveViewSupplier, VerveActionListener verveActionListener, VerveMediaInfoSupplier verveMediaInfoSupplier) {
        if (this.f411c != null) {
            removeAllViews();
            this.f414f = null;
            this.f411c = null;
            this.f415g.clear();
        }
        this.f412d = -1;
        this.f411c = new DeckInfo(vMDeck, verveViewSupplier, verveActionListener, verveMediaInfoSupplier, 1.0f);
        DeckInfo deckInfo = this.f411c;
        Context context = getContext();
        SparseArrayCompat sparseArrayCompat = new SparseArrayCompat();
        for (int i = 0; i < deckInfo.f346a.slides.size(); i++) {
            if (!((VMSlide) deckInfo.f346a.slides.get(i)).master) {
                VerveViewFactory.m409a(deckInfo.m318b(i), i, deckInfo, context, sparseArrayCompat);
            }
        }
        this.f414f = sparseArrayCompat;
        this.f416h.f396a = this.f414f;
        m395d(TransitionUtil.m363a(vMDeck, vMDeck.initialSlide));
    }

    public VMSlide getCurrentSlide() {
        if (this.f412d == -1) {
            return null;
        }
        DeckInfo deckInfo = this.f411c;
        return (VMSlide) deckInfo.f346a.slides.get(this.f412d);
    }

    public static void m387a(VerveContentView verveContentView, int i) {
        int i2 = verveContentView.f412d;
        DeckInfo deckInfo = verveContentView.f411c;
        Transition a = TransitionLogic.m329a(i2, i, deckInfo.m318b(i2), deckInfo.m318b(i), false);
        ImmutableList immutableList = a.f361a;
        int size = immutableList.size();
        for (int i3 = 0; i3 < size; i3++) {
            ViewAnim viewAnim = (ViewAnim) immutableList.get(i3);
            View view = null;
            switch (viewAnim.f356a) {
                case IN:
                    ViewPropertiesUtil.m415b((View) verveContentView.f414f.a(viewAnim.f358c.f340a), viewAnim.f357b);
                    verveContentView.m389b(viewAnim.f358c.f340a);
                    view = (View) verveContentView.f414f.a(viewAnim.f358c.f340a);
                    break;
                case OUT:
                case MOVE:
                    verveContentView.bringChildToFront((View) verveContentView.f414f.a(viewAnim.f357b.f340a));
                    view = (View) verveContentView.f414f.a(viewAnim.f357b.f340a);
                    break;
            }
            if (view instanceof VerveGroupView) {
                ((VerveGroupView) view).f417a.m379a(verveContentView.f412d, i, viewAnim.f357b, viewAnim.f358c);
            }
        }
        verveContentView.f416h.f397b = a;
        Integer.valueOf(verveContentView.f412d);
        Integer.valueOf(i);
    }

    private void m389b(int i) {
        this.f415g.add(Integer.valueOf(i));
        addView((View) this.f414f.a(i));
    }

    private void m392c(int i) {
        this.f415g.remove(Integer.valueOf(i));
        removeView((View) this.f414f.a(i));
    }

    private void m395d(int i) {
        ImmutableList b = this.f411c.m318b(i);
        int size = b.size();
        for (int i2 = 0; i2 < size; i2++) {
            VMView vMView = (VMView) b.get(i2);
            ViewPropertiesUtil.m413a((View) this.f414f.a(vMView.f340a), vMView);
            m389b(vMView.f340a);
            ((View) this.f414f.a(vMView.f340a)).setAlpha(vMView.m295b());
            if (vMView.m308o() == VMViewType.GROUP) {
                ((VerveGroupView) this.f414f.a(vMView.f340a)).f417a.m377a();
            }
        }
        m396e(this, i);
        DragAndSpringScroller dragAndSpringScroller = this.f410b;
        int a = TransitionUtil.m361a(this.f411c.f346a, i);
        dragAndSpringScroller.f377i = a;
        dragAndSpringScroller.f371c.p = a;
    }

    public static void m396e(VerveContentView verveContentView, int i) {
        Integer.valueOf(i);
        verveContentView.f412d = i;
        DeckInfo deckInfo = verveContentView.f411c;
        VMColor vMColor = (VMColor) deckInfo.f353h.a(i);
        if (vMColor == null) {
            vMColor = deckInfo.f346a.m269a();
        }
        verveContentView.setBackgroundDrawable(ColorParseUtil.m335a(vMColor));
        Set<Integer> a = Sets.a();
        for (Integer intValue : verveContentView.f415g) {
            int intValue2 = intValue.intValue();
            a.add(Integer.valueOf(intValue2));
            if (((VMView) verveContentView.f411c.f354i.a(intValue2)).m308o() == VMViewType.GROUP) {
                ((VerveGroupView) verveContentView.f414f.a(intValue2)).f417a.m378a(i);
            }
        }
        ImmutableList b = verveContentView.f411c.m318b(verveContentView.f412d);
        int size = b.size();
        for (int i2 = 0; i2 < size; i2++) {
            VMView vMView = (VMView) b.get(i2);
            if (verveContentView.f415g.contains(Integer.valueOf(vMView.f340a))) {
                verveContentView.bringChildToFront((View) verveContentView.f414f.a(vMView.f340a));
            } else {
                ViewPropertiesUtil.m413a((View) verveContentView.f414f.a(vMView.f340a), vMView);
                verveContentView.m389b(vMView.f340a);
                if (vMView.m308o() == VMViewType.GROUP) {
                    VerveGroupView verveGroupView = (VerveGroupView) verveContentView.f414f.a(vMView.f340a);
                    verveGroupView.m399a(vMView, verveContentView.f412d);
                    verveGroupView.f417a.m377a();
                }
            }
            a.remove(Integer.valueOf(vMView.f340a));
        }
        for (Integer intValue3 : a) {
            verveContentView.m392c(intValue3.intValue());
        }
    }

    public final boolean m398a(Direction direction) {
        DragAndSpringScroller dragAndSpringScroller = this.f410b;
        boolean z = true;
        Object obj = (dragAndSpringScroller.f377i == Direction.UP.flag() && direction == Direction.DOWN && (dragAndSpringScroller.f376h == State.IDLE || (dragAndSpringScroller.f376h == State.DRAGGING && DragAndSpringScroller.m352d(dragAndSpringScroller) < 0.3d))) ? 1 : null;
        Object obj2;
        if (dragAndSpringScroller.f377i == Direction.DOWN.flag() && direction == Direction.UP && (dragAndSpringScroller.f376h == State.IDLE || (dragAndSpringScroller.f376h == State.DRAGGING && DragAndSpringScroller.m352d(dragAndSpringScroller) < 0.3d))) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        if (!(obj == null && r4 == null)) {
            z = false;
        }
        return z;
    }
}
