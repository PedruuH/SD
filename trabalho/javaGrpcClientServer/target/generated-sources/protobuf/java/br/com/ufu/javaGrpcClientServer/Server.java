// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Server.proto

package br.com.ufu.javaGrpcClientServer;

public final class Server {
  private Server() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_br_com_ufu_javaGrpcClientServer_InsertRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_br_com_ufu_javaGrpcClientServer_InsertRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_br_com_ufu_javaGrpcClientServer_InsertResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_br_com_ufu_javaGrpcClientServer_InsertResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_br_com_ufu_javaGrpcClientServer_SelectRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_br_com_ufu_javaGrpcClientServer_SelectRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_br_com_ufu_javaGrpcClientServer_SelectResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_br_com_ufu_javaGrpcClientServer_SelectResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_br_com_ufu_javaGrpcClientServer_UpdateRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_br_com_ufu_javaGrpcClientServer_UpdateRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_br_com_ufu_javaGrpcClientServer_UpdateResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_br_com_ufu_javaGrpcClientServer_UpdateResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_br_com_ufu_javaGrpcClientServer_DeleteRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_br_com_ufu_javaGrpcClientServer_DeleteRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_br_com_ufu_javaGrpcClientServer_DeleteResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_br_com_ufu_javaGrpcClientServer_DeleteResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\014Server.proto\022\037br.com.ufu.javaGrpcClien" +
      "tServer\" \n\rInsertRequest\022\017\n\007content\030\001 \001(" +
      "\t\"\"\n\016InsertResponse\022\020\n\010response\030\001 \001(\t\"\033\n" +
      "\rSelectRequest\022\n\n\002id\030\001 \001(\003\"\"\n\016SelectResp" +
      "onse\022\020\n\010response\030\001 \001(\t\",\n\rUpdateRequest\022" +
      "\n\n\002id\030\001 \001(\003\022\017\n\007content\030\002 \001(\t\"\"\n\016UpdateRe" +
      "sponse\022\020\n\010response\030\001 \001(\t\"\033\n\rDeleteReques" +
      "t\022\n\n\002id\030\001 \001(\003\"\"\n\016DeleteResponse\022\020\n\010respo" +
      "nse\030\001 \001(\t2\276\003\n\020ReceptionService\022i\n\006insert" +
      "\022..br.com.ufu.javaGrpcClientServer.Inser" +
      "tRequest\032/.br.com.ufu.javaGrpcClientServ" +
      "er.InsertResponse\022i\n\006select\022..br.com.ufu" +
      ".javaGrpcClientServer.SelectRequest\032/.br" +
      ".com.ufu.javaGrpcClientServer.SelectResp" +
      "onse\022i\n\006update\022..br.com.ufu.javaGrpcClie" +
      "ntServer.UpdateRequest\032/.br.com.ufu.java" +
      "GrpcClientServer.UpdateResponse\022i\n\006delet" +
      "e\022..br.com.ufu.javaGrpcClientServer.Dele" +
      "teRequest\032/.br.com.ufu.javaGrpcClientSer" +
      "ver.DeleteResponseB#\n\037br.com.ufu.javaGrp" +
      "cClientServerP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_br_com_ufu_javaGrpcClientServer_InsertRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_br_com_ufu_javaGrpcClientServer_InsertRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_br_com_ufu_javaGrpcClientServer_InsertRequest_descriptor,
        new java.lang.String[] { "Content", });
    internal_static_br_com_ufu_javaGrpcClientServer_InsertResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_br_com_ufu_javaGrpcClientServer_InsertResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_br_com_ufu_javaGrpcClientServer_InsertResponse_descriptor,
        new java.lang.String[] { "Response", });
    internal_static_br_com_ufu_javaGrpcClientServer_SelectRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_br_com_ufu_javaGrpcClientServer_SelectRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_br_com_ufu_javaGrpcClientServer_SelectRequest_descriptor,
        new java.lang.String[] { "Id", });
    internal_static_br_com_ufu_javaGrpcClientServer_SelectResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_br_com_ufu_javaGrpcClientServer_SelectResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_br_com_ufu_javaGrpcClientServer_SelectResponse_descriptor,
        new java.lang.String[] { "Response", });
    internal_static_br_com_ufu_javaGrpcClientServer_UpdateRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_br_com_ufu_javaGrpcClientServer_UpdateRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_br_com_ufu_javaGrpcClientServer_UpdateRequest_descriptor,
        new java.lang.String[] { "Id", "Content", });
    internal_static_br_com_ufu_javaGrpcClientServer_UpdateResponse_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_br_com_ufu_javaGrpcClientServer_UpdateResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_br_com_ufu_javaGrpcClientServer_UpdateResponse_descriptor,
        new java.lang.String[] { "Response", });
    internal_static_br_com_ufu_javaGrpcClientServer_DeleteRequest_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_br_com_ufu_javaGrpcClientServer_DeleteRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_br_com_ufu_javaGrpcClientServer_DeleteRequest_descriptor,
        new java.lang.String[] { "Id", });
    internal_static_br_com_ufu_javaGrpcClientServer_DeleteResponse_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_br_com_ufu_javaGrpcClientServer_DeleteResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_br_com_ufu_javaGrpcClientServer_DeleteResponse_descriptor,
        new java.lang.String[] { "Response", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
