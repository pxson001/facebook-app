package com.facebook.contacts.upload;

import android.content.Context;
import android.content.Intent;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.collect.CloseableIterator;
import com.facebook.common.collect.MergeJoinIterator;
import com.facebook.common.collect.MergeJoinIterator.Entry;
import com.facebook.common.collect.MergeJoinIterator.KeyExtractor;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.phonenumbers.PhoneNumberUtilMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.contacts.ContactSurface;
import com.facebook.contacts.background.AddressBookPeriodicRunner;
import com.facebook.contacts.database.ContactsDatabaseSupplier;
import com.facebook.contacts.graphql.Contact;
import com.facebook.contacts.graphql.ContactBuilder;
import com.facebook.contacts.handlers.DbInsertContactHandler;
import com.facebook.contacts.handlers.DbInsertContactHandler.InsertionType;
import com.facebook.contacts.iterator.AbstractPhonebookContactIterator;
import com.facebook.contacts.iterator.PhoneUserIterators;
import com.facebook.contacts.model.PhonebookContact;
import com.facebook.contacts.model.PhonebookEmailAddress;
import com.facebook.contacts.model.PhonebookPhoneNumber;
import com.facebook.contacts.protocol.methods.FetchContactsMethod;
import com.facebook.contacts.protocol.methods.UploadBulkContactsMethod;
import com.facebook.contacts.protocol.methods.UploadFriendFinderContactsMethod;
import com.facebook.contacts.server.FetchContactsParams;
import com.facebook.contacts.server.FetchContactsResult;
import com.facebook.contacts.server.UploadBulkContactChange;
import com.facebook.contacts.server.UploadBulkContactChange.Type;
import com.facebook.contacts.server.UploadBulkContactChangeResult;
import com.facebook.contacts.server.UploadBulkContactChangeResult.Confidence;
import com.facebook.contacts.server.UploadBulkContactsParams;
import com.facebook.contacts.server.UploadBulkContactsResult;
import com.facebook.contacts.server.UploadBulkFetchContactsResult;
import com.facebook.contacts.server.UploadContactsResult;
import com.facebook.contacts.server.UploadFriendFinderContactsParams;
import com.facebook.contacts.server.UploadFriendFinderContactsParams.ContactsFlow;
import com.facebook.contacts.server.UploadFriendFinderContactsResult;
import com.facebook.contacts.upload.data.ContactsUploadDbHandler;
import com.facebook.contacts.upload.data.ContactsUploadFriendFinderHashHelper;
import com.facebook.contacts.upload.data.ContactsUploadMessengerHashHelper;
import com.facebook.contacts.upload.data.PhoneAddressBookSnapshotEntry;
import com.facebook.contacts.upload.data.PhoneAddressBookSnapshotEntryChange;
import com.facebook.contacts.upload.iterator.PhoneAddressBookSnapshotEntryIterators;
import com.facebook.contacts.upload.logging.ContactsUploadAnalyticsLogger;
import com.facebook.contacts.upload.logging.ContactsUploadLoggingConstants.Events;
import com.facebook.contacts.upload.prefs.ContactUploadStatusHelper;
import com.facebook.contacts.upload.prefs.ContactsUploadPrefKeys;
import com.facebook.contacts.upload.protocol.SetContactsUploadSettingsMethod;
import com.facebook.contacts.upload.protocol.SetContactsUploadSettingsMethod.Params;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.BlueServiceProgressCallback;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.api.LoomLogger;
import com.facebook.phonenumbers.NumberParseException;
import com.facebook.phonenumbers.PhoneNumberUtil;
import com.facebook.phonenumbers.Phonenumber.PhoneNumber;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.LoomLoggerDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.primitives.Longs;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: tapped_event */
public class ContactsUploadServiceHandler implements BlueServiceHandler {
    private static ContactsUploadServiceHandler f2151G;
    private static final Object f2152H = new Object();
    private static final String f2153a = ContactsUploadServiceHandler.class.getName();
    private static final ImmutableSet<ContactSurface> f2154b = ImmutableSet.of(ContactSurface.GROWTH_CONTACT_IMPORTER, ContactSurface.MESSENGER);
    public final BaseFbBroadcastManager f2155A;
    private final AbstractFbErrorReporter f2156B;
    private final Provider<Boolean> f2157C;
    public final ContactUploadStatusHelper f2158D;
    private final ContactsUploadAnalyticsLogger f2159E;
    private boolean f2160F = false;
    private final PhoneUserIterators f2161c;
    private final PhoneAddressBookSnapshotEntryIterators f2162d;
    public final AbstractSingleMethodRunner f2163e;
    private final UploadBulkContactsMethod f2164f;
    private final UploadFriendFinderContactsMethod f2165g;
    private final FetchContactsMethod f2166h;
    public final SetContactsUploadSettingsMethod f2167i;
    public final ContactsDatabaseSupplier f2168j;
    public final AddressBookPeriodicRunner f2169k;
    private final DbInsertContactHandler f2170l;
    public final ContactsUploadDbHandler f2171m;
    private final ContactsUploadMessengerHashHelper f2172n;
    private final ContactsUploadFriendFinderHashHelper f2173o;
    private final FbSharedPreferences f2174p;
    private final Provider<String> f2175q;
    private final Provider<Boolean> f2176r;
    private final Provider<TriState> f2177s;
    private final Provider<TriState> f2178t;
    private final PhoneNumberUtil f2179u;
    private final Provider<TriState> f2180v;
    private final KeyExtractor<PhonebookContact, Long> f2181w;
    private final KeyExtractor<PhoneAddressBookSnapshotEntry, Long> f2182x;
    private final Comparator<Long> f2183y;
    private final Clock f2184z;

