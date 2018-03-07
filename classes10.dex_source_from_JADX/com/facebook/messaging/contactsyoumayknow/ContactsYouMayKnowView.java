package com.facebook.messaging.contactsyoumayknow;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.graphql.calls.CymkSuggestionContactAddInputData;
import com.facebook.graphql.calls.CymkSuggestionContactAddInputData.SuggestionSurface;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.contacts.picker.ContactPickerViewIndexableListAdapter.C03392;
import com.facebook.messaging.contactsyoumayknow.ContactsYouMayKnowLogger.ContactYouMayKnowViewImpression;
import com.facebook.messaging.contactsyoumayknow.ContactsYouMayKnowMutationHandler.C03561;
import com.facebook.messaging.contactsyoumayknow.graphql.ContactsYouMayKnowMutations.AddCYMKSuggestionString;
import com.facebook.offlinemode.common.OfflineQueryBehavior;
import com.facebook.ui.errordialog.ErrorDialogs;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.recyclerview.BetterLinearLayoutManager;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: switch_to_dbl */
public class ContactsYouMayKnowView extends CustomFrameLayout {
    @Inject
    public ContactsYouMayKnowAdapter f2150a;
    @Inject
    public ContactsYouMayKnowLogger f2151b;
    @Inject
    public ContactsYouMayKnowCache f2152c;
    @Inject
    public Lazy<ContactsYouMayKnowMutationHandler> f2153d;
    @Inject
    @ForUiThread
    public Executor f2154e;
    @Inject
    Lazy<ErrorDialogs> f2155f;
    @Inject
    public Lazy<ContactsYouMayKnowNoticeHelper> f2156g;
    private BetterRecyclerView f2157h;
    private BetterLinearLayoutManager f2158i;
    public int f2159j = 0;
    private final Set<String> f2160k = new HashSet();
    @Nullable
    private ContactsYouMayKnowData f2161l;
    @Nullable
    private C03392 f2162m;

    /* compiled from: switch_to_dbl */
    class C03612 extends OnScrollListener {
        final /* synthetic */ ContactsYouMayKnowView f2144a;

        C03612(ContactsYouMayKnowView contactsYouMayKnowView) {
            this.f2144a = contactsYouMayKnowView;
        }

        public final void m1941a(RecyclerView recyclerView, int i) {
            super.a(recyclerView, i);
            this.f2144a.f2159j = i;
            ContactsYouMayKnowView.m1945b(this.f2144a);
        }
    }

    /* compiled from: switch_to_dbl */
    public class C03633 {
        public final /* synthetic */ ContactsYouMayKnowView f2147a;

        /* compiled from: switch_to_dbl */
        public class C03621 implements FutureCallback<Void> {
            final /* synthetic */ ContactSuggestion f2145a;
            final /* synthetic */ C03633 f2146b;

            public C03621(C03633 c03633, ContactSuggestion contactSuggestion) {
                this.f2146b = c03633;
                this.f2145a = contactSuggestion;
            }

            public void onSuccess(@Nullable Object obj) {
                ContactsYouMayKnowView contactsYouMayKnowView = this.f2146b.f2147a;
                ContactSuggestion contactSuggestion = this.f2145a;
                ContactsYouMayKnowMutationHandler contactsYouMayKnowMutationHandler = (ContactsYouMayKnowMutationHandler) contactsYouMayKnowView.f2153d.get();
                GraphQlQueryString addCYMKSuggestionString = new AddCYMKSuggestionString();
                CymkSuggestionContactAddInputData cymkSuggestionContactAddInputData = new CymkSuggestionContactAddInputData();
                cymkSuggestionContactAddInputData.a("suggestion_id", contactSuggestion.f2078a.a);
                GraphQlCallInput graphQlCallInput = cymkSuggestionContactAddInputData;
                graphQlCallInput.a("suggestion_surface", SuggestionSurface.PEOPLE_TAB);
                addCYMKSuggestionString.a("input", graphQlCallInput).a("small_img_size", Integer.valueOf(GraphQlQueryDefaults.b())).a("big_img_size", Integer.valueOf(GraphQlQueryDefaults.c())).a("huge_img_size", Integer.valueOf(GraphQlQueryDefaults.d()));
                ListenableFuture a = contactsYouMayKnowMutationHandler.f2128b.a(GraphQLRequest.a(addCYMKSuggestionString), OfflineQueryBehavior.a);
                SettableFuture f = SettableFuture.f();
                Futures.a(a, new C03561(contactsYouMayKnowMutationHandler, f), contactsYouMayKnowMutationHandler.f2130d);
                Futures.a(f, new C03644(contactsYouMayKnowView, contactSuggestion), contactsYouMayKnowView.f2154e);
            }

