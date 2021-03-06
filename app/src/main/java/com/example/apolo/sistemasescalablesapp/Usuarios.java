package com.example.apolo.sistemasescalablesapp;

import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;

import com.example.apolo.sistemasescalablesapp.databinding.UsuariosBinding;

import ViewModels.UserViewModels;

public class Usuarios extends AppCompatActivity{
    private UserViewModels user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.usuarios);
        UsuariosBinding _binding = DataBindingUtil.setContentView(this,R.layout.usuarios);
        setSupportActionBar(_binding.toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            window.setStatusBarColor(this.getResources().getColor(R.color.colorPrimaryDark,null));
        }
        user = new UserViewModels(this,_binding);
        _binding.setUserModel(user);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        user.onCreateOptionsMenu(menu);

        return true;
    }

}
