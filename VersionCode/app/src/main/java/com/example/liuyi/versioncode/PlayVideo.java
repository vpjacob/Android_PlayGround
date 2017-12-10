package com.example.liuyi.versioncode;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;

public class PlayVideo extends AppCompatActivity {
    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);

        setContentView(R.layout.activity_play_video);
        videoView = (VideoView) findViewById(R.id.video_view);
        Button play = (Button) findViewById(R.id.play);
        Button pause = (Button) findViewById(R.id.play);
        Button replay = (Button) findViewById(R.id.play);

//        play.setOnClickListener(this);
//        pause.setOnClickListener(this);
//        replay.setOnClickListener(this);



        if (ContextCompat.checkSelfPermission(PlayVideo.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(PlayVideo.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        }else {
            initVideoPath();
        }


    }

    private  void initVideoPath(){
        File file = new File(Environment.getExternalStorageDirectory(),"moview.mov");
        videoView.setVideoPath(file.getPath());
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    switch (requestCode){
        case 1:
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                initVideoPath();
            }else {
                Toast.makeText(this,"拒绝授权将无法使用程序",Toast.LENGTH_SHORT).show();
                finish();
            }
            break;
        default:
    }

    }

public void onClick(View v){
    switch (v.getId()){
        case R.id.play:
            if (!videoView.isPlaying()){
                videoView.start();
            }
            break;
        case R.id.pause:
            if (videoView.isPlaying()){
                videoView.pause();
            }
            break;
        case R.id.replay:
            if (videoView.isPlaying()){
                videoView.resume();
            }
            break;
    }
}

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (videoView != null){
            videoView.suspend();
        }
    }
}
