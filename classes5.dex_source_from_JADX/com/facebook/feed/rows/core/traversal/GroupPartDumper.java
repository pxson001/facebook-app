package com.facebook.feed.rows.core.traversal;

import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.multirow.api.MultiRowGroupPartDefinition;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.multirow.api.SinglePartDefinitionWithViewTypeAndIsNeeded;
import java.io.PrintWriter;

/* compiled from: WWW_SEARCH_LOCAL_PUSH */
public class GroupPartDumper<P, S, E extends AnyEnvironment> extends BaseMultiRowSubParts<E> {
    private final E f12271a;
    private final PrintWriter f12272b;
    private int f12273c = 0;

    public GroupPartDumper(PrintWriter printWriter, E e) {
        this.f12272b = printWriter;
        this.f12271a = e;
    }

    public final <P> boolean m20303a(MultiRowPartWithIsNeeded<P, ? super E> multiRowPartWithIsNeeded, P p) {
        if (multiRowPartWithIsNeeded instanceof MultiRowGroupPartDefinition) {
            return a((MultiRowGroupPartDefinition) multiRowPartWithIsNeeded, p);
        }
        if (multiRowPartWithIsNeeded instanceof MultiRowSinglePartDefinition) {
            return a((MultiRowSinglePartDefinition) multiRowPartWithIsNeeded, p);
        }
        return false;
    }

    public final <P> boolean m20302a(MultiRowGroupPartDefinition<P, ?, ? super E> multiRowGroupPartDefinition, P p) {
        if (multiRowGroupPartDefinition.a(p)) {
            m20300a("+ " + multiRowGroupPartDefinition);
            this.f12273c++;
            multiRowGroupPartDefinition.a(this, p, this.f12271a);
            this.f12273c--;
            return true;
        }
        m20300a("N " + multiRowGroupPartDefinition);
        return false;
    }

    public final <P> boolean m20301a(SinglePartDefinitionWithViewTypeAndIsNeeded<P, ?, ? super E, ?> singlePartDefinitionWithViewTypeAndIsNeeded, P p) {
        if (singlePartDefinitionWithViewTypeAndIsNeeded.a(p)) {
            m20300a("Y " + singlePartDefinitionWithViewTypeAndIsNeeded);
            return true;
        }
        m20300a("N " + singlePartDefinitionWithViewTypeAndIsNeeded);
        return false;
    }

    private void m20300a(String str) {
        for (int i = 0; i < this.f12273c; i++) {
            this.f12272b.print("  ");
        }
        this.f12272b.println(str);
    }
}
