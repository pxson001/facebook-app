package com.facebook.feed.rows.sections.attachments;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.SizeUtil;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.abtest.ExperimentsForMultipleRowsStoriesAbtestModule;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.HasFeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.feed.rows.views.ContentTextView;
import com.facebook.feedplugins.spannable.SpannableInTextViewPartDefinition;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.HasFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ufiservices.flyout.FlyoutClickSource;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: YourSoldForSalePosts */
public class MinutiaeAttachmentTextPartDefinition<E extends HasPersistentState & HasPositionInformation & HasInvalidate> extends MultiRowSinglePartDefinition<Props, Void, E, ContentTextView> {
    public static final ViewType f20706a = new C17751();
    private static MinutiaeAttachmentTextPartDefinition f20707i;
    private static final Object f20708j = new Object();
    private final QeAccessor f20709b;
    private final BackgroundPartDefinition f20710c;
    private final SpannableInTextViewPartDefinition f20711d;
    public final int f20712e;
    private final float f20713f = this.f20709b.a(ExperimentsForMultipleRowsStoriesAbtestModule.k, 2.0f);
    private final float f20714g = this.f20709b.a(ExperimentsForMultipleRowsStoriesAbtestModule.j, 8.0f);
    private final MinutiaeAttachmentHeaderTextPersistentSpannableInputProvider f20715h;

    /* compiled from: YourSoldForSalePosts */
    final class C17751 extends ViewType {
        C17751() {
        }

        public final View m23707a(Context context) {
            return new ContentTextView(context);
        }
    }

    @Immutable
    /* compiled from: YourSoldForSalePosts */
    public class Props implements HasFeedProps<GraphQLStory>, HasFeedUnit {
        public final FeedProps<GraphQLStoryAttachment> f20701a;
        public final FlyoutClickSource f20702b;
        public final String f20703c;
        public final FeedProps<GraphQLStory> f20704d;
        @Nullable
        public final GraphQLTextWithEntities f20705e;

        public Props(FeedProps<GraphQLStoryAttachment> feedProps, FlyoutClickSource flyoutClickSource, String str) {
            this.f20701a = feedProps;
            this.f20702b = flyoutClickSource;
            this.f20703c = str;
            this.f20704d = AttachmentProps.e(feedProps);
            this.f20705e = ((GraphQLStoryAttachment) feedProps.a).n();
        }

        public final FeedUnit m23709c() {
            return (FeedUnit) this.f20704d.a;
        }

        public final FeedProps<GraphQLStory> m23710f() {
            return this.f20704d;
        }

        public final boolean m23708a() {
            return (this.f20705e == null || Strings.isNullOrEmpty(this.f20705e.a())) ? false : true;
        }
    }

    private static MinutiaeAttachmentTextPartDefinition m23712b(InjectorLike injectorLike) {
        return new MinutiaeAttachmentTextPartDefinition(ResourcesMethodAutoProvider.a(injectorLike), BackgroundPartDefinition.a(injectorLike), SpannableInTextViewPartDefinition.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), (MinutiaeAttachmentHeaderTextPersistentSpannableInputProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(MinutiaeAttachmentHeaderTextPersistentSpannableInputProvider.class));
    }

    public final Object m23714a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        subParts.a(this.f20711d, this.f20715h.m23698a(props));
        BackgroundPartDefinition backgroundPartDefinition = this.f20710c;
        FeedProps feedProps = props.f20704d;
        Builder g = Builder.g();
        g.b = this.f20713f;
        g = g;
        g.c = this.f20714g;
        subParts.a(backgroundPartDefinition, new StylingData(feedProps, g.i()));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m23715a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1074709384);
        ContentTextView contentTextView = (ContentTextView) view;
        contentTextView.setIncludeFontPadding(false);
        contentTextView.setTextSize((float) this.f20712e);
        contentTextView.setTypeface(Typeface.DEFAULT_BOLD);
        contentTextView.setTextColor(-16777216);
        contentTextView.setGravity(17);
        Logger.a(8, EntryType.MARK_POP, -1054643374, a);
    }

    public final boolean m23716a(Object obj) {
        return ((Props) obj).m23708a();
    }

    public static MinutiaeAttachmentTextPartDefinition m23711a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MinutiaeAttachmentTextPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20708j) {
                MinutiaeAttachmentTextPartDefinition minutiaeAttachmentTextPartDefinition;
                if (a2 != null) {
                    minutiaeAttachmentTextPartDefinition = (MinutiaeAttachmentTextPartDefinition) a2.a(f20708j);
                } else {
                    minutiaeAttachmentTextPartDefinition = f20707i;
                }
                if (minutiaeAttachmentTextPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23712b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20708j, b3);
                        } else {
                            f20707i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = minutiaeAttachmentTextPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public MinutiaeAttachmentTextPartDefinition(Resources resources, BackgroundPartDefinition backgroundPartDefinition, SpannableInTextViewPartDefinition spannableInTextViewPartDefinition, QeAccessor qeAccessor, MinutiaeAttachmentHeaderTextPersistentSpannableInputProvider minutiaeAttachmentHeaderTextPersistentSpannableInputProvider) {
        this.f20710c = backgroundPartDefinition;
        this.f20711d = spannableInTextViewPartDefinition;
        this.f20715h = minutiaeAttachmentHeaderTextPersistentSpannableInputProvider;
        this.f20712e = SizeUtil.c(resources, 2131427400);
        this.f20709b = qeAccessor;
    }

    public final ViewType m23713a() {
        return f20706a;
    }
}
