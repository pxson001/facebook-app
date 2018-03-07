package com.google.zxing.common;

import com.google.zxing.DecodeHintType;
import java.util.Map;

/* compiled from: event_prompt_action_button_click */
public final class StringUtils {
    private static final String f13504a = System.getProperty("file.encoding");
    private static final boolean f13505b;

    static {
        boolean z = "SJIS".equalsIgnoreCase(f13504a) || "EUC_JP".equalsIgnoreCase(f13504a);
        f13505b = z;
    }

    private StringUtils() {
    }

    public static String m13699a(byte[] bArr, Map<DecodeHintType, ?> map) {
        Object obj;
        if (map != null) {
            String str = (String) map.get(DecodeHintType.CHARACTER_SET);
            if (str != null) {
                return str;
            }
        }
        int length = bArr.length;
        Object obj2 = 1;
        Object obj3 = 1;
        Object obj4 = 1;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        Object obj5 = (bArr.length > 3 && bArr[0] == (byte) -17 && bArr[1] == (byte) -69 && bArr[2] == (byte) -65) ? 1 : null;
        int i11 = 0;
        int i12 = 0;
        while (i11 < length && (obj2 != null || obj3 != null || obj4 != null)) {
            int i13;
            Object obj6;
            int i14;
            Object obj7;
            Object obj8;
            int i15;
            int i16 = bArr[i11] & 255;
            if (obj4 != null) {
                if (i12 > 0) {
                    if ((i16 & 128) != 0) {
                        i13 = i12 - 1;
                        obj6 = obj4;
                        if (obj2 != null) {
                            if (i16 <= 127 && i16 < 160) {
                                i14 = i10;
                                obj7 = null;
                                if (obj3 == null) {
                                    i12 = i9;
                                    i9 = i8;
                                    i8 = i7;
                                    i7 = i6;
                                    i6 = i5;
                                    i5 = i4;
                                    obj8 = obj3;
                                } else if (i4 > 0) {
                                    if (i16 != 128) {
                                    }
                                    i15 = i9;
                                    i9 = i8;
                                    i8 = i7;
                                    i7 = i6;
                                    i6 = i5;
                                    i5 = i4;
                                    obj8 = null;
                                    i12 = i15;
                                } else {
                                    if (i16 >= 64) {
                                    }
                                    i15 = i9;
                                    i9 = i8;
                                    i8 = i7;
                                    i7 = i6;
                                    i6 = i5;
                                    i5 = i4;
                                    obj8 = null;
                                    i12 = i15;
                                }
                                i11++;
                                obj2 = obj7;
                                obj3 = obj8;
                                i10 = i14;
                                i4 = i5;
                                obj4 = obj6;
                                i5 = i6;
                                i6 = i7;
                                i7 = i8;
                                i8 = i9;
                                i9 = i12;
                                i12 = i13;
                            } else if (i16 > 159 && (i16 < 192 || i16 == 215 || i16 == 247)) {
                                i14 = i10 + 1;
                                obj7 = obj2;
                                if (obj3 == null) {
                                    i12 = i9;
                                    i9 = i8;
                                    i8 = i7;
                                    i7 = i6;
                                    i6 = i5;
                                    i5 = i4;
                                    obj8 = obj3;
                                } else if (i4 > 0) {
                                    if (i16 >= 64 || i16 == 127 || i16 > 252) {
                                        i15 = i9;
                                        i9 = i8;
                                        i8 = i7;
                                        i7 = i6;
                                        i6 = i5;
                                        i5 = i4;
                                        obj8 = null;
                                        i12 = i15;
                                    } else {
                                        i12 = i4 - 1;
                                        obj8 = obj3;
                                        i15 = i8;
                                        i8 = i7;
                                        i7 = i6;
                                        i6 = i5;
                                        i5 = i12;
                                        i12 = i9;
                                        i9 = i15;
                                    }
                                } else if (i16 != 128 || i16 == 160 || i16 > 239) {
                                    i15 = i9;
                                    i9 = i8;
                                    i8 = i7;
                                    i7 = i6;
                                    i6 = i5;
                                    i5 = i4;
                                    obj8 = null;
                                    i12 = i15;
                                } else if (i16 > 160 && i16 < 224) {
                                    i5++;
                                    i12 = i6 + 1;
                                    if (i12 > i8) {
                                        i8 = 0;
                                        i6 = i5;
                                        i7 = i12;
                                        i5 = i4;
                                        obj8 = obj3;
                                        i15 = i9;
                                        i9 = i12;
                                        i12 = i15;
                                    } else {
                                        i6 = i5;
                                        i5 = i4;
                                        obj8 = obj3;
                                        i15 = i12;
                                        i12 = i9;
                                        i9 = i8;
                                        i8 = 0;
                                        i7 = i15;
                                    }
                                } else if (i16 > 127) {
                                    i4++;
                                    i12 = i7 + 1;
                                    if (i12 > i9) {
                                        i9 = i8;
                                        i7 = 0;
                                        i8 = i12;
                                        i6 = i5;
                                        i5 = i4;
                                        obj8 = obj3;
                                    } else {
                                        i7 = 0;
                                        i6 = i5;
                                        i5 = i4;
                                        obj8 = obj3;
                                        i15 = i8;
                                        i8 = i12;
                                        i12 = i9;
                                        i9 = i15;
                                    }
                                } else {
                                    i7 = 0;
                                    i6 = i5;
                                    i5 = i4;
                                    obj8 = obj3;
                                    i15 = i9;
                                    i9 = i8;
                                    i8 = 0;
                                    i12 = i15;
                                }
                                i11++;
                                obj2 = obj7;
                                obj3 = obj8;
                                i10 = i14;
                                i4 = i5;
                                obj4 = obj6;
                                i5 = i6;
                                i6 = i7;
                                i7 = i8;
                                i8 = i9;
                                i9 = i12;
                                i12 = i13;
                            }
                        }
                        i14 = i10;
                        obj7 = obj2;
                        if (obj3 == null) {
                            i12 = i9;
                            i9 = i8;
                            i8 = i7;
                            i7 = i6;
                            i6 = i5;
                            i5 = i4;
                            obj8 = obj3;
                        } else if (i4 > 0) {
                            if (i16 >= 64) {
                            }
                            i15 = i9;
                            i9 = i8;
                            i8 = i7;
                            i7 = i6;
                            i6 = i5;
                            i5 = i4;
                            obj8 = null;
                            i12 = i15;
                        } else {
                            if (i16 != 128) {
                            }
                            i15 = i9;
                            i9 = i8;
                            i8 = i7;
                            i7 = i6;
                            i6 = i5;
                            i5 = i4;
                            obj8 = null;
                            i12 = i15;
                        }
                        i11++;
                        obj2 = obj7;
                        obj3 = obj8;
                        i10 = i14;
                        i4 = i5;
                        obj4 = obj6;
                        i5 = i6;
                        i6 = i7;
                        i7 = i8;
                        i8 = i9;
                        i9 = i12;
                        i12 = i13;
                    }
                } else if ((i16 & 128) != 0) {
                    if ((i16 & 64) != 0) {
                        i13 = i12 + 1;
                        if ((i16 & 32) == 0) {
                            i++;
                            obj6 = obj4;
                        } else {
                            i13++;
                            if ((i16 & 16) == 0) {
                                i2++;
                                obj6 = obj4;
                            } else {
                                i12 = i13 + 1;
                                if ((i16 & 8) == 0) {
                                    i3++;
                                    i13 = i12;
                                    obj6 = obj4;
                                }
                            }
                        }
                        if (obj2 != null) {
                            if (i16 <= 127) {
                            }
                            i14 = i10 + 1;
                            obj7 = obj2;
                            if (obj3 == null) {
                                i12 = i9;
                                i9 = i8;
                                i8 = i7;
                                i7 = i6;
                                i6 = i5;
                                i5 = i4;
                                obj8 = obj3;
                            } else if (i4 > 0) {
                                if (i16 != 128) {
                                }
                                i15 = i9;
                                i9 = i8;
                                i8 = i7;
                                i7 = i6;
                                i6 = i5;
                                i5 = i4;
                                obj8 = null;
                                i12 = i15;
                            } else {
                                if (i16 >= 64) {
                                }
                                i15 = i9;
                                i9 = i8;
                                i8 = i7;
                                i7 = i6;
                                i6 = i5;
                                i5 = i4;
                                obj8 = null;
                                i12 = i15;
                            }
                            i11++;
                            obj2 = obj7;
                            obj3 = obj8;
                            i10 = i14;
                            i4 = i5;
                            obj4 = obj6;
                            i5 = i6;
                            i6 = i7;
                            i7 = i8;
                            i8 = i9;
                            i9 = i12;
                            i12 = i13;
                        }
                        i14 = i10;
                        obj7 = obj2;
                        if (obj3 == null) {
                            i12 = i9;
                            i9 = i8;
                            i8 = i7;
                            i7 = i6;
                            i6 = i5;
                            i5 = i4;
                            obj8 = obj3;
                        } else if (i4 > 0) {
                            if (i16 >= 64) {
                            }
                            i15 = i9;
                            i9 = i8;
                            i8 = i7;
                            i7 = i6;
                            i6 = i5;
                            i5 = i4;
                            obj8 = null;
                            i12 = i15;
                        } else {
                            if (i16 != 128) {
                            }
                            i15 = i9;
                            i9 = i8;
                            i8 = i7;
                            i7 = i6;
                            i6 = i5;
                            i5 = i4;
                            obj8 = null;
                            i12 = i15;
                        }
                        i11++;
                        obj2 = obj7;
                        obj3 = obj8;
                        i10 = i14;
                        i4 = i5;
                        obj4 = obj6;
                        i5 = i6;
                        i6 = i7;
                        i7 = i8;
                        i8 = i9;
                        i9 = i12;
                        i12 = i13;
                    }
                }
                i13 = i12;
                obj6 = null;
                if (obj2 != null) {
                    if (i16 <= 127) {
                    }
                    i14 = i10 + 1;
                    obj7 = obj2;
                    if (obj3 == null) {
                        i12 = i9;
                        i9 = i8;
                        i8 = i7;
                        i7 = i6;
                        i6 = i5;
                        i5 = i4;
                        obj8 = obj3;
                    } else if (i4 > 0) {
                        if (i16 != 128) {
                        }
                        i15 = i9;
                        i9 = i8;
                        i8 = i7;
                        i7 = i6;
                        i6 = i5;
                        i5 = i4;
                        obj8 = null;
                        i12 = i15;
                    } else {
                        if (i16 >= 64) {
                        }
                        i15 = i9;
                        i9 = i8;
                        i8 = i7;
                        i7 = i6;
                        i6 = i5;
                        i5 = i4;
                        obj8 = null;
                        i12 = i15;
                    }
                    i11++;
                    obj2 = obj7;
                    obj3 = obj8;
                    i10 = i14;
                    i4 = i5;
                    obj4 = obj6;
                    i5 = i6;
                    i6 = i7;
                    i7 = i8;
                    i8 = i9;
                    i9 = i12;
                    i12 = i13;
                }
                i14 = i10;
                obj7 = obj2;
                if (obj3 == null) {
                    i12 = i9;
                    i9 = i8;
                    i8 = i7;
                    i7 = i6;
                    i6 = i5;
                    i5 = i4;
                    obj8 = obj3;
                } else if (i4 > 0) {
                    if (i16 >= 64) {
                    }
                    i15 = i9;
                    i9 = i8;
                    i8 = i7;
                    i7 = i6;
                    i6 = i5;
                    i5 = i4;
                    obj8 = null;
                    i12 = i15;
                } else {
                    if (i16 != 128) {
                    }
                    i15 = i9;
                    i9 = i8;
                    i8 = i7;
                    i7 = i6;
                    i6 = i5;
                    i5 = i4;
                    obj8 = null;
                    i12 = i15;
                }
                i11++;
                obj2 = obj7;
                obj3 = obj8;
                i10 = i14;
                i4 = i5;
                obj4 = obj6;
                i5 = i6;
                i6 = i7;
                i7 = i8;
                i8 = i9;
                i9 = i12;
                i12 = i13;
            }
            i13 = i12;
            obj6 = obj4;
            if (obj2 != null) {
                if (i16 <= 127) {
                }
                i14 = i10 + 1;
                obj7 = obj2;
                if (obj3 == null) {
                    i12 = i9;
                    i9 = i8;
                    i8 = i7;
                    i7 = i6;
                    i6 = i5;
                    i5 = i4;
                    obj8 = obj3;
                } else if (i4 > 0) {
                    if (i16 != 128) {
                    }
                    i15 = i9;
                    i9 = i8;
                    i8 = i7;
                    i7 = i6;
                    i6 = i5;
                    i5 = i4;
                    obj8 = null;
                    i12 = i15;
                } else {
                    if (i16 >= 64) {
                    }
                    i15 = i9;
                    i9 = i8;
                    i8 = i7;
                    i7 = i6;
                    i6 = i5;
                    i5 = i4;
                    obj8 = null;
                    i12 = i15;
                }
                i11++;
                obj2 = obj7;
                obj3 = obj8;
                i10 = i14;
                i4 = i5;
                obj4 = obj6;
                i5 = i6;
                i6 = i7;
                i7 = i8;
                i8 = i9;
                i9 = i12;
                i12 = i13;
            }
            i14 = i10;
            obj7 = obj2;
            if (obj3 == null) {
                i12 = i9;
                i9 = i8;
                i8 = i7;
                i7 = i6;
                i6 = i5;
                i5 = i4;
                obj8 = obj3;
            } else if (i4 > 0) {
                if (i16 >= 64) {
                }
                i15 = i9;
                i9 = i8;
                i8 = i7;
                i7 = i6;
                i6 = i5;
                i5 = i4;
                obj8 = null;
                i12 = i15;
            } else {
                if (i16 != 128) {
                }
                i15 = i9;
                i9 = i8;
                i8 = i7;
                i7 = i6;
                i6 = i5;
                i5 = i4;
                obj8 = null;
                i12 = i15;
            }
            i11++;
            obj2 = obj7;
            obj3 = obj8;
            i10 = i14;
            i4 = i5;
            obj4 = obj6;
            i5 = i6;
            i6 = i7;
            i7 = i8;
            i8 = i9;
            i9 = i12;
            i12 = i13;
        }
        if (obj4 == null || i12 <= 0) {
            obj = obj4;
        } else {
            obj = null;
        }
        if (obj3 != null && i4 > 0) {
            obj3 = null;
        }
        if (obj != null && (obj5 != null || (i + i2) + i3 > 0)) {
            return "UTF8";
        }
        if (obj3 != null && (f13505b || i8 >= 3 || i9 >= 3)) {
            return "SJIS";
        }
        if (obj2 != null && obj3 != null) {
            return (!(i8 == 2 && i5 == 2) && i10 * 10 < length) ? "ISO8859_1" : "SJIS";
        } else {
            if (obj2 != null) {
                return "ISO8859_1";
            }
            if (obj3 != null) {
                return "SJIS";
            }
            if (obj != null) {
                return "UTF8";
            }
            return f13504a;
        }
    }
}
