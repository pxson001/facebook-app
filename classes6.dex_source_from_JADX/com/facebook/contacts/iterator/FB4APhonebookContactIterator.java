package com.facebook.contacts.iterator;

import android.database.Cursor;
import com.facebook.common.cursors.CachedColumnNameCursorProvider;
import com.facebook.common.cursors.CursorHelper;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.contacts.model.PhonebookAddress;
import com.facebook.contacts.model.PhonebookContact.Builder;
import com.facebook.contacts.model.PhonebookContactMetadata;
import com.facebook.contacts.model.PhonebookEmailAddress;
import com.facebook.contacts.model.PhonebookEvent;
import com.facebook.contacts.model.PhonebookInstantMessaging;
import com.facebook.contacts.model.PhonebookNickname;
import com.facebook.contacts.model.PhonebookOrganization;
import com.facebook.contacts.model.PhonebookPhoneNumber;
import com.facebook.contacts.model.PhonebookRelation;
import com.facebook.contacts.model.PhonebookWebsite;
import com.facebook.contacts.model.PhonebookWhatsappProfile;
import com.facebook.contacts.util.ContactMetadataUtil;
import com.facebook.inject.Assisted;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: pb. */
public class FB4APhonebookContactIterator extends AbstractPhonebookContactIterator {
    private final ContactIteratorAnalyticsLogger f8240d;
    private final ContactMetadataUtil f8241e;
    private final Provider<TriState> f8242f;

    @Inject
    public FB4APhonebookContactIterator(CachedColumnNameCursorProvider cachedColumnNameCursorProvider, ContactIteratorAnalyticsLogger contactIteratorAnalyticsLogger, ContactMetadataUtil contactMetadataUtil, Provider<TriState> provider, @Assisted Cursor cursor) {
        super(cachedColumnNameCursorProvider, cursor);
        this.f8240d = contactIteratorAnalyticsLogger;
        this.f8241e = contactMetadataUtil;
        this.f8242f = provider;
    }

    protected final void mo938a(Builder builder) {
        Object c = CursorHelper.m11026c(this.f8215c, "data1");
        if (StringUtil.a(c)) {
            this.f8240d.m12062a(builder.f8266a, "phone");
            return;
        }
        String c2;
        int a = CursorHelper.m11024a(this.f8215c, "data2");
        String c3 = CursorHelper.m11026c(this.f8215c, "data3");
        if (((TriState) this.f8242f.get()).asBoolean(true)) {
            c2 = CursorHelper.m11026c(this.f8215c, "account_type");
        } else {
            c2 = null;
        }
        builder.m12103a(new PhonebookPhoneNumber(c, a, c3, c2));
    }

    protected final void mo939b(Builder builder) {
        Object c = CursorHelper.m11026c(this.f8215c, "data1");
        if (StringUtil.a(c)) {
            this.f8240d.m12062a(builder.f8266a, "email");
            return;
        }
        String c2;
        int a = CursorHelper.m11024a(this.f8215c, "data2");
        String c3 = CursorHelper.m11026c(this.f8215c, "data3");
        if (((TriState) this.f8242f.get()).asBoolean(true)) {
            c2 = CursorHelper.m11026c(this.f8215c, "account_type");
        } else {
            c2 = null;
        }
        builder.m12102a(new PhonebookEmailAddress(c, a, c3, c2));
    }

    protected final void mo940c(Builder builder) {
        String c = CursorHelper.m11026c(this.f8215c, "data1");
        String c2 = CursorHelper.m11026c(this.f8215c, "data2");
        String c3 = CursorHelper.m11026c(this.f8215c, "data3");
        String c4 = CursorHelper.m11026c(this.f8215c, "data4");
        String c5 = CursorHelper.m11026c(this.f8215c, "data5");
        String c6 = CursorHelper.m11026c(this.f8215c, "data6");
        String c7 = CursorHelper.m11026c(this.f8215c, "data7");
        String c8 = CursorHelper.m11026c(this.f8215c, "data8");
        String c9 = CursorHelper.m11026c(this.f8215c, "data9");
        builder.f8267b = c;
        builder.f8268c = c2;
        builder.f8269d = c3;
        builder.f8270e = c4;
        builder.f8271f = c5;
        builder.f8272g = c6;
        builder.f8273h = c7;
        builder.f8274i = c8;
        builder.f8275j = c9;
    }

    protected final void mo941d(Builder builder) {
        boolean z;
        if (StringUtil.a(CursorHelper.m11026c(this.f8215c, "data14"))) {
            z = false;
        } else {
            z = true;
        }
        builder.f8276k = z;
    }

    protected final void mo942e(Builder builder) {
        boolean z;
        if (StringUtil.a(CursorHelper.m11026c(this.f8215c, "data1"))) {
            z = false;
        } else {
            z = true;
        }
        builder.f8277l = z;
    }

