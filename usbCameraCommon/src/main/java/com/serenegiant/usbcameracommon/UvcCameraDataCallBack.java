package com.serenegiant.usbcameracommon;


public interface UvcCameraDataCallBack {

    /**
     * @param data        摄像头回调原始数据
     */
    void getData(byte[] data);
}
