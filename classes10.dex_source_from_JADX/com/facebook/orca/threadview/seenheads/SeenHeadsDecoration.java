package com.facebook.orca.threadview.seenheads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.util.LongSparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.inject.Assisted;
import com.facebook.messaging.seenheads.SeenHeadCircleOverflowRendererProvider;
import com.facebook.messaging.util.CircleOverflowRenderer;
import com.facebook.orca.threadview.ThreadViewMessagesFragment.AnonymousClass29;
import com.facebook.orca.threadview.ThreadViewMessagesListView.Decoration;
import com.facebook.orca.threadview.messagelist.MessageListHelper;
import com.facebook.springs.SpringSystem;
import com.facebook.user.model.UserKey;
import com.facebook.user.tiles.UserTileDrawableController;
import com.facebook.user.tiles.UserTileViewParams;
import com.facebook.widget.animatablelistview.AnimatingItemView;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: mailto */
public class SeenHeadsDecoration implements Decoration {
    private final SeenHeadProvider f8322a;
    private final CircleOverflowRenderer f8323b;
    private final SpringSystem f8324c;
    public final MessageListHelper f8325d;
    public final List<SeenHead> f8326e = Lists.a();
    public final LongSparseArray<List<UserKey>> f8327f = new LongSparseArray();
    public final Map<UserKey, Long> f8328g = Maps.c();
    public final LongSparseArray<Integer> f8329h = new LongSparseArray();
    public final List<List<MoveToEndOfItem>> f8330i = Lists.b();
    private final SeenHeadsRowContainer f8331j;
    public AnonymousClass29 f8332k;
    public int f8333l;

    /* compiled from: mailto */
    class DefaultSeenHeadsRowContainer implements SeenHeadsRowContainer {
        final /* synthetic */ SeenHeadsDecoration f8315a;
        private final int f8316b;
        private final int f8317c;
        private final int f8318d;
        private final int f8319e;

        public DefaultSeenHeadsRowContainer(SeenHeadsDecoration seenHeadsDecoration, Resources resources) {
            this.f8315a = seenHeadsDecoration;
            this.f8316b = resources.getDimensionPixelOffset(2131428633);
            this.f8317c = resources.getDimensionPixelSize(2131428634);
            this.f8318d = resources.getDimensionPixelSize(2131428635);
            this.f8319e = resources.getDimensionPixelSize(2131428636);
        }

        public int getBaseSeenHeadRightMarginPx() {
            return this.f8317c;
        }

        public int getBaseSeenHeadBottomMarginPx() {
            return this.f8318d;
        }

        public int getSeenHeadSpacingPx() {
            return this.f8319e;
        }

        public int getMaxSeenHeadCount() {
            return Math.min((this.f8315a.f8325d.mo334a().getWidth() - this.f8316b) / (this.f8315a.f8333l + this.f8319e), 14);
        }
    }

    /* compiled from: mailto */
    class MoveToEndOfItem {
        public final UserKey f8320a;
        public final long f8321b;

        public MoveToEndOfItem(UserKey userKey, long j) {
            this.f8320a = userKey;
            this.f8321b = j;
        }
    }

    @Inject
    public SeenHeadsDecoration(Resources resources, SeenHeadProvider seenHeadProvider, SeenHeadCircleOverflowRendererProvider seenHeadCircleOverflowRendererProvider, SpringSystem springSystem, @Assisted MessageListHelper messageListHelper) {
        this.f8322a = seenHeadProvider;
        this.f8323b = seenHeadCircleOverflowRendererProvider.a().a();
        this.f8324c = springSystem;
        this.f8325d = messageListHelper;
        this.f8331j = new DefaultSeenHeadsRowContainer(this, resources);
        this.f8333l = resources.getDimensionPixelSize(2131428631);
    }

