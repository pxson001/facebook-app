package com.facebook.feedback.ui;

import com.facebook.graphql.model.GraphQLComment;
import com.facebook.widget.listview.BaseProxyOnScrollListener;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;
import java.util.ArrayList;
import java.util.List;

/* compiled from: selected_option_id */
public class CommentListScrollStateController {
    public final CommentAdapter f4279a;
    public final ScrollingProxy f4280b;
    public ScrollingViewProxy f4281c;
    public GraphQLComment f4282d;
    public int f4283e;
    public boolean f4284f;
    public int f4285g;
    public CommentListOnScrollListener f4286h = new CommentListOnScrollListener(this);
    public List<OnScrollListener> f4287i = new ArrayList();

    /* compiled from: selected_option_id */
    public interface ScrollingProxy {
        int mo196a();
    }

    /* compiled from: selected_option_id */
    class CommentListOnScrollListener extends BaseProxyOnScrollListener {
        final /* synthetic */ CommentListScrollStateController f4278a;

        /* compiled from: selected_option_id */
        class C03871 implements Runnable {
            final /* synthetic */ CommentListOnScrollListener f4277a;

            C03871(CommentListOnScrollListener commentListOnScrollListener) {
                this.f4277a = commentListOnScrollListener;
            }

            public void run() {
                if (this.f4277a.f4278a.f4281c != null && this.f4277a.f4278a.f4281c.o().getCount() > this.f4277a.f4278a.f4285g) {
                    this.f4277a.f4278a.f4281c.a(0, 0);
                    this.f4277a.f4278a.f4281c.h(this.f4277a.f4278a.f4285g);
                }
            }
        }

        public CommentListOnScrollListener(CommentListScrollStateController commentListScrollStateController) {
            this.f4278a = commentListScrollStateController;
        }

        public final void m4874a(ScrollingViewProxy scrollingViewProxy, int i) {
            if (i == 0 && this.f4278a.f4284f) {
                this.f4278a.f4284f = false;
                if (this.f4278a.f4281c != null) {
                    this.f4278a.f4281c.a(new C03871(this));
                }
            }
        }
    }

    public CommentListScrollStateController(CommentAdapter commentAdapter, ScrollingProxy scrollingProxy) {
        this.f4279a = commentAdapter;
        this.f4280b = scrollingProxy;
    }

    public final void m4878a(OnScrollListener onScrollListener) {
        if (this.f4281c == null) {
            this.f4287i.add(onScrollListener);
        } else {
            this.f4281c.b(onScrollListener);
        }
    }

    public final boolean m4879a() {
        return this.f4281c == null ? true : this.f4281c.l();
    }

    public final void m4882e() {
        if (this.f4281c != null) {
            m4877a(this.f4282d, this.f4283e);
            this.f4282d = null;
            this.f4283e = 0;
        }
    }

    public final boolean m4883f() {
        return this.f4281c != null && m4876a(this.f4281c.s() - 1, 0);
    }

    public final boolean m4884g() {
        return this.f4281c != null && m4875a(this.f4281c.s() - 1);
    }

    public final boolean m4881a(String str) {
        if (this.f4281c == null) {
            return false;
        }
        int i;
        if (str == null) {
            i = -1;
        } else {
            int a = this.f4280b.mo196a();
            i = a;
            while (i < this.f4279a.getCount() + a) {
                GraphQLComment c = this.f4279a.m4796c(i - a);
                if (c != null && str.equals(c.y())) {
                    break;
                }
                i++;
            }
            i = -1;
        }
        return m4875a(i);
    }

    public final boolean m4880a(GraphQLComment graphQLComment) {
        return m4877a(graphQLComment, 0);
    }

    private boolean m4877a(GraphQLComment graphQLComment, int i) {
        if (this.f4281c == null) {
            return false;
        }
        int i2;
        if (graphQLComment == null) {
            i2 = -1;
        } else {
            int a = this.f4280b.mo196a();
            i2 = a;
            while (i2 < this.f4279a.getCount() + a) {
                GraphQLComment c = this.f4279a.m4796c(i2 - a);
                if (c != null && c.equals(graphQLComment)) {
                    break;
                }
                i2++;
            }
            i2 = -1;
        }
        return m4876a(i2, i);
    }

    private boolean m4876a(int i, int i2) {
        if (i < 0 || this.f4281c == null) {
            return false;
        }
        this.f4281c.d(i, i2);
        return true;
    }

    private boolean m4875a(final int i) {
        if (i < 0) {
            return false;
        }
        this.f4285g = i;
        this.f4284f = true;
        this.f4281c.a(new Runnable(this) {
            final /* synthetic */ CommentListScrollStateController f4276b;

            public void run() {
                if (this.f4276b.f4281c != null) {
                    this.f4276b.f4281c.e(i);
                }
            }
        });
        return true;
    }
}
