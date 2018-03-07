package com.facebook.reactionsanimations;

import android.graphics.Path;
import java.util.Locale;

/* compiled from: fetch_feedback_ */
public abstract class VectorCommand {
    protected final ArgFormat f14390a;
    public final float[] f14391b;
    public float[] f14392c;

    /* compiled from: fetch_feedback_ */
    enum ArgFormat {
        RELATIVE,
        ABSOLUTE
    }

    /* compiled from: fetch_feedback_ */
    class CubicToCommand extends VectorCommand {
        public CubicToCommand(ArgFormat argFormat, float[] fArr) {
            super(argFormat, fArr);
        }

        public final void mo1144a(Path path) {
            mo1145a(path, this.f14390a, this.f14391b);
        }

        protected final void mo1145a(Path path, ArgFormat argFormat, float[] fArr) {
            switch (argFormat) {
                case RELATIVE:
                    path.rCubicTo(fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5]);
                    return;
                case ABSOLUTE:
                    path.cubicTo(fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5]);
                    return;
                default:
                    throw new IllegalArgumentException(String.format(Locale.US, "No such argument format %s", new Object[]{argFormat}));
            }
        }
    }

    /* compiled from: fetch_feedback_ */
    class LineToCommand extends VectorCommand {
        public LineToCommand(ArgFormat argFormat, float[] fArr) {
            super(argFormat, fArr);
        }

        public final void mo1144a(Path path) {
            mo1145a(path, this.f14390a, this.f14391b);
        }

        protected final void mo1145a(Path path, ArgFormat argFormat, float[] fArr) {
            switch (argFormat) {
                case RELATIVE:
                    path.rLineTo(fArr[0], fArr[1]);
                    return;
                case ABSOLUTE:
                    path.lineTo(fArr[0], fArr[1]);
                    return;
                default:
                    throw new IllegalArgumentException(String.format(Locale.US, "No such argument format %s", new Object[]{argFormat}));
            }
        }
    }

    /* compiled from: fetch_feedback_ */
    class MoveToCommand extends VectorCommand {
        public MoveToCommand(ArgFormat argFormat, float[] fArr) {
            super(argFormat, fArr);
        }

        public final void mo1144a(Path path) {
            mo1145a(path, this.f14390a, this.f14391b);
        }

        protected final void mo1145a(Path path, ArgFormat argFormat, float[] fArr) {
            switch (argFormat) {
                case RELATIVE:
                    path.rMoveTo(fArr[0], fArr[1]);
                    return;
                case ABSOLUTE:
                    path.moveTo(fArr[0], fArr[1]);
                    return;
                default:
                    throw new IllegalArgumentException(String.format(Locale.US, "No such argument format %s", new Object[]{argFormat}));
            }
        }
    }

    /* compiled from: fetch_feedback_ */
    class QuadraticToCommand extends VectorCommand {
        public QuadraticToCommand(ArgFormat argFormat, float[] fArr) {
            super(argFormat, fArr);
        }

        public final void mo1144a(Path path) {
            mo1145a(path, this.f14390a, this.f14391b);
        }

        protected final void mo1145a(Path path, ArgFormat argFormat, float[] fArr) {
            switch (argFormat) {
                case RELATIVE:
                    path.rQuadTo(fArr[0], fArr[1], fArr[2], fArr[3]);
                    return;
                case ABSOLUTE:
                    path.quadTo(fArr[0], fArr[1], fArr[2], fArr[3]);
                    return;
                default:
                    throw new IllegalArgumentException(String.format(Locale.US, "No such argument format %s", new Object[]{argFormat}));
            }
        }
    }

    /* compiled from: fetch_feedback_ */
    enum SVGCommand {
        m(ArgFormat.RELATIVE, 2),
        M(ArgFormat.ABSOLUTE, 2),
        q(ArgFormat.RELATIVE, 4),
        Q(ArgFormat.ABSOLUTE, 4),
        c(ArgFormat.RELATIVE, 6),
        C(ArgFormat.ABSOLUTE, 6),
        l(ArgFormat.RELATIVE, 2),
        L(ArgFormat.ABSOLUTE, 2);
        
        public final int argCount;
        public final ArgFormat argFormat;

        private SVGCommand(ArgFormat argFormat, int i) {
            this.argFormat = argFormat;
            this.argCount = i;
        }
    }

    public abstract void mo1144a(Path path);

    protected abstract void mo1145a(Path path, ArgFormat argFormat, float[] fArr);

    public static VectorCommand m18273a(String str) {
        SVGCommand valueOf = SVGCommand.valueOf(str.substring(0, 1));
        String[] split = str.substring(1).split(",");
        Object obj = new float[split.length];
        int length = split.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i2 + 1;
            obj[i2] = Float.parseFloat(split[i]);
            i++;
            i2 = i3;
        }
        switch (valueOf) {
            case m:
            case M:
                if (m18274a(valueOf, obj)) {
                    return new MoveToCommand(valueOf.argFormat, obj);
                }
                throw new IllegalArgumentException(String.format(Locale.US, "VectorCommand MoveTo requires two arguments, but got %s", new Object[]{obj.toString()}));
            case q:
            case Q:
                if (m18274a(valueOf, obj)) {
                    return new QuadraticToCommand(valueOf.argFormat, obj);
                }
                throw new IllegalArgumentException(String.format(Locale.US, "VectorCommand QuadraticTo requires four arguments, but got %s", new Object[]{obj.toString()}));
            case c:
            case C:
                if (m18274a(valueOf, obj)) {
                    return new CubicToCommand(valueOf.argFormat, obj);
                }
                throw new IllegalArgumentException(String.format(Locale.US, "VectorCommand CubicTo requires six arguments, but got %s", new Object[]{obj.toString()}));
            case l:
            case L:
                if (m18274a(valueOf, obj)) {
                    return new LineToCommand(valueOf.argFormat, obj);
                }
                throw new IllegalArgumentException(String.format(Locale.US, "VectorCommand LineTo requires two arguments, but got %s", new Object[]{obj.toString()}));
            default:
                throw new IllegalArgumentException(String.format(Locale.US, "Unrecognized vector command: %s", new Object[]{str}));
        }
    }

    private static boolean m18274a(SVGCommand sVGCommand, float[] fArr) {
        return sVGCommand.argCount == fArr.length;
    }

    public VectorCommand(ArgFormat argFormat, float[] fArr) {
        this.f14390a = argFormat;
        this.f14391b = fArr;
    }

    public final void m18277a(VectorCommand vectorCommand, float f, Path path) {
        if (this.f14392c == null) {
            this.f14392c = new float[this.f14391b.length];
        }
        float[] fArr = this.f14392c;
        int length = this.f14391b.length;
        for (int i = 0; i < length; i++) {
            float f2 = this.f14391b[i];
            fArr[i] = ((vectorCommand.f14391b[i] - f2) * f) + f2;
        }
        mo1145a(path, this.f14390a, fArr);
    }
}
