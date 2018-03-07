package com.fasterxml.jackson.core.sym;

/* compiled from: graphql_skip_fetching_email_addresses */
public final class Name1 extends Name {
    public static final Name1 f21921c = new Name1("", 0, 0);
    final int f21922d;

    Name1(String str, int i, int i2) {
        super(str, i);
        this.f21922d = i2;
    }

    public static Name1 m29731b() {
        return f21921c;
    }

    public final boolean mo3210a(int i) {
        return i == this.f21922d;
    }

    public final boolean mo3211a(int i, int i2) {
        return i == this.f21922d && i2 == 0;
    }

    public final boolean mo3212a(int[] iArr, int i) {
        return i == 1 && iArr[0] == this.f21922d;
    }
}
