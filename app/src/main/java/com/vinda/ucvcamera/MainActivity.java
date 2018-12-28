package com.vinda.ucvcamera;

import android.graphics.SurfaceTexture;
import android.hardware.usb.UsbDevice;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Surface;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.serenegiant.common.BaseActivity;
import com.serenegiant.usb.CameraDialog;
import com.serenegiant.usb.USBMonitor;
import com.serenegiant.usb.USBMonitor.OnDeviceConnectListener;
import com.serenegiant.usb.USBMonitor.UsbControlBlock;
import com.serenegiant.usb.UVCCamera;
import com.serenegiant.usbcameracommon.UVCCameraHandler;
import com.serenegiant.usbcameracommon.UvcCameraDataCallBack;
import com.serenegiant.widget.CameraViewInterface;
import com.serenegiant.widget.UVCCameraTextureView;
import com.yuan.camera.R;

/**
 * 显示多路摄像头
 */
public class MainActivity extends BaseActivity implements CameraDialog.CameraDialogParent {
    private static final boolean DEBUG = true;
    private static final String TAG = "MainActivity";

    private static final float[] BANDWIDTH_FACTORS = {0.5f, 0.5f};

    // for accessing USB and USB camera
    private USBMonitor mUSBMonitor;

    private UVCCameraHandler mHandlerFirst;
    private CameraViewInterface mUVCCameraViewFirst;
    private ImageButton mCaptureButtonFirst;
    private Surface mFirstPreviewSurface;

    private UVCCameraHandler mHandlerSecond;
    private CameraViewInterface mUVCCameraViewSecond;
    private ImageButton mCaptureButtonSecond;
    private Surface mSecondPreviewSurface;

    private UVCCameraHandler mHandlerThird;
    private CameraViewInterface mUVCCameraViewThird;
    private ImageButton mCaptureButtonThird;
    private Surface mThirdPreviewSurface;

    private UVCCameraHandler mHandlerFourth;
    private CameraViewInterface mUVCCameraViewFourth;
    private ImageButton mCaptureButtonFourth;
    private Surface mFourthPreviewSurface;

    private UVCCameraHandler mHandlerFifth;
    private CameraViewInterface mUVCCameraViewFifth;
    private ImageButton mCaptureButtonFifth;
    private Surface mFifthPreviewSurface;


