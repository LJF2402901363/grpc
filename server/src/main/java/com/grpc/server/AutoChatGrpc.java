package server;

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
 * <pre>
 * The greeting service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.26.0)",
    comments = "Source: autochat.proto")
public final class AutoChatGrpc {

  private AutoChatGrpc() {}

  public static final String SERVICE_NAME = "server.AutoChat";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<server.AutoChatRequest,
      server.AutoChatReply> getAutoChatMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "autoChat",
      requestType = server.AutoChatRequest.class,
      responseType = server.AutoChatReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<server.AutoChatRequest,
      server.AutoChatReply> getAutoChatMethod() {
    io.grpc.MethodDescriptor<server.AutoChatRequest, server.AutoChatReply> getAutoChatMethod;
    if ((getAutoChatMethod = AutoChatGrpc.getAutoChatMethod) == null) {
      synchronized (AutoChatGrpc.class) {
        if ((getAutoChatMethod = AutoChatGrpc.getAutoChatMethod) == null) {
          AutoChatGrpc.getAutoChatMethod = getAutoChatMethod =
              io.grpc.MethodDescriptor.<server.AutoChatRequest, server.AutoChatReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "autoChat"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  server.AutoChatRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  server.AutoChatReply.getDefaultInstance()))
              .setSchemaDescriptor(new AutoChatMethodDescriptorSupplier("autoChat"))
              .build();
        }
      }
    }
    return getAutoChatMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AutoChatStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AutoChatStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AutoChatStub>() {
        @java.lang.Override
        public AutoChatStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AutoChatStub(channel, callOptions);
        }
      };
    return AutoChatStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AutoChatBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AutoChatBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AutoChatBlockingStub>() {
        @java.lang.Override
        public AutoChatBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AutoChatBlockingStub(channel, callOptions);
        }
      };
    return AutoChatBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AutoChatFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AutoChatFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AutoChatFutureStub>() {
        @java.lang.Override
        public AutoChatFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AutoChatFutureStub(channel, callOptions);
        }
      };
    return AutoChatFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static abstract class AutoChatImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void autoChat(server.AutoChatRequest request,
        io.grpc.stub.StreamObserver<server.AutoChatReply> responseObserver) {
      asyncUnimplementedUnaryCall(getAutoChatMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAutoChatMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                server.AutoChatRequest,
                server.AutoChatReply>(
                  this, METHODID_AUTO_CHAT)))
          .build();
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class AutoChatStub extends io.grpc.stub.AbstractAsyncStub<AutoChatStub> {
    private AutoChatStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AutoChatStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AutoChatStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void autoChat(server.AutoChatRequest request,
        io.grpc.stub.StreamObserver<server.AutoChatReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAutoChatMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class AutoChatBlockingStub extends io.grpc.stub.AbstractBlockingStub<AutoChatBlockingStub> {
    private AutoChatBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AutoChatBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AutoChatBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public server.AutoChatReply autoChat(server.AutoChatRequest request) {
      return blockingUnaryCall(
          getChannel(), getAutoChatMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class AutoChatFutureStub extends io.grpc.stub.AbstractFutureStub<AutoChatFutureStub> {
    private AutoChatFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AutoChatFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AutoChatFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<server.AutoChatReply> autoChat(
        server.AutoChatRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAutoChatMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_AUTO_CHAT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AutoChatImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AutoChatImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_AUTO_CHAT:
          serviceImpl.autoChat((server.AutoChatRequest) request,
              (io.grpc.stub.StreamObserver<server.AutoChatReply>) responseObserver);
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

  private static abstract class AutoChatBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AutoChatBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return server.Autochat.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AutoChat");
    }
  }

  private static final class AutoChatFileDescriptorSupplier
      extends AutoChatBaseDescriptorSupplier {
    AutoChatFileDescriptorSupplier() {}
  }

  private static final class AutoChatMethodDescriptorSupplier
      extends AutoChatBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AutoChatMethodDescriptorSupplier(String methodName) {
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
      synchronized (AutoChatGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AutoChatFileDescriptorSupplier())
              .addMethod(getAutoChatMethod())
              .build();
        }
      }
    }
    return result;
  }
}
