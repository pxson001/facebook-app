package com.facebook.messaging.inbox2.recents;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewParent;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.ChildSharingFrameLayout;
import com.google.common.base.Preconditions;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: send_cancel_request_to_group */
public class ExpandableItemContainer extends ChildSharingFrameLayout {
    private static final Class<?> f2859a = ExpandableItemContainer.class;
    private ExpandedItemViewHost f2860b;
    private ExpandableItemView f2861c;

    /* compiled from: send_cancel_request_to_group */
    class C04661 implements OnKeyListener {
        final /* synthetic */ ExpandableItemContainer f2857a;

        C04661(ExpandableItemContainer expandableItemContainer) {
            this.f2857a = expandableItemContainer;
        }

        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (keyEvent.getAction() != 1 || keyEvent.getKeyCode() != 4 || !this.f2857a.m2824e()) {
                return false;
            }
            this.f2857a.m2823b();
            return true;
        }
    }

    /* compiled from: send_cancel_request_to_group */
    class C04672 implements OnFocusChangeListener {
        final /* synthetic */ ExpandableItemContainer f2858a;

        C04672(ExpandableItemContainer expandableItemContainer) {
            this.f2858a = expandableItemContainer;
        }

        public void onFocusChange(View view, boolean z) {
            Boolean.valueOf(z);
            if (!z && this.f2858a.m2824e()) {
                this.f2858a.m2823b();
            }
        }
    }

    /* compiled from: send_cancel_request_to_group */
    public interface ExpandableItemView {
        InboxRecentItem getInboxItem();

        void lX_();

        void lY_();

        void setExpandableItemContainer(ExpandableItemContainer expandableItemContainer);
    }

    public ExpandableItemContainer(Context context) {
        super(context);
    }

    public ExpandableItemContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ExpandableItemContainer(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void m2821a() {
        if (this.f2860b != null) {
            this.f2860b.mo93a((View) this.f2861c, this.f2861c.getInboxItem());
            this.f2861c.lX_();
        }
    }

    public final void m2823b() {
        if (this.f2860b != null) {
            this.f2860b.mo95b((View) this.f2861c, this.f2861c.getInboxItem());
            this.f2861c.lY_();
        }
    }

    public final void m2822a(String str, Map<String, String> map) {
        this.f2860b.mo94a(str, (Map) map);
    }

    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof ExpandableItemView) {
            Preconditions.checkState(this.f2861c == null);
            this.f2861c = (ExpandableItemView) view;
            this.f2861c.setExpandableItemContainer(this);
            view.setOnKeyListener(new C04661(this));
            view.setOnFocusChangeListener(new C04672(this));
        }
    }

    public final boolean m2824e() {
        return ((View) this.f2861c).getParent() != this;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -847582618);
        super.onAttachedToWindow();
        this.f2860b = m2820f();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1520549645, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 611584732);
        super.onDetachedFromWindow();
        this.f2860b = null;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1321325926, a);
    }

    private ExpandedItemViewHost m2820f() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof ExpandedItemViewHost) {
                return (ExpandedItemViewHost) parent;
            }
        }
        return null;
    }
}
