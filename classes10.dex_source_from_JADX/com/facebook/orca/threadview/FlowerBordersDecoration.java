package com.facebook.orca.threadview;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.inject.Assisted;
import com.facebook.messaging.modifiers.flowerborder.FlowerCornersDrawable;
import com.facebook.orca.threadview.ThreadViewMessagesListView.Decoration;
import com.facebook.orca.threadview.messagelist.MessageListHelper;
import com.facebook.widget.animatablelistview.AnimatingItemView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: missing video */
public class FlowerBordersDecoration implements Decoration {
    public final Provider<FlowerCornersDrawable> f6921a;
    public final MessageListHelper f6922b;
    public final Map<Long, FlowerBorder> f6923c = new HashMap();
    public final Queue<FlowerBorder> f6924d = new LinkedList();
    private final int f6925e;

    /* compiled from: missing video */
    public class FlowerBorder {
        public final FlowerCornersDrawable f6919a;
        boolean f6920b;

        public FlowerBorder(FlowerCornersDrawable flowerCornersDrawable) {
            this.f6919a = flowerCornersDrawable;
        }
    }

    @Inject
    public FlowerBordersDecoration(Provider<FlowerCornersDrawable> provider, @Assisted MessageListHelper messageListHelper, Resources resources) {
        this.f6921a = provider;
        this.f6922b = messageListHelper;
        this.f6925e = resources.getDimensionPixelSize(2131427893);
    }

    public final void mo244a() {
        ViewGroup a = this.f6922b.mo334a();
        for (int i = 0; i < a.getChildCount(); i++) {
            View childAt = a.getChildAt(i);
            int left = childAt.getLeft();
            int top = childAt.getTop();
            if (childAt instanceof AnimatingItemView) {
                childAt = ((AnimatingItemView) childAt).getWrappedView();
            }
            if (childAt instanceof FlowerBorderContainer) {
                FlowerBorderContainer flowerBorderContainer = (FlowerBorderContainer) childAt;
                if (flowerBorderContainer.mo266a()) {
                    left += flowerBorderContainer.getFlowerBorderLeft() - this.f6925e;
                    top += flowerBorderContainer.getFlowerBorderTop() - this.f6925e;
                    int flowerBorderWidth = (flowerBorderContainer.getFlowerBorderWidth() + left) + (this.f6925e * 2);
                    int flowerBorderHeight = (flowerBorderContainer.getFlowerBorderHeight() + top) + (this.f6925e * 2);
                    long flowerBorderId = flowerBorderContainer.getFlowerBorderId();
                    FlowerBorder flowerBorder = (FlowerBorder) this.f6923c.get(Long.valueOf(flowerBorderId));
                    if (flowerBorder == null) {
                        if (this.f6924d.isEmpty()) {
                            FlowerBorder flowerBorder2 = new FlowerBorder((FlowerCornersDrawable) this.f6921a.get());
                            flowerBorder2.f6919a.setCallback(this.f6922b.mo334a());
                            flowerBorder = flowerBorder2;
                        } else {
                            flowerBorder = (FlowerBorder) this.f6924d.poll();
                            flowerBorder.f6919a.a();
                        }
                        this.f6923c.put(Long.valueOf(flowerBorderId), flowerBorder);
                    }
                    FlowerBorder flowerBorder3 = flowerBorder;
                    flowerBorder3.f6919a.setBounds(left, top, flowerBorderWidth, flowerBorderHeight);
                    flowerBorder3.f6920b = true;
                }
            }
        }
        List list = null;
        for (Long l : this.f6923c.keySet()) {
            FlowerBorder flowerBorder4 = (FlowerBorder) this.f6923c.get(l);
            if (!flowerBorder4.f6920b) {
                if (r3 == null) {
                    list = new ArrayList();
                }
                list.add(l);
            }
            flowerBorder4.f6920b = false;
        }
        if (r3 != null) {
            for (Long l2 : r3) {
                this.f6924d.add(this.f6923c.remove(l2));
            }
        }
    }

    public final void m6553b() {
        this.f6923c.clear();
    }

    public final boolean mo246a(Drawable drawable) {
        for (FlowerBorder flowerBorder : this.f6923c.values()) {
            if (flowerBorder.f6919a == drawable) {
                return true;
            }
        }
        return false;
    }

    public final void mo245a(Canvas canvas) {
        for (FlowerBorder flowerBorder : this.f6923c.values()) {
            flowerBorder.f6919a.draw(canvas);
        }
    }

    public final boolean mo247a(MotionEvent motionEvent) {
        return false;
    }

    public final void mo248c() {
    }

    public final void mo249d() {
    }
}
