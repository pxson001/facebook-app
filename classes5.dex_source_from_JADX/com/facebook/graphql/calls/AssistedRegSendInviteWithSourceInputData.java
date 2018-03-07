package com.facebook.graphql.calls;

/* compiled from: related_pages_placeholder */
public final class AssistedRegSendInviteWithSourceInputData extends GraphQlMutationCallInput {
    public final AssistedRegSendInviteWithSourceInputData m4305a(String str) {
        a("first_name", str);
        return this;
    }

    public final AssistedRegSendInviteWithSourceInputData m4306b(String str) {
        a("last_name", str);
        return this;
    }

    public final AssistedRegSendInviteWithSourceInputData m4307c(String str) {
        a("contactpoint", str);
        return this;
    }

    public final AssistedRegSendInviteWithSourceInputData m4304a(Integer num) {
        a("source", num);
        return this;
    }

    public final AssistedRegSendInviteWithSourceInputData m4308d(String str) {
        a("invite_details", str);
        return this;
    }
}
