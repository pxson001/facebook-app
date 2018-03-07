package com.facebook.common.iolite;

import android.annotation.SuppressLint;
import java.io.FilterWriter;
import java.io.Writer;

@SuppressLint({"BadMethodUse-java.lang.String.length", "BadMethodUse-java.lang.String.charAt"})
/* compiled from: sold */
public class PrefixedWriter extends FilterWriter {
    private static final String f2641a = System.getProperty("line.separator");
    public final String f2642b;
    public final String f2643c;
    private final CharacterStateMachine f2644d;

    /* compiled from: sold */
    public enum CharacterState {
        AFTER_CARRIAGE_RETURN {
            protected final void handle(CharacterStateMachine characterStateMachine, int i) {
                characterStateMachine.f2638a.out.write(characterStateMachine.f2638a.f2642b);
                CharacterState.AFTER_FIRST_CHARACTER.handle(characterStateMachine, i);
            }
        },
        AFTER_FIRST_CHARACTER {
            protected final void handle(CharacterStateMachine characterStateMachine, int i) {
                characterStateMachine.m3754b(i);
                if (i == characterStateMachine.m3752a().charAt(0)) {
                    characterStateMachine.m3753a(CharacterState.SEPARATOR_CHARACTER_n);
                } else {
                    characterStateMachine.m3753a(CharacterState.AFTER_FIRST_CHARACTER);
                }
            }
        },
        SEPARATOR_CHARACTER_n {
            protected final void onEnterState(CharacterStateMachine characterStateMachine) {
                characterStateMachine.f2640c = 1;
                if (characterStateMachine.f2640c >= characterStateMachine.m3752a().length()) {
                    characterStateMachine.m3753a(CharacterState.AFTER_CARRIAGE_RETURN);
                }
            }

            protected final void handle(CharacterStateMachine characterStateMachine, int i) {
                characterStateMachine.m3754b(i);
                String a = characterStateMachine.m3752a();
                int i2 = characterStateMachine.f2640c;
                characterStateMachine.f2640c = i2 + 1;
                if (i != a.charAt(i2)) {
                    if (i == a.charAt(0)) {
                        onEnterState(characterStateMachine);
                    } else {
                        characterStateMachine.m3753a(CharacterState.AFTER_FIRST_CHARACTER);
                    }
                } else if (characterStateMachine.f2640c == a.length()) {
                    characterStateMachine.m3753a(CharacterState.AFTER_CARRIAGE_RETURN);
                }
            }
        };

        public abstract void handle(CharacterStateMachine characterStateMachine, int i);

        protected void onEnterState(CharacterStateMachine characterStateMachine) {
        }

        protected void onExitState(CharacterStateMachine characterStateMachine) {
        }
    }

    /* compiled from: sold */
    public class CharacterStateMachine {
        public final /* synthetic */ PrefixedWriter f2638a;
        public CharacterState f2639b = CharacterState.AFTER_CARRIAGE_RETURN;
        public int f2640c = -1;

        public CharacterStateMachine(PrefixedWriter prefixedWriter) {
            this.f2638a = prefixedWriter;
        }

        public final void m3753a(CharacterState characterState) {
            if (this.f2639b != characterState) {
                this.f2639b.onExitState(this);
                this.f2639b = characterState;
                characterState.onEnterState(this);
            }
        }

        public final String m3752a() {
            return this.f2638a.f2643c;
        }

        public final void m3754b(int i) {
            this.f2638a.out.write(i);
        }
    }

    public PrefixedWriter(Writer writer, String str) {
        this(writer, str, f2641a);
    }

    private PrefixedWriter(Writer writer, String str, String str2) {
        super(writer);
        this.f2642b = str;
        this.f2643c = str2;
        this.f2644d = new CharacterStateMachine(this);
    }

    public void write(char[] cArr, int i, int i2) {
        synchronized (this.lock) {
            while (true) {
                int i3 = i2 - 1;
                if (i2 > 0) {
                    int i4 = i + 1;
                    m3755a(cArr[i]);
                    i2 = i3;
                    i = i4;
                }
            }
        }
    }

    public void write(int i) {
        synchronized (this.lock) {
            m3755a(i);
        }
    }

    public void write(String str, int i, int i2) {
        synchronized (this.lock) {
            while (true) {
                int i3 = i2 - 1;
                if (i2 > 0) {
                    int i4 = i + 1;
                    m3755a(str.charAt(i));
                    i2 = i3;
                    i = i4;
                }
            }
        }
    }

    private void m3755a(int i) {
        CharacterStateMachine characterStateMachine = this.f2644d;
        characterStateMachine.f2639b.handle(characterStateMachine, i);
    }
}
