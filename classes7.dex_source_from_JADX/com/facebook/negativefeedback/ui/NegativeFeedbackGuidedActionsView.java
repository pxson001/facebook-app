package com.facebook.negativefeedback.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.negativefeedback.protocol.NegativeFeedbackQueryInterfaces.NegativeFeedbackPromptQueryFragment;
import com.facebook.negativefeedback.protocol.NegativeFeedbackQueryModels.NegativeFeedbackPromptQueryFragmentModel;
import com.facebook.negativefeedback.protocol.NegativeFeedbackQueryModels.NegativeFeedbackPromptQueryFragmentModel.ResponsesModel;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import java.util.Set;

/* compiled from: non_admin_write_post */
public class NegativeFeedbackGuidedActionsView extends CustomLinearLayout implements NegativeFeedbackDialogContent<NegativeFeedbackPromptQueryFragment> {
    public static final ImmutableSet<GraphQLNegativeFeedbackActionType> f8085a = ImmutableSet.of(GraphQLNegativeFeedbackActionType.REDIRECT, GraphQLNegativeFeedbackActionType.REPORT_IP_VIOLATION);
    public static final ImmutableSet<GraphQLNegativeFeedbackActionType> f8086b = ImmutableSet.of(GraphQLNegativeFeedbackActionType.REPORT_CONTENT);
    public static final ImmutableMap<GraphQLNegativeFeedbackActionType, Integer> f8087c = new Builder().b(GraphQLNegativeFeedbackActionType.BLOCK_ACTOR, Integer.valueOf(2131237753)).b(GraphQLNegativeFeedbackActionType.BLOCK_APP, Integer.valueOf(2131237753)).b(GraphQLNegativeFeedbackActionType.DELETE, Integer.valueOf(2131237754)).b(GraphQLNegativeFeedbackActionType.UNFRIEND, Integer.valueOf(2131237755)).b(GraphQLNegativeFeedbackActionType.UNLIKE, Integer.valueOf(2131237756)).b(GraphQLNegativeFeedbackActionType.UNSUBSCRIBE, Integer.valueOf(2131237757)).b(GraphQLNegativeFeedbackActionType.UNSUBSCRIBE_OWNER, Integer.valueOf(2131237757)).b(GraphQLNegativeFeedbackActionType.UNSUBSCRIBE_PAGE, Integer.valueOf(2131237757)).b(GraphQLNegativeFeedbackActionType.UNSUBSCRIBE_RESHARER, Integer.valueOf(2131237757)).b(GraphQLNegativeFeedbackActionType.UNSUBSCRIBE_ATTACHED_STORY_ACTOR, Integer.valueOf(2131237757)).b(GraphQLNegativeFeedbackActionType.UNSUBSCRIBE_DIRECTED_TARGET, Integer.valueOf(2131237757)).b(GraphQLNegativeFeedbackActionType.UNTAG, Integer.valueOf(2131237758)).b();
    private static final ImmutableSet<GraphQLNegativeFeedbackActionType> f8088i = ImmutableSet.of(GraphQLNegativeFeedbackActionType.BLOCK_ACTOR, GraphQLNegativeFeedbackActionType.BLOCK_APP, GraphQLNegativeFeedbackActionType.DELETE, GraphQLNegativeFeedbackActionType.HIDE_ADVERTISER, GraphQLNegativeFeedbackActionType.HIDE_AD, GraphQLNegativeFeedbackActionType.MESSAGE, new GraphQLNegativeFeedbackActionType[]{GraphQLNegativeFeedbackActionType.REDIRECT, GraphQLNegativeFeedbackActionType.REPORT_CONTENT, GraphQLNegativeFeedbackActionType.REPORT_IP_VIOLATION, GraphQLNegativeFeedbackActionType.SPAM_CLEANUP_CHECKPOINT, GraphQLNegativeFeedbackActionType.UNFRIEND, GraphQLNegativeFeedbackActionType.UNLIKE, GraphQLNegativeFeedbackActionType.UNSUBSCRIBE, GraphQLNegativeFeedbackActionType.UNSUBSCRIBE_OWNER, GraphQLNegativeFeedbackActionType.UNSUBSCRIBE_PAGE, GraphQLNegativeFeedbackActionType.UNSUBSCRIBE_RESHARER, GraphQLNegativeFeedbackActionType.UNSUBSCRIBE_ATTACHED_STORY_ACTOR, GraphQLNegativeFeedbackActionType.UNSUBSCRIBE_DIRECTED_TARGET, GraphQLNegativeFeedbackActionType.UNTAG});
    public ListView f8089d = ((ListView) a(2131564183));
    private FbTextView f8090e;
    public FrameLayout f8091f = ((FrameLayout) a(2131564182));
    public NegativeFeedbackGuidedActionAdapter f8092g;
    public Set<GraphQLNegativeFeedbackActionType> f8093h = Sets.a();

    public NegativeFeedbackGuidedActionsView(Context context) {
        super(context);
        NegativeFeedbackDialogContentHelper.m9722a(this);
        setContentView(2130905417);
        this.f8089d.getViewTreeObserver().addOnGlobalLayoutListener(NegativeFeedbackDialogContentHelper.m9721a(this.f8089d, this));
    }

    public final void m9760a(NegativeFeedbackPromptQueryFragmentModel negativeFeedbackPromptQueryFragmentModel) {
        View view;
        if (negativeFeedbackPromptQueryFragmentModel.m9697a().isEmpty()) {
            view = (LinearLayout) LayoutInflater.from(getContext()).inflate(2130905414, null);
        } else {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(2130905418, null);
        }
        this.f8089d.addHeaderView(view);
        this.f8092g = new NegativeFeedbackGuidedActionAdapter(getContext(), 2131564177);
        this.f8089d.setAdapter(this.f8092g);
        this.f8090e = (FbTextView) view.findViewById(2131564174);
        if (negativeFeedbackPromptQueryFragmentModel.m9698b() != null) {
            this.f8090e.setText(negativeFeedbackPromptQueryFragmentModel.m9698b().m9693a());
        }
        ImmutableList a = negativeFeedbackPromptQueryFragmentModel.m9697a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            ResponsesModel responsesModel = (ResponsesModel) a.get(i);
            if (f8088i.contains(responsesModel.m9683g())) {
                this.f8092g.add(new NegativeFeedbackGuidedActionItem(responsesModel, this.f8093h));
            }
        }
        setProgressBarVisibility(false);
    }

    public void setProgressBarVisibility(boolean z) {
        if (z) {
            this.f8091f.setMinimumHeight(this.f8089d.getHeight());
            this.f8091f.setVisibility(0);
            this.f8089d.setVisibility(8);
            return;
        }
        this.f8091f.setVisibility(8);
        this.f8089d.setVisibility(0);
    }
}
