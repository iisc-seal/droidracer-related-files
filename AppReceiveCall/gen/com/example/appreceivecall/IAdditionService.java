/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /home/pallavi/eclipse_workspace/AppReceiveCall/src/com/example/appreceivecall/IAdditionService.aidl
 */
package com.example.appreceivecall;
public interface IAdditionService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.example.appreceivecall.IAdditionService
{
private static final java.lang.String DESCRIPTOR = "com.example.appreceivecall.IAdditionService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.example.appreceivecall.IAdditionService interface,
 * generating a proxy if needed.
 */
public static com.example.appreceivecall.IAdditionService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.example.appreceivecall.IAdditionService))) {
return ((com.example.appreceivecall.IAdditionService)iin);
}
return new com.example.appreceivecall.IAdditionService.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_add:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
int _result = this.add(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.example.appreceivecall.IAdditionService
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
// You can pass values in, out, or inout. 
// Primitive datatypes (such as int, boolean, etc.) can only be passed in.

@Override public int add(int value1, int value2) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(value1);
_data.writeInt(value2);
mRemote.transact(Stub.TRANSACTION_add, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_add = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
// You can pass values in, out, or inout. 
// Primitive datatypes (such as int, boolean, etc.) can only be passed in.

public int add(int value1, int value2) throws android.os.RemoteException;
}
