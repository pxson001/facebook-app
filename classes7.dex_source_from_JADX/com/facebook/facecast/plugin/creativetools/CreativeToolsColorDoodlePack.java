package com.facebook.facecast.plugin.creativetools;

import com.facebook.facecast.plugin.creativetools.CreativeToolsPack.CreativeToolsPackType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: beeper_caused_comment */
public class CreativeToolsColorDoodlePack implements CreativeToolsPack, Iterable<CreativeToolsColorDoodle> {
    private final List<CreativeToolsColorDoodle> f18687a = new ArrayList();

    public CreativeToolsColorDoodlePack(List<CreativeToolsColorDoodle> list) {
        this.f18687a.addAll(list);
    }

    public final int mo1435a() {
        return 2131238278;
    }

    public final int mo1436b() {
        return 2130840013;
    }

    public final CreativeToolsPackType mo1437c() {
        return CreativeToolsPackType.CREATIVE_TOOLS_PACK_TYPE_COLOR_DOODLE;
    }

    public final String mo1438d() {
        return "draw";
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CreativeToolsColorDoodlePack: ");
        for (CreativeToolsColorDoodle creativeToolsColorDoodle : this.f18687a) {
            stringBuilder.append("\n");
            stringBuilder.append(creativeToolsColorDoodle.toString());
        }
        return stringBuilder.toString();
    }

    public Iterator<CreativeToolsColorDoodle> iterator() {
        return this.f18687a.iterator();
    }
}
