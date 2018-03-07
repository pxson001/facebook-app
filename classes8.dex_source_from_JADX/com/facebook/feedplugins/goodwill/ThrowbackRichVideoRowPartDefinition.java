package com.facebook.feedplugins.goodwill;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.CanShowVideoInFullScreen;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.TextOrHiddenPartDefinition;
import com.facebook.multirow.parts.VisibilityPartDefinition;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: goodfriends_picker_deselect */
public class ThrowbackRichVideoRowPartDefinition<E extends CanShowVideoInFullScreen & HasPositionInformation & HasFeedListType & HasPersistentState & HasInvalidate & HasPrefetcher> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, RelativeLayout> {
    public static final ViewType f12523a = ViewType.a(2130904622);
    private static ThrowbackRichVideoRowPartDefinition f12524f;
    private static final Object f12525g = new Object();
    private final Context f12526b;
    private final TextOrHiddenPartDefinition f12527c;
    private final VisibilityPartDefinition f12528d;
    private final RichVideoWithBackgroundOverridePartDefinition f12529e;

    private static ThrowbackRichVideoRowPartDefinition m14406b(InjectorLike injectorLike) {
        return new ThrowbackRichVideoRowPartDefinition((Context) injectorLike.getInstance(Context.class), TextOrHiddenPartDefinition.a(injectorLike), VisibilityPartDefinition.a(injectorLike), RichVideoWithBackgroundOverridePartDefinition.m14271a(injectorLike));
    }

    public final Object m14408a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(2131562602, this.f12529e, feedProps);
        GraphQLStory a = AttachmentProps.a(feedProps);
        Object a2 = a != null ? m14405a(a.aw()) : null;
        subParts.a(2131562590, this.f12528d, Integer.valueOf(a2 == null ? 8 : 0));
        subParts.a(2131558412, this.f12527c, a2);
        return null;
    }

    @Inject
    public ThrowbackRichVideoRowPartDefinition(Context context, TextOrHiddenPartDefinition textOrHiddenPartDefinition, VisibilityPartDefinition visibilityPartDefinition, RichVideoWithBackgroundOverridePartDefinition richVideoWithBackgroundOverridePartDefinition) {
        this.f12526b = context;
        this.f12529e = richVideoWithBackgroundOverridePartDefinition;
        this.f12527c = textOrHiddenPartDefinition;
        this.f12528d = visibilityPartDefinition;
    }

    public static ThrowbackRichVideoRowPartDefinition m14404a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackRichVideoRowPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12525g) {
                ThrowbackRichVideoRowPartDefinition throwbackRichVideoRowPartDefinition;
                if (a2 != null) {
                    throwbackRichVideoRowPartDefinition = (ThrowbackRichVideoRowPartDefinition) a2.a(f12525g);
                } else {
                    throwbackRichVideoRowPartDefinition = f12524f;
                }
                if (throwbackRichVideoRowPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14406b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12525g, b3);
                        } else {
                            f12524f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackRichVideoRowPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m14409a(FeedProps<GraphQLStoryAttachment> feedProps) {
        return this.f12529e.m14275a((FeedProps) feedProps);
    }

    public final ViewType m14407a() {
        return f12523a;
    }

    @Nullable
    private String m14405a(GraphQLTextWithEntities graphQLTextWithEntities) {
        String str = null;
        if (!(graphQLTextWithEntities == null || TextUtils.isEmpty(graphQLTextWithEntities.a()))) {
            try {
                int parseInt = Integer.parseInt(graphQLTextWithEntities.a());
                str = this.f12526b.getResources().getQuantityString(2131689730, parseInt, new Object[]{Integer.valueOf(parseInt)});
            } catch (NumberFormatException e) {
            }
        }
        return str;
    }
}
