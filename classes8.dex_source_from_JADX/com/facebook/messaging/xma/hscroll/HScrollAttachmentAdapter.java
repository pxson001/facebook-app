package com.facebook.messaging.xma.hscroll;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.messaging.graphql.threads.ThreadQueriesInterfaces.XMAAttachmentStoryFields.Subattachments;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAAttachmentStoryFieldsModel.SubattachmentsModel;
import com.facebook.messaging.xma.SimpleStyleRenderer;
import com.facebook.messaging.xma.StyleRendererManager;
import com.facebook.messaging.xma.XMAView;
import com.facebook.orca.threadview.MessageXMACallbackHelper.1;
import com.facebook.ui.recyclablepager.PagerViewType;
import com.facebook.ui.recyclablepager.RecyclablePagerAdapter;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: time_out */
public final class HScrollAttachmentAdapter extends RecyclablePagerAdapter<Subattachments> {
    public final StyleRendererManager f1580a;
    private final PagerViewType f1581b;
    public final ViewHolder f1582c;
    public final int[] f1583d;
    public ImmutableList<? extends Subattachments> f1584e = RegularImmutableList.a;
    @Nullable
    public SimpleStyleRenderer f1585f;
    @Nullable
    private 1 f1586g;

    /* compiled from: time_out */
    class C01651 implements PagerViewType {
        final /* synthetic */ HScrollAttachmentAdapter f1579a;

        C01651(HScrollAttachmentAdapter hScrollAttachmentAdapter) {
            this.f1579a = hScrollAttachmentAdapter;
        }

        public final Class m1755a() {
            return ViewHolder.class;
        }

        public final View m1754a(Context context) {
            return new ViewHolder(context);
        }
    }

    protected final /* synthetic */ Object m1761b(int i) {
        return m1763f(i);
    }

    @Inject
    public HScrollAttachmentAdapter(Context context, RecyclableViewPoolManager recyclableViewPoolManager, StyleRendererManager styleRendererManager) {
        super(recyclableViewPoolManager);
        this.f1580a = styleRendererManager;
        this.f1582c = new ViewHolder(context);
        this.f1583d = new int[4];
        this.f1581b = new C01651(this);
    }

    public final void m1759a(@Nullable ImmutableList<? extends Subattachments> immutableList) {
        SimpleStyleRenderer simpleStyleRenderer;
        if (!(this.f1584e.isEmpty() || this.f1585f == null)) {
            this.f1584e = RegularImmutableList.a;
            kR_();
        }
        if (immutableList == null) {
            immutableList = RegularImmutableList.a;
        }
        this.f1584e = immutableList;
        ImmutableList immutableList2 = this.f1584e;
        if (immutableList2.isEmpty() || ((SubattachmentsModel) immutableList2.get(0)).d() == null) {
            simpleStyleRenderer = null;
        } else {
            SimpleStyleRenderer a = this.f1580a.m1741a(((SubattachmentsModel) immutableList2.get(0)).d());
            Preconditions.checkState(a instanceof SimpleStyleRenderer);
            int size = immutableList2.size();
            for (int i = 0; i < size; i++) {
                ImmutableList d = ((SubattachmentsModel) immutableList2.get(i)).d();
                Preconditions.checkNotNull(d);
                Preconditions.checkState(a == this.f1580a.m1741a(d));
            }
            simpleStyleRenderer = a;
        }
        this.f1585f = simpleStyleRenderer;
        kR_();
    }

    public final void m1758a(1 1) {
        this.f1586g = 1;
    }

    protected final PagerViewType m1756a(int i) {
        return this.f1581b;
    }

    protected final void m1757a(View view, Object obj, int i) {
        Preconditions.checkState(view instanceof ViewHolder);
        ViewGroup viewGroup = (ViewHolder) view;
        viewGroup.setLayoutParams(new LayoutParams(-1, -2));
        viewGroup.a(i, b(), this.f1583d);
        View childAt = viewGroup.getChildCount() > 0 ? viewGroup.getChildAt(0) : null;
        if (this.f1585f != null) {
            View a;
            Preconditions.checkState(this.f1585f instanceof SimpleStyleRenderer);
            SimpleStyleRenderer simpleStyleRenderer = this.f1585f;
            if (childAt == null) {
                a = simpleStyleRenderer.m1729a(viewGroup);
                if (this.f1586g != null && (a instanceof XMAView)) {
                    ((XMAView) a).setXMACallback(this.f1586g);
                }
                viewGroup.addView(a);
            } else {
                a = childAt;
            }
            simpleStyleRenderer.m1732a(a, m1763f(i));
        }
    }

    protected final SubattachmentsModel m1763f(int i) {
        return (SubattachmentsModel) this.f1584e.get(i);
    }

    public final void m1762b(View view, Object obj) {
        Preconditions.checkState(view instanceof ViewHolder);
        ViewHolder viewHolder = (ViewHolder) view;
        if (this.f1585f != null) {
            View childAt = viewHolder.getChildCount() > 0 ? viewHolder.getChildAt(0) : null;
            if (childAt != null) {
                viewHolder.removeView(childAt);
                this.f1585f.m1731a(childAt);
            }
        }
    }

    public final int m1760b() {
        return this.f1585f != null ? this.f1584e.size() : 0;
    }
}
