package com.facebook.ufiservices.flyout.views;

import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.util.TypedValue;
import android.view.View;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.feedback.reactions.data.FeedbackReaction;
import com.facebook.graphql.enums.GraphQLFeedOptimisticPublishState;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.ufiservices.cache.PendingCommentCache;
import com.facebook.widget.accessibility.AccessibleClickableSpan;
import com.google.common.base.Preconditions;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.inject.Provider;

/* compiled from: custom_location */
public class DefaultCommentMetadataSpannableBuilder {
    protected Drawable f18165a;
    public int f18166b;
    protected int f18167c;
    public CommentMetadataSpannableBuilderParams f18168d;
    public FeedbackReaction f18169e = FeedbackReaction.c;
    protected boolean f18170f;
    protected boolean f18171g;
    protected List<Spannable> f18172h;
    private final PendingCommentCache f18173i;
    private final Provider<TimeFormatUtil> f18174j;

    /* compiled from: custom_location */
    class C13231 extends ClickableSpan {
        final /* synthetic */ DefaultCommentMetadataSpannableBuilder f18156a;

        C13231(DefaultCommentMetadataSpannableBuilder defaultCommentMetadataSpannableBuilder) {
            this.f18156a = defaultCommentMetadataSpannableBuilder;
        }

        public void onClick(View view) {
            this.f18156a.f18168d.f18145b.m26688a(view);
        }

        public void updateDrawState(TextPaint textPaint) {
            textPaint.setUnderlineText(false);
            textPaint.setColor(this.f18156a.f18167c);
        }
    }

    /* compiled from: custom_location */
    class C13242 extends ClickableSpan {
        final /* synthetic */ DefaultCommentMetadataSpannableBuilder f18157a;

        C13242(DefaultCommentMetadataSpannableBuilder defaultCommentMetadataSpannableBuilder) {
            this.f18157a = defaultCommentMetadataSpannableBuilder;
        }

        public void onClick(View view) {
            this.f18157a.f18168d.f18145b.m26691b(view);
        }

        public void updateDrawState(TextPaint textPaint) {
            textPaint.setUnderlineText(false);
            textPaint.setColor(this.f18157a.f18167c);
        }
    }

    /* compiled from: custom_location */
    public abstract class ReactionActionClickSpan extends ClickableSpan {
        final /* synthetic */ DefaultCommentMetadataSpannableBuilder f18160c;

        public ReactionActionClickSpan(DefaultCommentMetadataSpannableBuilder defaultCommentMetadataSpannableBuilder) {
            this.f18160c = defaultCommentMetadataSpannableBuilder;
        }
    }

    /* compiled from: custom_location */
    class C13286 extends ClickableSpan {
        final /* synthetic */ DefaultCommentMetadataSpannableBuilder f18164a;

        C13286(DefaultCommentMetadataSpannableBuilder defaultCommentMetadataSpannableBuilder) {
            this.f18164a = defaultCommentMetadataSpannableBuilder;
        }

        public void onClick(View view) {
            this.f18164a.f18168d.f18145b.m26694e(view);
        }

        public void updateDrawState(TextPaint textPaint) {
            textPaint.setUnderlineText(false);
            textPaint.setColor(this.f18164a.f18167c);
        }
    }

