package br.com.ufu.javaServer;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.20.0)",
    comments = "Source: Server.proto")
public final class ReceptionServiceGrpc {

  private ReceptionServiceGrpc() {}

  public static final String SERVICE_NAME = "br.com.ufu.javaServer.ReceptionService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<br.com.ufu.javaServer.InsertRequest,
      br.com.ufu.javaServer.InsertResponse> getInsertMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "insert",
      requestType = br.com.ufu.javaServer.InsertRequest.class,
      responseType = br.com.ufu.javaServer.InsertResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<br.com.ufu.javaServer.InsertRequest,
      br.com.ufu.javaServer.InsertResponse> getInsertMethod() {
    io.grpc.MethodDescriptor<br.com.ufu.javaServer.InsertRequest, br.com.ufu.javaServer.InsertResponse> getInsertMethod;
    if ((getInsertMethod = ReceptionServiceGrpc.getInsertMethod) == null) {
      synchronized (ReceptionServiceGrpc.class) {
        if ((getInsertMethod = ReceptionServiceGrpc.getInsertMethod) == null) {
          ReceptionServiceGrpc.getInsertMethod = getInsertMethod = 
              io.grpc.MethodDescriptor.<br.com.ufu.javaServer.InsertRequest, br.com.ufu.javaServer.InsertResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "br.com.ufu.javaServer.ReceptionService", "insert"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  br.com.ufu.javaServer.InsertRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  br.com.ufu.javaServer.InsertResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ReceptionServiceMethodDescriptorSupplier("insert"))
                  .build();
          }
        }
     }
     return getInsertMethod;
  }

  private static volatile io.grpc.MethodDescriptor<br.com.ufu.javaServer.SelectRequest,
      br.com.ufu.javaServer.SelectResponse> getSelectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "select",
      requestType = br.com.ufu.javaServer.SelectRequest.class,
      responseType = br.com.ufu.javaServer.SelectResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<br.com.ufu.javaServer.SelectRequest,
      br.com.ufu.javaServer.SelectResponse> getSelectMethod() {
    io.grpc.MethodDescriptor<br.com.ufu.javaServer.SelectRequest, br.com.ufu.javaServer.SelectResponse> getSelectMethod;
    if ((getSelectMethod = ReceptionServiceGrpc.getSelectMethod) == null) {
      synchronized (ReceptionServiceGrpc.class) {
        if ((getSelectMethod = ReceptionServiceGrpc.getSelectMethod) == null) {
          ReceptionServiceGrpc.getSelectMethod = getSelectMethod = 
              io.grpc.MethodDescriptor.<br.com.ufu.javaServer.SelectRequest, br.com.ufu.javaServer.SelectResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "br.com.ufu.javaServer.ReceptionService", "select"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  br.com.ufu.javaServer.SelectRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  br.com.ufu.javaServer.SelectResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ReceptionServiceMethodDescriptorSupplier("select"))
                  .build();
          }
        }
     }
     return getSelectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<br.com.ufu.javaServer.UpdateRequest,
      br.com.ufu.javaServer.UpdateResponse> getUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "update",
      requestType = br.com.ufu.javaServer.UpdateRequest.class,
      responseType = br.com.ufu.javaServer.UpdateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<br.com.ufu.javaServer.UpdateRequest,
      br.com.ufu.javaServer.UpdateResponse> getUpdateMethod() {
    io.grpc.MethodDescriptor<br.com.ufu.javaServer.UpdateRequest, br.com.ufu.javaServer.UpdateResponse> getUpdateMethod;
    if ((getUpdateMethod = ReceptionServiceGrpc.getUpdateMethod) == null) {
      synchronized (ReceptionServiceGrpc.class) {
        if ((getUpdateMethod = ReceptionServiceGrpc.getUpdateMethod) == null) {
          ReceptionServiceGrpc.getUpdateMethod = getUpdateMethod = 
              io.grpc.MethodDescriptor.<br.com.ufu.javaServer.UpdateRequest, br.com.ufu.javaServer.UpdateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "br.com.ufu.javaServer.ReceptionService", "update"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  br.com.ufu.javaServer.UpdateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  br.com.ufu.javaServer.UpdateResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ReceptionServiceMethodDescriptorSupplier("update"))
                  .build();
          }
        }
     }
     return getUpdateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<br.com.ufu.javaServer.DeleteRequest,
      br.com.ufu.javaServer.DeleteResponse> getDeleteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "delete",
      requestType = br.com.ufu.javaServer.DeleteRequest.class,
      responseType = br.com.ufu.javaServer.DeleteResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<br.com.ufu.javaServer.DeleteRequest,
      br.com.ufu.javaServer.DeleteResponse> getDeleteMethod() {
    io.grpc.MethodDescriptor<br.com.ufu.javaServer.DeleteRequest, br.com.ufu.javaServer.DeleteResponse> getDeleteMethod;
    if ((getDeleteMethod = ReceptionServiceGrpc.getDeleteMethod) == null) {
      synchronized (ReceptionServiceGrpc.class) {
        if ((getDeleteMethod = ReceptionServiceGrpc.getDeleteMethod) == null) {
          ReceptionServiceGrpc.getDeleteMethod = getDeleteMethod = 
              io.grpc.MethodDescriptor.<br.com.ufu.javaServer.DeleteRequest, br.com.ufu.javaServer.DeleteResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "br.com.ufu.javaServer.ReceptionService", "delete"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  br.com.ufu.javaServer.DeleteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  br.com.ufu.javaServer.DeleteResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ReceptionServiceMethodDescriptorSupplier("delete"))
                  .build();
          }
        }
     }
     return getDeleteMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ReceptionServiceStub newStub(io.grpc.Channel channel) {
    return new ReceptionServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ReceptionServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ReceptionServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ReceptionServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ReceptionServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ReceptionServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void insert(br.com.ufu.javaServer.InsertRequest request,
        io.grpc.stub.StreamObserver<br.com.ufu.javaServer.InsertResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getInsertMethod(), responseObserver);
    }

    /**
     */
    public void select(br.com.ufu.javaServer.SelectRequest request,
        io.grpc.stub.StreamObserver<br.com.ufu.javaServer.SelectResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSelectMethod(), responseObserver);
    }

    /**
     */
    public void update(br.com.ufu.javaServer.UpdateRequest request,
        io.grpc.stub.StreamObserver<br.com.ufu.javaServer.UpdateResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateMethod(), responseObserver);
    }

    /**
     */
    public void delete(br.com.ufu.javaServer.DeleteRequest request,
        io.grpc.stub.StreamObserver<br.com.ufu.javaServer.DeleteResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getInsertMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                br.com.ufu.javaServer.InsertRequest,
                br.com.ufu.javaServer.InsertResponse>(
                  this, METHODID_INSERT)))
          .addMethod(
            getSelectMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                br.com.ufu.javaServer.SelectRequest,
                br.com.ufu.javaServer.SelectResponse>(
                  this, METHODID_SELECT)))
          .addMethod(
            getUpdateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                br.com.ufu.javaServer.UpdateRequest,
                br.com.ufu.javaServer.UpdateResponse>(
                  this, METHODID_UPDATE)))
          .addMethod(
            getDeleteMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                br.com.ufu.javaServer.DeleteRequest,
                br.com.ufu.javaServer.DeleteResponse>(
                  this, METHODID_DELETE)))
          .build();
    }
  }

  /**
   */
  public static final class ReceptionServiceStub extends io.grpc.stub.AbstractStub<ReceptionServiceStub> {
    private ReceptionServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ReceptionServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReceptionServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ReceptionServiceStub(channel, callOptions);
    }

    /**
     */
    public void insert(br.com.ufu.javaServer.InsertRequest request,
        io.grpc.stub.StreamObserver<br.com.ufu.javaServer.InsertResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInsertMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void select(br.com.ufu.javaServer.SelectRequest request,
        io.grpc.stub.StreamObserver<br.com.ufu.javaServer.SelectResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSelectMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void update(br.com.ufu.javaServer.UpdateRequest request,
        io.grpc.stub.StreamObserver<br.com.ufu.javaServer.UpdateResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void delete(br.com.ufu.javaServer.DeleteRequest request,
        io.grpc.stub.StreamObserver<br.com.ufu.javaServer.DeleteResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ReceptionServiceBlockingStub extends io.grpc.stub.AbstractStub<ReceptionServiceBlockingStub> {
    private ReceptionServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ReceptionServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReceptionServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ReceptionServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public br.com.ufu.javaServer.InsertResponse insert(br.com.ufu.javaServer.InsertRequest request) {
      return blockingUnaryCall(
          getChannel(), getInsertMethod(), getCallOptions(), request);
    }

    /**
     */
    public br.com.ufu.javaServer.SelectResponse select(br.com.ufu.javaServer.SelectRequest request) {
      return blockingUnaryCall(
          getChannel(), getSelectMethod(), getCallOptions(), request);
    }

    /**
     */
    public br.com.ufu.javaServer.UpdateResponse update(br.com.ufu.javaServer.UpdateRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateMethod(), getCallOptions(), request);
    }

    /**
     */
    public br.com.ufu.javaServer.DeleteResponse delete(br.com.ufu.javaServer.DeleteRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ReceptionServiceFutureStub extends io.grpc.stub.AbstractStub<ReceptionServiceFutureStub> {
    private ReceptionServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ReceptionServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReceptionServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ReceptionServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<br.com.ufu.javaServer.InsertResponse> insert(
        br.com.ufu.javaServer.InsertRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getInsertMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<br.com.ufu.javaServer.SelectResponse> select(
        br.com.ufu.javaServer.SelectRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSelectMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<br.com.ufu.javaServer.UpdateResponse> update(
        br.com.ufu.javaServer.UpdateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<br.com.ufu.javaServer.DeleteResponse> delete(
        br.com.ufu.javaServer.DeleteRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_INSERT = 0;
  private static final int METHODID_SELECT = 1;
  private static final int METHODID_UPDATE = 2;
  private static final int METHODID_DELETE = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ReceptionServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ReceptionServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_INSERT:
          serviceImpl.insert((br.com.ufu.javaServer.InsertRequest) request,
              (io.grpc.stub.StreamObserver<br.com.ufu.javaServer.InsertResponse>) responseObserver);
          break;
        case METHODID_SELECT:
          serviceImpl.select((br.com.ufu.javaServer.SelectRequest) request,
              (io.grpc.stub.StreamObserver<br.com.ufu.javaServer.SelectResponse>) responseObserver);
          break;
        case METHODID_UPDATE:
          serviceImpl.update((br.com.ufu.javaServer.UpdateRequest) request,
              (io.grpc.stub.StreamObserver<br.com.ufu.javaServer.UpdateResponse>) responseObserver);
          break;
        case METHODID_DELETE:
          serviceImpl.delete((br.com.ufu.javaServer.DeleteRequest) request,
              (io.grpc.stub.StreamObserver<br.com.ufu.javaServer.DeleteResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ReceptionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ReceptionServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return br.com.ufu.javaServer.Server.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ReceptionService");
    }
  }

  private static final class ReceptionServiceFileDescriptorSupplier
      extends ReceptionServiceBaseDescriptorSupplier {
    ReceptionServiceFileDescriptorSupplier() {}
  }

  private static final class ReceptionServiceMethodDescriptorSupplier
      extends ReceptionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ReceptionServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ReceptionServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ReceptionServiceFileDescriptorSupplier())
              .addMethod(getInsertMethod())
              .addMethod(getSelectMethod())
              .addMethod(getUpdateMethod())
              .addMethod(getDeleteMethod())
              .build();
        }
      }
    }
    return result;
  }
}
