package com.fasterxml.jackson.dataformat.smile;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.BytesToNameCanonicalizer;
import com.fasterxml.jackson.dataformat.smile.SmileParser.Feature;
import java.io.InputStream;

/* compiled from: can_viewer_comment_with_video */
public class SmileParserBootstrapper {
    protected final IOContext f6309a;
    protected final InputStream f6310b;
    protected final byte[] f6311c;
    protected int f6312d;
    protected int f6313e;
    protected final boolean f6314f;
    protected int f6315g;

    public SmileParserBootstrapper(IOContext iOContext, InputStream inputStream) {
        this.f6309a = iOContext;
        this.f6310b = inputStream;
        this.f6311c = iOContext.e();
        this.f6312d = 0;
        this.f6313e = 0;
        this.f6315g = 0;
        this.f6314f = true;
    }

    public SmileParserBootstrapper(IOContext iOContext, byte[] bArr, int i, int i2) {
        this.f6309a = iOContext;
        this.f6310b = null;
        this.f6311c = bArr;
        this.f6312d = i;
        this.f6313e = i + i2;
        this.f6315g = -i;
        this.f6314f = false;
    }

    public final SmileParser m12000a(int i, int i2, boolean z, ObjectCodec objectCodec, BytesToNameCanonicalizer bytesToNameCanonicalizer) {
        BytesToNameCanonicalizer a = bytesToNameCanonicalizer.a(z);
        m11999a(1);
        SmileParser smileParser = new SmileParser(this.f6309a, i, objectCodec, a, this.f6310b, this.f6311c, this.f6312d, this.f6313e, this.f6314f);
        boolean z2 = false;
        if (this.f6312d < this.f6313e) {
            if (this.f6311c[this.f6312d] == (byte) 58) {
                z2 = smileParser.m11985a(true, true);
            }
            if (!(z2 || (Feature.REQUIRE_HEADER.getMask() & i2) == 0)) {
                String str;
                int i3 = this.f6312d < this.f6313e ? this.f6311c[this.f6312d] : 0;
                if (i3 == 123 || i3 == 91) {
                    str = "Input does not start with Smile format header (first byte = 0x" + Integer.toHexString(i3 & 255) + ") -- rather, it starts with '" + ((char) i3) + "' (plain JSON input?) -- can not parse";
                } else {
                    str = "Input does not start with Smile format header (first byte = 0x" + Integer.toHexString(i3 & 255) + ") and parser has REQUIRE_HEADER enabled: can not parse";
                }
                throw new JsonParseException(str, JsonLocation.a);
            }
        }
        return smileParser;
    }

    private boolean m11999a(int i) {
        if (this.f6310b == null) {
            return false;
        }
        int i2 = this.f6313e - this.f6312d;
        while (i2 < i) {
            int read = this.f6310b.read(this.f6311c, this.f6313e, this.f6311c.length - this.f6313e);
            if (read <= 0) {
                return false;
            }
            this.f6313e += read;
            i2 += read;
        }
        return true;
    }
}
