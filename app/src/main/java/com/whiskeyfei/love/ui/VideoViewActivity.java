package com.whiskeyfei.love.ui;

import android.media.MediaPlayer;
import android.media.session.MediaController;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

import com.whiskeyfei.love.R;
import com.whiskeyfei.love.widget.TopBar;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by whiskeyfei on 16/5/7.
 */
public class VideoViewActivity extends BaseActivity implements TopBar.topbarClickListener {
    private static final String url1 = "http://2449.vod.myqcloud.com/2449_bfbbfa3cea8f11e5aac3db03cda99974.f20.mp4";
    private static final String url2 = "http://media2.neu6.edu.cn/hls/cctv5hd.m3u8";
    private JCVideoPlayerStandard mVideoView;
    private VideoView mVideo;
    private Button mButton;
    private MediaController mController;

    @Override
    public void onCreate() {
        setContentView(R.layout.video);

    }

    @Override
    public void initView() {
        final Uri uri =  Uri.parse("http://media2.neu6.edu.cn/hls/cctv5hd.m3u8");
        final Uri uri2 =  Uri.parse("http://video.jiecao.fm/5/1/%E8%87%AA%E5%8F%96%E5%85%B6%E8%BE%B1.mp4");
//        mVideoView = (JCVideoPlayerStandard) findViewById(R.id.video1);
//        mVideoView.setUp(url2,"");
        mButton = (Button) findViewById(R.id.button);
        mVideo = (VideoView) findViewById(R.id.video);
        mVideo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
//                if (!mp.isPlaying())
//                    mp.reset();
                mp.start();
            }
        });
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mVideoView.setUp(url1,"");
//                JCFullScreenActivity.startActivity(VideoViewActivity.this,
//                        "http://video.jiecao.fm/5/1/%E8%87%AA%E5%8F%96%E5%85%B6%E8%BE%B1.mp4",
//                        JCVideoPlayerStandard.class,
//                        "嫂子别摸我");
                mVideo.setVideoURI(uri2);
                mVideo.start();
            }
        });
    }

    @Override
    public void leftClick() {
        Toast.makeText(VideoViewActivity.this,
                "left", Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    public void rightClick() {
        Toast.makeText(VideoViewActivity.this,
                "right", Toast.LENGTH_SHORT)
                .show();
    }
}
