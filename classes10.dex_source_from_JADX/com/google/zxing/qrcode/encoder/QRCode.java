package com.google.zxing.qrcode.encoder;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;

/* compiled from: event_dashboard_all_upcoming */
public final class QRCode {
    public Mode f13587a;
    public ErrorCorrectionLevel f13588b;
    public Version f13589c;
    public int f13590d = -1;
    public ByteMatrix f13591e;

    public final ByteMatrix m13851a() {
        return this.f13591e;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(200);
        stringBuilder.append("<<\n");
        stringBuilder.append(" mode: ");
        stringBuilder.append(this.f13587a);
        stringBuilder.append("\n ecLevel: ");
        stringBuilder.append(this.f13588b);
        stringBuilder.append("\n version: ");
        stringBuilder.append(this.f13589c);
        stringBuilder.append("\n maskPattern: ");
        stringBuilder.append(this.f13590d);
        if (this.f13591e == null) {
            stringBuilder.append("\n matrix: null\n");
        } else {
            stringBuilder.append("\n matrix:\n");
            stringBuilder.append(this.f13591e.toString());
        }
        stringBuilder.append(">>\n");
        return stringBuilder.toString();
    }
}
