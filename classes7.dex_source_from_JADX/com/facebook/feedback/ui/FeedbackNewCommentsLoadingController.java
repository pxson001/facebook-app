package com.facebook.feedback.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.device.ScreenUtil;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.ui.animations.ViewHelperViewAnimator;
import com.facebook.ui.animations.ViewHelperViewAnimatorFactory;
import com.facebook.widget.LazyView;
import com.facebook.widget.listview.BaseProxyOnScrollListener;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: saio */
public class FeedbackNewCommentsLoadingController extends AbstractPillController {
    private static final SpringConfig f4561a = SpringConfig.b(5.0d, 10.0d);
    public CommentListScrollStateController f4562b;
    public LazyView<NewCommentsLoadingView> f4563c;
    private SpringSystem f4564d;
    public ViewHelperViewAnimatorFactory f4565e;
    private ScreenUtil f4566f;
    public GraphQLComment f4567g;

    /* compiled from: saio */
    class C04332 extends BaseProxyOnScrollListener {
        final /* synthetic */ FeedbackNewCommentsLoadingController f4557a;

        C04332(FeedbackNewCommentsLoadingController feedbackNewCommentsLoadingController) {
            this.f4557a = feedbackNewCommentsLoadingController;
        }

        public final void m5111a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
            if (this.f4557a.f4562b.m4879a()) {
                this.f4557a.m3238b();
            }
        }
    }

    public static FeedbackNewCommentsLoadingController m5116a(InjectorLike injectorLike) {
        return new FeedbackNewCommentsLoadingController(SpringSystem.b(injectorLike), ViewHelperViewAnimatorFactory.a(injectorLike), ScreenUtil.a(injectorLike));
    }

    @Inject
    public FeedbackNewCommentsLoadingController(SpringSystem springSystem, ViewHelperViewAnimatorFactory viewHelperViewAnimatorFactory, ScreenUtil screenUtil) {
        super(springSystem, viewHelperViewAnimatorFactory);
        this.f4564d = springSystem;
        this.f4565e = viewHelperViewAnimatorFactory;
        this.f4566f = screenUtil;
    }

    protected final LazyView<? extends View> mo130g() {
        return this.f4563c;
    }

    public final void m5120b(GraphQLFeedback graphQLFeedback) {
        if (this.f4563c != null && !m3242f() && !m3241e()) {
            if (graphQLFeedback != null) {
                GraphQLComment graphQLComment = null;
                ImmutableList i = GraphQLHelper.i(graphQLFeedback);
                int size = i.size();
                if (size != 0) {
                    if (this.f4567g == null) {
                        graphQLComment = (GraphQLComment) i.get(size <= 25 ? size - 1 : (size - 25) - 1);
                    } else {
                        int i2 = 0;
                        GraphQLComment graphQLComment2 = null;
                        while (i2 < size && i2 < 25) {
                            graphQLComment = (GraphQLComment) i.get(i2);
                            if (graphQLComment != null && graphQLComment.y() != null) {
                                if (graphQLComment.y().equals(this.f4567g.y())) {
                                    break;
                                }
                            } else {
                                graphQLComment = graphQLComment2;
                            }
                            i2++;
                            graphQLComment2 = graphQLComment;
                        }
                        graphQLComment = graphQLComment2;
                    }
                }
                final GraphQLComment graphQLComment3 = graphQLComment;
                if (graphQLComment3 != null) {
                    m5117i();
                    ((NewCommentsLoadingView) this.f4563c.a()).setOnPillClickListener(new OnClickListener(this) {
                        final /* synthetic */ FeedbackNewCommentsLoadingController f4556b;

                        public void onClick(View view) {
                            int a = Logger.a(2, EntryType.UI_INPUT_START, 28130936);
                            this.f4556b.m3238b();
                            this.f4556b.f4562b.m4881a(graphQLComment3.y());
                            Logger.a(2, EntryType.UI_INPUT_END, -577056547, a);
                        }
                    });
                    this.f4562b.m4878a(new C04332(this));
                    return;
                }
            }
            m3238b();
        }
    }

    private void m5117i() {
        Spring a = this.f4564d.a().a(0.0d);
        final ViewHelperViewAnimator a2 = this.f4565e.a(((NewCommentsLoadingView) this.f4563c.a()).f4634a);
        final ViewHelperViewAnimator a3 = this.f4565e.a(((NewCommentsLoadingView) this.f4563c.a()).f4635b);
        a.a(new SimpleSpringListener(this) {
            final /* synthetic */ FeedbackNewCommentsLoadingController f4560c;

            public final void m5115c(Spring spring) {
                if (this.f4560c.f4563c != null) {
                    ((NewCommentsLoadingView) this.f4560c.f4563c.a()).f4635b.setVisibility(0);
                }
            }

            public final void m5113a(Spring spring) {
                if (this.f4560c.f4563c == null || this.f4560c.m3242f() || this.f4560c.m3241e()) {
                    spring.l();
                    return;
                }
                float d = (float) spring.d();
                C04343.m5112a(a3, d);
                C04343.m5112a(a2, 1.0f - d);
            }

            public final void m5114b(Spring spring) {
                if (this.f4560c.f4563c != null && !this.f4560c.m3242f() && !this.f4560c.m3241e()) {
                    ((NewCommentsLoadingView) this.f4560c.f4563c.a()).f4634a.setVisibility(8);
                }
            }

            private static void m5112a(ViewHelperViewAnimator viewHelperViewAnimator, float f) {
                viewHelperViewAnimator.a(f);
                viewHelperViewAnimator.c(f);
                viewHelperViewAnimator.e(f);
            }
        }).a(f4561a).b(1.0d);
    }

    public final boolean mo230a() {
        if (m3239c() || m3240d()) {
            return false;
        }
        ((NewCommentsLoadingView) this.f4563c.a()).setTranslationY((float) this.f4566f.d());
        return super.mo230a();
    }

    protected final void mo229a(float f) {
        if (!m3239c()) {
            super.mo229a(f);
        } else if (this.f4563c != null) {
            ((NewCommentsLoadingView) this.f4563c.a()).setTranslationY(((float) ((NewCommentsLoadingView) this.f4563c.a()).getHeight()) * (1.0f - f));
        }
    }
}