            public void onFailure(Throwable th) {
                this.f2146b.f2147a.f2150a.m1905c(this.f2145a);
            }
        }

        C03633(ContactsYouMayKnowView contactsYouMayKnowView) {
            this.f2147a = contactsYouMayKnowView;
        }
    }

    /* compiled from: switch_to_dbl */
    public class C03644 implements FutureCallback<Void> {
        final /* synthetic */ ContactSuggestion f2148a;
        final /* synthetic */ ContactsYouMayKnowView f2149b;

        public C03644(ContactsYouMayKnowView contactsYouMayKnowView, ContactSuggestion contactSuggestion) {
            this.f2149b = contactsYouMayKnowView;
            this.f2148a = contactSuggestion;
        }

        public void onSuccess(@Nullable Object obj) {
            this.f2149b.f2152c.m1911b(this.f2148a.f2078a.a);
            ContactsYouMayKnowAdapter contactsYouMayKnowAdapter = this.f2149b.f2150a;
            ContactSuggestion contactSuggestion = this.f2148a;
            int size = contactsYouMayKnowAdapter.f2083c.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                if (Objects.equal(((ContactSuggestion) contactsYouMayKnowAdapter.f2083c.get(i2)).f2078a.a, contactSuggestion.f2078a.a)) {
                    contactsYouMayKnowAdapter.f2085e.add(contactSuggestion.f2078a.a);
                    contactsYouMayKnowAdapter.f2086f.remove(contactSuggestion.f2078a.a);
                    contactsYouMayKnowAdapter.j_(i);
                    return;
                }
                i++;
            }
        }

