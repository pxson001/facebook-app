package com.facebook.feedplugins.attachments.linkshare.follow;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.graphql.linkutil.GraphQLLinkExtractor;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLEntityAtRange;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.FbDraweePartDefinition;
import com.facebook.multirow.parts.FbDraweePartDefinition.Props.Builder;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.resources.ui.FbButton;
import com.facebook.timeline.intent.ModelBundle;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: TODAY */
public class BaseFollowShareAttachmentPartDefinition<E extends FeedEnvironment> extends BaseSinglePartDefinition<GraphQLStoryAttachment, Void, E, FollowShareAttachmentView> {
    private static final CallerContext f22578a = CallerContext.a(BaseFollowShareAttachmentPartDefinition.class, "native_newsfeed");
    private static BaseFollowShareAttachmentPartDefinition f22579h;
    private static final Object f22580i = new Object();
    private final TextPartDefinition f22581b;
    private final FbDraweePartDefinition<E> f22582c;
    private final ClickListenerPartDefinition f22583d;
    public final Context f22584e;
    public final GraphQLLinkExtractor f22585f;
    public final Provider<IFeedIntentBuilder> f22586g;

    /* compiled from: TODAY */
    public enum FollowShareButtonState {
        FOLLOW_USER(2131235688, 0),
        FOLLOWING_USER(2131235689, 0),
        LIKE_PAGE(2131235690, 0),
        LIKED_PAGE(2131235691, 0),
        CANNOT_SUBSCRIBE(2131235688, 4);
        
        private int mText;
        private int mVisibility;

        private FollowShareButtonState(int i, int i2) {
            this.mText = i;
            this.mVisibility = i2;
        }

        public final FbButton setState(FbButton fbButton) {
            fbButton.setText(this.mText);
            fbButton.setVisibility(this.mVisibility);
            return fbButton;
        }
    }

    private static BaseFollowShareAttachmentPartDefinition m25265b(InjectorLike injectorLike) {
        return new BaseFollowShareAttachmentPartDefinition((Context) injectorLike.getInstance(Context.class), TextPartDefinition.a(injectorLike), FbDraweePartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), GraphQLLinkExtractor.a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 2347));
    }

    public final Object m25266a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) obj;
        GraphQLStoryActionLink a = ActionLinkHelper.a(graphQLStoryAttachment);
        StyleSpan styleSpan = new StyleSpan(1);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(a.Y().a());
        if (a.Y().b() != null) {
            spannableStringBuilder.setSpan(styleSpan, ((GraphQLEntityAtRange) a.Y().b().get(0)).c(), spannableStringBuilder.length(), 33);
        }
        subParts.a(2131562109, this.f22581b, spannableStringBuilder);
        FbDraweePartDefinition fbDraweePartDefinition = this.f22582c;
        Builder a2 = FbDraweePartDefinition.a().a(a.ah().ai().b());
        a2.c = f22578a;
        subParts.a(2131562108, fbDraweePartDefinition, a2.a());
        subParts.a(2131562109, this.f22583d, m25263a(graphQLStoryAttachment));
        subParts.a(2131562108, this.f22583d, m25263a(graphQLStoryAttachment));
        return null;
    }

    public static BaseFollowShareAttachmentPartDefinition m25264a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BaseFollowShareAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22580i) {
                BaseFollowShareAttachmentPartDefinition baseFollowShareAttachmentPartDefinition;
                if (a2 != null) {
                    baseFollowShareAttachmentPartDefinition = (BaseFollowShareAttachmentPartDefinition) a2.a(f22580i);
                } else {
                    baseFollowShareAttachmentPartDefinition = f22579h;
                }
                if (baseFollowShareAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25265b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22580i, b3);
                        } else {
                            f22579h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = baseFollowShareAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public BaseFollowShareAttachmentPartDefinition(Context context, TextPartDefinition textPartDefinition, FbDraweePartDefinition fbDraweePartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, GraphQLLinkExtractor graphQLLinkExtractor, Provider<IFeedIntentBuilder> provider) {
        this.f22584e = context;
        this.f22581b = textPartDefinition;
        this.f22582c = fbDraweePartDefinition;
        this.f22583d = clickListenerPartDefinition;
        this.f22585f = graphQLLinkExtractor;
        this.f22586g = provider;
    }

    private OnClickListener m25263a(final GraphQLStoryAttachment graphQLStoryAttachment) {
        return new OnClickListener(this) {
            final /* synthetic */ BaseFollowShareAttachmentPartDefinition f22577b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 881580681);
                GraphQLProfile ah = ActionLinkHelper.a(graphQLStoryAttachment).ah();
                int g = ah.j().g();
                GraphQLLinkExtractor graphQLLinkExtractor = this.f22577b.f22585f;
                String a2 = GraphQLLinkExtractor.a(g, new Object[]{ah.b()});
                Bundle bundle = new Bundle();
                ModelBundle.a(bundle, g, ah.b(), ah.ai() != null ? ah.ai().b() : null, ah.U());
                ((IFeedIntentBuilder) this.f22577b.f22586g.get()).a(this.f22577b.f22584e, a2, bundle, null);
                LogUtils.a(1100103738, a);
            }
        };
    }
}
