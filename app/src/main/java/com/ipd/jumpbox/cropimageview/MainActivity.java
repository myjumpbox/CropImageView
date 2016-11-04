package com.ipd.jumpbox.cropimageview;

import android.graphics.Bitmap;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private CropImageView mCropImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCropImageView = (CropImageView) findViewById(R.id.crop_image_view);
        mCropImageView.getPhotoView().setImageResource(R.drawable.bg1);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.save_photo_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_save) {
            //保存
            Bitmap bitmap = mCropImageView.cropImage();
            if (bitmap != null) {
                BottomSheetDialog bottomImageDialog = new BottomSheetDialog(this);
                View contentView = LayoutInflater.from(this).inflate(R.layout.dialog_show_image, null);
                ImageView imageView = (ImageView) contentView.findViewById(R.id.iv_image);
                imageView.setImageBitmap(bitmap);
                bottomImageDialog.setContentView(contentView);
                bottomImageDialog.show();
            }

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
