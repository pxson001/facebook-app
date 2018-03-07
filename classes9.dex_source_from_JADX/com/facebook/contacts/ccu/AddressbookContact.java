package com.facebook.contacts.ccu;

import android.text.TextUtils;
import com.facebook.graphql.calls.ContactUploadSessionCreateAndMaybeBatchUploadInputData.Contacts;
import com.facebook.graphql.calls.ContactUploadSessionCreateAndMaybeBatchUploadInputData.Contacts.Emails;
import com.facebook.graphql.calls.ContactUploadSessionCreateAndMaybeBatchUploadInputData.Contacts.Phones;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.google.common.base.Charsets;
import com.google.common.hash.Hashing.Sha256Holder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: profile_image_height */
public class AddressbookContact {
    public final String f6186a;
    public final Set<String> f6187b;
    public final Set<String> f6188c;
    public String f6189d;
    public String f6190e;
    public String f6191f;
    public Modifier f6192g = null;

    /* compiled from: profile_image_height */
    public enum Modifier {
        ADD,
        REMOVE,
        UPDATE
    }

    public AddressbookContact(String str) {
        this.f6186a = str;
        this.f6187b = new HashSet();
        this.f6188c = new HashSet();
    }

    public final Long m6520a() {
        return Long.valueOf(Long.parseLong(this.f6186a));
    }

    public String toString() {
        Iterable arrayList = new ArrayList(this.f6188c);
        Iterable arrayList2 = new ArrayList(this.f6187b);
        Collections.sort(arrayList);
        Collections.sort(arrayList2);
        return TextUtils.join(";", new String[]{this.f6186a, this.f6189d, this.f6190e, this.f6191f, TextUtils.join(",", arrayList), TextUtils.join(",", arrayList2)});
    }

    public static List<Contacts> m6519b(List<AddressbookContact> list) {
        List<Contacts> arrayList = new ArrayList(list.size());
        for (AddressbookContact addressbookContact : list) {
            List arrayList2 = new ArrayList(addressbookContact.f6188c.size());
            for (String str : addressbookContact.f6188c) {
                Phones phones = new Phones();
                phones.a("value", str);
                arrayList2.add(phones);
            }
            List arrayList3 = new ArrayList(addressbookContact.f6187b.size());
            for (String str2 : addressbookContact.f6187b) {
                Emails emails = new Emails();
                emails.a("value", str2);
                arrayList3.add(emails);
            }
            Contacts contacts = new Contacts();
            contacts.a("record_id", addressbookContact.f6186a);
            GraphQlCallInput graphQlCallInput = contacts;
            graphQlCallInput.a("modifier", com.facebook.graphql.calls.ContactUploadSessionCreateAndMaybeBatchUploadInputData.Contacts.Modifier.valueOf(addressbookContact.f6192g.toString()));
            graphQlCallInput = graphQlCallInput;
            graphQlCallInput.a("name", addressbookContact.f6189d);
            graphQlCallInput = graphQlCallInput;
            graphQlCallInput.a("first_name", addressbookContact.f6190e);
            graphQlCallInput = graphQlCallInput;
            graphQlCallInput.a("last_name", addressbookContact.f6191f);
            graphQlCallInput = graphQlCallInput;
            graphQlCallInput.a("phones", arrayList2);
            graphQlCallInput = graphQlCallInput;
            graphQlCallInput.a("emails", arrayList3);
            graphQlCallInput = graphQlCallInput;
            graphQlCallInput.a("minimal_hash", addressbookContact.m6521c());
            graphQlCallInput = graphQlCallInput;
            graphQlCallInput.a("extended_hash", addressbookContact.m6521c());
            arrayList.add(graphQlCallInput);
        }
        return arrayList;
    }

    public final String m6521c() {
        return Sha256Holder.a.a(toString(), Charsets.UTF_8).toString();
    }
}
