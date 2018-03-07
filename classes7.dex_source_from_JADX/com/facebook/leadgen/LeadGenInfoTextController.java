package com.facebook.leadgen;

import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.enums.GraphQLLeadGenPrivacyType;
import com.facebook.graphql.model.GraphQLLeadGenPage;
import com.facebook.graphql.model.GraphQLLeadGenPrivacyNode;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.Assisted;
import com.facebook.leadgen.data.LeadGenDataExtractor;
import com.facebook.leadgen.util.LeadGenUIUtil;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: place_question */
public class LeadGenInfoTextController {
    public final TextView f6282a;
    public final TextView f6283b;
    public final TextView f6284c;
    private final LeadGenUIUtil f6285d;

    /* compiled from: place_question */
    /* synthetic */ class C05681 {
        static final /* synthetic */ int[] f6281a = new int[GraphQLLeadGenPrivacyType.values().length];

        static {
            try {
                f6281a[GraphQLLeadGenPrivacyType.SECURE_SHARING_TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6281a[GraphQLLeadGenPrivacyType.PRIVACY_LINK_TEXT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    @Inject
    public LeadGenInfoTextController(LeadGenUIUtil leadGenUIUtil, @Assisted TextView textView, @Assisted TextView textView2, @Assisted TextView textView3) {
        this.f6285d = leadGenUIUtil;
        this.f6282a = textView;
        this.f6283b = textView2;
        this.f6284c = textView3;
    }

    public final void m8127a(@Nullable GraphQLLeadGenPage graphQLLeadGenPage, SpannableString spannableString, GraphQLStoryAttachment graphQLStoryAttachment, int i, int i2) {
        this.f6283b.setVisibility(8);
        this.f6284c.setVisibility(8);
        if (graphQLLeadGenPage != null && graphQLLeadGenPage.j() != null) {
            if ((!LeadGenUtil.b(graphQLLeadGenPage) || LeadGenUtil.g(graphQLStoryAttachment)) && !LeadGenUtil.a(graphQLStoryAttachment, i, i2)) {
                ImmutableList j = graphQLLeadGenPage.j();
                int size = j.size();
                for (int i3 = 0; i3 < size; i3++) {
                    GraphQLLeadGenPrivacyNode graphQLLeadGenPrivacyNode = (GraphQLLeadGenPrivacyNode) j.get(i3);
                    switch (C05681.f6281a[graphQLLeadGenPrivacyNode.j().ordinal()]) {
                        case 1:
                            this.f6283b.setText(graphQLLeadGenPrivacyNode.a());
                            if (spannableString != null) {
                                m8126a(graphQLLeadGenPrivacyNode, spannableString);
                            }
                            this.f6283b.setVisibility(0);
                            break;
                        case 2:
                            this.f6284c.setPaintFlags(this.f6284c.getPaintFlags() | 8);
                            m8125a(this.f6284c, graphQLLeadGenPrivacyNode.a());
                            break;
                    }
                    if (graphQLLeadGenPrivacyNode.j() == GraphQLLeadGenPrivacyType.SHORT_SECURE_SHARING_TEXT) {
                        m8125a(this.f6283b, graphQLLeadGenPrivacyNode.a());
                    }
                }
            }
        }
    }

    private static void m8125a(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        textView.setVisibility(0);
    }

    public final void m8128a(LeadGenDataExtractor leadGenDataExtractor, LeadGenUtil$ValidationResult leadGenUtil$ValidationResult, @Nullable GraphQLLeadGenPage graphQLLeadGenPage, int i, int i2) {
        if ((!LeadGenUtil.b(graphQLLeadGenPage) || leadGenDataExtractor.m8197L()) && !LeadGenUtil.a((GraphQLStoryAttachment) leadGenDataExtractor.f6367c.a, i, i2)) {
            CharSequence an;
            if (leadGenUtil$ValidationResult.isValid()) {
                an = leadGenDataExtractor.f6370f.an();
                if (!(graphQLLeadGenPage == null || !LeadGenUtil.a(graphQLLeadGenPage) || StringUtil.a(leadGenDataExtractor.m8194E()))) {
                    an = leadGenDataExtractor.m8194E();
                }
                this.f6282a.setTextColor(this.f6282a.getResources().getColor(2131363584));
            } else {
                an = leadGenDataExtractor.m8199a(leadGenUtil$ValidationResult);
            }
            m8125a(this.f6282a, an);
            return;
        }
        this.f6282a.setVisibility(8);
    }

    private void m8126a(GraphQLLeadGenPrivacyNode graphQLLeadGenPrivacyNode, SpannableString spannableString) {
        if (graphQLLeadGenPrivacyNode.j() != GraphQLLeadGenPrivacyType.SHORT_SECURE_SHARING_TEXT) {
            this.f6283b.setMovementMethod(LinkMovementMethod.getInstance());
            this.f6283b.append(spannableString);
        }
    }
}