    public final void m8290a(LongSparseArray<List<UserKey>> longSparseArray, LongSparseArray<Integer> longSparseArray2) {
        this.f8329h.b();
        int a = longSparseArray2.a();
        for (int i = 0; i < a; i++) {
            this.f8329h.b(longSparseArray2.b(i), longSparseArray2.c(i));
        }
        List<SeenHead> arrayList = new ArrayList(this.f8326e);
        boolean isEmpty = this.f8326e.isEmpty();
        for (int i2 = 0; i2 < longSparseArray.a(); i2++) {
            long b = longSparseArray.b(i2);
            List list = (List) longSparseArray.c(i2);
            for (int i3 = 0; i3 < list.size(); i3++) {
                UserKey userKey = (UserKey) list.get(i3);
                if (isEmpty) {
                    SeenHead c = m8284c(userKey);
                    c.f8303a = b;
                    c.f8304b = ((Integer) longSparseArray2.a(b)).intValue();
                    c.f8305c = i3;
                    this.f8326e.add(c);
                    m8286c(userKey, b);
                } else {
                    SeenHead b2 = m8282b(userKey);
                    m8279a(userKey, b);
                    if (b2 != null) {
                        Integer num = (Integer) longSparseArray2.a(b2.f8303a, null);
                        if (num != null) {
                            b2.f8304b = num.intValue();
                        }
                        arrayList.remove(b2);
                    }
                }
            }
        }
        for (SeenHead seenHead : arrayList) {
            seenHead.m8271e();
            m8278a(seenHead.f8312j);
            this.f8326e.remove(seenHead);
            seenHead.m8272f();
        }
    }

    public final void mo244a() {
        for (SeenHead seenHead : this.f8326e) {
            int a = m8274a(seenHead);
            int b = m8281b(seenHead);
            seenHead.f8313k = a;
            seenHead.f8314l = b;
            SeenHead.m8267g(seenHead);
        }
    }

    private void m8279a(UserKey userKey, long j) {
        Long l = (Long) this.f8328g.get(userKey);
        if (l == null || j != l.longValue()) {
            if (l != null) {
                List list = (List) this.f8327f.a(l.longValue());
                if (!(list == null || list.isEmpty() || userKey.equals((UserKey) list.get(0)))) {
                    m8283b(userKey, l.longValue());
                }
            }
            m8283b(userKey, j);
            m8286c(userKey, j);
        }
    }

    private void m8283b(UserKey userKey, long j) {
        List list;
        if (this.f8330i.isEmpty()) {
            list = null;
        } else {
            List<MoveToEndOfItem> list2 = (List) this.f8330i.get(this.f8330i.size() - 1);
            for (MoveToEndOfItem moveToEndOfItem : list2) {
                if (moveToEndOfItem.f8321b != j) {
                    if (moveToEndOfItem.f8320a.equals(userKey)) {
                    }
                }
                list = null;
            }
        }
        if (list == null) {
            list = Lists.a();
            this.f8330i.add(list);
        }
        list.add(new MoveToEndOfItem(userKey, j));
    }

    private void m8286c(UserKey userKey, long j) {
        Long l = (Long) this.f8328g.get(userKey);
        if (l == null || l.longValue() != j) {
            if (l != null) {
                m8278a(userKey);
            }
            this.f8328g.put(userKey, Long.valueOf(j));
            List list = (List) this.f8327f.a(j);
            if (list == null) {
                list = Lists.a();
                this.f8327f.b(j, list);
            }
            list.add(0, userKey);
        }
    }

    private void m8278a(UserKey userKey) {
        Long l = (Long) this.f8328g.remove(userKey);
        if (l != null) {
            List list = (List) this.f8327f.a(l.longValue());
            if (list != null) {
                list.remove(userKey);
                if (list.isEmpty()) {
                    this.f8327f.b(l.longValue());
                }
            }
        }
    }

    private SeenHead m8282b(UserKey userKey) {
        for (SeenHead seenHead : this.f8326e) {
            if (seenHead.f8312j.equals(userKey)) {
                return seenHead;
            }
        }
        return null;
    }

