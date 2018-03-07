package com.google.protobuf;

import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: amount_scrolled */
public final class ExtensionRegistry extends ExtensionRegistryLite {
    public static final ExtensionRegistry f20907c = new ExtensionRegistry((byte) 0);
    private final Map<String, ExtensionInfo> f20908a;
    private final Map<DescriptorIntPair, ExtensionInfo> f20909b;

    /* compiled from: amount_scrolled */
    final class DescriptorIntPair {
        private final Descriptor f20900a;
        private final int f20901b;

        DescriptorIntPair(Descriptor descriptor, int i) {
            this.f20900a = descriptor;
            this.f20901b = i;
        }

        public final int hashCode() {
            return (this.f20900a.hashCode() * 65535) + this.f20901b;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof DescriptorIntPair)) {
                return false;
            }
            DescriptorIntPair descriptorIntPair = (DescriptorIntPair) obj;
            if (this.f20900a == descriptorIntPair.f20900a && this.f20901b == descriptorIntPair.f20901b) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: amount_scrolled */
    public final class ExtensionInfo {
        public final FieldDescriptor f20902a;
        public final AbstractMessage f20903b;
    }

    private ExtensionRegistry(byte b) {
        super(ExtensionRegistryLite.f20905c);
        this.f20908a = Collections.emptyMap();
        this.f20909b = Collections.emptyMap();
    }

    public final ExtensionInfo m21310a(Descriptor descriptor, int i) {
        return (ExtensionInfo) this.f20909b.get(new DescriptorIntPair(descriptor, i));
    }

    private ExtensionRegistry() {
        this.f20908a = new HashMap();
        this.f20909b = new HashMap();
    }
}
