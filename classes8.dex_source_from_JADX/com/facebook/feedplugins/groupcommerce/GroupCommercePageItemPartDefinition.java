package com.facebook.feedplugins.groupcommerce;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.feed.environment.CanFeedback;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.AttachmentLinkPartDefinition;
import com.facebook.feed.rows.sections.header.HeaderSubtitlePartDefinition;
import com.facebook.feed.rows.sections.header.HeaderTitleWithLayoutPartDefinition;
import com.facebook.feed.rows.sections.header.ProfilePhotoPartDefinition;
import com.facebook.feed.rows.sections.header.StoryHeaderUtil;
import com.facebook.feed.rows.util.DraweeControllerPartDefinition;
import com.facebook.feed.rows.util.DraweeControllerPartDefinition.Callbacks;
import com.facebook.feedplugins.base.blingbar.BlingBarPartDefinition;
import com.facebook.feedplugins.base.blingbar.ui.ConstantHeightBlingBarView;
import com.facebook.graphql.enums.GraphQLGroupCommercePriceType;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.StoryCommerceHelper;
import com.facebook.groupcommerce.util.GroupCommercePriceFormatter;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinitionWithViewType;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: friendversary_video_ipb */
public class GroupCommercePageItemPartDefinition<E extends CanFeedback & HasInvalidate & HasPositionInformation & HasPersistentState & HasPrefetcher & HasRowKey & HasMenuButtonProvider & HasContext> extends BaseSinglePartDefinitionWithViewType<Props, State, E, GroupCommerceHScrollItemView> {
    public static final ViewType<GroupCommerceHScrollItemView> f12764a = new C13291();
    public static final CallerContext f12765b = CallerContext.a(GroupCommercePageItemPartDefinition.class, "native_newsfeed");
    private static GroupCommercePageItemPartDefinition f12766p;
    private static final Object f12767q = new Object();
    private final ProfilePhotoPartDefinition<E> f12768c;
    private final HeaderTitleWithLayoutPartDefinition<E> f12769d;
    private final HeaderSubtitlePartDefinition f12770e;
    private final AttachmentLinkPartDefinition f12771f;
    private final BlingBarPartDefinition<ConstantHeightBlingBarView, E> f12772g;
    private final GroupCommercePageFooterPartDefinition<E> f12773h;
    public final Context f12774i;
    private final DraweeControllerPartDefinition<GroupCommerceHScrollItemView> f12775j;
    private final GroupCommercePriceFormatter f12776k;
    private final StoryHeaderUtil f12777l;
    public final FbDraweeControllerBuilder f12778m;
    public final int f12779n = this.f12774i.getResources().getColor(2131362048);
    private final int f12780o = this.f12774i.getResources().getColor(2131361974);

    /* compiled from: friendversary_video_ipb */
    final class C13291 extends ViewType<GroupCommerceHScrollItemView> {
        C13291() {
        }

        public final View m14557a(Context context) {
            return new GroupCommerceHScrollItemView(context);
        }
    }

    /* compiled from: friendversary_video_ipb */
    public class Props {
        public final FeedProps<GraphQLStory> f12760a;
        public final int f12761b;
    }

    /* compiled from: friendversary_video_ipb */
    public class State {
        public final SpannableStringBuilder f12762a;
        public final String f12763b;

        public State(SpannableStringBuilder spannableStringBuilder, String str) {
            this.f12762a = spannableStringBuilder;
            this.f12763b = str;
        }
    }

    private static GroupCommercePageItemPartDefinition m14563b(InjectorLike injectorLike) {
        return new GroupCommercePageItemPartDefinition(ProfilePhotoPartDefinition.a(injectorLike), HeaderTitleWithLayoutPartDefinition.a(injectorLike), HeaderSubtitlePartDefinition.a(injectorLike), AttachmentLinkPartDefinition.a(injectorLike), BlingBarPartDefinition.a(injectorLike), GroupCommercePageFooterPartDefinition.m14554a(injectorLike), (Context) injectorLike.getInstance(Context.class), DraweeControllerPartDefinition.a(injectorLike), GroupCommercePriceFormatter.a(injectorLike), StoryHeaderUtil.a(injectorLike), FbDraweeControllerBuilder.b(injectorLike));
    }

