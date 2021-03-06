// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: protocol.proto

package com.cloudzero.arch.pb;

/**
 * <pre>
 *响应协议
 * </pre>
 *
 * Protobuf type {@code CloudResponse}
 */
public  final class CloudResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:CloudResponse)
    CloudResponseOrBuilder {
  // Use CloudResponse.newBuilder() to construct.
  private CloudResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private CloudResponse() {
    returnCode_ = "";
    description_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private CloudResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            returnCode_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            description_ = s;
            break;
          }
          case 170: {
            com.google.protobuf.Any.Builder subBuilder = null;
            if (body_ != null) {
              subBuilder = body_.toBuilder();
            }
            body_ = input.readMessage(com.google.protobuf.Any.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(body_);
              body_ = subBuilder.buildPartial();
            }

            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.cloudzero.arch.pb.Proto.internal_static_CloudResponse_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.cloudzero.arch.pb.Proto.internal_static_CloudResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.cloudzero.arch.pb.CloudResponse.class, com.cloudzero.arch.pb.CloudResponse.Builder.class);
  }

  public static final int RETURNCODE_FIELD_NUMBER = 1;
  private volatile java.lang.Object returnCode_;
  /**
   * <pre>
   *应答码 [必须]
   * </pre>
   *
   * <code>string returnCode = 1;</code>
   */
  public java.lang.String getReturnCode() {
    java.lang.Object ref = returnCode_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      returnCode_ = s;
      return s;
    }
  }
  /**
   * <pre>
   *应答码 [必须]
   * </pre>
   *
   * <code>string returnCode = 1;</code>
   */
  public com.google.protobuf.ByteString
      getReturnCodeBytes() {
    java.lang.Object ref = returnCode_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      returnCode_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int DESCRIPTION_FIELD_NUMBER = 2;
  private volatile java.lang.Object description_;
  /**
   * <pre>
   *简短描述 [可选]
   * </pre>
   *
   * <code>string description = 2;</code>
   */
  public java.lang.String getDescription() {
    java.lang.Object ref = description_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      description_ = s;
      return s;
    }
  }
  /**
   * <pre>
   *简短描述 [可选]
   * </pre>
   *
   * <code>string description = 2;</code>
   */
  public com.google.protobuf.ByteString
      getDescriptionBytes() {
    java.lang.Object ref = description_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      description_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int BODY_FIELD_NUMBER = 21;
  private com.google.protobuf.Any body_;
  /**
   * <pre>
   *响应消息体 [可选]
   * </pre>
   *
   * <code>.google.protobuf.Any body = 21;</code>
   */
  public boolean hasBody() {
    return body_ != null;
  }
  /**
   * <pre>
   *响应消息体 [可选]
   * </pre>
   *
   * <code>.google.protobuf.Any body = 21;</code>
   */
  public com.google.protobuf.Any getBody() {
    return body_ == null ? com.google.protobuf.Any.getDefaultInstance() : body_;
  }
  /**
   * <pre>
   *响应消息体 [可选]
   * </pre>
   *
   * <code>.google.protobuf.Any body = 21;</code>
   */
  public com.google.protobuf.AnyOrBuilder getBodyOrBuilder() {
    return getBody();
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getReturnCodeBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, returnCode_);
    }
    if (!getDescriptionBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, description_);
    }
    if (body_ != null) {
      output.writeMessage(21, getBody());
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getReturnCodeBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, returnCode_);
    }
    if (!getDescriptionBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, description_);
    }
    if (body_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(21, getBody());
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.cloudzero.arch.pb.CloudResponse)) {
      return super.equals(obj);
    }
    com.cloudzero.arch.pb.CloudResponse other = (com.cloudzero.arch.pb.CloudResponse) obj;

    boolean result = true;
    result = result && getReturnCode()
        .equals(other.getReturnCode());
    result = result && getDescription()
        .equals(other.getDescription());
    result = result && (hasBody() == other.hasBody());
    if (hasBody()) {
      result = result && getBody()
          .equals(other.getBody());
    }
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + RETURNCODE_FIELD_NUMBER;
    hash = (53 * hash) + getReturnCode().hashCode();
    hash = (37 * hash) + DESCRIPTION_FIELD_NUMBER;
    hash = (53 * hash) + getDescription().hashCode();
    if (hasBody()) {
      hash = (37 * hash) + BODY_FIELD_NUMBER;
      hash = (53 * hash) + getBody().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.cloudzero.arch.pb.CloudResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.cloudzero.arch.pb.CloudResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.cloudzero.arch.pb.CloudResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.cloudzero.arch.pb.CloudResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.cloudzero.arch.pb.CloudResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.cloudzero.arch.pb.CloudResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.cloudzero.arch.pb.CloudResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.cloudzero.arch.pb.CloudResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.cloudzero.arch.pb.CloudResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.cloudzero.arch.pb.CloudResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.cloudzero.arch.pb.CloudResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.cloudzero.arch.pb.CloudResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.cloudzero.arch.pb.CloudResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   *响应协议
   * </pre>
   *
   * Protobuf type {@code CloudResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:CloudResponse)
      com.cloudzero.arch.pb.CloudResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.cloudzero.arch.pb.Proto.internal_static_CloudResponse_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cloudzero.arch.pb.Proto.internal_static_CloudResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cloudzero.arch.pb.CloudResponse.class, com.cloudzero.arch.pb.CloudResponse.Builder.class);
    }

    // Construct using com.cloudzero.arch.pb.CloudResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      returnCode_ = "";

      description_ = "";

      if (bodyBuilder_ == null) {
        body_ = null;
      } else {
        body_ = null;
        bodyBuilder_ = null;
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.cloudzero.arch.pb.Proto.internal_static_CloudResponse_descriptor;
    }

    public com.cloudzero.arch.pb.CloudResponse getDefaultInstanceForType() {
      return com.cloudzero.arch.pb.CloudResponse.getDefaultInstance();
    }

    public com.cloudzero.arch.pb.CloudResponse build() {
      com.cloudzero.arch.pb.CloudResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.cloudzero.arch.pb.CloudResponse buildPartial() {
      com.cloudzero.arch.pb.CloudResponse result = new com.cloudzero.arch.pb.CloudResponse(this);
      result.returnCode_ = returnCode_;
      result.description_ = description_;
      if (bodyBuilder_ == null) {
        result.body_ = body_;
      } else {
        result.body_ = bodyBuilder_.build();
      }
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.cloudzero.arch.pb.CloudResponse) {
        return mergeFrom((com.cloudzero.arch.pb.CloudResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.cloudzero.arch.pb.CloudResponse other) {
      if (other == com.cloudzero.arch.pb.CloudResponse.getDefaultInstance()) return this;
      if (!other.getReturnCode().isEmpty()) {
        returnCode_ = other.returnCode_;
        onChanged();
      }
      if (!other.getDescription().isEmpty()) {
        description_ = other.description_;
        onChanged();
      }
      if (other.hasBody()) {
        mergeBody(other.getBody());
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.cloudzero.arch.pb.CloudResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.cloudzero.arch.pb.CloudResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object returnCode_ = "";
    /**
     * <pre>
     *应答码 [必须]
     * </pre>
     *
     * <code>string returnCode = 1;</code>
     */
    public java.lang.String getReturnCode() {
      java.lang.Object ref = returnCode_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        returnCode_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     *应答码 [必须]
     * </pre>
     *
     * <code>string returnCode = 1;</code>
     */
    public com.google.protobuf.ByteString
        getReturnCodeBytes() {
      java.lang.Object ref = returnCode_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        returnCode_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     *应答码 [必须]
     * </pre>
     *
     * <code>string returnCode = 1;</code>
     */
    public Builder setReturnCode(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      returnCode_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *应答码 [必须]
     * </pre>
     *
     * <code>string returnCode = 1;</code>
     */
    public Builder clearReturnCode() {
      
      returnCode_ = getDefaultInstance().getReturnCode();
      onChanged();
      return this;
    }
    /**
     * <pre>
     *应答码 [必须]
     * </pre>
     *
     * <code>string returnCode = 1;</code>
     */
    public Builder setReturnCodeBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      returnCode_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object description_ = "";
    /**
     * <pre>
     *简短描述 [可选]
     * </pre>
     *
     * <code>string description = 2;</code>
     */
    public java.lang.String getDescription() {
      java.lang.Object ref = description_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        description_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     *简短描述 [可选]
     * </pre>
     *
     * <code>string description = 2;</code>
     */
    public com.google.protobuf.ByteString
        getDescriptionBytes() {
      java.lang.Object ref = description_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        description_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     *简短描述 [可选]
     * </pre>
     *
     * <code>string description = 2;</code>
     */
    public Builder setDescription(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      description_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *简短描述 [可选]
     * </pre>
     *
     * <code>string description = 2;</code>
     */
    public Builder clearDescription() {
      
      description_ = getDefaultInstance().getDescription();
      onChanged();
      return this;
    }
    /**
     * <pre>
     *简短描述 [可选]
     * </pre>
     *
     * <code>string description = 2;</code>
     */
    public Builder setDescriptionBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      description_ = value;
      onChanged();
      return this;
    }

    private com.google.protobuf.Any body_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Any, com.google.protobuf.Any.Builder, com.google.protobuf.AnyOrBuilder> bodyBuilder_;
    /**
     * <pre>
     *响应消息体 [可选]
     * </pre>
     *
     * <code>.google.protobuf.Any body = 21;</code>
     */
    public boolean hasBody() {
      return bodyBuilder_ != null || body_ != null;
    }
    /**
     * <pre>
     *响应消息体 [可选]
     * </pre>
     *
     * <code>.google.protobuf.Any body = 21;</code>
     */
    public com.google.protobuf.Any getBody() {
      if (bodyBuilder_ == null) {
        return body_ == null ? com.google.protobuf.Any.getDefaultInstance() : body_;
      } else {
        return bodyBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     *响应消息体 [可选]
     * </pre>
     *
     * <code>.google.protobuf.Any body = 21;</code>
     */
    public Builder setBody(com.google.protobuf.Any value) {
      if (bodyBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        body_ = value;
        onChanged();
      } else {
        bodyBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <pre>
     *响应消息体 [可选]
     * </pre>
     *
     * <code>.google.protobuf.Any body = 21;</code>
     */
    public Builder setBody(
        com.google.protobuf.Any.Builder builderForValue) {
      if (bodyBuilder_ == null) {
        body_ = builderForValue.build();
        onChanged();
      } else {
        bodyBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <pre>
     *响应消息体 [可选]
     * </pre>
     *
     * <code>.google.protobuf.Any body = 21;</code>
     */
    public Builder mergeBody(com.google.protobuf.Any value) {
      if (bodyBuilder_ == null) {
        if (body_ != null) {
          body_ =
            com.google.protobuf.Any.newBuilder(body_).mergeFrom(value).buildPartial();
        } else {
          body_ = value;
        }
        onChanged();
      } else {
        bodyBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <pre>
     *响应消息体 [可选]
     * </pre>
     *
     * <code>.google.protobuf.Any body = 21;</code>
     */
    public Builder clearBody() {
      if (bodyBuilder_ == null) {
        body_ = null;
        onChanged();
      } else {
        body_ = null;
        bodyBuilder_ = null;
      }

      return this;
    }
    /**
     * <pre>
     *响应消息体 [可选]
     * </pre>
     *
     * <code>.google.protobuf.Any body = 21;</code>
     */
    public com.google.protobuf.Any.Builder getBodyBuilder() {
      
      onChanged();
      return getBodyFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     *响应消息体 [可选]
     * </pre>
     *
     * <code>.google.protobuf.Any body = 21;</code>
     */
    public com.google.protobuf.AnyOrBuilder getBodyOrBuilder() {
      if (bodyBuilder_ != null) {
        return bodyBuilder_.getMessageOrBuilder();
      } else {
        return body_ == null ?
            com.google.protobuf.Any.getDefaultInstance() : body_;
      }
    }
    /**
     * <pre>
     *响应消息体 [可选]
     * </pre>
     *
     * <code>.google.protobuf.Any body = 21;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Any, com.google.protobuf.Any.Builder, com.google.protobuf.AnyOrBuilder> 
        getBodyFieldBuilder() {
      if (bodyBuilder_ == null) {
        bodyBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.google.protobuf.Any, com.google.protobuf.Any.Builder, com.google.protobuf.AnyOrBuilder>(
                getBody(),
                getParentForChildren(),
                isClean());
        body_ = null;
      }
      return bodyBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:CloudResponse)
  }

  // @@protoc_insertion_point(class_scope:CloudResponse)
  private static final com.cloudzero.arch.pb.CloudResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.cloudzero.arch.pb.CloudResponse();
  }

  public static com.cloudzero.arch.pb.CloudResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<CloudResponse>
      PARSER = new com.google.protobuf.AbstractParser<CloudResponse>() {
    public CloudResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new CloudResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<CloudResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<CloudResponse> getParserForType() {
    return PARSER;
  }

  public com.cloudzero.arch.pb.CloudResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

