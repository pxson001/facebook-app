package com.facebook.feedplugins.graphqlstory.header;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.CommonEventsBuilder;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.uri.NativeUri;
import com.facebook.common.uri.NativeUri.Builder;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.LazyResources;
import com.facebook.common.util.StringUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.datasensitivity.pref.DataSensitivitySettingsPrefUtil;
import com.facebook.directinstall.util.DirectInstallApplicationUtils;
import com.facebook.earlyfetch.EarlyFetchController;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.topicfeeds.abtest.TopicFeedsTestUtil;
import com.facebook.feedplugins.graphqlstory.header.DefaultHeaderPartDataProviderForTextLayoutGraphQLModels.DispatchAvatarClickGraphQLModel;
import com.facebook.feedplugins.graphqlstory.header.DefaultHeaderPartDataProviderForTextLayoutGraphQLModels.DispatchAvatarClickGraphQLModel.ActorsModel;
import com.facebook.feedplugins.graphqlstory.header.DefaultHeaderPartDataProviderForTextLayoutGraphQLModels.DispatchAvatarClickGraphQLModel.AttachmentsModel;
import com.facebook.feedplugins.graphqlstory.header.DefaultHeaderPartDataProviderForTextLayoutGraphQLModels.DispatchAvatarClickGraphQLModel.AttachmentsModel.ActionLinksModel;
import com.facebook.feedplugins.graphqlstory.header.DefaultHeaderPartDataProviderForTextLayoutGraphQLModels.DispatchAvatarClickGraphQLModel.AttachmentsModel.ActionLinksModel.LinkTargetStoreDataModel;
import com.facebook.feedplugins.graphqlstory.header.HeaderPartDataProviderForTextLayout.HeaderSubtitleData;
import com.facebook.feedplugins.highlighter.FeedHighlighter;
import com.facebook.goodfriends.abtest.FeedPrivacyRenderingQEStore;
import com.facebook.goodfriends.abtest.GoodFriendsFeedPrivacyRenderingQEStore;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.linkutil.GraphQLLinkExtractor;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLExploreFeed;
import com.facebook.graphql.model.GraphQLFeedTopicContent;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.graphql.story.util.StoryParentContext;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.intent.thirdparty.NativeThirdPartyUriHelper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.privacy.ui.DefaultPrivacyScopeResourceResolver;
import com.facebook.privacy.ui.PrivacyScopeResourceResolver;
import com.facebook.story.GraphQLStoryHelper;
import com.facebook.timeline.intent.ModelBundle;
import com.facebook.timeline.intent.ModelBundleGraphQLInterfaces.ModelBundleProfileGraphQL;
import com.facebook.widget.text.PrivacyImageSpan;
import com.facebook.widget.text.RoundedBackgroundSpan;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: image_large_aspect_height */
public class DefaultHeaderPartDataProviderForTextLayout implements HeaderPartDataProviderForTextLayout {
    public static final String f20425a = HeaderPartDataProviderForTextLayout.class.getName();
    private static DefaultHeaderPartDataProviderForTextLayout f20426x;
    private static final Object f20427y = new Object();
    private final Context f20428b;
    public final AbstractFbErrorReporter f20429c;
    private final FeedHighlighter f20430d;
    public final AnalyticsLogger f20431e;
    public final NavigationLogger f20432f;
    public final IFeedIntentBuilder f20433g;
    public final CommonEventsBuilder f20434h;
    public final DefaultHeaderTimeInfoFormatter f20435i;
    private final GraphQLLinkExtractor f20436j;
    private final EarlyFetchController f20437k;
    private final DefaultPrivacyScopeResourceResolver f20438l;
    private final BulletedHeaderSubtitleFormatter f20439m;
    private final NewsFeedAnalyticsEventBuilder f20440n;
    public final TopicFeedsTestUtil f20441o;
    private final GlyphColorizer f20442p;
    public final SecureContextHelper f20443q;
    private final Lazy<Float> f20444r = LazyResources.m28240a(this.f20428b.getResources(), 2131430297);
    private final Lazy<Float> f20445s = LazyResources.m28240a(this.f20428b.getResources(), 2131430296);
    private final Lazy<PrivacyScopeStringHelper> f20446t;
    private final FeedPrivacyRenderingQEStore f20447u;
    private final GoodFriendsFeedPrivacyRenderingQEStore f20448v;
    private final DataSensitivitySettingsPrefUtil f20449w;

    /* compiled from: image_large_aspect_height */
    public class C08732 implements OnClickListener {
        final /* synthetic */ GraphQLStory f21905a;
        final /* synthetic */ FeedProps f21906b;
        final /* synthetic */ DefaultHeaderPartDataProviderForTextLayout f21907c;

