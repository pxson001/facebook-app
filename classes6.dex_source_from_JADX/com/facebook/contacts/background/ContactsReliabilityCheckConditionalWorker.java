package com.facebook.contacts.background;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.conditionalworker.ConditionalWorker;
import com.facebook.conditionalworker.ConditionalWorkerRunner;
import com.facebook.contacts.background.configs.ContactsReliabilityCheckXConfig;
import com.facebook.contacts.graphql.Contact;
import com.facebook.contacts.graphql.ContactGraphQL;
import com.facebook.contacts.graphql.ContactGraphQL$FetchContactsByIdsQueryString;
import com.facebook.contacts.graphql.ContactGraphQL$MessengerContactIdsQueryString;
import com.facebook.contacts.graphql.ContactGraphQLModels.ContactModel;
import com.facebook.contacts.graphql.ContactGraphQLModels.MessengerContactIdsQueryModel;
import com.facebook.contacts.graphql.ContactsGraphQlParams;
import com.facebook.contacts.graphql.GraphQLContactDeserializer;
import com.facebook.contacts.iterator.ContactCursorsQuery;
import com.facebook.contacts.iterator.ContactIterator;
import com.facebook.contacts.iterator.ContactIterators;
import com.facebook.device.DeviceConditionHelper;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.xconfig.core.XConfigReader;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.inject.Inject;

/* compiled from: photo_menu_title */
public class ContactsReliabilityCheckConditionalWorker implements ConditionalWorker {
    private final ContactIterators f8121a;
    private final GraphQLQueryExecutor f8122b;
    private final GraphQLContactDeserializer f8123c;
    private final ContactsReliabilityCheckLogger f8124d;
    private final AbstractFbErrorReporter f8125e;
    private final DeviceConditionHelper f8126f;
    private final ContactsGraphQlParams f8127g;
    private final int f8128h;
    private final boolean f8129i;

    public static ContactsReliabilityCheckConditionalWorker m11683b(InjectorLike injectorLike) {
        return new ContactsReliabilityCheckConditionalWorker(ContactIterators.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), GraphQLContactDeserializer.a(injectorLike), new ContactsReliabilityCheckLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 3942)), XConfigReader.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), DeviceConditionHelper.a(injectorLike), ContactsGraphQlParams.b(injectorLike));
    }

    @Inject
    public ContactsReliabilityCheckConditionalWorker(ContactIterators contactIterators, GraphQLQueryExecutor graphQLQueryExecutor, GraphQLContactDeserializer graphQLContactDeserializer, ContactsReliabilityCheckLogger contactsReliabilityCheckLogger, XConfigReader xConfigReader, AbstractFbErrorReporter abstractFbErrorReporter, DeviceConditionHelper deviceConditionHelper, ContactsGraphQlParams contactsGraphQlParams) {
        this.f8121a = contactIterators;
        this.f8122b = graphQLQueryExecutor;
        this.f8123c = graphQLContactDeserializer;
        this.f8124d = contactsReliabilityCheckLogger;
        this.f8125e = abstractFbErrorReporter;
        this.f8126f = deviceConditionHelper;
        this.f8127g = contactsGraphQlParams;
        this.f8128h = xConfigReader.a(ContactsReliabilityCheckXConfig.d, 5);
        this.f8129i = xConfigReader.a(ContactsReliabilityCheckXConfig.e, false);
    }

    public final boolean m11684a(ConditionalWorkerRunner conditionalWorkerRunner) {
        if (conditionalWorkerRunner.a() && this.f8129i) {
            List arrayList = new ArrayList();
            ContactIterator a = this.f8121a.a(ContactCursorsQuery.a());
            while (a.hasNext()) {
                try {
                    arrayList.add(a.next());
                } finally {
                    a.close();
                }
            }
            if (!arrayList.isEmpty()) {
                m11681a(arrayList);
            }
        }
        return true;
    }

    private void m11681a(List<Contact> list) {
        int i;
        int i2 = 0;
        int size = list.size();
        int i3 = this.f8128h > size ? size : this.f8128h;
        Random random = new Random();
        Builder builder = ImmutableList.builder();
        for (i = 0; i < i3; i++) {
            Collections.swap(list, random.nextInt(size - i), (size - i) - 1);
            builder.c(((Contact) list.get((size - i) - 1)).b());
        }
        ImmutableList b = builder.b();
        try {
            GraphQLBatchRequest graphQLBatchRequest = new GraphQLBatchRequest("ContactComparison");
            ContactGraphQL$MessengerContactIdsQueryString k = ContactGraphQL.k();
            this.f8127g.b(k);
            ListenableFuture b2 = graphQLBatchRequest.b(GraphQLRequest.a(k));
            ListenableFuture b3 = graphQLBatchRequest.b(m11680a(b));
            this.f8122b.a(graphQLBatchRequest);
            Collection<ContactModel> e = ((GraphQLResult) FutureDetour.a(b3, 1638405991)).e();
            ImmutableMap.Builder builder2 = new ImmutableMap.Builder();
            for (ContactModel contactModel : e) {
                String g = contactModel.g();
                if (g != null) {
                    builder2.b(g, this.f8123c.a(contactModel).P());
                }
            }
            ImmutableMap b4 = builder2.b();
            i = 0;
            for (int i4 = 0; i4 < i3; i4++) {
                Contact contact = (Contact) list.get((size - i4) - 1);
                Contact contact2 = (Contact) b4.get(contact.b());
                if (contact2 == null) {
                    i++;
                } else if (m11682a(contact, contact2)) {
                    i2++;
                }
            }
            this.f8124d.m11685a(i3, i2, i, list.size(), ((MessengerContactIdsQueryModel) ((GraphQLResult) FutureDetour.a(b2, 281625495)).d()).m11961a().m11958a().size(), list);
        } catch (Throwable e2) {
            this.f8125e.a(SoftError.a("ContactsReliabilityCheckConditionalWorker", "Failed to fetch following contacts from server : " + b.toString()).a(e2).g());
        }
    }

    private static boolean m11682a(Contact contact, Contact contact2) {
        return !Objects.equal(contact.e().f(), contact2.e().f());
    }

    private static GraphQLRequest m11680a(ImmutableList<String> immutableList) {
        ContactGraphQL$FetchContactsByIdsQueryString c = ContactGraphQL.c();
        c.a("contact_ids", immutableList);
        return GraphQLRequest.a(c);
    }
}
