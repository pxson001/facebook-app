package com.facebook.feedback.ui;

import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.ViewStub;
import com.facebook.common.util.CollectionUtil;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.inject.InjectorLike;
import com.facebook.ufiservices.util.LinkifyUtil;
import com.facebook.ufiservices.util.LinkifyUtilConverter;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: second_value */
public class CommentsDisabledNoticeViewHelper implements Bindable<GraphQLFeedback> {
    private final LinkifyUtil f4337a;
    public BetterTextView f4338b;
    public ViewStub f4339c;

    public static CommentsDisabledNoticeViewHelper m4947a(InjectorLike injectorLike) {
        return new CommentsDisabledNoticeViewHelper(LinkifyUtil.a(injectorLike));
    }

    public final void mo198a(Object obj) {
        GraphQLFeedback graphQLFeedback = (GraphQLFeedback) obj;
        MovementMethod movementMethod = null;
        if (graphQLFeedback != null && graphQLFeedback.x() && graphQLFeedback.q() != null) {
            if (this.f4338b == null) {
                Preconditions.checkNotNull(this.f4339c);
                this.f4338b = (BetterTextView) this.f4339c.inflate();
            }
            CharSequence a = this.f4337a.a(LinkifyUtilConverter.c(graphQLFeedback.q()), true, null);
            BetterTextView betterTextView = this.f4338b;
            if (!CollectionUtil.b(graphQLFeedback.q().c())) {
                movementMethod = LinkMovementMethod.getInstance();
            }
            betterTextView.setMovementMethod(movementMethod);
            this.f4338b.setText(a);
            this.f4338b.setVisibility(0);
        } else if (this.f4338b != null) {
            this.f4338b.setVisibility(8);
        }
    }

    @Inject
    public CommentsDisabledNoticeViewHelper(LinkifyUtil linkifyUtil) {
        this.f4337a = linkifyUtil;
    }
}