    private SeenHead m8284c(UserKey userKey) {
        SeenHeadProvider seenHeadProvider = this.f8322a;
        SeenHead seenHead = new SeenHead((Context) seenHeadProvider.getInstance(Context.class), UserTileDrawableController.b(seenHeadProvider), this.f8324c);
        seenHead.f8312j = userKey;
        seenHead.f8306d.a(UserTileViewParams.a(userKey));
        seenHead.f8306d.m.setCallback(this.f8325d.mo334a());
        return seenHead;
    }

    private void m8287e() {
        if (!this.f8330i.isEmpty()) {
            int i = 0;
            for (SeenHead b : this.f8326e) {
                if (b.m8269b()) {
                    i = 1;
                    break;
                }
            }
            while (i == 0 && !this.f8330i.isEmpty()) {
                int i2 = i;
                for (MoveToEndOfItem moveToEndOfItem : (List) this.f8330i.remove(0)) {
                    Integer num;
                    SeenHead c;
                    UserKey userKey = moveToEndOfItem.f8320a;
                    SeenHead b2 = m8282b(userKey);
                    Integer num2 = (Integer) this.f8329h.a(moveToEndOfItem.f8321b, null);
                    if (num2 != null) {
                        num = num2;
                    } else if (b2 != null && moveToEndOfItem.f8321b == b2.f8303a) {
                        num = Integer.valueOf(b2.f8304b);
                    }
                    int i3;
                    if (b2 != null) {
                        i3 = b2.f8305c;
                    } else {
                        i3 = Integer.MAX_VALUE;
                    }
                    int i4 = i2;
                    for (SeenHead c2 : this.f8326e) {
                        if (c2 != b2) {
                            if (c2.f8303a == moveToEndOfItem.f8321b && ((b2 != null && b2.f8303a != moveToEndOfItem.f8321b) || c2.f8305c <= r3)) {
                                m8276a(c2, 1);
                            } else if (b2 != null && moveToEndOfItem.f8321b != b2.f8303a && c2.f8303a == b2.f8303a && c2.f8305c > r3) {
                                m8276a(c2, -1);
                            }
                            i4 |= c2.m8269b();
                        }
                    }
                    if (b2 == null) {
                        c2 = m8284c(userKey);
                        c2.f8303a = moveToEndOfItem.f8321b;
                        c2.f8304b = num.intValue();
                        c2.f8305c = 0;
                        this.f8326e.add(c2);
                    } else {
                        c2 = b2;
                    }
                    m8277a(c2, moveToEndOfItem.f8321b, num.intValue(), 0);
                    i2 = c2.m8269b() | i4;
                }
                i = i2;
            }
        }
    }

    private void m8276a(SeenHead seenHead, int i) {
        m8277a(seenHead, seenHead.f8303a, seenHead.f8304b, seenHead.f8305c + i);
    }

    private void m8277a(SeenHead seenHead, long j, int i, int i2) {
        int a = m8274a(seenHead);
        int b = m8281b(seenHead);
        seenHead.f8303a = j;
        seenHead.f8304b = i;
        seenHead.f8305c = i2;
        seenHead.m8268a(a, b, m8274a(seenHead), m8281b(seenHead));
    }

