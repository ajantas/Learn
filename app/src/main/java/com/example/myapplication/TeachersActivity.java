package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeIntents;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

public class TeachersActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener, OnItemClickListener {

    private String ID_VIDEO = "btwesxgc";
    private YouTubePlayerView youTube;
    private List<YouTubeItem> list;
    private String ID_CHANNEL = "thiengoCalopsita";
    private String ID_PLAYLIST = "UUG3gFuIkRF3PpNkRk3Wp6dw";
    private static final int PLAY_VIDEO = 1;
    private static final int OPEN_PLAYLIST = 2;
    private static final int PLAY_PLAYLIST = 3;
    private static final int OPEN_CHANNEL = 4;
    private static final int SEARCH_IN_CHANNEL = 5;
    private static final int UPLOAD_VIDEO = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachers);

        youTube = (YouTubePlayerView) findViewById(R.id.youtube);
        youTube.setVisibility(View.GONE);
        //youTube.initialize(Config.YOUTUBE_API_KEY,this);
        list = new ArrayList<YouTubeItem>();
        list.add(new YouTubeItem(PLAY_VIDEO,"play youtube video"));
        list.add(new YouTubeItem(OPEN_PLAYLIST,"open playlist youtube"));
        list.add(new YouTubeItem(PLAY_PLAYLIST,"play playlist youtube"));
        list.add(new YouTubeItem(OPEN_CHANNEL,"open channel video"));
        list.add(new YouTubeItem(SEARCH_IN_CHANNEL,"search in channel video"));
        list.add(new YouTubeItem(UPLOAD_VIDEO,"upload youtube video"));


        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new YouTubeAdapter(this,list));
        listView.setOnItemClickListener(this);


    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean loadAgain) {
        Log.i("Script","try 1");
        if(!loadAgain){
            Log.i("Script","try 2");
            youTubePlayer.cueVideo(ID_VIDEO);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, "onInitializationFailure()",Toast.LENGTH_SHORT).show();
    }

    public void callYoutube(View view){
        Uri uri = Uri.parse("http://www.youtube.com/watch?v=mMZOAbiNuZA");
        uri = Uri.parse("vnd.youtube:"+uri.getQueryParameter("v"));

        Intent it = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(it);
    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
        Intent it;

        switch(list.get(position).getIntentId()){
            case PLAY_VIDEO:
                if(YouTubeIntents.canResolvePlayVideoIntent(this)){
                    it = YouTubeIntents.createPlayVideoIntentWithOptions(this, ID_VIDEO, true, true);
                    startActivity(it);
                }
                break;
            case OPEN_PLAYLIST:
                if(YouTubeIntents.canResolveOpenPlaylistIntent(this)){
                    it = YouTubeIntents.createOpenPlaylistIntent(this, ID_PLAYLIST);
                    startActivity(it);
                }
                break;
            case PLAY_PLAYLIST:
                if(YouTubeIntents.canResolvePlayPlaylistIntent(this)){
                    it = YouTubeIntents.createPlayPlaylistIntent(this, ID_PLAYLIST);
                    startActivity(it);
                }
                break;
            case OPEN_CHANNEL:
                if(YouTubeIntents.canResolveUserIntent(this)){
                    it = YouTubeIntents.createUserIntent(this, ID_CHANNEL);
                    startActivity(it);
                }
                break;
            case SEARCH_IN_CHANNEL:
                if(YouTubeIntents.canResolveSearchIntent(this)){
                    it = YouTubeIntents.createSearchIntent(this, ID_CHANNEL);
                    startActivity(it);
                }
                break;
            case UPLOAD_VIDEO:
                if(YouTubeIntents.canResolveUploadIntent(this)){
                    it = new Intent(Intent.ACTION_PICK, null);
                    it.setType("video/*");
                    startActivityForResult(it, 1);
                }
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == 1 && resultCode == RESULT_OK){
            Intent it = YouTubeIntents.createUploadIntent(this, data.getData());
            startActivity(it);
        }
    }
}
