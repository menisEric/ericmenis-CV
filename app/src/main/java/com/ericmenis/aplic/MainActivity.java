package com.ericmenis.aplic;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity{

    //FloatingActionsButton
    @BindView(R.id.groupFAB)
    FloatingActionsMenu groupButton;
    @BindView(R.id.FABfacebook)
    FloatingActionButton fabFacebook;
    @BindView(R.id.FABgmail)
    FloatingActionButton fabGmail;
    @BindView(R.id.FABgithub)
    FloatingActionButton fabGithub;
    @BindView(R.id.FABlinkdin)
    FloatingActionButton fabLinkdin;

    //ImageButton
    @BindView(R.id.buttonBritish)
    ImageButton imageBritish;
    @BindView(R.id.buttonSpain)
    ImageButton imageSpain;

    @OnClick(R.id.buttonBritish)
    void ClickedEN(){
        buttonBritish();
    }
    @OnClick(R.id.buttonSpain)
    void ClickedES(){
        buttonSpain();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Libreria ButterKnife
        ButterKnife.bind(this);

        //redes sociales
        fabFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FacebookIntent();
            }
        });
        fabLinkdin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinkdinIntent();
            }
        });
        fabGithub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GithubIntent();
            }
        });
        fabGmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GmailIntent();
            }
        });

    }
    
    //Cuadro de Dialogo
    private void buttonBritish() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Idioma");
        builder.setMessage("Escrito: medio\n"+"Oral: medio");
        builder.setNeutralButton("Close", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    //Cuadro de Dialogo
    private void buttonSpain() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Idioma");
        builder.setMessage("Excelente");
        builder.setNeutralButton("Close", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    
    //Intent Redes Sociales

    //Facebook
    public void FacebookIntent(){
        String url = "https://www.facebook.com/eric.menis.3/";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
    //Linkdin
    public void LinkdinIntent(){
        String url = "https://www.linkedin.com/in/eric-menis-990837162/";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
    //Github
    public void GithubIntent(){
        String url = "https://github.com/menisEric";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
    //Gmail
    public void GmailIntent(){
        String mailList = "ericmenistr@gmail.com";
        String[] mail = mailList.split(",");

        Intent i = new Intent(Intent.ACTION_SEND);
        i.putExtra(Intent.EXTRA_EMAIL, mail);
        i.setType("message/rfc822");
        startActivity(Intent.createChooser(i, "Choose an email"));
    }
}
