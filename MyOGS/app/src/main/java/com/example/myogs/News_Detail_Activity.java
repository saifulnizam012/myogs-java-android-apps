package com.example.myogs;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class News_Detail_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("News");

        TextView tvNewsContent, tvNewsDate;
        ImageView ivNewsImage;

        tvNewsContent = findViewById(R.id.tv_newsContent);
        tvNewsDate = findViewById(R.id.tv_newsDateDetail);
        ivNewsImage = findViewById(R.id.tv_newsImage);

        Intent intent = getIntent();
        TextView tvName = findViewById(R.id.tv_newsTopic);

        tvName.setText(intent.getStringExtra("newsName"));
        tvNewsContent.setText(intent.getStringExtra("newsContent"));
        tvNewsDate.setText(intent.getStringExtra("newsDate"));

        ivNewsImage.setImageResource(intent.getIntExtra("newsImage",0));

        //  international news
        if (intent.getStringExtra("newsName").equals("Best laptops at CES 2023: 3D OLED tech, new gaming laptops, and everything else")){

            tvNewsContent.setText("\n\t\t\tAsus isn't sitting around to let Acer hog the limelight. There's a new 18-inch gaming laptop here too, as part of the new range of Asus ROG Strix SCAR laptops, some of which will use Intel's mighty new Core i9-13980HX mobile processor, now the world's most powerful laptop CPU.\n\n" +
                    "\t\t\tIt's not just new Strix products either; the ever-successful ROG Zephyrus line is getting new entries, starting with slick new redesigns for the Zephyrus M16 and G16 - both already excellent gaming laptops, now updated with more powerful hardware and a new look. We're also getting new models of Asus's dinky gaming tablet, the ROG Flow X13 and Z13.\n\n" +
                    "\t\t\tIn total, there were thirteen new ROG laptops from Asus announced, with a lot of focus being placed on the manufacturer's Nebula display technology. Nebula is essentially a minimum hardware spec for Asus laptop screens, mandating 'a strict criteria of fast motion, bright backlights, and vivid colors.' Having seen these panels in the past, it's good to see Asus is sticking to its guns and aiming to deliver top-notch laptop displays.\n\n");

        }

        //  international news 2
        else if (intent.getStringExtra("newsName").equals("Lenovo's Yoga Book 9i makes a case for dual-screen laptops, and it doesn't suck")){

            tvNewsContent.setText("\n\t\t\tLenovo is taking dual-screen concept to the next level with the Yoga Book 9i, one of the first laptops with two full-size OLED touchscreens.\n\n" +
                    "\t\t\tTech companies in the past have tried creating dual screen laptops. Sadly, they either don’t go anywhere, like the Microsoft Surface Neo, or are diminished in scale. This new Lenovo laptop, however, is doing things a little differently.\n\n" +
                    "\t\t\tAt least, Lenovo calls it a laptop. It’s more of a tablet with the hinge serving as a divider. The screens themselves don’t bend so you don’t have to worry about an annoying crease going down the middle. Looking at the announcement images(opens in new tab), the Yoga Book 9i is pretty versatile as both displays can be used for one image or for working on two separate apps at the same time. You could conceivably give a presentation on one while “viewing the chat [and] advancing slides from the second screen.”\n\n" +
                    "\t\t\tAlthough there isn’t a keyboard directly attached, the Yoga Book 9i will come with a “detachable Bluetooth keyboard”. Lenovo also says that it supports the Smart Pen, but it’s unknown if the stylus is a part of the launch package.\n\n");

        }

        //  international news 3
        else if (intent.getStringExtra("newsName").equals("Razer's Blade 16 and 18 gaming laptops pack serious power – and hefty price tags")){

            tvNewsContent.setText("\n\t\t\tRazer is swinging back into gaming laptops game with the Blade 16 and Blade 18, both of which have some serious muscle behind them.\n\n" +
                    "\t\t\tThe two machines will “come equipped with the latest 13th generation Intel Core i9 HX chipset” and a GeForce RTX 40 series GPU from Nvidia that can run up to 175W TGP (Total Graphics Power). 175W refers to the amount of power being sent directly into the GPU to ensure high performance, though not power-efficiency as it will drain the battery pretty quickly.\n\n" +
                    "\t\t\tJudging from the description, there will be multiple models of the Blade laptops corresponding to a specific graphics card. The full list is unknown. However, we know that one will house the powerful RTX 4090. As impressive as the hardware is, what really gets us are the differences between the two(opens in new tab). Arguably the Blade 16 is the less powerful of the two, but it still packs impressive features.\n\n");

        }

        //  international news 4
        else if (intent.getStringExtra("newsName").equals("Intel Raptor Lake laptop CPU benchmark points to a multi-core monster")){

            tvNewsContent.setText("\n\t\t\tOne of Intel’s incoming laptop processors for Raptor Lake has been spotted in a benchmark, and it beefs up the core count compared to its Alder Lake predecessor.\n\n" +
                    "\t\t\tFirst off, arm yourself with a skeptical attitude as always around these kind of leaks, but the mobile CPU in question is the Core i7-1370P which is the successor to the Core i7-1270P. (It’s part of Intel’s low-power range, which the ‘P’ denotes).\n\n" +
                    "\t\t\tGoing by the benchmark which appeared on Geekbench, as surfaced by BenchLeaks on Twitter (via Tom’s Hardware(opens in new tab)), the Core i7-1370P will have six performance cores and eight efficiency cores, making for a total of 14-cores (and 20-threads, as only the performance cores use hyper-threading).\n\n");

        }

        //  international news 5
        else if (intent.getStringExtra("newsName").equals("Chromebooks with AMD CPUs can now play Steam games – RIP gaming laptops?")){

            tvNewsContent.setText("\n\t\t\tAMD has hooked up with Google to offer the ability to play Steam games on Chromebooks with Ryzen CPUs.\n\n" +
                    "\t\t\tYou may be aware that it’s been several years since Google first started talking about supporting Steam games on Chromebooks, and the functionality entered alpha testing earlier this year, but required an Intel CPU.\n\n" +
                    "\t\t\tNow, the project has moved into beta testing, and incorporates AMD processors – but only certain Ryzen 5000 chips. Namely the AMD Ryzen 7 5825C or Ryzen 5 5625C processors, and the Chromebook in question also needs a minimum of 8GB of system RAM too.\n\n" +
                    "\t\t\tAMD notes that some 50 games are part of the initial line-up of Steam titles that can be enjoyed on a qualifying Chromebook.\n\n" +
                    "\t\t\tWhat kind of games are we talking about? Compatible efforts include Age of Empires II: Definitive Edition, Civilization V, Half-Life 2, Left 4 Dead 2, Portal 2 and The Witcher 3: Wild Hunt, among others.\n\n");

        }

        //  local news

        if (intent.getStringExtra("newsName").equals("Deal: Honor MagicBook 14 and 15 are now going for less than RM1,800")){

            tvNewsContent.setText("\n\t\t\tHonor MagicBook laptops are one of the most value-for-money options that are priced under RM3,000 in Malaysia. If you missed the previous MagicBook 15 deal, Honor Malaysia is running a new promo where you can get the MagicBook 14 or MagicBook 15 laptops for less than RM1,800.\n\n" +
                    "\t\t\tFor a limited time, the AMD-powered Honor MagicBook 14 and 15 are now going for RM1,779 and RM1,789 respectively. Both laptops are available on Lazada, Shopee and the official Honor online store. Just make sure to apply the store voucher to get the sub-RM1,800 final price.\n\n" +
                    "\t\t\tThe major difference between the two MagicBooks is the screen size with the 14 model getting a 14″ IPS screen while the 15 model gets a larger 15.6″ IPS panel. According to the respective spec sheets, both displays offer a Full HD (1920×1080) resolution in a 16:9 aspect ratio, 100% sRGB colour gamut and 300 nits of max brightness.\n\n" +
                    "\t\t\tThese MagicBooks are running on AMD’s 6-core Ryzen 5 5500U processor with AMD Radeon Graphics, paired with 8GB of DDR 3200MHz RAM and 256GB of SSD. In terms of connectivity, they both support 802.11ax WiFi 6, Bluetooth 5.1 and multi-screen collaboration with a compatible Honor device using Honor Magic-Link.\n\n" +
                    "\t\t\tThe MagicBook 14 and 15 feature an HDMI port, a USB-C port, two USB-A ports (USB 3.0 Gen 1, USB 2.0 and a 3.5mm headphone jack. Also included is a power button with an integrated fingerprint sensor and a pop-up HD 720p webcam that sits in between the top row keys of the keyboard.\n\n" +
                    "\t\t\tInterestingly, both models are listed with the same 56Wh battery and it supports 65W PD charging via USB-C. Out of the box, both laptops run on Microsoft Windows 11 Home. The MagicBook 15 is 16.9mm thick and weighs 1.54kg. Meanwhile, the MagicBook 14 is slightly thinner at 15.9mm and it weighs 1.38kg.\n\n");

        }

        //  local news 2
        else if (intent.getStringExtra("newsName").equals("Vivobook 16X: Asus Malaysia’s affordable 16″ Ryzen 5 laptop, priced under RM3,000")) {

            tvNewsContent.setText("\n\t\t\tIf you’re looking for a new laptop that offers a large screen at an affordable price, Asus Malaysia has announced its new Vivobook 16X laptop powered by AMD Ryzen 5000 series processors. As the name implies, this is a 16″ laptop and it’s priced just a hair under RM3,000.\n\n" +
                    "\t\t\tThe Asus Vivobook 16X (M1603) is only offered in one spec variant with 8GB RAM and 512GB of storage, and it’s officially priced at RM2,999 in Malaysia. The laptop is offered in either Quiet Blue or Transparent Silver, and is available starting today, 12th October through official Asus official stores and retailers in Malaysia.\n\n" +
                    "\t\t\tAt the moment, it’s not available on the official Asus laptop store on both Lazada and Shopee, but we reckon it will be available online at a later time.\n\n");
        }

        //  local news 3
        else if (intent.getStringExtra("newsName").equals("MSI GE76 Raider Malaysia review: Alder Lake is good, actually")) {

            tvNewsContent.setText("\n\t\t\tWhen you think gaming laptops, there’s generally two types of them out there. The first are your portable gaming machines, which are thin and small enough with decent battery life to them, allowing it to be used both for work and play. They do have their downsides of course, such as not really having the best of the best hardware in them due to the size constraints.\n\n" +
                    "\t\t\tThen there are your big boys, the iconic and gigantic gaming laptop. These are the ones you typically think off when talking about gaming laptops. They’re massive and heavy so that they have all the cooling potential needed to run the most powerful hardware that manufacturers can legally put onto a laptop. In fact, they’re barely laptops anymore. With battery life normally thrown out the window for even more performance, they’re just portable desktop replacements, and last about as long too unplugged.\n\n" +
                    "\t\t\tNow it’s been a while since we got a chance to review one of the latter devices, so when offered the chance to take a look at the MSI GE76 Raider packing the latest 12th Gen Intel Core ‘Alder Lake’ processor with an NVIDIA GeForce RTX 3070 Ti, we kinda knew that we just had to take up the offer.\n\n");
        }

        //  local news 4
        else if (intent.getStringExtra("newsName").equals("HP Envy 16 Malaysia: 12th-gen Core processors, RTX 3060 graphics and 120Hz display, priced from RM6,999")) {

            tvNewsContent.setText("\n\t\t\tAside from the Spectre x360 13.5, HP also introduced the Envy 16 in Malaysia. Another creator-focused computer, it takes on a more conventional laptop form factor in exchange for a larger display, optional discrete graphics and a slightly cheaper starting price. Like its more distinctive sibling, the Envy also earns the Intel Evo certification and is powered by the firm’s latest 12th-generation chipsets.\n\n" +
                    "\t\t\tThe name is pretty self-explanatory – the Envy 16 features a larger display compared to past Envy models (though not quite as big as the Envy 17.3, which isn’t offered here). It’s a 16-inch WQXGA (2560×1600) IPS panel with an impressive 120Hz refresh rate, and it’s claimed to cover 100% of the sRGB colour gamut.\n\n" +
                    "\t\t\tPeer under the silver aluminium skin and you’ll find Intel’s latest 12th-generation Alder Lake processors. The base configuration features a Core i5-12500H chip with 12 cores, running at 4.5GHz with Turbo Boost. The Envy 16 is also one of the first laptops to ship with Intel Arc mobile graphics – an A370M GPU with 4GB of dedicated GDDR6 memory.\n\n" +
                    "\t\t\tAn extra RM550 bumps up the processor to a 4.7GHz, 14-core Core i7-12700H, but you’ll need to stump up an additional RM910 to get the Nvidia GeForce RTX 3060 graphics card with 6GB of GDDR6 memory. All models get 16GB of DDR5 RAM and 1TB of SSD storage, as well as an 83Wh battery claimed to provide up to nine hours and 45 minutes of use.\n\n");
        }

        //  local news 5
        else if (intent.getStringExtra("newsName").equals("HP Spectre x360 13.5 Malaysia: 2-in-1 laptop with 12th-gen Intel Core i7, priced from RM7,199")) {

            tvNewsContent.setText("\n\t\t\tToday, HP launched the new Spectre x360 in Malaysia, updating its 2-in-1 laptop offering. As its name suggests, the device features a touchscreen that rotates 360 degrees to form a tablet. Built on the Intel Evo platform, it features the latest 12th-generation Core i7 processor.\n\n" +
                    "\t\t\tThe Spectre x360 13.5 represents an incremental upgrade over last year’s Spectre x360 14, with a mildly-revised aluminium design that features more rounded edges and no more contrasting sides. Our market only gets the Nocturne Blue colourway with Celestial Blue accents.\n\n" +
                    "\t\t\tThe highlight is still the display that flips around the keyboard, featuring the same 3:2 aspect ratio as before. The base model comes with a WUXGA+ (1920×1280) IPS display, incorporating the HP Sure View integrated privacy screen feature. The latter limits the viewing angles with a press of a button, preventing nosy onlookers from catching a glimpse of your display. You can upgrade to a 3000×2000 OLED HDR panel with a brightness of up to 500 nits, but without Sure View. Both screens are covered with Gorilla Glass NBT.\n\n" +
                    "\t\t\tA stylus pen is still included with every purchase, but it can now be magnetically attached to the side of the display. Since Zoom meetings are an unavoidable part of life nowadays, HP has upgraded the webcam to a 5MP unit with temporal noise reduction; a physical camera shutter, dual-array microphones and four Bang & Olufsen speakers continue to be fitted.\n\n" +
                    "\t\t\tInside lies a new Intel Core i7-1255U processor with ten cores, running at up to 4.7GHz with Turbo Boost. You still get integrated Iris Xe graphics and 16GB of LPDDR4x RAM, along with a 1TB SSD. The 66Wh battery is claimed to provide up to 14 hours of use with the IPS screen and up to 11 hours and 45 minutes with the OLED version.\n\n" +
                    "\t\t\tThe Spectre x360 13.5 maintains the use of two Thunderbolt 4 USB-C ports (one on the bevelled right rear corner of the laptop; a 3.5mm headphone jack sits on the other side), a single USB-A port and a microSD card reader. It also comes with a fingerprint reader and Windows Hello facial recognition.\n\n" +
                    "\t\t\tWindows 11 Home comes pre-installed, with HP adding its own software to the mix, such as HP Palette that enables facial identification in photos and wireless file sharing; it also includes the Concepts sketching app and Duet screen sharing. Meanwhile, HP Presence and GlamCam are geared towards video conferencing, adding a beauty filter, a ring light overlay on the screen and a webcam facial tracking feature similar to Apple’s Centre Stage.\n\n");
        }


    }
}
