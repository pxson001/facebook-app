package com.facebook.feedplugins.groupcommerce;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.permalink.PermalinkFeedListType;
import com.facebook.feed.renderer.DefaultFeedUnitRenderer;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.text.StoryContentPersistentStateId;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.EdgeToEdgePaddingStyleConfig;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyleConfig;
import com.facebook.feed.rows.styling.PaddingStyleConfigMethodAutoProvider;
import com.facebook.feed.rows.views.ContentTextView;
import com.facebook.feed.spannable.PersistentSpannable;
import com.facebook.feedplugins.spannable.PersistentSpannableWithoutLayoutInput;
import com.facebook.feedplugins.spannable.SpannableInTextViewPartDefinition;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStory.Builder;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: geocode_address */
public class GroupCommerceItemAttachmentDescriptionPartDefinition<E extends HasPositionInformation & HasFeedListType & HasPersistentState> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, ContentTextView> {
    public static final ViewType f12710a = new C13241();
    public static final Class f12711b = GroupCommerceItemAttachmentDescriptionPartDefinition.class;
    private static GroupCommerceItemAttachmentDescriptionPartDefinition f12712h;
    private static final Object f12713i = new Object();
    private final BackgroundPartDefinition f12714c;
    private final SpannableInTextViewPartDefinition f12715d;
    public final Provider<DefaultFeedUnitRenderer> f12716e;
    public final AbstractFbErrorReporter f12717f;
    private final EdgeToEdgePaddingStyleConfig f12718g;

    /* compiled from: geocode_address */
    final class C13241 extends ViewType {
        C13241() {
        }

        public final View m14508a(Context context) {
            ContentTextView contentTextView = new ContentTextView(context);
            contentTextView.setTextColor(context.getResources().getColor(2131362048));
            return contentTextView;
        }
    }

    /* compiled from: geocode_address */
    class GroupCommerceTextPersistentSpannableInput extends PersistentSpannableWithoutLayoutInput {
        final /* synthetic */ GroupCommerceItemAttachmentDescriptionPartDefinition f12702a;
        private final GraphQLTextWithEntities f12703b;
        private final FeedProps<GraphQLStory> f12704c;
        private final ContextStateKey<String, PersistentSpannable> f12705d;

        public GroupCommerceTextPersistentSpannableInput(GroupCommerceItemAttachmentDescriptionPartDefinition groupCommerceItemAttachmentDescriptionPartDefinition, FeedProps<GraphQLStory> feedProps, boolean z) {
            this.f12702a = groupCommerceItemAttachmentDescriptionPartDefinition;
            this.f12703b = ((GraphQLStory) feedProps.a).aE();
            this.f12704c = feedProps;
            this.f12705d = new PersistentSpannableKey(groupCommerceItemAttachmentDescriptionPartDefinition, feedProps, z);
        }

        public final ContextStateKey<String, PersistentSpannable> m14510a() {
            return this.f12705d;
        }

        public final GraphQLTextWithEntities m14511b() {
            return this.f12703b;
        }

        public final CacheableEntity m14512c() {
            return (CacheableEntity) this.f12704c.a;
        }

        public final int m14509a(Spannable spannable) {
            if (this.f12703b == null || this.f12703b.d() == null || this.f12703b.d().isEmpty()) {
                return 0;
            }
            return spannable.length() - this.f12703b.a().length();
        }
    }

    /* compiled from: geocode_address */
    class PersistentSpannableKey implements ContextStateKey<String, PersistentSpannable> {
        final /* synthetic */ GroupCommerceItemAttachmentDescriptionPartDefinition f12706a;
        private final FeedProps<GraphQLStory> f12707b;
        private final boolean f12708c;
        private final String f12709d;

        public PersistentSpannableKey(GroupCommerceItemAttachmentDescriptionPartDefinition groupCommerceItemAttachmentDescriptionPartDefinition, FeedProps<GraphQLStory> feedProps, boolean z) {
            this.f12706a = groupCommerceItemAttachmentDescriptionPartDefinition;
            this.f12707b = feedProps;
            this.f12708c = z;
            this.f12709d = StoryContentPersistentStateId.a((GraphQLStory) feedProps.a, z);
        }

