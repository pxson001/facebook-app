package com.facebook.feedplugins.graphqlstory.header;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.unicode.RangeConverter;
import com.facebook.common.unicode.UTF16Range;
import com.facebook.common.util.LazyResources;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.graphql.linkutil.GraphQLLinkExtractor;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLEntityAtRange;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryActorHelper;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.intent.thirdparty.NativeThirdPartyUriHelper;
import com.facebook.linkify.LinkifyTargetBuilder;
import com.facebook.linkify.LinkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL;
import com.facebook.ufiservices.flyout.FlyoutClickSource;
import com.facebook.ufiservices.util.FeedMultiPhotoGridHelper;
import com.facebook.ufiservices.util.LinkifyUtil;
import com.facebook.ufiservices.util.LinkifyUtilConverter;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ijxLJi1yGs1JpL-X1SExmchvork */
public class HeaderTitleSpannableBuilder {
    private static HeaderTitleSpannableBuilder f20536j;
    private static final Object f20537k = new Object();
    public final Context f20538a;
    public final Lazy<LinkifyUtil> f20539b;
    public final RTLUtil f20540c;
    public final Lazy<GraphQLLinkExtractor> f20541d;
    public final Lazy<String> f20542e = LazyResources.m28239a(this.f20538a, 2131233402);
    public final Lazy<String> f20543f = LazyResources.m28239a(this.f20538a, 2131233286);
    public final Lazy<String> f20544g = LazyResources.m28239a(this.f20538a, 2131233287);
    public final Lazy<String> f20545h = LazyResources.m28239a(this.f20538a, 2131233284);
    public final Lazy<String> f20546i = LazyResources.m28239a(this.f20538a, 2131233285);

    /* compiled from: ijxLJi1yGs1JpL-X1SExmchvork */
    public class Builder {
        public final /* synthetic */ HeaderTitleSpannableBuilder f21798a;
        private final FeedProps<GraphQLStory> f21799b;
        private final LinkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL f21800c;
        private final boolean f21801d;
        private Spannable f21802e;
        public int f21803f = -1;

        public Builder(HeaderTitleSpannableBuilder headerTitleSpannableBuilder, FeedProps<GraphQLStory> feedProps, boolean z) {
            this.f21798a = headerTitleSpannableBuilder;
            this.f21799b = feedProps;
            this.f21800c = LinkifyTargetBuilder.m29534a(StoryActorHelper.m27492b((GraphQLStory) this.f21799b.f13444a));
            this.f21803f = -1;
            this.f21801d = z;
        }

        public final Builder m29531a() {
            GraphQLProfile aJ = ((GraphQLStory) this.f21799b.f13444a).aJ();
            if (!(this.f21802e != null || this.f21800c == null || aJ == null)) {
                this.f21802e = m29528a(this.f21800c, LinkifyTargetBuilder.m29537a(aJ), TrackableFeedProps.m27451a(this.f21799b));
            }
            return this;
        }

        public final Builder m29532b() {
            GraphQLActor aP = ((GraphQLStory) this.f21799b.f13444a).aP();
            if (!(this.f21802e != null || this.f21800c == null || aP == null)) {
                this.f21802e = m29530b(this.f21800c, LinkifyTargetBuilder.m29534a(aP), TrackableFeedProps.m27451a(this.f21799b));
            }
            return this;
        }

        public final Spannable m29533c() {
            LinkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL;
            FeedUnit feedUnit = (GraphQLStory) this.f21799b.f13444a;
            JsonNode a = TrackableFeedProps.m27451a(this.f21799b);
            if (!(feedUnit.aH() == null || this.f21801d)) {
                this.f21802e = ((LinkifyUtil) this.f21798a.f20539b.get()).m26551a(LinkifyUtilConverter.m29870b(feedUnit.aH()), FlyoutClickSource.TITLE, a, this.f21803f != -1 ? this.f21803f : 0);
            }
            if (this.f21802e == null && this.f21800c != null && NativeThirdPartyUriHelper.m29571a(this.f21800c.D_())) {
                linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL = this.f21800c;
                List list = null;
                if (linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL != null) {
                    GraphQLImage a2;
                    if (linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL.ad_() != null) {
                        com.facebook.graphql.model.GraphQLImage.Builder builder = new com.facebook.graphql.model.GraphQLImage.Builder();
                        builder.g = linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL.ad_().mo3198b();
                        a2 = builder.a();
                    } else {
                        a2 = null;
                    }
                    com.facebook.graphql.model.GraphQLEntity.Builder builder2 = new com.facebook.graphql.model.GraphQLEntity.Builder();
                    builder2.f15802m = linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL.mo3203d();
                    builder2 = builder2;
                    builder2.f15792S = linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL.mo3202b();
                    builder2 = builder2;
                    builder2.f15789P = linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL.D_();
                    builder2 = builder2;
                    builder2.f15810u = linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL.C_();
                    builder2 = builder2;
                    builder2.f15796g = feedUnit.mo2507g();
                    builder2 = builder2;
                    builder2.f15777D = a2;
                    GraphQLEntityAtRange a3 = GraphQLHelper.m22455a(builder2.m22529a(), RangeConverter.m29943a(linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL.C_(), new UTF16Range(0, linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL.C_().length())));
                    list = ((LinkifyUtil) this.f21798a.f20539b.get()).m26550a(LinkifyUtilConverter.m29870b(GraphQLHelper.m22464a(linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL.C_(), Lists.m1300a(a3), null, null)), feedUnit, FlyoutClickSource.TITLE, a);
                }
                this.f21802e = list;
            }
            if (this.f21802e != null) {
                return this.f21802e;
            }
            if (this.f21800c == null) {
                return null;
            }
            if (!FeedMultiPhotoGridHelper.m29588b((GraphQLStory) feedUnit) || FeedMultiPhotoGridHelper.m29587a(feedUnit)) {
                return ((LinkifyUtil) this.f21798a.f20539b.get()).m26546a(this.f21800c, a, this.f21803f != -1 ? this.f21803f : LinkifyUtil.f18856a, true);
            }
            int size;
            linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL = this.f21800c;
            GraphQLStoryAttachment o = StoryAttachmentHelper.m28042o(feedUnit);
            if (o == null || o.m23987z() == null || o.m23987z().ew() == null) {
                size = StoryAttachmentHelper.m28036i(feedUnit).size();
            } else {
                size = o.m23987z().ew().m24477a();
            }
            return m29527a(linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL, size, a);
        }

