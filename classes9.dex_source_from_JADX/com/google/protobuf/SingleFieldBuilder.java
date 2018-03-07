package com.google.protobuf;

import com.google.protobuf.GeneratedMessage.Builder;
import com.google.protobuf.GeneratedMessage.BuilderParent;

/* compiled from: allowed_call_to_action_types */
public class SingleFieldBuilder<MType extends GeneratedMessage, BType extends Builder, IType extends MessageOrBuilder> implements BuilderParent {
    private BuilderParent f20993a;
    public BType f20994b;
    public MType f20995c;
    private boolean f20996d;

    public SingleFieldBuilder(MType mType, BuilderParent builderParent, boolean z) {
        if (mType == null) {
            throw new NullPointerException();
        }
        this.f20995c = mType;
        this.f20993a = builderParent;
        this.f20996d = z;
    }

    public final void m21440b() {
        this.f20993a = null;
    }

    public final MType m21441c() {
        if (this.f20995c == null) {
            this.f20995c = (GeneratedMessage) this.f20994b.mo874h();
        }
        return this.f20995c;
    }

    public final MType m21442d() {
        this.f20996d = true;
        return m21441c();
    }

    public final BType m21443e() {
        if (this.f20994b == null) {
            this.f20994b = (Builder) this.f20995c.mo879a((BuilderParent) this);
            this.f20994b.mo870a(this.f20995c);
            this.f20994b.m20310q();
        }
        return this.f20994b;
    }

    public final SingleFieldBuilder<MType, BType, IType> m21437a(MType mType) {
        if (mType == null) {
            throw new NullPointerException();
        }
        this.f20995c = mType;
        if (this.f20994b != null) {
            this.f20994b.m20308o();
            this.f20994b = null;
        }
        m21436h();
        return this;
    }

    public final SingleFieldBuilder<MType, BType, IType> m21439b(MType mType) {
        if (this.f20994b == null && this.f20995c == this.f20995c.mo878v()) {
            this.f20995c = mType;
        } else {
            m21443e().mo870a((AbstractMessage) mType);
        }
        m21436h();
        return this;
    }

    public final SingleFieldBuilder<MType, BType, IType> m21444g() {
        AbstractMessage v;
        if (this.f20995c != null) {
            v = this.f20995c.mo878v();
        } else {
            v = this.f20994b.mo878v();
        }
        this.f20995c = (GeneratedMessage) v;
        if (this.f20994b != null) {
            this.f20994b.m20308o();
            this.f20994b = null;
        }
        m21436h();
        return this;
    }

    private void m21436h() {
        if (this.f20994b != null) {
            this.f20995c = null;
        }
        if (this.f20996d && this.f20993a != null) {
            this.f20993a.mo897a();
            this.f20996d = false;
        }
    }

    public final void mo897a() {
        m21436h();
    }
}
