package com.facebook.feed.rows.sections.attachments;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.SizeUtil;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.renderer.DefaultFeedUnitRenderer;
import com.facebook.feed.rows.core.FeedListName;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.feed.rows.views.ContentTextView;
import com.facebook.feed.spannable.PersistentSpannable;
import com.facebook.feedplugins.base.TextLinkPartDefinition;
import com.facebook.feedplugins.spannable.PersistentSpannableWithoutLayoutInput;
import com.facebook.feedplugins.spannable.SpannableInTextViewPartDefinition;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.graphql.model.mutator.GraphQLStoryMutator;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ZZTDataProvider;)V */
public class LifeEventAttachmentDescriptionPartDefinition<E extends HasPositionInformation & HasFeedListType> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Integer, E, ContentTextView> {
    public static final ViewType f20617a = new C17711();
    public static final Class f20618b = LifeEventAttachmentDescriptionPartDefinition.class;
    private static LifeEventAttachmentDescriptionPartDefinition f20619i;
    private static final Object f20620j = new Object();
    public final Context f20621c;
    private final BackgroundPartDefinition f20622d;
    public final DefaultFeedUnitRenderer f20623e;
    public final AbstractFbErrorReporter f20624f;
    private final SpannableInTextViewPartDefinition f20625g;
    private final Lazy<TextLinkPartDefinition> f20626h;

    /* compiled from: ZZTDataProvider;)V */
    final class C17711 extends ViewType {
        C17711() {
        }

        public final View m23648a(Context context) {
            return new ContentTextView(context);
        }
    }

    /* compiled from: ZZTDataProvider;)V */
    class LifeEventAttachmentDescriptionTextPersistentSpannableInput extends PersistentSpannableWithoutLayoutInput {
        final /* synthetic */ LifeEventAttachmentDescriptionPartDefinition f20609a;
        private final GraphQLTextWithEntities f20610b;
        private final FeedProps<GraphQLStory> f20611c;
        private final ContextStateKey<String, PersistentSpannable> f20612d;

        public LifeEventAttachmentDescriptionTextPersistentSpannableInput(LifeEventAttachmentDescriptionPartDefinition lifeEventAttachmentDescriptionPartDefinition, FeedProps<GraphQLStory> feedProps, boolean z) {
            this.f20609a = lifeEventAttachmentDescriptionPartDefinition;
            this.f20610b = ((GraphQLStory) feedProps.a).aE();
            this.f20611c = feedProps;
            this.f20612d = new PersistentSpannableKey(lifeEventAttachmentDescriptionPartDefinition, feedProps, z);
        }

        public final ContextStateKey<String, PersistentSpannable> m23650a() {
            return this.f20612d;
        }

        public final GraphQLTextWithEntities m23651b() {
            return this.f20610b;
        }

        public final CacheableEntity m23652c() {
            return (CacheableEntity) this.f20611c.a;
        }

        public final int m23649a(Spannable spannable) {
            if (this.f20610b == null || this.f20610b.d() == null || this.f20610b.d().isEmpty()) {
                return 0;
            }
            return spannable.length() - this.f20610b.a().length();
        }
    }

    /* compiled from: ZZTDataProvider;)V */
    class PersistentSpannableKey implements ContextStateKey<String, PersistentSpannable> {
        final /* synthetic */ LifeEventAttachmentDescriptionPartDefinition f20613a;
        private final FeedProps<GraphQLStory> f20614b;
        private final boolean f20615c;
        private final String f20616d;

        public PersistentSpannableKey(LifeEventAttachmentDescriptionPartDefinition lifeEventAttachmentDescriptionPartDefinition, FeedProps<GraphQLStory> feedProps, boolean z) {
            this.f20613a = lifeEventAttachmentDescriptionPartDefinition;
            this.f20614b = feedProps;
            this.f20615c = z;
            GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
            this.f20616d = "attachment:text" + AttachmentTextPersistentStateId.m23585a(graphQLStory) + graphQLStory.T_() + "description" + z;
        }

        public final Object m23654a() {
            return new PersistentSpannable(new SpannableStringBuilder(m23653a(this.f20614b, this.f20615c)), false);
        }

        public final Object m23655b() {
            return this.f20616d;
        }

