package com.example.myogs;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Laptop_Detail_Activity extends AppCompatActivity {

    TextView tvProcessor, tvGPU, tvCameraRear, tvCameraFront,  tvStorage, tvPrice, tvLaptopName;
    Button btnCheck, btnBuy;

    SharedPreferences sp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle("Laptop Detail");
        setContentView(R.layout.activity_laptop_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvProcessor = findViewById(R.id.tv_processor);
        tvGPU = findViewById(R.id.tv_gpu);
        tvCameraRear = findViewById(R.id.tv_memory);
        //tvCameraFront = findViewById(R.id.tv_cameraFront);
        tvStorage = findViewById(R.id.tv_ram);
        tvPrice = findViewById(R.id.tv_price);
        btnCheck = findViewById(R.id.btn_save);
        btnBuy = findViewById(R.id.btn_returnToCart);

        Intent intent  = getIntent();
        tvLaptopName = findViewById(R.id.tv_laptopDetailName);
        tvLaptopName.setText(intent.getStringExtra("laptopName"));

        ImageView ivLaptopImage = findViewById(R.id.iv_laptopImage);
        ivLaptopImage.setImageResource(intent.getIntExtra("laptopPrice", 0));

        sp2 = getSharedPreferences("sp2Pref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor2 = sp2.edit();

        String Aname = tvLaptopName.getText().toString();
        String Aprice = tvPrice.getText().toString();

        editor2.putString("pName",Aname);
        editor2.putString("pPrice", Aprice);
        editor2.commit();

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(Laptop_Detail_Activity.this);
                builder.setTitle("Check Stocks");
                builder.setMessage("This laptop still available. You want to purchase?");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        startActivity(new Intent(Laptop_Detail_Activity.this, BuyDetail_Activity.class));
                    }
                }).setNegativeButton("Later", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                builder.show();

            }
        });


        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Laptop_Detail_Activity.this, BuyDetail_Activity.class));
            }
        });

        //acer
        if (intent.getStringExtra("laptopName").equals("Acer Chromebook 311")){

            tvProcessor.setText("Intel® Celeron® N4120");
            tvGPU.setText("Nvidia GTX 1050");
            tvCameraRear.setText("32GB eMMC");
            //tvCameraFront.setText("");
            tvStorage.setText("4GB LPDDR4");
            tvPrice.setText("RM1349");

        }

        else if (intent.getStringExtra("laptopName").equals("Acer Swift X")){

            tvProcessor.setText("AMD Ryzen 5 5625U");
            tvGPU.setText("Nvidia GTX 1080");
            tvCameraRear.setText("512GB SSD");
            //tvCameraFront.setText("SSD");
            tvStorage.setText("8GB DDR4-3200");
            tvPrice.setText("RM4299");

        }

        else if (intent.getStringExtra("laptopName").equals("Acer Swift 3")){

            tvProcessor.setText("AMD Ryzen™ 5 5500U");
            tvGPU.setText("Nvidia RTX 2080 Ti");
            tvCameraRear.setText("512GB PCIe NVMe SSD");
            //tvCameraFront.setText("Front: Single 40MP Camera");
            tvStorage.setText("8GB LPDDR4");
            tvPrice.setText("RM3399");

        }

        else if (intent.getStringExtra("laptopName").equals("Acer Everyday Aspire 3")){

            tvProcessor.setText("Intel® Core™ i3-1215U");
            tvGPU.setText("Nvidia RTX 2060");
            tvCameraRear.setText("256GB SSD");
            //tvCameraFront.setText("Front: Single 4MP Camera");
            tvStorage.setText("8GB SoDIMM DDR4");
            tvPrice.setText("RM2399");

        }

        else if (intent.getStringExtra("laptopName").equals("Acer Predator Helios 300")){

            tvProcessor.setText("Intel® Core i9-11900H");
            tvGPU.setText("Nvidia RTX 3080");
            tvCameraRear.setText("1 TB PCIe® NVMe™ SSD");
            //tvCameraFront.setText("Front: Single 10MP Camera");
            tvStorage.setText("32GB DDR4");
            tvPrice.setText("RM7999");

        }


        // asus
        else if (intent.getStringExtra("laptopName").equals("Asus ROG Strix G17")){

            tvProcessor.setText("Intel® Core™ i9-12900H");
            tvGPU.setText("Nvidia GTX 1080");
            tvCameraRear.setText("1TB M.2 NVMe™ PCIe® 4.0 SSD");
            //tvCameraFront.setText("Front: Single 12MP Photos");
            tvStorage.setText("DDR5 4800 32GB");
            tvPrice.setText("RM10999");

        }

        else if (intent.getStringExtra("laptopName").equals("Asus ROG Strix G15")){

            tvProcessor.setText("AMD Ryzen™ 7 6800H");
            tvGPU.setText("Nvidia GTX 1050");
            tvCameraRear.setText("512GB M.2 NVMe™ PCIe® 4.0 SSD");
            //tvCameraFront.setText("Front: Single 12MP Photos");
            tvStorage.setText("DDR5 4800 16GB");
            tvPrice.setText("RM5399");

        }

        else if (intent.getStringExtra("laptopName").equals("Asus TUF Gaming A17")){

            tvProcessor.setText("AMD Ryzen™ 7 6800H");
            tvGPU.setText("Nvidia RTX 2080 Ti");
            tvCameraRear.setText("512GB M.2 NVMe PCIe® 3.0 SSD");
            //tvCameraFront.setText("Front: Single 12MP Photos");
            tvStorage.setText("DDR5 4800 16GB");
            tvPrice.setText("RM6299");

        }

        else if (intent.getStringExtra("laptopName").equals("Asus TUF Gaming A15")){

            tvProcessor.setText("AMD Ryzen™ 7 6800H");
            tvGPU.setText("Nvidia RTX 2060");
            tvCameraRear.setText("512GB M.2 NVMe PCIe® 3.0 SSD");
            //tvCameraFront.setText("Front: Single 7MP Photos");
            tvStorage.setText("DDR5 4800 8GB");
            tvPrice.setText("RM4999");

        }

        else if (intent.getStringExtra("laptopName").equals("Asus Vivobook 15")){

            tvProcessor.setText("AMD Ryzen™ 7 5700U Mobile Processor");
            tvGPU.setText("Nvidia RTX 3080");
            tvCameraRear.setText("512GB PCIe® 3.0 NVMe M.2 SSD");
            //tvCameraFront.setText("Front: Single 12MP Photos");
            tvStorage.setText("8GB DDR4");
            tvPrice.setText("RM3499");

        }

        // dell
        else if (intent.getStringExtra("laptopName").equals("Dell XPS 15")){

            tvProcessor.setText("12th Gen Intel® Core™ i7-12700H");
            tvGPU.setText("Nvidia GTX 1080");
            tvCameraRear.setText("512 GB SSD");
            //tvCameraFront.setText("Front: Single 32MP Camera");
            tvStorage.setText("16GB DDR5");
            tvPrice.setText("RM8749");

        }

        else if (intent.getStringExtra("laptopName").equals("Dell XPS 13 2in1")){

            tvProcessor.setText("12th Gen Intel® Core™ i5-1230U");
            tvGPU.setText("Nvidia GTX 1050");
            tvCameraRear.setText("256GB SSD");
            //tvCameraFront.setText("Front: Single 44MP Camera");
            tvStorage.setText("8GB LPDDR4");
            tvPrice.setText("RM6299");

        }

        else if (intent.getStringExtra("laptopName").equals("Dell Inspiron 14")){

            tvProcessor.setText("12th Gen Intel® Core™ i7-1255U");
            tvGPU.setText("Nvidia RTX 2060");
            tvCameraRear.setText("512GB SSD");
            //tvCameraFront.setText("Front: Single 50MP Camera");
            tvStorage.setText("16GB DDR4");
            tvPrice.setText("RM4599");

        }

        else if (intent.getStringExtra("laptopName").equals("Dell Inspiron 14 2in1")){

            tvProcessor.setText("12th Gen Intel® Core™ i5-1235U");
            tvGPU.setText("Nvidia RTX 2080 Ti");
            tvCameraRear.setText("512 GB SSD");
            //tvCameraFront.setText("Front: Single 16MP Camera");
            tvStorage.setText("8GB DDR4");
            tvPrice.setText("RM3599");

        }

        else if (intent.getStringExtra("laptopName").equals("Dell Alienware x15 R2")){

            tvProcessor.setText("12th Gen Intel® Core™ i7-12700H");
            tvGPU.setText("Nvidia RTX 3080");
            tvCameraRear.setText("1 TB SSD");
            //tvCameraFront.setText("Front: Single 8MP Camera");
            tvStorage.setText("32 GB LPDDR5");
            tvPrice.setText("RM14399");

        }

        // lenovo
        else if (intent.getStringExtra("laptopName").equals("Lenovo Legion 5")){

            tvProcessor.setText("AMD Ryzen™ 5 6600H");
            tvGPU.setText("Nvidia GTX 1050");
            tvCameraRear.setText("512GB ");
            //tvCameraFront.setText("Front: 13MP Selfie Camera");
            tvStorage.setText("16GB SO-DIMM DDR5");
            tvPrice.setText("RM4004");

        }

        else if (intent.getStringExtra("laptopName").equals("Lenovo Legion 7")){

            tvProcessor.setText("Lenovo Legion 7");
            tvGPU.setText("Nvidia GTX 1080");
            tvCameraRear.setText("512GB");
            //tvCameraFront.setText("Front: 13MP Ultra Vision Selfie Camera");
            tvStorage.setText("16 GB SO-DIMM DDR5 4800MHz");
            tvPrice.setText("RM9516");

        }

        else if (intent.getStringExtra("laptopName").equals("Lenovo ThinkPad E15")){

            tvProcessor.setText("AMD Ryzen™ 5 5625U");
            tvGPU.setText("Nvidia RTX 2060");
            tvCameraRear.setText("256 GB SSD");
            //tvCameraFront.setText("Front: 32MP Portrait Camera");
            tvStorage.setText("8GB DDR4");
            tvPrice.setText("RM3993");

        }

        else if (intent.getStringExtra("laptopName").equals("Lenovo ThinkPad X13 Yoga")){

            tvProcessor.setText("12th Generation Intel® Core™ i5-1235U");
            tvGPU.setText("Mali-G57");
            tvCameraRear.setText("256 GB M.2 2280 SSD");
            //tvCameraFront.setText("Front: 32MP Selfie Camera");
            tvStorage.setText("8GB LPDDR4X");
            tvPrice.setText("RM6353");

        }

        else if (intent.getStringExtra("laptopName").equals("Lenovo IdeaPad 1")){

            tvProcessor.setText("AMD Ryzen™ 5 5500U");
            tvGPU.setText("Nvidia RTX 2080 Ti");
            tvCameraRear.setText("512 GB PCIe® NVMe™ SSD");
            //tvCameraFront.setText("Front: 16MP Selfie Camera");
            tvStorage.setText("8GB DDR4");
            tvPrice.setText("RM2054");

        }

        // hp
        else if (intent.getStringExtra("laptopName").equals("Victus by HP")){

            tvProcessor.setText("AMD Ryzen™ 5");
            tvGPU.setText("Nvidia RTX 3080");
            tvCameraRear.setText("256GB SSD");
            //tvCameraFront.setText("Front: 16MP Selfie Camera");
            tvStorage.setText("8GB DDR4");
            tvPrice.setText("RM3799");

        }

        else if (intent.getStringExtra("laptopName").equals("OMEN by HP")){

            tvProcessor.setText("AMD Ryzen 7");
            tvGPU.setText("Nvidia GTX 1080");
            tvCameraRear.setText("1 TB PCIe® NVMe™ SSD");
            //tvCameraFront.setText("Front: 16MP Selfie Camera");
            tvStorage.setText("16GB DDR5-4800");
            tvPrice.setText("RM7599");

        }

        else if (intent.getStringExtra("laptopName").equals("HP Pavilion Aero")){

            tvProcessor.setText("AMD Ryzen™ 5");
            tvGPU.setText("Nvidia GTX 1050");
            tvCameraRear.setText("512GB M.2 NVMe PCIe® 3.0 SSD");
            //tvCameraFront.setText("Front: 16MP Selfie Camera");
            tvStorage.setText("16GB DDR4-3200");
            tvPrice.setText("RM3499");

        }

        else if (intent.getStringExtra("laptopName").equals("HP Laptop 15s")){

            tvProcessor.setText("AMD Ryzen™ 5");
            tvGPU.setText("Nvidia RTX 2080 Ti");
            tvCameraRear.setText("256 GB PCIe® NVMe™ M.2 SSD");
            //tvCameraFront.setText("Front: 16MP Selfie Camera");
            tvStorage.setText("4GB DDR4-2400");
            tvPrice.setText("RM1549");

        }

        else if (intent.getStringExtra("laptopName").equals("HP ENVY 16")){

            tvProcessor.setText("12th Generation Intel® Core™ i5");
            tvGPU.setText("Nvidia RTX 2060");
            tvCameraRear.setText("1 TB PCIe® NVMe™ TLC M.2 SSD");
            //tvCameraFront.setText("Front: 16MP Selfie Camera");
            tvStorage.setText("16 GB DDR5-4800");
            tvPrice.setText("RM6999");

        }


    }
}
