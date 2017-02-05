package com.example.priyamkumar.fireapp;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class PlayVideo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);
        VideoView vv= (VideoView) findViewById(R.id.videoView);
        VideoView videoView =(VideoView)findViewById(R.id.videoView);
        MediaController mediaController= new MediaController(this);
        mediaController.setAnchorView(videoView);
      //Uri uri=Uri.parse("rtsp://r6---sn-a5mlrn7r.googlevideo.com/Cj0LENy73wIaNAkbctx3lgOGvhMYDSANFC2HiZVYMOCoAUIASARg_uz2t9SM5eZXigELLTBINTlncUNHM1kM/BBF0B9BCA4968DC2DF96021C216290A9788FC9C7.D0DAF7AA6A9A9D1FF2C63AEEF4A4A8347FFC9716/yt6/1/video.3gprtsp://r6---sn-a5mlrn7r.googlevideo.com/Cj0LENy73wIaNAkbctx3lgOGvhMYDSANFC2HiZVYMOCoAUIASARg_uz2t9SM5eZXigELLTBINTlncUNHM1kM/BBF0B9BCA4968DC2DF96021C216290A9788FC9C7.D0DAF7AA6A9A9D1FF2C63AEEF4A4A8347FFC9716/yt6/1/video.3gp");
            Uri uri=Uri.parse("rtsp://r5---sn-a5meknek.googlevideo.com/Cj0LENy73wIaNAmOE_-_fd_kuxMYDSANFC2W0ZZYMOCoAUIASARg3fbduZLw7dhWigELeUVCQ0VDaVB3RjQM/8B4C9824195793BC1F2A925454C3FC090516051C.A2820C25BF3B43809130BCA22010C1A6B1911452/yt6/1/video.3gp");
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();


    }
}