    public final Object m14566a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        String str;
        Props props = (Props) obj;
        final GraphQLStory graphQLStory = (GraphQLStory) props.f12760a.a;
        subParts.a(2131562765, this.f12769d, new com.facebook.feed.rows.sections.header.HeaderTitleWithLayoutPartDefinition.Props(props.f12760a, false, -1));
        int c = this.f12777l.c(props.f12760a);
        subParts.a(2131562764, this.f12768c, new com.facebook.feed.rows.sections.header.ProfilePhotoPartDefinition.Props(props.f12760a, this.f12777l.b(props.f12760a), c));
        subParts.a(2131562766, this.f12770e, props.f12760a);
        subParts.a(2131562638, this.f12772g, new com.facebook.feedplugins.base.blingbar.BlingBarPartDefinition.Props(props.f12760a, true));
        subParts.a(2131562639, this.f12773h, props.f12760a);
        subParts.a(this.f12771f, new com.facebook.feed.rows.sections.attachments.AttachmentLinkPartDefinition.Props(props.f12760a.a(StoryCommerceHelper.a(graphQLStory))));
        subParts.a(this.f12775j, new com.facebook.feed.rows.util.DraweeControllerPartDefinition.Props(f12765b, new Callbacks<GroupCommerceHScrollItemView>(this) {
            final /* synthetic */ GroupCommercePageItemPartDefinition f12759b;

            public final void m14559a(View view, @Nullable DraweeController draweeController) {
                ((GroupCommerceHScrollItemView) view).f.setController(((FbDraweeControllerBuilder) this.f12759b.f12778m.a(GroupCommercePageItemPartDefinition.f12765b).b(draweeController)).r().s());
            }

            public final ImageRequest m14558a() {
                return ImageRequest.a(ImageUtil.a(StoryAttachmentHelper.q(graphQLStory)));
            }
        }, false, false));
        GraphQLStoryAttachment a = StoryCommerceHelper.a(graphQLStory);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        GraphQLNode z = a.z();
        String A = a.A();
        m14562a(spannableStringBuilder, m14561a(z), new ForegroundColorSpan(this.f12779n));
        GraphQLTextWithEntities fs = z.fs();
        if (fs == null || StringUtil.a(fs.a())) {
            str = null;
        } else {
            str = fs.a();
        }
        String str2 = str;
        if (str2 != null) {
            m14564b(spannableStringBuilder, str2);
        }
        return new State(spannableStringBuilder, A);
    }

    public final /* bridge */ /* synthetic */ void m14567a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 63359471);
        State state = (State) obj2;
        GroupCommerceHScrollItemView groupCommerceHScrollItemView = (GroupCommerceHScrollItemView) view;
        LayoutParams layoutParams = (LayoutParams) groupCommerceHScrollItemView.b.getLayoutParams();
        layoutParams.width = ((Props) obj).f12761b;
        groupCommerceHScrollItemView.b.setLayoutParams(layoutParams);
        groupCommerceHScrollItemView.b.requestLayout();
        groupCommerceHScrollItemView.d.setText(state.f12763b);
        groupCommerceHScrollItemView.e.setText(state.f12762a);
        Logger.a(8, EntryType.MARK_POP, -1856598323, a);
    }

    public static GroupCommercePageItemPartDefinition m14560a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GroupCommercePageItemPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12767q) {
                GroupCommercePageItemPartDefinition groupCommercePageItemPartDefinition;
                if (a2 != null) {
                    groupCommercePageItemPartDefinition = (GroupCommercePageItemPartDefinition) a2.a(f12767q);
                } else {
                    groupCommercePageItemPartDefinition = f12766p;
                }
                if (groupCommercePageItemPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14563b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12767q, b3);
                        } else {
                            f12766p = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = groupCommercePageItemPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public GroupCommercePageItemPartDefinition(ProfilePhotoPartDefinition profilePhotoPartDefinition, HeaderTitleWithLayoutPartDefinition headerTitleWithLayoutPartDefinition, HeaderSubtitlePartDefinition headerSubtitlePartDefinition, AttachmentLinkPartDefinition attachmentLinkPartDefinition, BlingBarPartDefinition blingBarPartDefinition, GroupCommercePageFooterPartDefinition groupCommercePageFooterPartDefinition, Context context, DraweeControllerPartDefinition draweeControllerPartDefinition, GroupCommercePriceFormatter groupCommercePriceFormatter, StoryHeaderUtil storyHeaderUtil, FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        this.f12768c = profilePhotoPartDefinition;
        this.f12769d = headerTitleWithLayoutPartDefinition;
        this.f12770e = headerSubtitlePartDefinition;
        this.f12771f = attachmentLinkPartDefinition;
        this.f12772g = blingBarPartDefinition;
        this.f12773h = groupCommercePageFooterPartDefinition;
        this.f12774i = context;
        this.f12775j = draweeControllerPartDefinition;
        this.f12776k = groupCommercePriceFormatter;
        this.f12777l = storyHeaderUtil;
        this.f12778m = fbDraweeControllerBuilder;
    }

    public final ViewType<GroupCommerceHScrollItemView> m14565a() {
        return f12764a;
    }

    private String m14561a(GraphQLNode graphQLNode) {
        return this.f12776k.a(graphQLNode.ec(), graphQLNode.fW() == GraphQLGroupCommercePriceType.NEGOTIABLE);
    }

    private void m14564b(SpannableStringBuilder spannableStringBuilder, String str) {
        CharSequence string = this.f12774i.getResources().getString(2131237867);
        m14562a(spannableStringBuilder, (CharSequence) " ", new ForegroundColorSpan(this.f12780o));
        m14562a(spannableStringBuilder, string, new ForegroundColorSpan(this.f12780o));
        m14562a(spannableStringBuilder, (CharSequence) " ", new ForegroundColorSpan(this.f12780o));
        Drawable drawable = this.f12774i.getResources().getDrawable(2130842660);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        m14562a(spannableStringBuilder, (CharSequence) " ", (Object) new ImageSpan(drawable, 1));
        m14562a(spannableStringBuilder, (CharSequence) str, new ForegroundColorSpan(this.f12780o));
    }

    public static void m14562a(SpannableStringBuilder spannableStringBuilder, CharSequence charSequence, Object obj) {
        int length = spannableStringBuilder.length();
        int length2 = charSequence.length() + length;
        spannableStringBuilder.append(charSequence);
        spannableStringBuilder.setSpan(obj, length, length2, 33);
    }
}
