package com.facebook.feedplugins.graphqlstory.usertopictombstone;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.graphql.model.NegativeFeedbackActionsUnit;

/* compiled from: SYNC_CHECK_SERVER_RESPONSE_RECEIVED */
class UserTopicTombstonePartDefinition$2 extends ClickableSpan {
    final /* synthetic */ NegativeFeedbackActionsUnit f23478a;
    final /* synthetic */ UserTopicTombstonePersistentState f23479b;
    final /* synthetic */ HasInvalidate f23480c;
    final /* synthetic */ UserTopicTombstonePartDefinition f23481d;

    UserTopicTombstonePartDefinition$2(UserTopicTombstonePartDefinition userTopicTombstonePartDefinition, NegativeFeedbackActionsUnit negativeFeedbackActionsUnit, UserTopicTombstonePersistentState userTopicTombstonePersistentState, HasInvalidate hasInvalidate) {
        this.f23481d = userTopicTombstonePartDefinition;
        this.f23478a = negativeFeedbackActionsUnit;
        this.f23479b = userTopicTombstonePersistentState;
        this.f23480c = hasInvalidate;
    }

    public void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(textPaint.linkColor);
        textPaint.setUnderlineText(false);
    }

    public void onClick(View view) {
        UserTopicTombstonePartDefinition userTopicTombstonePartDefinition = this.f23481d;
        NegativeFeedbackActionsUnit negativeFeedbackActionsUnit = this.f23478a;
        String str = this.f23479b.f23485a;
        userTopicTombstonePartDefinition.g.a(this.f23479b.f23487c, str, new UserTopicTombstonePartDefinition$3(userTopicTombstonePartDefinition, this.f23480c, negativeFeedbackActionsUnit));
    }
}
