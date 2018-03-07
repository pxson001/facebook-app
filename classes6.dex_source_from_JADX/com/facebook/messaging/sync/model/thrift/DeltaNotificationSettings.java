package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TList;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: typeahead_section */
public class DeltaNotificationSettings implements TBase, Serializable, Cloneable {
    public static boolean f2586a = true;
    private static final TStruct f2587b = new TStruct("DeltaNotificationSettings");
    private static final TField f2588c = new TField("threadKey", (byte) 12, (short) 1);
    private static final TField f2589d = new TField("doNotDisturbRanges", (byte) 15, (short) 2);
    public final List<NotificationDoNotDisturbRange> doNotDisturbRanges;
    public final ThreadKey threadKey;

    private DeltaNotificationSettings(ThreadKey threadKey, List<NotificationDoNotDisturbRange> list) {
        this.threadKey = threadKey;
        this.doNotDisturbRanges = list;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeltaNotificationSettings)) {
            return false;
        }
        DeltaNotificationSettings deltaNotificationSettings = (DeltaNotificationSettings) obj;
        boolean z = false;
        if (deltaNotificationSettings != null) {
            Object obj2;
            Object obj3 = this.threadKey != null ? 1 : null;
            if (deltaNotificationSettings.threadKey != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.threadKey.m3939a(deltaNotificationSettings.threadKey))) {
                if (this.doNotDisturbRanges != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (deltaNotificationSettings.doNotDisturbRanges != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.doNotDisturbRanges.equals(deltaNotificationSettings.doNotDisturbRanges))) {
                    z = true;
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public static DeltaNotificationSettings m3754b(TProtocol tProtocol) {
        List list = null;
        tProtocol.r();
        ThreadKey threadKey = null;
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                switch (f.c) {
                    case (short) 1:
                        if (f.b != (byte) 12) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        threadKey = ThreadKey.m3936b(tProtocol);
                        break;
                    case (short) 2:
                        if (f.b != (byte) 15) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        TList h = tProtocol.h();
                        List arrayList = new ArrayList(Math.max(0, h.b));
                        int i = 0;
                        while (true) {
                            if (h.b < 0) {
                                if (!TProtocol.t()) {
                                    list = arrayList;
                                    break;
                                }
                            } else if (i >= h.b) {
                                list = arrayList;
                            }
                            arrayList.add(NotificationDoNotDisturbRange.m3922b(tProtocol));
                            i++;
                        }
                    default:
                        TProtocolUtil.m7816a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            return new DeltaNotificationSettings(threadKey, list);
        }
    }

    public final void m3756a(TProtocol tProtocol) {
        tProtocol.a();
        if (!(this.threadKey == null || this.threadKey == null)) {
            tProtocol.a(f2588c);
            this.threadKey.m3938a(tProtocol);
        }
        if (!(this.doNotDisturbRanges == null || this.doNotDisturbRanges == null)) {
            tProtocol.a(f2589d);
            tProtocol.a(new TList((byte) 12, this.doNotDisturbRanges.size()));
            for (NotificationDoNotDisturbRange a : this.doNotDisturbRanges) {
                a.m3924a(tProtocol);
            }
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3755a(1, f2586a);
    }

    public final String m3755a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaNotificationSettings");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        Object obj = 1;
        if (this.threadKey != null) {
            stringBuilder.append(a);
            stringBuilder.append("threadKey");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.threadKey == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.threadKey, i + 1, z));
            }
            obj = null;
        }
        if (this.doNotDisturbRanges != null) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("doNotDisturbRanges");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.doNotDisturbRanges == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.doNotDisturbRanges, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
