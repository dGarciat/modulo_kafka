package org.example.protoBuf;// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: person.proto
// Protobuf Java Version: 4.26.1

public final class PersonOuterClass {
  private PersonOuterClass() {}
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 26,
      /* patch= */ 1,
      /* suffix= */ "",
      PersonOuterClass.class.getName());
  }
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface PersonOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Person)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string first_name = 1;</code>
     * @return The firstName.
     */
    String getFirstName();
    /**
     * <code>string first_name = 1;</code>
     * @return The bytes for firstName.
     */
    com.google.protobuf.ByteString
        getFirstNameBytes();

    /**
     * <code>string last_name = 2;</code>
     * @return The lastName.
     */
    String getLastName();
    /**
     * <code>string last_name = 2;</code>
     * @return The bytes for lastName.
     */
    com.google.protobuf.ByteString
        getLastNameBytes();

    /**
     * <code>int32 birth_date = 3;</code>
     * @return The birthDate.
     */
    int getBirthDate();
  }
  /**
   * Protobuf type {@code Person}
   */
  public static final class Person extends
      com.google.protobuf.GeneratedMessage implements
      // @@protoc_insertion_point(message_implements:Person)
      PersonOrBuilder {
  private static final long serialVersionUID = 0L;
    static {
      com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
        com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
        /* major= */ 4,
        /* minor= */ 26,
        /* patch= */ 1,
        /* suffix= */ "",
        Person.class.getName());
    }
    // Use Person.newBuilder() to construct.
    private Person(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
    }
    private Person() {
      firstName_ = "";
      lastName_ = "";
    }

    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return PersonOuterClass.internal_static_Person_descriptor;
    }

    @Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return PersonOuterClass.internal_static_Person_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Person.class, Builder.class);
    }

    public static final int FIRST_NAME_FIELD_NUMBER = 1;
    @SuppressWarnings("serial")
    private volatile Object firstName_ = "";
    /**
     * <code>string first_name = 1;</code>
     * @return The firstName.
     */
    @Override
    public String getFirstName() {
      Object ref = firstName_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        firstName_ = s;
        return s;
      }
    }
    /**
     * <code>string first_name = 1;</code>
     * @return The bytes for firstName.
     */
    @Override
    public com.google.protobuf.ByteString
        getFirstNameBytes() {
      Object ref = firstName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        firstName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int LAST_NAME_FIELD_NUMBER = 2;
    @SuppressWarnings("serial")
    private volatile Object lastName_ = "";
    /**
     * <code>string last_name = 2;</code>
     * @return The lastName.
     */
    @Override
    public String getLastName() {
      Object ref = lastName_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        lastName_ = s;
        return s;
      }
    }
    /**
     * <code>string last_name = 2;</code>
     * @return The bytes for lastName.
     */
    @Override
    public com.google.protobuf.ByteString
        getLastNameBytes() {
      Object ref = lastName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        lastName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int BIRTH_DATE_FIELD_NUMBER = 3;
    private int birthDate_ = 0;
    /**
     * <code>int32 birth_date = 3;</code>
     * @return The birthDate.
     */
    @Override
    public int getBirthDate() {
      return birthDate_;
    }

    private byte memoizedIsInitialized = -1;
    @Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (!com.google.protobuf.GeneratedMessage.isStringEmpty(firstName_)) {
        com.google.protobuf.GeneratedMessage.writeString(output, 1, firstName_);
      }
      if (!com.google.protobuf.GeneratedMessage.isStringEmpty(lastName_)) {
        com.google.protobuf.GeneratedMessage.writeString(output, 2, lastName_);
      }
      if (birthDate_ != 0) {
        output.writeInt32(3, birthDate_);
      }
      getUnknownFields().writeTo(output);
    }

    @Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!com.google.protobuf.GeneratedMessage.isStringEmpty(firstName_)) {
        size += com.google.protobuf.GeneratedMessage.computeStringSize(1, firstName_);
      }
      if (!com.google.protobuf.GeneratedMessage.isStringEmpty(lastName_)) {
        size += com.google.protobuf.GeneratedMessage.computeStringSize(2, lastName_);
      }
      if (birthDate_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(3, birthDate_);
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @Override
    public boolean equals(final Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof Person)) {
        return super.equals(obj);
      }
      Person other = (Person) obj;

      if (!getFirstName()
          .equals(other.getFirstName())) return false;
      if (!getLastName()
          .equals(other.getLastName())) return false;
      if (getBirthDate()
          != other.getBirthDate()) return false;
      if (!getUnknownFields().equals(other.getUnknownFields())) return false;
      return true;
    }

    @Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + FIRST_NAME_FIELD_NUMBER;
      hash = (53 * hash) + getFirstName().hashCode();
      hash = (37 * hash) + LAST_NAME_FIELD_NUMBER;
      hash = (53 * hash) + getLastName().hashCode();
      hash = (37 * hash) + BIRTH_DATE_FIELD_NUMBER;
      hash = (53 * hash) + getBirthDate();
      hash = (29 * hash) + getUnknownFields().hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static Person parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Person parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Person parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Person parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Person parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Person parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Person parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
          .parseWithIOException(PARSER, input);
    }
    public static Person parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static Person parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
          .parseDelimitedWithIOException(PARSER, input);
    }

    public static Person parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static Person parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
          .parseWithIOException(PARSER, input);
    }
    public static Person parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(Person prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code Person}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Person)
        PersonOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return PersonOuterClass.internal_static_Person_descriptor;
      }

      @Override
      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return PersonOuterClass.internal_static_Person_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Person.class, Builder.class);
      }

      // Construct using PersonOuterClass.Person.newBuilder()
      private Builder() {

      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);

      }
      @Override
      public Builder clear() {
        super.clear();
        bitField0_ = 0;
        firstName_ = "";
        lastName_ = "";
        birthDate_ = 0;
        return this;
      }

      @Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return PersonOuterClass.internal_static_Person_descriptor;
      }

      @Override
      public Person getDefaultInstanceForType() {
        return Person.getDefaultInstance();
      }

      @Override
      public Person build() {
        Person result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @Override
      public Person buildPartial() {
        Person result = new Person(this);
        if (bitField0_ != 0) { buildPartial0(result); }
        onBuilt();
        return result;
      }

      private void buildPartial0(Person result) {
        int from_bitField0_ = bitField0_;
        if (((from_bitField0_ & 0x00000001) != 0)) {
          result.firstName_ = firstName_;
        }
        if (((from_bitField0_ & 0x00000002) != 0)) {
          result.lastName_ = lastName_;
        }
        if (((from_bitField0_ & 0x00000004) != 0)) {
          result.birthDate_ = birthDate_;
        }
      }

      @Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof Person) {
          return mergeFrom((Person)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(Person other) {
        if (other == Person.getDefaultInstance()) return this;
        if (!other.getFirstName().isEmpty()) {
          firstName_ = other.firstName_;
          bitField0_ |= 0x00000001;
          onChanged();
        }
        if (!other.getLastName().isEmpty()) {
          lastName_ = other.lastName_;
          bitField0_ |= 0x00000002;
          onChanged();
        }
        if (other.getBirthDate() != 0) {
          setBirthDate(other.getBirthDate());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        onChanged();
        return this;
      }

      @Override
      public final boolean isInitialized() {
        return true;
      }

      @Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        if (extensionRegistry == null) {
          throw new NullPointerException();
        }
        try {
          boolean done = false;
          while (!done) {
            int tag = input.readTag();
            switch (tag) {
              case 0:
                done = true;
                break;
              case 10: {
                firstName_ = input.readStringRequireUtf8();
                bitField0_ |= 0x00000001;
                break;
              } // case 10
              case 18: {
                lastName_ = input.readStringRequireUtf8();
                bitField0_ |= 0x00000002;
                break;
              } // case 18
              case 24: {
                birthDate_ = input.readInt32();
                bitField0_ |= 0x00000004;
                break;
              } // case 24
              default: {
                if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                  done = true; // was an endgroup tag
                }
                break;
              } // default:
            } // switch (tag)
          } // while (!done)
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          throw e.unwrapIOException();
        } finally {
          onChanged();
        } // finally
        return this;
      }
      private int bitField0_;

      private Object firstName_ = "";
      /**
       * <code>string first_name = 1;</code>
       * @return The firstName.
       */
      public String getFirstName() {
        Object ref = firstName_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          firstName_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <code>string first_name = 1;</code>
       * @return The bytes for firstName.
       */
      public com.google.protobuf.ByteString
          getFirstNameBytes() {
        Object ref = firstName_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          firstName_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string first_name = 1;</code>
       * @param value The firstName to set.
       * @return This builder for chaining.
       */
      public Builder setFirstName(
          String value) {
        if (value == null) { throw new NullPointerException(); }
        firstName_ = value;
        bitField0_ |= 0x00000001;
        onChanged();
        return this;
      }
      /**
       * <code>string first_name = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearFirstName() {
        firstName_ = getDefaultInstance().getFirstName();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
        return this;
      }
      /**
       * <code>string first_name = 1;</code>
       * @param value The bytes for firstName to set.
       * @return This builder for chaining.
       */
      public Builder setFirstNameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) { throw new NullPointerException(); }
        checkByteStringIsUtf8(value);
        firstName_ = value;
        bitField0_ |= 0x00000001;
        onChanged();
        return this;
      }

      private Object lastName_ = "";
      /**
       * <code>string last_name = 2;</code>
       * @return The lastName.
       */
      public String getLastName() {
        Object ref = lastName_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          lastName_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <code>string last_name = 2;</code>
       * @return The bytes for lastName.
       */
      public com.google.protobuf.ByteString
          getLastNameBytes() {
        Object ref = lastName_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          lastName_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string last_name = 2;</code>
       * @param value The lastName to set.
       * @return This builder for chaining.
       */
      public Builder setLastName(
          String value) {
        if (value == null) { throw new NullPointerException(); }
        lastName_ = value;
        bitField0_ |= 0x00000002;
        onChanged();
        return this;
      }
      /**
       * <code>string last_name = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearLastName() {
        lastName_ = getDefaultInstance().getLastName();
        bitField0_ = (bitField0_ & ~0x00000002);
        onChanged();
        return this;
      }
      /**
       * <code>string last_name = 2;</code>
       * @param value The bytes for lastName to set.
       * @return This builder for chaining.
       */
      public Builder setLastNameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) { throw new NullPointerException(); }
        checkByteStringIsUtf8(value);
        lastName_ = value;
        bitField0_ |= 0x00000002;
        onChanged();
        return this;
      }

      private int birthDate_ ;
      /**
       * <code>int32 birth_date = 3;</code>
       * @return The birthDate.
       */
      @Override
      public int getBirthDate() {
        return birthDate_;
      }
      /**
       * <code>int32 birth_date = 3;</code>
       * @param value The birthDate to set.
       * @return This builder for chaining.
       */
      public Builder setBirthDate(int value) {

        birthDate_ = value;
        bitField0_ |= 0x00000004;
        onChanged();
        return this;
      }
      /**
       * <code>int32 birth_date = 3;</code>
       * @return This builder for chaining.
       */
      public Builder clearBirthDate() {
        bitField0_ = (bitField0_ & ~0x00000004);
        birthDate_ = 0;
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:Person)
    }

    // @@protoc_insertion_point(class_scope:Person)
    private static final Person DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new Person();
    }

    public static Person getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Person>
        PARSER = new com.google.protobuf.AbstractParser<Person>() {
      @Override
      public Person parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        Builder builder = newBuilder();
        try {
          builder.mergeFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          throw e.setUnfinishedMessage(builder.buildPartial());
        } catch (com.google.protobuf.UninitializedMessageException e) {
          throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
        } catch (java.io.IOException e) {
          throw new com.google.protobuf.InvalidProtocolBufferException(e)
              .setUnfinishedMessage(builder.buildPartial());
        }
        return builder.buildPartial();
      }
    };

    public static com.google.protobuf.Parser<Person> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<Person> getParserForType() {
      return PARSER;
    }

    @Override
    public Person getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Person_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_Person_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\014person.proto\"C\n\006Person\022\022\n\nfirst_name\030\001" +
      " \001(\t\022\021\n\tlast_name\030\002 \001(\t\022\022\n\nbirth_date\030\003 " +
      "\001(\005b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_Person_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Person_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_Person_descriptor,
        new String[] { "FirstName", "LastName", "BirthDate", });
    descriptor.resolveAllFeaturesImmutable();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
