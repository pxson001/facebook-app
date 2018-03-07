package com.facebook.events.notificationsettings;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.facebook.events.notificationsettings.protocol.EventsNotificationSettingsGraphQLModels.FetchEventsNotificationSubscriptionLevelsModel.PossibleNotificationSubscriptionLevelsModel.EdgesModel;
import com.facebook.events.notificationsettings.protocol.EventsNotificationSettingsGraphQLModels.FetchEventsNotificationSubscriptionLevelsModel.PossibleNotificationSubscriptionLevelsModel.EdgesModel.NodeModel;
import com.facebook.events.notificationsettings.protocol.EventsNotificationSettingsMutations.EventUpdateNotificationSubscriptionLevelMutationString;
import com.facebook.events.notificationsettings.protocol.EventsNotificationSettingsMutationsModels.EventUpdateNotificationSubscriptionLevelMutationModel.EventModel;
import com.facebook.events.notificationsettings.protocol.EventsNotificationSettingsMutationsModels.EventUpdateNotificationSubscriptionLevelMutationModel.EventModel.Builder;
import com.facebook.fbui.widget.contentview.CheckedContentView;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.calls.EventUpdateNotificationSubscriptionLevelInputData;
import com.facebook.graphql.calls.EventUpdateNotificationSubscriptionLevelInputData.Level;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.enums.GraphQLEventNotificationSubscriptionLevel;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.request.MutationRequest;
import com.facebook.inject.Assisted;
import com.google.common.base.Objects;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

/* compiled from: cause */
public class EventsNotificationSettingsAdapter extends Adapter<EventsNotificationSettingViewHolder> {
    public List<EdgesModel> f17798a = Collections.emptyList();
    public GraphQLEventNotificationSubscriptionLevel f17799b;
    private C25191 f17800c;
    public String f17801d;
    public GraphQLQueryExecutor f17802e;

    /* compiled from: cause */
    public class C25191 {
        final /* synthetic */ EventsNotificationSettingsAdapter f17796a;

        public C25191(EventsNotificationSettingsAdapter eventsNotificationSettingsAdapter) {
            this.f17796a = eventsNotificationSettingsAdapter;
        }

        public final void m18147a(GraphQLEventNotificationSubscriptionLevel graphQLEventNotificationSubscriptionLevel) {
            if (this.f17796a.f17799b != graphQLEventNotificationSubscriptionLevel) {
                Builder builder = new Builder();
                builder.f17828a = this.f17796a.f17801d;
                builder = builder;
                builder.f17829b = graphQLEventNotificationSubscriptionLevel;
                Builder builder2 = builder;
                EventUpdateNotificationSubscriptionLevelInputData eventUpdateNotificationSubscriptionLevelInputData = new EventUpdateNotificationSubscriptionLevelInputData();
                eventUpdateNotificationSubscriptionLevelInputData.a("event_id", this.f17796a.f17801d);
                GraphQlCallInput graphQlCallInput = eventUpdateNotificationSubscriptionLevelInputData;
                graphQlCallInput.a("level", EventsNotificationSettingsAdapter.m18148c(graphQLEventNotificationSubscriptionLevel));
                MutationRequest a = GraphQLRequest.a((EventUpdateNotificationSubscriptionLevelMutationString) new EventUpdateNotificationSubscriptionLevelMutationString().a("input", graphQlCallInput));
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder2.f17828a);
                int a2 = flatBufferBuilder.a(builder2.f17829b);
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                this.f17796a.f17802e.a(a.a(new EventModel(new MutableFlatBuffer(wrap, null, null, true, null))));
            }
        }
    }

    /* compiled from: cause */
    /* synthetic */ class C25202 {
        static final /* synthetic */ int[] f17797a = new int[GraphQLEventNotificationSubscriptionLevel.values().length];

        static {
            try {
                f17797a[GraphQLEventNotificationSubscriptionLevel.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f17797a[GraphQLEventNotificationSubscriptionLevel.MOST_IMPORTANT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f17797a[GraphQLEventNotificationSubscriptionLevel.HOST_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f17797a[GraphQLEventNotificationSubscriptionLevel.UNSUBSCRIBED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public final void m18150a(ViewHolder viewHolder, int i) {
        EventsNotificationSettingViewHolder eventsNotificationSettingViewHolder = (EventsNotificationSettingViewHolder) viewHolder;
        NodeModel a = ((EdgesModel) this.f17798a.get(i)).m18173a();
        GraphQLEventNotificationSubscriptionLevel graphQLEventNotificationSubscriptionLevel = this.f17799b;
        C25191 c25191 = this.f17800c;
        eventsNotificationSettingViewHolder.f17793m = a;
        eventsNotificationSettingViewHolder.f17794n = c25191;
        if (a == null) {
            eventsNotificationSettingViewHolder.f17792l.setVisibility(8);
            eventsNotificationSettingViewHolder.f17792l.setOnClickListener(null);
            return;
        }
        CharSequence j = a.m18169j();
        CharSequence a2 = a.m18168a();
        eventsNotificationSettingViewHolder.f17792l.setVisibility(0);
        eventsNotificationSettingViewHolder.f17792l.setTitleText(j);
        eventsNotificationSettingViewHolder.f17792l.setSubtitleText(a2);
        eventsNotificationSettingViewHolder.f17792l.setChecked(Objects.equal(graphQLEventNotificationSubscriptionLevel, a.m18170k()));
        eventsNotificationSettingViewHolder.f17792l.setOnClickListener(eventsNotificationSettingViewHolder.f17795o);
    }

    @Inject
    public EventsNotificationSettingsAdapter(@Assisted String str, GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f17801d = str;
        this.f17802e = graphQLQueryExecutor;
    }

    public final ViewHolder m18149a(ViewGroup viewGroup, int i) {
        CheckedContentView checkedContentView = (CheckedContentView) LayoutInflater.from(viewGroup.getContext()).inflate(2130904163, viewGroup, false);
        this.f17800c = new C25191(this);
        return new EventsNotificationSettingViewHolder(checkedContentView);
    }

    public final int aZ_() {
        return this.f17798a.size();
    }

    public static Level m18148c(GraphQLEventNotificationSubscriptionLevel graphQLEventNotificationSubscriptionLevel) {
        switch (C25202.f17797a[graphQLEventNotificationSubscriptionLevel.ordinal()]) {
            case 1:
                return Level.ALL;
            case 2:
                return Level.MOST_IMPORTANT;
            case 3:
                return Level.HOST_ONLY;
            case 4:
                return Level.UNSUBSCRIBED;
            default:
                throw new IllegalArgumentException("Unsupported notification subscription level: " + graphQLEventNotificationSubscriptionLevel);
        }
    }
}
