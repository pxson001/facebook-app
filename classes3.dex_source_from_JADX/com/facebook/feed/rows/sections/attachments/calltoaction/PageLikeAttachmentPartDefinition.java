package com.facebook.feed.rows.sections.attachments.calltoaction;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.View;
import com.facebook.attachments.angora.AttachmentHasButton;
import com.facebook.attachments.angora.AttachmentHasClear;
import com.facebook.attachments.angora.AttachmentHasLabel;
import com.facebook.attachments.utils.CallToActionUtil;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.environment.CanLikePage;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.AttachmentLabelPartDefinition;
import com.facebook.feed.rows.sections.attachments.calltoaction.ui.PageLikeAttachmentView;
import com.facebook.feed.rows.sections.header.ui.HasClickableProfileImage;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.DefaultPaddingStyleResolver;
import com.facebook.feedplugins.links.ProfileLinkPartDefinition;
import com.facebook.feedplugins.links.ProfileLinkPartDefinition.Props;
import com.facebook.fig.attachment.FIGAttachmentView;
import com.facebook.fig.attachment.qe.ExperimentsForFIGAttachmentModule;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.resources.utils.ResourceUtils;
import com.google.common.base.Strings;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;

@ContextScoped
/* compiled from: _MEDIA_GALLERY */
public class PageLikeAttachmentPartDefinition<E extends HasFeedListType & HasPositionInformation & HasInvalidate & CanLikePage, V extends View & AttachmentHasLabel & AttachmentHasButton & AttachmentHasClear & HasClickableProfileImage> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, V> {
    public static final ViewType f301a = new C00091();
    @VisibleForTesting
    static final AtomicReference<ViewType> f302b = new AtomicReference();
    private static PageLikeAttachmentPartDefinition f303k;
    private static final Object f304l = new Object();
    private final Context f305c;
    private final BackgroundPartDefinition f306d;
    private final DefaultPaddingStyleResolver f307e;
    private final ProfileLinkPartDefinition<GraphQLStoryAttachment, V> f308f;
    public final NewsFeedAnalyticsEventBuilder f309g;
    private final AttachmentLabelPartDefinition<V> f310h;
    private final ActionButtonPartDefinition<E, V> f311i;
    private final QeAccessor f312j;

    /* compiled from: _MEDIA_GALLERY */
    final class C00091 extends ViewType {
        C00091() {
        }

        public final View m277a(Context context) {
            return new PageLikeAttachmentView(context);
        }
    }

    private static PageLikeAttachmentPartDefinition m272b(InjectorLike injectorLike) {
        return new PageLikeAttachmentPartDefinition((Context) injectorLike.getInstance(Context.class), BackgroundPartDefinition.a(injectorLike), DefaultPaddingStyleResolver.a(injectorLike), ProfileLinkPartDefinition.a(injectorLike), NewsFeedAnalyticsEventBuilder.a(injectorLike), AttachmentLabelPartDefinition.a(injectorLike), ActionButtonPartDefinition.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public static PageLikeAttachmentPartDefinition m271a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PageLikeAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f304l) {
                PageLikeAttachmentPartDefinition pageLikeAttachmentPartDefinition;
                if (a2 != null) {
                    pageLikeAttachmentPartDefinition = (PageLikeAttachmentPartDefinition) a2.a(f304l);
                } else {
                    pageLikeAttachmentPartDefinition = f303k;
                }
                if (pageLikeAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m272b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f304l, b3);
                        } else {
                            f303k = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pageLikeAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final Object m274a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        subParts.a(this.f306d, new StylingData(AttachmentProps.e(feedProps), this.f307e.h(), 2130840313, -1));
        subParts.a(this.f308f, new Props(feedProps, new 3(this), new 2(this)));
        GraphQLPage ab = ActionLinkHelper.a(graphQLStoryAttachment, -581184810).ab();
        subParts.a(this.f310h, new AttachmentLabelPartDefinition.Props(m270a(ab), m269a(this.f305c, GraphQLHelper.c(ab))));
        subParts.a(this.f311i, feedProps);
        return null;
    }

    public final boolean m275a(Object obj) {
        return CallToActionUtil.h((GraphQLStoryAttachment) ((FeedProps) obj).a);
    }

    @Inject
    public PageLikeAttachmentPartDefinition(Context context, BackgroundPartDefinition backgroundPartDefinition, DefaultPaddingStyleResolver defaultPaddingStyleResolver, ProfileLinkPartDefinition profileLinkPartDefinition, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, AttachmentLabelPartDefinition attachmentLabelPartDefinition, ActionButtonPartDefinition actionButtonPartDefinition, QeAccessor qeAccessor) {
        this.f305c = context;
        this.f306d = backgroundPartDefinition;
        this.f307e = defaultPaddingStyleResolver;
        this.f308f = profileLinkPartDefinition;
        this.f309g = newsFeedAnalyticsEventBuilder;
        this.f310h = attachmentLabelPartDefinition;
        this.f311i = actionButtonPartDefinition;
        this.f312j = qeAccessor;
    }

    public final ViewType m273a() {
        if (f302b.get() == null) {
            f302b.set(this.f312j.a(ExperimentsForFIGAttachmentModule.a, false) ? FIGAttachmentView.h : f301a);
        }
        return (ViewType) f302b.get();
    }

    public final void m276b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((AttachmentHasClear) view).a();
    }

    private static Spannable m270a(GraphQLPage graphQLPage) {
        Spannable spannableStringBuilder = new SpannableStringBuilder();
        Object aG = graphQLPage.aG();
        if (!Strings.isNullOrEmpty(aG)) {
            spannableStringBuilder.append(aG);
            spannableStringBuilder.setSpan(new StyleSpan(1), 0, aG.length(), 17);
        }
        CharSequence b = GraphQLHelper.b(graphQLPage);
        if (!StringUtil.c(b)) {
            if (spannableStringBuilder.length() > 0) {
                spannableStringBuilder.append("\n");
            }
            spannableStringBuilder.append(b);
        }
        return spannableStringBuilder;
    }

    private Spannable m269a(Context context, int i) {
        String str;
        Spannable spannableStringBuilder = new SpannableStringBuilder();
        if (i <= 0) {
            str = null;
        } else {
            str = ResourceUtils.a(context.getResources(), 2131233554, 2131233555, i);
        }
        String str2 = str;
        if (!Strings.isNullOrEmpty(str2)) {
            spannableStringBuilder.append(str2);
            spannableStringBuilder.setSpan(new StyleSpan(1), 0, str2.length(), 17);
        }
        return spannableStringBuilder;
    }
}
