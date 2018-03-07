package com.facebook.timeline.datafetcher;

import android.os.Process;
import com.facebook.androidcompat.AndroidCompat;
import com.facebook.common.executors.FbAsyncTask;
import com.facebook.contacts.graphql.Contact;
import com.facebook.contacts.graphql.ContactLinkType;
import com.facebook.contacts.iterator.ContactCursorsQuery;
import com.facebook.contacts.iterator.ContactIterator;
import com.facebook.contacts.iterator.ContactIterators;
import com.facebook.inject.Assisted;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.util.concurrent.SettableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: group_edit_description_state */
public class FetchContactCacheTask extends FbAsyncTask<Void, Void, Contact> {
    private final long f10400a;
    private final ContactIterators f10401b;
    public SettableFuture<Contact> f10402c = SettableFuture.f();

    protected void onPostExecute(Object obj) {
        Contact contact = (Contact) obj;
        if (contact != null) {
            FutureDetour.a(this.f10402c, contact, -1672531282);
        }
    }

    @Inject
    public FetchContactCacheTask(@Assisted Long l, ContactIterators contactIterators) {
        this.f10400a = l.longValue();
        this.f10401b = contactIterators;
    }

    @Nullable
    protected final Object m10524a(Object[] objArr) {
        int threadPriority = Process.getThreadPriority(Process.myTid());
        try {
            Process.setThreadPriority(Math.min(0, threadPriority));
            Object a = m10523a(String.valueOf(this.f10400a));
            return a;
        } finally {
            Process.setThreadPriority(threadPriority);
        }
    }

    @Nullable
    private Contact m10523a(String str) {
        Throwable th;
        Throwable th2 = null;
        ContactIterator a = this.f10401b.a(ContactCursorsQuery.a(str).d(ContactLinkType.USERS));
        try {
            Contact contact;
            if (a.hasNext()) {
                contact = (Contact) a.next();
            } else {
                contact = null;
            }
            if (a != null) {
                a.close();
            }
            return contact;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        throw th;
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
    }
}