        private CharSequence m23653a(FeedProps<GraphQLStory> feedProps, boolean z) {
            try {
                return this.f20613a.f20623e.a(feedProps, z);
            } catch (IndexOutOfBoundsException e) {
                this.f20613a.f20624f.a(LifeEventAttachmentDescriptionPartDefinition.f20618b.getName(), "Corrupt data. Can't linkify description");
                return StoryHierarchyHelper.b((GraphQLStory) feedProps.a()).a();
            }
        }
    }

    private static LifeEventAttachmentDescriptionPartDefinition m23657b(InjectorLike injectorLike) {
        return new LifeEventAttachmentDescriptionPartDefinition((Context) injectorLike.getInstance(Context.class), BackgroundPartDefinition.a(injectorLike), IdBasedLazy.a(injectorLike, 1818), DefaultFeedUnitRenderer.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), SpannableInTextViewPartDefinition.a(injectorLike));
    }

    public final Object m23659a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        HasPositionInformation hasPositionInformation = (HasPositionInformation) anyEnvironment;
        int i = 1;
        GraphQLTextWithEntities n = ((GraphQLStoryAttachment) feedProps.a).n();
        subParts.a(this.f20625g, new LifeEventAttachmentDescriptionTextPersistentSpannableInput(this, AttachmentProps.e(feedProps).b(GraphQLStoryMutator.a(AttachmentProps.c(feedProps)).a(n).a), ((HasFeedListType) hasPositionInformation).c().a() != FeedListName.PERMALINK));
        BackgroundPartDefinition backgroundPartDefinition = this.f20622d;
        FeedProps e = AttachmentProps.e(feedProps);
        Builder g = Builder.g();
        g.b = 4.0f;
        g = g;
        g.c = 8.0f;
        subParts.a(backgroundPartDefinition, new StylingData(e, g.i()));
        subParts.a((SinglePartDefinition) this.f20626h.get(), feedProps.b);
        if (n.a().length() >= 100) {
            i = 3;
        }
        return Integer.valueOf(i);
    }

    public final /* bridge */ /* synthetic */ void m23660a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 224263048);
        Integer num = (Integer) obj2;
        ContentTextView contentTextView = (ContentTextView) view;
        contentTextView.setIncludeFontPadding(false);
        contentTextView.setTextSize((float) SizeUtil.c(this.f20621c.getResources(), 2131427402));
        contentTextView.setTextColor(-16777216);
        contentTextView.setGravity(num.intValue());
        Logger.a(8, EntryType.MARK_POP, -86473728, a);
    }

    public final boolean m23661a(Object obj) {
        GraphQLTextWithEntities n = ((GraphQLStoryAttachment) ((FeedProps) obj).a).n();
        return (n == null || Strings.isNullOrEmpty(n.a())) ? false : true;
    }

    public static LifeEventAttachmentDescriptionPartDefinition m23656a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LifeEventAttachmentDescriptionPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20620j) {
                LifeEventAttachmentDescriptionPartDefinition lifeEventAttachmentDescriptionPartDefinition;
                if (a2 != null) {
                    lifeEventAttachmentDescriptionPartDefinition = (LifeEventAttachmentDescriptionPartDefinition) a2.a(f20620j);
                } else {
                    lifeEventAttachmentDescriptionPartDefinition = f20619i;
                }
                if (lifeEventAttachmentDescriptionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23657b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20620j, b3);
                        } else {
                            f20619i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = lifeEventAttachmentDescriptionPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public LifeEventAttachmentDescriptionPartDefinition(Context context, BackgroundPartDefinition backgroundPartDefinition, Lazy<TextLinkPartDefinition> lazy, DefaultFeedUnitRenderer defaultFeedUnitRenderer, FbErrorReporter fbErrorReporter, SpannableInTextViewPartDefinition spannableInTextViewPartDefinition) {
        this.f20621c = context;
        this.f20622d = backgroundPartDefinition;
        this.f20623e = defaultFeedUnitRenderer;
        this.f20624f = fbErrorReporter;
        this.f20625g = spannableInTextViewPartDefinition;
        this.f20626h = lazy;
    }

    public final ViewType m23658a() {
        return f20617a;
    }
}
