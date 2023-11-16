package com.mobdeve.s13.tiongquico.erik.exercise4processmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * All structure images courtesy of Klei Entertainment's Don't Starve: Hamlet.
 * https://www.klei.com/games/dont-starve-together
 */
public class MainActivity extends AppCompatActivity {

    private Structures selectedStructure;

    private ImageView ivBg;
    private ImageView ivStructure;
    private Button btnBuild;
    private Spinner spinStructures;
    private SpinnerAdapter spinnerAdapter;
    private TextView tvSpinEntry;
    private ConstraintLayout clTiles;
    private LinearLayout llNotif;
    private ImageView ivNotifStructure;
    private TextView tvNotifDescription;
    private ProgressBar pbStructure;
    private ExecutorService executorService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.initComponents();
        this.showAllTiles();

        this.executorService = Executors.newFixedThreadPool(9);
    }

    /**
     * Called when the BUILD button is clicked.
     */
    private void buildStructure() {
        // TODO: Write your code here

        // Disable the BUILD button
        this.disableBuild();

        // Starts building the structure

        // For each tile, create a thread with a random processing time
        // and a callback that will be called when the thread finishes.
        // It hides the tile once it's done processing. However, once
        // all tiles are done processing, it will call the buildFinished()
        // method.
        for(int i = 0; i < this.clTiles.getChildCount(); i++) {
            final int index = i;
            this.executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        // The delay ranges from 500 milliseconds to 5500 milliseconds
                        Thread.sleep((long) (Math.random() * 5000) + 500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            hideTileAt(index);
                            pbStructure.setProgress(pbStructure.getProgress() + 1);

                            if(pbStructure.getProgress() == pbStructure.getMax()) {
                                buildFinished();
                            }
                        }
                    });
                }
            });
        }

    }

    /**
     * You may call this method when all tiles have finished processing.
     */
    private void buildFinished() {
        // TODO: Write your code here
    }

    /**
     * Shows the pop-up notification.
     * You have to set the notification image and description on your own.
     */
    private void showNotification() {
        // TODO: Write your code here

        this.tvNotifDescription.setTextColor(getColor(StructureHelper.getColor(this.selectedStructure)));
        this.llNotif.setVisibility(View.VISIBLE);
    }

    /**
     * Hides the pop-up notification.
     */
    private void hideNotification() {
        this.llNotif.setVisibility(View.INVISIBLE);
    }

    /**
     * Enables the BUILD button.
     */
    private void enableBuild() {
        this.pbStructure.setVisibility(View.GONE);
        this.spinStructures.setEnabled(true);
        this.btnBuild.setEnabled(true);
        this.btnBuild.setBackgroundColor(getColor(R.color.build_active_tint));
        this.btnBuild.setTextColor(getColor(R.color.build_active_text));
        this.btnBuild.setText("BUILD");
    }

    /**
     * Disables the BUILD button.
     */
    private void disableBuild() {
        this.pbStructure.setVisibility(View.VISIBLE);
        this.pbStructure.setProgress(0);
        this.spinStructures.setEnabled(false);
        this.btnBuild.setEnabled(false);
        this.btnBuild.setBackgroundColor(getColor(R.color.build_inactive_tint));
        this.btnBuild.setTextColor(getColor(R.color.build_inactive_text));
        this.btnBuild.setText("IN PROGRESS");
    }

    /**
     * Shows all building block tiles.
     */
    private void showAllTiles() {
        for(int i = 0; i < this.clTiles.getChildCount(); i++) {
            this.clTiles.getChildAt(i).setVisibility(View.VISIBLE);
        }
    }

    /**
     * Hides all building block tiles.
     */
    private void hideAllTiles() {
        for(int i = 0; i < this.clTiles.getChildCount(); i++) {
            this.clTiles.getChildAt(i).setVisibility(View.INVISIBLE);
        }
    }

    /**
     * Shows the building block tile specified
     * by the given index parameter.
     * @param index
     */
    private void showTileAt(int index) {
        this.clTiles.getChildAt(index).setVisibility(View.VISIBLE);
    }

    /**
     * Hides the building block tile specified
     * by the given index parameter.
     * @param index
     */
    private void hideTileAt(int index) {
        this.clTiles.getChildAt(index).setVisibility(View.INVISIBLE);
    }



    /* * * * * * * * * * * * * * * * * * *
     *  EVERYTHING BELOW ARE STUFF YOU   *
     *  DON'T HAVE TO BE CONCERNED WITH! *
     * * * * * * * * * * * * * * * * * * */

    private void initComponents() {
        this.ivBg = findViewById(R.id.iv_bg);
        this.ivStructure = findViewById(R.id.iv_structure);
        this.btnBuild = findViewById(R.id.btn_build);
        this.spinStructures = findViewById(R.id.spin_structures);
        this.clTiles = findViewById(R.id.cl_tiles);
        this.pbStructure = findViewById(R.id.pb_structure);

        this.llNotif = findViewById(R.id.ll_notif);
        this.ivNotifStructure = findViewById(R.id.iv_notif_structure);
        this.tvNotifDescription = findViewById(R.id.tv_notif_description);

        String[] arrayStructures = getResources().getStringArray(R.array.array_structures);
        this.spinnerAdapter = new SpinnerAdapter(this, R.layout.spinner_item, arrayStructures);
        this.spinStructures.setAdapter(this.spinnerAdapter);

        this.spinStructures.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                loadStructure(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) { }
        });

        this.btnBuild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buildStructure();
            }
        });

        this.hideNotification();
    }

    /**
     * Does all necessary UI changes whenever
     * a new option is selected from the Dropdown.
     * @param index
     */
    private void loadStructure(int index) {
        this.hideNotification();
        this.showAllTiles();
        this.selectedStructure = StructureHelper.getEnumAt(index);

        /* Change the BG Tint based on the chosen Structure */
        this.ivBg.setColorFilter(getColor(StructureHelper.getBackgroundTint(this.selectedStructure)), PorterDuff.Mode.SRC_OVER);

        this.pbStructure.getProgressDrawable().setColorFilter(getColor(StructureHelper.getProgressColor(this.selectedStructure)), PorterDuff.Mode.SRC_IN);

        int imgHouse = StructureHelper.getHouse(this.selectedStructure);
        int colorTheme = StructureHelper.getColor(this.selectedStructure);
        int dropdownBackground = StructureHelper.getBackground(this.selectedStructure);

        this.tvSpinEntry = this.spinStructures.getSelectedView().findViewById(R.id.tv_spinner_entry);
        this.tvSpinEntry.setTextColor(getColor(colorTheme));

        /* Change the Drowdown BG based on the chosen Structure */
        this.spinStructures.setPopupBackgroundDrawable(getDrawable(dropdownBackground));

        /* Change the Structure Image based on the chosen Structure */
        this.ivStructure.setImageResource(imgHouse);
    }
}