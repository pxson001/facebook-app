package com.facebook.orca.contacts.picker;

import android.content.res.Resources;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.time.SystemClock;
import com.facebook.config.application.Product;
import com.facebook.contacts.picker.BaseSearchableContactPickerListAdapter;
import com.facebook.contacts.picker.ContactPickerListFilter;
import com.facebook.contacts.picker.ContactPickerMergedFilter;
import com.facebook.contacts.picker.ContactPickerMergedFilter.ContactPickerSubFilterConfig;
import com.facebook.contacts.picker.ContactPickerViewFactory;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.messaging.annotations.ForAllFriends;
import com.facebook.messaging.annotations.ForContactMultiPicker;
import com.facebook.messaging.annotations.ForDivebarList;
import com.facebook.messaging.annotations.ForFacebookList;
import com.facebook.messaging.annotations.ForFavoritePickerList;
import com.facebook.messaging.annotations.ForNotOnMessengerFriends;
import com.facebook.messaging.annotations.ForPaymentEligibleContacts;
import com.facebook.messaging.annotations.ForPhoneContactList;
import com.facebook.messaging.annotations.ForUnpinnedGroups;
import com.facebook.messaging.annotations.ForVoipGroupCallList;
import com.facebook.messaging.annotations.ForVoipSearchList;
import com.facebook.messaging.annotations.ForVoipSelectSearchList;
import com.facebook.messaging.annotations.IsDivebarSupported;
import com.facebook.messaging.business.search.BusinessSearchGatekeeperUtil;
import com.facebook.messaging.business.search.abtest.ExperimentsForBusinessSearchAbtestModule;
import com.facebook.messaging.contacts.picker.ContactPickerDbGroupFilter;
import com.facebook.messaging.contacts.picker.ContactPickerFriendFilter;
import com.facebook.messaging.contacts.picker.ContactPickerNotOnMessengerFriendsFilter;
import com.facebook.messaging.contacts.picker.ContactPickerPaymentEligibleContactsFilter;
import com.facebook.messaging.contacts.picker.ContactPickerPhoneContactsFilter;
import com.facebook.messaging.contacts.picker.ContactPickerServerAgentPageFilter;
import com.facebook.messaging.contacts.picker.ContactPickerServerCommercePageFilter;
import com.facebook.messaging.contacts.picker.ContactPickerTincanThreadsFilter;
import com.facebook.messaging.contacts.picker.ContactPickerViewListAdapter;
import com.facebook.messaging.contacts.picker.util.MessagingContactLoggingHelper;
import com.facebook.orca.contacts.providers.ContactPickerListFilterProviderForFacebookList;
import com.facebook.orca.contacts.providers.ContactPickerListFilterProviderForVoipGroupCallList;
import com.facebook.orca.contacts.providers.MergedDivebarContactPickerListFilterProvider;
import com.facebook.qe.api.QeAccessor;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Provider;

