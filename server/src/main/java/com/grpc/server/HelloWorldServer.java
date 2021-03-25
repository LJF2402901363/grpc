package com.grpc.server;
//import com
import com.grpc.proto.GreeterGrpc;
import com.grpc.proto.HelloReply;
import com.grpc.proto.HelloRequest;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.logging.Logger;
 @Slf4j
public class HelloWorldServer {
    /* The port on which the server should run */
    private int port = 50051;
    private Server server;
 
    private void start() throws IOException {
        server = ServerBuilder.forPort(port)
                .addService( new GreeterImpl())
                .build()
                .start();
        log.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                HelloWorldServer.this.stop();
                System.err.println("*** server shut down");
            }
        });
    }
 
    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }
 
    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }
 
    /**
     * Main launches the server from the command line.
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        final HelloWorldServer server = new HelloWorldServer();
        server.start();
        server.blockUntilShutdown();
    }
 
    static class GreeterImpl extends GreeterGrpc.GreeterImplBase {
        /** 原子Integer */
    //    public AtomicInteger count = new AtomicInteger(0);
 
        public void sayHello(HelloRequest req, StreamObserver<HelloReply> responseObserver) {
//            System.out.println("call sayHello");
            HelloReply reply = HelloReply.newBuilder().setMessage("Hello " + req.getName()).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
//            System.out.println(count.incrementAndGet() + Thread.currentThread().getName());
        }
    }
}