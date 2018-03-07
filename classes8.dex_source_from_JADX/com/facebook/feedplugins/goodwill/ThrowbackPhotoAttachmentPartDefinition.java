package com.facebook.feedplugins.goodwill;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasImageLoadListener;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.PhotoAttachmentPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.BasePaddingStyleResolver;
import com.facebook.feed.rows.styling.DefaultPaddingStyleResolver;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.graphql.model.GraphQLTextWithEntities;
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
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: goodwill_campaign_post_failed */
public class ThrowbackPhotoAttachmentPartDefinition<E extends HasFeedListType & HasImageLoadListener & HasInvalidate & HasPositionInformation & HasPrefetcher> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, State, E, ThrowbackPhotoAttachmentContainerView> {
    public static final PaddingStyle f12454a;
    private static ThrowbackPhotoAttachmentPartDefinition f12455f;
    private static final Object f12456g = new Object();
    public final Context f12457b;
    public final BasePaddingStyleResolver f12458c;
    private final PhotoAttachmentPartDefinition<E> f12459d;
    private final BackgroundPartDefinition f12460e;

    /* compiled from: goodwill_campaign_post_failed */
    public class State {
        public final String f12452a;
        public final int f12453b;

        public State(String str, int i) {
            this.f12452a = str;
            this.f12453b = i;
        }
    }

    private static ThrowbackPhotoAttachmentPartDefinition m14349b(InjectorLike injectorLike) {
        return new ThrowbackPhotoAttachmentPartDefinition(PhotoAttachmentPartDefinition.a(injectorLike), BackgroundPartDefinition.a(injectorLike), (Context) injectorLike.getInstance(Context.class), (BasePaddingStyleResolver) DefaultPaddingStyleResolver.a(injectorLike));
    }

    public final Object m14351a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        int i;
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        subParts.a(this.f12459d, feedProps);
        subParts.a(this.f12460e, new StylingData(AttachmentProps.e(feedProps), f12454a, Position.MIDDLE));
        GraphQLStory a = AttachmentProps.a(feedProps);
        Object obj2 = (GraphQLStoryAttachmentUtil.l(graphQLStoryAttachment) == null || !GraphQLHelper.b(GraphQLStoryAttachmentUtil.l(graphQLStoryAttachment))) ? null : 1;
        if (obj2 != null) {
            i = 0;
        } else {
            i = this.f12458c.a(PaddingStyle.b, AttachmentProps.e(feedProps), (float) this.f12457b.getResources().getDimensionPixelSize(2131427380)) / 2;
        }
        return new State(a != null ? m14348a(a.aw()) : null, i);
    }

    public final /* bridge */ /* synthetic */ void m14352a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -2013683346);
        State state = (State) obj2;
        ThrowbackPhotoAttachmentContainerView throwbackPhotoAttachmentContainerView = (ThrowbackPhotoAttachmentContainerView) view;
        throwbackPhotoAttachmentContainerView.f12450c.setText(state.f12452a);
        CharSequence a2 = StringLocaleUtil.a(throwbackPhotoAttachmentContainerView.getResources().getString(2131239202), new Object[]{r4});
        throwbackPhotoAttachmentContainerView.getPhotoAttachmentView().setContentDescription(a2);
        throwbackPhotoAttachmentContainerView.f12451d.setContentDescription(a2);
        ((LayoutParams) throwbackPhotoAttachmentContainerView.f12451d.getLayoutParams()).setMargins(0, throwbackPhotoAttachmentContainerView.getResources().getDimensionPixelSize(2131432766), throwbackPhotoAttachmentContainerView.getResources().getDimensionPixelSize(2131432766) + state.f12453b, 0);
        Logger.a(8, EntryType.MARK_POP, 1657059566, a);
    }

    public final boolean m14353a(Object obj) {
        return PhotoAttachmentPartDefinition.a((FeedProps) obj);
    }

    static {
        Builder d = Builder.d();
        d.c = 8.0f;
        f12454a = d.i();
    }

    public static ThrowbackPhotoAttachmentPartDefinition m14347a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackPhotoAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12456g) {
                ThrowbackPhotoAttachmentPartDefinition throwbackPhotoAttachmentPartDefinition;
                if (a2 != null) {
                    throwbackPhotoAttachmentPartDefinition = (ThrowbackPhotoAttachmentPartDefinition) a2.a(f12456g);
                } else {
                    throwbackPhotoAttachmentPartDefinition = f12455f;
                }
                if (throwbackPhotoAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14349b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12456g, b3);
                        } else {
                            f12455f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackPhotoAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ThrowbackPhotoAttachmentPartDefinition(PhotoAttachmentPartDefinition photoAttachmentPartDefinition, BackgroundPartDefinition backgroundPartDefinition, Context context, BasePaddingStyleResolver basePaddingStyleResolver) {
        this.f12457b = context;
        this.f12458c = basePaddingStyleResolver;
        this.f12459d = photoAttachmentPartDefinition;
        this.f12460e = backgroundPartDefinition;
    }

    public final ViewType m14350a() {
        return ThrowbackPhotoAttachmentContainerView.f12449b;
    }

    @Nullable
    private String m14348a(GraphQLTextWithEntities graphQLTextWithEntities) {
        String str = null;
        if (!(graphQLTextWithEntities == null || graphQLTextWithEntities.a() == null)) {
            try {
                int parseInt = Integer.parseInt(graphQLTextWithEntities.a());
                str = this.f12457b.getResources().getQuantityString(2131689730, parseInt, new Object[]{Integer.valueOf(parseInt)});
            } catch (NumberFormatException e) {
            }
        }
        return str;
    }
}
