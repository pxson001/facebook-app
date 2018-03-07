package com.facebook.feedplugins.instagram;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.View;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.multirow.api.ViewType;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView;

/* compiled from: coupons */
public class InstagramPromoteUnitHeaderView extends CustomLinearLayout {
    public static final ViewType f7939a = new C10021();
    private final TextWithEntitiesView f7940b = ((TextWithEntitiesView) findViewById(2131562912));

    /* compiled from: coupons */
    final class C10021 extends ViewType {
        C10021() {
        }

        public final View m9031a(Context context) {
            return new InstagramPromoteUnitHeaderView(context);
        }
    }

    public InstagramPromoteUnitHeaderView(Context context) {
        super(context);
        setContentView(2130904934);
        setOrientation(1);
        this.f7940b.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void setTitle(String str) {
        this.f7940b.setText(str);
    }

    public void setTextWithEntities(GraphQLTextWithEntities graphQLTextWithEntities) {
        this.f7940b.setTextWithEntities((DefaultTextWithEntitiesLongFields) graphQLTextWithEntities);
    }
}