    private List<Spannable> m26711c(GraphQLComment graphQLComment) {
        Object obj;
        if (graphQLComment.x() == null || graphQLComment.x().a() <= 0) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            return new ArrayList();
        }
        List<Spannable> arrayList = new ArrayList();
        arrayList.add(m26712d());
        Spannable spannableString = new SpannableString(this.f18168d.f18144a.getString(2131233599));
        spannableString.setSpan(new C13231(this), 0, spannableString.length(), 33);
        arrayList.add(spannableString);
        return arrayList;
    }

    public DefaultCommentMetadataSpannableBuilder(CommentMetadataSpannableBuilderParams commentMetadataSpannableBuilderParams, PendingCommentCache pendingCommentCache, Provider<TimeFormatUtil> provider, boolean z) {
        this.f18168d = commentMetadataSpannableBuilderParams;
        this.f18170f = z;
        this.f18165a = commentMetadataSpannableBuilderParams.m26695b().getDrawable(2130843795);
        TypedValue typedValue = new TypedValue();
        commentMetadataSpannableBuilderParams.f18144a.getTheme().resolveAttribute(2130773265, typedValue, true);
        this.f18166b = commentMetadataSpannableBuilderParams.m26695b().getColor(typedValue.resourceId);
        this.f18167c = commentMetadataSpannableBuilderParams.m26695b().getColor(2131362722);
        this.f18173i = pendingCommentCache;
        this.f18174j = provider;
    }

    public List<Spannable> mo1387a(GraphQLComment graphQLComment) {
        return mo1388a(graphQLComment, graphQLComment);
    }

    public List<Spannable> mo1388a(GraphQLComment graphQLComment, GraphQLComment graphQLComment2) {
        Preconditions.checkNotNull(this.f18168d);
        this.f18172h = new ArrayList();
        GraphQLFeedOptimisticPublishState c = this.f18173i.m26494c(graphQLComment.H());
        List list;
        Spannable spannableString;
        if (c == GraphQLFeedOptimisticPublishState.POSTING) {
            list = this.f18172h;
            spannableString = new SpannableString(this.f18168d.m26695b().getString(2131233585));
            spannableString.setSpan(new ForegroundColorSpan(this.f18166b), 0, spannableString.length(), 33);
            list.add(spannableString);
            return this.f18172h;
        } else if (c == GraphQLFeedOptimisticPublishState.FAILED) {
            list = this.f18172h;
            spannableString = new SpannableString(this.f18168d.m26695b().getString(2131233586));
            spannableString.setSpan(new ForegroundColorSpan(this.f18166b), 0, spannableString.length(), 33);
            list.add(spannableString);
            return this.f18172h;
        } else {
            this.f18172h.addAll(m26710b(graphQLComment));
            this.f18172h.addAll(m26711c(graphQLComment));
            if (this.f18170f) {
                this.f18172h.addAll(m26715f(graphQLComment));
                this.f18172h.addAll(m26717h(graphQLComment2));
                this.f18172h.addAll(m26716g(graphQLComment));
            } else {
                this.f18172h.addAll(m26713d(graphQLComment));
                this.f18172h.addAll(m26714e(graphQLComment));
                this.f18172h.addAll(m26717h(graphQLComment2));
            }
            return this.f18172h;
        }
    }

    private List<Spannable> m26710b(GraphQLComment graphQLComment) {
        Spannable spannableString = new SpannableString(((TimeFormatUtil) this.f18174j.get()).a(TimeFormatStyle.STREAM_RELATIVE_STYLE, graphQLComment.w() * 1000));
        spannableString.setSpan(new ForegroundColorSpan(this.f18166b), 0, spannableString.length(), 33);
        List<Spannable> arrayList = new ArrayList();
        arrayList.add(spannableString);
        return arrayList;
    }

    private List<Spannable> m26713d(GraphQLComment graphQLComment) {
        if (graphQLComment.l() == null || !graphQLComment.l().g()) {
            return new ArrayList();
        }
        CharSequence string;
        List<Spannable> arrayList = new ArrayList();
        arrayList.add(m26712d());
        if (graphQLComment.l().y_()) {
            string = this.f18168d.f18144a.getString(2131233268);
        } else {
            string = this.f18168d.f18144a.getString(2131233267);
        }
        Spannable spannableString = new SpannableString(string);
        spannableString.setSpan(new C13242(this), 0, spannableString.length(), 33);
        arrayList.add(spannableString);
        return arrayList;
    }

    private List<Spannable> m26714e(GraphQLComment graphQLComment) {
        if (graphQLComment.l() == null || (!graphQLComment.l().y_() && (GraphQLHelper.o(graphQLComment.l()) == null || GraphQLHelper.p(graphQLComment.l()) == 0))) {
            return new ArrayList();
        }
        List<Spannable> arrayList = new ArrayList();
        arrayList.add(m26718a());
        int p = (graphQLComment.l().y_() && GraphQLHelper.o(graphQLComment.l()) == null) ? 1 : GraphQLHelper.p(graphQLComment.l());
        Spannable spannableString = new SpannableString("   " + NumberFormat.getInstance().format((long) p));
        this.f18165a.setBounds(0, 0, this.f18165a.getIntrinsicWidth(), this.f18165a.getIntrinsicHeight());
        spannableString.setSpan(new ImageSpan(this.f18165a, 1), 0, 1, 33);
        spannableString.setSpan(new AccessibleClickableSpan(this, this.f18168d.f18144a.getResources().getQuantityString(2131689522, p, new Object[]{Integer.valueOf(p)})) {
            final /* synthetic */ DefaultCommentMetadataSpannableBuilder f18159a;

            public void onClick(View view) {
                this.f18159a.f18168d.f18145b.m26692c(view);
            }

            public void updateDrawState(TextPaint textPaint) {
                textPaint.setUnderlineText(false);
                textPaint.setColor(this.f18159a.f18167c);
            }
        }, 0, spannableString.length(), 33);
        arrayList.add(spannableString);
        return arrayList;
    }

    private List<Spannable> m26715f(GraphQLComment graphQLComment) {
        GraphQLFeedback l = graphQLComment.l();
        if (l == null || !l.n()) {
            return Collections.emptyList();
        }
        CharSequence charSequence;
        List<Spannable> arrayList = new ArrayList();
        arrayList.add(m26712d());
        final boolean z = this.f18169e != FeedbackReaction.c;
        if (z) {
            charSequence = this.f18169e.f;
        } else {
            charSequence = this.f18168d.f18144a.getString(2131233267);
        }
        Spannable spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new ReactionActionClickSpan(this) {
            final /* synthetic */ DefaultCommentMetadataSpannableBuilder f18162b;

            public void onClick(View view) {
                this.f18162b.f18168d.f18145b.m26689a(view, this.f18162b.f18169e == FeedbackReaction.c ? FeedbackReaction.b : FeedbackReaction.a);
            }

            public void updateDrawState(TextPaint textPaint) {
                int i;
                textPaint.setUnderlineText(false);
                if (z) {
                    i = this.f18162b.f18169e.g;
                } else {
                    i = this.f18162b.f18167c;
                }
                textPaint.setColor(i);
            }
        }, 0, spannableString.length(), 33);
        arrayList.add(spannableString);
        return arrayList;
    }

    private List<Spannable> m26716g(GraphQLComment graphQLComment) {
        GraphQLFeedback l = graphQLComment.l();
        if (l == null || GraphQLHelper.r(l) == null || GraphQLHelper.q(l) == 0) {
            return Collections.emptyList();
        }
        Object quantityString;
        List<Spannable> arrayList = new ArrayList();
        arrayList.add(m26718a());
        int q = GraphQLHelper.q(l);
        String str = this.f18168d.f18147d;
        if (this.f18168d.f18146c == null) {
            quantityString = this.f18168d.f18144a.getResources().getQuantityString(GraphQLHelper.q(l) == GraphQLHelper.p(l) ? 2131689522 : 2131689523, q, new Object[]{str});
        } else {
            quantityString = "  " + str;
        }
        Spannable spannableString = new SpannableString(quantityString);
        if (this.f18168d.f18146c != null) {
            Drawable drawable = this.f18168d.f18146c;
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            spannableString.setSpan(new ImageSpan(drawable), 0, 1, 33);
        }
        spannableString.setSpan(new AccessibleClickableSpan(this, quantityString) {
            final /* synthetic */ DefaultCommentMetadataSpannableBuilder f18163a;

            public void onClick(View view) {
                this.f18163a.f18168d.f18145b.m26693d(view);
            }

            public void updateDrawState(TextPaint textPaint) {
                textPaint.setUnderlineText(false);
                textPaint.setColor(this.f18163a.f18167c);
            }
        }, 0, spannableString.length(), 33);
        arrayList.add(spannableString);
        return arrayList;
    }

    private List<Spannable> m26717h(GraphQLComment graphQLComment) {
        if (graphQLComment.l() == null || !graphQLComment.l().c()) {
            return new ArrayList();
        }
        List<Spannable> arrayList = new ArrayList();
        arrayList.add(m26718a());
        Spannable spannableString = new SpannableString(this.f18168d.f18144a.getString(2131233294));
        spannableString.setSpan(new C13286(this), 0, spannableString.length(), 33);
        arrayList.add(spannableString);
        return arrayList;
    }

    public final Spannable m26718a() {
        return m26709a(this.f18171g ? this.f18166b : this.f18167c);
    }

    private Spannable m26712d() {
        return m26709a(this.f18166b);
    }

    private Spannable m26709a(int i) {
        Spannable spannableString = new SpannableString("   " + this.f18168d.m26695b().getString(2131233266) + "   ");
        spannableString.setSpan(new ForegroundColorSpan(i), 0, spannableString.length(), 33);
        return spannableString;
    }
}
