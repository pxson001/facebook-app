package com.facebook.livephotos.player;

import java.util.LinkedList;
import java.util.ListIterator;

/* compiled from: onViewDismissed _really_ unexpected. */
public class Choreographer {
    public ChoreographerEvent[] f7747a;
    public int f7748b = 0;
    public LinkedList<ChoreographerEvent> f7749c = new LinkedList();

    public Choreographer(ChoreographerEvent[] choreographerEventArr) {
        this.f7747a = choreographerEventArr;
    }

    public final void m9372a(TrackContext[] trackContextArr, long j) {
        while (this.f7748b < this.f7747a.length) {
            Object obj;
            if (j >= this.f7747a[this.f7748b].f7743a) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                break;
            }
            LinkedList linkedList = this.f7749c;
            ChoreographerEvent[] choreographerEventArr = this.f7747a;
            int i = this.f7748b;
            this.f7748b = i + 1;
            linkedList.add(choreographerEventArr[i]);
        }
        if (this.f7749c.size() > 0) {
            m9371b(trackContextArr, j);
        }
    }

    private void m9371b(TrackContext[] trackContextArr, long j) {
        ListIterator listIterator = this.f7749c.listIterator();
        while (listIterator.hasNext()) {
            Object obj;
            ChoreographerEvent choreographerEvent = (ChoreographerEvent) listIterator.next();
            choreographerEvent.mo443a(trackContextArr[choreographerEvent.f7745c], j);
            if (j > choreographerEvent.f7743a + choreographerEvent.f7744b) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                listIterator.remove();
            }
        }
    }
}
