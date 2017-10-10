// **********************************************************************
//
// Copyright (c) 2003-2016 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.6.3
//
// <auto-generated>
//
// Generated from file `interface.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package com.cloudzero.arch.ice.generate;

public final class RequestHelper
{
    public static void
    write(IceInternal.BasicStream __os, com.cloudzero.arch.pb.CloudRequest __v)
    {
        if(!__v.isInitialized())
        {
            throw new Ice.MarshalException("type not fully initialized");
        }
        __os.writeByteSeq(__v.toByteArray());
    }

    public static com.cloudzero.arch.pb.CloudRequest
    read(IceInternal.BasicStream __is)
    {
        com.cloudzero.arch.pb.CloudRequest __v;
        try
        {
            __v = com.cloudzero.arch.pb.CloudRequest.parseFrom(__is.readByteSeq());
        }
        catch(com.google.protobuf.InvalidProtocolBufferException __ex)
        {
            throw new Ice.MarshalException(__ex);
        }
        return __v;
    }
}