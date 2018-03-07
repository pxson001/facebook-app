package com.facebook.pages.fb4a.vertex_attribution;

import android.content.Context;
import android.net.Uri;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.graphql.model.GraphQLAttributionEntry;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView;
import com.google.common.base.Preconditions;
import java.util.List;

/* compiled from: profile_field_sections_end_cursor */
public class PageIdentityVertexAttributionList extends CustomLinearLayout {
    private final LayoutInflater f3028a;

    public PageIdentityVertexAttributionList(Context context) {
        this(context, null);
    }

    public PageIdentityVertexAttributionList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        this.f3028a = LayoutInflater.from(getContext());
    }

    public void setAttributions(List<GraphQLAttributionEntry> list) {
        Preconditions.checkNotNull(list);
        for (GraphQLAttributionEntry graphQLAttributionEntry : list) {
            if (!(graphQLAttributionEntry.a() == null || StringUtil.a(graphQLAttributionEntry.a().a()))) {
                View inflate = this.f3028a.inflate(2130906004, this, false);
                TextWithEntitiesView textWithEntitiesView = (TextWithEntitiesView) inflate.findViewById(2131565431);
                FbDraweeView fbDraweeView = (FbDraweeView) inflate.findViewById(2131565430);
                textWithEntitiesView.setMovementMethod(LinkMovementMethod.getInstance());
                Preconditions.checkNotNull(graphQLAttributionEntry.a());
                textWithEntitiesView.a(graphQLAttributionEntry.a().a(), GraphQLHelper.a(graphQLAttributionEntry.a()));
                Object k = (graphQLAttributionEntry.j() == null || graphQLAttributionEntry.j().a() == null || StringUtil.a(graphQLAttributionEntry.j().a().b())) ? graphQLAttributionEntry.k() : graphQLAttributionEntry.j().a().b();
                if (!StringUtil.a(k)) {
                    fbDraweeView.a(Uri.parse(k), CallerContext.a(PageIdentityVertexAttributionList.class));
                }
                addView(inflate);
            }
        }
    }
}
