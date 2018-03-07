package com.facebook.aplacefor.reaction;

import com.facebook.aplacefor.reaction.partdefinitions.ReactionAPlaceForAnimationPartDefinition;
import com.facebook.aplacefor.reaction.partdefinitions.ReactionAPlaceForFooterCardPartDefinition;
import com.facebook.aplacefor.reaction.partdefinitions.ReactionAPlaceForHeaderCardPartDefinition;
import com.facebook.aplacefor.reaction.partdefinitions.ReactionAPlaceForStoryCardPartDefinition;
import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;

/* compiled from: jewel_popup_friend_requests */
public class APlaceForRowSupportDeclaration implements FeedRowSupportDeclaration {
    public final void m12419a(ListItemRowController listItemRowController) {
        listItemRowController.a(ReactionAPlaceForHeaderCardPartDefinition.f10533a);
        listItemRowController.a(ReactionAPlaceForAnimationPartDefinition.f10521a);
        listItemRowController.a(ReactionAPlaceForStoryCardPartDefinition.f10543a);
        listItemRowController.a(ReactionAPlaceForFooterCardPartDefinition.f10524a);
    }
}
