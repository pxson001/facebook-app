package com.facebook.contacts.graphql;

import com.facebook.common.util.TriState;
import com.facebook.contacts.graphql.ContactGraphQLModels$ContactModel.NameEntriesModel;
import com.facebook.contacts.graphql.contactprofiletype.ContactProfileType;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.user.model.Name;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;

/* compiled from: recent_privacy_option */
public class ContactBuilder {
    public ContactProfileType f3624A;
    public ContactGraphQLModels$CoverPhotoModel f3625B;
    public ImmutableList<NameEntriesModel> f3626C;
    public ImmutableList<String> f3627D;
    public long f3628E;
    public int f3629F;
    public int f3630G;
    public String f3631H;
    public boolean f3632I;
    public long f3633J;
    public long f3634K;
    public boolean f3635L;
    public float f3636M;
    public String f3637N;
    public float f3638O;
    public String f3639a;
    public String f3640b;
    public String f3641c;
    public Name f3642d;
    public String f3643e;
    public String f3644f;
    public String f3645g;
    public Name f3646h;
    public String f3647i;
    public String f3648j;
    public String f3649k;
    public int f3650l;
    public int f3651m;
    public int f3652n;
    public float f3653o;
    public float f3654p;
    public ImmutableList<ContactPhone> f3655q;
    public boolean f3656r;
    public boolean f3657s;
    public GraphQLFriendshipStatus f3658t;
    public GraphQLSubscribeStatus f3659u;
    public TriState f3660v;
    public boolean f3661w;
    public long f3662x;
    public boolean f3663y;
    public boolean f3664z;

    public ContactBuilder() {
        this.f3660v = TriState.UNSET;
        this.f3655q = RegularImmutableList.a;
        this.f3626C = RegularImmutableList.a;
        this.f3627D = RegularImmutableList.a;
    }

    public ContactBuilder(Contact contact) {
        this.f3660v = TriState.UNSET;
        this.f3639a = contact.m4067b();
        this.f3640b = contact.m4068c();
        this.f3641c = contact.m4069d();
        this.f3642d = contact.m4070e();
        if (this.f3642d != null) {
            this.f3643e = this.f3642d.g();
            this.f3644f = this.f3642d.a();
            this.f3645g = this.f3642d.c();
        }
        this.f3646h = contact.m4071f();
        this.f3647i = contact.m4072g();
        this.f3648j = contact.m4073h();
        this.f3649k = contact.m4074i();
        this.f3650l = contact.m4075j();
        this.f3651m = contact.m4076k();
        this.f3652n = contact.m4077l();
        this.f3653o = contact.m4078m();
        this.f3654p = contact.m4079n();
        this.f3655q = contact.m4080o();
        this.f3657s = contact.m4082q();
        this.f3658t = contact.m4089x();
        this.f3659u = contact.m4090y();
        this.f3660v = contact.m4083r();
        this.f3661w = contact.m4084s();
        this.f3663y = contact.m4086u();
        this.f3664z = contact.m4087v();
        this.f3624A = contact.m4053A();
        this.f3625B = contact.m4054B();
        this.f3626C = contact.m4055C();
        this.f3627D = contact.m4091z();
        this.f3628E = contact.m4088w();
        this.f3632I = contact.m4058F();
        this.f3636M = contact.m4063K();
        this.f3637N = contact.m4064L();
        this.f3638O = contact.m4065M();
    }

    public final ContactBuilder m4094e(boolean z) {
        this.f3664z = z;
        return this;
    }

    public final ContactBuilder m4093a(int i, int i2) {
        this.f3629F = i;
        this.f3630G = i2;
        return this;
    }

    public final Contact m4092P() {
        return new Contact(this);
    }
}
