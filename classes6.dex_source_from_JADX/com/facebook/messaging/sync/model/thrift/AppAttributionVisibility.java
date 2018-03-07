package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: universalNumber */
public class AppAttributionVisibility implements TBase, Serializable, Cloneable {
    public static boolean f2447a = true;
    private static final TStruct f2448b = new TStruct("AppAttributionVisibility");
    private static final TField f2449c = new TField("hideAttribution", (byte) 2, (short) 1);
    private static final TField f2450d = new TField("hideInstallButton", (byte) 2, (short) 2);
    private static final TField f2451e = new TField("hideReplyButton", (byte) 2, (short) 3);
    private static final TField f2452f = new TField("disableBroadcasting", (byte) 2, (short) 4);
    private static final TField f2453g = new TField("hideAppIcon", (byte) 2, (short) 5);
    public final Boolean disableBroadcasting;
    public final Boolean hideAppIcon;
    public final Boolean hideAttribution;
    public final Boolean hideInstallButton;
    public final Boolean hideReplyButton;

    private AppAttributionVisibility(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5) {
        this.hideAttribution = bool;
        this.hideInstallButton = bool2;
        this.hideReplyButton = bool3;
        this.disableBroadcasting = bool4;
        this.hideAppIcon = bool5;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AppAttributionVisibility)) {
            return m3670a((AppAttributionVisibility) obj);
        }
        return false;
    }

    public final boolean m3670a(AppAttributionVisibility appAttributionVisibility) {
        if (appAttributionVisibility == null) {
            return false;
        }
        boolean z;
        boolean z2 = this.hideAttribution != null;
        if (appAttributionVisibility.hideAttribution != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.hideAttribution.equals(appAttributionVisibility.hideAttribution))) {
            return false;
        }
        if (this.hideInstallButton != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (appAttributionVisibility.hideInstallButton != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.hideInstallButton.equals(appAttributionVisibility.hideInstallButton))) {
            return false;
        }
        if (this.hideReplyButton != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (appAttributionVisibility.hideReplyButton != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.hideReplyButton.equals(appAttributionVisibility.hideReplyButton))) {
            return false;
        }
        if (this.disableBroadcasting != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (appAttributionVisibility.disableBroadcasting != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.disableBroadcasting.equals(appAttributionVisibility.disableBroadcasting))) {
            return false;
        }
        if (this.hideAppIcon != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (appAttributionVisibility.hideAppIcon != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.hideAppIcon.equals(appAttributionVisibility.hideAppIcon))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return 0;
    }

    public static AppAttributionVisibility m3667b(TProtocol tProtocol) {
        Boolean bool = null;
        tProtocol.r();
        Boolean bool2 = null;
        Boolean bool3 = null;
        Boolean bool4 = null;
        Boolean bool5 = null;
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                switch (f.c) {
                    case (short) 1:
                        if (f.b != (byte) 2) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        bool5 = Boolean.valueOf(tProtocol.j());
                        break;
                    case (short) 2:
                        if (f.b != (byte) 2) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        bool4 = Boolean.valueOf(tProtocol.j());
                        break;
                    case (short) 3:
                        if (f.b != (byte) 2) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        bool3 = Boolean.valueOf(tProtocol.j());
                        break;
                    case (short) 4:
                        if (f.b != (byte) 2) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        bool2 = Boolean.valueOf(tProtocol.j());
                        break;
                    case (short) 5:
                        if (f.b != (byte) 2) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        bool = Boolean.valueOf(tProtocol.j());
                        break;
                    default:
                        TProtocolUtil.m7816a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            return new AppAttributionVisibility(bool5, bool4, bool3, bool2, bool);
        }
    }

    public final void m3669a(TProtocol tProtocol) {
        tProtocol.a();
        if (!(this.hideAttribution == null || this.hideAttribution == null)) {
            tProtocol.a(f2449c);
            tProtocol.a(this.hideAttribution.booleanValue());
        }
        if (!(this.hideInstallButton == null || this.hideInstallButton == null)) {
            tProtocol.a(f2450d);
            tProtocol.a(this.hideInstallButton.booleanValue());
        }
        if (!(this.hideReplyButton == null || this.hideReplyButton == null)) {
            tProtocol.a(f2451e);
            tProtocol.a(this.hideReplyButton.booleanValue());
        }
        if (!(this.disableBroadcasting == null || this.disableBroadcasting == null)) {
            tProtocol.a(f2452f);
            tProtocol.a(this.disableBroadcasting.booleanValue());
        }
        if (!(this.hideAppIcon == null || this.hideAppIcon == null)) {
            tProtocol.a(f2453g);
            tProtocol.a(this.hideAppIcon.booleanValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3668a(1, f2447a);
    }

    public final String m3668a(int i, boolean z) {
        Object obj = null;
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("AppAttributionVisibility");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        Object obj2 = 1;
        if (this.hideAttribution != null) {
            stringBuilder.append(a);
            stringBuilder.append("hideAttribution");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.hideAttribution == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.hideAttribution, i + 1, z));
            }
            obj2 = null;
        }
        if (this.hideInstallButton != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("hideInstallButton");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.hideInstallButton == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.hideInstallButton, i + 1, z));
            }
            obj2 = null;
        }
        if (this.hideReplyButton != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("hideReplyButton");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.hideReplyButton == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.hideReplyButton, i + 1, z));
            }
            obj2 = null;
        }
        if (this.disableBroadcasting != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("disableBroadcasting");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.disableBroadcasting == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.disableBroadcasting, i + 1, z));
            }
        } else {
            obj = obj2;
        }
        if (this.hideAppIcon != null) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("hideAppIcon");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.hideAppIcon == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.hideAppIcon, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
