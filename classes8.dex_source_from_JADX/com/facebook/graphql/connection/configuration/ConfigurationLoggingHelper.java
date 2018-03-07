package com.facebook.graphql.connection.configuration;

import com.facebook.graphql.connection.ConnectionTailLoaderManager.RowIterator;
import com.facebook.graphql.connection.configuration.SequentialBatchConfiguration.StreamingConfiguration;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQLRefParam;
import com.facebook.quicklog.QuickPerformanceLogger;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: whitelist_unit_tap */
public class ConfigurationLoggingHelper {
    private static final AtomicInteger f235a = new AtomicInteger(0);

    private static int m214a() {
        return f235a.incrementAndGet();
    }

    public static GraphQLRequest m216a(QuickPerformanceLogger quickPerformanceLogger, Configuration configuration, TailFetchLocation tailFetchLocation) {
        int a = m214a();
        quickPerformanceLogger.e(9437185, a);
        quickPerformanceLogger.b(9437185, a, m218a(configuration));
        try {
            GraphQLRequest a2 = configuration.mo19a(tailFetchLocation);
            return a2;
        } finally {
            quickPerformanceLogger.b(9437185, a, (short) 2);
        }
    }

    public static GraphQLRequest m217a(QuickPerformanceLogger quickPerformanceLogger, StreamingConfiguration streamingConfiguration, GraphQLRefParam graphQLRefParam) {
        int a = m214a();
        quickPerformanceLogger.e(9437185, a);
        quickPerformanceLogger.b(9437185, a, m218a(streamingConfiguration));
        try {
            GraphQLRequest a2 = streamingConfiguration.m225a(graphQLRefParam);
            return a2;
        } finally {
            quickPerformanceLogger.b(9437185, a, (short) 2);
        }
    }

    public static RowIterator m215a(QuickPerformanceLogger quickPerformanceLogger, Configuration configuration, TailFetchLocation tailFetchLocation, GraphQLResult graphQLResult) {
        int a = m214a();
        quickPerformanceLogger.e(9437186, a);
        quickPerformanceLogger.b(9437186, a, m218a(configuration));
        try {
            RowIterator a2 = configuration.mo18a(tailFetchLocation, graphQLResult);
            return a2;
        } finally {
            quickPerformanceLogger.b(9437186, a, (short) 2);
        }
    }

    private static String m218a(Configuration configuration) {
        return "configuration:" + configuration.mo20a();
    }
}
