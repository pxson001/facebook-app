package com.facebook.feed.rows.sections.attachments;

import android.content.Context;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.ui.GifShareAttachmentView;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.util.StoryAttachmentUtil;
import com.facebook.graphql.model.GraphQLStoryAttachment;
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
import com.facebook.multirow.parts.TextOrHiddenPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fetchZeroTokenRequestParams */
public class GifShareAttachmentPartDefinition<E extends HasInvalidate & HasPersistentState & HasPositionInformation> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, State, E, GifShareAttachmentView> {
    public static final ViewType f24204a = new C09831();
    private static final CallerContext f24205b = CallerContext.m9063a(GifShareAttachmentPartDefinition.class, "newsfeed_image_share_view", "gif_image", "native_newsfeed");
    private static final PaddingStyle f24206c = PaddingStyle.f13071a;
    private static GifShareAttachmentPartDefinition f24207h;
    private static final Object f24208i = new Object();
    private final BackgroundPartDefinition f24209d;
    private final StoryAttachmentUtil f24210e;
    private final FbDraweeControllerBuilder f24211f;
    private final TextOrHiddenPartDefinition f24212g;

    /* compiled from: fetchZeroTokenRequestParams */
    final class C09831 extends ViewType {
        C09831() {
        }

        public final View mo1995a(Context context) {
            return new GifShareAttachmentView(context);
        }
    }

    private static GifShareAttachmentPartDefinition m32553b(InjectorLike injectorLike) {
        return new GifShareAttachmentPartDefinition(BackgroundPartDefinition.m19135a(injectorLike), StoryAttachmentUtil.m22700a(injectorLike), FbDraweeControllerBuilder.m19410b(injectorLike), TextOrHiddenPartDefinition.m32561a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.f13444a;
        subParts.mo2755a(2131563058, this.f24212g, StoryAttachmentUtil.m22701a(graphQLStoryAttachment));
        subParts.mo2756a(this.f24209d, new StylingData(AttachmentProps.m28715e(feedProps), f24206c, 2130840170, -1));
        State state = new State(2.0f);
        state.a = ((FbDraweeControllerBuilder) this.f24211f.m19417a(f24205b).m19418a(m32552a(graphQLStoryAttachment.m23979r().m24440S().mo2924b())).m19440a(new 2(this, state))).m19435s();
        return state;
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -2142728207);
        State state = (State) obj2;
        state.c = (GifShareAttachmentView) view;
        state.c.setAspectRatio(state.b);
        GifShareAttachmentView gifShareAttachmentView = state.c;
        gifShareAttachmentView.a.setController(state.a);
        Logger.a(8, EntryType.MARK_POP, -1190950104, a);
    }

    public final boolean m32557a(Object obj) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) ((FeedProps) obj).f13444a;
        return (graphQLStoryAttachment.m23966C() == null || !graphQLStoryAttachment.m23966C().contains(".gif") || graphQLStoryAttachment.m23979r() == null || graphQLStoryAttachment.m23979r().m24440S() == null || graphQLStoryAttachment.m23979r().m24440S().mo2924b() == null || !graphQLStoryAttachment.m23979r().m24440S().mo2924b().toString().contains(".gif")) ? false : true;
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((State) obj2).c = null;
    }

    public static GifShareAttachmentPartDefinition m32551a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GifShareAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f24208i) {
                GifShareAttachmentPartDefinition gifShareAttachmentPartDefinition;
                if (a2 != null) {
                    gifShareAttachmentPartDefinition = (GifShareAttachmentPartDefinition) a2.mo818a(f24208i);
                } else {
                    gifShareAttachmentPartDefinition = f24207h;
                }
                if (gifShareAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32553b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f24208i, b3);
                        } else {
                            f24207h = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = gifShareAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public GifShareAttachmentPartDefinition(BackgroundPartDefinition backgroundPartDefinition, StoryAttachmentUtil storyAttachmentUtil, FbDraweeControllerBuilder fbDraweeControllerBuilder, TextOrHiddenPartDefinition textOrHiddenPartDefinition) {
        this.f24209d = backgroundPartDefinition;
        this.f24210e = storyAttachmentUtil;
        this.f24211f = fbDraweeControllerBuilder;
        this.f24212g = textOrHiddenPartDefinition;
    }

    public final ViewType mo2547a() {
        return f24204a;
    }

    private static String m32552a(String str) {
        String str2 = "url=";
        String str3 = ".gif";
        int indexOf = str.indexOf(str2);
        int indexOf2 = str.indexOf(str3);
        if (indexOf < 0 || indexOf2 > str.length()) {
            return str;
        }
        return str.substring(str2.length() + indexOf, str3.length() + indexOf2).replaceAll("%2F", "/").replaceAll("%3A", ":");
    }
}
