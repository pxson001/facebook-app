package org.whispersystems.libsignal.state;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.whispersystems.libsignal.state.StorageProtos.RecordStructure;
import org.whispersystems.libsignal.state.StorageProtos.RecordStructure.Builder;
import org.whispersystems.libsignal.state.StorageProtos.SessionStructure;

/* compiled from: action_delete_payment_card */
public class SessionRecord {
    public SessionState f21356a;
    public LinkedList<SessionState> f21357b;
    public boolean f21358c;

    public SessionRecord() {
        this.f21356a = new SessionState();
        this.f21357b = new LinkedList();
        this.f21358c = false;
        this.f21358c = true;
    }

    public SessionRecord(byte[] bArr) {
        this.f21356a = new SessionState();
        this.f21357b = new LinkedList();
        this.f21358c = false;
        RecordStructure recordStructure = (RecordStructure) RecordStructure.f21380a.m20167a(bArr);
        this.f21356a = new SessionState(recordStructure.currentSession_);
        this.f21358c = false;
        for (SessionStructure sessionState : recordStructure.previousSessions_) {
            this.f21357b.add(new SessionState(sessionState));
        }
    }

    public final SessionState m21908a() {
        return this.f21356a;
    }

    public final List<SessionState> m21910b() {
        return this.f21357b;
    }

    public final boolean m21912c() {
        return this.f21358c;
    }

    public final void m21913d() {
        m21909a(new SessionState());
    }

    public final void m21909a(SessionState sessionState) {
        this.f21357b.addFirst(this.f21356a);
        this.f21356a = sessionState;
        if (this.f21357b.size() > 40) {
            this.f21357b.removeLast();
        }
    }

    public final void m21911b(SessionState sessionState) {
        this.f21356a = sessionState;
    }

    public final byte[] m21914e() {
        Iterable linkedList = new LinkedList();
        Iterator it = this.f21357b.iterator();
        while (it.hasNext()) {
            linkedList.add(((SessionState) it.next()).f21362a);
        }
        return Builder.m22043u().m22050a(this.f21356a.f21362a).mo938a(linkedList).m22064l().lP_();
    }
}
