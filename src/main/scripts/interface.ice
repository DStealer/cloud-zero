[["java:package:com.cloudzero.arch.ice"]]
module generate{
["java:protobuf:com.cloudzero.arch.pb.CloudRequest"] sequence<byte> Request;
["java:protobuf:com.cloudzero.arch.pb.CloudResponse"] sequence<byte> Response;
     interface DIceCaller{
         void call(Request request);
         Response invoke(Request request);
     };
};