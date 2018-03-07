package com.facebook.richdocument.view.autoplay;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.event.FbEvent;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.richdocument.event.RichDocumentEventBus;
import com.facebook.richdocument.event.RichDocumentEventSubscribers.ScrollValueChangedEventSubscriber;
import com.facebook.richdocument.event.RichDocumentEvents.ScrollValueChangedEvent;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

@ContextScoped
/* compiled from: parallel_search_ready */
public class ViewLocationTracker extends ScrollValueChangedEventSubscriber {
    private static ViewLocationTracker f6585f;
    private static final Object f6586g = new Object();
    private final List<ViewInfoHolder> f6587a = new ArrayList();
    private final List<ViewInfoHolder> f6588b = new ArrayList();
    private final List<ViewInfoHolder> f6589c = new ArrayList();
    private final RichDocumentEventBus f6590d;
    private int f6591e;

    /* compiled from: parallel_search_ready */
    public class ViewInfoHolder {
        final View f6578a;
        public final ViewLocationListener f6579b;
        final ViewLocationOffsetParams f6580c;
        public int f6581d;
        public int f6582e;

        public ViewInfoHolder(View view, ViewLocationListener viewLocationListener, ViewLocationOffsetParams viewLocationOffsetParams) {
            this.f6578a = view;
            this.f6579b = viewLocationListener;
            this.f6580c = viewLocationOffsetParams;
        }

        public final boolean m6893a(int i) {
            return i >= this.f6581d && i <= this.f6582e;
        }

        public final boolean m6892a() {
            return (this.f6578a == null || this.f6579b == null) ? false : true;
        }

        public final void m6894b() {
            if (m6892a()) {
                this.f6579b.mo372a();
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ViewInfoHolder)) {
                return super.equals(obj);
            }
            return this.f6579b == ((ViewInfoHolder) obj).f6579b;
        }
    }

    /* compiled from: parallel_search_ready */
    public interface ViewLocationListener {
        void mo372a();

        void mo373b();
    }

    /* compiled from: parallel_search_ready */
    public class ViewLocationOffsetParams {
        public final Unit f6583a;
        public final int f6584b;

        /* compiled from: parallel_search_ready */
        public enum Unit {
            PIXEL,
            PERCENTAGE
        }

        public ViewLocationOffsetParams(Unit unit, int i) {
            this.f6583a = unit;
            this.f6584b = i;
        }
    }

    private static ViewLocationTracker m6900b(InjectorLike injectorLike) {
        return new ViewLocationTracker(RichDocumentEventBus.m5130a(injectorLike));
    }

    public final void m6903b(FbEvent fbEvent) {
        ScrollValueChangedEvent scrollValueChangedEvent = (ScrollValueChangedEvent) fbEvent;
        int i = 0;
        this.f6591e += scrollValueChangedEvent.f5184b;
        int i2 = 0;
        while (i2 < this.f6588b.size()) {
            ViewInfoHolder viewInfoHolder = (ViewInfoHolder) this.f6588b.get(i2);
            if (!viewInfoHolder.m6892a()) {
                this.f6588b.remove(i2);
                i2--;
            } else if (!viewInfoHolder.m6893a(this.f6591e)) {
                if (viewInfoHolder.m6892a()) {
                    viewInfoHolder.f6579b.mo373b();
                }
                this.f6589c.add(viewInfoHolder);
                this.f6588b.remove(i2);
                i2--;
            }
            i2++;
        }
        while (i < this.f6589c.size()) {
            viewInfoHolder = (ViewInfoHolder) this.f6589c.get(i);
            if (!viewInfoHolder.m6892a()) {
                this.f6589c.remove(i);
                i--;
            } else if (viewInfoHolder.m6893a(this.f6591e)) {
                viewInfoHolder.m6894b();
                this.f6588b.add(viewInfoHolder);
                this.f6589c.remove(i);
                i--;
            }
            i++;
        }
        m6898a(scrollValueChangedEvent.f5185c);
    }

    @Inject
    public ViewLocationTracker(RichDocumentEventBus richDocumentEventBus) {
        this.f6590d = richDocumentEventBus;
        this.f6590d.a(this);
    }

    public static ViewLocationTracker m6897a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ViewLocationTracker b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6586g) {
                ViewLocationTracker viewLocationTracker;
                if (a2 != null) {
                    viewLocationTracker = (ViewLocationTracker) a2.a(f6586g);
                } else {
                    viewLocationTracker = f6585f;
                }
                if (viewLocationTracker == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m6900b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6586g, b3);
                        } else {
                            f6585f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = viewLocationTracker;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private void m6898a(RecyclerView recyclerView) {
        int[] iArr = new int[2];
        int i = 0;
        while (i < this.f6587a.size()) {
            ViewInfoHolder viewInfoHolder = (ViewInfoHolder) this.f6587a.get(i);
            if (viewInfoHolder.f6578a == null || viewInfoHolder.f6579b == null) {
                this.f6587a.remove(i);
                i--;
            } else {
                View view = viewInfoHolder.f6578a;
                view.getLocationOnScreen(iArr);
                if (iArr[0] >= 0 || iArr[1] >= 0) {
                    int i2;
                    int height = recyclerView.getHeight();
                    int top = iArr[1] - recyclerView.getTop();
                    ViewLocationOffsetParams viewLocationOffsetParams = viewInfoHolder.f6580c;
                    if (viewLocationOffsetParams.f6583a == Unit.PIXEL) {
                        i2 = viewLocationOffsetParams.f6584b;
                    } else {
                        i2 = (recyclerView.getHeight() * viewLocationOffsetParams.f6584b) / 100;
                    }
                    int i3 = i2;
                    height = (this.f6591e + top) - (height - i3);
                    int height2 = (view.getHeight() + (top + this.f6591e)) - i3;
                    viewInfoHolder.f6581d = height;
                    viewInfoHolder.f6582e = height2;
                    if (viewInfoHolder.m6893a(this.f6591e)) {
                        this.f6588b.add(viewInfoHolder);
                        viewInfoHolder.m6894b();
                    } else {
                        this.f6589c.add(viewInfoHolder);
                    }
                    this.f6587a.remove(i);
                    i--;
                }
            }
            i++;
        }
    }

    public final void m6902a(View view, ViewLocationOffsetParams viewLocationOffsetParams, ViewLocationListener viewLocationListener) {
        ViewInfoHolder viewInfoHolder = new ViewInfoHolder(view, viewLocationListener, viewLocationOffsetParams);
        if (!this.f6587a.contains(viewInfoHolder)) {
            this.f6587a.add(viewInfoHolder);
        }
    }

    public final void m6901a(View view) {
        m6899a(this.f6587a, view);
        m6899a(this.f6588b, view);
        m6899a(this.f6589c, view);
    }

    private static void m6899a(List<ViewInfoHolder> list, View view) {
        int i = 0;
        while (i < list.size()) {
            if (((ViewInfoHolder) list.get(i)).f6578a == view) {
                list.remove(i);
                i--;
            }
            i++;
        }
    }
}
