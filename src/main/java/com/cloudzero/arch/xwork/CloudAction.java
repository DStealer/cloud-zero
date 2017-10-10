package com.cloudzero.arch.xwork;

import com.cloudzero.arch.pb.Void;
import com.google.protobuf.Any;
import com.google.protobuf.GeneratedMessageV3;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.config.entities.Parameterizable;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * 所有Action的父类
 * Created by lishiwu on 2016/9/18.
 */
public abstract class CloudAction<Q extends GeneratedMessageV3, S extends GeneratedMessageV3> implements Action, Parameterizable {
    protected Q request;
    private Map<String, String> staticParameters;

    /**
     * 获取泛型 Q S
     *
     * @return
     */
    private Class[] getTypes() {
        Type type = this.getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type[] types = parameterizedType.getActualTypeArguments();
            if (types != null && types.length == 2) {
                return new Class[]{(Class) types[0], (Class) types[1]};
            } else {
                throw new UnsupportedOperationException("Generic super class not exits");
            }
        } else {
            throw new UnsupportedOperationException("Generic super class not exits");
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public String execute() throws Exception {
        Class[] clazz = this.getTypes();
        ActionContext ac = ActionContext.getContext();
        MessageHolder holder = (MessageHolder) ac.get(XworkConstant.ACTION_MESSAGE_HOLDER);
        if (!clazz[0].isAssignableFrom(Void.class) && holder.request != null) {
            this.request = holder.request.unpack((Class<Q>) clazz[0]);
        }
        S responseObj = this.internalExec();
        if (!clazz[1].isAssignableFrom(Void.class) && responseObj != null) {
            holder.response = Any.pack(responseObj);
        }
        return Action.NONE;
    }

    /**
     * 业务方法，需子类重写
     *
     * @throws Exception
     */
    protected abstract S internalExec() throws CloudException;

    @Override
    public void addParam(String name, String value) {
        this.staticParameters.put(name, value);
    }

    @Override
    public Map<String, String> getParams() {
        return this.staticParameters;
    }

    @Override
    public void setParams(Map<String, String> params) {
        this.staticParameters = params;
    }
}