        public void onFailure(Throwable th) {
            this.f2149b.f2150a.m1905c(this.f2148a);
            ((ErrorDialogs) this.f2149b.f2155f.get()).a(((ErrorDialogs) this.f2149b.f2155f.get()).a(ServiceException.a(th)));
        }
    }

    public static void m1944a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((ContactsYouMayKnowView) obj).m1943a(new ContactsYouMayKnowAdapter(LayoutInflaterMethodAutoProvider.b(injectorLike)), ContactsYouMayKnowLogger.m1934b(injectorLike), ContactsYouMayKnowCache.m1906a(injectorLike), IdBasedLazy.a(injectorLike, 7772), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), IdBasedLazy.a(injectorLike, 3559), IdBasedLazy.a(injectorLike, 7773));
    }

    public ContactsYouMayKnowView(Context context) {
        super(context);
        m1942a();
    }

    private void m1942a() {
        Class cls = ContactsYouMayKnowView.class;
        m1944a(this, getContext());
        setContentView(2130903781);
        this.f2157h = (BetterRecyclerView) c(2131560745);
        final int dimensionPixelSize = getResources().getDimensionPixelSize(2131433812);
        final int dimensionPixelSize2 = getResources().getDimensionPixelSize(2131433813);
        this.f2158i = new BetterLinearLayoutManager(getContext());
        this.f2158i.b(0);
        this.f2157h.a(new ItemDecoration(this) {
            final /* synthetic */ ContactsYouMayKnowView f2143c;

            public final void m1940a(Rect rect, View view, RecyclerView recyclerView, State state) {
                int d = RecyclerView.d(view);
                rect.set(d == 0 ? dimensionPixelSize2 : dimensionPixelSize, rect.top, d == state.e() + -1 ? dimensionPixelSize2 : dimensionPixelSize, rect.bottom);
            }
        });
        this.f2157h.setLayoutManager(this.f2158i);
        this.f2157h.d.g = false;
        this.f2157h.setAdapter(this.f2150a);
        this.f2157h.setOnScrollListener(new C03612(this));
        this.f2150a.f2084d = new C03633(this);
        setData(this.f2152c.f2091a);
    }

    public void setListener(C03392 c03392) {
        this.f2162m = c03392;
        ContactsYouMayKnowData contactsYouMayKnowData = this.f2152c.f2091a;
        Preconditions.checkState(contactsYouMayKnowData != null);
        if (this.f2161l == null || ((this.f2161l != contactsYouMayKnowData && this.f2161l.f2095b < contactsYouMayKnowData.f2095b) || this.f2152c.m1912c())) {
            setData(contactsYouMayKnowData);
            this.f2152c.m1910a(false);
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        m1945b(this);
    }

    private void setData(ContactsYouMayKnowData contactsYouMayKnowData) {
        this.f2161l = contactsYouMayKnowData;
        ContactsYouMayKnowAdapter contactsYouMayKnowAdapter = this.f2150a;
        if (contactsYouMayKnowAdapter.f2082b != contactsYouMayKnowData) {
            contactsYouMayKnowAdapter.f2082b = contactsYouMayKnowData;
            contactsYouMayKnowAdapter.f2083c = contactsYouMayKnowAdapter.f2082b.f2094a;
            contactsYouMayKnowAdapter.f2085e = new HashSet();
            contactsYouMayKnowAdapter.f2086f = new HashSet();
            contactsYouMayKnowAdapter.notifyDataSetChanged();
        }
        ContactsYouMayKnowLogger contactsYouMayKnowLogger = this.f2151b;
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        ImmutableList immutableList = contactsYouMayKnowData.f2094a;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ContactSuggestion contactSuggestion = (ContactSuggestion) immutableList.get(i);
            ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
            objectNode.a("id", contactSuggestion.f2078a.a);
            objectNode.a("type", "top");
            arrayNode.a(objectNode);
        }
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("cymk_view_loaded");
        honeyClientEvent.c = "contacts_you_may_know_people";
        contactsYouMayKnowLogger.f2123a.a(honeyClientEvent.a("impression_units", arrayNode));
    }

    public static void m1945b(ContactsYouMayKnowView contactsYouMayKnowView) {
        if (contactsYouMayKnowView.f2159j == 0 && contactsYouMayKnowView.f2161l != null) {
            int m = contactsYouMayKnowView.f2158i.m();
            int o = contactsYouMayKnowView.f2158i.o();
            if (m >= 0 && o < contactsYouMayKnowView.f2161l.f2094a.size() && m <= o) {
                List list = null;
                for (int i = m; i <= o; i++) {
                    ContactSuggestion contactSuggestion = (ContactSuggestion) contactsYouMayKnowView.f2161l.f2094a.get(i);
                    if (!contactsYouMayKnowView.f2160k.contains(contactSuggestion.f2078a.a)) {
                        if (r1 == null) {
                            list = new ArrayList();
                        }
                        list.add(new ContactYouMayKnowViewImpression(contactSuggestion, i));
                        contactsYouMayKnowView.f2160k.add(contactSuggestion.f2078a.a);
                    }
                }
                if (r1 != null) {
                    ContactsYouMayKnowLogger contactsYouMayKnowLogger = contactsYouMayKnowView.f2151b;
                    ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
                    for (ContactYouMayKnowViewImpression contactYouMayKnowViewImpression : r1) {
                        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
                        objectNode.a("id", contactYouMayKnowViewImpression.f2121a.f2078a.a);
                        objectNode.a("type", "top");
                        objectNode.a("pos", contactYouMayKnowViewImpression.f2122b);
                        arrayNode.a(objectNode);
                    }
                    HoneyClientEvent honeyClientEvent = new HoneyClientEvent("cymk_view_impression");
                    honeyClientEvent.c = "contacts_you_may_know_people";
                    contactsYouMayKnowLogger.f2123a.a(honeyClientEvent.a("impression_units", arrayNode));
                }
            }
        }
    }

    private void m1943a(ContactsYouMayKnowAdapter contactsYouMayKnowAdapter, ContactsYouMayKnowLogger contactsYouMayKnowLogger, ContactsYouMayKnowCache contactsYouMayKnowCache, Lazy<ContactsYouMayKnowMutationHandler> lazy, Executor executor, Lazy<ErrorDialogs> lazy2, Lazy<ContactsYouMayKnowNoticeHelper> lazy3) {
        this.f2150a = contactsYouMayKnowAdapter;
        this.f2151b = contactsYouMayKnowLogger;
        this.f2152c = contactsYouMayKnowCache;
        this.f2153d = lazy;
        this.f2154e = executor;
        this.f2155f = lazy2;
        this.f2156g = lazy3;
    }
}
