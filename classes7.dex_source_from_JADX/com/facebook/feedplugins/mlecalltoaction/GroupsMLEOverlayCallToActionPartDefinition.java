package com.facebook.feedplugins.mlecalltoaction;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.calltoaction.ActionLinkCallToActionPartDefinition;
import com.facebook.feedplugins.calltoaction.ActionLinkCallToActionPartDefinition$Props;
import com.facebook.feedplugins.calltoaction.ActionLinkCallToActionView;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLGroupCreationSuggestion;
import com.facebook.graphql.model.GraphQLOverlayCallToActionInfo;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLUser;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.groups.analytics.GroupsAnalyticsLogger;
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
import com.facebook.remoteasset.RemoteAsset.Builder;
import com.facebook.remoteasset.RemoteAssetUriGenerator;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

@ContextScoped
/* compiled from: STRING */
public class GroupsMLEOverlayCallToActionPartDefinition<E extends FeedEnvironment> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, ActionLinkCallToActionView> {
    private static GroupsMLEOverlayCallToActionPartDefinition f23520g;
    private static final Object f23521h = new Object();
    private final ActionLinkCallToActionPartDefinition<E> f23522a;
    public final RemoteAssetUriGenerator f23523b;
    public final FbUriIntentHandler f23524c;
    public final Context f23525d;
    public final GroupsAnalyticsLogger f23526e;
    private final GatekeeperStoreImpl f23527f;

    private static GroupsMLEOverlayCallToActionPartDefinition m25768b(InjectorLike injectorLike) {
        return new GroupsMLEOverlayCallToActionPartDefinition(ActionLinkCallToActionPartDefinition.a(injectorLike), RemoteAssetUriGenerator.b(injectorLike), FbUriIntentHandler.a(injectorLike), (Context) injectorLike.getInstance(Context.class), GroupsAnalyticsLogger.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m25771a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        final GraphQLStoryActionLink a = ActionLinkHelper.a(StoryAttachmentHelper.o((GraphQLStory) feedProps.a));
        GraphQLGroupCreationSuggestion j = a.I().j();
        C20281 c20281 = new OnClickListener(this) {
            final /* synthetic */ GroupsMLEOverlayCallToActionPartDefinition f23519b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -178154629);
                GraphQLGroupCreationSuggestion j = a.I().j();
                this.f23519b.f23524c.a(this.f23519b.f23525d, FBLinks.D, GroupsMLEOverlayCallToActionPartDefinition.m25769c(a));
                this.f23519b.f23526e.b(j.o().name(), j.m(), "overlay_cta");
                Logger.a(2, EntryType.UI_INPUT_END, -438399211, a);
            }
        };
        Builder builder = new Builder();
        builder.c = "png";
        builder = builder;
        builder.a = "MLEOverlayActionLinkIcon";
        builder = builder;
        builder.b = "groups";
        subParts.a(this.f23522a, ActionLinkCallToActionPartDefinition$Props.m25512a(feedProps, null, c20281, Uri.parse(this.f23523b.a(builder.a())), null));
        this.f23526e.c(j.o().name(), j.m(), "overlay_cta");
        return null;
    }

    public final boolean m25772a(Object obj) {
        GraphQLStory graphQLStory = (GraphQLStory) ((FeedProps) obj).a;
        if (!ActionLinkCallToActionPartDefinition.b(graphQLStory) || !this.f23527f.a(866, false)) {
            return false;
        }
        GraphQLStoryAttachment o = StoryAttachmentHelper.o(graphQLStory);
        if (o == null) {
            return false;
        }
        GraphQLStoryActionLink a = ActionLinkHelper.a(o);
        if (a == null) {
            return false;
        }
        GraphQLObjectType a2 = a.a();
        if (a2 == null || a2.g() != -1260727392) {
            return false;
        }
        GraphQLOverlayCallToActionInfo I = a.I();
        return (I == null || I.a() == null || I.a().g() != -495215233) ? false : true;
    }

    public static GroupsMLEOverlayCallToActionPartDefinition m25767a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GroupsMLEOverlayCallToActionPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23521h) {
                GroupsMLEOverlayCallToActionPartDefinition groupsMLEOverlayCallToActionPartDefinition;
                if (a2 != null) {
                    groupsMLEOverlayCallToActionPartDefinition = (GroupsMLEOverlayCallToActionPartDefinition) a2.a(f23521h);
                } else {
                    groupsMLEOverlayCallToActionPartDefinition = f23520g;
                }
                if (groupsMLEOverlayCallToActionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25768b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23521h, b3);
                        } else {
                            f23520g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = groupsMLEOverlayCallToActionPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public GroupsMLEOverlayCallToActionPartDefinition(ActionLinkCallToActionPartDefinition actionLinkCallToActionPartDefinition, RemoteAssetUriGenerator remoteAssetUriGenerator, FbUriIntentHandler fbUriIntentHandler, Context context, GroupsAnalyticsLogger groupsAnalyticsLogger, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f23522a = actionLinkCallToActionPartDefinition;
        this.f23523b = remoteAssetUriGenerator;
        this.f23524c = fbUriIntentHandler;
        this.f23525d = context;
        this.f23526e = groupsAnalyticsLogger;
        this.f23527f = gatekeeperStoreImpl;
    }

    public final ViewType<ActionLinkCallToActionView> m25770a() {
        return ActionLinkCallToActionView.f23054h;
    }

    public static Bundle m25769c(GraphQLStoryActionLink graphQLStoryActionLink) {
        Bundle bundle = new Bundle();
        GraphQLGroupCreationSuggestion j = graphQLStoryActionLink.I().j();
        List arrayList = new ArrayList();
        ImmutableList k = j.k();
        int size = k.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(((GraphQLUser) k.get(i)).P());
        }
        String b = StringUtil.b(",", new Object[]{arrayList});
        bundle.putString("group_name", j.a());
        bundle.putString("group_members", b);
        bundle.putString("group_visibility", j.j().toString());
        bundle.putString("ref", "overlay_cta");
        bundle.putString("suggestion_category", j.o().name());
        bundle.putString("suggestion_identifier", j.m());
        return bundle;
    }
}
