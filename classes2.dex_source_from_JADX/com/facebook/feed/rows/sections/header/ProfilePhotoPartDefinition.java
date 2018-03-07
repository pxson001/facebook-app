package com.facebook.feed.rows.sections.header;

import android.content.Context;
import android.net.Uri;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.photos.FeedImagesCacheStateMapper;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feedplugins.graphqlstory.header.DefaultHeaderPartDataProviderForTextLayout;
import com.facebook.feedplugins.graphqlstory.header.DefaultHeaderPartDataProviderForTextLayout.C08732;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLActorUtil;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryActorHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.FbDraweePartDefinition;
import com.facebook.multirow.parts.FbDraweePartDefinition.Props.Builder;
import com.google.common.base.Strings;
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: hu_HU */
public class ProfilePhotoPartDefinition<E extends HasPrefetcher & HasRowKey> extends BaseSinglePartDefinition<Props, Void, E, FbDraweeView> {
    private static final CallerContext f20671a = CallerContext.m9061a(ProfilePhotoPartDefinition.class, "native_newsfeed");
    private static ProfilePhotoPartDefinition f20672f;
    private static final Object f20673g = new Object();
    private final DefaultHeaderPartDataProviderForTextLayout f20674b;
    private final FeedImagesCacheStateMapper f20675c;
    private final ClickListenerPartDefinition f20676d;
    private final FbDraweePartDefinition<E> f20677e;

    @Immutable
    /* compiled from: hu_HU */
    public class Props {
        public final FeedProps<GraphQLStory> f21735a;
        public final int f21736b;
        public final int f21737c;

        public Props(FeedProps<GraphQLStory> feedProps, int i, int i2) {
            this.f21735a = feedProps;
            this.f21737c = i;
            this.f21736b = i2;
        }
    }

    private static ProfilePhotoPartDefinition m28425b(InjectorLike injectorLike) {
        return new ProfilePhotoPartDefinition(DefaultHeaderPartDataProviderForTextLayout.m28171a(injectorLike), FbDraweePartDefinition.m27839a(injectorLike), ClickListenerPartDefinition.m19353a(injectorLike), FeedImagesCacheStateMapper.m14216a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLStory graphQLStory;
        GraphQLActor b;
        Uri uri;
        String g;
        Object obj2;
        Props props = (Props) obj;
        if (props.f21735a != null) {
            graphQLStory = (GraphQLStory) props.f21735a.f13444a;
        } else {
            graphQLStory = null;
        }
        if (graphQLStory != null) {
            b = StoryActorHelper.m27492b(graphQLStory);
        } else {
            b = null;
        }
        if (b == null || Strings.isNullOrEmpty(GraphQLActorUtil.m29709c(b))) {
            uri = null;
        } else {
            uri = Uri.parse(GraphQLActorUtil.m29709c(b));
        }
        if (graphQLStory != null) {
            g = StoryProps.m27457d(props.f21735a).mo2507g();
        } else {
            g = null;
        }
        if (!(uri == null || g == null)) {
            this.f20675c.m14221a(g, uri.toString());
        }
        SinglePartDefinition singlePartDefinition = this.f20677e;
        Builder a = new Builder().m29719a(uri);
        a.f21889c = f20671a;
        a = a.m29718a(props.f21736b, props.f21737c);
        a.f21892f = true;
        subParts.mo2756a(singlePartDefinition, a.m29721a());
        DefaultHeaderPartDataProviderForTextLayout defaultHeaderPartDataProviderForTextLayout = this.f20674b;
        FeedProps feedProps = props.f21735a;
        GraphQLStory graphQLStory2 = (GraphQLStory) feedProps.f13444a;
        if (StoryActorHelper.m27492b(graphQLStory2) == null) {
            defaultHeaderPartDataProviderForTextLayout.f20429c.m2350b(DefaultHeaderPartDataProviderForTextLayout.f20425a, "Story without an actor " + graphQLStory2.S_());
            obj2 = null;
        } else {
            C08732 c08732 = new C08732(defaultHeaderPartDataProviderForTextLayout, graphQLStory2, feedProps);
        }
        subParts.mo2756a(this.f20676d, obj2);
        return null;
    }

    public static ProfilePhotoPartDefinition m28424a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ProfilePhotoPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20673g) {
                ProfilePhotoPartDefinition profilePhotoPartDefinition;
                if (a2 != null) {
                    profilePhotoPartDefinition = (ProfilePhotoPartDefinition) a2.mo818a(f20673g);
                } else {
                    profilePhotoPartDefinition = f20672f;
                }
                if (profilePhotoPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28425b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20673g, b3);
                        } else {
                            f20672f = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = profilePhotoPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public ProfilePhotoPartDefinition(DefaultHeaderPartDataProviderForTextLayout defaultHeaderPartDataProviderForTextLayout, FbDraweePartDefinition fbDraweePartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, FeedImagesCacheStateMapper feedImagesCacheStateMapper) {
        this.f20674b = defaultHeaderPartDataProviderForTextLayout;
        this.f20675c = feedImagesCacheStateMapper;
        this.f20677e = fbDraweePartDefinition;
        this.f20676d = clickListenerPartDefinition;
    }
}
