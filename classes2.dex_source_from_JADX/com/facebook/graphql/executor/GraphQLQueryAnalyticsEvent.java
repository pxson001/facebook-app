package com.facebook.graphql.executor;

import com.facebook.analytics.logger.HoneyClientEvent;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: save_action */
public interface GraphQLQueryAnalyticsEvent {
    @Nullable
    HoneyClientEvent mo1460a();

    void mo1461a(long j);

    void mo1462a(GraphQLRequest graphQLRequest);

    void mo1463a(GraphQLRequest graphQLRequest, Exception exception);

    void mo1464a(Exception exception);

    void mo1465a(String str);

    void mo1466a(String str, String str2);

    void mo1467a(String str, Throwable th);

    void mo1468a(boolean z);

    void mo1469b();

    void mo1470b(String str);

    void mo1471c();

    void mo1472d();
}
