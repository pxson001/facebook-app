package com.facebook.messaging.inbox2.data.omnistore;

import android.content.res.Resources;
import com.facebook.androidcompat.AndroidCompat;
import com.facebook.auth.module.User_LoggedInUserMethodAutoProvider;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.inbox2.data.common.InboxUnit;
import com.facebook.messaging.inbox2.data.common.InboxUnitFetcher;
import com.facebook.messaging.inbox2.data.common.InboxUnitFetcherHelper;
import com.facebook.messaging.inbox2.data.common.InboxUnitParams;
import com.facebook.messaging.inbox2.data.common.InboxUnitResult;
import com.facebook.messaging.inbox2.data.common.InboxUnitSnapshot;
import com.facebook.messaging.inbox2.data.common.InboxUnitsToFetch;
import com.facebook.messaging.inbox2.data.loader.InboxUnitManager.C04551;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel;
import com.facebook.messaging.inbox2.items.InboxUnitItem;
import com.facebook.omnistore.Collection;
import com.facebook.omnistore.Collection.SortDirection;
import com.facebook.omnistore.CollectionName;
import com.facebook.omnistore.Cursor;
import com.facebook.omnistore.Omnistore;
import com.facebook.omnistore.SubscriptionParams;
import com.facebook.omnistore.module.OmnistoreMethodAutoProvider;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.user.model.User;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.EnumSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

@UserScoped
/* compiled from: server returned failure */
public class InboxUnitFetcherWithOmnistore implements InboxUnitFetcher {
    private static final Class<?> f2790a = InboxUnitFetcherWithOmnistore.class;
    private static final Object f2791i = new Object();
    private final Omnistore f2792b;
    private final ListeningExecutorService f2793c;
    private final User f2794d;
    private final Resources f2795e;
    private final Clock f2796f;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<InboxUnitFetcherHelper> f2797g = UltralightRuntime.b;
    private Collection f2798h;

    /* compiled from: server returned failure */
    class C04591 implements Callable<InboxUnitResult> {
        final /* synthetic */ InboxUnitFetcherWithOmnistore f2787a;

        C04591(InboxUnitFetcherWithOmnistore inboxUnitFetcherWithOmnistore) {
            this.f2787a = inboxUnitFetcherWithOmnistore;
        }

        public Object call() {
            return InboxUnitFetcherWithOmnistore.m2742a(this.f2787a, ((InboxUnitFetcherHelper) this.f2787a.f2797g.get()).m2711a());
        }
    }

    /* compiled from: server returned failure */
    class InboxUnitResultWithOmnistore implements InboxUnitResult {
        final /* synthetic */ InboxUnitFetcherWithOmnistore f2788a;
        private final InboxUnitSnapshot f2789b;

        public InboxUnitResultWithOmnistore(InboxUnitFetcherWithOmnistore inboxUnitFetcherWithOmnistore, InboxUnitSnapshot inboxUnitSnapshot) {
            this.f2788a = inboxUnitFetcherWithOmnistore;
            this.f2789b = inboxUnitSnapshot;
        }

        public final InboxUnitSnapshot mo75a() {
            return this.f2789b;
        }

        public final void mo76a(C04551 c04551) {
        }
    }