        private Spannable m29528a(LinkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL, LinkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL2, JsonNode jsonNode) {
            boolean a = this.f21798a.f20540c.m6557a();
            String str = a ? (String) this.f21798a.f20544g.get() : (String) this.f21798a.f20543f.get();
            String str2 = a ? (String) this.f21798a.f20546i.get() : (String) this.f21798a.f20545h.get();
            Spannable a2 = m29529a(str, jsonNode, LinkifyUtil.f18856a, linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL, linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL2);
            int indexOf = a2.toString().indexOf(str2);
            if (indexOf >= 0) {
                a2.setSpan(new ForegroundColorSpan(this.f21798a.f20538a.getResources().getColor(2131361974)), indexOf, indexOf + 1, 17);
                a2.setSpan(new RelativeSizeSpan(0.9285714f), indexOf, indexOf + 1, 17);
            }
            return a2;
        }

        private Spannable m29530b(LinkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL, LinkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL2, JsonNode jsonNode) {
            return m29529a(this.f21798a.f20538a.getString(2131233401), jsonNode, LinkifyUtil.f18856a, linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL, linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL2);
        }

        private Spannable m29527a(LinkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL, int i, JsonNode jsonNode) {
            if (linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL == null) {
                return null;
            }
            return m29529a(StringFormatUtil.formatStrLocaleSafe((String) this.f21798a.f20542e.get(), "%1$s", Integer.valueOf(i)), jsonNode, LinkifyUtil.f18856a, linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL);
        }

        private Spannable m29529a(String str, JsonNode jsonNode, int i, LinkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL... linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQLArr) {
            String[] strArr = new String[linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQLArr.length];
            for (int i2 = 0; i2 < linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQLArr.length; i2++) {
                strArr[i2] = linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQLArr[i2].C_();
            }
            Spannable valueOf = SpannableString.valueOf(StringFormatUtil.a(str, strArr));
            for (Index index : new Indices(str, strArr).a()) {
                LinkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL = linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQLArr[index.d()];
                String a = ((GraphQLLinkExtractor) this.f21798a.f20541d.get()).m26445a(linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL.mo3202b(), linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL.mo3203d());
                int a2 = index.a();
                ((LinkifyUtil) this.f21798a.f20539b.get()).m26561a(a, a2, index.c() + a2, valueOf, true, i, true, jsonNode, linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL);
            }
            return valueOf;
        }
    }

    private static HeaderTitleSpannableBuilder m28272b(InjectorLike injectorLike) {
        return new HeaderTitleSpannableBuilder((Context) injectorLike.getInstance(Context.class), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3538), RTLUtil.m6553a(injectorLike), IdBasedLazy.m1808a(injectorLike, 2189));
    }

    public static HeaderTitleSpannableBuilder m28271a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            HeaderTitleSpannableBuilder b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20537k) {
                HeaderTitleSpannableBuilder headerTitleSpannableBuilder;
                if (a2 != null) {
                    headerTitleSpannableBuilder = (HeaderTitleSpannableBuilder) a2.mo818a(f20537k);
                } else {
                    headerTitleSpannableBuilder = f20536j;
                }
                if (headerTitleSpannableBuilder == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28272b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20537k, b3);
                        } else {
                            f20536j = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = headerTitleSpannableBuilder;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public HeaderTitleSpannableBuilder(Context context, Lazy<LinkifyUtil> lazy, RTLUtil rTLUtil, Lazy<GraphQLLinkExtractor> lazy2) {
        this.f20538a = context;
        this.f20539b = lazy;
        this.f20540c = rTLUtil;
        this.f20541d = lazy2;
    }

    public final Builder m28273a(FeedProps<GraphQLStory> feedProps) {
        return new Builder(this, feedProps, false);
    }
}
