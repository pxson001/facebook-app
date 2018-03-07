package com.facebook.attachments.angora.actionbutton;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.CurationMechanism;
import com.facebook.analytics.CurationSurface;
import com.facebook.api.graphql.saved.SaveDefaultsGraphQLInterfaces.SavableTimelineAppCollection;
import com.facebook.api.graphql.saved.SaveDefaultsGraphQLModels.DefaultSavableObjectExtraFieldsModel;
import com.facebook.attachments.angora.AngoraCollectionUpdateRequestListener;
import com.facebook.attachments.angora.CollectionUpdateResultListener;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.controller.mutation.gk.ControllerMutationGatekeepers;
import com.facebook.controller.mutation.util.SavedCollectionFeedUnitMutator;
import com.facebook.fbservice.ops.ResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.StoryEvents.FeedUnitMutatedEvent;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLSavedCollectionFeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLTimelineAppCollection;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.saved.common.sync.SavedEventHandler;
import com.facebook.story.UpdateTimelineAppCollectionParams.Action;
import com.facebook.story.UpdateTimelineAppCollectionParams.Builder;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;

/* compiled from: venue_name */
public abstract class SaveButtonListener implements CollectionUpdateResultListener {
    private final String f726a = getClass().getSimpleName();
    public final AbstractFbErrorReporter f727b;
    private final FeedEventBus f728c;
    protected OnClickListener f729d;
    private final SavedCollectionFeedUnitMutator f730e;
    private final SaveButtonUtils f731f;
    private final AngoraCollectionUpdateRequestListener f732g;
    private final GraphQLStoryUtil f733h;
    private final Context f734i;
    private final ControllerMutationGatekeepers f735j;
    private final GraphQLQueryExecutor f736k;
    private final ExecutorService f737l;
    public final Lazy<SavedEventHandler> f738m;
    private final CollectionSaveLegacyMutationProvider f739n;
    private CurationSurface f740o = CurationSurface.UNKNOWN;
    private GraphQLNode f741p;
    private FeedProps<? extends FeedUnit> f742q;
    @Nullable
    private String f743r;
    @Nullable
    private String f744s;
    private OnClickListener f745t;

    /* compiled from: venue_name */
    class C00771 implements OnClickListener {
        final /* synthetic */ SaveButtonListener f868a;

