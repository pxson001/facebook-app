package com.facebook.orca.contacts.divebar;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.contacts.graphql.ChatContextsGraphQLInterfaces.ChatContextForUser;
import com.facebook.contacts.graphql.ChatContextsGraphQLModels.ChatContextModel;
import com.facebook.contacts.picker.DivebarNearbyFriendsParams;
import com.facebook.contacts.picker.DivebarNearbyFriendsParams.Mode;
import com.facebook.contacts.picker.DivebarNearbyFriendsRow;
import com.facebook.contacts.picker.SuggestionUsersLoader;
import com.facebook.contacts.picker.SuggestionUsersLoader.1;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLUserChatContextType;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.facebook.location.FbLocationStatus;
import com.facebook.location.FbLocationStatus.State;
import com.facebook.location.FbLocationStatusUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.graphql.divebar.FetchDivebarNearbyFriendsStatusGraphQLModels.DivebarNearbyFriendsStatusQueryModel;
import com.facebook.messaging.graphql.divebar.FetchDivebarNearbyFriendsStatusGraphQLModels.LocationSharingFieldsModel;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import com.facebook.user.util.UserRankComparator;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: on_return_to_main_app */
public class DivebarNearbyFriendsController {
    public final Context f5838a;
    public final FbLocationStatusUtil f5839b;
    public final GraphQLQueryExecutor f5840c;
    public final SuggestionUsersLoader f5841d;
    public final SecureContextHelper f5842e;
    public final ExecutorService f5843f;
    public final DivebarNearbyFriendsAnalyticsLogger f5844g;
    public final GatekeeperStoreImpl f5845h;
    public final SectionFragmentDrawerController<DivebarNearbyFriendsFragment> f5846i = new SectionFragmentDrawerController();
    public DivebarViewListener f5847j;

    /* compiled from: on_return_to_main_app */
    public class C08531 implements Function<List<DivebarNearbyFriendsParams>, DivebarNearbyFriendsRow> {
        final /* synthetic */ DivebarNearbyFriendsController f5831a;

        public C08531(DivebarNearbyFriendsController divebarNearbyFriendsController) {
            this.f5831a = divebarNearbyFriendsController;
        }

        public Object apply(@Nullable Object obj) {
            List<DivebarNearbyFriendsParams> list = (List) obj;
            if (list == null) {
                return null;
            }
            for (final DivebarNearbyFriendsParams divebarNearbyFriendsParams : list) {
                if (divebarNearbyFriendsParams != null) {
                    DivebarNearbyFriendsAnalyticsLogger divebarNearbyFriendsAnalyticsLogger;
                    HoneyClientEvent honeyClientEvent;
                    switch (C08585.f5837a[divebarNearbyFriendsParams.a.ordinal()]) {
                        case 1:
                            this.f5831a.f5844g.m5518a(true);
                            break;
                        case 2:
                            this.f5831a.f5844g.m5518a(false);
                            break;
                        case 3:
                            divebarNearbyFriendsAnalyticsLogger = this.f5831a.f5844g;
                            honeyClientEvent = new HoneyClientEvent("background_location_location_disabled_miniphone_displayed");
                            honeyClientEvent.c = "background_location";
                            divebarNearbyFriendsAnalyticsLogger.f5828a.a(honeyClientEvent);
                            break;
                        case 4:
                            divebarNearbyFriendsAnalyticsLogger = this.f5831a.f5844g;
                            honeyClientEvent = new HoneyClientEvent("background_location_chat_context_disabled_miniphone_displayed");
                            honeyClientEvent.c = "background_location";
                            divebarNearbyFriendsAnalyticsLogger.f5828a.a(honeyClientEvent);
                            break;
                        case 5:
                            break;
                    }
                    divebarNearbyFriendsAnalyticsLogger = this.f5831a.f5844g;
                    honeyClientEvent = new HoneyClientEvent("background_location_miniphone_displayed");
                    honeyClientEvent.c = "background_location";
                    divebarNearbyFriendsAnalyticsLogger.f5828a.a(honeyClientEvent);
                    return new DivebarNearbyFriendsRow(divebarNearbyFriendsParams, new OnClickListener(this) {
                        final /* synthetic */ C08531 f5830b;

                        public void onClick(View view) {
                            int a = Logger.a(2, EntryType.UI_INPUT_START, 1122732649);
                            DivebarNearbyFriendsController.m5522b(this.f5830b.f5831a, divebarNearbyFriendsParams);
                            Logger.a(2, EntryType.UI_INPUT_END, -1001547715, a);
                        }
                    });
                }
            }
            return null;
        }
    }