        public final Object m14513a() {
            CharSequence a;
            try {
                a = ((DefaultFeedUnitRenderer) this.f12706a.f12716e.get()).a(this.f12707b, this.f12708c);
            } catch (IndexOutOfBoundsException e) {
                this.f12706a.f12717f.a(GroupCommerceItemAttachmentDescriptionPartDefinition.f12711b.getName(), "Corrupt data. Can't linkify description");
                a = StoryHierarchyHelper.b((GraphQLStory) this.f12707b.a()).a();
            }
            return new PersistentSpannable(new SpannableStringBuilder(a), false);
        }

        public final Object m14514b() {
            return this.f12709d;
        }
    }

    private static GroupCommerceItemAttachmentDescriptionPartDefinition m14516b(InjectorLike injectorLike) {
        return new GroupCommerceItemAttachmentDescriptionPartDefinition(BackgroundPartDefinition.a(injectorLike), SpannableInTextViewPartDefinition.a(injectorLike), IdBasedProvider.a(injectorLike, 1473), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), PaddingStyleConfigMethodAutoProvider.b(injectorLike));
    }

    public final Object m14518a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        HasPositionInformation hasPositionInformation = (HasPositionInformation) anyEnvironment;
        GraphQLNode z = ((GraphQLStoryAttachment) feedProps.a).z();
        FeedListType c = ((HasFeedListType) hasPositionInformation).c();
        GraphQLTextWithEntities db = z.db();
        FeedProps e = AttachmentProps.e(feedProps);
        boolean z2 = !(c instanceof PermalinkFeedListType);
        Builder a = Builder.a((GraphQLStory) e.a);
        a.X = db;
        subParts.a(this.f12715d, new GroupCommerceTextPersistentSpannableInput(this, e.b(a.a()), z2));
        BackgroundPartDefinition backgroundPartDefinition = this.f12714c;
        PaddingStyle.Builder g = PaddingStyle.Builder.g();
        g.b = 8.0f;
        g = g;
        EdgeToEdgePaddingStyleConfig edgeToEdgePaddingStyleConfig = this.f12718g;
        g.c = 6.0f;
        subParts.a(backgroundPartDefinition, new StylingData(e, g.i()));
        return null;
    }

    public final boolean m14519a(Object obj) {
        GraphQLTextWithEntities db = ((GraphQLStoryAttachment) ((FeedProps) obj).a).z().db();
        return (db == null || db.a() == null || db.a().isEmpty()) ? false : true;
    }

    public static GroupCommerceItemAttachmentDescriptionPartDefinition m14515a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GroupCommerceItemAttachmentDescriptionPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12713i) {
                GroupCommerceItemAttachmentDescriptionPartDefinition groupCommerceItemAttachmentDescriptionPartDefinition;
                if (a2 != null) {
                    groupCommerceItemAttachmentDescriptionPartDefinition = (GroupCommerceItemAttachmentDescriptionPartDefinition) a2.a(f12713i);
                } else {
                    groupCommerceItemAttachmentDescriptionPartDefinition = f12712h;
                }
                if (groupCommerceItemAttachmentDescriptionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14516b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12713i, b3);
                        } else {
                            f12712h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = groupCommerceItemAttachmentDescriptionPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public GroupCommerceItemAttachmentDescriptionPartDefinition(BackgroundPartDefinition backgroundPartDefinition, SpannableInTextViewPartDefinition spannableInTextViewPartDefinition, Provider<DefaultFeedUnitRenderer> provider, FbErrorReporter fbErrorReporter, PaddingStyleConfig paddingStyleConfig) {
        this.f12714c = backgroundPartDefinition;
        this.f12715d = spannableInTextViewPartDefinition;
        this.f12716e = provider;
        this.f12717f = fbErrorReporter;
        this.f12718g = paddingStyleConfig;
    }

    public final ViewType m14517a() {
        return f12710a;
    }
}
