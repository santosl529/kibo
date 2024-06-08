package jp.jaxa.iss.kibo.rpc.defaultapk;

import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.provider.MediaStore;

import org.opencv.core.Mat;
import org.tensorflow.lite.support.image.TensorImage;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;
import org.tensorflow.lite.task.core.BaseOptions;
import org.tensorflow.lite.task.vision.classifier.Classifications;
import org.tensorflow.lite.task.vision.classifier.ImageClassifier;
import org.tensorflow.lite.task.vision.detector.*;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import gov.nasa.arc.astrobee.types.Point;
import gov.nasa.arc.astrobee.types.Quaternion;
import jp.jaxa.iss.kibo.rpc.api.KiboRpcService;



/**
 * Class meant to handle commands from the Ground Data System and execute them in Astrobee
 */

public class YourService extends KiboRpcService {
    @Override
    protected void runPlan1(){
        api.startMission();
        int imagesize = 224;

        //object detection code
        // Initialization
//        ObjectDetector.ObjectDetectorOptions options =
//                ObjectDetector.ObjectDetectorOptions.builder()
//                        .setBaseOptions(BaseOptions.builder().useGpu().build())
//                        .setMaxResults(1)
//                        .build();
//        ObjectDetector objectDetector =
//                ObjectDetector.createFromFileAndOptions(
//                        getApplicationContext(), modelFile, options);
//        Bitmap image = api.getBitmapDockCam();
//// Run inference
//        List<Detection> results = objectDetector.detect(TensorImage.fromBitmap(image));






        //move to area1
        Point point = new Point(10.95d, -10.00d, 5.195d);
        Quaternion quaternion = new Quaternion(0f, 0f, -0.707f, 0.707f);
        api.moveTo(point, quaternion, true);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        api.saveBitmapImage(api.getBitmapNavCam(), "Area1");

        //move through koz1
        point = new Point(10.56d, -9.0d, 4.5d);
        quaternion = new Quaternion(0f, 0f, 1f, 0f);
        api.moveTo(point, quaternion, true);

        point = new Point(10.56d, -8.875d, 4.5d);
        quaternion = new Quaternion(0f, 0f, 1f, 0f);
        api.moveTo(point, quaternion, true);

        //position in front of area2
        point = new Point(10.925d, -8.875d, 4.4d);
        quaternion = new Quaternion(0f, 0.707f, 0f, 0.707f);
        api.moveTo(point, quaternion, true);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        api.saveBitmapImage(api.getBitmapNavCam(), "Area2");

        //Move to Area3
        point = new Point(11.235d, -8.875d, 4.62d);
        quaternion = new Quaternion(0f, 0f, 0f, 1f);
        api.moveTo(point, quaternion, true);

        point = new Point(11.235d, -7.925d, 4.62d);
        quaternion = new Quaternion(0f, 0f, 1f, 0f);
        api.moveTo(point, quaternion, true);

        point = new Point(10.925d, -7.7d, 4.4d);
        quaternion = new Quaternion(0f, 0.707f, 0f, 0.707f);
        api.moveTo(point, quaternion, true);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        api.saveBitmapImage(api.getBitmapNavCam(), "Area3");

        point = new Point(10.56d, -7.925d, 4.62d);
        quaternion = new Quaternion(0f, 0f, 0f, 0f);
        api.moveTo(point, quaternion, true);

        point = new Point(10.56d, -6.8525d, 4.62d);
        quaternion = new Quaternion(0f, 0f, 0f, 0f);
        api.moveTo(point, quaternion, true);

        point = new Point(10.866984d, -6.8525d, 4.945d);
        quaternion = new Quaternion(0f, 0f, 0f, 0f);
        api.moveTo(point, quaternion, true);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        api.saveBitmapImage(api.getBitmapDockCam(), "Area4");

        point = new Point(11.143d, -6.7607d, 4.9654d);
        quaternion = new Quaternion(0f, 0f, 0.707f, 0.707f);
        api.moveTo(point, quaternion, true);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        api.saveBitmapImage(api.getBitmapNavCam(), "Astronaut");



        // write your plan 1 here
    }

    @Override
    protected void runPlan2(){
        // write your plan 2 here
    }

    @Override
    protected void runPlan3(){
        // write your plan 3 here
    }

}
