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

public abstract class _DIceCallerDisp extends Ice.ObjectImpl implements DIceCaller
{
    protected void
    ice_copyStateFrom(Ice.Object __obj)
        throws java.lang.CloneNotSupportedException
    {
        throw new java.lang.CloneNotSupportedException();
    }

    public static final String[] __ids =
    {
        "::Ice::Object",
        "::generate::DIceCaller"
    };

    public boolean ice_isA(String s)
    {
        return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public boolean ice_isA(String s, Ice.Current __current)
    {
        return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public String[] ice_ids()
    {
        return __ids;
    }

    public String[] ice_ids(Ice.Current __current)
    {
        return __ids;
    }

    public String ice_id()
    {
        return __ids[1];
    }

    public String ice_id(Ice.Current __current)
    {
        return __ids[1];
    }

    public static String ice_staticId()
    {
        return __ids[1];
    }

    public final void call(com.cloudzero.arch.pb.CloudRequest request)
    {
        call(request, null);
    }

    public final com.cloudzero.arch.pb.CloudResponse invoke(com.cloudzero.arch.pb.CloudRequest request)
    {
        return invoke(request, null);
    }

    public static Ice.DispatchStatus ___call(DIceCaller __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.startReadParams();
        com.cloudzero.arch.pb.CloudRequest request;
        try
        {
            request = com.cloudzero.arch.pb.CloudRequest.parseFrom(__is.readByteSeq());
        }
        catch(com.google.protobuf.InvalidProtocolBufferException __ex)
        {
            throw new Ice.MarshalException(__ex);
        }
        __inS.endReadParams();
        __obj.call(request, __current);
        __inS.__writeEmptyParams();
        return Ice.DispatchStatus.DispatchOK;
    }

    public static Ice.DispatchStatus ___invoke(DIceCaller __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.startReadParams();
        com.cloudzero.arch.pb.CloudRequest request;
        try
        {
            request = com.cloudzero.arch.pb.CloudRequest.parseFrom(__is.readByteSeq());
        }
        catch(com.google.protobuf.InvalidProtocolBufferException __ex)
        {
            throw new Ice.MarshalException(__ex);
        }
        __inS.endReadParams();
        com.cloudzero.arch.pb.CloudResponse __ret = __obj.invoke(request, __current);
        IceInternal.BasicStream __os = __inS.__startWriteParams(Ice.FormatType.DefaultFormat);
        if(!__ret.isInitialized())
        {
            throw new Ice.MarshalException("type not fully initialized");
        }
        __os.writeByteSeq(__ret.toByteArray());
        __inS.__endWriteParams(true);
        return Ice.DispatchStatus.DispatchOK;
    }

    private final static String[] __all =
    {
        "call",
        "ice_id",
        "ice_ids",
        "ice_isA",
        "ice_ping",
        "invoke"
    };

    public Ice.DispatchStatus __dispatch(IceInternal.Incoming in, Ice.Current __current)
    {
        int pos = java.util.Arrays.binarySearch(__all, __current.operation);
        if(pos < 0)
        {
            throw new Ice.OperationNotExistException(__current.id, __current.facet, __current.operation);
        }

        switch(pos)
        {
            case 0:
            {
                return ___call(this, in, __current);
            }
            case 1:
            {
                return ___ice_id(this, in, __current);
            }
            case 2:
            {
                return ___ice_ids(this, in, __current);
            }
            case 3:
            {
                return ___ice_isA(this, in, __current);
            }
            case 4:
            {
                return ___ice_ping(this, in, __current);
            }
            case 5:
            {
                return ___invoke(this, in, __current);
            }
        }

        assert(false);
        throw new Ice.OperationNotExistException(__current.id, __current.facet, __current.operation);
    }

    protected void __writeImpl(IceInternal.BasicStream __os)
    {
        __os.startWriteSlice(ice_staticId(), -1, true);
        __os.endWriteSlice();
    }

    protected void __readImpl(IceInternal.BasicStream __is)
    {
        __is.startReadSlice();
        __is.endReadSlice();
    }

    public static final long serialVersionUID = 0L;
}
