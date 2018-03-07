package com.facebook.ufiservices.util;

import android.content.Context;
import android.content.res.Resources;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.model.FeedStorySpannableString;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ufiservices.flyout.FlyoutClickSource;
import com.facebook.widget.text.markdown.Markdown;
import javax.inject.Inject;

@ContextScoped
/* compiled from: is_sort_key_less_feed_unit_collection_enabled */
public class MessageSpannableBuilder {
    private static MessageSpannableBuilder f18847g;
    private static final Object f18848h = new Object();
    private final LinkifyUtil f18849a;
    private final Lazy<MessageTruncator> f18850b;
    private final Lazy<LinkifySpanFactory> f18851c;
    private final String f18852d;
    private final AbstractFbErrorReporter f18853e;
    private final GatekeeperStoreImpl f18854f;

    private static MessageSpannableBuilder m26521b(InjectorLike injectorLike) {
        return new MessageSpannableBuilder(LinkifyUtil.m26532a(injectorLike), IdBasedLazy.m1808a(injectorLike, 3540), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3536), ResourcesMethodAutoProvider.m6510a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike));
    }

    @Inject
    public MessageSpannableBuilder(LinkifyUtil linkifyUtil, Lazy<MessageTruncator> lazy, Lazy<LinkifySpanFactory> lazy2, Resources resources, FbErrorReporter fbErrorReporter, GatekeeperStore gatekeeperStore) {
        this.f18849a = linkifyUtil;
        this.f18850b = lazy;
        this.f18851c = lazy2;
        this.f18852d = resources.getString(2131233418);
        this.f18853e = fbErrorReporter;
        this.f18854f = gatekeeperStore;
    }

    public final Spannable m26524a(FeedProps<GraphQLStory> feedProps) {
        return m26525a((FeedProps) feedProps, 0);
    }

    public static MessageSpannableBuilder m26520a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MessageSpannableBuilder b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f18848h) {
                MessageSpannableBuilder messageSpannableBuilder;
                if (a2 != null) {
                    messageSpannableBuilder = (MessageSpannableBuilder) a2.mo818a(f18848h);
                } else {
                    messageSpannableBuilder = f18847g;
                }
                if (messageSpannableBuilder == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m26521b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f18848h, b3);
                        } else {
                            f18847g = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = messageSpannableBuilder;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final Spannable m26525a(FeedProps<GraphQLStory> feedProps, int i) {
        CharSequence a = m26519a((FeedProps) feedProps, m26522c(feedProps, i));
        if (a == null) {
            return null;
        }
        return new FeedStorySpannableString(a);
    }

    public final Spannable m26527b(FeedProps<GraphQLStory> feedProps, int i) {
        return m26518a((FeedProps) feedProps, i, -1);
    }

    private Spannable m26518a(FeedProps<GraphQLStory> feedProps, int i, int i2) {
        Spannable c = m26522c(feedProps, i);
        if (c == null) {
            return null;
        }
        if (i2 == -1) {
            i2 = ((MessageTruncator) this.f18850b.get()).m31230a((CharSequence) c, (FeedProps) feedProps);
        }
        return m26517a(c, (FeedProps) feedProps, i2);
    }

    private Spannable m26519a(FeedProps<GraphQLStory> feedProps, Spannable spannable) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        int i = (StoryAttachmentHelper.m28029a(graphQLStory) && GraphQLStoryAttachmentUtil.m28056f((GraphQLStoryAttachment) graphQLStory.m22327M().get(0))) ? 1 : 0;
        if (i != 0 || graphQLStory.aE() == null) {
            return spannable;
        }
        Spannable a = this.f18849a.m26552a(LinkifyUtilConverter.m29870b(graphQLStory.aE()), TrackableFeedProps.m27451a(feedProps));
        return SpannableString.valueOf(TextUtils.concat(new CharSequence[]{spannable, a}));
    }

    public final Spannable m26526b(FeedProps<GraphQLStory> feedProps) {
        Spannable c = m26522c(feedProps, 0);
        if (c == null) {
            return null;
        }
        int i;
        this.f18850b.get();
        if (StoryProps.m27456c(feedProps) != null) {
            i = 250;
        } else {
            i = 100;
        }
        return m26517a(c, (FeedProps) feedProps, i);
    }

    private Spannable m26517a(Spannable spannable, FeedProps<GraphQLStory> feedProps, int i) {
        Spannable a;
        try {
            a = this.f18849a.m26553a((CharSequence) spannable, spannable.length(), ((DefaultLinkifySpanFactory) this.f18851c.get()).m30359a((FeedProps) feedProps), i, this.f18852d);
        } catch (Throwable e) {
            this.f18853e.m2351b("LinkifyUtil.IndexOutOfBoundsException - truncate", spannable.toString(), e);
            a = null;
        }
        if (a == null) {
            return new FeedStorySpannableString(m26519a((FeedProps) feedProps, spannable));
        }
        return m26519a((FeedProps) feedProps, a);
    }

    private Spannable m26522c(FeedProps<GraphQLStory> feedProps, int i) {
        if (feedProps == null || StoryHierarchyHelper.m27435b((GraphQLStory) feedProps.m19804a()) == null) {
            return null;
        }
        Spannable a;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.m19804a();
        try {
            a = this.f18849a.m26551a(LinkifyUtilConverter.m29870b(StoryHierarchyHelper.m27435b(graphQLStory)), FlyoutClickSource.MESSAGE, TrackableFeedProps.m27451a(feedProps), i);
        } catch (Throwable e) {
            this.f18853e.m2351b("LinkifyUtil.IndexOutOfBoundsException", graphQLStory.S_() != null ? graphQLStory.S_() : "No debug info", e);
            a = SpannableString.valueOf(StoryHierarchyHelper.m27435b(graphQLStory).mo2911a());
        }
        if (m26523c(feedProps)) {
            return Markdown.a(a, graphQLStory.ba().mo2911a());
        }
        return a;
    }

    private boolean m26523c(FeedProps<GraphQLStory> feedProps) {
        return this.f18854f.m2189a(149, false) && ((GraphQLStory) feedProps.f13444a).ba() != null;
    }
}
