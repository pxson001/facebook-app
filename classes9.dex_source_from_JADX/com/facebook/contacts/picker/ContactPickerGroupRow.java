package com.facebook.contacts.picker;

import com.facebook.messaging.model.threads.ThreadSummary;
import com.google.common.collect.ImmutableList;
import java.util.LinkedList;
import java.util.List;

/* compiled from: prepare_payment_method */
public class ContactPickerGroupRow extends PickableContactPickerRow {
    public final ThreadSummary f6312a;
    public final ContactPickerRowSectionType f6313b;
    private final String f6314c;
    public final GroupMenuHandler f6315d;
    private boolean f6316e;
    public boolean f6317f;
    public boolean f6318g = false;
    public boolean f6319h;
    public boolean f6320i = false;
    public boolean f6321j = false;
    public boolean f6322k = false;
    public String f6323l;
    public String f6324m;
    private List<Integer> f6325n;
    public long f6326o;
    public int f6327p = 1;

    /* compiled from: prepare_payment_method */
    public interface GroupMenuHandler {
        boolean m6735a();
    }

    /* compiled from: prepare_payment_method */
    public enum GroupRowSectionType implements ContactPickerRowSectionType {
        UNKNOWN,
        SEARCH_RESULT,
        AUTO_COMPLETE,
        SUGGESTIONS,
        CALL_LOG,
        ONGOING_GROUP_CALL,
        NULL_STATE_TOP_GROUP
    }

    public ContactPickerGroupRow(ThreadSummary threadSummary, ContactPickerRowSectionType contactPickerRowSectionType, String str, GroupMenuHandler groupMenuHandler) {
        this.f6312a = threadSummary;
        this.f6313b = contactPickerRowSectionType;
        this.f6314c = str;
        this.f6315d = groupMenuHandler;
        this.f6325n = new LinkedList();
    }

    public final void mo248a(boolean z) {
        this.f6316e = z;
    }

    public final boolean mo250d() {
        return this.f6316e;
    }

    public final void mo249b(boolean z) {
        this.f6317f = z;
    }

    public String toString() {
        return this.f6314c;
    }

    public final void m6742d(boolean z) {
        this.f6320i = z;
    }

    public final void m6744e(boolean z) {
        this.f6321j = z;
    }

    public final void m6739a(String str) {
        this.f6323l = str;
    }

    public final ImmutableList<Integer> m6745m() {
        return ImmutableList.copyOf(this.f6325n);
    }
}
