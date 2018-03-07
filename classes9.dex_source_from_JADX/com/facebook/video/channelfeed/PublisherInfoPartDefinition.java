package com.facebook.video.channelfeed;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLActorUtil;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.StoryActorHelper;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ImageBlockLayoutThumbnailPartDefinition;
import com.facebook.multirow.parts.ImageBlockLayoutThumbnailPartDefinition.Props.Builder;
import com.facebook.multirow.parts.TextIconPartDefinition;
import com.facebook.multirow.parts.TextIconPartDefinition.IconData;
import com.facebook.multirow.parts.TextIconPartDefinition.IconData.Position;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.multirow.parts.TextWithImageEntitiesOrHiddenPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: success_load_new_user_signup */
public class PublisherInfoPartDefinition<E extends HasContext> extends MultiRowSinglePartDefinition<Props, Void, E, ImageBlockLayout> {
    public static final ViewType<ImageBlockLayout> f2643a = ViewType.a(2130906508);
    private static PublisherInfoPartDefinition f2644f;
    private static final Object f2645g = new Object();
    private final ImageBlockLayoutThumbnailPartDefinition f2646b;
    private final TextPartDefinition f2647c;
    private final TextWithImageEntitiesOrHiddenPartDefinition<E> f2648d;
    private final TextIconPartDefinition f2649e;

    /* compiled from: success_load_new_user_signup */
    public final class Props {
        public final GraphQLStory f2640a;
        public final boolean f2641b;
        public final GraphQLTextWithEntities f2642c;

        /* compiled from: success_load_new_user_signup */
        public class Builder {
            public GraphQLStory f2637a;
            public boolean f2638b;
            public GraphQLTextWithEntities f2639c;

            public Builder(GraphQLStory graphQLStory) {
                this.f2637a = graphQLStory;
            }
        }

        public Props(GraphQLStory graphQLStory, boolean z, GraphQLTextWithEntities graphQLTextWithEntities) {
            this.f2640a = graphQLStory;
            this.f2641b = z;
            this.f2642c = graphQLTextWithEntities;
        }
    }

    private static PublisherInfoPartDefinition m2542b(InjectorLike injectorLike) {
        return new PublisherInfoPartDefinition(ImageBlockLayoutThumbnailPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), TextWithImageEntitiesOrHiddenPartDefinition.a(injectorLike), TextIconPartDefinition.a(injectorLike));
    }

    public final Object m2544a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        CharSequence aa;
        int i;
        Props props = (Props) obj;
        GraphQLStoryAttachment o = StoryAttachmentHelper.o(props.f2640a);
        GraphQLActor a = StoryAttachmentHelper.a(o);
        if (a != null) {
            aa = a.aa();
        } else {
            aa = null;
        }
        if (StringUtil.a(aa) && props.f2640a.m() != null) {
            aa = props.f2640a.m().a();
        }
        if (!TextUtils.isEmpty(aa)) {
            subParts.a(2131558927, this.f2647c, aa);
            i = (a == null || !a.R()) ? 0 : 1;
            TextIconPartDefinition textIconPartDefinition = this.f2649e;
            if (i != 0) {
                i = 2130843879;
            } else {
                i = 0;
            }
            subParts.a(2131558927, textIconPartDefinition, new IconData(i, 2131431544, Position.END));
        }
        subParts.a(2131558926, this.f2648d, new com.facebook.multirow.parts.TextWithImageEntitiesOrHiddenPartDefinition.Props(props.f2642c != null ? props.f2642c : o.r().aV(), 2131431507, 0));
        ImageBlockLayoutThumbnailPartDefinition imageBlockLayoutThumbnailPartDefinition = this.f2646b;
        Builder a2 = new Builder().a(GraphQLActorUtil.c(StoryActorHelper.b(props.f2640a)));
        a2.c = 2130841701;
        Builder builder = a2;
        if (props.f2641b) {
            i = 2131431504;
        } else {
            i = 2131431503;
        }
        builder.d = i;
        builder = builder;
        if (props.f2641b) {
            i = 2131431506;
        } else {
            i = 2131431505;
        }
        builder.e = i;
        subParts.a(2131560329, imageBlockLayoutThumbnailPartDefinition, builder.a());
        return null;
    }

    public static PublisherInfoPartDefinition m2541a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PublisherInfoPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2645g) {
                PublisherInfoPartDefinition publisherInfoPartDefinition;
                if (a2 != null) {
                    publisherInfoPartDefinition = (PublisherInfoPartDefinition) a2.a(f2645g);
                } else {
                    publisherInfoPartDefinition = f2644f;
                }
                if (publisherInfoPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2542b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2645g, b3);
                        } else {
                            f2644f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = publisherInfoPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PublisherInfoPartDefinition(ImageBlockLayoutThumbnailPartDefinition imageBlockLayoutThumbnailPartDefinition, TextPartDefinition textPartDefinition, TextWithImageEntitiesOrHiddenPartDefinition textWithImageEntitiesOrHiddenPartDefinition, TextIconPartDefinition textIconPartDefinition) {
        this.f2646b = imageBlockLayoutThumbnailPartDefinition;
        this.f2647c = textPartDefinition;
        this.f2648d = textWithImageEntitiesOrHiddenPartDefinition;
        this.f2649e = textIconPartDefinition;
    }

    public final ViewType<ImageBlockLayout> m2543a() {
        return f2643a;
    }

    public final boolean m2545a(Object obj) {
        return true;
    }
}
