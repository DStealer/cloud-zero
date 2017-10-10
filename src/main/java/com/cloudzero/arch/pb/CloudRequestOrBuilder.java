// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: protocol.proto

package com.cloudzero.arch.pb;

public interface CloudRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:CloudRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   *处理请求的单元的标签 [必须]
   * </pre>
   *
   * <code>string ngLabel = 1;</code>
   */
  java.lang.String getNgLabel();
  /**
   * <pre>
   *处理请求的单元的标签 [必须]
   * </pre>
   *
   * <code>string ngLabel = 1;</code>
   */
  com.google.protobuf.ByteString
      getNgLabelBytes();

  /**
   * <pre>
   *处理请求的单元的版本 [必须]
   * </pre>
   *
   * <code>string ngVersion = 2;</code>
   */
  java.lang.String getNgVersion();
  /**
   * <pre>
   *处理请求的单元的版本 [必须]
   * </pre>
   *
   * <code>string ngVersion = 2;</code>
   */
  com.google.protobuf.ByteString
      getNgVersionBytes();

  /**
   * <pre>
   *请求动作描述 [必须]
   * </pre>
   *
   * <code>string action = 3;</code>
   */
  java.lang.String getAction();
  /**
   * <pre>
   *请求动作描述 [必须]
   * </pre>
   *
   * <code>string action = 3;</code>
   */
  com.google.protobuf.ByteString
      getActionBytes();

  /**
   * <pre>
   *动作版本 [必须]
   * </pre>
   *
   * <code>string actVersion = 4;</code>
   */
  java.lang.String getActVersion();
  /**
   * <pre>
   *动作版本 [必须]
   * </pre>
   *
   * <code>string actVersion = 4;</code>
   */
  com.google.protobuf.ByteString
      getActVersionBytes();

  /**
   * <pre>
   *请求发送平台的类型
   * </pre>
   *
   * <code>.CloudRequest.Platform platform = 5;</code>
   */
  int getPlatformValue();
  /**
   * <pre>
   *请求发送平台的类型
   * </pre>
   *
   * <code>.CloudRequest.Platform platform = 5;</code>
   */
  com.cloudzero.arch.pb.CloudRequest.Platform getPlatform();

  /**
   * <pre>
   *请求消息体 [可选]
   * </pre>
   *
   * <code>.google.protobuf.Any body = 21;</code>
   */
  boolean hasBody();
  /**
   * <pre>
   *请求消息体 [可选]
   * </pre>
   *
   * <code>.google.protobuf.Any body = 21;</code>
   */
  com.google.protobuf.Any getBody();
  /**
   * <pre>
   *请求消息体 [可选]
   * </pre>
   *
   * <code>.google.protobuf.Any body = 21;</code>
   */
  com.google.protobuf.AnyOrBuilder getBodyOrBuilder();
}