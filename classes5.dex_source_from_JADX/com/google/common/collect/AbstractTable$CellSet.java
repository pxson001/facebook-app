package com.google.common.collect;

import com.google.common.collect.Table.Cell;
import com.google.common.collect.Tables.AbstractCell;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: calling getInputStream() on FakeSocketImpl */
public class AbstractTable$CellSet extends AbstractSet<Cell<R, C, V>> {
    final /* synthetic */ AbstractTable f7292a;

    public AbstractTable$CellSet(AbstractTable abstractTable) {
        this.f7292a = abstractTable;
    }

    public boolean contains(Object obj) {
        if (!(obj instanceof AbstractCell)) {
            return false;
        }
        AbstractCell abstractCell = (AbstractCell) obj;
        Map map = (Map) Maps.a(this.f7292a.e(), abstractCell.mo1002a());
        if (map == null || !Collections2.a(map.entrySet(), Maps.a(abstractCell.mo1003b(), abstractCell.mo1004c()))) {
            return false;
        }
        return true;
    }

    public boolean remove(@Nullable Object obj) {
        if (!(obj instanceof AbstractCell)) {
            return false;
        }
        AbstractCell abstractCell = (AbstractCell) obj;
        Map map = (Map) Maps.a(this.f7292a.e(), abstractCell.mo1002a());
        if (map == null || !Collections2.b(map.entrySet(), Maps.a(abstractCell.mo1003b(), abstractCell.mo1004c()))) {
            return false;
        }
        return true;
    }

    public void clear() {
        this.f7292a.a();
    }

    public Iterator<Cell<R, C, V>> iterator() {
        return this.f7292a.c();
    }

    public int size() {
        return this.f7292a.f();
    }
}