    /* compiled from: tapped_event */
    class C02201 implements KeyExtractor<PhonebookContact, Long> {
        final /* synthetic */ ContactsUploadServiceHandler f2141a;

        C02201(ContactsUploadServiceHandler contactsUploadServiceHandler) {
            this.f2141a = contactsUploadServiceHandler;
        }

        public final Object m2108a(Object obj) {
            return Long.valueOf(Long.parseLong(((PhonebookContact) obj).a));
        }
    }

    /* compiled from: tapped_event */
    class C02212 implements KeyExtractor<PhoneAddressBookSnapshotEntry, Long> {
        final /* synthetic */ ContactsUploadServiceHandler f2142a;

        C02212(ContactsUploadServiceHandler contactsUploadServiceHandler) {
            this.f2142a = contactsUploadServiceHandler;
        }

        public final Object m2109a(Object obj) {
            return Long.valueOf(((PhoneAddressBookSnapshotEntry) obj).f2197a);
        }
    }

    /* compiled from: tapped_event */
    class C02223 implements Comparator<Long> {
        final /* synthetic */ ContactsUploadServiceHandler f2143a;

        C02223(ContactsUploadServiceHandler contactsUploadServiceHandler) {
            this.f2143a = contactsUploadServiceHandler;
        }

        public int compare(Object obj, Object obj2) {
            return Longs.a(((Long) obj).longValue(), ((Long) obj2).longValue());
        }
    }

