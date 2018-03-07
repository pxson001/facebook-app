package com.facebook.checkin.socialsearch.feed;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.android.maps.StaticMapView.StaticMapOptions;
import com.facebook.android.maps.model.LatLng;
import com.facebook.checkin.socialsearch.map.SocialSearchMapFragment;
import com.facebook.checkin.socialsearch.ui.SocialSearchAttachmentView;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.FeedListName;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLLocation;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.GraphQLPlaceListItem;
import com.facebook.graphql.model.GraphQLPlaceListItemsFromPlaceListConnection;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.feed.PermalinkStoryIdParams.Builder;
import com.facebook.ipc.feed.ViewPermalinkIntentFactory;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.maps.rows.MapPartDefinition;
import com.facebook.maps.rows.MapPartDefinition.Props;
import com.facebook.maps.rows.MapSizeHelper;
import com.facebook.maps.rows.PrefetchMapPartDefinition;
import com.facebook.maps.rows.StaticMapOptionsHelper;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

@ContextScoped
/* compiled from: lastUserLocation */
public class SocialSearchAttachmentPartDefinition<E extends HasPositionInformation & HasPrefetcher & HasFeedListType> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, SocialSearchAttachmentView> {
    public static final ViewType<SocialSearchAttachmentView> f5893a = new C07381();
    private static SocialSearchAttachmentPartDefinition f5894k;
    private static final Object f5895l = new Object();
    public final Context f5896b;
    private final BackgroundPartDefinition f5897c;
    private final MapPartDefinition f5898d;
    private final PrefetchMapPartDefinition f5899e;
    private final ClickListenerPartDefinition f5900f;
    public final SecureContextHelper f5901g;
    public final ViewPermalinkIntentFactory f5902h;
    public final FbUriIntentHandler f5903i;
    private final MapSizeHelper f5904j;

    /* compiled from: lastUserLocation */
    final class C07381 extends ViewType<SocialSearchAttachmentView> {
        C07381() {
        }

        public final View m7292a(Context context) {
            return new SocialSearchAttachmentView(context);
        }
    }

    private static SocialSearchAttachmentPartDefinition m7295b(InjectorLike injectorLike) {
        return new SocialSearchAttachmentPartDefinition((Context) injectorLike.getInstance(Context.class), BackgroundPartDefinition.a(injectorLike), MapPartDefinition.a(injectorLike), PrefetchMapPartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), ViewPermalinkIntentFactory.a(injectorLike), FbUriIntentHandler.a(injectorLike), MapSizeHelper.a(injectorLike));
    }

    public final Object m7298a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Object c07392;
        FeedProps feedProps = (FeedProps) obj;
        HasPositionInformation hasPositionInformation = (HasPositionInformation) anyEnvironment;
        GraphQLStory c = AttachmentProps.c(feedProps);
        StaticMapOptions c2 = m7296c(feedProps);
        FeedProps e = AttachmentProps.e(feedProps);
        subParts.a(this.f5897c, new StylingData(AttachmentProps.e(feedProps), PaddingStyle.f));
        int a = this.f5904j.a(e);
        int a2 = this.f5904j.a();
        subParts.a(2131564018, this.f5898d, new Props(c2, false, a, a2));
        subParts.a(2131564018, this.f5899e, new PrefetchMapPartDefinition.Props(e, c2, a, a2));
        FeedListType c3 = ((HasFeedListType) hasPositionInformation).c();
        if (c3 == null || c3.a() != FeedListName.PERMALINK) {
            Builder builder = new Builder();
            builder.a = c.c();
            final Intent a3 = this.f5902h.a(builder.a());
            c07392 = new OnClickListener(this) {
                final /* synthetic */ SocialSearchAttachmentPartDefinition f5890b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 881670900);
                    this.f5890b.f5901g.a(a3, this.f5890b.f5896b);
                    Logger.a(2, EntryType.UI_INPUT_END, -836171600, a);
                }
            };
        } else {
            c07392 = m7294b(feedProps);
        }
        subParts.a(2131564018, this.f5900f, c07392);
        return null;
    }

    public final boolean m7299a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        return (feedProps.a == null || ((GraphQLStoryAttachment) feedProps.a).z() == null || ((GraphQLStoryAttachment) feedProps.a).z().jG() == null) ? false : true;
    }

    public static SocialSearchAttachmentPartDefinition m7293a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SocialSearchAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5895l) {
                SocialSearchAttachmentPartDefinition socialSearchAttachmentPartDefinition;
                if (a2 != null) {
                    socialSearchAttachmentPartDefinition = (SocialSearchAttachmentPartDefinition) a2.a(f5895l);
                } else {
                    socialSearchAttachmentPartDefinition = f5894k;
                }
                if (socialSearchAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7295b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5895l, b3);
                        } else {
                            f5894k = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = socialSearchAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SocialSearchAttachmentPartDefinition(Context context, BackgroundPartDefinition backgroundPartDefinition, MapPartDefinition mapPartDefinition, PrefetchMapPartDefinition prefetchMapPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, SecureContextHelper secureContextHelper, ViewPermalinkIntentFactory viewPermalinkIntentFactory, FbUriIntentHandler fbUriIntentHandler, MapSizeHelper mapSizeHelper) {
        this.f5896b = context;
        this.f5898d = mapPartDefinition;
        this.f5899e = prefetchMapPartDefinition;
        this.f5897c = backgroundPartDefinition;
        this.f5900f = clickListenerPartDefinition;
        this.f5901g = secureContextHelper;
        this.f5902h = viewPermalinkIntentFactory;
        this.f5903i = fbUriIntentHandler;
        this.f5904j = mapSizeHelper;
    }

    private OnClickListener m7294b(FeedProps<GraphQLStoryAttachment> feedProps) {
        GraphQLNode z = ((GraphQLStoryAttachment) feedProps.a).z();
        final Bundle bundle = new Bundle();
        bundle.putString(SocialSearchMapFragment.a, z.dp());
        FlatBufferModelHelper.a(bundle, SocialSearchMapFragment.b, z.jG());
        return new OnClickListener(this) {
            final /* synthetic */ SocialSearchAttachmentPartDefinition f5892b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 2022070833);
                this.f5892b.f5903i.a(this.f5892b.f5896b, FBLinks.gd, bundle);
                Logger.a(2, EntryType.UI_INPUT_END, 1116003893, a);
            }
        };
    }

    @VisibleForTesting
    private static StaticMapOptions m7296c(FeedProps<GraphQLStoryAttachment> feedProps) {
        GraphQLNode z = ((GraphQLStoryAttachment) feedProps.a).z();
        GraphQLPlaceListItemsFromPlaceListConnection jF = z.jF();
        if (jF == null || jF.a().isEmpty()) {
            GraphQLPage jG = z.jG();
            return StaticMapOptionsHelper.a(jG.aA(), "social_search", jG.az());
        }
        StaticMapOptions staticMapOptions = new StaticMapOptions("social_search");
        ImmutableList<GraphQLPlaceListItem> a = jF.a();
        List arrayList = new ArrayList(a.size());
        for (GraphQLPlaceListItem k : a) {
            GraphQLPage k2 = k.k();
            if (k2 != null) {
                GraphQLLocation az = k2.az();
                if (az != null) {
                    arrayList.add(new LatLng(az.a(), az.b()));
                }
            }
        }
        staticMapOptions.a(arrayList, "red");
        return staticMapOptions;
    }

    public final ViewType<SocialSearchAttachmentView> m7297a() {
        return f5893a;
    }
}