    public final void mo245a(Canvas canvas) {
        int i = 0;
        m8287e();
        int i2 = 0;
        for (SeenHead seenHead : this.f8326e) {
            if (seenHead.f8305c > 0 || seenHead.m8270c()) {
                m8275a(canvas, seenHead);
            } else {
                i2 = 1;
            }
        }
        if (i2 != 0) {
            for (SeenHead seenHead2 : this.f8326e) {
                if (seenHead2.f8305c == 0 && !seenHead2.m8270c()) {
                    m8275a(canvas, seenHead2);
                }
            }
        }
        int a = this.f8327f.a();
        while (i < a) {
            Integer num = (Integer) this.f8329h.a(this.f8327f.b(i), null);
            if (num != null) {
                Object obj;
                i2 = num.intValue();
                if (i2 < this.f8325d.mo357e() || i2 > this.f8325d.mo358f()) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj != null) {
                    SeenHeadsRowContainer c = m8285c(num.intValue());
                    i2 = ((List) this.f8327f.c(i)).size();
                    int maxSeenHeadCount = c.getMaxSeenHeadCount();
                    if (i2 > maxSeenHeadCount) {
                        this.f8323b.a(canvas, (i2 - maxSeenHeadCount) + 1, m8273a(num.intValue(), maxSeenHeadCount - 1), m8280b(num.intValue()));
                    }
                }
            }
            i++;
        }
    }

    public final boolean mo247a(MotionEvent motionEvent) {
        if (this.f8332k == null) {
            return false;
        }
        for (SeenHead seenHead : this.f8326e) {
            Object obj;
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            Rect bounds = seenHead.f8306d.m.getBounds();
            int max = Math.max(bounds.width(), seenHead.f8309g);
            int max2 = Math.max(bounds.height(), seenHead.f8309g);
            int centerX = bounds.centerX() - (max / 2);
            int centerY = bounds.centerY() - (max2 / 2);
            if (x < centerX || x >= max + centerX || y < centerY || y >= centerY + max2) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                this.f8332k.m7459a(seenHead.f8303a);
                return true;
            }
        }
        return false;
    }

    private void m8275a(Canvas canvas, SeenHead seenHead) {
        List list = (List) this.f8327f.a(seenHead.f8303a);
        if (list != null) {
            int maxSeenHeadCount = m8285c(seenHead.f8304b).getMaxSeenHeadCount();
            if ((list.size() > maxSeenHeadCount ? 1 : null) != null && seenHead.f8305c >= maxSeenHeadCount - 1) {
                return;
            }
        }
        Drawable drawable = seenHead.f8306d.m;
        Rect bounds = drawable.getBounds();
        if (bounds.bottom >= 0 && bounds.top < canvas.getHeight()) {
            drawable.draw(canvas);
        }
    }

    public final boolean mo246a(Drawable drawable) {
        for (SeenHead seenHead : this.f8326e) {
            Object obj;
            if (seenHead.f8306d.m == drawable) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                return true;
            }
        }
        return false;
    }

    public final void mo248c() {
        for (SeenHead seenHead : this.f8326e) {
            seenHead.f8306d.c();
        }
    }

    public final void mo249d() {
        for (SeenHead e : this.f8326e) {
            e.m8271e();
        }
    }

    private int m8274a(SeenHead seenHead) {
        return m8273a(seenHead.f8304b, seenHead.f8305c);
    }

    private int m8273a(int i, int i2) {
        SeenHeadsRowContainer c = m8285c(i);
        int baseSeenHeadRightMarginPx = c.getBaseSeenHeadRightMarginPx();
        int seenHeadSpacingPx = c.getSeenHeadSpacingPx();
        return ((this.f8325d.mo334a().getWidth() - baseSeenHeadRightMarginPx) - this.f8333l) - (Math.min(i2, c.getMaxSeenHeadCount() - 1) * (seenHeadSpacingPx + this.f8333l));
    }

    private int m8281b(SeenHead seenHead) {
        return m8280b(seenHead.f8304b);
    }

    private int m8280b(int i) {
        int e = i - this.f8325d.mo357e();
        ViewGroup a = this.f8325d.mo334a();
        if (e < 0) {
            return -this.f8333l;
        }
        if (e >= a.getChildCount()) {
            return a.getHeight();
        }
        View childAt = a.getChildAt(e);
        return (childAt.getBottom() - m8285c(i).getBaseSeenHeadBottomMarginPx()) - this.f8333l;
    }

    private SeenHeadsRowContainer m8285c(int i) {
        View childAt = this.f8325d.mo334a().getChildAt(i - this.f8325d.mo357e());
        if (childAt instanceof AnimatingItemView) {
            childAt = ((AnimatingItemView) childAt).getWrappedView();
        }
        if (childAt instanceof SeenHeadsRowContainer) {
            return (SeenHeadsRowContainer) childAt;
        }
        return this.f8331j;
    }
}
