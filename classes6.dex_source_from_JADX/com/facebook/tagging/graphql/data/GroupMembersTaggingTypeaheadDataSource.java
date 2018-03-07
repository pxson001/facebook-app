package com.facebook.tagging.graphql.data;

import android.content.res.Resources;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.calls.OfTypeInputTypes;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.Assisted;
import com.facebook.tagging.data.TagTypeaheadDataSource;
import com.facebook.tagging.data.TagTypeaheadDataSource.SourceResultsListener;
import com.facebook.tagging.data.TagTypeaheadDataSource.TagTypeaheadDataType;
import com.facebook.tagging.data.TaggingProfiles;
import com.facebook.tagging.graphql.protocol.FetchGroupMembersToMentionQuery;
import com.facebook.tagging.graphql.protocol.FetchGroupMembersToMentionQuery.FetchGroupMembersToMentionQueryString;
import com.facebook.tagging.graphql.protocol.FetchGroupMembersToMentionQueryModels.FetchGroupMembersToMentionQueryModel;
import com.facebook.tagging.graphql.protocol.FetchGroupMembersToMentionQueryModels.FetchGroupMembersToMentionQueryModel.GroupMentionsModel.MemberSectionModel.EdgesModel;
import com.facebook.tagging.graphql.protocol.FetchGroupMembersToMentionQueryModels.FetchGroupMembersToMentionQueryModel.GroupMentionsModel.MemberSectionModel.EdgesModel.NodeModel;
import com.facebook.tagging.graphql.protocol.FetchGroupMembersToMentionQueryModels.FetchGroupMembersToMentionQueryModel.GroupMentionsModel.NonMemberSectionModel;
import com.facebook.tagging.graphql.protocol.FetchGroupMembersToMentionQueryModels.FetchGroupMembersToMentionQueryModel.ParentGroupModel;
import com.facebook.tagging.model.TaggingProfile.Type;
import com.facebook.user.model.Name;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.Futures;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.NotThreadSafe;
import javax.inject.Inject;

@NotThreadSafe
/* compiled from: description_tags */
public class GroupMembersTaggingTypeaheadDataSource extends TagTypeaheadDataSource {
    private final Long f17452a;
    public final TaggingProfiles f17453b;
    private final Resources f17454c;
    private final GraphQLQueryExecutor f17455d;
    private final ExecutorService f17456e;
    private final ScheduledExecutorService f17457f;
    public List<String> f17458g = new ArrayList();
    private final ContactsDbTaggingDataSource f17459h;
    public final MonotonicClock f17460i;
    public long f17461j;
    private ScheduledFuture f17462k;
    public final GroupMembersTaggingLogger f17463l;

