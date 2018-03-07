package com.facebook.facecast.plugin.creativetools;

import com.facebook.facecast.plugin.creativetools.CreativeToolsPack.CreativeToolsPackType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: before_timestamp */
public class CreativeToolsBasicAdjustmentPack implements CreativeToolsPack, Iterable<CreativeToolsBasicAdjustmentFilter> {
    private final List<CreativeToolsBasicAdjustmentFilter> f18670a = new ArrayList();

    public CreativeToolsBasicAdjustmentPack(List<CreativeToolsBasicAdjustmentFilter> list) {
        this.f18670a.addAll(list);
    }

    public final int mo1435a() {
        return 2131238277;
    }

    public final int mo1436b() {
        return 2130839679;
    }

    public final CreativeToolsPackType mo1437c() {
        return CreativeToolsPackType.CREATIVE_TOOLS_PACK_TYPE_BASIC_ADJUSTMENT_FILTER;
    }

    public final String mo1438d() {
        return "filters";
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CreativeToolsBasicAdjustmentPack: ");
        for (CreativeToolsBasicAdjustmentFilter creativeToolsBasicAdjustmentFilter : this.f18670a) {
            stringBuilder.append("\n");
            stringBuilder.append(creativeToolsBasicAdjustmentFilter.toString());
        }
        return stringBuilder.toString();
    }

    public Iterator<CreativeToolsBasicAdjustmentFilter> iterator() {
        return this.f18670a.iterator();
    }

    public final int m22260e() {
        return this.f18670a.size();
    }

    public final CreativeToolsBasicAdjustmentFilter m22256a(int i) {
        return (CreativeToolsBasicAdjustmentFilter) this.f18670a.get(i);
    }
}
