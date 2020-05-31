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

public class MainActivity extends AppCompatActivity{

    private FloatingActionsMenu groupButton;

    private FloatingActionButton fabFacebook, fabGmail, fabGithub, fabLinkdin;

    private ImageButton imageSpain, imageBritish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fabFacebook = (FloatingActionButton) findViewById(R.id.FABfacebook);
        fabGithub = (FloatingActionButton) findViewById(R.id.FABgithub);
        fabGmail = (FloatingActionButton) findViewById(R.id.FABgmail);
        fabLinkdin = (FloatingActionButton) findViewById(R.id.FABlinkdin);

        //Intent redes sociales
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

        //Cuadros de Dialogo
        imageBritish = (ImageButton) findViewById(R.id.buttonBritish);
        imageSpain = (ImageButton) findViewById(R.id.buttonSpain);

        imageSpain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonSpain();
            }
        });

        imageBritish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonBritish();
            }
        });
    }

    private void buttonBritish() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Idioma");
        builder.setMessage("Escrito: medio\n"+"Oral: medio");
        builder.setNeutralButton("Close", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void buttonSpain() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Idioma");
        builder.setMessage("Excelente");
        builder.setNeutralButton("Close", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void FacebookIntent(){
        String url = "https://www.facebook.com/eric.menis.3/";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    public void LinkdinIntent(){
        String url = "https://www.linkedin.com/in/eric-menis-990837162/";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    public void GithubIntent(){
        String url = "https://github.com/menisEric";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    public void GmailIntent(){
        String mailList = "ericmenistr@gmail.com";
        String[] mail = mailList.split(",");

        Intent i = new Intent(Intent.ACTION_SEND);
        i.putExtra(Intent.EXTRA_EMAIL, mail);
        i.setType("message/rfc822");
        startActivity(Intent.createChooser(i, "Choose an email"));
    }
}
