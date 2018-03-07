package com.facebook.leadgen.data;

import android.content.Context;
import android.net.Uri;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.facebook.common.i18n.StringLengthHelper;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.enums.GraphQLLeadGenInfoFieldInputType;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLEntityAtRange;
import com.facebook.graphql.model.GraphQLLeadGenErrorNode;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.inject.InjectorLike;
import com.facebook.leadgen.LeadGenUtil;
import com.facebook.leadgen.LeadGenUtil$ValidationResult;
import com.facebook.leadgen.util.LeadGenUIUtil;
import com.facebook.leadgen.util.LeadGenUIUtil.C05981;
import com.facebook.leadgen.util.LeadGenUIUtil.C06003;
import com.facebook.leadgen.util.LeadGenUIUtil.C06014;
import com.facebook.leadgen.util.LeadGenUIUtil.C06025;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: pivot_on_comment */
public class LeadGenDataExtractor implements InjectableComponentWithContext {
    @Inject
    public LeadGenUtil f6365a;
    @Inject
    public LeadGenUIUtil f6366b;
    public FeedProps<GraphQLStoryAttachment> f6367c;
    public GraphQLStoryAttachment f6368d;
    private GraphQLStory f6369e;
    public GraphQLStoryActionLink f6370f = LeadGenUtil.a(this.f6368d);
    private Context f6371g;

