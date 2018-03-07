package com.facebook.feed.rows.sections.attachments;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.HasFeedProps;
import com.facebook.feed.rows.sections.attachments.components.LifeEventAttachmentHeaderTextPersistentSpannableInputProvider;
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
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.ufiservices.flyout.FlyoutClickSource;
import com.facebook.ufiservices.util.LinkifyUtil;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: ZTE;) */
public class LifeEventAttachmentHeaderTextPartDefinition<E extends HasPersistentState & HasPositionInformation & HasInvalidate> extends MultiRowSinglePartDefinition<Props, Void, E, ContentTextView> {
    public static final ViewType f20659a = new C17731();
    private static LifeEventAttachmentHeaderTextPartDefinition f20660h;
    private static final Object f20661i = new Object();
    private final Context f20662b;
    private final LinkifyUtil f20663c;
    private final Provider<FbUriIntentHandler> f20664d;
    private final BackgroundPartDefinition f20665e;
    private final SpannableInTextViewPartDefinition f20666f;
    private final LifeEventAttachmentHeaderTextPersistentSpannableInputProvider f20667g;

    /* compiled from: ZTE;) */
    final class C17731 extends ViewType {
        C17731() {
        }

        public final View m23673a(Context context) {
            return new ContentTextView(context);
        }
    }

    @Immutable
    /* compiled from: ZTE;) */
    public class Props implements HasFeedProps<GraphQLStory>, HasFeedUnit {
        public final GraphQLStoryAttachment f20649a = ((GraphQLStoryAttachment) this.f20650b.a);
        public final FeedProps<GraphQLStoryAttachment> f20650b;
        public final FlyoutClickSource f20651c;
        public final String f20652d;
        public final FeedProps<GraphQLStory> f20653e;
        public final float f20654f;
        public final float f20655g;
        public final int f20656h;
        public final int f20657i;
        @Nullable
        public final GraphQLTextWithEntities f20658j;

        public Props(FeedProps<GraphQLStoryAttachment> feedProps, FlyoutClickSource flyoutClickSource, String str, float f, float f2, int i, int i2) {
            this.f20650b = feedProps;
            this.f20651c = flyoutClickSource;
            this.f20652d = str;
            this.f20653e = AttachmentProps.e(feedProps);
            this.f20654f = f;
            this.f20655g = f2;
            this.f20656h = i;
            this.f20657i = i2;
            this.f20658j = LifeEventAttachmentUtil.m23682a(this.f20649a, this.f20652d);
        }

        public final FeedUnit m23674c() {
            return (FeedUnit) this.f20653e.a;
        }

        public final FeedProps<GraphQLStory> m23675f() {
            return this.f20653e;
        }
    }

    private static LifeEventAttachmentHeaderTextPartDefinition m23677b(InjectorLike injectorLike) {
        return new LifeEventAttachmentHeaderTextPartDefinition((Context) injectorLike.getInstance(Context.class), LinkifyUtil.a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 616), BackgroundPartDefinition.a(injectorLike), SpannableInTextViewPartDefinition.a(injectorLike), (LifeEventAttachmentHeaderTextPersistentSpannableInputProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(LifeEventAttachmentHeaderTextPersistentSpannableInputProvider.class));
    }

    public final Object m23679a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        subParts.a(this.f20666f, this.f20667g.m23836a(props.f20650b, props.m23675f(), props.f20658j, props.f20651c, props.f20652d));
        BackgroundPartDefinition backgroundPartDefinition = this.f20665e;
        FeedProps feedProps = props.f20653e;
        Builder g = Builder.g();
        g.b = props.f20654f;
        g = g;
        g.c = props.f20655g;
        subParts.a(backgroundPartDefinition, new StylingData(feedProps, g.i()));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m23680a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1843874707);
        Props props = (Props) obj;
        ContentTextView contentTextView = (ContentTextView) view;
        contentTextView.setIncludeFontPadding(false);
        contentTextView.setTextSize((float) props.f20656h);
        contentTextView.setTextColor(props.f20657i);
        contentTextView.setGravity(17);
        Logger.a(8, EntryType.MARK_POP, -1221612270, a);
    }

    public final boolean m23681a(Object obj) {
        Props props = (Props) obj;
        return (props.f20658j == null || Strings.isNullOrEmpty(props.f20658j.a())) ? false : true;
    }

    public static LifeEventAttachmentHeaderTextPartDefinition m23676a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LifeEventAttachmentHeaderTextPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20661i) {
                LifeEventAttachmentHeaderTextPartDefinition lifeEventAttachmentHeaderTextPartDefinition;
                if (a2 != null) {
                    lifeEventAttachmentHeaderTextPartDefinition = (LifeEventAttachmentHeaderTextPartDefinition) a2.a(f20661i);
                } else {
                    lifeEventAttachmentHeaderTextPartDefinition = f20660h;
                }
                if (lifeEventAttachmentHeaderTextPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23677b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20661i, b3);
                        } else {
                            f20660h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = lifeEventAttachmentHeaderTextPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public LifeEventAttachmentHeaderTextPartDefinition(Context context, LinkifyUtil linkifyUtil, Provider<FbUriIntentHandler> provider, BackgroundPartDefinition backgroundPartDefinition, SpannableInTextViewPartDefinition spannableInTextViewPartDefinition, LifeEventAttachmentHeaderTextPersistentSpannableInputProvider lifeEventAttachmentHeaderTextPersistentSpannableInputProvider) {
        this.f20662b = context;
        this.f20663c = linkifyUtil;
        this.f20664d = provider;
        this.f20665e = backgroundPartDefinition;
        this.f20666f = spannableInTextViewPartDefinition;
        this.f20667g = lifeEventAttachmentHeaderTextPersistentSpannableInputProvider;
    }

    public final ViewType m23678a() {
        return f20659a;
    }
}