    /* compiled from: tapped_event */
    public /* synthetic */ class C02234 {
        static final /* synthetic */ int[] f2144a = new int[Type.values().length];
        static final /* synthetic */ int[] f2145b = new int[ContactSurface.values().length];
        static final /* synthetic */ int[] f2146c = new int[UploadBulkContactChangeResult.Type.values().length];
        public static final /* synthetic */ int[] f2148e = new int[Confidence.values().length];

        static {
            try {
                f2148e[Confidence.HIGH.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2148e[Confidence.MEDIUM.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            f2147d = new int[ContactIdFilterMode.values().length];
            try {
                f2147d[ContactIdFilterMode.LOCAL_CONTACT_IDS.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f2147d[ContactIdFilterMode.REMOTE_CONTACT_IDS.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f2146c[UploadBulkContactChangeResult.Type.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f2146c[UploadBulkContactChangeResult.Type.NONE.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f2146c[UploadBulkContactChangeResult.Type.MODIFY.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f2146c[UploadBulkContactChangeResult.Type.REMOVE.ordinal()] = 4;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f2145b[ContactSurface.GROWTH_CONTACT_IMPORTER.ordinal()] = 1;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f2145b[ContactSurface.MESSENGER.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f2144a[Type.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f2144a[Type.MODIFY.ordinal()] = 2;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f2144a[Type.DELETE.ordinal()] = 3;
            } catch (NoSuchFieldError e13) {
            }
        }
    }

    /* compiled from: tapped_event */
    enum ContactIdFilterMode {
        LOCAL_CONTACT_IDS,
        REMOTE_CONTACT_IDS
    }

    /* compiled from: tapped_event */
    class Progress {
        public int f2149a;
        public final int f2150b;

        public Progress(int i) {
            this.f2150b = i;
        }
    }

    private static ContactsUploadServiceHandler m2125b(InjectorLike injectorLike) {
        return new ContactsUploadServiceHandler(PhoneUserIterators.a(injectorLike), PhoneAddressBookSnapshotEntryIterators.m2185a(injectorLike), (AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(injectorLike), UploadBulkContactsMethod.a(injectorLike), UploadFriendFinderContactsMethod.a(injectorLike), FetchContactsMethod.a(injectorLike), SetContactsUploadSettingsMethod.m2188a(injectorLike), ContactsDatabaseSupplier.a(injectorLike), AddressBookPeriodicRunner.a(injectorLike), DbInsertContactHandler.a(injectorLike), ContactsUploadDbHandler.a(injectorLike), ContactsUploadMessengerHashHelper.m2136a(injectorLike), ContactsUploadFriendFinderHashHelper.m2134a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), IdBasedProvider.a(injectorLike, 4442), IdBasedProvider.a(injectorLike, 3943), IdBasedProvider.a(injectorLike, 660), IdBasedProvider.a(injectorLike, 656), PhoneNumberUtilMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 657), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), IdBasedProvider.a(injectorLike, 4142), ContactUploadStatusHelper.a(injectorLike), ContactsUploadAnalyticsLogger.a(injectorLike));
    }

    public final OperationResult m2130a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("contacts_upload_messaging".equals(str)) {
            return m2126b(operationParams);
        }
        if ("contacts_upload_friend_finder".equals(str)) {
            return m2129c(operationParams);
        }
        if ("bulk_contacts_delete".equals(str)) {
            this.f2163e.a(this.f2167i, new Params(false));
            this.f2168j.e();
            this.f2169k.clearUserData();
            this.f2171m.a();
            this.f2158D.a(false);
            this.f2155A.a(new Intent("com.facebook.contacts.CONTACT_BULK_DELETE"));
            return OperationResult.a;
        }
        throw new IllegalArgumentException("Unknown operation type: " + str);
    }

    public static ContactsUploadServiceHandler m2114a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ContactsUploadServiceHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2152H) {
                ContactsUploadServiceHandler contactsUploadServiceHandler;
                if (a2 != null) {
                    contactsUploadServiceHandler = (ContactsUploadServiceHandler) a2.a(f2152H);
                } else {
                    contactsUploadServiceHandler = f2151G;
                }
                if (contactsUploadServiceHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2125b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2152H, b3);
                        } else {
                            f2151G = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = contactsUploadServiceHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ContactsUploadServiceHandler(PhoneUserIterators phoneUserIterators, PhoneAddressBookSnapshotEntryIterators phoneAddressBookSnapshotEntryIterators, SingleMethodRunner singleMethodRunner, UploadBulkContactsMethod uploadBulkContactsMethod, UploadFriendFinderContactsMethod uploadFriendFinderContactsMethod, FetchContactsMethod fetchContactsMethod, SetContactsUploadSettingsMethod setContactsUploadSettingsMethod, ContactsDatabaseSupplier contactsDatabaseSupplier, AddressBookPeriodicRunner addressBookPeriodicRunner, DbInsertContactHandler dbInsertContactHandler, ContactsUploadDbHandler contactsUploadDbHandler, ContactsUploadMessengerHashHelper contactsUploadMessengerHashHelper, ContactsUploadFriendFinderHashHelper contactsUploadFriendFinderHashHelper, FbSharedPreferences fbSharedPreferences, Provider<String> provider, Provider<Boolean> provider2, Provider<TriState> provider3, Provider<TriState> provider4, PhoneNumberUtil phoneNumberUtil, Provider<TriState> provider5, Clock clock, FbBroadcastManager fbBroadcastManager, FbErrorReporter fbErrorReporter, Provider<Boolean> provider6, ContactUploadStatusHelper contactUploadStatusHelper, ContactsUploadAnalyticsLogger contactsUploadAnalyticsLogger) {
        this.f2161c = phoneUserIterators;
        this.f2162d = phoneAddressBookSnapshotEntryIterators;
        this.f2163e = singleMethodRunner;
        this.f2164f = uploadBulkContactsMethod;
        this.f2165g = uploadFriendFinderContactsMethod;
        this.f2166h = fetchContactsMethod;
        this.f2167i = setContactsUploadSettingsMethod;
        this.f2168j = contactsDatabaseSupplier;
        this.f2169k = addressBookPeriodicRunner;
        this.f2170l = dbInsertContactHandler;
        this.f2171m = contactsUploadDbHandler;
        this.f2174p = fbSharedPreferences;
        this.f2172n = contactsUploadMessengerHashHelper;
        this.f2173o = contactsUploadFriendFinderHashHelper;
        this.f2175q = provider;
        this.f2176r = provider2;
        this.f2177s = provider3;
        this.f2178t = provider4;
        this.f2179u = phoneNumberUtil;
        this.f2180v = provider5;
        this.f2184z = clock;
        this.f2155A = fbBroadcastManager;
        this.f2156B = fbErrorReporter;
        this.f2157C = provider6;
        this.f2158D = contactUploadStatusHelper;
        this.f2159E = contactsUploadAnalyticsLogger;
        this.f2181w = new C02201(this);
        this.f2182x = new C02212(this);
        this.f2183y = new C02223(this);
    }

    private OperationResult m2126b(OperationParams operationParams) {
        return m2116a(operationParams, ContactSurface.MESSENGER);
    }

    private OperationResult m2129c(OperationParams operationParams) {
        return OperationResult.a(m2116a(operationParams, ContactSurface.GROWTH_CONTACT_IMPORTER));
    }

    private OperationResult m2116a(OperationParams operationParams, ContactSurface contactSurface) {
        if (!f2154b.contains(contactSurface)) {
            return OperationResult.a(new UnsupportedOperationException("Unsupported ContactSurface: " + contactSurface));
        }
        this.f2159E.a(Events.OVERALL_UPLOAD_START);
        String a = this.f2174p.a(ContactsUploadPrefKeys.o, null);
        AbstractPhonebookContactIterator b = contactSurface == ContactSurface.GROWTH_CONTACT_IMPORTER ? this.f2161c.b() : this.f2161c.c();
        if (b == null) {
            return OperationResult.a(new UnsupportedOperationException("Contacts content provider is unsupported"));
        }
        CloseableIterator a2 = this.f2162d.m2187a();
        try {
            Progress progress;
            int c = b.c();
            BlueServiceProgressCallback d = operationParams.d();
            if (d != null) {
                d.a(OperationResult.a(ContactsUploadState.m2131a(0, 0, c)));
            }
            int i = operationParams.b().getInt("contactsUploadPhonebookMaxLimit", 10000);
            if (contactSurface == ContactSurface.GROWTH_CONTACT_IMPORTER && c > i && ((TriState) this.f2177s.get()).asBoolean(false)) {
                progress = new Progress(i);
            } else {
                progress = new Progress(c);
            }
            int parseInt = Integer.parseInt(this.f2174p.a(ContactsUploadPrefKeys.e, "-1"));
            if (parseInt == -1) {
                parseInt = 100;
            }
            Integer.valueOf(progress.f2150b);
            Integer.valueOf(parseInt);
            this.f2160F = operationParams.b().getBoolean("forceFullUploadAndTurnOffGlobalKillSwitch", false);
            if (this.f2160F) {
                this.f2171m.a();
                this.f2158D.a(true);
                if (contactSurface == ContactSurface.MESSENGER) {
                    this.f2163e.a(this.f2167i, new Params(true));
                }
            }
            Object a3 = m2111a(operationParams, b, a2, progress, parseInt, a, contactSurface, i);
            new StringBuilder("Done uploading contacts (import ID ").append(a).append(")");
            this.f2159E.a(Events.OVERALL_UPLOAD_FINISH);
            return OperationResult.a(a3);
        } finally {
            b.d();
            a2.close();
        }
    }

    private UploadContactsResult m2111a(OperationParams operationParams, AbstractPhonebookContactIterator abstractPhonebookContactIterator, CloseableIterator<PhoneAddressBookSnapshotEntry> closeableIterator, Progress progress, int i, String str, ContactSurface contactSurface, int i2) {
        this.f2159E.a(Events.COMPUTE_DELTA_AND_UPLOAD);
        MergeJoinIterator a = MergeJoinIterator.newBuilder().b(this.f2181w).a(this.f2182x).a(this.f2183y).a(abstractPhonebookContactIterator).b(closeableIterator).a();
        Builder builder = ImmutableMap.builder();
        ImmutableList.Builder builder2 = ImmutableList.builder();
        Map c = Maps.c();
        HashSet hashSet = new HashSet(i);
        List arrayList = new ArrayList();
        BlueServiceProgressCallback d = operationParams.d();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        Builder builder3 = builder;
        ImmutableList.Builder builder4 = builder2;
        int i8 = 0;
        Set set = hashSet;
        String str2 = str;
        while (a.hasNext()) {
            int i9;
            boolean z;
            Entry entry = (Entry) a.next();
            if (entry.a == null || contactSurface != ContactSurface.GROWTH_CONTACT_IMPORTER) {
                i9 = i8;
                z = false;
            } else {
                int i10 = i8 + 1;
                if (i10 <= i2 || !((TriState) this.f2177s.get()).asBoolean(false)) {
                    arrayList.add(m2128b(contactSurface, (PhonebookContact) entry.a));
                    z = false;
                    i9 = i10;
                } else if (entry.b != null) {
                    z = true;
                    i9 = i10;
                } else {
                    i8 = i10;
                }
            }
            ContactsUploadAction a2 = m2113a(entry, contactSurface, z);
            if (a2.f2117a == ActionType.ADD || a2.f2117a == ActionType.UPDATE) {
                PhonebookContact phonebookContact = a2.f2119c;
                if (phonebookContact.n.isEmpty() && phonebookContact.m.isEmpty()) {
                    this.f2159E.a(phonebookContact.a, a2.f2117a.toString());
                }
            }
            if (a2.f2119c != null) {
                progress.f2149a++;
            }
            if (a2.f2117a != ActionType.NONE) {
                String valueOf = String.valueOf(a2.f2118b);
                if (set.add(valueOf)) {
                    int i11;
                    Builder builder5;
                    ImmutableList.Builder builder6;
                    HashSet hashSet2;
                    if (contactSurface.equals(ContactSurface.GROWTH_CONTACT_IMPORTER)) {
                        switch (C02234.f2144a[a2.f2117a.buckContactChangeType.ordinal()]) {
                            case 1:
                                builder3.b(valueOf, new UploadBulkContactChange(valueOf, a2.f2119c, a2.f2117a.buckContactChangeType, m2128b(contactSurface, a2.f2119c)));
                                i3++;
                                break;
                            case 2:
                                builder3.b(valueOf + "D", new UploadBulkContactChange(valueOf, a2.f2119c, Type.DELETE, ((PhoneAddressBookSnapshotEntry) entry.b).f2198b));
                                builder3.b(valueOf, new UploadBulkContactChange(valueOf, a2.f2119c, Type.ADD, m2128b(contactSurface, a2.f2119c)));
                                i4++;
                                break;
                            case 3:
                                builder3.b(valueOf, new UploadBulkContactChange(valueOf, a2.f2119c, a2.f2117a.buckContactChangeType, ((PhoneAddressBookSnapshotEntry) entry.b).f2198b));
                                i5++;
                                break;
                            default:
                                throw new IllegalArgumentException("Unsupported action type " + a2.f2117a.buckContactChangeType);
                        }
                    }
                    switch (C02234.f2144a[a2.f2117a.buckContactChangeType.ordinal()]) {
                        case 1:
                            i3++;
                            break;
                        case 2:
                            i4++;
                            break;
                        case 3:
                            i5++;
                            break;
                        default:
                            throw new IllegalArgumentException("Unsupported action type " + a2.f2117a.buckContactChangeType);
                    }
                    builder3.b(valueOf, new UploadBulkContactChange(valueOf, a2.f2119c, a2.f2117a.buckContactChangeType, m2128b(contactSurface, a2.f2119c)));
                    builder4.c(new PhoneAddressBookSnapshotEntryChange(a2.f2117a.snapshotEntryChangeType, a2.f2118b, a2.f2120d));
                    i6++;
                    if (i6 >= i) {
                        str = m2120a(builder3.b(), builder4.b(), str2, progress, d, c, contactSurface);
                        i8 = i7 + i6;
                        i11 = 0;
                        builder5 = ImmutableMap.builder();
                        builder6 = ImmutableList.builder();
                        hashSet2 = new HashSet();
                    } else {
                        i11 = i6;
                        i8 = i7;
                        Set set2 = set;
                        str = str2;
                        builder5 = builder3;
                        builder6 = builder4;
                    }
                    i6 = i11;
                    i7 = i8;
                    builder4 = builder6;
                    builder3 = builder5;
                    i8 = i9;
                    set = hashSet2;
                    str2 = str;
                } else {
                    this.f2156B.a("Duplicate contact ID returned by phonebook iterator", valueOf);
                    i8 = i9;
                }
            } else {
                i8 = i9;
            }
        }
        if (i6 > 0) {
            str2 = m2120a(builder3.b(), builder4.b(), str2, progress, d, c, contactSurface);
            i7 += i6;
        }
        if (i7 > 0) {
            this.f2155A.a(new Intent("com.facebook.contacts.CONTACTS_UPLOAD_DONE"));
        }
        if (contactSurface == ContactSurface.GROWTH_CONTACT_IMPORTER) {
            this.f2174p.edit().a(ContactsUploadPrefKeys.k, ContactsUploadFriendFinderHashHelper.m2135a(arrayList)).commit();
        }
        this.f2159E.a(contactSurface.equals(ContactSurface.GROWTH_CONTACT_IMPORTER) ? "fb4a" : "messenger", progress.f2149a, i3, i4, i5, (i3 + i5) + (i4 * 2));
        return new UploadContactsResult(str2, ImmutableList.copyOf(c.values()));
    }

    private String m2120a(ImmutableMap<String, UploadBulkContactChange> immutableMap, ImmutableList<PhoneAddressBookSnapshotEntryChange> immutableList, String str, Progress progress, @Nullable BlueServiceProgressCallback blueServiceProgressCallback, Map<String, Contact> map, ContactSurface contactSurface) {
        String str2;
        if (contactSurface == ContactSurface.GROWTH_CONTACT_IMPORTER) {
            str2 = m2112a(str, (ImmutableMap) immutableMap, (ImmutableList) immutableList).a;
        } else {
            UploadBulkFetchContactsResult a = m2110a(str, immutableMap, immutableList, contactSurface);
            UploadBulkContactsResult uploadBulkContactsResult = a.a;
            FetchContactsResult fetchContactsResult = a.b;
            if (fetchContactsResult != null) {
                ImmutableList c = fetchContactsResult.c();
                int size = c.size();
                for (int i = 0; i < size; i++) {
                    Contact contact = (Contact) c.get(i);
                    if (!(GraphQLFriendshipStatus.ARE_FRIENDS.equals(contact.x()) || Objects.equal(this.f2175q.get(), contact.c()) || (!contact.s() && !((Boolean) this.f2157C.get()).booleanValue()))) {
                        map.put(contact.b(), contact);
                    }
                }
            }
            str2 = uploadBulkContactsResult.c();
        }
        if (blueServiceProgressCallback != null) {
            blueServiceProgressCallback.a(OperationResult.a(ContactsUploadState.m2131a(progress.f2149a, map.size(), progress.f2150b)));
        }
        if (str2 != null) {
            this.f2174p.edit().a(ContactsUploadPrefKeys.o, str2).commit();
        } else {
            this.f2156B.a(f2153a, "Null Import Id returned by server");
        }
        return str2;
    }

    private ContactsUploadAction m2113a(Entry<PhonebookContact, PhoneAddressBookSnapshotEntry> entry, ContactSurface contactSurface, boolean z) {
        if (((TriState) this.f2180v.get()).asBoolean(false)) {
            ContactsUploadActionBuilder newBuilder = ContactsUploadAction.newBuilder();
            newBuilder.f2121a = ActionType.NONE;
            newBuilder = newBuilder;
            newBuilder.f2123c = null;
            newBuilder = newBuilder;
            newBuilder.f2124d = null;
            return newBuilder.m2090a();
        }
        PhonebookContact phonebookContact;
        if (z) {
            phonebookContact = null;
        } else {
            phonebookContact = (PhonebookContact) entry.a;
        }
        PhoneAddressBookSnapshotEntry phoneAddressBookSnapshotEntry = (PhoneAddressBookSnapshotEntry) entry.b;
        ContactsUploadActionBuilder newBuilder2;
        if (phonebookContact == null) {
            newBuilder2 = ContactsUploadAction.newBuilder();
            newBuilder2.f2121a = ActionType.DELETE;
            newBuilder2 = newBuilder2;
            newBuilder2.f2122b = phoneAddressBookSnapshotEntry.f2197a;
            newBuilder = newBuilder2;
            newBuilder.f2123c = null;
            newBuilder = newBuilder;
            newBuilder.f2124d = null;
            return newBuilder.m2090a();
        } else if (phoneAddressBookSnapshotEntry == null) {
            if (m2123a(phonebookContact, contactSurface)) {
                newBuilder = ContactsUploadAction.newBuilder();
                newBuilder.f2121a = ActionType.ADD;
                newBuilder = newBuilder;
                newBuilder.f2122b = Long.parseLong(phonebookContact.a);
                newBuilder = newBuilder;
                newBuilder.f2123c = phonebookContact;
                newBuilder = newBuilder;
                newBuilder.f2124d = m2115a(contactSurface, phonebookContact);
                return newBuilder.m2090a();
            }
            newBuilder = ContactsUploadAction.newBuilder();
            newBuilder.f2121a = ActionType.NONE;
            newBuilder = newBuilder;
            newBuilder.f2122b = Long.parseLong(phonebookContact.a);
            newBuilder = newBuilder;
            newBuilder.f2123c = phonebookContact;
            newBuilder = newBuilder;
            newBuilder.f2124d = null;
            return newBuilder.m2090a();
        } else if (m2128b(contactSurface, phonebookContact).equals(phoneAddressBookSnapshotEntry.f2198b)) {
            r2 = ContactsUploadAction.newBuilder();
            r2.f2121a = ActionType.NONE;
            r2 = r2;
            r2.f2122b = phoneAddressBookSnapshotEntry.f2197a;
            r2 = r2;
            r2.f2123c = phonebookContact;
            newBuilder2 = r2;
            newBuilder2.f2124d = phoneAddressBookSnapshotEntry;
            return newBuilder2.m2090a();
        } else if (m2123a(phonebookContact, contactSurface)) {
            r2 = ContactsUploadAction.newBuilder();
            r2.f2121a = ActionType.UPDATE;
            r2 = r2;
            r2.f2122b = phoneAddressBookSnapshotEntry.f2197a;
            newBuilder = r2;
            newBuilder.f2123c = phonebookContact;
            newBuilder = newBuilder;
            newBuilder.f2124d = m2115a(contactSurface, phonebookContact);
            return newBuilder.m2090a();
        } else {
            newBuilder2 = ContactsUploadAction.newBuilder();
            newBuilder2.f2121a = ActionType.DELETE;
            newBuilder2 = newBuilder2;
            newBuilder2.f2122b = phoneAddressBookSnapshotEntry.f2197a;
            newBuilder = newBuilder2;
            newBuilder.f2123c = null;
            newBuilder = newBuilder;
            newBuilder.f2124d = null;
            return newBuilder.m2090a();
        }
    }

    private PhoneAddressBookSnapshotEntry m2115a(ContactSurface contactSurface, PhonebookContact phonebookContact) {
        return new PhoneAddressBookSnapshotEntry(Long.parseLong(phonebookContact.a), m2128b(contactSurface, phonebookContact));
    }

    private String m2128b(ContactSurface contactSurface, PhonebookContact phonebookContact) {
        if (phonebookContact == null) {
            return "";
        }
        switch (C02234.f2145b[contactSurface.ordinal()]) {
            case 1:
                String valueOf;
                if (((Boolean) this.f2176r.get()).booleanValue()) {
                    valueOf = String.valueOf(phonebookContact.hashCode());
                } else {
                    int i;
                    long hashCode = (long) Objects.hashCode(new Object[]{phonebookContact.b});
                    for (i = 0; i < phonebookContact.n.size(); i++) {
                        hashCode = (long) Objects.hashCode(new Object[]{((PhonebookEmailAddress) phonebookContact.n.get(i)).a, Long.valueOf(hashCode)});
                    }
                    for (i = 0; i < phonebookContact.m.size(); i++) {
                        hashCode = (long) Objects.hashCode(new Object[]{((PhonebookPhoneNumber) phonebookContact.m.get(i)).a, Long.valueOf(hashCode)});
                    }
                    valueOf = String.valueOf(hashCode);
                }
                return valueOf;
            case 2:
                return ContactsUploadMessengerHashHelper.m2137a(phonebookContact, ((TriState) this.f2178t.get()).asBoolean(false));
            default:
                throw new IllegalArgumentException("Unsupported upload surface: " + contactSurface);
        }
    }

    @VisibleForTesting
    private UploadFriendFinderContactsResult m2112a(String str, ImmutableMap<String, UploadBulkContactChange> immutableMap, ImmutableList<PhoneAddressBookSnapshotEntryChange> immutableList) {
        IOException iOException;
        TracerDetour.a("uploadContactBatchForFriendFinder (%d changes)", Integer.valueOf(immutableMap.size()), -149205110);
        LoomLogger.a(LoomLoggerDetour.a(-218997521), "uploadContactBatchForFriendFinder", String.valueOf(immutableMap.size()));
        this.f2159E.a(Events.BATCH_UPLOAD_START);
        if (str == null) {
            try {
                str = "(new import)";
            } catch (Throwable th) {
                TracerDetour.a(605651271);
            }
        }
        UploadFriendFinderContactsResult uploadFriendFinderContactsResult = null;
        Object obj = null;
        int i = 0;
        while (obj == null && i < 3) {
            try {
                Integer.valueOf(immutableMap.size());
                UploadFriendFinderContactsResult uploadFriendFinderContactsResult2 = (UploadFriendFinderContactsResult) this.f2163e.a(this.f2165g, new UploadFriendFinderContactsParams(ContactsFlow.CONTINUOUS_SYNC, str, ImmutableList.copyOf(immutableMap.values()), this.f2160F));
                try {
                    m2121a((ImmutableList) immutableList);
                    obj = 1;
                    uploadFriendFinderContactsResult = uploadFriendFinderContactsResult2;
                } catch (IOException e) {
                    IOException iOException2 = e;
                    uploadFriendFinderContactsResult = uploadFriendFinderContactsResult2;
                    iOException = iOException2;
                    i++;
                    BLog.b(f2153a, "Failed to upload contact batch, (try %s of %s ), error: %s ", new Object[]{Integer.valueOf(i), Integer.valueOf(3), iOException});
                    this.f2159E.a(Events.BATCH_UPLOAD_ATTEMPT_ERROR);
                    if (i >= 3) {
                        this.f2159E.a(Events.BATCH_UPLOAD_FAIL);
                        throw iOException;
                    }
                }
            } catch (IOException e2) {
                iOException = e2;
                i++;
                BLog.b(f2153a, "Failed to upload contact batch, (try %s of %s ), error: %s ", new Object[]{Integer.valueOf(i), Integer.valueOf(3), iOException});
                this.f2159E.a(Events.BATCH_UPLOAD_ATTEMPT_ERROR);
                if (i >= 3) {
                    this.f2159E.a(Events.BATCH_UPLOAD_FAIL);
                    throw iOException;
                }
            }
        }
        Preconditions.checkState(uploadFriendFinderContactsResult != null);
        this.f2159E.a(Events.BATCH_UPLOAD_FINISH);
        TracerDetour.a(-1713804322);
        return uploadFriendFinderContactsResult;
    }

    @VisibleForTesting
    private UploadBulkFetchContactsResult m2110a(String str, ImmutableMap<String, UploadBulkContactChange> immutableMap, ImmutableList<PhoneAddressBookSnapshotEntryChange> immutableList, ContactSurface contactSurface) {
        TracerDetour.a("uploadContactBatchForMessaging (%d changes)", Integer.valueOf(immutableMap.size()), 786131226);
        LoomLogger.a(LoomLoggerDetour.a(229355837), "uploadContactBatchForMessaging", String.valueOf(immutableMap.size()));
        this.f2159E.a(Events.BATCH_UPLOAD_START);
        Object obj = null;
        UploadBulkFetchContactsResult uploadBulkFetchContactsResult = null;
        int i = 0;
        while (obj == null && i < 3) {
            try {
                Integer.valueOf(immutableMap.size());
                UploadBulkContactsResult uploadBulkContactsResult = (UploadBulkContactsResult) this.f2163e.a(this.f2164f, new UploadBulkContactsParams(str, ImmutableList.copyOf(immutableMap.values()), contactSurface));
                m2121a((ImmutableList) immutableList);
                ImmutableSet a = m2119a(uploadBulkContactsResult, ContactIdFilterMode.REMOTE_CONTACT_IDS);
                FetchContactsResult fetchContactsResult = null;
                if (a.size() > 0) {
                    fetchContactsResult = (FetchContactsResult) this.f2163e.a(this.f2166h, new FetchContactsParams(a));
                    this.f2170l.a(m2127b(fetchContactsResult.c()), InsertionType.INSERT, fetchContactsResult.a());
                    m2122a((ImmutableMap) immutableMap, uploadBulkContactsResult);
                }
                obj = 1;
                uploadBulkFetchContactsResult = new UploadBulkFetchContactsResult(uploadBulkContactsResult, fetchContactsResult);
            } catch (IOException e) {
                int i2 = i + 1;
                BLog.b(f2153a, "Failed to upload contact batch, (try %s of %s ), error: %s ", new Object[]{Integer.valueOf(i2), Integer.valueOf(3), e});
                this.f2159E.a(Events.BATCH_UPLOAD_ATTEMPT_ERROR);
                if (i2 >= 3) {
                    BLog.b(f2153a, "Giving up uploading contact batch.");
                    this.f2159E.a(Events.BATCH_UPLOAD_FAIL);
                    throw e;
                }
                i = i2;
            } catch (Throwable th) {
                TracerDetour.a(-1287997209);
            }
        }
        Preconditions.checkState(uploadBulkFetchContactsResult != null);
        this.f2159E.a(Events.BATCH_UPLOAD_FINISH);
        TracerDetour.a(1785794094);
        return uploadBulkFetchContactsResult;
    }

    private void m2121a(ImmutableList<PhoneAddressBookSnapshotEntryChange> immutableList) {
        this.f2171m.a(immutableList);
    }

    private ImmutableCollection<Contact> m2127b(ImmutableList<Contact> immutableList) {
        ImmutableList.Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            Contact contact = (Contact) immutableList.get(i);
            ContactBuilder contactBuilder = new ContactBuilder(contact);
            contactBuilder.z = true;
            if (contact.w() == 0) {
                contactBuilder.E = this.f2184z.a();
            }
            builder.c(contactBuilder.P());
        }
        return builder.b();
    }

    private boolean m2123a(PhonebookContact phonebookContact, ContactSurface contactSurface) {
        if (contactSurface == ContactSurface.GROWTH_CONTACT_IMPORTER) {
            return true;
        }
        if (contactSurface != ContactSurface.MESSENGER) {
            return false;
        }
        if (StringUtil.a(phonebookContact.b)) {
            return false;
        }
        if (!m2124a(phonebookContact.m) || (((TriState) this.f2178t.get()).asBoolean(false) && !m2124a(phonebookContact.n))) {
            return true;
        }
        return false;
    }

    private static boolean m2124a(List list) {
        return list == null || list.isEmpty();
    }

    private ImmutableList<UploadBulkContactChangeResult> m2117a(UploadBulkContactsResult uploadBulkContactsResult) {
        ImmutableList.Builder builder = ImmutableList.builder();
        ImmutableList immutableList = uploadBulkContactsResult.b;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            UploadBulkContactChangeResult uploadBulkContactChangeResult = (UploadBulkContactChangeResult) immutableList.get(i);
            switch (C02234.f2146c[uploadBulkContactChangeResult.a.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    Object obj;
                    Confidence confidence = uploadBulkContactChangeResult.e;
                    switch (C02234.f2148e[confidence.ordinal()]) {
                        case 1:
                        case 2:
                            obj = 1;
                            break;
                        default:
                            obj = null;
                            break;
                    }
                    if (obj == null) {
                        new StringBuilder("Not including contact ").append(uploadBulkContactChangeResult).append(", confidence ").append(confidence).append(" too low.");
                        break;
                    }
                    builder.c(uploadBulkContactChangeResult);
                    break;
                default:
                    break;
            }
        }
        return builder.b();
    }

    private ImmutableSet<String> m2119a(UploadBulkContactsResult uploadBulkContactsResult, ContactIdFilterMode contactIdFilterMode) {
        ImmutableList a = m2117a(uploadBulkContactsResult);
        ImmutableSet.Builder builder = ImmutableSet.builder();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            UploadBulkContactChangeResult uploadBulkContactChangeResult = (UploadBulkContactChangeResult) a.get(i);
            Object obj = null;
            String str;
            switch (contactIdFilterMode) {
                case LOCAL_CONTACT_IDS:
                    str = uploadBulkContactChangeResult.b;
                    break;
                case REMOTE_CONTACT_IDS:
                    str = uploadBulkContactChangeResult.c;
                    break;
            }
            Preconditions.checkState(obj != null);
            builder.c(obj);
        }
        return builder.b();
    }

    private void m2122a(ImmutableMap<String, UploadBulkContactChange> immutableMap, UploadBulkContactsResult uploadBulkContactsResult) {
        ImmutableMultimap a = m2118a((ImmutableMap) immutableMap, m2117a(uploadBulkContactsResult));
        new StringBuilder("Inserting phone indexes for contacts: ").append(a);
        this.f2170l.a(a);
    }

    private ImmutableMultimap<String, PhoneNumber> m2118a(ImmutableMap<String, UploadBulkContactChange> immutableMap, ImmutableList<UploadBulkContactChangeResult> immutableList) {
        ImmutableMultimap.Builder c = ImmutableMultimap.c();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            UploadBulkContactChangeResult uploadBulkContactChangeResult = (UploadBulkContactChangeResult) immutableList.get(i);
            String b = uploadBulkContactChangeResult.b();
            String c2 = uploadBulkContactChangeResult.c();
            UploadBulkContactChange uploadBulkContactChange = (UploadBulkContactChange) immutableMap.get(b);
            if (uploadBulkContactChange == null) {
                BLog.b(f2153a, "Got change result that did not match a local contact ID, skipping: " + uploadBulkContactChangeResult);
            } else {
                ImmutableList immutableList2 = uploadBulkContactChange.c().m;
                int size2 = immutableList2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = ((PhonebookPhoneNumber) immutableList2.get(i2)).a;
                    try {
                        c.b(c2, this.f2179u.parse(str, null));
                    } catch (NumberParseException e) {
                        new Object[1][0] = str;
                    }
                }
            }
        }
        return c.b();
    }
}
