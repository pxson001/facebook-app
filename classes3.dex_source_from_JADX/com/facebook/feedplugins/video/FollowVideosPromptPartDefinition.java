package com.facebook.feedplugins.video;

import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.HasFeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.HasFeedUnit;
import com.facebook.graphql.model.StoryActorHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.multirow.parts.VisibilityPartDefinition;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.resources.ui.FbTextView;
import com.facebook.video.channelfeed.protocol.VideoChannelMutationsHelper;
import com.facebook.video.followvideos.qe.FollowVideosButtonTextHelper;
import com.facebook.video.videohome.abtest.ExperimentsForVideoHomeAbTestModule;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: button */
public class FollowVideosPromptPartDefinition<E extends HasPositionInformation & HasContext> extends MultiRowSinglePartDefinition<Props, Void, E, CustomLinearLayout> {
    public static final ViewType<CustomLinearLayout> f254a = new C00081();
    private static FollowVideosPromptPartDefinition f255l;
    private static final Object f256m = new Object();
    private final BackgroundPartDefinition f257b;
    private final ClickListenerPartDefinition f258c;
    private final TextPartDefinition f259d;
    private final VisibilityPartDefinition f260e;
    private final VideoChannelMutationsHelper f261f;
    private final QeAccessor f262g;
    private final boolean f263h = this.f262g.a(ExperimentsForVideoHomeAbTestModule.p, false);
    private final GatekeeperStoreImpl f264i;
    private final boolean f265j;
    private final FollowVideoHomeButtonVisibilityUtil f266k;

    /* compiled from: button */
    final class C00081 extends ViewType<CustomLinearLayout> {
        C00081() {
        }

        public final View m242a(Context context) {
            CustomLinearLayout customLinearLayout = (CustomLinearLayout) LayoutInflater.from(context).inflate(2130904398, null);
            FbTextView fbTextView = (FbTextView) customLinearLayout.findViewById(2131562113);
            FbTextView fbTextView2 = (FbTextView) customLinearLayout.findViewById(2131562114);
            Drawable drawable = context.getResources().getDrawable(2130839774);
            Drawable drawable2 = context.getResources().getDrawable(2130840030);
            ColorFilter porterDuffColorFilter = new PorterDuffColorFilter(context.getResources().getColor(2131362109), Mode.DST);
            drawable.setColorFilter(porterDuffColorFilter);
            drawable2.setColorFilter(porterDuffColorFilter);
            fbTextView.setCompoundDrawablesWithIntrinsicBounds(drawable2, null, null, null);
            fbTextView2.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
            return customLinearLayout;
        }
    }

    /* compiled from: button */
    public class Props implements HasFeedProps<FeedUnit>, HasFeedUnit {
        public final FollowVideosState f271a;
        public final FeedProps<GraphQLStoryAttachment> f272b;

        public Props(FeedProps<GraphQLStoryAttachment> feedProps, FollowVideosState followVideosState) {
            this.f271a = followVideosState;
            this.f272b = feedProps;
        }

        public final FeedUnit m251c() {
            Flattenable c = this.f272b.c();
            return c instanceof FeedUnit ? (FeedUnit) c : null;
        }

        @Nullable
        public final FeedProps<FeedUnit> m252f() {
            return this.f272b.c() instanceof FeedUnit ? this.f272b.b : null;
        }
    }

    private static FollowVideosPromptPartDefinition m238b(InjectorLike injectorLike) {
        return new FollowVideosPromptPartDefinition(BackgroundPartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), VisibilityPartDefinition.a(injectorLike), VideoChannelMutationsHelper.m244a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), FollowVideoHomeButtonVisibilityUtil.m170a(injectorLike));
    }

    public static FollowVideosPromptPartDefinition m237a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FollowVideosPromptPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f256m) {
                FollowVideosPromptPartDefinition followVideosPromptPartDefinition;
                if (a2 != null) {
                    followVideosPromptPartDefinition = (FollowVideosPromptPartDefinition) a2.a(f256m);
                } else {
                    followVideosPromptPartDefinition = f255l;
                }
                if (followVideosPromptPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m238b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f256m, b3);
                        } else {
                            f255l = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = followVideosPromptPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final Object m240a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        HasPositionInformation hasPositionInformation = (HasPositionInformation) anyEnvironment;
        int i = 0;
        FeedProps e = AttachmentProps.e(props.f272b);
        Preconditions.checkNotNull(e);
        subParts.a(this.f257b, new StylingData(e, PaddingStyle.a, 2131362097, 2131362097));
        String aa = StoryActorHelper.b((GraphQLStory) e.a).aa();
        GraphQLMedia r = ((GraphQLStoryAttachment) props.f272b.a()).r();
        boolean aB = r.aF().aB();
        subParts.a(2131562112, this.f258c, new ButtonClickHandler(r.b(), r.aF().H(), !aB, this.f261f, props.f271a));
        subParts.a(2131562111, this.f259d, ((HasContext) hasPositionInformation).getContext().getResources().getString(2131235664, new Object[]{aa}));
        subParts.a(2131562113, this.f259d, FollowVideosButtonTextHelper.a(this.f262g, ((HasContext) hasPositionInformation).getContext()));
        subParts.a(2131562114, this.f259d, FollowVideosButtonTextHelper.b(this.f262g, ((HasContext) hasPositionInformation).getContext()));
        subParts.a(2131562113, this.f260e, Integer.valueOf(aB ? 4 : 0));
        if (!aB) {
            i = 4;
        }
        subParts.a(2131562114, this.f260e, Integer.valueOf(i));
        return null;
    }

    public final boolean m241a(Object obj) {
        Props props = (Props) obj;
        return FollowVideoHomeButtonVisibilityUtil.m171a(this.f263h, this.f265j, props.f272b, props.f271a);
    }

    @Inject
    public FollowVideosPromptPartDefinition(BackgroundPartDefinition backgroundPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, TextPartDefinition textPartDefinition, VisibilityPartDefinition visibilityPartDefinition, VideoChannelMutationsHelper videoChannelMutationsHelper, QeAccessor qeAccessor, GatekeeperStoreImpl gatekeeperStoreImpl, FollowVideoHomeButtonVisibilityUtil followVideoHomeButtonVisibilityUtil) {
        this.f257b = backgroundPartDefinition;
        this.f258c = clickListenerPartDefinition;
        this.f259d = textPartDefinition;
        this.f260e = visibilityPartDefinition;
        this.f262g = qeAccessor;
        this.f261f = videoChannelMutationsHelper;
        this.f264i = gatekeeperStoreImpl;
        this.f265j = this.f264i.a(482, false);
        this.f266k = followVideoHomeButtonVisibilityUtil;
    }

    public final ViewType<CustomLinearLayout> m239a() {
        return f254a;
    }
}
