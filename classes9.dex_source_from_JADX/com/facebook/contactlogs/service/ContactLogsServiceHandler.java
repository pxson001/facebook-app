package com.facebook.contactlogs.service;

import android.content.Context;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.contactlogs.data.ContactLogMetadata;
import com.facebook.contactlogs.iterator.CallLogMetaDataIteratorGetter;
import com.facebook.contactlogs.iterator.ContactLogMetaDataIterator;
import com.facebook.contactlogs.iterator.MmsLogMetaDataIteratorGetter;
import com.facebook.contactlogs.iterator.SmsLogMetaDataIteratorGetter;
import com.facebook.contactlogs.logging.ContactLogsAnalyticsLogger;
import com.facebook.contactlogs.migrator.PhonebookContactsGetter;
import com.facebook.contactlogs.protocol.MatchTopSMSContactsMethod;
import com.facebook.contactlogs.protocol.MatchTopSMSContactsParams;
import com.facebook.contactlogs.protocol.SetContactLogsUploadSettingMethod;
import com.facebook.contactlogs.protocol.SetContactLogsUploadSettingMethod.Setting;
import com.facebook.contactlogs.protocol.StartJourneysMethod;
import com.facebook.contactlogs.protocol.UploadContactLogsMethod;
import com.facebook.contactlogs.protocol.UploadContactLogsMethod.ServerStatusCode;
import com.facebook.contacts.iterator.MessengerPhonebookContactIteratorProvider;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.ArrayList;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: profile_image_width */
public class ContactLogsServiceHandler implements BlueServiceHandler {
    private static ContactLogsServiceHandler f6173l;
    private static final Object f6174m = new Object();
    public final Provider<SingleMethodRunner> f6175a;
    public final Lazy<SetContactLogsUploadSettingMethod> f6176b;
    private final CallLogMetaDataIteratorGetter f6177c;
    private final MmsLogMetaDataIteratorGetter f6178d;
    private final SmsLogMetaDataIteratorGetter f6179e;
    public final PhonebookContactsGetter f6180f;
    public final Lazy<MatchTopSMSContactsMethod> f6181g;
    public final Lazy<StartJourneysMethod> f6182h;
    private final UploadContactLogsMethod f6183i;
    private final ContactLogsAnalyticsLogger f6184j;
    private final Provider<Boolean> f6185k;

    private static ContactLogsServiceHandler m6516b(InjectorLike injectorLike) {
        return new ContactLogsServiceHandler(IdBasedSingletonScopeProvider.a(injectorLike, 2289), IdBasedLazy.a(injectorLike, 5335), CallLogMetaDataIteratorGetter.m6484b(injectorLike), MmsLogMetaDataIteratorGetter.m6490b(injectorLike), SmsLogMetaDataIteratorGetter.m6494b(injectorLike), new PhonebookContactsGetter(ContentResolverMethodAutoProvider.b(injectorLike), (MessengerPhonebookContactIteratorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(MessengerPhonebookContactIteratorProvider.class)), IdBasedLazy.a(injectorLike, 5334), IdBasedLazy.a(injectorLike, 5336), UploadContactLogsMethod.m6511b(injectorLike), ContactLogsAnalyticsLogger.a(injectorLike), IdBasedProvider.a(injectorLike, 3939));
    }

    public final OperationResult m6518a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("set_contact_logs_upload_setting".equals(str)) {
            ((AbstractSingleMethodRunner) this.f6175a.get()).a((ApiMethod) this.f6176b.get(), (Setting) operationParams.c.getSerializable("set_contact_logs_upload_setting_param_key"), operationParams.e);
            return OperationResult.a;
        } else if ("upload_contact_logs".equals(str)) {
            return m6517c(operationParams);
        } else {
            if ("match_top_sms_contacts".equals(str)) {
                return OperationResult.a((ArrayList) ((AbstractSingleMethodRunner) this.f6175a.get()).a((ApiMethod) this.f6181g.get(), this.f6180f.m6498a(((MatchTopSMSContactsParams) operationParams.c.getParcelable("matchTopSmsContactsParams")).f6170a), operationParams.e));
            } else if ("begin_journeys".equals(str)) {
                ((AbstractSingleMethodRunner) this.f6175a.get()).a((ApiMethod) this.f6182h.get(), operationParams.c.getStringArrayList("target_ids"), operationParams.e);
                return OperationResult.a;
            } else {
                throw new IllegalArgumentException("Unknown operation type: " + str);
            }
        }
    }

