package com.facebook.feed.rows.permalink;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.ContextUtils;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryAttachmentHelper;
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
import com.facebook.photos.albums.ProfilePicCoverPhotoEditHelper;
import com.facebook.photos.base.analytics.ProfilePhotoPromptLogger;
import com.facebook.photos.base.photos.PhotoFetchInfo;
import com.facebook.photos.base.photos.PhotoFetchInfo.FetchCause;
import javax.inject.Inject;

@ContextScoped
/* compiled from: addPhotoTagParams */
public class PermalinkProfilePhotoPromptPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, State, HasPositionInformation, PermalinkProfilePhotoPromptView> {
    public static final ViewType f19920a = new C17251();
    public static final PhotoFetchInfo f19921b = new PhotoFetchInfo(FetchCause.USER_INITIATED, CallerContext.a(PermalinkProfilePhotoPromptPartDefinition.class));
    private static PermalinkProfilePhotoPromptPartDefinition f19922g;
    private static final Object f19923h = new Object();
    private final BackgroundPartDefinition f19924c;
    public final ProfilePicCoverPhotoEditHelper f19925d;
    public final ProfilePhotoPromptLogger f19926e;
    public String f19927f;

    /* compiled from: addPhotoTagParams */
    final class C17251 extends ViewType {
        C17251() {
        }

        public final View m23127a(Context context) {
            return new PermalinkProfilePhotoPromptView(context);
        }
    }

    /* compiled from: addPhotoTagParams */
    class C17273 implements OnClickListener {
        final /* synthetic */ PermalinkProfilePhotoPromptPartDefinition f19917a;

        C17273(PermalinkProfilePhotoPromptPartDefinition permalinkProfilePhotoPromptPartDefinition) {
            this.f19917a = permalinkProfilePhotoPromptPartDefinition;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 593341588);
            this.f19917a.f19926e.b(this.f19917a.f19927f);
            Logger.a(2, EntryType.UI_INPUT_END, -1295716188, a);
        }
    }

    /* compiled from: addPhotoTagParams */
    public class State {
        public final OnClickListener f19918a;
        public final OnClickListener f19919b;

        public State(OnClickListener onClickListener, OnClickListener onClickListener2) {
            this.f19918a = onClickListener;
            this.f19919b = onClickListener2;
        }
    }

    private static PermalinkProfilePhotoPromptPartDefinition m23129b(InjectorLike injectorLike) {
        return new PermalinkProfilePhotoPromptPartDefinition(ProfilePicCoverPhotoEditHelper.m11388b(injectorLike), BackgroundPartDefinition.a(injectorLike), ProfilePhotoPromptLogger.a(injectorLike));
    }

    public final Object m23131a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        final GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        if (this.f19927f == null) {
            this.f19927f = this.f19926e.a(graphQLStory.aa_(), graphQLStory.n(), StoryAttachmentHelper.o(graphQLStory).r().b());
        }
        subParts.a(this.f19924c, new StylingData(feedProps, PaddingStyle.a));
        return new State(new OnClickListener(this) {
            final /* synthetic */ PermalinkProfilePhotoPromptPartDefinition f19916b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 752954973);
                this.f19916b.f19926e.a(this.f19916b.f19927f);
                this.f19916b.f19925d.m11391a(Long.parseLong(StoryAttachmentHelper.o(graphQLStory).r().b()), (Activity) ContextUtils.a(view.getContext(), Activity.class), PermalinkProfilePhotoPromptPartDefinition.f19921b);
                Logger.a(2, EntryType.UI_INPUT_END, 1432021417, a);
            }
        }, new C17273(this));
    }

    public final /* bridge */ /* synthetic */ void m23132a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -362880243);
        ((PermalinkProfilePhotoPromptView) view).m23135a(((State) obj2).f19918a);
        Logger.a(8, EntryType.MARK_POP, -1197514638, a);
    }

    public final boolean m23133a(Object obj) {
        GraphQLStory graphQLStory = (GraphQLStory) ((FeedProps) obj).a;
        boolean z = true;
        if (!StoryAttachmentHelper.a(graphQLStory) || ((StoryAttachmentHelper.a(graphQLStory) && graphQLStory.M().size() != 1) || (StoryAttachmentHelper.h(graphQLStory) && StoryAttachmentHelper.i(graphQLStory).size() != 1))) {
            z = false;
        } else {
            GraphQLStoryAttachment o = StoryAttachmentHelper.o(graphQLStory);
            if (o.r() == null || o.r().j() == null || o.r().j().g() != 77090322 || !o.r().aZ()) {
                z = false;
            }
        }
        return z;
    }

    public final void m23134b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((PermalinkProfilePhotoPromptView) view).m23135a(null);
    }

    public static PermalinkProfilePhotoPromptPartDefinition m23128a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PermalinkProfilePhotoPromptPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19923h) {
                PermalinkProfilePhotoPromptPartDefinition permalinkProfilePhotoPromptPartDefinition;
                if (a2 != null) {
                    permalinkProfilePhotoPromptPartDefinition = (PermalinkProfilePhotoPromptPartDefinition) a2.a(f19923h);
                } else {
                    permalinkProfilePhotoPromptPartDefinition = f19922g;
                }
                if (permalinkProfilePhotoPromptPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23129b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19923h, b3);
                        } else {
                            f19922g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = permalinkProfilePhotoPromptPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PermalinkProfilePhotoPromptPartDefinition(ProfilePicCoverPhotoEditHelper profilePicCoverPhotoEditHelper, BackgroundPartDefinition backgroundPartDefinition, ProfilePhotoPromptLogger profilePhotoPromptLogger) {
        this.f19925d = profilePicCoverPhotoEditHelper;
        this.f19924c = backgroundPartDefinition;
        this.f19926e = profilePhotoPromptLogger;
    }

    public final ViewType m23130a() {
        return f19920a;
    }
}
