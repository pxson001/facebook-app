package com.facebook.feedback.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedback.reactions.ui.TokenPileHelper;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.base.Optional;
import javax.inject.Inject;

/* compiled from: savedAlbumTitle */
public class FeedbackHeaderView extends CustomLinearLayout implements Bindable<FeedProps<GraphQLFeedback>> {
    @Inject
    GraphQLStoryUtil f4535a;
    @Inject
    TokenPileHelper f4536b;
    @Inject
    private RTLUtil f4537c;
    private TextView f4538d;
    public GraphQLFeedback f4539e;
    private OnClickListener f4540f;
    public Listener f4541g;

    /* compiled from: savedAlbumTitle */
    class C04311 implements OnClickListener {
        final /* synthetic */ FeedbackHeaderView f4534a;

        C04311(FeedbackHeaderView feedbackHeaderView) {
            this.f4534a = feedbackHeaderView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -2053340411);
            if (this.f4534a.f4541g == null) {
                Logger.a(2, EntryType.UI_INPUT_END, 1581509639, a);
                return;
            }
            this.f4534a.f4541g.mo228a(this.f4534a.f4539e);
            LogUtils.a(1773943029, a);
        }
    }

    /* compiled from: savedAlbumTitle */
    public interface Listener {
        void mo228a(GraphQLFeedback graphQLFeedback);
    }

    private static <T extends View> void m5095a(Class<T> cls, T t) {
        m5096a((Object) t, t.getContext());
    }

    private static void m5096a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((FeedbackHeaderView) obj).m5094a(GraphQLStoryUtil.a(fbInjector), TokenPileHelper.a(fbInjector), RTLUtil.a(fbInjector));
    }

    public final void mo198a(Object obj) {
        GraphQLFeedback graphQLFeedback;
        FeedProps feedProps = (FeedProps) obj;
        if (feedProps != null) {
            graphQLFeedback = (GraphQLFeedback) feedProps.a;
        } else {
            graphQLFeedback = null;
        }
        this.f4539e = graphQLFeedback;
        m5098b();
    }

    public FeedbackHeaderView(Context context) {
        this(context, null);
    }

    public FeedbackHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FeedbackHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5093a();
    }

    private void m5094a(GraphQLStoryUtil graphQLStoryUtil, TokenPileHelper tokenPileHelper, RTLUtil rTLUtil) {
        this.f4535a = graphQLStoryUtil;
        this.f4536b = tokenPileHelper;
        this.f4537c = rTLUtil;
    }

    private void m5093a() {
        m5095a(FeedbackHeaderView.class, (View) this);
        setContentView(2130904361);
        this.f4538d = (TextView) a(2131562064);
        this.f4540f = new C04311(this);
        setVisibility(8);
    }

    private void m5098b() {
        Optional a = this.f4535a.a(this.f4539e);
        int i = (this.f4539e == null || !a.isPresent()) ? 0 : 1;
        if (i != 0) {
            setActorText(a);
            m5099c();
            setVisibility(0);
            return;
        }
        setVisibility(8);
    }

    public void setListener(Listener listener) {
        this.f4541g = listener;
    }

    private void setActorText(Optional<GraphQLTextWithEntities> optional) {
        GraphQLTextWithEntities graphQLTextWithEntities = optional.isPresent() ? (GraphQLTextWithEntities) optional.get() : null;
        if (graphQLTextWithEntities == null) {
            this.f4538d.setText(getResources().getString(2131233265));
            this.f4538d.setBackgroundResource(0);
            setOnClickListener(null);
            return;
        }
        setOnClickListener(this.f4540f);
        setBackgroundResource(2130843806);
        m5100d();
        this.f4538d.setText(graphQLTextWithEntities.a());
    }

    private void m5099c() {
        this.f4536b.a(this.f4539e, this.f4538d);
    }

    private void m5100d() {
        Drawable drawable = getResources().getDrawable(2130837667);
        if (VERSION.SDK_INT >= 19) {
            drawable.setAutoMirrored(true);
        }
        setRightArrowCompoundDrawable(drawable);
    }

    private void setRightArrowCompoundDrawable(Drawable drawable) {
        if (this.f4537c.a()) {
            this.f4538d.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
        } else {
            this.f4538d.setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null);
        }
    }
}
