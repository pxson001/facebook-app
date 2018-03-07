package com.facebook.events.dashboard.birthdays;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.events.graphql.EventsGraphQL.FetchPagedUpcomingBirthdaysQueryString;
import com.facebook.events.graphql.EventsGraphQLModels.EventUserWithBirthdayFragmentModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchPagedUpcomingBirthdaysQueryModel;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.Nonnull;
import javax.inject.Inject;

/* compiled from: commerce/collectionview/ad/{#%s} */
public class BirthdaysPager {
    public final GraphQLQueryExecutor f16966a;
    private final TasksManager f16967b;
    private final Resources f16968c;

    /* compiled from: commerce/collectionview/ad/{#%s} */
    public interface BirthdaysPagerCallback {
        void mo788a(boolean z, String str, String str2, @Nonnull List<EventUserWithBirthdayFragmentModel> list);
    }

    public static BirthdaysPager m17292b(InjectorLike injectorLike) {
        return new BirthdaysPager(GraphQLQueryExecutor.a(injectorLike), TasksManager.b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    public static BirthdaysPager m17291a(InjectorLike injectorLike) {
        return m17292b(injectorLike);
    }

    @Inject
    public BirthdaysPager(GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager, Resources resources) {
        this.f16966a = graphQLQueryExecutor;
        this.f16967b = tasksManager;
        this.f16968c = resources;
    }

    public final boolean m17294a() {
        return this.f16967b.a("fetch_birthdays_task");
    }

    public final void m17293a(int i, final String str, String str2, GregorianCalendar gregorianCalendar, final BirthdaysPagerCallback birthdaysPagerCallback) {
        final int dimensionPixelSize = this.f16968c.getDimensionPixelSize(2131431108);
        final int i2 = i;
        final String str3 = str2;
        final GregorianCalendar gregorianCalendar2 = gregorianCalendar;
        this.f16967b.a("fetch_birthdays_task", new Callable<ListenableFuture<GraphQLResult<FetchPagedUpcomingBirthdaysQueryModel>>>(this) {
            final /* synthetic */ BirthdaysPager f16962e;

            public Object call() {
                GraphQLRequest a = GraphQLRequest.a(new FetchPagedUpcomingBirthdaysQueryString());
                BirthdaysPager birthdaysPager = this.f16962e;
                int i = dimensionPixelSize;
                int i2 = i2;
                String str = str3;
                GregorianCalendar gregorianCalendar = gregorianCalendar2;
                FetchPagedUpcomingBirthdaysQueryString fetchPagedUpcomingBirthdaysQueryString = new FetchPagedUpcomingBirthdaysQueryString();
                fetchPagedUpcomingBirthdaysQueryString.a("profile_image_size", String.valueOf(i)).a("first_count", Integer.toString(i2)).a("end_cursor", str).a("start_month", Integer.toString(gregorianCalendar.get(2) + 1)).a("start_day_of_month", Integer.toString(gregorianCalendar.get(5)));
                a.a(fetchPagedUpcomingBirthdaysQueryString.a);
                return this.f16962e.f16966a.a(a);
            }
        }, new AbstractDisposableFutureCallback<GraphQLResult<FetchPagedUpcomingBirthdaysQueryModel>>(this) {
            final /* synthetic */ BirthdaysPager f16965c;

            protected final void m17289a(Object obj) {
                FetchPagedUpcomingBirthdaysQueryModel fetchPagedUpcomingBirthdaysQueryModel = (FetchPagedUpcomingBirthdaysQueryModel) ((GraphQLResult) obj).e;
                if (birthdaysPagerCallback != null && fetchPagedUpcomingBirthdaysQueryModel != null) {
                    boolean z;
                    String str;
                    String str2 = str;
                    List a = Lists.a();
                    if (fetchPagedUpcomingBirthdaysQueryModel.a() == null || fetchPagedUpcomingBirthdaysQueryModel.a().a().isEmpty()) {
                        z = false;
                    } else {
                        ImmutableList a2 = fetchPagedUpcomingBirthdaysQueryModel.a().a();
                        int size = a2.size();
                        for (int i = 0; i < size; i++) {
                            EventUserWithBirthdayFragmentModel eventUserWithBirthdayFragmentModel = (EventUserWithBirthdayFragmentModel) a2.get(i);
                            if (Objects.equal(str2, eventUserWithBirthdayFragmentModel.m())) {
                                z = false;
                                break;
                            }
                            if (str2 == null) {
                                str2 = eventUserWithBirthdayFragmentModel.m();
                            }
                            a.add(eventUserWithBirthdayFragmentModel);
                        }
                        z = true;
                    }
                    if (fetchPagedUpcomingBirthdaysQueryModel.a() == null || fetchPagedUpcomingBirthdaysQueryModel.a().j() == null) {
                        str = null;
                    } else {
                        str = fetchPagedUpcomingBirthdaysQueryModel.a().j().a();
                    }
                    birthdaysPagerCallback.mo788a(z, str2, str, a);
                }
            }

            protected final void m17290a(Throwable th) {
            }
        });
    }
}
