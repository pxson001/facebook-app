package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.io.SerializedString;
import java.io.Serializable;
import java.util.Arrays;

/* compiled from: story_for_social_search */
public class DefaultPrettyPrinter implements PrettyPrinter, Instantiatable<DefaultPrettyPrinter>, Serializable {
    public static final SerializedString f4043a = new SerializedString(" ");
    private static final long serialVersionUID = -5512586643324525213L;
    protected Indenter _arrayIndenter;
    protected Indenter _objectIndenter;
    protected final SerializableString _rootSeparator;
    protected boolean _spacesInObjectEntries;
    protected transient int f4044b;

    /* compiled from: story_for_social_search */
    public class FixedSpaceIndenter extends NopIndenter {
        public static final FixedSpaceIndenter f4046a = new FixedSpaceIndenter();

        public final void mo1055a(JsonGenerator jsonGenerator, int i) {
            jsonGenerator.mo1108a(' ');
        }

        public final boolean mo1056a() {
            return true;
        }
    }

    /* compiled from: story_for_social_search */
    public class NopIndenter implements Indenter, Serializable {
        public static final NopIndenter f4047c = new NopIndenter();

        public void mo1055a(JsonGenerator jsonGenerator, int i) {
        }

        public boolean mo1056a() {
            return true;
        }
    }

    /* compiled from: story_for_social_search */
    public interface Indenter {
        void mo1055a(JsonGenerator jsonGenerator, int i);

        boolean mo1056a();
    }

    /* compiled from: story_for_social_search */
    public class Lf2SpacesIndenter extends NopIndenter {
        public static final Lf2SpacesIndenter f4048a = new Lf2SpacesIndenter();
        static final char[] f4049b;
        private static final String f4050d;

        static {
            String str = null;
            try {
                str = System.getProperty("line.separator");
            } catch (Throwable th) {
            }
            if (str == null) {
                str = "\n";
            }
            f4050d = str;
            char[] cArr = new char[64];
            f4049b = cArr;
            Arrays.fill(cArr, ' ');
        }

        public final boolean mo1056a() {
            return false;
        }

        public final void mo1055a(JsonGenerator jsonGenerator, int i) {
            jsonGenerator.mo1127c(f4050d);
            if (i > 0) {
                int i2 = i + i;
                while (i2 > 64) {
                    jsonGenerator.mo1124b(f4049b, 0, 64);
                    i2 -= f4049b.length;
                }
                jsonGenerator.mo1124b(f4049b, 0, i2);
            }
        }
    }

    public DefaultPrettyPrinter() {
        this(f4043a);
    }

    private DefaultPrettyPrinter(SerializableString serializableString) {
        this._arrayIndenter = FixedSpaceIndenter.f4046a;
        this._objectIndenter = Lf2SpacesIndenter.f4048a;
        this._spacesInObjectEntries = true;
        this.f4044b = 0;
        this._rootSeparator = serializableString;
    }

    private DefaultPrettyPrinter(DefaultPrettyPrinter defaultPrettyPrinter) {
        this(defaultPrettyPrinter, defaultPrettyPrinter._rootSeparator);
    }

    private DefaultPrettyPrinter(DefaultPrettyPrinter defaultPrettyPrinter, SerializableString serializableString) {
        this._arrayIndenter = FixedSpaceIndenter.f4046a;
        this._objectIndenter = Lf2SpacesIndenter.f4048a;
        this._spacesInObjectEntries = true;
        this.f4044b = 0;
        this._arrayIndenter = defaultPrettyPrinter._arrayIndenter;
        this._objectIndenter = defaultPrettyPrinter._objectIndenter;
        this._spacesInObjectEntries = defaultPrettyPrinter._spacesInObjectEntries;
        this.f4044b = defaultPrettyPrinter.f4044b;
        this._rootSeparator = serializableString;
    }

    public final Object mo1038a() {
        return new DefaultPrettyPrinter(this);
    }

    public final void mo1039a(JsonGenerator jsonGenerator) {
        if (this._rootSeparator != null) {
            jsonGenerator.mo1130d(this._rootSeparator);
        }
    }

    public final void mo1041b(JsonGenerator jsonGenerator) {
        jsonGenerator.mo1108a('{');
        if (!this._objectIndenter.mo1056a()) {
            this.f4044b++;
        }
    }

    public final void mo1048h(JsonGenerator jsonGenerator) {
        this._objectIndenter.mo1055a(jsonGenerator, this.f4044b);
    }

    public final void mo1044d(JsonGenerator jsonGenerator) {
        if (this._spacesInObjectEntries) {
            jsonGenerator.mo1127c(" : ");
        } else {
            jsonGenerator.mo1108a(':');
        }
    }

    public final void mo1043c(JsonGenerator jsonGenerator) {
        jsonGenerator.mo1108a(',');
        this._objectIndenter.mo1055a(jsonGenerator, this.f4044b);
    }

    public final void mo1040a(JsonGenerator jsonGenerator, int i) {
        if (!this._objectIndenter.mo1056a()) {
            this.f4044b--;
        }
        if (i > 0) {
            this._objectIndenter.mo1055a(jsonGenerator, this.f4044b);
        } else {
            jsonGenerator.mo1108a(' ');
        }
        jsonGenerator.mo1108a('}');
    }

    public final void mo1045e(JsonGenerator jsonGenerator) {
        if (!this._arrayIndenter.mo1056a()) {
            this.f4044b++;
        }
        jsonGenerator.mo1108a('[');
    }

    public final void mo1047g(JsonGenerator jsonGenerator) {
        this._arrayIndenter.mo1055a(jsonGenerator, this.f4044b);
    }

    public final void mo1046f(JsonGenerator jsonGenerator) {
        jsonGenerator.mo1108a(',');
        this._arrayIndenter.mo1055a(jsonGenerator, this.f4044b);
    }

    public final void mo1042b(JsonGenerator jsonGenerator, int i) {
        if (!this._arrayIndenter.mo1056a()) {
            this.f4044b--;
        }
        if (i > 0) {
            this._arrayIndenter.mo1055a(jsonGenerator, this.f4044b);
        } else {
            jsonGenerator.mo1108a(' ');
        }
        jsonGenerator.mo1108a(']');
    }
}