    public static void m8193a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        LeadGenDataExtractor leadGenDataExtractor = (LeadGenDataExtractor) obj;
        LeadGenUtil a = LeadGenUtil.a(injectorLike);
        LeadGenUIUtil a2 = LeadGenUIUtil.m8504a(injectorLike);
        leadGenDataExtractor.f6365a = a;
        leadGenDataExtractor.f6366b = a2;
    }

    public LeadGenDataExtractor(FeedProps<GraphQLStoryAttachment> feedProps, Context context) {
        this.f6367c = feedProps;
        this.f6369e = AttachmentProps.c(feedProps);
        this.f6368d = (GraphQLStoryAttachment) feedProps.a;
        this.f6371g = context;
        Class cls = LeadGenDataExtractor.class;
        m8193a(this, getContext());
    }

    public final boolean m8200a() {
        return (this.f6370f == null || this.f6370f.M() == null || this.f6370f.M().n() == null) ? false : true;
    }

    public final String m8201b() {
        return this.f6369e != null ? this.f6369e.c() : null;
    }

    public final String m8202c() {
        GraphQLStoryAttachment graphQLStoryAttachment = this.f6368d;
        String str = null;
        if (graphQLStoryAttachment != null) {
            GraphQLStoryActionLink a = ActionLinkHelper.a(graphQLStoryAttachment, 1185006756);
            if (a != null) {
                GraphQLPage ab = a.ab();
                if (ab != null) {
                    str = ab.aG();
                }
            }
        }
        return str;
    }

    public final boolean m8203e() {
        return LeadGenUtil.s(this.f6368d) != null;
    }

    public final Uri m8204m() {
        Uri uri = null;
        GraphQLStoryActionLink a = LeadGenUtil.a(this.f6368d);
        if (a != null) {
            GraphQLPage ab = a.ab();
            if (!(ab == null || ab.bs() == null)) {
                uri = ImageUtil.a(ab.bs());
            }
        }
        return uri;
    }

    public final SpannableString m8205s() {
        SpannableString spannableString;
        LeadGenUIUtil leadGenUIUtil = this.f6366b;
        FeedProps feedProps = this.f6367c;
        GraphQLStoryActionLink a = LeadGenUtil.a((GraphQLStoryAttachment) feedProps.a);
        if (a == null || a.B() == null) {
            spannableString = null;
        } else {
            spannableString = new SpannableString(a.B());
            spannableString.setSpan(new C05981(leadGenUIUtil, feedProps, a), 0, spannableString.length(), 0);
            spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 0);
            spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 0);
            spannableString.setSpan(new ForegroundColorSpan(leadGenUIUtil.f6585c.getResources().getColor(2131363589)), 0, spannableString.length(), 0);
        }
        return spannableString;
    }

    public final String m8199a(LeadGenUtil$ValidationResult leadGenUtil$ValidationResult) {
        String ae;
        GraphQLStoryActionLink graphQLStoryActionLink = this.f6370f;
        if (leadGenUtil$ValidationResult == LeadGenUtil$ValidationResult.PRIVACY_CHECKBOX_ERROR) {
            ae = graphQLStoryActionLink.ae();
        } else {
            ae = null;
            ImmutableList x = graphQLStoryActionLink.x();
            int size = x.size();
            int i = 0;
            while (i < size) {
                GraphQLLeadGenErrorNode graphQLLeadGenErrorNode = (GraphQLLeadGenErrorNode) x.get(i);
                if (graphQLLeadGenErrorNode.j() == leadGenUtil$ValidationResult.fieldInputType) {
                    ae = graphQLLeadGenErrorNode.a();
                    break;
                }
                String a;
                if (graphQLLeadGenErrorNode.j() == GraphQLLeadGenInfoFieldInputType.TEXT) {
                    a = graphQLLeadGenErrorNode.a();
                } else {
                    a = ae;
                }
                i++;
                ae = a;
            }
        }
        return ae;
    }

    public final String m8194E() {
        return this.f6370f.ai();
    }

    public final String m8195F() {
        GraphQLStoryAttachment graphQLStoryAttachment = this.f6368d;
        String str = null;
        if (graphQLStoryAttachment != null) {
            GraphQLStoryActionLink a = ActionLinkHelper.a(graphQLStoryAttachment, 1185006756);
            if (a != null) {
                str = a.k();
            }
        }
        return str;
    }

    public Context getContext() {
        return this.f6371g;
    }

    public final SpannableString m8196J() {
        SpannableString spannableString;
        LeadGenUIUtil leadGenUIUtil = this.f6366b;
        FeedProps feedProps = this.f6367c;
        int i = 0;
        GraphQLStoryActionLink a = LeadGenUtil.a((GraphQLStoryAttachment) feedProps.a);
        if (a == null) {
            spannableString = null;
        } else {
            ImmutableList k = a.M().l().k();
            SpannableString spannableString2 = new SpannableString(((GraphQLTextWithEntities) k.get(0)).a());
            k = ((GraphQLTextWithEntities) k.get(0)).b();
            if (k != null) {
                while (i < k.size()) {
                    GraphQLEntityAtRange graphQLEntityAtRange = (GraphQLEntityAtRange) k.get(i);
                    spannableString2.setSpan(new C06003(leadGenUIUtil, feedProps, graphQLEntityAtRange.j().D_()), graphQLEntityAtRange.c(), graphQLEntityAtRange.b() + graphQLEntityAtRange.c(), 17);
                    i++;
                }
            }
            spannableString = spannableString2;
        }
        return spannableString;
    }

    public final SpannableString m8198a(String str) {
        SpannableString spannableString;
        LeadGenUIUtil leadGenUIUtil = this.f6366b;
        FeedProps feedProps = this.f6367c;
        GraphQLStoryActionLink a = LeadGenUtil.a((GraphQLStoryAttachment) feedProps.a);
        if (a == null) {
            spannableString = null;
        } else {
            String str2;
            if (str != null) {
                str2 = str;
            } else {
                str2 = a.M().l().a();
            }
            if (str2 == null) {
                str2 = a.ag();
            }
            SpannableString spannableString2 = new SpannableString(a.al() + a.B() + " " + str2);
            C06014 c06014 = new C06014(leadGenUIUtil, feedProps, a);
            int a2 = StringLengthHelper.a(a.al());
            spannableString2.setSpan(c06014, a2, StringLengthHelper.a(a.B()) + a2, 0);
            C06025 c06025 = new C06025(leadGenUIUtil, feedProps, a);
            int a3 = (StringLengthHelper.a(a.B()) + StringLengthHelper.a(a.al())) + 1;
            spannableString2.setSpan(c06025, a3, StringLengthHelper.a(str2) + a3, 0);
            spannableString = spannableString2;
        }
        return spannableString;
    }

    public final boolean m8197L() {
        return LeadGenUtil.g(this.f6368d);
    }
}
