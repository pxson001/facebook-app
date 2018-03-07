package com.facebook.feedplugins.calltoaction;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLEntityAtRange;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.StoryAttachmentHelper;
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
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: help */
public class ActionLinkCallToActionPartDefinition<E extends HasPositionInformation & HasPrefetcher> extends BaseSinglePartDefinition<Props, Void, E, ActionLinkCallToActionView> {
    public static final CallerContext f21111a = CallerContext.m9061a(ActionLinkCallToActionPartDefinition.class, "native_newsfeed");
    private static ActionLinkCallToActionPartDefinition f21112f;
    private static final Object f21113g = new Object();
    private final BackgroundPartDefinition f21114b;
    private final TextPartDefinition f21115c;
    private final ClickListenerPartDefinition f21116d;
    private final ClickListenerPartDefinition f21117e;

    private static ActionLinkCallToActionPartDefinition m28861b(InjectorLike injectorLike) {
        return new ActionLinkCallToActionPartDefinition(BackgroundPartDefinition.m19135a(injectorLike), TextPartDefinition.m19379a(injectorLike), ClickListenerPartDefinition.m19353a(injectorLike), ClickListenerPartDefinition.m19353a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        HasPositionInformation hasPositionInformation = (HasPositionInformation) anyEnvironment;
        if (props.i) {
            subParts.mo2756a(this.f21114b, new StylingData(props.a, props.h, -1, -1));
        }
        subParts.mo2755a(2131559194, this.f21115c, props.g);
        subParts.mo2756a(this.f21116d, props.b);
        subParts.mo2755a(2131559195, this.f21117e, props.c);
        if (props.d != null) {
            ((HasPrefetcher) hasPositionInformation).mo2434a(ImageRequest.m18795a(props.d), f21111a);
        }
        return null;
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1945773140);
        Props props = (Props) obj;
        ActionLinkCallToActionView actionLinkCallToActionView = (ActionLinkCallToActionView) view;
        GraphQLStory graphQLStory = (GraphQLStory) props.a.f13444a;
        if (props.d != null) {
            Uri uri = props.d;
            CallerContext callerContext = f21111a;
            ((FbDraweeView) actionLinkCallToActionView.j.m12095a()).setVisibility(0);
            ((FbDraweeView) actionLinkCallToActionView.j.m12095a()).m20507a(uri, callerContext);
        } else if (props.e != null) {
            Drawable drawable = props.e;
            ((FbDraweeView) actionLinkCallToActionView.j.m12095a()).setVisibility(0);
            ((FbDraweeView) actionLinkCallToActionView.j.m12095a()).setImageDrawable(drawable);
        } else {
            actionLinkCallToActionView.j.m12098c();
        }
        if (props.f.aB() != null) {
            CharSequence aB = props.f.aB();
            actionLinkCallToActionView.k.setVisibility(0);
            actionLinkCallToActionView.k.setText(aB);
        } else {
            actionLinkCallToActionView.k.setVisibility(8);
        }
        boolean z = false;
        if (graphQLStory.mo2890l() != null) {
            Object obj3;
            if (graphQLStory.mo2890l().m23211E() == null || graphQLStory.mo2890l().m23211E().m22671a() <= 0) {
                obj3 = null;
            } else {
                obj3 = 1;
            }
            Object obj4;
            if (graphQLStory.mo2890l().m23249p() == null || graphQLStory.mo2890l().m23249p().m22656a() <= 0) {
                obj4 = null;
            } else {
                obj4 = 1;
            }
            if (!(obj3 == null && r10 == null)) {
                z = true;
            }
        }
        actionLinkCallToActionView.l = z;
        actionLinkCallToActionView.invalidate();
        Logger.a(8, EntryType.MARK_POP, -118872038, a);
    }

    public static ActionLinkCallToActionPartDefinition m28859a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ActionLinkCallToActionPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f21113g) {
                ActionLinkCallToActionPartDefinition actionLinkCallToActionPartDefinition;
                if (a2 != null) {
                    actionLinkCallToActionPartDefinition = (ActionLinkCallToActionPartDefinition) a2.mo818a(f21113g);
                } else {
                    actionLinkCallToActionPartDefinition = f21112f;
                }
                if (actionLinkCallToActionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28861b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f21113g, b3);
                        } else {
                            f21112f = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = actionLinkCallToActionPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public ActionLinkCallToActionPartDefinition(BackgroundPartDefinition backgroundPartDefinition, TextPartDefinition textPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition2) {
        this.f21114b = backgroundPartDefinition;
        this.f21115c = textPartDefinition;
        this.f21116d = clickListenerPartDefinition;
        this.f21117e = clickListenerPartDefinition2;
    }

    public static boolean m28860a(GraphQLStory graphQLStory) {
        Object obj = (graphQLStory.m22319E() == null || graphQLStory.m22319E().size() <= 0) ? null : 1;
        return obj != null || m28863b(graphQLStory);
    }

    public static boolean m28863b(GraphQLStory graphQLStory) {
        GraphQLStoryAttachment o = StoryAttachmentHelper.m28042o(graphQLStory);
        if (o == null) {
            return false;
        }
        GraphQLStoryActionLink a = ActionLinkHelper.m22935a(o);
        if (a == null || a.m22915t() == null) {
            return false;
        }
        return true;
    }

    public static GraphQLStoryActionLink m28864c(GraphQLStory graphQLStory) {
        return ActionLinkHelper.m22935a(StoryAttachmentHelper.m28042o(graphQLStory));
    }

    public static CharSequence m28862b(GraphQLStoryActionLink graphQLStoryActionLink) {
        GraphQLTextWithEntities t = graphQLStoryActionLink.m22915t();
        ImmutableList b = t.mo2912b();
        if (b.isEmpty()) {
            return t.mo2911a();
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(t.mo2911a());
        StyleSpan styleSpan = new StyleSpan(1);
        int size = b.size();
        for (int i = 0; i < size; i++) {
            GraphQLEntityAtRange graphQLEntityAtRange = (GraphQLEntityAtRange) b.get(i);
            spannableStringBuilder.setSpan(styleSpan, graphQLEntityAtRange.mo2944c(), graphQLEntityAtRange.mo2943b() + graphQLEntityAtRange.mo2944c(), 17);
        }
        return spannableStringBuilder;
    }
}