    /* compiled from: description_tags */
    /* synthetic */ class C12733 {
        static final /* synthetic */ int[] f17451a = new int[GraphQLGroupVisibility.values().length];

        static {
            try {
                f17451a[GraphQLGroupVisibility.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f17451a[GraphQLGroupVisibility.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f17451a[GraphQLGroupVisibility.SECRET.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    @Inject
    public GroupMembersTaggingTypeaheadDataSource(@Assisted Long l, ContactsDbTaggingDataSource contactsDbTaggingDataSource, TaggingProfiles taggingProfiles, Resources resources, GraphQLQueryExecutor graphQLQueryExecutor, ExecutorService executorService, ScheduledExecutorService scheduledExecutorService, GroupMembersTaggingLogger groupMembersTaggingLogger, MonotonicClock monotonicClock) {
        this.f17452a = l;
        this.f17453b = taggingProfiles;
        this.f17459h = contactsDbTaggingDataSource;
        this.f17454c = resources;
        this.f17455d = graphQLQueryExecutor;
        this.f17456e = executorService;
        this.f17457f = scheduledExecutorService;
        this.f17463l = groupMembersTaggingLogger;
        this.f17460i = monotonicClock;
    }

    public final void mo1314a(CharSequence charSequence, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, SourceResultsListener sourceResultsListener) {
        if (charSequence != null) {
            if (this.f17460i.now() - this.f17461j < 200 && this.f17462k != null) {
                this.f17462k.cancel(true);
            }
            this.f17461j = this.f17460i.now();
            final CharSequence charSequence2 = charSequence;
            final String str2 = str;
            final boolean z6 = z;
            final boolean z7 = z2;
            final boolean z8 = z3;
            final boolean z9 = z4;
            final boolean z10 = z5;
            final SourceResultsListener sourceResultsListener2 = sourceResultsListener;
            this.f17462k = this.f17457f.schedule(new Runnable(this) {
                final /* synthetic */ GroupMembersTaggingTypeaheadDataSource f17441i;

                public void run() {
                    this.f17441i.m25256b(charSequence2, str2, z6, z7, z8, z9, z10, sourceResultsListener2);
                }
            }, 200, TimeUnit.MILLISECONDS);
        }
    }

    private void m25256b(CharSequence charSequence, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, SourceResultsListener sourceResultsListener) {
        FetchGroupMembersToMentionQueryString a = FetchGroupMembersToMentionQuery.m25264a();
        a.a("target_id", this.f17452a).b("query_string", charSequence).a("size", Integer.valueOf(this.f17454c.getDimensionPixelSize(2131429507))).a("entity_type", OfTypeInputTypes.USER).a("first", Integer.valueOf(5));
        final String str2 = str;
        final CharSequence charSequence2 = charSequence;
        final SourceResultsListener sourceResultsListener2 = sourceResultsListener;
        final boolean z6 = z;
        final boolean z7 = z2;
        final boolean z8 = z3;
        final boolean z9 = z4;
        final boolean z10 = z5;
        Futures.a(this.f17455d.a(GraphQLRequest.a(a).a(GraphQLCachePolicy.c)), new AbstractDisposableFutureCallback<GraphQLResult<FetchGroupMembersToMentionQueryModel>>(this) {
            final /* synthetic */ GroupMembersTaggingTypeaheadDataSource f17450i;

            protected final void m25249a(Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                this.f17450i.f17463l.m25248a(StringUtil.a(str2), this.f17450i.f17460i.now() - this.f17450i.f17461j, charSequence2.toString(), false);
                Collection arrayList = new ArrayList();
                if (graphQLResult == null || graphQLResult.e == null) {
                    sourceResultsListener2.mo1121a(charSequence2, ImmutableList.copyOf(arrayList));
                    return;
                }
                GraphQLGroupVisibility k = ((FetchGroupMembersToMentionQueryModel) graphQLResult.e).m25326k();
                ParentGroupModel j = ((FetchGroupMembersToMentionQueryModel) graphQLResult.e).m25325j();
                ImmutableList<EdgesModel> a = ((FetchGroupMembersToMentionQueryModel) graphQLResult.e).m25322a().m25308a().m25285a();
                String tagTypeaheadDataType = GroupMembersTaggingTypeaheadDataSource.m25255b(k, j).toString();
                for (EdgesModel edgesModel : a) {
                    if (!(edgesModel == null || edgesModel.m25281a() == null)) {
                        if (!this.f17450i.f17458g.contains(tagTypeaheadDataType)) {
                            this.f17450i.f17458g.add(tagTypeaheadDataType);
                        }
                        NodeModel a2 = edgesModel.m25281a();
                        arrayList.add(this.f17450i.f17453b.m25206a(new Name(null, null, a2.m25276k()), Long.parseLong(a2.m25275j()), a2.m25277l().b(), Type.USER, "group_members", tagTypeaheadDataType));
                    }
                }
                ImmutableList a3 = ((FetchGroupMembersToMentionQueryModel) graphQLResult.e).m25322a().m25309j().m25304a();
                tagTypeaheadDataType = GroupMembersTaggingTypeaheadDataSource.m25254b(k).toString();
                int size = a3.size();
                for (int i = 0; i < size; i++) {
                    NonMemberSectionModel.EdgesModel edgesModel2 = (NonMemberSectionModel.EdgesModel) a3.get(i);
                    if (!(edgesModel2 == null || edgesModel2.m25300a() == null)) {
                        if (!this.f17450i.f17458g.contains(tagTypeaheadDataType)) {
                            this.f17450i.f17458g.add(tagTypeaheadDataType);
                        }
                        NonMemberSectionModel.EdgesModel.NodeModel a4 = edgesModel2.m25300a();
                        arrayList.add(this.f17450i.f17453b.m25206a(new Name(null, null, a4.m25295k()), Long.parseLong(a4.m25294j()), a4.m25296l().b(), Type.USER, "non_group_members", tagTypeaheadDataType));
                    }
                }
                sourceResultsListener2.mo1121a(charSequence2, arrayList);
            }

            protected final void m25250a(Throwable th) {
                BLog.b("fetch_group_members_to_mentions", "Fail to load group members for mentions ");
                this.f17450i.f17463l.m25248a(StringUtil.a(str2), this.f17450i.f17460i.now() - this.f17450i.f17461j, charSequence2.toString(), true);
                this.f17450i.m25253a(charSequence2, z6, z7, z8, z9, z10, sourceResultsListener2);
            }
        }, this.f17456e);
    }

    private void m25253a(CharSequence charSequence, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, SourceResultsListener sourceResultsListener) {
        List a = this.f17459h.mo1318a(charSequence, z, z2, z3, z4);
        this.f17458g.addAll(this.f17459h.mo1319d());
        sourceResultsListener.mo1121a(charSequence, a);
    }

    public static TagTypeaheadDataType m25254b(GraphQLGroupVisibility graphQLGroupVisibility) {
        switch (C12733.f17451a[graphQLGroupVisibility.ordinal()]) {
            case 1:
                return TagTypeaheadDataType.NOT_NOTIFIED_OTHERS;
            case 2:
                return TagTypeaheadDataType.NOT_NOTIFIED_AND_UNSEEN_OTHERS;
            case 3:
                return TagTypeaheadDataType.NOT_NOTIFIED_AND_UNSEEN_OTHERS;
            default:
                return TagTypeaheadDataType.OTHERS;
        }
    }

    public static TagTypeaheadDataType m25255b(GraphQLGroupVisibility graphQLGroupVisibility, ParentGroupModel parentGroupModel) {
        Object obj = parentGroupModel != null ? 1 : null;
        switch (C12733.f17451a[graphQLGroupVisibility.ordinal()]) {
            case 1:
                return obj != null ? TagTypeaheadDataType.OPEN_GROUP_MEMBERS : TagTypeaheadDataType.PUBLIC_GROUP_MEMBERS;
            case 2:
                return TagTypeaheadDataType.CLOSE_GROUP_MEMBERS;
            case 3:
                return TagTypeaheadDataType.SECRET_GROUP_MEMBERS;
            default:
                return TagTypeaheadDataType.OTHERS;
        }
    }

    public final ImmutableList<String> mo1319d() {
        Builder builder = new Builder();
        builder.b(this.f17458g);
        return builder.b();
    }

    public final String mo1316b() {
        return "group_members";
    }

    public final String mo1322e() {
        return String.valueOf(this.f17452a);
    }

    public final boolean mo1315a() {
        return true;
    }
}