        public C08732(DefaultHeaderPartDataProviderForTextLayout defaultHeaderPartDataProviderForTextLayout, GraphQLStory graphQLStory, FeedProps feedProps) {
            this.f21907c = defaultHeaderPartDataProviderForTextLayout;
            this.f21905a = graphQLStory;
            this.f21906b = feedProps;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1336728410);
            this.f21907c.m28182a(view, DefaultHeaderPartConverter.a(this.f21905a), StoryParentContext.a(this.f21906b));
            Logger.a(2, EntryType.UI_INPUT_END, 2024640330, a);
        }
    }

    private static DefaultHeaderPartDataProviderForTextLayout m28179b(InjectorLike injectorLike) {
        return new DefaultHeaderPartDataProviderForTextLayout((Context) injectorLike.getInstance(Context.class), FbErrorReporterImpl.m2317a(injectorLike), FeedHighlighter.m28184a(injectorLike), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), NavigationLogger.m5475a(injectorLike), DefaultFeedIntentBuilder.m26214a(injectorLike), CommonEventsBuilder.m14535a(injectorLike), DefaultHeaderTimeInfoFormatter.m28192a(injectorLike), GraphQLLinkExtractor.m26442a(injectorLike), EarlyFetchController.m28202a(injectorLike), DefaultPrivacyScopeResourceResolver.m18602a(injectorLike), BulletedHeaderSubtitleFormatter.m28213a(injectorLike), NewsFeedAnalyticsEventBuilder.m14112a(injectorLike), TopicFeedsTestUtil.m8785a(injectorLike), GlyphColorizer.m11486a(injectorLike), DefaultSecureContextHelper.m4636a(injectorLike), FeedPrivacyRenderingQEStore.m28224a(injectorLike), IdBasedLazy.m1808a(injectorLike, 1881), GoodFriendsFeedPrivacyRenderingQEStore.m28232a(injectorLike), DataSensitivitySettingsPrefUtil.m8604a(injectorLike));
    }

    public static DefaultHeaderPartDataProviderForTextLayout m28171a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            DefaultHeaderPartDataProviderForTextLayout b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20427y) {
                DefaultHeaderPartDataProviderForTextLayout defaultHeaderPartDataProviderForTextLayout;
                if (a2 != null) {
                    defaultHeaderPartDataProviderForTextLayout = (DefaultHeaderPartDataProviderForTextLayout) a2.mo818a(f20427y);
                } else {
                    defaultHeaderPartDataProviderForTextLayout = f20426x;
                }
                if (defaultHeaderPartDataProviderForTextLayout == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28179b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20427y, b3);
                        } else {
                            f20426x = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = defaultHeaderPartDataProviderForTextLayout;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public DefaultHeaderPartDataProviderForTextLayout(Context context, FbErrorReporter fbErrorReporter, FeedHighlighter feedHighlighter, AnalyticsLogger analyticsLogger, NavigationLogger navigationLogger, IFeedIntentBuilder iFeedIntentBuilder, CommonEventsBuilder commonEventsBuilder, HeaderTimeInfoFormatter headerTimeInfoFormatter, GraphQLLinkExtractor graphQLLinkExtractor, EarlyFetchController earlyFetchController, PrivacyScopeResourceResolver privacyScopeResourceResolver, BulletedHeaderSubtitleFormatter bulletedHeaderSubtitleFormatter, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, TopicFeedsTestUtil topicFeedsTestUtil, GlyphColorizer glyphColorizer, SecureContextHelper secureContextHelper, FeedPrivacyRenderingQEStore feedPrivacyRenderingQEStore, Lazy<PrivacyScopeStringHelper> lazy, GoodFriendsFeedPrivacyRenderingQEStore goodFriendsFeedPrivacyRenderingQEStore, DataSensitivitySettingsPrefUtil dataSensitivitySettingsPrefUtil) {
        this.f20428b = context;
        this.f20429c = fbErrorReporter;
        this.f20430d = feedHighlighter;
        this.f20431e = analyticsLogger;
        this.f20432f = navigationLogger;
        this.f20433g = iFeedIntentBuilder;
        this.f20434h = commonEventsBuilder;
        this.f20435i = headerTimeInfoFormatter;
        this.f20436j = graphQLLinkExtractor;
        this.f20437k = earlyFetchController;
        this.f20438l = privacyScopeResourceResolver;
        this.f20439m = bulletedHeaderSubtitleFormatter;
        this.f20440n = newsFeedAnalyticsEventBuilder;
        this.f20441o = topicFeedsTestUtil;
        this.f20442p = glyphColorizer;
        this.f20443q = secureContextHelper;
        this.f20446t = lazy;
        this.f20447u = feedPrivacyRenderingQEStore;
        this.f20448v = goodFriendsFeedPrivacyRenderingQEStore;
        this.f20449w = dataSensitivitySettingsPrefUtil;
    }

    public final HeaderSubtitleData mo3137a(FeedProps<GraphQLStory> feedProps, TextPaint textPaint, Paint paint, int i) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.m19804a();
        String a = this.f20435i.m28195a((FeedProps) feedProps);
        SpannableStringBuilder a2 = m28170a(this.f20439m.m28220a((FeedProps) feedProps, a));
        if (a2 == null) {
            return HeaderSubtitleData.f21926d;
        }
        SpannableStringBuilder spannableStringBuilder;
        int i2;
        boolean z;
        Spannable spannable;
        int b = m28178b(graphQLStory, a2);
        String a3 = m28174a(graphQLStory, (CharSequence) a2);
        int i3 = 0;
        PrivacyImageSpan privacyImageSpan = null;
        if (b != 0) {
            Drawable a4 = this.f20442p.m11489a(b, ContextUtils.m2503c(this.f20428b, 16843282, -7235677));
            if (a4 != null) {
                i3 = a4.getIntrinsicWidth();
                privacyImageSpan = new PrivacyImageSpan(a4);
            }
        }
        int ceil = (int) Math.ceil((double) Layout.getDesiredWidth(a2, textPaint));
        if (ceil + i3 <= i) {
            spannableStringBuilder = a2;
        } else {
            spannableStringBuilder = m28170a(this.f20439m.m28222b(feedProps, a));
            ceil = (int) Math.ceil((double) Layout.getDesiredWidth(spannableStringBuilder, textPaint));
        }
        Object obj;
        if (privacyImageSpan != null) {
            PrivacyScopeStringHelper$PrivacyString a5 = m28172a(graphQLStory, a2);
            if (!m28177a(a3) || Strings.isNullOrEmpty(a5.m29735a())) {
                int length = spannableStringBuilder.length();
                spannableStringBuilder.append(a3);
                spannableStringBuilder.setSpan(privacyImageSpan, length, spannableStringBuilder.length(), 17);
                i2 = ceil + i3;
                z = false;
                obj = spannableStringBuilder;
            } else {
                boolean z2;
                CharSequence a6 = ((PrivacyScopeStringHelper) this.f20446t.get()).a(m28173a(graphQLStory), this.f20439m, privacyImageSpan, a5, spannableStringBuilder, textPaint, this.f20444r, this.f20445s, graphQLStory.ay() != null ? graphQLStory.ay().m24814n() : false);
                i2 = (int) Layout.getDesiredWidth(a6, textPaint);
                if (i < i2) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                z = z2;
                spannable = a6;
            }
        } else {
            z = false;
            i2 = ceil;
            obj = spannableStringBuilder;
        }
        m28176a(spannable, graphQLStory, i2, i, textPaint, paint, z);
        m28175a(spannable, i2, i, textPaint, paint, z);
        if (FeedHighlighter.m28185a(graphQLStory)) {
            this.f20430d.m28188a(graphQLStory, spannable);
        }
        return new HeaderSubtitleData(i, spannable, b);
    }

    private static String m28173a(GraphQLStory graphQLStory) {
        if (graphQLStory.m22349b() != null && graphQLStory.m22349b().size() > 0) {
            GraphQLActor graphQLActor = (GraphQLActor) graphQLStory.m22349b().get(0);
            if (!(graphQLActor == null || graphQLActor.aa() == null)) {
                return graphQLActor.aa();
            }
        }
        return "";
    }

    private void m28175a(SpannableStringBuilder spannableStringBuilder, int i, int i2, TextPaint textPaint, Paint paint, boolean z) {
        if (this.f20449w.m8613e(false)) {
            int length = spannableStringBuilder.length();
            this.f20439m.m28221a(spannableStringBuilder);
            int length2 = spannableStringBuilder.length();
            int desiredWidth = (int) (((float) i) + Layout.getDesiredWidth(spannableStringBuilder, length, length2, textPaint));
            int length3 = spannableStringBuilder.length();
            spannableStringBuilder.append("dsm");
            int length4 = spannableStringBuilder.length();
            spannableStringBuilder.setSpan(new RoundedBackgroundSpan(((Float) this.f20444r.get()).floatValue(), ((Float) this.f20445s.get()).floatValue(), paint), length3, length4, 17);
            int desiredWidth2 = (int) (((float) desiredWidth) + Layout.getDesiredWidth(spannableStringBuilder, length3, length4, textPaint));
            if (!z && i2 < desiredWidth2) {
                spannableStringBuilder.replace(length, length2, "\n");
            }
        }
    }

    private boolean m28177a(String str) {
        return "good_friends".equals(str) ? this.f20448v.m28234a() : this.f20447u.m28226a();
    }

    private void m28176a(SpannableStringBuilder spannableStringBuilder, GraphQLStory graphQLStory, int i, int i2, TextPaint textPaint, Paint paint, boolean z) {
        if (this.f20441o.m8792b()) {
            GraphQLFeedTopicContent Z = graphQLStory.m22340Z();
            if (Z != null && Z.m24195a().size() != 0) {
                int i3 = 0;
                int i4 = 0;
                Object obj = 1;
                ImmutableList a = Z.m24195a();
                int size = a.size();
                int i5 = 0;
                boolean z2 = z;
                int i6 = i;
                while (i5 < size) {
                    Object obj2;
                    GraphQLExploreFeed graphQLExploreFeed = (GraphQLExploreFeed) a.get(i5);
                    if (StringUtil.m3589a(graphQLExploreFeed.q())) {
                        obj2 = obj;
                    } else {
                        boolean z3;
                        if (obj != null) {
                            i3 = spannableStringBuilder.length();
                            this.f20439m.m28221a(spannableStringBuilder);
                            i4 = spannableStringBuilder.length();
                            i6 = (int) (((float) i6) + Layout.getDesiredWidth(spannableStringBuilder, i3, i4, textPaint));
                        }
                        int length = spannableStringBuilder.length();
                        if (obj == null) {
                            spannableStringBuilder.append(' ');
                        }
                        spannableStringBuilder.append(graphQLExploreFeed.q());
                        int i7 = obj != null ? length : length + 1;
                        int length2 = spannableStringBuilder.length();
                        if (this.f20441o.m8799i()) {
                            spannableStringBuilder.setSpan(new 1(this, graphQLExploreFeed), i7, length2, 17);
                        }
                        spannableStringBuilder.setSpan(new RoundedBackgroundSpan(((Float) this.f20444r.get()).floatValue(), ((Float) this.f20445s.get()).floatValue(), paint), i7, length2, 17);
                        i7 = (int) (((float) i6) + Layout.getDesiredWidth(spannableStringBuilder, length, length2, textPaint));
                        if (z2 || i2 >= i7) {
                            z3 = z2;
                        } else {
                            spannableStringBuilder.replace(i3, i4, "\n");
                            z3 = true;
                        }
                        z2 = z3;
                        obj2 = null;
                        i6 = i7;
                    }
                    i5++;
                    obj = obj2;
                }
            }
        }
    }

    private static SpannableStringBuilder m28170a(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        if (charSequence instanceof SpannableStringBuilder) {
            return (SpannableStringBuilder) charSequence;
        }
        return new SpannableStringBuilder(charSequence);
    }

    public final void m28182a(View view, DispatchAvatarClickGraphQLModel dispatchAvatarClickGraphQLModel, StoryParentContext storyParentContext) {
        Bundle a = m28169a(dispatchAvatarClickGraphQLModel);
        ActorsModel actorsModel = dispatchAvatarClickGraphQLModel.a() != null ? (ActorsModel) dispatchAvatarClickGraphQLModel.a().get(0) : null;
        if (actorsModel != null) {
            String b;
            if (actorsModel.c() != null) {
                this.f20437k.m28205a(actorsModel.c().m22301g(), actorsModel.g(), a);
            }
            String a2 = this.f20436j.m26445a(actorsModel.c(), actorsModel.g());
            if (a2 == null) {
                b = actorsModel.b();
            } else {
                b = a2;
            }
            if (b != null) {
                Map d;
                if (NativeThirdPartyUriHelper.m29571a(b)) {
                    d = NewsFeedAnalyticsEventBuilder.m14121d(storyParentContext.a, storyParentContext.b);
                } else {
                    String str;
                    HoneyClientEvent a3 = this.f20434h.m14541a(b, storyParentContext.a, storyParentContext.b, "native_newsfeed");
                    if (!TrackingNodes.m27144a(a3)) {
                        TrackingNodes.m27142a(a3, view);
                    }
                    this.f20431e.mo528a(a3);
                    NavigationLogger navigationLogger = this.f20432f;
                    if (a3 == null || !a3.f3106j) {
                        str = "tap_profile_pic";
                    } else {
                        str = "tap_profile_pic_sponsored";
                    }
                    navigationLogger.m5498a(str);
                    d = null;
                }
                if (NativeThirdPartyUriHelper.m29571a(b)) {
                    Builder f = NativeUri.f();
                    f.a = b;
                    f = f;
                    f.d = DirectInstallApplicationUtils.a(actorsModel, dispatchAvatarClickGraphQLModel.c(), b);
                    f = f;
                    f.b = a;
                    Builder a4 = f.a(d);
                    a4.e = "NEWSFEED";
                    this.f20433g.mo3015a(view.getContext(), a4.a());
                    return;
                }
                this.f20433g.mo3017a(view.getContext(), b, a, d);
            }
        }
    }

    @Nullable
    private static Bundle m28169a(DispatchAvatarClickGraphQLModel dispatchAvatarClickGraphQLModel) {
        Bundle bundle;
        AttachmentsModel attachmentsModel;
        ModelBundleProfileGraphQL modelBundleProfileGraphQL = dispatchAvatarClickGraphQLModel.a() != null ? (ActorsModel) dispatchAvatarClickGraphQLModel.a().get(0) : null;
        if (modelBundleProfileGraphQL != null) {
            Bundle bundle2 = new Bundle();
            ModelBundle.a(bundle2, modelBundleProfileGraphQL);
            bundle = bundle2;
        } else {
            bundle = null;
        }
        if (dispatchAvatarClickGraphQLModel.b() == null || dispatchAvatarClickGraphQLModel.b().size() <= 0) {
            attachmentsModel = null;
        } else {
            attachmentsModel = (AttachmentsModel) dispatchAvatarClickGraphQLModel.b().get(0);
        }
        if (attachmentsModel != null) {
            ImmutableList a = attachmentsModel.a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                ActionLinksModel actionLinksModel = (ActionLinksModel) a.get(i);
                GraphQLObjectType a2 = actionLinksModel.a();
                if (a2 != null && a2.m22301g() == -508788748) {
                    LinkTargetStoreDataModel b = actionLinksModel.b();
                    if (b != null) {
                        if (bundle == null) {
                            bundle2 = new Bundle();
                        } else {
                            bundle2 = bundle;
                        }
                        bundle2.putBoolean("show_beeper", b.a());
                        bundle = bundle2;
                    }
                }
            }
            if (GraphQLStoryAttachmentUtil.m28052a(attachmentsModel.b(), GraphQLStoryAttachmentStyle.GROUP_SELL_PRODUCT_ITEM) && attachmentsModel.c() != null) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putString("group_commerce_sell_options_id", attachmentsModel.c().b());
            }
        }
        return bundle;
    }

    private static String m28174a(GraphQLStory graphQLStory, CharSequence charSequence) {
        if (GraphQLStoryHelper.m10201c(graphQLStory) == null || charSequence == null || charSequence.length() <= 0) {
            return "";
        }
        return GraphQLStoryHelper.m10201c(graphQLStory).m23522s();
    }

    private int m28178b(GraphQLStory graphQLStory, CharSequence charSequence) {
        String a = m28174a(graphQLStory, charSequence);
        if (StringUtil.m3589a((CharSequence) a)) {
            return 0;
        }
        return this.f20438l.m18603a(a);
    }

    private PrivacyScopeStringHelper$PrivacyString m28172a(GraphQLStory graphQLStory, SpannableStringBuilder spannableStringBuilder) {
        String a = m28174a(graphQLStory, (CharSequence) spannableStringBuilder);
        String str = null;
        if (!(GraphQLStoryHelper.m10201c(graphQLStory) == null || spannableStringBuilder == null || spannableStringBuilder.length() <= 0)) {
            str = GraphQLStoryHelper.m10201c(graphQLStory).m23517n();
        }
        if (str == null) {
            str = "";
        }
        return new PrivacyScopeStringHelper$PrivacyString(str, a);
    }

    public static boolean m28180c(FeedProps<GraphQLStory> feedProps, FeedProps<GraphQLStory> feedProps2) {
        Object obj = null;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        GraphQLStory graphQLStory2 = (GraphQLStory) feedProps2.f13444a;
        String s = GraphQLStoryHelper.m10201c(graphQLStory) != null ? GraphQLStoryHelper.m10201c(graphQLStory).m23522s() : null;
        if (GraphQLStoryHelper.m10201c(graphQLStory2) != null) {
            obj = GraphQLStoryHelper.m10201c(graphQLStory2).m23522s();
        }
        if (s != null) {
            if (!s.equals(obj)) {
                return false;
            }
        } else if (obj != null) {
            return false;
        }
        return true;
    }
}
