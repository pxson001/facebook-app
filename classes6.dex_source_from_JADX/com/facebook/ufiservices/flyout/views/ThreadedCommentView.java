package com.facebook.ufiservices.flyout.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.api.ufiservices.common.CommentOrderType;
import com.facebook.feedback.abtest.ExperimentsForFeedbackTestModule;
import com.facebook.graphql.model.FeedbackableUtil;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.LazyView;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: current_location_toggled */
public class ThreadedCommentView extends CustomLinearLayout {
    private static final int[] f18214b;
    private static final int f18215c;
    @Inject
    public QeAccessor f18216a;
    private GraphQLComment f18217d;
    private CommentOrderType f18218e;
    private LazyView<TextView> f18219f;
    private LazyView<ThreadedCommentReplyView>[] f18220g;
    private ThreadedCommentFakeComposerView f18221h;
    private LinearLayout f18222i;
    public NavigationListener f18223j;
    private OnClickListener f18224k;
    private boolean f18225l;

    /* compiled from: current_location_toggled */
    class C13301 implements OnClickListener {
        final /* synthetic */ ThreadedCommentView f18210a;

        C13301(ThreadedCommentView threadedCommentView) {
            this.f18210a = threadedCommentView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 694818134);
            if (this.f18210a.f18223j == null) {
                Logger.a(2, EntryType.UI_INPUT_END, 1578833893, a);
                return;
            }
            this.f18210a.f18223j.m26736a();
            LogUtils.a(1924482891, a);
        }
    }

    /* compiled from: current_location_toggled */
    class C13312 implements OnClickListener {
        final /* synthetic */ ThreadedCommentView f18211a;

        C13312(ThreadedCommentView threadedCommentView) {
            this.f18211a = threadedCommentView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -542796298);
            if (this.f18211a.f18223j == null) {
                Logger.a(2, EntryType.UI_INPUT_END, -1113257105, a);
                return;
            }
            this.f18211a.f18223j.m26738b();
            LogUtils.a(1133737062, a);
        }
    }

    /* compiled from: current_location_toggled */
    public interface NavigationListener {
        void m26736a();

        void m26737a(GraphQLComment graphQLComment);

        void m26738b();
    }

    private static <T extends View> void m26742a(Class<T> cls, T t) {
        m26743a((Object) t, t.getContext());
    }

    private static void m26743a(Object obj, Context context) {
        ((ThreadedCommentView) obj).f18216a = (QeAccessor) QeInternalImplMethodAutoProvider.a(FbInjector.get(context));
    }

    private void m26741a(QeAccessor qeAccessor) {
        this.f18216a = qeAccessor;
    }

    static {
        int[] iArr = new int[]{2131563138, 2131563139, 2131563140};
        f18214b = iArr;
        f18215c = iArr.length;
    }

    public ThreadedCommentView(Context context) {
        this(context, null, 0);
    }

    public ThreadedCommentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThreadedCommentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m26740a();
    }

    private void m26740a() {
        m26742a(ThreadedCommentView.class, (View) this);
        setContentView(2130904899);
        setOrientation(1);
        this.f18219f = new LazyView((ViewStub) a(2131563136));
        this.f18224k = new C13301(this);
        this.f18220g = new LazyView[f18215c];
        int i = 0;
        while (i < this.f18220g.length && i < f18214b.length) {
            this.f18220g[i] = new LazyView((ViewStub) a(f18214b[i]));
            i++;
        }
        this.f18222i = (LinearLayout) a(2131563137);
        this.f18221h = (ThreadedCommentFakeComposerView) a(2131563141);
        this.f18221h.setOnClickListener(new C13312(this));
        this.f18225l = this.f18216a.a(ExperimentsForFeedbackTestModule.h, false);
    }

    public final void m26748a(GraphQLComment graphQLComment, CommentOrderType commentOrderType) {
        this.f18217d = graphQLComment;
        this.f18218e = commentOrderType;
        Preconditions.checkNotNull(this.f18217d);
        m26745c();
        m26744b();
        m26746d();
    }

    private void m26744b() {
        for (LazyView c : this.f18220g) {
            c.c();
        }
        ImmutableList replies = getReplies();
        int i = (this.f18217d.z() == null || this.f18217d.z().a() <= 0) ? 0 : 1;
        if (replies.isEmpty()) {
            this.f18222i.setVisibility(8);
            return;
        }
        for (int i2 = 0; i2 < replies.size(); i2++) {
            boolean z;
            final GraphQLComment graphQLComment = (GraphQLComment) replies.get(i2);
            ThreadedCommentReplyView threadedCommentReplyView = (ThreadedCommentReplyView) this.f18220g[i2].a();
            if (this.f18218e == CommentOrderType.RANKED_ORDER && i == 0) {
                z = true;
            } else {
                z = false;
            }
            threadedCommentReplyView.m26735a(graphQLComment, z);
            threadedCommentReplyView.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ThreadedCommentView f18213b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -705799342);
                    if (this.f18213b.f18223j == null) {
                        Logger.a(2, EntryType.UI_INPUT_END, 548732801, a);
                        return;
                    }
                    this.f18213b.f18223j.m26737a(graphQLComment);
                    LogUtils.a(1499972945, a);
                }
            });
            threadedCommentReplyView.setVisibility(0);
        }
        this.f18222i.setVisibility(0);
    }

    private void m26745c() {
        int f = GraphQLHelper.f(this.f18217d.l()) - getReplies().size();
        if (f <= 0) {
            ((TextView) this.f18219f.a()).setVisibility(8);
            return;
        }
        ((TextView) this.f18219f.a()).setText(getResources().getQuantityString(m26747e() ? 2131689547 : 2131689548, f, new Object[]{Integer.valueOf(f)}));
        ((TextView) this.f18219f.a()).setOnClickListener(this.f18224k);
        ((TextView) this.f18219f.a()).setVisibility(0);
    }

    private void m26746d() {
        if (this.f18225l && FeedbackableUtil.b(this.f18217d)) {
            this.f18221h.setVisibility(0);
        } else {
            this.f18221h.setVisibility(8);
        }
    }

    private boolean m26747e() {
        return this.f18218e == CommentOrderType.RANKED_ORDER && this.f18217d.z() != null && this.f18217d.z().a() > 0;
    }

    private ImmutableList<GraphQLComment> getReplies() {
        if (m26747e() && f18215c > 0) {
            return ImmutableList.of(this.f18217d.z().j().get(0));
        }
        ImmutableList i = GraphQLHelper.i(this.f18217d.l());
        int min = Math.min(this.f18218e == CommentOrderType.RANKED_ORDER ? 1 : 3, f18215c);
        return (i.size() <= min ? i : i.subList(0, min)).reverse();
    }

    public void setNavigationListener(NavigationListener navigationListener) {
        this.f18223j = navigationListener;
    }
}