@InjectorModule
/* compiled from: empty response */
public class MessagesContactPickerModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @ForDivebarList
    static ContactPickerListFilter m13931a(SystemClock systemClock, ScheduledExecutorService scheduledExecutorService, FbErrorReporter fbErrorReporter, Resources resources, ContactPickerFriendFilter contactPickerFriendFilter, ContactPickerNonFriendUsersFilter contactPickerNonFriendUsersFilter, ContactPickerDbGroupFilter contactPickerDbGroupFilter, ContactPickerServerGroupFilter contactPickerServerGroupFilter, ContactPickerServerCommercePageFilter contactPickerServerCommercePageFilter, ContactPickerServerAgentPageFilter contactPickerServerAgentPageFilter, ContactPickerTincanThreadsFilter contactPickerTincanThreadsFilter, BusinessSearchGatekeeperUtil businessSearchGatekeeperUtil, Provider<Boolean> provider, QeAccessor qeAccessor) {
        return MergedDivebarContactPickerListFilterProvider.a(systemClock, scheduledExecutorService, fbErrorReporter, resources, contactPickerFriendFilter, contactPickerNonFriendUsersFilter, contactPickerDbGroupFilter, contactPickerServerGroupFilter, contactPickerServerCommercePageFilter, businessSearchGatekeeperUtil.m13110b() ? contactPickerServerAgentPageFilter : null, contactPickerTincanThreadsFilter, qeAccessor.a(ExperimentsForBusinessSearchAbtestModule.a, false), ((Boolean) provider.get()).booleanValue());
    }

    @ProviderMethod
    @ForFacebookList
    public static ContactPickerListFilter m13932a(SystemClock systemClock, ScheduledExecutorService scheduledExecutorService, AbstractFbErrorReporter abstractFbErrorReporter, ContactPickerFriendFilter contactPickerFriendFilter, ContactPickerNonFriendUsersFilter contactPickerNonFriendUsersFilter, Boolean bool) {
        return ContactPickerListFilterProviderForFacebookList.a(systemClock, scheduledExecutorService, abstractFbErrorReporter, contactPickerFriendFilter, contactPickerNonFriendUsersFilter, bool.booleanValue());
    }

    @ProviderMethod
    @ForVoipSearchList
    public static ContactPickerListFilter m13933a(SystemClock systemClock, ScheduledExecutorService scheduledExecutorService, AbstractFbErrorReporter abstractFbErrorReporter, ContactPickerFriendFilter contactPickerFriendFilter, Boolean bool) {
        boolean booleanValue = bool.booleanValue();
        Builder builder = ImmutableList.builder();
        contactPickerFriendFilter.i = true;
        contactPickerFriendFilter.j = true;
        contactPickerFriendFilter.k = booleanValue;
        builder.c(new ContactPickerSubFilterConfig(contactPickerFriendFilter, null, true));
        return new ContactPickerMergedFilter(builder.b(), systemClock, scheduledExecutorService, abstractFbErrorReporter);
    }

    @ProviderMethod
    @ForVoipGroupCallList
    static ContactPickerListFilter m13930a(SystemClock systemClock, ScheduledExecutorService scheduledExecutorService, AbstractFbErrorReporter abstractFbErrorReporter, Resources resources, ContactPickerFriendFilter contactPickerFriendFilter, ContactPickerDbGroupFilter contactPickerDbGroupFilter, ContactPickerServerGroupFilter contactPickerServerGroupFilter) {
        return ContactPickerListFilterProviderForVoipGroupCallList.a(systemClock, scheduledExecutorService, abstractFbErrorReporter, contactPickerFriendFilter, resources, contactPickerDbGroupFilter, contactPickerServerGroupFilter);
    }

    @ProviderMethod
    @ForFacebookList
    public static BaseSearchableContactPickerListAdapter m13928a(ContactPickerViewFactory contactPickerViewFactory, Provider<ContactPickerListFilter> provider) {
        return new ContactPickerViewListAdapter(contactPickerViewFactory, provider);
    }

    @ProviderMethod
    @ForVoipSearchList
    public static BaseSearchableContactPickerListAdapter m13935b(ContactPickerViewFactory contactPickerViewFactory, Provider<ContactPickerListFilter> provider) {
        return new ContactPickerViewListAdapter(contactPickerViewFactory, provider);
    }

    @ProviderMethod
    @ForVoipSelectSearchList
    public static BaseSearchableContactPickerListAdapter m13936c(ContactPickerViewFactory contactPickerViewFactory, Provider<ContactPickerListFilter> provider) {
        return new ContactPickerViewListAdapter(contactPickerViewFactory, provider);
    }

    @ProviderMethod
    @ForVoipGroupCallList
    public static BaseSearchableContactPickerListAdapter m13937d(ContactPickerViewFactory contactPickerViewFactory, Provider<ContactPickerListFilter> provider) {
        return new ContactPickerViewListAdapter(contactPickerViewFactory, provider);
    }

    @ProviderMethod
    @ForFavoritePickerList
    static BaseSearchableContactPickerListAdapter m13938e(ContactPickerViewFactory contactPickerViewFactory, Provider<ContactPickerListFilter> provider) {
        return new ContactPickerViewListAdapter(contactPickerViewFactory, provider);
    }

    @ProviderMethod
    @ForDivebarList
    static BaseSearchableContactPickerListAdapter m13929a(ContactPickerViewFactory contactPickerViewFactory, Provider<ContactPickerListFilter> provider, MessagingContactLoggingHelper messagingContactLoggingHelper) {
        return new ContactPickerViewListAdapter(contactPickerViewFactory, provider, messagingContactLoggingHelper);
    }

    @ProviderMethod
    @ForContactMultiPicker
    static BaseSearchableContactPickerListAdapter m13939f(ContactPickerViewFactory contactPickerViewFactory, Provider<ContactPickerListFilter> provider) {
        return new ContactPickerViewListAdapter(contactPickerViewFactory, provider);
    }

    @ProviderMethod
    @ForUnpinnedGroups
    static BaseSearchableContactPickerListAdapter m13940g(ContactPickerViewFactory contactPickerViewFactory, Provider<ContactPickerListFilter> provider) {
        return new ContactPickerViewListAdapter(contactPickerViewFactory, provider);
    }

    @ProviderMethod
    @ForNotOnMessengerFriends
    static BaseSearchableContactPickerListAdapter m13941h(ContactPickerViewFactory contactPickerViewFactory, Provider<ContactPickerNotOnMessengerFriendsFilter> provider) {
        return new ContactPickerViewListAdapter(contactPickerViewFactory, provider);
    }

    @ProviderMethod
    @ForAllFriends
    static BaseSearchableContactPickerListAdapter m13942i(ContactPickerViewFactory contactPickerViewFactory, Provider<ContactPickerFriendFilter> provider) {
        return new ContactPickerViewListAdapter(contactPickerViewFactory, provider);
    }

    @ProviderMethod
    @ForPaymentEligibleContacts
    static BaseSearchableContactPickerListAdapter m13943j(ContactPickerViewFactory contactPickerViewFactory, Provider<ContactPickerPaymentEligibleContactsFilter> provider) {
        return new ContactPickerViewListAdapter(contactPickerViewFactory, provider);
    }

    @ProviderMethod
    @ForPhoneContactList
    static BaseSearchableContactPickerListAdapter m13944k(ContactPickerViewFactory contactPickerViewFactory, Provider<ContactPickerPhoneContactsFilter> provider) {
        return new ContactPickerViewListAdapter(contactPickerViewFactory, provider);
    }

    @ProviderMethod
    @IsDivebarSupported
    public static Boolean m13934a(Product product) {
        return Boolean.valueOf(product == Product.FB4A);
    }
}