    private UVCCameraHandler mHandlerSixth;
    private CameraViewInterface mUVCCameraViewSixth;
    private ImageButton mCaptureButtonSixth;
    private Surface mSixthPreviewSurface;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surface_view_camera);
        findViewById(R.id.RelativeLayout1).setOnClickListener(mOnClickListener);
        mUSBMonitor = new USBMonitor(this, mOnDeviceConnectListener);
        resultFirstCamera();
        resultSecondCamera();
        resultThirdCamera();
        resultFourthCamera();
        resultFifThCamrea();
        resultSixthCamera();
    }

    /**
     * 带有回调数据的初始化
     */
    private void resultFirstCamera() {
        mUVCCameraViewFirst = (CameraViewInterface) findViewById(R.id.camera_view_first);
        //设置显示宽高
        mUVCCameraViewFirst.setAspectRatio(UVCCamera.DEFAULT_PREVIEW_WIDTH / (float) UVCCamera.DEFAULT_PREVIEW_HEIGHT);
        ((UVCCameraTextureView) mUVCCameraViewFirst).setOnClickListener(mOnClickListener);
        mCaptureButtonFirst = (ImageButton) findViewById(R.id.capture_button_first);
        mCaptureButtonFirst.setOnClickListener(mOnClickListener);
        mCaptureButtonFirst.setVisibility(View.INVISIBLE);
        mHandlerFirst = UVCCameraHandler.createHandler(this, mUVCCameraViewFirst
                , UVCCamera.DEFAULT_PREVIEW_WIDTH, UVCCamera.DEFAULT_PREVIEW_HEIGHT
                , BANDWIDTH_FACTORS[0], firstDataCallBack);
    }

    UvcCameraDataCallBack firstDataCallBack = new UvcCameraDataCallBack() {
        @Override
        public void getData(byte[] data) {
            if (DEBUG) Log.v(TAG, "数据回调:" + data.length);
        }
    };

    private void resultSecondCamera() {
        mUVCCameraViewSecond = (CameraViewInterface) findViewById(R.id.camera_view_second);
        mUVCCameraViewSecond.setAspectRatio(UVCCamera.DEFAULT_PREVIEW_WIDTH / (float) UVCCamera.DEFAULT_PREVIEW_HEIGHT);
        ((UVCCameraTextureView) mUVCCameraViewSecond).setOnClickListener(mOnClickListener);
        mCaptureButtonSecond = (ImageButton) findViewById(R.id.capture_button_second);
        mCaptureButtonSecond.setOnClickListener(mOnClickListener);
        mCaptureButtonSecond.setVisibility(View.INVISIBLE);
        mHandlerSecond = UVCCameraHandler.createHandler(this, mUVCCameraViewSecond, UVCCamera.DEFAULT_PREVIEW_WIDTH, UVCCamera.DEFAULT_PREVIEW_HEIGHT, BANDWIDTH_FACTORS[1]);
    }

    private void resultThirdCamera() {
        mUVCCameraViewThird = (CameraViewInterface) findViewById(R.id.camera_view_third);
        mUVCCameraViewThird.setAspectRatio(UVCCamera.DEFAULT_PREVIEW_WIDTH / (float) UVCCamera.DEFAULT_PREVIEW_HEIGHT);
        ((UVCCameraTextureView) mUVCCameraViewThird).setOnClickListener(mOnClickListener);
        mCaptureButtonThird = (ImageButton) findViewById(R.id.capture_button_third);
        mCaptureButtonThird.setOnClickListener(mOnClickListener);
        mCaptureButtonThird.setVisibility(View.INVISIBLE);
        mHandlerThird = UVCCameraHandler.createHandler(this, mUVCCameraViewThird, UVCCamera.DEFAULT_PREVIEW_WIDTH, UVCCamera.DEFAULT_PREVIEW_HEIGHT, BANDWIDTH_FACTORS[1]);
    }

    private void resultFourthCamera() {
        mUVCCameraViewFourth = (CameraViewInterface) findViewById(R.id.camera_view_fourth);
        mUVCCameraViewFourth.setAspectRatio(UVCCamera.DEFAULT_PREVIEW_WIDTH / (float) UVCCamera.DEFAULT_PREVIEW_HEIGHT);
        ((UVCCameraTextureView) mUVCCameraViewFourth).setOnClickListener(mOnClickListener);
        mCaptureButtonFourth = (ImageButton) findViewById(R.id.capture_button_fourth);
        mCaptureButtonFourth.setOnClickListener(mOnClickListener);
        mCaptureButtonFourth.setVisibility(View.INVISIBLE);
        mHandlerFourth = UVCCameraHandler.createHandler(this, mUVCCameraViewFourth, UVCCamera.DEFAULT_PREVIEW_WIDTH, UVCCamera.DEFAULT_PREVIEW_HEIGHT, BANDWIDTH_FACTORS[1]);
    }

    private void resultFifThCamrea() {
        mUVCCameraViewFifth = (CameraViewInterface) findViewById(R.id.camera_view_fifth);
        mUVCCameraViewFifth.setAspectRatio(UVCCamera.DEFAULT_PREVIEW_WIDTH / (float) UVCCamera.DEFAULT_PREVIEW_HEIGHT);
        ((UVCCameraTextureView) mUVCCameraViewFifth).setOnClickListener(mOnClickListener);
        mCaptureButtonFifth = (ImageButton) findViewById(R.id.capture_button_fifth);
        mCaptureButtonFifth.setOnClickListener(mOnClickListener);
        mCaptureButtonFifth.setVisibility(View.INVISIBLE);
        mHandlerFifth = UVCCameraHandler.createHandler(this, mUVCCameraViewFifth, UVCCamera.DEFAULT_PREVIEW_WIDTH, UVCCamera.DEFAULT_PREVIEW_HEIGHT, BANDWIDTH_FACTORS[1]);
    }

    private void resultSixthCamera() {
        mUVCCameraViewSixth = (CameraViewInterface) findViewById(R.id.camera_view_sixth);
        mUVCCameraViewSixth.setAspectRatio(UVCCamera.DEFAULT_PREVIEW_WIDTH / (float) UVCCamera.DEFAULT_PREVIEW_HEIGHT);
        ((UVCCameraTextureView) mUVCCameraViewSixth).setOnClickListener(mOnClickListener);
        mCaptureButtonSixth = (ImageButton) findViewById(R.id.capture_button_sixth);
        mCaptureButtonSixth.setOnClickListener(mOnClickListener);
        mCaptureButtonSixth.setVisibility(View.INVISIBLE);
        mHandlerSixth = UVCCameraHandler.createHandler(this, mUVCCameraViewSixth, UVCCamera.DEFAULT_PREVIEW_WIDTH, UVCCamera.DEFAULT_PREVIEW_HEIGHT, BANDWIDTH_FACTORS[1]);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mUSBMonitor.register();
        if (mUVCCameraViewSecond != null)
            mUVCCameraViewSecond.onResume();
        if (mUVCCameraViewFirst != null)
            mUVCCameraViewFirst.onResume();
        if (mUVCCameraViewThird != null)
            mUVCCameraViewThird.onResume();
        if (mUVCCameraViewFourth != null)
            mUVCCameraViewFourth.onResume();
        if (mUVCCameraViewFifth != null)
            mUVCCameraViewFifth.onResume();
        if (mUVCCameraViewSixth != null)
            mUVCCameraViewSixth.onResume();
    }

    @Override
    protected void onStop() {
        mHandlerFirst.close();
        if (mUVCCameraViewFirst != null)
            mUVCCameraViewFirst.onPause();
        mCaptureButtonFirst.setVisibility(View.INVISIBLE);

        mHandlerSecond.close();
        if (mUVCCameraViewSecond != null)
            mUVCCameraViewSecond.onPause();
        mCaptureButtonSecond.setVisibility(View.INVISIBLE);

        mHandlerThird.close();
        if (mUVCCameraViewThird != null)
            mUVCCameraViewThird.onPause();
        mCaptureButtonThird.setVisibility(View.INVISIBLE);

        mHandlerFourth.close();
        if (mUVCCameraViewFourth != null)
            mUVCCameraViewFourth.onPause();
        mCaptureButtonFourth.setVisibility(View.INVISIBLE);

        mHandlerFifth.close();
        if (mUVCCameraViewFifth != null)
            mUVCCameraViewFifth.onPause();
        mCaptureButtonFifth.setVisibility(View.INVISIBLE);

        mHandlerSixth.close();
        if (mUVCCameraViewSixth != null)
            mUVCCameraViewSixth.onPause();
        mCaptureButtonSixth.setVisibility(View.INVISIBLE);

        mUSBMonitor.unregister();//usb管理器解绑
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        if (mHandlerFirst != null) {
            mHandlerFirst = null;
        }

        if (mHandlerSecond != null) {
            mHandlerSecond = null;
        }

        if (mHandlerThird != null) {
            mHandlerThird = null;
        }

        if (mHandlerFourth != null) {
            mHandlerFourth = null;
        }

        if (mHandlerFifth != null) {
            mHandlerFifth = null;
        }

        if (mHandlerSixth != null) {
            mHandlerSixth = null;
        }

        if (mUSBMonitor != null) {
            mUSBMonitor.destroy();
            mUSBMonitor = null;
        }

        mUVCCameraViewFirst = null;
        mCaptureButtonFirst = null;

        mUVCCameraViewSecond = null;
        mCaptureButtonSecond = null;

        mUVCCameraViewThird = null;
        mCaptureButtonThird = null;

        mUVCCameraViewFourth = null;
        mCaptureButtonFourth = null;

        mUVCCameraViewFifth = null;
        mCaptureButtonFifth = null;

        mUVCCameraViewSixth = null;
        mCaptureButtonSixth = null;
        super.onDestroy();
    }

    private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(final View view) {
            switch (view.getId()) {
                case R.id.camera_view_first:
                    if (mHandlerFirst != null) {
                        if (!mHandlerFirst.isOpened()) {
                            CameraDialog.showDialog(MainActivity.this);
                        } else {
                            mHandlerFirst.close();
                            setCameraButton();
                        }
                    }
                    break;
                case R.id.capture_button_first:
                    if (mHandlerFirst != null) {
                        if (mHandlerFirst.isOpened()) {
                            if (checkPermissionWriteExternalStorage() && checkPermissionAudio()) {
                                if (!mHandlerFirst.isRecording()) {
                                    mCaptureButtonFirst.setColorFilter(0xffff0000);    // turn red
                                    mHandlerFirst.startRecording();
                                } else {
                                    mCaptureButtonFirst.setColorFilter(0);    // return to default color
                                    mHandlerFirst.stopRecording();
                                }
                            }
                        }
                    }
                    break;
                case R.id.camera_view_second:
                    if (mHandlerSecond != null) {
                        if (!mHandlerSecond.isOpened()) {
                            CameraDialog.showDialog(MainActivity.this);
                        } else {
                            mHandlerSecond.close();
                            setCameraButton();
                        }
                    }
                    break;
                case R.id.capture_button_second:
                    if (mHandlerSecond != null) {
                        if (mHandlerSecond.isOpened()) {
                            if (checkPermissionWriteExternalStorage() && checkPermissionAudio()) {
                                if (!mHandlerSecond.isRecording()) {
                                    mCaptureButtonSecond.setColorFilter(0xffff0000);    // turn red
                                    mHandlerSecond.startRecording();
                                } else {
                                    mCaptureButtonSecond.setColorFilter(0);    // return to default color
                                    mHandlerSecond.stopRecording();
                                }
                            }
                        }
                    }
                    break;
                case R.id.camera_view_third:
                    if (mHandlerThird != null) {
                        if (!mHandlerThird.isOpened()) {
                            CameraDialog.showDialog(MainActivity.this);
                        } else {
                            mHandlerThird.close();
                            setCameraButton();
                        }
                    }
                    break;
                case R.id.capture_button_third:
                    if (mHandlerThird != null) {
                        if (mHandlerThird.isOpened()) {
                            if (checkPermissionWriteExternalStorage() && checkPermissionAudio()) {
                                if (!mHandlerThird.isRecording()) {
                                    mCaptureButtonThird.setColorFilter(0xffff0000);    // turn red
                                    mHandlerThird.startRecording();
                                } else {
                                    mCaptureButtonThird.setColorFilter(0);    // return to default color
                                    mHandlerThird.stopRecording();
                                }
                            }
                        }
                    }
                    break;
                case R.id.camera_view_fourth:
                    if (mHandlerFourth != null) {
                        if (!mHandlerFourth.isOpened()) {
                            CameraDialog.showDialog(MainActivity.this);
                        } else {
                            mHandlerFourth.close();
                            setCameraButton();
                        }
                    }
                    break;
                case R.id.capture_button_fourth:
                    if (mHandlerFourth != null) {
                        if (mHandlerFourth.isOpened()) {
                            if (checkPermissionWriteExternalStorage() && checkPermissionAudio()) {
                                if (!mHandlerFourth.isRecording()) {
                                    mCaptureButtonFourth.setColorFilter(0xffff0000);    // turn red
                                    mHandlerFourth.startRecording();
                                } else {
                                    mCaptureButtonFourth.setColorFilter(0);    // return to default color
                                    mHandlerFourth.stopRecording();
                                }
                            }
                        }
                    }
                    break;

                case R.id.camera_view_fifth:
                    if (mHandlerFifth != null) {
                        if (!mHandlerFifth.isOpened()) {
                            CameraDialog.showDialog(MainActivity.this);
                        } else {
                            mHandlerFifth.close();
                            setCameraButton();
                        }
                    }
                    break;
                case R.id.capture_button_fifth:
                    if (mHandlerFifth != null) {
                        if (mHandlerFifth.isOpened()) {
                            if (checkPermissionWriteExternalStorage() && checkPermissionAudio()) {
                                if (!mHandlerFifth.isRecording()) {
                                    mCaptureButtonFifth.setColorFilter(0xffff0000);    // turn red
                                    mHandlerFifth.startRecording();
                                } else {
                                    mCaptureButtonFifth.setColorFilter(0);    // return to default color
                                    mHandlerFifth.stopRecording();
                                }
                            }
                        }
                    }
                    break;

                case R.id.camera_view_sixth:
                    if (mHandlerSixth != null) {
                        if (!mHandlerSixth.isOpened()) {
                            CameraDialog.showDialog(MainActivity.this);
                        } else {
                            mHandlerSixth.close();
                            setCameraButton();
                        }
                    }
                    break;
                case R.id.capture_button_sixth:
                    if (mHandlerSixth != null) {
                        if (mHandlerSixth.isOpened()) {
                            if (checkPermissionWriteExternalStorage() && checkPermissionAudio()) {
                                if (!mHandlerSixth.isRecording()) {
                                    mCaptureButtonSixth.setColorFilter(0xffff0000);    // turn red
                                    mHandlerSixth.startRecording();
                                } else {
                                    mCaptureButtonSixth.setColorFilter(0);    // return to default color
                                    mHandlerSixth.stopRecording();
                                }
                            }
                        }
                    }
                    break;
            }
        }
    };

    private final OnDeviceConnectListener mOnDeviceConnectListener = new OnDeviceConnectListener() {
        @Override
        public void onAttach(final UsbDevice device) {
            if (DEBUG) Log.v(TAG, "onAttach:" + device);
            Toast.makeText(MainActivity.this, "USB_DEVICE_ATTACHED", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onConnect(final UsbDevice device, final UsbControlBlock ctrlBlock, final boolean createNew) {
            //设备连接成功
            if (DEBUG) Log.v(TAG, "onConnect:" + device);
            if (!mHandlerFirst.isOpened()) {
                mHandlerFirst.open(ctrlBlock);
                final SurfaceTexture st = mUVCCameraViewFirst.getSurfaceTexture();
                mHandlerFirst.startPreview(new Surface(st));

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mCaptureButtonFirst.setVisibility(View.VISIBLE);
                    }
                });
            } else if (!mHandlerSecond.isOpened()) {
                mHandlerSecond.open(ctrlBlock);
                final SurfaceTexture st = mUVCCameraViewSecond.getSurfaceTexture();
                mHandlerSecond.startPreview(new Surface(st));
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mCaptureButtonSecond.setVisibility(View.VISIBLE);
                    }
                });
            } else if (!mHandlerThird.isOpened()) {
                mHandlerThird.open(ctrlBlock);
                final SurfaceTexture st = mUVCCameraViewThird.getSurfaceTexture();
                mHandlerThird.startPreview(new Surface(st));
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mCaptureButtonThird.setVisibility(View.VISIBLE);
                    }
                });
            } else if (!mHandlerFourth.isOpened()) {
                mHandlerFourth.open(ctrlBlock);
                final SurfaceTexture st = mUVCCameraViewFourth.getSurfaceTexture();
                mHandlerFourth.startPreview(new Surface(st));
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mCaptureButtonFourth.setVisibility(View.VISIBLE);
                    }
                });
            } else if (!mHandlerFifth.isOpened()) {
                mHandlerFifth.open(ctrlBlock);
                final SurfaceTexture st = mUVCCameraViewFifth.getSurfaceTexture();
                mHandlerFifth.startPreview(new Surface(st));
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mCaptureButtonFifth.setVisibility(View.VISIBLE);
                    }
                });
            } else if (!mHandlerSixth.isOpened()) {
                mHandlerSixth.open(ctrlBlock);
                final SurfaceTexture st = mUVCCameraViewSixth.getSurfaceTexture();
                mHandlerSixth.startPreview(new Surface(st));
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mCaptureButtonSixth.setVisibility(View.VISIBLE);
                    }
                });
            }
        }

        @Override
        public void onDisconnect(final UsbDevice device, final UsbControlBlock ctrlBlock) {
            if (DEBUG) Log.v(TAG, "onDisconnect:" + device);
            if ((mHandlerFirst != null) && !mHandlerFirst.isEqual(device)) {
                queueEvent(new Runnable() {
                    @Override
                    public void run() {
                        mHandlerFirst.close();
                        if (mFirstPreviewSurface != null) {
                            mFirstPreviewSurface.release();
                            mFirstPreviewSurface = null;
                        }
                        setCameraButton();
                    }
                }, 0);
            } else if ((mHandlerSecond != null) && !mHandlerSecond.isEqual(device)) {
                queueEvent(new Runnable() {
                    @Override
                    public void run() {
                        mHandlerSecond.close();
                        if (mSecondPreviewSurface != null) {
                            mSecondPreviewSurface.release();
                            mSecondPreviewSurface = null;
                        }
                        setCameraButton();
                    }
                }, 0);
            } else if ((mHandlerThird != null) && !mHandlerThird.isEqual(device)) {
                queueEvent(new Runnable() {
                    @Override
                    public void run() {
                        mHandlerThird.close();
                        if (mThirdPreviewSurface != null) {
                            mThirdPreviewSurface.release();
                            mThirdPreviewSurface = null;
                        }
                        setCameraButton();
                    }
                }, 0);
            } else if ((mHandlerFourth != null) && !mHandlerFourth.isEqual(device)) {
                queueEvent(new Runnable() {
                    @Override
                    public void run() {
                        mHandlerFourth.close();
                        if (mFourthPreviewSurface != null) {
                            mFourthPreviewSurface.release();
                            mFourthPreviewSurface = null;
                        }
                        setCameraButton();
                    }
                }, 0);
            } else if ((mHandlerFifth != null) && !mHandlerFifth.isEqual(device)) {
                queueEvent(new Runnable() {
                    @Override
                    public void run() {
                        mHandlerFifth.close();
                        if (mFifthPreviewSurface != null) {
                            mFifthPreviewSurface.release();
                            mFifthPreviewSurface = null;
                        }
                        setCameraButton();
                    }
                }, 0);
            } else if ((mHandlerSixth != null) && !mHandlerSixth.isEqual(device)) {
                queueEvent(new Runnable() {
                    @Override
                    public void run() {
                        mHandlerSixth.close();
                        if (mSixthPreviewSurface != null) {
                            mSixthPreviewSurface.release();
                            mSixthPreviewSurface = null;
                        }
                        setCameraButton();
                    }
                }, 0);
            }
        }

        @Override
        public void onDettach(final UsbDevice device) {
            if (DEBUG) Log.v(TAG, "onDettach:" + device);
            Toast.makeText(MainActivity.this, "USB_DEVICE_DETACHED", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(final UsbDevice device) {
            if (DEBUG) Log.v(TAG, "onCancel:");
        }
    };

    /**
     * to access from CameraDialog
     *
     * @return
     */
    @Override
    public USBMonitor getUSBMonitor() {
        return mUSBMonitor;
    }

    @Override
    public void onDialogResult(boolean canceled) {
        if (canceled) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    setCameraButton();
                }
            }, 0);
        }
    }

    private void setCameraButton() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if ((mHandlerFirst != null) && !mHandlerFirst.isOpened() && (mCaptureButtonFirst != null)) {
                    mCaptureButtonFirst.setVisibility(View.INVISIBLE);
                }
                if ((mHandlerSecond != null) && !mHandlerSecond.isOpened() && (mCaptureButtonSecond != null)) {
                    mCaptureButtonSecond.setVisibility(View.INVISIBLE);
                }
                if ((mHandlerThird != null) && !mHandlerThird.isOpened() && (mCaptureButtonThird != null)) {
                    mCaptureButtonThird.setVisibility(View.INVISIBLE);
                }
                if ((mHandlerFourth != null) && !mHandlerFourth.isOpened() && (mCaptureButtonFourth != null)) {
                    mCaptureButtonFourth.setVisibility(View.INVISIBLE);
                }
                if ((mHandlerFifth != null) && !mHandlerFifth.isOpened() && (mCaptureButtonFifth != null)) {
                    mCaptureButtonFifth.setVisibility(View.INVISIBLE);
                }
                if ((mHandlerSixth != null) && !mHandlerSixth.isOpened() && (mCaptureButtonSixth != null)) {
                    mCaptureButtonSixth.setVisibility(View.INVISIBLE);
                }
            }
        }, 0);
    }
}
