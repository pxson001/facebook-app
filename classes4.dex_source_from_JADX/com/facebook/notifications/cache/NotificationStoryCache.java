package com.facebook.notifications.cache;

import android.database.Cursor;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.ipc.notifications.GraphQLNotificationsContract.GraphQLNotificationsTable.Columns;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel.Builder;
import com.facebook.notifications.util.NotificationsMutator;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: mobile2 */
public class NotificationStoryCache extends BaseSyndicatedListenableCache<String, FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields> {
    protected final Object mo618a(Object obj) {
        FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields = (FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields) obj;
        Preconditions.checkNotNull(fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields);
        return fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo822k().g();
    }

    public NotificationStoryCache(DefaultAndroidThreadUtil defaultAndroidThreadUtil, String str, String str2, MemoryTrimmableRegistry memoryTrimmableRegistry, AbstractFbErrorReporter abstractFbErrorReporter) {
        super(new NotificationStoryCreationTimeComparator(), defaultAndroidThreadUtil, str, str2, memoryTrimmableRegistry, abstractFbErrorReporter);
    }

    @Nullable
    public final FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields m7933a(Cursor cursor) {
        Preconditions.checkNotNull(cursor, "Can't query cache with null cursor");
        FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields = (FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields) m7957d(cursor.getString(Columns.f7592f.a(cursor)));
        if (fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields == null) {
            return null;
        }
        int a = Columns.f7590d.a(cursor);
        int a2 = Columns.f7591e.a(cursor);
        int a3 = Columns.f7604r.a(cursor);
        GraphQLStory a4 = NotificationsMutator.a(fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo822k(), GraphQLStorySeenState.valueOf(cursor.getString(a)), cursor.getLong(a2));
        PropertyHelper.a(a4, cursor.getInt(a3));
        String string = cursor.getString(Columns.f7593g.a(cursor));
        Builder a5 = Builder.a(FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel.m11248a(fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields));
        a5.j = a4;
        a5 = a5;
        a5.a = string;
        return a5.a();
    }

    public final synchronized boolean m7936a(String str, GraphQLStorySeenState graphQLStorySeenState) {
        boolean z;
        FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields = (FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields) m7957d(str);
        if (fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields == null) {
            z = false;
        } else {
            m7954b(NotificationsMutator.a(fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, graphQLStorySeenState));
            z = true;
        }
        return z;
    }

    public final synchronized boolean m7937a(String str, ReactionUnitFragment reactionUnitFragment) {
        boolean z;
        FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields = (FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields) m7957d(str);
        if (fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields == null) {
            z = false;
        } else {
            m7954b(NotificationsMutator.a(fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, reactionUnitFragment));
            z = true;
        }
        return z;
    }

    public final synchronized boolean m7939a(String str, boolean z) {
        boolean z2;
        FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields = (FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields) m7957d(str);
        if (fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields == null) {
            z2 = false;
        } else {
            m7954b(NotificationsMutator.a(fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, z));
            z2 = true;
        }
        return z2;
    }

    public final synchronized void m7935a(Iterable<String> iterable, int i) {
        for (String a : iterable) {
            m7932a(a, i);
        }
    }

    private synchronized boolean m7932a(String str, int i) {
        boolean z;
        FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields = (FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields) m7957d(str);
        if (fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields == null) {
            z = false;
        } else {
            m7954b(NotificationsMutator.a(fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, i));
            z = true;
        }
        return z;
    }

    public final synchronized boolean m7938a(String str, String str2) {
        boolean z;
        FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields = (FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields) m7957d(str);
        if (fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields == null) {
            z = false;
        } else {
            fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields = NotificationsMutator.a(fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, str2);
            if (fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields != null) {
                m7954b(fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields);
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }
}
