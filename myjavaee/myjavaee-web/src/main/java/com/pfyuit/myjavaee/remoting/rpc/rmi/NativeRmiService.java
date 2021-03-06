package com.pfyuit.myjavaee.remoting.rpc.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface of Native RMI remoting technology. Must extends Remote, the business method must throws java.rmi.RemoteException.
 * @author yupengfei
 */
public interface NativeRmiService extends Remote {

	public String sayHello(String name) throws RemoteException;

}