    protected final void mo943f(Builder builder) {
        Object c = CursorHelper.m11026c(this.f8215c, "data1");
        if (!StringUtil.a(c)) {
            PhonebookInstantMessaging phonebookInstantMessaging = new PhonebookInstantMessaging(c, CursorHelper.m11024a(this.f8215c, "data2"), CursorHelper.m11026c(this.f8215c, "data3"), CursorHelper.m11026c(this.f8215c, "data5"), CursorHelper.m11026c(this.f8215c, "data6"));
            if (phonebookInstantMessaging != null) {
                builder.f8280o.add(phonebookInstantMessaging);
            }
        }
    }

    protected final void mo944g(Builder builder) {
        Object c = CursorHelper.m11026c(this.f8215c, "data1");
        if (!StringUtil.a(c)) {
            PhonebookNickname phonebookNickname = new PhonebookNickname(c, CursorHelper.m11024a(this.f8215c, "data2"), CursorHelper.m11026c(this.f8215c, "data3"));
            if (phonebookNickname != null) {
                builder.f8281p.add(phonebookNickname);
            }
        }
    }

    protected final void mo945h(Builder builder) {
        Object c = CursorHelper.m11026c(this.f8215c, "data1");
        if (!StringUtil.a(c)) {
            PhonebookAddress phonebookAddress = new PhonebookAddress(c, CursorHelper.m11024a(this.f8215c, "data2"), CursorHelper.m11026c(this.f8215c, "data3"), CursorHelper.m11026c(this.f8215c, "data4"), CursorHelper.m11026c(this.f8215c, "data5"), CursorHelper.m11026c(this.f8215c, "data6"), CursorHelper.m11026c(this.f8215c, "data7"), CursorHelper.m11026c(this.f8215c, "data8"), CursorHelper.m11026c(this.f8215c, "data9"), CursorHelper.m11026c(this.f8215c, "data10"));
            if (phonebookAddress != null) {
                builder.f8282q.add(phonebookAddress);
            }
        }
    }

    protected final void mo946i(Builder builder) {
        Object c = CursorHelper.m11026c(this.f8215c, "data1");
        if (!StringUtil.a(c)) {
            PhonebookWebsite phonebookWebsite = new PhonebookWebsite(c, CursorHelper.m11024a(this.f8215c, "data2"), CursorHelper.m11026c(this.f8215c, "data3"));
            if (phonebookWebsite != null) {
                builder.f8283r.add(phonebookWebsite);
            }
        }
    }

    protected final void mo947j(Builder builder) {
        Object c = CursorHelper.m11026c(this.f8215c, "data1");
        if (!StringUtil.a(c)) {
            PhonebookRelation phonebookRelation = new PhonebookRelation(c, CursorHelper.m11024a(this.f8215c, "data2"), CursorHelper.m11026c(this.f8215c, "data3"));
            if (phonebookRelation != null) {
                builder.f8284s.add(phonebookRelation);
            }
        }
    }

    protected final void mo948k(Builder builder) {
        Object c = CursorHelper.m11026c(this.f8215c, "data1");
        Object c2 = CursorHelper.m11026c(this.f8215c, "data4");
        if (!StringUtil.a(c) || !StringUtil.a(c2)) {
            PhonebookOrganization phonebookOrganization = new PhonebookOrganization(c, CursorHelper.m11024a(this.f8215c, "data2"), CursorHelper.m11026c(this.f8215c, "data3"), c2, CursorHelper.m11026c(this.f8215c, "data5"), CursorHelper.m11026c(this.f8215c, "data6"), CursorHelper.m11026c(this.f8215c, "data7"), CursorHelper.m11026c(this.f8215c, "data8"), CursorHelper.m11026c(this.f8215c, "data9"));
            if (phonebookOrganization != null) {
                builder.f8285t.add(phonebookOrganization);
            }
        }
    }

    protected final void mo949l(Builder builder) {
        Object c = CursorHelper.m11026c(this.f8215c, "data1");
        if (!StringUtil.a(c)) {
            PhonebookEvent phonebookEvent = new PhonebookEvent(c, CursorHelper.m11024a(this.f8215c, "data2"), CursorHelper.m11026c(this.f8215c, "data3"));
            if (phonebookEvent != null) {
                builder.f8286u.add(phonebookEvent);
            }
        }
    }

    protected final void mo950m(Builder builder) {
        PhonebookContactMetadata a = this.f8241e.m12326a(builder.f8266a);
        if (a != null && a != null) {
            builder.f8287v.add(a);
        }
    }

    protected final void mo951n(Builder builder) {
        Object c = CursorHelper.m11026c(this.f8215c, "data1");
        Object c2 = CursorHelper.m11026c(this.f8215c, "data3");
        if (!StringUtil.a(c) && !StringUtil.a(c2)) {
            PhonebookWhatsappProfile phonebookWhatsappProfile = new PhonebookWhatsappProfile(c, c2.replace("Message", "").trim());
            if (phonebookWhatsappProfile != null) {
                builder.f8288w.add(phonebookWhatsappProfile);
            }
        }
    }
}
