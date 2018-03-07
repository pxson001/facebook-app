package com.facebook.graphql.preference;

import android.content.Context;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import com.facebook.graphql.cursor.database.GraphCursorDatabase;
import com.facebook.graphql.executor.cache.GraphQLDiskCache;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;

/* compiled from: {sentence} */
public class GraphQLCachePreference extends Preference {
    public Lazy<GraphQLDiskCache> f42a;
    public Lazy<GraphCursorDatabase> f43b;
    public Lazy<Toaster> f44c;

    /* compiled from: {sentence} */
    public class C00041 implements OnPreferenceClickListener {
        final /* synthetic */ GraphQLCachePreference f41a;

        public C00041(GraphQLCachePreference graphQLCachePreference) {
            this.f41a = graphQLCachePreference;
        }

        public boolean onPreferenceClick(Preference preference) {
            ((GraphQLDiskCache) this.f41a.f42a.get()).c();
            ((GraphCursorDatabase) this.f41a.f43b.get()).c();
            ((Toaster) this.f41a.f44c.get()).a(new ToastBuilder("Graphql cache cleared"));
            return true;
        }
    }

    public static void m24a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        GraphQLCachePreference graphQLCachePreference = (GraphQLCachePreference) obj;
        Lazy b = IdBasedSingletonScopeProvider.b(fbInjector, 2183);
        Lazy b2 = IdBasedSingletonScopeProvider.b(fbInjector, 2154);
        Lazy a = IdBasedLazy.a(fbInjector, 3588);
        graphQLCachePreference.f42a = b;
        graphQLCachePreference.f43b = b2;
        graphQLCachePreference.f44c = a;
    }

    public GraphQLCachePreference(Context context) {
        super(context);
        Class cls = GraphQLCachePreference.class;
        m24a(this, context);
        setTitle("Clear GraphQL cache");
        setSummary("Clear the GraphQL cache on the device");
        setOnPreferenceClickListener(new C00041(this));
    }
}