    @Inject
    public ContactLogsServiceHandler(Provider<SingleMethodRunner> provider, Lazy<SetContactLogsUploadSettingMethod> lazy, CallLogMetaDataIteratorGetter callLogMetaDataIteratorGetter, MmsLogMetaDataIteratorGetter mmsLogMetaDataIteratorGetter, SmsLogMetaDataIteratorGetter smsLogMetaDataIteratorGetter, PhonebookContactsGetter phonebookContactsGetter, Lazy<MatchTopSMSContactsMethod> lazy2, Lazy<StartJourneysMethod> lazy3, UploadContactLogsMethod uploadContactLogsMethod, ContactLogsAnalyticsLogger contactLogsAnalyticsLogger, Provider<Boolean> provider2) {
        this.f6175a = provider;
        this.f6176b = lazy;
        this.f6177c = callLogMetaDataIteratorGetter;
        this.f6178d = mmsLogMetaDataIteratorGetter;
        this.f6179e = smsLogMetaDataIteratorGetter;
        this.f6180f = phonebookContactsGetter;
        this.f6183i = uploadContactLogsMethod;
        this.f6181g = lazy2;
        this.f6182h = lazy3;
        this.f6184j = contactLogsAnalyticsLogger;
        this.f6185k = provider2;
    }

    public static ContactLogsServiceHandler m6514a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ContactLogsServiceHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6174m) {
                ContactLogsServiceHandler contactLogsServiceHandler;
                if (a2 != null) {
                    contactLogsServiceHandler = (ContactLogsServiceHandler) a2.a(f6174m);
                } else {
                    contactLogsServiceHandler = f6173l;
                }
                if (contactLogsServiceHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m6516b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6174m, b3);
                        } else {
                            f6173l = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = contactLogsServiceHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private OperationResult m6517c(OperationParams operationParams) {
        if (!((Boolean) this.f6185k.get()).booleanValue()) {
            return OperationResult.a(new UnsupportedOperationException("Contact logs upload method has been disabled."));
        }
        ContactLogMetaDataIterator b = this.f6177c.m6486b();
        ContactLogMetaDataIterator b2 = this.f6179e.m6496b();
        ContactLogMetaDataIterator b3 = this.f6178d.m6493b();
        Builder builder = ImmutableMap.builder();
        builder.b("call_logs", m6515a(b));
        builder.b("sms_logs", m6515a(b2));
        builder.b("mms_logs", m6515a(b3));
        ImmutableMap b4 = builder.b();
        this.f6184j.a((long) ((ImmutableList) b4.get("call_logs")).size(), (long) ((ImmutableList) b4.get("sms_logs")).size(), (long) ((ImmutableList) b4.get("mms_logs")).size());
        return OperationResult.a(((ServerStatusCode) ((AbstractSingleMethodRunner) this.f6175a.get()).a(this.f6183i, b4, operationParams.e)).name());
    }

    public static ImmutableList<ContactLogMetadata> m6515a(ContactLogMetaDataIterator contactLogMetaDataIterator) {
        if (contactLogMetaDataIterator == null) {
            return ImmutableList.of();
        }
        ImmutableList.Builder builder = ImmutableList.builder();
        while (contactLogMetaDataIterator.hasNext()) {
            try {
                builder.c(contactLogMetaDataIterator.next());
            } finally {
                contactLogMetaDataIterator.m6488c();
            }
        }
        return builder.b();
    }
}