    /* compiled from: on_return_to_main_app */
    public class C08542 implements Function<GraphQLResult<DivebarNearbyFriendsStatusQueryModel>, DivebarNearbyFriendsParams> {
        final /* synthetic */ DivebarNearbyFriendsController f5832a;

        public C08542(DivebarNearbyFriendsController divebarNearbyFriendsController) {
            this.f5832a = divebarNearbyFriendsController;
        }

        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null) {
                return null;
            }
            LocationSharingFieldsModel a = ((DivebarNearbyFriendsStatusQueryModel) graphQLResult.e).m2251a();
            if (a.m2257a()) {
                return null;
            }
            if (a.m2258b()) {
                return new DivebarNearbyFriendsParams(Mode.NUX, null);
            }
            return new DivebarNearbyFriendsParams(Mode.UPSELL, null);
        }
    }

    /* compiled from: on_return_to_main_app */
    public class C08563 implements AsyncFunction<Map<UserKey, ChatContextForUser>, DivebarNearbyFriendsParams> {
        final /* synthetic */ DivebarNearbyFriendsController f5834a;

        /* compiled from: on_return_to_main_app */
        class C08551 implements Function<ImmutableList<User>, DivebarNearbyFriendsParams> {
            final /* synthetic */ C08563 f5833a;

            C08551(C08563 c08563) {
                this.f5833a = c08563;
            }

            public Object apply(@Nullable Object obj) {
                ImmutableList immutableList = (ImmutableList) obj;
                if (immutableList == null) {
                    return null;
                }
                Collection a = Lists.a(immutableList);
                Collections.sort(a, UserRankComparator.a);
                return DivebarNearbyFriendsParams.a(ImmutableList.copyOf(a));
            }
        }

        public C08563(DivebarNearbyFriendsController divebarNearbyFriendsController) {
            this.f5834a = divebarNearbyFriendsController;
        }

        public final ListenableFuture m5520a(@Nullable Object obj) {
            Map map = (Map) obj;
            if (!this.f5834a.f5845h.a(905, false)) {
                return Futures.a(new DivebarNearbyFriendsParams(Mode.CHAT_CONTEXT_DISABLED, null));
            }
            if (this.f5834a.f5839b.b().a != State.OKAY) {
                return Futures.a(new DivebarNearbyFriendsParams(Mode.LOCATION_DISABLED, null));
            }
            if (map == null || map.isEmpty()) {
                return Futures.a(DivebarNearbyFriendsParams.a(RegularImmutableList.a));
            }
            Builder builder = ImmutableList.builder();
            for (Entry entry : map.entrySet()) {
                ChatContextModel b = ((ChatContextForUser) entry.getValue()).b();
                if (b != null && b.b() == GraphQLUserChatContextType.NEARBY) {
                    builder.c(entry.getKey());
                }
            }
            SuggestionUsersLoader suggestionUsersLoader = this.f5834a.f5841d;
            return Futures.a(suggestionUsersLoader.e.a(new 1(suggestionUsersLoader, builder.b())), new C08551(this), this.f5834a.f5843f);
        }
    }

    /* compiled from: on_return_to_main_app */
    /* synthetic */ class C08585 {
        static final /* synthetic */ int[] f5837a = new int[Mode.values().length];

        static {
            try {
                f5837a[Mode.NUX.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f5837a[Mode.UPSELL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f5837a[Mode.LOCATION_DISABLED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f5837a[Mode.CHAT_CONTEXT_DISABLED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f5837a[Mode.LIST.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public static DivebarNearbyFriendsController m5521a(InjectorLike injectorLike) {
        return new DivebarNearbyFriendsController((Context) injectorLike.getInstance(Context.class), FbLocationStatusUtil.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), SuggestionUsersLoader.b(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), DivebarNearbyFriendsAnalyticsLogger.m5516a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public DivebarNearbyFriendsController(Context context, FbLocationStatusUtil fbLocationStatusUtil, GraphQLQueryExecutor graphQLQueryExecutor, SuggestionUsersLoader suggestionUsersLoader, SecureContextHelper secureContextHelper, ExecutorService executorService, DivebarNearbyFriendsAnalyticsLogger divebarNearbyFriendsAnalyticsLogger, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f5838a = context;
        this.f5839b = fbLocationStatusUtil;
        this.f5840c = graphQLQueryExecutor;
        this.f5841d = suggestionUsersLoader;
        this.f5842e = secureContextHelper;
        this.f5843f = executorService;
        this.f5844g = divebarNearbyFriendsAnalyticsLogger;
        this.f5845h = gatekeeperStoreImpl;
    }

    public final DivebarNearbyFriendsRow m5524a() {
        if (!this.f5845h.a(516, false) || !FbLocationStatus.a(this.f5839b.b().a)) {
            return null;
        }
        final DivebarNearbyFriendsParams divebarNearbyFriendsParams = new DivebarNearbyFriendsParams(Mode.LOADING, null);
        return new DivebarNearbyFriendsRow(divebarNearbyFriendsParams, new OnClickListener(this) {
            final /* synthetic */ DivebarNearbyFriendsController f5836b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 534308245);
                DivebarNearbyFriendsController.m5522b(this.f5836b, divebarNearbyFriendsParams);
                Logger.a(2, EntryType.UI_INPUT_END, -255604037, a);
            }
        });
    }

    public static void m5522b(DivebarNearbyFriendsController divebarNearbyFriendsController, DivebarNearbyFriendsParams divebarNearbyFriendsParams) {
        DivebarNearbyFriendsAnalyticsLogger divebarNearbyFriendsAnalyticsLogger;
        HoneyClientEvent honeyClientEvent;
        switch (C08585.f5837a[divebarNearbyFriendsParams.a.ordinal()]) {
            case 1:
                divebarNearbyFriendsController.f5844g.m5519b(true);
                Intent intent = new Intent();
                intent.setData(Uri.parse(StringFormatUtil.formatStrLocaleSafe(FBLinks.cT, "divebar", Boolean.valueOf(true), Boolean.valueOf(false))));
                divebarNearbyFriendsController.f5842e.a(intent, divebarNearbyFriendsController.f5838a);
                return;
            case 2:
                divebarNearbyFriendsController.f5844g.m5519b(false);
                divebarNearbyFriendsController.m5523d();
                return;
            case 3:
                divebarNearbyFriendsAnalyticsLogger = divebarNearbyFriendsController.f5844g;
                honeyClientEvent = new HoneyClientEvent("background_location_location_disabled_miniphone_selected");
                honeyClientEvent.c = "background_location";
                divebarNearbyFriendsAnalyticsLogger.f5828a.a(honeyClientEvent);
                divebarNearbyFriendsController.m5523d();
                return;
            case 4:
                divebarNearbyFriendsAnalyticsLogger = divebarNearbyFriendsController.f5844g;
                honeyClientEvent = new HoneyClientEvent("background_location_chat_context_disabled_miniphone_selected");
                honeyClientEvent.c = "background_location";
                divebarNearbyFriendsAnalyticsLogger.f5828a.a(honeyClientEvent);
                divebarNearbyFriendsController.m5523d();
                return;
            case 5:
                divebarNearbyFriendsAnalyticsLogger = divebarNearbyFriendsController.f5844g;
                honeyClientEvent = new HoneyClientEvent("background_location_miniphone_selected");
                honeyClientEvent.c = "background_location";
                divebarNearbyFriendsAnalyticsLogger.f5828a.a(honeyClientEvent);
                divebarNearbyFriendsController.m5523d();
                return;
            default:
                return;
        }
    }

    private void m5523d() {
        Intent intent = new Intent();
        intent.setData(Uri.parse(StringFormatUtil.formatStrLocaleSafe(FBLinks.cQ, "divebar")));
        this.f5842e.a(intent, this.f5838a);
    }
}