    private static InboxUnitFetcherWithOmnistore m2746b(InjectorLike injectorLike) {
        InboxUnitFetcherWithOmnistore inboxUnitFetcherWithOmnistore = new InboxUnitFetcherWithOmnistore(OmnistoreMethodAutoProvider.getInstance__com_facebook_omnistore_Omnistore__INJECTED_BY_TemplateInjector(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), User_LoggedInUserMethodAutoProvider.b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
        inboxUnitFetcherWithOmnistore.f2797g = IdBasedLazy.a(injectorLike, 7878);
        return inboxUnitFetcherWithOmnistore;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.inbox2.data.omnistore.InboxUnitFetcherWithOmnistore m2743a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f2791i;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m2746b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f2791i;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.inbox2.data.omnistore.InboxUnitFetcherWithOmnistore) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.inbox2.data.omnistore.InboxUnitFetcherWithOmnistore) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f2791i;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.inbox2.data.omnistore.InboxUnitFetcherWithOmnistore) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.inbox2.data.omnistore.InboxUnitFetcherWithOmnistore.a(com.facebook.inject.InjectorLike):com.facebook.messaging.inbox2.data.omnistore.InboxUnitFetcherWithOmnistore");
    }

    @Inject
    private InboxUnitFetcherWithOmnistore(Omnistore omnistore, ListeningExecutorService listeningExecutorService, User user, Resources resources, Clock clock) {
        this.f2792b = omnistore;
        this.f2793c = listeningExecutorService;
        this.f2794d = user;
        this.f2795e = resources;
        this.f2796f = clock;
    }

    public final EnumSet<InboxUnitsToFetch> mo78a() {
        return EnumSet.of(InboxUnitsToFetch.ALL);
    }

    public final boolean mo81b() {
        throw new IllegalStateException();
    }

    public final ListenableFuture<InboxUnitResult> mo77a(InboxUnitParams inboxUnitParams) {
        Preconditions.checkArgument(mo78a().contains(inboxUnitParams.f2753b));
        return this.f2793c.a(new C04591(this));
    }

    public static InboxUnitResult m2742a(InboxUnitFetcherWithOmnistore inboxUnitFetcherWithOmnistore, Map map) {
        Throwable th;
        Throwable th2;
        try {
            Cursor query = inboxUnitFetcherWithOmnistore.m2747b(map).query("", 25, SortDirection.ASCENDING);
            try {
                Builder builder = ImmutableList.builder();
                while (query.step()) {
                    InboxUnit a = ((InboxUnitFetcherHelper) inboxUnitFetcherWithOmnistore.f2797g.get()).m2709a((NodesModel) MutableFlatBuffer.a(m2745a(query.getBlob()), NodesModel.class, null));
                    if (a != null) {
                        builder.c(a);
                    }
                }
                InboxUnitResult inboxUnitResultWithOmnistore = new InboxUnitResultWithOmnistore(inboxUnitFetcherWithOmnistore, new InboxUnitSnapshot(DataFreshnessResult.FROM_CACHE_UP_TO_DATE, InboxUnitsToFetch.ALL, inboxUnitFetcherWithOmnistore.f2796f.a(), builder.b()));
                if (query != null) {
                    query.close();
                }
                return inboxUnitResultWithOmnistore;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                th3 = th2;
                th2 = th4;
            }
            if (query != null) {
                if (th3 != null) {
                    try {
                        query.close();
                    } catch (Throwable th5) {
                        AndroidCompat.addSuppressed(th3, th5);
                    }
                } else {
                    query.close();
                }
            }
            throw th2;
            throw th2;
        } catch (IOException e) {
            th2 = e;
            BLog.b(f2790a, th2, "Failed to read inbox2 from generated omnistore collection", new Object[0]);
            throw th2;
        } catch (JSONException e2) {
            th2 = e2;
            BLog.b(f2790a, th2, "Failed to read inbox2 from generated omnistore collection", new Object[0]);
            throw th2;
        }
    }

    private static ByteBuffer m2745a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.capacity());
        allocate.put(byteBuffer);
        allocate.flip();
        return allocate;
    }

    private Collection m2747b(Map<String, ?> map) {
        if (this.f2798h != null) {
            return this.f2798h;
        }
        String a = m2744a("InboxV2Query_MessengerInboxUnits_Nodes.fbs");
        String a2 = m2744a("InboxV2Query_MessengerInboxUnits_Nodes.fbs.md5");
        JSONObject jSONObject = new JSONObject(m2744a("InboxV2Query_MessengerInboxUnits_Nodes.params.json"));
        JSONObject jSONObject2 = new JSONObject();
        jSONObject.put("render_object_list_query_params", jSONObject2);
        for (Entry entry : map.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof Boolean) {
                jSONObject2.put((String) entry.getKey(), Boolean.toString(((Boolean) value).booleanValue()));
            } else {
                jSONObject2.put((String) entry.getKey(), value);
            }
        }
        jSONObject.put("render_object_list_query_id", Long.parseLong(jSONObject.getString("render_object_list_query_id")));
        Omnistore omnistore = this.f2792b;
        CollectionName build = this.f2792b.createCollectionNameBuilder("messenger_inbox2_android").addSegment(this.f2794d.U.a()).addDeviceId().addSegment(a2).build();
        SubscriptionParams.Builder builder = new SubscriptionParams.Builder();
        builder.mCollectionParams = jSONObject.toString();
        builder = builder;
        builder.mIdl = a;
        this.f2798h = omnistore.subscribeCollection(build, builder.build());
        return this.f2798h;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m2744a(java.lang.String r4) {
        /*
        r3 = this;
        r2 = new java.io.InputStreamReader;
        r0 = r3.f2795e;
        r0 = r0.getAssets();
        r0 = r0.open(r4);
        r2.<init>(r0);
        r1 = 0;
        r0 = com.google.common.io.CharStreams.a(r2);	 Catch:{ Throwable -> 0x0018 }
        r2.close();
        return r0;
    L_0x0018:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x001a }
    L_0x001a:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0026;
    L_0x001d:
        r2.close();	 Catch:{ Throwable -> 0x0021 }
    L_0x0020:
        throw r0;
    L_0x0021:
        r2 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r1, r2);
        goto L_0x0020;
    L_0x0026:
        r2.close();
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.inbox2.data.omnistore.InboxUnitFetcherWithOmnistore.a(java.lang.String):java.lang.String");
    }

    public final void mo80a(InboxUnitItem inboxUnitItem) {
    }

    public final void mo79a(NodesModel nodesModel) {
    }
}
