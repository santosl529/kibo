package com.example.tensorflowtestjava;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Picture;
import android.os.Bundle;

import org.tensorflow.lite.support.image.MlImageAdapter;
import org.tensorflow.lite.support.image.TensorImage;
import org.tensorflow.lite.task.core.BaseOptions;
import org.tensorflow.lite.task.vision.classifier.Classifications;
import org.tensorflow.lite.task.vision.classifier.ImageClassifier;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public MainActivity() throws IOException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // Initialization
    ImageClassifier.ImageClassifierOptions options =
            ImageClassifier.ImageClassifierOptions.builder()
                    .setBaseOptions(BaseOptions.builder().useGpu().build())
                    .setMaxResults(1)
                    .build();
    ImageClassifier imageClassifier =
            ImageClassifier.createFromFileAndOptions(
                    getApplicationContext(), "com/example/tensorflowtestjava/saved_model.pb", options);

    Bitmap bitmap = Bitmap.createBitmap("com/example/tensorflowtestjava/Cute_dog.bmp");
    TensorImage image = TensorImage.fromBitmap("com/example/tensorflowtestjava/Cute_dog.bmp")
    // Run inference
    List<Classifications> results = imageClassifier.classify("com/example/tensorflowtestjava/Cute_dog.bmp");

}
