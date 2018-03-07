package com.facebook.messaging.tincan.thrift;

import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.TUnion;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TList;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: cities */
public class SalamanderBody extends TUnion {
    public static boolean f18207a = true;
    private static final TStruct f18208b = new TStruct("SalamanderBody");
    private static final TField f18209c = new TField("link_accepted", (byte) 11, (short) 1);
    private static final TField f18210d = new TField("plain_text", (byte) 11, (short) 3);
    private static final TField f18211e = new TField("attachment_info_list", (byte) 15, (short) 4);
    private static final TField f18212f = new TField("device_local_text", (byte) 11, (short) 5);
    private static final TField f18213g = new TField("sticker_info", (byte) 12, (short) 6);

    public static SalamanderBody m18149a(String str) {
        SalamanderBody salamanderBody = new SalamanderBody();
        salamanderBody.m18154c(str);
        return salamanderBody;
    }

    public static SalamanderBody m18150a(List<AttachmentInfo> list) {
        SalamanderBody salamanderBody = new SalamanderBody();
        salamanderBody.m18153b((List) list);
        return salamanderBody;
    }

    public static SalamanderBody m18151b(String str) {
        SalamanderBody salamanderBody = new SalamanderBody();
        salamanderBody.m18155d(str);
        return salamanderBody;
    }

    public static SalamanderBody m18148a(StickerInfo stickerInfo) {
        SalamanderBody salamanderBody = new SalamanderBody();
        salamanderBody.m18152b(stickerInfo);
        return salamanderBody;
    }

    private String m18156g() {
        if (this.setField_ == 1) {
            return (String) this.value_;
        }
        throw new RuntimeException("Cannot get field 'link_accepted' because union is currently set to " + m18157a(this.setField_).a);
    }

    public final boolean m18161a(SalamanderBody salamanderBody) {
        return this.setField_ == salamanderBody.setField_ && ((this.value_ instanceof byte[]) ? Arrays.equals((byte[]) this.value_, (byte[]) salamanderBody.value_) : this.value_.equals(salamanderBody.value_));
    }

    public final String m18162c() {
        if (this.setField_ == 3) {
            return (String) this.value_;
        }
        throw new RuntimeException("Cannot get field 'plain_text' because union is currently set to " + m18157a(this.setField_).a);
    }

    public final List<AttachmentInfo> m18163d() {
        if (this.setField_ == 4) {
            return (List) this.value_;
        }
        throw new RuntimeException("Cannot get field 'attachment_info_list' because union is currently set to " + m18157a(this.setField_).a);
    }

    public final String m18164e() {
        if (this.setField_ == 5) {
            return (String) this.value_;
        }
        throw new RuntimeException("Cannot get field 'device_local_text' because union is currently set to " + m18157a(this.setField_).a);
    }

    public final StickerInfo m18165f() {
        if (this.setField_ == 6) {
            return (StickerInfo) this.value_;
        }
        throw new RuntimeException("Cannot get field 'sticker_info' because union is currently set to " + m18157a(this.setField_).a);
    }

    public final Object m18158a(TProtocol tProtocol, TField tField) {
        int i = 0;
        switch (tField.c) {
            case (short) 1:
                if (tField.b == f18209c.b) {
                    return tProtocol.p();
                }
                TProtocolUtil.a(tProtocol, tField.b);
                return null;
            case (short) 3:
                if (tField.b == f18210d.b) {
                    return tProtocol.p();
                }
                TProtocolUtil.a(tProtocol, tField.b);
                return null;
            case (short) 4:
                if (tField.b == f18211e.b) {
                    TList h = tProtocol.h();
                    List arrayList = new ArrayList(Math.max(0, h.b));
                    while (true) {
                        if (h.b < 0) {
                            if (!TProtocol.t()) {
                                return arrayList;
                            }
                        } else if (i >= h.b) {
                            return arrayList;
                        }
                        arrayList.add(AttachmentInfo.m18072b(tProtocol));
                        i++;
                    }
                } else {
                    TProtocolUtil.a(tProtocol, tField.b);
                    return null;
                }
            case (short) 5:
                if (tField.b == f18212f.b) {
                    return tProtocol.p();
                }
                TProtocolUtil.a(tProtocol, tField.b);
                return null;
            case (short) 6:
                if (tField.b == f18213g.b) {
                    Long l = null;
                    tProtocol.r();
                    while (true) {
                        TField f = tProtocol.f();
                        if (f.b != (byte) 0) {
                            switch (f.c) {
                                case (short) 2:
                                    if (f.b != (byte) 10) {
                                        TProtocolUtil.a(tProtocol, f.b);
                                        break;
                                    }
                                    l = Long.valueOf(tProtocol.n());
                                    break;
                                default:
                                    TProtocolUtil.a(tProtocol, f.b);
                                    break;
                            }
                        }
                        tProtocol.e();
                        return new StickerInfo(l);
                    }
                }
                TProtocolUtil.a(tProtocol, tField.b);
                return null;
            default:
                TProtocolUtil.a(tProtocol, tField.b);
                return null;
        }
    }

    protected final void m18160a(TProtocol tProtocol, short s) {
        switch (s) {
            case (short) 1:
                tProtocol.a((String) this.value_);
                return;
            case (short) 3:
                tProtocol.a((String) this.value_);
                return;
            case (short) 4:
                List<AttachmentInfo> list = (List) this.value_;
                tProtocol.a(new TList((byte) 12, list.size()));
                for (AttachmentInfo a : list) {
                    a.m18074a(tProtocol);
                }
                return;
            case (short) 5:
                tProtocol.a((String) this.value_);
                return;
            case (short) 6:
                ((StickerInfo) this.value_).m18175a(tProtocol);
                return;
            default:
                throw new IllegalStateException("Cannot write union with unknown field " + s);
        }
    }

    protected final TField m18157a(int i) {
        switch (i) {
            case 1:
                return f18209c;
            case 3:
                return f18210d;
            case 4:
                return f18211e;
            case 5:
                return f18212f;
            case 6:
                return f18213g;
            default:
                throw new IllegalArgumentException("Unknown field id " + i);
        }
    }

    private void m18154c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.setField_ = 3;
        this.value_ = str;
    }

    private void m18153b(List<AttachmentInfo> list) {
        if (list == null) {
            throw new NullPointerException();
        }
        this.setField_ = 4;
        this.value_ = list;
    }

    private void m18155d(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.setField_ = 5;
        this.value_ = str;
    }

    private void m18152b(StickerInfo stickerInfo) {
        if (stickerInfo == null) {
            throw new NullPointerException();
        }
        this.setField_ = 6;
        this.value_ = stickerInfo;
    }

    public boolean equals(Object obj) {
        if (obj instanceof SalamanderBody) {
            return m18161a((SalamanderBody) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return m18159a(1, f18207a);
    }

    public final String m18159a(int i, boolean z) {
        Object obj = 1;
        Object obj2 = null;
        String a = z ? TBaseHelper.a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("SalamanderBody");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        if (this.setField_ == 1) {
            stringBuilder.append(a);
            stringBuilder.append("link_accepted");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m18156g() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(m18156g(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 3) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("plain_text");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m18162c() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(m18162c(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 4) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("attachment_info_list");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m18163d() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(m18163d(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 5) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("device_local_text");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m18164e() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(m18164e(), i + 1, z));
            }
        } else {
            obj2 = obj;
        }
        if (this.setField_ == 6) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("sticker_info");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m18165f() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(m18165f(), i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
