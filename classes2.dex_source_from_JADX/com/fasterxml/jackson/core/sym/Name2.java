package com.fasterxml.jackson.core.sym;

/* compiled from: graphql_tags_search */
public final class Name2 extends Name {
    final int f21895c;
    final int f21896d;

    Name2(String str, int i, int i2, int i3) {
        super(str, i);
        this.f21895c = i2;
        this.f21896d = i3;
    }

    public final boolean mo3210a(int i) {
        return false;
    }

    public final boolean mo3211a(int i, int i2) {
        return i == this.f21895c && i2 == this.f21896d;
    }

    public final boolean mo3212a(int[] iArr, int i) {
        return i == 2 && iArr[0] == this.f21895c && iArr[1] == this.f21896d;
    }
}