        C00771(SaveButtonListener saveButtonListener) {
            this.f868a = saveButtonListener;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -948638676);
            this.f868a.m784a(view);
            Logger.a(2, EntryType.UI_INPUT_END, 229204952, a);
        }
    }

    /* compiled from: venue_name */
    class C00782 extends ResultFutureCallback<GraphQLResult<DefaultSavableObjectExtraFieldsModel>> {
        final /* synthetic */ SaveButtonListener f869a;

        C00782(SaveButtonListener saveButtonListener) {
            this.f869a = saveButtonListener;
        }

        protected final void m865a(Object obj) {
            ((SavedEventHandler) this.f869a.f738m.get()).a();
        }

        protected final void m864a(ServiceException serviceException) {
            this.f869a.f727b.a(this.f869a.getClass().getSimpleName(), StringFormatUtil.formatStrLocaleSafe("Failed to add item to Timeline Collection due to server exception %s.", serviceException.toString()));
        }
    }

    /* compiled from: venue_name */
    /* synthetic */ class C00793 {
        static final /* synthetic */ int[] f870a = new int[Action.values().length];

        static {
            try {
                f870a[Action.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f870a[Action.REMOVE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    protected abstract void mo42a(boolean z);

    public SaveButtonListener(SaveButtonUtils saveButtonUtils, FbErrorReporter fbErrorReporter, AngoraCollectionUpdateRequestListener angoraCollectionUpdateRequestListener, FeedEventBus feedEventBus, SavedCollectionFeedUnitMutator savedCollectionFeedUnitMutator, GraphQLStoryUtil graphQLStoryUtil, Context context, ControllerMutationGatekeepers controllerMutationGatekeepers, GraphQLQueryExecutor graphQLQueryExecutor, ExecutorService executorService, Lazy<SavedEventHandler> lazy, CollectionSaveLegacyMutationProvider collectionSaveLegacyMutationProvider, GraphQLNode graphQLNode, CurationSurface curationSurface, FeedProps<? extends FeedUnit> feedProps, @Nullable OnClickListener onClickListener) {
        this.f731f = saveButtonUtils;
        this.f727b = fbErrorReporter;
        this.f732g = angoraCollectionUpdateRequestListener;
        this.f728c = feedEventBus;
        this.f730e = savedCollectionFeedUnitMutator;
        this.f733h = graphQLStoryUtil;
        this.f734i = context;
        this.f735j = controllerMutationGatekeepers;
        this.f736k = graphQLQueryExecutor;
        this.f737l = executorService;
        this.f738m = lazy;
        this.f739n = collectionSaveLegacyMutationProvider;
        this.f740o = curationSurface;
        this.f745t = onClickListener;
        this.f741p = graphQLNode;
        this.f742q = feedProps;
        this.f729d = new C00771(this);
        if (((FeedUnit) this.f742q.a()) instanceof GraphQLStory) {
            this.f742q = StoryProps.e(this.f742q);
            FeedProps feedProps2 = this.f742q;
            this.f743r = ((GraphQLStory) feedProps2.a()).c();
            this.f744s = TrackableFeedProps.a(feedProps2).toString();
            return;
        }
        this.f743r = null;
        this.f744s = null;
    }

    public final void mo40a() {
    }

    public final void mo41a(SavableTimelineAppCollection savableTimelineAppCollection, Action action) {
        if (!m795b()) {
            return;
        }
        if (savableTimelineAppCollection != this.f741p.gK()) {
            this.f727b.a(this.f726a, "Save Button has been rebinded to a different attachment.");
        } else if (((FeedUnit) this.f742q.a) instanceof GraphQLSavedCollectionFeedUnit) {
            switch (C00793.f870a[action.ordinal()]) {
                case 1:
                    m789b(false);
                    mo42a(false);
                    return;
                case 2:
                    m789b(true);
                    mo42a(true);
                    return;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    private void m784a(View view) {
        if (m795b()) {
            if (this.f741p.jn() != GraphQLSavedState.SAVED) {
                m788b(view);
            } else {
                m790c();
            }
            if (this.f745t != null) {
                this.f745t.onClick(view);
            }
        }
    }

    private void m789b(boolean z) {
        Flattenable flattenable = this.f742q.a;
        this.f728c.a(new FeedUnitMutatedEvent(this.f730e.a((GraphQLSavedCollectionFeedUnit) this.f742q.a, ImmutableBiMap.b(this.f741p.dp(), Boolean.valueOf(z)))));
    }

    private void m788b(View view) {
        this.f731f.a(view);
        FeedUnit feedUnit = (FeedUnit) this.f742q.a;
        this.f731f.a(this.f734i);
        if (feedUnit instanceof GraphQLStory) {
            this.f731f.a(this.f742q, CurationMechanism.TOGGLE_BUTTON, this.f740o);
            mo42a(true);
        } else if (!(feedUnit instanceof GraphQLSavedCollectionFeedUnit)) {
            this.f727b.b(this.f726a, "Saving something that isn't a Story or SavedCollectionFeedUnit. Item was not saved.");
        } else if (this.f735j.a()) {
            m791c(true);
        } else {
            GraphQLObjectType graphQLObjectType;
            m789b(true);
            mo42a(true);
            GraphQLTimelineAppCollection gK = this.f741p.gK();
            Builder builder = new Builder();
            builder.a = gK.b();
            builder = builder;
            builder.b = this.f741p.dp();
            builder = builder;
            builder.g = gK.d().c();
            builder = builder;
            builder.h = m783a(feedUnit);
            builder = builder;
            builder.d = this.f740o;
            builder = builder;
            builder.e = CurationMechanism.TOGGLE_BUTTON;
            builder = builder;
            builder.j = true;
            builder = builder;
            builder.l = this.f743r;
            builder = builder;
            builder.k = this.f744s;
            builder = builder;
            if (feedUnit == null) {
                graphQLObjectType = null;
            } else {
                graphQLObjectType = feedUnit.getType();
            }
            builder.f = graphQLObjectType;
            this.f732g.mo38a(this, gK, builder.a());
        }
    }

    private void m790c() {
        FeedUnit feedUnit = (FeedUnit) this.f742q.a;
        this.f731f.a();
        if (feedUnit instanceof GraphQLStory) {
            this.f731f.b(this.f742q, CurationMechanism.TOGGLE_BUTTON, this.f740o);
            mo42a(false);
        } else if (!(feedUnit instanceof GraphQLSavedCollectionFeedUnit)) {
            this.f727b.b(this.f726a, "Unsaving something that isn't a Story or SavedCollectionFeedUnit. Item not unsaved.");
        } else if (this.f735j.a()) {
            m791c(false);
        } else {
            GraphQLObjectType graphQLObjectType;
            m789b(false);
            mo42a(false);
            GraphQLTimelineAppCollection gK = this.f741p.gK();
            Builder builder = new Builder();
            builder.a = gK.b();
            builder = builder;
            builder.b = this.f741p.dp();
            builder = builder;
            builder.h = m783a(feedUnit);
            builder = builder;
            builder.j = true;
            builder = builder;
            builder.e = CurationMechanism.TOGGLE_BUTTON;
            builder = builder;
            builder.d = this.f740o;
            builder = builder;
            builder.l = this.f743r;
            builder = builder;
            builder.k = this.f744s;
            builder = builder;
            if (feedUnit == null) {
                graphQLObjectType = null;
            } else {
                graphQLObjectType = feedUnit.getType();
            }
            builder.f = graphQLObjectType;
            this.f732g.mo39b(this, gK, builder.a());
        }
    }

    private void m791c(boolean z) {
        Futures.a(this.f736k.a(this.f739n.m816a(this.f741p, this.f743r, this.f740o, CurationMechanism.TOGGLE_BUTTON, this.f744s, z)), new C00782(this), this.f737l);
    }

    private ImmutableList<String> m783a(@Nullable FeedUnit feedUnit) {
        if (feedUnit == null) {
            return RegularImmutableList.a;
        }
        if (feedUnit instanceof GraphQLStory) {
            return this.f733h.h((GraphQLStory) feedUnit);
        }
        return ImmutableList.of(feedUnit.g());
    }

    private static boolean m786a(GraphQLNode graphQLNode) {
        return (StringUtil.a(graphQLNode.dp()) || graphQLNode.gK() == null || !GraphQLHelper.a(graphQLNode.gK())) ? false : true;
    }

    protected final boolean m795b() {
        if (this.f741p == null) {
            this.f727b.a(this.f726a, "Save Button is binded without a target object.");
            return false;
        } else if (m786a(this.f741p)) {
            return true;
        } else {
            this.f727b.a(this.f726a, "SaveActionLink does not have enough information for save.");
            return false;
        }
    }
}
