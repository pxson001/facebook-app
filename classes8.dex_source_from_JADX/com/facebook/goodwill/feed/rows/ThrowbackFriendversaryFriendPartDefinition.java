package com.facebook.goodwill.feed.rows;

import com.facebook.fbui.widget.contentview.ContentViewWithButton;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.model.GraphQLUser;
import com.facebook.inject.Assisted;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

/* compiled from: fb_captured_media_uri */
public class ThrowbackFriendversaryFriendPartDefinition extends MultiRowSinglePartDefinition<GraphQLUser, Void, HasPositionInformation, ContentViewWithButton> {
    private static final PaddingStyle f13691d;
    private final BackgroundPartDefinition f13692a;
    private final ThrowbackFriendversaryFriendViewPartDefinition f13693b;
    private final Boolean f13694c;

    public final Object m15390a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLUser graphQLUser = (GraphQLUser) obj;
        subParts.a(this.f13692a, new StylingData(null, this.f13694c.booleanValue() ? f13691d : PaddingStyle.a, -1, 2130839797, this.f13694c.booleanValue() ? Position.BOTTOM : Position.MIDDLE));
        if (graphQLUser != null) {
            subParts.a(this.f13693b, graphQLUser);
        }
        return null;
    }

    static {
        Builder a = Builder.a();
        a.c = 6.0f;
        f13691d = a.i();
    }

    @Inject
    public ThrowbackFriendversaryFriendPartDefinition(BackgroundPartDefinition backgroundPartDefinition, ThrowbackFriendversaryFriendViewPartDefinition throwbackFriendversaryFriendViewPartDefinition, @Assisted Boolean bool) {
        this.f13692a = backgroundPartDefinition;
        this.f13693b = throwbackFriendversaryFriendViewPartDefinition;
        this.f13694c = bool;
    }

    public final ViewType m15389a() {
        return ThrowbackFriendversaryFriendViewPartDefinition.f13706a;
    }

    public final boolean m15391a(Object obj) {
        return true;
    }
}
